package p001ch.qos.logback.classic.turbo;

import p001ch.qos.logback.classic.Level;

/* renamed from: ch.qos.logback.classic.turbo.MDCValueLevelPair */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/MDCValueLevelPair.class */
public class MDCValueLevelPair {
    private String value;
    private Level level;

    public String getValue() {
        return this.value;
    }

    public void setValue(String name) {
        this.value = name;
    }

    public Level getLevel() {
        return this.level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
