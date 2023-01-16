package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerKey;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.impl.triggers.SimpleTriggerImpl;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/SimpleTriggerPersistenceDelegate.class */
public class SimpleTriggerPersistenceDelegate implements TriggerPersistenceDelegate, StdJDBCConstants {
    protected String tablePrefix;
    protected String schedNameLiteral;

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public void initialize(String theTablePrefix, String schedName) {
        this.tablePrefix = theTablePrefix;
        this.schedNameLiteral = "'" + schedName + "'";
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public String getHandledTriggerTypeDiscriminator() {
        return Constants.TTYPE_SIMPLE;
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public boolean canHandleTriggerType(OperableTrigger trigger) {
        return (trigger instanceof SimpleTriggerImpl) && !((SimpleTriggerImpl) trigger).hasAdditionalProperties();
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public int deleteExtendedTriggerProperties(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.DELETE_SIMPLE_TRIGGER, this.tablePrefix, this.schedNameLiteral));
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
        SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.INSERT_SIMPLE_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, trigger.getKey().getName());
            ps.setString(2, trigger.getKey().getGroup());
            ps.setInt(3, simpleTrigger.getRepeatCount());
            ps.setBigDecimal(4, new BigDecimal(String.valueOf(simpleTrigger.getRepeatInterval())));
            ps.setInt(5, simpleTrigger.getTimesTriggered());
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
            PreparedStatement ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.SELECT_SIMPLE_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int repeatCount = rs.getInt(Constants.COL_REPEAT_COUNT);
                TriggerPersistenceDelegate.TriggerPropertyBundle triggerPropertyBundle = new TriggerPersistenceDelegate.TriggerPropertyBundle(SimpleScheduleBuilder.simpleSchedule().withRepeatCount(repeatCount).withIntervalInMilliseconds(rs.getLong(Constants.COL_REPEAT_INTERVAL)), new String[]{"timesTriggered"}, new Object[]{Integer.valueOf(rs.getInt(Constants.COL_TIMES_TRIGGERED))});
                Util.closeResultSet(rs);
                Util.closeStatement(ps);
                return triggerPropertyBundle;
            }
            throw new IllegalStateException("No record found for selection of Trigger with key: '" + triggerKey + "' and statement: " + Util.rtp(StdJDBCConstants.SELECT_SIMPLE_TRIGGER, this.tablePrefix, this.schedNameLiteral));
        } catch (Throwable th) {
            Util.closeResultSet(null);
            Util.closeStatement(null);
            throw th;
        }
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public int updateExtendedTriggerProperties(Connection conn, OperableTrigger trigger, String state, JobDetail jobDetail) throws SQLException, IOException {
        SimpleTrigger simpleTrigger = (SimpleTrigger) trigger;
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(StdJDBCConstants.UPDATE_SIMPLE_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setInt(1, simpleTrigger.getRepeatCount());
            ps.setBigDecimal(2, new BigDecimal(String.valueOf(simpleTrigger.getRepeatInterval())));
            ps.setInt(3, simpleTrigger.getTimesTriggered());
            ps.setString(4, simpleTrigger.getKey().getName());
            ps.setString(5, simpleTrigger.getKey().getGroup());
            int executeUpdate = ps.executeUpdate();
            Util.closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            Util.closeStatement(ps);
            throw th;
        }
    }
}
