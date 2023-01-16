package com.mongodb.client.model;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CollationMaxVariable.class */
public enum CollationMaxVariable {
    PUNCT("punct"),
    SPACE("space");
    
    private final String value;

    CollationMaxVariable(String caseFirst) {
        this.value = caseFirst;
    }

    public String getValue() {
        return this.value;
    }

    public static CollationMaxVariable fromString(String collationMaxVariable) {
        if (collationMaxVariable != null) {
            CollationMaxVariable[] values = values();
            for (CollationMaxVariable maxVariable : values) {
                if (collationMaxVariable.equals(maxVariable.value)) {
                    return maxVariable;
                }
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is not a valid collationMaxVariable", collationMaxVariable));
    }
}
