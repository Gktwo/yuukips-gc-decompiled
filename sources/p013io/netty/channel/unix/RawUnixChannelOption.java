package p013io.netty.channel.unix;

import java.nio.ByteBuffer;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.unix.RawUnixChannelOption */
/* loaded from: grasscutter.jar:io/netty/channel/unix/RawUnixChannelOption.class */
public final class RawUnixChannelOption extends GenericUnixChannelOption<ByteBuffer> {
    private final int length;

    public RawUnixChannelOption(String name, int level, int optname, int length) {
        super(name, level, optname);
        this.length = ObjectUtil.checkPositive(length, "length");
    }

    public int length() {
        return this.length;
    }

    public void validate(ByteBuffer value) {
        validate((RawUnixChannelOption) value);
        if (value.remaining() != this.length) {
            throw new IllegalArgumentException("Length of value does not match. Expected " + this.length + ", but got " + value.remaining());
        }
    }
}
