package p013io.javalin.http;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.TextStreamsKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;
import p013io.javalin.core.util.Util;
import p013io.javalin.http.staticfiles.Location;
import p013io.javalin.http.util.ContextUtil;

/* compiled from: SinglePageHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��<\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018��2\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0006J\u001e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n��R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0015"}, m373d2 = {"Lio/javalin/http/SinglePageHandler;", "", "()V", "pathHandlerMap", "", "", "Lio/javalin/http/Handler;", "pathPageMap", "Lio/javalin/http/SinglePageHandler$Page;", BeanUtil.PREFIX_ADDER, "", "hostedPath", "handler", "filePath", "location", "Lio/javalin/http/staticfiles/Location;", "handle", "", "ctx", "Lio/javalin/http/Context;", "Page", "javalin"})
/* renamed from: io.javalin.http.SinglePageHandler */
/* loaded from: grasscutter.jar:io/javalin/http/SinglePageHandler.class */
public final class SinglePageHandler {
    @NotNull
    private final Map<String, Page> pathPageMap = new LinkedHashMap();
    @NotNull
    private final Map<String, Handler> pathHandlerMap = new LinkedHashMap();

    /* compiled from: SinglePageHandler.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48)
    /* renamed from: io.javalin.http.SinglePageHandler$WhenMappings */
    /* loaded from: grasscutter.jar:io/javalin/http/SinglePageHandler$WhenMappings.class */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Location.values().length];
            iArr[Location.CLASSPATH.ordinal()] = 1;
            iArr[Location.EXTERNAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: SinglePageHandler.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��(\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018��2\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020��2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000fJ\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m373d2 = {"Lio/javalin/http/SinglePageHandler$Page;", "", "url", "Ljava/net/URL;", "cachedHtml", "", "(Ljava/net/URL;Ljava/lang/String;)V", "getCachedHtml", "()Ljava/lang/String;", "getUrl", "()Ljava/net/URL;", "component1", "component2", "copy", "equals", "", "other", "getHtml", "reRead", "hashCode", "", Printer.TO_STRING, "javalin"})
    /* renamed from: io.javalin.http.SinglePageHandler$Page */
    /* loaded from: grasscutter.jar:io/javalin/http/SinglePageHandler$Page.class */
    public static final class Page {
        @NotNull
        private final URL url;
        @NotNull
        private final String cachedHtml;

        @NotNull
        public final URL component1() {
            return this.url;
        }

        @NotNull
        public final String component2() {
            return this.cachedHtml;
        }

        @NotNull
        public final Page copy(@NotNull URL url, @NotNull String cachedHtml) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(cachedHtml, "cachedHtml");
            return new Page(url, cachedHtml);
        }

        public static /* synthetic */ Page copy$default(Page page, URL url, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                url = page.url;
            }
            if ((i & 2) != 0) {
                str = page.cachedHtml;
            }
            return page.copy(url, str);
        }

        @NotNull
        public String toString() {
            return "Page(url=" + this.url + ", cachedHtml=" + this.cachedHtml + ')';
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + this.cachedHtml.hashCode();
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Page)) {
                return false;
            }
            Page page = (Page) other;
            return Intrinsics.areEqual(this.url, page.url) && Intrinsics.areEqual(this.cachedHtml, page.cachedHtml);
        }

        public Page(@NotNull URL url, @NotNull String cachedHtml) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(cachedHtml, "cachedHtml");
            this.url = url;
            this.cachedHtml = cachedHtml;
        }

        @NotNull
        public final URL getUrl() {
            return this.url;
        }

        @NotNull
        public final String getCachedHtml() {
            return this.cachedHtml;
        }

        @NotNull
        public final String getHtml(boolean reRead) {
            if (!reRead) {
                return this.cachedHtml;
            }
            URL url = this.url;
            return new String(TextStreamsKt.readBytes(url), Charsets.UTF_8);
        }
    }

    public final void add(@NotNull String hostedPath, @NotNull String filePath, @NotNull Location location) {
        URL url;
        Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(location, "location");
        switch (WhenMappings.$EnumSwitchMapping$0[location.ordinal()]) {
            case 1:
                URL resourceUrl = Util.getResourceUrl(StringsKt.removePrefix(filePath, (CharSequence) "/"));
                if (resourceUrl != null) {
                    url = resourceUrl;
                    break;
                } else {
                    throw new IllegalArgumentException("File at '" + filePath + "' not found. Path should be relative to resource folder.");
                }
            case 2:
                URL fileUrl = Util.INSTANCE.getFileUrl(filePath);
                if (fileUrl != null) {
                    url = fileUrl;
                    break;
                } else {
                    throw new IllegalArgumentException("External file at '" + filePath + "' not found.");
                }
            default:
                throw new NoWhenBranchMatchedException();
        }
        this.pathPageMap.put(hostedPath, new Page(url, new String(TextStreamsKt.readBytes(url), Charsets.UTF_8)));
    }

    public final void add(@NotNull String hostedPath, @NotNull Handler handler) {
        Intrinsics.checkNotNullParameter(hostedPath, "hostedPath");
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.pathHandlerMap.put(hostedPath, handler);
    }

    public final boolean handle(@NotNull Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String header = ctx.header("Accept");
        String accept = header == null ? "" : header;
        if (!StringsKt.contains$default((CharSequence) accept, (CharSequence) ContentType.HTML, false, 2, (Object) null) && !StringsKt.contains$default((CharSequence) accept, (CharSequence) "*/*", false, 2, (Object) null) && !Intrinsics.areEqual(accept, "")) {
            return false;
        }
        Page page = (Page) SinglePageHandlerKt.access$findByPath(this.pathPageMap, ctx.path());
        if (page == null) {
            Handler handler = (Handler) SinglePageHandlerKt.access$findByPath(this.pathHandlerMap, ctx.path());
            if (handler == null) {
                return false;
            }
            handler.handle(ctx);
            return true;
        }
        ctx.html(page.getHtml(ContextUtil.INSTANCE.isLocalhost(ctx)));
        return true;
    }
}
