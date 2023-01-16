package com.mongodb.client.model;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CollationAlternate.class */
public enum CollationAlternate {
    NON_IGNORABLE("non-ignorable"),
    SHIFTED("shifted");
    
    private final String value;

    CollationAlternate(String caseFirst) {
        this.value = caseFirst;
    }

    public String getValue() {
        return this.value;
    }

    public static CollationAlternate fromString(String collationAlternate) {
        if (collationAlternate != null) {
            CollationAlternate[] values = values();
            for (CollationAlternate alternate : values) {
                if (collationAlternate.equals(alternate.value)) {
                    return alternate;
                }
            }
        }
        throw new IllegalArgumentException(String.format("'%s' is not a valid collationAlternate", collationAlternate));
    }
}
