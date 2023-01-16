package emu.grasscutter.task;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/task/Task.class */
public @interface Task {
    String taskName() default "NO_NAME";

    String taskCronExpression() default "0 0 0 0 0 ?";

    String triggerName() default "NO_NAME";

    boolean executeImmediatelyAfterReset() default false;

    boolean executeImmediately() default false;
}
