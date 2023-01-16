package p013io.javalin.core.validation;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: JavalinValidation.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018��2\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m373d2 = {"Lio/javalin/core/validation/MissingConverterException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "className", "", "(Ljava/lang/String;)V", "getClassName", "()Ljava/lang/String;", "javalin"})
/* renamed from: io.javalin.core.validation.MissingConverterException */
/* loaded from: grasscutter.jar:io/javalin/core/validation/MissingConverterException.class */
public final class MissingConverterException extends RuntimeException {
    @NotNull
    private final String className;

    public MissingConverterException(@NotNull String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        this.className = className;
    }

    @NotNull
    public final String getClassName() {
        return this.className;
    }
}
