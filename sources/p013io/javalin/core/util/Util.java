package p013io.javalin.core.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.lang.annotation.Annotation;
import java.net.URL;
import java.net.URLEncoder;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMapping;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.http.Context;
import p013io.javalin.http.InternalServerErrorResponse;

/* compiled from: Util.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��^\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0005\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tH\u0007J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0006JG\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b��\u0010\u00112\u001e\u0010\u0012\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u00060\u0015j\u0002`\u00160\u0014\u0012\u0004\u0012\u0002H\u00110\u00132\u0012\u0010\u0017\u001a\u000e\u0012\n\b\u0001\u0012\u00060\u0015j\u0002`\u00160\u0014¢\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\u000e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0005J\u0014\u0010!\u001a\u00020\u00052\n\u0010\"\u001a\u00060\u0015j\u0002`\u0016H\u0007J\u0012\u0010#\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020\u0005H\u0007J\u0018\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010'\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010(\u001a\u00020\u00062\n\u0010)\u001a\u0006\u0012\u0002\b\u00030\u0014J\u0010\u0010*\u001a\u00020\u000e2\u0006\u0010+\u001a\u00020\u0006H\u0007J\b\u0010,\u001a\u00020\u000eH\u0007J\u0006\u0010-\u001a\u00020\u0006J\u0015\u0010.\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH��¢\u0006\u0002\b/J\u0010\u00100\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u0005H\u0007J\u0014\u00102\u001a\b\u0012\u0004\u0012\u00020\u0005032\u0006\u00104\u001a\u00020\u0005J\u0018\u00105\u001a\u00020\u00052\u0006\u00101\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0007J\b\u00106\u001a\u00020\u000eH\u0007J\u0010\u00107\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n��¨\u00068"}, m373d2 = {"Lio/javalin/core/util/Util;", "", "()V", "dependencyCheckCache", "Ljava/util/HashMap;", "", "", "assertWebjarInstalled", "dependency", "Lio/javalin/core/util/OptionalDependency;", "classExists", "className", "dependencyIsPresent", "ensureDependencyPresent", "", "startupCheck", "findByClass", "T", "map", "", "Ljava/lang/Class;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exceptionClass", "(Ljava/util/Map;Ljava/lang/Class;)Ljava/lang/Object;", "formatBuildTime", "buildTime", "getChecksumAndReset", "inputStream", "Ljava/io/ByteArrayInputStream;", "getFileUrl", "Ljava/net/URL;", "path", "getPort", "e", "getResourceUrl", "getWebjarPublicPath", "ctx", "Lio/javalin/http/Context;", "getWebjarResourceUrl", "isKotlinClass", "clazz", "logJavalinBanner", "showBanner", "logJavalinVersion", "loggingLibraryExists", "missingDependencyMessage", "missingDependencyMessage$javalin", "normalizeContextPath", "contextPath", "pathToList", "", "pathString", "prefixContextPath", "printHelpfulMessageIfLoggerIsMissing", "serviceImplementationExists", "javalin"})
/* renamed from: io.javalin.core.util.Util */
/* loaded from: grasscutter.jar:io/javalin/core/util/Util.class */
public final class Util {
    @NotNull
    public static final Util INSTANCE = new Util();
    @NotNull
    private static final HashMap<String, Boolean> dependencyCheckCache = new HashMap<>();

    private Util() {
    }

    @JvmStatic
    @NotNull
    public static final String normalizeContextPath(@NotNull String contextPath) {
        Intrinsics.checkNotNullParameter(contextPath, "contextPath");
        return StringsKt.removeSuffix(new Regex("/{2,}").replace(Intrinsics.stringPlus("/", contextPath), "/"), (CharSequence) "/");
    }

    @JvmStatic
    @NotNull
    public static final String prefixContextPath(@NotNull String contextPath, @NotNull String path) {
        Intrinsics.checkNotNullParameter(contextPath, "contextPath");
        Intrinsics.checkNotNullParameter(path, "path");
        if (Intrinsics.areEqual(path, "*")) {
            return path;
        }
        return new Regex("/{2,}").replace(contextPath + '/' + path, "/");
    }

    public final boolean classExists(@NotNull String className) {
        boolean z;
        Intrinsics.checkNotNullParameter(className, "className");
        try {
            Class.forName(className);
            z = true;
        } catch (ClassNotFoundException e) {
            z = false;
        }
        return z;
    }

    private final boolean serviceImplementationExists(String className) {
        boolean z;
        try {
            ServiceLoader loader = ServiceLoader.load(Class.forName(className));
            Intrinsics.checkNotNullExpressionValue(loader, "loader");
            z = CollectionsKt.any(loader);
        } catch (ClassNotFoundException e) {
            z = false;
        }
        return z;
    }

