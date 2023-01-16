package org.quartz.plugins.management;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.SchedulerPlugin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/plugins/management/ShutdownHookPlugin.class */
public class ShutdownHookPlugin implements SchedulerPlugin {
    private boolean cleanShutdown = true;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public boolean isCleanShutdown() {
        return this.cleanShutdown;
    }

    public void setCleanShutdown(boolean b) {
        this.cleanShutdown = b;
    }

    protected Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void initialize(String name, final Scheduler scheduler, ClassLoadHelper classLoadHelper) throws SchedulerException {
        getLog().info("Registering Quartz shutdown hook.");
        Runtime.getRuntime().addShutdownHook(new Thread("Quartz Shutdown-Hook " + scheduler.getSchedulerName()) { // from class: org.quartz.plugins.management.ShutdownHookPlugin.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                ShutdownHookPlugin.this.getLog().info("Shutting down Quartz...");
                try {
                    scheduler.shutdown(ShutdownHookPlugin.this.isCleanShutdown());
                } catch (SchedulerException e) {
                    ShutdownHookPlugin.this.getLog().info("Error shutting down Quartz: " + e.getMessage(), (Throwable) e);
                }
            }
        });
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void start() {
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void shutdown() {
    }
}
