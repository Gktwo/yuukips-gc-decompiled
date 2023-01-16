package p013io.javalin.core.validation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: NullableValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\b\u0016\u0018��*\u0004\b��\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B'\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028��0\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0004¢\u0006\u0002\u0010\bB+\u0012\u0006\u0010\u0007\u001a\u00020\u0004\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00018��\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00028��\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ<\u0010\r\u001a\b\u0012\u0004\u0012\u00028��0��2 \u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020\u000f0\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00018��`\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028��0\u0012J6\u0010\r\u001a\b\u0012\u0004\u0012\u00028��0��2 \u0010\r\u001a\u001c\u0012\u0006\u0012\u0004\u0018\u00018��\u0012\u0004\u0012\u00020\u000f0\u000ej\n\u0012\u0006\u0012\u0004\u0018\u00018��`\u00102\u0006\u0010\u0011\u001a\u00020\u0004¨\u0006\u0013"}, m373d2 = {"Lio/javalin/core/validation/NullableValidator;", "T", "Lio/javalin/core/validation/BaseValidator;", "stringValue", "", "clazz", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/String;Ljava/lang/Class;Ljava/lang/String;)V", "typedValue", "stringSource", "Lio/javalin/core/validation/StringSource;", "(Ljava/lang/String;Ljava/lang/Object;Lio/javalin/core/validation/StringSource;)V", "check", "Lkotlin/Function1;", "", "Lio/javalin/core/validation/Check;", "error", "Lio/javalin/core/validation/ValidationError;", "javalin"})
/* renamed from: io.javalin.core.validation.NullableValidator */
/* loaded from: grasscutter.jar:io/javalin/core/validation/NullableValidator.class */
public class NullableValidator<T> extends BaseValidator<T> {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public NullableValidator(@NotNull String fieldName, @Nullable T t, @Nullable StringSource<T> stringSource) {
        super(fieldName, t, stringSource);
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    public /* synthetic */ NullableValidator(String str, Object obj, StringSource stringSource, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : obj, (i & 4) != 0 ? null : stringSource);
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    public NullableValidator(@Nullable String stringValue, @NotNull Class<T> cls, @NotNull String fieldName) {
        this(fieldName, (Object) null, new StringSource(stringValue, cls, null, 4, null));
        Intrinsics.checkNotNullParameter(cls, "clazz");
        Intrinsics.checkNotNullParameter(fieldName, "fieldName");
    }

    @NotNull
    public final NullableValidator<T> check(@NotNull Function1<? super T, Boolean> function1, @NotNull String error) {
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(error, "error");
        return (NullableValidator) addRule(getFieldName(), function1, error);
    }

    @NotNull
    public final NullableValidator<T> check(@NotNull Function1<? super T, Boolean> function1, @NotNull ValidationError<T> validationError) {
        Intrinsics.checkNotNullParameter(function1, "check");
        Intrinsics.checkNotNullParameter(validationError, "error");
        return (NullableValidator) addRule(getFieldName(), function1, validationError);
    }
}
