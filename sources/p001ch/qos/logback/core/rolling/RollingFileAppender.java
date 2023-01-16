package p001ch.qos.logback.core.rolling;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.rolling.helper.CompressionMode;
import p001ch.qos.logback.core.rolling.helper.FileNamePattern;
import p001ch.qos.logback.core.util.ContextUtil;

/* renamed from: ch.qos.logback.core.rolling.RollingFileAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/RollingFileAppender.class */
public class RollingFileAppender<E> extends FileAppender<E> {
    File currentlyActiveFile;
    TriggeringPolicy<E> triggeringPolicy;
    RollingPolicy rollingPolicy;
    private static String RFA_NO_TP_URL = "http://logback.qos.ch/codes.html#rfa_no_tp";
    private static String RFA_NO_RP_URL = "http://logback.qos.ch/codes.html#rfa_no_rp";
    private static String COLLISION_URL = "http://logback.qos.ch/codes.html#rfa_collision";
    private static String RFA_LATE_FILE_URL = "http://logback.qos.ch/codes.html#rfa_file_after";

    @Override // p001ch.qos.logback.core.FileAppender, p001ch.qos.logback.core.OutputStreamAppender, p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.triggeringPolicy == null) {
            addWarn("No TriggeringPolicy was set for the RollingFileAppender named " + getName());
            addWarn(CoreConstants.MORE_INFO_PREFIX + RFA_NO_TP_URL);
        } else if (!this.triggeringPolicy.isStarted()) {
            addWarn("TriggeringPolicy has not started. RollingFileAppender will not start");
        } else if (checkForCollisionsInPreviousRollingFileAppenders()) {
            addError("Collisions detected with FileAppender/RollingAppender instances defined earlier. Aborting.");
            addError(CoreConstants.MORE_INFO_PREFIX + COLLISION_WITH_EARLIER_APPENDER_URL);
        } else {
            if (!this.append) {
                addWarn("Append mode is mandatory for RollingFileAppender. Defaulting to append=true.");
                this.append = true;
            }
            if (this.rollingPolicy == null) {
                addError("No RollingPolicy was set for the RollingFileAppender named " + getName());
                addError(CoreConstants.MORE_INFO_PREFIX + RFA_NO_RP_URL);
            } else if (checkForFileAndPatternCollisions()) {
                addError("File property collides with fileNamePattern. Aborting.");
                addError(CoreConstants.MORE_INFO_PREFIX + COLLISION_URL);
            } else {
                if (isPrudent()) {
                    if (rawFileProperty() != null) {
                        addWarn("Setting \"File\" property to null on account of prudent mode");
                        setFile(null);
                    }
                    if (this.rollingPolicy.getCompressionMode() != CompressionMode.NONE) {
                        addError("Compression is not supported in prudent mode. Aborting");
                        return;
                    }
                }
                this.currentlyActiveFile = new File(getFile());
                addInfo("Active log file name: " + getFile());
                start();
            }
        }
    }

    private boolean checkForFileAndPatternCollisions() {
        FileNamePattern fileNamePattern;
        if (!(this.triggeringPolicy instanceof RollingPolicyBase) || (fileNamePattern = ((RollingPolicyBase) this.triggeringPolicy).fileNamePattern) == null || this.fileName == null) {
            return false;
        }
        return this.fileName.matches(fileNamePattern.toRegex());
    }

    private boolean checkForCollisionsInPreviousRollingFileAppenders() {
        boolean collisionResult = false;
        if ((this.triggeringPolicy instanceof RollingPolicyBase) && innerCheckForFileNamePatternCollisionInPreviousRFA(((RollingPolicyBase) this.triggeringPolicy).fileNamePattern)) {
            collisionResult = true;
        }
        return collisionResult;
    }

    private boolean innerCheckForFileNamePatternCollisionInPreviousRFA(FileNamePattern fileNamePattern) {
        boolean collisionsDetected = false;
        Map<String, FileNamePattern> map = (Map) this.context.getObject(CoreConstants.RFA_FILENAME_PATTERN_COLLISION_MAP);
        if (map == null) {
            return false;
        }
        for (Map.Entry<String, FileNamePattern> entry : map.entrySet()) {
            if (fileNamePattern.equals(entry.getValue())) {
                addErrorForCollision("FileNamePattern", entry.getValue().toString(), entry.getKey());
                collisionsDetected = true;
            }
        }
        if (this.name != null) {
            map.put(getName(), fileNamePattern);
        }
        return collisionsDetected;
    }

    @Override // p001ch.qos.logback.core.FileAppender, p001ch.qos.logback.core.OutputStreamAppender, p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        stop();
        if (this.rollingPolicy != null) {
            this.rollingPolicy.stop();
        }
        if (this.triggeringPolicy != null) {
            this.triggeringPolicy.stop();
        }
        Map<String, FileNamePattern> map = ContextUtil.getFilenamePatternCollisionMap(this.context);
        if (map != null && getName() != null) {
            map.remove(getName());
        }
    }

    @Override // p001ch.qos.logback.core.FileAppender
    public void setFile(String file) {
        if (!(file == null || (this.triggeringPolicy == null && this.rollingPolicy == null))) {
            addError("File property must be set before any triggeringPolicy or rollingPolicy properties");
            addError(CoreConstants.MORE_INFO_PREFIX + RFA_LATE_FILE_URL);
        }
        setFile(file);
    }

    @Override // p001ch.qos.logback.core.FileAppender
    public String getFile() {
        return this.rollingPolicy.getActiveFileName();
    }

    public void rollover() {
        this.lock.lock();
        try {
            closeOutputStream();
            attemptRollover();
            attemptOpenFile();
        } finally {
            this.lock.unlock();
        }
    }

    private void attemptOpenFile() {
        try {
            this.currentlyActiveFile = new File(this.rollingPolicy.getActiveFileName());
            openFile(this.rollingPolicy.getActiveFileName());
        } catch (IOException e) {
            addError("setFile(" + this.fileName + ", false) call failed.", e);
        }
    }

    private void attemptRollover() {
        try {
            this.rollingPolicy.rollover();
        } catch (RolloverFailure e) {
            addWarn("RolloverFailure occurred. Deferring roll-over.");
            this.append = true;
        }
    }

    @Override // p001ch.qos.logback.core.OutputStreamAppender
    protected void subAppend(E event) {
        synchronized (this.triggeringPolicy) {
            if (this.triggeringPolicy.isTriggeringEvent(this.currentlyActiveFile, event)) {
                rollover();
            }
        }
        subAppend(event);
    }

    public RollingPolicy getRollingPolicy() {
        return this.rollingPolicy;
    }

    public TriggeringPolicy<E> getTriggeringPolicy() {
        return this.triggeringPolicy;
    }

    public void setRollingPolicy(RollingPolicy policy) {
        this.rollingPolicy = policy;
        if (this.rollingPolicy instanceof TriggeringPolicy) {
            this.triggeringPolicy = (TriggeringPolicy) policy;
        }
    }

    public void setTriggeringPolicy(TriggeringPolicy<E> policy) {
        this.triggeringPolicy = policy;
        if (policy instanceof RollingPolicy) {
            this.rollingPolicy = (RollingPolicy) policy;
        }
    }
}
