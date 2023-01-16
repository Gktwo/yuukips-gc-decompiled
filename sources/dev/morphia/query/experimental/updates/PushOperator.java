package dev.morphia.query.experimental.updates;

import dev.morphia.internal.PathTarget;
import dev.morphia.query.OperationTarget;
import dev.morphia.query.Sort;
import dev.morphia.query.UpdateException;
import dev.morphia.sofia.Sofia;
import java.util.List;
import java.util.Locale;
import org.bson.Document;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/updates/PushOperator.class */
public class PushOperator extends UpdateOperator {
    private Integer position;
    private Integer slice;
    private Integer sort;
    private Document sortDocument;

    /* access modifiers changed from: package-private */
    public PushOperator(String field, List<?> values) {
        super("$push", field, values);
    }

    public PushOperator position(int position) {
        if (position < 0) {
            throw new UpdateException("The position must be at least 0.");
        }
        this.position = Integer.valueOf(position);
        return this;
    }

    public PushOperator slice(int slice) {
        this.slice = Integer.valueOf(slice);
        return this;
    }

    public PushOperator sort(int sort) {
        if (this.sortDocument != null) {
            throw new IllegalStateException(Sofia.updateSortOptions("Sort", "sort document", new Locale[0]));
        }
        this.sort = Integer.valueOf(sort);
        return this;
    }

    public PushOperator sort(Sort value) {
        if (this.sort != null) {
            throw new IllegalStateException(Sofia.updateSortOptions("Sort document", "sort", new Locale[0]));
        }
        if (this.sortDocument == null) {
            this.sortDocument = new Document();
        }
        this.sortDocument.put(value.getField(), (Object) Integer.valueOf(value.getOrder()));
        return this;
    }

    @Override // dev.morphia.query.experimental.updates.UpdateOperator
    public OperationTarget toTarget(PathTarget pathTarget) {
        Document document = new Document("$each", value());
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
        return new OperationTarget(pathTarget, document);
    }
}
