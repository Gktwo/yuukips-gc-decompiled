package emu.grasscutter.task;

import emu.grasscutter.Grasscutter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobKey;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/* loaded from: grasscutter.jar:emu/grasscutter/task/TaskMap.class */
public final class TaskMap {
    private final Map<String, TaskHandler> tasks;
    private final Map<String, Task> annotations;
    private final Map<String, TaskHandler> afterReset;
    private final SchedulerFactory schedulerFactory;

    public TaskMap() {
        this(false);
    }

    public TaskMap(boolean scan) {
        this.tasks = new HashMap();
        this.annotations = new HashMap();
        this.afterReset = new HashMap();
        this.schedulerFactory = new StdSchedulerFactory();
        if (scan) {
            scan();
        }
    }

    public static TaskMap getInstance() {
        return Grasscutter.getGameServer().getTaskMap();
    }

    public void resetNow() {
        for (TaskHandler task : this.tasks.values()) {
            unregisterTask(task);
        }
        for (TaskHandler task2 : this.afterReset.values()) {
            try {
                task2.restartExecute();
            } catch (Exception e) {
                Grasscutter.getLogger().error("restartExecute error:", (Throwable) e);
            }
        }
        this.afterReset.clear();
        for (TaskHandler task3 : this.tasks.values()) {
            registerTask(((Task) task3.getClass().getAnnotation(Task.class)).taskName(), task3);
        }
    }

    public TaskMap unregisterTask(TaskHandler task) {
        this.tasks.remove(((Task) task.getClass().getAnnotation(Task.class)).taskName());
        this.annotations.remove(((Task) task.getClass().getAnnotation(Task.class)).taskName());
        try {
            this.schedulerFactory.getScheduler().deleteJob(new JobKey(((Task) task.getClass().getAnnotation(Task.class)).taskName()));
        } catch (SchedulerException e) {
            Grasscutter.getLogger().error("unregisterTask error:", (Throwable) e);
        }
        task.onDisable();
        return this;
    }

    public boolean pauseTask(String taskName) {
        try {
            this.schedulerFactory.getScheduler().pauseJob(new JobKey(taskName));
            return true;
        } catch (SchedulerException e) {
            Grasscutter.getLogger().error("pauseTask error:", (Throwable) e);
            return false;
        }
    }

    public boolean resumeTask(String taskName) {
        try {
            this.schedulerFactory.getScheduler().resumeJob(new JobKey(taskName));
            return true;
        } catch (SchedulerException e) {
            Grasscutter.getLogger().error("resumeTask error:", (Throwable) e);
            return false;
        }
    }

    public boolean cancelTask(String taskName) {
        if (this.annotations.get(taskName) == null) {
            return false;
        }
        try {
            unregisterTask(this.tasks.get(taskName));
            return true;
        } catch (Exception e) {
            Grasscutter.getLogger().error("cancelTask error:", (Throwable) e);
            return false;
        }
    }

    public TaskMap registerTask(String taskName, TaskHandler task) {
        Task annotation = (Task) task.getClass().getAnnotation(Task.class);
        this.annotations.put(taskName, annotation);
        this.tasks.put(taskName, task);
        try {
            this.schedulerFactory.getScheduler().scheduleJob(JobBuilder.newJob(task.getClass()).withIdentity(taskName).build(), TriggerBuilder.newTrigger().withIdentity(annotation.triggerName()).withSchedule(CronScheduleBuilder.cronSchedule(annotation.taskCronExpression())).build());
            if (annotation.executeImmediately()) {
                task.execute(null);
            }
            task.onEnable();
        } catch (SchedulerException e) {
            Grasscutter.getLogger().error("registerTask error:", (Throwable) e);
        }
        return this;
    }

    public List<TaskHandler> getHandlersAsList() {
        return new ArrayList(this.tasks.values());
    }

    public HashMap<String, TaskHandler> getHandlers() {
        return new LinkedHashMap(this.tasks);
    }

    public TaskHandler getHandler(String taskName) {
        return this.tasks.get(taskName);
    }

    private void scan() {
        Grasscutter.reflector.getTypesAnnotatedWith(Task.class).forEach(
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0012: INVOKE  
              (wrap: java.util.Set<java.lang.Class<?>> : 0x0007: INVOKE  (r0v2 'classes' java.util.Set<java.lang.Class<?>> A[REMOVE]) = 
              (wrap: org.reflections.Reflections : 0x0000: SGET  (r0v0 'reflector' org.reflections.Reflections A[REMOVE]) =  emu.grasscutter.Grasscutter.reflector org.reflections.Reflections)
              (wrap: java.lang.Class<? extends java.lang.annotation.Annotation> : 0x0005: CONST_CLASS   emu.grasscutter.task.Task.class)
             type: VIRTUAL call: org.reflections.Reflections.getTypesAnnotatedWith(java.lang.Class):java.util.Set)
              (wrap: java.util.function.Consumer : 0x000d: INVOKE_CUSTOM (r1v2 java.util.function.Consumer A[REMOVE]) = (r4v0 'this' emu.grasscutter.task.TaskMap A[D('this' emu.grasscutter.task.TaskMap), DONT_INLINE, IMMUTABLE_TYPE, THIS])
             handle type: INVOKE_INSTANCE
             lambda: java.util.function.Consumer.accept(java.lang.Object):void
             call insn: ?: INVOKE  (r1 I:emu.grasscutter.task.TaskMap), (v1 java.lang.Class) type: VIRTUAL call: emu.grasscutter.task.TaskMap.lambda$scan$0(java.lang.Class):void)
             type: INTERFACE call: java.util.Set.forEach(java.util.function.Consumer):void in method: emu.grasscutter.task.TaskMap.scan():void, file: grasscutter.jar:emu/grasscutter/task/TaskMap.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            org.reflections.Reflections r0 = emu.grasscutter.Grasscutter.reflector
            r5 = r0
            r0 = r5
            java.lang.Class<emu.grasscutter.task.Task> r1 = emu.grasscutter.task.Task.class
            java.util.Set r0 = r0.getTypesAnnotatedWith(r1)
            r6 = r0
            r0 = r6
            r1 = r4
            void r1 = (v1) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$scan$0(v1);
            }
            r0.forEach(r1)
            r0 = r4
            org.quartz.SchedulerFactory r0 = r0.schedulerFactory     // Catch: SchedulerException -> 0x002a
            org.quartz.Scheduler r0 = r0.getScheduler()     // Catch: SchedulerException -> 0x002a
            r7 = r0
            r0 = r7
            r0.start()     // Catch: SchedulerException -> 0x002a
            goto L_0x0034
        L_0x002a:
            r7 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "scan error:"
            r2 = r7
            r0.error(r1, r2)
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.task.TaskMap.scan():void");
    }
}
