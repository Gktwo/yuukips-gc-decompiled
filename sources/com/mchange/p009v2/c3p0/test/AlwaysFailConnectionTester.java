package com.mchange.p009v2.c3p0.test;

import com.mchange.p009v2.c3p0.QueryConnectionTester;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.test.AlwaysFailConnectionTester */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/AlwaysFailConnectionTester.class */
public final class AlwaysFailConnectionTester implements QueryConnectionTester {
    static final MLogger logger = MLog.getLogger(AlwaysFailConnectionTester.class);

    public AlwaysFailConnectionTester() {
        logger.log(MLevel.WARNING, "Instantiated: " + this, (Throwable) new Exception("Instantiation Stack Trace."));
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionTester
    public int activeCheckConnection(Connection c) {
        logger.warning(this + ": activeCheckConnection(Connection c)");
        return -1;
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionTester
    public int statusOnException(Connection c, Throwable t) {
        logger.warning(this + ": statusOnException(Connection c, Throwable t)");
        return -1;
    }

    @Override // com.mchange.p009v2.c3p0.QueryConnectionTester
    public int activeCheckConnection(Connection c, String preferredTestQuery) {
        logger.warning(this + ": activeCheckConnection(Connection c, String preferredTestQuery)");
        return -1;
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionTester, java.lang.Object
    public boolean equals(Object o) {
        return o instanceof AlwaysFailConnectionTester;
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionTester, java.lang.Object
    public int hashCode() {
        return 1;
    }
}
