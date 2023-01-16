package com.mchange.p009v2.c3p0.impl;

import java.util.Enumeration;
import java.util.Properties;

/* renamed from: com.mchange.v2.c3p0.impl.AuthMaskingProperties */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/AuthMaskingProperties.class */
public class AuthMaskingProperties extends Properties {
    public AuthMaskingProperties() {
    }

    public AuthMaskingProperties(Properties p) {
        super(p);
    }

    public static AuthMaskingProperties fromAnyProperties(Properties p) {
        AuthMaskingProperties out = new AuthMaskingProperties();
        Enumeration e = p.propertyNames();
        while (e.hasMoreElements()) {
            String key = (String) e.nextElement();
            out.setProperty(key, p.getProperty(key));
        }
        return out;
    }

    private String normalToString() {
        return toString();
    }

    @Override // java.lang.Object, java.util.Hashtable
    public String toString() {
        boolean hasUser = get("user") != null;
        boolean hasPassword = get("password") != null;
        if (!hasUser && !hasPassword) {
            return normalToString();
        }
        AuthMaskingProperties clone = (AuthMaskingProperties) clone();
        if (hasUser) {
            clone.put("user", "******");
        }
        if (hasPassword) {
            clone.put("password", "******");
        }
        return clone.normalToString();
    }
}
