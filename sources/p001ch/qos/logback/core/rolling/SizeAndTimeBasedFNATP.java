package p001ch.qos.logback.core.rolling;

import java.io.File;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.spi.NoAutoStart;
import p001ch.qos.logback.core.rolling.helper.ArchiveRemover;
import p001ch.qos.logback.core.rolling.helper.CompressionMode;
import p001ch.qos.logback.core.rolling.helper.FileFilterUtil;
import p001ch.qos.logback.core.rolling.helper.SizeAndTimeBasedArchiveRemover;
import p001ch.qos.logback.core.util.DefaultInvocationGate;
import p001ch.qos.logback.core.util.FileSize;
import p001ch.qos.logback.core.util.InvocationGate;

@NoAutoStart
/* renamed from: ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/SizeAndTimeBasedFNATP.class */
public class SizeAndTimeBasedFNATP<E> extends TimeBasedFileNamingAndTriggeringPolicyBase<E> {
    int currentPeriodsCounter;
    FileSize maxFileSize;
    long nextSizeCheck;
    static String MISSING_INT_TOKEN = "Missing integer token, that is %i, in FileNamePattern [";
    static String MISSING_DATE_TOKEN = "Missing date token, that is %d, in FileNamePattern [";
    private final Usage usage;
    InvocationGate invocationGate;

    /* renamed from: ch.qos.logback.core.rolling.SizeAndTimeBasedFNATP$Usage */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/SizeAndTimeBasedFNATP$Usage.class */
    enum Usage {
        EMBEDDED,
        DIRECT
    }

    public SizeAndTimeBasedFNATP() {
        this(Usage.DIRECT);
    }

    public SizeAndTimeBasedFNATP(Usage usage) {
        this.currentPeriodsCounter = 0;
        this.nextSizeCheck = 0;
        this.invocationGate = new DefaultInvocationGate();
        this.usage = usage;
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        start();
        if (this.usage == Usage.DIRECT) {
            addWarn(CoreConstants.SIZE_AND_TIME_BASED_FNATP_IS_DEPRECATED);
            addWarn("For more information see http://logback.qos.ch/manual/appenders.html#SizeAndTimeBasedRollingPolicy");
        }
        if (isErrorFree()) {
            if (this.maxFileSize == null) {
                addError("maxFileSize property is mandatory.");
                withErrors();
            }
            if (!validateDateAndIntegerTokens()) {
                withErrors();
                return;
            }
            this.archiveRemover = createArchiveRemover();
            this.archiveRemover.setContext(this.context);
            computeCurrentPeriodsHighestCounterValue(FileFilterUtil.afterLastSlash(this.tbrp.fileNamePattern.toRegexForFixedDate(this.dateInCurrentPeriod)));
            if (isErrorFree()) {
                this.started = true;
            }
        }
    }

    private boolean validateDateAndIntegerTokens() {
        boolean inError = false;
        if (this.tbrp.fileNamePattern.getIntegerTokenConverter() == null) {
            inError = true;
            addError(MISSING_INT_TOKEN + this.tbrp.fileNamePatternStr + "]");
            addError(CoreConstants.SEE_MISSING_INTEGER_TOKEN);
        }
        if (this.tbrp.fileNamePattern.getPrimaryDateTokenConverter() == null) {
            inError = true;
            addError(MISSING_DATE_TOKEN + this.tbrp.fileNamePatternStr + "]");
        }
        return !inError;
    }

    protected ArchiveRemover createArchiveRemover() {
        return new SizeAndTimeBasedArchiveRemover(this.tbrp.fileNamePattern, this.f16rc);
    }

    void computeCurrentPeriodsHighestCounterValue(String stemRegex) {
        File[] matchingFileArray = FileFilterUtil.filesInFolderMatchingStemRegex(new File(getCurrentPeriodsFileNameWithoutCompressionSuffix()).getParentFile(), stemRegex);
        if (matchingFileArray == null || matchingFileArray.length == 0) {
            this.currentPeriodsCounter = 0;
            return;
        }
        this.currentPeriodsCounter = FileFilterUtil.findHighestCounter(matchingFileArray, stemRegex);
        if (this.tbrp.getParentsRawFileProperty() != null || this.tbrp.compressionMode != CompressionMode.NONE) {
            this.currentPeriodsCounter++;
        }
    }

    @Override // p001ch.qos.logback.core.rolling.TriggeringPolicy
    public boolean isTriggeringEvent(File activeFile, E event) {
        long time = getCurrentTime();
        if (time >= this.nextCheck) {
            this.elapsedPeriodsFileName = this.tbrp.fileNamePatternWithoutCompSuffix.convertMultipleArguments(this.dateInCurrentPeriod, Integer.valueOf(this.currentPeriodsCounter));
            this.currentPeriodsCounter = 0;
            setDateInCurrentPeriod(time);
            computeNextCheck();
            return true;
        } else if (this.invocationGate.isTooSoon(time)) {
            return false;
        } else {
            if (activeFile == null) {
                addWarn("activeFile == null");
                return false;
            } else if (this.maxFileSize == null) {
                addWarn("maxFileSize = null");
                return false;
            } else if (activeFile.length() < this.maxFileSize.getSize()) {
                return false;
            } else {
                this.elapsedPeriodsFileName = this.tbrp.fileNamePatternWithoutCompSuffix.convertMultipleArguments(this.dateInCurrentPeriod, Integer.valueOf(this.currentPeriodsCounter));
                this.currentPeriodsCounter++;
                return true;
            }
        }
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase, p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public String getCurrentPeriodsFileNameWithoutCompressionSuffix() {
        return this.tbrp.fileNamePatternWithoutCompSuffix.convertMultipleArguments(this.dateInCurrentPeriod, Integer.valueOf(this.currentPeriodsCounter));
    }

    public void setMaxFileSize(FileSize aMaxFileSize) {
        this.maxFileSize = aMaxFileSize;
    }
}
