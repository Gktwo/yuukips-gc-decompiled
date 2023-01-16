package p014it.unimi.dsi.fastutil.longs;

/* renamed from: it.unimi.dsi.fastutil.longs.LongHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongHash.class */
public interface LongHash {

    /* renamed from: it.unimi.dsi.fastutil.longs.LongHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/longs/LongHash$Strategy.class */
    public interface Strategy {
        int hashCode(long j);

        boolean equals(long j, long j2);
    }
}
