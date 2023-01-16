package com.mongodb.client.model.geojson;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/Position.class */
public final class Position {
    private final List<Double> values;

    public Position(List<Double> values) {
        Assertions.notNull("values", values);
        Assertions.doesNotContainNull("values", values);
        Assertions.isTrueArgument("value must contain at least two elements", values.size() >= 2);
        this.values = Collections.unmodifiableList(values);
    }

    public Position(double first, double second, double... remaining) {
        List<Double> values = new ArrayList<>();
        values.add(Double.valueOf(first));
        values.add(Double.valueOf(second));
        for (double cur : remaining) {
            values.add(Double.valueOf(cur));
        }
        this.values = Collections.unmodifiableList(values);
    }

    public List<Double> getValues() {
        return this.values;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.values.equals(((Position) o).values)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.values.hashCode();
    }

    public String toString() {
        return "Position{values=" + this.values + '}';
    }
}
