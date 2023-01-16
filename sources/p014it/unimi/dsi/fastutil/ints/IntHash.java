package p014it.unimi.dsi.fastutil.ints;

/* renamed from: it.unimi.dsi.fastutil.ints.IntHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntHash.class */
public interface IntHash {

    /* renamed from: it.unimi.dsi.fastutil.ints.IntHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/ints/IntHash$Strategy.class */
    public interface Strategy {
        int hashCode(int i);

        boolean equals(int i, int i2);
    }
}
