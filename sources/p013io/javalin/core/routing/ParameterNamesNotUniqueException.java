package p013io.javalin.core.routing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ParserExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018��2\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, m373d2 = {"Lio/javalin/core/routing/ParameterNamesNotUniqueException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "path", "", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "javalin"})
/* renamed from: io.javalin.core.routing.ParameterNamesNotUniqueException */
/* loaded from: grasscutter.jar:io/javalin/core/routing/ParameterNamesNotUniqueException.class */
public final class ParameterNamesNotUniqueException extends IllegalArgumentException {
    @NotNull
    private final String path;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public ParameterNamesNotUniqueException(@NotNull String path) {
        super("Duplicate path param names detected! This is forbidden. Found in path '" + path + '\'');
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }
}
