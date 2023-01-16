package dev.morphia.mapping.experimental;

import dev.morphia.Datastore;
import dev.morphia.mapping.codec.pojo.EntityModel;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* loaded from: grasscutter.jar:dev/morphia/mapping/experimental/SetReference.class */
public class SetReference<T> extends CollectionReference<Set<T>> {
    private Set<T> values;

    public SetReference(Datastore datastore, EntityModel entityModel, List ids) {
        super(datastore, entityModel, ids);
    }

    public SetReference(Set<T> values) {
        this.values = values;
    }

    /* access modifiers changed from: package-private */
    @Override // dev.morphia.mapping.experimental.CollectionReference
    public Set<T> getValues() {
        return this.values;
    }

    @Override // dev.morphia.mapping.experimental.CollectionReference
    protected void setValues(List ids) {
        this.values = new LinkedHashSet();
        this.values.addAll(ids);
        resolve();
    }

    @Override // dev.morphia.mapping.experimental.CollectionReference, dev.morphia.mapping.experimental.MorphiaReference
    public Set<T> get() {
        if (this.values == null) {
            this.values = new LinkedHashSet(find());
        }
        return this.values;
    }
}
