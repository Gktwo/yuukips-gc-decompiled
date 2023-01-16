package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.util.JacksonFeature;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/FormatFeature.class */
public interface FormatFeature extends JacksonFeature {
    @Override // com.fasterxml.jackson.core.util.JacksonFeature
    boolean enabledByDefault();

    @Override // com.fasterxml.jackson.core.util.JacksonFeature
    int getMask();

    @Override // com.fasterxml.jackson.core.util.JacksonFeature
    boolean enabledIn(int i);
}
