package org.eclipse.jetty.p023io;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadPendingException;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;

/* renamed from: org.eclipse.jetty.io.FillInterest */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/FillInterest.class */
public abstract class FillInterest {
    private static final Logger LOG = Log.getLogger(FillInterest.class);
    private final AtomicReference<Callback> _interested = new AtomicReference<>(null);

    protected abstract void needsFillInterest() throws IOException;

    public void register(Callback callback) throws ReadPendingException {
        if (!tryRegister(callback)) {
            LOG.warn("Read pending for {} prevented {}", this._interested, callback);
            throw new ReadPendingException();
        }
    }

    public boolean tryRegister(Callback callback) {
        if (callback == null) {
            throw new IllegalArgumentException();
        } else if (!this._interested.compareAndSet(null, callback)) {
            return false;
        } else {
            if (LOG.isDebugEnabled()) {
                LOG.debug("interested {}", this);
            }
            try {
                needsFillInterest();
                return true;
            } catch (Throwable e) {
                onFail(e);
                return true;
            }
        }
    }

    public boolean fillable() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("fillable {}", this);
        }
        Callback callback = this._interested.get();
        if (callback != null && this._interested.compareAndSet(callback, null)) {
            callback.succeeded();
            return true;
        } else if (!LOG.isDebugEnabled()) {
            return false;
        } else {
            LOG.debug("{} lost race {}", this, callback);
            return false;
        }
    }

    public boolean isInterested() {
        return this._interested.get() != null;
    }

    public Invocable.InvocationType getCallbackInvocationType() {
        return Invocable.getInvocationType(this._interested.get());
    }

    public boolean onFail(Throwable cause) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onFail " + this, cause);
        }
        Callback callback = this._interested.get();
        if (callback == null || !this._interested.compareAndSet(callback, null)) {
            return false;
        }
        callback.failed(cause);
        return true;
    }

    public void onClose() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onClose {}", this);
        }
        Callback callback = this._interested.get();
        if (callback != null && this._interested.compareAndSet(callback, null)) {
            callback.failed(new ClosedChannelException());
        }
    }

    public String toString() {
        return String.format("FillInterest@%x{%s}", Integer.valueOf(hashCode()), this._interested.get());
    }

    public String toStateString() {
        return this._interested.get() == null ? "-" : "FI";
    }
}
