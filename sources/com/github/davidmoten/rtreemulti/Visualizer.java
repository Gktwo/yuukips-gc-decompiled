package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Visualizer.class */
public final class Visualizer {
    private final RTree<?, Geometry> tree;
    private final int width;
    private final int height;
    private final Rectangle view;
    private final int maxDepth;

    /* access modifiers changed from: package-private */
    public Visualizer(RTree<?, Geometry> tree, int width, int height, Rectangle view) {
        Preconditions.checkArgument(tree.dimensions() == 2, "visualizer only supported for 2 dimensions");
        this.tree = tree;
        this.width = width;
        this.height = height;
        this.view = view;
        this.maxDepth = calculateMaxDepth(tree.root());
    }

    private static <R, S extends Geometry> int calculateMaxDepth(Optional<? extends Node<R, S>> root) {
        if (!root.isPresent()) {
            return 0;
        }
        return calculateDepth((Node) root.get(), 0);
    }

    private static <R, S extends Geometry> int calculateDepth(Node<R, S> node, int depth) {
        if (node.isLeaf()) {
            return depth + 1;
        }
        return calculateDepth(((NonLeaf) node).child(0), depth + 1);
    }

    public BufferedImage createImage() {
        BufferedImage image = new BufferedImage(this.width, this.height, 2);
        Graphics2D g = (Graphics2D) image.getGraphics();
        g.setBackground(Color.white);
        g.clearRect(0, 0, this.width, this.height);
        g.setComposite(AlphaComposite.getInstance(3, 0.75f));
        if (this.tree.root().isPresent()) {
            drawNode(g, getNodeDepthsSortedByDepth((Node) this.tree.root().get()));
        }
        return image;
    }

    private <T, S extends Geometry> List<RectangleDepth> getNodeDepthsSortedByDepth(Node<T, S> root) {
        List<RectangleDepth> list = getRectangleDepths(root, 0);
        Collections.sort(list, new Comparator<RectangleDepth>() { // from class: com.github.davidmoten.rtreemulti.Visualizer.1
            public int compare(RectangleDepth n1, RectangleDepth n2) {
                return Integer.valueOf(n1.getDepth()).compareTo(Integer.valueOf(n2.getDepth()));
            }
        });
        return list;
    }

    private <T, S extends Geometry> List<RectangleDepth> getRectangleDepths(Node<T, S> node, int depth) {
        List<RectangleDepth> list = new ArrayList<>();
        list.add(new RectangleDepth(node.geometry().mbr(), depth));
        if (node.isLeaf()) {
            for (Entry<T, S> entry : ((Leaf) node).entries()) {
                list.add(new RectangleDepth(entry.geometry().mbr(), depth + 2));
            }
        } else {
            NonLeaf<T, S> n = (NonLeaf) node;
            for (int i = 0; i < n.count(); i++) {
                list.addAll(getRectangleDepths(n.child(i), depth + 1));
            }
        }
        return list;
    }

    private void drawNode(Graphics2D g, List<RectangleDepth> nodes) {
        for (RectangleDepth node : nodes) {
            Color color = Color.getHSBColor(((float) node.getDepth()) / (((float) this.maxDepth) + 1.0f), 1.0f, 1.0f);
            g.setStroke(new BasicStroke(Math.max(0.5f, (float) (((this.maxDepth - node.getDepth()) + 1) - 1))));
            g.setColor(color);
            drawRectangle(g, node.getRectangle());
        }
    }

    private void drawRectangle(Graphics2D g, Rectangle r) {
        double x1 = ((r.min(0) - this.view.min(0)) / (this.view.max(0) - this.view.min(0))) * ((double) this.width);
        double y1 = ((r.min(1) - this.view.min(1)) / (this.view.max(1) - this.view.min(1))) * ((double) this.height);
        g.drawRect(rnd(x1), rnd(y1), Math.max(rnd((((r.max(0) - this.view.min(0)) / (this.view.max(0) - this.view.min(0))) * ((double) this.width)) - x1), 1), Math.max(rnd((((r.max(1) - this.view.min(1)) / (this.view.max(1) - this.view.min(1))) * ((double) this.height)) - y1), 1));
    }

    private static int rnd(double d) {
        return (int) Math.round(d);
    }

    public void save(File file, String imageFormat) {
        ImageSaver.save(createImage(), file, imageFormat);
    }

    public void save(String filename, String imageFormat) {
        save(new File(filename), imageFormat);
    }

    public void save(String filename) {
        save(new File(filename), "PNG");
    }
}
