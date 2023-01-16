package org.jline.terminal.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.utils.Curses;
import org.jline.utils.InfoCmp;
import org.jline.utils.NonBlocking;
import org.jline.utils.NonBlockingInputStream;
import org.jline.utils.NonBlockingPumpReader;
import org.jline.utils.NonBlockingReader;
import org.jline.utils.ShutdownHooks;
import org.jline.utils.Signals;
import org.jline.utils.WriterOutputStream;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/AbstractWindowsTerminal.class */
public abstract class AbstractWindowsTerminal extends AbstractTerminal {
    public static final String TYPE_WINDOWS = "windows";
    public static final String TYPE_WINDOWS_256_COLOR = "windows-256color";
    public static final String TYPE_WINDOWS_CONEMU = "windows-conemu";
    public static final String TYPE_WINDOWS_VTP = "windows-vtp";
    public static final int ENABLE_VIRTUAL_TERMINAL_PROCESSING = 4;
    private static final int UTF8_CODE_PAGE = 65001;
    protected static final int ENABLE_PROCESSED_INPUT = 1;
    protected static final int ENABLE_LINE_INPUT = 2;
    protected static final int ENABLE_ECHO_INPUT = 4;
    protected static final int ENABLE_WINDOW_INPUT = 8;
    protected static final int ENABLE_MOUSE_INPUT = 16;
    protected static final int ENABLE_INSERT_MODE = 32;
    protected static final int ENABLE_QUICK_EDIT_MODE = 64;
    protected final Writer slaveInputPipe;
    protected final NonBlockingInputStream input;
    protected final OutputStream output;
    protected final NonBlockingReader reader;
    protected final PrintWriter writer;
    protected final ShutdownHooks.Task closer;
    protected Thread pump;
    private volatile boolean closing;
    static final int SHIFT_FLAG = 1;
    static final int ALT_FLAG = 2;
    static final int CTRL_FLAG = 4;
    static final int RIGHT_ALT_PRESSED = 1;
    static final int LEFT_ALT_PRESSED = 2;
    static final int RIGHT_CTRL_PRESSED = 4;
    static final int LEFT_CTRL_PRESSED = 8;
    static final int SHIFT_PRESSED = 16;
    static final int NUMLOCK_ON = 32;
    static final int SCROLLLOCK_ON = 64;
    static final int CAPSLOCK_ON = 128;
    protected final Map<Terminal.Signal, Object> nativeHandlers = new HashMap();
    protected final Attributes attributes = new Attributes();
    protected final Object lock = new Object();
    protected boolean paused = true;
    protected Terminal.MouseTracking tracking = Terminal.MouseTracking.Off;
    protected boolean focusTracking = false;
    protected final int originalConsoleMode = getConsoleMode();

    protected abstract int getConsoleMode();

    protected abstract void setConsoleMode(int i);

    protected abstract boolean processConsoleInput() throws IOException;

