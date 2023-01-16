package org.jline.utils;

import java.io.IOException;
import java.io.Writer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/NonBlockingPumpReader.class */
public class NonBlockingPumpReader extends NonBlockingReader {
    private static final int DEFAULT_BUFFER_SIZE = 4096;
    private final char[] buffer;
    private int read;
    private int write;
    private int count;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;
    private final Writer writer;
    private boolean closed;

    public NonBlockingPumpReader() {
        this(4096);
    }

    public NonBlockingPumpReader(int bufferSize) {
        this.buffer = new char[bufferSize];
        this.writer = new NbpWriter();
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
    }

    public Writer getWriter() {
        return this.writer;
    }

    @Override // java.io.Reader
    public boolean ready() {
        return available() > 0;
    }

    @Override // org.jline.utils.NonBlockingReader
    public int available() {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            return this.count;
        } finally {
            lock.unlock();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x003c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.jline.utils.NonBlockingReader
    protected int read(long r6, boolean r8) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlockingPumpReader.read(long, boolean):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:16:0x0036
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.jline.utils.NonBlockingReader
    public int readBuffered(char[] r9) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 201
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlockingPumpReader.readBuffered(char[]):int");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x0032
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    void write(char[] r7, int r8, int r9) throws java.io.IOException {
        /*
            r6 = this;
            r0 = r9
            if (r0 <= 0) goto L_0x00ba
            r0 = r6
            java.util.concurrent.locks.ReentrantLock r0 = r0.lock
            r10 = r0
            r0 = r10
            r0.lock()
        L_0x000f:
            r0 = r9
            if (r0 <= 0) goto L_0x00a8
            r0 = r6
            boolean r0 = r0.closed     // Catch: all -> 0x00b0
            if (r0 != 0) goto L_0x0044
            r0 = r6
            int r0 = r0.count     // Catch: all -> 0x00b0
            r1 = r6
            char[] r1 = r1.buffer     // Catch: all -> 0x00b0
            int r1 = r1.length     // Catch: all -> 0x00b0
            if (r0 != r1) goto L_0x0044
            r0 = r6
            java.util.concurrent.locks.Condition r0 = r0.notFull     // Catch: all -> 0x00b0, InterruptedException -> 0x0032
            r0.await()     // Catch: all -> 0x00b0, InterruptedException -> 0x0032
            goto L_0x0044
        L_0x0032:
            r11 = move-exception
            java.io.InterruptedIOException r0 = new java.io.InterruptedIOException     // Catch: all -> 0x00b0
            r1 = r0
            r1.<init>()     // Catch: all -> 0x00b0
            r1 = r11
            java.lang.Throwable r0 = r0.initCause(r1)     // Catch: all -> 0x00b0
            java.io.IOException r0 = (java.io.IOException) r0     // Catch: all -> 0x00b0
            throw r0     // Catch: all -> 0x00b0
        L_0x0044:
            r0 = r6
            boolean r0 = r0.closed     // Catch: all -> 0x00b0
            if (r0 == 0) goto L_0x0055
            java.io.IOException r0 = new java.io.IOException     // Catch: all -> 0x00b0
            r1 = r0
            java.lang.String r2 = "Closed"
            r1.<init>(r2)     // Catch: all -> 0x00b0
            throw r0     // Catch: all -> 0x00b0
        L_0x0055:
            r0 = r9
            if (r0 <= 0) goto L_0x009c
            r0 = r6
            int r0 = r0.count     // Catch: all -> 0x00b0
            r1 = r6
            char[] r1 = r1.buffer     // Catch: all -> 0x00b0
            int r1 = r1.length     // Catch: all -> 0x00b0
            if (r0 >= r1) goto L_0x009c
            r0 = r6
            char[] r0 = r0.buffer     // Catch: all -> 0x00b0
            r1 = r6
            r2 = r1
            int r2 = r2.write     // Catch: all -> 0x00b0
            r3 = r2; r2 = r1; r1 = r3;      // Catch: all -> 0x00b0
            r4 = 1
            int r3 = r3 + r4
            r2.write = r3     // Catch: all -> 0x00b0
            r2 = r7
            r3 = r8
            int r8 = r8 + 1
            char r2 = r2[r3]     // Catch: all -> 0x00b0
            r0[r1] = r2     // Catch: all -> 0x00b0
            r0 = r6
            r1 = r0
            int r1 = r1.count     // Catch: all -> 0x00b0
            r2 = 1
            int r1 = r1 + r2
            r0.count = r1     // Catch: all -> 0x00b0
            int r9 = r9 + -1
            r0 = r6
            int r0 = r0.write     // Catch: all -> 0x00b0
            r1 = r6
            char[] r1 = r1.buffer     // Catch: all -> 0x00b0
            int r1 = r1.length     // Catch: all -> 0x00b0
            if (r0 != r1) goto L_0x0055
            r0 = r6
            r1 = 0
            r0.write = r1     // Catch: all -> 0x00b0
            goto L_0x0055
        L_0x009c:
            r0 = r6
            java.util.concurrent.locks.Condition r0 = r0.notEmpty     // Catch: all -> 0x00b0
            r0.signal()     // Catch: all -> 0x00b0
            goto L_0x000f
        L_0x00a8:
            r0 = r10
            r0.unlock()
            goto L_0x00ba
        L_0x00b0:
            r12 = move-exception
            r0 = r10
            r0.unlock()
            r0 = r12
            throw r0
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.NonBlockingPumpReader.write(char[], int, int):void");
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        ReentrantLock lock = this.lock;
        lock.lock();
        try {
            this.closed = true;
            this.notEmpty.signalAll();
            this.notFull.signalAll();
        } finally {
            lock.unlock();
        }
    }

    /* WARNING: Classes with same name are omitted:
  
 */
    /* loaded from: grasscutter.jar:org/jline/utils/NonBlockingPumpReader$NbpWriter.class */
    private class NbpWriter extends Writer {
        private NbpWriter() {
        }

        @Override // java.io.Writer
        public void write(char[] cbuf, int off, int len) throws IOException {
            NonBlockingPumpReader.this.write(cbuf, off, len);
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() throws IOException {
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            NonBlockingPumpReader.this.close();
        }
    }
}
