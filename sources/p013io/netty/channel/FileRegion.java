package p013io.netty.channel;

import java.io.IOException;
import java.nio.channels.WritableByteChannel;
import p013io.netty.util.ReferenceCounted;

/* renamed from: io.netty.channel.FileRegion */
/* loaded from: grasscutter.jar:io/netty/channel/FileRegion.class */
public interface FileRegion extends ReferenceCounted {
    long position();

    @Deprecated
    long transfered();

    long transferred();

    long count();

    long transferTo(WritableByteChannel writableByteChannel, long j) throws IOException;

    @Override // p013io.netty.util.ReferenceCounted
    FileRegion retain();

    @Override // p013io.netty.util.ReferenceCounted
    FileRegion retain(int i);

    @Override // p013io.netty.util.ReferenceCounted
    FileRegion touch();

    @Override // p013io.netty.util.ReferenceCounted
    FileRegion touch(Object obj);
}
