package com.mongodb.client.model;

import java.util.Arrays;
import java.util.List;
import org.bson.conversions.Bson;

/* loaded from: grasscutter.jar:com/mongodb/client/model/Facet.class */
public class Facet {
    private final String name;
    private final List<? extends Bson> pipeline;

    public Facet(String name, List<? extends Bson> pipeline) {
        this.name = name;
        this.pipeline = pipeline;
    }

    public Facet(String name, Bson... pipeline) {
        this(name, Arrays.asList(pipeline));
    }

    public String getName() {
        return this.name;
    }

    public List<? extends Bson> getPipeline() {
        return this.pipeline;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Facet facet = (Facet) o;
        if (this.name != null) {
            if (!this.name.equals(facet.name)) {
                return false;
            }
        } else if (facet.name != null) {
            return false;
        }
        return this.pipeline != null ? this.pipeline.equals(facet.pipeline) : facet.pipeline == null;
    }

    public int hashCode() {
        return (31 * (this.name != null ? this.name.hashCode() : 0)) + (this.pipeline != null ? this.pipeline.hashCode() : 0);
    }

    public String toString() {
        return "Facet{name='" + this.name + "', pipeline=" + this.pipeline + '}';
    }
}
