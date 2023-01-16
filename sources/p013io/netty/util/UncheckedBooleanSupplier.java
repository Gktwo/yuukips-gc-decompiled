package p013io.netty.util;

/* renamed from: io.netty.util.UncheckedBooleanSupplier */
/* loaded from: grasscutter.jar:io/netty/util/UncheckedBooleanSupplier.class */
public interface UncheckedBooleanSupplier extends BooleanSupplier {
    public static final UncheckedBooleanSupplier FALSE_SUPPLIER = new UncheckedBooleanSupplier() { // from class: io.netty.util.UncheckedBooleanSupplier.1
        @Override // p013io.netty.util.UncheckedBooleanSupplier, p013io.netty.util.BooleanSupplier
        public boolean get() {
            return false;
        }
    };
    public static final UncheckedBooleanSupplier TRUE_SUPPLIER = new UncheckedBooleanSupplier() { // from class: io.netty.util.UncheckedBooleanSupplier.2
        @Override // p013io.netty.util.UncheckedBooleanSupplier, p013io.netty.util.BooleanSupplier
        public boolean get() {
            return true;
        }
    };

    @Override // p013io.netty.util.BooleanSupplier
    boolean get();
}
