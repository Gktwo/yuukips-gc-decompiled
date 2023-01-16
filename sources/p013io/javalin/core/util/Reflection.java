package p013io.javalin.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: ReflectionUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018�� /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0002\u0010\u0003J\u0010\u0010(\u001a\u0004\u0018\u00010\u001a2\u0006\u0010)\u001a\u00020\tJ\u000e\u0010*\u001a\u00020\u00012\u0006\u0010+\u001a\u00020\tJ\u0010\u0010,\u001a\u0004\u0018\u00010\u001f2\u0006\u0010)\u001a\u00020\tJ\u000e\u0010-\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\tR\u0011\u0010\u0004\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007R\u0011\u0010\r\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0007R\u0011\u0010\u000f\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0007R\u0011\u0010\u0010\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0007R\u0011\u0010\u0011\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0007R\u0011\u0010\u0012\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0007R\u0011\u0010\u0013\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0011\u0010\u0014\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0007R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u000bR\u0011\u0010\u0017\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u000bR\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8F¢\u0006\u0006\u001a\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0001¢\u0006\b\n��\u001a\u0004\b\"\u0010#R\u0015\u0010$\u001a\u0006\u0012\u0002\b\u00030%8F¢\u0006\u0006\u001a\u0004\b&\u0010'¨\u00060"}, m373d2 = {"Lio/javalin/core/util/Reflection;", "", "obj", "(Ljava/lang/Object;)V", "hasMethodName", "", "getHasMethodName", "()Z", "implementingClassName", "", "getImplementingClassName", "()Ljava/lang/String;", "isClass", "isJavaAnonymousClass", "isJavaAnonymousLambda", "isJavaField", "isJavaMemberClass", "isJavaNonStaticMethodReference", "isKotlinAnonymousLambda", "isKotlinField", "isKotlinMethodReference", "javaFieldName", "getJavaFieldName", "kotlinFieldName", "getKotlinFieldName", "lambdaField", "Ljava/lang/reflect/Field;", "getLambdaField", "()Ljava/lang/reflect/Field;", "methodsNotDeclaredByObject", "", "Ljava/lang/reflect/Method;", "getMethodsNotDeclaredByObject", "()[Ljava/lang/reflect/Method;", "getObj", "()Ljava/lang/Object;", "parentClass", "Ljava/lang/Class;", "getParentClass", "()Ljava/lang/Class;", "getDeclaredFieldByName", "methodName", "getFieldValue", "fieldName", "getMethodByName", "runMethod", "name", "Companion", "javalin"})
/* renamed from: io.javalin.core.util.Reflection */
/* loaded from: grasscutter.jar:io/javalin/core/util/Reflection.class */
public final class Reflection {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final Object obj;

    /* compiled from: ReflectionUtil.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0002J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u0001¨\u0006\b"}, m373d2 = {"Lio/javalin/core/util/Reflection$Companion;", "", "()V", "classOf", "Ljava/lang/Class;", "obj", "rfl", "Lio/javalin/core/util/Reflection;", "javalin"})
    /* renamed from: io.javalin.core.util.Reflection$Companion */
    /* loaded from: grasscutter.jar:io/javalin/core/util/Reflection$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Reflection rfl(@NotNull Object obj) {
            Intrinsics.checkNotNullParameter(obj, "obj");
            return new Reflection(obj);
        }

        /* access modifiers changed from: private */
        public final Class<?> classOf(Object obj) {
            return obj instanceof Class ? (Class) obj : obj.getClass();
        }
    }

    public Reflection(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        this.obj = obj;
    }

    @NotNull
    public final Object getObj() {
        return this.obj;
    }

    @NotNull
    public final String getKotlinFieldName() {
        return ReflectionUtil.getKotlinFieldName(this.obj);
    }

    @Nullable
    public final String getJavaFieldName() {
        return ReflectionUtil.getJavaFieldName(this.obj);
    }

    @NotNull
    public final Class<?> getParentClass() {
        return ReflectionUtil.getParentClass(this.obj);
    }

    @Nullable
    public final String getImplementingClassName() {
        return ReflectionUtil.getImplementingClassName(this.obj);
    }

    public final boolean isClass() {
        return this.obj instanceof Class;
    }

    public final boolean isKotlinAnonymousLambda() {
        return ReflectionUtil.isKotlinAnonymousLambda(this.obj);
    }

    public final boolean isKotlinMethodReference() {
        return ReflectionUtil.isKotlinMethodReference(this.obj);
    }

    public final boolean isKotlinField() {
        return ReflectionUtil.isKotlinField(this.obj);
    }

    public final boolean isJavaAnonymousClass() {
        return ReflectionUtil.isJavaAnonymousClass(this.obj);
    }

    public final boolean isJavaAnonymousLambda() {
        return ReflectionUtil.isJavaAnonymousLambda(this.obj);
    }

    public final boolean isJavaMemberClass() {
        return ReflectionUtil.isJavaMemberClass(this.obj);
    }

    public final boolean getHasMethodName() {
        return ReflectionUtil.getHasMethodName(this.obj);
    }

    public final boolean isJavaNonStaticMethodReference() {
        return ReflectionUtil.isJavaNonStaticMethodReference(this.obj);
    }

    public final boolean isJavaField() {
        return ReflectionUtil.isJavaField(this.obj);
    }

    @Nullable
    public final Field getLambdaField() {
        return ReflectionUtil.getLambdaField(this.obj);
    }

    @NotNull
    public final Method[] getMethodsNotDeclaredByObject() {
        return ReflectionUtil.getMethodsNotDeclaredByObject(Companion.classOf(this.obj));
    }

    @NotNull
    public final Object runMethod(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return ReflectionUtil.runMethod(this.obj, name);
    }

    @NotNull
    public final Object getFieldValue(@NotNull String fieldName) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        return ReflectionUtil.getFieldValue(this.obj, fieldName);
    }

    @Nullable
    public final Method getMethodByName(@NotNull String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return ReflectionUtil.getMethodByName(Companion.classOf(this.obj), methodName);
    }

    @Nullable
    public final Field getDeclaredFieldByName(@NotNull String methodName) {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        return ReflectionUtil.getDeclaredFieldByName(Companion.classOf(this.obj), methodName);
    }
}
