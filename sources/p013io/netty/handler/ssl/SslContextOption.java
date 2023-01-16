package p013io.netty.handler.ssl;

import p013io.netty.util.AbstractConstant;
import p013io.netty.util.ConstantPool;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.ssl.SslContextOption */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/SslContextOption.class */
public class SslContextOption<T> extends AbstractConstant<SslContextOption<T>> {
    private static final ConstantPool<SslContextOption<Object>> pool = new ConstantPool<SslContextOption<Object>>() { // from class: io.netty.handler.ssl.SslContextOption.1
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.ConstantPool
        public SslContextOption<Object> newConstant(int id, String name) {
            return new SslContextOption<>(id, name);
        }
    };

    public static <T> SslContextOption<T> valueOf(String name) {
        return (SslContextOption<T>) pool.valueOf(name);
    }

    public static <T> SslContextOption<T> valueOf(Class<?> firstNameComponent, String secondNameComponent) {
        return (SslContextOption<T>) pool.valueOf(firstNameComponent, secondNameComponent);
    }

    public static boolean exists(String name) {
        return pool.exists(name);
    }

    private SslContextOption(int id, String name) {
        super(id, name);
    }

    /* access modifiers changed from: protected */
    public SslContextOption(String name) {
        this(pool.nextId(), name);
    }

    public void validate(T value) {
        ObjectUtil.checkNotNull(value, "value");
    }
}
