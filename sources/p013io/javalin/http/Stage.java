package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: JavalinServletHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��L\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n��\b\b\u0018��2\u00020\u0001Bx\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012_\u0010\u0006\u001a[\u0012\u0004\u0012\u00020\b\u0012B\u0012@\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b\u0012\u0004\u0012\u00020\n0\tj\u0011`\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\u0007j\u0002`\u000f¢\u0006\u0002\b\u0010¢\u0006\u0002\u0010\u0011J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003Jb\u0010\u001a\u001a[\u0012\u0004\u0012\u00020\b\u0012B\u0012@\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b\u0012\u0004\u0012\u00020\n0\tj\u0011`\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\u0007j\u0002`\u000f¢\u0006\u0002\b\u0010HÆ\u0003J\u0001\u0010\u001b\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052a\b\u0002\u0010\u0006\u001a[\u0012\u0004\u0012\u00020\b\u0012B\u0012@\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b\u0012\u0004\u0012\u00020\n0\tj\u0011`\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\u0007j\u0002`\u000f¢\u0006\u0002\b\u0010HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0012\u0010\u0013Rj\u0010\u0006\u001a[\u0012\u0004\u0012\u00020\b\u0012B\u0012@\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n0\tj\u0002`\u000b\u0012\u0004\u0012\u00020\n0\tj\u0011`\f¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e¢\u0006\f\b\r\u0012\b\b\u0002\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\n0\u0007j\u0002`\u000f¢\u0006\u0002\b\u0010¢\u0006\b\n��\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0016\u0010\u0017¨\u0006\""}, m373d2 = {"Lio/javalin/http/Stage;", "", "name", "Lio/javalin/http/StageName;", "haltsOnError", "", "initializer", "Lkotlin/Function2;", "Lio/javalin/http/JavalinServletHandler;", "Lkotlin/Function1;", "", "Lio/javalin/http/TaskHandler;", "Lio/javalin/http/SubmitTask;", "Lkotlin/ParameterName;", "submitTask", "Lio/javalin/http/StageInitializer;", "Lkotlin/ExtensionFunctionType;", "(Lio/javalin/http/StageName;ZLkotlin/jvm/functions/Function2;)V", "getHaltsOnError", "()Z", "getInitializer", "()Lkotlin/jvm/functions/Function2;", "getName", "()Lio/javalin/http/StageName;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", Printer.TO_STRING, "", "javalin"})
/* renamed from: io.javalin.http.Stage */
/* loaded from: grasscutter.jar:io/javalin/http/Stage.class */
public final class Stage {
    @NotNull
    private final StageName name;
    private final boolean haltsOnError;
    @NotNull
    private final Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>, Unit> initializer;

    @NotNull
    public final StageName component1() {
        return this.name;
    }

    public final boolean component2() {
        return this.haltsOnError;
    }

    @NotNull
    public final Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>, Unit> component3() {
        return this.initializer;
    }

    @NotNull
    public final Stage copy(@NotNull StageName name, boolean haltsOnError, @NotNull Function2<? super JavalinServletHandler, ? super Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>, Unit> function2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function2, "initializer");
        return new Stage(name, haltsOnError, function2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: io.javalin.http.Stage */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Stage copy$default(Stage stage, StageName stageName, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            stageName = stage.name;
        }
        if ((i & 2) != 0) {
            z = stage.haltsOnError;
        }
        if ((i & 4) != 0) {
            function2 = stage.initializer;
        }
        return stage.copy(stageName, z, function2);
    }

    @NotNull
    public String toString() {
        return "Stage(name=" + this.name + ", haltsOnError=" + this.haltsOnError + ", initializer=" + this.initializer + ')';
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        boolean z = this.haltsOnError;
        if (z) {
            z = true;
        }
        int i = z ? 1 : 0;
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        return ((hashCode + i) * 31) + this.initializer.hashCode();
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Stage)) {
            return false;
        }
        Stage stage = (Stage) other;
        return Intrinsics.areEqual(this.name, stage.name) && this.haltsOnError == stage.haltsOnError && Intrinsics.areEqual(this.initializer, stage.initializer);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super io.javalin.http.JavalinServletHandler, ? super kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit>, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public Stage(@NotNull StageName name, boolean haltsOnError, @NotNull Function2<? super JavalinServletHandler, ? super Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>, Unit> function2) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function2, "initializer");
        this.name = name;
        this.haltsOnError = haltsOnError;
        this.initializer = function2;
    }

    public /* synthetic */ Stage(StageName stageName, boolean z, Function2 function2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(stageName, (i & 2) != 0 ? true : z, function2);
    }

    @NotNull
    public final StageName getName() {
        return this.name;
    }

    public final boolean getHaltsOnError() {
        return this.haltsOnError;
    }

    @NotNull
    public final Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>, Unit> getInitializer() {
        return this.initializer;
    }
}
