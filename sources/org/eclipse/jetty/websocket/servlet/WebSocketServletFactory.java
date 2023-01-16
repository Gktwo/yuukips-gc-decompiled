package org.eclipse.jetty.websocket.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.extensions.ExtensionFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/WebSocketServletFactory.class */
public interface WebSocketServletFactory {
    boolean acceptWebSocket(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException;

    boolean acceptWebSocket(WebSocketCreator webSocketCreator, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException;

    void start() throws Exception;

    void stop() throws Exception;

    Set<String> getAvailableExtensionNames();

    WebSocketCreator getCreator();

    @Deprecated
    ExtensionFactory getExtensionFactory();

    WebSocketPolicy getPolicy();

    boolean isUpgradeRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

    void register(Class<?> cls);

    void setCreator(WebSocketCreator webSocketCreator);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/servlet/WebSocketServletFactory$Loader.class */
    public static class Loader {
        static final String DEFAULT_IMPL = "org.eclipse.jetty.websocket.server.WebSocketServerFactory";

        public static WebSocketServletFactory load(ServletContext ctx, WebSocketPolicy policy) {
            try {
                return (WebSocketServletFactory) Class.forName(DEFAULT_IMPL, true, Thread.currentThread().getContextClassLoader()).getDeclaredConstructor(ServletContext.class, WebSocketPolicy.class).newInstance(ctx, policy);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Unable to load org.eclipse.jetty.websocket.server.WebSocketServerFactory", e);
            } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
                throw new RuntimeException("Unable to instantiate org.eclipse.jetty.websocket.server.WebSocketServerFactory", e2);
            }
        }
    }
}
