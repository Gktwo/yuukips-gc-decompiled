package org.eclipse.jetty.websocket.common.events.annotated;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Method;
import org.eclipse.jetty.websocket.api.Session;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/annotated/OptionalSessionCallableMethod.class */
public class OptionalSessionCallableMethod extends CallableMethod {
    private final boolean wantsSession;
    private final boolean streaming;

    public OptionalSessionCallableMethod(Class<?> pojo, Method method) {
        super(pojo, method);
        boolean foundConnection = false;
        boolean foundStreaming = false;
        if (this.paramTypes != null) {
            Class<?>[] clsArr = this.paramTypes;
            for (Class<?> paramType : clsArr) {
                foundConnection = Session.class.isAssignableFrom(paramType) ? true : foundConnection;
                if (Reader.class.isAssignableFrom(paramType) || InputStream.class.isAssignableFrom(paramType)) {
                    foundStreaming = true;
                }
            }
        }
        this.wantsSession = foundConnection;
        this.streaming = foundStreaming;
    }

    public void call(Object obj, Session connection, Object... args) {
        if (this.wantsSession) {
            Object[] fullArgs = new Object[args.length + 1];
            fullArgs[0] = connection;
            System.arraycopy(args, 0, fullArgs, 1, args.length);
            call(obj, fullArgs);
            return;
        }
        call(obj, args);
    }

    public boolean isSessionAware() {
        return this.wantsSession;
    }

    public boolean isStreaming() {
        return this.streaming;
    }

    @Override // org.eclipse.jetty.websocket.common.events.annotated.CallableMethod
    public String toString() {
        return String.format("%s[pojo=%s,method=%s,wantsSession=%b,streaming=%s]", getClass().getSimpleName(), this.pojo.getName(), this.method.toGenericString(), Boolean.valueOf(this.wantsSession), Boolean.valueOf(this.streaming));
    }
}
