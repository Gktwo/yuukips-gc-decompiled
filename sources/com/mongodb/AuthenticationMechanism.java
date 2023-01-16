package com.mongodb;

import java.util.HashMap;
import java.util.Map;

/* loaded from: grasscutter.jar:com/mongodb/AuthenticationMechanism.class */
public enum AuthenticationMechanism {
    GSSAPI("GSSAPI"),
    MONGODB_AWS("MONGODB-AWS"),
    MONGODB_X509("MONGODB-X509"),
    PLAIN("PLAIN"),
    SCRAM_SHA_1("SCRAM-SHA-1"),
    SCRAM_SHA_256("SCRAM-SHA-256");
    
    private static final Map<String, AuthenticationMechanism> AUTH_MAP = new HashMap();
    private final String mechanismName;

    static {
        AuthenticationMechanism[] values = values();
        for (AuthenticationMechanism value : values) {
            AUTH_MAP.put(value.getMechanismName(), value);
        }
    }

    AuthenticationMechanism(String mechanismName) {
        this.mechanismName = mechanismName;
    }

    public String getMechanismName() {
        return this.mechanismName;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.mechanismName;
    }

    public static AuthenticationMechanism fromMechanismName(String mechanismName) {
        AuthenticationMechanism mechanism = AUTH_MAP.get(mechanismName);
        if (mechanism != null) {
            return mechanism;
        }
        throw new IllegalArgumentException("Unsupported authMechanism: " + mechanismName);
    }
}
