package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSL;
import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* renamed from: io.netty.handler.ssl.OpenSslServerSessionContext */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslServerSessionContext.class */
public final class OpenSslServerSessionContext extends OpenSslSessionContext {
    /* access modifiers changed from: package-private */
    public OpenSslServerSessionContext(ReferenceCountedOpenSslContext context, OpenSslKeyMaterialProvider provider) {
        super(context, provider, SSL.SSL_SESS_CACHE_SERVER, new OpenSslSessionCache(context.engineMap));
    }

    public boolean setSessionIdContext(byte[] sidCtx) {
        Lock writerLock = this.context.ctxLock.writeLock();
        writerLock.lock();
        try {
            boolean sessionIdContext = SSLContext.setSessionIdContext(this.context.ctx, sidCtx);
            writerLock.unlock();
            return sessionIdContext;
        } catch (Throwable th) {
            writerLock.unlock();
            throw th;
        }
    }
}
