package okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.xml.XMLSchedulingDataProcessor;
import org.slf4j.Logger;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: ResourceFileSystem.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\b��\u0018�� *2\u00020\u0001:\u0001*B\u0017\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0016\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0018\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\b2\u0006\u0010\u001b\u001a\u00020\nH\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010\u0018\u001a\u00020\nH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\nH\u0016J \u0010%\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010\u0015\u001a\u00020'2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\f\u0010(\u001a\u00020)*\u00020\nH\u0002R-\u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n0\t0\b8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006+"}, m373d2 = {"Lokio/internal/ResourceFileSystem;", "Lokio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", "", "(Ljava/lang/ClassLoader;Z)V", "roots", "", "Lkotlin/Pair;", "Lokio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lkotlin/Lazy;", "appendingSink", "Lokio/Sink;", Action.FILE_ATTRIBUTE, "mustExist", "atomicMove", "", "source", TypeProxy.INSTANCE_FIELD, "canonicalize", "path", "canonicalizeInternal", "createDirectory", "dir", "mustCreate", "createSymlink", "delete", "list", "listOrNull", "metadataOrNull", "Lokio/FileMetadata;", "openReadOnly", "Lokio/FileHandle;", "openReadWrite", "sink", "Lokio/Source;", "toRelativePath", "", "Companion", "okio"})
/* loaded from: grasscutter.jar:okio/internal/ResourceFileSystem.class */
public final class ResourceFileSystem extends FileSystem {
    @NotNull
    private final Lazy roots$delegate;
    @NotNull
    private static final Companion Companion = new Companion(null);
    @Deprecated
    @NotNull
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);

    public ResourceFileSystem(@NotNull ClassLoader classLoader, boolean indexEagerly) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        this.roots$delegate = LazyKt.lazy(new Function0<List<? extends Pair<? extends FileSystem, ? extends Path>>>(classLoader) { // from class: okio.internal.ResourceFileSystem$roots$2
            final /* synthetic */ ClassLoader $classLoader;

            /* access modifiers changed from: package-private */
            {
                this.$classLoader = $classLoader;
            }

            /* Return type fixed from 'java.util.List<kotlin.Pair<okio.FileSystem, okio.Path>>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends Pair<? extends FileSystem, ? extends Path>> invoke() {
                return ResourceFileSystem.Companion.toClasspathRoots(this.$classLoader);
            }
        });
        if (indexEagerly) {
            getRoots().size();
        }
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    @Override // okio.FileSystem
    @NotNull
    public Path canonicalize(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return canonicalizeInternal(path);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override // okio.FileSystem
    @NotNull
    public List<Path> list(@NotNull Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath = toRelativePath(dir);
        Set result = new LinkedHashSet();
        boolean foundAny = false;
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem fileSystem = pair.component1();
            Path base = pair.component2();
            try {
                Set set = result;
                Iterable $this$filter$iv = fileSystem.list(base.resolve(relativePath));
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    if (Companion.keepPath((Path) element$iv$iv)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable<Path> $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Path it : $this$map$iv) {
                    destination$iv$iv2.add(Companion.removeBase(it, base));
                }
                CollectionsKt.addAll(set, (List) destination$iv$iv2);
                foundAny = true;
            } catch (IOException e) {
            }
        }
        if (foundAny) {
            return CollectionsKt.toList(result);
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", dir));
    }

    @Override // okio.FileSystem
    @Nullable
    public List<Path> listOrNull(@NotNull Path dir) {
        List baseResult;
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath = toRelativePath(dir);
        Set result = new LinkedHashSet();
        boolean foundAny = false;
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem fileSystem = pair.component1();
            Path base = pair.component2();
            Iterable listOrNull = fileSystem.listOrNull(base.resolve(relativePath));
            if (listOrNull == null) {
                baseResult = null;
            } else {
                Iterable $this$filter$iv = listOrNull;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    if (Companion.keepPath((Path) element$iv$iv)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                Iterable<Path> $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Path it : $this$map$iv) {
                    destination$iv$iv2.add(Companion.removeBase(it, base));
                }
                baseResult = (List) destination$iv$iv2;
            }
            if (baseResult != null) {
                CollectionsKt.addAll(result, baseResult);
                foundAny = true;
            }
        }
        if (foundAny) {
            return CollectionsKt.toList(result);
        }
        return null;
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadOnly(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", file));
        }
        String relativePath = toRelativePath(file);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            try {
                return pair.component1().openReadOnly(pair.component2().resolve(relativePath));
            } catch (FileNotFoundException e) {
            }
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", file));
    }

    @Override // okio.FileSystem
    @NotNull
    public FileHandle openReadWrite(@NotNull Path file, boolean mustCreate, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileMetadata metadataOrNull = pair.component1().metadataOrNull(pair.component2().resolve(relativePath));
            if (metadataOrNull != null) {
                return metadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    @NotNull
    public Source source(@NotNull Path file) {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", file));
        }
        String relativePath = toRelativePath(file);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            try {
                return pair.component1().source(pair.component2().resolve(relativePath));
            } catch (FileNotFoundException e) {
            }
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("file not found: ", file));
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink sink(@NotNull Path file, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    @NotNull
    public Sink appendingSink(@NotNull Path file, boolean mustExist) {
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createDirectory(@NotNull Path dir, boolean mustCreate) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(@NotNull Path path, boolean mustExist) {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        throw new IOException(this + " is read-only");
    }

    private final String toRelativePath(Path $this$toRelativePath) {
        return canonicalizeInternal($this$toRelativePath).relativeTo(ROOT).toString();
    }

    /* compiled from: ResourceFileSystem.kt */
    /* access modifiers changed from: private */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��6\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004J\u001c\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000e0\r*\u00020\u0010J\u0018\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012J\u0018\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000e*\u00020\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, m373d2 = {"Lokio/internal/ResourceFileSystem$Companion;", "", "()V", Logger.ROOT_LOGGER_NAME, "Lokio/Path;", "getROOT", "()Lokio/Path;", "keepPath", "", "path", "removeBase", "base", "toClasspathRoots", "", "Lkotlin/Pair;", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "okio"})
    /* loaded from: grasscutter.jar:okio/internal/ResourceFileSystem$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        @NotNull
        public final Path removeBase(@NotNull Path $this$removeBase, @NotNull Path base) {
            Intrinsics.checkNotNullParameter($this$removeBase, "<this>");
            Intrinsics.checkNotNullParameter(base, "base");
            return getROOT().resolve(StringsKt.replace$default(StringsKt.removePrefix($this$removeBase.toString(), (CharSequence) base.toString()), '\\', '/', false, 4, (Object) null));
        }

        @NotNull
        public final List<Pair<FileSystem, Path>> toClasspathRoots(@NotNull ClassLoader $this$toClasspathRoots) {
            Intrinsics.checkNotNullParameter($this$toClasspathRoots, "<this>");
            Enumeration<URL> resources = $this$toClasspathRoots.getResources("");
            Intrinsics.checkNotNullExpressionValue(resources, "getResources(\"\")");
            Iterable list = Collections.list(resources);
            Intrinsics.checkNotNullExpressionValue(list, "java.util.Collections.list(this)");
            Iterable<URL> $this$mapNotNull$iv = (List) list;
            Collection destination$iv$iv = new ArrayList();
            for (URL it : $this$mapNotNull$iv) {
                Companion companion = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                Pair<FileSystem, Path> fileRoot = companion.toFileRoot(it);
                if (fileRoot != null) {
                    destination$iv$iv.add(fileRoot);
                }
            }
            ArrayList arrayList = (List) destination$iv$iv;
            Enumeration<URL> resources2 = $this$toClasspathRoots.getResources("META-INF/MANIFEST.MF");
            Intrinsics.checkNotNullExpressionValue(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            Iterable list2 = Collections.list(resources2);
            Intrinsics.checkNotNullExpressionValue(list2, "java.util.Collections.list(this)");
            Collection destination$iv$iv2 = new ArrayList();
            for (URL it2 : (List) list2) {
                Companion companion2 = ResourceFileSystem.Companion;
                Intrinsics.checkNotNullExpressionValue(it2, "it");
                Pair<FileSystem, Path> jarRoot = companion2.toJarRoot(it2);
                if (jarRoot != null) {
                    destination$iv$iv2.add(jarRoot);
                }
            }
            return CollectionsKt.plus((Collection) arrayList, (Iterable) ((List) destination$iv$iv2));
        }

        @Nullable
        public final Pair<FileSystem, Path> toFileRoot(@NotNull URL $this$toFileRoot) {
            Intrinsics.checkNotNullParameter($this$toFileRoot, "<this>");
            if (!Intrinsics.areEqual($this$toFileRoot.getProtocol(), Action.FILE_ATTRIBUTE)) {
                return null;
            }
            return Tuples.m366to(FileSystem.SYSTEM, Path.Companion.get$default(Path.Companion, new File($this$toFileRoot.toURI()), false, 1, (Object) null));
        }

        @Nullable
        public final Pair<FileSystem, Path> toJarRoot(@NotNull URL $this$toJarRoot) {
            int suffixStart;
            Intrinsics.checkNotNullParameter($this$toJarRoot, "<this>");
            String urlString = $this$toJarRoot.toString();
            Intrinsics.checkNotNullExpressionValue(urlString, "toString()");
            if (!StringsKt.startsWith$default(urlString, "jar:file:", false, 2, (Object) null) || (suffixStart = StringsKt.lastIndexOf$default((CharSequence) urlString, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Path.Companion companion = Path.Companion;
            String substring = urlString.substring(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX.length(), suffixStart);
            Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return Tuples.m366to(zip.openZip(Path.Companion.get$default(companion, new File(URI.create(substring)), false, 1, (Object) null), FileSystem.SYSTEM, ResourceFileSystem$Companion$toJarRoot$zip$1.INSTANCE), getROOT());
        }

        /* access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !StringsKt.endsWith(path.name(), ".class", true);
        }
    }
}
