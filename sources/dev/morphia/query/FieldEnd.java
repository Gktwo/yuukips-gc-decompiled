package dev.morphia.query;

import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.MultiPolygon;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Polygon;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/query/FieldEnd.class */
public interface FieldEnd<T> {
    @Deprecated(since = "2.0", forRemoval = true)
    T contains(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    T containsIgnoreCase(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    T doesNotExist();

    @Deprecated(since = "2.0", forRemoval = true)
    T endsWith(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    T endsWithIgnoreCase(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    T equal(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T equalIgnoreCase(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T elemMatch(Query<?> query);

    @Deprecated(since = "2.0", forRemoval = true)
    T greaterThan(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T greaterThanOrEq(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T hasAllOf(Iterable<?> iterable);

    @Deprecated(since = "2.0", forRemoval = true)
    T hasAnyOf(Iterable<?> iterable);

    @Deprecated(since = "2.0", forRemoval = true)
    T hasNoneOf(Iterable<?> iterable);

    @Deprecated(since = "2.0", forRemoval = true)
    T exists();

    @Deprecated(since = "2.0", forRemoval = true)
    T hasThisOne(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    /* renamed from: in */
    T mo1225in(Iterable<?> iterable);

    @Deprecated(since = "2.0", forRemoval = true)
    T intersects(Geometry geometry);

    @Deprecated(since = "2.0", forRemoval = true)
    T intersects(Geometry geometry, CoordinateReferenceSystem coordinateReferenceSystem);

    @Deprecated(since = "2.0", forRemoval = true)
    T lessThan(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T lessThanOrEq(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T mod(long j, long j2);

    @Deprecated(since = "2.0", forRemoval = true)
    T near(double d, double d2);

    @Deprecated(since = "2.0", forRemoval = true)
    T near(double d, double d2, boolean z);

    @Deprecated(since = "2.0", forRemoval = true)
    T near(double d, double d2, double d3);

    @Deprecated(since = "2.0", forRemoval = true)
    T near(double d, double d2, double d3, boolean z);

    @Deprecated(since = "2.0", forRemoval = true)
    T near(Point point);

    @Deprecated(since = "2.0", forRemoval = true)
    T near(Point point, Double d, Double d2);

    @Deprecated(since = "2.0", forRemoval = true)
    T nearSphere(Point point);

    @Deprecated(since = "2.0", forRemoval = true)
    T nearSphere(Point point, Double d, Double d2);

    @Deprecated(since = "2.0", forRemoval = true)
    FieldEnd<T> not();

    @Deprecated(since = "2.0", forRemoval = true)
    T notEqual(Object obj);

    @Deprecated(since = "2.0", forRemoval = true)
    T notIn(Iterable<?> iterable);

    @Deprecated(since = "2.0", forRemoval = true)
    T sizeEq(int i);

    @Deprecated(since = "2.0", forRemoval = true)
    T startsWith(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    T startsWithIgnoreCase(String str);

    @Deprecated(since = "2.0", forRemoval = true)
    T type(Type type);

    @Deprecated(since = "2.0", forRemoval = true)
    T within(Shape shape);

    @Deprecated(since = "2.0", forRemoval = true)
    T within(Polygon polygon);

    @Deprecated(since = "2.0", forRemoval = true)
    T within(MultiPolygon multiPolygon);

    @Deprecated(since = "2.0", forRemoval = true)
    T within(Polygon polygon, CoordinateReferenceSystem coordinateReferenceSystem);

    @Deprecated(since = "2.0", forRemoval = true)
    T within(MultiPolygon multiPolygon, CoordinateReferenceSystem coordinateReferenceSystem);

    @Deprecated(since = "2.0", forRemoval = true)
    default T intersects(dev.morphia.geo.Geometry geometry) {
        return intersects(geometry.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T intersects(dev.morphia.geo.Geometry geometry, dev.morphia.geo.CoordinateReferenceSystem crs) {
        return intersects(geometry.convert(), crs.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T near(dev.morphia.geo.Point point) {
        return near(point.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T near(dev.morphia.geo.Point point, Double maxDistance, Double minDistance) {
        return near(point.convert(), maxDistance, minDistance);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T nearSphere(dev.morphia.geo.Point point) {
        return nearSphere(point.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T nearSphere(dev.morphia.geo.Point point, Double maxDistance, Double minDistance) {
        return nearSphere(point.convert(), maxDistance, minDistance);
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T within(dev.morphia.geo.Polygon boundary) {
        return within(boundary.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T within(dev.morphia.geo.MultiPolygon boundaries) {
        return within(boundaries.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T within(dev.morphia.geo.Polygon boundary, dev.morphia.geo.CoordinateReferenceSystem crs) {
        return within(boundary.convert(), crs.convert());
    }

    @Deprecated(since = "2.0", forRemoval = true)
    default T within(dev.morphia.geo.MultiPolygon boundaries, dev.morphia.geo.CoordinateReferenceSystem crs) {
        return within(boundaries.convert(), crs.convert());
    }
}
