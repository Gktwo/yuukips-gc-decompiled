package p014it.unimi.dsi.fastutil.shorts;

/* renamed from: it.unimi.dsi.fastutil.shorts.ShortHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortHash.class */
public interface ShortHash {

    /* renamed from: it.unimi.dsi.fastutil.shorts.ShortHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/shorts/ShortHash$Strategy.class */
    public interface Strategy {
        int hashCode(short s);

        boolean equals(short s, short s2);
    }
}
