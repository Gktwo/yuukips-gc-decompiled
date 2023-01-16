package p013io.javalin.core.validation;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinValidation.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010��\n��\n\u0002\u0010\u000e\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "s", ""})
/* renamed from: io.javalin.core.validation.JavalinValidation$converters$10 */
/* loaded from: grasscutter.jar:io/javalin/core/validation/JavalinValidation$converters$10.class */
final class JavalinValidation$converters$10 extends Lambda implements Function1<String, Object> {
    public static final JavalinValidation$converters$10 INSTANCE = new JavalinValidation$converters$10();

    JavalinValidation$converters$10() {
        super(1);
    }

    @NotNull
    public final Object invoke(@NotNull String s) {
        Intrinsics.checkNotNullParameter(s, "s");
        return Integer.valueOf(Integer.parseInt(s));
    }
}
