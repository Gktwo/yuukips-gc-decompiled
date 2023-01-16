package p013io.netty.channel;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.netty.util.AbstractReferenceCounted;
import p013io.netty.util.IllegalReferenceCountException;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.channel.DefaultFileRegion */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultFileRegion.class */
public class DefaultFileRegion extends AbstractReferenceCounted implements FileRegion {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(DefaultFileRegion.class);

    /* renamed from: f */
    private final File f978f;
    private final long position;
    private final long count;
    private long transferred;
    private FileChannel file;

    public DefaultFileRegion(FileChannel file, long position, long count) {
        this.file = (FileChannel) ObjectUtil.checkNotNull(file, Action.FILE_ATTRIBUTE);
        this.position = ObjectUtil.checkPositiveOrZero(position, "position");
        this.count = ObjectUtil.checkPositiveOrZero(count, "count");
        this.f978f = null;
    }

    public DefaultFileRegion(File f, long position, long count) {
        this.f978f = (File) ObjectUtil.checkNotNull(f, "f");
        this.position = ObjectUtil.checkPositiveOrZero(position, "position");
        this.count = ObjectUtil.checkPositiveOrZero(count, "count");
    }

    public boolean isOpen() {
        return this.file != null;
    }

    public void open() throws IOException {
        if (!isOpen() && refCnt() > 0) {
            this.file = new RandomAccessFile(this.f978f, "r").getChannel();
        }
    }

    @Override // p013io.netty.channel.FileRegion
    public long position() {
        return this.position;
    }

    @Override // p013io.netty.channel.FileRegion
    public long count() {
        return this.count;
    }

    @Override // p013io.netty.channel.FileRegion
    @Deprecated
    public long transfered() {
        return this.transferred;
    }

    @Override // p013io.netty.channel.FileRegion
    public long transferred() {
        return this.transferred;
    }

    @Override // p013io.netty.channel.FileRegion
    public long transferTo(WritableByteChannel target, long position) throws IOException {
        long count = this.count - position;
        if (count < 0 || position < 0) {
            throw new IllegalArgumentException("position out of range: " + position + " (expected: 0 - " + (this.count - 1) + ')');
        } else if (count == 0) {
            return 0;
        } else {
            if (refCnt() == 0) {
                throw new IllegalReferenceCountException(0);
            }
            open();
            long written = this.file.transferTo(this.position + position, count, target);
            if (written > 0) {
                this.transferred += written;
            } else if (written == 0) {
                validate(this, position);
            }
            return written;
        }
    }

    @Override // p013io.netty.util.AbstractReferenceCounted
    protected void deallocate() {
        FileChannel file = this.file;
        if (file != null) {
            this.file = null;
            try {
                file.close();
            } catch (IOException e) {
                logger.warn("Failed to close a file.", (Throwable) e);
            }
        }
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public FileRegion retain() {
        retain();
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public FileRegion retain(int increment) {
        retain(increment);
        return this;
    }

    @Override // p013io.netty.util.AbstractReferenceCounted, p013io.netty.util.ReferenceCounted
    public FileRegion touch() {
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public FileRegion touch(Object hint) {
        return this;
    }

    /* access modifiers changed from: package-private */
    public static void validate(DefaultFileRegion region, long position) throws IOException {
        long size = region.file.size();
        if (region.position + (region.count - position) + position > size) {
            throw new IOException("Underlying file size " + size + " smaller then requested count " + region.count);
        }
    }
}
