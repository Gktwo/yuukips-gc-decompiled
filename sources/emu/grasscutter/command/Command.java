package emu.grasscutter.command;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/command/Command.class */
public @interface Command {

    /* loaded from: grasscutter.jar:emu/grasscutter/command/Command$TargetRequirement.class */
    public enum TargetRequirement {
        NONE,
        OFFLINE,
        PLAYER,
        ONLINE
    }

    String label() default "";

    String[] aliases() default {};

    String[] usage() default {""};

    String permission() default "";

    String permissionTargeted() default "";

    TargetRequirement targetRequirement() default TargetRequirement.ONLINE;

    boolean threading() default true;

    int ratelimit() default 3;

    int count() default 1;
}
