package org.quartz.xml;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import javax.xml.bind.DatatypeConverter;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.quartz.CalendarIntervalScheduleBuilder;
import org.quartz.CronScheduleBuilder;
import org.quartz.DateBuilder;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.MutableTrigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/* loaded from: grasscutter.jar:org/quartz/xml/XMLSchedulingDataProcessor.class */
public class XMLSchedulingDataProcessor implements ErrorHandler {
    public static final String QUARTZ_NS = "http://www.quartz-scheduler.org/xml/JobSchedulingData";
    public static final String QUARTZ_SCHEMA_WEB_URL = "http://www.quartz-scheduler.org/xml/job_scheduling_data_2_0.xsd";
    public static final String QUARTZ_XSD_PATH_IN_JAR = "org/quartz/xml/job_scheduling_data_2_0.xsd";
    public static final String QUARTZ_XML_DEFAULT_FILE_NAME = "quartz_data.xml";
    public static final String QUARTZ_SYSTEM_ID_JAR_PREFIX = "jar:";
    protected ClassLoadHelper classLoadHelper;
    protected List<String> jobGroupsToDelete = new LinkedList();
    protected List<String> triggerGroupsToDelete = new LinkedList();
    protected List<JobKey> jobsToDelete = new LinkedList();
    protected List<TriggerKey> triggersToDelete = new LinkedList();
    protected List<JobDetail> loadedJobs = new LinkedList();
    protected List<MutableTrigger> loadedTriggers = new LinkedList();
    private boolean overWriteExistingData = true;
    private boolean ignoreDuplicates = false;
    protected Collection<Exception> validationExceptions = new ArrayList();
    protected List<String> jobGroupsToNeverDelete = new LinkedList();
    protected List<String> triggerGroupsToNeverDelete = new LinkedList();
    private DocumentBuilder docBuilder = null;
    private XPath xpath = null;
    private final Logger log = LoggerFactory.getLogger(getClass());

    public XMLSchedulingDataProcessor(ClassLoadHelper clh) throws ParserConfigurationException {
        this.classLoadHelper = clh;
        initDocumentParser();
    }

    protected void initDocumentParser() throws ParserConfigurationException {
        DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
        docBuilderFactory.setNamespaceAware(true);
        docBuilderFactory.setValidating(true);
        docBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");
        docBuilderFactory.setAttribute("http://java.sun.com/xml/jaxp/properties/schemaSource", resolveSchemaSource());
        docBuilderFactory.setFeature("http://apache.org/xml/features/disallow-doctype-decl", true);
        docBuilderFactory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
        docBuilderFactory.setFeature("http://xml.org/sax/features/external-general-entities", false);
        docBuilderFactory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        docBuilderFactory.setXIncludeAware(false);
        docBuilderFactory.setExpandEntityReferences(false);
        this.docBuilder = docBuilderFactory.newDocumentBuilder();
        this.docBuilder.setErrorHandler(this);
        NamespaceContext nsContext = new NamespaceContext() { // from class: org.quartz.xml.XMLSchedulingDataProcessor.1
            @Override // javax.xml.namespace.NamespaceContext
            public String getNamespaceURI(String prefix) {
                if (prefix == null) {
                    throw new IllegalArgumentException("Null prefix");
                } else if ("xml".equals(prefix)) {
                    return "http://www.w3.org/XML/1998/namespace";
                } else {
                    if ("xmlns".equals(prefix)) {
                        return "http://www.w3.org/2000/xmlns/";
                    }
                    if ("q".equals(prefix)) {
                        return XMLSchedulingDataProcessor.QUARTZ_NS;
                    }
                    return "";
                }
            }

            @Override // javax.xml.namespace.NamespaceContext
            public Iterator<?> getPrefixes(String namespaceURI) {
                throw new UnsupportedOperationException();
            }

            @Override // javax.xml.namespace.NamespaceContext
            public String getPrefix(String namespaceURI) {
                throw new UnsupportedOperationException();
            }
        };
        this.xpath = XPathFactory.newInstance().newXPath();
        this.xpath.setNamespaceContext(nsContext);
    }

