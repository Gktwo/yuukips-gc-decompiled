package com.mongodb;

import com.mongodb.assertions.Assertions;
import com.mongodb.lang.Nullable;
import java.io.Serializable;

/* loaded from: grasscutter.jar:com/mongodb/DBRef.class */
public class DBRef implements Serializable {
    private static final long serialVersionUID = -849581217713362618L;

    /* renamed from: id */
    private final Object f427id;
    private final String collectionName;
    private final String databaseName;

    public DBRef(String collectionName, Object id) {
        this(null, collectionName, id);
    }

    public DBRef(@Nullable String databaseName, String collectionName, Object id) {
        this.f427id = Assertions.notNull("id", id);
        this.collectionName = (String) Assertions.notNull("collectionName", collectionName);
        this.databaseName = databaseName;
    }

    public Object getId() {
        return this.f427id;
    }

    public String getCollectionName() {
        return this.collectionName;
    }

    @Nullable
    public String getDatabaseName() {
        return this.databaseName;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DBRef dbRef = (DBRef) o;
        if (!this.f427id.equals(dbRef.f427id) || !this.collectionName.equals(dbRef.collectionName)) {
            return false;
        }
        if (this.databaseName != null) {
            if (!this.databaseName.equals(dbRef.databaseName)) {
                return false;
            }
            return true;
        } else if (dbRef.databaseName != null) {
            return false;
        } else {
            return true;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * this.f427id.hashCode()) + this.collectionName.hashCode())) + (this.databaseName != null ? this.databaseName.hashCode() : 0);
    }

    @Override // java.lang.Object
    public String toString() {
        return "{ \"$ref\" : \"" + this.collectionName + "\", \"$id\" : \"" + this.f427id + "\"" + (this.databaseName == null ? "" : ", \"$db\" : \"" + this.databaseName + "\"") + " }";
    }
}
