package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: JavalinServletHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\b\b\u0018��2\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bHÆ\u0003J-\u0010\u0010\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bHÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, m373d2 = {"Lio/javalin/http/Task;", "", "stage", "Lio/javalin/http/Stage;", "handler", "Lkotlin/Function1;", "Lio/javalin/http/JavalinServletHandler;", "", "Lio/javalin/http/TaskHandler;", "(Lio/javalin/http/Stage;Lkotlin/jvm/functions/Function1;)V", "getHandler", "()Lkotlin/jvm/functions/Function1;", "getStage", "()Lio/javalin/http/Stage;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", Printer.TO_STRING, "", "javalin"})
/* renamed from: io.javalin.http.Task */
/* loaded from: grasscutter.jar:io/javalin/http/Task.class */
public final class Task {
    @NotNull
    private final Stage stage;
    @NotNull
    private final Function1<JavalinServletHandler, Unit> handler;

    @NotNull
    public final Stage component1() {
        return this.stage;
    }

    @NotNull
    public final Function1<JavalinServletHandler, Unit> component2() {
        return this.handler;
    }

    @NotNull
    public final Task copy(@NotNull Stage stage, @NotNull Function1<? super JavalinServletHandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(function1, "handler");
        return new Task(stage, function1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.javalin.http.Task */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Task copy$default(Task task, Stage stage, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            stage = task.stage;
        }
        if ((i & 2) != 0) {
            function1 = task.handler;
        }
        return task.copy(stage, function1);
    }

    @NotNull
    public String toString() {
        return "Task(stage=" + this.stage + ", handler=" + this.handler + ')';
    }

    public int hashCode() {
        return (this.stage.hashCode() * 31) + this.handler.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Task)) {
            return false;
        }
        Task task = (Task) other;
        return Intrinsics.areEqual(this.stage, task.stage) && Intrinsics.areEqual(this.handler, task.handler);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public Task(@NotNull Stage stage, @NotNull Function1<? super JavalinServletHandler, Unit> function1) {
        Intrinsics.checkNotNullParameter(stage, "stage");
        Intrinsics.checkNotNullParameter(function1, "handler");
        this.stage = stage;
        this.handler = function1;
    }

    @NotNull
    public final Stage getStage() {
        return this.stage;
    }

    @NotNull
    public final Function1<JavalinServletHandler, Unit> getHandler() {
        return this.handler;
    }
}
