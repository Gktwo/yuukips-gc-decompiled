package com.google.common.p004io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.p004io.ByteSource;
import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.charset.Charset;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

@Beta
@GwtIncompatible
/* renamed from: com.google.common.io.MoreFiles */
/* loaded from: grasscutter.jar:com/google/common/io/MoreFiles.class */
public final class MoreFiles {
    private static final SuccessorsFunction<Path> FILE_TREE = new SuccessorsFunction<Path>() { // from class: com.google.common.io.MoreFiles.1
        public Iterable<Path> successors(Path path) {
            return MoreFiles.fileTreeChildren(path);
        }
    };

    private MoreFiles() {
    }

    public static ByteSource asByteSource(Path path, OpenOption... options) {
        return new PathByteSource(path, options);
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.MoreFiles$PathByteSource */
    /* loaded from: grasscutter.jar:com/google/common/io/MoreFiles$PathByteSource.class */
    public static final class PathByteSource extends ByteSource {
        private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
        private final Path path;
        private final OpenOption[] options;
        private final boolean followLinks;

        private PathByteSource(Path path, OpenOption... options) {
            this.path = (Path) Preconditions.checkNotNull(path);
            this.options = (OpenOption[]) options.clone();
            this.followLinks = followLinks(this.options);
        }

        private static boolean followLinks(OpenOption[] options) {
            for (OpenOption option : options) {
                if (option == LinkOption.NOFOLLOW_LINKS) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.p004io.ByteSource
        public InputStream openStream() throws IOException {
            return Files.newInputStream(this.path, this.options);
        }

        private BasicFileAttributes readAttributes() throws IOException {
            return Files.readAttributes(this.path, BasicFileAttributes.class, this.followLinks ? FOLLOW_LINKS : new LinkOption[]{LinkOption.NOFOLLOW_LINKS});
        }

        @Override // com.google.common.p004io.ByteSource
        public Optional<Long> sizeIfKnown() {
            try {
                BasicFileAttributes attrs = readAttributes();
                if (attrs.isDirectory() || attrs.isSymbolicLink()) {
                    return Optional.absent();
                }
                return Optional.m1463of(Long.valueOf(attrs.size()));
            } catch (IOException e) {
                return Optional.absent();
            }
        }

        @Override // com.google.common.p004io.ByteSource
        public long size() throws IOException {
            BasicFileAttributes attrs = readAttributes();
            if (attrs.isDirectory()) {
                throw new IOException("can't read: is a directory");
            } else if (!attrs.isSymbolicLink()) {
                return attrs.size();
            } else {
                throw new IOException("can't read: is a symbolic link");
            }
        }

        @Override // com.google.common.p004io.ByteSource
        public byte[] read() throws IOException {
            SeekableByteChannel channel = Files.newByteChannel(this.path, this.options);
            Throwable th = null;
            try {
                byte[] byteArray = ByteStreams.toByteArray(Channels.newInputStream(channel), channel.size());
                if (channel != null) {
                    if (0 != 0) {
                        try {
                            channel.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        channel.close();
                    }
                }
                return byteArray;
            } catch (Throwable th3) {
                if (channel != null) {
                    if (0 != 0) {
                        try {
                            channel.close();
                        } catch (Throwable th4) {
                            th.addSuppressed(th4);
                        }
                    } else {
                        channel.close();
                    }
                }
                throw th3;
            }
        }

        @Override // com.google.common.p004io.ByteSource
        public CharSource asCharSource(Charset charset) {
            if (this.options.length == 0) {
                return new ByteSource.AsCharSource(charset) { // from class: com.google.common.io.MoreFiles.PathByteSource.1
                    @Override // com.google.common.p004io.CharSource
                    public Stream<String> lines() throws IOException {
                        return Files.lines(PathByteSource.this.path, this.charset);
                    }
                };
            }
            return asCharSource(charset);
        }

        public String toString() {
            return "MoreFiles.asByteSource(" + this.path + ", " + Arrays.toString(this.options) + ")";
        }
    }

    public static ByteSink asByteSink(Path path, OpenOption... options) {
        return new PathByteSink(path, options);
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.io.MoreFiles$PathByteSink */
    /* loaded from: grasscutter.jar:com/google/common/io/MoreFiles$PathByteSink.class */
    public static final class PathByteSink extends ByteSink {
        private final Path path;
        private final OpenOption[] options;

        private PathByteSink(Path path, OpenOption... options) {
            this.path = (Path) Preconditions.checkNotNull(path);
            this.options = (OpenOption[]) options.clone();
        }

        @Override // com.google.common.p004io.ByteSink
        public OutputStream openStream() throws IOException {
            return Files.newOutputStream(this.path, this.options);
        }

        public String toString() {
            return "MoreFiles.asByteSink(" + this.path + ", " + Arrays.toString(this.options) + ")";
        }
    }

    public static CharSource asCharSource(Path path, Charset charset, OpenOption... options) {
        return asByteSource(path, options).asCharSource(charset);
    }

    public static CharSink asCharSink(Path path, Charset charset, OpenOption... options) {
        return asByteSink(path, options).asCharSink(charset);
    }

    public static ImmutableList<Path> listFiles(Path dir) throws IOException {
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(dir);
            ImmutableList<Path> copyOf = ImmutableList.copyOf(stream);
            if (stream != null) {
                if (0 != 0) {
                    stream.close();
                } else {
                    stream.close();
                }
            }
            return copyOf;
        } catch (DirectoryIteratorException e) {
            throw e.getCause();
        }
    }

    public static Traverser<Path> fileTraverser() {
        return Traverser.forTree(FILE_TREE);
    }

    /* access modifiers changed from: private */
    public static Iterable<Path> fileTreeChildren(Path dir) {
        if (!Files.isDirectory(dir, LinkOption.NOFOLLOW_LINKS)) {
            return ImmutableList.m1438of();
        }
        try {
            return listFiles(dir);
        } catch (IOException e) {
            throw new DirectoryIteratorException(e);
        }
    }

    public static Predicate<Path> isDirectory(LinkOption... options) {
        final LinkOption[] optionsCopy = (LinkOption[]) options.clone();
        return new Predicate<Path>() { // from class: com.google.common.io.MoreFiles.2
            public boolean apply(Path input) {
                return Files.isDirectory(input, optionsCopy);
            }

            @Override // java.lang.Object
            public String toString() {
                return "MoreFiles.isDirectory(" + Arrays.toString(optionsCopy) + ")";
            }
        };
    }

    private static boolean isDirectory(SecureDirectoryStream<Path> dir, Path name, LinkOption... options) throws IOException {
        return ((BasicFileAttributeView) dir.getFileAttributeView(name, BasicFileAttributeView.class, options)).readAttributes().isDirectory();
    }

    public static Predicate<Path> isRegularFile(LinkOption... options) {
        final LinkOption[] optionsCopy = (LinkOption[]) options.clone();
        return new Predicate<Path>() { // from class: com.google.common.io.MoreFiles.3
            public boolean apply(Path input) {
                return Files.isRegularFile(input, optionsCopy);
            }

            @Override // java.lang.Object
            public String toString() {
                return "MoreFiles.isRegularFile(" + Arrays.toString(optionsCopy) + ")";
            }
        };
    }

    public static boolean equal(Path path1, Path path2) throws IOException {
        Preconditions.checkNotNull(path1);
        Preconditions.checkNotNull(path2);
        if (Files.isSameFile(path1, path2)) {
            return true;
        }
        ByteSource source1 = asByteSource(path1, new OpenOption[0]);
        ByteSource source2 = asByteSource(path2, new OpenOption[0]);
        long len1 = source1.sizeIfKnown().mo1456or((Optional<Long>) 0L).longValue();
        long len2 = source2.sizeIfKnown().mo1456or((Optional<Long>) 0L).longValue();
        if (len1 == 0 || len2 == 0 || len1 == len2) {
            return source1.contentEquals(source2);
        }
        return false;
    }

    public static void touch(Path path) throws IOException {
        Preconditions.checkNotNull(path);
        try {
            Files.setLastModifiedTime(path, FileTime.fromMillis(System.currentTimeMillis()));
        } catch (NoSuchFileException e) {
            try {
                Files.createFile(path, new FileAttribute[0]);
            } catch (FileAlreadyExistsException e2) {
            }
        }
    }

    public static void createParentDirectories(Path path, FileAttribute<?>... attrs) throws IOException {
        Path parent = path.toAbsolutePath().normalize().getParent();
        if (parent != null && !Files.isDirectory(parent, new LinkOption[0])) {
            Files.createDirectories(parent, attrs);
            if (!Files.isDirectory(parent, new LinkOption[0])) {
                throw new IOException("Unable to create parent directories of " + path);
            }
        }
    }

    public static String getFileExtension(Path path) {
        String fileName;
        int dotIndex;
        Path name = path.getFileName();
        return (name == null || (dotIndex = (fileName = name.toString()).lastIndexOf(46)) == -1) ? "" : fileName.substring(dotIndex + 1);
    }

    public static String getNameWithoutExtension(Path path) {
        Path name = path.getFileName();
        if (name == null) {
            return "";
        }
        String fileName = name.toString();
        int dotIndex = fileName.lastIndexOf(46);
        return dotIndex == -1 ? fileName : fileName.substring(0, dotIndex);
    }

    public static void deleteRecursively(Path path, RecursiveDeleteOption... options) throws IOException {
        Path parentPath = getParentPath(path);
        if (parentPath == null) {
            throw new FileSystemException(path.toString(), null, "can't delete recursively");
        }
        Collection<IOException> exceptions = null;
        try {
            boolean sdsSupported = false;
            DirectoryStream<Path> parent = Files.newDirectoryStream(parentPath);
            if (parent instanceof SecureDirectoryStream) {
                sdsSupported = true;
                exceptions = deleteRecursivelySecure((SecureDirectoryStream) parent, path.getFileName());
            }
            if (parent != null) {
                if (0 != 0) {
                    parent.close();
                } else {
                    parent.close();
                }
            }
            if (!sdsSupported) {
                checkAllowsInsecure(path, options);
                exceptions = deleteRecursivelyInsecure(path);
            }
        } catch (IOException e) {
            if (0 == 0) {
                throw e;
            }
            exceptions.add(e);
        }
        if (exceptions != null) {
            throwDeleteFailed(path, exceptions);
        }
    }

    public static void deleteDirectoryContents(Path path, RecursiveDeleteOption... options) throws IOException {
        Collection<IOException> exceptions = null;
        try {
            DirectoryStream<Path> stream = Files.newDirectoryStream(path);
            if (stream instanceof SecureDirectoryStream) {
                exceptions = deleteDirectoryContentsSecure((SecureDirectoryStream) stream);
            } else {
                checkAllowsInsecure(path, options);
                exceptions = deleteDirectoryContentsInsecure(stream);
            }
            if (stream != null) {
                if (0 != 0) {
                    stream.close();
                } else {
                    stream.close();
                }
            }
        } catch (IOException e) {
            if (0 == 0) {
                throw e;
            }
            exceptions.add(e);
        }
        if (exceptions != null) {
            throwDeleteFailed(path, exceptions);
        }
    }

    private static Collection<IOException> deleteRecursivelySecure(SecureDirectoryStream<Path> dir, Path path) {
        Collection<IOException> exceptions = null;
        try {
            if (isDirectory(dir, path, LinkOption.NOFOLLOW_LINKS)) {
                SecureDirectoryStream<Path> childDir = dir.newDirectoryStream(path, LinkOption.NOFOLLOW_LINKS);
                exceptions = deleteDirectoryContentsSecure(childDir);
                if (childDir != null) {
                    if (0 != 0) {
                        childDir.close();
                    } else {
                        childDir.close();
                    }
                }
                if (exceptions == null) {
                    dir.deleteDirectory(path);
                }
            } else {
                dir.deleteFile(path);
            }
            return exceptions;
        } catch (IOException e) {
            return addException(null, e);
        }
    }

    private static Collection<IOException> deleteDirectoryContentsSecure(SecureDirectoryStream<Path> dir) {
        Collection<IOException> exceptions = null;
        try {
            for (Path path : dir) {
                exceptions = concat(exceptions, deleteRecursivelySecure(dir, path.getFileName()));
            }
            return exceptions;
        } catch (DirectoryIteratorException e) {
            return addException(exceptions, e.getCause());
        }
    }

    private static Collection<IOException> deleteRecursivelyInsecure(Path path) {
        Collection<IOException> exceptions = null;
        try {
            if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                DirectoryStream<Path> stream = Files.newDirectoryStream(path);
                exceptions = deleteDirectoryContentsInsecure(stream);
                if (stream != null) {
                    if (0 != 0) {
                        stream.close();
                    } else {
                        stream.close();
                    }
                }
            }
            if (exceptions == null) {
                Files.delete(path);
            }
            return exceptions;
        } catch (IOException e) {
            return addException(null, e);
        }
    }

    private static Collection<IOException> deleteDirectoryContentsInsecure(DirectoryStream<Path> dir) {
        Collection<IOException> exceptions = null;
        try {
            for (Path entry : dir) {
                exceptions = concat(exceptions, deleteRecursivelyInsecure(entry));
            }
            return exceptions;
        } catch (DirectoryIteratorException e) {
            return addException(exceptions, e.getCause());
        }
    }

    private static Path getParentPath(Path path) {
        Path parent = path.getParent();
        if (parent != null) {
            return parent;
        }
        if (path.getNameCount() == 0) {
            return null;
        }
        return path.getFileSystem().getPath(Mapper.IGNORED_FIELDNAME, new String[0]);
    }

    private static void checkAllowsInsecure(Path path, RecursiveDeleteOption[] options) throws InsecureRecursiveDeleteException {
        if (!Arrays.asList(options).contains(RecursiveDeleteOption.ALLOW_INSECURE)) {
            throw new InsecureRecursiveDeleteException(path.toString());
        }
    }

    private static Collection<IOException> addException(Collection<IOException> exceptions, IOException e) {
        if (exceptions == null) {
            exceptions = new ArrayList();
        }
        exceptions.add(e);
        return exceptions;
    }

    private static Collection<IOException> concat(Collection<IOException> exceptions, Collection<IOException> other) {
        if (exceptions == null) {
            return other;
        }
        if (other != null) {
            exceptions.addAll(other);
        }
        return exceptions;
    }

    private static void throwDeleteFailed(Path path, Collection<IOException> exceptions) throws FileSystemException {
        FileSystemException deleteFailed = new FileSystemException(path.toString(), null, "failed to delete one or more files; see suppressed exceptions for details");
        for (IOException e : exceptions) {
            deleteFailed.addSuppressed(e);
        }
        throw deleteFailed;
    }
}
