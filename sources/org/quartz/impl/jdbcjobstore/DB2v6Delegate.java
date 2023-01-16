package org.quartz.impl.jdbcjobstore;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.quartz.JobKey;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/DB2v6Delegate.class */
public class DB2v6Delegate extends StdJDBCDelegate {
    public static final String SELECT_NUM_JOBS = "SELECT COUNT(*) FROM {0}JOB_DETAILS WHERE SCHED_NAME = {1}";
    public static final String SELECT_NUM_TRIGGERS_FOR_JOB = "SELECT COUNT(*) FROM {0}TRIGGERS WHERE SCHED_NAME = {1} AND JOB_NAME = ? AND JOB_GROUP = ?";
    public static final String SELECT_NUM_TRIGGERS = "SELECT COUNT(*) FROM {0}TRIGGERS WHERE SCHED_NAME = {1}";
    public static final String SELECT_NUM_CALENDARS = "SELECT COUNT(*) FROM {0}CALENDARS WHERE SCHED_NAME = {1}";

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumJobs(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            ps = conn.prepareStatement(rtp(SELECT_NUM_JOBS));
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

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumTriggersForJob(Connection conn, JobKey jobKey) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            ps = conn.prepareStatement(rtp(SELECT_NUM_TRIGGERS_FOR_JOB));
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

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumTriggers(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            ps = conn.prepareStatement(rtp(SELECT_NUM_TRIGGERS));
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

    @Override // org.quartz.impl.jdbcjobstore.StdJDBCDelegate, org.quartz.impl.jdbcjobstore.DriverDelegate
    public int selectNumCalendars(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            int count = 0;
            ps = conn.prepareStatement(rtp(SELECT_NUM_CALENDARS));
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
}
