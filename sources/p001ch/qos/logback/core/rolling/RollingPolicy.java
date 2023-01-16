package p001ch.qos.logback.core.rolling;

import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.rolling.helper.CompressionMode;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.rolling.RollingPolicy */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/RollingPolicy.class */
public interface RollingPolicy extends LifeCycle {
    void rollover() throws RolloverFailure;

    String getActiveFileName();

    CompressionMode getCompressionMode();

    void setParent(FileAppender<?> fileAppender);
}
