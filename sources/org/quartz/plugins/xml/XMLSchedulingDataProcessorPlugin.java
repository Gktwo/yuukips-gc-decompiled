package org.quartz.plugins.xml;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import javax.transaction.UserTransaction;
import net.bytebuddy.utility.JavaConstant;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.jobs.FileScanJob;
import org.quartz.jobs.FileScanListener;
import org.quartz.plugins.SchedulerPluginWithUserTransactionSupport;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/quartz/plugins/xml/XMLSchedulingDataProcessorPlugin.class */
public class XMLSchedulingDataProcessorPlugin extends SchedulerPluginWithUserTransactionSupport implements FileScanListener {
    private static final int MAX_JOB_TRIGGER_NAME_LEN = 80;
    private static final String JOB_INITIALIZATION_PLUGIN_NAME = "JobSchedulingDataLoaderPlugin";
    private static final String FILE_NAME_DELIMITERS = ",";
    private boolean failOnFileNotFound = true;
    private String fileNames = XMLSchedulingDataProcessor.QUARTZ_XML_DEFAULT_FILE_NAME;
    private Map<String, JobFile> jobFiles = new LinkedHashMap();
    private long scanInterval = 0;
    boolean started = false;
    protected ClassLoadHelper classLoadHelper = null;
    private Set<String> jobTriggerNameSet = new HashSet();

    public String getFileNames() {
        return this.fileNames;
    }

    public void setFileNames(String fileNames) {
        this.fileNames = fileNames;
    }

    public long getScanInterval() {
        return this.scanInterval / 1000;
    }

    public void setScanInterval(long scanInterval) {
        this.scanInterval = scanInterval * 1000;
    }

    public boolean isFailOnFileNotFound() {
        return this.failOnFileNotFound;
    }

    public void setFailOnFileNotFound(boolean failOnFileNotFound) {
        this.failOnFileNotFound = failOnFileNotFound;
    }

    @Override // org.quartz.spi.SchedulerPlugin
    public void initialize(String name, Scheduler scheduler, ClassLoadHelper schedulerFactoryClassLoadHelper) throws SchedulerException {
        initialize(name, scheduler);
        this.classLoadHelper = schedulerFactoryClassLoadHelper;
        getLog().info("Registering Quartz Job Initialization Plug-in.");
        StringTokenizer stok = new StringTokenizer(this.fileNames, FILE_NAME_DELIMITERS);
        while (stok.hasMoreTokens()) {
            String fileName = stok.nextToken();
            this.jobFiles.put(fileName, new JobFile(fileName));
        }
    }

    @Override // org.quartz.plugins.SchedulerPluginWithUserTransactionSupport
    public void start(UserTransaction userTransaction) {
        try {
            try {
                if (!this.jobFiles.isEmpty()) {
                    if (this.scanInterval > 0) {
                        getScheduler().getContext().put("JobSchedulingDataLoaderPlugin_" + getName(), (Object) this);
                    }
                    for (JobFile jobFile : this.jobFiles.values()) {
                        if (this.scanInterval > 0) {
                            String jobTriggerName = buildJobTriggerName(jobFile.getFileBasename());
                            TriggerKey tKey = new TriggerKey(jobTriggerName, JOB_INITIALIZATION_PLUGIN_NAME);
                            getScheduler().unscheduleJob(tKey);
                            JobDetail job = JobBuilder.newJob().withIdentity(jobTriggerName, JOB_INITIALIZATION_PLUGIN_NAME).ofType(FileScanJob.class).usingJobData(FileScanJob.FILE_NAME, jobFile.getFileName()).usingJobData(FileScanJob.FILE_SCAN_LISTENER_NAME, "JobSchedulingDataLoaderPlugin_" + getName()).build();
                            getScheduler().scheduleJob(job, (SimpleTrigger) TriggerBuilder.newTrigger().withIdentity(tKey).withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever().withIntervalInMilliseconds(this.scanInterval)).forJob(job).build());
                            getLog().debug("Scheduled file scan job for data file: {}, at interval: {}", jobFile.getFileName(), Long.valueOf(this.scanInterval));
                        }
                        processFile(jobFile);
                    }
                }
            } catch (SchedulerException se) {
                getLog().error("Error starting background-task for watching jobs file.", (Throwable) se);
                this.started = true;
            }
        } finally {
            this.started = true;
        }
    }

    private String buildJobTriggerName(String fileBasename) {
        String jobTriggerName = "JobSchedulingDataLoaderPlugin_" + getName() + '_' + fileBasename.replace('.', '_');
        if (jobTriggerName.length() > 80) {
            jobTriggerName = jobTriggerName.substring(0, 80);
        }
        int currentIndex = 1;
        while (!this.jobTriggerNameSet.add(jobTriggerName)) {
            if (currentIndex > 1) {
                jobTriggerName = jobTriggerName.substring(0, jobTriggerName.lastIndexOf(95));
            }
            currentIndex++;
            String numericSuffix = JavaConstant.Dynamic.DEFAULT_NAME + currentIndex;
            if (jobTriggerName.length() > 80 - numericSuffix.length()) {
                jobTriggerName = jobTriggerName.substring(0, 80 - numericSuffix.length());
            }
            jobTriggerName = jobTriggerName + numericSuffix;
        }
        return jobTriggerName;
    }

    @Override // org.quartz.plugins.SchedulerPluginWithUserTransactionSupport, org.quartz.spi.SchedulerPlugin
    public void shutdown() {
    }

    private void processFile(JobFile jobFile) {
        if (jobFile != null && jobFile.getFileFound()) {
            try {
                XMLSchedulingDataProcessor processor = new XMLSchedulingDataProcessor(this.classLoadHelper);
                processor.addJobGroupToNeverDelete(JOB_INITIALIZATION_PLUGIN_NAME);
                processor.addTriggerGroupToNeverDelete(JOB_INITIALIZATION_PLUGIN_NAME);
                processor.processFileAndScheduleJobs(jobFile.getFileName(), jobFile.getFileName(), getScheduler());
            } catch (Exception e) {
                getLog().error("Error scheduling jobs: " + e.getMessage(), (Throwable) e);
            }
        }
    }

    public void processFile(String filePath) {
        processFile(this.jobFiles.get(filePath));
    }

    @Override // org.quartz.jobs.FileScanListener
    public void fileUpdated(String fileName) {
        if (this.started) {
            processFile(fileName);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/quartz/plugins/xml/XMLSchedulingDataProcessorPlugin$JobFile.class */
    public class JobFile {
        private String fileName;
        private String filePath;
        private String fileBasename;
        private boolean fileFound;

        protected JobFile(String fileName) throws SchedulerException {
            this.fileName = fileName;
            initialize();
        }

        protected String getFileName() {
            return this.fileName;
        }

        protected boolean getFileFound() {
            return this.fileFound;
        }

        protected String getFilePath() {
            return this.filePath;
        }

        protected String getFileBasename() {
            return this.fileBasename;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x003c
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        private void initialize() throws org.quartz.SchedulerException {
            /*
            // Method dump skipped, instructions count: 330
            */
            throw new UnsupportedOperationException("Method not decompiled: org.quartz.plugins.xml.XMLSchedulingDataProcessorPlugin.JobFile.initialize():void");
        }
    }
}
