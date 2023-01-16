package org.quartz.impl.jdbcjobstore.oracle;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.sql.BLOB;
import org.quartz.Calendar;
import org.quartz.JobDetail;
import org.quartz.impl.jdbcjobstore.StdJDBCDelegate;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/oracle/OracleDelegate.class */
public class OracleDelegate extends StdJDBCDelegate {
    public static final String INSERT_ORACLE_JOB_DETAIL = "INSERT INTO {0}JOB_DETAILS (SCHED_NAME, JOB_NAME, JOB_GROUP, DESCRIPTION, JOB_CLASS_NAME, IS_DURABLE, IS_NONCONCURRENT, IS_UPDATE_DATA, REQUESTS_RECOVERY, JOB_DATA)  VALUES({1}, ?, ?, ?, ?, ?, ?, ?, ?, EMPTY_BLOB())";
    public static final String UPDATE_ORACLE_JOB_DETAIL = "UPDATE {0}JOB_DETAILS SET DESCRIPTION = ?, JOB_CLASS_NAME = ?, IS_DURABLE = ?, IS_NONCONCURRENT = ?, IS_UPDATE_DATA = ?, REQUESTS_RECOVERY = ?, JOB_DATA = EMPTY_BLOB()  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?";
    public static final String UPDATE_ORACLE_JOB_DETAIL_BLOB = "UPDATE {0}JOB_DETAILS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?";
    public static final String SELECT_ORACLE_JOB_DETAIL_BLOB = "SELECT JOB_DATA FROM {0}JOB_DETAILS WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ? FOR UPDATE";
    public static final String UPDATE_ORACLE_TRIGGER = "UPDATE {0}TRIGGERS SET JOB_NAME = ?, JOB_GROUP = ?, DESCRIPTION = ?, NEXT_FIRE_TIME = ?, PREV_FIRE_TIME = ?, TRIGGER_STATE = ?, TRIGGER_TYPE = ?, START_TIME = ?, END_TIME = ?, CALENDAR_NAME = ?, MISFIRE_INSTR = ?, PRIORITY = ? WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ?";
    public static final String SELECT_ORACLE_TRIGGER_JOB_DETAIL_BLOB = "SELECT JOB_DATA FROM {0}TRIGGERS WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ? FOR UPDATE";
    public static final String UPDATE_ORACLE_TRIGGER_JOB_DETAIL_BLOB = "UPDATE {0}TRIGGERS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ?";
    public static final String UPDATE_ORACLE_TRIGGER_JOB_DETAIL_EMPTY_BLOB = "UPDATE {0}TRIGGERS SET JOB_DATA = EMPTY_BLOB()  WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ?";
    public static final String INSERT_ORACLE_CALENDAR = "INSERT INTO {0}CALENDARS (SCHED_NAME, CALENDAR_NAME, CALENDAR)  VALUES({1}, ?, EMPTY_BLOB())";
    public static final String SELECT_ORACLE_CALENDAR_BLOB = "SELECT CALENDAR FROM {0}CALENDARS WHERE SCHED_NAME = {1} AND CALENDAR_NAME = ? FOR UPDATE";
    public static final String UPDATE_ORACLE_CALENDAR_BLOB = "UPDATE {0}CALENDARS SET CALENDAR = ?  WHERE SCHED_NAME = {1} AND CALENDAR_NAME = ?";

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        Object obj = null;
        InputStream binaryInput = rs.getBinaryStream(colName);
        if (binaryInput != null) {
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

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertJobDetail(Connection conn, JobDetail job) throws IOException, SQLException {
        byte[] data = serializeJobData(job.getJobDataMap()).toByteArray();
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps2 = conn.prepareStatement(rtp(INSERT_ORACLE_JOB_DETAIL));
            ps2.setString(1, job.getKey().getName());
            ps2.setString(2, job.getKey().getGroup());
            ps2.setString(3, job.getDescription());
            ps2.setString(4, job.getJobClass().getName());
            setBoolean(ps2, 5, job.isDurable());
            setBoolean(ps2, 6, job.isConcurrentExectionDisallowed());
            setBoolean(ps2, 7, job.isPersistJobDataAfterExecution());
            setBoolean(ps2, 8, job.requestsRecovery());
            ps2.executeUpdate();
            ps2.close();
            ps = conn.prepareStatement(rtp(SELECT_ORACLE_JOB_DETAIL_BLOB));
            ps.setString(1, job.getKey().getName());
            ps.setString(2, job.getKey().getGroup());
            rs = ps.executeQuery();
            if (!rs.next()) {
                return 0;
            }
            Blob dbBlob = writeDataToBlob(rs, 1, data);
            rs.close();
            ps.close();
            ps = conn.prepareStatement(rtp("UPDATE {0}JOB_DETAILS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?"));
            ps.setBlob(1, dbBlob);
            ps.setString(2, job.getKey().getName());
            ps.setString(3, job.getKey().getGroup());
            int res = ps.executeUpdate();
            closeResultSet(rs);
            closeStatement(ps);
            return res;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getJobDataFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        if (canUseProperties()) {
            return rs.getBinaryStream(colName);
        }
        return getObjectFromBlob(rs, colName);
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateJobDetail(Connection conn, JobDetail job) throws IOException, SQLException {
        byte[] data = serializeJobData(job.getJobDataMap()).toByteArray();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps3 = conn.prepareStatement(rtp(UPDATE_ORACLE_JOB_DETAIL));
            ps3.setString(1, job.getDescription());
            ps3.setString(2, job.getJobClass().getName());
            setBoolean(ps3, 3, job.isDurable());
            setBoolean(ps3, 4, job.isConcurrentExectionDisallowed());
            setBoolean(ps3, 5, job.isPersistJobDataAfterExecution());
            setBoolean(ps3, 6, job.requestsRecovery());
            ps3.setString(7, job.getKey().getName());
            ps3.setString(8, job.getKey().getGroup());
            ps3.executeUpdate();
            ps3.close();
            ps = conn.prepareStatement(rtp(SELECT_ORACLE_JOB_DETAIL_BLOB));
            ps.setString(1, job.getKey().getName());
            ps.setString(2, job.getKey().getGroup());
            rs = ps.executeQuery();
            int res = 0;
            if (rs.next()) {
                Blob dbBlob = writeDataToBlob(rs, 1, data);
                ps2 = conn.prepareStatement(rtp("UPDATE {0}JOB_DETAILS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?"));
                ps2.setBlob(1, dbBlob);
                ps2.setString(2, job.getKey().getName());
                ps2.setString(3, job.getKey().getGroup());
                res = ps2.executeUpdate();
            }
            return res;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeStatement(ps2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int insertTrigger(java.sql.Connection r8, org.quartz.spi.OperableTrigger r9, java.lang.String r10, org.quartz.JobDetail r11) throws java.sql.SQLException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 706
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.oracle.OracleDelegate.insertTrigger(java.sql.Connection, org.quartz.spi.OperableTrigger, java.lang.String, org.quartz.JobDetail):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r18v0 */
    /* JADX WARN: Type inference failed for: r18v1 */
    /* JADX WARN: Type inference failed for: r20v0 */
    /* JADX WARN: Type inference failed for: r20v1 */
    /* JADX WARN: Type inference failed for: r24v0 */
    /* JADX WARN: Type inference failed for: r24v1 */
    /* JADX WARN: Type inference failed for: r18v4 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r24v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateTrigger(java.sql.Connection r8, org.quartz.spi.OperableTrigger r9, java.lang.String r10, org.quartz.JobDetail r11) throws java.sql.SQLException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 706
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.oracle.OracleDelegate.updateTrigger(java.sql.Connection, org.quartz.spi.OperableTrigger, java.lang.String, org.quartz.JobDetail):int");
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertCalendar(Connection conn, String calendarName, Calendar calendar) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeObject(calendar);
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            PreparedStatement ps3 = conn.prepareStatement(rtp(INSERT_ORACLE_CALENDAR));
            ps3.setString(1, calendarName);
            ps3.executeUpdate();
            ps3.close();
            ps = conn.prepareStatement(rtp(SELECT_ORACLE_CALENDAR_BLOB));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return 0;
            }
            Blob dbBlob = writeDataToBlob(rs, 1, baos.toByteArray());
            ps2 = conn.prepareStatement(rtp("UPDATE {0}CALENDARS SET CALENDAR = ?  WHERE SCHED_NAME = {1} AND CALENDAR_NAME = ?"));
            ps2.setBlob(1, dbBlob);
            ps2.setString(2, calendarName);
            int executeUpdate = ps2.executeUpdate();
            closeResultSet(rs);
            closeStatement(ps);
            closeStatement(ps2);
            return executeUpdate;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeStatement(ps2);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateCalendar(Connection conn, String calendarName, Calendar calendar) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeObject(calendar);
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(SELECT_ORACLE_CALENDAR_BLOB));
            ps.setString(1, calendarName);
            rs = ps.executeQuery();
            if (!rs.next()) {
                return 0;
            }
            Blob dbBlob = writeDataToBlob(rs, 1, baos.toByteArray());
            ps2 = conn.prepareStatement(rtp("UPDATE {0}CALENDARS SET CALENDAR = ?  WHERE SCHED_NAME = {1} AND CALENDAR_NAME = ?"));
            ps2.setBlob(1, dbBlob);
            ps2.setString(2, calendarName);
            int executeUpdate = ps2.executeUpdate();
            closeResultSet(rs);
            closeStatement(ps);
            closeStatement(ps2);
            return executeUpdate;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeStatement(ps2);
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateJobData(Connection conn, JobDetail job) throws IOException, SQLException {
        byte[] data = serializeJobData(job.getJobDataMap()).toByteArray();
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(SELECT_ORACLE_JOB_DETAIL_BLOB));
            ps.setString(1, job.getKey().getName());
            ps.setString(2, job.getKey().getGroup());
            rs = ps.executeQuery();
            int res = 0;
            if (rs.next()) {
                Blob dbBlob = writeDataToBlob(rs, 1, data);
                ps2 = conn.prepareStatement(rtp("UPDATE {0}JOB_DETAILS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?"));
                ps2.setBlob(1, dbBlob);
                ps2.setString(2, job.getKey().getName());
                ps2.setString(3, job.getKey().getGroup());
                res = ps2.executeUpdate();
            }
            return res;
        } finally {
            closeResultSet(rs);
            closeStatement(ps);
            closeStatement(ps2);
        }
    }

    /* access modifiers changed from: protected */
    public Blob writeDataToBlob(ResultSet rs, int column, byte[] data) throws SQLException {
        Blob blob = rs.getBlob(column);
        if (blob == null) {
            throw new SQLException("Driver's Blob representation is null!");
        } else if (blob instanceof BLOB) {
            ((BLOB) blob).putBytes(1, data);
            ((BLOB) blob).trim((long) data.length);
            return blob;
        } else {
            throw new SQLException("Driver's Blob representation is of an unsupported type: " + blob.getClass().getName());
        }
    }
}
