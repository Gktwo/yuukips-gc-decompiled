package kotlin.jvm.internal;

import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KFunction;

@SinceKotlin(version = "1.7")
/* loaded from: grasscutter.jar:kotlin/jvm/internal/FunInterfaceConstructorReference.class */
public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class funInterface) {
        super(1);
        this.funInterface = funInterface;
    }

    @Override // kotlin.jvm.internal.FunctionReference, java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FunInterfaceConstructorReference)) {
            return false;
        }
        return this.funInterface.equals(((FunInterfaceConstructorReference) o).funInterface);
    }

    @Override // kotlin.jvm.internal.FunctionReference, java.lang.Object
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override // kotlin.jvm.internal.FunctionReference, java.lang.Object
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }

    /* access modifiers changed from: protected */
    @Override // kotlin.jvm.internal.FunctionReference, kotlin.jvm.internal.CallableReference
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
