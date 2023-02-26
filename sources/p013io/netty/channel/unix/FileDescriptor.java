package p013io.netty.channel.unix;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import org.jline.builtins.TTop;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.unix.FileDescriptor */
/* loaded from: grasscutter.jar:io/netty/channel/unix/FileDescriptor.class */
public class FileDescriptor {
    private static final AtomicIntegerFieldUpdater<FileDescriptor> stateUpdater = AtomicIntegerFieldUpdater.newUpdater(FileDescriptor.class, TTop.STAT_STATE);
    private static final int STATE_CLOSED_MASK = 1;
    private static final int STATE_INPUT_SHUTDOWN_MASK = 2;
    private static final int STATE_OUTPUT_SHUTDOWN_MASK = 4;
    private static final int STATE_ALL_MASK = 7;
    volatile int state;

    /* renamed from: fd */
    final int f954fd;

    private static native int open(String str);

    private static native int close(int i);

    private static native int write(int i, ByteBuffer byteBuffer, int i2, int i3);

    private static native int writeAddress(int i, long j, int i2, int i3);

    private static native long writev(int i, ByteBuffer[] byteBufferArr, int i2, int i3, long j);

    private static native long writevAddresses(int i, long j, int i2);

    private static native int read(int i, ByteBuffer byteBuffer, int i2, int i3);

    private static native int readAddress(int i, long j, int i2, int i3);

    private static native long newPipe();

    public FileDescriptor(int fd) {
        ObjectUtil.checkPositiveOrZero(fd, "fd");
        this.f954fd = fd;
    }

    public final int intValue() {
        return this.f954fd;
    }

    protected boolean markClosed() {
        int state;
        do {
            state = this.state;
            if (isClosed(state)) {
                return false;
            }
        } while (!casState(state, state | 7));
        return true;
    }

    public void close() throws IOException {
        int res;
        if (markClosed() && (res = close(this.f954fd)) < 0) {
            throw Errors.newIOException("close", res);
        }
    }

    public boolean isOpen() {
        return !isClosed(this.state);
    }

    public final int write(ByteBuffer buf, int pos, int limit) throws IOException {
        int res = write(this.f954fd, buf, pos, limit);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("write", res);
    }

    public final int writeAddress(long address, int pos, int limit) throws IOException {
        int res = writeAddress(this.f954fd, address, pos, limit);
        if (res >= 0) {
            return res;
        }
        return Errors.ioResult("writeAddress", res);
    }

    public final long writev(ByteBuffer[] buffers, int offset, int length, long maxBytesToWrite) throws IOException {
        long res = writev(this.f954fd, buffers, offset, Math.min(Limits.IOV_MAX, length), maxBytesToWrite);
        if (res >= 0) {
            return res;
        }
        return (long) Errors.ioResult("writev", (int) res);
    }

    public final long writevAddresses(long memoryAddress, int length) throws IOException {
        long res = writevAddresses(this.f954fd, memoryAddress, length);
        if (res >= 0) {
            return res;
        }
        return (long) Errors.ioResult("writevAddresses", (int) res);
    }

    public final int read(ByteBuffer buf, int pos, int limit) throws IOException {
        int res = read(this.f954fd, buf, pos, limit);
        if (res > 0) {
            return res;
        }
        if (res == 0) {
            return -1;
        }
        return Errors.ioResult("read", res);
    }

    public final int readAddress(long address, int pos, int limit) throws IOException {
        int res = readAddress(this.f954fd, address, pos, limit);
        if (res > 0) {
            return res;
        }
        if (res == 0) {
            return -1;
        }
        return Errors.ioResult("readAddress", res);
    }

    public String toString() {
        return "FileDescriptor{fd=" + this.f954fd + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return (o instanceof FileDescriptor) && this.f954fd == ((FileDescriptor) o).f954fd;
    }

    public int hashCode() {
        return this.f954fd;
    }

    public static FileDescriptor from(String path) throws IOException {
        int res = open((String) ObjectUtil.checkNotNull(path, "path"));
        if (res >= 0) {
            return new FileDescriptor(res);
        }
        throw Errors.newIOException("open", res);
    }

    public static FileDescriptor from(File file) throws IOException {
        return from(((File) ObjectUtil.checkNotNull(file, Action.FILE_ATTRIBUTE)).getPath());
    }

    public static FileDescriptor[] pipe() throws IOException {
        long res = newPipe();
        if (res >= 0) {
            return new FileDescriptor[]{new FileDescriptor((int) (res >>> 32)), new FileDescriptor((int) res)};
        }
        throw Errors.newIOException("newPipe", (int) res);
    }

    final boolean casState(int expected, int update) {
        return stateUpdater.compareAndSet(this, expected, update);
    }

    static boolean isClosed(int state) {
        return (state & 1) != 0;
    }

    static boolean isInputShutdown(int state) {
        return (state & 2) != 0;
    }

    static boolean isOutputShutdown(int state) {
        return (state & 4) != 0;
    }

    static int inputShutdown(int state) {
        return state | 2;
    }

    static int outputShutdown(int state) {
        return state | 4;
    }
}
