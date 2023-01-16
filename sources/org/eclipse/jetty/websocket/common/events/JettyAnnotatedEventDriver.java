package org.eclipse.jetty.websocket.common.events;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.util.Objects;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.annotations.WebSocket;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.CloseInfo;
import org.eclipse.jetty.websocket.common.message.MessageInputStream;
import org.eclipse.jetty.websocket.common.message.MessageReader;
import org.eclipse.jetty.websocket.common.message.NullMessage;
import org.eclipse.jetty.websocket.common.util.TextUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyAnnotatedEventDriver.class */
public class JettyAnnotatedEventDriver extends AbstractEventDriver {
    private static final Logger LOG = Log.getLogger(JettyAnnotatedEventDriver.class);
    private final JettyAnnotatedMetadata events;
    private boolean hasCloseBeenCalled = false;
    private final BatchMode batchMode;

    public JettyAnnotatedEventDriver(WebSocketPolicy policy, Object websocket, JettyAnnotatedMetadata events) {
        super(policy, websocket);
        this.events = (JettyAnnotatedMetadata) Objects.requireNonNull(events, "JettyAnnotatedMetadata may not be null");
        WebSocket anno = (WebSocket) websocket.getClass().getAnnotation(WebSocket.class);
        if (anno.maxTextMessageSize() > 0) {
            this.policy.setMaxTextMessageSize(anno.maxTextMessageSize());
        }
        if (anno.maxBinaryMessageSize() > 0) {
            this.policy.setMaxBinaryMessageSize(anno.maxBinaryMessageSize());
        }
        if (anno.inputBufferSize() > 0) {
            this.policy.setInputBufferSize(anno.inputBufferSize());
        }
        if (anno.maxIdleTime() > 0) {
            this.policy.setIdleTimeout((long) anno.maxIdleTime());
        }
        this.batchMode = anno.batchMode();
        if (LOG.isDebugEnabled()) {
            LOG.debug("ctor / object={}, policy={}, batchMode={}, events={}", websocket, policy, this.batchMode, events);
        }
    }

