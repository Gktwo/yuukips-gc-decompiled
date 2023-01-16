package javassist.runtime;

/* loaded from: grasscutter.jar:javassist/runtime/Cflow.class */
public class Cflow extends ThreadLocal<Depth> {

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:javassist/runtime/Cflow$Depth.class */
    public static class Depth {
        private int depth = 0;

        Depth() {
        }

        int value() {
            return this.depth;
        }

        void inc() {
            this.depth++;
        }

        void dec() {
            this.depth--;
        }
    }

    /* access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    public synchronized Depth initialValue() {
        return new Depth();
    }

    public void enter() {
        get().inc();
    }

    public void exit() {
        get().dec();
    }

    public int value() {
        return get().value();
    }
}
