package com.mongodb.client.model.changestream;

import p001ch.qos.logback.core.pattern.parser.Parser;

/* loaded from: grasscutter.jar:com/mongodb/client/model/changestream/OperationType.class */
public enum OperationType {
    INSERT("insert"),
    UPDATE("update"),
    REPLACE(Parser.REPLACE_CONVERTER_WORD),
    DELETE("delete"),
    INVALIDATE("invalidate"),
    DROP("drop"),
    DROP_DATABASE("dropDatabase"),
    RENAME("rename"),
    OTHER("other");
    
    private final String value;

    OperationType(String operationTypeName) {
        this.value = operationTypeName;
    }

    public String getValue() {
        return this.value;
    }

    public static OperationType fromString(String operationTypeName) {
        if (operationTypeName != null) {
            OperationType[] values = values();
            for (OperationType operationType : values) {
                if (operationTypeName.equals(operationType.value)) {
                    return operationType;
                }
            }
        }
        return OTHER;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "OperationType{value='" + this.value + "'}";
    }
}
