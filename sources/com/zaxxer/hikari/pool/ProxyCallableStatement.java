package com.zaxxer.hikari.pool;

import java.sql.CallableStatement;

/* loaded from: grasscutter.jar:com/zaxxer/hikari/pool/ProxyCallableStatement.class */
public abstract class ProxyCallableStatement extends ProxyPreparedStatement implements CallableStatement {
    /* access modifiers changed from: protected */
    public ProxyCallableStatement(ProxyConnection connection, CallableStatement statement) {
        super(connection, statement);
    }
}
