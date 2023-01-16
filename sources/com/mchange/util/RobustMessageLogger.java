package com.mchange.util;

/* loaded from: grasscutter.jar:com/mchange/util/RobustMessageLogger.class */
public interface RobustMessageLogger extends MessageLogger {
    @Override // com.mchange.util.MessageLogger
    void log(String str);

    @Override // com.mchange.util.MessageLogger
    void log(Throwable th, String str);
}
