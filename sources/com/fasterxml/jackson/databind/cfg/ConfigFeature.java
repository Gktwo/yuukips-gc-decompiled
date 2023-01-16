package com.fasterxml.jackson.databind.cfg;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/cfg/ConfigFeature.class */
public interface ConfigFeature {
    boolean enabledByDefault();

    int getMask();

    boolean enabledIn(int i);
}
