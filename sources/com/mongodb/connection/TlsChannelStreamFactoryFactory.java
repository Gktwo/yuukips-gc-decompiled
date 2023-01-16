package com.mongodb.connection;

import com.mongodb.MongoClientException;
import com.mongodb.ServerAddress;
import com.mongodb.assertions.Assertions;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.connection.AsynchronousChannelStream;
import com.mongodb.internal.connection.ConcurrentLinkedDeque;
import com.mongodb.internal.connection.ExtendedAsynchronousByteChannel;
import com.mongodb.internal.connection.PowerOfTwoBufferPool;
import com.mongodb.internal.connection.tlschannel.BufferAllocator;
import com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannel;
import com.mongodb.internal.connection.tlschannel.async.AsynchronousTlsChannelGroup;
import java.io.Closeable;
import java.io.IOException;
import java.net.SocketOption;
import java.net.StandardSocketOptions;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLContext;

/* loaded from: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory.class */
public class TlsChannelStreamFactoryFactory implements StreamFactoryFactory, Closeable {
    private static final Logger LOGGER = Loggers.getLogger("connection.tls");
    private final SelectorMonitor selectorMonitor;
    private final AsynchronousTlsChannelGroup group;
    private final boolean ownsGroup;
    private final PowerOfTwoBufferPool bufferPool;

    public TlsChannelStreamFactoryFactory() {
        this(new AsynchronousTlsChannelGroup(), true);
    }

    @Deprecated
    public TlsChannelStreamFactoryFactory(AsynchronousTlsChannelGroup group) {
        this(group, false);
    }

    private TlsChannelStreamFactoryFactory(AsynchronousTlsChannelGroup group, boolean ownsGroup) {
        this.bufferPool = new PowerOfTwoBufferPool();
        this.group = group;
        this.ownsGroup = ownsGroup;
        this.selectorMonitor = new SelectorMonitor();
        this.selectorMonitor.start();
    }

