package org.quartz.impl.jdbcjobstore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.quartz.Calendar;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.JobDetailImpl;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.StringMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.OperableTrigger;
import org.slf4j.Logger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/StdJDBCDelegate.class */
public class StdJDBCDelegate implements DriverDelegate, StdJDBCConstants {
    protected String instanceId;
    protected String schedName;
    protected boolean useProperties;
    protected ClassLoadHelper classLoadHelper;
    protected Logger logger = null;
    protected String tablePrefix = Constants.DEFAULT_TABLE_PREFIX;
    protected List<TriggerPersistenceDelegate> triggerPersistenceDelegates = new LinkedList();
    private String schedNameLiteral = null;

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public void initialize(Logger logger, String tablePrefix, String schedName, String instanceId, ClassLoadHelper classLoadHelper, boolean useProperties, String initString) throws NoSuchDelegateException {
        this.logger = logger;
        this.tablePrefix = tablePrefix;
        this.schedName = schedName;
        this.instanceId = instanceId;
        this.useProperties = useProperties;
        this.classLoadHelper = classLoadHelper;
        addDefaultTriggerPersistenceDelegates();
        if (initString != null) {
            for (String setting : initString.split("\\|")) {
                String[] parts = setting.split("=");
                String name = parts[0];
                if (!(parts.length == 1 || parts[1] == null || parts[1].equals(""))) {
                    if (name.equals("triggerPersistenceDelegateClasses")) {
                        String[] trigDelegates = parts[1].split(",");
                        for (String trigDelClassName : trigDelegates) {
                            try {
                                addTriggerPersistenceDelegate((TriggerPersistenceDelegate) classLoadHelper.loadClass(trigDelClassName).newInstance());
                            } catch (Exception e) {
                                throw new NoSuchDelegateException("Error instantiating TriggerPersistenceDelegate of type: " + trigDelClassName, e);
                            }
                        }
                        continue;
                    } else {
                        throw new NoSuchDelegateException("Unknown setting: '" + name + "'");
                    }
                }
            }
        }
    }

    protected void addDefaultTriggerPersistenceDelegates() {
        addTriggerPersistenceDelegate(new SimpleTriggerPersistenceDelegate());
        addTriggerPersistenceDelegate(new CronTriggerPersistenceDelegate());
        addTriggerPersistenceDelegate(new CalendarIntervalTriggerPersistenceDelegate());
        addTriggerPersistenceDelegate(new DailyTimeIntervalTriggerPersistenceDelegate());
    }

    protected boolean canUseProperties() {
        return this.useProperties;
    }

    public void addTriggerPersistenceDelegate(TriggerPersistenceDelegate delegate) {
        this.logger.debug("Adding TriggerPersistenceDelegate of type: " + delegate.getClass().getCanonicalName());
        delegate.initialize(this.tablePrefix, this.schedName);
        this.triggerPersistenceDelegates.add(delegate);
    }

    public TriggerPersistenceDelegate findTriggerPersistenceDelegate(OperableTrigger trigger) {
        for (TriggerPersistenceDelegate delegate : this.triggerPersistenceDelegates) {
            if (delegate.canHandleTriggerType(trigger)) {
                return delegate;
            }
        }
        return null;
    }

