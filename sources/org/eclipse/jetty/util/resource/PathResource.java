package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/PathResource.class */
public class PathResource extends Resource {
    private static final Logger LOG = Log.getLogger(PathResource.class);
    private static final LinkOption[] NO_FOLLOW_LINKS = {LinkOption.NOFOLLOW_LINKS};
    private static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
    private final Path path;
    private final Path alias;
    private final URI uri;
    private final boolean belongsToDefaultFileSystem;

    private Path checkAliasPath() {
        Path abs = this.path;
        if (!URIUtil.equalsIgnoreEncodings(this.uri, this.path.toUri())) {
            try {
                return Paths.get(this.uri).toRealPath(FOLLOW_LINKS);
            } catch (IOException ignored) {
                LOG.ignore(ignored);
            }
        }
        if (!abs.isAbsolute()) {
            abs = this.path.toAbsolutePath();
        }
        Path normal = this.path.normalize();
        if (!isSameName(abs, normal)) {
            return normal;
        }
        try {
            if (Files.isSymbolicLink(this.path)) {
                return this.path.getParent().resolve(Files.readSymbolicLink(this.path));
            }
            if (!Files.exists(this.path, new LinkOption[0])) {
                return null;
            }
            Path real = abs.toRealPath(FOLLOW_LINKS);
            if (!isSameName(abs, real)) {
                return real;
            }
            return null;
        } catch (IOException e) {
            LOG.ignore(e);
            return null;
        } catch (Exception e2) {
            LOG.warn("bad alias ({} {}) for {}", e2.getClass().getName(), e2.getMessage(), this.path);
            return null;
        }
    }

    public static boolean isSameName(Path pathA, Path pathB) {
        int aCount = pathA.getNameCount();
        int bCount = pathB.getNameCount();
        if (aCount != bCount) {
            return false;
        }
        int i = bCount;
        do {
            i--;
            if (i <= 0) {
                return true;
            }
        } while (pathA.getName(i).toString().equals(pathB.getName(i).toString()));
        return false;
    }

    public PathResource(File file) {
        this(file.toPath());
    }

