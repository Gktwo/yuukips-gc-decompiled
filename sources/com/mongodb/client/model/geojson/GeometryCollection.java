package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/GeometryCollection.class */
public final class GeometryCollection extends Geometry {
    private final List<? extends Geometry> geometries;

    public GeometryCollection(List<? extends Geometry> geometries) {
        this(null, geometries);
    }

    public GeometryCollection(@Nullable CoordinateReferenceSystem coordinateReferenceSystem, List<? extends Geometry> geometries) {
        super(coordinateReferenceSystem);
        Assertions.notNull("geometries", geometries);
        Assertions.doesNotContainNull("geometries", geometries);
        this.geometries = Collections.unmodifiableList(geometries);
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public GeoJsonObjectType getType() {
        return GeoJsonObjectType.GEOMETRY_COLLECTION;
    }

    public List<? extends Geometry> getGeometries() {
        return this.geometries;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !equals(o) || !this.geometries.equals(((GeometryCollection) o).geometries)) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public int hashCode() {
        return (31 * hashCode()) + this.geometries.hashCode();
    }

    public String toString() {
        CoordinateReferenceSystem coordinateReferenceSystem = getCoordinateReferenceSystem();
        return "GeometryCollection{geometries=" + this.geometries + (coordinateReferenceSystem == null ? "" : ", coordinateReferenceSystem=" + coordinateReferenceSystem) + '}';
    }
}
