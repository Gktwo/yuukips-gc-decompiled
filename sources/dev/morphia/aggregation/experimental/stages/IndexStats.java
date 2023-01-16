package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/IndexStats.class */
public class IndexStats extends Stage {
    protected IndexStats() {
        super("$indexStats");
    }

    public static IndexStats indexStats() {
        return new IndexStats();
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static IndexStats m1241of() {
        return new IndexStats();
    }
}
