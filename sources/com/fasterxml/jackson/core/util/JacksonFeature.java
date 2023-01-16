package com.fasterxml.jackson.core.util;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/util/JacksonFeature.class */
public interface JacksonFeature {
    boolean enabledByDefault();

    int getMask();

    boolean enabledIn(int i);
}
