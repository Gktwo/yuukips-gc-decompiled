package org.quartz.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.quartz.JobKey;
import org.quartz.JobListener;
import org.quartz.ListenerManager;
import org.quartz.Matcher;
import org.quartz.SchedulerListener;
import org.quartz.TriggerKey;
import org.quartz.TriggerListener;
import org.quartz.impl.matchers.EverythingMatcher;

/* loaded from: grasscutter.jar:org/quartz/core/ListenerManagerImpl.class */
public class ListenerManagerImpl implements ListenerManager {
    private Map<String, JobListener> globalJobListeners = new LinkedHashMap(10);
    private Map<String, TriggerListener> globalTriggerListeners = new LinkedHashMap(10);
    private Map<String, List<Matcher<JobKey>>> globalJobListenersMatchers = new LinkedHashMap(10);
    private Map<String, List<Matcher<TriggerKey>>> globalTriggerListenersMatchers = new LinkedHashMap(10);
    private ArrayList<SchedulerListener> schedulerListeners = new ArrayList<>(10);

    @Override // org.quartz.ListenerManager
    public void addJobListener(JobListener jobListener, Matcher<JobKey>... matchers) {
        addJobListener(jobListener, Arrays.asList(matchers));
    }

    @Override // org.quartz.ListenerManager
    public void addJobListener(JobListener jobListener, List<Matcher<JobKey>> matchers) {
        if (jobListener.getName() == null || jobListener.getName().length() == 0) {
            throw new IllegalArgumentException("JobListener name cannot be empty.");
        }
        synchronized (this.globalJobListeners) {
            this.globalJobListeners.put(jobListener.getName(), jobListener);
            LinkedList<Matcher<JobKey>> matchersL = new LinkedList<>();
            if (matchers == null || matchers.size() <= 0) {
                matchersL.add(EverythingMatcher.allJobs());
            } else {
                matchersL.addAll(matchers);
            }
            this.globalJobListenersMatchers.put(jobListener.getName(), matchersL);
        }
    }

    @Override // org.quartz.ListenerManager
    public void addJobListener(JobListener jobListener) {
        addJobListener(jobListener, EverythingMatcher.allJobs());
    }

