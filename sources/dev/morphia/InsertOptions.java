package dev.morphia;

import com.mongodb.WriteConcern;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/InsertOptions.class */
public class InsertOptions {
    private WriteConcern writeConcern;
    private boolean ordered = true;
    private Boolean bypassDocumentValidation;

    /* access modifiers changed from: package-private */
    public InsertOneOptions toInsertOneOptions() {
        return new InsertOneOptions().bypassDocumentValidation(this.bypassDocumentValidation);
    }

    /* access modifiers changed from: package-private */
    public InsertManyOptions toInsertManyOptions() {
        return new InsertManyOptions().bypassDocumentValidation(this.bypassDocumentValidation).ordered(this.ordered);
    }

    public InsertOptions writeConcern(WriteConcern writeConcern) {
        this.writeConcern = writeConcern;
        return this;
    }

    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    public Boolean getBypassDocumentValidation() {
        return this.bypassDocumentValidation;
    }

    public InsertOptions bypassDocumentValidation(Boolean bypassDocumentValidation) {
        this.bypassDocumentValidation = bypassDocumentValidation;
        return this;
    }

    public InsertOptions ordered(boolean ordered) {
        this.ordered = ordered;
        return this;
    }

    public boolean isOrdered() {
        return this.ordered;
    }
}