    @Override // com.mongodb.connection.StreamFactoryFactory
    public StreamFactory create(SocketSettings socketSettings, SslSettings sslSettings) {
        return serverAddress -> {
            return new TlsChannelStream(sslSettings, socketSettings, socketSettings, this.bufferPool, this.group, this.selectorMonitor);
        };
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.selectorMonitor.close();
        if (this.ownsGroup) {
            this.group.shutdown();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory$SelectorMonitor.class */
    private static class SelectorMonitor implements Closeable {
        private final Selector selector;
        private volatile boolean isClosed;
        private final ConcurrentLinkedDeque<Pair> pendingRegistrations = new ConcurrentLinkedDeque<>();

        /* access modifiers changed from: private */
        /* loaded from: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory$SelectorMonitor$Pair.class */
        public static final class Pair {
            private final SocketChannel socketChannel;
            private final Runnable attachment;

            private Pair(SocketChannel socketChannel, Runnable attachment) {
                this.socketChannel = socketChannel;
                this.attachment = attachment;
            }
        }

        SelectorMonitor() {
            try {
                this.selector = Selector.open();
            } catch (IOException e) {
                throw new MongoClientException("Exception opening Selector", e);
            }
        }

        void start() {
            Thread selectorThread = new Thread(() -> {
                while (!this.isClosed) {
                    try {
                        this.selector.select();
                        for (SelectionKey selectionKey : this.selector.selectedKeys()) {
                            try {
                                selectionKey.cancel();
                                ((Runnable) selectionKey.attachment()).run();
                            } catch (IOException | RuntimeException e) {
                                TlsChannelStreamFactoryFactory.LOGGER.warn("Exception in selector loop", e);
                            }
                        }
                        Iterator<Pair> iter = this.pendingRegistrations.iterator();
                        while (iter.hasNext()) {
                            Pair pendingRegistration = iter.next();
                            pendingRegistration.socketChannel.register(this.selector, 8, pendingRegistration.attachment);
                            iter.remove();
                        }
                    } catch (Throwable th) {
                        try {
                            this.selector.close();
                        } catch (IOException e2) {
                        }
                        throw th;
                    }
                }
                try {
                    this.selector.close();
                } catch (IOException e3) {
                }
            });
            selectorThread.setDaemon(true);
            selectorThread.start();
        }

        void register(SocketChannel channel, Runnable attachment) {
            this.pendingRegistrations.add(new Pair(channel, attachment));
            this.selector.wakeup();
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.isClosed = true;
            this.selector.wakeup();
        }
    }

    /* loaded from: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory$TlsChannelStream.class */
    private static class TlsChannelStream extends AsynchronousChannelStream implements Stream {
        private final AsynchronousTlsChannelGroup group;
        private final SelectorMonitor selectorMonitor;
        private final SslSettings sslSettings;

        TlsChannelStream(ServerAddress serverAddress, SocketSettings settings, SslSettings sslSettings, PowerOfTwoBufferPool bufferProvider, AsynchronousTlsChannelGroup group, SelectorMonitor selectorMonitor) {
            super(serverAddress, settings, bufferProvider);
            this.sslSettings = sslSettings;
            this.group = group;
            this.selectorMonitor = selectorMonitor;
        }

        @Override // com.mongodb.internal.connection.AsynchronousChannelStream, com.mongodb.connection.Stream
        public boolean supportsAdditionalTimeout() {
            return true;
        }

        @Override // com.mongodb.connection.Stream
        public void openAsync(AsyncCompletionHandler<Void> handler) {
            Assertions.isTrue("unopened", getChannel() == null);
            try {
                SocketChannel socketChannel = SocketChannel.open();
                socketChannel.configureBlocking(false);
                socketChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.TCP_NODELAY, (SocketOption) true);
                socketChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_KEEPALIVE, (SocketOption) true);
                if (getSettings().getReceiveBufferSize() > 0) {
                    socketChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_RCVBUF, (SocketOption) Integer.valueOf(getSettings().getReceiveBufferSize()));
                }
                if (getSettings().getSendBufferSize() > 0) {
                    socketChannel.setOption((SocketOption<SocketOption>) StandardSocketOptions.SO_SNDBUF, (SocketOption) Integer.valueOf(getSettings().getSendBufferSize()));
                }
                socketChannel.connect(getServerAddress().getSocketAddress());
                this.selectorMonitor.register(socketChannel, ()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0084: INVOKE  
                      (wrap: com.mongodb.connection.TlsChannelStreamFactoryFactory$SelectorMonitor : 0x0078: IGET  (r0v19 com.mongodb.connection.TlsChannelStreamFactoryFactory$SelectorMonitor A[REMOVE]) = 
                      (r7v0 'this' com.mongodb.connection.TlsChannelStreamFactoryFactory$TlsChannelStream A[D('this' com.mongodb.connection.TlsChannelStreamFactoryFactory$TlsChannelStream), IMMUTABLE_TYPE, THIS])
                     com.mongodb.connection.TlsChannelStreamFactoryFactory.TlsChannelStream.selectorMonitor com.mongodb.connection.TlsChannelStreamFactoryFactory$SelectorMonitor)
                      (r0v3 'socketChannel' java.nio.channels.SocketChannel A[D('socketChannel' java.nio.channels.SocketChannel)])
                      (wrap: java.lang.Runnable : 0x007f: INVOKE_CUSTOM (r2v6 java.lang.Runnable A[REMOVE]) = 
                      (r7v0 'this' com.mongodb.connection.TlsChannelStreamFactoryFactory$TlsChannelStream A[D('this' com.mongodb.connection.TlsChannelStreamFactoryFactory$TlsChannelStream), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r0v3 'socketChannel' java.nio.channels.SocketChannel A[D('socketChannel' java.nio.channels.SocketChannel), DONT_INLINE])
                      (r8v0 'handler' com.mongodb.connection.AsyncCompletionHandler<java.lang.Void> A[D('handler' com.mongodb.connection.AsyncCompletionHandler<java.lang.Void>), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  
                      (r2 I:com.mongodb.connection.TlsChannelStreamFactoryFactory$TlsChannelStream)
                      (r3 I:java.nio.channels.SocketChannel)
                      (r4 I:com.mongodb.connection.AsyncCompletionHandler)
                     type: DIRECT call: com.mongodb.connection.TlsChannelStreamFactoryFactory.TlsChannelStream.lambda$openAsync$0(java.nio.channels.SocketChannel, com.mongodb.connection.AsyncCompletionHandler):void)
                     type: VIRTUAL call: com.mongodb.connection.TlsChannelStreamFactoryFactory.SelectorMonitor.register(java.nio.channels.SocketChannel, java.lang.Runnable):void in method: com.mongodb.connection.TlsChannelStreamFactoryFactory.TlsChannelStream.openAsync(com.mongodb.connection.AsyncCompletionHandler<java.lang.Void>):void, file: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory$TlsChannelStream.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:314)
                    	at jadx.core.dex.regions.TryCatchRegion.generate(TryCatchRegion.java:85)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: java.lang.IndexOutOfBoundsException: Index 2 out of bounds for length 2
                    	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                    	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                    	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                    	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                    	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                    	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                    	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 21 more
                    */
                /*
                    this = this;
                    java.lang.String r0 = "unopened"
                    r1 = r7
                    com.mongodb.internal.connection.ExtendedAsynchronousByteChannel r1 = r1.getChannel()
                    if (r1 != 0) goto L_0x000d
                    r1 = 1
                    goto L_0x000e
                L_0x000d:
                    r1 = 0
                L_0x000e:
                    com.mongodb.assertions.Assertions.isTrue(r0, r1)
                    java.nio.channels.SocketChannel r0 = java.nio.channels.SocketChannel.open()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r9 = r0
                    r0 = r9
                    r1 = 0
                    java.nio.channels.SelectableChannel r0 = r0.configureBlocking(r1)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r0 = r9
                    java.net.SocketOption r1 = java.net.StandardSocketOptions.TCP_NODELAY     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r2 = 1
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.nio.channels.SocketChannel r0 = r0.setOption(r1, r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r0 = r9
                    java.net.SocketOption r1 = java.net.StandardSocketOptions.SO_KEEPALIVE     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r2 = 1
                    java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.nio.channels.SocketChannel r0 = r0.setOption(r1, r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r0 = r7
                    com.mongodb.connection.SocketSettings r0 = r0.getSettings()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    int r0 = r0.getReceiveBufferSize()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    if (r0 <= 0) goto L_0x004f
                    r0 = r9
                    java.net.SocketOption r1 = java.net.StandardSocketOptions.SO_RCVBUF     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r2 = r7
                    com.mongodb.connection.SocketSettings r2 = r2.getSettings()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    int r2 = r2.getReceiveBufferSize()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.nio.channels.SocketChannel r0 = r0.setOption(r1, r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                L_0x004f:
                    r0 = r7
                    com.mongodb.connection.SocketSettings r0 = r0.getSettings()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    int r0 = r0.getSendBufferSize()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    if (r0 <= 0) goto L_0x006b
                    r0 = r9
                    java.net.SocketOption r1 = java.net.StandardSocketOptions.SO_SNDBUF     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r2 = r7
                    com.mongodb.connection.SocketSettings r2 = r2.getSettings()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    int r2 = r2.getSendBufferSize()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.nio.channels.SocketChannel r0 = r0.setOption(r1, r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                L_0x006b:
                    r0 = r9
                    r1 = r7
                    com.mongodb.ServerAddress r1 = r1.getServerAddress()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    java.net.InetSocketAddress r1 = r1.getSocketAddress()     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    boolean r0 = r0.connect(r1)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r0 = r7
                    com.mongodb.connection.TlsChannelStreamFactoryFactory$SelectorMonitor r0 = r0.selectorMonitor     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r1 = r9
                    r2 = r7
                    r3 = r9
                    r4 = r8
                    void r2 = () -> { // java.lang.Runnable.run():void
                        r2.lambda$openAsync$0(r3, r4);
                    }     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    r0.register(r1, r2)     // Catch: IOException -> 0x008a, Throwable -> 0x00a2
                    goto L_0x00aa
                L_0x008a:
                    r9 = move-exception
                    r0 = r8
                    com.mongodb.MongoSocketOpenException r1 = new com.mongodb.MongoSocketOpenException
                    r2 = r1
                    java.lang.String r3 = "Exception opening socket"
                    r4 = r7
                    com.mongodb.ServerAddress r4 = r4.getServerAddress()
                    r5 = r9
                    r2.<init>(r3, r4, r5)
                    r0.failed(r1)
                    goto L_0x00aa
                L_0x00a2:
                    r9 = move-exception
                    r0 = r8
                    r1 = r9
                    r0.failed(r1)
                L_0x00aa:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mongodb.connection.TlsChannelStreamFactoryFactory.TlsChannelStream.openAsync(com.mongodb.connection.AsyncCompletionHandler):void");
            }

            private SSLContext getSslContext() {
                try {
                    return this.sslSettings.getContext() == null ? SSLContext.getDefault() : this.sslSettings.getContext();
                } catch (NoSuchAlgorithmException e) {
                    throw new MongoClientException("Unable to create default SSLContext", e);
                }
            }

            /* loaded from: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory$TlsChannelStream$BufferProviderAllocator.class */
            private class BufferProviderAllocator implements BufferAllocator {
                private BufferProviderAllocator() {
                }

                @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
                public ByteBuffer allocate(int size) {
                    return TlsChannelStream.this.getBufferProvider().getByteBuffer(size);
                }

                @Override // com.mongodb.internal.connection.tlschannel.BufferAllocator
                public void free(ByteBuffer buffer) {
                    TlsChannelStream.this.getBufferProvider().release(buffer);
                }
            }

            /* loaded from: grasscutter.jar:com/mongodb/connection/TlsChannelStreamFactoryFactory$TlsChannelStream$AsynchronousTlsChannelAdapter.class */
            public static class AsynchronousTlsChannelAdapter implements ExtendedAsynchronousByteChannel {
                private final AsynchronousTlsChannel wrapped;

                AsynchronousTlsChannelAdapter(AsynchronousTlsChannel wrapped) {
                    this.wrapped = wrapped;
                }

                @Override // java.nio.channels.AsynchronousByteChannel
                public <A> void read(ByteBuffer dst, A attach, CompletionHandler<Integer, ? super A> handler) {
                    this.wrapped.read(dst, attach, handler);
                }

                @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
                public <A> void read(ByteBuffer dst, long timeout, TimeUnit unit, A attach, CompletionHandler<Integer, ? super A> handler) {
                    this.wrapped.read(dst, timeout, unit, attach, handler);
                }

                @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
                public <A> void read(ByteBuffer[] dsts, int offset, int length, long timeout, TimeUnit unit, A attach, CompletionHandler<Long, ? super A> handler) {
                    this.wrapped.read(dsts, offset, length, timeout, unit, attach, handler);
                }

                @Override // java.nio.channels.AsynchronousByteChannel
                public Future<Integer> read(ByteBuffer dst) {
                    return this.wrapped.read(dst);
                }

                @Override // java.nio.channels.AsynchronousByteChannel
                public <A> void write(ByteBuffer src, A attach, CompletionHandler<Integer, ? super A> handler) {
                    this.wrapped.write(src, attach, handler);
                }

                @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
                public <A> void write(ByteBuffer src, long timeout, TimeUnit unit, A attach, CompletionHandler<Integer, ? super A> handler) {
                    this.wrapped.write(src, timeout, unit, attach, handler);
                }

                @Override // com.mongodb.internal.connection.ExtendedAsynchronousByteChannel
                public <A> void write(ByteBuffer[] srcs, int offset, int length, long timeout, TimeUnit unit, A attach, CompletionHandler<Long, ? super A> handler) {
                    this.wrapped.write(srcs, offset, length, timeout, unit, attach, handler);
                }

                @Override // java.nio.channels.AsynchronousByteChannel
                public Future<Integer> write(ByteBuffer src) {
                    return this.wrapped.write(src);
                }

                @Override // java.nio.channels.Channel
                public boolean isOpen() {
                    return this.wrapped.isOpen();
                }

                @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.AsynchronousChannel, java.nio.channels.Channel
                public void close() throws IOException {
                    this.wrapped.close();
                }
            }
        }
    }
