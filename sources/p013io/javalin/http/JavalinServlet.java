package p013io.javalin.http;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.core.JavalinConfig;
import p013io.javalin.core.security.RouteRole;
import p013io.javalin.core.util.CorsPlugin;
import p013io.javalin.core.util.LogUtil;
import p013io.javalin.http.staticfiles.ResourceHandler;
import p013io.javalin.http.util.MethodNotAllowedUtil;

/* compiled from: JavalinServlet.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J,\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0014J\f\u0010(\u001a\u00020)*\u00020\u0003H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\b\n��\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n��\u001a\u0004\b\u0016\u0010\u0017¨\u0006*"}, m373d2 = {"Lio/javalin/http/JavalinServlet;", "Ljavax/servlet/http/HttpServlet;", "config", "Lio/javalin/core/JavalinConfig;", "(Lio/javalin/core/JavalinConfig;)V", "getConfig", "()Lio/javalin/core/JavalinConfig;", "errorMapper", "Lio/javalin/http/ErrorMapper;", "getErrorMapper", "()Lio/javalin/http/ErrorMapper;", "exceptionMapper", "Lio/javalin/http/ExceptionMapper;", "getExceptionMapper", "()Lio/javalin/http/ExceptionMapper;", "lifecycle", "", "Lio/javalin/http/Stage;", "getLifecycle", "()Ljava/util/List;", "matcher", "Lio/javalin/http/PathMatcher;", "getMatcher", "()Lio/javalin/http/PathMatcher;", "addHandler", "", "handlerType", "Lio/javalin/http/HandlerType;", "path", "", "handler", "Lio/javalin/http/Handler;", "roles", "", "Lio/javalin/core/security/RouteRole;", "service", "request", "Ljavax/servlet/http/HttpServletRequest;", "response", "Ljavax/servlet/http/HttpServletResponse;", "isCorsEnabled", "", "javalin"})
/* renamed from: io.javalin.http.JavalinServlet */
/* loaded from: grasscutter.jar:io/javalin/http/JavalinServlet.class */
public final class JavalinServlet extends HttpServlet {
    @NotNull
    private final JavalinConfig config;
    @NotNull
    private final PathMatcher matcher = new PathMatcher();
    @NotNull
    private final ExceptionMapper exceptionMapper = new ExceptionMapper();
    @NotNull
    private final ErrorMapper errorMapper = new ErrorMapper();
    @NotNull
    private final List<Stage> lifecycle = CollectionsKt.mutableListOf(new Stage(DefaultName.BEFORE, false, new Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit>, Unit>(this) { // from class: io.javalin.http.JavalinServlet$lifecycle$1
        final /* synthetic */ JavalinServlet this$0;

        /* access modifiers changed from: package-private */
        {
            this.this$0 = $receiver;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(JavalinServletHandler javalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit> function1) {
            invoke(javalinServletHandler, (Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>) function1);
            return Unit.INSTANCE;
        }

        public final void invoke(@NotNull JavalinServletHandler $this$$receiver, @NotNull Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit> function1) {
            Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
            Intrinsics.checkNotNullParameter(function1, "submitTask");
            for (HandlerEntry entry : this.this$0.getMatcher().findEntries(HandlerType.BEFORE, $this$$receiver.getRequestUri())) {
                function1.invoke(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  
                      (r8v0 'function1' kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit> A[D('submitTask' kotlin.jvm.functions.Function1)])
                      (wrap: io.javalin.http.JavalinServlet$lifecycle$1$1$1 : 0x0051: CONSTRUCTOR  (r1v3 io.javalin.http.JavalinServlet$lifecycle$1$1$1 A[REMOVE]) = 
                      (r0v15 'entry' io.javalin.http.HandlerEntry A[REMOVE])
                      (r7v0 '$this$$receiver' io.javalin.http.JavalinServletHandler A[D('$this$$receiver' io.javalin.http.JavalinServletHandler)])
                     call: io.javalin.http.JavalinServlet$lifecycle$1$1$1.<init>(io.javalin.http.HandlerEntry, io.javalin.http.JavalinServletHandler):void type: CONSTRUCTOR)
                     type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object in method: io.javalin.http.JavalinServlet$lifecycle$1.invoke(io.javalin.http.JavalinServletHandler, kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit>):void, file: grasscutter.jar:io/javalin/http/JavalinServlet$lifecycle$1.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                    	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                    	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.javalin.http.JavalinServlet$lifecycle$1$1$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
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
                    this = this;
                    r0 = r7
                    java.lang.String r1 = "$this$$receiver"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                    r0 = r8
                    java.lang.String r1 = "submitTask"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                    r0 = r6
                    io.javalin.http.JavalinServlet r0 = r0.this$0
                    io.javalin.http.PathMatcher r0 = r0.getMatcher()
                    io.javalin.http.HandlerType r1 = p013io.javalin.http.HandlerType.BEFORE
                    r2 = r7
                    java.lang.String r2 = r2.getRequestUri()
                    java.util.List r0 = r0.findEntries(r1, r2)
                    java.lang.Iterable r0 = (java.lang.Iterable) r0
                    r9 = r0
                    r0 = 0
                    r10 = r0
                    r0 = r9
                    java.util.Iterator r0 = r0.iterator()
                    r11 = r0
                L_0x002c:
                    r0 = r11
                    boolean r0 = r0.hasNext()
                    if (r0 == 0) goto L_0x005e
                    r0 = r11
                    java.lang.Object r0 = r0.next()
                    r12 = r0
                    r0 = r12
                    io.javalin.http.HandlerEntry r0 = (p013io.javalin.http.HandlerEntry) r0
                    r13 = r0
                    r0 = 0
                    r14 = r0
                    r0 = r8
                    io.javalin.http.JavalinServlet$lifecycle$1$1$1 r1 = new io.javalin.http.JavalinServlet$lifecycle$1$1$1
                    r2 = r1
                    r3 = r13
                    r4 = r7
                    r2.<init>(r3, r4)
                    java.lang.Object r0 = r0.invoke(r1)
                    goto L_0x002c
                L_0x005e:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.JavalinServlet$lifecycle$1.invoke(io.javalin.http.JavalinServletHandler, kotlin.jvm.functions.Function1):void");
            }
        }, 2, null), new Stage(DefaultName.HTTP, false, new Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit>, Unit>(this) { // from class: io.javalin.http.JavalinServlet$lifecycle$2
            final /* synthetic */ JavalinServlet this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JavalinServletHandler javalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit> function1) {
                invoke(javalinServletHandler, (Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>) function1);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final JavalinServletHandler $this$$receiver, @NotNull Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit> function1) {
                Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
                Intrinsics.checkNotNullParameter(function1, "submitTask");
                HandlerEntry entry = (HandlerEntry) CollectionsKt.firstOrNull((List<? extends Object>) this.this$0.getMatcher().findEntries($this$$receiver.getRequestType(), $this$$receiver.getRequestUri()));
                if (entry == null) {
                    final JavalinServlet javalinServlet = this.this$0;
                    function1.invoke(new Function1<JavalinServletHandler, Unit>() { // from class: io.javalin.http.JavalinServlet$lifecycle$2.2
                        /* Return type fixed from 'java.lang.Object' to match base method */
                        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(JavalinServletHandler javalinServletHandler) {
                            invoke(javalinServletHandler);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(@NotNull JavalinServletHandler it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            if ($this$$receiver.getRequestType() != HandlerType.HEAD || !javalinServlet.getMatcher().hasEntries$javalin(HandlerType.GET, $this$$receiver.getRequestUri())) {
                                if ($this$$receiver.getRequestType() == HandlerType.HEAD || $this$$receiver.getRequestType() == HandlerType.GET) {
                                    ResourceHandler resourceHandler = javalinServlet.getConfig().inner.resourceHandler;
                                    if ((resourceHandler == null ? false : resourceHandler.handle(it.getCtx().req, new JavalinResponseWrapper(it.getCtx(), javalinServlet.getConfig(), $this$$receiver.getRequestType()))) || javalinServlet.getConfig().inner.singlePageHandler.handle($this$$receiver.getCtx())) {
                                        return;
                                    }
                                }
                                if ($this$$receiver.getRequestType() != HandlerType.OPTIONS || !(javalinServlet.isCorsEnabled(javalinServlet.getConfig()))) {
                                    if ($this$$receiver.getCtx().getHandlerType$javalin() == HandlerType.BEFORE) {
                                        $this$$receiver.getCtx().setEndpointHandlerPath$javalin("No handler matched request path/method (404/405)");
                                    }
                                    List availableHandlerTypes = MethodNotAllowedUtil.INSTANCE.findAvailableHttpHandlerTypes(javalinServlet.getMatcher(), $this$$receiver.getRequestUri());
                                    if (javalinServlet.getConfig().prefer405over404) {
                                        if (!availableHandlerTypes.isEmpty()) {
                                            throw new MethodNotAllowedResponse(null, MethodNotAllowedUtil.INSTANCE.getAvailableHandlerTypes($this$$receiver.getCtx(), availableHandlerTypes), 1, null);
                                        }
                                    }
                                    throw new NotFoundResponse(null, null, 3, null);
                                }
                            }
                        }
                    });
                    return;
                }
                function1.invoke(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0047: INVOKE  
                      (r8v0 'function1' kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit> A[D('submitTask' kotlin.jvm.functions.Function1)])
                      (wrap: io.javalin.http.JavalinServlet$lifecycle$2$1$1 : 0x0044: CONSTRUCTOR  (r1v5 io.javalin.http.JavalinServlet$lifecycle$2$1$1 A[REMOVE]) = 
                      (r0v7 'entry' io.javalin.http.HandlerEntry A[D('entry' io.javalin.http.HandlerEntry)])
                      (r7v0 '$this$$receiver' io.javalin.http.JavalinServletHandler A[D('$this$$receiver' io.javalin.http.JavalinServletHandler)])
                     call: io.javalin.http.JavalinServlet$lifecycle$2$1$1.<init>(io.javalin.http.HandlerEntry, io.javalin.http.JavalinServletHandler):void type: CONSTRUCTOR)
                     type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object in method: io.javalin.http.JavalinServlet$lifecycle$2.invoke(io.javalin.http.JavalinServletHandler, kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit>):void, file: grasscutter.jar:io/javalin/http/JavalinServlet$lifecycle$2.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
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
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.javalin.http.JavalinServlet$lifecycle$2$1$1, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 19 more
                    */
                /*
                    this = this;
                    r0 = r7
                    java.lang.String r1 = "$this$$receiver"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                    r0 = r8
                    java.lang.String r1 = "submitTask"
                    kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                    r0 = r6
                    io.javalin.http.JavalinServlet r0 = r0.this$0
                    io.javalin.http.PathMatcher r0 = r0.getMatcher()
                    r1 = r7
                    io.javalin.http.HandlerType r1 = r1.getRequestType()
                    r2 = r7
                    java.lang.String r2 = r2.getRequestUri()
                    java.util.List r0 = r0.findEntries(r1, r2)
                    java.lang.Object r0 = kotlin.collections.CollectionsKt.firstOrNull(r0)
                    io.javalin.http.HandlerEntry r0 = (p013io.javalin.http.HandlerEntry) r0
                    r9 = r0
                    r0 = r9
                    if (r0 != 0) goto L_0x002c
                    goto L_0x004e
                L_0x002c:
                    r0 = r9
                    r10 = r0
                    r0 = 0
                    r11 = r0
                    r0 = 0
                    r12 = r0
                    r0 = r10
                    r13 = r0
                    r0 = 0
                    r14 = r0
                    r0 = r8
                    io.javalin.http.JavalinServlet$lifecycle$2$1$1 r1 = new io.javalin.http.JavalinServlet$lifecycle$2$1$1
                    r2 = r1
                    r3 = r13
                    r4 = r7
                    r2.<init>(r3, r4)
                    java.lang.Object r0 = r0.invoke(r1)
                    return
                L_0x004e:
                    r0 = r8
                    io.javalin.http.JavalinServlet$lifecycle$2$2 r1 = new io.javalin.http.JavalinServlet$lifecycle$2$2
                    r2 = r1
                    r3 = r7
                    r4 = r6
                    io.javalin.http.JavalinServlet r4 = r4.this$0
                    r2.<init>(r3, r4)
                    java.lang.Object r0 = r0.invoke(r1)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.JavalinServlet$lifecycle$2.invoke(io.javalin.http.JavalinServletHandler, kotlin.jvm.functions.Function1):void");
            }
        }, 2, null), new Stage(DefaultName.ERROR, false, new Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit>, Unit>(this) { // from class: io.javalin.http.JavalinServlet$lifecycle$3
            final /* synthetic */ JavalinServlet this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JavalinServletHandler javalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit> function1) {
                invoke(javalinServletHandler, (Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>) function1);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull final JavalinServletHandler $this$$receiver, @NotNull Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit> function1) {
                Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
                Intrinsics.checkNotNullParameter(function1, "submitTask");
                final JavalinServlet javalinServlet = this.this$0;
                function1.invoke(new Function1<JavalinServletHandler, Unit>() { // from class: io.javalin.http.JavalinServlet$lifecycle$3.1
                    public final void invoke(@NotNull JavalinServletHandler it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        javalinServlet.getErrorMapper().handle($this$$receiver.getCtx().status(), $this$$receiver.getCtx());
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(JavalinServletHandler javalinServletHandler) {
                        invoke(javalinServletHandler);
                        return Unit.INSTANCE;
                    }
                });
            }
        }), new Stage(DefaultName.AFTER, false, new Function2<JavalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit>, Unit>(this) { // from class: io.javalin.http.JavalinServlet$lifecycle$4
            final /* synthetic */ JavalinServlet this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(JavalinServletHandler javalinServletHandler, Function1<? super Function1<? super JavalinServletHandler, ? extends Unit>, ? extends Unit> function1) {
                invoke(javalinServletHandler, (Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit>) function1);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull JavalinServletHandler $this$$receiver, @NotNull Function1<? super Function1<? super JavalinServletHandler, Unit>, Unit> function1) {
                Intrinsics.checkNotNullParameter($this$$receiver, "$this$$receiver");
                Intrinsics.checkNotNullParameter(function1, "submitTask");
                for (HandlerEntry entry : this.this$0.getMatcher().findEntries(HandlerType.AFTER, $this$$receiver.getRequestUri())) {
                    function1.invoke(
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0054: INVOKE  
                          (r8v0 'function1' kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit> A[D('submitTask' kotlin.jvm.functions.Function1)])
                          (wrap: io.javalin.http.JavalinServlet$lifecycle$4$1$1 : 0x0051: CONSTRUCTOR  (r1v3 io.javalin.http.JavalinServlet$lifecycle$4$1$1 A[REMOVE]) = 
                          (r0v15 'entry' io.javalin.http.HandlerEntry A[REMOVE])
                          (r7v0 '$this$$receiver' io.javalin.http.JavalinServletHandler A[D('$this$$receiver' io.javalin.http.JavalinServletHandler)])
                         call: io.javalin.http.JavalinServlet$lifecycle$4$1$1.<init>(io.javalin.http.HandlerEntry, io.javalin.http.JavalinServletHandler):void type: CONSTRUCTOR)
                         type: INTERFACE call: kotlin.jvm.functions.Function1.invoke(java.lang.Object):java.lang.Object in method: io.javalin.http.JavalinServlet$lifecycle$4.invoke(io.javalin.http.JavalinServletHandler, kotlin.jvm.functions.Function1<? super kotlin.jvm.functions.Function1<? super io.javalin.http.JavalinServletHandler, kotlin.Unit>, kotlin.Unit>):void, file: grasscutter.jar:io/javalin/http/JavalinServlet$lifecycle$4.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:221)
                        	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.javalin.http.JavalinServlet$lifecycle$4$1$1, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
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
                        this = this;
                        r0 = r7
                        java.lang.String r1 = "$this$$receiver"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                        r0 = r8
                        java.lang.String r1 = "submitTask"
                        kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
                        r0 = r6
                        io.javalin.http.JavalinServlet r0 = r0.this$0
                        io.javalin.http.PathMatcher r0 = r0.getMatcher()
                        io.javalin.http.HandlerType r1 = p013io.javalin.http.HandlerType.AFTER
                        r2 = r7
                        java.lang.String r2 = r2.getRequestUri()
                        java.util.List r0 = r0.findEntries(r1, r2)
                        java.lang.Iterable r0 = (java.lang.Iterable) r0
                        r9 = r0
                        r0 = 0
                        r10 = r0
                        r0 = r9
                        java.util.Iterator r0 = r0.iterator()
                        r11 = r0
                    L_0x002c:
                        r0 = r11
                        boolean r0 = r0.hasNext()
                        if (r0 == 0) goto L_0x005e
                        r0 = r11
                        java.lang.Object r0 = r0.next()
                        r12 = r0
                        r0 = r12
                        io.javalin.http.HandlerEntry r0 = (p013io.javalin.http.HandlerEntry) r0
                        r13 = r0
                        r0 = 0
                        r14 = r0
                        r0 = r8
                        io.javalin.http.JavalinServlet$lifecycle$4$1$1 r1 = new io.javalin.http.JavalinServlet$lifecycle$4$1$1
                        r2 = r1
                        r3 = r13
                        r4 = r7
                        r2.<init>(r3, r4)
                        java.lang.Object r0 = r0.invoke(r1)
                        goto L_0x002c
                    L_0x005e:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.http.JavalinServlet$lifecycle$4.invoke(io.javalin.http.JavalinServletHandler, kotlin.jvm.functions.Function1):void");
                }
            }));

            public JavalinServlet(@NotNull JavalinConfig config) {
                Intrinsics.checkNotNullParameter(config, "config");
                this.config = config;
            }

            @NotNull
            public final JavalinConfig getConfig() {
                return this.config;
            }

            @NotNull
            public final PathMatcher getMatcher() {
                return this.matcher;
            }

            @NotNull
            public final ExceptionMapper getExceptionMapper() {
                return this.exceptionMapper;
            }

            @NotNull
            public final ErrorMapper getErrorMapper() {
                return this.errorMapper;
            }

            @NotNull
            public final List<Stage> getLifecycle() {
                return this.lifecycle;
            }

            /* access modifiers changed from: protected */
            @Override // javax.servlet.http.HttpServlet
            public void service(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
                Intrinsics.checkNotNullParameter(request, "request");
                Intrinsics.checkNotNullParameter(response, "response");
                try {
                    Map<String, Object> map = this.config.inner.appAttributes;
                    Intrinsics.checkNotNullExpressionValue(map, "config.inner.appAttributes");
                    Context ctx = new Context(request, response, map);
                    LogUtil.INSTANCE.setup(ctx, this.matcher, this.config.inner.requestLogger != null);
                    String str = this.config.defaultContentType;
                    Intrinsics.checkNotNullExpressionValue(str, "config.defaultContentType");
                    ctx.contentType(str);
                    new JavalinServletHandler(new ArrayDeque(this.lifecycle), this.config, this.errorMapper, this.exceptionMapper, ctx, null, null, 96, null).queueNextTaskOrFinish$javalin();
                } catch (Throwable throwable) {
                    this.exceptionMapper.handleUnexpectedThrowable$javalin(response, throwable);
                }
            }

            public final void addHandler(@NotNull HandlerType handlerType, @NotNull String path, @NotNull Handler handler, @NotNull Set<? extends RouteRole> set) {
                Intrinsics.checkNotNullParameter(handlerType, "handlerType");
                Intrinsics.checkNotNullParameter(path, "path");
                Intrinsics.checkNotNullParameter(handler, "handler");
                Intrinsics.checkNotNullParameter(set, "roles");
                this.matcher.add(new HandlerEntry(handlerType, path, this.config.ignoreTrailingSlashes, handlerType.isHttpMethod() ? (v3) -> {
                    m5824addHandler$lambda0(r0, r1, r2, v3);
                } : handler, handler));
            }

            /* renamed from: addHandler$lambda-0  reason: not valid java name */
            private static final void m5824addHandler$lambda0(JavalinServlet this$0, Handler $handler, Set $roles, Context ctx) {
                Intrinsics.checkNotNullParameter(this$0, "this$0");
                Intrinsics.checkNotNullParameter($handler, "$handler");
                Intrinsics.checkNotNullParameter($roles, "$roles");
                Intrinsics.checkNotNullParameter(ctx, "ctx");
                this$0.getConfig().inner.accessManager.manage($handler, ctx, $roles);
            }

            /* access modifiers changed from: private */
            public final boolean isCorsEnabled(JavalinConfig $this$isCorsEnabled) {
                return $this$isCorsEnabled.inner.plugins.get(CorsPlugin.class) != null;
            }
        }
