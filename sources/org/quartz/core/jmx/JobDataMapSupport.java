package org.quartz.core.jmx;

import java.util.ArrayList;
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
import org.quartz.JobDataMap;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:org/quartz/core/jmx/JobDataMapSupport.class */
public class JobDataMapSupport {
    private static final String typeName = "JobDataMap";
    private static final String[] keyValue = {Action.KEY_ATTRIBUTE, "value"};
    private static final OpenType[] openTypes = {SimpleType.STRING, SimpleType.STRING};
    private static final CompositeType rowType;
    public static final TabularType TABULAR_TYPE;

    static {
        try {
            rowType = new CompositeType(typeName, typeName, keyValue, keyValue, openTypes);
            TABULAR_TYPE = new TabularType(typeName, typeName, rowType, new String[]{Action.KEY_ATTRIBUTE});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static JobDataMap newJobDataMap(TabularData tabularData) {
        JobDataMap jobDataMap = new JobDataMap();
        if (tabularData != null) {
            for (CompositeData cData : tabularData.values()) {
                jobDataMap.put((String) cData.get(Action.KEY_ATTRIBUTE), (String) cData.get("value"));
            }
        }
        return jobDataMap;
    }

    public static JobDataMap newJobDataMap(Map<String, Object> map) {
        JobDataMap jobDataMap = new JobDataMap();
        if (map != null) {
            for (String key : map.keySet()) {
                jobDataMap.put(key, map.get(key));
            }
        }
        return jobDataMap;
    }

    public static CompositeData toCompositeData(String key, String value) {
        try {
            return new CompositeDataSupport(rowType, keyValue, new Object[]{key, value});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static TabularData toTabularData(JobDataMap jobDataMap) {
        TabularData tData = new TabularDataSupport(TABULAR_TYPE);
        ArrayList<CompositeData> list = new ArrayList<>();
        for (String key : jobDataMap.keySet()) {
            list.add(toCompositeData(key, String.valueOf(jobDataMap.get(key))));
        }
        tData.putAll((CompositeData[]) list.toArray(new CompositeData[list.size()]));
        return tData;
    }
}
