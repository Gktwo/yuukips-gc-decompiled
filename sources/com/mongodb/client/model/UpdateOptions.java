package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import java.util.List;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/UpdateOptions.class */
public class UpdateOptions {
    private boolean upsert;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private List<? extends Bson> arrayFilters;
    private Bson hint;
    private String hintString;

    public boolean isUpsert() {
        return this.upsert;
    }

    public UpdateOptions upsert(boolean upsert) {
        this.upsert = upsert;
        return this;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public UpdateOptions bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public UpdateOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    public UpdateOptions arrayFilters(@Nullable List<? extends Bson> arrayFilters) {
        this.arrayFilters = arrayFilters;
        return this;
    }

    @Nullable
    public List<? extends Bson> getArrayFilters() {
        return this.arrayFilters;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    public UpdateOptions hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public UpdateOptions hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    public String toString() {
        return "UpdateOptions{upsert=" + this.upsert + ", bypassDocumentValidation=" + this.bypassDocumentValidation + ", collation=" + this.collation + ", arrayFilters=" + this.arrayFilters + ", hint=" + this.hint + ", hintString=" + this.hintString + '}';
    }
}
