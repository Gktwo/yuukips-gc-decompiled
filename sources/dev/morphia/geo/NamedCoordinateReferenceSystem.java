package dev.morphia.geo;

import com.mongodb.client.model.geojson.CoordinateReferenceSystem;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/NamedCoordinateReferenceSystem.class */
public final class NamedCoordinateReferenceSystem extends CoordinateReferenceSystem {
    public static final NamedCoordinateReferenceSystem EPSG_4326 = new NamedCoordinateReferenceSystem("EPSG:4326");
    public static final NamedCoordinateReferenceSystem CRS_84 = new NamedCoordinateReferenceSystem("urn:ogc:def:crs:OGC:1.3:CRS84");
    public static final NamedCoordinateReferenceSystem EPSG_4326_STRICT_WINDING = new NamedCoordinateReferenceSystem("urn:x-mongodb:crs:strictwinding:EPSG:4326");
    private final String name;

    private NamedCoordinateReferenceSystem(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override // dev.morphia.geo.CoordinateReferenceSystem
    public CoordinateReferenceSystemType getType() {
        return CoordinateReferenceSystemType.NAME;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return this.name.equals(((NamedCoordinateReferenceSystem) o).name);
    }

    public String toString() {
        return String.format("NamedCoordinateReferenceSystem{name='%s'}", this.name);
    }

    @Override // dev.morphia.geo.CoordinateReferenceSystem
    public CoordinateReferenceSystem convert() {
        return new com.mongodb.client.model.geojson.NamedCoordinateReferenceSystem(this.name);
    }
}
