package com.mchange.p009v2.c3p0;

import java.sql.Connection;
import java.util.Map;

/* renamed from: com.mchange.v2.c3p0.AbstractConnectionCustomizer */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/AbstractConnectionCustomizer.class */
public abstract class AbstractConnectionCustomizer implements ConnectionCustomizer {
    protected Map extensionsForToken(String parentDataSourceIdentityToken) {
        return C3P0Registry.extensionsForToken(parentDataSourceIdentityToken);
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onAcquire(Connection c, String parentDataSourceIdentityToken) throws Exception {
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onDestroy(Connection c, String parentDataSourceIdentityToken) throws Exception {
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onCheckOut(Connection c, String parentDataSourceIdentityToken) throws Exception {
    }

    @Override // com.mchange.p009v2.c3p0.ConnectionCustomizer
    public void onCheckIn(Connection c, String parentDataSourceIdentityToken) throws Exception {
    }
}
