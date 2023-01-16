package org.slf4j.impl;

import org.slf4j.spi.MDCAdapter;
import p001ch.qos.logback.classic.util.LogbackMDCAdapter;

/* loaded from: grasscutter.jar:org/slf4j/impl/StaticMDCBinder.class */
public class StaticMDCBinder {
    public static final StaticMDCBinder SINGLETON = new StaticMDCBinder();

    private StaticMDCBinder() {
    }

    public MDCAdapter getMDCA() {
        return new LogbackMDCAdapter();
    }

    public String getMDCAdapterClassStr() {
        return LogbackMDCAdapter.class.getName();
    }
}
