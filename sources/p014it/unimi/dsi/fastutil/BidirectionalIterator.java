package p014it.unimi.dsi.fastutil;

import java.util.Iterator;

/* renamed from: it.unimi.dsi.fastutil.BidirectionalIterator */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/BidirectionalIterator.class */
public interface BidirectionalIterator<K> extends Iterator<K> {
    K previous();

    boolean hasPrevious();
}
