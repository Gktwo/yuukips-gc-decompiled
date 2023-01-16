package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.rtreemulti.RTree;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/Serializer.class */
public interface Serializer<T, S extends Geometry> {
    void write(RTree<T, S> rTree, OutputStream outputStream) throws IOException;

    RTree<T, S> read(InputStream inputStream) throws IOException;
}
