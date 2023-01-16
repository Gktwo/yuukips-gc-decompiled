package p013io.netty.channel.nio;

import java.io.IOException;
import java.net.PortUnreachableException;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.List;
import p013io.netty.channel.Channel;
import p013io.netty.channel.ChannelOutboundBuffer;
import p013io.netty.channel.RecvByteBufAllocator;
import p013io.netty.channel.ServerChannel;
import p013io.netty.channel.nio.AbstractNioChannel;

/* renamed from: io.netty.channel.nio.AbstractNioMessageChannel */
/* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioMessageChannel.class */
public abstract class AbstractNioMessageChannel extends AbstractNioChannel {
    boolean inputShutdown;

    protected abstract int doReadMessages(List<Object> list) throws Exception;

    protected abstract boolean doWriteMessage(Object obj, ChannelOutboundBuffer channelOutboundBuffer) throws Exception;

    /* access modifiers changed from: protected */
    public AbstractNioMessageChannel(Channel parent, SelectableChannel ch, int readInterestOp) {
        super(parent, ch, readInterestOp);
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.AbstractChannel
    public AbstractNioChannel.AbstractNioUnsafe newUnsafe() {
        return new NioMessageUnsafe();
    }

    /* access modifiers changed from: protected */
    @Override // p013io.netty.channel.nio.AbstractNioChannel, p013io.netty.channel.AbstractChannel
    public void doBeginRead() throws Exception {
        if (!this.inputShutdown) {
            doBeginRead();
        }
    }

    protected boolean continueReading(RecvByteBufAllocator.Handle allocHandle) {
        return allocHandle.continueReading();
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.channel.nio.AbstractNioMessageChannel$NioMessageUnsafe */
    /* loaded from: grasscutter.jar:io/netty/channel/nio/AbstractNioMessageChannel$NioMessageUnsafe.class */
    public final class NioMessageUnsafe extends AbstractNioChannel.AbstractNioUnsafe {
        private final List<Object> readBuf;
        static final /* synthetic */ boolean $assertionsDisabled;

        private NioMessageUnsafe() {
            super();
            this.readBuf = new ArrayList();
        }

        static {
            $assertionsDisabled = !AbstractNioMessageChannel.class.desiredAssertionStatus();
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:18:0x007b
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // p013io.netty.channel.nio.AbstractNioChannel.NioUnsafe
        public void read() {
            /*
            // Method dump skipped, instructions count: 315
            */
            throw new UnsupportedOperationException("Method not decompiled: p013io.netty.channel.nio.AbstractNioMessageChannel.NioMessageUnsafe.read():void");
        }
    }

    @Override // p013io.netty.channel.AbstractChannel
    protected void doWrite(ChannelOutboundBuffer in) throws Exception {
        Object msg;
        boolean done;
        SelectionKey key = selectionKey();
        int interestOps = key.interestOps();
        int maxMessagesPerWrite = maxMessagesPerWrite();
        while (maxMessagesPerWrite > 0 && (msg = in.current()) != null) {
            try {
                done = false;
                int i = config().getWriteSpinCount() - 1;
                while (true) {
                    if (i < 0) {
                        break;
                    } else if (doWriteMessage(msg, in)) {
                        done = true;
                        break;
                    } else {
                        i--;
                    }
                }
            } catch (Exception e) {
                if (continueOnWriteError()) {
                    maxMessagesPerWrite--;
                    in.remove(e);
                } else {
                    throw e;
                }
            }
            if (!done) {
                break;
            }
            maxMessagesPerWrite--;
            in.remove();
        }
        if (in.isEmpty()) {
            if ((interestOps & 4) != 0) {
                key.interestOps(interestOps & -5);
            }
        } else if ((interestOps & 4) == 0) {
            key.interestOps(interestOps | 4);
        }
    }

    protected boolean continueOnWriteError() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean closeOnReadError(Throwable cause) {
        if (!isActive()) {
            return true;
        }
        if (cause instanceof PortUnreachableException) {
            return false;
        }
        return !(cause instanceof IOException) || !(this instanceof ServerChannel);
    }
}
