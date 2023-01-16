package org.quartz.p026ee.jmx.jboss;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.jboss.naming.NonSerializableFactory;
import org.jboss.system.ServiceMBeanSupport;
import org.quartz.Scheduler;
import org.quartz.SchedulerConfigException;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/* renamed from: org.quartz.ee.jmx.jboss.QuartzService */
/* loaded from: grasscutter.jar:org/quartz/ee/jmx/jboss/QuartzService.class */
public class QuartzService extends ServiceMBeanSupport implements QuartzServiceMBean {
    private StdSchedulerFactory schedulerFactory;
    private boolean startScheduler = true;
    private boolean error = false;
    private boolean usePropertiesFile = false;
    private String propertiesFile = "";
    private boolean useProperties = false;
    private Properties properties = new Properties();
    private String jndiName = "Quartz";

    @Override // org.quartz.p026ee.jmx.jboss.QuartzServiceMBean
    public void setJndiName(String jndiName) throws Exception {
        String oldName = this.jndiName;
        this.jndiName = jndiName;
        if (getState() == 3) {
            unbind(oldName);
            try {
                rebind();
            } catch (NamingException ne) {
                this.log.error("Failed to rebind Scheduler", ne);
                throw new SchedulerConfigException("Failed to rebind Scheduler - ", ne);
            }
        }
    }

    @Override // org.quartz.p026ee.jmx.jboss.QuartzServiceMBean
    public String getJndiName() {
        return this.jndiName;
    }

    public String getName() {
        return "QuartzService(" + this.jndiName + ")";
    }

    @Override // org.quartz.p026ee.jmx.jboss.QuartzServiceMBean
    public void setProperties(String properties) {
        if (this.usePropertiesFile) {
            this.log.error("Must specify only one of 'Properties' or 'PropertiesFile'");
            this.error = true;
            return;
        }
        this.useProperties = true;
        try {
            ByteArrayInputStream bais = new ByteArrayInputStream(properties.replace(File.separator, "/").getBytes());
            this.properties = new Properties();
            this.properties.load(bais);
        } catch (IOException e) {
        }
    }

    public String getProperties() {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            this.properties.store(baos, "");
            return new String(baos.toByteArray());
        } catch (IOException e) {
            return "";
        }
    }

    @Override // org.quartz.p026ee.jmx.jboss.QuartzServiceMBean
    public void setPropertiesFile(String propertiesFile) {
        if (this.useProperties) {
            this.log.error("Must specify only one of 'Properties' or 'PropertiesFile'");
            this.error = true;
            return;
        }
        this.usePropertiesFile = true;
        this.propertiesFile = propertiesFile;
    }

    public String getPropertiesFile() {
        return this.propertiesFile;
    }

    @Override // org.quartz.p026ee.jmx.jboss.QuartzServiceMBean
    public void setStartScheduler(boolean startScheduler) {
        this.startScheduler = startScheduler;
    }

    public boolean getStartScheduler() {
        return this.startScheduler;
    }

    public void createService() throws Exception {
        this.log.info("Create QuartzService(" + this.jndiName + ")...");
        if (this.error) {
            this.log.error("Must specify only one of 'Properties' or 'PropertiesFile'");
            throw new Exception("Must specify only one of 'Properties' or 'PropertiesFile'");
        }
        this.schedulerFactory = new StdSchedulerFactory();
        try {
            if (this.useProperties) {
                this.schedulerFactory.initialize(this.properties);
            }
            if (this.usePropertiesFile) {
                this.schedulerFactory.initialize(this.propertiesFile);
            }
            this.log.info("QuartzService(" + this.jndiName + ") created.");
        } catch (Exception e) {
            this.log.error("Failed to initialize Scheduler", e);
            throw new SchedulerConfigException("Failed to initialize Scheduler - ", e);
        }
    }

    public void destroyService() throws Exception {
        this.log.info("Destroy QuartzService(" + this.jndiName + ")...");
        this.schedulerFactory = null;
        this.log.info("QuartzService(" + this.jndiName + ") destroyed.");
    }

    public void startService() throws Exception {
        this.log.info("Start QuartzService(" + this.jndiName + ")...");
        try {
            rebind();
            try {
                Scheduler scheduler = this.schedulerFactory.getScheduler();
                if (this.startScheduler) {
                    scheduler.start();
                } else {
                    this.log.info("Skipping starting the scheduler (will not run jobs).");
                }
                this.log.info("QuartzService(" + this.jndiName + ") started.");
            } catch (Exception e) {
                this.log.error("Failed to start Scheduler", e);
                throw new SchedulerConfigException("Failed to start Scheduler - ", e);
            }
        } catch (NamingException ne) {
            this.log.error("Failed to rebind Scheduler", ne);
            throw new SchedulerConfigException("Failed to rebind Scheduler - ", ne);
        }
    }

    public void stopService() throws Exception {
        this.log.info("Stop QuartzService(" + this.jndiName + ")...");
        try {
            this.schedulerFactory.getScheduler().shutdown();
            unbind(this.jndiName);
            this.log.info("QuartzService(" + this.jndiName + ") stopped.");
        } catch (Exception e) {
            this.log.error("Failed to shutdown Scheduler", e);
            throw new SchedulerConfigException("Failed to shutdown Scheduler - ", e);
        }
    }

    private void rebind() throws NamingException, SchedulerException {
        InitialContext rootCtx = null;
        try {
            rootCtx = new InitialContext();
            NonSerializableFactory.rebind(rootCtx.getNameParser("").parse(this.jndiName), this.schedulerFactory.getScheduler(), true);
            if (rootCtx != null) {
                try {
                    rootCtx.close();
                } catch (NamingException e) {
                }
            }
        } catch (Throwable th) {
            if (rootCtx != null) {
                try {
                    rootCtx.close();
                } catch (NamingException e2) {
                }
            }
            throw th;
        }
    }

    private void unbind(String name) {
        InitialContext rootCtx = null;
        try {
            try {
                rootCtx = new InitialContext();
                rootCtx.unbind(name);
                NonSerializableFactory.unbind(name);
                if (rootCtx != null) {
                    try {
                        rootCtx.close();
                    } catch (NamingException e) {
                    }
                }
            } catch (NamingException e2) {
                this.log.warn("Failed to unbind scheduler with jndiName: " + name, e2);
                if (rootCtx != null) {
                    try {
                        rootCtx.close();
                    } catch (NamingException e3) {
                    }
                }
            }
        } catch (Throwable th) {
            if (rootCtx != null) {
                try {
                    rootCtx.close();
                } catch (NamingException e4) {
                }
            }
            throw th;
        }
    }
}
