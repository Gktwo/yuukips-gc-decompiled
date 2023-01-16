package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/CreateCollectionOptions.class */
public class CreateCollectionOptions {
    private long maxDocuments;
    private boolean capped;
    private long sizeInBytes;
    private Bson storageEngineOptions;
    private IndexOptionDefaults indexOptionDefaults = new IndexOptionDefaults();
    private ValidationOptions validationOptions = new ValidationOptions();
    private Collation collation;

    public long getMaxDocuments() {
        return this.maxDocuments;
    }

    public CreateCollectionOptions maxDocuments(long maxDocuments) {
        this.maxDocuments = maxDocuments;
        return this;
    }

    public boolean isCapped() {
        return this.capped;
    }

    public CreateCollectionOptions capped(boolean capped) {
        this.capped = capped;
        return this;
    }

    public long getSizeInBytes() {
        return this.sizeInBytes;
    }

    public CreateCollectionOptions sizeInBytes(long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
        return this;
    }

    @Nullable
    public Bson getStorageEngineOptions() {
        return this.storageEngineOptions;
    }

    public CreateCollectionOptions storageEngineOptions(@Nullable Bson storageEngineOptions) {
        this.storageEngineOptions = storageEngineOptions;
        return this;
    }

    public IndexOptionDefaults getIndexOptionDefaults() {
        return this.indexOptionDefaults;
    }

    public CreateCollectionOptions indexOptionDefaults(IndexOptionDefaults indexOptionDefaults) {
        this.indexOptionDefaults = (IndexOptionDefaults) Assertions.notNull("indexOptionDefaults", indexOptionDefaults);
        return this;
    }

    public ValidationOptions getValidationOptions() {
        return this.validationOptions;
    }

    public CreateCollectionOptions validationOptions(ValidationOptions validationOptions) {
        this.validationOptions = (ValidationOptions) Assertions.notNull("validationOptions", validationOptions);
        return this;
    }

    @Nullable
    public Collation getCollation() {
        return this.collation;
    }

    public CreateCollectionOptions collation(@Nullable Collation collation) {
        this.collation = collation;
        return this;
    }

    public String toString() {
        return "CreateCollectionOptions{, maxDocuments=" + this.maxDocuments + ", capped=" + this.capped + ", sizeInBytes=" + this.sizeInBytes + ", storageEngineOptions=" + this.storageEngineOptions + ", indexOptionDefaults=" + this.indexOptionDefaults + ", validationOptions=" + this.validationOptions + ", collation=" + this.collation + '}';
    }
}
