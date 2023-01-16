package p013io.javalin.plugin.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.binder.http.DefaultHttpServletRequestTagsProvider;
import io.micrometer.core.instrument.binder.jetty.JettyConnectionMetrics;
import io.micrometer.core.instrument.binder.jetty.JettyServerThreadPoolMetrics;
import io.micrometer.core.instrument.binder.jetty.TimedHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.jetbrains.annotations.NotNull;
import org.jline.builtins.Tmux;
import p013io.javalin.Javalin;
import p013io.javalin.core.event.EventListener;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.core.util.OptionalDependency;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.Context;
import p013io.javalin.http.ExceptionHandler;
import p013io.javalin.http.HandlerType;
import p013io.javalin.jetty.JettyServer;

/* compiled from: MicrometerPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018�� \u00132\u00020\u0001:\u0001\u0013B?\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0014\u0010\u0010\u001a\u00020\u0011*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n��¨\u0006\u0014"}, m373d2 = {"Lio/javalin/plugin/metrics/MicrometerPlugin;", "Lio/javalin/core/plugin/Plugin;", "registry", "Lio/micrometer/core/instrument/MeterRegistry;", "tags", "", "Lio/micrometer/core/instrument/Tag;", "tagExceptionName", "", "tagRedirectPaths", "tagNotFoundMappedPaths", "(Lio/micrometer/core/instrument/MeterRegistry;Ljava/lang/Iterable;ZZZ)V", "apply", "", "app", "Lio/javalin/Javalin;", "prefixIfNot", "", Tmux.OPT_PREFIX, "Companion", "javalin"})
/* renamed from: io.javalin.plugin.metrics.MicrometerPlugin */
/* loaded from: grasscutter.jar:io/javalin/plugin/metrics/MicrometerPlugin.class */
public final class MicrometerPlugin implements Plugin {
    @NotNull
    private final MeterRegistry registry;
    @NotNull
    private final Iterable<Tag> tags;
    private final boolean tagExceptionName;
    private final boolean tagRedirectPaths;
    private final boolean tagNotFoundMappedPaths;
    @NotNull
    private static final String EXCEPTION_HEADER = "__micrometer_exception_name";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static ExceptionHandler<Exception> EXCEPTION_HANDLER = MicrometerPlugin::m5870EXCEPTION_HANDLER$lambda4;

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicrometerPlugin(@NotNull MeterRegistry registry, @NotNull Iterable<? extends Tag> iterable, boolean tagExceptionName, boolean tagRedirectPaths) {
        this(registry, iterable, tagExceptionName, tagRedirectPaths, false, 16, null);
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(iterable, "tags");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicrometerPlugin(@NotNull MeterRegistry registry, @NotNull Iterable<? extends Tag> iterable, boolean tagExceptionName) {
        this(registry, iterable, tagExceptionName, false, false, 24, null);
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(iterable, "tags");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicrometerPlugin(@NotNull MeterRegistry registry, @NotNull Iterable<? extends Tag> iterable) {
        this(registry, iterable, false, false, false, 28, null);
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(iterable, "tags");
    }

    /* JADX INFO: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public MicrometerPlugin(@NotNull MeterRegistry registry) {
        this(registry, null, false, false, false, 30, null);
        Intrinsics.checkNotNullParameter(registry, "registry");
    }

    @JvmOverloads
    public MicrometerPlugin() {
        this(null, null, false, false, false, 31, null);
    }

    @JvmOverloads
    public MicrometerPlugin(@NotNull MeterRegistry registry, @NotNull Iterable<? extends Tag> iterable, boolean tagExceptionName, boolean tagRedirectPaths, boolean tagNotFoundMappedPaths) {
        Intrinsics.checkNotNullParameter(registry, "registry");
        Intrinsics.checkNotNullParameter(iterable, "tags");
        this.registry = registry;
        this.tags = iterable;
        this.tagExceptionName = tagExceptionName;
        this.tagRedirectPaths = tagRedirectPaths;
        this.tagNotFoundMappedPaths = tagNotFoundMappedPaths;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MicrometerPlugin(io.micrometer.core.instrument.MeterRegistry r8, java.lang.Iterable r9, boolean r10, boolean r11, boolean r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r7 = this;
            r0 = r13
            r1 = 1
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0019
            io.micrometer.core.instrument.composite.CompositeMeterRegistry r0 = io.micrometer.core.instrument.Metrics.globalRegistry
            r15 = r0
            r0 = r15
            java.lang.String r1 = "globalRegistry"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r15
            io.micrometer.core.instrument.MeterRegistry r0 = (io.micrometer.core.instrument.MeterRegistry) r0
            r8 = r0
        L_0x0019:
            r0 = r13
            r1 = 2
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0032
            io.micrometer.core.instrument.Tags r0 = io.micrometer.core.instrument.Tags.empty()
            r15 = r0
            r0 = r15
            java.lang.String r1 = "empty()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r15
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r9 = r0
        L_0x0032:
            r0 = r13
            r1 = 4
            r0 = r0 & r1
            if (r0 == 0) goto L_0x003b
            r0 = 0
            r10 = r0
        L_0x003b:
            r0 = r13
            r1 = 8
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0046
            r0 = 0
            r11 = r0
        L_0x0046:
            r0 = r13
            r1 = 16
            r0 = r0 & r1
            if (r0 == 0) goto L_0x0051
            r0 = 0
            r12 = r0
        L_0x0051:
            r0 = r7
            r1 = r8
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.plugin.metrics.MicrometerPlugin.<init>(io.micrometer.core.instrument.MeterRegistry, java.lang.Iterable, boolean, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Server server;
        Intrinsics.checkNotNullParameter(app, "app");
        Util.ensureDependencyPresent$default(Util.INSTANCE, OptionalDependency.MICROMETER, false, 2, null);
        JettyServer jettyServer = app.jettyServer();
        if (jettyServer != null && (server = jettyServer.server()) != null) {
            if (this.tagExceptionName) {
                app.exception(Exception.class, EXCEPTION_HANDLER);
            }
            server.insertHandler((HandlerWrapper) new TimedHandler(this.registry, this.tags, new DefaultHttpServletRequestTagsProvider(this, app) { // from class: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1
                final /* synthetic */ MicrometerPlugin this$0;
                final /* synthetic */ Javalin $app;

                /* access modifiers changed from: package-private */
                {
                    this.this$0 = $receiver;
                    this.$app = $app;
                }

                @NotNull
                public Iterable<Tag> getTags(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
                    String exceptionName;
                    String uri;
                    Intrinsics.checkNotNullParameter(request, "request");
                    Intrinsics.checkNotNullParameter(response, "response");
                    if (MicrometerPlugin.access$getTagExceptionName$p(this.this$0)) {
                        exceptionName = response.getHeader("__micrometer_exception_name");
                    } else {
                        exceptionName = "Unknown";
                    }
                    MicrometerPlugin micrometerPlugin = this.this$0;
                    String pathInfo = request.getPathInfo();
                    Intrinsics.checkNotNullExpressionValue(pathInfo, "request.pathInfo");
                    String str = this.$app._conf.contextPath;
                    Intrinsics.checkNotNullExpressionValue(str, "app._conf.contextPath");
                    String pathInfo2 = MicrometerPlugin.access$prefixIfNot(micrometerPlugin, StringsKt.removePrefix(pathInfo, (CharSequence) str), "/");
                    response.setHeader("__micrometer_exception_name", null);
                    String method = request.getMethod();
                    Intrinsics.checkNotNullExpressionValue(method, "request.method");
                    String str2 = (String) SequencesKt.firstOrNull(SequencesKt.map(SequencesKt.map(SequencesKt.map(SequencesKt.map(CollectionsKt.asSequence(this.$app.javalinServlet().getMatcher().findEntries(HandlerType.valueOf(method), pathInfo2)), MicrometerPlugin$apply$1$1$getTags$uri$1.INSTANCE), MicrometerPlugin$apply$1$1$getTags$uri$2.INSTANCE), 
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00ca: CHECK_CAST (r0v27 'str2' java.lang.String) = (java.lang.String) (wrap: java.lang.Object : 0x00c7: INVOKE  (r0v26 java.lang.Object A[REMOVE]) = 
                          (wrap: kotlin.sequences.Sequence : 0x00c4: INVOKE  (r0v25 kotlin.sequences.Sequence A[REMOVE]) = 
                          (wrap: kotlin.sequences.Sequence : 0x00b2: INVOKE  (r0v24 kotlin.sequences.Sequence A[REMOVE]) = 
                          (wrap: kotlin.sequences.Sequence : 0x00a0: INVOKE  (r0v23 kotlin.sequences.Sequence A[REMOVE]) = 
                          (wrap: kotlin.sequences.Sequence : 0x0097: INVOKE  (r0v22 kotlin.sequences.Sequence A[REMOVE]) = 
                          (wrap: kotlin.sequences.Sequence : 0x008e: INVOKE  (r0v21 kotlin.sequences.Sequence A[REMOVE]) = 
                          (wrap: java.util.List<io.javalin.http.HandlerEntry> : 0x0088: INVOKE  (r0v19 java.util.List<io.javalin.http.HandlerEntry> A[REMOVE]) = 
                          (wrap: io.javalin.http.PathMatcher : 0x0081: INVOKE  (r0v18 io.javalin.http.PathMatcher A[REMOVE]) = 
                          (wrap: io.javalin.http.JavalinServlet : 0x007e: INVOKE  (r0v17 io.javalin.http.JavalinServlet A[REMOVE]) = 
                          (wrap: io.javalin.Javalin : 0x007b: IGET  (r0v16 io.javalin.Javalin A[REMOVE]) = 
                          (r6v0 'this' io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1 A[D('this' io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1), IMMUTABLE_TYPE, THIS])
                         io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1.$app io.javalin.Javalin)
                         type: VIRTUAL call: io.javalin.Javalin.javalinServlet():io.javalin.http.JavalinServlet)
                         type: VIRTUAL call: io.javalin.http.JavalinServlet.getMatcher():io.javalin.http.PathMatcher)
                          (wrap: io.javalin.http.HandlerType : 0x0075: INVOKE  (r0v14 'handlerType' io.javalin.http.HandlerType A[REMOVE]) = (r0v11 'method' java.lang.String) type: STATIC call: io.javalin.http.HandlerType.valueOf(java.lang.String):io.javalin.http.HandlerType)
                          (r0v8 'pathInfo2' java.lang.String A[D('pathInfo' java.lang.String)])
                         type: VIRTUAL call: io.javalin.http.PathMatcher.findEntries(io.javalin.http.HandlerType, java.lang.String):java.util.List)
                         type: STATIC call: kotlin.collections.CollectionsKt.asSequence(java.lang.Iterable):kotlin.sequences.Sequence)
                          (wrap: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$1 : 0x0091: SGET  (r1v10 io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$1 A[REMOVE]) =  io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$1.INSTANCE io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$1)
                         type: STATIC call: kotlin.sequences.SequencesKt.map(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence)
                          (wrap: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$2 : 0x009a: SGET  (r1v12 io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$2 A[REMOVE]) =  io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$2.INSTANCE io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$2)
                         type: STATIC call: kotlin.sequences.SequencesKt.map(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence)
                          (wrap: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$3 : 0x00ac: CONSTRUCTOR  (r1v14 io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$3 A[REMOVE]) = 
                          (wrap: io.javalin.plugin.metrics.MicrometerPlugin : 0x00a8: IGET  (r3v2 io.javalin.plugin.metrics.MicrometerPlugin A[REMOVE]) = 
                          (r6v0 'this' io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1 A[D('this' io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1), IMMUTABLE_TYPE, THIS])
                         io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1.this$0 io.javalin.plugin.metrics.MicrometerPlugin)
                          (r8v0 'response' javax.servlet.http.HttpServletResponse A[D('response' javax.servlet.http.HttpServletResponse)])
                         call: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$3.<init>(io.javalin.plugin.metrics.MicrometerPlugin, javax.servlet.http.HttpServletResponse):void type: CONSTRUCTOR)
                         type: STATIC call: kotlin.sequences.SequencesKt.map(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence)
                          (wrap: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$4 : 0x00be: CONSTRUCTOR  (r1v16 io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$4 A[REMOVE]) = 
                          (wrap: io.javalin.plugin.metrics.MicrometerPlugin : 0x00ba: IGET  (r3v4 io.javalin.plugin.metrics.MicrometerPlugin A[REMOVE]) = 
                          (r6v0 'this' io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1 A[D('this' io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1), IMMUTABLE_TYPE, THIS])
                         io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1.this$0 io.javalin.plugin.metrics.MicrometerPlugin)
                          (r8v0 'response' javax.servlet.http.HttpServletResponse A[D('response' javax.servlet.http.HttpServletResponse)])
                         call: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$4.<init>(io.javalin.plugin.metrics.MicrometerPlugin, javax.servlet.http.HttpServletResponse):void type: CONSTRUCTOR)
                         type: STATIC call: kotlin.sequences.SequencesKt.map(kotlin.sequences.Sequence, kotlin.jvm.functions.Function1):kotlin.sequences.Sequence)
                         type: STATIC call: kotlin.sequences.SequencesKt.firstOrNull(kotlin.sequences.Sequence):java.lang.Object) in method: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1.getTags(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse):java.lang.Iterable<io.micrometer.core.instrument.Tag>, file: grasscutter.jar:io/javalin/plugin/metrics/MicrometerPlugin$apply$1$1.class
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
                        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1$getTags$uri$3, state: NOT_LOADED
                        	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                        	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
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
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:320)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                        	... 15 more
                        */
                    /*
                    // Method dump skipped, instructions count: 290
                    */
                    throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.plugin.metrics.MicrometerPlugin$apply$1$1.getTags(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse):java.lang.Iterable");
                }
            }));
            new JettyServerThreadPoolMetrics(server.getThreadPool(), this.tags).bindTo(this.registry);
            app.events((v2) -> {
                m5869apply$lambda2$lambda1(r1, r2, v2);
            });
        }
    }

    /* renamed from: apply$lambda-2$lambda-1  reason: not valid java name */
    private static final void m5869apply$lambda2$lambda1(Server $server, MicrometerPlugin this$0, EventListener it) {
        Intrinsics.checkNotNullParameter($server, "$server");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        it.serverStarted(() -> {
            m5868apply$lambda2$lambda1$lambda0(r1, r2);
        });
    }

    /* renamed from: apply$lambda-2$lambda-1$lambda-0  reason: not valid java name */
    private static final void m5868apply$lambda2$lambda1$lambda0(Server $server, MicrometerPlugin this$0) {
        Intrinsics.checkNotNullParameter($server, "$server");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        JettyConnectionMetrics.addToAllConnectors($server, this$0.registry, this$0.tags);
    }

    /* compiled from: MicrometerPlugin.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n��¨\u0006\f"}, m373d2 = {"Lio/javalin/plugin/metrics/MicrometerPlugin$Companion;", "", "()V", "EXCEPTION_HANDLER", "Lio/javalin/http/ExceptionHandler;", "Ljava/lang/Exception;", "getEXCEPTION_HANDLER", "()Lio/javalin/http/ExceptionHandler;", "setEXCEPTION_HANDLER", "(Lio/javalin/http/ExceptionHandler;)V", "EXCEPTION_HEADER", "", "javalin"})
    /* renamed from: io.javalin.plugin.metrics.MicrometerPlugin$Companion */
    /* loaded from: grasscutter.jar:io/javalin/plugin/metrics/MicrometerPlugin$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final ExceptionHandler<Exception> getEXCEPTION_HANDLER() {
            return MicrometerPlugin.EXCEPTION_HANDLER;
        }

        public final void setEXCEPTION_HANDLER(@NotNull ExceptionHandler<Exception> exceptionHandler) {
            Intrinsics.checkNotNullParameter(exceptionHandler, "<set-?>");
            MicrometerPlugin.EXCEPTION_HANDLER = exceptionHandler;
        }
    }

    /* renamed from: EXCEPTION_HANDLER$lambda-4  reason: not valid java name */
    private static final void m5870EXCEPTION_HANDLER$lambda4(Exception e, Context ctx) {
        String str;
        Intrinsics.checkNotNullParameter(e, "e");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String simpleName = e.getClass().getSimpleName();
        Context context = ctx;
        String str2 = EXCEPTION_HEADER;
        String str3 = simpleName;
        if (StringsKt.isBlank(str3)) {
            str = e.getClass().getName();
            context = context;
            str2 = str2;
        } else {
            str = str3;
        }
        Intrinsics.checkNotNullExpressionValue(str, "simpleName.ifBlank { e.javaClass.name }");
        context.header(str2, str);
        ctx.status(500);
    }

    /* access modifiers changed from: private */
    public final String prefixIfNot(String $this$prefixIfNot, String prefix) {
        return StringsKt.startsWith$default($this$prefixIfNot, prefix, false, 2, (Object) null) ? $this$prefixIfNot : Intrinsics.stringPlus(prefix, $this$prefixIfNot);
    }
}
