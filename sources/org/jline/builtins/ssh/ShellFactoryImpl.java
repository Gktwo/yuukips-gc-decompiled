package org.jline.builtins.ssh;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;
import java.util.function.Consumer;
import org.apache.sshd.common.channel.PtyMode;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;
import org.apache.sshd.server.Signal;
import org.apache.sshd.server.channel.ChannelSession;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.shell.ShellFactory;
import org.jline.builtins.ssh.Ssh;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

/* loaded from: grasscutter.jar:org/jline/builtins/ssh/ShellFactoryImpl.class */
public class ShellFactoryImpl implements ShellFactory {
    private final Consumer<Ssh.ShellParams> shell;

    public ShellFactoryImpl(Consumer<Ssh.ShellParams> shell) {
        this.shell = shell;
    }

    /* access modifiers changed from: private */
    public static void flush(OutputStream... streams) {
        for (OutputStream s : streams) {
            try {
                s.flush();
            } catch (IOException e) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public static void close(Closeable... closeables) {
        for (Closeable c : closeables) {
            try {
                c.close();
            } catch (IOException e) {
            }
        }
    }

    public Command createShell(ChannelSession session) {
        return new ShellImpl();
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/ssh/ShellFactoryImpl$ShellImpl.class */
    public class ShellImpl implements Command {

        /* renamed from: in */
        private InputStream f3174in;
        private OutputStream out;
        private OutputStream err;
        private ExitCallback callback;
        private boolean closed;

        public ShellImpl() {
        }

        public void setInputStream(InputStream in) {
            this.f3174in = in;
        }

        public void setOutputStream(OutputStream out) {
            this.out = out;
        }

        public void setErrorStream(OutputStream err) {
            this.err = err;
        }

        public void setExitCallback(ExitCallback callback) {
            this.callback = callback;
        }

        public void start(ChannelSession session, Environment env) throws IOException {
            try {
                new Thread(()
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x000f: INVOKE  
                      (wrap: java.lang.Thread : 0x000c: CONSTRUCTOR  (r0v1 java.lang.Thread A[REMOVE]) = 
                      (wrap: java.lang.Runnable : 0x0007: INVOKE_CUSTOM (r2v2 java.lang.Runnable A[REMOVE]) = 
                      (r6v0 'this' org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl A[D('this' org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                      (r7v0 'session' org.apache.sshd.server.channel.ChannelSession A[D('session' org.apache.sshd.server.channel.ChannelSession), DONT_INLINE])
                      (r8v0 'env' org.apache.sshd.server.Environment A[D('env' org.apache.sshd.server.Environment), DONT_INLINE])
                    
                     handle type: INVOKE_DIRECT
                     lambda: java.lang.Runnable.run():void
                     call insn: ?: INVOKE  
                      (r2 I:org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl)
                      (r3 I:org.apache.sshd.server.channel.ChannelSession)
                      (r4 I:org.apache.sshd.server.Environment)
                     type: DIRECT call: org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.lambda$start$0(org.apache.sshd.server.channel.ChannelSession, org.apache.sshd.server.Environment):void)
                     call: java.lang.Thread.<init>(java.lang.Runnable):void type: CONSTRUCTOR)
                     type: VIRTUAL call: java.lang.Thread.start():void in method: org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.start(org.apache.sshd.server.channel.ChannelSession, org.apache.sshd.server.Environment):void, file: grasscutter.jar:org/jline/builtins/ssh/ShellFactoryImpl$ShellImpl.class
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
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:711)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.addArgDot(InsnGen.java:93)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:770)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 21 more
                    */
                /*
                    this = this;
                    java.lang.Thread r0 = new java.lang.Thread     // Catch: Exception -> 0x0015
                    r1 = r0
                    r2 = r6
                    r3 = r7
                    r4 = r8
                    void r2 = () -> { // java.lang.Runnable.run():void
                        r2.lambda$start$0(r3, r4);
                    }     // Catch: Exception -> 0x0015
                    r1.<init>(r2)     // Catch: Exception -> 0x0015
                    r0.start()     // Catch: Exception -> 0x0015
                    goto L_0x0021
                L_0x0015:
                    r9 = move-exception
                    java.io.IOException r0 = new java.io.IOException
                    r1 = r0
                    java.lang.String r2 = "Unable to start shell"
                    r3 = r9
                    r1.<init>(r2, r3)
                    throw r0
                L_0x0021:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.start(org.apache.sshd.server.channel.ChannelSession, org.apache.sshd.server.Environment):void");
            }

            public void run(ChannelSession session, Environment env) throws Exception {
                try {
                    Terminal terminal = TerminalBuilder.builder().name("JLine SSH").type((String) env.getEnv().get("TERM")).system(false).streams(this.f3174in, this.out).build();
                    terminal.setSize(new Size(Integer.parseInt((String) env.getEnv().get("COLUMNS")), Integer.parseInt((String) env.getEnv().get("LINES"))));
                    Attributes attr = terminal.getAttributes();
                    for (Map.Entry<PtyMode, Integer> e : env.getPtyModes().entrySet()) {
                        switch (C58301.$SwitchMap$org$apache$sshd$common$channel$PtyMode[e.getKey().ordinal()]) {
                            case 1:
                                attr.setControlChar(Attributes.ControlChar.VINTR, e.getValue().intValue());
                                break;
                            case 2:
                                attr.setControlChar(Attributes.ControlChar.VQUIT, e.getValue().intValue());
                                break;
                            case 3:
                                attr.setControlChar(Attributes.ControlChar.VERASE, e.getValue().intValue());
                                break;
                            case 4:
                                attr.setControlChar(Attributes.ControlChar.VKILL, e.getValue().intValue());
                                break;
                            case 5:
                                attr.setControlChar(Attributes.ControlChar.VEOF, e.getValue().intValue());
                                break;
                            case 6:
                                attr.setControlChar(Attributes.ControlChar.VEOL, e.getValue().intValue());
                                break;
                            case 7:
                                attr.setControlChar(Attributes.ControlChar.VEOL2, e.getValue().intValue());
                                break;
                            case 8:
                                attr.setControlChar(Attributes.ControlChar.VSTART, e.getValue().intValue());
                                break;
                            case 9:
                                attr.setControlChar(Attributes.ControlChar.VSTOP, e.getValue().intValue());
                                break;
                            case 10:
                                attr.setControlChar(Attributes.ControlChar.VSUSP, e.getValue().intValue());
                                break;
                            case 11:
                                attr.setControlChar(Attributes.ControlChar.VDSUSP, e.getValue().intValue());
                                break;
                            case 12:
                                attr.setControlChar(Attributes.ControlChar.VREPRINT, e.getValue().intValue());
                                break;
                            case 13:
                                attr.setControlChar(Attributes.ControlChar.VWERASE, e.getValue().intValue());
                                break;
                            case 14:
                                attr.setControlChar(Attributes.ControlChar.VLNEXT, e.getValue().intValue());
                                break;
                            case 15:
                                attr.setControlChar(Attributes.ControlChar.VSTATUS, e.getValue().intValue());
                                break;
                            case 16:
                                attr.setControlChar(Attributes.ControlChar.VDISCARD, e.getValue().intValue());
                                break;
                            case 17:
                                attr.setLocalFlag(Attributes.LocalFlag.ECHO, e.getValue().intValue() != 0);
                                break;
                            case 18:
                                attr.setLocalFlag(Attributes.LocalFlag.ICANON, e.getValue().intValue() != 0);
                                break;
                            case 19:
                                attr.setLocalFlag(Attributes.LocalFlag.ISIG, e.getValue().intValue() != 0);
                                break;
                            case 20:
                                attr.setInputFlag(Attributes.InputFlag.ICRNL, e.getValue().intValue() != 0);
                                break;
                            case 21:
                                attr.setInputFlag(Attributes.InputFlag.INLCR, e.getValue().intValue() != 0);
                                break;
                            case 22:
                                attr.setInputFlag(Attributes.InputFlag.IGNCR, e.getValue().intValue() != 0);
                                break;
                            case 23:
                                attr.setOutputFlag(Attributes.OutputFlag.OCRNL, e.getValue().intValue() != 0);
                                break;
                            case 24:
                                attr.setOutputFlag(Attributes.OutputFlag.ONLCR, e.getValue().intValue() != 0);
                                break;
                            case 25:
                                attr.setOutputFlag(Attributes.OutputFlag.ONLRET, e.getValue().intValue() != 0);
                                break;
                            case 26:
                                attr.setOutputFlag(Attributes.OutputFlag.OPOST, e.getValue().intValue() != 0);
                                break;
                        }
                    }
                    terminal.setAttributes(attr);
                    env.addSignalListener(channel, signals -> {
                        terminal.setSize(new Size(Integer.parseInt((String) env.getEnv().get("COLUMNS")), Integer.parseInt((String) env.getEnv().get("LINES"))));
                        terminal.raise(Terminal.Signal.WINCH);
                    }, new Signal[]{Signal.WINCH});
                    ShellFactoryImpl.this.shell.accept(new Ssh.ShellParams(env.getEnv(), session.getSession(), terminal, ()
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0417: INVOKE  
                          (wrap: java.util.function.Consumer : 0x03fb: IGET  (r0v20 java.util.function.Consumer A[REMOVE]) = 
                          (wrap: org.jline.builtins.ssh.ShellFactoryImpl : 0x03f8: IGET  (r0v19 org.jline.builtins.ssh.ShellFactoryImpl A[REMOVE]) = 
                          (r9v0 'this' org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl A[D('this' org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl), IMMUTABLE_TYPE, THIS])
                         org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.this$0 org.jline.builtins.ssh.ShellFactoryImpl)
                         org.jline.builtins.ssh.ShellFactoryImpl.shell java.util.function.Consumer)
                          (wrap: org.jline.builtins.ssh.Ssh$ShellParams : 0x0414: CONSTRUCTOR  (r1v12 org.jline.builtins.ssh.Ssh$ShellParams A[REMOVE]) = 
                          (wrap: java.util.Map : 0x0403: INVOKE  (r3v7 java.util.Map A[REMOVE]) = (r11v0 'env' org.apache.sshd.server.Environment A[D('env' org.apache.sshd.server.Environment)]) type: INTERFACE call: org.apache.sshd.server.Environment.getEnv():java.util.Map)
                          (wrap: org.apache.sshd.server.session.ServerSession : 0x0409: INVOKE  (r4v8 org.apache.sshd.server.session.ServerSession A[REMOVE]) = 
                          (r10v0 'session' org.apache.sshd.server.channel.ChannelSession A[D('session' org.apache.sshd.server.channel.ChannelSession)])
                         type: VIRTUAL call: org.apache.sshd.server.channel.ChannelSession.getSession():org.apache.sshd.server.session.ServerSession)
                          (r0v6 'terminal' org.jline.terminal.Terminal A[D('terminal' org.jline.terminal.Terminal)])
                          (wrap: java.lang.Runnable : 0x040f: INVOKE_CUSTOM (r6v1 java.lang.Runnable A[REMOVE]) = 
                          (r9v0 'this' org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl A[D('this' org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                          (r10v0 'session' org.apache.sshd.server.channel.ChannelSession A[D('session' org.apache.sshd.server.channel.ChannelSession), DONT_INLINE])
                        
                         handle type: INVOKE_DIRECT
                         lambda: java.lang.Runnable.run():void
                         call insn: ?: INVOKE  (r6 I:org.jline.builtins.ssh.ShellFactoryImpl$ShellImpl), (r7 I:org.apache.sshd.server.channel.ChannelSession) type: DIRECT call: org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.lambda$run$2(org.apache.sshd.server.channel.ChannelSession):void)
                         call: org.jline.builtins.ssh.Ssh.ShellParams.<init>(java.util.Map, org.apache.sshd.server.session.ServerSession, org.jline.terminal.Terminal, java.lang.Runnable):void type: CONSTRUCTOR)
                         type: INTERFACE call: java.util.function.Consumer.accept(java.lang.Object):void in method: org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.run(org.apache.sshd.server.channel.ChannelSession, org.apache.sshd.server.Environment):void, file: grasscutter.jar:org/jline/builtins/ssh/ShellFactoryImpl$ShellImpl.class
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
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:711)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
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
                    // Method dump skipped, instructions count: 1061
                    */
                    throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.ssh.ShellFactoryImpl.ShellImpl.run(org.apache.sshd.server.channel.ChannelSession, org.apache.sshd.server.Environment):void");
                }

                public void destroy(ChannelSession session) {
                    if (!this.closed) {
                        this.closed = true;
                        ShellFactoryImpl.flush(this.out, this.err);
                        ShellFactoryImpl.close(this.f3174in, this.out, this.err);
                        this.callback.onExit(0);
                    }
                }
            }

            /* access modifiers changed from: package-private */
            /* renamed from: org.jline.builtins.ssh.ShellFactoryImpl$1 */
            /* loaded from: grasscutter.jar:org/jline/builtins/ssh/ShellFactoryImpl$1.class */
            public static /* synthetic */ class C58301 {
                static final /* synthetic */ int[] $SwitchMap$org$apache$sshd$common$channel$PtyMode = new int[PtyMode.values().length];

                static {
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VINTR.ordinal()] = 1;
                    } catch (NoSuchFieldError e) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VQUIT.ordinal()] = 2;
                    } catch (NoSuchFieldError e2) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VERASE.ordinal()] = 3;
                    } catch (NoSuchFieldError e3) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VKILL.ordinal()] = 4;
                    } catch (NoSuchFieldError e4) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VEOF.ordinal()] = 5;
                    } catch (NoSuchFieldError e5) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VEOL.ordinal()] = 6;
                    } catch (NoSuchFieldError e6) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VEOL2.ordinal()] = 7;
                    } catch (NoSuchFieldError e7) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VSTART.ordinal()] = 8;
                    } catch (NoSuchFieldError e8) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VSTOP.ordinal()] = 9;
                    } catch (NoSuchFieldError e9) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VSUSP.ordinal()] = 10;
                    } catch (NoSuchFieldError e10) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VDSUSP.ordinal()] = 11;
                    } catch (NoSuchFieldError e11) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VREPRINT.ordinal()] = 12;
                    } catch (NoSuchFieldError e12) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VWERASE.ordinal()] = 13;
                    } catch (NoSuchFieldError e13) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VLNEXT.ordinal()] = 14;
                    } catch (NoSuchFieldError e14) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VSTATUS.ordinal()] = 15;
                    } catch (NoSuchFieldError e15) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.VDISCARD.ordinal()] = 16;
                    } catch (NoSuchFieldError e16) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.ECHO.ordinal()] = 17;
                    } catch (NoSuchFieldError e17) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.ICANON.ordinal()] = 18;
                    } catch (NoSuchFieldError e18) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.ISIG.ordinal()] = 19;
                    } catch (NoSuchFieldError e19) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.ICRNL.ordinal()] = 20;
                    } catch (NoSuchFieldError e20) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.INLCR.ordinal()] = 21;
                    } catch (NoSuchFieldError e21) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.IGNCR.ordinal()] = 22;
                    } catch (NoSuchFieldError e22) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.OCRNL.ordinal()] = 23;
                    } catch (NoSuchFieldError e23) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.ONLCR.ordinal()] = 24;
                    } catch (NoSuchFieldError e24) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.ONLRET.ordinal()] = 25;
                    } catch (NoSuchFieldError e25) {
                    }
                    try {
                        $SwitchMap$org$apache$sshd$common$channel$PtyMode[PtyMode.OPOST.ordinal()] = 26;
                    } catch (NoSuchFieldError e26) {
                    }
                }
            }
        }
