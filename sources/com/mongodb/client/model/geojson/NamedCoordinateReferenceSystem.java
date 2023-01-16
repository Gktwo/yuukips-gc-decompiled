package com.mongodb.client.model.geojson;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/NamedCoordinateReferenceSystem.class */
public final class NamedCoordinateReferenceSystem extends CoordinateReferenceSystem {
    public static final NamedCoordinateReferenceSystem EPSG_4326 = new NamedCoordinateReferenceSystem("EPSG:4326");
    public static final NamedCoordinateReferenceSystem CRS_84 = new NamedCoordinateReferenceSystem("urn:ogc:def:crs:OGC:1.3:CRS84");
    public static final NamedCoordinateReferenceSystem EPSG_4326_STRICT_WINDING = new NamedCoordinateReferenceSystem("urn:x-mongodb:crs:strictwinding:EPSG:4326");
    private final String name;

    public NamedCoordinateReferenceSystem(String name) {
        this.name = (String) Assertions.notNull("name", name);
    }

    @Override // com.mongodb.client.model.geojson.CoordinateReferenceSystem
    public CoordinateReferenceSystemType getType() {
        return CoordinateReferenceSystemType.NAME;
    }

    public String getName() {
        return this.name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.name.equals(((NamedCoordinateReferenceSystem) o).name)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        return "NamedCoordinateReferenceSystem{name='" + this.name + "'}";
    }
}
