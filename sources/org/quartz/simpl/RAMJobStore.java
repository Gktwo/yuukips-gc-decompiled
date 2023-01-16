package org.quartz.simpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.ObjectAlreadyExistsException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.impl.matchers.StringMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.JobStore;
import org.quartz.spi.OperableTrigger;
import org.quartz.spi.SchedulerSignaler;
import org.quartz.spi.TriggerFiredBundle;
import org.quartz.spi.TriggerFiredResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:org/quartz/simpl/RAMJobStore.class */
public class RAMJobStore implements JobStore {
    protected SchedulerSignaler signaler;
    private static final AtomicLong ftrCtr = new AtomicLong(System.currentTimeMillis());
    protected HashMap<JobKey, JobWrapper> jobsByKey = new HashMap<>(1000);
    protected HashMap<TriggerKey, TriggerWrapper> triggersByKey = new HashMap<>(1000);
    protected HashMap<String, HashMap<JobKey, JobWrapper>> jobsByGroup = new HashMap<>(25);
    protected HashMap<String, HashMap<TriggerKey, TriggerWrapper>> triggersByGroup = new HashMap<>(25);
    protected TreeSet<TriggerWrapper> timeTriggers = new TreeSet<>(new TriggerWrapperComparator());
    protected HashMap<String, Calendar> calendarsByName = new HashMap<>(25);
    protected Map<JobKey, List<TriggerWrapper>> triggersByJob = new HashMap(1000);
    protected final Object lock = new Object();
    protected HashSet<String> pausedTriggerGroups = new HashSet<>();
    protected HashSet<String> pausedJobGroups = new HashSet<>();
    protected HashSet<JobKey> blockedJobs = new HashSet<>();
    protected long misfireThreshold = 5000;
    private final Logger log = LoggerFactory.getLogger(getClass());

    protected Logger getLog() {
        return this.log;
    }

