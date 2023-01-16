package com.mongodb.client.model;

import p001ch.qos.logback.core.pattern.parser.Parser;

/* loaded from: grasscutter.jar:com/mongodb/client/model/MapReduceAction.class */
public enum MapReduceAction {
    REPLACE(Parser.REPLACE_CONVERTER_WORD),
    MERGE("merge"),
    REDUCE("reduce");
    
    private final String value;

    MapReduceAction(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
