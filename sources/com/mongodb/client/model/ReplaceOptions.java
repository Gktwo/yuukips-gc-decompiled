package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/ReplaceOptions.class */
public class ReplaceOptions {
    private boolean upsert;
    private Boolean bypassDocumentValidation;
    private Collation collation;
    private Bson hint;
    private String hintString;

    public boolean isUpsert() {
        return this.upsert;
    }

    public ReplaceOptions upsert(boolean upsert) {
        this.upsert = upsert;
        return this;
    }

    @Nullable
    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public ReplaceOptions bypassDocumentValidation(@Nullable Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public ReplaceOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    public ReplaceOptions hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public ReplaceOptions hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    public String toString() {
        return "ReplaceOptions{upsert=" + this.upsert + ", bypassDocumentValidation=" + this.bypassDocumentValidation + ", collation=" + this.collation + ", hint=" + this.hint + ", hintString=" + this.hintString + '}';
    }
}
