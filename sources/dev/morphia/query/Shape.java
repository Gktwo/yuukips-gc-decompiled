package dev.morphia.query;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.Point;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/Shape.class */
public class Shape {
    private final String geometry;
    private final Point[] points;

    Shape(String geometry, Point... points) {
        this.geometry = geometry;
        this.points = points;
    }

    public static Shape box(Point bottomLeft, Point upperRight) {
        return new Shape(QueryOperators.BOX, bottomLeft, upperRight);
    }

    public static Shape center(Point center, double radius) {
        return new Center(QueryOperators.CENTER, center, radius);
    }

    public static Shape centerSphere(Point center, double radius) {
        return new Center(QueryOperators.CENTER_SPHERE, center, radius);
    }

    public static Shape polygon(Point... points) {
        return new Shape(QueryOperators.POLYGON, points);
    }

    public String getGeometry() {
        return this.geometry;
    }

    public Point[] getPoints() {
        return copy(this.points);
    }

    private Point[] copy(Point[] array) {
        Point[] copy = new Point[array.length];
        System.arraycopy(array, 0, copy, 0, array.length);
        return copy;
    }

    /* loaded from: grasscutter.jar:dev/morphia/query/Shape$Center.class */
    public static class Center extends Shape {
        private final Point center;
        private final double radius;

        Center(String geometry, Point center, double radius) {
            super(geometry, new Point[0]);
            this.center = center;
            this.radius = radius;
        }

        public Point getCenter() {
            return this.center;
        }

        public double getRadius() {
            return this.radius;
        }
    }
}
