package dev.morphia.geo;

import java.util.List;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/GeoJsonType.class */
public enum GeoJsonType implements GeometryFactory {
    POINT("Point", Point.class) {
        @Override // dev.morphia.geo.GeometryFactory
        public Geometry createGeometry(List coordinates) {
            return new Point(coordinates);
        }
    },
    LINE_STRING("LineString", LineString.class) {
        @Override // dev.morphia.geo.GeometryFactory
        public Geometry createGeometry(List objects) {
            return new LineString(objects);
        }
    },
    POLYGON("Polygon", Polygon.class) {
        @Override // dev.morphia.geo.GeometryFactory
        public Geometry createGeometry(List boundaries) {
            return new Polygon(boundaries);
        }
    },
    MULTI_POINT("MultiPoint", MultiPoint.class) {
        @Override // dev.morphia.geo.GeometryFactory
        public Geometry createGeometry(List points) {
            return new MultiPoint(points);
        }
    },
    MULTI_LINE_STRING("MultiLineString", MultiLineString.class) {
        @Override // dev.morphia.geo.GeometryFactory
        public Geometry createGeometry(List lineStrings) {
            return new MultiLineString(lineStrings);
        }
    },
    MULTI_POLYGON("MultiPolygon", MultiPolygon.class) {
        @Override // dev.morphia.geo.GeometryFactory
        public Geometry createGeometry(List polygons) {
            return new MultiPolygon(polygons);
        }
    };
    
    private final String type;
    private final Class<? extends Geometry> typeClass;

    GeoJsonType(String type, Class cls) {
        this.type = type;
        this.typeClass = cls;
    }
}
