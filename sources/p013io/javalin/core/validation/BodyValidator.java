package p013io.javalin.core.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.plugin.json.JsonMapper;

/* compiled from: BodyValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��N\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0010��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B%\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ8\u0010\n\u001a\b\u0012\u0004\u0012\u00028��0��2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00028��`\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028��0\u000fJ2\u0010\n\u001a\b\u0012\u0004\u0012\u00028��0��2\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00028��`\r2\u0006\u0010\u000e\u001a\u00020\u0004J@\u0010\n\u001a\b\u0012\u0004\u0012\u00028��0��2\u0006\u0010\u0010\u001a\u00020\u00042\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00028��`\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028��0\u000fJ:\u0010\n\u001a\b\u0012\u0004\u0012\u00028��0��2\u0006\u0010\u0010\u001a\u00020\u00042\u001c\u0010\n\u001a\u0018\u0012\u0004\u0012\u00028��\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00028��`\r2\u0006\u0010\u000e\u001a\u00020\u0004J\r\u0010\u0011\u001a\u00028��H\u0017¢\u0006\u0002\u0010\u0012J=\u0010\u0013\u001a\u00028��2.\u0010\u0014\u001a*\u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u000f0\u00160\u0015\u0012\b\u0012\u00060\u0018j\u0002`\u00190\u000bH\u0017¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, m373d2 = {"Lio/javalin/core/validation/BodyValidator;", "T", "Lio/javalin/core/validation/BaseValidator;", "stringValue", "", "clazz", "Ljava/lang/Class;", "jsonMapper", "Lio/javalin/plugin/json/JsonMapper;", "(Ljava/lang/String;Ljava/lang/Class;Lio/javalin/plugin/json/JsonMapper;)V", "check", "Lkotlin/Function1;", "", "Lio/javalin/core/validation/Check;", "error", "Lio/javalin/core/validation/ValidationError;", "fieldName", BeanUtil.PREFIX_GETTER_GET, "()Ljava/lang/Object;", "getOrThrow", "exceptionFunction", "", "", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "javalin"})
/* renamed from: io.javalin.core.validation.BodyValidator */
/* loaded from: grasscutter.jar:io/javalin/core/validation/BodyValidator.class */
public class BodyValidator<T> extends BaseValidator<T> {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public BodyValidator(@Nullable String stringValue, @NotNull Class<T> cls, @NotNull JsonMapper jsonMapper) {
        super(stringValue, cls, BodyValidatorKt.REQUEST_BODY, jsonMapper);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(jsonMapper, "jsonMapper");
    }

    @NotNull
    public final BodyValidator<T> check(@NotNull Function1<? super T, Boolean> function1, @NotNull String error) {
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(error, "error");
        return check(BodyValidatorKt.REQUEST_BODY, function1, error);
    }

    @NotNull
    public final BodyValidator<T> check(@NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        return check(BodyValidatorKt.REQUEST_BODY, function1, validationError);
    }

    @NotNull
    public final BodyValidator<T> check(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> function1, @NotNull String error) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(error, "error");
        return (BodyValidator) addRule(fieldName, new Function1<T, Boolean>(function1) { // from class: io.javalin.core.validation.BodyValidator$check$1
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
    public final BodyValidator<T> check(@NotNull String fieldName, @NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        return (BodyValidator) addRule(fieldName, new Function1<T, Boolean>(function1) { // from class: io.javalin.core.validation.BodyValidator$check$2
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

    @Override // p013io.javalin.core.validation.BaseValidator
    @NotNull
    public T get() {
        T t = get();
        Intrinsics.checkNotNull(t);
        return t;
    }

    @Override // p013io.javalin.core.validation.BaseValidator
    @NotNull
    public T getOrThrow(@NotNull Function1<? super Map<String, ? extends List<ValidationError<Object>>>, ? extends Exception> function1) {
        Intrinsics.checkNotNullParameter(function1, "exceptionFunction");
        T orThrow = getOrThrow(function1);
        Intrinsics.checkNotNull(orThrow);
        return orThrow;
    }
}
