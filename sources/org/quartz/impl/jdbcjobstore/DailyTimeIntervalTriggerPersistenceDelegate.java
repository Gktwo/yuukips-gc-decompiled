package org.quartz.impl.jdbcjobstore;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.quartz.DailyTimeIntervalScheduleBuilder;
import org.quartz.DailyTimeIntervalTrigger;
import org.quartz.DateBuilder;
import org.quartz.TimeOfDay;
import org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate;
import org.quartz.impl.triggers.DailyTimeIntervalTriggerImpl;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/DailyTimeIntervalTriggerPersistenceDelegate.class */
public class DailyTimeIntervalTriggerPersistenceDelegate extends SimplePropertiesTriggerPersistenceDelegateSupport {
    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public boolean canHandleTriggerType(OperableTrigger trigger) {
        return (trigger instanceof DailyTimeIntervalTrigger) && !((DailyTimeIntervalTriggerImpl) trigger).hasAdditionalProperties();
    }

    @Override // org.quartz.impl.jdbcjobstore.TriggerPersistenceDelegate
    public String getHandledTriggerTypeDiscriminator() {
        return Constants.TTYPE_DAILY_TIME_INT;
    }

    @Override // org.quartz.impl.jdbcjobstore.SimplePropertiesTriggerPersistenceDelegateSupport
    protected SimplePropertiesTriggerProperties getTriggerProperties(OperableTrigger trigger) {
        DailyTimeIntervalTriggerImpl dailyTrigger = (DailyTimeIntervalTriggerImpl) trigger;
        SimplePropertiesTriggerProperties props = new SimplePropertiesTriggerProperties();
        props.setInt1(dailyTrigger.getRepeatInterval());
        props.setString1(dailyTrigger.getRepeatIntervalUnit().name());
        props.setInt2(dailyTrigger.getTimesTriggered());
        props.setString2(join(dailyTrigger.getDaysOfWeek(), ","));
        StringBuilder timeOfDayBuffer = new StringBuilder();
        TimeOfDay startTimeOfDay = dailyTrigger.getStartTimeOfDay();
        if (startTimeOfDay != null) {
            timeOfDayBuffer.append(startTimeOfDay.getHour()).append(",");
            timeOfDayBuffer.append(startTimeOfDay.getMinute()).append(",");
            timeOfDayBuffer.append(startTimeOfDay.getSecond()).append(",");
        } else {
            timeOfDayBuffer.append(",,,");
        }
        TimeOfDay endTimeOfDay = dailyTrigger.getEndTimeOfDay();
        if (endTimeOfDay != null) {
            timeOfDayBuffer.append(endTimeOfDay.getHour()).append(",");
            timeOfDayBuffer.append(endTimeOfDay.getMinute()).append(",");
            timeOfDayBuffer.append(endTimeOfDay.getSecond());
        } else {
            timeOfDayBuffer.append(",,,");
        }
        props.setString3(timeOfDayBuffer.toString());
        props.setLong1((long) dailyTrigger.getRepeatCount());
        return props;
    }

    private String join(Set<Integer> days, String sep) {
        StringBuilder sb = new StringBuilder();
        if (days == null || days.size() <= 0) {
            return "";
        }
        Iterator<Integer> itr = days.iterator();
        sb.append(itr.next());
        while (itr.hasNext()) {
            sb.append(sep).append(itr.next());
        }
        return sb.toString();
    }

    @Override // org.quartz.impl.jdbcjobstore.SimplePropertiesTriggerPersistenceDelegateSupport
    protected TriggerPersistenceDelegate.TriggerPropertyBundle getTriggerPropertyBundle(SimplePropertiesTriggerProperties props) {
        TimeOfDay startTimeOfDay;
        TimeOfDay endTimeOfDay;
        int repeatCount = (int) props.getLong1();
        int interval = props.getInt1();
        String intervalUnitStr = props.getString1();
        String daysOfWeekStr = props.getString2();
        String timeOfDayStr = props.getString3();
        DailyTimeIntervalScheduleBuilder scheduleBuilder = DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule().withInterval(interval, DateBuilder.IntervalUnit.valueOf(intervalUnitStr)).withRepeatCount(repeatCount);
        if (daysOfWeekStr != null) {
            Set<Integer> daysOfWeek = new HashSet<>();
            String[] nums = daysOfWeekStr.split(",");
            if (nums.length > 0) {
                for (String num : nums) {
                    daysOfWeek.add(Integer.valueOf(Integer.parseInt(num)));
                }
                scheduleBuilder.onDaysOfTheWeek(daysOfWeek);
            }
        } else {
            scheduleBuilder.onDaysOfTheWeek(DailyTimeIntervalScheduleBuilder.ALL_DAYS_OF_THE_WEEK);
        }
        if (timeOfDayStr != null) {
            String[] nums2 = timeOfDayStr.split(",");
            if (nums2.length >= 3) {
                startTimeOfDay = new TimeOfDay(Integer.parseInt(nums2[0]), Integer.parseInt(nums2[1]), Integer.parseInt(nums2[2]));
            } else {
                startTimeOfDay = TimeOfDay.hourMinuteAndSecondOfDay(0, 0, 0);
            }
            scheduleBuilder.startingDailyAt(startTimeOfDay);
            if (nums2.length >= 6) {
                endTimeOfDay = new TimeOfDay(Integer.parseInt(nums2[3]), Integer.parseInt(nums2[4]), Integer.parseInt(nums2[5]));
            } else {
                endTimeOfDay = TimeOfDay.hourMinuteAndSecondOfDay(23, 59, 59);
            }
            scheduleBuilder.endingDailyAt(endTimeOfDay);
        } else {
            scheduleBuilder.startingDailyAt(TimeOfDay.hourMinuteAndSecondOfDay(0, 0, 0));
            scheduleBuilder.endingDailyAt(TimeOfDay.hourMinuteAndSecondOfDay(23, 59, 59));
        }
        return new TriggerPersistenceDelegate.TriggerPropertyBundle(scheduleBuilder, new String[]{"timesTriggered"}, new Object[]{Integer.valueOf(props.getInt2())});
    }
}
