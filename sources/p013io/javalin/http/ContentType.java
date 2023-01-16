package p013io.javalin.http;

import com.fasterxml.jackson.core.JsonFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: ContentType.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u0011\n\u0002\b*\b\u0001\u0018�� 02\b\u0012\u0004\u0012\u00020��0\u0001:\u00010B+\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007\"\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u001b\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0007¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0004\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/¨\u00061"}, m373d2 = {"Lio/javalin/http/ContentType;", "", "mimeType", "", "isHumanReadable", "", "extensions", "", "(Ljava/lang/String;ILjava/lang/String;Z[Ljava/lang/String;)V", "getExtensions", "()[Ljava/lang/String;", "[Ljava/lang/String;", "()Z", "getMimeType", "()Ljava/lang/String;", Printer.TO_STRING, "TEXT_PLAIN", "TEXT_CSS", "TEXT_CSV", "TEXT_HTML", "TEXT_MARKDOWN", "TEXT_PROPERTIES", "TEXT_XML", "IMAGE_ICO", "IMAGE_JPEG", "IMAGE_PNG", "IMAGE_TIFF", "FONT_OTF", "FONT_TTF", "APPLICATION_OCTET_STREAM", "APPLICATION_BZ", "APPLICATION_BZ2", "APPLICATION_CDN", "APPLICATION_GZ", "APPLICATION_JS", "APPLICATION_JSON", "APPLICATION_MPKG", "APPLICATION_JAR", "APPLICATION_PDF", "APPLICATION_POM", "APPLICATION_RAR", "APPLICATION_SH", "APPLICATION_TAR", "APPLICATION_XHTML", "APPLICATION_YAML", "APPLICATION_ZIP", "APPLICATION_7Z", "MULTIPART_FORM_DATA", "Companion", "javalin"})
/* renamed from: io.javalin.http.ContentType */
/* loaded from: grasscutter.jar:io/javalin/http/ContentType.class */
public enum ContentType {
    TEXT_PLAIN(PLAIN, true, "txt"),
    TEXT_CSS(CSS, true, "css"),
    TEXT_CSV("text/csv", false, "csv"),
    TEXT_HTML(HTML, true, "html", "htm"),
    TEXT_MARKDOWN("text/markdown", true, "md"),
    TEXT_PROPERTIES("text/x-java-properties", true, "properties"),
    TEXT_XML(XML, true, "xml"),
    IMAGE_ICO("image/vnd.microsoft.icon", true, "ico"),
    IMAGE_JPEG("image/jpeg", true, "jpeg", "jpg"),
    IMAGE_PNG("image/png", true, "png"),
    IMAGE_TIFF("image/tiff", true, "tiff", "tif"),
    FONT_OTF("font/otf", false, "otf"),
    FONT_TTF("font/ttf", false, "ttf"),
    APPLICATION_OCTET_STREAM(OCTET_STREAM, false, "bin"),
    APPLICATION_BZ("application/x-bzip", false, "bz"),
    APPLICATION_BZ2("application/x-bzip2", false, "bz2"),
    APPLICATION_CDN("application/cdn", true, "cdn"),
    APPLICATION_GZ("application/gzip", false, "gz"),
    APPLICATION_JS(JAVASCRIPT, true, "js"),
    APPLICATION_JSON(JSON, true, "json"),
    APPLICATION_MPKG("application/vnd.apple.installer+xml", false, "mpkg"),
    APPLICATION_JAR("application/java-archive", false, "jar"),
    APPLICATION_PDF("application/pdf", false, "pdf"),
    APPLICATION_POM("application/xml", true, "pom"),
    APPLICATION_RAR("application/vnd.rar", false, "rar"),
    APPLICATION_SH("application/x-sh", true, "sh"),
    APPLICATION_TAR("application/x-tar", false, "tar"),
    APPLICATION_XHTML("application/xhtml+xml", true, "xhtml"),
    APPLICATION_YAML("application/yaml", true, "yaml", "yml"),
    APPLICATION_ZIP("application/zip", false, "zip"),
    APPLICATION_7Z("application/x-7z-compressed", false, "7z"),
    MULTIPART_FORM_DATA(FORM_DATA, false, FORM_DATA);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final String mimeType;
    private final boolean isHumanReadable;
    @NotNull
    private final String[] extensions;
    @NotNull
    public static final String PLAIN = "text/plain";
    @NotNull
    public static final String CSS = "text/css";
    @NotNull
    public static final String HTML = "text/html";
    @NotNull
    public static final String XML = "text/xml";
    @NotNull
    public static final String OCTET_STREAM = "application/octet-stream";
    @NotNull
    public static final String JAVASCRIPT = "application/javascript";
    @NotNull
    public static final String JSON = "application/json";
    @NotNull
    public static final String FORM_DATA = "multipart/form-data";

