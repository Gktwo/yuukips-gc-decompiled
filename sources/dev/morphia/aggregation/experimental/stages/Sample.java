package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Sample.class */
public class Sample extends Stage {
    private final long size;

    protected Sample(long size) {
        super("$sample");
        this.size = size;
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Sample m1231of(long size) {
        return new Sample(size);
    }

    public static Sample sample(long size) {
        return new Sample(size);
    }

    public long getSize() {
        return this.size;
    }
}
