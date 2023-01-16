package com.mongodb.client.model.geojson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/GeoJsonObjectType.class */
public enum GeoJsonObjectType {
    GEOMETRY_COLLECTION("GeometryCollection"),
    LINE_STRING("LineString"),
    MULTI_LINE_STRING("MultiLineString"),
    MULTI_POINT("MultiPoint"),
    MULTI_POLYGON("MultiPolygon"),
    POINT("Point"),
    POLYGON("Polygon");
    
    private final String typeName;

    public String getTypeName() {
        return this.typeName;
    }

    GeoJsonObjectType(String typeName) {
        this.typeName = typeName;
    }
}
