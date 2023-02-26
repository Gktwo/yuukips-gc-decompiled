package org.jline.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlockingInputStreamImpl.class */
public class NonBlockingInputStreamImpl extends NonBlockingInputStream {

    /* renamed from: in */
    private InputStream f3234in;
    private String name;
    private Thread thread;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: b */
    private int f3235b = -2;
    private boolean threadIsReading = false;
    private IOException exception = null;
    private long threadDelay = 60000;

    static {
        $assertionsDisabled = !NonBlockingInputStreamImpl.class.desiredAssertionStatus();
    }

    public NonBlockingInputStreamImpl(String name, InputStream in) {
        this.f3234in = in;
        this.name = name;
    }

    private synchronized void startReadingThreadIfNeeded() {
        if (this.thread == null) {
            this.thread = new Thread(this::run);
            this.thread.setName(this.name + " non blocking reader thread");
            this.thread.setDaemon(true);
            this.thread.start();
        }
    }

    @Override // org.jline.utils.NonBlockingInputStream
    public synchronized void shutdown() {
        if (this.thread != null) {
            notify();
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3234in.close();
        shutdown();
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x008d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x008d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [org.jline.utils.NonBlockingInputStreamImpl, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // org.jline.utils.NonBlockingInputStream
    public synchronized int read(long j, boolean isPeek) throws IOException {
        if (this.exception == null) {
            if (this.f3235b >= -1) {
                if (!$assertionsDisabled && this.exception != null) {
                    throw new AssertionError();
                }
            } else if (isPeek || j > 0 || this.threadIsReading) {
                if (!this.threadIsReading) {
                    this.threadIsReading = true;
                    startReadingThreadIfNeeded();
                    notifyAll();
                }
                boolean isInfinite = j <= 0;
                while (true) {
                    if (!isInfinite && (j == true ? 1 : 0) <= 0) {
                        break;
                    }
                    long start = System.currentTimeMillis();
                    try {
                    } catch (InterruptedException e) {
                        this.exception = (IOException) new InterruptedIOException().initCause(e);
                    }
                    if (Thread.interrupted()) {
                        throw new InterruptedException();
                        break;
                    }
                    wait(j);
                    if (this.exception != null) {
                        if ($assertionsDisabled || this.f3235b == -2) {
                            IOException toBeThrown = this.exception;
                            if (!isPeek) {
                                this.exception = null;
                            }
                            throw toBeThrown;
                        }
                        throw new AssertionError();
                    } else if (this.f3235b >= -1) {
                        if (!$assertionsDisabled && this.exception != null) {
                            throw new AssertionError();
                        }
                    } else if (!isInfinite) {
                        j -= System.currentTimeMillis() - start;
                    }
                }
            } else {
                this.f3235b = this.f3234in.read();
            }
            int ret = this.f3235b;
            if (!isPeek) {
                this.f3235b = -2;
            }
            return ret;
        } else if ($assertionsDisabled || this.f3235b == -2) {
            IOException toBeThrown2 = this.exception;
            if (!isPeek) {
                this.exception = null;
            }
            throw toBeThrown2;
        } else {
            throw new AssertionError();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0024
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void run() {
        /*
        // Method dump skipped, instructions count: 312
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlockingInputStreamImpl.run():void");
    }
}
