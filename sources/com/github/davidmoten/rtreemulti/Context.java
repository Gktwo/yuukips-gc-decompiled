package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.Geometry;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Context.class */
public final class Context<T, S extends Geometry> {
    private final int dimensions;
    private final int maxChildren;
    private final int minChildren;
    private final Splitter splitter;
    private final Selector selector;
    private final Factory<T, S> factory;

    public Context(int dimensions, int minChildren, int maxChildren, Selector selector, Splitter splitter, Factory<T, S> factory) {
        Preconditions.checkNotNull(splitter);
        Preconditions.checkNotNull(selector);
        Preconditions.checkArgument(maxChildren > 2, "maxChildren must be greater than 2");
        Preconditions.checkArgument(minChildren >= 1, "minChildren must be greater than 0");
        Preconditions.checkArgument(minChildren < maxChildren, "minChildren must be less than maxChildren");
        Preconditions.checkNotNull(factory);
        Preconditions.checkArgument(dimensions > 1, "dimensions must be greater than 1");
        this.dimensions = dimensions;
        this.selector = selector;
        this.maxChildren = maxChildren;
        this.minChildren = minChildren;
        this.splitter = splitter;
        this.factory = factory;
    }

    public int maxChildren() {
        return this.maxChildren;
    }

    public int minChildren() {
        return this.minChildren;
    }

    public Splitter splitter() {
        return this.splitter;
    }

    public Selector selector() {
        return this.selector;
    }

    public Factory<T, S> factory() {
        return this.factory;
    }

    public int dimensions() {
        return this.dimensions;
    }
}
