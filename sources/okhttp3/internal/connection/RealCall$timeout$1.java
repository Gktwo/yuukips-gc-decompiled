package okhttp3.internal.connection;

import kotlin.Metadata;
import okio.AsyncTimeout;

/* compiled from: RealCall.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n��*\u0001��\b\n\u0018��2\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0014¨\u0006\u0004"}, m373d2 = {"okhttp3/internal/connection/RealCall$timeout$1", "Lokio/AsyncTimeout;", "timedOut", "", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/connection/RealCall$timeout$1.class */
public final class RealCall$timeout$1 extends AsyncTimeout {
    final /* synthetic */ RealCall this$0;

    /* access modifiers changed from: package-private */
    public RealCall$timeout$1(RealCall $receiver) {
        this.this$0 = $receiver;
    }

    @Override // okio.AsyncTimeout
    protected void timedOut() {
        this.this$0.cancel();
    }
}
