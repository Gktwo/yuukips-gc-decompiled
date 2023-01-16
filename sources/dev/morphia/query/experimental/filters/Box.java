package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.Point;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/Box.class */
public class Box extends Filter {
    private final Point bottomLeft;
    private final Point upperRight;

    /* access modifiers changed from: protected */
    public Box(String field, Point bottomLeft, Point upperRight) {
        super(QueryOperators.BOX, field, null);
        this.bottomLeft = bottomLeft;
        this.upperRight = upperRight;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        writer.writeStartDocument("$geoWithin");
        writer.writeStartArray(getName());
        writer.writeStartArray();
        for (Double value : this.bottomLeft.getPosition().getValues()) {
            writer.writeDouble(value.doubleValue());
        }
        writer.writeEndArray();
        writer.writeStartArray();
        for (Double value2 : this.upperRight.getPosition().getValues()) {
            writer.writeDouble(value2.doubleValue());
        }
        writer.writeEndArray();
        writer.writeEndArray();
        writer.writeEndDocument();
        writer.writeEndDocument();
    }
}
