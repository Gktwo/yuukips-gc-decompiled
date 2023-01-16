package com.mongodb.internal.connection;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ChangeListener.class */
public interface ChangeListener<T> {
    void stateChanged(ChangeEvent<T> changeEvent);
}
