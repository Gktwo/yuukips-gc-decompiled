package com.mchange.p009v2.c3p0.impl;

import com.mchange.p009v2.c3p0.impl.DefaultConnectionTester;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLogger;
import java.sql.Connection;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: DefaultConnectionTester.java */
/* renamed from: com.mchange.v2.c3p0.impl.ThreadLocalQuerylessTestRunner */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/impl/ThreadLocalQuerylessTestRunner.class */
class ThreadLocalQuerylessTestRunner implements DefaultConnectionTester.QuerylessTestRunner {
    static final MLogger logger = DefaultConnectionTester.logger;
    private static final ThreadLocal classToTestRunnerThreadLocal = new ThreadLocal() { // from class: com.mchange.v2.c3p0.impl.ThreadLocalQuerylessTestRunner.1
        @Override // java.lang.ThreadLocal
        protected Object initialValue() {
            return new WeakHashMap();
        }
    };
    private static final Class[] ARG_ARRAY = {Integer.TYPE};

    private static Map classToTestRunner() {
        return (Map) classToTestRunnerThreadLocal.get();
    }

    private static DefaultConnectionTester.QuerylessTestRunner findTestRunner(Class cClass) {
        try {
            cClass.getDeclaredMethod("isValid", ARG_ARRAY);
            return DefaultConnectionTester.IS_VALID;
        } catch (NoSuchMethodException e) {
            return DefaultConnectionTester.METADATA_TABLESEARCH;
        } catch (SecurityException e2) {
            if (logger.isLoggable(MLevel.WARNING)) {
                logger.log(MLevel.WARNING, "Huh? SecurityException while reflectively checking for " + cClass.getName() + ".isValid(). Defaulting to traditional (slow) queryless test.");
            }
            return DefaultConnectionTester.METADATA_TABLESEARCH;
        }
    }

    @Override // com.mchange.p009v2.c3p0.impl.DefaultConnectionTester.QuerylessTestRunner
    public int activeCheckConnectionNoQuery(Connection c, Throwable[] rootCauseOutParamHolder) {
        Map map = classToTestRunner();
        Class cClass = c.getClass();
        DefaultConnectionTester.QuerylessTestRunner qtl = (DefaultConnectionTester.QuerylessTestRunner) map.get(cClass);
        if (qtl == null) {
            qtl = findTestRunner(cClass);
            map.put(cClass, qtl);
        }
        return qtl.activeCheckConnectionNoQuery(c, rootCauseOutParamHolder);
    }
}
