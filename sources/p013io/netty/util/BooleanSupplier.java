package p013io.netty.util;

/* renamed from: io.netty.util.BooleanSupplier */
/* loaded from: grasscutter.jar:io/netty/util/BooleanSupplier.class */
public interface BooleanSupplier {
    public static final BooleanSupplier FALSE_SUPPLIER = new BooleanSupplier() { // from class: io.netty.util.BooleanSupplier.1
        @Override // p013io.netty.util.BooleanSupplier
        public boolean get() {
            return false;
        }
    };
    public static final BooleanSupplier TRUE_SUPPLIER = new BooleanSupplier() { // from class: io.netty.util.BooleanSupplier.2
        @Override // p013io.netty.util.BooleanSupplier
        public boolean get() {
            return true;
        }
    };

    boolean get() throws Exception;
}
