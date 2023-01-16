package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.Lists;
import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.guavamini.annotations.VisibleForTesting;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.geometry.Point;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import com.github.davidmoten.rtreemulti.internal.Comparators;
import com.github.davidmoten.rtreemulti.internal.NodeAndEntries;
import com.github.davidmoten.rtreemulti.internal.util.BoundedPriorityQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/RTree.class */
public final class RTree<T, S extends Geometry> {
    private final Optional<? extends Node<T, S>> root;
    private final Context<T, S> context;
    public static final int MAX_CHILDREN_DEFAULT_GUTTMAN = 4;
    public static final int MAX_CHILDREN_DEFAULT_STAR = 4;
    private final int size;
    private static final Predicate<Geometry> ALWAYS_TRUE = new Predicate<Geometry>() { // from class: com.github.davidmoten.rtreemulti.RTree.2
        public boolean test(Geometry rectangle) {
            return true;
        }
    };
    private static final String marginIncrement = "  ";

    public RTree(Optional<? extends Node<T, S>> root, int size, Context<T, S> context) {
        this.root = root;
        this.size = size;
        this.context = context;
    }

    private RTree(Node<T, S> root, int size, Context<T, S> context) {
        this(Optional.of(root), size, context);
    }

    public static <T, S extends Geometry> RTree<T, S> create() {
        return new Builder().create();
    }

    public static <T, S extends Geometry> RTree<T, S> create(int dimensions) {
        return new Builder().dimensions(dimensions).create();
    }

    public static Builder dimensions(int dimensions) {
        return new Builder().dimensions(dimensions);
    }

    public int calculateDepth() {
        return calculateDepth(this.root);
    }

    private static <T, S extends Geometry> int calculateDepth(Optional<? extends Node<T, S>> root) {
        if (!root.isPresent()) {
            return 0;
        }
        return calculateDepth((Node) root.get(), 0);
    }

    private static <T, S extends Geometry> int calculateDepth(Node<T, S> node, int depth) {
        if (node.isLeaf()) {
            return depth + 1;
        }
        return calculateDepth(((NonLeaf) node).child(0), depth + 1);
    }

    public static Builder minChildren(int minChildren) {
        return new Builder().minChildren(minChildren);
    }

    public static Builder maxChildren(int maxChildren) {
        return new Builder().maxChildren(maxChildren);
    }

    public static Builder splitter(Splitter splitter) {
        return new Builder().splitter(splitter);
    }

    public static Builder selector(Selector selector) {
        return new Builder().selector(selector);
    }

    public static Builder star() {
        return new Builder().star();
    }

    /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/RTree$Builder.class */
    public static class Builder {
        private static final double DEFAULT_FILLING_FACTOR = 0.4d;
        private static final double DEFAULT_LOADING_FACTOR = 0.7d;
        private Optional<Integer> maxChildren;
        private Optional<Integer> minChildren;
        private Splitter splitter;
        private Selector selector;
        private double loadingFactor;
        private boolean star;
        private Factory<Object, Geometry> factory;
        private int dimensions;

        private Builder() {
            this.maxChildren = Optional.empty();
            this.minChildren = Optional.empty();
            this.splitter = SplitterQuadratic.INSTANCE;
            this.selector = SelectorMinimalVolumeIncrease.INSTANCE;
            this.loadingFactor = DEFAULT_LOADING_FACTOR;
            this.star = false;
            this.factory = Factory.defaultFactory();
            this.dimensions = 2;
        }

        public Builder dimensions(int dimensions) {
            Preconditions.checkArgument(dimensions >= 2, "dimensions must be 2 or more");
            this.dimensions = dimensions;
            return this;
        }

        public Builder loadingFactor(double factor) {
            this.loadingFactor = factor;
            return this;
        }

        public Builder minChildren(int minChildren) {
            this.minChildren = Optional.of(Integer.valueOf(minChildren));
            return this;
        }

