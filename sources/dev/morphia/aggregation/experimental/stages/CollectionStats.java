package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/CollectionStats.class */
public class CollectionStats extends Stage {
    private boolean histogram;
    private Integer scale;
    private boolean count;

    protected CollectionStats() {
        super("$collStats");
    }

    public static CollectionStats collStats() {
        return new CollectionStats();
    }

    @Deprecated(forRemoval = true)
    public static CollectionStats with() {
        return new CollectionStats();
    }

    public CollectionStats count(boolean count) {
        this.count = count;
        return this;
    }

    public boolean getCount() {
        return this.count;
    }

    public boolean getHistogram() {
        return this.histogram;
    }

    public Integer getScale() {
        return this.scale;
    }

    public CollectionStats histogram(boolean histogram) {
        this.histogram = histogram;
        return this;
    }

    public CollectionStats scale(Integer scale) {
        this.scale = scale;
        return this;
    }
}
