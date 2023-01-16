package org.jline.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/ShutdownHooks.class */
public final class ShutdownHooks {
    private static final List<Task> tasks = new ArrayList();
    private static Thread hook;

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/ShutdownHooks$Task.class */
    public interface Task {
        void run() throws Exception;
    }

    public static synchronized <T extends Task> T add(T task) {
        Objects.requireNonNull(task);
        if (hook == null) {
            hook = addHook(new Thread("JLine Shutdown Hook") { // from class: org.jline.utils.ShutdownHooks.1
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    ShutdownHooks.runTasks();
                }
            });
        }
        Log.debug("Adding shutdown-hook task: ", task);
        tasks.add(task);
        return task;
    }

    /* access modifiers changed from: private */
    public static synchronized void runTasks() {
        Log.debug("Running all shutdown-hook tasks");
        Task[] taskArr = (Task[]) tasks.toArray(new Task[tasks.size()]);
        for (Task task : taskArr) {
            Log.debug("Running task: ", task);
            try {
                task.run();
            } catch (Throwable e) {
                Log.warn("Task failed", e);
            }
        }
        tasks.clear();
    }

    private static Thread addHook(Thread thread) {
        Log.debug("Registering shutdown-hook: ", thread);
        Runtime.getRuntime().addShutdownHook(thread);
        return thread;
    }

    public static synchronized void remove(Task task) {
        Objects.requireNonNull(task);
        if (hook != null) {
            tasks.remove(task);
            if (tasks.isEmpty()) {
                removeHook(hook);
                hook = null;
            }
        }
    }

    private static void removeHook(Thread thread) {
        Log.debug("Removing shutdown-hook: ", thread);
        try {
            Runtime.getRuntime().removeShutdownHook(thread);
        } catch (IllegalStateException e) {
        }
    }
}
