package org.quartz.p026ee.servlet;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/* renamed from: org.quartz.ee.servlet.QuartzInitializerServlet */
/* loaded from: grasscutter.jar:org/quartz/ee/servlet/QuartzInitializerServlet.class */
public class QuartzInitializerServlet extends HttpServlet {
    private static final long serialVersionUID = 1;
    public static final String QUARTZ_FACTORY_KEY = "org.quartz.impl.StdSchedulerFactory.KEY";
    private boolean performShutdown = true;
    private boolean waitOnShutdown = false;
    private transient Scheduler scheduler = null;

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void init(ServletConfig cfg) throws ServletException {
        init(cfg);
        log("Quartz Initializer Servlet loaded, initializing Scheduler...");
        try {
            String configFile = cfg.getInitParameter("config-file");
            String shutdownPref = cfg.getInitParameter("shutdown-on-unload");
            if (shutdownPref != null) {
                this.performShutdown = Boolean.valueOf(shutdownPref).booleanValue();
            }
            String shutdownWaitPref = cfg.getInitParameter("wait-on-shutdown");
            if (shutdownPref != null) {
                this.waitOnShutdown = Boolean.valueOf(shutdownWaitPref).booleanValue();
            }
            StdSchedulerFactory factory = getSchedulerFactory(configFile);
            this.scheduler = factory.getScheduler();
            String startOnLoad = cfg.getInitParameter("start-scheduler-on-load");
            int startDelay = 0;
            String startDelayS = cfg.getInitParameter("start-delay-seconds");
            if (startDelayS != null && startDelayS.trim().length() > 0) {
                try {
                    startDelay = Integer.parseInt(startDelayS);
                } catch (Exception e) {
                    log("Cannot parse value of 'start-delay-seconds' to an integer: " + startDelayS + ", defaulting to 5 seconds.", e);
                    startDelay = 5;
                }
            }
            if (startOnLoad != null && !Boolean.valueOf(startOnLoad).booleanValue()) {
                log("Scheduler has not been started. Use scheduler.start()");
            } else if (startDelay <= 0) {
                this.scheduler.start();
                log("Scheduler has been started...");
            } else {
                this.scheduler.startDelayed(startDelay);
                log("Scheduler will start in " + startDelay + " seconds.");
            }
            String factoryKey = cfg.getInitParameter("servlet-context-factory-key");
            if (factoryKey == null) {
                factoryKey = "org.quartz.impl.StdSchedulerFactory.KEY";
            }
            log("Storing the Quartz Scheduler Factory in the servlet context at key: " + factoryKey);
            cfg.getServletContext().setAttribute(factoryKey, factory);
            String servletCtxtKey = cfg.getInitParameter("scheduler-context-servlet-context-key");
            if (servletCtxtKey != null) {
                log("Storing the ServletContext in the scheduler context at key: " + servletCtxtKey);
                this.scheduler.getContext().put(servletCtxtKey, (Object) cfg.getServletContext());
            }
        } catch (Exception e2) {
            log("Quartz Scheduler failed to initialize: " + e2.toString());
            throw new ServletException(e2);
        }
    }

    protected StdSchedulerFactory getSchedulerFactory(String configFile) throws SchedulerException {
        StdSchedulerFactory factory;
        if (configFile != null) {
            factory = new StdSchedulerFactory(configFile);
        } else {
            factory = new StdSchedulerFactory();
        }
        return factory;
    }

    @Override // javax.servlet.GenericServlet, javax.servlet.Servlet
    public void destroy() {
        if (this.performShutdown) {
            try {
                if (this.scheduler != null) {
                    this.scheduler.shutdown(this.waitOnShutdown);
                }
            } catch (Exception e) {
                log("Quartz Scheduler failed to shutdown cleanly: " + e.toString());
                e.printStackTrace();
            }
            log("Quartz Scheduler successful shutdown.");
        }
    }

    @Override // javax.servlet.http.HttpServlet
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(403);
    }

    @Override // javax.servlet.http.HttpServlet
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendError(403);
    }
}
