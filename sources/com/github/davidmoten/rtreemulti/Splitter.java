package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.geometry.ListPair;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/Splitter.class */
public interface Splitter {
    <T extends HasGeometry> ListPair<T> split(List<T> list, int i);
}
