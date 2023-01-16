package org.quartz.impl.jdbcjobstore;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.JobPersistenceException;
import org.quartz.TriggerKey;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.ClassLoadHelper;
import org.quartz.spi.OperableTrigger;
import org.quartz.utils.Key;
import org.slf4j.Logger;

/* loaded from: grasscutter.jar:org/quartz/impl/jdbcjobstore/DriverDelegate.class */
public interface DriverDelegate {
    void initialize(Logger logger, String str, String str2, String str3, ClassLoadHelper classLoadHelper, boolean z, String str4) throws NoSuchDelegateException;

    int updateTriggerStatesFromOtherStates(Connection connection, String str, String str2, String str3) throws SQLException;

    List<TriggerKey> selectMisfiredTriggers(Connection connection, long j) throws SQLException;

    List<TriggerKey> selectMisfiredTriggersInState(Connection connection, String str, long j) throws SQLException;

    boolean hasMisfiredTriggersInState(Connection connection, String str, long j, int i, List<TriggerKey> list) throws SQLException;

    int countMisfiredTriggersInState(Connection connection, String str, long j) throws SQLException;

    List<TriggerKey> selectMisfiredTriggersInGroupInState(Connection connection, String str, String str2, long j) throws SQLException;

    List<OperableTrigger> selectTriggersForRecoveringJobs(Connection connection) throws SQLException, IOException, ClassNotFoundException;

    int deleteFiredTriggers(Connection connection) throws SQLException;

    int deleteFiredTriggers(Connection connection, String str) throws SQLException;

    int insertJobDetail(Connection connection, JobDetail jobDetail) throws IOException, SQLException;

    int updateJobDetail(Connection connection, JobDetail jobDetail) throws IOException, SQLException;

    List<TriggerKey> selectTriggerKeysForJob(Connection connection, JobKey jobKey) throws SQLException;

    int deleteJobDetail(Connection connection, JobKey jobKey) throws SQLException;

    boolean isJobNonConcurrent(Connection connection, JobKey jobKey) throws SQLException;

    boolean jobExists(Connection connection, JobKey jobKey) throws SQLException;

    int updateJobData(Connection connection, JobDetail jobDetail) throws IOException, SQLException;

    JobDetail selectJobDetail(Connection connection, JobKey jobKey, ClassLoadHelper classLoadHelper) throws ClassNotFoundException, IOException, SQLException;

    int selectNumJobs(Connection connection) throws SQLException;

    List<String> selectJobGroups(Connection connection) throws SQLException;

    Set<JobKey> selectJobsInGroup(Connection connection, GroupMatcher<JobKey> groupMatcher) throws SQLException;

    int insertTrigger(Connection connection, OperableTrigger operableTrigger, String str, JobDetail jobDetail) throws SQLException, IOException;

    int updateTrigger(Connection connection, OperableTrigger operableTrigger, String str, JobDetail jobDetail) throws SQLException, IOException;

    boolean triggerExists(Connection connection, TriggerKey triggerKey) throws SQLException;

    int updateTriggerState(Connection connection, TriggerKey triggerKey, String str) throws SQLException;

    int updateTriggerStateFromOtherState(Connection connection, TriggerKey triggerKey, String str, String str2) throws SQLException;

    int updateTriggerStateFromOtherStates(Connection connection, TriggerKey triggerKey, String str, String str2, String str3, String str4) throws SQLException;

    int updateTriggerGroupStateFromOtherStates(Connection connection, GroupMatcher<TriggerKey> groupMatcher, String str, String str2, String str3, String str4) throws SQLException;

    int updateTriggerGroupStateFromOtherState(Connection connection, GroupMatcher<TriggerKey> groupMatcher, String str, String str2) throws SQLException;

    int updateTriggerStatesForJob(Connection connection, JobKey jobKey, String str) throws SQLException;

    int updateTriggerStatesForJobFromOtherState(Connection connection, JobKey jobKey, String str, String str2) throws SQLException;

    int deleteTrigger(Connection connection, TriggerKey triggerKey) throws SQLException;

    int selectNumTriggersForJob(Connection connection, JobKey jobKey) throws SQLException;

    JobDetail selectJobForTrigger(Connection connection, ClassLoadHelper classLoadHelper, TriggerKey triggerKey) throws ClassNotFoundException, SQLException;

