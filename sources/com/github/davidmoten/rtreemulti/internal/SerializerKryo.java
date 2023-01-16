package com.github.davidmoten.rtreemulti.internal;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.github.davidmoten.rtreemulti.Context;
import com.github.davidmoten.rtreemulti.Factory;
import com.github.davidmoten.rtreemulti.Node;
import com.github.davidmoten.rtreemulti.RTree;
import com.github.davidmoten.rtreemulti.Selector;
import com.github.davidmoten.rtreemulti.SelectorMinimalVolumeIncrease;
import com.github.davidmoten.rtreemulti.SelectorRStar;
import com.github.davidmoten.rtreemulti.Splitter;
import com.github.davidmoten.rtreemulti.SplitterQuadratic;
import com.github.davidmoten.rtreemulti.SplitterRStar;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Optional;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/SerializerKryo.class */
public class SerializerKryo<T, S extends Geometry> implements Serializer<T, S> {
    private static final int VERSION = 1;

    @Override // com.github.davidmoten.rtreemulti.internal.Serializer
    public void write(RTree<T, S> tree, OutputStream out) throws IOException {
        createKryo().writeObject(new Output(out), tree);
    }

    @Override // com.github.davidmoten.rtreemulti.internal.Serializer
    public RTree<T, S> read(InputStream in) {
        return (RTree) createKryo().readObject(new Input(in), RTree.class);
    }

    private static Kryo createKryo() {
        Kryo k = new Kryo();
        k.register(RTree.class, new Serializer<RTree<Object, Geometry>>() { // from class: com.github.davidmoten.rtreemulti.internal.SerializerKryo.1
            public RTree<Object, Geometry> read(Kryo k2, Input input, Class<? extends RTree<Object, Geometry>> cls) {
                input.readShort();
                int dimensions = input.readShort();
                int minChildren = input.readShort();
                int maxChildren = input.readShort();
                Splitter splitter = input.readShort() == 0 ? SplitterQuadratic.INSTANCE : SplitterRStar.INSTANCE;
                Selector selector = input.readShort() == 0 ? SelectorRStar.INSTANCE : SelectorMinimalVolumeIncrease.INSTANCE;
                if (input.readBoolean()) {
                    return new RTree<>(Optional.of((Node) k2.readObject(input, Node.class)), 0, new Context(dimensions, minChildren, maxChildren, selector, splitter, Factory.defaultFactory()));
                }
                return new RTree<>(Optional.empty(), 0, new Context(dimensions, minChildren, maxChildren, selector, splitter, Factory.defaultFactory()));
            }

            public void write(Kryo k2, Output output, RTree<Object, Geometry> tree) {
                output.writeShort(1);
                output.writeShort(tree.dimensions());
                output.writeShort(tree.context().minChildren());
                output.writeShort(tree.context().maxChildren());
                short splitter = (short) (tree.context().splitter() instanceof SplitterQuadratic ? 0 : 1);
                int i = tree.context().selector() instanceof SelectorRStar ? 1 : 0;
                output.writeShort(splitter);
                output.writeShort((short) i);
                output.writeBoolean(tree.root().isPresent());
                if (tree.root().isPresent()) {
                    k2.writeObject(output, tree.root().get());
                }
            }
        });
        return k;
    }
}
