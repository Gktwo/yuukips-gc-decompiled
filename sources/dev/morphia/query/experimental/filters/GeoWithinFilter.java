package dev.morphia.query.experimental.filters;

import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.MultiPolygon;
import com.mongodb.client.model.geojson.Polygon;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/GeoWithinFilter.class */
public class GeoWithinFilter extends Filter {
    private CoordinateReferenceSystem crs;

    /* access modifiers changed from: package-private */
    public GeoWithinFilter(String field, Polygon value) {
        super("$geoWithin", field, value);
    }

    /* access modifiers changed from: package-private */
    public GeoWithinFilter(String field, MultiPolygon value) {
        super("$geoWithin", field, value);
    }

    public GeoWithinFilter crs(CoordinateReferenceSystem crs) {
        this.crs = crs;
        return this;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public final void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        writer.writeStartDocument(getName());
        writer.writeName("$geometry");
        Object shape = getValue();
        if (shape != null) {
            mapper.getCodecRegistry().get(shape.getClass()).encode(writer, shape, context);
        }
        writer.writeEndDocument();
        writer.writeEndDocument();
    }
}
