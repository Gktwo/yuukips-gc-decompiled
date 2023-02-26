package p013io.javalin.http.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import p013io.javalin.Javalin;
import p013io.javalin.core.PathParser;
import p013io.javalin.core.event.EventListener;
import p013io.javalin.core.event.HandlerMetaInfo;
import p013io.javalin.core.plugin.Plugin;
import p013io.javalin.core.plugin.PluginLifecycleInit;
import p013io.javalin.core.routing.PathSegment;
import p013io.javalin.http.Context;
import p013io.javalin.http.HandlerEntry;
import p013io.javalin.http.HandlerType;
import p013io.javalin.http.PathMatcher;

/* compiled from: RedirectToLowercasePathPlugin.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, m373d2 = {"Lio/javalin/http/util/RedirectToLowercasePathPlugin;", "Lio/javalin/core/plugin/Plugin;", "Lio/javalin/core/plugin/PluginLifecycleInit;", "()V", "apply", "", "app", "Lio/javalin/Javalin;", "init", "javalin"})
/* renamed from: io.javalin.http.util.RedirectToLowercasePathPlugin */
/* loaded from: grasscutter.jar:io/javalin/http/util/RedirectToLowercasePathPlugin.class */
public final class RedirectToLowercasePathPlugin implements Plugin, PluginLifecycleInit {
    @Override // p013io.javalin.core.plugin.PluginLifecycleInit
    public void init(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.events((v1) -> {
            m5851init$lambda6(r1, v1);
        });
    }

    /* renamed from: init$lambda-6  reason: not valid java name */
    private static final void m5851init$lambda6(Javalin $app, EventListener e) {
        Intrinsics.checkNotNullParameter($app, "$app");
        e.handlerAdded((v1) -> {
            m5850init$lambda6$lambda5(r1, v1);
        });
    }

    /* renamed from: init$lambda-6$lambda-5  reason: not valid java name */
    private static final void m5850init$lambda6$lambda5(Javalin $app, HandlerMetaInfo h) {
        Intrinsics.checkNotNullParameter($app, "$app");
        PathParser parser = new PathParser(h.getPath(), $app._conf.ignoreTrailingSlashes);
        Iterable $this$filterIsInstance$iv = parser.getSegments();
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filterIsInstance$iv) {
            if (element$iv$iv instanceof PathSegment.Normal) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<PathSegment.Normal> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (PathSegment.Normal it : $this$map$iv) {
            destination$iv$iv2.add(it.getContent());
        }
        for (String it2 : (List) destination$iv$iv2) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
            if (it2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = it2.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (!Intrinsics.areEqual(it2, lowerCase)) {
                throw new IllegalArgumentException("Paths must be lowercase when using RedirectToLowercasePathPlugin");
            }
        }
        Iterable $this$filterIsInstance$iv2 = parser.getSegments();
        Collection destination$iv$iv3 = new ArrayList();
        for (Object element$iv$iv2 : $this$filterIsInstance$iv2) {
            if (element$iv$iv2 instanceof PathSegment.MultipleSegments) {
                destination$iv$iv3.add(element$iv$iv2);
            }
        }
        Iterable<PathSegment.MultipleSegments> $this$flatMap$iv = (List) destination$iv$iv3;
        Collection destination$iv$iv4 = new ArrayList();
        for (PathSegment.MultipleSegments it3 : $this$flatMap$iv) {
            CollectionsKt.addAll(destination$iv$iv4, it3.getInnerSegments());
        }
        Iterable $this$filterIsInstance$iv3 = (List) destination$iv$iv4;
        Collection destination$iv$iv5 = new ArrayList();
        for (Object element$iv$iv3 : $this$filterIsInstance$iv3) {
            if (element$iv$iv3 instanceof PathSegment.Normal) {
                destination$iv$iv5.add(element$iv$iv3);
            }
        }
        Iterable<PathSegment.Normal> $this$map$iv2 = (List) destination$iv$iv5;
        Collection destination$iv$iv6 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (PathSegment.Normal it4 : $this$map$iv2) {
            destination$iv$iv6.add(it4.getContent());
        }
        for (String it5 : (List) destination$iv$iv6) {
            Locale locale2 = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale2, Logger.ROOT_LOGGER_NAME);
            if (it5 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = it5.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            if (!Intrinsics.areEqual(it5, lowerCase2)) {
                throw new IllegalArgumentException("Paths must be lowercase when using RedirectToLowercasePathPlugin");
            }
        }
    }

