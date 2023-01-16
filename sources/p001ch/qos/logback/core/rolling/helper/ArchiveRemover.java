package p001ch.qos.logback.core.rolling.helper;

import java.util.Date;
import java.util.concurrent.Future;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.core.rolling.helper.ArchiveRemover */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/ArchiveRemover.class */
public interface ArchiveRemover extends ContextAware {
    void clean(Date date);

    void setMaxHistory(int i);

    void setTotalSizeCap(long j);

    Future<?> cleanAsynchronously(Date date);
}
