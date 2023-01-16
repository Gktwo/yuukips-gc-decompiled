package p013io.javalin.core.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import p013io.javalin.apibuilder.CrudFunctionHandler;

@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��,\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n\u0002\u0010��\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u001a\u001a\u0010'\u001a\u0004\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030!2\u0006\u0010\u001c\u001a\u00020\u0001H��\u001a\u0014\u0010(\u001a\u00020\u0004*\u00020\u00042\u0006\u0010)\u001a\u00020\u0001H��\u001a\u001a\u0010*\u001a\u0004\u0018\u00010 *\u0006\u0012\u0002\b\u00030!2\u0006\u0010\u001c\u001a\u00020\u0001H��\u001a\u0014\u0010+\u001a\u00020\u0004*\u00020\u00042\u0006\u0010,\u001a\u00020\u0001H��\"\u000e\u0010��\u001a\u00020\u0001XT¢\u0006\u0002\n��\"\u0018\u0010\u0002\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t\"\u0018\u0010\n\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0006\"\u0018\u0010\u000b\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0006\"\u0018\u0010\f\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0006\"\u0018\u0010\r\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0006\"\u0018\u0010\u000e\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006\"\u0018\u0010\u000f\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006\"\u0018\u0010\u0010\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0006\"\u0018\u0010\u0011\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0006\"\u0018\u0010\u0012\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0006\"\u0018\u0010\u0013\u001a\u00020\u0003*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006\"\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0001*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\t\"\u0018\u0010\u0016\u001a\u00020\u0001*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\t\"\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\"\u001a\u0010\u001c\u001a\u0004\u0018\u00010\u0001*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\t\"\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001f*\u0006\u0012\u0002\b\u00030!8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#\"\u001c\u0010$\u001a\u0006\u0012\u0002\b\u00030!*\u00020\u00048@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&¨\u0006-"}, m373d2 = {"methodReferenceReflectionMethodName", "", "hasMethodName", "", "", "getHasMethodName", "(Ljava/lang/Object;)Z", "implementingClassName", "getImplementingClassName", "(Ljava/lang/Object;)Ljava/lang/String;", "isClass", "isCrudFunction", "isJavaAnonymousClass", "isJavaAnonymousLambda", "isJavaField", "isJavaMemberClass", "isJavaNonStaticMethodReference", "isKotlinAnonymousLambda", "isKotlinField", "isKotlinMethodReference", "javaFieldName", "getJavaFieldName", "kotlinFieldName", "getKotlinFieldName", "lambdaField", "Ljava/lang/reflect/Field;", "getLambdaField", "(Ljava/lang/Object;)Ljava/lang/reflect/Field;", "methodName", "getMethodName", "methodsNotDeclaredByObject", "", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getMethodsNotDeclaredByObject", "(Ljava/lang/Class;)[Ljava/lang/reflect/Method;", "parentClass", "getParentClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "getDeclaredFieldByName", "getFieldValue", "fieldName", "getMethodByName", "runMethod", "name", "javalin"})
/* renamed from: io.javalin.core.util.ReflectionUtilKt */
/* loaded from: grasscutter.jar:io/javalin/core/util/ReflectionUtilKt.class */
public final class ReflectionUtil {
    @NotNull
    public static final String methodReferenceReflectionMethodName = "get$Lambda";

    @NotNull
    public static final String getKotlinFieldName(@NotNull Object $this$kotlinFieldName) {
        Intrinsics.checkNotNullParameter($this$kotlinFieldName, "<this>");
        String cls = $this$kotlinFieldName.getClass().toString();
        Intrinsics.checkNotNullExpressionValue(cls, "this.javaClass.toString()");
        String $this$takeWhile$iv = StringsKt.removePrefix(cls, (CharSequence) Intrinsics.stringPlus(getParentClass($this$kotlinFieldName).toString(), "$"));
        int length = $this$takeWhile$iv.length();
        for (int index$iv = 0; index$iv < length; index$iv++) {
            if (!($this$takeWhile$iv.charAt(index$iv) != '$')) {
                String substring = $this$takeWhile$iv.substring(0, index$iv);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
            }
        }
        return $this$takeWhile$iv;
    }

