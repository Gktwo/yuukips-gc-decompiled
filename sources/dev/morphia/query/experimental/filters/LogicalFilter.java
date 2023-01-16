package dev.morphia.query.experimental.filters;

import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.mapping.Mapper;
import java.util.Arrays;
import java.util.List;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/LogicalFilter.class */
public class LogicalFilter extends Filter {
    private final List<Filter> filters;

    /* access modifiers changed from: package-private */
    public LogicalFilter(String name, Filter... filters) {
        super(name);
        this.filters = Arrays.asList(filters);
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartArray(getName());
        for (Filter filter : this.filters) {
            ExpressionHelper.document(writer, () -> {
                filter.encode(mapper, writer, context);
            });
        }
        writer.writeEndArray();
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public Filter entityType(Class<?> type) {
        entityType(type);
        for (Filter filter : this.filters) {
            filter.entityType(type);
        }
        return this;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public Filter isValidating(boolean validate) {
        isValidating(validate);
        for (Filter filter : this.filters) {
            filter.isValidating(validate);
        }
        return this;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public String toString() {
        return String.format("%s: %s", getName(), this.filters);
    }
}
