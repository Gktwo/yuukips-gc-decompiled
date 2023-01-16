package p001ch.qos.logback.core.rolling.helper;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.concurrent.Future;
import p001ch.qos.logback.core.pattern.Converter;
import p001ch.qos.logback.core.pattern.LiteralConverter;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.util.FileSize;

/* renamed from: ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/TimeBasedArchiveRemover.class */
public class TimeBasedArchiveRemover extends ContextAwareBase implements ArchiveRemover {
    protected static final long UNINITIALIZED = -1;
    protected static final long INACTIVITY_TOLERANCE_IN_MILLIS = 2764800000L;
    static final int MAX_VALUE_FOR_INACTIVITY_PERIODS = 336;
    final FileNamePattern fileNamePattern;

    /* renamed from: rc */
    final RollingCalendar f18rc;
    final boolean parentClean;
    private int maxHistory = 0;
    private long totalSizeCap = 0;
    long lastHeartBeat = -1;
    int callCount = 0;

    public TimeBasedArchiveRemover(FileNamePattern fileNamePattern, RollingCalendar rc) {
        this.fileNamePattern = fileNamePattern;
        this.f18rc = rc;
        this.parentClean = computeParentCleaningFlag(fileNamePattern);
    }

    @Override // p001ch.qos.logback.core.rolling.helper.ArchiveRemover
    public void clean(Date now) {
        long nowInMillis = now.getTime();
        int periodsElapsed = computeElapsedPeriodsSinceLastClean(nowInMillis);
        this.lastHeartBeat = nowInMillis;
        if (periodsElapsed > 1) {
            addInfo("Multiple periods, i.e. " + periodsElapsed + " periods, seem to have elapsed. This is expected at application start.");
        }
        for (int i = 0; i < periodsElapsed; i++) {
            cleanPeriod(this.f18rc.getEndOfNextNthPeriod(now, getPeriodOffsetForDeletionTarget() - i));
        }
    }

    protected File[] getFilesInPeriod(Date dateOfPeriodToClean) {
        File file2Delete = new File(this.fileNamePattern.convert(dateOfPeriodToClean));
        return fileExistsAndIsFile(file2Delete) ? new File[]{file2Delete} : new File[0];
    }

    private boolean fileExistsAndIsFile(File file2Delete) {
        return file2Delete.exists() && file2Delete.isFile();
    }

    public void cleanPeriod(Date dateOfPeriodToClean) {
        File[] matchingFileArray = getFilesInPeriod(dateOfPeriodToClean);
        for (File f : matchingFileArray) {
            addInfo("deleting " + f);
            f.delete();
        }
        if (this.parentClean && matchingFileArray.length > 0) {
            removeFolderIfEmpty(getParentDir(matchingFileArray[0]));
        }
    }

