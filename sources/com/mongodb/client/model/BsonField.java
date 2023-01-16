package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/BsonField.class */
public final class BsonField {
    private final String name;
    private final Bson value;

    public BsonField(String name, Bson value) {
        this.name = (String) Assertions.notNull("name", name);
        this.value = (Bson) Assertions.notNull("value", value);
    }

    public String getName() {
        return this.name;
    }

    public Bson getValue() {
        return this.value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BsonField bsonField = (BsonField) o;
        if (!this.name.equals(bsonField.name)) {
            return false;
        }
        return this.value.equals(bsonField.value);
    }

    public int hashCode() {
        return (31 * this.name.hashCode()) + this.value.hashCode();
    }

    public String toString() {
        return "BsonField{name='" + this.name + "', value=" + this.value + '}';
    }
}
