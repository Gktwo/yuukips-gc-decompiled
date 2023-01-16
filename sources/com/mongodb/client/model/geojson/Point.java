package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/Point.class */
public final class Point extends Geometry {
    private final Position coordinate;

    public Point(Position coordinate) {
        this(null, coordinate);
    }

    public Point(@Nullable CoordinateReferenceSystem coordinateReferenceSystem, Position coordinate) {
        super(coordinateReferenceSystem);
        this.coordinate = (Position) Assertions.notNull("coordinates", coordinate);
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public GeoJsonObjectType getType() {
        return GeoJsonObjectType.POINT;
    }

    public Position getCoordinates() {
        return this.coordinate;
    }

    public Position getPosition() {
        return this.coordinate;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !equals(o) || !this.coordinate.equals(((Point) o).coordinate)) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public int hashCode() {
        return (31 * hashCode()) + this.coordinate.hashCode();
    }

    public String toString() {
        return "Point{coordinate=" + this.coordinate + (getCoordinateReferenceSystem() == null ? "" : ", coordinateReferenceSystem=" + getCoordinateReferenceSystem()) + '}';
    }
}