    @Override // org.quartz.ListenerManager
    public void addJobListener(JobListener jobListener, Matcher<JobKey> matcher) {
        if (jobListener.getName() == null || jobListener.getName().length() == 0) {
            throw new IllegalArgumentException("JobListener name cannot be empty.");
        }
        synchronized (this.globalJobListeners) {
            this.globalJobListeners.put(jobListener.getName(), jobListener);
            LinkedList<Matcher<JobKey>> matchersL = new LinkedList<>();
            if (matcher != null) {
                matchersL.add(matcher);
            } else {
                matchersL.add(EverythingMatcher.allJobs());
            }
            this.globalJobListenersMatchers.put(jobListener.getName(), matchersL);
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean addJobListenerMatcher(String listenerName, Matcher<JobKey> matcher) {
        if (matcher == null) {
            throw new IllegalArgumentException("Null value not acceptable.");
        }
        synchronized (this.globalJobListeners) {
            List<Matcher<JobKey>> matchers = this.globalJobListenersMatchers.get(listenerName);
            if (matchers == null) {
                return false;
            }
            matchers.add(matcher);
            return true;
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean removeJobListenerMatcher(String listenerName, Matcher<JobKey> matcher) {
        if (matcher == null) {
            throw new IllegalArgumentException("Non-null value not acceptable.");
        }
        synchronized (this.globalJobListeners) {
            List<Matcher<JobKey>> matchers = this.globalJobListenersMatchers.get(listenerName);
            if (matchers == null) {
                return false;
            }
            return matchers.remove(matcher);
        }
    }

    @Override // org.quartz.ListenerManager
    public List<Matcher<JobKey>> getJobListenerMatchers(String listenerName) {
        synchronized (this.globalJobListeners) {
            List<Matcher<JobKey>> matchers = this.globalJobListenersMatchers.get(listenerName);
            if (matchers == null) {
                return null;
            }
            return Collections.unmodifiableList(matchers);
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean setJobListenerMatchers(String listenerName, List<Matcher<JobKey>> matchers) {
        if (matchers == null) {
            throw new IllegalArgumentException("Non-null value not acceptable.");
        }
        synchronized (this.globalJobListeners) {
            if (this.globalJobListenersMatchers.get(listenerName) == null) {
                return false;
            }
            this.globalJobListenersMatchers.put(listenerName, matchers);
            return true;
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean removeJobListener(String name) {
        boolean z;
        synchronized (this.globalJobListeners) {
            z = this.globalJobListeners.remove(name) != null;
        }
        return z;
    }

    @Override // org.quartz.ListenerManager
    public List<JobListener> getJobListeners() {
        List<JobListener> unmodifiableList;
        synchronized (this.globalJobListeners) {
            unmodifiableList = Collections.unmodifiableList(new LinkedList(this.globalJobListeners.values()));
        }
        return unmodifiableList;
    }

    @Override // org.quartz.ListenerManager
    public JobListener getJobListener(String name) {
        JobListener jobListener;
        synchronized (this.globalJobListeners) {
            jobListener = this.globalJobListeners.get(name);
        }
        return jobListener;
    }

    @Override // org.quartz.ListenerManager
    public void addTriggerListener(TriggerListener triggerListener, Matcher<TriggerKey>... matchers) {
        addTriggerListener(triggerListener, Arrays.asList(matchers));
    }

    @Override // org.quartz.ListenerManager
    public void addTriggerListener(TriggerListener triggerListener, List<Matcher<TriggerKey>> matchers) {
        if (triggerListener.getName() == null || triggerListener.getName().length() == 0) {
            throw new IllegalArgumentException("TriggerListener name cannot be empty.");
        }
        synchronized (this.globalTriggerListeners) {
            this.globalTriggerListeners.put(triggerListener.getName(), triggerListener);
            LinkedList<Matcher<TriggerKey>> matchersL = new LinkedList<>();
            if (matchers == null || matchers.size() <= 0) {
                matchersL.add(EverythingMatcher.allTriggers());
            } else {
                matchersL.addAll(matchers);
            }
            this.globalTriggerListenersMatchers.put(triggerListener.getName(), matchersL);
        }
    }

    @Override // org.quartz.ListenerManager
    public void addTriggerListener(TriggerListener triggerListener) {
        addTriggerListener(triggerListener, EverythingMatcher.allTriggers());
    }

    @Override // org.quartz.ListenerManager
    public void addTriggerListener(TriggerListener triggerListener, Matcher<TriggerKey> matcher) {
        if (matcher == null) {
            throw new IllegalArgumentException("Null value not acceptable for matcher.");
        } else if (triggerListener.getName() == null || triggerListener.getName().length() == 0) {
            throw new IllegalArgumentException("TriggerListener name cannot be empty.");
        } else {
            synchronized (this.globalTriggerListeners) {
                this.globalTriggerListeners.put(triggerListener.getName(), triggerListener);
                List<Matcher<TriggerKey>> matchers = new LinkedList<>();
                matchers.add(matcher);
                this.globalTriggerListenersMatchers.put(triggerListener.getName(), matchers);
            }
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean addTriggerListenerMatcher(String listenerName, Matcher<TriggerKey> matcher) {
        if (matcher == null) {
            throw new IllegalArgumentException("Non-null value not acceptable.");
        }
        synchronized (this.globalTriggerListeners) {
            List<Matcher<TriggerKey>> matchers = this.globalTriggerListenersMatchers.get(listenerName);
            if (matchers == null) {
                return false;
            }
            matchers.add(matcher);
            return true;
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean removeTriggerListenerMatcher(String listenerName, Matcher<TriggerKey> matcher) {
        if (matcher == null) {
            throw new IllegalArgumentException("Non-null value not acceptable.");
        }
        synchronized (this.globalTriggerListeners) {
            List<Matcher<TriggerKey>> matchers = this.globalTriggerListenersMatchers.get(listenerName);
            if (matchers == null) {
                return false;
            }
            return matchers.remove(matcher);
        }
    }

    @Override // org.quartz.ListenerManager
    public List<Matcher<TriggerKey>> getTriggerListenerMatchers(String listenerName) {
        synchronized (this.globalTriggerListeners) {
            List<Matcher<TriggerKey>> matchers = this.globalTriggerListenersMatchers.get(listenerName);
            if (matchers == null) {
                return null;
            }
            return Collections.unmodifiableList(matchers);
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean setTriggerListenerMatchers(String listenerName, List<Matcher<TriggerKey>> matchers) {
        if (matchers == null) {
            throw new IllegalArgumentException("Non-null value not acceptable.");
        }
        synchronized (this.globalTriggerListeners) {
            if (this.globalTriggerListenersMatchers.get(listenerName) == null) {
                return false;
            }
            this.globalTriggerListenersMatchers.put(listenerName, matchers);
            return true;
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean removeTriggerListener(String name) {
        boolean z;
        synchronized (this.globalTriggerListeners) {
            z = this.globalTriggerListeners.remove(name) != null;
        }
        return z;
    }

    @Override // org.quartz.ListenerManager
    public List<TriggerListener> getTriggerListeners() {
        List<TriggerListener> unmodifiableList;
        synchronized (this.globalTriggerListeners) {
            unmodifiableList = Collections.unmodifiableList(new LinkedList(this.globalTriggerListeners.values()));
        }
        return unmodifiableList;
    }

    @Override // org.quartz.ListenerManager
    public TriggerListener getTriggerListener(String name) {
        TriggerListener triggerListener;
        synchronized (this.globalTriggerListeners) {
            triggerListener = this.globalTriggerListeners.get(name);
        }
        return triggerListener;
    }

    @Override // org.quartz.ListenerManager
    public void addSchedulerListener(SchedulerListener schedulerListener) {
        synchronized (this.schedulerListeners) {
            this.schedulerListeners.add(schedulerListener);
        }
    }

    @Override // org.quartz.ListenerManager
    public boolean removeSchedulerListener(SchedulerListener schedulerListener) {
        boolean remove;
        synchronized (this.schedulerListeners) {
            remove = this.schedulerListeners.remove(schedulerListener);
        }
        return remove;
    }

    @Override // org.quartz.ListenerManager
    public List<SchedulerListener> getSchedulerListeners() {
        List<SchedulerListener> unmodifiableList;
        synchronized (this.schedulerListeners) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(this.schedulerListeners));
        }
        return unmodifiableList;
    }
}
