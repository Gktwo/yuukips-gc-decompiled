package p013io.javalin.core.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jline.reader.LineReader;

/* compiled from: BaseValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0004\u0018��2\u00060\u0001j\u0002`\u0002B%\u0012\u001e\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004¢\u0006\u0002\u0010\tR)\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00060\u0004¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, m373d2 = {"Lio/javalin/core/validation/ValidationException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", LineReader.ERRORS, "", "", "", "Lio/javalin/core/validation/ValidationError;", "", "(Ljava/util/Map;)V", "getErrors", "()Ljava/util/Map;", "javalin"})
/* renamed from: io.javalin.core.validation.ValidationException */
/* loaded from: grasscutter.jar:io/javalin/core/validation/ValidationException.class */
public final class ValidationException extends RuntimeException {
    @NotNull
    private final Map<String, List<ValidationError<Object>>> errors;

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, ? extends java.util.List<io.javalin.core.validation.ValidationError<java.lang.Object>>> */
    /* JADX WARN: Multi-variable type inference failed */
    public ValidationException(@NotNull Map<String, ? extends List<ValidationError<Object>>> map) {
        Intrinsics.checkNotNullParameter(map, LineReader.ERRORS);
        this.errors = map;
    }

    @NotNull
    public final Map<String, List<ValidationError<Object>>> getErrors() {
        return this.errors;
    }
}
