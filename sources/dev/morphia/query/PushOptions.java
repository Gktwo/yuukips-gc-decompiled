package dev.morphia.query;

import dev.morphia.query.experimental.updates.PushOperator;
import java.util.Map;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/PushOptions.class */
public class PushOptions {
    private Integer position;
    private Integer slice;
    private Integer sort;
    private Document sortDocument;

    public PushOptions position(int position) {
        if (position < 0) {
            throw new UpdateException("The position must be at least 0.");
        }
        this.position = Integer.valueOf(position);
        return this;
    }

    public PushOptions slice(int slice) {
        this.slice = Integer.valueOf(slice);
        return this;
    }

    public PushOptions sort(int sort) {
        this.sort = Integer.valueOf(sort);
        return this;
    }

    public PushOptions sort(String field, int direction) {
        if (this.sort != null) {
            throw new IllegalStateException("sortDocument can not be set if sort already is");
        }
        if (this.sortDocument == null) {
            this.sortDocument = new Document();
        }
        this.sortDocument.put(field, (Object) Integer.valueOf(direction));
        return this;
    }

    /* access modifiers changed from: package-private */
    public void update(PushOperator push) {
        if (this.position != null) {
            push.position(this.position.intValue());
        }
        if (this.slice != null) {
            push.slice(this.slice.intValue());
        }
        if (this.sort != null) {
            push.sort(this.sort.intValue());
        }
        if (this.sortDocument != null) {
            Map.Entry<String, Integer> next = (Map.Entry) this.sortDocument.values().iterator().next();
            push.sort(new Sort(next.getKey(), next.getValue().intValue()));
        }
    }

    void update(Document document) {
        if (this.position != null) {
            document.put("$position", (Object) this.position);
        }
        if (this.slice != null) {
            document.put("$slice", (Object) this.slice);
        }
        if (this.sort != null) {
            document.put("$sort", (Object) this.sort);
        }
        if (this.sortDocument != null) {
            document.put("$sort", (Object) this.sortDocument);
        }
    }

    public static PushOptions options() {
        return new PushOptions();
    }
}