    protected Object resolveSchemaSource() {
        InputStream is = null;
        try {
            is = this.classLoadHelper.getResourceAsStream(QUARTZ_XSD_PATH_IN_JAR);
            if (is != null) {
                InputSource inputSource = new InputSource(is);
                inputSource.setSystemId(QUARTZ_SCHEMA_WEB_URL);
                this.log.debug("Utilizing schema packaged in local quartz distribution jar.");
                return inputSource;
            }
            this.log.info("Unable to load local schema packaged in quartz distribution jar. Utilizing schema online at http://www.quartz-scheduler.org/xml/job_scheduling_data_2_0.xsd");
            return QUARTZ_SCHEMA_WEB_URL;
        } catch (Throwable th) {
            if (is != null) {
                new InputSource(is).setSystemId(QUARTZ_SCHEMA_WEB_URL);
                this.log.debug("Utilizing schema packaged in local quartz distribution jar.");
                throw th;
            }
            this.log.info("Unable to load local schema packaged in quartz distribution jar. Utilizing schema online at http://www.quartz-scheduler.org/xml/job_scheduling_data_2_0.xsd");
            return QUARTZ_SCHEMA_WEB_URL;
        }
    }

    public boolean isOverWriteExistingData() {
        return this.overWriteExistingData;
    }

    protected void setOverWriteExistingData(boolean overWriteExistingData) {
        this.overWriteExistingData = overWriteExistingData;
    }

    public boolean isIgnoreDuplicates() {
        return this.ignoreDuplicates;
    }

    public void setIgnoreDuplicates(boolean ignoreDuplicates) {
        this.ignoreDuplicates = ignoreDuplicates;
    }

    public void addJobGroupToNeverDelete(String group) {
        if (group != null) {
            this.jobGroupsToNeverDelete.add(group);
        }
    }

    public boolean removeJobGroupToNeverDelete(String group) {
        return group != null && this.jobGroupsToNeverDelete.remove(group);
    }

    public List<String> getJobGroupsToNeverDelete() {
        return Collections.unmodifiableList(this.jobGroupsToDelete);
    }

    public void addTriggerGroupToNeverDelete(String group) {
        if (group != null) {
            this.triggerGroupsToNeverDelete.add(group);
        }
    }

    public boolean removeTriggerGroupToNeverDelete(String group) {
        if (group != null) {
            return this.triggerGroupsToNeverDelete.remove(group);
        }
        return false;
    }

    public List<String> getTriggerGroupsToNeverDelete() {
        return Collections.unmodifiableList(this.triggerGroupsToDelete);
    }

    protected void processFile() throws Exception {
        processFile(QUARTZ_XML_DEFAULT_FILE_NAME);
    }

    protected void processFile(String fileName) throws Exception {
        processFile(fileName, getSystemIdForFileName(fileName));
    }

