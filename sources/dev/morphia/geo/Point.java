package dev.morphia.geo;

import com.mongodb.client.model.geojson.Position;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/Point.class */
public class Point implements Geometry {
    private final List<Double> coordinates = new ArrayList();

    /* access modifiers changed from: package-private */
    public Point(double latitude, double longitude) {
        this.coordinates.add(Double.valueOf(longitude));
        this.coordinates.add(Double.valueOf(latitude));
    }

    /* access modifiers changed from: package-private */
    public Point(List<Double> coordinates) {
        this.coordinates.addAll(coordinates);
    }

    @Override // dev.morphia.geo.Geometry
    public List<Double> getCoordinates() {
        return this.coordinates;
    }

    public double getLatitude() {
        return this.coordinates.get(1).doubleValue();
    }

    public double getLongitude() {
        return this.coordinates.get(0).doubleValue();
    }

    public int hashCode() {
        return this.coordinates.hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        if (getCoordinates().size() != point.getCoordinates().size()) {
            return false;
        }
        for (int i = 0; i < this.coordinates.size(); i++) {
            if (Double.compare(this.coordinates.get(i).doubleValue(), point.getCoordinates().get(i).doubleValue()) != 0) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        return String.format("Point{coordinates=%s}", this.coordinates);
    }

    @Override // dev.morphia.geo.Geometry
    public com.mongodb.client.model.geojson.Point convert() {
        return convert((CoordinateReferenceSystem) null);
    }

    @Override // dev.morphia.geo.Geometry
    public com.mongodb.client.model.geojson.Point convert(@Nullable CoordinateReferenceSystem crs) {
        return new com.mongodb.client.model.geojson.Point(crs != null ? crs.convert() : null, new Position(getLongitude(), getLatitude(), new double[0]));
    }
}
