package com.mchange.util;

import java.util.Iterator;

/* loaded from: grasscutter.jar:com/mchange/util/FailSuppressedMessageLogger.class */
public interface FailSuppressedMessageLogger extends RobustMessageLogger {
    Iterator getFailures();

    void clearFailures();
}
