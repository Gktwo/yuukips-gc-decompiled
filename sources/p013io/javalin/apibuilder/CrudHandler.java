package p013io.javalin.apibuilder;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.Context;

/* compiled from: CrudHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018��2\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\f"}, m373d2 = {"Lio/javalin/apibuilder/CrudHandler;", "", "create", "", "ctx", "Lio/javalin/http/Context;", "delete", "resourceId", "", "getAll", "getOne", "update", "javalin"})
/* renamed from: io.javalin.apibuilder.CrudHandler */
/* loaded from: grasscutter.jar:io/javalin/apibuilder/CrudHandler.class */
public interface CrudHandler {
    void getAll(@NotNull Context context);

    void getOne(@NotNull Context context, @NotNull String str);

    void create(@NotNull Context context);

    void update(@NotNull Context context, @NotNull String str);

    void delete(@NotNull Context context, @NotNull String str);
}
