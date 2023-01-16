package okhttp3.internal.http2;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;

/* compiled from: TaskQueue.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006��"}, m373d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1.class */
public final class Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1 extends Task {
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ int $payload1$inlined;
    final /* synthetic */ int $payload2$inlined;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public Http2Connection$ReaderRunnable$ping$$inlined$execute$default$1(String $name, boolean $cancelable, Http2Connection http2Connection, int i, int i2) {
        super($name, $cancelable);
        this.$name = $name;
        this.$cancelable = $cancelable;
        this.this$0 = http2Connection;
        this.$payload1$inlined = i;
        this.$payload2$inlined = i2;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.this$0.writePing(true, this.$payload1$inlined, this.$payload2$inlined);
        return -1;
    }
}
