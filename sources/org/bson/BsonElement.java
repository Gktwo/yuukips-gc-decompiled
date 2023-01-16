package org.bson;

/* loaded from: grasscutter.jar:org/bson/BsonElement.class */
public class BsonElement {
    private final String name;
    private final BsonValue value;

    public BsonElement(String name, BsonValue value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public BsonValue getValue() {
        return this.value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BsonElement that = (BsonElement) o;
        if (getName() != null) {
            if (!getName().equals(that.getName())) {
                return false;
            }
        } else if (that.getName() != null) {
            return false;
        }
        if (getValue() != null) {
            if (!getValue().equals(that.getValue())) {
                return false;
            }
            return true;
        } else if (that.getValue() != null) {
            return false;
        } else {
            return true;
        }
    }

    public int hashCode() {
        return (31 * (getName() != null ? getName().hashCode() : 0)) + (getValue() != null ? getValue().hashCode() : 0);
    }
}