    @JvmStatic
    @Nullable
    public static final ContentType getContentType(@NotNull String mimeType) {
        return Companion.getContentType(mimeType);
    }

    @JvmStatic
    @Nullable
    public static final ContentType getContentTypeByExtension(@NotNull String extension) {
        return Companion.getContentTypeByExtension(extension);
    }

    @JvmStatic
    @Nullable
    public static final String getMimeTypeByExtension(@NotNull String extensions) {
        return Companion.getMimeTypeByExtension(extensions);
    }

    ContentType(String mimeType, boolean isHumanReadable, String... extensions) {
        this.mimeType = mimeType;
        this.isHumanReadable = isHumanReadable;
        this.extensions = extensions;
    }

    @NotNull
    public final String getMimeType() {
        return this.mimeType;
    }

    public final boolean isHumanReadable() {
        return this.isHumanReadable;
    }

    @NotNull
    public final String[] getExtensions() {
        return this.extensions;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.mimeType;
    }

    /* compiled from: ContentType.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u0004H\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0012\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n��¨\u0006\u0013"}, m373d2 = {"Lio/javalin/http/ContentType$Companion;", "", "()V", "CSS", "", "FORM_DATA", "HTML", "JAVASCRIPT", JsonFactory.FORMAT_NAME_JSON, "OCTET_STREAM", "PLAIN", "XML", "getContentType", "Lio/javalin/http/ContentType;", "mimeType", "getContentTypeByExtension", "extension", "getMimeTypeByExtension", "extensions", "javalin"})
    /* renamed from: io.javalin.http.ContentType$Companion */
    /* loaded from: grasscutter.jar:io/javalin/http/ContentType$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @Nullable
        public final ContentType getContentType(@NotNull String mimeType) {
            Intrinsics.checkNotNullParameter(mimeType, "mimeType");
            ContentType[] values = ContentType.values();
            for (ContentType it : values) {
                if (StringsKt.equals(it.getMimeType(), mimeType, true)) {
                    return it;
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final ContentType getContentTypeByExtension(@NotNull String extension) {
            boolean z;
            Intrinsics.checkNotNullParameter(extension, "extension");
            ContentType[] values = ContentType.values();
            for (ContentType contentType : values) {
                String[] extensions = contentType.getExtensions();
                int length = extensions.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = false;
                        break;
                    } else if (StringsKt.equals(extension, extensions[i], true)) {
                        z = true;
                        break;
                    } else {
                        i++;
                    }
                }
                if (z) {
                    return contentType;
                }
            }
            return null;
        }

        @JvmStatic
        @Nullable
        public final String getMimeTypeByExtension(@NotNull String extensions) {
            Intrinsics.checkNotNullParameter(extensions, "extensions");
            ContentType contentTypeByExtension = getContentTypeByExtension(extensions);
            if (contentTypeByExtension == null) {
                return null;
            }
            return contentTypeByExtension.getMimeType();
        }
    }
}
