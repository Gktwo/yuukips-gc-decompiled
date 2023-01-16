package com.mchange.p009v2.c3p0.test;

import com.mchange.p009v2.c3p0.AbstractConnectionCustomizer;
import java.sql.Connection;

/* renamed from: com.mchange.v2.c3p0.test.TestConnectionCustomizer */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/test/TestConnectionCustomizer.class */
public class TestConnectionCustomizer extends AbstractConnectionCustomizer {
    @Override // com.mchange.p009v2.c3p0.AbstractConnectionCustomizer, com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onAcquire(Connection c, String pdsIdt) {
        System.err.println("Acquired " + c + " [" + pdsIdt + "]");
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionCustomizer, com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onDestroy(Connection c, String pdsIdt) {
        System.err.println("Destroying " + c + " [" + pdsIdt + "]");
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionCustomizer, com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onCheckOut(Connection c, String pdsIdt) {
        System.err.println("Checked out " + c + " [" + pdsIdt + "]");
    }

    @Override // com.mchange.p009v2.c3p0.AbstractConnectionCustomizer, com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onCheckIn(Connection c, String pdsIdt) {
        System.err.println("Checking in " + c + " [" + pdsIdt + "]");
    }
}
