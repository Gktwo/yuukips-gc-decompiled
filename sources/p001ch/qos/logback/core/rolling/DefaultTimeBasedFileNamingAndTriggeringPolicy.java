package p001ch.qos.logback.core.rolling;

import java.io.File;
import java.util.Date;
import p001ch.qos.logback.core.joran.spi.NoAutoStart;
import p001ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover;

@NoAutoStart
/* renamed from: ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/DefaultTimeBasedFileNamingAndTriggeringPolicy.class */
public class DefaultTimeBasedFileNamingAndTriggeringPolicy<E> extends TimeBasedFileNamingAndTriggeringPolicyBase<E> {
    @Override // p001ch.qos.logback.core.rolling.TimeBasedFileNamingAndTriggeringPolicyBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        start();
        if (isErrorFree()) {
            if (this.tbrp.fileNamePattern.hasIntegerTokenCOnverter()) {
                addError("Filename pattern [" + this.tbrp.fileNamePattern + "] contains an integer token converter, i.e. %i, INCOMPATIBLE with this configuration. Remove it.");
                return;
            }
            this.archiveRemover = new TimeBasedArchiveRemover(this.tbrp.fileNamePattern, this.f16rc);
            this.archiveRemover.setContext(this.context);
            this.started = true;
        }
    }

    @Override // p001ch.qos.logback.core.rolling.TriggeringPolicy
    public boolean isTriggeringEvent(File activeFile, E event) {
        long time = getCurrentTime();
        if (time < this.nextCheck) {
            return false;
        }
        Date dateOfElapsedPeriod = this.dateInCurrentPeriod;
        addInfo("Elapsed period: " + dateOfElapsedPeriod);
        this.elapsedPeriodsFileName = this.tbrp.fileNamePatternWithoutCompSuffix.convert(dateOfElapsedPeriod);
        setDateInCurrentPeriod(time);
        computeNextCheck();
        return true;
    }

    public String toString() {
        return "c.q.l.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy";
    }
}
