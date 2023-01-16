package org.quartz.p026ee.jmx.jboss;

import org.jboss.system.ServiceMBean;

/* renamed from: org.quartz.ee.jmx.jboss.QuartzServiceMBean */
/* loaded from: grasscutter.jar:org/quartz/ee/jmx/jboss/QuartzServiceMBean.class */
public interface QuartzServiceMBean extends ServiceMBean {
    void setJndiName(String str) throws Exception;

    String getJndiName();

    void setProperties(String str);

    void setPropertiesFile(String str);

    void setStartScheduler(boolean z);
}
