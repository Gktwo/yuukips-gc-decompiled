package okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.implementation.auxiliary.TypeProxy;
import okio.Path;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;

/* compiled from: NioSystemFileSystem.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��4\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0010H\u0002¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, m373d2 = {"Lokio/NioSystemFileSystem;", "Lokio/JvmSystemFileSystem;", "()V", "atomicMove", "", "source", "Lokio/Path;", TypeProxy.INSTANCE_FIELD, "createSymlink", "metadataOrNull", "Lokio/FileMetadata;", "path", Printer.TO_STRING, "", "zeroToNull", "", "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "okio"})
@IgnoreJRERequirement
/* loaded from: grasscutter.jar:okio/NioSystemFileSystem.class */
public final class NioSystemFileSystem extends JvmSystemFileSystem {
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    @Nullable
    public FileMetadata metadataOrNull(@NotNull Path path) {
        Path symlinkTarget;
        Intrinsics.checkNotNullParameter(path, "path");
        Path nioPath = path.toNioPath();
        try {
            BasicFileAttributes attributes = Files.readAttributes(nioPath, BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            if (attributes.isSymbolicLink()) {
                symlinkTarget = Files.readSymbolicLink(nioPath);
            } else {
                symlinkTarget = null;
            }
            boolean isRegularFile = attributes.isRegularFile();
            boolean isDirectory = attributes.isDirectory();
            Path path2 = symlinkTarget == null ? null : Path.Companion.get$default(Path.Companion, symlinkTarget, false, 1, (Object) null);
            Long valueOf = Long.valueOf(attributes.size());
            FileTime creationTime = attributes.creationTime();
            Long zeroToNull = creationTime == null ? null : zeroToNull(creationTime);
            FileTime lastModifiedTime = attributes.lastModifiedTime();
            Long zeroToNull2 = lastModifiedTime == null ? null : zeroToNull(lastModifiedTime);
            FileTime lastAccessTime = attributes.lastAccessTime();
            return new FileMetadata(isRegularFile, isDirectory, path2, valueOf, zeroToNull, zeroToNull2, lastAccessTime == null ? null : zeroToNull(lastAccessTime), null, 128, null);
        } catch (NoSuchFileException e) {
            return null;
        } catch (FileSystemException e2) {
            return null;
        }
    }

    private final Long zeroToNull(FileTime $this$zeroToNull) {
        Long valueOf = Long.valueOf($this$zeroToNull.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        try {
            Files.move(source.toNioPath(), target.toNioPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException e) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e2) {
            throw new FileNotFoundException(e2.getMessage());
        }
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(@NotNull Path source, @NotNull Path target) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, TypeProxy.INSTANCE_FIELD);
        Files.createSymbolicLink(source.toNioPath(), target.toNioPath(), new FileAttribute[0]);
    }

    @Override // okio.JvmSystemFileSystem
    @NotNull
    public String toString() {
        return "NioSystemFileSystem";
    }
}
