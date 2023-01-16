package org.jline.utils;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.Reader;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlockingReaderImpl.class */
public class NonBlockingReaderImpl extends NonBlockingReader {
    public static final int READ_EXPIRED = -2;

    /* renamed from: in */
    private Reader f3272in;
    private String name;
    private Thread thread;
    static final /* synthetic */ boolean $assertionsDisabled;

    /* renamed from: ch */
    private int f3273ch = -2;
    private boolean threadIsReading = false;
    private IOException exception = null;
    private long threadDelay = 60000;

    static {
        $assertionsDisabled = !NonBlockingReaderImpl.class.desiredAssertionStatus();
    }

    public NonBlockingReaderImpl(String name, Reader in) {
        this.f3272in = in;
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

    @Override // org.jline.utils.NonBlockingReader
    public synchronized void shutdown() {
        if (this.thread != null) {
            notify();
        }
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f3272in.close();
        shutdown();
    }

    @Override // java.io.Reader
    public synchronized boolean ready() throws IOException {
        return this.f3273ch >= 0 || this.f3272in.ready();
    }

    @Override // org.jline.utils.NonBlockingReader
    public int readBuffered(char[] b) throws IOException {
        if (b == null) {
            throw new NullPointerException();
        } else if (b.length == 0) {
            return 0;
        } else {
            if (this.exception != null) {
                if ($assertionsDisabled || this.f3273ch == -2) {
                    IOException toBeThrown = this.exception;
                    this.exception = null;
                    throw toBeThrown;
                }
                throw new AssertionError();
            } else if (this.f3273ch >= -1) {
                b[0] = (char) this.f3273ch;
                this.f3273ch = -2;
                return 1;
            } else if (!this.threadIsReading) {
                return this.f3272in.read(b);
            } else {
                int c = read(-1, false);
                if (c < 0) {
                    return -1;
                }
                b[0] = (char) c;
                return 1;
            }
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:86:0x008d */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:87:0x008d */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0, types: [java.lang.Object, org.jline.utils.NonBlockingReaderImpl] */
    /* JADX WARN: Type inference failed for: r8v0, types: [long] */
    /* JADX WARN: Type inference failed for: r8v1, types: [long] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    /* JADX WARN: Type inference failed for: r8v3 */
    @Override // org.jline.utils.NonBlockingReader
    protected synchronized int read(long j, boolean isPeek) throws IOException {
        if (this.exception == null) {
            if (this.f3273ch >= -1) {
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
                        if ($assertionsDisabled || this.f3273ch == -2) {
                            IOException toBeThrown = this.exception;
                            if (!isPeek) {
                                this.exception = null;
                            }
                            throw toBeThrown;
                        }
                        throw new AssertionError();
                    } else if (this.f3273ch >= -1) {
                        if (!$assertionsDisabled && this.exception != null) {
                            throw new AssertionError();
                        }
                    } else if (!isInfinite) {
                        j -= System.currentTimeMillis() - start;
                    }
                }
            } else {
                this.f3273ch = this.f3272in.read();
            }
            int ret = this.f3273ch;
            if (!isPeek) {
                this.f3273ch = -2;
            }
            return ret;
        } else if ($assertionsDisabled || this.f3273ch == -2) {
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
        // Method dump skipped, instructions count: 266
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlockingReaderImpl.run():void");
    }

    public synchronized void clear() throws IOException {
        while (ready()) {
            read();
        }
    }
}