    /* JADX WARN: Type inference failed for: r0v24, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    void capTotalSize(Date now) {
        char c = 0;
        char c2 = 0;
        for (int offset = 0; offset < this.maxHistory; offset++) {
            File[] matchingFileArray = getFilesInPeriod(this.f18rc.getEndOfNextNthPeriod(now, -offset));
            descendingSortByLastModified(matchingFileArray);
            for (File f : matchingFileArray) {
                long size = f.length();
                if (c + size > this.totalSizeCap) {
                    addInfo("Deleting [" + f + "] of size " + new FileSize(size));
                    c2 += size;
                    f.delete();
                }
                c += size;
            }
        }
        addInfo("Removed  " + new FileSize(c2) + " of files");
    }

    private void descendingSortByLastModified(File[] matchingFileArray) {
        Arrays.sort(matchingFileArray, new Comparator<File>() { // from class: ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover.1
            public int compare(File f1, File f2) {
                long l1 = f1.lastModified();
                long l2 = f2.lastModified();
                if (l1 == l2) {
                    return 0;
                }
                if (l2 < l1) {
                    return -1;
                }
                return 1;
            }
        });
    }

    File getParentDir(File file) {
        return file.getAbsoluteFile().getParentFile();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r0v14, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r11v5 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int computeElapsedPeriodsSinceLastClean(long r9) {
        /*
            r8 = this;
            r0 = 0
            r11 = r0
            r0 = r8
            long r0 = r0.lastHeartBeat
            r1 = -1
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x002c
            r0 = r8
            java.lang.String r1 = "first clean up after appender initialization"
            r0.addInfo(r1)
            r0 = r8
            ch.qos.logback.core.rolling.helper.RollingCalendar r0 = r0.f18rc
            r1 = r9
            r2 = r9
            r3 = 2764800000(0xa4cb8000, double:1.3659926976E-314)
            long r2 = r2 + r3
            long r0 = r0.periodBarriersCrossed(r1, r2)
            r11 = r0
            r0 = r11
            r1 = 336(0x150, double:1.66E-321)
            long r0 = java.lang.Math.min(r0, r1)
            r11 = r0
            goto L_0x0039
        L_0x002c:
            r0 = r8
            ch.qos.logback.core.rolling.helper.RollingCalendar r0 = r0.f18rc
            r1 = r8
            long r1 = r1.lastHeartBeat
            r2 = r9
            long r0 = r0.periodBarriersCrossed(r1, r2)
            r11 = r0
        L_0x0039:
            r0 = r11
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p001ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover.computeElapsedPeriodsSinceLastClean(long):int");
    }

    boolean computeParentCleaningFlag(FileNamePattern fileNamePattern) {
        if (fileNamePattern.getPrimaryDateTokenConverter().getDatePattern().indexOf(47) != -1) {
            return true;
        }
        Converter<Object> p = fileNamePattern.headTokenConverter;
        while (p != null && !(p instanceof DateTokenConverter)) {
            p = p.getNext();
        }
        while (p != null) {
            if ((p instanceof LiteralConverter) && p.convert(null).indexOf(47) != -1) {
                return true;
            }
            p = p.getNext();
        }
        return false;
    }

    void removeFolderIfEmpty(File dir) {
        removeFolderIfEmpty(dir, 0);
    }

    private void removeFolderIfEmpty(File dir, int depth) {
        if (depth < 3 && dir.isDirectory() && FileFilterUtil.isEmptyDirectory(dir)) {
            addInfo("deleting folder [" + dir + "]");
            dir.delete();
            removeFolderIfEmpty(dir.getParentFile(), depth + 1);
        }
    }

    @Override // p001ch.qos.logback.core.rolling.helper.ArchiveRemover
    public void setMaxHistory(int maxHistory) {
        this.maxHistory = maxHistory;
    }

    protected int getPeriodOffsetForDeletionTarget() {
        return (-this.maxHistory) - 1;
    }

    @Override // p001ch.qos.logback.core.rolling.helper.ArchiveRemover
    public void setTotalSizeCap(long totalSizeCap) {
        this.totalSizeCap = totalSizeCap;
    }

    public String toString() {
        return "c.q.l.core.rolling.helper.TimeBasedArchiveRemover";
    }

    @Override // p001ch.qos.logback.core.rolling.helper.ArchiveRemover
    public Future<?> cleanAsynchronously(Date now) {
        return this.context.getScheduledExecutorService().submit(new ArhiveRemoverRunnable(now));
    }

    /* renamed from: ch.qos.logback.core.rolling.helper.TimeBasedArchiveRemover$ArhiveRemoverRunnable */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/TimeBasedArchiveRemover$ArhiveRemoverRunnable.class */
    public class ArhiveRemoverRunnable implements Runnable {
        Date now;

        ArhiveRemoverRunnable(Date now) {
            this.now = now;
        }

        @Override // java.lang.Runnable
        public void run() {
            TimeBasedArchiveRemover.this.clean(this.now);
            if (TimeBasedArchiveRemover.this.totalSizeCap != 0 && TimeBasedArchiveRemover.this.totalSizeCap > 0) {
                TimeBasedArchiveRemover.this.capTotalSize(this.now);
            }
        }
    }
}
