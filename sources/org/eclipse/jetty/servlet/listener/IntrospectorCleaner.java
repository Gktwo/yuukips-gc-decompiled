package org.eclipse.jetty.servlet.listener;

import java.beans.Introspector;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/listener/IntrospectorCleaner.class */
public class IntrospectorCleaner implements ServletContextListener {
    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent sce) {
        Introspector.flushCaches();
    }
}
