package org.eclipse.jetty.p023io;

import java.io.EOFException;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;
import org.eclipse.jetty.util.thread.Scheduler;

/* renamed from: org.eclipse.jetty.io.ByteArrayEndPoint */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/ByteArrayEndPoint.class */
public class ByteArrayEndPoint extends AbstractEndPoint {
    static final Logger LOG;
    static final InetAddress NOIP;
    static final InetSocketAddress NOIPPORT;
    private static final int MAX_BUFFER_SIZE = 2147482623;
    private static final ByteBuffer EOF;
    private final Runnable _runFillable;
    private final Locker _locker;
    private final Condition _hasOutput;
    private final Queue<ByteBuffer> _inQ;
    private final int _outputSize;
    private ByteBuffer _out;
    private boolean _growOutput;

    static {
        InetAddress noip;
        try {
            LOG = Log.getLogger(ByteArrayEndPoint.class);
            noip = null;
            noip = Inet4Address.getByName("0.0.0.0");
        } catch (UnknownHostException e) {
            LOG.warn(e);
        } finally {
            NOIP = noip;
            NOIPPORT = new InetSocketAddress(NOIP, 0);
        }
        EOF = BufferUtil.allocate(0);
    }

    public ByteArrayEndPoint() {
        this((Scheduler) null, 0, (ByteBuffer) null, (ByteBuffer) null);
    }

    public ByteArrayEndPoint(byte[] input, int outputSize) {
        this((Scheduler) null, 0, input != null ? BufferUtil.toBuffer(input) : null, BufferUtil.allocate(outputSize));
    }

    public ByteArrayEndPoint(String input, int outputSize) {
        this((Scheduler) null, 0, input != null ? BufferUtil.toBuffer(input) : null, BufferUtil.allocate(outputSize));
    }

    public ByteArrayEndPoint(Scheduler scheduler, long idleTimeoutMs) {
        this(scheduler, idleTimeoutMs, (ByteBuffer) null, (ByteBuffer) null);
    }

    public ByteArrayEndPoint(Scheduler timer, long idleTimeoutMs, byte[] input, int outputSize) {
        this(timer, idleTimeoutMs, input != null ? BufferUtil.toBuffer(input) : null, BufferUtil.allocate(outputSize));
    }

    public ByteArrayEndPoint(Scheduler timer, long idleTimeoutMs, String input, int outputSize) {
        this(timer, idleTimeoutMs, input != null ? BufferUtil.toBuffer(input) : null, BufferUtil.allocate(outputSize));
    }

