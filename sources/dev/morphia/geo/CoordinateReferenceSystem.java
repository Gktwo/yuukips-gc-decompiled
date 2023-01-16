package dev.morphia.geo;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/CoordinateReferenceSystem.class */
public abstract class CoordinateReferenceSystem {
    public abstract CoordinateReferenceSystemType getType();

    public abstract com.mongodb.client.model.geojson.CoordinateReferenceSystem convert();
}
