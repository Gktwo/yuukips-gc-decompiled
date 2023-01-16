package kotlin.jvm.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: localVariableReferences.kt */
@SinceKotlin(version = "1.1")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\b\u0017\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, m373d2 = {"Lkotlin/jvm/internal/LocalVariableReference;", "Lkotlin/jvm/internal/PropertyReference0;", "()V", BeanUtil.PREFIX_GETTER_GET, "", "getOwner", "Lkotlin/reflect/KDeclarationContainer;", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/jvm/internal/LocalVariableReference.class */
public class LocalVariableReference extends PropertyReference0 {
    @Override // kotlin.jvm.internal.CallableReference
    @NotNull
    public KDeclarationContainer getOwner() {
        Void unused = localVariableReferences.notSupportedError();
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.reflect.KProperty0
    @Nullable
    public Object get() {
        Void unused = localVariableReferences.notSupportedError();
        throw new KotlinNothingValueException();
    }
}
