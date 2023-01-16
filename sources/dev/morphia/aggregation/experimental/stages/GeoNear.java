package dev.morphia.aggregation.experimental.stages;

import com.mongodb.client.model.geojson.Point;
import dev.morphia.query.experimental.filters.Filter;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/GeoNear.class */
public class GeoNear extends Stage {
    private Point point;
    private double[] coordinates;
    private String distanceField;
    private Boolean spherical;
    private Number maxDistance;
    private Filter[] filters;
    private Number distanceMultiplier;
    private String includeLocs;
    private Number minDistance;
    private String key;

    protected GeoNear(Point point) {
        this();
        this.point = point;
    }

    protected GeoNear() {
        super("$geoNear");
    }

    protected GeoNear(double[] coordinates) {
        this();
        this.coordinates = coordinates;
    }

    public static GeoNear geoNear(Point point) {
        return new GeoNear(point);
    }

    public static GeoNear geoNear(double[] coordinates) {
        return new GeoNear(coordinates);
    }

    @Deprecated(forRemoval = true)
    /* renamed from: to */
    public static GeoNear m1249to(Point point) {
        return new GeoNear(point);
    }

    @Deprecated(forRemoval = true)
    /* renamed from: to */
    public static GeoNear m1248to(double[] coordinates) {
        return new GeoNear(coordinates);
    }

    public GeoNear distanceField(String distanceField) {
        this.distanceField = distanceField;
        return this;
    }

    public GeoNear distanceMultiplier(Number distanceMultiplier) {
        this.distanceMultiplier = distanceMultiplier;
        return this;
    }

    public double[] getCoordinates() {
        return this.coordinates;
    }

    public String getDistanceField() {
        return this.distanceField;
    }

    public Number getDistanceMultiplier() {
        return this.distanceMultiplier;
    }

    public Filter[] getFilters() {
        return this.filters;
    }

    public String getIncludeLocs() {
        return this.includeLocs;
    }

    public String getKey() {
        return this.key;
    }

    public Number getMaxDistance() {
        return this.maxDistance;
    }

    public Number getMinDistance() {
        return this.minDistance;
    }

    public Point getPoint() {
        return this.point;
    }

    public Boolean getSpherical() {
        return this.spherical;
    }

    public GeoNear includeLocs(String includeLocs) {
        this.includeLocs = includeLocs;
        return this;
    }

    public GeoNear key(String key) {
        this.key = key;
        return this;
    }

    public GeoNear maxDistance(Number maxDistance) {
        this.maxDistance = maxDistance;
        return this;
    }

    public GeoNear minDistance(Number minDistance) {
        this.minDistance = minDistance;
        return this;
    }

    public GeoNear query(Filter... filters) {
        this.filters = filters;
        return this;
    }

    public GeoNear spherical(Boolean spherical) {
        this.spherical = spherical;
        return this;
    }
}
