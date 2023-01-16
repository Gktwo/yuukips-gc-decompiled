package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/PlanCacheStats.class */
public class PlanCacheStats extends Stage {
    protected PlanCacheStats() {
        super("$planCacheStats");
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static PlanCacheStats m1234of() {
        return new PlanCacheStats();
    }

    public static PlanCacheStats planCacheStats() {
        return new PlanCacheStats();
    }
}
