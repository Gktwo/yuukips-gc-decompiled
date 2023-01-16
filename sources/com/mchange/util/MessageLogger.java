package com.mchange.util;

import java.io.IOException;

/* loaded from: grasscutter.jar:com/mchange/util/MessageLogger.class */
public interface MessageLogger {
    void log(String str) throws IOException;

    void log(Throwable th, String str) throws IOException;
}
