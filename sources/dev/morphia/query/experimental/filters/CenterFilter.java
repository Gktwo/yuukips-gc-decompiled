package dev.morphia.query.experimental.filters;

import com.mongodb.client.model.geojson.Point;
import com.mongodb.lang.NonNull;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/CenterFilter.class */
public class CenterFilter extends Filter {
    private final double radius;

    /* access modifiers changed from: protected */
    public CenterFilter(String filterName, String field, Point value, double radius) {
        super(filterName, field, value);
        this.radius = radius;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        writer.writeStartDocument("$geoWithin");
        writer.writeStartArray(getName());
        Point center = getValue();
        writer.writeStartArray();
        for (Double value : center.getPosition().getValues()) {
            writer.writeDouble(value.doubleValue());
        }
        writer.writeEndArray();
        writer.writeDouble(this.radius);
        writer.writeEndArray();
        writer.writeEndDocument();
        writer.writeEndDocument();
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    @NonNull
    public Point getValue() {
        Object value = getValue();
        if (value != null) {
            return (Point) value;
        }
        throw new NullPointerException();
    }
}
