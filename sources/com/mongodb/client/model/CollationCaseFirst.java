package com.mongodb.client.model;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CollationCaseFirst.class */
public enum CollationCaseFirst {
    UPPER("upper"),
    LOWER("lower"),
    OFF("off");
    
    private final String value;

    CollationCaseFirst(String caseFirst) {
        this.value = caseFirst;
    }

    public String getValue() {
        return this.value;
    }

    public static CollationCaseFirst fromString(String collationCaseFirst) {
        if (collationCaseFirst != null) {
            CollationCaseFirst[] values = values();
            for (CollationCaseFirst caseFirst : values) {
                if (collationCaseFirst.equals(caseFirst.value)) {
                    return caseFirst;
                }
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is not a valid collationCaseFirst", collationCaseFirst));
    }
}