    JobDetail selectJobForTrigger(Connection connection, ClassLoadHelper classLoadHelper, TriggerKey triggerKey, boolean z) throws ClassNotFoundException, SQLException;

    List<OperableTrigger> selectTriggersForJob(Connection connection, JobKey jobKey) throws SQLException, ClassNotFoundException, IOException, JobPersistenceException;

    List<OperableTrigger> selectTriggersForCalendar(Connection connection, String str) throws SQLException, ClassNotFoundException, IOException, JobPersistenceException;

    OperableTrigger selectTrigger(Connection connection, TriggerKey triggerKey) throws SQLException, ClassNotFoundException, IOException, JobPersistenceException;

    JobDataMap selectTriggerJobDataMap(Connection connection, String str, String str2) throws SQLException, ClassNotFoundException, IOException;

    String selectTriggerState(Connection connection, TriggerKey triggerKey) throws SQLException;

    TriggerStatus selectTriggerStatus(Connection connection, TriggerKey triggerKey) throws SQLException;

    int selectNumTriggers(Connection connection) throws SQLException;

    List<String> selectTriggerGroups(Connection connection) throws SQLException;

    List<String> selectTriggerGroups(Connection connection, GroupMatcher<TriggerKey> groupMatcher) throws SQLException;

    Set<TriggerKey> selectTriggersInGroup(Connection connection, GroupMatcher<TriggerKey> groupMatcher) throws SQLException;

    List<TriggerKey> selectTriggersInState(Connection connection, String str) throws SQLException;

    int insertPausedTriggerGroup(Connection connection, String str) throws SQLException;

    int deletePausedTriggerGroup(Connection connection, String str) throws SQLException;

    int deletePausedTriggerGroup(Connection connection, GroupMatcher<TriggerKey> groupMatcher) throws SQLException;

    int deleteAllPausedTriggerGroups(Connection connection) throws SQLException;

    boolean isTriggerGroupPaused(Connection connection, String str) throws SQLException;

    Set<String> selectPausedTriggerGroups(Connection connection) throws SQLException;

    boolean isExistingTriggerGroup(Connection connection, String str) throws SQLException;

    int insertCalendar(Connection connection, String str, Calendar calendar) throws IOException, SQLException;

    int updateCalendar(Connection connection, String str, Calendar calendar) throws IOException, SQLException;

    boolean calendarExists(Connection connection, String str) throws SQLException;

    Calendar selectCalendar(Connection connection, String str) throws ClassNotFoundException, IOException, SQLException;

    boolean calendarIsReferenced(Connection connection, String str) throws SQLException;

    int deleteCalendar(Connection connection, String str) throws SQLException;

    int selectNumCalendars(Connection connection) throws SQLException;

    List<String> selectCalendars(Connection connection) throws SQLException;

    long selectNextFireTime(Connection connection) throws SQLException;

    Key<?> selectTriggerForFireTime(Connection connection, long j) throws SQLException;

    List<TriggerKey> selectTriggerToAcquire(Connection connection, long j, long j2) throws SQLException;

    List<TriggerKey> selectTriggerToAcquire(Connection connection, long j, long j2, int i) throws SQLException;

    int insertFiredTrigger(Connection connection, OperableTrigger operableTrigger, String str, JobDetail jobDetail) throws SQLException;

    int updateFiredTrigger(Connection connection, OperableTrigger operableTrigger, String str, JobDetail jobDetail) throws SQLException;

    List<FiredTriggerRecord> selectFiredTriggerRecords(Connection connection, String str, String str2) throws SQLException;

    List<FiredTriggerRecord> selectFiredTriggerRecordsByJob(Connection connection, String str, String str2) throws SQLException;

    List<FiredTriggerRecord> selectInstancesFiredTriggerRecords(Connection connection, String str) throws SQLException;

    Set<String> selectFiredTriggerInstanceNames(Connection connection) throws SQLException;

    int deleteFiredTrigger(Connection connection, String str) throws SQLException;

    int selectJobExecutionCount(Connection connection, JobKey jobKey) throws SQLException;

    int insertSchedulerState(Connection connection, String str, long j, long j2) throws SQLException;

    int deleteSchedulerState(Connection connection, String str) throws SQLException;

    int updateSchedulerState(Connection connection, String str, long j) throws SQLException;

    List<SchedulerStateRecord> selectSchedulerStateRecords(Connection connection, String str) throws SQLException;

    void clearData(Connection connection) throws SQLException;
}
