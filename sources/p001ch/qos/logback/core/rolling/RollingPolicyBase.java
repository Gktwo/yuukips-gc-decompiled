package p001ch.qos.logback.core.rolling;

import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.rolling.helper.CompressionMode;
import p001ch.qos.logback.core.rolling.helper.FileNamePattern;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.RollingPolicyBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/RollingPolicyBase.class */
public abstract class RollingPolicyBase extends ContextAwareBase implements RollingPolicy {
    protected CompressionMode compressionMode = CompressionMode.NONE;
    FileNamePattern fileNamePattern;
    protected String fileNamePatternStr;
    private FileAppender<?> parent;
    FileNamePattern zipEntryFileNamePattern;
    private boolean started;

    protected void determineCompressionMode() {
        if (this.fileNamePatternStr.endsWith(".gz")) {
            addInfo("Will use gz compression");
            this.compressionMode = CompressionMode.GZ;
        } else if (this.fileNamePatternStr.endsWith(".zip")) {
            addInfo("Will use zip compression");
            this.compressionMode = CompressionMode.ZIP;
        } else {
            addInfo("No compression will be used");
            this.compressionMode = CompressionMode.NONE;
        }
    }

    public void setFileNamePattern(String fnp) {
        this.fileNamePatternStr = fnp;
    }

    public String getFileNamePattern() {
        return this.fileNamePatternStr;
    }

    @Override // p001ch.qos.logback.core.rolling.RollingPolicy
    public CompressionMode getCompressionMode() {
        return this.compressionMode;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }

    @Override // p001ch.qos.logback.core.rolling.RollingPolicy
    public void setParent(FileAppender<?> appender) {
        this.parent = appender;
    }

    public boolean isParentPrudent() {
        return this.parent.isPrudent();
    }

    public String getParentsRawFileProperty() {
        return this.parent.rawFileProperty();
    }
}
