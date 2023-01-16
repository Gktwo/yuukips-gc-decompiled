package net.bytebuddy.dynamic.scaffold;

/* loaded from: grasscutter.jar:net/bytebuddy/dynamic/scaffold/TypeValidation.class */
public enum TypeValidation {
    ENABLED(true),
    DISABLED(false);
    
    private final boolean enabled;

    TypeValidation(boolean enabled) {
        this.enabled = enabled;
    }

    /* renamed from: of */
    public static TypeValidation m206of(boolean enabled) {
        return enabled ? ENABLED : DISABLED;
    }

    public boolean isEnabled() {
        return this.enabled;
    }
}
