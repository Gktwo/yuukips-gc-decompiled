package p013io.netty.channel.group;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelException;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.channel.group.ChannelGroupException */
/* loaded from: grasscutter.jar:io/netty/channel/group/ChannelGroupException.class */
public class ChannelGroupException extends ChannelException implements Iterable<Map.Entry<Channel, Throwable>> {
    private static final long serialVersionUID = -4093064295562629453L;
    private final Collection<Map.Entry<Channel, Throwable>> failed;

    public ChannelGroupException(Collection<Map.Entry<Channel, Throwable>> causes) {
        ObjectUtil.checkNonEmpty(causes, "causes");
        this.failed = Collections.unmodifiableCollection(causes);
    }

    @Override // java.lang.Iterable
    public Iterator<Map.Entry<Channel, Throwable>> iterator() {
        return this.failed.iterator();
    }
}
