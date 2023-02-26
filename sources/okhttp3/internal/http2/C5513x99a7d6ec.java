package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import okhttp3.internal.concurrent.Task;

/* compiled from: TaskQueue.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006��"}, m373d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"})
/* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$applyAndAckSettings$lambda-7$lambda-6$$inlined$execute$default$1 */
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$ReaderRunnable$applyAndAckSettings$lambda-7$lambda-6$$inlined$execute$default$1.class */
public final class C5513x99a7d6ec extends Task {
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ Ref.ObjectRef $newPeerSettings$inlined;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public C5513x99a7d6ec(String $name, boolean $cancelable, Http2Connection http2Connection, Ref.ObjectRef objectRef) {
        super($name, $cancelable);
        this.$name = $name;
        this.$cancelable = $cancelable;
        this.this$0 = http2Connection;
        this.$newPeerSettings$inlined = objectRef;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.this$0.getListener$okhttp().onSettings(this.this$0, (Settings) this.$newPeerSettings$inlined.element);
        return -1;
    }
}
