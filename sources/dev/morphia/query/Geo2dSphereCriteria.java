package dev.morphia.query;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import dev.morphia.mapping.codec.pojo.EntityModel;
import dev.morphia.mapping.codec.writer.DocumentWriter;
import org.bson.Document;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/Geo2dSphereCriteria.class */
final class Geo2dSphereCriteria extends FieldCriteria {
    private final Geometry geometry;
    private Document options;
    private CoordinateReferenceSystem crs;

    private Geo2dSphereCriteria(Mapper mapper, String field, FilterOperator operator, Geometry geometry, EntityModel model, boolean validating) {
        super(mapper, field, operator, geometry, model, validating);
        this.geometry = geometry;
    }

    /* access modifiers changed from: package-private */
    public static Geo2dSphereCriteria geo(Mapper mapper, String field, FilterOperator operator, Geometry value, EntityModel model, boolean validating) {
        return new Geo2dSphereCriteria(mapper, field, operator, value, model, validating);
    }

    @Override // dev.morphia.query.FieldCriteria, dev.morphia.query.Criteria
    public Document toDocument() {
        Document query;
        FilterOperator operator = getOperator();
        DocumentWriter writer = new DocumentWriter(getMapper());
        getMapper().getCodecRegistry().get(this.geometry.getClass()).encode(writer, this.geometry, EncoderContext.builder().build());
        Document document = new Document("$geometry", writer.getDocument());
        if (operator == FilterOperator.NEAR || operator == FilterOperator.NEAR_SPHERE) {
            if (this.options != null) {
                document.putAll(this.options);
            }
            query = new Document(FilterOperator.NEAR.val(), document);
        } else if (operator == FilterOperator.GEO_WITHIN || operator == FilterOperator.INTERSECTS) {
            query = new Document(operator.val(), document);
            if (this.crs != null) {
                ((Document) document.get("$geometry")).put("crs", (Object) this.crs);
            }
        } else {
            throw new UnsupportedOperationException(String.format("Operator %s not supported for geo-query", operator.val()));
        }
        return new Document(getField(), query);
    }

    /* access modifiers changed from: package-private */
    public Geo2dSphereCriteria addCoordinateReferenceSystem(CoordinateReferenceSystem crs) {
        this.crs = crs;
        return this;
    }

    private Geo2dSphereCriteria manageOption(String key, @Nullable Object value) {
        if (this.options == null) {
            this.options = new Document();
        }
        if (value == null) {
            this.options.remove(key);
        } else {
            this.options.put(key, value);
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public Geo2dSphereCriteria maxDistance(@Nullable Double maxDistance) {
        return manageOption(QueryOperators.MAX_DISTANCE, maxDistance);
    }

    /* access modifiers changed from: package-private */
    public Geo2dSphereCriteria minDistance(@Nullable Double minDistance) {
        return manageOption("$minDistance", minDistance);
    }
}
