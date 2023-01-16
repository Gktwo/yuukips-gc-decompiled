package p001ch.qos.logback.core.util;

import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import p001ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.util.JNDIUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/JNDIUtil.class */
public class JNDIUtil {
    static final String RESTRICTION_MSG = "JNDI name must start with java: but was ";

    public static Context getInitialContext() throws NamingException {
        return new InitialContext();
    }

    public static Context getInitialContext(Hashtable<?, ?> props) throws NamingException {
        return new InitialContext(props);
    }

    public static Object lookupObject(Context ctx, String name) throws NamingException {
        if (ctx == null || OptionHelper.isEmpty(name)) {
            return null;
        }
        jndiNameSecurityCheck(name);
        return ctx.lookup(name);
    }

    private static void jndiNameSecurityCheck(String name) throws NamingException {
        if (!name.startsWith(CoreConstants.JNDI_JAVA_NAMESPACE)) {
            throw new NamingException(RESTRICTION_MSG + name);
        }
    }

    public static String lookupString(Context ctx, String name) throws NamingException {
        return (String) lookupObject(ctx, name);
    }
}
