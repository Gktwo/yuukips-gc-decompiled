package org.quartz.jobs;

import java.io.File;
import java.net.URL;
import java.net.URLDecoder;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
/* loaded from: grasscutter.jar:org/quartz/jobs/FileScanJob.class */
public class FileScanJob implements Job {
    public static final String FILE_NAME = "FILE_NAME";
    public static final String FILE_SCAN_LISTENER_NAME = "FILE_SCAN_LISTENER_NAME";
    public static final String MINIMUM_UPDATE_AGE = "MINIMUM_UPDATE_AGE";
    private static final String LAST_MODIFIED_TIME = "LAST_MODIFIED_TIME";
    private final Logger log = LoggerFactory.getLogger(getClass());

    /* JADX WARN: Type inference failed for: r0v49, types: [long] */
    /* JADX WARN: Type inference failed for: r0v51, types: [long] */
    @Override // org.quartz.Job
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
        try {
            SchedulerContext schedCtxt = context.getScheduler().getContext();
            String fileName = mergedJobDataMap.getString(FILE_NAME);
            String listenerName = mergedJobDataMap.getString(FILE_SCAN_LISTENER_NAME);
            if (fileName == null) {
                throw new JobExecutionException("Required parameter 'FILE_NAME' not found in merged JobDataMap");
            } else if (listenerName == null) {
                throw new JobExecutionException("Required parameter 'FILE_SCAN_LISTENER_NAME' not found in merged JobDataMap");
            } else {
                FileScanListener listener = (FileScanListener) schedCtxt.get(listenerName);
                if (listener == null) {
                    throw new JobExecutionException("FileScanListener named '" + listenerName + "' not found in SchedulerContext");
                }
                char c = 65535;
                if (mergedJobDataMap.containsKey(LAST_MODIFIED_TIME)) {
                    c = mergedJobDataMap.getLong(LAST_MODIFIED_TIME);
                }
                char c2 = 5000;
                if (mergedJobDataMap.containsKey("MINIMUM_UPDATE_AGE")) {
                    c2 = mergedJobDataMap.getLong("MINIMUM_UPDATE_AGE");
                }
                long maxAgeDate = System.currentTimeMillis() + c2;
                long newDate = getLastModifiedDate(fileName);
                if (newDate < 0) {
                    this.log.warn("File '" + fileName + "' does not exist.");
                    return;
                }
                if (c > 0 && newDate > c && newDate < maxAgeDate) {
                    this.log.info("File '" + fileName + "' updated, notifying listener.");
                    listener.fileUpdated(fileName);
                } else if (this.log.isDebugEnabled()) {
                    this.log.debug("File '" + fileName + "' unchanged.");
                }
                context.getJobDetail().getJobDataMap().put(LAST_MODIFIED_TIME, newDate);
            }
        } catch (SchedulerException e) {
            throw new JobExecutionException("Error obtaining scheduler context.", e, false);
        }
    }

    protected long getLastModifiedDate(String fileName) {
        URL resource = Thread.currentThread().getContextClassLoader().getResource(fileName);
        String filePath = resource == null ? fileName : URLDecoder.decode(resource.getFile());
        if (filePath.indexOf(33) > 0) {
            filePath = filePath.substring(5, filePath.indexOf(33));
        }
        File file = new File(filePath);
        if (!file.exists()) {
            return -1;
        }
        return file.lastModified();
    }
}
