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
import org.quartz.JobDetail;
import org.quartz.impl.JobDetailImpl;

/* loaded from: grasscutter.jar:org/quartz/core/jmx/JobDetailSupport.class */
public class JobDetailSupport {
    private static final String COMPOSITE_TYPE_NAME = "JobDetail";
    private static final String COMPOSITE_TYPE_DESCRIPTION = "Job Execution Details";
    private static final CompositeType COMPOSITE_TYPE;
    private static final String TABULAR_TYPE_NAME = "JobDetail collection";
    private static final String TABULAR_TYPE_DESCRIPTION = "JobDetail collection";
    private static final TabularType TABULAR_TYPE;
    private static final String[] ITEM_NAMES = {"name", "group", "description", "jobClass", "jobDataMap", "durability", "shouldRecover"};
    private static final String[] ITEM_DESCRIPTIONS = {"name", "group", "description", "jobClass", "jobDataMap", "durability", "shouldRecover"};
    private static final OpenType[] ITEM_TYPES = {SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, SimpleType.STRING, JobDataMapSupport.TABULAR_TYPE, SimpleType.BOOLEAN, SimpleType.BOOLEAN};
    private static final String[] INDEX_NAMES = {"name", "group"};

    static {
        try {
            COMPOSITE_TYPE = new CompositeType(COMPOSITE_TYPE_NAME, COMPOSITE_TYPE_DESCRIPTION, ITEM_NAMES, ITEM_DESCRIPTIONS, ITEM_TYPES);
            TABULAR_TYPE = new TabularType("JobDetail collection", "JobDetail collection", COMPOSITE_TYPE, INDEX_NAMES);
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.quartz.impl.JobDetailImpl */
    /* JADX WARN: Multi-variable type inference failed */
    public static JobDetail newJobDetail(CompositeData cData) throws ClassNotFoundException {
        JobDetailImpl jobDetail = new JobDetailImpl();
        int i = 0 + 1;
        jobDetail.setName((String) cData.get(ITEM_NAMES[0]));
        int i2 = i + 1;
        jobDetail.setGroup((String) cData.get(ITEM_NAMES[i]));
        int i3 = i2 + 1;
        jobDetail.setDescription((String) cData.get(ITEM_NAMES[i2]));
        int i4 = i3 + 1;
        jobDetail.setJobClass(Class.forName((String) cData.get(ITEM_NAMES[i3])));
        int i5 = i4 + 1;
        jobDetail.setJobDataMap(JobDataMapSupport.newJobDataMap((TabularData) cData.get(ITEM_NAMES[i4])));
        int i6 = i5 + 1;
        jobDetail.setDurability(((Boolean) cData.get(ITEM_NAMES[i5])).booleanValue());
        int i7 = i6 + 1;
        jobDetail.setRequestsRecovery(((Boolean) cData.get(ITEM_NAMES[i6])).booleanValue());
        return jobDetail;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.quartz.impl.JobDetailImpl */
    /* JADX WARN: Multi-variable type inference failed */
    public static JobDetail newJobDetail(Map<String, Object> attrMap) throws ClassNotFoundException {
        JobDetailImpl jobDetail = new JobDetailImpl();
        int i = 0 + 1;
        jobDetail.setName((String) attrMap.get(ITEM_NAMES[0]));
        int i2 = i + 1;
        jobDetail.setGroup((String) attrMap.get(ITEM_NAMES[i]));
        int i3 = i2 + 1;
        jobDetail.setDescription((String) attrMap.get(ITEM_NAMES[i2]));
        int i4 = i3 + 1;
        jobDetail.setJobClass(Class.forName((String) attrMap.get(ITEM_NAMES[i3])));
        if (attrMap.containsKey(ITEM_NAMES[i4])) {
            jobDetail.setJobDataMap(JobDataMapSupport.newJobDataMap((Map) attrMap.get(ITEM_NAMES[i4])));
        }
        int i5 = i4 + 1;
        if (attrMap.containsKey(ITEM_NAMES[i5])) {
            jobDetail.setDurability(((Boolean) attrMap.get(ITEM_NAMES[i5])).booleanValue());
        }
        int i6 = i5 + 1;
        if (attrMap.containsKey(ITEM_NAMES[i6])) {
            jobDetail.setRequestsRecovery(((Boolean) attrMap.get(ITEM_NAMES[i6])).booleanValue());
        }
        int i7 = i6 + 1;
        return jobDetail;
    }

    public static CompositeData toCompositeData(JobDetail jobDetail) {
        try {
            return new CompositeDataSupport(COMPOSITE_TYPE, ITEM_NAMES, new Object[]{jobDetail.getKey().getName(), jobDetail.getKey().getGroup(), jobDetail.getDescription(), jobDetail.getJobClass().getName(), JobDataMapSupport.toTabularData(jobDetail.getJobDataMap()), Boolean.valueOf(jobDetail.isDurable()), Boolean.valueOf(jobDetail.requestsRecovery())});
        } catch (OpenDataException e) {
            throw new RuntimeException((Throwable) e);
        }
    }

    public static TabularData toTabularData(JobDetail[] jobDetails) {
        TabularData tData = new TabularDataSupport(TABULAR_TYPE);
        if (jobDetails != null) {
            ArrayList<CompositeData> list = new ArrayList<>();
            for (JobDetail jobDetail : jobDetails) {
                list.add(toCompositeData(jobDetail));
            }
            tData.putAll((CompositeData[]) list.toArray(new CompositeData[list.size()]));
        }
        return tData;
    }
}
