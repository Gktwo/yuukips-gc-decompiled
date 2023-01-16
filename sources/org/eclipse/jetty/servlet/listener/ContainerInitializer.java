package org.eclipse.jetty.servlet.listener;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/listener/ContainerInitializer.class */
public final class ContainerInitializer {
    public static ServletContainerInitializerServletContextListener asContextListener(ServletContainerInitializer sci) {
        return new ServletContainerInitializerServletContextListener(sci);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/listener/ContainerInitializer$ServletContainerInitializerServletContextListener.class */
    public static class ServletContainerInitializerServletContextListener implements ServletContextListener {
        private final ServletContainerInitializer sci;
        private Set<String> classNames;
        private Set<Class<?>> classes = new HashSet();
        private Consumer<ServletContext> afterStartupConsumer;

        public ServletContainerInitializerServletContextListener(ServletContainerInitializer sci) {
            this.sci = sci;
        }

        public ServletContainerInitializerServletContextListener addClasses(String... classNames) {
            if (this.classNames == null) {
                this.classNames = new HashSet();
            }
            this.classNames.addAll(Arrays.asList(classNames));
            return this;
        }

        public ServletContainerInitializerServletContextListener addClasses(Class<?>... classes) {
            this.classes.addAll(Arrays.asList(classes));
            return this;
        }

        public ServletContainerInitializerServletContextListener afterStartup(Consumer<ServletContext> consumer) {
            this.afterStartupConsumer = consumer;
            return this;
        }

        @Override // javax.servlet.ServletContextListener
        public void contextInitialized(ServletContextEvent sce) {
            ServletContext servletContext = sce.getServletContext();
            try {
                this.sci.onStartup(getClasses(), servletContext);
                if (this.afterStartupConsumer != null) {
                    this.afterStartupConsumer.accept(servletContext);
                }
            } catch (RuntimeException rte) {
                throw rte;
            } catch (Throwable cause) {
                throw new RuntimeException(cause);
            }
        }

        public Set<Class<?>> getClasses() {
            if (this.classNames != null && !this.classNames.isEmpty()) {
                ClassLoader cl = Thread.currentThread().getContextClassLoader();
                for (String className : this.classNames) {
                    try {
                        this.classes.add(cl.loadClass(className));
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException("Unable to find class: " + className, e);
                    }
                }
            }
            return this.classes;
        }

        @Override // javax.servlet.ServletContextListener
        public void contextDestroyed(ServletContextEvent sce) {
        }
    }
}