    @Override // org.eclipse.jetty.websocket.common.events.AbstractEventDriver, org.eclipse.jetty.websocket.common.events.EventDriver
    public BatchMode getBatchMode() {
        return this.batchMode;
    }

    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
    public void onBinaryFrame(ByteBuffer buffer, boolean fin) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onBinaryFrame({}, {}) - events.onBinary={}, activeMessage={}", BufferUtil.toDetailString(buffer), Boolean.valueOf(fin), this.events.onBinary, this.activeMessage);
        }
        if (this.activeMessage == null) {
            if (this.events.onBinary == null) {
                this.activeMessage = NullMessage.INSTANCE;
            } else if (this.events.onBinary.isStreaming()) {
                MessageInputStream inputStream = new MessageInputStream(this.session);
                this.activeMessage = inputStream;
                dispatch(()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0079: INVOKE  
                      (r7v0 'this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver A[D('this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver), IMMUTABLE_TYPE, THIS])
                      (wrap: java.lang.Runnable : 0x0074: INVOKE_CUSTOM (r1v5 java.lang.Runnable A[REMOVE]) = 
                      (r7v0 'this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver A[D('this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r0v13 'inputStream' org.eclipse.jetty.websocket.common.message.MessageInputStream A[D('inputStream' org.eclipse.jetty.websocket.common.message.MessageInputStream), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  
                      (r1 I:org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver)
                      (r2 I:org.eclipse.jetty.websocket.common.message.MessageInputStream)
                     type: DIRECT call: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.lambda$onBinaryFrame$0(org.eclipse.jetty.websocket.common.message.MessageInputStream):void)
                     type: VIRTUAL call: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.dispatch(java.lang.Runnable):void in method: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.onBinaryFrame(java.nio.ByteBuffer, boolean):void, file: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyAnnotatedEventDriver.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                    	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:170)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:147)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                    	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                    Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
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
                    	... 29 more
                    */
                /*
                    this = this;
                    org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.LOG
                    boolean r0 = r0.isDebugEnabled()
                    if (r0 == 0) goto L_0x0038
                    org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.LOG
                    java.lang.String r1 = "onBinaryFrame({}, {}) - events.onBinary={}, activeMessage={}"
                    r2 = 4
                    java.lang.Object[] r2 = new java.lang.Object[r2]
                    r3 = r2
                    r4 = 0
                    r5 = r8
                    java.lang.String r5 = org.eclipse.jetty.util.BufferUtil.toDetailString(r5)
                    r3[r4] = r5
                    r3 = r2
                    r4 = 1
                    r5 = r9
                    java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                    r3[r4] = r5
                    r3 = r2
                    r4 = 2
                    r5 = r7
                    org.eclipse.jetty.websocket.common.events.JettyAnnotatedMetadata r5 = r5.events
                    org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod r5 = r5.onBinary
                    r3[r4] = r5
                    r3 = r2
                    r4 = 3
                    r5 = r7
                    org.eclipse.jetty.websocket.common.message.MessageAppender r5 = r5.activeMessage
                    r3[r4] = r5
                    r0.debug(r1, r2)
                L_0x0038:
                    r0 = r7
                    org.eclipse.jetty.websocket.common.message.MessageAppender r0 = r0.activeMessage
                    if (r0 != 0) goto L_0x008b
                    r0 = r7
                    org.eclipse.jetty.websocket.common.events.JettyAnnotatedMetadata r0 = r0.events
                    org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod r0 = r0.onBinary
                    if (r0 != 0) goto L_0x0053
                    r0 = r7
                    org.eclipse.jetty.websocket.common.message.MessageAppender r1 = org.eclipse.jetty.websocket.common.message.NullMessage.INSTANCE
                    r0.activeMessage = r1
                    goto L_0x008b
                L_0x0053:
                    r0 = r7
                    org.eclipse.jetty.websocket.common.events.JettyAnnotatedMetadata r0 = r0.events
                    org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod r0 = r0.onBinary
                    boolean r0 = r0.isStreaming()
                    if (r0 == 0) goto L_0x007f
                    org.eclipse.jetty.websocket.common.message.MessageInputStream r0 = new org.eclipse.jetty.websocket.common.message.MessageInputStream
                    r1 = r0
                    r2 = r7
                    org.eclipse.jetty.websocket.common.WebSocketSession r2 = r2.session
                    r1.<init>(r2)
                    r10 = r0
                    r0 = r7
                    r1 = r10
                    r0.activeMessage = r1
                    r0 = r7
                    r1 = r7
                    r2 = r10
                    void r1 = () -> { // java.lang.Runnable.run():void
                        r1.lambda$onBinaryFrame$0(r2);
                    }
                    r0.dispatch(r1)
                    goto L_0x008b
                L_0x007f:
                    r0 = r7
                    org.eclipse.jetty.websocket.common.message.SimpleBinaryMessage r1 = new org.eclipse.jetty.websocket.common.message.SimpleBinaryMessage
                    r2 = r1
                    r3 = r7
                    r2.<init>(r3)
                    r0.activeMessage = r1
                L_0x008b:
                    r0 = r7
                    r1 = r8
                    r2 = r9
                    r0.appendMessage(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.onBinaryFrame(java.nio.ByteBuffer, boolean):void");
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onBinaryMessage(byte[] data) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onBinaryMessage([{}]) - events.onBinary={}", Integer.valueOf(data.length), this.events.onBinary);
                }
                if (this.events.onBinary != null) {
                    this.events.onBinary.call(this.websocket, this.session, data, 0, Integer.valueOf(data.length));
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onClose(CloseInfo close) {
                if (!this.hasCloseBeenCalled) {
                    this.hasCloseBeenCalled = true;
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("onClose({}) - events.onClose={}", close, this.events.onClose);
                    }
                    if (this.events.onClose != null) {
                        this.events.onClose.call(this.websocket, this.session, Integer.valueOf(close.getStatusCode()), close.getReason());
                    }
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onConnect() {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onConnect() - events.onConnect={}", this.events.onConnect);
                }
                if (this.events.onConnect != null) {
                    this.events.onConnect.call(this.websocket, this.session);
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onError(Throwable cause) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onError({}) - events.onError={}", cause.getClass().getName(), this.events.onError);
                }
                if (this.events.onError != null) {
                    this.events.onError.call(this.websocket, this.session, cause);
                } else {
                    LOG.warn("Unable to report throwable to websocket (no @OnWebSocketError handler declared): " + this.websocket.getClass().getName(), cause);
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onFrame(Frame frame) {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onFrame({}) - events.onFrame={}", frame, this.events.onFrame);
                }
                if (this.events.onFrame != null) {
                    this.events.onFrame.call(this.websocket, this.session, frame);
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onInputStream(InputStream stream) {
                Objects.requireNonNull(stream, "InputStream may not be null");
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onInputStream({}) - events.onBinary={}", stream.getClass().getName(), this.events.onBinary);
                }
                if (this.events.onBinary != null) {
                    this.events.onBinary.call(this.websocket, this.session, stream);
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onReader(Reader reader) {
                Objects.requireNonNull(reader, "Reader may not be null");
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onReader({}) - events.onText={}", reader.getClass().getName(), this.events.onText);
                }
                if (this.events.onText != null) {
                    this.events.onText.call(this.websocket, this.session, reader);
                }
            }

            @Override // org.eclipse.jetty.websocket.common.events.EventDriver
            public void onTextFrame(ByteBuffer buffer, boolean fin) throws IOException {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("onTextFrame({}, {}) - events.onText={}, activeMessage={}", BufferUtil.toDetailString(buffer), Boolean.valueOf(fin), this.events.onText, this.activeMessage);
                }
                if (this.activeMessage == null) {
                    if (this.events.onText == null) {
                        this.activeMessage = NullMessage.INSTANCE;
                    } else if (this.events.onText.isStreaming()) {
                        MessageReader reader = new MessageReader(this.session);
                        this.activeMessage = reader;
                        dispatch(()
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0079: INVOKE  
                              (r7v0 'this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver A[D('this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver), IMMUTABLE_TYPE, THIS])
                              (wrap: java.lang.Runnable : 0x0074: INVOKE_CUSTOM (r1v5 java.lang.Runnable A[REMOVE]) = 
                              (r7v0 'this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver A[D('this' org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                              (r0v13 'reader' org.eclipse.jetty.websocket.common.message.MessageReader A[D('reader' org.eclipse.jetty.websocket.common.message.MessageReader), DONT_INLINE])
                            
                             handle type: INVOKE_DIRECT
                             lambda: java.lang.Runnable.run():void
                             call insn: ?: INVOKE  
                              (r1 I:org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver)
                              (r2 I:org.eclipse.jetty.websocket.common.message.MessageReader)
                             type: DIRECT call: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.lambda$onTextFrame$1(org.eclipse.jetty.websocket.common.message.MessageReader):void)
                             type: VIRTUAL call: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.dispatch(java.lang.Runnable):void in method: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.onTextFrame(java.nio.ByteBuffer, boolean):void, file: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyAnnotatedEventDriver.class
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                            	at jadx.core.codegen.RegionGen.connectElseIf(RegionGen.java:170)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:147)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
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
                            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
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
                            	... 29 more
                            */
                        /*
                            this = this;
                            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.LOG
                            boolean r0 = r0.isDebugEnabled()
                            if (r0 == 0) goto L_0x0038
                            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.LOG
                            java.lang.String r1 = "onTextFrame({}, {}) - events.onText={}, activeMessage={}"
                            r2 = 4
                            java.lang.Object[] r2 = new java.lang.Object[r2]
                            r3 = r2
                            r4 = 0
                            r5 = r8
                            java.lang.String r5 = org.eclipse.jetty.util.BufferUtil.toDetailString(r5)
                            r3[r4] = r5
                            r3 = r2
                            r4 = 1
                            r5 = r9
                            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
                            r3[r4] = r5
                            r3 = r2
                            r4 = 2
                            r5 = r7
                            org.eclipse.jetty.websocket.common.events.JettyAnnotatedMetadata r5 = r5.events
                            org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod r5 = r5.onText
                            r3[r4] = r5
                            r3 = r2
                            r4 = 3
                            r5 = r7
                            org.eclipse.jetty.websocket.common.message.MessageAppender r5 = r5.activeMessage
                            r3[r4] = r5
                            r0.debug(r1, r2)
                        L_0x0038:
                            r0 = r7
                            org.eclipse.jetty.websocket.common.message.MessageAppender r0 = r0.activeMessage
                            if (r0 != 0) goto L_0x008b
                            r0 = r7
                            org.eclipse.jetty.websocket.common.events.JettyAnnotatedMetadata r0 = r0.events
                            org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod r0 = r0.onText
                            if (r0 != 0) goto L_0x0053
                            r0 = r7
                            org.eclipse.jetty.websocket.common.message.MessageAppender r1 = org.eclipse.jetty.websocket.common.message.NullMessage.INSTANCE
                            r0.activeMessage = r1
                            goto L_0x008b
                        L_0x0053:
                            r0 = r7
                            org.eclipse.jetty.websocket.common.events.JettyAnnotatedMetadata r0 = r0.events
                            org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod r0 = r0.onText
                            boolean r0 = r0.isStreaming()
                            if (r0 == 0) goto L_0x007f
                            org.eclipse.jetty.websocket.common.message.MessageReader r0 = new org.eclipse.jetty.websocket.common.message.MessageReader
                            r1 = r0
                            r2 = r7
                            org.eclipse.jetty.websocket.common.WebSocketSession r2 = r2.session
                            r1.<init>(r2)
                            r10 = r0
                            r0 = r7
                            r1 = r10
                            r0.activeMessage = r1
                            r0 = r7
                            r1 = r7
                            r2 = r10
                            void r1 = () -> { // java.lang.Runnable.run():void
                                r1.lambda$onTextFrame$1(r2);
                            }
                            r0.dispatch(r1)
                            goto L_0x008b
                        L_0x007f:
                            r0 = r7
                            org.eclipse.jetty.websocket.common.message.SimpleTextMessage r1 = new org.eclipse.jetty.websocket.common.message.SimpleTextMessage
                            r2 = r1
                            r3 = r7
                            r2.<init>(r3)
                            r0.activeMessage = r1
                        L_0x008b:
                            r0 = r7
                            r1 = r8
                            r2 = r9
                            r0.appendMessage(r1, r2)
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.websocket.common.events.JettyAnnotatedEventDriver.onTextFrame(java.nio.ByteBuffer, boolean):void");
                    }

                    @Override // org.eclipse.jetty.websocket.common.events.EventDriver
                    public void onTextMessage(String message) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("onTextMessage([{}] \"{}\") - events.onText={}", Integer.valueOf(message.length()), TextUtil.maxStringLength(60, message), this.events.onText);
                        }
                        if (this.events.onText != null) {
                            this.events.onText.call(this.websocket, this.session, message);
                        }
                    }

                    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
                    public String toString() {
                        return String.format("%s[%s]", getClass().getSimpleName(), this.websocket);
                    }
                }
