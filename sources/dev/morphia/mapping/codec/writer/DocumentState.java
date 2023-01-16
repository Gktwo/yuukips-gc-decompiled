package dev.morphia.mapping.codec.writer;

import com.mongodb.QueryOperators;
import com.mongodb.lang.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import org.bson.Document;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/writer/DocumentState.class */
public class DocumentState extends ValueState<Map<String, Object>> {
    private final List<NameState> values = new ArrayList();
    private Document finished;

    /* access modifiers changed from: package-private */
    public DocumentState(DocumentWriter writer, WriteState previous) {
        super(writer, previous);
    }

    public String toString() {
        StringJoiner joiner = new StringJoiner(", ", "{", this.finished != null ? "}" : "");
        this.values.forEach(v -> {
            joiner.add(v.toString());
        });
        return joiner.toString();
    }

    @Override // dev.morphia.mapping.codec.writer.ValueState
    public Map<String, Object> value() {
        return this.finished;
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    protected String state() {
        return "document";
    }

    @Override // dev.morphia.mapping.codec.writer.WriteState
    void end() {
        this.finished = new Document();
        this.values.forEach(v -> {
            if (this.finished.get(v.name()) == null) {
                this.finished.put(v.name(), v.value());
            } else {
                andTogether(this.finished, v.name(), v.value());
            }
        });
        end();
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.codec.writer.WriteState
    public NameState name(String name) {
        NameState state = new NameState(getWriter(), name, this);
        this.values.add(state);
        return state;
    }

    private Document andTogether(Document doc, String key, @Nullable Object additional) {
        if (additional != null) {
            Document newSubdoc = new Document(key, additional);
            Object extant = doc.remove(key);
            List<Document> and = (List) doc.get(QueryOperators.AND);
            if (and != null) {
                and.add(newSubdoc);
            } else {
                List<Document> and2 = new ArrayList<>();
                and2.addAll(List.of(new Document(key, extant), newSubdoc));
                doc.put(QueryOperators.AND, (Object) and2);
                return newSubdoc;
            }
        }
        return doc;
    }
}
