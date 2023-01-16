package com.mchange.p009v2.c3p0.debug;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.reflect.ReflectUtils;
import com.mchange.p009v2.sql.filter.FilterConnection;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLWarning;

/* renamed from: com.mchange.v2.c3p0.debug.AfterCloseLoggingConnectionWrapper */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/debug/AfterCloseLoggingConnectionWrapper.class */
public class AfterCloseLoggingConnectionWrapper extends FilterConnection {
    static final MLogger logger = MLog.getLogger(AfterCloseLoggingConnectionWrapper.class);

    public static Connection wrap(Connection inner) {
        try {
            return (Connection) ReflectUtils.findProxyConstructor(AfterCloseLoggingConnectionWrapper.class.getClassLoader(), Connection.class).newInstance(new AfterCloseLoggingInvocationHandler(inner));
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.SEVERE)) {
                logger.log(MLevel.SEVERE, "An unexpected Exception occured while trying to instantiate a dynamic proxy.", (Throwable) e);
            }
            throw new RuntimeException(e);
        }
    }

    /* renamed from: com.mchange.v2.c3p0.debug.AfterCloseLoggingConnectionWrapper$AfterCloseLoggingInvocationHandler */
    /* loaded from: grasscutter.jar:com/mchange/v2/c3p0/debug/AfterCloseLoggingConnectionWrapper$AfterCloseLoggingInvocationHandler.class */
    private static class AfterCloseLoggingInvocationHandler implements InvocationHandler {
        final Connection inner;
        volatile SQLWarning closeStackTrace = null;

        AfterCloseLoggingInvocationHandler(Connection inner) {
            this.inner = inner;
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            if ("close".equals(method.getName()) && this.closeStackTrace == null) {
                this.closeStackTrace = new SQLWarning("DEBUG STACK TRACE -- " + this.inner + ".close() first-call stack trace.");
            } else if (this.closeStackTrace != null) {
                if (AfterCloseLoggingConnectionWrapper.logger.isLoggable(MLevel.INFO)) {
                    AfterCloseLoggingConnectionWrapper.logger.log(MLevel.INFO, String.format("Method '%s' called after call to Connection close().", method));
                }
                if (AfterCloseLoggingConnectionWrapper.logger.isLoggable(MLevel.FINE)) {
                    AfterCloseLoggingConnectionWrapper.logger.log(MLevel.FINE, "After-close() method call stack trace:", (Throwable) new SQLWarning("DEBUG STACK TRACE -- ILLEGAL use of " + this.inner + " after call to close()."));
                    AfterCloseLoggingConnectionWrapper.logger.log(MLevel.FINE, "Original close() call stack trace:", (Throwable) this.closeStackTrace);
                }
            }
            return method.invoke(this.inner, args);
        }
    }
}
