package dev.morphia.utils;

/* loaded from: grasscutter.jar:dev/morphia/utils/IndexDirection.class */
public enum IndexDirection {
    ASC(1),
    DESC(-1),
    GEO2D("2d"),
    GEO2DSPHERE("2dsphere");
    
    private final Object direction;

    IndexDirection(Object o) {
        this.direction = o;
    }

    public Object toIndexValue() {
        return this.direction;
    }
}
