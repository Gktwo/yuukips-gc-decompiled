package p001ch.qos.logback.core.rolling;

import p001ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP;
import p001ch.qos.logback.core.util.FileSize;

/* renamed from: ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/SizeAndTimeBasedRollingPolicy.class */
public class SizeAndTimeBasedRollingPolicy<E> extends TimeBasedRollingPolicy<E> {
    FileSize maxFileSize;

    @Override // p001ch.qos.logback.core.rolling.TimeBasedRollingPolicy, p001ch.qos.logback.core.rolling.RollingPolicyBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        SizeAndTimeBasedFNATP<E> sizeAndTimeBasedFNATP = new SizeAndTimeBasedFNATP<>(SizeAndTimeBasedFNATP.Usage.EMBEDDED);
        if (this.maxFileSize == null) {
            addError("maxFileSize property is mandatory.");
            return;
        }
        addInfo("Archive files will be limited to [" + this.maxFileSize + "] each.");
        sizeAndTimeBasedFNATP.setMaxFileSize(this.maxFileSize);
        this.timeBasedFileNamingAndTriggeringPolicy = sizeAndTimeBasedFNATP;
        if (isUnboundedTotalSizeCap() || this.totalSizeCap.getSize() >= this.maxFileSize.getSize()) {
            start();
        } else {
            addError("totalSizeCap of [" + this.totalSizeCap + "] is smaller than maxFileSize [" + this.maxFileSize + "] which is non-sensical");
        }
    }

    public void setMaxFileSize(FileSize aMaxFileSize) {
        this.maxFileSize = aMaxFileSize;
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedRollingPolicy
    public String toString() {
        return "c.q.l.core.rolling.SizeAndTimeBasedRollingPolicy@" + hashCode();
    }
}
