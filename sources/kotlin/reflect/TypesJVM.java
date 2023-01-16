package kotlin.reflect;

import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
/* renamed from: kotlin.reflect.ParameterizedTypeImpl$getTypeName$1$1 */
/* loaded from: grasscutter.jar:kotlin/reflect/ParameterizedTypeImpl$getTypeName$1$1.class */
/* synthetic */ class TypesJVM extends FunctionReferenceImpl implements Function1<Type, String> {
    public static final TypesJVM INSTANCE = new TypesJVM();

    TypesJVM() {
        super(1, TypesJVMKt.class, "typeToString", "typeToString(Ljava/lang/reflect/Type;)Ljava/lang/String;", 1);
    }

    @NotNull
    public final String invoke(@NotNull Type p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return TypesJVMKt.typeToString(p0);
    }
}
