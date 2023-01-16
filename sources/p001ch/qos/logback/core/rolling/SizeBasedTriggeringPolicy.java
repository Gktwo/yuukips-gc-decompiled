package p001ch.qos.logback.core.rolling;

import java.io.File;
import p001ch.qos.logback.core.util.DefaultInvocationGate;
import p001ch.qos.logback.core.util.FileSize;
import p001ch.qos.logback.core.util.InvocationGate;

/* renamed from: ch.qos.logback.core.rolling.SizeBasedTriggeringPolicy */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/SizeBasedTriggeringPolicy.class */
public class SizeBasedTriggeringPolicy<E> extends TriggeringPolicyBase<E> {
    public static final String SEE_SIZE_FORMAT = "http://logback.qos.ch/codes.html#sbtp_size_format";
    public static final long DEFAULT_MAX_FILE_SIZE = 10485760;
    FileSize maxFileSize = new FileSize(DEFAULT_MAX_FILE_SIZE);
    InvocationGate invocationGate = new DefaultInvocationGate();

    @Override // p001ch.qos.logback.core.rolling.TriggeringPolicy
    public boolean isTriggeringEvent(File activeFile, E event) {
        return !this.invocationGate.isTooSoon(System.currentTimeMillis()) && activeFile.length() >= this.maxFileSize.getSize();
    }

    public void setMaxFileSize(FileSize aMaxFileSize) {
        this.maxFileSize = aMaxFileSize;
    }
}
