package okio.internal;

import dev.morphia.mapping.Mapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* compiled from: -Path.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��H\n��\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010��\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0006\n\u0002\u0010\u0005\n��\u001a\u0015\u0010\u0014\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\b\u001a\u0017\u0010\u0016\u001a\u00020\u0017*\u00020\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0018H\b\u001a\r\u0010\u0019\u001a\u00020\r*\u00020\u000eH\b\u001a\r\u0010\u001a\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001b\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001c\u001a\u00020\u0017*\u00020\u000eH\b\u001a\r\u0010\u001d\u001a\u00020\u001e*\u00020\u000eH\b\u001a\r\u0010\u001f\u001a\u00020\u0001*\u00020\u000eH\b\u001a\r\u0010 \u001a\u00020\u000e*\u00020\u000eH\b\u001a\u000f\u0010!\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\b\u001a\u0015\u0010\"\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001d\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010%\u001a\u00020\u0017H\b\u001a\u001c\u0010#\u001a\u00020\u000e*\u00020\u000e2\u0006\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\u0017H��\u001a\u000f\u0010'\u001a\u0004\u0018\u00010\u000e*\u00020\u000eH\b\u001a\u0013\u0010(\u001a\b\u0012\u0004\u0012\u00020\u001e0)*\u00020\u000eH\b\u001a\u0013\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010)*\u00020\u000eH\b\u001a\u0012\u0010+\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010%\u001a\u00020\u0017\u001a\r\u0010,\u001a\u00020\u001e*\u00020\u000eH\b\u001a\u0014\u0010-\u001a\u0004\u0018\u00010.*\u00020\u000eH\b¢\u0006\u0002\u0010/\u001a\f\u00100\u001a\u00020\u0017*\u00020\u000eH\u0002\u001a\f\u00101\u001a\u00020\r*\u00020\u000eH\u0002\u001a\u0014\u00102\u001a\u00020\u0017*\u00020&2\u0006\u0010\u0011\u001a\u00020\u0001H\u0002\u001a\u0014\u00103\u001a\u00020\u000e*\u00020&2\u0006\u0010%\u001a\u00020\u0017H��\u001a\f\u00104\u001a\u00020\u0001*\u000205H\u0002\u001a\f\u00104\u001a\u00020\u0001*\u00020\u001eH\u0002\"\u0016\u0010��\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n��\u0012\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n��\u0012\u0004\b\u0005\u0010\u0003\"\u0016\u0010\u0006\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n��\u0012\u0004\b\u0007\u0010\u0003\"\u0016\u0010\b\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n��\u0012\u0004\b\t\u0010\u0003\"\u0016\u0010\n\u001a\u00020\u00018\u0002X\u0004¢\u0006\b\n��\u0012\u0004\b\u000b\u0010\u0003\"\u0018\u0010\f\u001a\u00020\r*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u0001*\u00020\u000e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u00066"}, m373d2 = {"ANY_SLASH", "Lokio/ByteString;", "getANY_SLASH$annotations", "()V", "BACKSLASH", "getBACKSLASH$annotations", "DOT", "getDOT$annotations", "DOT_DOT", "getDOT_DOT$annotations", "SLASH", "getSLASH$annotations", "indexOfLastSlash", "", "Lokio/Path;", "getIndexOfLastSlash", "(Lokio/Path;)I", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "other", "commonEquals", "", "", "commonHashCode", "commonIsAbsolute", "commonIsRelative", "commonIsRoot", "commonName", "", "commonNameBytes", "commonNormalized", "commonParent", "commonRelativeTo", "commonResolve", "child", "normalize", "Lokio/Buffer;", "commonRoot", "commonSegments", "", "commonSegmentsBytes", "commonToPath", "commonToString", "commonVolumeLetter", "", "(Lokio/Path;)Ljava/lang/Character;", "lastSegmentIsDotDot", "rootLength", "startsWithVolumeLetterAndColon", "toPath", "toSlash", "", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_PathKt.class */
public final class _PathKt {
    @NotNull
    private static final ByteString SLASH = ByteString.Companion.encodeUtf8("/");
    @NotNull
    private static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    @NotNull
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    @NotNull
    private static final ByteString DOT = ByteString.Companion.encodeUtf8(Mapper.IGNORED_FIELDNAME);
    @NotNull
    private static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8(CallerDataConverter.DEFAULT_RANGE_DELIMITER);

    private static /* synthetic */ void getSLASH$annotations() {
    }

    private static /* synthetic */ void getBACKSLASH$annotations() {
    }

    private static /* synthetic */ void getANY_SLASH$annotations() {
    }

    private static /* synthetic */ void getDOT$annotations() {
    }

    private static /* synthetic */ void getDOT_DOT$annotations() {
    }

    @Nullable
    public static final Path commonRoot(@NotNull Path $this$commonRoot) {
        Intrinsics.checkNotNullParameter($this$commonRoot, "<this>");
        int rootLength = rootLength($this$commonRoot);
        if (rootLength == -1) {
            return null;
        }
        return new Path($this$commonRoot.getBytes$okio().substring(0, rootLength));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00da  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0134 A[LOOP:1: B:23:0x012a->B:25:0x0134, LOOP_END] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<java.lang.String> commonSegments(@org.jetbrains.annotations.NotNull okio.Path r5) {
        /*
        // Method dump skipped, instructions count: 358
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonSegments(okio.Path):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c8  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<okio.ByteString> commonSegmentsBytes(@org.jetbrains.annotations.NotNull okio.Path r4) {
        /*
        // Method dump skipped, instructions count: 238
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonSegmentsBytes(okio.Path):java.util.List");
    }

    public static final int rootLength(Path $this$rootLength) {
        if ($this$rootLength.getBytes$okio().size() == 0) {
            return -1;
        }
        if ($this$rootLength.getBytes$okio().getByte(0) == ((byte) 47)) {
            return 1;
        }
        if ($this$rootLength.getBytes$okio().getByte(0) == ((byte) 92)) {
            if ($this$rootLength.getBytes$okio().size() <= 2 || $this$rootLength.getBytes$okio().getByte(1) != ((byte) 92)) {
                return 1;
            }
            int uncRootEnd = $this$rootLength.getBytes$okio().indexOf(BACKSLASH, 2);
            if (uncRootEnd == -1) {
                uncRootEnd = $this$rootLength.getBytes$okio().size();
            }
            return uncRootEnd;
        } else if ($this$rootLength.getBytes$okio().size() <= 2 || $this$rootLength.getBytes$okio().getByte(1) != ((byte) 58) || $this$rootLength.getBytes$okio().getByte(2) != ((byte) 92)) {
            return -1;
        } else {
            char c = (char) $this$rootLength.getBytes$okio().getByte(0);
            if ('a' <= c ? c <= 'z' : false) {
                return 3;
            }
            return !('A' <= c ? c <= 'Z' : false) ? -1 : 3;
        }
    }

    public static final boolean commonIsAbsolute(@NotNull Path $this$commonIsAbsolute) {
        Intrinsics.checkNotNullParameter($this$commonIsAbsolute, "<this>");
        return rootLength($this$commonIsAbsolute) != -1;
    }

    public static final boolean commonIsRelative(@NotNull Path $this$commonIsRelative) {
        Intrinsics.checkNotNullParameter($this$commonIsRelative, "<this>");
        return rootLength($this$commonIsRelative) == -1;
    }

    @Nullable
    public static final Character commonVolumeLetter(@NotNull Path $this$commonVolumeLetter) {
        Intrinsics.checkNotNullParameter($this$commonVolumeLetter, "<this>");
        if (ByteString.indexOf$default($this$commonVolumeLetter.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || $this$commonVolumeLetter.getBytes$okio().size() < 2 || $this$commonVolumeLetter.getBytes$okio().getByte(1) != ((byte) 58)) {
            return null;
        }
        char c = (char) $this$commonVolumeLetter.getBytes$okio().getByte(0);
        if (!('a' <= c ? c <= 'z' : false)) {
            if (!('A' <= c ? c <= 'Z' : false)) {
                return null;
            }
        }
        return Character.valueOf(c);
    }

    public static final int getIndexOfLastSlash(Path $this$indexOfLastSlash) {
        int lastSlash = ByteString.lastIndexOf$default($this$indexOfLastSlash.getBytes$okio(), SLASH, 0, 2, (Object) null);
        return lastSlash != -1 ? lastSlash : ByteString.lastIndexOf$default($this$indexOfLastSlash.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    @NotNull
    public static final ByteString commonNameBytes(@NotNull Path $this$commonNameBytes) {
        Intrinsics.checkNotNullParameter($this$commonNameBytes, "<this>");
        int lastSlash = getIndexOfLastSlash($this$commonNameBytes);
        return lastSlash != -1 ? ByteString.substring$default($this$commonNameBytes.getBytes$okio(), lastSlash + 1, 0, 2, null) : ($this$commonNameBytes.volumeLetter() == null || $this$commonNameBytes.getBytes$okio().size() != 2) ? $this$commonNameBytes.getBytes$okio() : ByteString.EMPTY;
    }

    @NotNull
    public static final String commonName(@NotNull Path $this$commonName) {
        Intrinsics.checkNotNullParameter($this$commonName, "<this>");
        return $this$commonName.nameBytes().utf8();
    }

    @Nullable
    public static final Path commonParent(@NotNull Path $this$commonParent) {
        Intrinsics.checkNotNullParameter($this$commonParent, "<this>");
        if (Intrinsics.areEqual($this$commonParent.getBytes$okio(), DOT) || Intrinsics.areEqual($this$commonParent.getBytes$okio(), SLASH) || Intrinsics.areEqual($this$commonParent.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot($this$commonParent)) {
            return null;
        }
        int lastSlash = getIndexOfLastSlash($this$commonParent);
        if (lastSlash != 2 || $this$commonParent.volumeLetter() == null) {
            if (lastSlash == 1 && $this$commonParent.getBytes$okio().startsWith(BACKSLASH)) {
                return null;
            }
            if (lastSlash != -1 || $this$commonParent.volumeLetter() == null) {
                if (lastSlash == -1) {
                    return new Path(DOT);
                }
                if (lastSlash == 0) {
                    return new Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, 1, 1, null));
                }
                return new Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, lastSlash, 1, null));
            } else if ($this$commonParent.getBytes$okio().size() == 2) {
                return null;
            } else {
                return new Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, 2, 1, null));
            }
        } else if ($this$commonParent.getBytes$okio().size() == 3) {
            return null;
        } else {
            return new Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, 3, 1, null));
        }
    }

    public static final boolean lastSegmentIsDotDot(Path $this$lastSegmentIsDotDot) {
        if ($this$lastSegmentIsDotDot.getBytes$okio().endsWith(DOT_DOT)) {
            return $this$lastSegmentIsDotDot.getBytes$okio().size() == 2 || $this$lastSegmentIsDotDot.getBytes$okio().rangeEquals($this$lastSegmentIsDotDot.getBytes$okio().size() - 3, SLASH, 0, 1) || $this$lastSegmentIsDotDot.getBytes$okio().rangeEquals($this$lastSegmentIsDotDot.getBytes$okio().size() - 3, BACKSLASH, 0, 1);
        }
        return false;
    }

    public static final boolean commonIsRoot(@NotNull Path $this$commonIsRoot) {
        Intrinsics.checkNotNullParameter($this$commonIsRoot, "<this>");
        return rootLength($this$commonIsRoot) == $this$commonIsRoot.getBytes$okio().size();
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path $this$commonResolve, @NotNull String child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve($this$commonResolve, toPath(new Buffer().writeUtf8(child), false), normalize);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path $this$commonResolve, @NotNull ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve($this$commonResolve, toPath(new Buffer().write(child), false), normalize);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path $this$commonResolve, @NotNull Buffer child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve($this$commonResolve, toPath(child, false), normalize);
    }

    @NotNull
    public static final Path commonResolve(@NotNull Path $this$commonResolve, @NotNull Path child, boolean normalize) {
        ByteString slash;
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash2 = getSlash($this$commonResolve);
        if (slash2 == null) {
            ByteString slash3 = getSlash(child);
            slash = slash3 == null ? toSlash(Path.DIRECTORY_SEPARATOR) : slash3;
        } else {
            slash = slash2;
        }
        Buffer buffer = new Buffer();
        buffer.write($this$commonResolve.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes$okio());
        return toPath(buffer, normalize);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x01ab A[LOOP:2: B:39:0x01ab->B:40:0x01cf, LOOP_START, PHI: r15 
      PHI: (r15v5 'i' int) = (r15v4 'i' int), (r15v6 'i' int) binds: [B:38:0x01a8, B:40:0x01cf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x01d2  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.Path commonRelativeTo(@org.jetbrains.annotations.NotNull okio.Path r6, @org.jetbrains.annotations.NotNull okio.Path r7) {
        /*
        // Method dump skipped, instructions count: 473
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.commonRelativeTo(okio.Path, okio.Path):okio.Path");
    }

    @NotNull
    public static final Path commonNormalized(@NotNull Path $this$commonNormalized) {
        Intrinsics.checkNotNullParameter($this$commonNormalized, "<this>");
        return Path.Companion.get($this$commonNormalized.toString(), true);
    }

    public static final ByteString getSlash(Path $this$slash) {
        if (ByteString.indexOf$default($this$slash.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1) {
            return SLASH;
        }
        if (ByteString.indexOf$default($this$slash.getBytes$okio(), BACKSLASH, 0, 2, (Object) null) != -1) {
            return BACKSLASH;
        }
        return null;
    }

    public static final int commonCompareTo(@NotNull Path $this$commonCompareTo, @NotNull Path other) {
        Intrinsics.checkNotNullParameter($this$commonCompareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$commonCompareTo.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(@NotNull Path $this$commonEquals, @Nullable Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        return (other instanceof Path) && Intrinsics.areEqual(((Path) other).getBytes$okio(), $this$commonEquals.getBytes$okio());
    }

    public static final int commonHashCode(@NotNull Path $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        return $this$commonHashCode.getBytes$okio().hashCode();
    }

    @NotNull
    public static final String commonToString(@NotNull Path $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return $this$commonToString.getBytes$okio().utf8();
    }

    @NotNull
    public static final Path commonToPath(@NotNull String $this$commonToPath, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonToPath, "<this>");
        return toPath(new Buffer().writeUtf8($this$commonToPath), normalize);
    }

    /* JADX WARNING: Removed duplicated region for block: B:82:0x020b  */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final okio.Path toPath(@org.jetbrains.annotations.NotNull okio.Buffer r5, boolean r6) {
        /*
        // Method dump skipped, instructions count: 543
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._PathKt.toPath(okio.Buffer, boolean):okio.Path");
    }

    public static final ByteString toSlash(String $this$toSlash) {
        if (Intrinsics.areEqual($this$toSlash, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual($this$toSlash, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", $this$toSlash));
    }

    private static final ByteString toSlash(byte $this$toSlash) {
        if ($this$toSlash == 47) {
            return SLASH;
        }
        if ($this$toSlash == 92) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus("not a directory separator: ", Byte.valueOf($this$toSlash)));
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer $this$startsWithVolumeLetterAndColon, ByteString slash) {
        if (!Intrinsics.areEqual(slash, BACKSLASH) || $this$startsWithVolumeLetterAndColon.size() < 2 || $this$startsWithVolumeLetterAndColon.getByte(1) != ((byte) 58)) {
            return false;
        }
        char b = (char) $this$startsWithVolumeLetterAndColon.getByte(0);
        if (!('a' <= b ? b <= 'z' : false)) {
            if (!('A' <= b ? b <= 'Z' : false)) {
                return false;
            }
        }
        return true;
    }
}
