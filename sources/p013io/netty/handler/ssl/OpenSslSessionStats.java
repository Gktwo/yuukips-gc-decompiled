package p013io.netty.handler.ssl;

import io.netty.internal.tcnative.SSLContext;
import java.util.concurrent.locks.Lock;

/* renamed from: io.netty.handler.ssl.OpenSslSessionStats */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/OpenSslSessionStats.class */
public final class OpenSslSessionStats {
    private final ReferenceCountedOpenSslContext context;

    /* access modifiers changed from: package-private */
    public OpenSslSessionStats(ReferenceCountedOpenSslContext context) {
        this.context = context;
    }

    public long number() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionNumber = SSLContext.sessionNumber(this.context.ctx);
            readerLock.unlock();
            return sessionNumber;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long connect() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionConnect = SSLContext.sessionConnect(this.context.ctx);
            readerLock.unlock();
            return sessionConnect;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long connectGood() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionConnectGood = SSLContext.sessionConnectGood(this.context.ctx);
            readerLock.unlock();
            return sessionConnectGood;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long connectRenegotiate() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionConnectRenegotiate = SSLContext.sessionConnectRenegotiate(this.context.ctx);
            readerLock.unlock();
            return sessionConnectRenegotiate;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long accept() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionAccept = SSLContext.sessionAccept(this.context.ctx);
            readerLock.unlock();
            return sessionAccept;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long acceptGood() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionAcceptGood = SSLContext.sessionAcceptGood(this.context.ctx);
            readerLock.unlock();
            return sessionAcceptGood;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long acceptRenegotiate() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionAcceptRenegotiate = SSLContext.sessionAcceptRenegotiate(this.context.ctx);
            readerLock.unlock();
            return sessionAcceptRenegotiate;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long hits() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionHits = SSLContext.sessionHits(this.context.ctx);
            readerLock.unlock();
            return sessionHits;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long cbHits() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionCbHits = SSLContext.sessionCbHits(this.context.ctx);
            readerLock.unlock();
            return sessionCbHits;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long misses() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionMisses = SSLContext.sessionMisses(this.context.ctx);
            readerLock.unlock();
            return sessionMisses;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long timeouts() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionTimeouts = SSLContext.sessionTimeouts(this.context.ctx);
            readerLock.unlock();
            return sessionTimeouts;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long cacheFull() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionCacheFull = SSLContext.sessionCacheFull(this.context.ctx);
            readerLock.unlock();
            return sessionCacheFull;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long ticketKeyFail() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionTicketKeyFail = SSLContext.sessionTicketKeyFail(this.context.ctx);
            readerLock.unlock();
            return sessionTicketKeyFail;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long ticketKeyNew() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionTicketKeyNew = SSLContext.sessionTicketKeyNew(this.context.ctx);
            readerLock.unlock();
            return sessionTicketKeyNew;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long ticketKeyRenew() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionTicketKeyRenew = SSLContext.sessionTicketKeyRenew(this.context.ctx);
            readerLock.unlock();
            return sessionTicketKeyRenew;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }

    public long ticketKeyResume() {
        Lock readerLock = this.context.ctxLock.readLock();
        readerLock.lock();
        try {
            long sessionTicketKeyResume = SSLContext.sessionTicketKeyResume(this.context.ctx);
            readerLock.unlock();
            return sessionTicketKeyResume;
        } catch (Throwable th) {
            readerLock.unlock();
            throw th;
        }
    }
}
