package com.mongodb.client.model;

import com.mongodb.lang.Nullable;

/* loaded from: grasscutter.jar:com/mongodb/client/model/InsertManyOptions.class */
public final class InsertManyOptions {
    private boolean ordered = true;
    private Boolean bypassDocumentValidation;

    public boolean isOrdered() {
        return this.ordered;
    }

    public InsertManyOptions ordered(boolean ordered) {
        this.ordered = ordered;
        return this;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public InsertManyOptions bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public String toString() {
        return "InsertManyOptions{ordered=" + this.ordered + ", bypassDocumentValidation=" + this.bypassDocumentValidation + '}';
    }
}
