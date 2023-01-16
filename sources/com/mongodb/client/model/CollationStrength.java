package com.mongodb.client.model;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CollationStrength.class */
public enum CollationStrength {
    PRIMARY(1),
    SECONDARY(2),
    TERTIARY(3),
    QUATERNARY(4),
    IDENTICAL(5);
    
    private final int intRepresentation;

    CollationStrength(int intRepresentation) {
        this.intRepresentation = intRepresentation;
    }

    public int getIntRepresentation() {
        return this.intRepresentation;
    }

    public static CollationStrength fromInt(int intRepresentation) {
        switch (intRepresentation) {
            case 1:
                return PRIMARY;
            case 2:
                return SECONDARY;
            case 3:
                return TERTIARY;
            case 4:
                return QUATERNARY;
            case 5:
                return IDENTICAL;
            default:
                throw new IllegalArgumentException(intRepresentation + " is not a valid collation strength");
        }
    }
}
