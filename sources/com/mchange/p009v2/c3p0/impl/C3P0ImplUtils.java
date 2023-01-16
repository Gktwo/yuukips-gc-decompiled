package com.mchange.p009v2.c3p0.impl;

import com.mchange.lang.ByteUtils;
import com.mchange.p006v1.identicator.IdentityHashCodeIdenticator;
import com.mchange.p009v2.c3p0.cfg.C3P0Config;
import com.mchange.p009v2.encounter.EncounterCounter;
import com.mchange.p009v2.encounter.EncounterUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.log.jdk14logging.ForwardingLogger;
import com.mchange.p009v2.ser.SerializableUtils;
import com.mchange.p009v2.sql.SqlUtils;
import com.mchange.p009v2.uid.UidUtils;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;
import org.eclipse.jetty.util.security.Constraint;
import org.quartz.impl.StdSchedulerFactory;

/* renamed from: com.mchange.v2.c3p0.impl.C3P0ImplUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/C3P0ImplUtils.class */
public final class C3P0ImplUtils {
    private static final boolean CONDITIONAL_LONG_TOKENS = false;
    static final MLogger logger = MLog.getLogger(C3P0ImplUtils.class);
    public static final DbAuth NULL_AUTH = new DbAuth(null, null);
    public static final Object[] NOARGS = new Object[0];
    public static final Logger PARENT_LOGGER = new ForwardingLogger(MLog.getLogger("com.mchange.v2.c3p0"), null);
    private static final EncounterCounter ID_TOKEN_COUNTER = createEncounterCounter();
    public static final String VMID_PROPKEY = "com.mchange.v2.c3p0.VMID";
    private static final String VMID_PFX;
    static String connectionTesterClassName;
    private static final String HASM_HEADER = "HexAsciiSerializedMap";

    static {
        String vmid = C3P0Config.getPropsFileConfigProperty(VMID_PROPKEY);
        if (vmid != null) {
            String vmid2 = vmid.trim();
            if (!vmid2.equals("") && !vmid2.equals(StdSchedulerFactory.AUTO_GENERATE_INSTANCE_ID)) {
                if (vmid2.equals(Constraint.NONE)) {
                    VMID_PFX = "";
                } else {
                    VMID_PFX = vmid2 + "|";
                }
                connectionTesterClassName = null;
            }
        }
        VMID_PFX = UidUtils.VM_ID + '|';
        connectionTesterClassName = null;
    }

    private static EncounterCounter createEncounterCounter() {
        return EncounterUtils.syncWrap(EncounterUtils.createWeak(IdentityHashCodeIdenticator.INSTANCE));
    }

    public static String allocateIdentityToken(Object o) {
        if (o == null) {
            return null;
        }
        String shortIdToken = Integer.toString(System.identityHashCode(o), 16);
        StringBuffer sb = new StringBuffer(128);
        sb.append(VMID_PFX);
        if (ID_TOKEN_COUNTER != null) {
            long count = ID_TOKEN_COUNTER.encounter(shortIdToken);
            if (count > 0) {
                sb.append(shortIdToken);
                sb.append('#');
                sb.append(count);
                return sb.toString().intern();
            }
        }
        sb.append(shortIdToken);
        return sb.toString().intern();
    }

    public static DbAuth findAuth(Object o) throws SQLException {
        Method readMethod;
        if (o == null) {
            return NULL_AUTH;
        }
        String user = null;
        String password = null;
        String overrideDefaultUser = null;
        String overrideDefaultPassword = null;
        try {
            PropertyDescriptor[] pds = Introspector.getBeanInfo(o.getClass()).getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                Class propCl = pd.getPropertyType();
                String propName = pd.getName();
                if (propCl == String.class && (readMethod = pd.getReadMethod()) != null) {
                    String value = (String) readMethod.invoke(o, NOARGS);
                    if ("user".equals(propName)) {
                        user = value;
                    } else if ("password".equals(propName)) {
                        password = value;
                    } else if ("overrideDefaultUser".equals(propName)) {
                        overrideDefaultUser = value;
                    } else if ("overrideDefaultPassword".equals(propName)) {
                        overrideDefaultPassword = value;
                    }
                }
            }
            if (overrideDefaultUser != null) {
                return new DbAuth(overrideDefaultUser, overrideDefaultPassword);
            }
            if (user != null) {
                return new DbAuth(user, password);
            }
            return NULL_AUTH;
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "An exception occurred while trying to extract the default authentification info from a bean.", (Throwable) e);
            }
            throw SqlUtils.toSQLException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public static void resetTxnState(Connection pCon, boolean forceIgnoreUnresolvedTransactions, boolean autoCommitOnClose, boolean txnKnownResolved) throws SQLException {
        if (!forceIgnoreUnresolvedTransactions && !pCon.getAutoCommit()) {
            if (!autoCommitOnClose && !txnKnownResolved) {
                pCon.rollback();
            }
            pCon.setAutoCommit(true);
        }
    }

    public static boolean supportsMethod(Object target, String mname, Class[] argTypes) {
        try {
            return target.getClass().getMethod(mname, argTypes) != null;
        } catch (NoSuchMethodException e) {
            return false;
        } catch (SecurityException e2) {
            if (!logger.isLoggable(MLevel.FINE)) {
                return false;
            }
            logger.log(MLevel.FINE, "We were denied access in a check of whether " + target + " supports method " + mname + ". Prob means external clients have no access, returning false.", (Throwable) e2);
            return false;
        }
    }

    public static String createUserOverridesAsString(Map userOverrides) throws IOException {
        StringBuffer sb = new StringBuffer();
        sb.append(HASM_HEADER);
        sb.append('[');
        sb.append(ByteUtils.toHexAscii(SerializableUtils.toByteArray(userOverrides)));
        sb.append(']');
        return sb.toString();
    }

    public static Map parseUserOverridesAsString(String userOverridesAsString) throws IOException, ClassNotFoundException {
        if (userOverridesAsString != null) {
            return Collections.unmodifiableMap((Map) SerializableUtils.fromByteArray(ByteUtils.fromHexAscii(userOverridesAsString.substring(HASM_HEADER.length() + 1, userOverridesAsString.length() - 1))));
        }
        return Collections.EMPTY_MAP;
    }

    public static void assertCompileTimePresenceOfJdbc4_Jdk17Api(NewProxyConnection npc) throws SQLException {
        npc.getNetworkTimeout();
    }

    private C3P0ImplUtils() {
    }
}
