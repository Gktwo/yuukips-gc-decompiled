package com.mchange.p009v2.cfg;

import com.mchange.p009v2.lang.ObjectUtils;

/* renamed from: com.mchange.v2.cfg.DelayedLogItem */
/* loaded from: grasscutter.jar:com/mchange/v2/cfg/DelayedLogItem.class */
public final class DelayedLogItem {
    private Level level;
    private String text;
    private Throwable exception;

    /* renamed from: com.mchange.v2.cfg.DelayedLogItem$Level */
    /* loaded from: grasscutter.jar:com/mchange/v2/cfg/DelayedLogItem$Level.class */
    public enum Level {
        ALL,
        CONFIG,
        FINE,
        FINER,
        FINEST,
        INFO,
        OFF,
        SEVERE,
        WARNING
    }

    public Level getLevel() {
        return this.level;
    }

    public String getText() {
        return this.text;
    }

    public Throwable getException() {
        return this.exception;
    }

    public DelayedLogItem(Level level, String str, Throwable th) {
        this.level = level;
        this.text = str;
        this.exception = th;
    }

    public DelayedLogItem(Level level, String str) {
        this(level, str, null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DelayedLogItem)) {
            return false;
        }
        DelayedLogItem delayedLogItem = (DelayedLogItem) obj;
        return this.level.equals(delayedLogItem.level) && this.text.equals(delayedLogItem.text) && ObjectUtils.eqOrBothNull(this.exception, delayedLogItem.exception);
    }

    public int hashCode() {
        return (this.level.hashCode() ^ this.text.hashCode()) ^ ObjectUtils.hashOrZero(this.exception);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(String.format(" [ level -> %s, text -> \"%s\", exception -> %s]", this.level, this.text, this.exception));
        return stringBuffer.toString();
    }
}
