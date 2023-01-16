package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.Geometry;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/GeoIntersectsFilter.class */
public class GeoIntersectsFilter extends Filter {
    /* access modifiers changed from: package-private */
    public GeoIntersectsFilter(String field, Geometry val) {
        super("$geoIntersects", field, val);
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        if (isNot()) {
            writer.writeStartDocument(QueryOperators.NOT);
        }
        writer.writeStartDocument(getName());
        writer.writeName("$geometry");
        writeUnnamedValue(getValue(mapper), mapper, writer, context);
        writer.writeEndDocument();
        if (isNot()) {
            writer.writeEndDocument();
        }
        writer.writeEndDocument();
    }
}
