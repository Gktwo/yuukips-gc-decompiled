package com.mongodb.internal.connection;

import com.mongodb.assertions.Assertions;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/ChangeEvent.class */
final class ChangeEvent<T> {
    private final T previousValue;
    private final T newValue;

    /* access modifiers changed from: package-private */
    public ChangeEvent(T previousValue, T newValue) {
        this.previousValue = (T) Assertions.notNull("oldValue", previousValue);
        this.newValue = (T) Assertions.notNull("newValue", newValue);
    }

    public T getPreviousValue() {
        return this.previousValue;
    }

    public T getNewValue() {
        return this.newValue;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChangeEvent<?> that = (ChangeEvent) o;
        if (!this.newValue.equals(that.newValue)) {
            return false;
        }
        if (this.previousValue != null) {
            if (!this.previousValue.equals(that.previousValue)) {
                return false;
            }
            return true;
        } else if (that.previousValue != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * (this.previousValue != null ? this.previousValue.hashCode() : 0)) + this.newValue.hashCode();
    }

    public String toString() {
        return "ChangeEvent{previousValue=" + this.previousValue + ", newValue=" + this.newValue + '}';
    }
}
