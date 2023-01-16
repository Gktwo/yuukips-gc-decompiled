package com.mongodb.client.model;

import com.mongodb.assertions.Assertions;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Field.class */
public class Field<TExpression> {
    private final String name;
    private TExpression value;

    public Field(String name, TExpression value) {
        this.name = (String) Assertions.notNull("name", name);
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public TExpression getValue() {
        return this.value;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Field)) {
            return false;
        }
        Field<?> field = (Field) o;
        if (!this.name.equals(field.name)) {
            return false;
        }
        return this.value != null ? this.value.equals(field.value) : field.value == null;
    }

    public int hashCode() {
        return (31 * this.name.hashCode()) + (this.value != null ? this.value.hashCode() : 0);
    }

    public String toString() {
        return "Field{name='" + this.name + "', value=" + this.value + '}';
    }
}
