package org.eclipse.jetty.websocket.server;

import java.util.Set;
import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.listener.ContainerInitializer;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/NativeWebSocketServletContainerInitializer.class */
public class NativeWebSocketServletContainerInitializer implements ServletContainerInitializer {
    public static final String ATTR_KEY = NativeWebSocketConfiguration.class.getName();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/server/NativeWebSocketServletContainerInitializer$Configurator.class */
    public interface Configurator {
        void accept(ServletContext servletContext, NativeWebSocketConfiguration nativeWebSocketConfiguration);
    }

    public static NativeWebSocketConfiguration initialize(ServletContextHandler context) {
        NativeWebSocketConfiguration configuration = (NativeWebSocketConfiguration) context.getAttribute(ATTR_KEY);
        if (configuration == null) {
            configuration = new NativeWebSocketConfiguration(context.getServletContext());
            context.setAttribute(ATTR_KEY, configuration);
            context.addManaged(configuration);
        }
        return configuration;
    }

    public static void configure(ServletContextHandler context, Configurator configurator) {
        context.addEventListener(ContainerInitializer.asContextListener(new NativeWebSocketServletContainerInitializer()).afterStartup(servletContext -> {
            if (configurator != null) {
                configurator.accept(servletContext, (NativeWebSocketConfiguration) servletContext.getAttribute(ATTR_KEY));
            }
        }));
    }

    @Deprecated
    public static NativeWebSocketConfiguration getDefaultFrom(ServletContext context) {
        ServletContextHandler handler = ServletContextHandler.getServletContextHandler(context);
        if (handler != null) {
            return initialize(handler);
        }
        throw new IllegalStateException("Unable to find ServletContextHandler for provided ServletContext");
    }

    @Override // javax.servlet.ServletContainerInitializer
    public void onStartup(Set<Class<?>> c, ServletContext context) {
        ServletContextHandler handler = ServletContextHandler.getServletContextHandler(context);
        if (handler == null) {
            throw new IllegalStateException("Unable to find ServletContextHandler for provided ServletContext");
        }
        initialize(handler);
    }
}
