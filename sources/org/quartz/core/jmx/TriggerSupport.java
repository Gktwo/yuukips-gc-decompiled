package org.quartz.core.jmx;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.management.openmbean.CompositeData;
import javax.management.openmbean.CompositeDataSupport;
import javax.management.openmbean.CompositeType;
import javax.management.openmbean.OpenDataException;
import javax.management.openmbean.OpenType;
import javax.management.openmbean.SimpleType;
import javax.management.openmbean.TabularData;
import javax.management.openmbean.TabularDataSupport;
import javax.management.openmbean.TabularType;
import org.quartz.JobKey;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.spi.MutableTrigger;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/core/jmx/TriggerSupport.class */
public class TriggerSupport {
    private static final String COMPOSITE_TYPE_NAME = "Trigger";
    private static final String COMPOSITE_TYPE_DESCRIPTION = "Trigger Details";
    private static final CompositeType COMPOSITE_TYPE;
    private static final String TABULAR_TYPE_NAME = "Trigger collection";
    private static final String TABULAR_TYPE_DESCRIPTION = "Trigger collection";
    private static final TabularType TABULAR_TYPE;
    private static final String[] ITEM_NAMES = {"name", "group", "jobName", "jobGroup", "description", "jobDataMap", "calendarName", "fireInstanceId", "misfireInstruction", "priority", "startTime", "endTime", "nextFireTime", "previousFireTime", "finalFireTime"};
    private static final String[] ITEM_DESCRIPTIONS = {"name", "group", "jobName", "jobGroup", "description", "jobDataMap", "calendarName", "fireInstanceId", "misfireInstruction", "priority", "startTime", "endTime", "nextFireTime", "previousFireTime", "finalFireTime"};
    private static final OpenType[] ITEM_TYPES = {SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, JobDataMapSupport.TABULAR_TYPE, SimpleType.STRING, SimpleType.STRING, SimpleType.INTEGER, SimpleType.INTEGER, SimpleType.DATE, SimpleType.DATE, SimpleType.DATE, SimpleType.DATE, SimpleType.DATE};
    private static final String[] INDEX_NAMES = {"name", "group"};

    static {
        try {
            COMPOSITE_TYPE = new CompositeType(COMPOSITE_TYPE_NAME, COMPOSITE_TYPE_DESCRIPTION, ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
            TABULAR_TYPE = new TabularType("Trigger collection", "Trigger collection", COMPOSITE_TYPE, INDEX_NAMES);
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static String[] getItemNames() {
        return ITEM_NAMES;
    }

    public static String[] getItemDescriptions() {
        return ITEM_DESCRIPTIONS;
    }

    public static OpenType[] getItemTypes() {
        return ITEM_TYPES;
    }

    public String[] getIndexNames() {
        return INDEX_NAMES;
    }

    public static CompositeData toCompositeData(Trigger trigger) {
        try {
            return new CompositeDataSupport(COMPOSITE_TYPE, ITEM_NAMES, new Object[]{trigger.getKey().getName(), trigger.getKey().getGroup(), trigger.getJobKey().getName(), trigger.getJobKey().getGroup(), trigger.getDescription(), JobDataMapSupport.toTabularData(trigger.getJobDataMap()), trigger.getCalendarName(), ((OperableTrigger) trigger).getFireInstanceId(), Integer.valueOf(trigger.getMisfireInstruction()), Integer.valueOf(trigger.getPriority()), trigger.getStartTime(), trigger.getEndTime(), trigger.getNextFireTime(), trigger.getPreviousFireTime(), trigger.getFinalFireTime()});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static TabularData toTabularData(List<? extends Trigger> triggers) {
        TabularData tData = new TabularDataSupport(TABULAR_TYPE);
        if (triggers != null) {
            ArrayList<CompositeData> list = new ArrayList<>();
            for (Trigger trigger : triggers) {
                list.add(toCompositeData(trigger));
            }
            tData.putAll((CompositeData[]) list.toArray(new CompositeData[list.size()]));
        }
        return tData;
    }

    public static List<CompositeData> toCompositeList(List<? extends Trigger> triggers) {
        List<CompositeData> result = new ArrayList<>();
        for (Trigger trigger : triggers) {
            CompositeData cData = toCompositeData(trigger);
            if (cData != null) {
                result.add(cData);
            }
        }
        return result;
    }

    public static void initializeTrigger(MutableTrigger trigger, CompositeData cData) {
        Date startTime;
        trigger.setDescription((String) cData.get("description"));
        trigger.setCalendarName((String) cData.get("calendarName"));
        if (cData.containsKey("priority")) {
            trigger.setPriority(((Integer) cData.get("priority")).intValue());
        }
        if (cData.containsKey("jobDataMap")) {
            trigger.setJobDataMap(JobDataMapSupport.newJobDataMap((TabularData) cData.get("jobDataMap")));
        }
        if (cData.containsKey("startTime")) {
            startTime = (Date) cData.get("startTime");
        } else {
            startTime = new Date();
        }
        trigger.setStartTime(startTime);
        trigger.setEndTime((Date) cData.get("endTime"));
        if (cData.containsKey("misfireInstruction")) {
            trigger.setMisfireInstruction(((Integer) cData.get("misfireInstruction")).intValue());
        }
        trigger.setKey(new TriggerKey((String) cData.get("name"), (String) cData.get("group")));
        trigger.setJobKey(new JobKey((String) cData.get("jobName"), (String) cData.get("jobGroup")));
    }

    public static void initializeTrigger(MutableTrigger trigger, Map<String, Object> attrMap) {
        Date startTime;
        trigger.setDescription((String) attrMap.get("description"));
        trigger.setCalendarName((String) attrMap.get("calendarName"));
        if (attrMap.containsKey("priority")) {
            trigger.setPriority(((Integer) attrMap.get("priority")).intValue());
        }
        if (attrMap.containsKey("jobDataMap")) {
            trigger.setJobDataMap(JobDataMapSupport.newJobDataMap((Map) attrMap.get("jobDataMap")));
        }
        if (attrMap.containsKey("startTime")) {
            startTime = (Date) attrMap.get("startTime");
        } else {
            startTime = new Date();
        }
        trigger.setStartTime(startTime);
        if (attrMap.containsKey("endTime")) {
            trigger.setEndTime((Date) attrMap.get("endTime"));
        }
        if (attrMap.containsKey("misfireInstruction")) {
            trigger.setMisfireInstruction(((Integer) attrMap.get("misfireInstruction")).intValue());
        }
        trigger.setKey(new TriggerKey((String) attrMap.get("name"), (String) attrMap.get("group")));
        trigger.setJobKey(new JobKey((String) attrMap.get("jobName"), (String) attrMap.get("jobGroup")));
    }

    public static OperableTrigger newTrigger(CompositeData cData) throws ParseException {
        OperableTrigger result;
        if (cData.containsKey("cronExpression")) {
            result = CronTriggerSupport.newTrigger(cData);
        } else {
            result = SimpleTriggerSupport.newTrigger(cData);
        }
        return result;
    }

    public static OperableTrigger newTrigger(Map<String, Object> attrMap) throws ParseException {
        OperableTrigger result;
        if (attrMap.containsKey("cronExpression")) {
            result = CronTriggerSupport.newTrigger(attrMap);
        } else {
            result = SimpleTriggerSupport.newTrigger(attrMap);
        }
        return result;
    }
}
