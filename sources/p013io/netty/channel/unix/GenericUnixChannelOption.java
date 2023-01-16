package p013io.netty.channel.unix;

/* renamed from: io.netty.channel.unix.GenericUnixChannelOption */
/* loaded from: grasscutter.jar:io/netty/channel/unix/GenericUnixChannelOption.class */
public abstract class GenericUnixChannelOption<T> extends UnixChannelOption<T> {
    private final int level;
    private final int optname;

    /* access modifiers changed from: package-private */
    public GenericUnixChannelOption(String name, int level, int optname) {
        super(name);
        this.level = level;
        this.optname = optname;
    }

    public int level() {
        return this.level;
    }

    public int optname() {
        return this.optname;
    }
}
