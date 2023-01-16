package p001ch.qos.logback.core.rolling;

import java.io.File;
import java.util.Date;
import java.util.Locale;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.rolling.helper.ArchiveRemover;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;
import p001ch.qos.logback.core.rolling.helper.RollingCalendar;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/TimeBasedFileNamingAndTriggeringPolicyBase.class */
public abstract class TimeBasedFileNamingAndTriggeringPolicyBase<E> extends ContextAwareBase implements TimeBasedFileNamingAndTriggeringPolicy<E> {
    private static String COLLIDING_DATE_FORMAT_URL = "http://logback.qos.ch/codes.html#rfa_collision_in_dateFormat";
    protected TimeBasedRollingPolicy<E> tbrp;
    protected String elapsedPeriodsFileName;

    /* renamed from: rc */
    protected RollingCalendar f16rc;
    protected long nextCheck;
    protected ArchiveRemover archiveRemover = null;
    protected long artificialCurrentTime = -1;
    protected Date dateInCurrentPeriod = null;
    protected boolean started = false;
    protected boolean errorFree = true;

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        DateTokenConverter<Object> dtc = this.tbrp.fileNamePattern.getPrimaryDateTokenConverter();
        if (dtc == null) {
            throw new IllegalStateException("FileNamePattern [" + this.tbrp.fileNamePattern.getPattern() + "] does not contain a valid DateToken");
        }
        if (dtc.getTimeZone() != null) {
            this.f16rc = new RollingCalendar(dtc.getDatePattern(), dtc.getTimeZone(), Locale.getDefault());
        } else {
            this.f16rc = new RollingCalendar(dtc.getDatePattern());
        }
        addInfo("The date pattern is '" + dtc.getDatePattern() + "' from file name pattern '" + this.tbrp.fileNamePattern.getPattern() + "'.");
        this.f16rc.printPeriodicity(this);
        if (!this.f16rc.isCollisionFree()) {
            addError("The date format in FileNamePattern will result in collisions in the names of archived log files.");
            addError(CoreConstants.MORE_INFO_PREFIX + COLLIDING_DATE_FORMAT_URL);
            withErrors();
            return;
        }
        setDateInCurrentPeriod(new Date(getCurrentTime()));
        if (this.tbrp.getParentsRawFileProperty() != null) {
            File currentFile = new File(this.tbrp.getParentsRawFileProperty());
            if (currentFile.exists() && currentFile.canRead()) {
                setDateInCurrentPeriod(new Date(currentFile.lastModified()));
            }
        }
        addInfo("Setting initial period to " + this.dateInCurrentPeriod);
        computeNextCheck();
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }

    protected void computeNextCheck() {
        this.nextCheck = this.f16rc.getNextTriggeringDate(this.dateInCurrentPeriod).getTime();
    }

    protected void setDateInCurrentPeriod(long now) {
        this.dateInCurrentPeriod.setTime(now);
    }

    public void setDateInCurrentPeriod(Date _dateInCurrentPeriod) {
        this.dateInCurrentPeriod = _dateInCurrentPeriod;
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public String getElapsedPeriodsFileName() {
        return this.elapsedPeriodsFileName;
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public String getCurrentPeriodsFileNameWithoutCompressionSuffix() {
        return this.tbrp.fileNamePatternWithoutCompSuffix.convert(this.dateInCurrentPeriod);
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public void setCurrentTime(long timeInMillis) {
        this.artificialCurrentTime = timeInMillis;
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public long getCurrentTime() {
        if (this.artificialCurrentTime >= 0) {
            return this.artificialCurrentTime;
        }
        return System.currentTimeMillis();
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public void setTimeBasedRollingPolicy(TimeBasedRollingPolicy<E> _tbrp) {
        this.tbrp = _tbrp;
    }

    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicy
    public ArchiveRemover getArchiveRemover() {
        return this.archiveRemover;
    }

    protected void withErrors() {
        this.errorFree = false;
    }

    /* access modifiers changed from: protected */
    public boolean isErrorFree() {
        return this.errorFree;
    }
}
