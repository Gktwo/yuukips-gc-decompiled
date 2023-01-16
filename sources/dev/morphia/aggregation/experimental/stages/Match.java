package dev.morphia.aggregation.experimental.stages;

import dev.morphia.query.experimental.filters.Filter;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/Match.class */
public class Match extends Stage {
    private final Filter[] filters;

    protected Match(Filter... filters) {
        super("$match");
        this.filters = filters;
    }

    public static Match match(Filter... filters) {
        return new Match(filters);
    }

    @Deprecated(forRemoval = true)
    /* renamed from: on */
    public static Match m1238on(Filter... filters) {
        return new Match(filters);
    }

    public Filter[] getFilters() {
        return this.filters;
    }
}
