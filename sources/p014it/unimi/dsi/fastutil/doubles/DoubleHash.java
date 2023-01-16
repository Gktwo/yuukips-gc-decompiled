package p014it.unimi.dsi.fastutil.doubles;

/* renamed from: it.unimi.dsi.fastutil.doubles.DoubleHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleHash.class */
public interface DoubleHash {

    /* renamed from: it.unimi.dsi.fastutil.doubles.DoubleHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/doubles/DoubleHash$Strategy.class */
    public interface Strategy {
        int hashCode(double d);

        boolean equals(double d, double d2);
    }
}