        public Builder maxChildren(int maxChildren) {
            this.maxChildren = Optional.of(Integer.valueOf(maxChildren));
            return this;
        }

        public Builder splitter(Splitter splitter) {
            this.splitter = splitter;
            return this;
        }

        public Builder selector(Selector selector) {
            this.selector = selector;
            return this;
        }

        public Builder star() {
            this.selector = SelectorRStar.INSTANCE;
            this.splitter = SplitterRStar.INSTANCE;
            this.star = true;
            return this;
        }

        public Builder factory(Factory<?, ? extends Geometry> factory) {
            this.factory = factory;
            return this;
        }

        public <T, S extends Geometry> RTree<T, S> create() {
            setDefaultCapacity();
            return new RTree<>(Optional.empty(), 0, new Context(this.dimensions, this.minChildren.get().intValue(), this.maxChildren.get().intValue(), this.selector, this.splitter, this.factory));
        }

        public <T, S extends Geometry> RTree<T, S> create(List<Entry<T, S>> entries) {
            setDefaultCapacity();
            return packingSTR(entries, true, entries.size(), new Context<>(this.dimensions, this.minChildren.get().intValue(), this.maxChildren.get().intValue(), this.selector, this.splitter, this.factory));
        }

        private void setDefaultCapacity() {
            if (!this.maxChildren.isPresent()) {
                if (this.star) {
                    this.maxChildren = Optional.of(4);
                } else {
                    this.maxChildren = Optional.of(4);
                }
            }
            if (!this.minChildren.isPresent()) {
                this.minChildren = Optional.of(Integer.valueOf((int) Math.round(((double) this.maxChildren.get().intValue()) * DEFAULT_FILLING_FACTOR)));
            }
        }

        private <T, S extends Geometry> RTree<T, S> packingSTR(List<? extends HasGeometry> objects, boolean isLeaf, int size, Context<T, S> context) {
            Node<T, S> root;
            int capacity = (int) Math.round(((double) this.maxChildren.get().intValue()) * this.loadingFactor);
            int nodeCount = (int) Math.ceil((1.0d * ((double) objects.size())) / ((double) capacity));
            if (nodeCount == 0) {
                return create();
            }
            if (nodeCount == 1) {
                if (isLeaf) {
                    root = context.factory().createLeaf(objects, context);
                } else {
                    root = context.factory().createNonLeaf(objects, context);
                }
                return new RTree<>(Optional.of(root), size, context);
            }
            int sliceCapacity = ((int) Math.ceil(Math.sqrt((double) nodeCount))) * capacity;
            int sliceCount = (int) Math.ceil((1.0d * ((double) objects.size())) / ((double) sliceCapacity));
            Collections.sort(objects, new MidComparator(0));
            List<Node<T, S>> nodes = new ArrayList<>(nodeCount);
            for (int s = 0; s < sliceCount; s++) {
                List slice = objects.subList(s * sliceCapacity, Math.min((s + 1) * sliceCapacity, objects.size()));
                Collections.sort(slice, new MidComparator(1));
                for (int i = 0; i < slice.size(); i += capacity) {
                    if (isLeaf) {
                        nodes.add(context.factory().createLeaf(slice.subList(i, Math.min(slice.size(), i + capacity)), context));
                    } else {
                        nodes.add(context.factory().createNonLeaf(slice.subList(i, Math.min(slice.size(), i + capacity)), context));
                    }
                }
            }
            return packingSTR(nodes, false, size, context);
        }

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/RTree$Builder$MidComparator.class */
        public static final class MidComparator implements Comparator<HasGeometry> {
            private final int dimension;

            public MidComparator(int dimension) {
                this.dimension = dimension;
            }

            public int compare(HasGeometry o1, HasGeometry o2) {
                return Double.compare(mid(o1), mid(o2));
            }

            private double mid(HasGeometry o) {
                Rectangle mbr = o.geometry().mbr();
                return (mbr.min(this.dimension) + mbr.max(this.dimension)) / 2.0d;
            }
        }
    }

