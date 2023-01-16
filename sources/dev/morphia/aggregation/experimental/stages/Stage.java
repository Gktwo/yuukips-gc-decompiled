package dev.morphia.aggregation.experimental.stages;

import dev.morphia.aggregation.experimental.Aggregation;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Stage.class */
public abstract class Stage {
    private final String stageName;
    private Aggregation<?> aggregation;

    /* access modifiers changed from: protected */
    public Stage(String stageName) {
        this.stageName = stageName;
    }

    public Stage aggregation(Aggregation<?> aggregation) {
        this.aggregation = aggregation;
        return this;
    }

    public String stageName() {
        return this.stageName;
    }

    Aggregation<?> aggregation() {
        return this.aggregation;
    }
}
