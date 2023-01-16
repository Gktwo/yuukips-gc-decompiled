package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.quartz.JobDetail;
import org.quartz.TriggerKey;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/SimplePropertiesTriggerPersistenceDelegateSupport.class */
public abstract class SimplePropertiesTriggerPersistenceDelegateSupport implements TriggerPersistenceDelegate, StdJDBCConstants {
    protected static final String TABLE_SIMPLE_PROPERTIES_TRIGGERS = "SIMPROP_TRIGGERS";
    protected static final String COL_STR_PROP_1 = "STR_PROP_1";
    protected static final String COL_STR_PROP_2 = "STR_PROP_2";
    protected static final String COL_STR_PROP_3 = "STR_PROP_3";
    protected static final String COL_INT_PROP_1 = "INT_PROP_1";
    protected static final String COL_INT_PROP_2 = "INT_PROP_2";
    protected static final String COL_LONG_PROP_1 = "LONG_PROP_1";
    protected static final String COL_LONG_PROP_2 = "LONG_PROP_2";
    protected static final String COL_DEC_PROP_1 = "DEC_PROP_1";
    protected static final String COL_DEC_PROP_2 = "DEC_PROP_2";
    protected static final String COL_BOOL_PROP_1 = "BOOL_PROP_1";
    protected static final String COL_BOOL_PROP_2 = "BOOL_PROP_2";
    protected static final String SELECT_SIMPLE_PROPS_TRIGGER = "SELECT * FROM {0}SIMPROP_TRIGGERS WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ?";
    protected static final String DELETE_SIMPLE_PROPS_TRIGGER = "DELETE FROM {0}SIMPROP_TRIGGERS WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ?";
    protected static final String INSERT_SIMPLE_PROPS_TRIGGER = "INSERT INTO {0}SIMPROP_TRIGGERS (SCHED_NAME, TRIGGER_NAME, TRIGGER_GROUP, STR_PROP_1, STR_PROP_2, STR_PROP_3, INT_PROP_1, INT_PROP_2, LONG_PROP_1, LONG_PROP_2, DEC_PROP_1, DEC_PROP_2, BOOL_PROP_1, BOOL_PROP_2)  VALUES({1}, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    protected static final String UPDATE_SIMPLE_PROPS_TRIGGER = "UPDATE {0}SIMPROP_TRIGGERS SET STR_PROP_1 = ?, STR_PROP_2 = ?, STR_PROP_3 = ?, INT_PROP_1 = ?, INT_PROP_2 = ?, LONG_PROP_1 = ?, LONG_PROP_2 = ?, DEC_PROP_1 = ?, DEC_PROP_2 = ?, BOOL_PROP_1 = ?, BOOL_PROP_2 = ? WHERE SCHED_NAME = {1} AND TRIGGER_NAME = ? AND TRIGGER_GROUP = ?";
    protected String tablePrefix;
    protected String schedNameLiteral;

    protected abstract SimplePropertiesTriggerProperties getTriggerProperties(OperableTrigger operableTrigger);

    protected abstract TriggerPersistenceDelegate.TriggerPropertyBundle getTriggerPropertyBundle(SimplePropertiesTriggerProperties simplePropertiesTriggerProperties);

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public void initialize(String theTablePrefix, String schedName) {
        this.tablePrefix = theTablePrefix;
        this.schedNameLiteral = "'" + schedName + "'";
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public int deleteExtendedTriggerProperties(Connection conn, TriggerKey triggerKey) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(DELETE_SIMPLE_PROPS_TRIGGER, this.tablePrefix, this.schedNameLiteral));
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
        SimplePropertiesTriggerProperties properties = getTriggerProperties(trigger);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(INSERT_SIMPLE_PROPS_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, trigger.getKey().getName());
            ps.setString(2, trigger.getKey().getGroup());
            ps.setString(3, properties.getString1());
            ps.setString(4, properties.getString2());
            ps.setString(5, properties.getString3());
            ps.setInt(6, properties.getInt1());
            ps.setInt(7, properties.getInt2());
            ps.setLong(8, properties.getLong1());
            ps.setLong(9, properties.getLong2());
            ps.setBigDecimal(10, properties.getDecimal1());
            ps.setBigDecimal(11, properties.getDecimal2());
            ps.setBoolean(12, properties.isBoolean1());
            ps.setBoolean(13, properties.isBoolean2());
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
            PreparedStatement ps = conn.prepareStatement(Util.rtp(SELECT_SIMPLE_PROPS_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, triggerKey.getName());
            ps.setString(2, triggerKey.getGroup());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                SimplePropertiesTriggerProperties properties = new SimplePropertiesTriggerProperties();
                properties.setString1(rs.getString(COL_STR_PROP_1));
                properties.setString2(rs.getString(COL_STR_PROP_2));
                properties.setString3(rs.getString(COL_STR_PROP_3));
                properties.setInt1(rs.getInt(COL_INT_PROP_1));
                properties.setInt2(rs.getInt(COL_INT_PROP_2));
                properties.setLong1((long) rs.getInt(COL_LONG_PROP_1));
                properties.setLong2((long) rs.getInt(COL_LONG_PROP_2));
                properties.setDecimal1(rs.getBigDecimal(COL_DEC_PROP_1));
                properties.setDecimal2(rs.getBigDecimal(COL_DEC_PROP_2));
                properties.setBoolean1(rs.getBoolean(COL_BOOL_PROP_1));
                properties.setBoolean2(rs.getBoolean(COL_BOOL_PROP_2));
                TriggerPersistenceDelegate.TriggerPropertyBundle triggerPropertyBundle = getTriggerPropertyBundle(properties);
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
        SimplePropertiesTriggerProperties properties = getTriggerProperties(trigger);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(Util.rtp(UPDATE_SIMPLE_PROPS_TRIGGER, this.tablePrefix, this.schedNameLiteral));
            ps.setString(1, properties.getString1());
            ps.setString(2, properties.getString2());
            ps.setString(3, properties.getString3());
            ps.setInt(4, properties.getInt1());
            ps.setInt(5, properties.getInt2());
            ps.setLong(6, properties.getLong1());
            ps.setLong(7, properties.getLong2());
            ps.setBigDecimal(8, properties.getDecimal1());
            ps.setBigDecimal(9, properties.getDecimal2());
            ps.setBoolean(10, properties.isBoolean1());
            ps.setBoolean(11, properties.isBoolean2());
            ps.setString(12, trigger.getKey().getName());
            ps.setString(13, trigger.getKey().getGroup());
            int executeUpdate = ps.executeUpdate();
            Util.closeStatement(ps);
            return executeUpdate;
        } catch (Throwable th) {
            Util.closeStatement(ps);
            throw th;
        }
    }
}
