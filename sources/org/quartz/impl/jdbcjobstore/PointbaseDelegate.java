package org.quartz.impl.jdbcjobstore;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.quartz.Calendar;
import org.quartz.JobDetail;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/PointbaseDelegate.class */
public class PointbaseDelegate extends StdJDBCDelegate {
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertJobDetail(Connection conn, JobDetail job) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeJobData(job.getJobDataMap());
        int len = baos.toByteArray().length;
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
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
            ps.setBinaryStream(9, (InputStream) bais, len);
            int insertResult = ps.executeUpdate();
            closeStatement(ps);
            return insertResult;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateJobDetail(Connection conn, JobDetail job) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeJobData(job.getJobDataMap());
        int len = baos.toByteArray().length;
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.UPDATE_JOB_DETAIL));
            ps.setString(1, job.getDescription());
            ps.setString(2, job.getJobClass().getName());
            setBoolean(ps, 3, job.isDurable());
            setBoolean(ps, 4, job.isConcurrentExectionDisallowed());
            setBoolean(ps, 5, job.isPersistJobDataAfterExecution());
            setBoolean(ps, 6, job.requestsRecovery());
            ps.setBinaryStream(7, (InputStream) bais, len);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r21v0 */
    /* JADX WARN: Type inference failed for: r21v1 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARNING: Unknown variable types count: 2 */
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int insertTrigger(java.sql.Connection r8, org.quartz.spi.OperableTrigger r9, java.lang.String r10, org.quartz.JobDetail r11) throws java.sql.SQLException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 444
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.PointbaseDelegate.insertTrigger(java.sql.Connection, org.quartz.spi.OperableTrigger, java.lang.String, org.quartz.JobDetail):int");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r19v0 */
    /* JADX WARN: Type inference failed for: r19v1 */
    /* JADX WARN: Type inference failed for: r23v0 */
    /* JADX WARN: Type inference failed for: r23v1 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r19v4 */
    /* JADX WARN: Type inference failed for: r23v4 */
    /* JADX WARNING: Unknown variable types count: 3 */
    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int updateTrigger(java.sql.Connection r8, org.quartz.spi.OperableTrigger r9, java.lang.String r10, org.quartz.JobDetail r11) throws java.sql.SQLException, java.io.IOException {
        /*
        // Method dump skipped, instructions count: 462
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.impl.jdbcjobstore.PointbaseDelegate.updateTrigger(java.sql.Connection, org.quartz.spi.OperableTrigger, java.lang.String, org.quartz.JobDetail):int");
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateJobData(Connection conn, JobDetail job) throws IOException, SQLException {
        ByteArrayOutputStream baos = serializeJobData(job.getJobDataMap());
        int len = baos.toByteArray().length;
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp("UPDATE {0}JOB_DETAILS SET JOB_DATA = ?  WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?"));
            ps.setBinaryStream(1, (InputStream) bais, len);
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

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int insertCalendar(Connection conn, String calendarName, Calendar calendar) throws IOException, SQLException {
        byte[] buf = serializeObject(calendar).toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp(StdJDBCConstants.INSERT_CALENDAR));
            ps.setString(1, calendarName);
            ps.setBinaryStream(2, (InputStream) bais, buf.length);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int updateCalendar(Connection conn, String calendarName, Calendar calendar) throws IOException, SQLException {
        byte[] buf = serializeObject(calendar).toByteArray();
        ByteArrayInputStream bais = new ByteArrayInputStream(buf);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(rtp("UPDATE {0}CALENDARS SET CALENDAR = ?  WHERE SCHED_NAME = {1} AND CALENDAR_NAME = ?"));
            ps.setBinaryStream(1, (InputStream) bais, buf.length);
            ps.setString(2, calendarName);
            int executeUpdate = ps.executeUpdate();
            closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getObjectFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        Object obj = null;
        InputStream binaryInput = new ByteArrayInputStream(rs.getBytes(colName));
        if (!(null == binaryInput || binaryInput.available() == 0)) {
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

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate
    protected Object getJobDataFromBlob(ResultSet rs, String colName) throws ClassNotFoundException, IOException, SQLException {
        if (!canUseProperties()) {
            return getObjectFromBlob(rs, colName);
        }
        byte[] data = rs.getBytes(colName);
        if (data == null) {
            return null;
        }
        return new ByteArrayInputStream(data);
    }
}
