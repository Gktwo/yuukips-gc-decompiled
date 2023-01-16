package org.terracotta.quartz.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import org.quartz.Calendar;
import org.quartz.JobKey;
import org.quartz.TriggerKey;
import org.terracotta.quartz.wrappers.FiredTrigger;
import org.terracotta.quartz.wrappers.JobWrapper;
import org.terracotta.quartz.wrappers.TriggerWrapper;
import org.terracotta.toolkit.Toolkit;
import org.terracotta.toolkit.builder.ToolkitStoreConfigBuilder;
import org.terracotta.toolkit.collections.ToolkitSet;
import org.terracotta.toolkit.concurrent.locks.ToolkitLock;
import org.terracotta.toolkit.internal.concurrent.locks.ToolkitLockTypeInternal;
import org.terracotta.toolkit.store.ToolkitConfigFields;
import org.terracotta.toolkit.store.ToolkitStore;

/* loaded from: grasscutter.jar:org/terracotta/quartz/collections/ToolkitDSHolder.class */
public class ToolkitDSHolder {
    private static final String JOBS_MAP_PREFIX = "_tc_quartz_jobs";
    private static final String ALL_JOBS_GROUP_NAMES_SET_PREFIX = "_tc_quartz_grp_names";
    private static final String PAUSED_GROUPS_SET_PREFIX = "_tc_quartz_grp_paused_names";
    private static final String BLOCKED_JOBS_SET_PREFIX = "_tc_quartz_blocked_jobs";
    private static final String JOBS_GROUP_MAP_PREFIX = "_tc_quartz_grp_jobs_";
    private static final String TRIGGERS_MAP_PREFIX = "_tc_quartz_triggers";
    private static final String TRIGGERS_GROUP_MAP_PREFIX = "_tc_quartz_grp_triggers_";
    private static final String ALL_TRIGGERS_GROUP_NAMES_SET_PREFIX = "_tc_quartz_grp_names_triggers";
    private static final String PAUSED_TRIGGER_GROUPS_SET_PREFIX = "_tc_quartz_grp_paused_trogger_names";
    private static final String TIME_TRIGGER_SORTED_SET_PREFIX = "_tc_time_trigger_sorted_set";
    private static final String FIRED_TRIGGER_MAP_PREFIX = "_tc_quartz_fired_trigger";
    private static final String CALENDAR_WRAPPER_MAP_PREFIX = "_tc_quartz_calendar_wrapper";
    private static final String SINGLE_LOCK_NAME_PREFIX = "_tc_quartz_single_lock";
    private static final String DELIMETER = "|";
    private final String jobStoreName;
    protected final Toolkit toolkit;
    private final AtomicReference<SerializedToolkitStore<JobKey, JobWrapper>> jobsMapReference = new AtomicReference<>();
    private final AtomicReference<SerializedToolkitStore<TriggerKey, TriggerWrapper>> triggersMapReference = new AtomicReference<>();
    private final AtomicReference<ToolkitSet<String>> allGroupsReference = new AtomicReference<>();
    private final AtomicReference<ToolkitSet<String>> allTriggersGroupsReference = new AtomicReference<>();
    private final AtomicReference<ToolkitSet<String>> pausedGroupsReference = new AtomicReference<>();
    private final AtomicReference<ToolkitSet<JobKey>> blockedJobsReference = new AtomicReference<>();
    private final Map<String, ToolkitSet<String>> jobsGroupSet = new HashMap();
    private final Map<String, ToolkitSet<String>> triggersGroupSet = new HashMap();
    private final AtomicReference<ToolkitSet<String>> pausedTriggerGroupsReference = new AtomicReference<>();
    private final AtomicReference<ToolkitStore<String, FiredTrigger>> firedTriggersMapReference = new AtomicReference<>();
    private final AtomicReference<ToolkitStore<String, Calendar>> calendarWrapperMapReference = new AtomicReference<>();
    private final AtomicReference<TimeTriggerSet> timeTriggerSetReference = new AtomicReference<>();
    private final Map<String, ToolkitStore<?, ?>> toolkitMaps = new HashMap();

    public ToolkitDSHolder(String jobStoreName, Toolkit toolkit) {
        this.jobStoreName = jobStoreName;
        this.toolkit = toolkit;
    }

    protected final String generateName(String prefix) {
        return prefix + DELIMETER + this.jobStoreName;
    }

    public SerializedToolkitStore<JobKey, JobWrapper> getOrCreateJobsMap() {
        this.jobsMapReference.compareAndSet(null, new SerializedToolkitStore<>(createStore(generateName(JOBS_MAP_PREFIX))));
        return this.jobsMapReference.get();
    }

