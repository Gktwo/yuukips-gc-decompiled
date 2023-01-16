package dev.morphia.aggregation;

import com.mongodb.client.model.geojson.Geometry;
import dev.morphia.geo.Point;
import dev.morphia.query.Query;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/aggregation/GeoNear.class */
public final class GeoNear {
    private final double[] nearLegacy;
    private final Geometry nearGeoJson;
    private final String distanceField;
    private final Long limit;
    private final Long maxDocuments;
    private final Double maxDistance;
    private final Query query;
    private final Boolean spherical;
    private final Double distanceMultiplier;
    private final String includeLocations;

    private GeoNear(GeoNearBuilder builder) {
        this.nearLegacy = builder.nearLegacy;
        this.nearGeoJson = builder.nearGeoJson;
        this.distanceField = builder.distanceField;
        this.limit = builder.limit;
        this.maxDocuments = builder.maxDocuments;
        this.maxDistance = builder.maxDistance;
        this.query = builder.query;
        this.spherical = builder.spherical;
        this.distanceMultiplier = builder.distanceMultiplier;
        this.includeLocations = builder.includeLocations;
    }

    public static GeoNearBuilder builder(String distanceField) {
        return new GeoNearBuilder(distanceField);
    }

    public String getDistanceField() {
        return this.distanceField;
    }

    public Double getDistanceMultiplier() {
        return this.distanceMultiplier;
    }

    public String getIncludeLocations() {
        return this.includeLocations;
    }

    public Long getLimit() {
        return this.limit;
    }

    public Double getMaxDistance() {
        return this.maxDistance;
    }

    public Long getMaxDocuments() {
        return this.maxDocuments;
    }

    public double[] getNear() {
        double[] copy = new double[0];
        if (this.nearLegacy != null) {
            copy = new double[this.nearLegacy.length];
            System.arraycopy(this.nearLegacy, 0, copy, 0, this.nearLegacy.length);
        }
        return copy;
    }

    public Query getQuery() {
        return this.query;
    }

    public Boolean getSpherical() {
        return this.spherical;
    }

    @Deprecated(since = "2.0", forRemoval = true)
    /* loaded from: grasscutter.jar:dev/morphia/aggregation/GeoNear$GeoNearBuilder.class */
    public static class GeoNearBuilder {
        private final String distanceField;
        private Long limit;
        private Long maxDocuments;
        private Double maxDistance;
        private Query query;
        private Boolean spherical;
        private Double distanceMultiplier;
        private String includeLocations;
        private double[] nearLegacy;
        private Geometry nearGeoJson;

        public GeoNearBuilder(String distanceField) {
            this.distanceField = distanceField;
        }

        public GeoNear build() {
            return new GeoNear(this);
        }

        public GeoNearBuilder setDistanceMultiplier(Double distanceMultiplier) {
            this.distanceMultiplier = distanceMultiplier;
            return this;
        }

        public GeoNearBuilder setIncludeLocations(String includeLocations) {
            this.includeLocations = includeLocations;
            return this;
        }

        public GeoNearBuilder setLimit(Long limit) {
            this.limit = limit;
            return this;
        }

        public GeoNearBuilder setMaxDistance(Double maxDistance) {
            this.maxDistance = maxDistance;
            return this;
        }

        public GeoNearBuilder setMaxDocuments(Long num) {
            this.maxDocuments = num;
            return this;
        }

        public GeoNearBuilder setNear(double latitude, double longitude) {
            this.nearLegacy = new double[]{longitude, latitude};
            return this;
        }

        @Deprecated(since = "2.0", forRemoval = true)
        public GeoNearBuilder setNear(Point point) {
            return setNear(point.convert());
        }

        public GeoNearBuilder setNear(com.mongodb.client.model.geojson.Point point) {
            this.nearGeoJson = point;
            return this;
        }

        public GeoNearBuilder setQuery(Query query) {
            this.query = query;
            return this;
        }

        public GeoNearBuilder setSpherical(Boolean spherical) {
            this.spherical = spherical;
            return this;
        }
    }
}
