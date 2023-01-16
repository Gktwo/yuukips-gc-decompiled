package p013io.netty.util;

/* renamed from: io.netty.util.AttributeKey */
/* loaded from: grasscutter.jar:io/netty/util/AttributeKey.class */
public final class AttributeKey<T> extends AbstractConstant<AttributeKey<T>> {
    private static final ConstantPool<AttributeKey<Object>> pool = new ConstantPool<AttributeKey<Object>>() { // from class: io.netty.util.AttributeKey.1
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.ConstantPool
        public AttributeKey<Object> newConstant(int id, String name) {
            return new AttributeKey<>(id, name);
        }
    };

    public static <T> AttributeKey<T> valueOf(String name) {
        return (AttributeKey<T>) pool.valueOf(name);
    }

    public static boolean exists(String name) {
        return pool.exists(name);
    }

    public static <T> AttributeKey<T> newInstance(String name) {
        return (AttributeKey<T>) pool.newInstance(name);
    }

    public static <T> AttributeKey<T> valueOf(Class<?> firstNameComponent, String secondNameComponent) {
        return (AttributeKey<T>) pool.valueOf(firstNameComponent, secondNameComponent);
    }

    private AttributeKey(int id, String name) {
        super(id, name);
    }
}
