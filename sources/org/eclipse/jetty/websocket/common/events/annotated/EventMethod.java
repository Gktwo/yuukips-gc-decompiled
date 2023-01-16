package org.eclipse.jetty.websocket.common.events.annotated;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.WebSocketException;
import org.eclipse.jetty.websocket.api.util.QuoteUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/annotated/EventMethod.class */
public class EventMethod {
    private static final Logger LOG = Log.getLogger(EventMethod.class);
    protected Class<?> pojo;
    protected Method method;
    private boolean hasSession = false;
    private boolean isStreaming = false;
    private Class<?>[] paramTypes;

    private static Object[] dropFirstArg(Object[] args) {
        if (args.length == 1) {
            return new Object[0];
        }
        Object[] ret = new Object[args.length - 1];
        System.arraycopy(args, 1, ret, 0, ret.length);
        return ret;
    }

    public EventMethod(Class<?> pojo, Method method) {
        this.pojo = pojo;
        this.paramTypes = method.getParameterTypes();
        this.method = method;
        identifyPresentParamTypes();
    }

    public EventMethod(Class<?> pojo, String methodName, Class<?>... paramTypes) {
        try {
            this.pojo = pojo;
            this.paramTypes = paramTypes;
            this.method = pojo.getMethod(methodName, paramTypes);
            identifyPresentParamTypes();
        } catch (NoSuchMethodException | SecurityException e) {
            LOG.warn("Cannot use method {}({}): {}", methodName, paramTypes, e.getMessage());
            this.method = null;
        }
    }

    public void call(Object obj, Object... args) {
        if (this.pojo == null || this.method == null) {
            LOG.warn("Cannot execute call: pojo={}, method={}", this.pojo, this.method);
        } else if (obj == null) {
            LOG.warn("Cannot call {} on null object", this.method);
        } else if (args.length > this.paramTypes.length) {
            call(obj, dropFirstArg(args));
        } else if (args.length < this.paramTypes.length) {
            throw new IllegalArgumentException("Call arguments length [" + args.length + "] must always be greater than or equal to captured args length [" + this.paramTypes.length + "]");
        } else {
            try {
                this.method.invoke(obj, args);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                throw new WebSocketException(String.format("Cannot call method %s on %s with args: %s", this.method, this.pojo, QuoteUtil.join(args, ",")), e);
            }
        }
    }

    public Method getMethod() {
        return this.method;
    }

    protected Class<?>[] getParamTypes() {
        return this.paramTypes;
    }

    private void identifyPresentParamTypes() {
        this.hasSession = false;
        this.isStreaming = false;
        if (this.paramTypes != null) {
            Class<?>[] clsArr = this.paramTypes;
            for (Class<?> paramType : clsArr) {
                if (Session.class.isAssignableFrom(paramType)) {
                    this.hasSession = true;
                }
                if (Reader.class.isAssignableFrom(paramType) || InputStream.class.isAssignableFrom(paramType)) {
                    this.isStreaming = true;
                }
            }
        }
    }

    public boolean isHasSession() {
        return this.hasSession;
    }

    public boolean isStreaming() {
        return this.isStreaming;
    }
}
