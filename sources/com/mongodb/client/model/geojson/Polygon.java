package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/Polygon.class */
public final class Polygon extends Geometry {
    private final PolygonCoordinates coordinates;

    @SafeVarargs
    public Polygon(List<Position> exterior, List<Position>... holes) {
        this(new PolygonCoordinates(exterior, holes));
    }

    public Polygon(PolygonCoordinates coordinates) {
        this((CoordinateReferenceSystem) null, coordinates);
    }

    public Polygon(@Nullable CoordinateReferenceSystem coordinateReferenceSystem, PolygonCoordinates coordinates) {
        super(coordinateReferenceSystem);
        this.coordinates = (PolygonCoordinates) Assertions.notNull("coordinates", coordinates);
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public GeoJsonObjectType getType() {
        return GeoJsonObjectType.POLYGON;
    }

    public PolygonCoordinates getCoordinates() {
        return this.coordinates;
    }

    public List<Position> getExterior() {
        return this.coordinates.getExterior();
    }

    public List<List<Position>> getHoles() {
        return this.coordinates.getHoles();
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !equals(o) || !this.coordinates.equals(((Polygon) o).coordinates)) {
            return false;
        }
        return true;
    }

    @Override // com.mongodb.client.model.geojson.Geometry
    public int hashCode() {
        return (31 * hashCode()) + this.coordinates.hashCode();
    }

    public String toString() {
        return "Polygon{exterior=" + this.coordinates.getExterior() + (this.coordinates.getHoles().isEmpty() ? "" : ", holes=" + this.coordinates.getHoles()) + (getCoordinateReferenceSystem() == null ? "" : ", coordinateReferenceSystem=" + getCoordinateReferenceSystem()) + '}';
    }
}
