package com.mongodb.client.model;

import com.mongodb.DBCollection;
import com.mongodb.QueryOperators;
import com.mongodb.assertions.Assertions;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.lang.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.bson.BsonArray;
import org.bson.BsonBoolean;
import org.bson.BsonDocument;
import org.bson.BsonDocumentWriter;
import org.bson.BsonDouble;
import org.bson.BsonInt32;
import org.bson.BsonInt64;
import org.bson.BsonRegularExpression;
import org.bson.BsonString;
import org.bson.BsonType;
import org.bson.BsonValue;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Filters.class */
public final class Filters {
    private Filters() {
    }

    /* renamed from: eq */
    public static <TItem> Bson m1278eq(@Nullable TItem value) {
        return m1277eq(DBCollection.ID_FIELD_NAME, value);
    }

    /* renamed from: eq */
    public static <TItem> Bson m1277eq(String fieldName, @Nullable TItem value) {
        return new SimpleEncodingFilter(fieldName, value);
    }

    /* renamed from: ne */
    public static <TItem> Bson m1272ne(String fieldName, @Nullable TItem value) {
        return new OperatorFilter(QueryOperators.f431NE, fieldName, value);
    }

    /* renamed from: gt */
    public static <TItem> Bson m1276gt(String fieldName, TItem value) {
        return new OperatorFilter(QueryOperators.f429GT, fieldName, value);
    }

    /* renamed from: lt */
    public static <TItem> Bson m1273lt(String fieldName, TItem value) {
        return new OperatorFilter(QueryOperators.f430LT, fieldName, value);
    }

    public static <TItem> Bson gte(String fieldName, TItem value) {
        return new OperatorFilter(QueryOperators.GTE, fieldName, value);
    }

    public static <TItem> Bson lte(String fieldName, TItem value) {
        return new OperatorFilter(QueryOperators.LTE, fieldName, value);
    }

    @SafeVarargs
    /* renamed from: in */
    public static <TItem> Bson m1274in(String fieldName, TItem... values) {
        return m1275in(fieldName, Arrays.asList(values));
    }

    /* renamed from: in */
    public static <TItem> Bson m1275in(String fieldName, Iterable<TItem> values) {
        return new IterableOperatorFilter(fieldName, QueryOperators.f432IN, values);
    }

    @SafeVarargs
    public static <TItem> Bson nin(String fieldName, TItem... values) {
        return nin(fieldName, Arrays.asList(values));
    }

    public static <TItem> Bson nin(String fieldName, Iterable<TItem> values) {
        return new IterableOperatorFilter(fieldName, QueryOperators.NIN, values);
    }

    public static Bson and(Iterable<Bson> filters) {
        return new AndFilter(filters);
    }

    public static Bson and(Bson... filters) {
        return and(Arrays.asList(filters));
    }

    /* renamed from: or */
    public static Bson m1271or(Iterable<Bson> filters) {
        return new OrNorFilter(OrNorFilter.Operator.OR, filters);
    }

    /* renamed from: or */
    public static Bson m1270or(Bson... filters) {
        return m1271or(Arrays.asList(filters));
    }

    public static Bson not(Bson filter) {
        return new NotFilter(filter);
    }

    public static Bson nor(Bson... filters) {
        return nor(Arrays.asList(filters));
    }

    public static Bson nor(Iterable<Bson> filters) {
        return new OrNorFilter(OrNorFilter.Operator.NOR, filters);
    }

    public static Bson exists(String fieldName) {
        return exists(fieldName, true);
    }

    public static Bson exists(String fieldName, boolean exists) {
        return new OperatorFilter(QueryOperators.EXISTS, fieldName, BsonBoolean.valueOf(exists));
    }

    public static Bson type(String fieldName, BsonType type) {
        return new OperatorFilter("$type", fieldName, new BsonInt32(type.getValue()));
    }

    public static Bson type(String fieldName, String type) {
        return new OperatorFilter("$type", fieldName, new BsonString(type));
    }

    public static Bson mod(String fieldName, long divisor, long remainder) {
        return new OperatorFilter(QueryOperators.MOD, fieldName, new BsonArray(Arrays.asList(new BsonInt64(divisor), new BsonInt64(remainder))));
    }

