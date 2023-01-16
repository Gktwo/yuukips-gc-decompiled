package okhttp3.internal.http2;

import kotlin.Metadata;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.http2.Http2Connection;

/* compiled from: TaskQueue.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006��"}, m373d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"})
/* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1 */
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$ReaderRunnable$settings$$inlined$execute$default$1.class */
public final class C5523x8b30c3bb extends Task {
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ Http2Connection.ReaderRunnable this$0;
    final /* synthetic */ boolean $clearPrevious$inlined;
    final /* synthetic */ Settings $settings$inlined;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public C5523x8b30c3bb(String $name, boolean $cancelable, Http2Connection.ReaderRunnable readerRunnable, boolean z, Settings settings) {
        super($name, $cancelable);
        this.$name = $name;
        this.$cancelable = $cancelable;
        this.this$0 = readerRunnable;
        this.$clearPrevious$inlined = z;
        this.$settings$inlined = settings;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        this.this$0.applyAndAckSettings(this.$clearPrevious$inlined, this.$settings$inlined);
        return -1;
    }
}
