package emu.grasscutter.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceType.class */
public @interface ResourceType {
    String[] name();

    LoadPriority loadPriority() default LoadPriority.NORMAL;

    /* loaded from: grasscutter.jar:emu/grasscutter/data/ResourceType$LoadPriority.class */
    public enum LoadPriority {
        HIGHEST(4),
        HIGH(3),
        NORMAL(2),
        LOW(1),
        LOWEST(0);
        
        private final int value;

        LoadPriority(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }
}
