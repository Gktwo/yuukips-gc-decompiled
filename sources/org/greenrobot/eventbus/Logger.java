package org.greenrobot.eventbus;

import java.util.logging.Level;
import org.greenrobot.eventbus.android.AndroidComponents;

/* loaded from: grasscutter.jar:org/greenrobot/eventbus/Logger.class */
public interface Logger {
    void log(Level level, String str);

    void log(Level level, String str, Throwable th);

    /* loaded from: grasscutter.jar:org/greenrobot/eventbus/Logger$JavaLogger.class */
    public static class JavaLogger implements Logger {
        protected final java.util.logging.Logger logger;

        public JavaLogger(String tag) {
            this.logger = java.util.logging.Logger.getLogger(tag);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg) {
            this.logger.log(level, msg);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg, Throwable th) {
            this.logger.log(level, msg, th);
        }
    }

    /* loaded from: grasscutter.jar:org/greenrobot/eventbus/Logger$SystemOutLogger.class */
    public static class SystemOutLogger implements Logger {
        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg) {
            System.out.println("[" + level + "] " + msg);
        }

        @Override // org.greenrobot.eventbus.Logger
        public void log(Level level, String msg, Throwable th) {
            System.out.println("[" + level + "] " + msg);
            th.printStackTrace(System.out);
        }
    }

    /* loaded from: grasscutter.jar:org/greenrobot/eventbus/Logger$Default.class */
    public static class Default {
        public static Logger get() {
            if (AndroidComponents.areAvailable()) {
                return AndroidComponents.get().logger;
            }
            return new SystemOutLogger();
        }
    }
}