    public TriggerPersistenceDelegate findTriggerPersistenceDelegate(String discriminator) {
        for (TriggerPersistenceDelegate delegate : this.triggerPersistenceDelegates) {
            if (delegate.getHandledTriggerTypeDiscriminator().equals(discriminator)) {
                return delegate;
            }
        }
        return null;
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerStatesFromOtherStates(Connection conn, String newState, String oldState1, String oldState2) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_TRIGGER_STATES_FROM_OTHER_STATES));
            ps.setString(1, newState);
            ps.setString(2, oldState1);
            ps.setString(3, oldState2);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectMisfiredTriggers(Connection conn, long ts) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_MISFIRED_TRIGGERS));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            rs = ps.executeQuery();
            LinkedList<TriggerKey> list = new LinkedList<>();
            while (rs.next()) {
                list.add(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectTriggersInState(Connection conn, String state) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGERS_IN_STATE));
            ps.setString(1, state);
            rs = ps.executeQuery();
            LinkedList<TriggerKey> list = new LinkedList<>();
            while (rs.next()) {
                list.add(TriggerKey.triggerKey(rs.getString(1), rs.getString(2)));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectMisfiredTriggersInState(Connection conn, String state, long ts) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp("SELECT TRIGGER_NAME, TRIGGER_GROUP FROM {0}TRIGGERS WHERE SCHED_NAME = {1} AND NOT (MISFIRE_INSTR = -1) AND NEXT_FIRE_TIME < ? AND TRIGGER_STATE = ? ORDER BY NEXT_FIRE_TIME ASC, PRIORITY DESC"));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, state);
            rs = ps.executeQuery();
            LinkedList<TriggerKey> list = new LinkedList<>();
            while (rs.next()) {
                list.add(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean hasMisfiredTriggersInState(Connection conn, String state1, long ts, int count, List<TriggerKey> resultList) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp("SELECT TRIGGER_NAME, TRIGGER_GROUP FROM {0}TRIGGERS WHERE SCHED_NAME = {1} AND NOT (MISFIRE_INSTR = -1) AND NEXT_FIRE_TIME < ? AND TRIGGER_STATE = ? ORDER BY NEXT_FIRE_TIME ASC, PRIORITY DESC"));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, state1);
            rs = ps.executeQuery();
            boolean hasReachedLimit = false;
            while (rs.next() && !hasReachedLimit) {
                if (resultList.size() == count) {
                    hasReachedLimit = true;
                } else {
                    resultList.add(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
                }
            }
            return hasReachedLimit;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int countMisfiredTriggersInState(Connection conn, String state1, long ts) throws SQLException {
        try {
            PreparedStatement ps = conn.prepareStatement(rtp(StdJDBCConstants.COUNT_MISFIRED_TRIGGERS_IN_STATE));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, state1);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int i = rs.getInt(1);
                closeResultSet(rs);
                closeStatement(ps);
                return i;
            }
            throw new SQLException("No misfired trigger count returned.");
        } catch (Throwable th) {
            closeResultSet(null);
            closeStatement(null);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectMisfiredTriggersInGroupInState(Connection conn, String groupName, String state, long ts) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_MISFIRED_TRIGGERS_IN_GROUP_IN_STATE));
            ps.setBigDecimal(1, new BigDecimal(String.valueOf(ts)));
            ps.setString(2, groupName);
            ps.setString(3, state);
            rs = ps.executeQuery();
            LinkedList<TriggerKey> list = new LinkedList<>();
            while (rs.next()) {
                list.add(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), groupName));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [long, java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<org.quartz.spi.OperableTrigger> selectTriggersForRecoveringJobs(java.sql.Connection r11) throws java.sql.SQLException, java.io.IOException, java.lang.ClassNotFoundException {
        /*
        // Method dump skipped, instructions count: 321
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.StdJDBCDelegate.selectTriggersForRecoveringJobs(java.sql.Connection):java.util.List");
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteFiredTriggers(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_FIRED_TRIGGERS));
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteFiredTriggers(Connection conn, String theInstanceId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_INSTANCES_FIRED_TRIGGERS));
            ps.setString(1, theInstanceId);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public void clearData(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            PreparedStatement ps2 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_SIMPLE_TRIGGERS));
            ps2.executeUpdate();
            ps2.close();
            PreparedStatement ps3 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_SIMPROP_TRIGGERS));
            ps3.executeUpdate();
            ps3.close();
            PreparedStatement ps4 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_CRON_TRIGGERS));
            ps4.executeUpdate();
            ps4.close();
            PreparedStatement ps5 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_BLOB_TRIGGERS));
            ps5.executeUpdate();
            ps5.close();
            PreparedStatement ps6 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_TRIGGERS));
            ps6.executeUpdate();
            ps6.close();
            PreparedStatement ps7 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_JOB_DETAILS));
            ps7.executeUpdate();
            ps7.close();
            PreparedStatement ps8 = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_ALL_CALENDARS));
            ps8.executeUpdate();
            ps8.close();
            ps = conn.prepareStatement(rtp("DELETE FROM {0}PAUSED_TRIGGER_GRPS WHERE SCHED_NAME = {1}"));
            ps.executeUpdate();
            closeStatement(ps);
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertJobDetail(Connection conn, JobDetail job) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeJobData(job.getJobDataMap());
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_JOB_DETAIL));
            ps.setString(1, job.getKey().getName());
            ps.setString(2, job.getKey().getGroup());
            ps.setString(3, job.getDescription());
            ps.setString(4, job.getJobClass().getName());
            setBoolean(ps, 5, job.isDurable());
            setBoolean(ps, 6, job.isConcurrentExectionDisallowed());
            setBoolean(ps, 7, job.isPersistJobDataAfterExecution());
            setBoolean(ps, 8, job.requestsRecovery());
            setBytes(ps, 9, baos);
            int insertResult = ps.executeUpdate();
            closeStatement(ps);
            return insertResult;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateJobDetail(Connection conn, JobDetail job) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeJobData(job.getJobDataMap());
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_JOB_DETAIL));
            ps.setString(1, job.getDescription());
            ps.setString(2, job.getJobClass().getName());
            setBoolean(ps, 3, job.isDurable());
            setBoolean(ps, 4, job.isConcurrentExectionDisallowed());
            setBoolean(ps, 5, job.isPersistJobDataAfterExecution());
            setBoolean(ps, 6, job.requestsRecovery());
            setBytes(ps, 7, baos);
            ps.setString(8, job.getKey().getName());
            ps.setString(9, job.getKey().getGroup());
            int insertResult = ps.executeUpdate();
            closeStatement(ps);
            return insertResult;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectTriggerKeysForJob(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGERS_FOR_JOB));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            LinkedList<TriggerKey> list = new LinkedList<>();
            while (rs.next()) {
                list.add(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteJobDetail(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        try {
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("Deleting job: " + jobKey);
            }
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_JOB_DETAIL));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean isJobNonConcurrent(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOB_NONCONCURRENT));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            if (!rs.next()) {
                return false;
            }
            boolean z = getBoolean(rs, Constants.COL_IS_NONCONCURRENT);
            closeResultSet(rs);
            closeStatement(ps);
            return z;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean jobExists(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOB_EXISTENCE));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            closeResultSet(rs);
            closeStatement(ps);
            return false;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateJobData(Connection conn, JobDetail job) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeJobData(job.getJobDataMap());
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp("UPDATE {0}JOB_DETAILS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?"));
            setBytes(ps, 1, baos);
            ps.setString(2, job.getKey().getName());
            ps.setString(3, job.getKey().getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public JobDetail selectJobDetail(Connection conn, JobKey jobKey, ClassLoadHelper loadHelper) throws ClassNotFoundException, IOException, SQLException {
        Map<?, ?> map;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOB_DETAIL));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            JobDetailImpl job = null;
            if (rs.next()) {
                job = new JobDetailImpl();
                job.setName(rs.getString(Constants.COL_JOB_NAME));
                job.setGroup(rs.getString(Constants.COL_JOB_GROUP));
                job.setDescription(rs.getString(Constants.COL_DESCRIPTION));
                job.setJobClass(loadHelper.loadClass(rs.getString(Constants.COL_JOB_CLASS), Job.class));
                job.setDurability(getBoolean(rs, Constants.COL_IS_DURABLE));
                job.setRequestsRecovery(getBoolean(rs, Constants.COL_REQUESTS_RECOVERY));
                if (canUseProperties()) {
                    map = getMapFromProperties(rs);
                } else {
                    map = (Map) getObjectFromBlob(rs, Constants.COL_JOB_DATAMAP);
                }
                if (null != map) {
                    job.setJobDataMap(new JobDataMap(map));
                }
            }
            return job;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    private Map<?, ?> getMapFromProperties(ResultSet rs) throws ClassNotFoundException, IOException, SQLException {
        InputStream is = (InputStream) getJobDataFromBlob(rs, Constants.COL_JOB_DATAMAP);
        if (is == null) {
            return null;
        }
        Properties properties = new Properties();
        if (is != null) {
            try {
                properties.load(is);
                is.close();
            } catch (Throwable th) {
                is.close();
                throw th;
            }
        }
        return convertFromProperty(properties);
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumJobs(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NUM_JOBS));
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<String> selectJobGroups(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOB_GROUPS));
            rs = ps.executeQuery();
            LinkedList<String> list = new LinkedList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public Set<JobKey> selectJobsInGroup(Connection conn, GroupMatcher<JobKey> matcher) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (isMatcherEquals(matcher)) {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOBS_IN_GROUP));
                ps.setString(1, toSqlEqualsClause(matcher));
            } else {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOBS_IN_GROUP_LIKE));
                ps.setString(1, toSqlLikeClause(matcher));
            }
            rs = ps.executeQuery();
            LinkedList<JobKey> list = new LinkedList<>();
            while (rs.next()) {
                list.add(JobKey.jobKey(rs.getString(1), rs.getString(2)));
            }
            HashSet hashSet = new HashSet(list);
            closeResultSet(rs);
            closeStatement(ps);
            return hashSet;
        } catch (Throwable th) {
            closeResultSet(rs);
            closeStatement(ps);
            throw th;
        }
    }

    protected boolean isMatcherEquals(GroupMatcher<?> matcher) {
        return matcher.getCompareWithOperator().equals(StringMatcher.StringOperatorName.EQUALS);
    }

    protected String toSqlEqualsClause(GroupMatcher<?> matcher) {
        return matcher.getCompareToValue();
    }

    protected String toSqlLikeClause(GroupMatcher<?> matcher) {
        String groupName;
        switch (matcher.getCompareWithOperator()) {
            case EQUALS:
                groupName = matcher.getCompareToValue();
                break;
            case CONTAINS:
                groupName = "%" + matcher.getCompareToValue() + "%";
                break;
            case ENDS_WITH:
                groupName = "%" + matcher.getCompareToValue();
                break;
            case STARTS_WITH:
                groupName = matcher.getCompareToValue() + "%";
                break;
            case ANYTHING:
                groupName = "%";
                break;
            default:
                throw new UnsupportedOperationException("Don't know how to translate " + matcher.getCompareWithOperator() + " into SQL");
        }
        return groupName;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v0 */
    /* JADX WARN: Type inference failed for: r15v1 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int insertTrigger(java.sql.Connection r8, org.quartz.spi.OperableTrigger r9, java.lang.String r10, org.quartz.JobDetail r11) throws java.sql.SQLException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 456
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.StdJDBCDelegate.insertTrigger(java.sql.Connection, org.quartz.spi.OperableTrigger, java.lang.String, org.quartz.JobDetail):int");
    }

    public int insertBlobTrigger(Connection conn, OperableTrigger trigger) throws SQLException, IOException {
        PreparedStatement ps = null;
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(trigger);
            oos.close();
            byte[] buf = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(buf);
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_BLOB_TRIGGER));
            ps.setString(1, trigger.getKey().getName());
            ps.setString(2, trigger.getKey().getGroup());
            ps.setBinaryStream(3, (InputStream) is, buf.length);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r22v0 */
    /* JADX WARN: Type inference failed for: r22v1 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r22v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateTrigger(java.sql.Connection r8, org.quartz.spi.OperableTrigger r9, java.lang.String r10, org.quartz.JobDetail r11) throws java.sql.SQLException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 522
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.StdJDBCDelegate.updateTrigger(java.sql.Connection, org.quartz.spi.OperableTrigger, java.lang.String, org.quartz.JobDetail):int");
    }

    public int updateBlobTrigger(Connection conn, OperableTrigger trigger) throws SQLException, IOException {
        PreparedStatement ps = null;
        ByteArrayOutputStream os = null;
        try {
            os = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(os);
            oos.writeObject(trigger);
            oos.close();
            byte[] buf = os.toByteArray();
            ByteArrayInputStream is = new ByteArrayInputStream(buf);
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_BLOB_TRIGGER));
            ps.setBinaryStream(1, (InputStream) is, buf.length);
            ps.setString(2, trigger.getKey().getName());
            ps.setString(3, trigger.getKey().getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            if (os != null) {
                os.close();
            }
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            if (os != null) {
                os.close();
            }
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean triggerExists(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_EXISTENCE));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            closeResultSet(rs);
            closeStatement(ps);
            return false;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerState(Connection conn, TriggerKey triggerKey, String state) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_TRIGGER_STATE));
            ps.setString(1, state);
            ps.setString(2, triggerKey.getName());
            ps.setString(3, triggerKey.getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerStateFromOtherStates(Connection conn, TriggerKey triggerKey, String newState, String oldState1, String oldState2, String oldState3) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_TRIGGER_STATE_FROM_STATES));
            ps.setString(1, newState);
            ps.setString(2, triggerKey.getName());
            ps.setString(3, triggerKey.getGroup());
            ps.setString(4, oldState1);
            ps.setString(5, oldState2);
            ps.setString(6, oldState3);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerGroupStateFromOtherStates(Connection conn, GroupMatcher<TriggerKey> matcher, String newState, String oldState1, String oldState2, String oldState3) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_TRIGGER_GROUP_STATE_FROM_STATES));
            ps.setString(1, newState);
            ps.setString(2, toSqlLikeClause(matcher));
            ps.setString(3, oldState1);
            ps.setString(4, oldState2);
            ps.setString(5, oldState3);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerStateFromOtherState(Connection conn, TriggerKey triggerKey, String newState, String oldState) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_TRIGGER_STATE_FROM_STATE));
            ps.setString(1, newState);
            ps.setString(2, triggerKey.getName());
            ps.setString(3, triggerKey.getGroup());
            ps.setString(4, oldState);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerGroupStateFromOtherState(Connection conn, GroupMatcher<TriggerKey> matcher, String newState, String oldState) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_TRIGGER_GROUP_STATE_FROM_STATE));
            ps.setString(1, newState);
            ps.setString(2, toSqlLikeClause(matcher));
            ps.setString(3, oldState);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerStatesForJob(Connection conn, JobKey jobKey, String state) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_JOB_TRIGGER_STATES));
            ps.setString(1, state);
            ps.setString(2, jobKey.getName());
            ps.setString(3, jobKey.getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateTriggerStatesForJobFromOtherState(Connection conn, JobKey jobKey, String state, String oldState) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_JOB_TRIGGER_STATES_FROM_OTHER_STATE));
            ps.setString(1, state);
            ps.setString(2, jobKey.getName());
            ps.setString(3, jobKey.getGroup());
            ps.setString(4, oldState);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    public int deleteBlobTrigger(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_BLOB_TRIGGER));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteTrigger(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        deleteTriggerExtension(conn, triggerKey);
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_TRIGGER));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    protected void deleteTriggerExtension(Connection conn, TriggerKey triggerKey) throws SQLException {
        for (TriggerPersistenceDelegate tDel : this.triggerPersistenceDelegates) {
            if (tDel.deleteExtendedTriggerProperties(conn, triggerKey) > 0) {
                return;
            }
        }
        deleteBlobTrigger(conn, triggerKey);
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumTriggersForJob(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NUM_TRIGGERS_FOR_JOB));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            if (!rs.next()) {
                return 0;
            }
            int i = rs.getInt(1);
            closeResultSet(rs);
            closeStatement(ps);
            return i;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public JobDetail selectJobForTrigger(Connection conn, ClassLoadHelper loadHelper, TriggerKey triggerKey) throws ClassNotFoundException, SQLException {
        return selectJobForTrigger(conn, loadHelper, triggerKey, true);
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public JobDetail selectJobForTrigger(Connection conn, ClassLoadHelper loadHelper, TriggerKey triggerKey, boolean loadJobClass) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOB_FOR_TRIGGER));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();
            if (rs.next()) {
                JobDetailImpl job = new JobDetailImpl();
                job.setName(rs.getString(1));
                job.setGroup(rs.getString(2));
                job.setDurability(getBoolean(rs, 3));
                if (loadJobClass) {
                    job.setJobClass(loadHelper.loadClass(rs.getString(4), Job.class));
                }
                job.setRequestsRecovery(getBoolean(rs, 5));
                closeResultSet(rs);
                closeStatement(ps);
                return job;
            }
            if (this.logger.isDebugEnabled()) {
                this.logger.debug("No job for trigger '" + triggerKey + "'.");
            }
            return null;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<OperableTrigger> selectTriggersForJob(Connection conn, JobKey jobKey) throws SQLException, ClassNotFoundException, IOException, JobPersistenceException {
        LinkedList<OperableTrigger> trigList = new LinkedList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGERS_FOR_JOB));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            while (rs.next()) {
                OperableTrigger t = selectTrigger(conn, TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
                if (t != null) {
                    trigList.add(t);
                }
            }
            return trigList;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<OperableTrigger> selectTriggersForCalendar(Connection conn, String calName) throws SQLException, ClassNotFoundException, IOException, JobPersistenceException {
        LinkedList<OperableTrigger> trigList = new LinkedList<>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGERS_FOR_CALENDAR));
            ps.setString(1, calName);
            rs = ps.executeQuery();
            while (rs.next()) {
                trigList.add(selectTrigger(conn, TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP))));
            }
            return trigList;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public OperableTrigger selectTrigger(Connection conn, TriggerKey triggerKey) throws SQLException, ClassNotFoundException, IOException, JobPersistenceException {
        Map<?, ?> map;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            OperableTrigger trigger = null;
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();
            if (rs.next()) {
                String jobName = rs.getString(Constants.COL_JOB_NAME);
                String jobGroup = rs.getString(Constants.COL_JOB_GROUP);
                String description = rs.getString(Constants.COL_DESCRIPTION);
                long nextFireTime = rs.getLong(Constants.COL_NEXT_FIRE_TIME);
                long prevFireTime = rs.getLong(Constants.COL_PREV_FIRE_TIME);
                String triggerType = rs.getString(Constants.COL_TRIGGER_TYPE);
                long startTime = rs.getLong(Constants.COL_START_TIME);
                long endTime = rs.getLong(Constants.COL_END_TIME);
                String calendarName = rs.getString(Constants.COL_CALENDAR_NAME);
                int misFireInstr = rs.getInt(Constants.COL_MISFIRE_INSTRUCTION);
                int priority = rs.getInt(Constants.COL_PRIORITY);
                if (canUseProperties()) {
                    map = getMapFromProperties(rs);
                } else {
                    map = (Map) getObjectFromBlob(rs, Constants.COL_JOB_DATAMAP);
                }
                Date nft = null;
                if (nextFireTime > 0) {
                    nft = new Date(nextFireTime);
                }
                Date pft = null;
                if (prevFireTime > 0) {
                    pft = new Date(prevFireTime);
                }
                Date startTimeD = new Date(startTime);
                Date endTimeD = null;
                if (endTime > 0) {
                    endTimeD = new Date(endTime);
                }
                if (triggerType.equals(Constants.TTYPE_BLOB)) {
                    rs.close();
                    ps.close();
                    ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_BLOB_TRIGGER));
                    ps.setString(1, triggerKey.getName());
                    ps.setString(2, triggerKey.getGroup());
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        trigger = (OperableTrigger) getObjectFromBlob(rs, Constants.COL_BLOB);
                    }
                } else {
                    TriggerPersistenceDelegate tDel = findTriggerPersistenceDelegate(triggerType);
                    if (tDel == null) {
                        throw new JobPersistenceException("No TriggerPersistenceDelegate for trigger discriminator type: " + triggerType);
                    }
                    try {
                        TriggerPersistenceDelegate.TriggerPropertyBundle triggerProps = tDel.loadExtendedTriggerProperties(conn, triggerKey);
                        TriggerBuilder forJob = TriggerBuilder.newTrigger().withDescription(description).withPriority(priority).startAt(startTimeD).endAt(endTimeD).withIdentity(triggerKey).modifiedByCalendar(calendarName).withSchedule(triggerProps.getScheduleBuilder()).forJob(JobKey.jobKey(jobName, jobGroup));
                        if (null != map) {
                            forJob.usingJobData(new JobDataMap(map));
                        }
                        trigger = (OperableTrigger) forJob.build();
                        trigger.setMisfireInstruction(misFireInstr);
                        trigger.setNextFireTime(nft);
                        trigger.setPreviousFireTime(pft);
                        setTriggerStateProperties(trigger, triggerProps);
                    } catch (IllegalStateException isex) {
                        if (isTriggerStillPresent(ps)) {
                            throw isex;
                        }
                        closeResultSet(rs);
                        closeStatement(ps);
                        return null;
                    }
                }
            }
            closeResultSet(rs);
            closeStatement(ps);
            return trigger;
        } catch (Throwable th) {
            closeResultSet(rs);
            closeStatement(ps);
            throw th;
        }
    }

    private boolean isTriggerStillPresent(PreparedStatement ps) throws SQLException {
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            boolean next = rs.next();
            closeResultSet(rs);
            return next;
        } catch (Throwable th) {
            closeResultSet(rs);
            throw th;
        }
    }

    private void setTriggerStateProperties(OperableTrigger trigger, TriggerPersistenceDelegate.TriggerPropertyBundle props) throws JobPersistenceException {
        if (props.getStatePropertyNames() != null) {
            Util.setBeanProps(trigger, props.getStatePropertyNames(), props.getStatePropertyValues());
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public JobDataMap selectTriggerJobDataMap(Connection conn, String triggerName, String groupName) throws SQLException, ClassNotFoundException, IOException {
        Map<?, ?> map;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_DATA));
            ps.setString(1, triggerName);
            ps.setString(2, groupName);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (canUseProperties()) {
                    map = getMapFromProperties(rs);
                } else {
                    map = (Map) getObjectFromBlob(rs, Constants.COL_JOB_DATAMAP);
                }
                rs.close();
                ps.close();
                if (null != map) {
                    JobDataMap jobDataMap = new JobDataMap(map);
                    closeResultSet(rs);
                    closeStatement(ps);
                    return jobDataMap;
                }
            }
            closeResultSet(rs);
            closeStatement(ps);
            return new JobDataMap();
        } catch (Throwable th) {
            closeResultSet(rs);
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public String selectTriggerState(Connection conn, TriggerKey triggerKey) throws SQLException {
        String state;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_STATE));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();
            if (rs.next()) {
                state = rs.getString(Constants.COL_TRIGGER_STATE);
            } else {
                state = Constants.STATE_DELETED;
            }
            String intern = state.intern();
            closeResultSet(rs);
            closeStatement(ps);
            return intern;
        } catch (Throwable th) {
            closeResultSet(rs);
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public TriggerStatus selectTriggerStatus(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            TriggerStatus status = null;
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_STATUS));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            rs = ps.executeQuery();
            if (rs.next()) {
                String state = rs.getString(Constants.COL_TRIGGER_STATE);
                long nextFireTime = rs.getLong(Constants.COL_NEXT_FIRE_TIME);
                String jobName = rs.getString(Constants.COL_JOB_NAME);
                String jobGroup = rs.getString(Constants.COL_JOB_GROUP);
                Date nft = null;
                if (nextFireTime > 0) {
                    nft = new Date(nextFireTime);
                }
                status = new TriggerStatus(state, nft);
                status.setKey(triggerKey);
                status.setJobKey(JobKey.jobKey(jobName, jobGroup));
            }
            return status;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumTriggers(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NUM_TRIGGERS));
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<String> selectTriggerGroups(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_GROUPS));
            rs = ps.executeQuery();
            LinkedList<String> list = new LinkedList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<String> selectTriggerGroups(Connection conn, GroupMatcher<TriggerKey> matcher) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_GROUPS_FILTERED));
            ps.setString(1, toSqlLikeClause(matcher));
            rs = ps.executeQuery();
            LinkedList<String> list = new LinkedList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public Set<TriggerKey> selectTriggersInGroup(Connection conn, GroupMatcher<TriggerKey> matcher) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            if (isMatcherEquals(matcher)) {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGERS_IN_GROUP));
                ps.setString(1, toSqlEqualsClause(matcher));
            } else {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGERS_IN_GROUP_LIKE));
                ps.setString(1, toSqlLikeClause(matcher));
            }
            rs = ps.executeQuery();
            Set<TriggerKey> keys = new HashSet<>();
            while (rs.next()) {
                keys.add(TriggerKey.triggerKey(rs.getString(1), rs.getString(2)));
            }
            return keys;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertPausedTriggerGroup(Connection conn, String groupName) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_PAUSED_TRIGGER_GROUP));
            ps.setString(1, groupName);
            int rows = ps.executeUpdate();
            closeStatement(ps);
            return rows;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deletePausedTriggerGroup(Connection conn, String groupName) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_PAUSED_TRIGGER_GROUP));
            ps.setString(1, groupName);
            int rows = ps.executeUpdate();
            closeStatement(ps);
            return rows;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deletePausedTriggerGroup(Connection conn, GroupMatcher<TriggerKey> matcher) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_PAUSED_TRIGGER_GROUP));
            ps.setString(1, toSqlLikeClause(matcher));
            int rows = ps.executeUpdate();
            closeStatement(ps);
            return rows;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteAllPausedTriggerGroups(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp("DELETE FROM {0}PAUSED_TRIGGER_GRPS WHERE SCHED_NAME = {1}"));
            int rows = ps.executeUpdate();
            closeStatement(ps);
            return rows;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean isTriggerGroupPaused(Connection conn, String groupName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_PAUSED_TRIGGER_GROUP));
            ps.setString(1, groupName);
            rs = ps.executeQuery();
            boolean next = rs.next();
            closeResultSet(rs);
            closeStatement(ps);
            return next;
        } catch (Throwable th) {
            closeResultSet(rs);
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean isExistingTriggerGroup(Connection conn, String groupName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NUM_TRIGGERS_IN_GROUP));
            ps.setString(1, groupName);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return false;
            }
            boolean z = rs.getInt(1) > 0;
            closeResultSet(rs);
            closeStatement(ps);
            return z;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertCalendar(Connection conn, String calendarName, Calendar calendar) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeObject(calendar);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_CALENDAR));
            ps.setString(1, calendarName);
            setBytes(ps, 2, baos);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateCalendar(Connection conn, String calendarName, Calendar calendar) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeObject(calendar);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp("UPDATE {0}CALENDARS SET CALENDAR = ?  WHERE SCHED_NAME = {1} AND CALENDAR_NAME = ?"));
            setBytes(ps, 1, baos);
            ps.setString(2, calendarName);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean calendarExists(Connection conn, String calendarName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_CALENDAR_EXISTENCE));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            closeResultSet(rs);
            closeStatement(ps);
            return false;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public Calendar selectCalendar(Connection conn, String calendarName) throws ClassNotFoundException, IOException, SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_CALENDAR));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();
            Calendar cal = null;
            if (rs.next()) {
                cal = (Calendar) getObjectFromBlob(rs, Constants.COL_CALENDAR);
            }
            if (null == cal) {
                this.logger.warn("Couldn't find calendar with name '" + calendarName + "'.");
            }
            return cal;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public boolean calendarIsReferenced(Connection conn, String calendarName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_REFERENCED_CALENDAR));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            closeResultSet(rs);
            closeStatement(ps);
            return false;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteCalendar(Connection conn, String calendarName) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_CALENDAR));
            ps.setString(1, calendarName);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumCalendars(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NUM_CALENDARS));
            rs = ps.executeQuery();
            if (rs.next()) {
                count = rs.getInt(1);
            }
            return count;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<String> selectCalendars(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_CALENDARS));
            rs = ps.executeQuery();
            LinkedList<String> list = new LinkedList<>();
            while (rs.next()) {
                list.add(rs.getString(1));
            }
            return list;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public long selectNextFireTime(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NEXT_FIRE_TIME));
            ps.setString(1, Constants.STATE_WAITING);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return 0;
            }
            long j = rs.getLong(Constants.ALIAS_COL_NEXT_FIRE_TIME);
            closeResultSet(rs);
            closeStatement(ps);
            return j;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public TriggerKey selectTriggerForFireTime(Connection conn, long fireTime) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_TRIGGER_FOR_FIRE_TIME));
            ps.setString(1, Constants.STATE_WAITING);
            ps.setBigDecimal(2, new BigDecimal(String.valueOf(fireTime)));
            rs = ps.executeQuery();
            if (!rs.next()) {
                return null;
            }
            TriggerKey triggerKey = new TriggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP));
            closeResultSet(rs);
            closeStatement(ps);
            return triggerKey;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectTriggerToAcquire(Connection conn, long noLaterThan, long noEarlierThan) throws SQLException {
        return selectTriggerToAcquire(conn, noLaterThan, noEarlierThan, 1);
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<TriggerKey> selectTriggerToAcquire(Connection conn, long noLaterThan, long noEarlierThan, int maxCount) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<TriggerKey> nextTriggers = new LinkedList<>();
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_NEXT_TRIGGER_TO_ACQUIRE));
            if (maxCount < 1) {
                maxCount = 1;
            }
            ps.setMaxRows(maxCount);
            ps.setFetchSize(maxCount);
            ps.setString(1, Constants.STATE_WAITING);
            ps.setBigDecimal(2, new BigDecimal(String.valueOf(noLaterThan)));
            ps.setBigDecimal(3, new BigDecimal(String.valueOf(noEarlierThan)));
            rs = ps.executeQuery();
            while (rs.next() && nextTriggers.size() < maxCount) {
                nextTriggers.add(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
            }
            return nextTriggers;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertFiredTrigger(Connection conn, OperableTrigger trigger, String state, JobDetail job) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_FIRED_TRIGGER));
            ps.setString(1, trigger.getFireInstanceId());
            ps.setString(2, trigger.getKey().getName());
            ps.setString(3, trigger.getKey().getGroup());
            ps.setString(4, this.instanceId);
            ps.setBigDecimal(5, new BigDecimal(String.valueOf(System.currentTimeMillis())));
            ps.setBigDecimal(6, new BigDecimal(String.valueOf(trigger.getNextFireTime().getTime())));
            ps.setString(7, state);
            if (job != null) {
                ps.setString(8, trigger.getJobKey().getName());
                ps.setString(9, trigger.getJobKey().getGroup());
                setBoolean(ps, 10, job.isConcurrentExectionDisallowed());
                setBoolean(ps, 11, job.requestsRecovery());
            } else {
                ps.setString(8, null);
                ps.setString(9, null);
                setBoolean(ps, 10, false);
                setBoolean(ps, 11, false);
            }
            ps.setInt(12, trigger.getPriority());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateFiredTrigger(Connection conn, OperableTrigger trigger, String state, JobDetail job) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_FIRED_TRIGGER));
            ps.setString(1, this.instanceId);
            ps.setBigDecimal(2, new BigDecimal(String.valueOf(System.currentTimeMillis())));
            ps.setBigDecimal(3, new BigDecimal(String.valueOf(trigger.getNextFireTime().getTime())));
            ps.setString(4, state);
            if (job != null) {
                ps.setString(5, trigger.getJobKey().getName());
                ps.setString(6, trigger.getJobKey().getGroup());
                setBoolean(ps, 7, job.isConcurrentExectionDisallowed());
                setBoolean(ps, 8, job.requestsRecovery());
            } else {
                ps.setString(5, null);
                ps.setString(6, null);
                setBoolean(ps, 7, false);
                setBoolean(ps, 8, false);
            }
            ps.setString(9, trigger.getFireInstanceId());
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<FiredTriggerRecord> selectFiredTriggerRecords(Connection conn, String triggerName, String groupName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<FiredTriggerRecord> lst = new LinkedList<>();
            if (triggerName != null) {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_FIRED_TRIGGER));
                ps.setString(1, triggerName);
                ps.setString(2, groupName);
            } else {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_FIRED_TRIGGER_GROUP));
                ps.setString(1, groupName);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                FiredTriggerRecord rec = new FiredTriggerRecord();
                rec.setFireInstanceId(rs.getString(Constants.COL_ENTRY_ID));
                rec.setFireInstanceState(rs.getString(Constants.COL_ENTRY_STATE));
                rec.setFireTimestamp(rs.getLong(Constants.COL_FIRED_TIME));
                rec.setScheduleTimestamp(rs.getLong(Constants.COL_SCHED_TIME));
                rec.setPriority(rs.getInt(Constants.COL_PRIORITY));
                rec.setSchedulerInstanceId(rs.getString(Constants.COL_INSTANCE_NAME));
                rec.setTriggerKey(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
                if (!rec.getFireInstanceState().equals(Constants.STATE_ACQUIRED)) {
                    rec.setJobDisallowsConcurrentExecution(getBoolean(rs, Constants.COL_IS_NONCONCURRENT));
                    rec.setJobRequestsRecovery(rs.getBoolean(Constants.COL_REQUESTS_RECOVERY));
                    rec.setJobKey(JobKey.jobKey(rs.getString(Constants.COL_JOB_NAME), rs.getString(Constants.COL_JOB_GROUP)));
                }
                lst.add(rec);
            }
            return lst;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<FiredTriggerRecord> selectFiredTriggerRecordsByJob(Connection conn, String jobName, String groupName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<FiredTriggerRecord> lst = new LinkedList<>();
            if (jobName != null) {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_FIRED_TRIGGERS_OF_JOB));
                ps.setString(1, jobName);
                ps.setString(2, groupName);
            } else {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_FIRED_TRIGGERS_OF_JOB_GROUP));
                ps.setString(1, groupName);
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                FiredTriggerRecord rec = new FiredTriggerRecord();
                rec.setFireInstanceId(rs.getString(Constants.COL_ENTRY_ID));
                rec.setFireInstanceState(rs.getString(Constants.COL_ENTRY_STATE));
                rec.setFireTimestamp(rs.getLong(Constants.COL_FIRED_TIME));
                rec.setScheduleTimestamp(rs.getLong(Constants.COL_SCHED_TIME));
                rec.setPriority(rs.getInt(Constants.COL_PRIORITY));
                rec.setSchedulerInstanceId(rs.getString(Constants.COL_INSTANCE_NAME));
                rec.setTriggerKey(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
                if (!rec.getFireInstanceState().equals(Constants.STATE_ACQUIRED)) {
                    rec.setJobDisallowsConcurrentExecution(getBoolean(rs, Constants.COL_IS_NONCONCURRENT));
                    rec.setJobRequestsRecovery(rs.getBoolean(Constants.COL_REQUESTS_RECOVERY));
                    rec.setJobKey(JobKey.jobKey(rs.getString(Constants.COL_JOB_NAME), rs.getString(Constants.COL_JOB_GROUP)));
                }
                lst.add(rec);
            }
            return lst;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<FiredTriggerRecord> selectInstancesFiredTriggerRecords(Connection conn, String instanceName) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<FiredTriggerRecord> lst = new LinkedList<>();
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_INSTANCES_FIRED_TRIGGERS));
            ps.setString(1, instanceName);
            rs = ps.executeQuery();
            while (rs.next()) {
                FiredTriggerRecord rec = new FiredTriggerRecord();
                rec.setFireInstanceId(rs.getString(Constants.COL_ENTRY_ID));
                rec.setFireInstanceState(rs.getString(Constants.COL_ENTRY_STATE));
                rec.setFireTimestamp(rs.getLong(Constants.COL_FIRED_TIME));
                rec.setScheduleTimestamp(rs.getLong(Constants.COL_SCHED_TIME));
                rec.setSchedulerInstanceId(rs.getString(Constants.COL_INSTANCE_NAME));
                rec.setTriggerKey(TriggerKey.triggerKey(rs.getString(Constants.COL_TRIGGER_NAME), rs.getString(Constants.COL_TRIGGER_GROUP)));
                if (!rec.getFireInstanceState().equals(Constants.STATE_ACQUIRED)) {
                    rec.setJobDisallowsConcurrentExecution(getBoolean(rs, Constants.COL_IS_NONCONCURRENT));
                    rec.setJobRequestsRecovery(rs.getBoolean(Constants.COL_REQUESTS_RECOVERY));
                    rec.setJobKey(JobKey.jobKey(rs.getString(Constants.COL_JOB_NAME), rs.getString(Constants.COL_JOB_GROUP)));
                }
                rec.setPriority(rs.getInt(Constants.COL_PRIORITY));
                lst.add(rec);
            }
            return lst;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public Set<String> selectFiredTriggerInstanceNames(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            Set<String> instanceNames = new HashSet<>();
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_FIRED_TRIGGER_INSTANCE_NAMES));
            rs = ps.executeQuery();
            while (rs.next()) {
                instanceNames.add(rs.getString(Constants.COL_INSTANCE_NAME));
            }
            return instanceNames;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteFiredTrigger(Connection conn, String entryId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_FIRED_TRIGGER));
            ps.setString(1, entryId);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectJobExecutionCount(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_JOB_EXECUTION_COUNT));
            ps.setString(1, jobKey.getName());
            ps.setString(2, jobKey.getGroup());
            rs = ps.executeQuery();
            return rs.next() ? rs.getInt(1) : 0;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertSchedulerState(Connection conn, String theInstanceId, long checkInTime, long interval) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_SCHEDULER_STATE));
            ps.setString(1, theInstanceId);
            ps.setLong(2, checkInTime);
            ps.setLong(3, interval);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int deleteSchedulerState(Connection conn, String theInstanceId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.DELETE_SCHEDULER_STATE));
            ps.setString(1, theInstanceId);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateSchedulerState(Connection conn, String theInstanceId, long checkInTime) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_SCHEDULER_STATE));
            ps.setLong(1, checkInTime);
            ps.setString(2, theInstanceId);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public List<SchedulerStateRecord> selectSchedulerStateRecords(Connection conn, String theInstanceId) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            List<SchedulerStateRecord> lst = new LinkedList<>();
            if (theInstanceId != null) {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_SCHEDULER_STATE));
                ps.setString(1, theInstanceId);
            } else {
                ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_SCHEDULER_STATES));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                SchedulerStateRecord rec = new SchedulerStateRecord();
                rec.setSchedulerInstanceId(rs.getString(Constants.COL_INSTANCE_NAME));
                rec.setCheckinTimestamp(rs.getLong(Constants.COL_LAST_CHECKIN_TIME));
                rec.setCheckinInterval(rs.getLong(Constants.COL_CHECKIN_INTERVAL));
                lst.add(rec);
            }
            return lst;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    protected final String rtp(String query) {
        return Util.rtp(query, this.tablePrefix, getSchedulerNameLiteral());
    }

    protected String getSchedulerNameLiteral() {
        if (this.schedNameLiteral == null) {
            this.schedNameLiteral = "'" + this.schedName + "'";
        }
        return this.schedNameLiteral;
    }

    protected ByteArrayOutputStream serializeObject(Object obj) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        if (null != obj) {
            ObjectOutputStream out = new ObjectOutputStream(baos);
            out.writeObject(obj);
            out.flush();
        }
        return baos;
    }

    protected ByteArrayOutputStream serializeJobData(JobDataMap data) throws IOException {
        if (canUseProperties()) {
            return serializeProperties(data);
        }
        try {
            return serializeObject(data);
        } catch (NotSerializableException e) {
            throw new NotSerializableException("Unable to serialize JobDataMap for insertion into database because the value of property '" + getKeyOfNonSerializableValue(data) + "' is not serializable: " + e.getMessage());
        }
    }

    protected Object getKeyOfNonSerializableValue(Map<?, ?> data) {
        for (Map.Entry<?, ?> entry : data.entrySet()) {
            ByteArrayOutputStream baos = null;
            try {
                try {
                    baos = serializeObject(entry.getValue());
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (IOException e) {
                        }
                    }
                } catch (IOException e2) {
                    Object key = entry.getKey();
                    if (baos != null) {
                        try {
                            baos.close();
                        } catch (IOException e3) {
                        }
                    }
                    return key;
                }
            } catch (Throwable th) {
                if (baos != null) {
                    try {
                        baos.close();
                    } catch (IOException e4) {
                    }
                }
                throw th;
            }
        }
        return null;
    }

    private ByteArrayOutputStream serializeProperties(JobDataMap data) throws IOException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        if (null != data) {
            convertToProperty(data.getWrappedMap()).store(ba, "");
        }
        return ba;
    }

    protected Map<?, ?> convertFromProperty(Properties properties) throws IOException {
        return new HashMap(properties);
    }

    protected Properties convertToProperty(Map<?, ?> data) throws IOException {
        Properties properties = new Properties();
        for (Map.Entry<?, ?> entry : data.entrySet()) {
            Object key = entry.getKey();
            String val = entry.getValue() == null ? "" : entry.getValue();
            if (!(key instanceof String)) {
                throw new IOException("JobDataMap keys/values must be Strings when the 'useProperties' property is set.  offending Key: " + key);
            } else if (!(val instanceof String)) {
                throw new IOException("JobDataMap values must be Strings when the 'useProperties' property is set.  Key of offending value: " + key);
            } else {
                properties.put(key, val);
            }
        }
        return properties;
    }

    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        InputStream binaryInput;
        Object obj = null;
        Blob blobLocator = rs.getBlob(colName);
        if (!(blobLocator == null || blobLocator.length() == 0 || null == (binaryInput = blobLocator.getBinaryStream()) || ((binaryInput instanceof ByteArrayInputStream) && ((ByteArrayInputStream) binaryInput).available() == 0))) {
            ObjectInputStream in = new ObjectInputStream(binaryInput);
            try {
                obj = in.readObject();
                in.close();
            } catch (Throwable th) {
                in.close();
                throw th;
            }
        }
        return obj;
    }

    protected Object getJobDataFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        if (!canUseProperties()) {
            return getObjectFromBlob(rs, colName);
        }
        Blob blobLocator = rs.getBlob(colName);
        if (blobLocator != null) {
            return blobLocator.getBinaryStream();
        }
        return null;
    }

    @Override // org.quartz.impl.jdbcjobstore.DriverDelegate
    public Set<String> selectPausedTriggerGroups(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        HashSet<String> set = new HashSet<>();
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.SELECT_PAUSED_TRIGGER_GROUPS));
            rs = ps.executeQuery();
            while (rs.next()) {
                set.add(rs.getString(Constants.COL_TRIGGER_GROUP));
            }
            return set;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    protected static void closeResultSet(ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException e) {
            }
        }
    }

    protected static void closeStatement(Statement statement) {
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException e) {
            }
        }
    }

    protected void setBoolean(PreparedStatement ps, int index, boolean val) throws SQLException {
        ps.setBoolean(index, val);
    }

    protected boolean getBoolean(ResultSet rs, String columnName) throws SQLException {
        return rs.getBoolean(columnName);
    }

    protected boolean getBoolean(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getBoolean(columnIndex);
    }

    protected void setBytes(PreparedStatement ps, int index, ByteArrayOutputStream baos) throws SQLException {
        ps.setBytes(index, baos == null ? new byte[0] : baos.toByteArray());
    }
}
