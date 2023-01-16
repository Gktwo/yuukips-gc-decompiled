package okhttp3.internal.http2;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.platform.Platform;

/* compiled from: TaskQueue.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006��"}, m373d2 = {"okhttp3/internal/concurrent/TaskQueue$execute$1", "Lokhttp3/internal/concurrent/Task;", "runOnce", "", "okhttp"})
/* renamed from: okhttp3.internal.http2.Http2Connection$ReaderRunnable$headers$lambda-2$$inlined$execute$default$1 */
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2Connection$ReaderRunnable$headers$lambda-2$$inlined$execute$default$1.class */
public final class C5522x74e0874 extends Task {
    final /* synthetic */ String $name;
    final /* synthetic */ boolean $cancelable;
    final /* synthetic */ Http2Connection this$0;
    final /* synthetic */ Http2Stream $newStream$inlined;

    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public C5522x74e0874(String $name, boolean $cancelable, Http2Connection http2Connection, Http2Stream http2Stream) {
        super($name, $cancelable);
        this.$name = $name;
        this.$cancelable = $cancelable;
        this.this$0 = http2Connection;
        this.$newStream$inlined = http2Stream;
    }

    @Override // okhttp3.internal.concurrent.Task
    public long runOnce() {
        try {
            this.this$0.getListener$okhttp().onStream(this.$newStream$inlined);
            return -1;
        } catch (IOException e) {
            Platform.Companion.get().log(Intrinsics.stringPlus("Http2Connection.Listener failure for ", this.this$0.getConnectionName$okhttp()), 4, e);
            try {
                this.$newStream$inlined.close(ErrorCode.PROTOCOL_ERROR, e);
                return -1;
            } catch (IOException e2) {
                return -1;
            }
        }
    }
}
