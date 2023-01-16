package dev.morphia.geo;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/PointBuilder.class */
public class PointBuilder {
    private double longitude;
    private double latitude;

    public static PointBuilder pointBuilder() {
        return new PointBuilder();
    }

    public Point build() {
        return new Point(this.latitude, this.longitude);
    }

    public PointBuilder latitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    public PointBuilder longitude(double longitude) {
        this.longitude = longitude;
        return this;
    }
}
