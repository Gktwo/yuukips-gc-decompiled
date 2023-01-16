package okio;

import java.io.Closeable;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: FileHandle.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018��2\u00060\u0001j\u0002`\u0002:\u0002()B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000eH$J\b\u0010\u0016\u001a\u00020\u000eH$J(\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J\u0010\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011H$J\b\u0010\u001f\u001a\u00020\u0011H$J(\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH$J&\u0010!\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010!\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010#\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010$\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010%\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001e\u001a\u00020\u0011J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u0011J&\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bJ\u001e\u0010&\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011J \u0010'\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\"2\u0006\u0010\u001c\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006*"}, m373d2 = {"Lokio/FileHandle;", "Ljava/io/Closeable;", "Lokio/Closeable;", "readWrite", "", "(Z)V", "closed", "openStreamCount", "", "getReadWrite", "()Z", "appendingSink", "Lokio/Sink;", "close", "", "flush", "position", "", "sink", "source", "Lokio/Source;", "protectedClose", "protectedFlush", "protectedRead", "fileOffset", "array", "", "arrayOffset", "byteCount", "protectedResize", "size", "protectedSize", "protectedWrite", "read", "Lokio/Buffer;", "readNoCloseCheck", "reposition", "resize", "write", "writeNoCloseCheck", "FileHandleSink", "FileHandleSource", "okio"})
/* loaded from: grasscutter.jar:okio/FileHandle.class */
public abstract class FileHandle implements Closeable {
    private final boolean readWrite;
    private boolean closed;
    private int openStreamCount;

    protected abstract int protectedRead(long j, @NotNull byte[] bArr, int i, int i2) throws IOException;

    protected abstract void protectedWrite(long j, @NotNull byte[] bArr, int i, int i2) throws IOException;

    protected abstract void protectedFlush() throws IOException;

    protected abstract void protectedResize(long j) throws IOException;

    protected abstract long protectedSize() throws IOException;

    protected abstract void protectedClose() throws IOException;

    public FileHandle(boolean readWrite) {
        this.readWrite = readWrite;
    }

    public final boolean getReadWrite() {
        return this.readWrite;
    }

    public final int read(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(array, "array");
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return protectedRead(fileOffset, array, arrayOffset, byteCount);
    }

    public final long read(long fileOffset, @NotNull Buffer sink, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return readNoCloseCheck(fileOffset, sink, byteCount);
    }

    public final long size() throws IOException {
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        return protectedSize();
    }

    public final void resize(long size) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        protectedResize(size);
    }

    public final void write(long fileOffset, @NotNull byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(array, "array");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        protectedWrite(fileOffset, array, arrayOffset, byteCount);
    }

    public final void write(long fileOffset, @NotNull Buffer source, long byteCount) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        writeNoCloseCheck(fileOffset, source, byteCount);
    }

    public final void flush() throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            Unit unit = Unit.INSTANCE;
        }
        protectedFlush();
    }

    public static /* synthetic */ Source source$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: source");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        return fileHandle.source(j);
    }

    @NotNull
    public final Source source(long fileOffset) throws IOException {
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
        }
        return new FileHandleSource(this, fileOffset);
    }

    /* JADX WARN: Type inference failed for: r0v42, types: [long] */
    public final long position(@NotNull Source source) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Source source2 = source;
        char c = 0;
        if (source2 instanceof RealBufferedSource) {
            c = ((RealBufferedSource) source2).bufferField.size();
            source2 = ((RealBufferedSource) source2).source;
        }
        if (!((source2 instanceof FileHandleSource) && ((FileHandleSource) source2).getFileHandle() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if (!((FileHandleSource) source2).getClosed()) {
            return ((FileHandleSource) source2).getPosition() - c;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void reposition(@NotNull Source source, long position) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source instanceof RealBufferedSource) {
            Source fileHandleSource = ((RealBufferedSource) source).source;
            if (!((fileHandleSource instanceof FileHandleSource) && ((FileHandleSource) fileHandleSource).getFileHandle() == this)) {
                throw new IllegalArgumentException("source was not created by this FileHandle".toString());
            }
            if (!(!((FileHandleSource) fileHandleSource).getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            long bufferSize = ((RealBufferedSource) source).bufferField.size();
            long toSkip = position - (((FileHandleSource) fileHandleSource).getPosition() - bufferSize);
            if (0 <= toSkip ? toSkip < bufferSize : false) {
                ((RealBufferedSource) source).skip(toSkip);
                return;
            }
            ((RealBufferedSource) source).bufferField.clear();
            ((FileHandleSource) fileHandleSource).setPosition(position);
            return;
        }
        if (!((source instanceof FileHandleSource) && ((FileHandleSource) source).getFileHandle() == this)) {
            throw new IllegalArgumentException("source was not created by this FileHandle".toString());
        }
        if (!(!((FileHandleSource) source).getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        ((FileHandleSource) source).setPosition(position);
    }

    public static /* synthetic */ Sink sink$default(FileHandle fileHandle, long j, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i & 1) != 0) {
            j = 0;
        }
        return fileHandle.sink(j);
    }

    @NotNull
    public final Sink sink(long fileOffset) throws IOException {
        if (!this.readWrite) {
            throw new IllegalStateException("file handle is read-only".toString());
        }
        synchronized (this) {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.openStreamCount++;
        }
        return new FileHandleSink(this, fileOffset);
    }

    @NotNull
    public final Sink appendingSink() throws IOException {
        return sink(size());
    }

    /* JADX WARN: Type inference failed for: r0v42, types: [long] */
    public final long position(@NotNull Sink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        Sink sink2 = sink;
        char c = 0;
        if (sink2 instanceof RealBufferedSink) {
            c = ((RealBufferedSink) sink2).bufferField.size();
            sink2 = ((RealBufferedSink) sink2).sink;
        }
        if (!((sink2 instanceof FileHandleSink) && ((FileHandleSink) sink2).getFileHandle() == this)) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if (!((FileHandleSink) sink2).getClosed()) {
            return ((FileHandleSink) sink2).getPosition() + c;
        }
        throw new IllegalStateException("closed".toString());
    }

    public final void reposition(@NotNull Sink sink, long position) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (sink instanceof RealBufferedSink) {
            Sink fileHandleSink = ((RealBufferedSink) sink).sink;
            if (!((fileHandleSink instanceof FileHandleSink) && ((FileHandleSink) fileHandleSink).getFileHandle() == this)) {
                throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
            }
            if (!(!((FileHandleSink) fileHandleSink).getClosed())) {
                throw new IllegalStateException("closed".toString());
            }
            ((RealBufferedSink) sink).emit();
            ((FileHandleSink) fileHandleSink).setPosition(position);
            return;
        }
        if (!((sink instanceof FileHandleSink) && ((FileHandleSink) sink).getFileHandle() == this)) {
            throw new IllegalArgumentException("sink was not created by this FileHandle".toString());
        }
        if (!(!((FileHandleSink) sink).getClosed())) {
            throw new IllegalStateException("closed".toString());
        }
        ((FileHandleSink) sink).setPosition(position);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        synchronized (this) {
            if (!this.closed) {
                this.closed = true;
                if (this.openStreamCount == 0) {
                    Unit unit = Unit.INSTANCE;
                    protectedClose();
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v28, types: [long] */
    /* access modifiers changed from: private */
    public final long readNoCloseCheck(long fileOffset, Buffer sink, long byteCount) {
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("byteCount < 0: ", Long.valueOf(byteCount)).toString());
        }
        char c = fileOffset;
        long targetOffset = fileOffset + byteCount;
        while (true) {
            if (c >= targetOffset) {
                break;
            }
            Segment tail = sink.writableSegment$okio(1);
            int readByteCount = protectedRead(c, tail.data, tail.limit, (int) Math.min(targetOffset - c, (long) (8192 - tail.limit)));
            if (readByteCount == -1) {
                if (tail.pos == tail.limit) {
                    sink.head = tail.pop();
                    SegmentPool.recycle(tail);
                }
                if (fileOffset == c) {
                    return -1;
                }
            } else {
                tail.limit += readByteCount;
                c += (long) readByteCount;
                sink.setSize$okio(sink.size() + ((long) readByteCount));
            }
        }
        return c - fileOffset;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* access modifiers changed from: private */
    public final void writeNoCloseCheck(long fileOffset, Buffer source, long byteCount) {
        _UtilKt.checkOffsetAndCount(source.size(), 0, byteCount);
        char c = fileOffset;
        long targetOffset = fileOffset + byteCount;
        while (c < targetOffset) {
            Segment head = source.head;
            Intrinsics.checkNotNull(head);
            int toCopy = (int) Math.min(targetOffset - c, (long) (head.limit - head.pos));
            protectedWrite(c, head.data, head.pos, toCopy);
            head.pos += toCopy;
            c += (long) toCopy;
            source.setSize$okio(source.size() - ((long) toCopy));
            if (head.pos == head.limit) {
                source.head = head.pop();
                SegmentPool.recycle(head);
            }
        }
    }

    /* compiled from: FileHandle.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��8\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n��\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, m373d2 = {"Lokio/FileHandle$FileHandleSink;", "Lokio/Sink;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "flush", "timeout", "Lokio/Timeout;", "write", "source", "Lokio/Buffer;", "byteCount", "okio"})
    /* loaded from: grasscutter.jar:okio/FileHandle$FileHandleSink.class */
    public static final class FileHandleSink implements Sink {
        @NotNull
        private final FileHandle fileHandle;
        private long position;
        private boolean closed;

        public FileHandleSink(@NotNull FileHandle fileHandle, long position) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = position;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Sink
        public void write(@NotNull Buffer source, long byteCount) {
            Intrinsics.checkNotNullParameter(source, "source");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.writeNoCloseCheck(this.position, source, byteCount);
            this.position += byteCount;
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() {
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            this.fileHandle.protectedFlush();
        }

        @Override // okio.Sink
        @NotNull
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.closed) {
                this.closed = true;
                synchronized (this.fileHandle) {
                    FileHandle fileHandle = getFileHandle();
                    fileHandle.openStreamCount--;
                    if (getFileHandle().openStreamCount == 0 && getFileHandle().closed) {
                        Unit unit = Unit.INSTANCE;
                        this.fileHandle.protectedClose();
                    }
                }
            }
        }
    }

    /* compiled from: FileHandle.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0002\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n��\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001b"}, m373d2 = {"Lokio/FileHandle$FileHandleSource;", "Lokio/Source;", "fileHandle", "Lokio/FileHandle;", "position", "", "(Lokio/FileHandle;J)V", "closed", "", "getClosed", "()Z", "setClosed", "(Z)V", "getFileHandle", "()Lokio/FileHandle;", "getPosition", "()J", "setPosition", "(J)V", "close", "", "read", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "okio"})
    /* loaded from: grasscutter.jar:okio/FileHandle$FileHandleSource.class */
    public static final class FileHandleSource implements Source {
        @NotNull
        private final FileHandle fileHandle;
        private long position;
        private boolean closed;

        public FileHandleSource(@NotNull FileHandle fileHandle, long position) {
            Intrinsics.checkNotNullParameter(fileHandle, "fileHandle");
            this.fileHandle = fileHandle;
            this.position = position;
        }

        @NotNull
        public final FileHandle getFileHandle() {
            return this.fileHandle;
        }

        public final long getPosition() {
            return this.position;
        }

        public final void setPosition(long j) {
            this.position = j;
        }

        public final boolean getClosed() {
            return this.closed;
        }

        public final void setClosed(boolean z) {
            this.closed = z;
        }

        @Override // okio.Source
        public long read(@NotNull Buffer sink, long byteCount) {
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (!(!this.closed)) {
                throw new IllegalStateException("closed".toString());
            }
            long result = this.fileHandle.readNoCloseCheck(this.position, sink, byteCount);
            if (result != -1) {
                this.position += result;
            }
            return result;
        }

        @Override // okio.Source
        @NotNull
        public Timeout timeout() {
            return Timeout.NONE;
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            if (!this.closed) {
                this.closed = true;
                synchronized (this.fileHandle) {
                    FileHandle fileHandle = getFileHandle();
                    fileHandle.openStreamCount--;
                    if (getFileHandle().openStreamCount == 0 && getFileHandle().closed) {
                        Unit unit = Unit.INSTANCE;
                        this.fileHandle.protectedClose();
                    }
                }
            }
        }
    }
}
