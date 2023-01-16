package com.mchange.p009v2.log.jdk14logging;

import com.mchange.p009v2.log.LogUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLogger;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* renamed from: com.mchange.v2.log.jdk14logging.ForwardingLogger */
/* loaded from: grasscutter.jar:com/mchange/v2/log/jdk14logging/ForwardingLogger.class */
public final class ForwardingLogger extends Logger {
    MLogger forwardTo;

    public ForwardingLogger(MLogger mLogger, String str) {
        super(mLogger.getName(), str);
        this.forwardTo = mLogger;
    }

    @Override // java.util.logging.Logger
    public void log(LogRecord logRecord) {
        MLevel mlevelFromLevel = Jdk14LoggingUtils.mlevelFromLevel(logRecord.getLevel());
        String formatMessage = LogUtils.formatMessage(logRecord.getResourceBundleName(), logRecord.getMessage(), logRecord.getParameters());
        Throwable thrown = logRecord.getThrown();
        String sourceClassName = logRecord.getSourceClassName();
        String sourceMethodName = logRecord.getSourceMethodName();
        if (!(sourceClassName != null) || !(sourceMethodName != null)) {
            this.forwardTo.log(mlevelFromLevel, formatMessage, thrown);
        } else {
            this.forwardTo.logp(mlevelFromLevel, sourceClassName, sourceMethodName, formatMessage, thrown);
        }
    }
}