    @Nullable
    public static final String getJavaFieldName(@NotNull Object $this$javaFieldName) {
        String str;
        Field field;
        Intrinsics.checkNotNullParameter($this$javaFieldName, "<this>");
        try {
            Field[] declaredFields = getParentClass($this$javaFieldName).getDeclaredFields();
            Intrinsics.checkNotNullExpressionValue(declaredFields, "parentClass.declaredFields");
            Field[] fieldArr = declaredFields;
            int length = fieldArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    field = null;
                    break;
                }
                Field field2 = fieldArr[i];
                Field it = field2;
                it.setAccessible(true);
                if (Intrinsics.areEqual(it.get(it), $this$javaFieldName)) {
                    field = field2;
                    break;
                }
                i++;
            }
            Field field3 = field;
            str = field3 == null ? null : field3.getName();
        } catch (Exception e) {
            str = null;
        }
        return str;
    }

    @Nullable
    public static final String getMethodName(@NotNull Object $this$methodName) {
        Intrinsics.checkNotNullParameter($this$methodName, "<this>");
        return null;
    }

    @NotNull
    public static final Class<?> getParentClass(@NotNull Object $this$parentClass) {
        String str;
        Intrinsics.checkNotNullParameter($this$parentClass, "<this>");
        String $this$takeWhile$iv = $this$parentClass.getClass().getName();
        Intrinsics.checkNotNullExpressionValue($this$takeWhile$iv, "this.javaClass.name");
        int index$iv = 0;
        int length = $this$takeWhile$iv.length();
        while (true) {
            if (index$iv >= length) {
                str = $this$takeWhile$iv;
                break;
            }
            if (!($this$takeWhile$iv.charAt(index$iv) != '$')) {
                str = $this$takeWhile$iv.substring(0, index$iv);
                Intrinsics.checkNotNullExpressionValue(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                break;
            }
            index$iv++;
        }
        Class<?> cls = Class.forName(str, false, $this$parentClass.getClass().getClassLoader());
        Intrinsics.checkNotNullExpressionValue(cls, "forName(this.javaClass.n…is.javaClass.classLoader)");
        return cls;
    }

    @Nullable
    public static final String getImplementingClassName(@NotNull Object $this$implementingClassName) {
        Intrinsics.checkNotNullParameter($this$implementingClassName, "<this>");
        return $this$implementingClassName.getClass().getName();
    }

    public static final boolean isClass(@NotNull Object $this$isClass) {
        Intrinsics.checkNotNullParameter($this$isClass, "<this>");
        return $this$isClass instanceof Class;
    }

    public static final boolean isKotlinAnonymousLambda(@NotNull Object $this$isKotlinAnonymousLambda) {
        Intrinsics.checkNotNullParameter($this$isKotlinAnonymousLambda, "<this>");
        return $this$isKotlinAnonymousLambda.getClass().getEnclosingMethod() != null;
    }

    public static final boolean isCrudFunction(@NotNull Object $this$isCrudFunction) {
        Intrinsics.checkNotNullParameter($this$isCrudFunction, "<this>");
        return $this$isCrudFunction instanceof CrudFunctionHandler;
    }

    public static final boolean isKotlinMethodReference(@NotNull Object $this$isKotlinMethodReference) {
        Intrinsics.checkNotNullParameter($this$isKotlinMethodReference, "<this>");
        Object[] $this$count$iv = $this$isKotlinMethodReference.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue($this$count$iv, "this.javaClass.declaredFields");
        int count$iv = 0;
        for (Object element$iv : $this$count$iv) {
            Field it = (Field) element$iv;
            if (Intrinsics.areEqual(it.getName(), "function") || Intrinsics.areEqual(it.getName(), "$tmp0")) {
                count$iv++;
            }
        }
        return count$iv == 1;
    }

    public static final boolean isKotlinField(@NotNull Object $this$isKotlinField) {
        Intrinsics.checkNotNullParameter($this$isKotlinField, "<this>");
        Object[] $this$any$iv = $this$isKotlinField.getClass().getFields();
        Intrinsics.checkNotNullExpressionValue($this$any$iv, "this.javaClass.fields");
        for (Object element$iv : $this$any$iv) {
            if (Intrinsics.areEqual(((Field) element$iv).getName(), "INSTANCE")) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isJavaAnonymousClass(@NotNull Object $this$isJavaAnonymousClass) {
        Intrinsics.checkNotNullParameter($this$isJavaAnonymousClass, "<this>");
        return $this$isJavaAnonymousClass.getClass().isAnonymousClass();
    }

    public static final boolean isJavaMemberClass(@NotNull Object $this$isJavaMemberClass) {
        Intrinsics.checkNotNullParameter($this$isJavaMemberClass, "<this>");
        return $this$isJavaMemberClass.getClass().isMemberClass();
    }

    public static final boolean isJavaAnonymousLambda(@NotNull Object $this$isJavaAnonymousLambda) {
        Intrinsics.checkNotNullParameter($this$isJavaAnonymousLambda, "<this>");
        return $this$isJavaAnonymousLambda.getClass().isSynthetic();
    }

    public static final boolean getHasMethodName(@NotNull Object $this$hasMethodName) {
        Intrinsics.checkNotNullParameter($this$hasMethodName, "<this>");
        return getMethodName($this$hasMethodName) != null;
    }

    public static final boolean isJavaNonStaticMethodReference(@NotNull Object $this$isJavaNonStaticMethodReference) {
        Intrinsics.checkNotNullParameter($this$isJavaNonStaticMethodReference, "<this>");
        Object[] $this$any$iv = $this$isJavaNonStaticMethodReference.getClass().getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue($this$any$iv, "javaClass.declaredMethods");
        for (Object element$iv : $this$any$iv) {
            if (Intrinsics.areEqual(((Method) element$iv).getName(), methodReferenceReflectionMethodName)) {
                return true;
            }
        }
        return false;
    }

    public static final boolean isJavaField(@NotNull Object $this$isJavaField) {
        Intrinsics.checkNotNullParameter($this$isJavaField, "<this>");
        return getJavaFieldName($this$isJavaField) != null;
    }

    @NotNull
    public static final Object runMethod(@NotNull Object $this$runMethod, @NotNull String name) {
        Intrinsics.checkNotNullParameter($this$runMethod, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Method $this$runMethod_u24lambda_u2d6 = $this$runMethod.getClass().getMethod(name, new Class[0]);
        $this$runMethod_u24lambda_u2d6.setAccessible(true);
        Object invoke = $this$runMethod_u24lambda_u2d6.invoke($this$runMethod, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(invoke, "this.javaClass.getMethod…ble = true }.invoke(this)");
        return invoke;
    }

    @Nullable
    public static final Field getLambdaField(@NotNull Object $this$lambdaField) {
        Intrinsics.checkNotNullParameter($this$lambdaField, "<this>");
        if (isKotlinField($this$lambdaField)) {
            return getDeclaredFieldByName(getParentClass($this$lambdaField), getKotlinFieldName($this$lambdaField));
        }
        if (!isJavaField($this$lambdaField)) {
            return null;
        }
        Class<?> parentClass = getParentClass($this$lambdaField);
        String javaFieldName = getJavaFieldName($this$lambdaField);
        Intrinsics.checkNotNull(javaFieldName);
        return getDeclaredFieldByName(parentClass, javaFieldName);
    }

    @NotNull
    public static final Object getFieldValue(@NotNull Object $this$getFieldValue, @NotNull String fieldName) {
        Intrinsics.checkNotNullParameter($this$getFieldValue, "<this>");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Field field = $this$getFieldValue.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        Object obj = field.get($this$getFieldValue);
        Intrinsics.checkNotNullExpressionValue(obj, "field.get(this)");
        return obj;
    }

    @Nullable
    public static final Method getMethodByName(@NotNull Class<?> cls, @NotNull String methodName) {
        Method method;
        Method method2;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Function1 isName = new Function1<Method, Boolean>(methodName) { // from class: io.javalin.core.util.ReflectionUtilKt$getMethodByName$isName$1
            final /* synthetic */ String $methodName;

            /* access modifiers changed from: package-private */
            {
                this.$methodName = $methodName;
            }

            @NotNull
            public final Boolean invoke(@NotNull Method method3) {
                Intrinsics.checkNotNullParameter(method3, EJBInvokerJob.EJB_METHOD_KEY);
                return Boolean.valueOf(Intrinsics.areEqual(method3.getName(), this.$methodName));
            }
        };
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
        Method[] methodArr = declaredMethods;
        int length = methodArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                method = null;
                break;
            }
            Method method3 = methodArr[i];
            if (isName.invoke(method3).booleanValue()) {
                method = method3;
                break;
            }
            i++;
        }
        Method method4 = method;
        if (method4 != null) {
            return method4;
        }
        Method[] methods = cls.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "methods");
        Method[] methodArr2 = methods;
        int length2 = methodArr2.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length2) {
                method2 = null;
                break;
            }
            Method method5 = methodArr2[i2];
            if (isName.invoke(method5).booleanValue()) {
                method2 = method5;
                break;
            }
            i2++;
        }
        return method2;
    }

    @Nullable
    public static final Field getDeclaredFieldByName(@NotNull Class<?> cls, @NotNull String methodName) {
        Field field;
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Field[] declaredFields = cls.getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "declaredFields");
        Field[] fieldArr = declaredFields;
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            Field it = fieldArr[i];
            if (Intrinsics.areEqual(it.getName(), methodName)) {
                field = it;
                break;
            }
            i++;
        }
        return field;
    }

    @NotNull
    public static final Method[] getMethodsNotDeclaredByObject(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        Method[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
        Method[] methods = cls.getMethods();
        Intrinsics.checkNotNullExpressionValue(methods, "methods");
        Iterable $this$filter$iv = ArraysKt.toSet(ArraysKt.plus((Object[]) declaredMethods, (Object[]) methods));
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (!Intrinsics.areEqual(((Method) element$iv$iv).getDeclaringClass(), Object.class)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Object[] array = ((List) destination$iv$iv).toArray(new Method[0]);
        if (array != null) {
            return (Method[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
