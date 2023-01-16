package p013io.javalin.core.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.core.util.JavalinLogger;
import p013io.javalin.http.InternalServerErrorResponse;

/* compiled from: Validator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��V\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0010��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018�� #*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0001#B'\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bB+\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018��\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\f\u0010\r\u001a\b\u0012\u0004\u0012\u00028��0\u000eJ8\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028��0��2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00028��`\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028��0\u0014J2\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028��0��2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00028��`\u00122\u0006\u0010\u0013\u001a\u00020\u0004J\r\u0010\u0015\u001a\u00028��H\u0017¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00028��2\u0006\u0010\u0018\u001a\u00028��¢\u0006\u0002\u0010\u0019J=\u0010\u001a\u001a\u00028��2.\u0010\u001b\u001a*\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001e0\u00140\u001d0\u001c\u0012\b\u0012\u00060\u001fj\u0002` 0\u0010H\u0017¢\u0006\u0002\u0010!J\u0006\u0010\"\u001a\u00020\u0011¨\u0006$"}, m373d2 = {"Lio/javalin/core/validation/Validator;", "T", "Lio/javalin/core/validation/BaseValidator;", "stringValue", "", "clazz", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V", "typedValue", "stringSource", "Lio/javalin/core/validation/StringSource;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/core/validation/StringSource;)V", "allowNullable", "Lio/javalin/core/validation/NullableValidator;", "check", "Lkotlin/Function1;", "", "Lio/javalin/core/validation/Check;", "error", "Lio/javalin/core/validation/ValidationError;", BeanUtil.PREFIX_GETTER_GET, "()Ljava/lang/Object;", "getOrDefault", "default", "(Ljava/lang/Object;)Ljava/lang/Object;", "getOrThrow", "exceptionFunction", "", "", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "hasValue", "Companion", "javalin"})
/* renamed from: io.javalin.core.validation.Validator */
/* loaded from: grasscutter.jar:io/javalin/core/validation/Validator.class */
public class Validator<T> extends BaseValidator<T> {
    @NotNull
    public static final Companion Companion = new Companion(null);

    @JvmStatic
    @NotNull
    public static final <T> Validator<T> create(@NotNull Class<T> cls, @Nullable String value, @NotNull String fieldName) {
        return Companion.create(cls, value, fieldName);
    }

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public Validator(@NotNull String fieldName, @Nullable T t, @Nullable StringSource<T> stringSource) {
        super(fieldName, t, stringSource);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    public /* synthetic */ Validator(String str, Object obj, StringSource stringSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : stringSource);
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public Validator(@Nullable String stringValue, @NotNull Class<T> cls, @NotNull String fieldName) {
        this(fieldName, (Object) null, new StringSource(stringValue, cls, null, 4, null));
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    @NotNull
    public final NullableValidator<T> allowNullable() {
        if (getRules$javalin().isEmpty()) {
            return new NullableValidator<>(getFieldName(), getTypedValue(), getStringSource());
        }
        throw new IllegalStateException("Validator#allowNullable must be called before adding rules");
    }

    @NotNull
    public final Validator<T> check(@NotNull Function1<? super T, Boolean> function1, @NotNull String error) {
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(error, "error");
        return (Validator) addRule(getFieldName(), new Function1<T, Boolean>(function1) { // from class: io.javalin.core.validation.Validator$check$1
            final /* synthetic */ Function1<T, Boolean> $check;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.$check = r4;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable T t) {
                Function1<T, Boolean> function12 = this.$check;
                Intrinsics.checkNotNull(t);
                return function12.invoke(t);
            }
        }, error);
    }

    @NotNull
    public final Validator<T> check(@NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        return (Validator) addRule(getFieldName(), new Function1<T, Boolean>(function1) { // from class: io.javalin.core.validation.Validator$check$2
            final /* synthetic */ Function1<T, Boolean> $check;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: kotlin.jvm.functions.Function1<? super T, java.lang.Boolean> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.$check = r4;
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@Nullable T t) {
                Function1<T, Boolean> function12 = this.$check;
                Intrinsics.checkNotNull(t);
                return function12.invoke(t);
            }
        }, validationError);
    }

    public final boolean hasValue() {
        StringSource<T> stringSource = getStringSource();
        return ((stringSource == null ? null : stringSource.getStringValue()) == null && getTypedValue() == null) ? false : true;
    }

    @Override // p013io.javalin.core.validation.BaseValidator
    @NotNull
    public T get() {
        T t = get();
        Intrinsics.checkNotNull(t);
        return t;
    }

    public final T getOrDefault(T t) {
        if (!hasValue()) {
            return t;
        }
        T t2 = get();
        Intrinsics.checkNotNull(t2);
        return t2;
    }

    @Override // p013io.javalin.core.validation.BaseValidator
    @NotNull
    public T getOrThrow(@NotNull Function1<? super Map<String, ? extends List<ValidationError<Object>>>, ? extends Exception> function1) {
        Intrinsics.checkNotNullParameter(function1, "exceptionFunction");
        T orThrow = getOrThrow(function1);
        Intrinsics.checkNotNull(orThrow);
        return orThrow;
    }

    /* compiled from: Validator.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00050\u0004\"\u0004\b\u0001\u0010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00050\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\tH\u0007¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/validation/Validator$Companion;", "", "()V", "create", "Lio/javalin/core/validation/Validator;", "T", "clazz", "Ljava/lang/Class;", "value", "", "fieldName", "javalin"})
    /* renamed from: io.javalin.core.validation.Validator$Companion */
    /* loaded from: grasscutter.jar:io/javalin/core/validation/Validator$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final <T> Validator<T> create(@NotNull Class<T> cls, @Nullable String value, @NotNull String fieldName) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            Intrinsics.checkNotNullParameter(fieldName, "fieldName");
            if (JavalinValidation.INSTANCE.hasConverter(cls)) {
                return new Validator<>(value, cls, fieldName);
            }
            JavalinLogger.info$default("Can't convert to " + ((Object) cls.getSimpleName()) + ". Register a converter using JavalinValidation#register.", null, 2, null);
            throw new InternalServerErrorResponse(null, null, 3, null);
        }
    }
}
