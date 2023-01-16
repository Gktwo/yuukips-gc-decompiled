package org.quartz.core;

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.UnexpectedException;
import java.rmi.server.RemoteObject;
import java.rmi.server.RemoteRef;
import java.rmi.server.RemoteStub;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jline.reader.LineReader;
import org.quartz.Calendar;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.SchedulerContext;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerKey;
import org.quartz.UnableToInterruptJobException;
import org.quartz.impl.matchers.GroupMatcher;
import org.quartz.spi.OperableTrigger;

/* loaded from: grasscutter.jar:org/quartz/core/QuartzScheduler_Stub.class */
public final class QuartzScheduler_Stub extends RemoteStub implements RemotableQuartzScheduler {
    private static final long serialVersionUID = 2;
    private static Method $method_addCalendar_0;
    private static Method $method_addJob_1;
    private static Method $method_addJob_2;
    private static Method $method_checkExists_3;
    private static Method $method_checkExists_4;
    private static Method $method_clear_5;
    private static Method $method_deleteCalendar_6;
    private static Method $method_deleteJob_7;
    private static Method $method_deleteJobs_8;
    private static Method $method_getCalendar_9;
    private static Method $method_getCalendarNames_10;
    private static Method $method_getCurrentlyExecutingJobs_11;
    private static Method $method_getJobDetail_12;
    private static Method $method_getJobGroupNames_13;
    private static Method $method_getJobKeys_14;
    private static Method $method_getJobStoreClass_15;
    private static Method $method_getPausedTriggerGroups_16;
    private static Method $method_getSchedulerContext_17;
    private static Method $method_getSchedulerInstanceId_18;
    private static Method $method_getSchedulerName_19;
    private static Method $method_getThreadPoolClass_20;
    private static Method $method_getThreadPoolSize_21;
    private static Method $method_getTrigger_22;
    private static Method $method_getTriggerGroupNames_23;
    private static Method $method_getTriggerKeys_24;
    private static Method $method_getTriggerState_25;
    private static Method $method_getTriggersOfJob_26;
    private static Method $method_getVersion_27;
    private static Method $method_interrupt_28;
    private static Method $method_interrupt_29;
    private static Method $method_isClustered_30;
    private static Method $method_isInStandbyMode_31;
    private static Method $method_isShutdown_32;
    private static Method $method_numJobsExecuted_33;
    private static Method $method_pauseAll_34;
    private static Method $method_pauseJob_35;
    private static Method $method_pauseJobs_36;
    private static Method $method_pauseTrigger_37;
    private static Method $method_pauseTriggers_38;
    private static Method $method_rescheduleJob_39;
    private static Method $method_resetTriggerFromErrorState_40;
    private static Method $method_resumeAll_41;
    private static Method $method_resumeJob_42;
    private static Method $method_resumeJobs_43;
    private static Method $method_resumeTrigger_44;
    private static Method $method_resumeTriggers_45;
    private static Method $method_runningSince_46;
    private static Method $method_scheduleJob_47;
    private static Method $method_scheduleJob_48;
    private static Method $method_scheduleJob_49;
    private static Method $method_scheduleJobs_50;
    private static Method $method_shutdown_51;
    private static Method $method_shutdown_52;
    private static Method $method_standby_53;
    private static Method $method_start_54;
    private static Method $method_startDelayed_55;
    private static Method $method_supportsPersistence_56;
    private static Method $method_triggerJob_57;
    private static Method $method_triggerJob_58;
    private static Method $method_unscheduleJob_59;
    private static Method $method_unscheduleJobs_60;
    static Class class$org$quartz$core$RemotableQuartzScheduler;
    static Class class$java$lang$String;
    static Class class$org$quartz$Calendar;
    static Class class$org$quartz$JobDetail;
    static Class class$org$quartz$JobKey;
    static Class class$org$quartz$TriggerKey;
    static Class class$java$util$List;
    static Class class$org$quartz$impl$matchers$GroupMatcher;
    static Class class$org$quartz$Trigger;
    static Class class$java$util$Set;
    static Class class$java$util$Map;
    static Class class$org$quartz$JobDataMap;
    static Class class$org$quartz$spi$OperableTrigger;

