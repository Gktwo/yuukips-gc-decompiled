package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/LineString.class */
public final class LineString extends Geometry {
    private final List<Position> coordinates;

    public LineString(List<Position> coordinates) {
        this(null, coordinates);
    }

    public LineString(@Nullable CoordinateReferenceSystem coordinateReferenceSystem, List<Position> coordinates) {
        super(coordinateReferenceSystem);
        Assertions.notNull("coordinates", coordinates);
        Assertions.isTrueArgument("coordinates must contain at least two positions", coordinates.size() >= 2);
        Assertions.doesNotContainNull("coordinates", coordinates);
        this.coordinates = Collections.unmodifiableList(coordinates);
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public GeoJsonObjectType getType() {
        return GeoJsonObjectType.LINE_STRING;
    }

    public List<Position> getCoordinates() {
        return this.coordinates;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !equals(o) || !this.coordinates.equals(((LineString) o).coordinates)) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public int hashCode() {
        return (31 * hashCode()) + this.coordinates.hashCode();
    }

    public String toString() {
        return "LineString{coordinates=" + this.coordinates + (getCoordinateReferenceSystem() == null ? "" : ", coordinateReferenceSystem=" + getCoordinateReferenceSystem()) + '}';
    }
}
