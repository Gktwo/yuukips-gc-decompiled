package dev.morphia.aggregation.experimental.stages;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Facet.class */
public class Facet extends Stage {
    private final LinkedHashMap<String, List<Stage>> fields = new LinkedHashMap<>();

    protected Facet() {
        super("$facet");
    }

    public static Facet facet() {
        return new Facet();
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Facet m1250of() {
        return new Facet();
    }

    public Facet field(String name, Stage... stages) {
        this.fields.put(name, Arrays.asList(stages));
        return this;
    }

    public Map<String, List<Stage>> getFields() {
        return this.fields;
    }
}
