package com.mongodb.client.model;

import com.mongodb.lang.Nullable;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/DeleteOptions.class */
public class DeleteOptions {
    private Bson hint;
    private String hintString;
    private Collation collation;

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public DeleteOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    @Nullable
    public Bson getHint() {
        return this.hint;
    }

    @Nullable
    public String getHintString() {
        return this.hintString;
    }

    public DeleteOptions hint(@Nullable Bson hint) {
        this.hint = hint;
        return this;
    }

    public DeleteOptions hintString(@Nullable String hint) {
        this.hintString = hint;
        return this;
    }

    public String toString() {
        return "DeleteOptions{collation=" + this.collation + ", hint=" + this.hint + ", hintString='" + this.hintString + "'}";
    }
}
