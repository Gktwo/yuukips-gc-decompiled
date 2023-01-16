package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/MultiPolygon.class */
public final class MultiPolygon extends Geometry {
    private final List<PolygonCoordinates> coordinates;

    public MultiPolygon(List<PolygonCoordinates> coordinates) {
        this(null, coordinates);
    }

    public MultiPolygon(@Nullable CoordinateReferenceSystem coordinateReferenceSystem, List<PolygonCoordinates> coordinates) {
        super(coordinateReferenceSystem);
        Assertions.notNull("coordinates", coordinates);
        Assertions.doesNotContainNull("coordinates", coordinates);
        this.coordinates = Collections.unmodifiableList(coordinates);
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public GeoJsonObjectType getType() {
        return GeoJsonObjectType.MULTI_POLYGON;
    }

    public List<PolygonCoordinates> getCoordinates() {
        return this.coordinates;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !equals(o) || !this.coordinates.equals(((MultiPolygon) o).coordinates)) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public int hashCode() {
        return (31 * hashCode()) + this.coordinates.hashCode();
    }

    public String toString() {
        return "MultiPolygon{coordinates=" + this.coordinates + (getCoordinateReferenceSystem() == null ? "" : ", coordinateReferenceSystem=" + getCoordinateReferenceSystem()) + '}';
    }
}
