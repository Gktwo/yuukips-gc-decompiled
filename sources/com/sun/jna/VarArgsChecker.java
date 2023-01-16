package com.sun.jna;

import java.lang.reflect.Method;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/sun/jna/VarArgsChecker.class */
public abstract class VarArgsChecker {
    /* access modifiers changed from: package-private */
    public abstract boolean isVarArgs(Method method);

    /* access modifiers changed from: package-private */
    public abstract int fixedArgs(Method method);

    private VarArgsChecker() {
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/sun/jna/VarArgsChecker$RealVarArgsChecker.class */
    public static final class RealVarArgsChecker extends VarArgsChecker {
        private RealVarArgsChecker() {
            super();
        }

        @Override // com.sun.jna.VarArgsChecker
        boolean isVarArgs(Method m) {
            return m.isVarArgs();
        }

        @Override // com.sun.jna.VarArgsChecker
        int fixedArgs(Method m) {
            if (m.isVarArgs()) {
                return m.getParameterTypes().length - 1;
            }
            return 0;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/sun/jna/VarArgsChecker$NoVarArgsChecker.class */
    public static final class NoVarArgsChecker extends VarArgsChecker {
        private NoVarArgsChecker() {
            super();
        }

        @Override // com.sun.jna.VarArgsChecker
        boolean isVarArgs(Method m) {
            return false;
        }

        @Override // com.sun.jna.VarArgsChecker
        int fixedArgs(Method m) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    public static VarArgsChecker create() {
        try {
            if (Method.class.getMethod("isVarArgs", new Class[0]) != null) {
                return new RealVarArgsChecker();
            }
            return new NoVarArgsChecker();
        } catch (NoSuchMethodException e) {
            return new NoVarArgsChecker();
        } catch (SecurityException e2) {
            return new NoVarArgsChecker();
        }
    }
}
