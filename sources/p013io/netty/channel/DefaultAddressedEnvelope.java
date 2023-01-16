package p013io.netty.channel;

import java.net.SocketAddress;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p013io.netty.util.ReferenceCountUtil;
import p013io.netty.util.ReferenceCounted;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.DefaultAddressedEnvelope */
/* loaded from: grasscutter.jar:io/netty/channel/DefaultAddressedEnvelope.class */
public class DefaultAddressedEnvelope<M, A extends SocketAddress> implements AddressedEnvelope<M, A> {
    private final M message;
    private final A sender;
    private final A recipient;

    public DefaultAddressedEnvelope(M message, A recipient, A sender) {
        ObjectUtil.checkNotNull(message, SendMailJob.PROP_MESSAGE);
        if (recipient == null && sender == null) {
            throw new NullPointerException("recipient and sender");
        }
        this.message = message;
        this.sender = sender;
        this.recipient = recipient;
    }

    public DefaultAddressedEnvelope(M message, A recipient) {
        this(message, recipient, null);
    }

    @Override // p013io.netty.channel.AddressedEnvelope
    public M content() {
        return this.message;
    }

    @Override // p013io.netty.channel.AddressedEnvelope
    public A sender() {
        return this.sender;
    }

    @Override // p013io.netty.channel.AddressedEnvelope
    public A recipient() {
        return this.recipient;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public int refCnt() {
        if (this.message instanceof ReferenceCounted) {
            return ((ReferenceCounted) this.message).refCnt();
        }
        return 1;
    }

    @Override // p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> retain() {
        ReferenceCountUtil.retain(this.message);
        return this;
    }

    @Override // p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> retain(int increment) {
        ReferenceCountUtil.retain(this.message, increment);
        return this;
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release() {
        return ReferenceCountUtil.release(this.message);
    }

    @Override // p013io.netty.util.ReferenceCounted
    public boolean release(int decrement) {
        return ReferenceCountUtil.release(this.message, decrement);
    }

    @Override // p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> touch() {
        ReferenceCountUtil.touch(this.message);
        return this;
    }

    @Override // p013io.netty.channel.AddressedEnvelope, p013io.netty.util.ReferenceCounted
    public AddressedEnvelope<M, A> touch(Object hint) {
        ReferenceCountUtil.touch(this.message, hint);
        return this;
    }

    public String toString() {
        if (this.sender != null) {
            return StringUtil.simpleClassName(this) + '(' + this.sender + " => " + this.recipient + ", " + this.message + ')';
        }
        return StringUtil.simpleClassName(this) + "(=> " + this.recipient + ", " + this.message + ')';
    }
}
