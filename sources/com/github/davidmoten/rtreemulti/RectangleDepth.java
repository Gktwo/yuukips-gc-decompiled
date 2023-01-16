package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Rectangle;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/RectangleDepth.class */
final class RectangleDepth {
    private final Rectangle rectangle;
    private final int depth;

    /* access modifiers changed from: package-private */
    public RectangleDepth(Rectangle rectangle, int depth) {
        this.rectangle = rectangle;
        this.depth = depth;
    }

    /* access modifiers changed from: package-private */
    public Rectangle getRectangle() {
        return this.rectangle;
    }

    /* access modifiers changed from: package-private */
    public int getDepth() {
        return this.depth;
    }
}
