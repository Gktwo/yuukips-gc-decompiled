package org.quartz.impl.jdbcjobstore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/AttributeRestoringConnectionInvocationHandler.class */
public class AttributeRestoringConnectionInvocationHandler implements InvocationHandler {
    private Connection conn;
    private boolean overwroteOriginalAutoCommitValue;
    private boolean overwroteOriginalTxIsolationValue;
    private boolean originalAutoCommitValue;
    private int originalTxIsolationValue;

    public AttributeRestoringConnectionInvocationHandler(Connection conn) {
        this.conn = conn;
    }

    protected Logger getLog() {
        return LoggerFactory.getLogger(getClass());
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("setAutoCommit")) {
            setAutoCommit(((Boolean) args[0]).booleanValue());
            return null;
        } else if (method.getName().equals("setTransactionIsolation")) {
            setTransactionIsolation(((Integer) args[0]).intValue());
            return null;
        } else if (method.getName().equals("close")) {
            close();
            return null;
        } else {
            try {
                return method.invoke(this.conn, args);
            } catch (InvocationTargetException ite) {
                if (ite.getCause() != null) {
                    throw ite.getCause();
                }
                throw ite;
            }
        }
    }

    public void setAutoCommit(boolean autoCommit) throws SQLException {
        boolean currentAutoCommitValue = this.conn.getAutoCommit();
        if (autoCommit != currentAutoCommitValue) {
            if (!this.overwroteOriginalAutoCommitValue) {
                this.overwroteOriginalAutoCommitValue = true;
                this.originalAutoCommitValue = currentAutoCommitValue;
            }
            this.conn.setAutoCommit(autoCommit);
        }
    }

    public void setTransactionIsolation(int level) throws SQLException {
        int currentLevel = this.conn.getTransactionIsolation();
        if (level != currentLevel) {
            if (!this.overwroteOriginalTxIsolationValue) {
                this.overwroteOriginalTxIsolationValue = true;
                this.originalTxIsolationValue = currentLevel;
            }
            this.conn.setTransactionIsolation(level);
        }
    }

    public Connection getWrappedConnection() {
        return this.conn;
    }

    public void restoreOriginalAtributes() {
        try {
            if (this.overwroteOriginalAutoCommitValue) {
                this.conn.setAutoCommit(this.originalAutoCommitValue);
            }
        } catch (Throwable t) {
            getLog().warn("Failed restore connection's original auto commit setting.", t);
        }
        try {
            if (this.overwroteOriginalTxIsolationValue) {
                this.conn.setTransactionIsolation(this.originalTxIsolationValue);
            }
        } catch (Throwable t2) {
            getLog().warn("Failed restore connection's original transaction isolation setting.", t2);
        }
    }

    public void close() throws SQLException {
        restoreOriginalAtributes();
        this.conn.close();
    }
}
