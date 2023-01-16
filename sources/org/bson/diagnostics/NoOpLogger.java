package org.bson.diagnostics;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/diagnostics/NoOpLogger.class */
public class NoOpLogger implements Logger {
    private final String name;

    /* access modifiers changed from: package-private */
    public NoOpLogger(String name) {
        this.name = name;
    }

    @Override // org.bson.diagnostics.Logger
    public String getName() {
        return this.name;
    }
}
