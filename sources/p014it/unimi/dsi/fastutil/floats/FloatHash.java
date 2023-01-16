package p014it.unimi.dsi.fastutil.floats;

/* renamed from: it.unimi.dsi.fastutil.floats.FloatHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatHash.class */
public interface FloatHash {

    /* renamed from: it.unimi.dsi.fastutil.floats.FloatHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/floats/FloatHash$Strategy.class */
    public interface Strategy {
        int hashCode(float f);

        boolean equals(float f, float f2);
    }
}
