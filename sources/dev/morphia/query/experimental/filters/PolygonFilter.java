package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.Point;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/PolygonFilter.class */
public class PolygonFilter extends Filter {
    private final Point[] points;

    /* access modifiers changed from: package-private */
    public PolygonFilter(String field, Point[] points) {
        super(QueryOperators.POLYGON, field, null);
        this.points = points;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        writer.writeStartDocument("$geoWithin");
        writer.writeStartArray(QueryOperators.POLYGON);
        Point[] pointArr = this.points;
        for (Point point : pointArr) {
            writer.writeStartArray();
            for (Double value : point.getPosition().getValues()) {
                writer.writeDouble(value.doubleValue());
            }
            writer.writeEndArray();
        }
        writer.writeEndArray();
        writer.writeEndDocument();
        writer.writeEndDocument();
    }
}