    public final boolean dependencyIsPresent(@NotNull OptionalDependency dependency) {
        boolean z;
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        try {
            ensureDependencyPresent$default(this, dependency, false, 2, null);
            z = true;
        } catch (Exception e) {
            z = false;
        }
        return z;
    }

    public static /* synthetic */ void ensureDependencyPresent$default(Util util, OptionalDependency optionalDependency, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        util.ensureDependencyPresent(optionalDependency, z);
    }

    public final void ensureDependencyPresent(@NotNull OptionalDependency dependency, boolean startupCheck) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        if (!Intrinsics.areEqual((Object) dependencyCheckCache.get(dependency.getTestClass()), (Object) true)) {
            if (!classExists(dependency.getTestClass())) {
                String message = missingDependencyMessage$javalin(dependency);
                if (startupCheck) {
                    throw new IllegalStateException(message);
                }
                JavalinLogger.warn$default(message, null, 2, null);
                throw new InternalServerErrorResponse(message, null, 2, null);
            }
            dependencyCheckCache.put(dependency.getTestClass(), true);
        }
    }

    @NotNull
    public final String missingDependencyMessage$javalin(@NotNull OptionalDependency dependency) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        return StringsKt.trimMargin$default("|\n            |-------------------------------------------------------------------\n            |Missing dependency '" + dependency.getDisplayName() + "'. Add the dependency.\n            |\n            |pom.xml:\n            |<dependency>\n            |    <groupId>" + dependency.getGroupId() + "</groupId>\n            |    <artifactId>" + dependency.getArtifactId() + "</artifactId>\n            |    <version>" + dependency.getVersion() + "</version>\n            |</dependency>\n            |\n            |build.gradle:\n            |implementation group: '" + dependency.getGroupId() + "', name: '" + dependency.getArtifactId() + "', version: '" + dependency.getVersion() + "'\n            |\n            |Find the latest version here:\n            |https://search.maven.org/search?q=" + ((Object) URLEncoder.encode("g:" + dependency.getGroupId() + " AND a:" + dependency.getArtifactId(), "UTF-8")) + "\n            |-------------------------------------------------------------------", null, 1, null);
    }

    @NotNull
    public final List<String> pathToList(@NotNull String pathString) {
        Intrinsics.checkNotNullParameter(pathString, "pathString");
        Iterable $this$filter$iv = StringsKt.split$default((CharSequence) pathString, new String[]{"/"}, false, 0, 6, (Object) null);
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (((String) element$iv$iv).length() > 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        return (List) destination$iv$iv;
    }

    @JvmStatic
    public static final void printHelpfulMessageIfLoggerIsMissing() {
        if (!INSTANCE.loggingLibraryExists()) {
            System.err.println(StringsKt.trimMargin$default("\n            |-------------------------------------------------------------------\n            |" + INSTANCE.missingDependencyMessage$javalin(OptionalDependency.SLF4JSIMPLE) + "\n            |-------------------------------------------------------------------\n            |OR\n            |-------------------------------------------------------------------\n            |" + INSTANCE.missingDependencyMessage$javalin(OptionalDependency.SLF4J_PROVIDER_API) + " and\n            |" + INSTANCE.missingDependencyMessage$javalin(OptionalDependency.SLF4J_PROVIDER_SIMPLE) + "\n            |-------------------------------------------------------------------\n            |Visit https://javalin.io/documentation#logging if you need more help", null, 1, null));
        }
    }

    public final boolean loggingLibraryExists() {
        return classExists(OptionalDependency.SLF4JSIMPLE.getTestClass()) || serviceImplementationExists(OptionalDependency.SLF4J_PROVIDER_API.getTestClass());
    }

    @JvmStatic
    public static final void logJavalinBanner(boolean showBanner) {
        if (showBanner) {
            JavalinLogger.info$default(Intrinsics.stringPlus("\n", "       __                      __ _            __ __\n      / /____ _ _   __ ____ _ / /(_)____      / // /\n __  / // __ `/| | / // __ `// // // __ \\    / // /_\n/ /_/ // /_/ / | |/ // /_/ // // // / / /   /__  __/\n\\____/ \\__,_/  |___/ \\__,_//_//_//_/ /_/      /_/\n\n          https://javalin.io/documentation\n"), null, 2, null);
        }
    }

    /* JADX INFO: Multiple debug info for r0v0 java.util.Properties: [D('properties' java.util.Properties), D('it' java.util.Properties)] */
    @JvmStatic
    public static final void logJavalinVersion() {
        try {
            Properties it = new Properties();
            it.load(INSTANCE.getClass().getClassLoader().getResourceAsStream("META-INF/maven/io.javalin/javalin/pom.properties"));
            String property = it.getProperty("version");
            Intrinsics.checkNotNull(property);
            String property2 = it.getProperty("buildTime");
            Intrinsics.checkNotNull(property2);
            List listOf = CollectionsKt.listOf((Object[]) new String[]{property, property2});
            JavalinLogger.startup("You are running Javalin " + ((String) listOf.get(0)) + " (released " + ((Object) INSTANCE.formatBuildTime((String) listOf.get(1))) + ").");
        } catch (Exception e) {
        }
    }

    private final String formatBuildTime(String buildTime) {
        String str;
        String str2;
        try {
            List listOf = CollectionsKt.listOf((Object[]) new Instant[]{Instant.parse(buildTime), Instant.now()});
            Instant release = (Instant) listOf.get(0);
            Instant now = (Instant) listOf.get(1);
            String format = DateTimeFormatter.ofPattern("MMMM d, yyyy").withLocale(Locale.US).withZone(ZoneId.of("Z")).format(release);
            if (now.isAfter(release.plus(90L, (TemporalUnit) ChronoUnit.DAYS))) {
                str2 = ". Your Javalin version is " + ChronoUnit.DAYS.between(release, now) + " days old. Consider checking for a newer version.";
            } else {
                str2 = "";
            }
            str = Intrinsics.stringPlus(format, str2);
        } catch (Exception e) {
            str = null;
        }
        return str;
    }

    @NotNull
    public final String getChecksumAndReset(@NotNull ByteArrayInputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        inputStream.mark(Integer.MAX_VALUE);
        CheckedInputStream cis = new CheckedInputStream(inputStream, new Adler32());
        for (int read = cis.read(); read > -1; read = cis.read()) {
        }
        inputStream.reset();
        return String.valueOf(cis.getChecksum().getValue());
    }

    @JvmStatic
    @Nullable
    public static final URL getResourceUrl(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return INSTANCE.getClass().getClassLoader().getResource(path);
    }

    @JvmStatic
    @NotNull
    public static final String getWebjarPublicPath(@NotNull Context ctx, @NotNull OptionalDependency dependency) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        return ctx.contextPath() + "/webjars/" + dependency.getArtifactId() + '/' + dependency.getVersion();
    }

    @JvmStatic
    @Nullable
    public static final Object assertWebjarInstalled(@NotNull OptionalDependency dependency) {
        Object obj;
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        try {
            Util util = INSTANCE;
            obj = getWebjarResourceUrl(dependency);
        } catch (Exception e) {
            JavalinLogger.warn$default(INSTANCE.missingDependencyMessage$javalin(dependency), null, 2, null);
            obj = Unit.INSTANCE;
        }
        return obj;
    }

    @JvmStatic
    @Nullable
    public static final URL getWebjarResourceUrl(@NotNull OptionalDependency dependency) {
        Intrinsics.checkNotNullParameter(dependency, "dependency");
        Util util = INSTANCE;
        return getResourceUrl("META-INF/resources/webjars/" + dependency.getArtifactId() + '/' + dependency.getVersion());
    }

    @Nullable
    public final URL getFileUrl(@NotNull String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (new File(path).exists()) {
            return new File(path).toURI().toURL();
        }
        return null;
    }

    public final boolean isKotlinClass(@NotNull Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        try {
            Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
            Intrinsics.checkNotNullExpressionValue(declaredAnnotations, "clazz.declaredAnnotations");
            int i = 0;
            int length = declaredAnnotations.length;
            while (i < length) {
                Annotation annotation = declaredAnnotations[i];
                i++;
                if (StringsKt.contains$default((CharSequence) JvmClassMapping.getAnnotationClass(annotation).toString(), (CharSequence) "kotlin.Metadata", false, 2, (Object) null)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getPort(@NotNull Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        String $this$takeLastWhile$iv = e.getMessage();
        Intrinsics.checkNotNull($this$takeLastWhile$iv);
        for (int index$iv = StringsKt.getLastIndex($this$takeLastWhile$iv); index$iv >= 0; index$iv--) {
            if (!($this$takeLastWhile$iv.charAt(index$iv) != ':')) {
                String substring = $this$takeLastWhile$iv.substring(index$iv + 1);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.String).substring(startIndex)");
                return substring;
            }
        }
        return $this$takeLastWhile$iv;
    }

    @Nullable
    public final <T> T findByClass(@NotNull Map<Class<? extends Exception>, ? extends T> map, @NotNull Class<? extends Exception> cls) {
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(cls, "exceptionClass");
        T t = (T) map.get(cls);
        if (t != null) {
            return t;
        }
        for (Class superclass = cls.getSuperclass(); superclass != null; superclass = superclass.getSuperclass()) {
            if (map.containsKey(superclass)) {
                return (T) map.get(superclass);
            }
        }
        return null;
    }
}
