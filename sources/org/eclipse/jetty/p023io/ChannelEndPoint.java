package org.eclipse.jetty.p023io;

import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.CancelledKeyException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import org.eclipse.jetty.p023io.ManagedSelector;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Invocable;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.ChannelEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ChannelEndPoint.class */
public abstract class ChannelEndPoint extends AbstractEndPoint implements ManagedSelector.Selectable {
    private static final Logger LOG = Log.getLogger(ChannelEndPoint.class);
    private final SocketChannel _channel;
    private final ManagedSelector _selector;
    private SelectionKey _key;
    private boolean _updatePending;
    private int _currentInterestOps;
    private int _desiredInterestOps;
    private final ManagedSelector.SelectorUpdate _updateKeyAction = this::updateKeyAction;
    private final Runnable _runFillable = new RunnableCloseable("runFillable") { // from class: org.eclipse.jetty.io.ChannelEndPoint.1
        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return ChannelEndPoint.this.getFillInterest().getCallbackInvocationType();
        }

        @Override // java.lang.Runnable
        public void run() {
            ChannelEndPoint.this.getFillInterest().fillable();
        }
    };
    private final Runnable _runCompleteWrite = new RunnableCloseable("runCompleteWrite") { // from class: org.eclipse.jetty.io.ChannelEndPoint.2
        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            return ChannelEndPoint.this.getWriteFlusher().getCallbackInvocationType();
        }

        @Override // java.lang.Runnable
        public void run() {
            ChannelEndPoint.this.getWriteFlusher().completeWrite();
        }

        @Override // org.eclipse.jetty.p023io.ChannelEndPoint.RunnableTask, java.lang.Object
        public String toString() {
            return String.format("CEP:%s:%s:%s->%s", ChannelEndPoint.this, this._operation, getInvocationType(), ChannelEndPoint.this.getWriteFlusher());
        }
    };
    private final Runnable _runCompleteWriteFillable = new RunnableCloseable("runCompleteWriteFillable") { // from class: org.eclipse.jetty.io.ChannelEndPoint.3
        @Override // org.eclipse.jetty.util.thread.Invocable
        public Invocable.InvocationType getInvocationType() {
            Invocable.InvocationType fillT = ChannelEndPoint.this.getFillInterest().getCallbackInvocationType();
            Invocable.InvocationType flushT = ChannelEndPoint.this.getWriteFlusher().getCallbackInvocationType();
            if (fillT == flushT) {
                return fillT;
            }
            if (fillT == Invocable.InvocationType.EITHER && flushT == Invocable.InvocationType.NON_BLOCKING) {
                return Invocable.InvocationType.EITHER;
            }
            if (fillT == Invocable.InvocationType.NON_BLOCKING && flushT == Invocable.InvocationType.EITHER) {
                return Invocable.InvocationType.EITHER;
            }
            return Invocable.InvocationType.BLOCKING;
        }

        @Override // java.lang.Runnable
        public void run() {
            ChannelEndPoint.this.getWriteFlusher().completeWrite();
            ChannelEndPoint.this.getFillInterest().fillable();
        }
    };

    /* renamed from: org.eclipse.jetty.io.ChannelEndPoint$RunnableTask */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ChannelEndPoint$RunnableTask.class */
    private abstract class RunnableTask implements Runnable, Invocable {
        final String _operation;

        protected RunnableTask(String op) {
            this._operation = op;
        }

        @Override // java.lang.Object
        public String toString() {
            return String.format("CEP:%s:%s:%s", ChannelEndPoint.this, this._operation, getInvocationType());
        }
    }

    /* renamed from: org.eclipse.jetty.io.ChannelEndPoint$RunnableCloseable */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/ChannelEndPoint$RunnableCloseable.class */
    private abstract class RunnableCloseable extends RunnableTask implements Closeable {
        protected RunnableCloseable(String op) {
            super(op);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            try {
                ChannelEndPoint.this.close();
            } catch (Throwable x) {
                ChannelEndPoint.LOG.warn(x);
            }
        }
    }

    public ChannelEndPoint(SocketChannel channel, ManagedSelector selector, SelectionKey key, Scheduler scheduler) {
        super(scheduler);
        this._channel = channel;
        this._selector = selector;
        this._key = key;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public InetSocketAddress getLocalAddress() {
        return (InetSocketAddress) this._channel.socket().getLocalSocketAddress();
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public InetSocketAddress getRemoteAddress() {
        return (InetSocketAddress) this._channel.socket().getRemoteSocketAddress();
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.EndPoint
    public boolean isOptimizedForDirectBuffers() {
        return true;
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public boolean isOpen() {
        return this._channel.isOpen();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    public void doShutdownOutput() {
        try {
            Socket socket = this._channel.socket();
            if (!socket.isOutputShutdown()) {
                socket.shutdownOutput();
            }
        } catch (IOException e) {
            LOG.debug(e);
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    public void doClose() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("doClose {}", this);
        }
        try {
            this._key.cancel();
            this._channel.close();
        } catch (IOException e) {
            LOG.debug(e);
        } finally {
            doClose();
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint, org.eclipse.jetty.p023io.IdleTimeout, org.eclipse.jetty.p023io.EndPoint
    public void onClose() {
        try {
            onClose();
            if (this._selector != null) {
                this._selector.destroyEndPoint(this);
            }
        } catch (Throwable th) {
            if (this._selector != null) {
                this._selector.destroyEndPoint(this);
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public int fill(ByteBuffer buffer) throws IOException {
        int pos;
        int filled;
        if (isInputShutdown()) {
            return -1;
        }
        try {
            pos = BufferUtil.flipToFill(buffer);
            try {
                filled = this._channel.read(buffer);
                if (filled > 0) {
                    notIdle();
                } else if (filled == -1) {
                    shutdownInput();
                }
                BufferUtil.flipToFlush(buffer, pos);
            } catch (IOException e) {
                LOG.debug(e);
                shutdownInput();
                filled = -1;
                BufferUtil.flipToFlush(buffer, pos);
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("filled {} {}", Integer.valueOf(filled), BufferUtil.toDetailString(buffer));
            }
            return filled;
        } catch (Throwable th) {
            BufferUtil.flipToFlush(buffer, pos);
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean flush(ByteBuffer... buffers) throws IOException {
        try {
            long flushed = this._channel.write(buffers);
            if (LOG.isDebugEnabled()) {
                LOG.debug("flushed {} {}", Long.valueOf(flushed), this);
            }
            if (flushed > 0) {
                notIdle();
            }
            for (ByteBuffer b : buffers) {
                if (!BufferUtil.isEmpty(b)) {
                    return false;
                }
            }
            return true;
        } catch (IOException e) {
            throw new EofException(e);
        }
    }

    public SocketChannel getChannel() {
        return this._channel;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public Object getTransport() {
        return this._channel;
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    protected void needsFillInterest() {
        changeInterests(1);
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    protected void onIncompleteFlush() {
        changeInterests(4);
    }

    @Override // org.eclipse.jetty.p023io.ManagedSelector.Selectable
    public Runnable onSelected() {
        int oldInterestOps;
        int newInterestOps;
        Runnable task;
        int readyOps = this._key.readyOps();
        synchronized (this) {
            this._updatePending = true;
            oldInterestOps = this._desiredInterestOps;
            newInterestOps = oldInterestOps & (readyOps ^ -1);
            this._desiredInterestOps = newInterestOps;
        }
        boolean fillable = (readyOps & 1) != 0;
        boolean flushable = (readyOps & 4) != 0;
        if (LOG.isDebugEnabled()) {
            LOG.debug("onSelected {}->{} r={} w={} for {}", Integer.valueOf(oldInterestOps), Integer.valueOf(newInterestOps), Boolean.valueOf(fillable), Boolean.valueOf(flushable), this);
        }
        if (fillable) {
            if (flushable) {
                task = this._runCompleteWriteFillable;
            } else {
                task = this._runFillable;
            }
        } else if (flushable) {
            task = this._runCompleteWrite;
        } else {
            task = null;
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("task {}", task);
        }
        return task;
    }

    private void updateKeyAction(Selector selector) {
        updateKey();
    }

    @Override // org.eclipse.jetty.p023io.ManagedSelector.Selectable
    public void updateKey() {
        int oldInterestOps;
        int newInterestOps;
        try {
            synchronized (this) {
                this._updatePending = false;
                oldInterestOps = this._currentInterestOps;
                newInterestOps = this._desiredInterestOps;
                if (oldInterestOps != newInterestOps) {
                    this._currentInterestOps = newInterestOps;
                    this._key.interestOps(newInterestOps);
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Key interests updated {} -> {} on {}", Integer.valueOf(oldInterestOps), Integer.valueOf(newInterestOps), this);
            }
        } catch (CancelledKeyException x) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Ignoring key update for cancelled key {}", this, x);
            }
            close();
        } catch (Throwable x2) {
            LOG.warn("Ignoring key update for {}", this, x2);
            close();
        }
    }

    @Override // org.eclipse.jetty.p023io.ManagedSelector.Selectable
    public void replaceKey(SelectionKey newKey) {
        this._key = newKey;
    }

    private void changeInterests(int operation) {
        boolean pending;
        int oldInterestOps;
        int newInterestOps;
        synchronized (this) {
            pending = this._updatePending;
            oldInterestOps = this._desiredInterestOps;
            newInterestOps = oldInterestOps | operation;
            if (newInterestOps != oldInterestOps) {
                this._desiredInterestOps = newInterestOps;
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("changeInterests p={} {}->{} for {}", Boolean.valueOf(pending), Integer.valueOf(oldInterestOps), Integer.valueOf(newInterestOps), this);
        }
        if (!pending && this._selector != null) {
            this._selector.submit(this._updateKeyAction);
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    public String toEndPointString() {
        return String.format("%s{io=%d/%d,kio=%d,kro=%d}", toEndPointString(), Integer.valueOf(this._currentInterestOps), Integer.valueOf(this._desiredInterestOps), Integer.valueOf(ManagedSelector.safeInterestOps(this._key)), Integer.valueOf(ManagedSelector.safeReadyOps(this._key)));
    }
}
