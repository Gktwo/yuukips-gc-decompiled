package com.mongodb.internal.operation;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/OrderBy.class */
public enum OrderBy {
    ASC(1),
    DESC(-1);
    
    private final int intRepresentation;

    OrderBy(int intRepresentation) {
        this.intRepresentation = intRepresentation;
    }

    public int getIntRepresentation() {
        return this.intRepresentation;
    }

    public static OrderBy fromInt(int intRepresentation) {
        switch (intRepresentation) {
            case -1:
                return DESC;
            case 1:
                return ASC;
            default:
                throw new IllegalArgumentException(intRepresentation + " is not a valid index Order");
        }
    }
}
