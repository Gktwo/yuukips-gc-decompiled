package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;

/* loaded from: grasscutter.jar:com/mongodb/client/model/InsertOneModel.class */
public final class InsertOneModel<T> extends WriteModel<T> {
    private final T document;

    public InsertOneModel(T document) {
        this.document = (T) Assertions.notNull("document", document);
    }

    public T getDocument() {
        return this.document;
    }

    public String toString() {
        return "InsertOneModel{document=" + this.document + '}';
    }
}
