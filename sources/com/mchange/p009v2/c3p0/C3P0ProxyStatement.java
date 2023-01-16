package com.mchange.p009v2.c3p0;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.sql.Statement;

/* renamed from: com.mchange.v2.c3p0.C3P0ProxyStatement */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/C3P0ProxyStatement.class */
public interface C3P0ProxyStatement extends Statement {
    public static final Object RAW_STATEMENT = new Object();

    Object rawStatementOperation(Method method, Object obj, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, SQLException;
}