    @Override // org.quartz.spi.JobStore
    public void initialize(ClassLoadHelper loadHelper, SchedulerSignaler schedSignaler) {
        this.signaler = schedSignaler;
        getLog().info("RAMJobStore initialized.");
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerStarted() {
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerPaused() {
    }

    @Override // org.quartz.spi.JobStore
    public void schedulerResumed() {
    }

    public long getMisfireThreshold() {
        return this.misfireThreshold;
    }

    public void setMisfireThreshold(long misfireThreshold) {
        if (misfireThreshold < 1) {
            throw new IllegalArgumentException("Misfire threshold must be larger than 0");
        }
        this.misfireThreshold = misfireThreshold;
    }

    @Override // org.quartz.spi.JobStore
    public void shutdown() {
    }

    @Override // org.quartz.spi.JobStore
    public boolean supportsPersistence() {
        return false;
    }

    @Override // org.quartz.spi.JobStore
    public void clearAllSchedulingData() throws JobPersistenceException {
        synchronized (this.lock) {
            for (String group : getTriggerGroupNames()) {
                for (TriggerKey key : getTriggerKeys(GroupMatcher.triggerGroupEquals(group))) {
                    removeTrigger(key);
                }
            }
            for (String group2 : getJobGroupNames()) {
                for (JobKey key2 : getJobKeys(GroupMatcher.jobGroupEquals(group2))) {
                    removeJob(key2);
                }
            }
            for (String name : getCalendarNames()) {
                removeCalendar(name);
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobAndTrigger(JobDetail newJob, OperableTrigger newTrigger) throws JobPersistenceException {
        storeJob(newJob, false);
        storeTrigger(newTrigger, false);
    }

    @Override // org.quartz.spi.JobStore
    public void storeJob(JobDetail newJob, boolean replaceExisting) throws ObjectAlreadyExistsException {
        JobWrapper jw = new JobWrapper((JobDetail) newJob.clone());
        boolean repl = false;
        synchronized (this.lock) {
            if (this.jobsByKey.get(jw.key) != null) {
                if (!replaceExisting) {
                    throw new ObjectAlreadyExistsException(newJob);
                }
                repl = true;
            }
            if (!repl) {
                HashMap<JobKey, JobWrapper> grpMap = this.jobsByGroup.get(newJob.getKey().getGroup());
                if (grpMap == null) {
                    grpMap = new HashMap<>(100);
                    this.jobsByGroup.put(newJob.getKey().getGroup(), grpMap);
                }
                grpMap.put(newJob.getKey(), jw);
                this.jobsByKey.put(jw.key, jw);
            } else {
                this.jobsByKey.get(jw.key).jobDetail = jw.jobDetail;
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJob(JobKey jobKey) {
        boolean found;
        HashMap<JobKey, JobWrapper> grpMap;
        boolean found2 = false;
        synchronized (this.lock) {
            for (OperableTrigger trig : getTriggersForJob(jobKey)) {
                removeTrigger(trig.getKey());
                found2 = true;
            }
            found = (this.jobsByKey.remove(jobKey) != null) | found2;
            if (found && (grpMap = this.jobsByGroup.get(jobKey.getGroup())) != null) {
                grpMap.remove(jobKey);
                if (grpMap.size() == 0) {
                    this.jobsByGroup.remove(jobKey.getGroup());
                }
            }
        }
        return found;
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeJobs(List<JobKey> jobKeys) throws JobPersistenceException {
        boolean allFound = true;
        synchronized (this.lock) {
            for (JobKey key : jobKeys) {
                allFound = removeJob(key) && allFound;
            }
        }
        return allFound;
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTriggers(List<TriggerKey> triggerKeys) throws JobPersistenceException {
        boolean allFound = true;
        synchronized (this.lock) {
            for (TriggerKey key : triggerKeys) {
                allFound = removeTrigger(key) && allFound;
            }
        }
        return allFound;
    }

    @Override // org.quartz.spi.JobStore
    public void storeJobsAndTriggers(Map<JobDetail, Set<? extends Trigger>> triggersAndJobs, boolean replace) throws JobPersistenceException {
        synchronized (this.lock) {
            if (!replace) {
                for (Map.Entry<JobDetail, Set<? extends Trigger>> e : triggersAndJobs.entrySet()) {
                    if (checkExists(e.getKey().getKey())) {
                        throw new ObjectAlreadyExistsException(e.getKey());
                    }
                    for (Trigger trigger : e.getValue()) {
                        if (checkExists(trigger.getKey())) {
                            throw new ObjectAlreadyExistsException(trigger);
                        }
                    }
                }
            }
            for (Map.Entry<JobDetail, Set<? extends Trigger>> e2 : triggersAndJobs.entrySet()) {
                storeJob(e2.getKey(), true);
                for (Trigger trigger2 : e2.getValue()) {
                    storeTrigger((OperableTrigger) trigger2, true);
                }
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeTrigger(OperableTrigger newTrigger, boolean replaceExisting) throws JobPersistenceException {
        TriggerWrapper tw = new TriggerWrapper((OperableTrigger) newTrigger.clone());
        synchronized (this.lock) {
            if (this.triggersByKey.get(tw.key) != null) {
                if (!replaceExisting) {
                    throw new ObjectAlreadyExistsException(newTrigger);
                }
                removeTrigger(newTrigger.getKey(), false);
            }
            if (retrieveJob(newTrigger.getJobKey()) == null) {
                throw new JobPersistenceException("The job (" + newTrigger.getJobKey() + ") referenced by the trigger does not exist.");
            }
            List<TriggerWrapper> jobList = this.triggersByJob.get(tw.jobKey);
            if (jobList == null) {
                jobList = new ArrayList(1);
                this.triggersByJob.put(tw.jobKey, jobList);
            }
            jobList.add(tw);
            HashMap<TriggerKey, TriggerWrapper> grpMap = this.triggersByGroup.get(newTrigger.getKey().getGroup());
            if (grpMap == null) {
                grpMap = new HashMap<>(100);
                this.triggersByGroup.put(newTrigger.getKey().getGroup(), grpMap);
            }
            grpMap.put(newTrigger.getKey(), tw);
            this.triggersByKey.put(tw.key, tw);
            if (this.pausedTriggerGroups.contains(newTrigger.getKey().getGroup()) || this.pausedJobGroups.contains(newTrigger.getJobKey().getGroup())) {
                tw.state = 4;
                if (this.blockedJobs.contains(tw.jobKey)) {
                    tw.state = 6;
                }
            } else if (this.blockedJobs.contains(tw.jobKey)) {
                tw.state = 5;
            } else {
                this.timeTriggers.add(tw);
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeTrigger(TriggerKey triggerKey) {
        return removeTrigger(triggerKey, true);
    }

    private boolean removeTrigger(TriggerKey key, boolean removeOrphanedJob) {
        boolean found;
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.remove(key);
            found = tw != null;
            if (found) {
                HashMap<TriggerKey, TriggerWrapper> grpMap = this.triggersByGroup.get(key.getGroup());
                if (grpMap != null) {
                    grpMap.remove(key);
                    if (grpMap.size() == 0) {
                        this.triggersByGroup.remove(key.getGroup());
                    }
                }
                List<TriggerWrapper> jobList = this.triggersByJob.get(tw.jobKey);
                if (jobList != null) {
                    jobList.remove(tw);
                    if (jobList.isEmpty()) {
                        this.triggersByJob.remove(tw.jobKey);
                    }
                }
                this.timeTriggers.remove(tw);
                if (removeOrphanedJob) {
                    JobWrapper jw = this.jobsByKey.get(tw.jobKey);
                    List<OperableTrigger> trigs = getTriggersForJob(tw.jobKey);
                    if ((trigs == null || trigs.size() == 0) && !jw.jobDetail.isDurable() && removeJob(jw.key)) {
                        this.signaler.notifySchedulerListenersJobDeleted(jw.key);
                    }
                }
            }
        }
        return found;
    }

    @Override // org.quartz.spi.JobStore
    public boolean replaceTrigger(TriggerKey triggerKey, OperableTrigger newTrigger) throws JobPersistenceException {
        boolean found;
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.remove(triggerKey);
            found = tw != null;
            if (found) {
                if (!tw.getTrigger().getJobKey().equals(newTrigger.getJobKey())) {
                    throw new JobPersistenceException("New trigger is not related to the same job as the old trigger.");
                }
                HashMap<TriggerKey, TriggerWrapper> grpMap = this.triggersByGroup.get(triggerKey.getGroup());
                if (grpMap != null) {
                    grpMap.remove(triggerKey);
                    if (grpMap.size() == 0) {
                        this.triggersByGroup.remove(triggerKey.getGroup());
                    }
                }
                List<TriggerWrapper> jobList = this.triggersByJob.get(tw.jobKey);
                if (jobList != null) {
                    jobList.remove(tw);
                    if (jobList.isEmpty()) {
                        this.triggersByJob.remove(tw.jobKey);
                    }
                }
                this.timeTriggers.remove(tw);
                try {
                    storeTrigger(newTrigger, false);
                } catch (JobPersistenceException jpe) {
                    storeTrigger(tw.getTrigger(), false);
                    throw jpe;
                }
            }
        }
        return found;
    }

    @Override // org.quartz.spi.JobStore
    public JobDetail retrieveJob(JobKey jobKey) {
        JobDetail jobDetail;
        synchronized (this.lock) {
            JobWrapper jw = this.jobsByKey.get(jobKey);
            jobDetail = jw != null ? (JobDetail) jw.jobDetail.clone() : null;
        }
        return jobDetail;
    }

    @Override // org.quartz.spi.JobStore
    public OperableTrigger retrieveTrigger(TriggerKey triggerKey) {
        OperableTrigger operableTrigger;
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.get(triggerKey);
            operableTrigger = tw != null ? (OperableTrigger) tw.getTrigger().clone() : null;
        }
        return operableTrigger;
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(JobKey jobKey) throws JobPersistenceException {
        boolean z;
        synchronized (this.lock) {
            z = this.jobsByKey.get(jobKey) != null;
        }
        return z;
    }

    @Override // org.quartz.spi.JobStore
    public boolean checkExists(TriggerKey triggerKey) throws JobPersistenceException {
        boolean z;
        synchronized (this.lock) {
            z = this.triggersByKey.get(triggerKey) != null;
        }
        return z;
    }

    @Override // org.quartz.spi.JobStore
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws JobPersistenceException {
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.get(triggerKey);
            if (tw == null) {
                return Trigger.TriggerState.NONE;
            } else if (tw.state == 3) {
                return Trigger.TriggerState.COMPLETE;
            } else if (tw.state == 4) {
                return Trigger.TriggerState.PAUSED;
            } else if (tw.state == 6) {
                return Trigger.TriggerState.PAUSED;
            } else if (tw.state == 5) {
                return Trigger.TriggerState.BLOCKED;
            } else if (tw.state == 7) {
                return Trigger.TriggerState.ERROR;
            } else {
                return Trigger.TriggerState.NORMAL;
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws JobPersistenceException {
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.get(triggerKey);
            if (tw != null && tw.trigger != null) {
                if (tw.state == 7) {
                    if (this.pausedTriggerGroups.contains(triggerKey.getGroup())) {
                        tw.state = 4;
                    } else {
                        tw.state = 0;
                        this.timeTriggers.add(tw);
                    }
                }
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public void storeCalendar(String name, Calendar calendar, boolean replaceExisting, boolean updateTriggers) throws ObjectAlreadyExistsException {
        Calendar calendar2 = (Calendar) calendar.clone();
        synchronized (this.lock) {
            Object obj = this.calendarsByName.get(name);
            if (obj == null || replaceExisting) {
                if (obj != null) {
                    this.calendarsByName.remove(name);
                }
                this.calendarsByName.put(name, calendar2);
                if (obj != null && updateTriggers) {
                    Iterator i$ = getTriggerWrappersForCalendar(name).iterator();
                    while (i$.hasNext()) {
                        TriggerWrapper tw = i$.next();
                        OperableTrigger trig = tw.getTrigger();
                        boolean removed = this.timeTriggers.remove(tw);
                        trig.updateWithNewCalendar(calendar2, getMisfireThreshold());
                        if (removed) {
                            this.timeTriggers.add(tw);
                        }
                    }
                }
            } else {
                throw new ObjectAlreadyExistsException("Calendar with name '" + name + "' already exists.");
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public boolean removeCalendar(String calName) throws JobPersistenceException {
        int numRefs = 0;
        synchronized (this.lock) {
            for (TriggerWrapper trigger : this.triggersByKey.values()) {
                OperableTrigger trigg = trigger.trigger;
                if (trigg.getCalendarName() != null && trigg.getCalendarName().equals(calName)) {
                    numRefs++;
                }
            }
        }
        if (numRefs <= 0) {
            return this.calendarsByName.remove(calName) != null;
        }
        throw new JobPersistenceException("Calender cannot be removed if it referenced by a Trigger!");
    }

    @Override // org.quartz.spi.JobStore
    public Calendar retrieveCalendar(String calName) {
        synchronized (this.lock) {
            Calendar cal = this.calendarsByName.get(calName);
            if (cal == null) {
                return null;
            }
            return (Calendar) cal.clone();
        }
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfJobs() {
        int size;
        synchronized (this.lock) {
            size = this.jobsByKey.size();
        }
        return size;
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfTriggers() {
        int size;
        synchronized (this.lock) {
            size = this.triggersByKey.size();
        }
        return size;
    }

    @Override // org.quartz.spi.JobStore
    public int getNumberOfCalendars() {
        int size;
        synchronized (this.lock) {
            size = this.calendarsByName.size();
        }
        return size;
    }

    @Override // org.quartz.spi.JobStore
    public Set<JobKey> getJobKeys(GroupMatcher<JobKey> matcher) {
        Set<JobKey> outList = null;
        synchronized (this.lock) {
            StringMatcher.StringOperatorName operator = matcher.getCompareWithOperator();
            String compareToValue = matcher.getCompareToValue();
            switch (operator) {
                case EQUALS:
                    HashMap<JobKey, JobWrapper> grpMap = this.jobsByGroup.get(compareToValue);
                    if (grpMap != null) {
                        outList = new HashSet<>();
                        for (JobWrapper jw : grpMap.values()) {
                            if (jw != null) {
                                outList.add(jw.jobDetail.getKey());
                            }
                        }
                        break;
                    }
                    break;
                default:
                    for (Map.Entry<String, HashMap<JobKey, JobWrapper>> entry : this.jobsByGroup.entrySet()) {
                        if (operator.evaluate(entry.getKey(), compareToValue) && entry.getValue() != null) {
                            if (outList == null) {
                                outList = new HashSet<>();
                            }
                            for (JobWrapper jobWrapper : entry.getValue().values()) {
                                if (jobWrapper != null) {
                                    outList.add(jobWrapper.jobDetail.getKey());
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return outList == null ? Collections.emptySet() : outList;
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getCalendarNames() {
        LinkedList linkedList;
        synchronized (this.lock) {
            linkedList = new LinkedList(this.calendarsByName.keySet());
        }
        return linkedList;
    }

    @Override // org.quartz.spi.JobStore
    public Set<TriggerKey> getTriggerKeys(GroupMatcher<TriggerKey> matcher) {
        Set<TriggerKey> outList = null;
        synchronized (this.lock) {
            StringMatcher.StringOperatorName operator = matcher.getCompareWithOperator();
            String compareToValue = matcher.getCompareToValue();
            switch (operator) {
                case EQUALS:
                    HashMap<TriggerKey, TriggerWrapper> grpMap = this.triggersByGroup.get(compareToValue);
                    if (grpMap != null) {
                        outList = new HashSet<>();
                        for (TriggerWrapper tw : grpMap.values()) {
                            if (tw != null) {
                                outList.add(tw.trigger.getKey());
                            }
                        }
                        break;
                    }
                    break;
                default:
                    for (Map.Entry<String, HashMap<TriggerKey, TriggerWrapper>> entry : this.triggersByGroup.entrySet()) {
                        if (operator.evaluate(entry.getKey(), compareToValue) && entry.getValue() != null) {
                            if (outList == null) {
                                outList = new HashSet<>();
                            }
                            for (TriggerWrapper triggerWrapper : entry.getValue().values()) {
                                if (triggerWrapper != null) {
                                    outList.add(triggerWrapper.trigger.getKey());
                                }
                            }
                        }
                    }
                    break;
            }
        }
        return outList == null ? Collections.emptySet() : outList;
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getJobGroupNames() {
        List<String> outList;
        synchronized (this.lock) {
            outList = new LinkedList<>(this.jobsByGroup.keySet());
        }
        return outList;
    }

    @Override // org.quartz.spi.JobStore
    public List<String> getTriggerGroupNames() {
        LinkedList<String> outList;
        synchronized (this.lock) {
            outList = new LinkedList<>(this.triggersByGroup.keySet());
        }
        return outList;
    }

    @Override // org.quartz.spi.JobStore
    public List<OperableTrigger> getTriggersForJob(JobKey jobKey) {
        ArrayList<OperableTrigger> trigList = new ArrayList<>();
        synchronized (this.lock) {
            List<TriggerWrapper> jobList = this.triggersByJob.get(jobKey);
            if (jobList != null) {
                for (TriggerWrapper tw : jobList) {
                    trigList.add((OperableTrigger) tw.trigger.clone());
                }
            }
        }
        return trigList;
    }

    protected ArrayList<TriggerWrapper> getTriggerWrappersForJob(JobKey jobKey) {
        ArrayList<TriggerWrapper> trigList = new ArrayList<>();
        synchronized (this.lock) {
            List<TriggerWrapper> jobList = this.triggersByJob.get(jobKey);
            if (jobList != null) {
                for (TriggerWrapper trigger : jobList) {
                    trigList.add(trigger);
                }
            }
        }
        return trigList;
    }

    protected ArrayList<TriggerWrapper> getTriggerWrappersForCalendar(String calName) {
        ArrayList<TriggerWrapper> trigList = new ArrayList<>();
        synchronized (this.lock) {
            for (TriggerWrapper tw : this.triggersByKey.values()) {
                String tcalName = tw.getTrigger().getCalendarName();
                if (tcalName != null && tcalName.equals(calName)) {
                    trigList.add(tw);
                }
            }
        }
        return trigList;
    }

    @Override // org.quartz.spi.JobStore
    public void pauseTrigger(TriggerKey triggerKey) {
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.get(triggerKey);
            if (tw != null && tw.trigger != null) {
                if (tw.state != 3) {
                    if (tw.state == 5) {
                        tw.state = 6;
                    } else {
                        tw.state = 4;
                    }
                    this.timeTriggers.remove(tw);
                }
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> pauseTriggers(GroupMatcher<TriggerKey> matcher) {
        List<String> pausedGroups;
        synchronized (this.lock) {
            pausedGroups = new LinkedList<>();
            StringMatcher.StringOperatorName operator = matcher.getCompareWithOperator();
            switch (operator) {
                case EQUALS:
                    if (this.pausedTriggerGroups.add(matcher.getCompareToValue())) {
                        pausedGroups.add(matcher.getCompareToValue());
                        break;
                    }
                    break;
                default:
                    for (String group : this.triggersByGroup.keySet()) {
                        if (operator.evaluate(group, matcher.getCompareToValue()) && this.pausedTriggerGroups.add(matcher.getCompareToValue())) {
                            pausedGroups.add(group);
                        }
                    }
                    break;
            }
            for (String pausedGroup : pausedGroups) {
                for (TriggerKey key : getTriggerKeys(GroupMatcher.triggerGroupEquals(pausedGroup))) {
                    pauseTrigger(key);
                }
            }
        }
        return pausedGroups;
    }

    @Override // org.quartz.spi.JobStore
    public void pauseJob(JobKey jobKey) {
        synchronized (this.lock) {
            for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                pauseTrigger(trigger.getKey());
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> pauseJobs(GroupMatcher<JobKey> matcher) {
        List<String> pausedGroups = new LinkedList<>();
        synchronized (this.lock) {
            StringMatcher.StringOperatorName operator = matcher.getCompareWithOperator();
            switch (operator) {
                case EQUALS:
                    if (this.pausedJobGroups.add(matcher.getCompareToValue())) {
                        pausedGroups.add(matcher.getCompareToValue());
                        break;
                    }
                    break;
                default:
                    for (String group : this.jobsByGroup.keySet()) {
                        if (operator.evaluate(group, matcher.getCompareToValue()) && this.pausedJobGroups.add(group)) {
                            pausedGroups.add(group);
                        }
                    }
                    break;
            }
            for (String groupName : pausedGroups) {
                for (JobKey jobKey : getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                    for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                        pauseTrigger(trigger.getKey());
                    }
                }
            }
        }
        return pausedGroups;
    }

    @Override // org.quartz.spi.JobStore
    public void resumeTrigger(TriggerKey triggerKey) {
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.get(triggerKey);
            if (tw != null && tw.trigger != null) {
                OperableTrigger trig = tw.getTrigger();
                if (tw.state == 4 || tw.state == 6) {
                    if (this.blockedJobs.contains(trig.getJobKey())) {
                        tw.state = 5;
                    } else {
                        tw.state = 0;
                    }
                    applyMisfire(tw);
                    if (tw.state == 0) {
                        this.timeTriggers.add(tw);
                    }
                }
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<String> resumeTriggers(GroupMatcher<TriggerKey> matcher) {
        Set<String> groups = new HashSet<>();
        synchronized (this.lock) {
            for (TriggerKey triggerKey : getTriggerKeys(matcher)) {
                groups.add(triggerKey.getGroup());
                if (this.triggersByKey.get(triggerKey) == null || !this.pausedJobGroups.contains(this.triggersByKey.get(triggerKey).jobKey.getGroup())) {
                    resumeTrigger(triggerKey);
                }
            }
            StringMatcher.StringOperatorName operator = matcher.getCompareWithOperator();
            LinkedList<String> pausedGroups = new LinkedList<>();
            String matcherGroup = matcher.getCompareToValue();
            switch (operator) {
                case EQUALS:
                    if (this.pausedTriggerGroups.contains(matcherGroup)) {
                        pausedGroups.add(matcher.getCompareToValue());
                        break;
                    }
                    break;
                default:
                    Iterator i$ = this.pausedTriggerGroups.iterator();
                    while (i$.hasNext()) {
                        String group = i$.next();
                        if (operator.evaluate(group, matcherGroup)) {
                            pausedGroups.add(group);
                        }
                    }
                    break;
            }
            Iterator i$2 = pausedGroups.iterator();
            while (i$2.hasNext()) {
                this.pausedTriggerGroups.remove(i$2.next());
            }
        }
        return new ArrayList(groups);
    }

    @Override // org.quartz.spi.JobStore
    public void resumeJob(JobKey jobKey) {
        synchronized (this.lock) {
            for (OperableTrigger trigger : getTriggersForJob(jobKey)) {
                resumeTrigger(trigger.getKey());
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public Collection<String> resumeJobs(GroupMatcher<JobKey> matcher) {
        Set<String> resumedGroups = new HashSet<>();
        synchronized (this.lock) {
            Set<JobKey> keys = getJobKeys(matcher);
            Iterator i$ = this.pausedJobGroups.iterator();
            while (i$.hasNext()) {
                String pausedJobGroup = i$.next();
                if (matcher.getCompareWithOperator().evaluate(pausedJobGroup, matcher.getCompareToValue())) {
                    resumedGroups.add(pausedJobGroup);
                }
            }
            for (String resumedGroup : resumedGroups) {
                this.pausedJobGroups.remove(resumedGroup);
            }
            for (JobKey key : keys) {
                for (OperableTrigger trigger : getTriggersForJob(key)) {
                    resumeTrigger(trigger.getKey());
                }
            }
        }
        return resumedGroups;
    }

    @Override // org.quartz.spi.JobStore
    public void pauseAll() {
        synchronized (this.lock) {
            for (String name : getTriggerGroupNames()) {
                pauseTriggers(GroupMatcher.triggerGroupEquals(name));
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public void resumeAll() {
        synchronized (this.lock) {
            this.pausedJobGroups.clear();
            resumeTriggers(GroupMatcher.anyTriggerGroup());
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v47, types: [long] */
    protected boolean applyMisfire(TriggerWrapper tw) {
        char currentTimeMillis = System.currentTimeMillis();
        if (getMisfireThreshold() > 0) {
            currentTimeMillis -= getMisfireThreshold();
        }
        Date tnft = tw.trigger.getNextFireTime();
        if (tnft == null || tnft.getTime() > currentTimeMillis || tw.trigger.getMisfireInstruction() == -1) {
            return false;
        }
        Calendar cal = null;
        if (tw.trigger.getCalendarName() != null) {
            cal = retrieveCalendar(tw.trigger.getCalendarName());
        }
        this.signaler.notifyTriggerListenersMisfired((OperableTrigger) tw.trigger.clone());
        tw.trigger.updateAfterMisfire(cal);
        if (tw.trigger.getNextFireTime() == null) {
            tw.state = 3;
            this.signaler.notifySchedulerListenersFinalized(tw.trigger);
            synchronized (this.lock) {
                this.timeTriggers.remove(tw);
            }
            return true;
        } else if (tnft.equals(tw.trigger.getNextFireTime())) {
            return false;
        } else {
            return true;
        }
    }

    protected String getFiredTriggerRecordId() {
        return String.valueOf(ftrCtr.incrementAndGet());
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:13:0x0057
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.quartz.spi.JobStore
    public java.util.List<org.quartz.spi.OperableTrigger> acquireNextTriggers(long r6, int r8, long r9) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.simpl.RAMJobStore.acquireNextTriggers(long, int, long):java.util.List");
    }

    @Override // org.quartz.spi.JobStore
    public void releaseAcquiredTrigger(OperableTrigger trigger) {
        synchronized (this.lock) {
            TriggerWrapper tw = this.triggersByKey.get(trigger.getKey());
            if (tw != null && tw.state == 1) {
                tw.state = 0;
                this.timeTriggers.add(tw);
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public List<TriggerFiredResult> triggersFired(List<OperableTrigger> firedTriggers) {
        List<TriggerFiredResult> results;
        synchronized (this.lock) {
            results = new ArrayList<>();
            for (OperableTrigger trigger : firedTriggers) {
                TriggerWrapper tw = this.triggersByKey.get(trigger.getKey());
                if (!(tw == null || tw.trigger == null || tw.state != 1)) {
                    Calendar cal = null;
                    if (tw.trigger.getCalendarName() != null) {
                        cal = retrieveCalendar(tw.trigger.getCalendarName());
                        if (cal == null) {
                        }
                    }
                    Date prevFireTime = trigger.getPreviousFireTime();
                    this.timeTriggers.remove(tw);
                    tw.trigger.triggered(cal);
                    trigger.triggered(cal);
                    tw.state = 0;
                    TriggerFiredBundle bndle = new TriggerFiredBundle(retrieveJob(tw.jobKey), trigger, cal, false, new Date(), trigger.getPreviousFireTime(), prevFireTime, trigger.getNextFireTime());
                    JobDetail job = bndle.getJobDetail();
                    if (job.isConcurrentExectionDisallowed()) {
                        Iterator i$ = getTriggerWrappersForJob(job.getKey()).iterator();
                        while (i$.hasNext()) {
                            TriggerWrapper ttw = i$.next();
                            if (ttw.state == 0) {
                                ttw.state = 5;
                            }
                            if (ttw.state == 4) {
                                ttw.state = 6;
                            }
                            this.timeTriggers.remove(ttw);
                        }
                        this.blockedJobs.add(job.getKey());
                    } else if (tw.trigger.getNextFireTime() != null) {
                        synchronized (this.lock) {
                            this.timeTriggers.add(tw);
                        }
                    }
                    results.add(new TriggerFiredResult(bndle));
                }
            }
        }
        return results;
    }

    @Override // org.quartz.spi.JobStore
    public void triggeredJobComplete(OperableTrigger trigger, JobDetail jobDetail, Trigger.CompletedExecutionInstruction triggerInstCode) {
        synchronized (this.lock) {
            JobWrapper jw = this.jobsByKey.get(jobDetail.getKey());
            TriggerWrapper tw = this.triggersByKey.get(trigger.getKey());
            if (jw != null) {
                JobDetail jd = jw.jobDetail;
                if (jd.isPersistJobDataAfterExecution()) {
                    JobDataMap newData = jobDetail.getJobDataMap();
                    if (newData != null) {
                        newData = (JobDataMap) newData.clone();
                        newData.clearDirtyFlag();
                    }
                    jd = jd.getJobBuilder().setJobData(newData).build();
                    jw.jobDetail = jd;
                }
                if (jd.isConcurrentExectionDisallowed()) {
                    this.blockedJobs.remove(jd.getKey());
                    Iterator i$ = getTriggerWrappersForJob(jd.getKey()).iterator();
                    while (i$.hasNext()) {
                        TriggerWrapper ttw = i$.next();
                        if (ttw.state == 5) {
                            ttw.state = 0;
                            this.timeTriggers.add(ttw);
                        }
                        if (ttw.state == 6) {
                            ttw.state = 4;
                        }
                    }
                    this.signaler.signalSchedulingChange(0);
                }
            } else {
                this.blockedJobs.remove(jobDetail.getKey());
            }
            if (tw != null) {
                if (triggerInstCode == Trigger.CompletedExecutionInstruction.DELETE_TRIGGER) {
                    if (trigger.getNextFireTime() != null) {
                        removeTrigger(trigger.getKey());
                        this.signaler.signalSchedulingChange(0);
                    } else if (tw.getTrigger().getNextFireTime() == null) {
                        removeTrigger(trigger.getKey());
                    }
                } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_TRIGGER_COMPLETE) {
                    tw.state = 3;
                    this.timeTriggers.remove(tw);
                    this.signaler.signalSchedulingChange(0);
                } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_TRIGGER_ERROR) {
                    getLog().info("Trigger " + trigger.getKey() + " set to ERROR state.");
                    tw.state = 7;
                    this.signaler.signalSchedulingChange(0);
                } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_ERROR) {
                    getLog().info("All triggers of Job " + trigger.getJobKey() + " set to ERROR state.");
                    setAllTriggersOfJobToState(trigger.getJobKey(), 7);
                    this.signaler.signalSchedulingChange(0);
                } else if (triggerInstCode == Trigger.CompletedExecutionInstruction.SET_ALL_JOB_TRIGGERS_COMPLETE) {
                    setAllTriggersOfJobToState(trigger.getJobKey(), 3);
                    this.signaler.signalSchedulingChange(0);
                }
            }
        }
    }

    @Override // org.quartz.spi.JobStore
    public long getAcquireRetryDelay(int failureCount) {
        return 20;
    }

    protected void setAllTriggersOfJobToState(JobKey jobKey, int state) {
        Iterator i$ = getTriggerWrappersForJob(jobKey).iterator();
        while (i$.hasNext()) {
            TriggerWrapper tw = i$.next();
            tw.state = state;
            if (state != 0) {
                this.timeTriggers.remove(tw);
            }
        }
    }

    protected String peekTriggers() {
        StringBuilder str = new StringBuilder();
        synchronized (this.lock) {
            for (TriggerWrapper triggerWrapper : this.triggersByKey.values()) {
                str.append(triggerWrapper.trigger.getKey().getName());
                str.append("/");
            }
        }
        str.append(" | ");
        synchronized (this.lock) {
            Iterator i$ = this.timeTriggers.iterator();
            while (i$.hasNext()) {
                str.append(i$.next().trigger.getKey().getName());
                str.append("->");
            }
        }
        return str.toString();
    }

    @Override // org.quartz.spi.JobStore
    public Set<String> getPausedTriggerGroups() throws JobPersistenceException {
        HashSet<String> set = new HashSet<>();
        set.addAll(this.pausedTriggerGroups);
        return set;
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceId(String schedInstId) {
    }

    @Override // org.quartz.spi.JobStore
    public void setInstanceName(String schedName) {
    }

    @Override // org.quartz.spi.JobStore
    public void setThreadPoolSize(int poolSize) {
    }

    @Override // org.quartz.spi.JobStore
    public long getEstimatedTimeToReleaseAndAcquireTrigger() {
        return 5;
    }

    @Override // org.quartz.spi.JobStore
    public boolean isClustered() {
        return false;
    }
}
