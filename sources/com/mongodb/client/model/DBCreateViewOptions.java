package com.mongodb.client.model;

/* loaded from: grasscutter.jar:com/mongodb/client/model/DBCreateViewOptions.class */
public class DBCreateViewOptions {
    private Collation collation;

    public Collation getCollation() {
        return this.collation;
    }

    public DBCreateViewOptions collation(Collation collation) {
        this.collation = collation;
        return this;
    }
}
