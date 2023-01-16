package com.sun.jna;

/* loaded from: grasscutter.jar:com/sun/jna/IntegerType.class */
public abstract class IntegerType extends Number implements NativeMapped {
    private static final long serialVersionUID = 1;
    private int size;
    private Number number;
    private boolean unsigned;
    private long value;

    public IntegerType(int size) {
        this(size, 0, false);
    }

    public IntegerType(int size, boolean unsigned) {
        this(size, 0, unsigned);
    }

    public IntegerType(int size, long value) {
        this(size, value, false);
    }

    public IntegerType(int size, long value, boolean unsigned) {
        this.size = size;
        this.unsigned = unsigned;
        setValue(value);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [long] */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setValue(long r7) {
        /*
        // Method dump skipped, instructions count: 306
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.jna.IntegerType.setValue(long):void");
    }

    @Override // com.sun.jna.NativeMapped
    public Object toNative() {
        return this.number;
    }

    @Override // com.sun.jna.NativeMapped
    public Object fromNative(Object nativeValue, FromNativeContext context) {
        long value = nativeValue == null ? 0 : ((Number) nativeValue).longValue();
        IntegerType number = (IntegerType) Klass.newInstance(getClass());
        number.setValue(value);
        return number;
    }

    @Override // com.sun.jna.NativeMapped
    public Class<?> nativeType() {
        return this.number.getClass();
    }

    @Override // java.lang.Number
    public int intValue() {
        return (int) this.value;
    }

    @Override // java.lang.Number
    public long longValue() {
        return this.value;
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.number.floatValue();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return this.number.doubleValue();
    }

    @Override // java.lang.Object
    public boolean equals(Object rhs) {
        return (rhs instanceof IntegerType) && this.number.equals(((IntegerType) rhs).number);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.number.toString();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.number.hashCode();
    }

    public static <T extends IntegerType> int compare(T v1, T v2) {
        if (v1 == v2) {
            return 0;
        }
        if (v1 == null) {
            return 1;
        }
        if (v2 == null) {
            return -1;
        }
        return compare(v1.longValue(), v2.longValue());
    }

    public static int compare(IntegerType v1, long v2) {
        if (v1 == null) {
            return 1;
        }
        return compare(v1.longValue(), v2);
    }

    public static final int compare(long v1, long v2) {
        if (v1 == v2) {
            return 0;
        }
        if (v1 < v2) {
            return -1;
        }
        return 1;
    }
}
