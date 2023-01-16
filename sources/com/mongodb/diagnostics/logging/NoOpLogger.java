package com.mongodb.diagnostics.logging;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/diagnostics/logging/NoOpLogger.class */
public class NoOpLogger implements Logger {
    private final String name;

    /* access modifiers changed from: package-private */
    public NoOpLogger(String name) {
        this.name = name;
    }

    @Override // com.mongodb.diagnostics.logging.Logger
    public String getName() {
        return this.name;
    }
}
