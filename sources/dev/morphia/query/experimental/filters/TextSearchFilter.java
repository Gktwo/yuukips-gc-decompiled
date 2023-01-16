package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import dev.morphia.mapping.Mapper;
import org.bson.BsonWriter;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/TextSearchFilter.class */
public class TextSearchFilter extends Filter {
    private final String searchText;
    private String language;
    private Boolean caseSensitive;
    private Boolean diacriticSensitive;

    /* access modifiers changed from: protected */
    public TextSearchFilter(String searchText) {
        super(QueryOperators.TEXT);
        this.searchText = searchText;
    }

    public TextSearchFilter caseSensitive(Boolean caseSensitive) {
        this.caseSensitive = caseSensitive;
        return this;
    }

    public TextSearchFilter diacriticSensitive(Boolean diacriticSensitive) {
        this.diacriticSensitive = diacriticSensitive;
        return this;
    }

    @Override // dev.morphia.query.experimental.filters.Filter
    public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
        writer.writeStartDocument(getName());
        writeNamedValue(QueryOperators.SEARCH, this.searchText, mapper, writer, context);
        if (this.language != null) {
            writeNamedValue(QueryOperators.LANGUAGE, this.language, mapper, writer, context);
        }
        if (Boolean.TRUE.equals(this.caseSensitive)) {
            writeNamedValue("$caseSensitive", this.caseSensitive, mapper, writer, context);
        }
        if (Boolean.TRUE.equals(this.diacriticSensitive)) {
            writeNamedValue("$diacriticSensitive", this.diacriticSensitive, mapper, writer, context);
        }
        writer.writeEndDocument();
    }

    public TextSearchFilter language(String language) {
        this.language = language;
        return this;
    }
}