    public ByteArrayEndPoint(Scheduler timer, long idleTimeoutMs, ByteBuffer input, ByteBuffer output) {
        super(timer);
        this._runFillable = new Runnable() { // from class: org.eclipse.jetty.io.ByteArrayEndPoint.1
            @Override // java.lang.Runnable
            public void run() {
                ByteArrayEndPoint.this.getFillInterest().fillable();
            }
        };
        this._locker = new Locker();
        this._hasOutput = this._locker.newCondition();
        this._inQ = new ArrayDeque();
        if (BufferUtil.hasContent(input)) {
            addInput(input);
        }
        this._outputSize = output == null ? 1024 : output.capacity();
        this._out = output == null ? BufferUtil.allocate(this._outputSize) : output;
        setIdleTimeout(idleTimeoutMs);
        onOpen();
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    public void doShutdownOutput() {
        doShutdownOutput();
        Locker.Lock lock = this._locker.lock();
        try {
            this._hasOutput.signalAll();
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    public void doClose() {
        doClose();
        Locker.Lock lock = this._locker.lock();
        try {
            this._hasOutput.signalAll();
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public InetSocketAddress getLocalAddress() {
        return NOIPPORT;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public InetSocketAddress getRemoteAddress() {
        return NOIPPORT;
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    protected void onIncompleteFlush() {
    }

    protected void execute(Runnable task) {
        new Thread(task, "BAEPoint-" + Integer.toHexString(hashCode())).start();
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    protected void needsFillInterest() throws IOException {
        Locker.Lock lock = this._locker.lock();
        try {
            if (!isOpen()) {
                throw new ClosedChannelException();
            }
            ByteBuffer in = this._inQ.peek();
            if (BufferUtil.hasContent(in) || isEOF(in)) {
                execute(this._runFillable);
            }
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void addInputEOF() {
        addInput((ByteBuffer) null);
    }

    public void addInput(ByteBuffer in) {
        boolean fillable = false;
        Locker.Lock lock = this._locker.lock();
        try {
            if (isEOF(this._inQ.peek())) {
                throw new RuntimeIOException(new EOFException());
            }
            boolean wasEmpty = this._inQ.isEmpty();
            if (in == null) {
                this._inQ.add(EOF);
                fillable = true;
            }
            if (BufferUtil.hasContent(in)) {
                this._inQ.add(in);
                fillable = wasEmpty;
            }
            if (lock != null) {
                lock.close();
            }
            if (fillable) {
                this._runFillable.run();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void addInputAndExecute(ByteBuffer in) {
        boolean fillable = false;
        Locker.Lock lock = this._locker.lock();
        try {
            if (isEOF(this._inQ.peek())) {
                throw new RuntimeIOException(new EOFException());
            }
            boolean wasEmpty = this._inQ.isEmpty();
            if (in == null) {
                this._inQ.add(EOF);
                fillable = true;
            }
            if (BufferUtil.hasContent(in)) {
                this._inQ.add(in);
                fillable = wasEmpty;
            }
            if (lock != null) {
                lock.close();
            }
            if (fillable) {
                execute(this._runFillable);
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void addInput(String s) {
        addInput(BufferUtil.toBuffer(s, StandardCharsets.UTF_8));
    }

    public void addInput(String s, Charset charset) {
        addInput(BufferUtil.toBuffer(s, charset));
    }

    public ByteBuffer getOutput() {
        Locker.Lock lock = this._locker.lock();
        try {
            ByteBuffer byteBuffer = this._out;
            if (lock != null) {
                lock.close();
            }
            return byteBuffer;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String getOutputString() {
        return getOutputString(StandardCharsets.UTF_8);
    }

    public String getOutputString(Charset charset) {
        return BufferUtil.toString(this._out, charset);
    }

    public ByteBuffer takeOutput() {
        Locker.Lock lock = this._locker.lock();
        try {
            ByteBuffer b = this._out;
            this._out = BufferUtil.allocate(this._outputSize);
            if (lock != null) {
                lock.close();
            }
            getWriteFlusher().completeWrite();
            return b;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public ByteBuffer waitForOutput(long time, TimeUnit unit) throws InterruptedException {
        Locker.Lock lock = this._locker.lock();
        do {
            try {
                if (!BufferUtil.isEmpty(this._out) || isOutputShutdown()) {
                    ByteBuffer b = this._out;
                    this._out = BufferUtil.allocate(this._outputSize);
                    if (lock != null) {
                        lock.close();
                    }
                    getWriteFlusher().completeWrite();
                    return b;
                }
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } while (this._hasOutput.await(time, unit));
        if (lock != null) {
            lock.close();
        }
        return null;
    }

    public String takeOutputString() {
        return takeOutputString(StandardCharsets.UTF_8);
    }

    public String takeOutputString(Charset charset) {
        return BufferUtil.toString(takeOutput(), charset);
    }

    public void setOutput(ByteBuffer out) {
        Locker.Lock lock = this._locker.lock();
        try {
            this._out = out;
            if (lock != null) {
                lock.close();
            }
            getWriteFlusher().completeWrite();
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean hasMore() {
        return getOutput().position() > 0;
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public int fill(ByteBuffer buffer) throws IOException {
        int filled = 0;
        Locker.Lock lock = this._locker.lock();
        while (isOpen()) {
            try {
                if (isInputShutdown()) {
                    if (lock != null) {
                        lock.close();
                    }
                    return -1;
                }
                if (!this._inQ.isEmpty()) {
                    ByteBuffer in = this._inQ.peek();
                    if (isEOF(in)) {
                        filled = -1;
                    } else if (BufferUtil.hasContent(in)) {
                        filled = BufferUtil.append(buffer, in);
                        if (BufferUtil.isEmpty(in)) {
                            this._inQ.poll();
                        }
                    } else {
                        this._inQ.poll();
                    }
                }
                if (lock != null) {
                    lock.close();
                }
                if (filled > 0) {
                    notIdle();
                } else if (filled < 0) {
                    shutdownInput();
                }
                return filled;
            } catch (Throwable th) {
                if (lock != null) {
                    try {
                        lock.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        throw new EofException("CLOSED");
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public boolean flush(ByteBuffer... buffers) throws IOException {
        boolean flushed = true;
        Locker.Lock lock = this._locker.lock();
        try {
            if (!isOpen()) {
                throw new IOException("CLOSED");
            } else if (isOutputShutdown()) {
                throw new IOException("OSHUT");
            } else {
                boolean idle = true;
                int length = buffers.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    ByteBuffer b = buffers[i];
                    if (BufferUtil.hasContent(b)) {
                        if (this._growOutput && b.remaining() > BufferUtil.space(this._out)) {
                            BufferUtil.compact(this._out);
                            if (b.remaining() > BufferUtil.space(this._out) && this._out.capacity() < MAX_BUFFER_SIZE) {
                                ByteBuffer n = BufferUtil.allocate(Math.toIntExact(Math.min((long) (((double) this._out.capacity()) + (((double) b.remaining()) * 1.5d)), 2147482623L)));
                                BufferUtil.append(n, this._out);
                                this._out = n;
                            }
                        }
                        if (BufferUtil.append(this._out, b) > 0) {
                            idle = false;
                        }
                        if (BufferUtil.hasContent(b)) {
                            flushed = false;
                            break;
                        }
                    }
                    i++;
                }
                if (!idle) {
                    notIdle();
                    this._hasOutput.signalAll();
                }
                if (lock != null) {
                    lock.close();
                }
                return flushed;
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint
    public void reset() {
        Locker.Lock lock = this._locker.lock();
        try {
            this._inQ.clear();
            this._hasOutput.signalAll();
            BufferUtil.clear(this._out);
            if (lock != null) {
                lock.close();
            }
            reset();
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.p023io.EndPoint
    public Object getTransport() {
        return null;
    }

    public boolean isGrowOutput() {
        return this._growOutput;
    }

    public void setGrowOutput(boolean growOutput) {
        this._growOutput = growOutput;
    }

    @Override // org.eclipse.jetty.p023io.AbstractEndPoint, java.lang.Object
    public String toString() {
        Locker.Lock lock = this._locker.lock();
        try {
            int q = this._inQ.size();
            ByteBuffer b = this._inQ.peek();
            String o = BufferUtil.toDetailString(this._out);
            if (lock != null) {
                lock.close();
            }
            return String.format("%s[q=%d,q[0]=%s,o=%s]", toString(), Integer.valueOf(q), b, o);
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    private static boolean isEOF(ByteBuffer buffer) {
        return buffer == EOF;
    }
}
