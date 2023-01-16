package net.bytebuddy.implementation.attribute;

/* loaded from: grasscutter.jar:net/bytebuddy/implementation/attribute/AnnotationRetention.class */
public enum AnnotationRetention {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean enabled;

    AnnotationRetention(boolean enabled) {
        this.enabled = enabled;
    }

    /* renamed from: of */
    public static AnnotationRetention m139of(boolean enabled) {
        return enabled ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
