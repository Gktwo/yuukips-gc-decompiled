package org.quartz.jobs;

import java.io.File;
import java.io.FileFilter;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.PersistJobDataAfterExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
/* loaded from: grasscutter.jar:org/quartz/jobs/DirectoryScanJob.class */
public class DirectoryScanJob implements Job {
    public static final String DIRECTORY_NAME = "DIRECTORY_NAME";
    public static final String DIRECTORY_SCAN_LISTENER_NAME = "DIRECTORY_SCAN_LISTENER_NAME";
    public static final String MINIMUM_UPDATE_AGE = "MINIMUM_UPDATE_AGE";
    private static final String LAST_MODIFIED_TIME = "LAST_MODIFIED_TIME";
    private final Logger log = LoggerFactory.getLogger(getClass());

    /* JADX WARN: Type inference failed for: r0v50, types: [long] */
    /* JADX WARN: Type inference failed for: r0v59, types: [long] */
    /* JADX WARN: Type inference failed for: r0v61, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // org.quartz.Job
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void execute(org.quartz.JobExecutionContext r8) throws org.quartz.JobExecutionException {
        /*
        // Method dump skipped, instructions count: 415
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.jobs.DirectoryScanJob.execute(org.quartz.JobExecutionContext):void");
    }

    protected File[] getUpdatedOrNewFiles(String dirName, final long lastDate, final long maxAgeDate) {
        File dir = new File(dirName);
        if (!dir.exists() || !dir.isDirectory()) {
            return null;
        }
        File[] files = dir.listFiles(new FileFilter() { // from class: org.quartz.jobs.DirectoryScanJob.1
            @Override // java.io.FileFilter
            public boolean accept(File pathname) {
                if (pathname.lastModified() <= lastDate || pathname.lastModified() >= maxAgeDate) {
                    return false;
                }
                return true;
            }
        });
        if (files == null) {
            files = new File[0];
        }
        return files;
    }
}