    static {
        Class cls;
        Class<?> cls2;
        Class<?> cls3;
        Class cls4;
        Class<?> cls5;
        Class cls6;
        Class<?> cls7;
        Class cls8;
        Class<?> cls9;
        Class cls10;
        Class<?> cls11;
        Class cls12;
        Class cls13;
        Class<?> cls14;
        Class cls15;
        Class<?> cls16;
        Class cls17;
        Class<?> cls18;
        Class cls19;
        Class<?> cls20;
        Class cls21;
        Class cls22;
        Class cls23;
        Class<?> cls24;
        Class cls25;
        Class cls26;
        Class<?> cls27;
        Class cls28;
        Class cls29;
        Class cls30;
        Class cls31;
        Class cls32;
        Class cls33;
        Class cls34;
        Class cls35;
        Class<?> cls36;
        Class cls37;
        Class cls38;
        Class<?> cls39;
        Class cls40;
        Class<?> cls41;
        Class cls42;
        Class<?> cls43;
        Class cls44;
        Class cls45;
        Class<?> cls46;
        Class cls47;
        Class<?> cls48;
        Class cls49;
        Class cls50;
        Class cls51;
        Class cls52;
        Class cls53;
        Class cls54;
        Class<?> cls55;
        Class cls56;
        Class<?> cls57;
        Class cls58;
        Class<?> cls59;
        Class cls60;
        Class<?> cls61;
        Class cls62;
        Class<?> cls63;
        Class<?> cls64;
        Class cls65;
        Class<?> cls66;
        Class cls67;
        Class cls68;
        Class<?> cls69;
        Class cls70;
        Class<?> cls71;
        Class cls72;
        Class<?> cls73;
        Class cls74;
        Class<?> cls75;
        Class cls76;
        Class cls77;
        Class<?> cls78;
        Class<?> cls79;
        Class cls80;
        Class<?> cls81;
        Class<?> cls82;
        Class cls83;
        Class<?> cls84;
        Class cls85;
        Class<?> cls86;
        Class cls87;
        Class cls88;
        Class cls89;
        Class cls90;
        Class cls91;
        Class cls92;
        Class cls93;
        Class<?> cls94;
        Class<?> cls95;
        Class cls96;
        Class<?> cls97;
        Class cls98;
        Class<?> cls99;
        Class cls100;
        Class<?> cls101;
        try {
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls;
            }
            Class<?>[] clsArr = new Class[4];
            if (class$java$lang$String != null) {
                cls2 = class$java$lang$String;
            } else {
                cls2 = class$("java.lang.String");
                class$java$lang$String = cls2;
            }
            clsArr[0] = cls2;
            if (class$org$quartz$Calendar != null) {
                cls3 = class$org$quartz$Calendar;
            } else {
                cls3 = class$("org.quartz.Calendar");
                class$org$quartz$Calendar = cls3;
            }
            clsArr[1] = cls3;
            clsArr[2] = Boolean.TYPE;
            clsArr[3] = Boolean.TYPE;
            $method_addCalendar_0 = cls.getMethod("addCalendar", clsArr);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls4 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls4 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls4;
            }
            Class<?>[] clsArr2 = new Class[2];
            if (class$org$quartz$JobDetail != null) {
                cls5 = class$org$quartz$JobDetail;
            } else {
                cls5 = class$("org.quartz.JobDetail");
                class$org$quartz$JobDetail = cls5;
            }
            clsArr2[0] = cls5;
            clsArr2[1] = Boolean.TYPE;
            $method_addJob_1 = cls4.getMethod("addJob", clsArr2);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls6 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls6 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls6;
            }
            Class<?>[] clsArr3 = new Class[3];
            if (class$org$quartz$JobDetail != null) {
                cls7 = class$org$quartz$JobDetail;
            } else {
                cls7 = class$("org.quartz.JobDetail");
                class$org$quartz$JobDetail = cls7;
            }
            clsArr3[0] = cls7;
            clsArr3[1] = Boolean.TYPE;
            clsArr3[2] = Boolean.TYPE;
            $method_addJob_2 = cls6.getMethod("addJob", clsArr3);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls8 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls8 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls8;
            }
            Class<?>[] clsArr4 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls9 = class$org$quartz$JobKey;
            } else {
                cls9 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls9;
            }
            clsArr4[0] = cls9;
            $method_checkExists_3 = cls8.getMethod("checkExists", clsArr4);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls10 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls10 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls10;
            }
            Class<?>[] clsArr5 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls11 = class$org$quartz$TriggerKey;
            } else {
                cls11 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls11;
            }
            clsArr5[0] = cls11;
            $method_checkExists_4 = cls10.getMethod("checkExists", clsArr5);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls12 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls12 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls12;
            }
            $method_clear_5 = cls12.getMethod(LineReader.CLEAR, new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls13 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls13 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls13;
            }
            Class<?>[] clsArr6 = new Class[1];
            if (class$java$lang$String != null) {
                cls14 = class$java$lang$String;
            } else {
                cls14 = class$("java.lang.String");
                class$java$lang$String = cls14;
            }
            clsArr6[0] = cls14;
            $method_deleteCalendar_6 = cls13.getMethod("deleteCalendar", clsArr6);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls15 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls15 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls15;
            }
            Class<?>[] clsArr7 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls16 = class$org$quartz$JobKey;
            } else {
                cls16 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls16;
            }
            clsArr7[0] = cls16;
            $method_deleteJob_7 = cls15.getMethod("deleteJob", clsArr7);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls17 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls17 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls17;
            }
            Class<?>[] clsArr8 = new Class[1];
            if (class$java$util$List != null) {
                cls18 = class$java$util$List;
            } else {
                cls18 = class$("java.util.List");
                class$java$util$List = cls18;
            }
            clsArr8[0] = cls18;
            $method_deleteJobs_8 = cls17.getMethod("deleteJobs", clsArr8);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls19 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls19 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls19;
            }
            Class<?>[] clsArr9 = new Class[1];
            if (class$java$lang$String != null) {
                cls20 = class$java$lang$String;
            } else {
                cls20 = class$("java.lang.String");
                class$java$lang$String = cls20;
            }
            clsArr9[0] = cls20;
            $method_getCalendar_9 = cls19.getMethod("getCalendar", clsArr9);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls21 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls21 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls21;
            }
            $method_getCalendarNames_10 = cls21.getMethod("getCalendarNames", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls22 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls22 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls22;
            }
            $method_getCurrentlyExecutingJobs_11 = cls22.getMethod("getCurrentlyExecutingJobs", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls23 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls23 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls23;
            }
            Class<?>[] clsArr10 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls24 = class$org$quartz$JobKey;
            } else {
                cls24 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls24;
            }
            clsArr10[0] = cls24;
            $method_getJobDetail_12 = cls23.getMethod("getJobDetail", clsArr10);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls25 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls25 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls25;
            }
            $method_getJobGroupNames_13 = cls25.getMethod("getJobGroupNames", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls26 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls26 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls26;
            }
            Class<?>[] clsArr11 = new Class[1];
            if (class$org$quartz$impl$matchers$GroupMatcher != null) {
                cls27 = class$org$quartz$impl$matchers$GroupMatcher;
            } else {
                cls27 = class$("org.quartz.impl.matchers.GroupMatcher");
                class$org$quartz$impl$matchers$GroupMatcher = cls27;
            }
            clsArr11[0] = cls27;
            $method_getJobKeys_14 = cls26.getMethod("getJobKeys", clsArr11);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls28 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls28 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls28;
            }
            $method_getJobStoreClass_15 = cls28.getMethod("getJobStoreClass", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls29 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls29 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls29;
            }
            $method_getPausedTriggerGroups_16 = cls29.getMethod("getPausedTriggerGroups", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls30 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls30 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls30;
            }
            $method_getSchedulerContext_17 = cls30.getMethod("getSchedulerContext", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls31 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls31 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls31;
            }
            $method_getSchedulerInstanceId_18 = cls31.getMethod("getSchedulerInstanceId", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls32 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls32 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls32;
            }
            $method_getSchedulerName_19 = cls32.getMethod("getSchedulerName", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls33 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls33 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls33;
            }
            $method_getThreadPoolClass_20 = cls33.getMethod("getThreadPoolClass", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls34 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls34 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls34;
            }
            $method_getThreadPoolSize_21 = cls34.getMethod("getThreadPoolSize", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls35 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls35 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls35;
            }
            Class<?>[] clsArr12 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls36 = class$org$quartz$TriggerKey;
            } else {
                cls36 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls36;
            }
            clsArr12[0] = cls36;
            $method_getTrigger_22 = cls35.getMethod("getTrigger", clsArr12);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls37 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls37 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls37;
            }
            $method_getTriggerGroupNames_23 = cls37.getMethod("getTriggerGroupNames", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls38 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls38 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls38;
            }
            Class<?>[] clsArr13 = new Class[1];
            if (class$org$quartz$impl$matchers$GroupMatcher != null) {
                cls39 = class$org$quartz$impl$matchers$GroupMatcher;
            } else {
                cls39 = class$("org.quartz.impl.matchers.GroupMatcher");
                class$org$quartz$impl$matchers$GroupMatcher = cls39;
            }
            clsArr13[0] = cls39;
            $method_getTriggerKeys_24 = cls38.getMethod("getTriggerKeys", clsArr13);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls40 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls40 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls40;
            }
            Class<?>[] clsArr14 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls41 = class$org$quartz$TriggerKey;
            } else {
                cls41 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls41;
            }
            clsArr14[0] = cls41;
            $method_getTriggerState_25 = cls40.getMethod("getTriggerState", clsArr14);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls42 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls42 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls42;
            }
            Class<?>[] clsArr15 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls43 = class$org$quartz$JobKey;
            } else {
                cls43 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls43;
            }
            clsArr15[0] = cls43;
            $method_getTriggersOfJob_26 = cls42.getMethod("getTriggersOfJob", clsArr15);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls44 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls44 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls44;
            }
            $method_getVersion_27 = cls44.getMethod("getVersion", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls45 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls45 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls45;
            }
            Class<?>[] clsArr16 = new Class[1];
            if (class$java$lang$String != null) {
                cls46 = class$java$lang$String;
            } else {
                cls46 = class$("java.lang.String");
                class$java$lang$String = cls46;
            }
            clsArr16[0] = cls46;
            $method_interrupt_28 = cls45.getMethod("interrupt", clsArr16);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls47 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls47 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls47;
            }
            Class<?>[] clsArr17 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls48 = class$org$quartz$JobKey;
            } else {
                cls48 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls48;
            }
            clsArr17[0] = cls48;
            $method_interrupt_29 = cls47.getMethod("interrupt", clsArr17);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls49 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls49 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls49;
            }
            $method_isClustered_30 = cls49.getMethod("isClustered", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls50 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls50 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls50;
            }
            $method_isInStandbyMode_31 = cls50.getMethod("isInStandbyMode", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls51 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls51 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls51;
            }
            $method_isShutdown_32 = cls51.getMethod("isShutdown", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls52 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls52 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls52;
            }
            $method_numJobsExecuted_33 = cls52.getMethod("numJobsExecuted", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls53 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls53 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls53;
            }
            $method_pauseAll_34 = cls53.getMethod("pauseAll", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls54 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls54 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls54;
            }
            Class<?>[] clsArr18 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls55 = class$org$quartz$JobKey;
            } else {
                cls55 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls55;
            }
            clsArr18[0] = cls55;
            $method_pauseJob_35 = cls54.getMethod("pauseJob", clsArr18);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls56 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls56 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls56;
            }
            Class<?>[] clsArr19 = new Class[1];
            if (class$org$quartz$impl$matchers$GroupMatcher != null) {
                cls57 = class$org$quartz$impl$matchers$GroupMatcher;
            } else {
                cls57 = class$("org.quartz.impl.matchers.GroupMatcher");
                class$org$quartz$impl$matchers$GroupMatcher = cls57;
            }
            clsArr19[0] = cls57;
            $method_pauseJobs_36 = cls56.getMethod("pauseJobs", clsArr19);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls58 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls58 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls58;
            }
            Class<?>[] clsArr20 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls59 = class$org$quartz$TriggerKey;
            } else {
                cls59 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls59;
            }
            clsArr20[0] = cls59;
            $method_pauseTrigger_37 = cls58.getMethod("pauseTrigger", clsArr20);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls60 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls60 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls60;
            }
            Class<?>[] clsArr21 = new Class[1];
            if (class$org$quartz$impl$matchers$GroupMatcher != null) {
                cls61 = class$org$quartz$impl$matchers$GroupMatcher;
            } else {
                cls61 = class$("org.quartz.impl.matchers.GroupMatcher");
                class$org$quartz$impl$matchers$GroupMatcher = cls61;
            }
            clsArr21[0] = cls61;
            $method_pauseTriggers_38 = cls60.getMethod("pauseTriggers", clsArr21);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls62 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls62 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls62;
            }
            Class<?>[] clsArr22 = new Class[2];
            if (class$org$quartz$TriggerKey != null) {
                cls63 = class$org$quartz$TriggerKey;
            } else {
                cls63 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls63;
            }
            clsArr22[0] = cls63;
            if (class$org$quartz$Trigger != null) {
                cls64 = class$org$quartz$Trigger;
            } else {
                cls64 = class$("org.quartz.Trigger");
                class$org$quartz$Trigger = cls64;
            }
            clsArr22[1] = cls64;
            $method_rescheduleJob_39 = cls62.getMethod("rescheduleJob", clsArr22);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls65 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls65 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls65;
            }
            Class<?>[] clsArr23 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls66 = class$org$quartz$TriggerKey;
            } else {
                cls66 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls66;
            }
            clsArr23[0] = cls66;
            $method_resetTriggerFromErrorState_40 = cls65.getMethod("resetTriggerFromErrorState", clsArr23);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls67 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls67 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls67;
            }
            $method_resumeAll_41 = cls67.getMethod("resumeAll", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls68 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls68 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls68;
            }
            Class<?>[] clsArr24 = new Class[1];
            if (class$org$quartz$JobKey != null) {
                cls69 = class$org$quartz$JobKey;
            } else {
                cls69 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls69;
            }
            clsArr24[0] = cls69;
            $method_resumeJob_42 = cls68.getMethod("resumeJob", clsArr24);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls70 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls70 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls70;
            }
            Class<?>[] clsArr25 = new Class[1];
            if (class$org$quartz$impl$matchers$GroupMatcher != null) {
                cls71 = class$org$quartz$impl$matchers$GroupMatcher;
            } else {
                cls71 = class$("org.quartz.impl.matchers.GroupMatcher");
                class$org$quartz$impl$matchers$GroupMatcher = cls71;
            }
            clsArr25[0] = cls71;
            $method_resumeJobs_43 = cls70.getMethod("resumeJobs", clsArr25);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls72 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls72 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls72;
            }
            Class<?>[] clsArr26 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls73 = class$org$quartz$TriggerKey;
            } else {
                cls73 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls73;
            }
            clsArr26[0] = cls73;
            $method_resumeTrigger_44 = cls72.getMethod("resumeTrigger", clsArr26);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls74 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls74 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls74;
            }
            Class<?>[] clsArr27 = new Class[1];
            if (class$org$quartz$impl$matchers$GroupMatcher != null) {
                cls75 = class$org$quartz$impl$matchers$GroupMatcher;
            } else {
                cls75 = class$("org.quartz.impl.matchers.GroupMatcher");
                class$org$quartz$impl$matchers$GroupMatcher = cls75;
            }
            clsArr27[0] = cls75;
            $method_resumeTriggers_45 = cls74.getMethod("resumeTriggers", clsArr27);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls76 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls76 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls76;
            }
            $method_runningSince_46 = cls76.getMethod("runningSince", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls77 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls77 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls77;
            }
            Class<?>[] clsArr28 = new Class[3];
            if (class$org$quartz$JobDetail != null) {
                cls78 = class$org$quartz$JobDetail;
            } else {
                cls78 = class$("org.quartz.JobDetail");
                class$org$quartz$JobDetail = cls78;
            }
            clsArr28[0] = cls78;
            if (class$java$util$Set != null) {
                cls79 = class$java$util$Set;
            } else {
                cls79 = class$("java.util.Set");
                class$java$util$Set = cls79;
            }
            clsArr28[1] = cls79;
            clsArr28[2] = Boolean.TYPE;
            $method_scheduleJob_47 = cls77.getMethod("scheduleJob", clsArr28);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls80 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls80 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls80;
            }
            Class<?>[] clsArr29 = new Class[2];
            if (class$org$quartz$JobDetail != null) {
                cls81 = class$org$quartz$JobDetail;
            } else {
                cls81 = class$("org.quartz.JobDetail");
                class$org$quartz$JobDetail = cls81;
            }
            clsArr29[0] = cls81;
            if (class$org$quartz$Trigger != null) {
                cls82 = class$org$quartz$Trigger;
            } else {
                cls82 = class$("org.quartz.Trigger");
                class$org$quartz$Trigger = cls82;
            }
            clsArr29[1] = cls82;
            $method_scheduleJob_48 = cls80.getMethod("scheduleJob", clsArr29);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls83 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls83 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls83;
            }
            Class<?>[] clsArr30 = new Class[1];
            if (class$org$quartz$Trigger != null) {
                cls84 = class$org$quartz$Trigger;
            } else {
                cls84 = class$("org.quartz.Trigger");
                class$org$quartz$Trigger = cls84;
            }
            clsArr30[0] = cls84;
            $method_scheduleJob_49 = cls83.getMethod("scheduleJob", clsArr30);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls85 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls85 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls85;
            }
            Class<?>[] clsArr31 = new Class[2];
            if (class$java$util$Map != null) {
                cls86 = class$java$util$Map;
            } else {
                cls86 = class$("java.util.Map");
                class$java$util$Map = cls86;
            }
            clsArr31[0] = cls86;
            clsArr31[1] = Boolean.TYPE;
            $method_scheduleJobs_50 = cls85.getMethod("scheduleJobs", clsArr31);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls87 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls87 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls87;
            }
            $method_shutdown_51 = cls87.getMethod("shutdown", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls88 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls88 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls88;
            }
            $method_shutdown_52 = cls88.getMethod("shutdown", Boolean.TYPE);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls89 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls89 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls89;
            }
            $method_standby_53 = cls89.getMethod("standby", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls90 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls90 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls90;
            }
            $method_start_54 = cls90.getMethod("start", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls91 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls91 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls91;
            }
            $method_startDelayed_55 = cls91.getMethod("startDelayed", Integer.TYPE);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls92 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls92 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls92;
            }
            $method_supportsPersistence_56 = cls92.getMethod("supportsPersistence", new Class[0]);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls93 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls93 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls93;
            }
            Class<?>[] clsArr32 = new Class[2];
            if (class$org$quartz$JobKey != null) {
                cls94 = class$org$quartz$JobKey;
            } else {
                cls94 = class$("org.quartz.JobKey");
                class$org$quartz$JobKey = cls94;
            }
            clsArr32[0] = cls94;
            if (class$org$quartz$JobDataMap != null) {
                cls95 = class$org$quartz$JobDataMap;
            } else {
                cls95 = class$("org.quartz.JobDataMap");
                class$org$quartz$JobDataMap = cls95;
            }
            clsArr32[1] = cls95;
            $method_triggerJob_57 = cls93.getMethod("triggerJob", clsArr32);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls96 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls96 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls96;
            }
            Class<?>[] clsArr33 = new Class[1];
            if (class$org$quartz$spi$OperableTrigger != null) {
                cls97 = class$org$quartz$spi$OperableTrigger;
            } else {
                cls97 = class$("org.quartz.spi.OperableTrigger");
                class$org$quartz$spi$OperableTrigger = cls97;
            }
            clsArr33[0] = cls97;
            $method_triggerJob_58 = cls96.getMethod("triggerJob", clsArr33);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls98 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls98 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls98;
            }
            Class<?>[] clsArr34 = new Class[1];
            if (class$org$quartz$TriggerKey != null) {
                cls99 = class$org$quartz$TriggerKey;
            } else {
                cls99 = class$("org.quartz.TriggerKey");
                class$org$quartz$TriggerKey = cls99;
            }
            clsArr34[0] = cls99;
            $method_unscheduleJob_59 = cls98.getMethod("unscheduleJob", clsArr34);
            if (class$org$quartz$core$RemotableQuartzScheduler != null) {
                cls100 = class$org$quartz$core$RemotableQuartzScheduler;
            } else {
                cls100 = class$("org.quartz.core.RemotableQuartzScheduler");
                class$org$quartz$core$RemotableQuartzScheduler = cls100;
            }
            Class<?>[] clsArr35 = new Class[1];
            if (class$java$util$List != null) {
                cls101 = class$java$util$List;
            } else {
                cls101 = class$("java.util.List");
                class$java$util$List = cls101;
            }
            clsArr35[0] = cls101;
            $method_unscheduleJobs_60 = cls100.getMethod("unscheduleJobs", clsArr35);
        } catch (NoSuchMethodException unused) {
            throw new NoSuchMethodError("stub class initialization failed");
        }
    }

    public QuartzScheduler_Stub(RemoteRef remoteRef) {
        super(remoteRef);
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void addCalendar(String str, Calendar calendar, boolean z, boolean z2) throws RemoteException, SchedulerException {
        try {
            RemoteRef remoteRef = ((RemoteObject) this).ref;
            Method method = $method_addCalendar_0;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = calendar;
            objArr[2] = z ? Boolean.TRUE : Boolean.FALSE;
            objArr[3] = z2 ? Boolean.TRUE : Boolean.FALSE;
            remoteRef.invoke(this, method, objArr, 8855052307177792680L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void addJob(JobDetail jobDetail, boolean z) throws RemoteException, SchedulerException {
        try {
            RemoteRef remoteRef = ((RemoteObject) this).ref;
            Method method = $method_addJob_1;
            Object[] objArr = new Object[2];
            objArr[0] = jobDetail;
            objArr[1] = z ? Boolean.TRUE : Boolean.FALSE;
            remoteRef.invoke(this, method, objArr, -7729650160006632870L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void addJob(JobDetail jobDetail, boolean z, boolean z2) throws RemoteException, SchedulerException {
        try {
            RemoteRef remoteRef = ((RemoteObject) this).ref;
            Method method = $method_addJob_2;
            Object[] objArr = new Object[3];
            objArr[0] = jobDetail;
            objArr[1] = z ? Boolean.TRUE : Boolean.FALSE;
            objArr[2] = z2 ? Boolean.TRUE : Boolean.FALSE;
            remoteRef.invoke(this, method, objArr, 1129496936115180762L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean checkExists(JobKey jobKey) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_checkExists_3, new Object[]{jobKey}, -5409554300431077992L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean checkExists(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_checkExists_4, new Object[]{triggerKey}, 57742068790347073L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void clear() throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_clear_5, (Object[]) null, -7475254351993695499L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean deleteCalendar(String str) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_deleteCalendar_6, new Object[]{str}, 4621799193941576495L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean deleteJob(JobKey jobKey) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_deleteJob_7, new Object[]{jobKey}, -3057293324488607018L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean deleteJobs(List list) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_deleteJobs_8, new Object[]{list}, 7613446947728959209L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Calendar getCalendar(String str) throws RemoteException, SchedulerException {
        try {
            return (Calendar) ((RemoteObject) this).ref.invoke(this, $method_getCalendar_9, new Object[]{str}, 7476199188467217146L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List getCalendarNames() throws RemoteException, SchedulerException {
        try {
            return (List) ((RemoteObject) this).ref.invoke(this, $method_getCalendarNames_10, (Object[]) null, -4042711865985645589L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List getCurrentlyExecutingJobs() throws RemoteException, SchedulerException {
        try {
            return (List) ((RemoteObject) this).ref.invoke(this, $method_getCurrentlyExecutingJobs_11, (Object[]) null, 5767551841304860517L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public JobDetail getJobDetail(JobKey jobKey) throws RemoteException, SchedulerException {
        try {
            return (JobDetail) ((RemoteObject) this).ref.invoke(this, $method_getJobDetail_12, new Object[]{jobKey}, -5890147489272798972L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List getJobGroupNames() throws RemoteException, SchedulerException {
        try {
            return (List) ((RemoteObject) this).ref.invoke(this, $method_getJobGroupNames_13, (Object[]) null, -8455486033245212483L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Set getJobKeys(GroupMatcher groupMatcher) throws RemoteException, SchedulerException {
        try {
            return (Set) ((RemoteObject) this).ref.invoke(this, $method_getJobKeys_14, new Object[]{groupMatcher}, 5516129892023529995L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Class getJobStoreClass() throws RemoteException {
        try {
            return (Class) ((RemoteObject) this).ref.invoke(this, $method_getJobStoreClass_15, (Object[]) null, 6705397913929502666L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Set getPausedTriggerGroups() throws RemoteException, SchedulerException {
        try {
            return (Set) ((RemoteObject) this).ref.invoke(this, $method_getPausedTriggerGroups_16, (Object[]) null, -3055688590637594456L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public SchedulerContext getSchedulerContext() throws RemoteException, SchedulerException {
        try {
            return (SchedulerContext) ((RemoteObject) this).ref.invoke(this, $method_getSchedulerContext_17, (Object[]) null, 2814359591403475563L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public String getSchedulerInstanceId() throws RemoteException {
        try {
            return (String) ((RemoteObject) this).ref.invoke(this, $method_getSchedulerInstanceId_18, (Object[]) null, -2454925768252868567L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public String getSchedulerName() throws RemoteException {
        try {
            return (String) ((RemoteObject) this).ref.invoke(this, $method_getSchedulerName_19, (Object[]) null, 1038196595245667445L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Class getThreadPoolClass() throws RemoteException {
        try {
            return (Class) ((RemoteObject) this).ref.invoke(this, $method_getThreadPoolClass_20, (Object[]) null, -706336661940287388L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public int getThreadPoolSize() throws RemoteException {
        try {
            return ((Integer) ((RemoteObject) this).ref.invoke(this, $method_getThreadPoolSize_21, (Object[]) null, 6528392066641712137L)).intValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Trigger getTrigger(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            return (Trigger) ((RemoteObject) this).ref.invoke(this, $method_getTrigger_22, new Object[]{triggerKey}, -8135458059745415503L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List getTriggerGroupNames() throws RemoteException, SchedulerException {
        try {
            return (List) ((RemoteObject) this).ref.invoke(this, $method_getTriggerGroupNames_23, (Object[]) null, -1425625447055098000L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Set getTriggerKeys(GroupMatcher groupMatcher) throws RemoteException, SchedulerException {
        try {
            return (Set) ((RemoteObject) this).ref.invoke(this, $method_getTriggerKeys_24, new Object[]{groupMatcher}, -833881061725726505L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Trigger.TriggerState getTriggerState(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            return (Trigger.TriggerState) ((RemoteObject) this).ref.invoke(this, $method_getTriggerState_25, new Object[]{triggerKey}, -5299675517853200699L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public List getTriggersOfJob(JobKey jobKey) throws RemoteException, SchedulerException {
        try {
            return (List) ((RemoteObject) this).ref.invoke(this, $method_getTriggersOfJob_26, new Object[]{jobKey}, 4987568461050139134L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public String getVersion() throws RemoteException {
        try {
            return (String) ((RemoteObject) this).ref.invoke(this, $method_getVersion_27, (Object[]) null, -8081107751519807347L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean interrupt(String str) throws RemoteException, UnableToInterruptJobException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_interrupt_28, new Object[]{str}, 256262298724115780L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (UnableToInterruptJobException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean interrupt(JobKey jobKey) throws RemoteException, UnableToInterruptJobException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_interrupt_29, new Object[]{jobKey}, -4185636327079289011L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (UnableToInterruptJobException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean isClustered() throws RemoteException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_isClustered_30, (Object[]) null, 8772462407279794129L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean isInStandbyMode() throws RemoteException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_isInStandbyMode_31, (Object[]) null, 809977841435240287L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean isShutdown() throws RemoteException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_isShutdown_32, (Object[]) null, 6424449119484905518L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public int numJobsExecuted() throws RemoteException {
        try {
            return ((Integer) ((RemoteObject) this).ref.invoke(this, $method_numJobsExecuted_33, (Object[]) null, 3699847707830503805L)).intValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseAll() throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_pauseAll_34, (Object[]) null, 5457255371237476599L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseJob(JobKey jobKey) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_pauseJob_35, new Object[]{jobKey}, 8209397623379863913L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseJobs(GroupMatcher groupMatcher) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_pauseJobs_36, new Object[]{groupMatcher}, 8348393716035813534L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseTrigger(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_pauseTrigger_37, new Object[]{triggerKey}, -1556555911706012384L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void pauseTriggers(GroupMatcher groupMatcher) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_pauseTriggers_38, new Object[]{groupMatcher}, -7673129639132463315L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date rescheduleJob(TriggerKey triggerKey, Trigger trigger) throws RemoteException, SchedulerException {
        try {
            return (Date) ((RemoteObject) this).ref.invoke(this, $method_rescheduleJob_39, new Object[]{triggerKey, trigger}, -6542935860087805349L);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        } catch (SchedulerException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resetTriggerFromErrorState(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_resetTriggerFromErrorState_40, new Object[]{triggerKey}, -8848809227421519492L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeAll() throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_resumeAll_41, (Object[]) null, 6544465639644633234L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeJob(JobKey jobKey) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_resumeJob_42, new Object[]{jobKey}, 85405606979760311L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeJobs(GroupMatcher groupMatcher) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_resumeJobs_43, new Object[]{groupMatcher}, 7080691189565323939L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeTrigger(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_resumeTrigger_44, new Object[]{triggerKey}, 1103652291697918174L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void resumeTriggers(GroupMatcher groupMatcher) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_resumeTriggers_45, new Object[]{groupMatcher}, 316892067472367515L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date runningSince() throws RemoteException {
        try {
            return (Date) ((RemoteObject) this).ref.invoke(this, $method_runningSince_46, (Object[]) null, -1739625058868381113L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void scheduleJob(JobDetail jobDetail, Set set, boolean z) throws RemoteException, SchedulerException {
        try {
            RemoteRef remoteRef = ((RemoteObject) this).ref;
            Method method = $method_scheduleJob_47;
            Object[] objArr = new Object[3];
            objArr[0] = jobDetail;
            objArr[1] = set;
            objArr[2] = z ? Boolean.TRUE : Boolean.FALSE;
            remoteRef.invoke(this, method, objArr, -2860300690822357486L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date scheduleJob(JobDetail jobDetail, Trigger trigger) throws RemoteException, SchedulerException {
        try {
            return (Date) ((RemoteObject) this).ref.invoke(this, $method_scheduleJob_48, new Object[]{jobDetail, trigger}, 4944457543332629245L);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        } catch (SchedulerException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public Date scheduleJob(Trigger trigger) throws RemoteException, SchedulerException {
        try {
            return (Date) ((RemoteObject) this).ref.invoke(this, $method_scheduleJob_49, new Object[]{trigger}, -6865148385642356285L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (SchedulerException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void scheduleJobs(Map map, boolean z) throws RemoteException, SchedulerException {
        try {
            RemoteRef remoteRef = ((RemoteObject) this).ref;
            Method method = $method_scheduleJobs_50;
            Object[] objArr = new Object[2];
            objArr[0] = map;
            objArr[1] = z ? Boolean.TRUE : Boolean.FALSE;
            remoteRef.invoke(this, method, objArr, 2404438458719160003L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void shutdown() throws RemoteException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_shutdown_51, (Object[]) null, -7207851917985848402L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void shutdown(boolean z) throws RemoteException {
        try {
            RemoteRef remoteRef = ((RemoteObject) this).ref;
            Method method = $method_shutdown_52;
            Object[] objArr = new Object[1];
            objArr[0] = z ? Boolean.TRUE : Boolean.FALSE;
            remoteRef.invoke(this, method, objArr, -7158426071079062438L);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void standby() throws RemoteException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_standby_53, (Object[]) null, 7161048918451732526L);
        } catch (RemoteException e) {
            throw e;
        } catch (RuntimeException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void start() throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_start_54, (Object[]) null, -8025343665958530775L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void startDelayed(int i) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_startDelayed_55, new Object[]{new Integer(i)}, -1476976461109028800L);
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean supportsPersistence() throws RemoteException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_supportsPersistence_56, (Object[]) null, -5767630451452602400L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new UnexpectedException("undeclared checked exception", e2);
        } catch (RemoteException e3) {
            throw e3;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void triggerJob(JobKey jobKey, JobDataMap jobDataMap) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_triggerJob_57, new Object[]{jobKey, jobDataMap}, -1585175841511357332L);
        } catch (Exception e) {
            throw new UnexpectedException("undeclared checked exception", e);
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (SchedulerException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public void triggerJob(OperableTrigger operableTrigger) throws RemoteException, SchedulerException {
        try {
            ((RemoteObject) this).ref.invoke(this, $method_triggerJob_58, new Object[]{operableTrigger}, 5598451830209081494L);
        } catch (SchedulerException e) {
            throw e;
        } catch (RemoteException e2) {
            throw e2;
        } catch (RuntimeException e3) {
            throw e3;
        } catch (Exception e4) {
            throw new UnexpectedException("undeclared checked exception", e4);
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean unscheduleJob(TriggerKey triggerKey) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_unscheduleJob_59, new Object[]{triggerKey}, -4592142908438852383L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }

    @Override // org.quartz.core.RemotableQuartzScheduler
    public boolean unscheduleJobs(List list) throws RemoteException, SchedulerException {
        try {
            return ((Boolean) ((RemoteObject) this).ref.invoke(this, $method_unscheduleJobs_60, new Object[]{list}, 1385849655203364760L)).booleanValue();
        } catch (RuntimeException e) {
            throw e;
        } catch (SchedulerException e2) {
            throw e2;
        } catch (Exception e3) {
            throw new UnexpectedException("undeclared checked exception", e3);
        } catch (RemoteException e4) {
            throw e4;
        }
    }
}
