package org.jline.terminal.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import org.jline.terminal.Terminal;
import org.jline.terminal.spi.Pty;
import org.jline.utils.NonBlocking;
import org.jline.utils.NonBlockingInputStream;
import org.jline.utils.NonBlockingReader;
import org.jline.utils.ShutdownHooks;
import org.jline.utils.Signals;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/PosixSysTerminal.class */
public class PosixSysTerminal extends AbstractPosixTerminal {
    protected final NonBlockingInputStream input;
    protected final OutputStream output;
    protected final NonBlockingReader reader;
    protected final PrintWriter writer;
    protected final Map<Terminal.Signal, Object> nativeHandlers = new HashMap();
    protected final ShutdownHooks.Task closer;

    public PosixSysTerminal(String name, String type, Pty pty, Charset encoding, boolean nativeSignals, Terminal.SignalHandler signalHandler) throws IOException {
        super(name, type, pty, encoding, signalHandler);
        this.input = NonBlocking.nonBlocking(getName(), pty.getSlaveInput());
        this.output = pty.getSlaveOutput();
        this.reader = NonBlocking.nonBlocking(getName(), this.input, encoding());
        this.writer = new PrintWriter(new OutputStreamWriter(this.output, encoding()));
        parseInfoCmp();
        if (nativeSignals) {
            Terminal.Signal[] values = Terminal.Signal.values();
            for (Terminal.Signal signal : values) {
                if (signalHandler == Terminal.SignalHandler.SIG_DFL) {
                    this.nativeHandlers.put(signal, Signals.registerDefault(signal.name()));
                } else {
                    this.nativeHandlers.put(signal, Signals.register(signal.name(), ()
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00b7: INVOKE  
                          (wrap: java.util.Map<org.jline.terminal.Terminal$Signal, java.lang.Object> : 0x00a2: IGET  (r0v21 java.util.Map<org.jline.terminal.Terminal$Signal, java.lang.Object> A[REMOVE]) = 
                          (r8v0 'this' org.jline.terminal.impl.PosixSysTerminal A[D('this' org.jline.terminal.impl.PosixSysTerminal), IMMUTABLE_TYPE, THIS])
                         org.jline.terminal.impl.PosixSysTerminal.nativeHandlers java.util.Map)
                          (r0v18 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal)])
                          (wrap: java.lang.Object : 0x00b4: INVOKE  (r2v9 java.lang.Object A[REMOVE]) = 
                          (wrap: java.lang.String : 0x00a9: INVOKE  (r2v8 java.lang.String A[REMOVE]) = (r0v18 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal)]) type: VIRTUAL call: org.jline.terminal.Terminal.Signal.name():java.lang.String)
                          (wrap: java.lang.Runnable : 0x00af: INVOKE_CUSTOM (r3v5 java.lang.Runnable A[REMOVE]) = 
                          (r8v0 'this' org.jline.terminal.impl.PosixSysTerminal A[D('this' org.jline.terminal.impl.PosixSysTerminal), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                          (r0v18 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal), DONT_INLINE])
                        
                         handle type: INVOKE_DIRECT
                         lambda: java.lang.Runnable.run():void
                         call insn: ?: INVOKE  (r3 I:org.jline.terminal.impl.PosixSysTerminal), (r4 I:org.jline.terminal.Terminal$Signal) type: DIRECT call: org.jline.terminal.impl.PosixSysTerminal.lambda$new$0(org.jline.terminal.Terminal$Signal):void)
                         type: STATIC call: org.jline.utils.Signals.register(java.lang.String, java.lang.Runnable):java.lang.Object)
                         type: INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object in method: org.jline.terminal.impl.PosixSysTerminal.<init>(java.lang.String, java.lang.String, org.jline.terminal.spi.Pty, java.nio.charset.Charset, boolean, org.jline.terminal.Terminal$SignalHandler):void, file: grasscutter.jar:org/jline/terminal/impl/PosixSysTerminal.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:151)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                        	... 33 more
                        */
                    /*
                        this = this;
                        r0 = r8
                        r1 = r9
                        r2 = r10
                        r3 = r11
                        r4 = r12
                        r5 = r14
                        r0.<init>(r1, r2, r3, r4, r5)
                        r0 = r8
                        java.util.HashMap r1 = new java.util.HashMap
                        r2 = r1
                        r2.<init>()
                        r0.nativeHandlers = r1
                        r0 = r8
                        r1 = r8
                        java.lang.String r1 = r1.getName()
                        r2 = r11
                        java.io.InputStream r2 = r2.getSlaveInput()
                        org.jline.utils.NonBlockingInputStream r1 = org.jline.utils.NonBlocking.nonBlocking(r1, r2)
                        r0.input = r1
                        r0 = r8
                        r1 = r11
                        java.io.OutputStream r1 = r1.getSlaveOutput()
                        r0.output = r1
                        r0 = r8
                        r1 = r8
                        java.lang.String r1 = r1.getName()
                        r2 = r8
                        org.jline.utils.NonBlockingInputStream r2 = r2.input
                        r3 = r8
                        java.nio.charset.Charset r3 = r3.encoding()
                        org.jline.utils.NonBlockingReader r1 = org.jline.utils.NonBlocking.nonBlocking(r1, r2, r3)
                        r0.reader = r1
                        r0 = r8
                        java.io.PrintWriter r1 = new java.io.PrintWriter
                        r2 = r1
                        java.io.OutputStreamWriter r3 = new java.io.OutputStreamWriter
                        r4 = r3
                        r5 = r8
                        java.io.OutputStream r5 = r5.output
                        r6 = r8
                        java.nio.charset.Charset r6 = r6.encoding()
                        r4.<init>(r5, r6)
                        r2.<init>(r3)
                        r0.writer = r1
                        r0 = r8
                        r0.parseInfoCmp()
                        r0 = r13
                        if (r0 == 0) goto L_0x00c3
                        org.jline.terminal.Terminal$Signal[] r0 = org.jline.terminal.Terminal.Signal.values()
                        r15 = r0
                        r0 = r15
                        int r0 = r0.length
                        r16 = r0
                        r0 = 0
                        r17 = r0
                    L_0x0074:
                        r0 = r17
                        r1 = r16
                        if (r0 >= r1) goto L_0x00c3
                        r0 = r15
                        r1 = r17
                        r0 = r0[r1]
                        r18 = r0
                        r0 = r14
                        org.jline.terminal.Terminal$SignalHandler r1 = org.jline.terminal.Terminal.SignalHandler.SIG_DFL
                        if (r0 != r1) goto L_0x00a1
                        r0 = r8
                        java.util.Map<org.jline.terminal.Terminal$Signal, java.lang.Object> r0 = r0.nativeHandlers
                        r1 = r18
                        r2 = r18
                        java.lang.String r2 = r2.name()
                        java.lang.Object r2 = org.jline.utils.Signals.registerDefault(r2)
                        java.lang.Object r0 = r0.put(r1, r2)
                        goto L_0x00bd
                    L_0x00a1:
                        r0 = r8
                        java.util.Map<org.jline.terminal.Terminal$Signal, java.lang.Object> r0 = r0.nativeHandlers
                        r1 = r18
                        r2 = r18
                        java.lang.String r2 = r2.name()
                        r3 = r8
                        r4 = r18
                        void r3 = () -> { // java.lang.Runnable.run():void
                            r3.lambda$new$0(r4);
                        }
                        java.lang.Object r2 = org.jline.utils.Signals.register(r2, r3)
                        java.lang.Object r0 = r0.put(r1, r2)
                    L_0x00bd:
                        int r17 = r17 + 1
                        goto L_0x0074
                    L_0x00c3:
                        r0 = r8
                        r1 = r8
                        void r1 = this::close
                        r0.closer = r1
                        r0 = r8
                        org.jline.utils.ShutdownHooks$Task r0 = r0.closer
                        org.jline.utils.ShutdownHooks$Task r0 = org.jline.utils.ShutdownHooks.add(r0)
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.jline.terminal.impl.PosixSysTerminal.<init>(java.lang.String, java.lang.String, org.jline.terminal.spi.Pty, java.nio.charset.Charset, boolean, org.jline.terminal.Terminal$SignalHandler):void");
                }

                @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                public Terminal.SignalHandler handle(Terminal.Signal signal, Terminal.SignalHandler handler) {
                    Terminal.SignalHandler prev = handle(signal, handler);
                    if (prev != handler) {
                        if (handler == Terminal.SignalHandler.SIG_DFL) {
                            Signals.registerDefault(signal.name());
                        } else {
                            Signals.register(signal.name(), ()
                            /*  JADX ERROR: Method code generation error
                                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0029: INVOKE  
                                  (wrap: java.lang.String : 0x001f: INVOKE  (r0v6 java.lang.String A[REMOVE]) = (r5v0 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal)]) type: VIRTUAL call: org.jline.terminal.Terminal.Signal.name():java.lang.String)
                                  (wrap: java.lang.Runnable : 0x0024: INVOKE_CUSTOM (r1v4 java.lang.Runnable A[REMOVE]) = 
                                  (r4v0 'this' org.jline.terminal.impl.PosixSysTerminal A[D('this' org.jline.terminal.impl.PosixSysTerminal), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                                  (r5v0 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal), DONT_INLINE])
                                
                                 handle type: INVOKE_DIRECT
                                 lambda: java.lang.Runnable.run():void
                                 call insn: ?: INVOKE  (r1 I:org.jline.terminal.impl.PosixSysTerminal), (r2 I:org.jline.terminal.Terminal$Signal) type: DIRECT call: org.jline.terminal.impl.PosixSysTerminal.lambda$handle$1(org.jline.terminal.Terminal$Signal):void)
                                 type: STATIC call: org.jline.utils.Signals.register(java.lang.String, java.lang.Runnable):java.lang.Object in method: org.jline.terminal.impl.PosixSysTerminal.handle(org.jline.terminal.Terminal$Signal, org.jline.terminal.Terminal$SignalHandler):org.jline.terminal.Terminal$SignalHandler, file: grasscutter.jar:org/jline/terminal/impl/PosixSysTerminal.class
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:151)
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
                                	... 27 more
                                */
                            /*
                                this = this;
                                r0 = r4
                                r1 = r5
                                r2 = r6
                                org.jline.terminal.Terminal$SignalHandler r0 = r0.handle(r1, r2)
                                r7 = r0
                                r0 = r7
                                r1 = r6
                                if (r0 == r1) goto L_0x002d
                                r0 = r6
                                org.jline.terminal.Terminal$SignalHandler r1 = org.jline.terminal.Terminal.SignalHandler.SIG_DFL
                                if (r0 != r1) goto L_0x001e
                                r0 = r5
                                java.lang.String r0 = r0.name()
                                java.lang.Object r0 = org.jline.utils.Signals.registerDefault(r0)
                                goto L_0x002d
                            L_0x001e:
                                r0 = r5
                                java.lang.String r0 = r0.name()
                                r1 = r4
                                r2 = r5
                                org.jline.terminal.Terminal$SignalHandler r1 = () -> { // java.lang.Runnable.run():void
                                    r1.lambda$handle$1(r2);
                                }
                                java.lang.Object r0 = org.jline.utils.Signals.register(r0, r1)
                            L_0x002d:
                                r0 = r7
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: org.jline.terminal.impl.PosixSysTerminal.handle(org.jline.terminal.Terminal$Signal, org.jline.terminal.Terminal$SignalHandler):org.jline.terminal.Terminal$SignalHandler");
                        }

                        @Override // org.jline.terminal.Terminal
                        public NonBlockingReader reader() {
                            return this.reader;
                        }

                        @Override // org.jline.terminal.Terminal
                        public PrintWriter writer() {
                            return this.writer;
                        }

                        @Override // org.jline.terminal.Terminal
                        public InputStream input() {
                            return this.input;
                        }

                        @Override // org.jline.terminal.Terminal
                        public OutputStream output() {
                            return this.output;
                        }

                        /* access modifiers changed from: protected */
                        @Override // org.jline.terminal.impl.AbstractPosixTerminal, org.jline.terminal.impl.AbstractTerminal
                        public void doClose() throws IOException {
                            ShutdownHooks.remove(this.closer);
                            for (Map.Entry<Terminal.Signal, Object> entry : this.nativeHandlers.entrySet()) {
                                Signals.unregister(entry.getKey().name(), entry.getValue());
                            }
                            doClose();
                            this.reader.shutdown();
                        }
                    }
