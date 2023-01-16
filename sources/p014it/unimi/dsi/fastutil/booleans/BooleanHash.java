package p014it.unimi.dsi.fastutil.booleans;

/* renamed from: it.unimi.dsi.fastutil.booleans.BooleanHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanHash.class */
public interface BooleanHash {

    /* renamed from: it.unimi.dsi.fastutil.booleans.BooleanHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/booleans/BooleanHash$Strategy.class */
    public interface Strategy {
        int hashCode(boolean z);

        boolean equals(boolean z, boolean z2);
    }
}