    public RTree<T, S> add(Entry<? extends T, ? extends S> entry) {
        Node<T, S> node;
        Preconditions.checkArgument(dimensions() == entry.geometry().dimensions(), entry + " has wrong number of dimensions, expected " + dimensions());
        if (!this.root.isPresent()) {
            return new RTree<>(this.context.factory().createLeaf(Lists.newArrayList(entry), this.context), this.size + 1, this.context);
        }
        List<Node<T, S>> nodes = ((Node) this.root.get()).add(entry);
        if (nodes.size() == 1) {
            node = nodes.get(0);
        } else {
            node = this.context.factory().createNonLeaf(nodes, this.context);
        }
        return new RTree<>(node, this.size + 1, this.context);
    }

    public RTree<T, S> add(T value, S geometry) {
        return add(this.context.factory().createEntry(value, geometry));
    }

    public RTree<T, S> add(Iterable<Entry<T, S>> entries) {
        RTree<T, S> tree = this;
        for (Entry<T, S> entry : entries) {
            tree = tree.add(entry);
        }
        return tree;
    }

    public RTree<T, S> delete(Iterable<Entry<T, S>> entries, boolean all) {
        RTree<T, S> tree = this;
        for (Entry<T, S> entry : entries) {
            tree = tree.delete(entry, all);
        }
        return tree;
    }

    public RTree<T, S> delete(Iterable<Entry<T, S>> entries) {
        RTree<T, S> tree = this;
        for (Entry<T, S> entry : entries) {
            tree = tree.delete(entry);
        }
        return tree;
    }

    public RTree<T, S> delete(T value, S geometry, boolean all) {
        return delete(this.context.factory().createEntry(value, geometry), all);
    }

    public RTree<T, S> delete(T value, S geometry) {
        return delete((Entry) this.context.factory().createEntry(value, geometry), false);
    }

    public RTree<T, S> delete(Entry<? extends T, ? extends S> entry, boolean all) {
        if (!this.root.isPresent()) {
            return this;
        }
        NodeAndEntries<T, S> nodeAndEntries = ((Node) this.root.get()).delete(entry, all);
        if (!nodeAndEntries.node().isPresent() || nodeAndEntries.node().get() != this.root.get()) {
            return new RTree(nodeAndEntries.node(), (this.size - nodeAndEntries.countDeleted()) - nodeAndEntries.entriesToAdd().size(), this.context).add(nodeAndEntries.entriesToAdd());
        }
        return this;
    }

    public RTree<T, S> delete(Entry<? extends T, ? extends S> entry) {
        return delete((Entry) entry, false);
    }

    @VisibleForTesting
    Iterable<Entry<T, S>> search(Predicate<? super Geometry> condition) {
        if (this.root.isPresent()) {
            return Search.search((Node) this.root.get(), condition);
        }
        return Collections.emptyList();
    }

    public static Predicate<Geometry> intersects(final Rectangle r) {
        return new Predicate<Geometry>() { // from class: com.github.davidmoten.rtreemulti.RTree.1
            public boolean test(Geometry g) {
                return g.intersects(r);
            }
        };
    }

    public Iterable<Entry<T, S>> search(Rectangle r) {
        return search(intersects(r));
    }

    public Iterable<Entry<T, S>> search(Point p) {
        return search(p.mbr());
    }

    public <R extends Geometry> Iterable<Entry<T, S>> search(R g, BiPredicate<? super S, ? super R> intersects) {
        return Iterables.filter(search(g.mbr()), entry -> {
            return intersects.test(entry.geometry(), g);
        });
    }

    public Iterable<Entry<T, S>> search(final Rectangle r, final double maxDistance) {
        return search(new Predicate<Geometry>() { // from class: com.github.davidmoten.rtreemulti.RTree.3
            public boolean test(Geometry g) {
                return g.distance(r) < maxDistance;
            }
        });
    }

