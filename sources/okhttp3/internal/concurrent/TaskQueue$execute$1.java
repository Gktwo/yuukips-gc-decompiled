package okhttp3.internal.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: TaskQueue.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 176, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, m373d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/concurrent/TaskQueue$execute$1.class */
public final class TaskQueue$execute$1 extends Task {
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ Function0<Unit> $block;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public TaskQueue$execute$1(String $name, boolean $cancelable, Function0<Unit> function0) {
        super($name, $cancelable);
        this.$name = $name;
        this.$cancelable = $cancelable;
        this.$block = function0;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.$block.invoke();
        return -1;
    }
}