    @Override // p013io.javalin.core.plugin.Plugin
    public void apply(@NotNull Javalin app) {
        Intrinsics.checkNotNullParameter(app, "app");
        app.before((v1) -> {
            m5852apply$lambda12(r1, v1);
        });
    }

    /* renamed from: apply$lambda-12  reason: not valid java name */
    private static final void m5852apply$lambda12(Javalin $app, Context ctx) {
        Intrinsics.checkNotNullParameter($app, "$app");
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        HandlerType type = HandlerType.Companion.fromServletRequest(ctx.req);
        String requestURI = ctx.req.getRequestURI();
        Intrinsics.checkNotNullExpressionValue(requestURI, "ctx.req.requestURI");
        String contextPath = ctx.req.getContextPath();
        Intrinsics.checkNotNullExpressionValue(contextPath, "ctx.req.contextPath");
        String requestUri = StringsKt.removePrefix(requestURI, (CharSequence) contextPath);
        PathMatcher matcher = $app.javalinServlet().getMatcher();
        if (((HandlerEntry) CollectionsKt.firstOrNull((List<? extends Object>) matcher.findEntries(type, requestUri))) == null) {
            Locale locale = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
            if (requestUri == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = requestUri.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            HandlerEntry entry = (HandlerEntry) CollectionsKt.firstOrNull((List<? extends Object>) matcher.findEntries(type, lowerCase));
            if (entry != null) {
                Iterable $this$filter$iv = StringsKt.split$default((CharSequence) requestUri, new String[]{"/"}, false, 0, 6, (Object) null);
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    if (((String) element$iv$iv).length() > 0) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Object[] array = ((List) destination$iv$iv).toArray(new String[0]);
                if (array == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
                }
                String[] clientSegments = (String[]) array;
                Iterable<PathSegment> serverSegments = new PathParser(entry.getPath(), $app._conf.ignoreTrailingSlashes).getSegments();
                int index$iv = 0;
                for (Object item$iv : serverSegments) {
                    index$iv++;
                    if (index$iv < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    PathSegment serverSegment = (PathSegment) item$iv;
                    if (serverSegment instanceof PathSegment.Normal) {
                        String str = clientSegments[index$iv];
                        Locale locale2 = Locale.ROOT;
                        Intrinsics.checkNotNullExpressionValue(locale2, Logger.ROOT_LOGGER_NAME);
                        if (str == null) {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                        String lowerCase2 = str.toLowerCase(locale2);
                        Intrinsics.checkNotNullExpressionValue(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
                        clientSegments[index$iv] = lowerCase2;
                    }
                    if (serverSegment instanceof PathSegment.MultipleSegments) {
                        for (PathSegment innerServerSegment : serverSegments) {
                            if (innerServerSegment instanceof PathSegment.Normal) {
                                String str2 = clientSegments[index$iv];
                                String content = ((PathSegment.Normal) innerServerSegment).getContent();
                                String content2 = ((PathSegment.Normal) innerServerSegment).getContent();
                                Locale locale3 = Locale.ROOT;
                                Intrinsics.checkNotNullExpressionValue(locale3, Logger.ROOT_LOGGER_NAME);
                                if (content2 == null) {
                                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                                }
                                String lowerCase3 = content2.toLowerCase(locale3);
                                Intrinsics.checkNotNullExpressionValue(lowerCase3, "(this as java.lang.String).toLowerCase(locale)");
                                clientSegments[index$iv] = StringsKt.replace(str2, content, lowerCase3, true);
                            }
                        }
                        continue;
                    }
                }
                ctx.redirect('/' + ArraysKt.joinToString$default(clientSegments, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null) + (ctx.queryString() != null ? Intrinsics.stringPlus("?", ctx.queryString()) : ""), 301);
            }
        }
    }
}
