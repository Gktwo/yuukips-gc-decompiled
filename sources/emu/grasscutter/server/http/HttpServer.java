package emu.grasscutter.server.http;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.utils.Language;
import java.io.UnsupportedEncodingException;
import p013io.javalin.Javalin;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/HttpServer.class */
public final class HttpServer {
    private final Javalin javalin = Javalin.create(config -> {
        config.server(HttpServer::createServer);
        config.enforceSsl = Configuration.HTTP_ENCRYPTION.useEncryption;
        if (Configuration.HTTP_POLICIES.cors.enabled) {
            String[] allowedOrigins = Configuration.HTTP_POLICIES.cors.allowedOrigins;
            if (allowedOrigins.length > 0) {
                config.enableCorsForOrigin(allowedOrigins);
            } else {
                config.enableCorsForAllOrigins();
            }
        }
        if (Configuration.DISPATCH_INFO.logRequests == Grasscutter.ServerDebugMode.ALL) {
            config.enableDevLogging();
        }
    });

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x00a7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private static org.eclipse.jetty.server.Server createServer() {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.HttpServer.createServer():org.eclipse.jetty.server.Server");
    }

    public Javalin getHandle() {
        return this.javalin;
    }

    public HttpServer addRouter(Class<? extends Router> router, Object... args) {
        Class<?>[] types = new Class[args.length];
        for (Object argument : args) {
            types[args.length - 1] = argument.getClass();
        }
        try {
            ((Router) router.getDeclaredConstructor(types).newInstance(args)).applyRoutes(this.javalin);
        } catch (Exception exception) {
            Grasscutter.getLogger().warn(Language.translate("messages.dispatch.router_error", new Object[0]), (Throwable) exception);
        }
        return this;
    }

    public void start() throws UnsupportedEncodingException {
        if (Configuration.HTTP_INFO.bindAddress.equals("")) {
            this.javalin.start(Configuration.HTTP_INFO.bindPort);
        } else {
            this.javalin.start(Configuration.HTTP_INFO.bindAddress, Configuration.HTTP_INFO.bindPort);
        }
        Grasscutter.getLogger().info(Language.translate("messages.dispatch.address_bind", Configuration.HTTP_INFO.accessAddress, Integer.valueOf(this.javalin.port())));
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/server/http/HttpServer$DefaultRequestRouter.class */
    public static class DefaultRequestRouter implements Router {
        @Override // emu.grasscutter.server.http.Router
        public void applyRoutes(Javalin javalin) {
            javalin.get("/", 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0008: INVOKE  
                  (r5v0 'javalin' io.javalin.Javalin A[D('javalin' io.javalin.Javalin)])
                  ("/")
                  (wrap: io.javalin.http.Handler : 0x0003: INVOKE_CUSTOM (r2v0 io.javalin.http.Handler A[REMOVE]) = 
                 handle type: INVOKE_STATIC
                 lambda: io.javalin.http.Handler.handle(io.javalin.http.Context):void
                 call insn: ?: INVOKE  (v0 io.javalin.http.Context) type: STATIC call: emu.grasscutter.server.http.HttpServer.DefaultRequestRouter.lambda$applyRoutes$0(io.javalin.http.Context):void)
                 type: VIRTUAL call: io.javalin.Javalin.get(java.lang.String, io.javalin.http.Handler):io.javalin.Javalin in method: emu.grasscutter.server.http.HttpServer.DefaultRequestRouter.applyRoutes(io.javalin.Javalin):void, file: grasscutter.jar:emu/grasscutter/server/http/HttpServer$DefaultRequestRouter.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
                	... 15 more
                */
            /*
                this = this;
                r0 = r5
                java.lang.String r1 = "/"
                void r2 = (v0) -> { // io.javalin.http.Handler.handle(io.javalin.http.Context):void
                    lambda$applyRoutes$0(v0);
                }
                io.javalin.Javalin r0 = r0.get(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.HttpServer.DefaultRequestRouter.applyRoutes(io.javalin.Javalin):void");
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/server/http/HttpServer$UnhandledRequestRouter.class */
    public static class UnhandledRequestRouter implements Router {
        @Override // emu.grasscutter.server.http.Router
        public void applyRoutes(Javalin javalin) {
            javalin.error(404, 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: INVOKE  
                  (r5v0 'javalin' io.javalin.Javalin A[D('javalin' io.javalin.Javalin)])
                  (404 int)
                  (wrap: io.javalin.http.Handler : 0x0004: INVOKE_CUSTOM (r2v0 io.javalin.http.Handler A[REMOVE]) = 
                 handle type: INVOKE_STATIC
                 lambda: io.javalin.http.Handler.handle(io.javalin.http.Context):void
                 call insn: ?: INVOKE  (v0 io.javalin.http.Context) type: STATIC call: emu.grasscutter.server.http.HttpServer.UnhandledRequestRouter.lambda$applyRoutes$0(io.javalin.http.Context):void)
                 type: VIRTUAL call: io.javalin.Javalin.error(int, io.javalin.http.Handler):io.javalin.Javalin in method: emu.grasscutter.server.http.HttpServer.UnhandledRequestRouter.applyRoutes(io.javalin.Javalin):void, file: grasscutter.jar:emu/grasscutter/server/http/HttpServer$UnhandledRequestRouter.class
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
                Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
                	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
                	... 15 more
                */
            /*
                this = this;
                r0 = r5
                r1 = 404(0x194, float:5.66E-43)
                void r2 = (v0) -> { // io.javalin.http.Handler.handle(io.javalin.http.Context):void
                    lambda$applyRoutes$0(v0);
                }
                io.javalin.Javalin r0 = r0.error(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.http.HttpServer.UnhandledRequestRouter.applyRoutes(io.javalin.Javalin):void");
        }
    }
}
