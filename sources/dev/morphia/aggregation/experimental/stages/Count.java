package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Count.class */
public class Count extends Stage {
    private final String name;

    public Count(String name) {
        super("$count");
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}
