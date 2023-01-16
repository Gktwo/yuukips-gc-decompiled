package dev.morphia.geo;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/CoordinateReferenceSystemType.class */
public enum CoordinateReferenceSystemType {
    NAME("name"),
    LINK("link");
    
    private final String typeName;

    CoordinateReferenceSystemType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return this.typeName;
    }
}
