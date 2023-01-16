package dev.morphia.geo;

import com.mongodb.client.model.geojson.Position;
import java.util.ArrayList;
import java.util.List;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/GeoJson.class */
public final class GeoJson {
    private GeoJson() {
    }

    public static Polygon polygon(Point... points) {
        LineString exteriorBoundary = lineString(points);
        ensurePolygonIsClosed(exteriorBoundary);
        return new Polygon(exteriorBoundary, new LineString[0]);
    }

    public static LineString lineString(Point... points) {
        return new LineString(points);
    }

    private static void ensurePolygonIsClosed(LineString points) {
        int size = points.getCoordinates().size();
        if (size > 0 && !points.getCoordinates().get(0).equals(points.getCoordinates().get(size - 1))) {
            throw new IllegalArgumentException("A polygon requires the starting point to be the same as the end to ensure a closed area");
        }
    }

    public static Polygon polygon(LineString exteriorBoundary, LineString... interiorBoundaries) {
        ensurePolygonIsClosed(exteriorBoundary);
        for (LineString boundary : interiorBoundaries) {
            ensurePolygonIsClosed(boundary);
        }
        return new Polygon(exteriorBoundary, interiorBoundaries);
    }

    public static MultiPoint multiPoint(Point... points) {
        return new MultiPoint(points);
    }

    public static MultiLineString multiLineString(LineString... lines) {
        return new MultiLineString(lines);
    }

    public static MultiPolygon multiPolygon(Polygon... polygons) {
        return new MultiPolygon(polygons);
    }

    public static GeometryCollection geometryCollection(Geometry... geometries) {
        return new GeometryCollection(geometries);
    }

    public static List<Position> convertPoints(List<Point> values) {
        ArrayList<Position> positions = new ArrayList<>();
        for (Point point : values) {
            positions.add(new Position(point.getLongitude(), point.getLatitude(), new double[0]));
        }
        return positions;
    }

    public static List<List<Position>> convertLineStrings(List<LineString> values) {
        List<List<Position>> positions = new ArrayList<>();
        for (LineString line : values) {
            positions.add(convertPoints(line.getCoordinates()));
        }
        return positions;
    }
}
