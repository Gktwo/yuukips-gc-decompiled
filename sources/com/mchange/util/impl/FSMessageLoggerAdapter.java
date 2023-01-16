package com.mchange.util.impl;

import com.mchange.util.FailSuppressedMessageLogger;
import com.mchange.util.MessageLogger;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: grasscutter.jar:com/mchange/util/impl/FSMessageLoggerAdapter.class */
public class FSMessageLoggerAdapter implements FailSuppressedMessageLogger {
    MessageLogger inner;
    List failures = null;

    public FSMessageLoggerAdapter(MessageLogger messageLogger) {
        this.inner = messageLogger;
    }

    @Override // com.mchange.util.RobustMessageLogger, com.mchange.util.MessageLogger
    public void log(String str) {
        try {
            this.inner.log(str);
        } catch (IOException e) {
            addFailure(e);
        }
    }

    @Override // com.mchange.util.RobustMessageLogger, com.mchange.util.MessageLogger
    public void log(Throwable th, String str) {
        try {
            this.inner.log(th, str);
        } catch (IOException e) {
            addFailure(e);
        }
    }

    @Override // com.mchange.util.FailSuppressedMessageLogger
    public synchronized Iterator getFailures() {
        if (this.inner instanceof FailSuppressedMessageLogger) {
            return ((FailSuppressedMessageLogger) this.inner).getFailures();
        }
        if (this.failures != null) {
            return this.failures.iterator();
        }
        return null;
    }

    @Override // com.mchange.util.FailSuppressedMessageLogger
    public synchronized void clearFailures() {
        if (this.inner instanceof FailSuppressedMessageLogger) {
            ((FailSuppressedMessageLogger) this.inner).clearFailures();
        } else {
            this.failures = null;
        }
    }

    private synchronized void addFailure(IOException iOException) {
        if (this.failures == null) {
            this.failures = new LinkedList();
        }
        this.failures.add(iOException);
    }
}
