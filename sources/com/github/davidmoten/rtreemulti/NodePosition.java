package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.Geometry;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/NodePosition.class */
final class NodePosition<T, S extends Geometry> {
    private Node<T, S> node;
    private int position;

    /* access modifiers changed from: package-private */
    public NodePosition(Node<T, S> node, int position) {
        Preconditions.checkNotNull(node);
        this.node = node;
        this.position = position;
    }

    /* access modifiers changed from: package-private */
    public Node<T, S> node() {
        return this.node;
    }

    /* access modifiers changed from: package-private */
    public int position() {
        return this.position;
    }

    /* access modifiers changed from: package-private */
    public boolean hasRemaining() {
        return this.position != this.node.count();
    }

    /* access modifiers changed from: package-private */
    public void setPosition(int position) {
        this.position = position;
    }

    public String toString() {
        return "NodePosition [node=" + this.node + ", position=" + this.position + "]";
    }
}