    protected String getSystemIdForFileName(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            try {
                new FileInputStream(file).close();
                return file.toURI().toString();
            } catch (IOException e) {
                return fileName;
            }
        } else {
            URL url = getURL(fileName);
            if (url == null) {
                return fileName;
            }
            try {
                url.openStream().close();
                return url.toString();
            } catch (IOException e2) {
                return fileName;
            }
        }
    }

    protected URL getURL(String fileName) {
        return this.classLoadHelper.getResource(fileName);
    }

    protected void prepForProcessing() {
        clearValidationExceptions();
        setOverWriteExistingData(true);
        setIgnoreDuplicates(false);
        this.jobGroupsToDelete.clear();
        this.jobsToDelete.clear();
        this.triggerGroupsToDelete.clear();
        this.triggersToDelete.clear();
        this.loadedJobs.clear();
        this.loadedTriggers.clear();
    }

    protected void processFile(String fileName, String systemId) throws ValidationException, ParserConfigurationException, SAXException, IOException, SchedulerException, ClassNotFoundException, ParseException, XPathException {
        prepForProcessing();
        this.log.info("Parsing XML file: " + fileName + " with systemId: " + systemId);
        InputSource is = new InputSource(getInputStream(fileName));
        is.setSystemId(systemId);
        process(is);
        maybeThrowValidationException();
    }

    public void processStreamAndScheduleJobs(InputStream stream, String systemId, Scheduler sched) throws ValidationException, ParserConfigurationException, SAXException, XPathException, IOException, SchedulerException, ClassNotFoundException, ParseException {
        prepForProcessing();
        this.log.info("Parsing XML from stream with systemId: " + systemId);
        InputSource is = new InputSource(stream);
        is.setSystemId(systemId);
        process(is);
        executePreProcessCommands(sched);
        scheduleJobs(sched);
        maybeThrowValidationException();
    }

    protected void process(InputSource is) throws SAXException, IOException, ParseException, XPathException, ClassNotFoundException {
        Date triggerStartTime;
        ScheduleBuilder scheduleBuilder;
        Document document = this.docBuilder.parse(is);
        NodeList deleteJobGroupNodes = (NodeList) this.xpath.evaluate("/q:job-scheduling-data/q:pre-processing-commands/q:delete-jobs-in-group", document, XPathConstants.NODESET);
        this.log.debug("Found " + deleteJobGroupNodes.getLength() + " delete job group commands.");
        for (int i = 0; i < deleteJobGroupNodes.getLength(); i++) {
            String t = deleteJobGroupNodes.item(i).getTextContent();
            if (t != null) {
                String t2 = t.trim();
                if (t2.length() != 0) {
                    this.jobGroupsToDelete.add(t2);
                }
            }
        }
        NodeList deleteTriggerGroupNodes = (NodeList) this.xpath.evaluate("/q:job-scheduling-data/q:pre-processing-commands/q:delete-triggers-in-group", document, XPathConstants.NODESET);
        this.log.debug("Found " + deleteTriggerGroupNodes.getLength() + " delete trigger group commands.");
        for (int i2 = 0; i2 < deleteTriggerGroupNodes.getLength(); i2++) {
            String t3 = deleteTriggerGroupNodes.item(i2).getTextContent();
            if (t3 != null) {
                String t4 = t3.trim();
                if (t4.length() != 0) {
                    this.triggerGroupsToDelete.add(t4);
                }
            }
        }
        NodeList deleteJobNodes = (NodeList) this.xpath.evaluate("/q:job-scheduling-data/q:pre-processing-commands/q:delete-job", document, XPathConstants.NODESET);
        this.log.debug("Found " + deleteJobNodes.getLength() + " delete job commands.");
        for (int i3 = 0; i3 < deleteJobNodes.getLength(); i3++) {
            Node node = deleteJobNodes.item(i3);
            String name = getTrimmedToNullString(this.xpath, "q:name", node);
            String group = getTrimmedToNullString(this.xpath, "q:group", node);
            if (name == null) {
                throw new ParseException("Encountered a 'delete-job' command without a name specified.", -1);
            }
            this.jobsToDelete.add(new JobKey(name, group));
        }
        NodeList deleteTriggerNodes = (NodeList) this.xpath.evaluate("/q:job-scheduling-data/q:pre-processing-commands/q:delete-trigger", document, XPathConstants.NODESET);
        this.log.debug("Found " + deleteTriggerNodes.getLength() + " delete trigger commands.");
        for (int i4 = 0; i4 < deleteTriggerNodes.getLength(); i4++) {
            Node node2 = deleteTriggerNodes.item(i4);
            String name2 = getTrimmedToNullString(this.xpath, "q:name", node2);
            String group2 = getTrimmedToNullString(this.xpath, "q:group", node2);
            if (name2 == null) {
                throw new ParseException("Encountered a 'delete-trigger' command without a name specified.", -1);
            }
            this.triggersToDelete.add(new TriggerKey(name2, group2));
        }
        Boolean overWrite = getBoolean(this.xpath, "/q:job-scheduling-data/q:processing-directives/q:overwrite-existing-data", document);
        if (overWrite == null) {
            this.log.debug("Directive 'overwrite-existing-data' not specified, defaulting to " + isOverWriteExistingData());
        } else {
            this.log.debug("Directive 'overwrite-existing-data' specified as: " + overWrite);
            setOverWriteExistingData(overWrite.booleanValue());
        }
        Boolean ignoreDupes = getBoolean(this.xpath, "/q:job-scheduling-data/q:processing-directives/q:ignore-duplicates", document);
        if (ignoreDupes == null) {
            this.log.debug("Directive 'ignore-duplicates' not specified, defaulting to " + isIgnoreDuplicates());
        } else {
            this.log.debug("Directive 'ignore-duplicates' specified as: " + ignoreDupes);
            setIgnoreDuplicates(ignoreDupes.booleanValue());
        }
        NodeList jobNodes = (NodeList) this.xpath.evaluate("/q:job-scheduling-data/q:schedule/q:job", document, XPathConstants.NODESET);
        this.log.debug("Found " + jobNodes.getLength() + " job definitions.");
        for (int i5 = 0; i5 < jobNodes.getLength(); i5++) {
            Node jobDetailNode = jobNodes.item(i5);
            String jobName = getTrimmedToNullString(this.xpath, "q:name", jobDetailNode);
            String jobGroup = getTrimmedToNullString(this.xpath, "q:group", jobDetailNode);
            String jobDescription = getTrimmedToNullString(this.xpath, "q:description", jobDetailNode);
            String jobClassName = getTrimmedToNullString(this.xpath, "q:job-class", jobDetailNode);
            String t5 = getTrimmedToNullString(this.xpath, "q:durability", jobDetailNode);
            boolean jobDurability = t5 != null && t5.equals(C3P0Substitutions.DEBUG);
            String t6 = getTrimmedToNullString(this.xpath, "q:recover", jobDetailNode);
            JobDetail jobDetail = JobBuilder.newJob(this.classLoadHelper.loadClass(jobClassName, Job.class)).withIdentity(jobName, jobGroup).withDescription(jobDescription).storeDurably(jobDurability).requestRecovery(t6 != null && t6.equals(C3P0Substitutions.DEBUG)).build();
            NodeList jobDataEntries = (NodeList) this.xpath.evaluate("q:job-data-map/q:entry", jobDetailNode, XPathConstants.NODESET);
            for (int k = 0; k < jobDataEntries.getLength(); k++) {
                Node entryNode = jobDataEntries.item(k);
                jobDetail.getJobDataMap().put(getTrimmedToNullString(this.xpath, "q:key", entryNode), getTrimmedToNullString(this.xpath, "q:value", entryNode));
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Parsed job definition: " + jobDetail);
            }
            addJobToSchedule(jobDetail);
        }
        NodeList triggerEntries = (NodeList) this.xpath.evaluate("/q:job-scheduling-data/q:schedule/q:trigger/*", document, XPathConstants.NODESET);
        this.log.debug("Found " + triggerEntries.getLength() + " trigger definitions.");
        for (int j = 0; j < triggerEntries.getLength(); j++) {
            Node triggerNode = triggerEntries.item(j);
            String triggerName = getTrimmedToNullString(this.xpath, "q:name", triggerNode);
            String triggerGroup = getTrimmedToNullString(this.xpath, "q:group", triggerNode);
            String triggerDescription = getTrimmedToNullString(this.xpath, "q:description", triggerNode);
            String triggerMisfireInstructionConst = getTrimmedToNullString(this.xpath, "q:misfire-instruction", triggerNode);
            String triggerPriorityString = getTrimmedToNullString(this.xpath, "q:priority", triggerNode);
            String triggerCalendarRef = getTrimmedToNullString(this.xpath, "q:calendar-name", triggerNode);
            String triggerJobName = getTrimmedToNullString(this.xpath, "q:job-name", triggerNode);
            String triggerJobGroup = getTrimmedToNullString(this.xpath, "q:job-group", triggerNode);
            int triggerPriority = 5;
            if (triggerPriorityString != null) {
                triggerPriority = Integer.valueOf(triggerPriorityString).intValue();
            }
            String startTimeString = getTrimmedToNullString(this.xpath, "q:start-time", triggerNode);
            String startTimeFutureSecsString = getTrimmedToNullString(this.xpath, "q:start-time-seconds-in-future", triggerNode);
            String endTimeString = getTrimmedToNullString(this.xpath, "q:end-time", triggerNode);
            if (startTimeFutureSecsString != null) {
                triggerStartTime = new Date(System.currentTimeMillis() + (Long.valueOf(startTimeFutureSecsString).longValue() * 1000));
            } else {
                triggerStartTime = (startTimeString == null || startTimeString.length() == 0) ? new Date() : DatatypeConverter.parseDateTime(startTimeString).getTime();
            }
            Date triggerEndTime = (endTimeString == null || endTimeString.length() == 0) ? null : DatatypeConverter.parseDateTime(endTimeString).getTime();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroup);
            if (triggerNode.getNodeName().equals("simple")) {
                String repeatCountString = getTrimmedToNullString(this.xpath, "q:repeat-count", triggerNode);
                String repeatIntervalString = getTrimmedToNullString(this.xpath, "q:repeat-interval", triggerNode);
                scheduleBuilder = SimpleScheduleBuilder.simpleSchedule().withIntervalInMilliseconds(repeatIntervalString == null ? 0 : Long.parseLong(repeatIntervalString)).withRepeatCount(repeatCountString == null ? 0 : Integer.parseInt(repeatCountString));
                if (!(triggerMisfireInstructionConst == null || triggerMisfireInstructionConst.length() == 0)) {
                    if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_FIRE_NOW")) {
                        ((SimpleScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionFireNow();
                    } else if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_EXISTING_COUNT")) {
                        ((SimpleScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionNextWithExistingCount();
                    } else if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_RESCHEDULE_NEXT_WITH_REMAINING_COUNT")) {
                        ((SimpleScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionNextWithRemainingCount();
                    } else if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_EXISTING_REPEAT_COUNT")) {
                        ((SimpleScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionNowWithExistingCount();
                    } else if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_RESCHEDULE_NOW_WITH_REMAINING_REPEAT_COUNT")) {
                        ((SimpleScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionNowWithRemainingCount();
                    } else if (!triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_SMART_POLICY")) {
                        throw new ParseException("Unexpected/Unhandlable Misfire Instruction encountered '" + triggerMisfireInstructionConst + "', for trigger: " + triggerKey, -1);
                    }
                }
            } else if (triggerNode.getNodeName().equals("cron")) {
                String cronExpression = getTrimmedToNullString(this.xpath, "q:cron-expression", triggerNode);
                String timezoneString = getTrimmedToNullString(this.xpath, "q:time-zone", triggerNode);
                scheduleBuilder = CronScheduleBuilder.cronSchedule(cronExpression).inTimeZone(timezoneString == null ? null : TimeZone.getTimeZone(timezoneString));
                if (!(triggerMisfireInstructionConst == null || triggerMisfireInstructionConst.length() == 0)) {
                    if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_DO_NOTHING")) {
                        ((CronScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionDoNothing();
                    } else if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_FIRE_ONCE_NOW")) {
                        ((CronScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionFireAndProceed();
                    } else if (!triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_SMART_POLICY")) {
                        throw new ParseException("Unexpected/Unhandlable Misfire Instruction encountered '" + triggerMisfireInstructionConst + "', for trigger: " + triggerKey, -1);
                    }
                }
            } else if (triggerNode.getNodeName().equals("calendar-interval")) {
                scheduleBuilder = CalendarIntervalScheduleBuilder.calendarIntervalSchedule().withInterval(Integer.parseInt(getTrimmedToNullString(this.xpath, "q:repeat-interval", triggerNode)), DateBuilder.IntervalUnit.valueOf(getTrimmedToNullString(this.xpath, "q:repeat-interval-unit", triggerNode)));
                if (!(triggerMisfireInstructionConst == null || triggerMisfireInstructionConst.length() == 0)) {
                    if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_DO_NOTHING")) {
                        ((CalendarIntervalScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionDoNothing();
                    } else if (triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_FIRE_ONCE_NOW")) {
                        ((CalendarIntervalScheduleBuilder) scheduleBuilder).withMisfireHandlingInstructionFireAndProceed();
                    } else if (!triggerMisfireInstructionConst.equals("MISFIRE_INSTRUCTION_SMART_POLICY")) {
                        throw new ParseException("Unexpected/Unhandlable Misfire Instruction encountered '" + triggerMisfireInstructionConst + "', for trigger: " + triggerKey, -1);
                    }
                }
            } else {
                throw new ParseException("Unknown trigger type: " + triggerNode.getNodeName(), -1);
            }
            MutableTrigger trigger = (MutableTrigger) TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroup).withDescription(triggerDescription).forJob(triggerJobName, triggerJobGroup).startAt(triggerStartTime).endAt(triggerEndTime).withPriority(triggerPriority).modifiedByCalendar(triggerCalendarRef).withSchedule(scheduleBuilder).build();
            NodeList jobDataEntries2 = (NodeList) this.xpath.evaluate("q:job-data-map/q:entry", triggerNode, XPathConstants.NODESET);
            for (int k2 = 0; k2 < jobDataEntries2.getLength(); k2++) {
                Node entryNode2 = jobDataEntries2.item(k2);
                trigger.getJobDataMap().put(getTrimmedToNullString(this.xpath, "q:key", entryNode2), getTrimmedToNullString(this.xpath, "q:value", entryNode2));
            }
            if (this.log.isDebugEnabled()) {
                this.log.debug("Parsed trigger definition: " + trigger);
            }
            addTriggerToSchedule(trigger);
        }
    }

    protected String getTrimmedToNullString(XPath xpathToElement, String elementName, Node parentNode) throws XPathExpressionException {
        String str = (String) xpathToElement.evaluate(elementName, parentNode, XPathConstants.STRING);
        if (str != null) {
            str = str.trim();
        }
        if (str != null && str.length() == 0) {
            str = null;
        }
        return str;
    }

    protected Boolean getBoolean(XPath xpathToElement, String elementName, Document document) throws XPathExpressionException {
        Node directive = (Node) xpathToElement.evaluate(elementName, document, XPathConstants.NODE);
        if (directive == null || directive.getTextContent() == null) {
            return null;
        }
        String val = directive.getTextContent();
        if (val.equalsIgnoreCase(C3P0Substitutions.DEBUG) || val.equalsIgnoreCase("yes") || val.equalsIgnoreCase("y")) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public void processFileAndScheduleJobs(Scheduler sched, boolean overWriteExistingJobs) throws Exception {
        processFile(QUARTZ_XML_DEFAULT_FILE_NAME, getSystemIdForFileName(QUARTZ_XML_DEFAULT_FILE_NAME));
        setOverWriteExistingData(overWriteExistingJobs);
        executePreProcessCommands(sched);
        scheduleJobs(sched);
    }

    public void processFileAndScheduleJobs(String fileName, Scheduler sched) throws Exception {
        processFileAndScheduleJobs(fileName, getSystemIdForFileName(fileName), sched);
    }

    public void processFileAndScheduleJobs(String fileName, String systemId, Scheduler sched) throws Exception {
        processFile(fileName, systemId);
        executePreProcessCommands(sched);
        scheduleJobs(sched);
    }

    protected List<JobDetail> getLoadedJobs() {
        return Collections.unmodifiableList(this.loadedJobs);
    }

    protected List<MutableTrigger> getLoadedTriggers() {
        return Collections.unmodifiableList(this.loadedTriggers);
    }

    protected InputStream getInputStream(String fileName) {
        return this.classLoadHelper.getResourceAsStream(fileName);
    }

    protected void addJobToSchedule(JobDetail job) {
        this.loadedJobs.add(job);
    }

    protected void addTriggerToSchedule(MutableTrigger trigger) {
        this.loadedTriggers.add(trigger);
    }

    private Map<JobKey, List<MutableTrigger>> buildTriggersByFQJobNameMap(List<MutableTrigger> triggers) {
        Map<JobKey, List<MutableTrigger>> triggersByFQJobName = new HashMap<>();
        for (MutableTrigger trigger : triggers) {
            List<MutableTrigger> triggersOfJob = triggersByFQJobName.get(trigger.getJobKey());
            if (triggersOfJob == null) {
                triggersOfJob = new LinkedList<>();
                triggersByFQJobName.put(trigger.getJobKey(), triggersOfJob);
            }
            triggersOfJob.add(trigger);
        }
        return triggersByFQJobName;
    }

    protected void executePreProcessCommands(Scheduler scheduler) throws SchedulerException {
        for (String group : this.jobGroupsToDelete) {
            if (group.equals("*")) {
                this.log.info("Deleting all jobs in ALL groups.");
                for (String groupName : scheduler.getJobGroupNames()) {
                    if (!this.jobGroupsToNeverDelete.contains(groupName)) {
                        for (JobKey key : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                            scheduler.deleteJob(key);
                        }
                    }
                }
            } else if (!this.jobGroupsToNeverDelete.contains(group)) {
                this.log.info("Deleting all jobs in group: {}", group);
                for (JobKey key2 : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(group))) {
                    scheduler.deleteJob(key2);
                }
            }
        }
        for (String group2 : this.triggerGroupsToDelete) {
            if (group2.equals("*")) {
                this.log.info("Deleting all triggers in ALL groups.");
                for (String groupName2 : scheduler.getTriggerGroupNames()) {
                    if (!this.triggerGroupsToNeverDelete.contains(groupName2)) {
                        for (TriggerKey key3 : scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(groupName2))) {
                            scheduler.unscheduleJob(key3);
                        }
                    }
                }
            } else if (!this.triggerGroupsToNeverDelete.contains(group2)) {
                this.log.info("Deleting all triggers in group: {}", group2);
                for (TriggerKey key4 : scheduler.getTriggerKeys(GroupMatcher.triggerGroupEquals(group2))) {
                    scheduler.unscheduleJob(key4);
                }
            }
        }
        for (JobKey key5 : this.jobsToDelete) {
            if (!this.jobGroupsToNeverDelete.contains(key5.getGroup())) {
                this.log.info("Deleting job: {}", key5);
                scheduler.deleteJob(key5);
            }
        }
        for (TriggerKey key6 : this.triggersToDelete) {
            if (!this.triggerGroupsToNeverDelete.contains(key6.getGroup())) {
                this.log.info("Deleting trigger: {}", key6);
                scheduler.unscheduleJob(key6);
            }
        }
    }

    protected void scheduleJobs(Scheduler sched) throws SchedulerException {
        List<JobDetail> jobs = new LinkedList<>(getLoadedJobs());
        List<MutableTrigger> triggers = new LinkedList<>(getLoadedTriggers());
        this.log.info("Adding " + jobs.size() + " jobs, " + triggers.size() + " triggers.");
        Map<JobKey, List<MutableTrigger>> triggersByFQJobName = buildTriggersByFQJobNameMap(triggers);
        Iterator<JobDetail> itr = jobs.iterator();
        while (itr.hasNext()) {
            JobDetail detail = itr.next();
            itr.remove();
            JobDetail dupeJ = null;
            try {
                dupeJ = sched.getJobDetail(detail.getKey());
            } catch (JobPersistenceException e) {
                if (!(e.getCause() instanceof ClassNotFoundException) || !isOverWriteExistingData()) {
                    throw e;
                }
                this.log.info("Removing job: " + detail.getKey());
                sched.deleteJob(detail.getKey());
            }
            if (dupeJ != null) {
                if (!isOverWriteExistingData() && isIgnoreDuplicates()) {
                    this.log.info("Not overwriting existing job: " + dupeJ.getKey());
                } else if (!isOverWriteExistingData() && !isIgnoreDuplicates()) {
                    throw new ObjectAlreadyExistsException(detail);
                }
            }
            if (dupeJ != null) {
                this.log.info("Replacing job: " + detail.getKey());
            } else {
                this.log.info("Adding job: " + detail.getKey());
            }
            List<MutableTrigger> triggersOfJob = triggersByFQJobName.get(detail.getKey());
            if (!detail.isDurable() && (triggersOfJob == null || triggersOfJob.size() == 0)) {
                if (dupeJ == null) {
                    throw new SchedulerException("A new job defined without any triggers must be durable: " + detail.getKey());
                } else if (dupeJ.isDurable() && sched.getTriggersOfJob(detail.getKey()).size() == 0) {
                    throw new SchedulerException("Can't change existing durable job without triggers to non-durable: " + detail.getKey());
                }
            }
            if (dupeJ == null && !detail.isDurable()) {
                boolean addJobWithFirstSchedule = true;
                for (MutableTrigger trigger : triggersOfJob) {
                    triggers.remove(trigger);
                    if (trigger.getStartTime() == null) {
                        trigger.setStartTime(new Date());
                    }
                    Trigger dupeT = sched.getTrigger(trigger.getKey());
                    if (dupeT == null) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Scheduling job: " + trigger.getJobKey() + " with trigger: " + trigger.getKey());
                        }
                        if (addJobWithFirstSchedule) {
                            try {
                                sched.scheduleJob(detail, trigger);
                                addJobWithFirstSchedule = false;
                            } catch (ObjectAlreadyExistsException e2) {
                                if (this.log.isDebugEnabled()) {
                                    this.log.debug("Adding trigger: " + trigger.getKey() + " for job: " + detail.getKey() + " failed because the trigger already existed.  This is likely due to a race condition between multiple instances in the cluster.  Will try to reschedule instead.");
                                }
                                sched.rescheduleJob(trigger.getKey(), trigger);
                            }
                        } else {
                            sched.scheduleJob(trigger);
                        }
                    } else if (isOverWriteExistingData()) {
                        if (this.log.isDebugEnabled()) {
                            this.log.debug("Rescheduling job: " + trigger.getJobKey() + " with updated trigger: " + trigger.getKey());
                        }
                        if (!dupeT.getJobKey().equals(trigger.getJobKey())) {
                            this.log.warn("Possibly duplicately named ({}) triggers in jobs xml file! ", trigger.getKey());
                        }
                        sched.rescheduleJob(trigger.getKey(), trigger);
                    } else if (isIgnoreDuplicates()) {
                        this.log.info("Not overwriting existing trigger: " + dupeT.getKey());
                    } else {
                        throw new ObjectAlreadyExistsException(trigger);
                    }
                }
                continue;
            } else if (triggersOfJob == null || triggersOfJob.size() <= 0) {
                sched.addJob(detail, true, false);
            } else {
                sched.addJob(detail, true, true);
            }
        }
        for (MutableTrigger trigger2 : triggers) {
            if (trigger2.getStartTime() == null) {
                trigger2.setStartTime(new Date());
            }
            Trigger dupeT2 = sched.getTrigger(trigger2.getKey());
            if (dupeT2 == null) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Scheduling job: " + trigger2.getJobKey() + " with trigger: " + trigger2.getKey());
                }
                try {
                    sched.scheduleJob(trigger2);
                } catch (ObjectAlreadyExistsException e3) {
                    if (this.log.isDebugEnabled()) {
                        this.log.debug("Adding trigger: " + trigger2.getKey() + " for job: " + trigger2.getJobKey() + " failed because the trigger already existed.  This is likely due to a race condition between multiple instances in the cluster.  Will try to reschedule instead.");
                    }
                    sched.rescheduleJob(trigger2.getKey(), trigger2);
                }
            } else if (isOverWriteExistingData()) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Rescheduling job: " + trigger2.getJobKey() + " with updated trigger: " + trigger2.getKey());
                }
                if (!dupeT2.getJobKey().equals(trigger2.getJobKey())) {
                    this.log.warn("Possibly duplicately named ({}) triggers in jobs xml file! ", trigger2.getKey());
                }
                sched.rescheduleJob(trigger2.getKey(), trigger2);
            } else if (isIgnoreDuplicates()) {
                this.log.info("Not overwriting existing trigger: " + dupeT2.getKey());
            } else {
                throw new ObjectAlreadyExistsException(trigger2);
            }
        }
    }

    @Override // org.xml.sax.ErrorHandler
    public void warning(SAXParseException e) throws SAXException {
        addValidationException(e);
    }

    @Override // org.xml.sax.ErrorHandler
    public void error(SAXParseException e) throws SAXException {
        addValidationException(e);
    }

    @Override // org.xml.sax.ErrorHandler
    public void fatalError(SAXParseException e) throws SAXException {
        addValidationException(e);
    }

    protected void addValidationException(SAXException e) {
        this.validationExceptions.add(e);
    }

    protected void clearValidationExceptions() {
        this.validationExceptions.clear();
    }

    protected void maybeThrowValidationException() throws ValidationException {
        if (this.validationExceptions.size() > 0) {
            throw new ValidationException("Encountered " + this.validationExceptions.size() + " validation exceptions.", this.validationExceptions);
        }
    }
}