    protected ToolkitStore<?, ?> toolkitMap(String nameOfMap) {
        ToolkitStore<?, ?> map = this.toolkitMaps.get(nameOfMap);
        if (map != null && !map.isDestroyed()) {
            return map;
        }
        ToolkitStore<?, ?> map2 = createStore(nameOfMap);
        this.toolkitMaps.put(nameOfMap, map2);
        return map2;
    }

    private ToolkitStore createStore(String nameOfMap) {
        return this.toolkit.getStore(nameOfMap, new ToolkitStoreConfigBuilder().consistency(ToolkitConfigFields.Consistency.STRONG).concurrency(1).build(), (Class) null);
    }

    public SerializedToolkitStore<TriggerKey, TriggerWrapper> getOrCreateTriggersMap() {
        this.triggersMapReference.compareAndSet(null, new SerializedToolkitStore<>(createStore(generateName(TRIGGERS_MAP_PREFIX))));
        return this.triggersMapReference.get();
    }

    public ToolkitStore<String, FiredTrigger> getOrCreateFiredTriggersMap() {
        this.firedTriggersMapReference.compareAndSet(null, createStore(generateName(FIRED_TRIGGER_MAP_PREFIX)));
        return this.firedTriggersMapReference.get();
    }

    public ToolkitStore<String, Calendar> getOrCreateCalendarWrapperMap() {
        this.calendarWrapperMapReference.compareAndSet(null, createStore(generateName(CALENDAR_WRAPPER_MAP_PREFIX)));
        return this.calendarWrapperMapReference.get();
    }

    public Set<String> getOrCreateAllGroupsSet() {
        this.allGroupsReference.compareAndSet(null, this.toolkit.getSet(generateName(ALL_JOBS_GROUP_NAMES_SET_PREFIX), String.class));
        return this.allGroupsReference.get();
    }

    public Set<JobKey> getOrCreateBlockedJobsSet() {
        this.blockedJobsReference.compareAndSet(null, this.toolkit.getSet(generateName(BLOCKED_JOBS_SET_PREFIX), JobKey.class));
        return this.blockedJobsReference.get();
    }

    public Set<String> getOrCreatePausedGroupsSet() {
        this.pausedGroupsReference.compareAndSet(null, this.toolkit.getSet(generateName(PAUSED_GROUPS_SET_PREFIX), String.class));
        return this.pausedGroupsReference.get();
    }

    public Set<String> getOrCreatePausedTriggerGroupsSet() {
        this.pausedTriggerGroupsReference.compareAndSet(null, this.toolkit.getSet(generateName(PAUSED_TRIGGER_GROUPS_SET_PREFIX), String.class));
        return this.pausedTriggerGroupsReference.get();
    }

    public Set<String> getOrCreateJobsGroupMap(String name) {
        ToolkitSet<String> set = this.jobsGroupSet.get(name);
        if (set != null && !set.isDestroyed()) {
            return set;
        }
        ToolkitSet<String> set2 = this.toolkit.getSet(generateName(JOBS_GROUP_MAP_PREFIX + name), String.class);
        this.jobsGroupSet.put(name, set2);
        return set2;
    }

    public void removeJobsGroupMap(String name) {
        ToolkitSet<String> set = this.jobsGroupSet.remove(name);
        if (set != null) {
            set.destroy();
        }
    }

    public Set<String> getOrCreateTriggersGroupMap(String name) {
        ToolkitSet<String> set = this.triggersGroupSet.get(name);
        if (set != null && !set.isDestroyed()) {
            return set;
        }
        ToolkitSet<String> set2 = this.toolkit.getSet(generateName(TRIGGERS_GROUP_MAP_PREFIX + name), String.class);
        this.triggersGroupSet.put(name, set2);
        return set2;
    }

    public void removeTriggersGroupMap(String name) {
        ToolkitSet<String> set = this.triggersGroupSet.remove(name);
        if (set != null) {
            set.destroy();
        }
    }

    public Set<String> getOrCreateAllTriggersGroupsSet() {
        this.allTriggersGroupsReference.compareAndSet(null, this.toolkit.getSet(generateName(ALL_TRIGGERS_GROUP_NAMES_SET_PREFIX), String.class));
        return this.allTriggersGroupsReference.get();
    }

    public TimeTriggerSet getOrCreateTimeTriggerSet() {
        this.timeTriggerSetReference.compareAndSet(null, new TimeTriggerSet(this.toolkit.getSortedSet(generateName(TIME_TRIGGER_SORTED_SET_PREFIX), TimeTrigger.class)));
        return this.timeTriggerSetReference.get();
    }

    public ToolkitLock getLock(ToolkitLockTypeInternal lockType) {
        return this.toolkit.getLock(generateName(SINGLE_LOCK_NAME_PREFIX), lockType);
    }
}
