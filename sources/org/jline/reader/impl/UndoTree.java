package org.jline.reader.impl;

import java.util.function.Consumer;

/* loaded from: grasscutter.jar:org/jline/reader/impl/UndoTree.class */
public class UndoTree<T> {
    private final Consumer<T> state;
    private final UndoTree<T>.Node parent = new Node(null);
    private UndoTree<T>.Node current;

    public UndoTree(Consumer<T> s) {
        this.state = s;
        ((Node) this.parent).left = this.parent;
        clear();
    }

    public void clear() {
        this.current = this.parent;
    }

    public void newState(T state) {
        UndoTree<T>.Node node = new Node(state);
        ((Node) this.current).right = node;
        ((Node) node).left = this.current;
        this.current = node;
    }

    public boolean canUndo() {
        return ((Node) this.current).left != this.parent;
    }

    public boolean canRedo() {
        return ((Node) this.current).right != null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.function.Consumer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void undo() {
        if (!canUndo()) {
            throw new IllegalStateException("Cannot undo.");
        }
        this.current = ((Node) this.current).left;
        this.state.accept(((Node) this.current).state);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v4, resolved type: java.util.function.Consumer<T> */
    /* JADX WARN: Multi-variable type inference failed */
    public void redo() {
        if (!canRedo()) {
            throw new IllegalStateException("Cannot redo.");
        }
        this.current = ((Node) this.current).right;
        this.state.accept(((Node) this.current).state);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/UndoTree$Node.class */
    public class Node {
        private final T state;
        private UndoTree<T>.Node left = null;
        private UndoTree<T>.Node right = null;

        public Node(T s) {
            this.state = s;
        }
    }
}
