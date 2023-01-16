package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/MultiPoint.class */
public final class MultiPoint extends Geometry {
    private final List<Position> coordinates;

    public MultiPoint(List<Position> coordinates) {
        this(null, coordinates);
    }

    public MultiPoint(@Nullable CoordinateReferenceSystem coordinateReferenceSystem, List<Position> coordinates) {
        super(coordinateReferenceSystem);
        Assertions.notNull("coordinates", coordinates);
        Assertions.isTrueArgument("coordinates contains only non-null positions", !coordinates.contains(null));
        this.coordinates = Collections.unmodifiableList(coordinates);
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public GeoJsonObjectType getType() {
        return GeoJsonObjectType.MULTI_POINT;
    }

    public List<Position> getCoordinates() {
        return this.coordinates;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !equals(o) || !this.coordinates.equals(((MultiPoint) o).coordinates)) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public int hashCode() {
        return (31 * hashCode()) + this.coordinates.hashCode();
    }

    public String toString() {
        return "MultiPoint{coordinates=" + this.coordinates + (getCoordinateReferenceSystem() == null ? "" : ", coordinateReferenceSystem=" + getCoordinateReferenceSystem()) + '}';
    }
}
