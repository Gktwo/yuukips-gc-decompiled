package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.TriggerKey;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/TriggerPersistenceDelegate.class */
public interface TriggerPersistenceDelegate {
    void initialize(String str, String str2);

    boolean canHandleTriggerType(OperableTrigger operableTrigger);

    String getHandledTriggerTypeDiscriminator();

    int insertExtendedTriggerProperties(Connection connection, OperableTrigger operableTrigger, String str, JobDetail jobDetail) throws SQLException, IOException;

    int updateExtendedTriggerProperties(Connection connection, OperableTrigger operableTrigger, String str, JobDetail jobDetail) throws SQLException, IOException;

    int deleteExtendedTriggerProperties(Connection connection, TriggerKey triggerKey) throws SQLException;

    TriggerPropertyBundle loadExtendedTriggerProperties(Connection connection, TriggerKey triggerKey) throws SQLException;

    /* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/TriggerPersistenceDelegate$TriggerPropertyBundle.class */
    public static class TriggerPropertyBundle {

        /* renamed from: sb */
        private ScheduleBuilder<?> f3336sb;
        private String[] statePropertyNames;
        private Object[] statePropertyValues;

        public TriggerPropertyBundle(ScheduleBuilder<?> sb, String[] statePropertyNames, Object[] statePropertyValues) {
            this.f3336sb = sb;
            this.statePropertyNames = statePropertyNames;
            this.statePropertyValues = statePropertyValues;
        }

        public ScheduleBuilder<?> getScheduleBuilder() {
            return this.f3336sb;
        }

        public String[] getStatePropertyNames() {
            return this.statePropertyNames;
        }

        public Object[] getStatePropertyValues() {
            return this.statePropertyValues;
        }
    }
}
