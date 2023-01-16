package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimeZone;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.TriggerKey;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.impl.triggers.CronTriggerImpl;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/CronTriggerPersistenceDelegate.class */
public class CronTriggerPersistenceDelegate implements TriggerPersistenceDelegate, StdJDBCConstants {
    protected String tablePrefix;
    protected String schedNameLiteral;

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public void initialize(String theTablePrefix, String schedName) {
        this.tablePrefix = theTablePrefix;
        this.schedNameLiteral = "'" + schedName + "'";
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public String getHandledTriggerTypeDiscriminator() {
        return Constants.TTYPE_CRON;
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public boolean canHandleTriggerType(OperableTrigger trigger) {
        return (trigger instanceof CronTriggerImpl) && !((CronTriggerImpl) trigger).hasAdditionalProperties();
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public int deleteExtendedTriggerProperties(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.DELETE_CRON_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            int executeUpdate = ps.executeUpdate();
            Util.closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            Util.closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public int insertExtendedTriggerProperties(Connection conn, OperableTrigger trigger, String state, JobDetail jobDetail) throws SQLException, IOException {
        CronTrigger cronTrigger = (CronTrigger) trigger;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.INSERT_CRON_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, trigger.getKey().getName());
            ps.setString(2, trigger.getKey().getGroup());
            ps.setString(3, cronTrigger.getCronExpression());
            ps.setString(4, cronTrigger.getTimeZone().getID());
            int executeUpdate = ps.executeUpdate();
            Util.closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            Util.closeStatement(ps);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public TriggerPersistenceDelegate.TriggerPropertyBundle loadExtendedTriggerProperties(Connection conn, TriggerKey triggerKey) throws SQLException {
        try {
            PreparedStatement ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.SELECT_CRON_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String cronExpr = rs.getString(Constants.COL_CRON_EXPRESSION);
                String timeZoneId = rs.getString(Constants.COL_TIME_ZONE_ID);
                CronScheduleBuilder cb = CronScheduleBuilder.cronSchedule(cronExpr);
                if (timeZoneId != null) {
                    cb.inTimeZone(TimeZone.getTimeZone(timeZoneId));
                }
                TriggerPersistenceDelegate.TriggerPropertyBundle triggerPropertyBundle = new TriggerPersistenceDelegate.TriggerPropertyBundle(cb, null, null);
                Util.closeResultSet(rs);
                Util.closeStatement(ps);
                return triggerPropertyBundle;
            }
            throw new IllegalStateException("No record found for selection of Trigger with key: '" + triggerKey + "' and statement: " + Util.rtp(StdJDBCConstants.SELECT_CRON_TRIGGER, this.tablePrefix, this.schedNameLiteral));
        } catch (Throwable th) {
            Util.closeResultSet(null);
            Util.closeStatement(null);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public int updateExtendedTriggerProperties(Connection conn, OperableTrigger trigger, String state, JobDetail jobDetail) throws SQLException, IOException {
        CronTrigger cronTrigger = (CronTrigger) trigger;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.UPDATE_CRON_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, cronTrigger.getCronExpression());
            ps.setString(2, cronTrigger.getTimeZone().getID());
            ps.setString(3, trigger.getKey().getName());
            ps.setString(4, trigger.getKey().getGroup());
            int executeUpdate = ps.executeUpdate();
            Util.closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            Util.closeStatement(ps);
            throw th;
        }
    }
}
