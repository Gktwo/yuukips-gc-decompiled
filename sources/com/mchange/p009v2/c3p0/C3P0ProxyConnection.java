package com.mchange.p009v2.c3p0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;

/* renamed from: com.mchange.v2.c3p0.C3P0ProxyConnection */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/C3P0ProxyConnection.class */
public interface C3P0ProxyConnection extends Connection {
    public static final Object RAW_CONNECTION = new Object();

    Object rawConnectionOperation(Method method, Object obj, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException;
}
