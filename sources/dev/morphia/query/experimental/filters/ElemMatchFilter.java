package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import dev.morphia.mapping.Mapper;
import java.util.List;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/ElemMatchFilter.class */
class ElemMatchFilter extends Filter {
    /* access modifiers changed from: package-private */
    public ElemMatchFilter(String field, List<Filter> query) {
        super(QueryOperators.ELEM_MATCH, field, query);
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(path(mapper));
        if (isNot()) {
            writer.writeStartDocument(QueryOperators.NOT);
        }
        writer.writeStartDocument(getName());
        List<Filter> filters = (List) getValue();
        if (filters != null) {
            for (Filter filter : filters) {
                filter.encode(mapper, writer, context);
            }
        }
        if (isNot()) {
            writer.writeEndDocument();
        }
        writer.writeEndDocument();
        writer.writeEndDocument();
    }
}
