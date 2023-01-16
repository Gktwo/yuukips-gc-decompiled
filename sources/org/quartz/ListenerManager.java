package org.quartz;

import java.util.List;

/* loaded from: grasscutter.jar:org/quartz/ListenerManager.class */
public interface ListenerManager {
    void addJobListener(JobListener jobListener);

    void addJobListener(JobListener jobListener, Matcher<JobKey> matcher);

    void addJobListener(JobListener jobListener, Matcher<JobKey>... matcherArr);

    void addJobListener(JobListener jobListener, List<Matcher<JobKey>> list);

    boolean addJobListenerMatcher(String str, Matcher<JobKey> matcher);

    boolean removeJobListenerMatcher(String str, Matcher<JobKey> matcher);

    boolean setJobListenerMatchers(String str, List<Matcher<JobKey>> list);

    List<Matcher<JobKey>> getJobListenerMatchers(String str);

    boolean removeJobListener(String str);

    List<JobListener> getJobListeners();

    JobListener getJobListener(String str);

    void addTriggerListener(TriggerListener triggerListener);

    void addTriggerListener(TriggerListener triggerListener, Matcher<TriggerKey> matcher);

    void addTriggerListener(TriggerListener triggerListener, Matcher<TriggerKey>... matcherArr);

    void addTriggerListener(TriggerListener triggerListener, List<Matcher<TriggerKey>> list);

    boolean addTriggerListenerMatcher(String str, Matcher<TriggerKey> matcher);

    boolean removeTriggerListenerMatcher(String str, Matcher<TriggerKey> matcher);

    boolean setTriggerListenerMatchers(String str, List<Matcher<TriggerKey>> list);

    List<Matcher<TriggerKey>> getTriggerListenerMatchers(String str);

    boolean removeTriggerListener(String str);

    List<TriggerListener> getTriggerListeners();

    TriggerListener getTriggerListener(String str);

    void addSchedulerListener(SchedulerListener schedulerListener);

    boolean removeSchedulerListener(SchedulerListener schedulerListener);

    List<SchedulerListener> getSchedulerListeners();
}