    public Iterable<Entry<T, S>> search(Point p, double maxDistance) {
        return search(p.mbr(), maxDistance);
    }

    public <R extends Geometry> Iterable<Entry<T, S>> search(R g, double maxDistance, BiFunction<? super S, ? super R, Double> distance) {
        return Iterables.filter(search(entry -> {
            return entry.distance(g.mbr()) < maxDistance;
        }), entry -> {
            return ((Double) distance.apply(entry.geometry(), g)).doubleValue() < maxDistance;
        });
    }

    public Iterable<Entry<T, S>> nearest(Rectangle r, double maxDistance, int maxCount) {
        BoundedPriorityQueue<Entry<T, S>> q = new BoundedPriorityQueue<>(maxCount, Comparators.ascendingDistance(r));
        for (Entry<T, S> entry : search(r, maxDistance)) {
            q.add(entry);
        }
        return q.asOrderedList();
    }

    public Iterable<Entry<T, S>> nearest(Point p, double maxDistance, int maxCount) {
        return nearest(p.mbr(), maxDistance, maxCount);
    }

    public Iterable<Entry<T, S>> entries() {
        return search(ALWAYS_TRUE);
    }

    public Visualizer visualize(int width, int height, Rectangle view) {
        return new Visualizer(this, width, height, view);
    }

    public Visualizer visualize(int width, int height) {
        return visualize(width, height, calculateMaxView(this));
    }

    private Rectangle calculateMaxView(RTree<T, S> tree) {
        Rectangle r = null;
        for (Entry<T, S> entry : tree.entries()) {
            if (r != null) {
                r = r.add(entry.geometry().mbr());
            } else {
                r = entry.geometry().mbr();
            }
        }
        if (r != null) {
            return r;
        }
        double[] zero = new double[this.context.dimensions()];
        return Rectangle.create(zero, zero);
    }

    public Optional<? extends Node<T, S>> root() {
        return this.root;
    }

    public Optional<Rectangle> mbr() {
        if (!this.root.isPresent()) {
            return Optional.empty();
        }
        return Optional.of(((Node) this.root.get()).geometry().mbr());
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return this.size;
    }

    public Context<T, S> context() {
        return this.context;
    }

    public String asString() {
        if (!this.root.isPresent()) {
            return "";
        }
        return asString((Node) this.root.get(), "");
    }

    private String asString(Node<T, S> node, String margin) {
        StringBuilder s = new StringBuilder();
        s.append(margin);
        s.append("mbr=");
        s.append(node.geometry());
        s.append('\n');
        if (!node.isLeaf()) {
            NonLeaf<T, S> n = (NonLeaf) node;
            for (int i = 0; i < n.count(); i++) {
                s.append(asString(n.child(i), margin + marginIncrement));
            }
        } else {
            for (Entry<T, S> entry : ((Leaf) node).entries()) {
                s.append(margin);
                s.append(marginIncrement);
                s.append("entry=");
                s.append(entry);
                s.append('\n');
            }
        }
        return s.toString();
    }

    public int dimensions() {
        return this.context.dimensions();
    }

    public void visit(Visitor<T, S> visitor) {
        if (this.root.isPresent()) {
            visit((Node) this.root.get(), visitor);
        }
    }

    private void visit(Node<T, S> node, Visitor<T, S> visitor) {
        if (node.isLeaf()) {
            visit((Leaf) ((Leaf) node), (Visitor) visitor);
        } else {
            visit((NonLeaf) ((NonLeaf) node), (Visitor) visitor);
        }
    }

    private void visit(Leaf<T, S> leaf, Visitor<T, S> visitor) {
        visitor.leaf(leaf);
    }

    private void visit(NonLeaf<T, S> nonLeaf, Visitor<T, S> visitor) {
        visitor.nonLeaf(nonLeaf);
        for (Node<T, S> node : nonLeaf.children()) {
            visit(node, visitor);
        }
    }
}
