package org.quartz.impl.jdbcjobstore;

import java.util.TimeZone;
import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.impl.triggers.CalendarIntervalTriggerImpl;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/CalendarIntervalTriggerPersistenceDelegate.class */
public class CalendarIntervalTriggerPersistenceDelegate extends SimplePropertiesTriggerPersistenceDelegateSupport {
    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public boolean canHandleTriggerType(OperableTrigger trigger) {
        return (trigger instanceof CalendarIntervalTriggerImpl) && !((CalendarIntervalTriggerImpl) trigger).hasAdditionalProperties();
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public String getHandledTriggerTypeDiscriminator() {
        return Constants.TTYPE_CAL_INT;
    }

    @Override // org.quartz.impl.jdbcjobstore.SimplePropertiesTriggerPersistenceDelegateSupport
    protected SimplePropertiesTriggerProperties getTriggerProperties(OperableTrigger trigger) {
        CalendarIntervalTriggerImpl calTrig = (CalendarIntervalTriggerImpl) trigger;
        SimplePropertiesTriggerProperties props = new SimplePropertiesTriggerProperties();
        props.setInt1(calTrig.getRepeatInterval());
        props.setString1(calTrig.getRepeatIntervalUnit().name());
        props.setInt2(calTrig.getTimesTriggered());
        props.setString2(calTrig.getTimeZone().getID());
        props.setBoolean1(calTrig.isPreserveHourOfDayAcrossDaylightSavings());
        props.setBoolean2(calTrig.isSkipDayIfHourDoesNotExist());
        return props;
    }

    @Override // org.quartz.impl.jdbcjobstore.SimplePropertiesTriggerPersistenceDelegateSupport
    protected TriggerPersistenceDelegate.TriggerPropertyBundle getTriggerPropertyBundle(SimplePropertiesTriggerProperties props) {
        TimeZone tz = null;
        String tzId = props.getString2();
        if (!(tzId == null || tzId.trim().length() == 0)) {
            tz = TimeZone.getTimeZone(tzId);
        }
        return new TriggerPersistenceDelegate.TriggerPropertyBundle(CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(props.getInt1(), DateBuilder.IntervalUnit.valueOf(props.getString1())).inTimeZone(tz).preserveHourOfDayAcrossDaylightSavings(props.isBoolean1()).skipDayIfHourDoesNotExist(props.isBoolean2()), new String[]{"timesTriggered"}, new Object[]{Integer.valueOf(props.getInt2())});
    }
}
