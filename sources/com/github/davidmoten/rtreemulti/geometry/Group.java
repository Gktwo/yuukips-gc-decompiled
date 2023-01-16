package com.github.davidmoten.rtreemulti.geometry;

import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.internal.Util;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/geometry/Group.class */
public class Group<T extends HasGeometry> implements HasGeometry {
    private final List<T> list;
    private final Rectangle mbr;

    public Group(List<T> list) {
        this.list = list;
        this.mbr = Util.mbr(list);
    }

    public List<T> list() {
        return this.list;
    }

    @Override // com.github.davidmoten.rtreemulti.geometry.HasGeometry
    public Geometry geometry() {
        return this.mbr;
    }
}
