package okhttp3;

import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: CacheControl.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0011\u0018�� !2\u00020\u0001:\u0002 !Bq\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0002\u0010\u0012J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0016J\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0017J\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0018J\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0019J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001eJ\b\u0010\u001f\u001a\u00020\u0011H\u0016R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n��R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u000f\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\b\u0010\u0013R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\u0014R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n��\u001a\u0004\b\f\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\n\u0010\u0013R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0013R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\u0013R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\u0013R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\r\u0010\u0013R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\u0014¨\u0006\""}, m373d2 = {"Lokhttp3/CacheControl;", "", "noCache", "", "noStore", "maxAgeSeconds", "", "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", "", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "-deprecated_immutable", "-deprecated_maxAgeSeconds", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_mustRevalidate", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_noTransform", "-deprecated_onlyIfCached", "-deprecated_sMaxAgeSeconds", Printer.TO_STRING, "Builder", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/CacheControl.class */
public final class CacheControl {
    private final boolean noCache;
    private final boolean noStore;
    private final int maxAgeSeconds;
    private final int sMaxAgeSeconds;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final boolean mustRevalidate;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean onlyIfCached;
    private final boolean noTransform;
    private final boolean immutable;
    @Nullable
    private String headerValue;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final CacheControl FORCE_NETWORK = new Builder().noCache().build();
    @JvmField
    @NotNull
    public static final CacheControl FORCE_CACHE = new Builder().onlyIfCached().maxStale(Integer.MAX_VALUE, TimeUnit.SECONDS).build();

    @JvmStatic
    @NotNull
    public static final CacheControl parse(@NotNull Headers headers) {
        return Companion.parse(headers);
    }

    public /* synthetic */ CacheControl(boolean noCache, boolean noStore, int maxAgeSeconds, int sMaxAgeSeconds, boolean isPrivate, boolean isPublic, boolean mustRevalidate, int maxStaleSeconds, int minFreshSeconds, boolean onlyIfCached, boolean noTransform, boolean immutable, String headerValue, DefaultConstructorMarker $constructor_marker) {
        this(noCache, noStore, maxAgeSeconds, sMaxAgeSeconds, isPrivate, isPublic, mustRevalidate, maxStaleSeconds, minFreshSeconds, onlyIfCached, noTransform, immutable, headerValue);
    }

    private CacheControl(boolean noCache, boolean noStore, int maxAgeSeconds, int sMaxAgeSeconds, boolean isPrivate, boolean isPublic, boolean mustRevalidate, int maxStaleSeconds, int minFreshSeconds, boolean onlyIfCached, boolean noTransform, boolean immutable, String headerValue) {
        this.noCache = noCache;
        this.noStore = noStore;
        this.maxAgeSeconds = maxAgeSeconds;
        this.sMaxAgeSeconds = sMaxAgeSeconds;
        this.isPrivate = isPrivate;
        this.isPublic = isPublic;
        this.mustRevalidate = mustRevalidate;
        this.maxStaleSeconds = maxStaleSeconds;
        this.minFreshSeconds = minFreshSeconds;
        this.onlyIfCached = onlyIfCached;
        this.noTransform = noTransform;
        this.immutable = immutable;
        this.headerValue = headerValue;
    }

    @JvmName(name = "noCache")
    public final boolean noCache() {
        return this.noCache;
    }

    @JvmName(name = "noStore")
    public final boolean noStore() {
        return this.noStore;
    }

    @JvmName(name = "maxAgeSeconds")
    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @JvmName(name = "sMaxAgeSeconds")
    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    @JvmName(name = "mustRevalidate")
    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    @JvmName(name = "maxStaleSeconds")
    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @JvmName(name = "minFreshSeconds")
    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @JvmName(name = "onlyIfCached")
    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    @JvmName(name = "noTransform")
    public final boolean noTransform() {
        return this.noTransform;
    }

    @JvmName(name = "immutable")
    public final boolean immutable() {
        return this.immutable;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_noCache")
    /* renamed from: -deprecated_noCache  reason: not valid java name */
    public final boolean m9154deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_noStore")
    /* renamed from: -deprecated_noStore  reason: not valid java name */
    public final boolean m9155deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_maxAgeSeconds")
    /* renamed from: -deprecated_maxAgeSeconds  reason: not valid java name */
    public final int m9156deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_sMaxAgeSeconds")
    /* renamed from: -deprecated_sMaxAgeSeconds  reason: not valid java name */
    public final int m9157deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_mustRevalidate")
    /* renamed from: -deprecated_mustRevalidate  reason: not valid java name */
    public final boolean m9158deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_maxStaleSeconds")
    /* renamed from: -deprecated_maxStaleSeconds  reason: not valid java name */
    public final int m9159deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_minFreshSeconds")
    /* renamed from: -deprecated_minFreshSeconds  reason: not valid java name */
    public final int m9160deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_onlyIfCached")
    /* renamed from: -deprecated_onlyIfCached  reason: not valid java name */
    public final boolean m9161deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_noTransform")
    /* renamed from: -deprecated_noTransform  reason: not valid java name */
    public final boolean m9162deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_immutable")
    /* renamed from: -deprecated_immutable  reason: not valid java name */
    public final boolean m9163deprecated_immutable() {
        return this.immutable;
    }

    @NotNull
    public String toString() {
        String result = this.headerValue;
        if (result == null) {
            StringBuilder $this$toString_u24lambda_u2d0 = new StringBuilder();
            if (noCache()) {
                $this$toString_u24lambda_u2d0.append("no-cache, ");
            }
            if (noStore()) {
                $this$toString_u24lambda_u2d0.append("no-store, ");
            }
            if (maxAgeSeconds() != -1) {
                $this$toString_u24lambda_u2d0.append("max-age=").append(maxAgeSeconds()).append(", ");
            }
            if (sMaxAgeSeconds() != -1) {
                $this$toString_u24lambda_u2d0.append("s-maxage=").append(sMaxAgeSeconds()).append(", ");
            }
            if (isPrivate()) {
                $this$toString_u24lambda_u2d0.append("private, ");
            }
            if (isPublic()) {
                $this$toString_u24lambda_u2d0.append("public, ");
            }
            if (mustRevalidate()) {
                $this$toString_u24lambda_u2d0.append("must-revalidate, ");
            }
            if (maxStaleSeconds() != -1) {
                $this$toString_u24lambda_u2d0.append("max-stale=").append(maxStaleSeconds()).append(", ");
            }
            if (minFreshSeconds() != -1) {
                $this$toString_u24lambda_u2d0.append("min-fresh=").append(minFreshSeconds()).append(", ");
            }
            if (onlyIfCached()) {
                $this$toString_u24lambda_u2d0.append("only-if-cached, ");
            }
            if (noTransform()) {
                $this$toString_u24lambda_u2d0.append("no-transform, ");
            }
            if (immutable()) {
                $this$toString_u24lambda_u2d0.append("immutable, ");
            }
            if ($this$toString_u24lambda_u2d0.length() == 0) {
                return "";
            }
            $this$toString_u24lambda_u2d0.delete($this$toString_u24lambda_u2d0.length() - 2, $this$toString_u24lambda_u2d0.length());
            String sb = $this$toString_u24lambda_u2d0.toString();
            Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
            result = sb;
            this.headerValue = result;
        }
        return result;
    }

    /* compiled from: CacheControl.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n��\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u0003\u001a\u00020��J\u0016\u0010\u000f\u001a\u00020��2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0012\u001a\u00020��2\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0013\u001a\u00020��2\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\t\u001a\u00020��J\u0006\u0010\n\u001a\u00020��J\u0006\u0010\u000b\u001a\u00020��J\u0006\u0010\f\u001a\u00020��J\f\u0010\u0014\u001a\u00020\u0006*\u00020\u0015H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��¨\u0006\u0016"}, m373d2 = {"Lokhttp3/CacheControl$Builder;", "", "()V", "immutable", "", "maxAgeSeconds", "", "maxStaleSeconds", "minFreshSeconds", "noCache", "noStore", "noTransform", "onlyIfCached", JsonPOJOBuilder.DEFAULT_BUILD_METHOD, "Lokhttp3/CacheControl;", "maxAge", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "maxStale", "minFresh", "clampToInt", "", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/CacheControl$Builder.class */
    public static final class Builder {
        private boolean noCache;
        private boolean noStore;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean onlyIfCached;
        private boolean noTransform;
        private boolean immutable;

        @NotNull
        public final Builder noCache() {
            this.noCache = true;
            return this;
        }

        @NotNull
        public final Builder noStore() {
            this.noStore = true;
            return this;
        }

        @NotNull
        public final Builder maxAge(int maxAge, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            Builder $this$maxAge_u24lambda_u2d3 = this;
            if (!(maxAge >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("maxAge < 0: ", Integer.valueOf(maxAge)).toString());
            }
            $this$maxAge_u24lambda_u2d3.maxAgeSeconds = $this$maxAge_u24lambda_u2d3.clampToInt(timeUnit.toSeconds((long) maxAge));
            return this;
        }

        @NotNull
        public final Builder maxStale(int maxStale, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            Builder $this$maxStale_u24lambda_u2d5 = this;
            if (!(maxStale >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("maxStale < 0: ", Integer.valueOf(maxStale)).toString());
            }
            $this$maxStale_u24lambda_u2d5.maxStaleSeconds = $this$maxStale_u24lambda_u2d5.clampToInt(timeUnit.toSeconds((long) maxStale));
            return this;
        }

        @NotNull
        public final Builder minFresh(int minFresh, @NotNull TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            Builder $this$minFresh_u24lambda_u2d7 = this;
            if (!(minFresh >= 0)) {
                throw new IllegalArgumentException(Intrinsics.stringPlus("minFresh < 0: ", Integer.valueOf(minFresh)).toString());
            }
            $this$minFresh_u24lambda_u2d7.minFreshSeconds = $this$minFresh_u24lambda_u2d7.clampToInt(timeUnit.toSeconds((long) minFresh));
            return this;
        }

        @NotNull
        public final Builder onlyIfCached() {
            this.onlyIfCached = true;
            return this;
        }

        @NotNull
        public final Builder noTransform() {
            this.noTransform = true;
            return this;
        }

        @NotNull
        public final Builder immutable() {
            this.immutable = true;
            return this;
        }

        private final int clampToInt(long $this$clampToInt) {
            if ($this$clampToInt > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            return (int) $this$clampToInt;
        }

        @NotNull
        public final CacheControl build() {
            return new CacheControl(this.noCache, this.noStore, this.maxAgeSeconds, -1, false, false, false, this.maxStaleSeconds, this.minFreshSeconds, this.onlyIfCached, this.noTransform, this.immutable, null, null);
        }
    }

    /* compiled from: CacheControl.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u001e\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\nH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u000e"}, m373d2 = {"Lokhttp3/CacheControl$Companion;", "", "()V", "FORCE_CACHE", "Lokhttp3/CacheControl;", "FORCE_NETWORK", "parse", "headers", "Lokhttp3/Headers;", "indexOfElement", "", "", "characters", "startIndex", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/CacheControl$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @NotNull
        public final CacheControl parse(@NotNull Headers headers) {
            String parameter;
            Intrinsics.checkNotNullParameter(headers, "headers");
            boolean noCache = false;
            boolean noStore = false;
            int maxAgeSeconds = -1;
            int sMaxAgeSeconds = -1;
            boolean isPrivate = false;
            boolean isPublic = false;
            boolean mustRevalidate = false;
            int maxStaleSeconds = -1;
            int minFreshSeconds = -1;
            boolean onlyIfCached = false;
            boolean noTransform = false;
            boolean immutable = false;
            boolean canUseHeaderValue = true;
            String headerValue = null;
            int i = 0;
            int size = headers.size();
            while (i < size) {
                i++;
                String name = headers.name(i);
                String value = headers.value(i);
                if (StringsKt.equals(name, "Cache-Control", true)) {
                    if (headerValue != null) {
                        canUseHeaderValue = false;
                    } else {
                        headerValue = value;
                    }
                } else if (StringsKt.equals(name, "Pragma", true)) {
                    canUseHeaderValue = false;
                }
                int pos = 0;
                while (pos < value.length()) {
                    int pos2 = indexOfElement(value, "=,;", pos);
                    String substring = value.substring(pos, pos2);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String directive = StringsKt.trim((CharSequence) substring).toString();
                    if (pos2 == value.length() || value.charAt(pos2) == ',' || value.charAt(pos2) == ';') {
                        pos = pos2 + 1;
                        parameter = null;
                    } else {
                        int pos3 = Util.indexOfNonWhitespace(value, pos2 + 1);
                        if (pos3 >= value.length() || value.charAt(pos3) != '\"') {
                            pos = indexOfElement(value, ",;", pos3);
                            String substring2 = value.substring(pos3, pos);
                            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
                            parameter = StringsKt.trim((CharSequence) substring2).toString();
                        } else {
                            int pos4 = pos3 + 1;
                            int pos5 = StringsKt.indexOf$default((CharSequence) value, '\"', pos4, false, 4, (Object) null);
                            String substring3 = value.substring(pos4, pos5);
                            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String…ing(startIndex, endIndex)");
                            parameter = substring3;
                            pos = pos5 + 1;
                        }
                    }
                    if (StringsKt.equals("no-cache", directive, true)) {
                        noCache = true;
                    } else if (StringsKt.equals("no-store", directive, true)) {
                        noStore = true;
                    } else if (StringsKt.equals("max-age", directive, true)) {
                        maxAgeSeconds = Util.toNonNegativeInt(parameter, -1);
                    } else if (StringsKt.equals("s-maxage", directive, true)) {
                        sMaxAgeSeconds = Util.toNonNegativeInt(parameter, -1);
                    } else if (StringsKt.equals("private", directive, true)) {
                        isPrivate = true;
                    } else if (StringsKt.equals("public", directive, true)) {
                        isPublic = true;
                    } else if (StringsKt.equals("must-revalidate", directive, true)) {
                        mustRevalidate = true;
                    } else if (StringsKt.equals("max-stale", directive, true)) {
                        maxStaleSeconds = Util.toNonNegativeInt(parameter, Integer.MAX_VALUE);
                    } else if (StringsKt.equals("min-fresh", directive, true)) {
                        minFreshSeconds = Util.toNonNegativeInt(parameter, -1);
                    } else if (StringsKt.equals("only-if-cached", directive, true)) {
                        onlyIfCached = true;
                    } else if (StringsKt.equals("no-transform", directive, true)) {
                        noTransform = true;
                    } else if (StringsKt.equals("immutable", directive, true)) {
                        immutable = true;
                    }
                }
            }
            if (!canUseHeaderValue) {
                headerValue = null;
            }
            return new CacheControl(noCache, noStore, maxAgeSeconds, sMaxAgeSeconds, isPrivate, isPublic, mustRevalidate, maxStaleSeconds, minFreshSeconds, onlyIfCached, noTransform, immutable, headerValue, null);
        }

        static /* synthetic */ int indexOfElement$default(Companion companion, String str, String str2, int i, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                i = 0;
            }
            return companion.indexOfElement(str, str2, i);
        }

        private final int indexOfElement(String $this$indexOfElement, String characters, int startIndex) {
            int i = startIndex;
            int length = $this$indexOfElement.length();
            while (i < length) {
                i++;
                if (StringsKt.contains$default((CharSequence) characters, $this$indexOfElement.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
            }
            return $this$indexOfElement.length();
        }
    }
}