    public static Bson regex(String fieldName, String pattern) {
        return regex(fieldName, pattern, null);
    }

    public static Bson regex(String fieldName, String pattern, @Nullable String options) {
        Assertions.notNull("pattern", pattern);
        return new SimpleFilter(fieldName, new BsonRegularExpression(pattern, options));
    }

    public static Bson regex(String fieldName, Pattern pattern) {
        Assertions.notNull("pattern", pattern);
        return new SimpleEncodingFilter(fieldName, pattern);
    }

    public static Bson text(String search) {
        Assertions.notNull("search", search);
        return text(search, new TextSearchOptions());
    }

    public static Bson text(String search, TextSearchOptions textSearchOptions) {
        Assertions.notNull("search", search);
        Assertions.notNull("textSearchOptions", textSearchOptions);
        return new TextFilter(search, textSearchOptions);
    }

    public static Bson where(String javaScriptExpression) {
        Assertions.notNull("javaScriptExpression", javaScriptExpression);
        return new BsonDocument(QueryOperators.WHERE, new BsonString(javaScriptExpression));
    }

    public static <TExpression> Bson expr(TExpression expression) {
        return new SimpleEncodingFilter("$expr", expression);
    }

    @SafeVarargs
    public static <TItem> Bson all(String fieldName, TItem... values) {
        return all(fieldName, Arrays.asList(values));
    }

    public static <TItem> Bson all(String fieldName, Iterable<TItem> values) {
        return new IterableOperatorFilter(fieldName, QueryOperators.ALL, values);
    }

