package dev.morphia.geo;

import java.util.List;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/Geometry.class */
public interface Geometry {
    List<?> getCoordinates();

    com.mongodb.client.model.geojson.Geometry convert();

    com.mongodb.client.model.geojson.Geometry convert(CoordinateReferenceSystem coordinateReferenceSystem);
}
