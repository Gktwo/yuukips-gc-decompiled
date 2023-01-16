package com.mchange.p009v2.log;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.mchange.v2.log.MLogClasses */
/* loaded from: grasscutter.jar:com/mchange/v2/log/MLogClasses.class */
public final class MLogClasses {
    static final Map<String, String> ALIASES;
    static final String SLF4J_CNAME = "com.mchange.v2.log.slf4j.Slf4jMLog";
    static final String LOG4J_CNAME = "com.mchange.v2.log.log4j.Log4jMLog";
    static final String LOG4J2_CNAME = "com.mchange.v2.log.log4j2.Log4j2MLog";
    static final String JDK14_CNAME = "com.mchange.v2.log.jdk14logging.Jdk14MLog";
    static final String[] SEARCH_CLASSNAMES = {SLF4J_CNAME, LOG4J_CNAME, LOG4J2_CNAME, JDK14_CNAME};

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("log4j", LOG4J_CNAME);
        hashMap.put("log4j2", LOG4J2_CNAME);
        hashMap.put("slf4j", SLF4J_CNAME);
        hashMap.put("jdk14", JDK14_CNAME);
        hashMap.put("jul", JDK14_CNAME);
        hashMap.put("java.util.logging", JDK14_CNAME);
        hashMap.put("fallback", "com.mchange.v2.log.FallbackMLog");
        ALIASES = Collections.unmodifiableMap(hashMap);
    }

    /* access modifiers changed from: package-private */
    public static String resolveIfAlias(String str) {
        String str2 = ALIASES.get(str.toLowerCase());
        if (str2 == null) {
            str2 = str;
        }
        return str2;
    }

    private MLogClasses() {
    }
}