    public static Bson elemMatch(final String fieldName, final Bson filter) {
        return new Bson() { // from class: com.mongodb.client.model.Filters.1
            @Override // org.bson.conversions.Bson
            public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
                return new BsonDocument(fieldName, new BsonDocument(QueryOperators.ELEM_MATCH, filter.toBsonDocument(documentClass, codecRegistry)));
            }
        };
    }

    public static Bson size(String fieldName, int size) {
        return new OperatorFilter(QueryOperators.SIZE, fieldName, Integer.valueOf(size));
    }

    public static Bson bitsAllClear(String fieldName, long bitmask) {
        return new OperatorFilter("$bitsAllClear", fieldName, Long.valueOf(bitmask));
    }

    public static Bson bitsAllSet(String fieldName, long bitmask) {
        return new OperatorFilter("$bitsAllSet", fieldName, Long.valueOf(bitmask));
    }

    public static Bson bitsAnyClear(String fieldName, long bitmask) {
        return new OperatorFilter("$bitsAnyClear", fieldName, Long.valueOf(bitmask));
    }

    public static Bson bitsAnySet(String fieldName, long bitmask) {
        return new OperatorFilter("$bitsAnySet", fieldName, Long.valueOf(bitmask));
    }

    public static Bson geoWithin(String fieldName, Geometry geometry) {
        return new GeometryOperatorFilter("$geoWithin", fieldName, geometry);
    }

    public static Bson geoWithin(String fieldName, Bson geometry) {
        return new GeometryOperatorFilter("$geoWithin", fieldName, geometry);
    }

    public static Bson geoWithinBox(String fieldName, double lowerLeftX, double lowerLeftY, double upperRightX, double upperRightY) {
        return new OperatorFilter("$geoWithin", fieldName, new BsonDocument(QueryOperators.BOX, new BsonArray(Arrays.asList(new BsonArray(Arrays.asList(new BsonDouble(lowerLeftX), new BsonDouble(lowerLeftY))), new BsonArray(Arrays.asList(new BsonDouble(upperRightX), new BsonDouble(upperRightY)))))));
    }

    public static Bson geoWithinPolygon(String fieldName, List<List<Double>> points) {
        BsonArray pointsArray = new BsonArray();
        for (List<Double> point : points) {
            pointsArray.add((BsonValue) new BsonArray(Arrays.asList(new BsonDouble(point.get(0).doubleValue()), new BsonDouble(point.get(1).doubleValue()))));
        }
        return new OperatorFilter("$geoWithin", fieldName, new BsonDocument(QueryOperators.POLYGON, pointsArray));
    }

    public static Bson geoWithinCenter(String fieldName, double x, double y, double radius) {
        return new OperatorFilter("$geoWithin", fieldName, new BsonDocument(QueryOperators.CENTER, new BsonArray(Arrays.asList(new BsonArray(Arrays.asList(new BsonDouble(x), new BsonDouble(y))), new BsonDouble(radius)))));
    }

    public static Bson geoWithinCenterSphere(String fieldName, double x, double y, double radius) {
        return new OperatorFilter("$geoWithin", fieldName, new BsonDocument(QueryOperators.CENTER_SPHERE, new BsonArray(Arrays.asList(new BsonArray(Arrays.asList(new BsonDouble(x), new BsonDouble(y))), new BsonDouble(radius)))));
    }

    public static Bson geoIntersects(String fieldName, Bson geometry) {
        return new GeometryOperatorFilter("$geoIntersects", fieldName, geometry);
    }

    public static Bson geoIntersects(String fieldName, Geometry geometry) {
        return new GeometryOperatorFilter("$geoIntersects", fieldName, geometry);
    }

    public static Bson near(String fieldName, Point geometry, @Nullable Double maxDistance, @Nullable Double minDistance) {
        return new GeometryOperatorFilter(QueryOperators.NEAR, fieldName, geometry, maxDistance, minDistance);
    }

    public static Bson near(String fieldName, Bson geometry, @Nullable Double maxDistance, @Nullable Double minDistance) {
        return new GeometryOperatorFilter(QueryOperators.NEAR, fieldName, geometry, maxDistance, minDistance);
    }

    public static Bson near(String fieldName, double x, double y, @Nullable Double maxDistance, @Nullable Double minDistance) {
        return createNearFilterDocument(fieldName, x, y, maxDistance, minDistance, QueryOperators.NEAR);
    }

    public static Bson nearSphere(String fieldName, Point geometry, @Nullable Double maxDistance, @Nullable Double minDistance) {
        return new GeometryOperatorFilter(QueryOperators.NEAR_SPHERE, fieldName, geometry, maxDistance, minDistance);
    }

    public static Bson nearSphere(String fieldName, Bson geometry, @Nullable Double maxDistance, @Nullable Double minDistance) {
        return new GeometryOperatorFilter(QueryOperators.NEAR_SPHERE, fieldName, geometry, maxDistance, minDistance);
    }

    public static Bson nearSphere(String fieldName, double x, double y, @Nullable Double maxDistance, @Nullable Double minDistance) {
        return createNearFilterDocument(fieldName, x, y, maxDistance, minDistance, QueryOperators.NEAR_SPHERE);
    }

    public static Bson jsonSchema(Bson schema) {
        return new SimpleEncodingFilter("$jsonSchema", schema);
    }

    public static Bson empty() {
        return new BsonDocument();
    }

    private static Bson createNearFilterDocument(String fieldName, double x, double y, @Nullable Double maxDistance, @Nullable Double minDistance, String operator) {
        BsonDocument nearFilter = new BsonDocument(operator, new BsonArray(Arrays.asList(new BsonDouble(x), new BsonDouble(y))));
        if (maxDistance != null) {
            nearFilter.append(QueryOperators.MAX_DISTANCE, new BsonDouble(maxDistance.doubleValue()));
        }
        if (minDistance != null) {
            nearFilter.append("$minDistance", new BsonDouble(minDistance.doubleValue()));
        }
        return new BsonDocument(fieldName, nearFilter);
    }

    /* access modifiers changed from: private */
    public static String operatorFilterToString(String fieldName, String operator, Object value) {
        return "Operator Filter{fieldName='" + fieldName + "', operator='" + operator + "', value=" + value + '}';
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$SimpleFilter.class */
    public static final class SimpleFilter implements Bson {
        private final String fieldName;
        private final BsonValue value;

        private SimpleFilter(String fieldName, BsonValue value) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.value = (BsonValue) Assertions.notNull("value", value);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            return new BsonDocument(this.fieldName, this.value);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SimpleFilter that = (SimpleFilter) o;
            if (!this.fieldName.equals(that.fieldName)) {
                return false;
            }
            return this.value.equals(that.value);
        }

        public int hashCode() {
            return (31 * this.fieldName.hashCode()) + this.value.hashCode();
        }

        public String toString() {
            return Filters.operatorFilterToString(this.fieldName, "$eq", this.value);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$OperatorFilter.class */
    public static final class OperatorFilter<TItem> implements Bson {
        private final String operatorName;
        private final String fieldName;
        private final TItem value;

        OperatorFilter(String operatorName, String fieldName, @Nullable TItem value) {
            this.operatorName = (String) Assertions.notNull("operatorName", operatorName);
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.value = value;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            writer.writeStartDocument();
            writer.writeName(this.operatorName);
            BuildersHelper.encodeValue(writer, this.value, codecRegistry);
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            OperatorFilter<?> that = (OperatorFilter) o;
            if (this.operatorName.equals(that.operatorName) && this.fieldName.equals(that.fieldName)) {
                return this.value != null ? this.value.equals(that.value) : that.value == null;
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((31 * this.operatorName.hashCode()) + this.fieldName.hashCode())) + (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return Filters.operatorFilterToString(this.fieldName, this.operatorName, this.value);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$AndFilter.class */
    public static class AndFilter implements Bson {
        private final Iterable<Bson> filters;

        AndFilter(Iterable<Bson> filters) {
            this.filters = (Iterable) Assertions.notNull("filters", filters);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonArray clauses = new BsonArray();
            for (Bson filter : this.filters) {
                clauses.add((BsonValue) filter.toBsonDocument(documentClass, codecRegistry));
            }
            return new BsonDocument(QueryOperators.AND, clauses);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.filters.equals(((AndFilter) o).filters);
        }

        public int hashCode() {
            return this.filters.hashCode();
        }

        public String toString() {
            return "And Filter{filters=" + this.filters + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$OrNorFilter.class */
    public static class OrNorFilter implements Bson {
        private final Operator operator;
        private final Iterable<Bson> filters;

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$OrNorFilter$Operator.class */
        public enum Operator {
            OR(QueryOperators.f428OR, "Or"),
            NOR(QueryOperators.NOR, "Nor");
            
            private final String name;
            private final String toStringName;

            Operator(String name, String toStringName) {
                this.name = name;
                this.toStringName = toStringName;
            }
        }

        OrNorFilter(Operator operator, Iterable<Bson> filters) {
            this.operator = (Operator) Assertions.notNull("operator", operator);
            this.filters = (Iterable) Assertions.notNull("filters", filters);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocument orRenderable = new BsonDocument();
            BsonArray filtersArray = new BsonArray();
            for (Bson filter : this.filters) {
                filtersArray.add((BsonValue) filter.toBsonDocument(documentClass, codecRegistry));
            }
            orRenderable.put(this.operator.name, (BsonValue) filtersArray);
            return orRenderable;
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            OrNorFilter that = (OrNorFilter) o;
            if (this.operator != that.operator) {
                return false;
            }
            return this.filters.equals(that.filters);
        }

        public int hashCode() {
            return (31 * this.operator.hashCode()) + this.filters.hashCode();
        }

        public String toString() {
            return this.operator.toStringName + " Filter{filters=" + this.filters + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$IterableOperatorFilter.class */
    public static class IterableOperatorFilter<TItem> implements Bson {
        private final String fieldName;
        private final String operatorName;
        private final Iterable<TItem> values;

        IterableOperatorFilter(String fieldName, String operatorName, Iterable<TItem> values) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.operatorName = (String) Assertions.notNull("operatorName", operatorName);
            this.values = (Iterable) Assertions.notNull("values", values);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            writer.writeStartDocument();
            writer.writeName(this.operatorName);
            writer.writeStartArray();
            for (TItem value : this.values) {
                BuildersHelper.encodeValue(writer, value, codecRegistry);
            }
            writer.writeEndArray();
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            IterableOperatorFilter<?> that = (IterableOperatorFilter) o;
            if (this.fieldName.equals(that.fieldName) && this.operatorName.equals(that.operatorName)) {
                return this.values.equals(that.values);
            }
            return false;
        }

        public int hashCode() {
            return (31 * ((31 * this.fieldName.hashCode()) + this.operatorName.hashCode())) + this.values.hashCode();
        }

        public String toString() {
            return Filters.operatorFilterToString(this.fieldName, this.operatorName, this.values);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$SimpleEncodingFilter.class */
    public static class SimpleEncodingFilter<TItem> implements Bson {
        private final String fieldName;
        private final TItem value;

        SimpleEncodingFilter(String fieldName, @Nullable TItem value) {
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.value = value;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            BuildersHelper.encodeValue(writer, this.value, codecRegistry);
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            SimpleEncodingFilter<?> that = (SimpleEncodingFilter) o;
            if (!this.fieldName.equals(that.fieldName)) {
                return false;
            }
            return this.value != null ? this.value.equals(that.value) : that.value == null;
        }

        public int hashCode() {
            return (31 * this.fieldName.hashCode()) + (this.value != null ? this.value.hashCode() : 0);
        }

        public String toString() {
            return "Filter{fieldName='" + this.fieldName + "', value=" + this.value + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$NotFilter.class */
    private static class NotFilter implements Bson {
        private static final Set<String> DBREF_KEYS = Collections.unmodifiableSet(new HashSet(Arrays.asList("$ref", "$id")));
        private static final Set<String> DBREF_KEYS_WITH_DB = Collections.unmodifiableSet(new HashSet(Arrays.asList("$ref", "$id", "$db")));
        private final Bson filter;

        NotFilter(Bson filter) {
            this.filter = (Bson) Assertions.notNull("filter", filter);
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocument filterDocument = this.filter.toBsonDocument(documentClass, codecRegistry);
            if (filterDocument.size() == 1) {
                Map.Entry<String, BsonValue> entry = filterDocument.entrySet().iterator().next();
                return createFilter(entry.getKey(), entry.getValue());
            }
            BsonArray values = new BsonArray();
            for (Map.Entry<String, BsonValue> docs : filterDocument.entrySet()) {
                values.add((BsonValue) new BsonDocument(docs.getKey(), docs.getValue()));
            }
            return createFilter(QueryOperators.AND, values);
        }

        private boolean containsOperator(BsonDocument value) {
            Set<String> keys = value.keySet();
            if (keys.equals(DBREF_KEYS) || keys.equals(DBREF_KEYS_WITH_DB)) {
                return false;
            }
            for (String key : keys) {
                if (key.startsWith("$")) {
                    return true;
                }
            }
            return false;
        }

        private BsonDocument createFilter(String fieldName, BsonValue value) {
            if (fieldName.startsWith("$")) {
                return new BsonDocument(QueryOperators.NOT, new BsonDocument(fieldName, value));
            }
            if ((!value.isDocument() || !containsOperator(value.asDocument())) && !value.isRegularExpression()) {
                return new BsonDocument(fieldName, new BsonDocument(QueryOperators.NOT, new BsonDocument("$eq", value)));
            }
            return new BsonDocument(fieldName, new BsonDocument(QueryOperators.NOT, value));
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return this.filter.equals(((NotFilter) o).filter);
        }

        public int hashCode() {
            return this.filter.hashCode();
        }

        public String toString() {
            return "Not Filter{filter=" + this.filter + '}';
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$GeometryOperatorFilter.class */
    private static class GeometryOperatorFilter<TItem> implements Bson {
        private final String operatorName;
        private final String fieldName;
        private final TItem geometry;
        private final Double maxDistance;
        private final Double minDistance;

        GeometryOperatorFilter(String operatorName, String fieldName, TItem geometry) {
            this(operatorName, fieldName, geometry, null, null);
        }

        GeometryOperatorFilter(String operatorName, String fieldName, TItem geometry, @Nullable Double maxDistance, @Nullable Double minDistance) {
            this.operatorName = operatorName;
            this.fieldName = (String) Assertions.notNull("fieldName", fieldName);
            this.geometry = (TItem) Assertions.notNull("geometry", geometry);
            this.maxDistance = maxDistance;
            this.minDistance = minDistance;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocumentWriter writer = new BsonDocumentWriter(new BsonDocument());
            writer.writeStartDocument();
            writer.writeName(this.fieldName);
            writer.writeStartDocument();
            writer.writeName(this.operatorName);
            writer.writeStartDocument();
            writer.writeName("$geometry");
            BuildersHelper.encodeValue(writer, this.geometry, codecRegistry);
            if (this.maxDistance != null) {
                writer.writeDouble(QueryOperators.MAX_DISTANCE, this.maxDistance.doubleValue());
            }
            if (this.minDistance != null) {
                writer.writeDouble("$minDistance", this.minDistance.doubleValue());
            }
            writer.writeEndDocument();
            writer.writeEndDocument();
            writer.writeEndDocument();
            return writer.getDocument();
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            GeometryOperatorFilter<?> that = (GeometryOperatorFilter) o;
            if (this.operatorName != null) {
                if (!this.operatorName.equals(that.operatorName)) {
                    return false;
                }
            } else if (that.operatorName != null) {
                return false;
            }
            if (!this.fieldName.equals(that.fieldName) || !this.geometry.equals(that.geometry)) {
                return false;
            }
            if (this.maxDistance != null) {
                if (!this.maxDistance.equals(that.maxDistance)) {
                    return false;
                }
            } else if (that.maxDistance != null) {
                return false;
            }
            return this.minDistance != null ? this.minDistance.equals(that.minDistance) : that.minDistance == null;
        }

        public int hashCode() {
            return (31 * ((31 * ((31 * ((31 * (this.operatorName != null ? this.operatorName.hashCode() : 0)) + this.fieldName.hashCode())) + this.geometry.hashCode())) + (this.maxDistance != null ? this.maxDistance.hashCode() : 0))) + (this.minDistance != null ? this.minDistance.hashCode() : 0);
        }

        public String toString() {
            return "Geometry Operator Filter{fieldName='" + this.fieldName + "', operator='" + this.operatorName + "', geometry=" + this.geometry + ", maxDistance=" + this.maxDistance + ", minDistance=" + this.minDistance + '}';
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/client/model/Filters$TextFilter.class */
    public static class TextFilter implements Bson {
        private final String search;
        private final TextSearchOptions textSearchOptions;

        TextFilter(String search, TextSearchOptions textSearchOptions) {
            this.search = search;
            this.textSearchOptions = textSearchOptions;
        }

        @Override // org.bson.conversions.Bson
        public <TDocument> BsonDocument toBsonDocument(Class<TDocument> documentClass, CodecRegistry codecRegistry) {
            BsonDocument searchDocument = new BsonDocument(QueryOperators.SEARCH, new BsonString(this.search));
            String language = this.textSearchOptions.getLanguage();
            if (language != null) {
                searchDocument.put(QueryOperators.LANGUAGE, (BsonValue) new BsonString(language));
            }
            Boolean caseSensitive = this.textSearchOptions.getCaseSensitive();
            if (caseSensitive != null) {
                searchDocument.put("$caseSensitive", (BsonValue) BsonBoolean.valueOf(caseSensitive.booleanValue()));
            }
            Boolean diacriticSensitive = this.textSearchOptions.getDiacriticSensitive();
            if (diacriticSensitive != null) {
                searchDocument.put("$diacriticSensitive", (BsonValue) BsonBoolean.valueOf(diacriticSensitive.booleanValue()));
            }
            return new BsonDocument(QueryOperators.TEXT, searchDocument);
        }

        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            TextFilter that = (TextFilter) o;
            if (this.search != null) {
                if (!this.search.equals(that.search)) {
                    return false;
                }
            } else if (that.search != null) {
                return false;
            }
            return this.textSearchOptions != null ? this.textSearchOptions.equals(that.textSearchOptions) : that.textSearchOptions == null;
        }

        public int hashCode() {
            return (31 * (this.search != null ? this.search.hashCode() : 0)) + (this.textSearchOptions != null ? this.textSearchOptions.hashCode() : 0);
        }

        public String toString() {
            return "Text Filter{search='" + this.search + "', textSearchOptions=" + this.textSearchOptions + '}';
        }
    }
}
