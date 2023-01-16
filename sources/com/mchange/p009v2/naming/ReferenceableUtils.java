package com.mchange.p009v2.naming;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Hashtable;
import javax.naming.Context;
import javax.naming.Name;
import javax.naming.NamingException;
import javax.naming.Reference;
import javax.naming.StringRefAddr;
import javax.naming.spi.ObjectFactory;

/* renamed from: com.mchange.v2.naming.ReferenceableUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/naming/ReferenceableUtils.class */
public final class ReferenceableUtils {
    static final MLogger logger = MLog.getLogger(ReferenceableUtils.class);
    static final String REFADDR_VERSION = "version";
    static final String REFADDR_CLASSNAME = "classname";
    static final String REFADDR_FACTORY = "factory";
    static final String REFADDR_FACTORY_CLASS_LOCATION = "factoryClassLocation";
    static final String REFADDR_SIZE = "size";
    static final int CURRENT_REF_VERSION = 1;

    public static String literalNullToNull(String str) {
        if (str == null || "null".equals(str)) {
            return null;
        }
        return str;
    }

    public static Object referenceToObject(Reference reference, Name name, Context context, Hashtable hashtable) throws NamingException {
        URLClassLoader uRLClassLoader;
        try {
            String factoryClassName = reference.getFactoryClassName();
            String factoryClassLocation = reference.getFactoryClassLocation();
            ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = ReferenceableUtils.class.getClassLoader();
            }
            if (factoryClassLocation == null) {
                uRLClassLoader = contextClassLoader;
            } else {
                uRLClassLoader = new URLClassLoader(new URL[]{new URL(factoryClassLocation)}, contextClassLoader);
            }
            return ((ObjectFactory) Class.forName(factoryClassName, true, uRLClassLoader).newInstance()).getObjectInstance(reference, name, context, hashtable);
        } catch (Exception e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Could not resolve Reference to Object!", (Throwable) e);
            }
            NamingException namingException = new NamingException("Could not resolve Reference to Object!");
            namingException.setRootCause(e);
            throw namingException;
        }
    }

    public static void appendToReference(Reference reference, Reference reference2) throws NamingException {
        int size = reference2.size();
        reference.add(new StringRefAddr(REFADDR_VERSION, String.valueOf(1)));
        reference.add(new StringRefAddr(REFADDR_CLASSNAME, reference2.getClassName()));
        reference.add(new StringRefAddr(REFADDR_FACTORY, reference2.getFactoryClassName()));
        reference.add(new StringRefAddr(REFADDR_FACTORY_CLASS_LOCATION, reference2.getFactoryClassLocation()));
        reference.add(new StringRefAddr(REFADDR_SIZE, String.valueOf(size)));
        for (int i = 0; i < size; i++) {
            reference.add(reference2.get(i));
        }
    }

    public static ExtractRec extractNestedReference(Reference reference, int i) throws NamingException {
        try {
            int i2 = i + 1;
            if (Integer.parseInt((String) reference.get(i).getContent()) == 1) {
                int i3 = i2 + 1;
                int i4 = i3 + 1;
                int i5 = i4 + 1;
                Reference reference2 = new Reference((String) reference.get(i2).getContent(), (String) reference.get(i3).getContent(), (String) reference.get(i4).getContent());
                int i6 = i5 + 1;
                int parseInt = Integer.parseInt((String) reference.get(i5).getContent());
                for (int i7 = 0; i7 < parseInt; i7++) {
                    i6++;
                    reference2.add(reference.get(i6));
                }
                return new ExtractRec(reference2, i6);
            }
            throw new NamingException("Bad version of nested reference!!!");
        } catch (NumberFormatException e) {
            if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "Version or size nested reference was not a number!!!", (Throwable) e);
            }
            throw new NamingException("Version or size nested reference was not a number!!!");
        }
    }

    /* renamed from: com.mchange.v2.naming.ReferenceableUtils$ExtractRec */
    /* loaded from: grasscutter.jar:com/mchange/v2/naming/ReferenceableUtils$ExtractRec.class */
    public static class ExtractRec {
        public Reference ref;
        public int index;

        private ExtractRec(Reference reference, int i) {
            this.ref = reference;
            this.index = i;
        }
    }

    private ReferenceableUtils() {
    }
}
