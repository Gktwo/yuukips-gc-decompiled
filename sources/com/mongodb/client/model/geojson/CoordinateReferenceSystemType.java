package com.mongodb.client.model.geojson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/CoordinateReferenceSystemType.class */
public enum CoordinateReferenceSystemType {
    NAME("name"),
    LINK("link");
    
    private final String typeName;

    public String getTypeName() {
        return this.typeName;
    }

    CoordinateReferenceSystemType(String typeName) {
        this.typeName = typeName;
    }
}
