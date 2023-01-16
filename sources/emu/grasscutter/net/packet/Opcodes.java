package emu.grasscutter.net.packet;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/net/packet/Opcodes.class */
public @interface Opcodes {
    int value();

    boolean disabled() default false;
}
