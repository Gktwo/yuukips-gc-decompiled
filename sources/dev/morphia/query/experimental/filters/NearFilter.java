package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.CoordinateReferenceSystem;
import com.mongodb.client.model.geojson.Point;
import dev.morphia.mapping.Mapper;
import java.util.Map;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/NearFilter.class */
public class NearFilter extends Filter {
    private Double maxDistance;
    private Double minDistance;
    private CoordinateReferenceSystem crs;

    /* access modifiers changed from: package-private */
    public NearFilter(String filterName, String field, Point point) {
        super(filterName, field, point);
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
        if (this.maxDistance != null) {
            writeNamedValue(QueryOperators.MAX_DISTANCE, this.maxDistance, mapper, writer, context);
        }
        if (this.minDistance != null) {
            writeNamedValue("$minDistance", this.minDistance, mapper, writer, context);
        }
        if (this.crs != null) {
            writeNamedValue("crs", this.crs, mapper, writer, context);
        }
        writer.writeEndDocument();
        if (isNot()) {
            writer.writeEndDocument();
        }
        writer.writeEndDocument();
    }

    public NearFilter maxDistance(Double maxDistance) {
        this.maxDistance = maxDistance;
        return this;
    }

    public NearFilter minDistance(Double minDistance) {
        this.minDistance = minDistance;
        return this;
    }

    public NearFilter crs(CoordinateReferenceSystem crs) {
        this.crs = crs;
        return this;
    }

    public void applyOpts(Map opts) {
        this.maxDistance = (Double) opts.get(QueryOperators.MAX_DISTANCE);
        this.minDistance = (Double) opts.get("$minDistance");
    }
}
