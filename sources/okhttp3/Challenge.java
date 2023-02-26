package okhttp3;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: Challenge.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018��2\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u0007H\u0007¢\u0006\u0002\b\u000eJ\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u000e\u0010\u0018\u001a\u00020��2\u0006\u0010\n\u001a\u00020\u000bR!\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00030\u00078G¢\u0006\b\n��\u001a\u0004\b\u0006\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8G¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\r¨\u0006\u0019"}, m373d2 = {"Lokhttp3/Challenge;", "", "scheme", "", "realm", "(Ljava/lang/String;Ljava/lang/String;)V", "authParams", "", "(Ljava/lang/String;Ljava/util/Map;)V", "()Ljava/util/Map;", "charset", "Ljava/nio/charset/Charset;", "()Ljava/nio/charset/Charset;", "()Ljava/lang/String;", "-deprecated_authParams", "-deprecated_charset", "equals", "", "other", "hashCode", "", "-deprecated_realm", "-deprecated_scheme", Printer.TO_STRING, "withCharset", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/Challenge.class */
public final class Challenge {
    @NotNull
    private final String scheme;
    @NotNull
    private final Map<String, String> authParams;

    public Challenge(@NotNull String scheme, @NotNull Map<String, String> map) {
        String newKey;
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Intrinsics.checkNotNullParameter(map, "authParams");
        this.scheme = scheme;
        Map newAuthParams = new LinkedHashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (key == null) {
                newKey = null;
            } else {
                Locale locale = Locale.US;
                Intrinsics.checkNotNullExpressionValue(locale, "US");
                newKey = key.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(newKey, "this as java.lang.String).toLowerCase(locale)");
            }
            newAuthParams.put(newKey, value);
        }
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(newAuthParams);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.authParams = unmodifiableMap;
    }

    @JvmName(name = "scheme")
    @NotNull
    public final String scheme() {
        return this.scheme;
    }

    @JvmName(name = "authParams")
    @NotNull
    public final Map<String, String> authParams() {
        return this.authParams;
    }

    @JvmName(name = "realm")
    @Nullable
    public final String realm() {
        return this.authParams.get("realm");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x0013
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    @kotlin.jvm.JvmName(name = "charset")
    @org.jetbrains.annotations.NotNull
    public final java.nio.charset.Charset charset() {
        /*
            r3 = this;
            r0 = r3
            java.util.Map<java.lang.String, java.lang.String> r0 = r0.authParams
            java.lang.String r1 = "charset"
            java.lang.Object r0 = r0.get(r1)
            java.lang.String r0 = (java.lang.String) r0
            r4 = r0
            r0 = r4
            if (r0 == 0) goto L_0x0022
            r0 = r4
            java.nio.charset.Charset r0 = java.nio.charset.Charset.forName(r0)     // Catch: Exception -> 0x0021
            r5 = r0
            r0 = r5
            java.lang.String r1 = "forName(charset)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)     // Catch: Exception -> 0x0021
            r0 = r5
            return r0
        L_0x0021:
            r5 = move-exception
        L_0x0022:
            java.nio.charset.Charset r0 = java.nio.charset.StandardCharsets.ISO_8859_1
            r5 = r0
            r0 = r5
            java.lang.String r1 = "ISO_8859_1"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.charset():java.nio.charset.Charset");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Challenge(@org.jetbrains.annotations.NotNull java.lang.String r6, @org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r5 = this;
            r0 = r6
            java.lang.String r1 = "scheme"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r7
            java.lang.String r1 = "realm"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r5
            r1 = r6
            java.lang.String r2 = "realm"
            r3 = r7
            java.util.Map r2 = java.util.Collections.singletonMap(r2, r3)
            r8 = r2
            r2 = r8
            java.lang.String r3 = "singletonMap(\"realm\", realm)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r2 = r8
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.Challenge.<init>(java.lang.String, java.lang.String):void");
    }

    @NotNull
    public final Challenge withCharset(@NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        Map authParams = MapsKt.toMutableMap(this.authParams);
        String name = charset.name();
        Intrinsics.checkNotNullExpressionValue(name, "charset.name()");
        authParams.put("charset", name);
        return new Challenge(this.scheme, authParams);
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_scheme")
    @NotNull
    /* renamed from: -deprecated_scheme  reason: not valid java name */
    public final String m9163deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "authParams", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_authParams")
    @NotNull
    /* renamed from: -deprecated_authParams  reason: not valid java name */
    public final Map<String, String> m9164deprecated_authParams() {
        return this.authParams;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "realm", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_realm")
    @Nullable
    /* renamed from: -deprecated_realm  reason: not valid java name */
    public final String m9165deprecated_realm() {
        return realm();
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "charset", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_charset")
    @NotNull
    /* renamed from: -deprecated_charset  reason: not valid java name */
    public final Charset m9166deprecated_charset() {
        return charset();
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof Challenge) && Intrinsics.areEqual(((Challenge) other).scheme, this.scheme) && Intrinsics.areEqual(((Challenge) other).authParams, this.authParams);
    }

    public int hashCode() {
        return (31 * ((31 * 29) + this.scheme.hashCode())) + this.authParams.hashCode();
    }

    @NotNull
    public String toString() {
        return this.scheme + " authParams=" + this.authParams;
    }
}
