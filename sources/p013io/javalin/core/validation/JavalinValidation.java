package p013io.javalin.core.validation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.Javalin;
import p013io.javalin.http.Context;

/* compiled from: JavalinValidation.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��T\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n��\n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007JE\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00110\u00100\u000f2\u001a\u0010\u0012\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00140\u0013\"\u0006\u0012\u0002\b\u00030\u0014H\u0007¢\u0006\u0002\u0010\u0015J6\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u00110\u00100\u000f2\u0010\u0010\u0012\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u0016H\u0007J)\u0010\u0017\u001a\u0002H\u0018\"\u0004\b��\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u001bJ\u001a\u0010\u001c\u001a\u00020\u001d\"\u0004\b��\u0010\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u0005J:\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00062\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u00052\u0014\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006H\u0007R/\u0010\u0003\u001a \u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00060\u0004¢\u0006\b\n��\u001a\u0004\b\b\u0010\t¨\u0006 "}, m373d2 = {"Lio/javalin/core/validation/JavalinValidation;", "", "()V", "converters", "", "Ljava/lang/Class;", "Lkotlin/Function1;", "", "getConverters", "()Ljava/util/Map;", "addValidationExceptionMapper", "", "app", "Lio/javalin/Javalin;", "collectErrors", "", "", "Lio/javalin/core/validation/ValidationError;", "validators", "", "Lio/javalin/core/validation/BaseValidator;", "([Lio/javalin/core/validation/BaseValidator;)Ljava/util/Map;", "", "convertValue", "T", "clazz", "value", "(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "hasConverter", "", "register", "converter", "javalin"})
/* renamed from: io.javalin.core.validation.JavalinValidation */
/* loaded from: grasscutter.jar:io/javalin/core/validation/JavalinValidation.class */
public final class JavalinValidation {
    @NotNull
    public static final JavalinValidation INSTANCE = new JavalinValidation();
    @NotNull
    private static final Map<Class<?>, Function1<String, Object>> converters = MapsKt.mutableMapOf(Tuples.m366to(Boolean.class, JavalinValidation$converters$1.INSTANCE), Tuples.m366to(Double.class, JavalinValidation$converters$2.INSTANCE), Tuples.m366to(Float.class, JavalinValidation$converters$3.INSTANCE), Tuples.m366to(Integer.class, JavalinValidation$converters$4.INSTANCE), Tuples.m366to(Long.class, JavalinValidation$converters$5.INSTANCE), Tuples.m366to(String.class, JavalinValidation$converters$6.INSTANCE), Tuples.m366to(Boolean.TYPE, JavalinValidation$converters$7.INSTANCE), Tuples.m366to(Double.TYPE, JavalinValidation$converters$8.INSTANCE), Tuples.m366to(Float.TYPE, JavalinValidation$converters$9.INSTANCE), Tuples.m366to(Integer.TYPE, JavalinValidation$converters$10.INSTANCE), Tuples.m366to(Long.TYPE, JavalinValidation$converters$11.INSTANCE), Tuples.m366to(String.class, JavalinValidation$converters$12.INSTANCE));

    private JavalinValidation() {
    }

    @NotNull
    public final Map<Class<?>, Function1<String, Object>> getConverters() {
        return converters;
    }

    public final <T> T convertValue(@NotNull Class<T> cls, @Nullable String value) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Function1 converter = converters.get(cls);
        if (converter == null) {
            String simpleName = cls.getSimpleName();
            Intrinsics.checkNotNullExpressionValue(simpleName, "clazz.simpleName");
            throw new MissingConverterException(simpleName);
        } else if (value != null) {
            return (T) converter.invoke(value);
        } else {
            return null;
        }
    }

    public final <T> boolean hasConverter(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return converters.get(cls) != null;
    }

    @JvmStatic
    @Nullable
    public static final Function1<String, Object> register(@NotNull Class<?> cls, @NotNull Function1<? super String, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(function1, "converter");
        JavalinValidation javalinValidation = INSTANCE;
        return converters.put(cls, function1);
    }

    @JvmStatic
    @NotNull
    public static final Map<String, List<ValidationError<? extends Object>>> collectErrors(@NotNull BaseValidator<?>... baseValidatorArr) {
        Intrinsics.checkNotNullParameter(baseValidatorArr, "validators");
        JavalinValidation javalinValidation = INSTANCE;
        return collectErrors(ArraysKt.toList(baseValidatorArr));
    }

    @JvmStatic
    @NotNull
    public static final Map<String, List<ValidationError<? extends Object>>> collectErrors(@NotNull Iterable<? extends BaseValidator<?>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "validators");
        Collection destination$iv$iv = new ArrayList();
        Iterator<? extends BaseValidator<?>> it = iterable.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(destination$iv$iv, ((BaseValidator) it.next()).errors().entrySet());
        }
        Iterable<Map.Entry> $this$associate$iv = (List) destination$iv$iv;
        Map destination$iv$iv2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16));
        for (Map.Entry it2 : $this$associate$iv) {
            Pair pair = Tuples.m366to(it2.getKey(), it2.getValue());
            destination$iv$iv2.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv2;
    }

    @JvmStatic
    public static final void addValidationExceptionMapper(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.exception(ValidationException.class, JavalinValidation::m5791addValidationExceptionMapper$lambda2);
    }

    /* renamed from: addValidationExceptionMapper$lambda-2  reason: not valid java name */
    private static final void m5791addValidationExceptionMapper$lambda2(ValidationException e, Context ctx) {
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        ctx.json(e.getErrors()).status(400);
    }
}
