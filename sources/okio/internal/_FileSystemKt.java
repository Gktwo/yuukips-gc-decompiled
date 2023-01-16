package okio.internal;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.ArrayDeque;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Path;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: -FileSystem.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 2, m369xi = 48, m374d1 = {"��4\n��\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aI\u0010��\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00072\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH@ø\u0001��¢\u0006\u0002\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H��\u001a\u001c\u0010\u0010\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\nH��\u001a\u001c\u0010\u0013\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\nH��\u001a\u0014\u0010\u0016\u001a\u00020\n*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H��\u001a\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018*\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH��\u001a\u0014\u0010\u0019\u001a\u00020\u001a*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H��\u001a\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u0003*\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H��\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, m373d2 = {"collectRecursively", "", "Lkotlin/sequences/SequenceScope;", "Lokio/Path;", "fileSystem", "Lokio/FileSystem;", "stack", "Lkotlin/collections/ArrayDeque;", "path", "followSymlinks", "", "postorder", "(Lkotlin/sequences/SequenceScope;Lokio/FileSystem;Lkotlin/collections/ArrayDeque;Lokio/Path;ZZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "commonCopy", "source", TypeProxy.INSTANCE_FIELD, "commonCreateDirectories", "dir", "mustCreate", "commonDeleteRecursively", "fileOrDirectory", "mustExist", "commonExists", "commonListRecursively", "Lkotlin/sequences/Sequence;", "commonMetadata", "Lokio/FileMetadata;", "symlinkTarget", "okio"})
/* loaded from: grasscutter.jar:okio/internal/_FileSystemKt.class */
public final class _FileSystemKt {
    @NotNull
    public static final FileMetadata commonMetadata(@NotNull FileSystem $this$commonMetadata, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonMetadata, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = $this$commonMetadata.metadataOrNull(path);
        if (metadataOrNull != null) {
            return metadataOrNull;
        }
        throw new FileNotFoundException(Intrinsics.stringPlus("no such file: ", path));
    }

    public static final boolean commonExists(@NotNull FileSystem $this$commonExists, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonExists, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        return $this$commonExists.metadataOrNull(path) != null;
    }

    public static final void commonCreateDirectories(@NotNull FileSystem $this$commonCreateDirectories, @NotNull Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonCreateDirectories, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        ArrayDeque directories = new ArrayDeque();
        Path path = dir;
        while (path != null && !$this$commonCreateDirectories.exists(path)) {
            directories.addFirst(path);
            path = path.parent();
        }
        if (!mustCreate || !directories.isEmpty()) {
            Iterator it = directories.iterator();
            while (it.hasNext()) {
                $this$commonCreateDirectories.createDirectory((Path) it.next());
            }
            return;
        }
        throw new IOException(dir + " already exist.");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:5:0x0060
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static final void commonCopy(@org.jetbrains.annotations.NotNull okio.FileSystem r3, @org.jetbrains.annotations.NotNull okio.Path r4, @org.jetbrains.annotations.NotNull okio.Path r5) throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 240
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }

    public static final void commonDeleteRecursively(@NotNull FileSystem $this$commonDeleteRecursively, @NotNull Path fileOrDirectory, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonDeleteRecursively, "<this>");
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        Iterator iterator = SequencesKt.sequence(new _FileSystemKt$commonDeleteRecursively$sequence$1($this$commonDeleteRecursively, fileOrDirectory, null)).iterator();
        while (iterator.hasNext()) {
            $this$commonDeleteRecursively.delete((Path) iterator.next(), mustExist && !iterator.hasNext());
        }
    }

    @NotNull
    public static final Sequence<Path> commonListRecursively(@NotNull FileSystem $this$commonListRecursively, @NotNull Path dir, boolean followSymlinks) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonListRecursively, "<this>");
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.sequence(new _FileSystemKt$commonListRecursively$1(dir, $this$commonListRecursively, followSymlinks, null));
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00f9  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0115  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0182 A[Catch: all -> 0x0238, TryCatch #0 {all -> 0x0238, blocks: (B:41:0x016e, B:42:0x0178, B:44:0x0182, B:52:0x01a7, B:58:0x0224), top: B:79:0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01e8  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x027b  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0287  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x028b  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object collectRecursively(@org.jetbrains.annotations.NotNull kotlin.sequences.SequenceScope<? super okio.Path> r10, @org.jetbrains.annotations.NotNull okio.FileSystem r11, @org.jetbrains.annotations.NotNull kotlin.collections.ArrayDeque<okio.Path> r12, @org.jetbrains.annotations.NotNull okio.Path r13, boolean r14, boolean r15, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r16) {
        /*
        // Method dump skipped, instructions count: 662
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal._FileSystemKt.collectRecursively(kotlin.sequences.SequenceScope, okio.FileSystem, kotlin.collections.ArrayDeque, okio.Path, boolean, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public static final Path symlinkTarget(@NotNull FileSystem $this$symlinkTarget, @NotNull Path path) throws IOException {
        Intrinsics.checkNotNullParameter($this$symlinkTarget, "<this>");
        Intrinsics.checkNotNullParameter(path, "path");
        Path target = $this$symlinkTarget.metadata(path).getSymlinkTarget();
        if (target == null) {
            return null;
        }
        Path parent = path.parent();
        Intrinsics.checkNotNull(parent);
        return parent.resolve(target);
    }
}