    public AbstractWindowsTerminal(Writer writer, String name, String type, Charset encoding, int codepage, boolean nativeSignals, Terminal.SignalHandler signalHandler) throws IOException {
        super(name, type, selectCharset(encoding, codepage), signalHandler);
        NonBlockingPumpReader reader = NonBlocking.nonBlockingPumpReader();
        this.slaveInputPipe = reader.getWriter();
        this.reader = reader;
        this.input = NonBlocking.nonBlockingStream(reader, encoding());
        this.writer = new PrintWriter(writer);
        this.output = new WriterOutputStream(writer, encoding());
        parseInfoCmp();
        this.attributes.setLocalFlag(Attributes.LocalFlag.ISIG, true);
        this.attributes.setControlChar(Attributes.ControlChar.VINTR, ctrl('C'));
        this.attributes.setControlChar(Attributes.ControlChar.VEOF, ctrl('D'));
        this.attributes.setControlChar(Attributes.ControlChar.VSUSP, ctrl('Z'));
        if (nativeSignals) {
            Terminal.Signal[] values = Terminal.Signal.values();
            for (Terminal.Signal signal : values) {
                if (signalHandler == Terminal.SignalHandler.SIG_DFL) {
                    this.nativeHandlers.put(signal, Signals.registerDefault(signal.name()));
                } else {
                    this.nativeHandlers.put(signal, Signals.register(signal.name(), ()
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x011a: INVOKE  
                          (wrap: java.util.Map<org.jline.terminal.Terminal$Signal, java.lang.Object> : 0x0105: IGET  (r0v43 java.util.Map<org.jline.terminal.Terminal$Signal, java.lang.Object> A[REMOVE]) = 
                          (r6v0 'this' org.jline.terminal.impl.AbstractWindowsTerminal A[D('this' org.jline.terminal.impl.AbstractWindowsTerminal), IMMUTABLE_TYPE, THIS])
                         org.jline.terminal.impl.AbstractWindowsTerminal.nativeHandlers java.util.Map)
                          (r0v40 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal)])
                          (wrap: java.lang.Object : 0x0117: INVOKE  (r2v17 java.lang.Object A[REMOVE]) = 
                          (wrap: java.lang.String : 0x010c: INVOKE  (r2v16 java.lang.String A[REMOVE]) = (r0v40 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal)]) type: VIRTUAL call: org.jline.terminal.Terminal.Signal.name():java.lang.String)
                          (wrap: java.lang.Runnable : 0x0112: INVOKE_CUSTOM (r3v8 java.lang.Runnable A[REMOVE]) = 
                          (r6v0 'this' org.jline.terminal.impl.AbstractWindowsTerminal A[D('this' org.jline.terminal.impl.AbstractWindowsTerminal), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                          (r0v40 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal), DONT_INLINE])
                        
                         handle type: INVOKE_DIRECT
                         lambda: java.lang.Runnable.run():void
                         call insn: ?: INVOKE  (r3 I:org.jline.terminal.impl.AbstractWindowsTerminal), (r4 I:org.jline.terminal.Terminal$Signal) type: DIRECT call: org.jline.terminal.impl.AbstractWindowsTerminal.lambda$new$0(org.jline.terminal.Terminal$Signal):void)
                         type: STATIC call: org.jline.utils.Signals.register(java.lang.String, java.lang.Runnable):java.lang.Object)
                         type: INTERFACE call: java.util.Map.put(java.lang.Object, java.lang.Object):java.lang.Object in method: org.jline.terminal.impl.AbstractWindowsTerminal.<init>(java.io.Writer, java.lang.String, java.lang.String, java.nio.charset.Charset, int, boolean, org.jline.terminal.Terminal$SignalHandler):void, file: grasscutter.jar:org/jline/terminal/impl/AbstractWindowsTerminal.class
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
                    // Method dump skipped, instructions count: 343
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.jline.terminal.impl.AbstractWindowsTerminal.<init>(java.io.Writer, java.lang.String, java.lang.String, java.nio.charset.Charset, int, boolean, org.jline.terminal.Terminal$SignalHandler):void");
                }

                private static Charset selectCharset(Charset encoding, int codepage) {
                    if (encoding != null) {
                        return encoding;
                    }
                    if (codepage >= 0) {
                        return getCodepageCharset(codepage);
                    }
                    return StandardCharsets.UTF_8;
                }

                private static Charset getCodepageCharset(int codepage) {
                    if (codepage == 65001) {
                        return StandardCharsets.UTF_8;
                    }
                    String charsetMS = "ms" + codepage;
                    if (Charset.isSupported(charsetMS)) {
                        return Charset.forName(charsetMS);
                    }
                    String charsetCP = "cp" + codepage;
                    if (Charset.isSupported(charsetCP)) {
                        return Charset.forName(charsetCP);
                    }
                    return Charset.defaultCharset();
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
                                  (r4v0 'this' org.jline.terminal.impl.AbstractWindowsTerminal A[D('this' org.jline.terminal.impl.AbstractWindowsTerminal), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                                  (r5v0 'signal' org.jline.terminal.Terminal$Signal A[D('signal' org.jline.terminal.Terminal$Signal), DONT_INLINE])
                                
                                 handle type: INVOKE_DIRECT
                                 lambda: java.lang.Runnable.run():void
                                 call insn: ?: INVOKE  (r1 I:org.jline.terminal.impl.AbstractWindowsTerminal), (r2 I:org.jline.terminal.Terminal$Signal) type: DIRECT call: org.jline.terminal.impl.AbstractWindowsTerminal.lambda$handle$1(org.jline.terminal.Terminal$Signal):void)
                                 type: STATIC call: org.jline.utils.Signals.register(java.lang.String, java.lang.Runnable):java.lang.Object in method: org.jline.terminal.impl.AbstractWindowsTerminal.handle(org.jline.terminal.Terminal$Signal, org.jline.terminal.Terminal$SignalHandler):org.jline.terminal.Terminal$SignalHandler, file: grasscutter.jar:org/jline/terminal/impl/AbstractWindowsTerminal.class
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
                            throw new UnsupportedOperationException("Method not decompiled: org.jline.terminal.impl.AbstractWindowsTerminal.handle(org.jline.terminal.Terminal$Signal, org.jline.terminal.Terminal$SignalHandler):org.jline.terminal.Terminal$SignalHandler");
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

                        @Override // org.jline.terminal.Terminal
                        public Attributes getAttributes() {
                            int mode = getConsoleMode();
                            if ((mode & 4) != 0) {
                                this.attributes.setLocalFlag(Attributes.LocalFlag.ECHO, true);
                            }
                            if ((mode & 2) != 0) {
                                this.attributes.setLocalFlag(Attributes.LocalFlag.ICANON, true);
                            }
                            return new Attributes(this.attributes);
                        }

                        @Override // org.jline.terminal.Terminal
                        public void setAttributes(Attributes attr) {
                            this.attributes.copy(attr);
                            updateConsoleMode();
                        }

                        protected void updateConsoleMode() {
                            int mode = 8;
                            if (this.attributes.getLocalFlag(Attributes.LocalFlag.ECHO)) {
                                mode = 8 | 4;
                            }
                            if (this.attributes.getLocalFlag(Attributes.LocalFlag.ICANON)) {
                                mode |= 2;
                            }
                            if (this.tracking != Terminal.MouseTracking.Off) {
                                mode |= 16;
                            }
                            setConsoleMode(mode);
                        }

                        protected int ctrl(char key) {
                            return Character.toUpperCase(key) & 31;
                        }

                        @Override // org.jline.terminal.Terminal
                        public void setSize(Size size) {
                            throw new UnsupportedOperationException("Can not resize windows terminal");
                        }

                        /* access modifiers changed from: protected */
                        @Override // org.jline.terminal.impl.AbstractTerminal
                        public void doClose() throws IOException {
                            doClose();
                            this.closing = true;
                            if (this.pump != null) {
                                this.pump.interrupt();
                            }
                            ShutdownHooks.remove(this.closer);
                            for (Map.Entry<Terminal.Signal, Object> entry : this.nativeHandlers.entrySet()) {
                                Signals.unregister(entry.getKey().name(), entry.getValue());
                            }
                            this.reader.close();
                            this.writer.close();
                            setConsoleMode(this.originalConsoleMode);
                        }

                        protected void processKeyEvent(boolean isKeyDown, short virtualKeyCode, char ch, int controlKeyState) throws IOException {
                            boolean isCtrl = (controlKeyState & 12) > 0;
                            boolean isAlt = (controlKeyState & 3) > 0;
                            boolean isShift = (controlKeyState & 16) > 0;
                            if (!isKeyDown || ch == 3) {
                                if (isKeyDown && ch == 3) {
                                    processInputChar(3);
                                } else if (virtualKeyCode == 18 && ch > 0) {
                                    processInputChar(ch);
                                }
                            } else if (ch == 0 || (controlKeyState & 31) != 9) {
                                String keySeq = getEscapeSequence(virtualKeyCode, (isCtrl ? 4 : 0) + (isAlt ? 2 : 0) + (isShift ? 1 : 0));
                                if (keySeq != null) {
                                    for (char c : keySeq.toCharArray()) {
                                        processInputChar(c);
                                    }
                                } else if (ch > 0) {
                                    if (isAlt) {
                                        processInputChar(27);
                                    }
                                    if (!isCtrl || ch == ' ' || ch == '\n' || ch == 127) {
                                        processInputChar(ch);
                                    } else {
                                        processInputChar((char) (ch == '?' ? 127 : Character.toUpperCase(ch) & 31));
                                    }
                                } else if (isCtrl) {
                                    if (virtualKeyCode >= 65 && virtualKeyCode <= 90) {
                                        ch = (char) (virtualKeyCode - 64);
                                    } else if (virtualKeyCode == 191) {
                                        ch = 127;
                                    }
                                    if (ch > 0) {
                                        if (isAlt) {
                                            processInputChar(27);
                                        }
                                        processInputChar(ch);
                                    }
                                }
                            } else {
                                processInputChar(ch);
                            }
                        }

                        protected String getEscapeSequence(short keyCode, int keyState) {
                            String escapeSequence;
                            switch (keyCode) {
                                case 8:
                                    escapeSequence = (keyState & 2) > 0 ? "\\E^H" : getRawSequence(InfoCmp.Capability.key_backspace);
                                    break;
                                case 9:
                                    escapeSequence = (keyState & 1) > 0 ? getRawSequence(InfoCmp.Capability.key_btab) : null;
                                    break;
                                case 10:
                                case 11:
                                case 12:
                                case 13:
                                case 14:
                                case 15:
                                case 16:
                                case 17:
                                case 18:
                                case 19:
                                case 20:
                                case 21:
                                case 22:
                                case 23:
                                case 24:
                                case 25:
                                case 26:
                                case 27:
                                case 28:
                                case 29:
                                case 30:
                                case 31:
                                case 32:
                                case 41:
                                case 42:
                                case 43:
                                case 44:
                                case 47:
                                case 48:
                                case 49:
                                case 50:
                                case 51:
                                case 52:
                                case 53:
                                case 54:
                                case 55:
                                case 56:
                                case 57:
                                case 58:
                                case 59:
                                case 60:
                                case 61:
                                case 62:
                                case 63:
                                case 64:
                                case 65:
                                case 66:
                                case 67:
                                case 68:
                                case 69:
                                case 70:
                                case 71:
                                case 72:
                                case 73:
                                case 74:
                                case 75:
                                case 76:
                                case 77:
                                case 78:
                                case 79:
                                case 80:
                                case 81:
                                case 82:
                                case 83:
                                case 84:
                                case 85:
                                case 86:
                                case 87:
                                case 88:
                                case 89:
                                case 90:
                                case 91:
                                case 92:
                                case 93:
                                case 94:
                                case 95:
                                case 96:
                                case 97:
                                case 98:
                                case 99:
                                case 100:
                                case 101:
                                case 102:
                                case 103:
                                case 104:
                                case 105:
                                case 106:
                                case 107:
                                case 108:
                                case 109:
                                case 110:
                                case 111:
                                default:
                                    return null;
                                case 33:
                                    escapeSequence = getRawSequence(InfoCmp.Capability.key_ppage);
                                    break;
                                case 34:
                                    escapeSequence = getRawSequence(InfoCmp.Capability.key_npage);
                                    break;
                                case 35:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dF" : getRawSequence(InfoCmp.Capability.key_end);
                                    break;
                                case 36:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dH" : getRawSequence(InfoCmp.Capability.key_home);
                                    break;
                                case 37:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dD" : getRawSequence(InfoCmp.Capability.key_left);
                                    break;
                                case 38:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dA" : getRawSequence(InfoCmp.Capability.key_up);
                                    break;
                                case 39:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dC" : getRawSequence(InfoCmp.Capability.key_right);
                                    break;
                                case 40:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dB" : getRawSequence(InfoCmp.Capability.key_down);
                                    break;
                                case 45:
                                    escapeSequence = getRawSequence(InfoCmp.Capability.key_ic);
                                    break;
                                case 46:
                                    escapeSequence = getRawSequence(InfoCmp.Capability.key_dc);
                                    break;
                                case 112:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dP" : getRawSequence(InfoCmp.Capability.key_f1);
                                    break;
                                case 113:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dQ" : getRawSequence(InfoCmp.Capability.key_f2);
                                    break;
                                case 114:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dR" : getRawSequence(InfoCmp.Capability.key_f3);
                                    break;
                                case 115:
                                    escapeSequence = keyState > 0 ? "\\E[1;%p1%dS" : getRawSequence(InfoCmp.Capability.key_f4);
                                    break;
                                case 116:
                                    escapeSequence = keyState > 0 ? "\\E[15;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f5);
                                    break;
                                case 117:
                                    escapeSequence = keyState > 0 ? "\\E[17;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f6);
                                    break;
                                case 118:
                                    escapeSequence = keyState > 0 ? "\\E[18;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f7);
                                    break;
                                case 119:
                                    escapeSequence = keyState > 0 ? "\\E[19;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f8);
                                    break;
                                case 120:
                                    escapeSequence = keyState > 0 ? "\\E[20;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f9);
                                    break;
                                case 121:
                                    escapeSequence = keyState > 0 ? "\\E[21;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f10);
                                    break;
                                case 122:
                                    escapeSequence = keyState > 0 ? "\\E[23;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f11);
                                    break;
                                case 123:
                                    escapeSequence = keyState > 0 ? "\\E[24;%p1%d~" : getRawSequence(InfoCmp.Capability.key_f12);
                                    break;
                            }
                            return Curses.tputs(escapeSequence, Integer.valueOf(keyState + 1));
                        }

                        protected String getRawSequence(InfoCmp.Capability cap) {
                            return (String) this.strings.get(cap);
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public boolean hasFocusSupport() {
                            return true;
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public boolean trackFocus(boolean tracking) {
                            this.focusTracking = tracking;
                            return true;
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public boolean canPauseResume() {
                            return true;
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public void pause() {
                            synchronized (this.lock) {
                                this.paused = true;
                            }
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public void pause(boolean wait) throws InterruptedException {
                            Thread p;
                            synchronized (this.lock) {
                                this.paused = true;
                                p = this.pump;
                            }
                            if (p != null) {
                                p.interrupt();
                                p.join();
                            }
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public void resume() {
                            synchronized (this.lock) {
                                this.paused = false;
                                if (this.pump == null) {
                                    this.pump = new Thread(this::pump, "WindowsStreamPump");
                                    this.pump.setDaemon(true);
                                    this.pump.start();
                                }
                            }
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public boolean paused() {
                            boolean z;
                            synchronized (this.lock) {
                                z = this.paused;
                            }
                            return z;
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:20:0x002d, code lost:
                            if (processConsoleInput() == false) goto L_0x0000;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0030, code lost:
                            r5.slaveInputPipe.flush();
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:8:0x0015, code lost:
                            r5.pump = null;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:68:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        protected void pump() {
                            /*
                            // Method dump skipped, instructions count: 191
                            */
                            throw new UnsupportedOperationException("Method not decompiled: org.jline.terminal.impl.AbstractWindowsTerminal.pump():void");
                        }

                        public void processInputChar(char c) throws IOException {
                            if (this.attributes.getLocalFlag(Attributes.LocalFlag.ISIG)) {
                                if (c == this.attributes.getControlChar(Attributes.ControlChar.VINTR)) {
                                    raise(Terminal.Signal.INT);
                                    return;
                                } else if (c == this.attributes.getControlChar(Attributes.ControlChar.VQUIT)) {
                                    raise(Terminal.Signal.QUIT);
                                    return;
                                } else if (c == this.attributes.getControlChar(Attributes.ControlChar.VSUSP)) {
                                    raise(Terminal.Signal.TSTP);
                                    return;
                                } else if (c == this.attributes.getControlChar(Attributes.ControlChar.VSTATUS)) {
                                    raise(Terminal.Signal.INFO);
                                }
                            }
                            if (c == '\r') {
                                if (!this.attributes.getInputFlag(Attributes.InputFlag.IGNCR)) {
                                    if (this.attributes.getInputFlag(Attributes.InputFlag.ICRNL)) {
                                        c = '\n';
                                    }
                                } else {
                                    return;
                                }
                            } else if (c == '\n' && this.attributes.getInputFlag(Attributes.InputFlag.INLCR)) {
                                c = '\r';
                            }
                            this.slaveInputPipe.write(c);
                        }

                        @Override // org.jline.terminal.impl.AbstractTerminal, org.jline.terminal.Terminal
                        public boolean trackMouse(Terminal.MouseTracking tracking) {
                            this.tracking = tracking;
                            updateConsoleMode();
                            return true;
                        }
                    }
