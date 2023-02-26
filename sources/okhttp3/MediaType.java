package okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.internal.progressionUtil;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: MediaType.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��2\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\u0018�� \u00182\u00020\u0001:\u0001\u0018B-\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0014\u001a\u00020\u0003J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0015J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\nR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\n¨\u0006\u0019"}, m373d2 = {"Lokhttp3/MediaType;", "", "mediaType", "", "type", "subtype", "parameterNamesAndValues", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "[Ljava/lang/String;", "()Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "defaultValue", "equals", "", "other", "hashCode", "", "parameter", "name", "-deprecated_subtype", Printer.TO_STRING, "-deprecated_type", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/MediaType.class */
public final class MediaType {
    @NotNull
    private final String mediaType;
    @NotNull
    private final String type;
    @NotNull
    private final String subtype;
    @NotNull
    private final String[] parameterNamesAndValues;
    @NotNull
    private static final String TOKEN;
    @NotNull
    private static final String QUOTED;
    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final Pattern TYPE_SUBTYPE = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern PARAMETER = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    @JvmOverloads
    @Nullable
    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    public static final MediaType get(@NotNull String $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    @JvmName(name = "parse")
    @Nullable
    public static final MediaType parse(@NotNull String $this$parse) {
        return Companion.parse($this$parse);
    }

    public /* synthetic */ MediaType(String mediaType, String type, String subtype, String[] parameterNamesAndValues, DefaultConstructorMarker $constructor_marker) {
        this(mediaType, type, subtype, parameterNamesAndValues);
    }

    private MediaType(String mediaType, String type, String subtype, String[] parameterNamesAndValues) {
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.parameterNamesAndValues = parameterNamesAndValues;
    }

    @JvmName(name = "type")
    @NotNull
    public final String type() {
        return this.type;
    }

    @JvmName(name = "subtype")
    @NotNull
    public final String subtype() {
        return this.subtype;
    }

    public static /* synthetic */ Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    @JvmOverloads
    @Nullable
    public final Charset charset(@Nullable Charset defaultValue) {
        Charset charset;
        String charset2 = parameter("charset");
        if (charset2 == null) {
            return defaultValue;
        }
        try {
            charset = Charset.forName(charset2);
        } catch (IllegalArgumentException e) {
            charset = defaultValue;
        }
        return charset;
    }

    @Nullable
    public final String parameter(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        int progressionLastElement = progressionUtil.getProgressionLastElement(0, this.parameterNamesAndValues.length - 1, 2);
        if (0 > progressionLastElement) {
            return null;
        }
        do {
            i += 2;
            if (StringsKt.equals(this.parameterNamesAndValues[i], name, true)) {
                return this.parameterNamesAndValues[i + 1];
            }
        } while (i != progressionLastElement);
        return null;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_type")
    @NotNull
    /* renamed from: -deprecated_type */
    public final String m9231deprecated_type() {
        return this.type;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_subtype")
    @NotNull
    /* renamed from: -deprecated_subtype */
    public final String m9232deprecated_subtype() {
        return this.subtype;
    }

    @NotNull
    public String toString() {
        return this.mediaType;
    }

    public boolean equals(@Nullable Object other) {
        return (other instanceof MediaType) && Intrinsics.areEqual(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    /* compiled from: MediaType.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\rJ\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u000fJ\u0011\u0010\u0010\u001a\u00020\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\nJ\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000b*\u00020\u0007H\u0007¢\u0006\u0002\b\u000eR\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0007XT¢\u0006\u0002\n��R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n��¨\u0006\u0012"}, m373d2 = {"Lokhttp3/MediaType$Companion;", "", "()V", "PARAMETER", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "QUOTED", "", "TOKEN", "TYPE_SUBTYPE", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/MediaType;", "mediaType", "-deprecated_get", "parse", "-deprecated_parse", "toMediaType", "toMediaTypeOrNull", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/MediaType$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        public final MediaType get(@NotNull String $this$toMediaType) {
            String value;
            Intrinsics.checkNotNullParameter($this$toMediaType, "<this>");
            Matcher typeSubtype = MediaType.TYPE_SUBTYPE.matcher($this$toMediaType);
            if (!typeSubtype.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + $this$toMediaType + '\"').toString());
            }
            String group = typeSubtype.group(1);
            Intrinsics.checkNotNullExpressionValue(group, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String type = group.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(type, "this as java.lang.String).toLowerCase(locale)");
            String group2 = typeSubtype.group(2);
            Intrinsics.checkNotNullExpressionValue(group2, "typeSubtype.group(2)");
            Locale locale2 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale2, "US");
            String subtype = group2.toLowerCase(locale2);
            Intrinsics.checkNotNullExpressionValue(subtype, "this as java.lang.String).toLowerCase(locale)");
            Collection parameterNamesAndValues = (List) new ArrayList();
            Matcher parameter = MediaType.PARAMETER.matcher($this$toMediaType);
            int s = typeSubtype.end();
            while (s < $this$toMediaType.length()) {
                parameter.region(s, $this$toMediaType.length());
                if (!parameter.lookingAt()) {
                    StringBuilder append = new StringBuilder().append("Parameter is not formatted correctly: \"");
                    String substring = $this$toMediaType.substring(s);
                    Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                    throw new IllegalArgumentException(append.append(substring).append("\" for: \"").append($this$toMediaType).append('\"').toString().toString());
                }
                String name = parameter.group(1);
                if (name == null) {
                    s = parameter.end();
                } else {
                    String token = parameter.group(2);
                    if (token == null) {
                        value = parameter.group(3);
                    } else if (!StringsKt.startsWith$default(token, "'", false, 2, (Object) null) || !StringsKt.endsWith$default(token, "'", false, 2, (Object) null) || token.length() <= 2) {
                        value = token;
                    } else {
                        value = token.substring(1, token.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(value, "this as java.lang.String…ing(startIndex, endIndex)");
                    }
                    parameterNamesAndValues.add(name);
                    parameterNamesAndValues.add(value);
                    s = parameter.end();
                }
            }
            Object[] array = parameterNamesAndValues.toArray(new String[0]);
            if (array != null) {
                return new MediaType($this$toMediaType, type, subtype, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }

        @JvmStatic
        @JvmName(name = "parse")
        @Nullable
        public final MediaType parse(@NotNull String $this$toMediaTypeOrNull) {
            MediaType mediaType;
            Intrinsics.checkNotNullParameter($this$toMediaTypeOrNull, "<this>");
            try {
                mediaType = get($this$toMediaTypeOrNull);
            } catch (IllegalArgumentException e) {
                mediaType = null;
            }
            return mediaType;
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"okhttp3.MediaType.Companion.toMediaType"}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_get")
        @NotNull
        /* renamed from: -deprecated_get */
        public final MediaType m9234deprecated_get(@NotNull String mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            return get(mediaType);
        }

        @Deprecated(message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"okhttp3.MediaType.Companion.toMediaTypeOrNull"}), level = DeprecationLevel.ERROR)
        @JvmName(name = "-deprecated_parse")
        @Nullable
        /* renamed from: -deprecated_parse */
        public final MediaType m9235deprecated_parse(@NotNull String mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            return parse(mediaType);
        }
    }
}
