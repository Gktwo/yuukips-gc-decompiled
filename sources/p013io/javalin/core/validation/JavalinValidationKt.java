package p013io.javalin.core.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinValidation.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"�� \n��\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n��\u001a0\u0010��\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0014\u0012\u0012\u0012\u000e\u0012\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u00040\u00030\u0001*\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006¨\u0006\b"}, m373d2 = {"collectErrors", "", "", "", "Lio/javalin/core/validation/ValidationError;", "", "", "Lio/javalin/core/validation/BaseValidator;", "javalin"})
/* renamed from: io.javalin.core.validation.JavalinValidationKt */
/* loaded from: grasscutter.jar:io/javalin/core/validation/JavalinValidationKt.class */
public final class JavalinValidationKt {
    @NotNull
    public static final Map<String, List<ValidationError<? extends Object>>> collectErrors(@NotNull Iterable<? extends BaseValidator<?>> iterable) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        return JavalinValidation.collectErrors(iterable);
    }
}
