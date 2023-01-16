package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Skip.class */
public class Skip extends Stage {
    private final long size;

    protected Skip(long size) {
        super("$skip");
        this.size = size;
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static Skip m1230of(long size) {
        return new Skip(size);
    }

    public static Skip skip(long size) {
        return new Skip(size);
    }

    public long getSize() {
        return this.size;
    }
}
