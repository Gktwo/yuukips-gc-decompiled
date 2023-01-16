package p001ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.Date;

/* renamed from: ch.qos.logback.core.rolling.helper.SizeAndTimeBasedArchiveRemover */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/SizeAndTimeBasedArchiveRemover.class */
public class SizeAndTimeBasedArchiveRemover extends TimeBasedArchiveRemover {
    public SizeAndTimeBasedArchiveRemover(FileNamePattern fileNamePattern, RollingCalendar rc) {
        super(fileNamePattern, rc);
    }

    @Override // p001ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover
    protected File[] getFilesInPeriod(Date dateOfPeriodToClean) {
        return FileFilterUtil.filesInFolderMatchingStemRegex(getParentDir(new File(this.fileNamePattern.convertMultipleArguments(dateOfPeriodToClean, 0))), createStemRegex(dateOfPeriodToClean));
    }

    private String createStemRegex(Date dateOfPeriodToClean) {
        return FileFilterUtil.afterLastSlash(this.fileNamePattern.toRegexForFixedDate(dateOfPeriodToClean));
    }
}
