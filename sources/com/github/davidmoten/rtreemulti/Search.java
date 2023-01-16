package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Search.class */
final class Search {
    private Search() {
    }

    /* access modifiers changed from: package-private */
    public static <T, S extends Geometry> Iterable<Entry<T, S>> search(Node<T, S> node, Predicate<? super Geometry> condition) {
        return new SearchIterable(node, condition);
    }

    /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Search$SearchIterable.class */
    static final class SearchIterable<T, S extends Geometry> implements Iterable<Entry<T, S>> {
        private final Node<T, S> node;
        private final Predicate<? super Geometry> condition;

        SearchIterable(Node<T, S> node, Predicate<? super Geometry> condition) {
            this.node = node;
            this.condition = condition;
        }

        @Override // java.lang.Iterable
        public Iterator<Entry<T, S>> iterator() {
            return new SearchIterator(this.node, this.condition);
        }
    }

    /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Search$SearchIterator.class */
    static final class SearchIterator<T, S extends Geometry> implements Iterator<Entry<T, S>> {
        private final Predicate<? super Geometry> condition;
        private final Deque<NodePosition<T, S>> stack = new LinkedList();
        private Entry<T, S> next;

        SearchIterator(Node<T, S> node, Predicate<? super Geometry> condition) {
            this.condition = condition;
            this.stack.push(new NodePosition<>(node, 0));
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            load();
            return this.next != null;
        }

        @Override // java.util.Iterator
        public Entry<T, S> next() {
            load();
            if (this.next == null) {
                throw new NoSuchElementException();
            }
            Entry<T, S> v = this.next;
            this.next = null;
            return v;
        }

        private void load() {
            if (this.next == null) {
                this.next = search();
            }
        }

        private Entry<T, S> search() {
            while (!this.stack.isEmpty()) {
                NodePosition<T, S> np = this.stack.peek();
                if (!np.hasRemaining()) {
                    searchAfterLastInNode();
                } else if (!np.node().isLeaf()) {
                    searchNonLeaf(np);
                } else {
                    Entry<T, S> v = searchLeaf(np);
                    if (v != null) {
                        return v;
                    }
                }
            }
            return null;
        }

        private Entry<T, S> searchLeaf(NodePosition<T, S> np) {
            int i = np.position();
            Leaf<T, S> leaf = (Leaf) np.node();
            do {
                Entry<T, S> entry = leaf.entry(i);
                if (this.condition.test(entry.geometry())) {
                    np.setPosition(i + 1);
                    return entry;
                }
                i++;
            } while (i < leaf.count());
            np.setPosition(i);
            return null;
        }

        private void searchNonLeaf(NodePosition<T, S> np) {
            Node<T, S> child = ((NonLeaf) np.node()).child(np.position());
            if (this.condition.test(child.geometry())) {
                this.stack.push(new NodePosition<>(child, 0));
            } else {
                np.setPosition(np.position() + 1);
            }
        }

        private void searchAfterLastInNode() {
            this.stack.pop();
            if (!this.stack.isEmpty()) {
                NodePosition<T, S> previous = this.stack.peek();
                previous.setPosition(previous.position() + 1);
            }
        }
    }
}
