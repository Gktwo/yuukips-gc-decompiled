package dev.morphia.mapping.experimental;

import dev.morphia.Datastore;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/ListReference.class */
public class ListReference<T> extends CollectionReference<List<T>> {
    private List<T> values;

    public ListReference(Datastore datastore, EntityModel model, List ids) {
        super(datastore, model, ids);
    }

    public ListReference(List<T> values) {
        this.values = values;
    }

    /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<T>, java.util.List<?> */
    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.experimental.CollectionReference
    public List<?> getValues() {
        return (List<T>) this.values;
    }

    @Override // dev.morphia.mapping.experimental.CollectionReference
    protected void setValues(List ids) {
        this.values = new ArrayList();
        this.values.addAll(ids);
        resolve();
    }

    @Override // dev.morphia.mapping.experimental.CollectionReference, dev.morphia.mapping.experimental.MorphiaReference
    public List<T> get() {
        if (this.values == null) {
            this.values = find();
        }
        return this.values;
    }
}
