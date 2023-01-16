package p013io.netty.util;

/* renamed from: io.netty.util.Signal */
/* loaded from: grasscutter.jar:io/netty/util/Signal.class */
public final class Signal extends Error implements Constant<Signal> {
    private static final long serialVersionUID = -221145131122459977L;
    private static final ConstantPool<Signal> pool = new ConstantPool<Signal>() { // from class: io.netty.util.Signal.1
        /* access modifiers changed from: protected */
        @Override // p013io.netty.util.ConstantPool
        public Signal newConstant(int id, String name) {
            return new Signal(id, name);
        }
    };
    private final SignalConstant constant;

    public static Signal valueOf(String name) {
        return pool.valueOf(name);
    }

    public static Signal valueOf(Class<?> firstNameComponent, String secondNameComponent) {
        return pool.valueOf(firstNameComponent, secondNameComponent);
    }

    private Signal(int id, String name) {
        this.constant = new SignalConstant(id, name);
    }

    public void expect(Signal signal) {
        if (this != signal) {
            throw new IllegalStateException("unexpected signal: " + signal);
        }
    }

    @Override // java.lang.Throwable
    public Throwable initCause(Throwable cause) {
        return this;
    }

    @Override // java.lang.Throwable
    public Throwable fillInStackTrace() {
        return this;
    }

    @Override // p013io.netty.util.Constant
    /* renamed from: id */
    public int mo1173id() {
        return this.constant.mo1173id();
    }

    @Override // p013io.netty.util.Constant
    public String name() {
        return this.constant.name();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return System.identityHashCode(this);
    }

    public int compareTo(Signal other) {
        if (this == other) {
            return 0;
        }
        return this.constant.compareTo(other.constant);
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        return name();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.Signal$SignalConstant */
    /* loaded from: grasscutter.jar:io/netty/util/Signal$SignalConstant.class */
    public static final class SignalConstant extends AbstractConstant<SignalConstant> {
        SignalConstant(int id, String name) {
            super(id, name);
        }
    }
}
