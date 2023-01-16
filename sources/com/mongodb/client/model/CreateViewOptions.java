package com.mongodb.client.model;

import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CreateViewOptions.class */
public class CreateViewOptions {
    private Collation collation;

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public CreateViewOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    public String toString() {
        return "CreateViewOptions{collation=" + this.collation + '}';
    }
}
