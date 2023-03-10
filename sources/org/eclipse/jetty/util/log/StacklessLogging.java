package org.eclipse.jetty.util.log;

import java.util.HashSet;
import java.util.Set;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/log/StacklessLogging.class */
public class StacklessLogging implements AutoCloseable {
    private final Set<StdErrLog> squelched = new HashSet();

    public StacklessLogging(Class<?>... classesToSquelch) {
        for (Class<?> clazz : classesToSquelch) {
            Logger log = Log.getLogger(clazz);
            if ((log instanceof StdErrLog) && !log.isDebugEnabled()) {
                StdErrLog stdErrLog = (StdErrLog) log;
                if (!stdErrLog.isHideStacks()) {
                    stdErrLog.setHideStacks(true);
                    this.squelched.add(stdErrLog);
                }
            }
        }
    }

    public StacklessLogging(Logger... logs) {
        for (Logger log : logs) {
            if ((log instanceof StdErrLog) && !log.isDebugEnabled()) {
                StdErrLog stdErrLog = (StdErrLog) log;
                if (!stdErrLog.isHideStacks()) {
                    stdErrLog.setHideStacks(true);
                    this.squelched.add(stdErrLog);
                }
            }
        }
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        for (StdErrLog log : this.squelched) {
            log.setHideStacks(false);
        }
    }
}
