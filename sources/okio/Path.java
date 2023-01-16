package okio;

import java.io.File;
import java.nio.file.Paths;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.internal._PathKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: Path.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��P\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n��\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010��\n\u0002\b\u0005\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018�� .2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001.B\u000f\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020��H\u0002J\u0016\u0010 \u001a\u00020��2\u0006\u0010!\u001a\u00020\rH\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020��2\u0006\u0010!\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\"J\u0016\u0010 \u001a\u00020��2\u0006\u0010!\u001a\u00020��H\u0002¢\u0006\u0002\b\"J\u0013\u0010#\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010$H\u0002J\b\u0010%\u001a\u00020\u001eH\u0016J\u0006\u0010&\u001a\u00020��J\u000e\u0010'\u001a\u00020��2\u0006\u0010\u001f\u001a\u00020��J\u0018\u0010\"\u001a\u00020��2\u0006\u0010!\u001a\u00020\r2\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020��2\u0006\u0010!\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020\bJ\u0018\u0010\"\u001a\u00020��2\u0006\u0010!\u001a\u00020��2\b\b\u0002\u0010(\u001a\u00020\bJ\u0006\u0010)\u001a\u00020*J\b\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0011\u0010\n\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\tR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\f\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010��8G¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u0004\u0018\u00010��8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001c¨\u0006/"}, m373d2 = {"Lokio/Path;", "", "bytes", "Lokio/ByteString;", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "isAbsolute", "", "()Z", "isRelative", "isRoot", "name", "", "()Ljava/lang/String;", "nameBytes", "parent", "()Lokio/Path;", "root", "getRoot", "segments", "", "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "volumeLetter", "", "()Ljava/lang/Character;", "compareTo", "", "other", "div", "child", "resolve", "equals", "", "hashCode", "normalized", "relativeTo", "normalize", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", Printer.TO_STRING, "Companion", "okio"})
/* loaded from: grasscutter.jar:okio/Path.class */
public final class Path implements Comparable<Path> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private final ByteString bytes;
    @JvmField
    @NotNull
    public static final String DIRECTORY_SEPARATOR;

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String $this$get, boolean normalize) {
        return Companion.get($this$get, normalize);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File $this$get, boolean normalize) {
        return Companion.get($this$get, normalize);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @IgnoreJRERequirement
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path $this$get, boolean normalize) {
        return Companion.get($this$get, normalize);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull String $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull File $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
    @IgnoreJRERequirement
    @NotNull
    @JvmOverloads
    public static final Path get(@NotNull java.nio.file.Path $this$get) {
        return Companion.get($this$get);
    }

    public Path(@NotNull ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    @NotNull
    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    @Nullable
    public final Path getRoot() {
        int rootLength$iv = _PathKt.access$rootLength(this);
        if (rootLength$iv == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, rootLength$iv));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0132 A[LOOP:1: B:23:0x0128->B:25:0x0132, LOOP_END] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> getSegments() {
        /*
        // Method dump skipped, instructions count: 357
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Path.getSegments():java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c6  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<okio.ByteString> getSegmentsBytes() {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Path.getSegmentsBytes():java.util.List");
    }

    public final boolean isAbsolute() {
        return _PathKt.access$rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return _PathKt.access$rootLength(this) == -1;
    }

    @JvmName(name = "volumeLetter")
    @Nullable
    public final Character volumeLetter() {
        if (ByteString.indexOf$default(getBytes$okio(), _PathKt.access$getSLASH$p(), 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c$iv = (char) getBytes$okio().getByte(0);
        if (!('a' <= c$iv ? c$iv <= 'z' : false)) {
            if (!('A' <= c$iv ? c$iv <= 'Z' : false)) {
                return null;
            }
        }
        return Character.valueOf(c$iv);
    }

    @JvmName(name = "nameBytes")
    @NotNull
    public final ByteString nameBytes() {
        int lastSlash$iv = _PathKt.access$getIndexOfLastSlash(this);
        if (lastSlash$iv != -1) {
            return ByteString.substring$default(getBytes$okio(), lastSlash$iv + 1, 0, 2, null);
        }
        return (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : ByteString.EMPTY;
    }

    @JvmName(name = "name")
    @NotNull
    public final String name() {
        return nameBytes().utf8();
    }

    @JvmName(name = "parent")
    @Nullable
    public final Path parent() {
        if (Intrinsics.areEqual(getBytes$okio(), _PathKt.access$getDOT$p()) || Intrinsics.areEqual(getBytes$okio(), _PathKt.access$getSLASH$p()) || Intrinsics.areEqual(getBytes$okio(), _PathKt.access$getBACKSLASH$p()) || _PathKt.access$lastSegmentIsDotDot(this)) {
            return null;
        }
        int lastSlash$iv = _PathKt.access$getIndexOfLastSlash(this);
        if (lastSlash$iv != 2 || volumeLetter() == null) {
            if (lastSlash$iv == 1 && getBytes$okio().startsWith(_PathKt.access$getBACKSLASH$p())) {
                return null;
            }
            if (lastSlash$iv != -1 || volumeLetter() == null) {
                if (lastSlash$iv == -1) {
                    return new Path(_PathKt.access$getDOT$p());
                }
                if (lastSlash$iv == 0) {
                    return new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
                }
                return new Path(ByteString.substring$default(getBytes$okio(), 0, lastSlash$iv, 1, null));
            } else if (getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
            }
        } else if (getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        }
    }

    public final boolean isRoot() {
        return _PathKt.access$rootLength(this) == getBytes$okio().size();
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), false);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), false);
    }

    @JvmName(name = "resolve")
    @NotNull
    public final Path resolve(@NotNull Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, false);
    }

    public static /* synthetic */ Path resolve$default(Path path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(str, z);
    }

    @NotNull
    public final Path resolve(@NotNull String child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().writeUtf8(child), false), normalize);
    }

    public static /* synthetic */ Path resolve$default(Path path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(byteString, z);
    }

    @NotNull
    public final Path resolve(@NotNull ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, _PathKt.toPath(new Buffer().write(child), false), normalize);
    }

    public static /* synthetic */ Path resolve$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(path2, z);
    }

    @NotNull
    public final Path resolve(@NotNull Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return _PathKt.commonResolve(this, child, normalize);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x01ad A[LOOP:2: B:38:0x01ad->B:39:0x01d2, LOOP_START, PHI: r16 
      PHI: (r16v5 'i$iv' int) = (r16v4 'i$iv' int), (r16v6 'i$iv' int) binds: [B:37:0x01aa, B:39:0x01d2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01d5  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final okio.Path relativeTo(@org.jetbrains.annotations.NotNull okio.Path r7) {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.Path.relativeTo(okio.Path):okio.Path");
    }

    @NotNull
    public final Path normalized() {
        return Companion.get(toString(), true);
    }

    @NotNull
    public final File toFile() {
        return new File(toString());
    }

    @IgnoreJRERequirement
    @NotNull
    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(toString())");
        return path;
    }

    public int compareTo(@NotNull Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object other) {
        return (other instanceof Path) && Intrinsics.areEqual(((Path) other).getBytes$okio(), getBytes$okio());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return getBytes$okio().utf8();
    }

    /* compiled from: Path.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��*\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u0005\u001a\u00020\u0006*\u00020\u000b2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\f\u001a\u00020\u0006*\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lokio/Path$Companion;", "", "()V", "DIRECTORY_SEPARATOR", "", "toOkioPath", "Lokio/Path;", "Ljava/io/File;", "normalize", "", BeanUtil.PREFIX_GETTER_GET, "Ljava/nio/file/Path;", "toPath", "okio"})
    /* loaded from: grasscutter.jar:okio/Path$Companion.class */
    public static final class Companion {
        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String $this$toPath) {
            Intrinsics.checkNotNullParameter($this$toPath, "<this>");
            return get$default(this, $this$toPath, false, 1, (Object) null);
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File $this$toOkioPath) {
            Intrinsics.checkNotNullParameter($this$toOkioPath, "<this>");
            return get$default(this, $this$toOkioPath, false, 1, (Object) null);
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @IgnoreJRERequirement
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path $this$toOkioPath) {
            Intrinsics.checkNotNullParameter($this$toOkioPath, "<this>");
            return get$default(this, $this$toOkioPath, false, 1, (Object) null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull String $this$toPath, boolean normalize) {
            Intrinsics.checkNotNullParameter($this$toPath, "<this>");
            return _PathKt.commonToPath($this$toPath, normalize);
        }

        public static /* synthetic */ Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(str, z);
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull File $this$toOkioPath, boolean normalize) {
            Intrinsics.checkNotNullParameter($this$toOkioPath, "<this>");
            String file = $this$toOkioPath.toString();
            Intrinsics.checkNotNullExpressionValue(file, "toString()");
            return get(file, normalize);
        }

        public static /* synthetic */ Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(file, z);
        }

        @JvmStatic
        @JvmName(name = BeanUtil.PREFIX_GETTER_GET)
        @IgnoreJRERequirement
        @NotNull
        @JvmOverloads
        public final Path get(@NotNull java.nio.file.Path $this$toOkioPath, boolean normalize) {
            Intrinsics.checkNotNullParameter($this$toOkioPath, "<this>");
            return get($this$toOkioPath.toString(), normalize);
        }

        public static /* synthetic */ Path get$default(Companion companion, java.nio.file.Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(path, z);
        }
    }

    static {
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "separator");
        DIRECTORY_SEPARATOR = str;
    }
}