    public PathResource(Path path) {
        Path absPath = path;
        try {
            absPath = path.toRealPath(NO_FOLLOW_LINKS);
        } catch (IOError | IOException e) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Unable to get real/canonical path for {}", path, e);
            }
        }
        this.path = absPath;
        assertValidPath(path);
        this.uri = this.path.toUri();
        this.alias = checkAliasPath();
        this.belongsToDefaultFileSystem = this.path.getFileSystem() == FileSystems.getDefault();
    }

    private PathResource(PathResource parent, String childPath) {
        this.path = parent.path.getFileSystem().getPath(parent.path.toString(), childPath);
        if (isDirectory() && !childPath.endsWith("/")) {
            childPath = childPath + "/";
        }
        this.uri = URIUtil.addPath(parent.uri, childPath);
        this.alias = checkAliasPath();
        this.belongsToDefaultFileSystem = this.path.getFileSystem() == FileSystems.getDefault();
    }

    public PathResource(URI uri) throws IOException {
        if (!uri.isAbsolute()) {
            throw new IllegalArgumentException("not an absolute uri");
        } else if (!uri.getScheme().equalsIgnoreCase(Action.FILE_ATTRIBUTE)) {
            throw new IllegalArgumentException("not file: scheme");
        } else {
            try {
                Path path = Paths.get(uri);
                this.path = path.toAbsolutePath();
                this.uri = path.toUri();
                this.alias = checkAliasPath();
                this.belongsToDefaultFileSystem = this.path.getFileSystem() == FileSystems.getDefault();
            } catch (IllegalArgumentException e) {
                throw e;
            } catch (Exception e2) {
                LOG.ignore(e2);
                throw new IOException("Unable to build Path from: " + uri, e2);
            }
        }
    }

    public PathResource(URL url) throws IOException, URISyntaxException {
        this(url.toURI());
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isSame(Resource resource) {
        try {
            if (resource instanceof PathResource) {
                return Files.isSameFile(getPath(), ((PathResource) resource).getPath());
            } else if (!(resource instanceof FileResource)) {
                return false;
            } else {
                return Files.isSameFile(getPath(), ((FileResource) resource).getFile().toPath());
            }
        } catch (IOException e) {
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("ignored", e);
            return false;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String subPath) throws IOException {
        if (URIUtil.canonicalPath(subPath) == null) {
            throw new MalformedURLException(subPath);
        } else if ("/".equals(subPath)) {
            return this;
        } else {
            return new PathResource(this, subPath);
        }
    }

    private void assertValidPath(Path path) {
        String str = path.toString();
        int idx = StringUtil.indexOfControlChars(str);
        if (idx >= 0) {
            throw new InvalidPathException(str, "Invalid Character at index " + idx);
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        try {
            return Files.deleteIfExists(this.path);
        } catch (IOException e) {
            LOG.ignore(e);
            return false;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PathResource other = (PathResource) obj;
        if (this.path == null) {
            return other.path == null;
        }
        return this.path.equals(other.path);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        return Files.exists(this.path, NO_FOLLOW_LINKS);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        if (!this.belongsToDefaultFileSystem) {
            return null;
        }
        return this.path.toFile();
    }

    public Path getPath() {
        return this.path;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(this.path, StandardOpenOption.READ);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String getName() {
        return this.path.toAbsolutePath().toString();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return newSeekableByteChannel();
    }

    public SeekableByteChannel newSeekableByteChannel() throws IOException {
        return Files.newByteChannel(this.path, StandardOpenOption.READ);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URI getURI() {
        return this.uri;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getURL() {
        try {
            return this.path.toUri().toURL();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * 1) + (this.path == null ? 0 : this.path.hashCode());
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource r) throws MalformedURLException {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return Files.isDirectory(this.path, FOLLOW_LINKS);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        try {
            return Files.getLastModifiedTime(this.path, FOLLOW_LINKS).toMillis();
        } catch (IOException e) {
            LOG.ignore(e);
            return 0;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long length() {
        try {
            return Files.size(this.path);
        } catch (IOException e) {
            return 0;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isAlias() {
        return this.alias != null;
    }

    public Path getAliasPath() {
        return this.alias;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URI getAlias() {
        if (this.alias == null) {
            return null;
        }
        return this.alias.toUri();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        try {
            DirectoryStream<Path> dir = Files.newDirectoryStream(this.path);
            List<String> entries = new ArrayList<>();
            for (Path entry : dir) {
                try {
                    String name = entry.getFileName().toString();
                    if (Files.isDirectory(entry, new LinkOption[0])) {
                        name = name + "/";
                    }
                    entries.add(name);
                } catch (Throwable th) {
                    if (dir != null) {
                        try {
                            dir.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            }
            String[] strArr = (String[]) entries.toArray(new String[entries.size()]);
            if (dir != null) {
                dir.close();
            }
            return strArr;
        } catch (IOException | DirectoryIteratorException e) {
            LOG.debug(e);
            return null;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource dest) throws SecurityException {
        if (!(dest instanceof PathResource)) {
            return false;
        }
        try {
            return Files.exists(Files.move(this.path, ((PathResource) dest).path, new CopyOption[0]), NO_FOLLOW_LINKS);
        } catch (IOException e) {
            LOG.ignore(e);
            return false;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public void copyTo(File destination) throws IOException {
        if (isDirectory()) {
            C5739IO.copyDir(this.path.toFile(), destination);
        } else {
            Files.copy(this.path, destination.toPath(), new CopyOption[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [long] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARN: Type inference failed for: r13v4 */
    @Override // org.eclipse.jetty.util.resource.Resource
    public void writeTo(OutputStream outputStream, long start, long j) throws IOException {
        char c = j;
        if (j < 0) {
            c = Files.size(this.path) - start;
        }
        SeekableByteChannel channel = Files.newByteChannel(this.path, StandardOpenOption.READ);
        try {
            ByteBuffer buffer = BufferUtil.allocate(65536);
            skipTo(channel, buffer, start);
            char c2 = 0;
            while (c2 < (c == 1 ? 1 : 0)) {
                BufferUtil.clearToFill(buffer);
                buffer.limit((int) Math.min(65536L, c - c2));
                int readLen = channel.read(buffer);
                BufferUtil.flipToFlush(buffer, 0);
                BufferUtil.writeTo(buffer, outputStream);
                c2 += (long) readLen;
            }
            if (channel != null) {
                channel.close();
            }
        } catch (Throwable th) {
            if (channel != null) {
                try {
                    channel.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    private void skipTo(SeekableByteChannel channel, ByteBuffer buffer, long skipTo) throws IOException {
        try {
            if (channel.position() != skipTo) {
                channel.position(skipTo);
            }
        } catch (UnsupportedOperationException e) {
            if (skipTo > 0) {
                char c = 0;
                int noProgressLoopLimit = 3;
                while (noProgressLoopLimit > 0 && c < skipTo) {
                    BufferUtil.clearToFill(buffer);
                    buffer.limit((int) Math.min(65536L, skipTo - c));
                    long readLen = (long) channel.read(buffer);
                    if (readLen == 0) {
                        noProgressLoopLimit--;
                    } else if (readLen > 0) {
                        c += readLen;
                        noProgressLoopLimit = 3;
                    } else {
                        throw new IOException("EOF reached before SeekableByteChannel skip destination");
                    }
                }
                if (noProgressLoopLimit <= 0) {
                    throw new IOException("No progress made to reach SeekableByteChannel skip position " + skipTo);
                }
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return this.uri.toASCIIString();
    }
}
