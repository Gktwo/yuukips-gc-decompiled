package p013io.javalin.core.routing;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: ParserExceptions.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018��2\u00060\u0001j\u0002`\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, m373d2 = {"Lio/javalin/core/routing/MissingBracketsException;", "Ljava/lang/IllegalArgumentException;", "Lkotlin/IllegalArgumentException;", "segment", "", "path", "(Ljava/lang/String;Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "javalin"})
/* renamed from: io.javalin.core.routing.MissingBracketsException */
/* loaded from: grasscutter.jar:io/javalin/core/routing/MissingBracketsException.class */
public final class MissingBracketsException extends IllegalArgumentException {
    @NotNull
    private final String path;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public MissingBracketsException(@NotNull String segment, @NotNull String path) {
        super("This segment '" + segment + "' is missing some brackets! Found in path '" + path + '\'');
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }
}
