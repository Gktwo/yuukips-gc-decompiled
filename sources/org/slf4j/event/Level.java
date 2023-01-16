package org.slf4j.event;

import org.quartz.impl.jdbcjobstore.Constants;

/* loaded from: grasscutter.jar:org/slf4j/event/Level.class */
public enum Level {
    ERROR(40, Constants.STATE_ERROR),
    WARN(30, "WARN"),
    INFO(20, "INFO"),
    DEBUG(10, "DEBUG"),
    TRACE(0, "TRACE");
    
    private int levelInt;
    private String levelStr;

    Level(int i, String s) {
        this.levelInt = i;
        this.levelStr = s;
    }

    public int toInt() {
        return this.levelInt;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return this.levelStr;
    }
}
