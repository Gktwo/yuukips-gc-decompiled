package kotlin.jvm.internal;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;

@SinceKotlin(version = "1.4")
/* loaded from: grasscutter.jar:kotlin/jvm/internal/AdaptedFunctionReference.class */
public class AdaptedFunctionReference implements FunctionBase, Serializable {
    protected final Object receiver;
    private final Class owner;
    private final String name;
    private final String signature;
    private final boolean isTopLevel;
    private final int arity;
    private final int flags;

    public AdaptedFunctionReference(int arity, Class owner, String name, String signature, int flags) {
        this(arity, CallableReference.NO_RECEIVER, owner, name, signature, flags);
    }

    public AdaptedFunctionReference(int arity, Object receiver, Class owner, String name, String signature, int flags) {
        this.receiver = receiver;
        this.owner = owner;
        this.name = name;
        this.signature = signature;
        this.isTopLevel = (flags & 1) == 1;
        this.arity = arity;
        this.flags = flags >> 1;
    }

    @Override // kotlin.jvm.internal.FunctionBase
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        if (this.owner == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(this.owner) : Reflection.getOrCreateKotlinClass(this.owner);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference other = (AdaptedFunctionReference) o;
        return this.isTopLevel == other.isTopLevel && this.arity == other.arity && this.flags == other.flags && Intrinsics.areEqual(this.receiver, other.receiver) && Intrinsics.areEqual(this.owner, other.owner) && this.name.equals(other.name) && this.signature.equals(other.signature);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((((((((((((this.receiver != null ? this.receiver.hashCode() : 0) * 31) + (this.owner != null ? this.owner.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE)) * 31) + this.arity) * 31) + this.flags;
    }

    @Override // java.lang.Object
    public String toString() {
        return Reflection.renderLambdaToString(this);
    }
}
