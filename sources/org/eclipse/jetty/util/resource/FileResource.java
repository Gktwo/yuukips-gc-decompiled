package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.StandardOpenOption;
import java.security.Permission;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/FileResource.class */
public class FileResource extends Resource {
    private static final Logger LOG = Log.getLogger(FileResource.class);
    private final File _file;
    private final URI _uri;
    private final URI _alias;

    public FileResource(URL url) throws IOException, URISyntaxException {
        File file;
        try {
            file = new File(url.toURI());
            assertValidPath(file.toString());
        } catch (URISyntaxException e) {
            throw e;
        } catch (Exception e2) {
            if (!url.toString().startsWith("file:")) {
                throw new IllegalArgumentException("!file:");
            }
            LOG.ignore(e2);
            try {
                URI uri = new URI("file:" + URIUtil.encodePath(url.toString().substring(5)));
                if (uri.getAuthority() == null) {
                    file = new File(uri);
                } else {
                    file = new File("//" + uri.getAuthority() + URIUtil.decodePath(url.getFile()));
                }
            } catch (Exception ex2) {
                LOG.ignore(ex2);
                Permission perm = url.openConnection().getPermission();
                file = new File(perm == null ? url.getFile() : perm.getName());
            }
        }
        this._file = file;
        this._uri = normalizeURI(this._file, url.toURI());
        this._alias = checkFileAlias(this._uri, this._file);
    }

    public FileResource(URI uri) {
        File file = new File(uri);
        this._file = file;
        try {
            URI fileUri = this._file.toURI();
            this._uri = normalizeURI(this._file, uri);
            assertValidPath(file.toString());
            if (!URIUtil.equalsIgnoreEncodings(this._uri.toASCIIString(), fileUri.toString())) {
                this._alias = this._file.toURI();
            } else {
                this._alias = checkFileAlias(this._uri, this._file);
            }
        } catch (URISyntaxException e) {
            throw new InvalidPathException(this._file.toString(), e.getMessage()) { // from class: org.eclipse.jetty.util.resource.FileResource.1
                {
                    initCause(e);
                }
            };
        }
    }

    public FileResource(File file) {
        assertValidPath(file.toString());
        this._file = file;
        try {
            this._uri = normalizeURI(this._file, this._file.toURI());
            this._alias = checkFileAlias(this._uri, this._file);
        } catch (URISyntaxException e) {
            throw new InvalidPathException(this._file.toString(), e.getMessage()) { // from class: org.eclipse.jetty.util.resource.FileResource.2
                {
                    initCause(e);
                }
            };
        }
    }

    public FileResource(File base, String childPath) {
        URI uri;
        String encoded = URIUtil.encodePath(childPath);
        this._file = new File(base, childPath);
        try {
            if (base.isDirectory()) {
                uri = new URI(URIUtil.addEncodedPaths(base.toURI().toASCIIString(), encoded));
            } else {
                uri = new URI(base.toURI().toASCIIString() + encoded);
            }
            this._uri = uri;
            this._alias = checkFileAlias(this._uri, this._file);
        } catch (URISyntaxException e) {
            throw new InvalidPathException(base.toString() + childPath, e.getMessage()) { // from class: org.eclipse.jetty.util.resource.FileResource.3
                {
                    initCause(e);
                }
            };
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isSame(Resource resource) {
        try {
            if (resource instanceof PathResource) {
                return Files.isSameFile(getFile().toPath(), ((PathResource) resource).getPath());
            } else if (!(resource instanceof FileResource)) {
                return false;
            } else {
                return Files.isSameFile(getFile().toPath(), ((FileResource) resource).getFile().toPath());
            }
        } catch (IOException e) {
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("ignored", e);
            return false;
        }
    }

    private static URI normalizeURI(File file, URI uri) throws URISyntaxException {
        String u = uri.toASCIIString();
        if (file.isDirectory()) {
            if (!u.endsWith("/")) {
                u = u + "/";
            }
        } else if (file.exists() && u.endsWith("/")) {
            u = u.substring(0, u.length() - 1);
        }
        return new URI(u);
    }

    private static URI checkFileAlias(URI uri, File file) {
        try {
            if (!URIUtil.equalsIgnoreEncodings(uri, file.toURI())) {
                return new File(uri).getAbsoluteFile().toURI();
            }
            String abs = file.getAbsolutePath();
            String can = file.getCanonicalPath();
            if (abs.equals(can)) {
                return null;
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("ALIAS abs={} can={}", abs, can);
            }
            return new URI("file://" + URIUtil.encodePath(new File(can).toURI().getPath()));
        } catch (Exception e) {
            LOG.warn("bad alias for {}: {}", file, e.toString());
            LOG.debug(e);
            try {
                return new URI("https://eclipse.org/bad/canonical/alias");
            } catch (Exception ex2) {
                LOG.ignore(ex2);
                throw new RuntimeException(e);
            }
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String path) throws IOException {
        assertValidPath(path);
        if (URIUtil.canonicalPath(path) == null) {
            throw new MalformedURLException(path);
        } else if ("/".equals(path)) {
            return this;
        } else {
            return new FileResource(this._file, path);
        }
    }

    private void assertValidPath(String path) {
        int idx = StringUtil.indexOfControlChars(path);
        if (idx >= 0) {
            throw new InvalidPathException(path, "Invalid Character at index " + idx);
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URI getAlias() {
        return this._alias;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        return this._file.exists();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        return this._file.lastModified();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return (this._file.exists() && this._file.isDirectory()) || this._uri.toASCIIString().endsWith("/");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long length() {
        return this._file.length();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String getName() {
        return this._file.getAbsolutePath();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public File getFile() {
        return this._file;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this._file);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return FileChannel.open(this._file.toPath(), StandardOpenOption.READ);
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        return this._file.delete();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource dest) throws SecurityException {
        if (dest instanceof FileResource) {
            return this._file.renameTo(((FileResource) dest)._file);
        }
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        String[] list = this._file.list();
        if (list == null) {
            return null;
        }
        int i = list.length;
        while (true) {
            i--;
            if (i <= 0) {
                return list;
            }
            if (new File(this._file, list[i]).isDirectory() && !list[i].endsWith("/")) {
                list[i] = list[i] + "/";
            }
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (null == o || !(o instanceof FileResource)) {
            return false;
        }
        FileResource f = (FileResource) o;
        return f._file == this._file || (null != this._file && this._file.equals(f._file));
    }

    @Override // java.lang.Object
    public int hashCode() {
        return null == this._file ? hashCode() : this._file.hashCode();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public void copyTo(File destination) throws IOException {
        if (isDirectory()) {
            C5747IO.copyDir(getFile(), destination);
        } else if (destination.exists()) {
            throw new IllegalArgumentException(destination + " exists");
        } else {
            C5747IO.copy(getFile(), destination);
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource r) throws MalformedURLException {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getURL() {
        try {
            return this._uri.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URI getURI() {
        return this._uri;
    }

    @Override // java.lang.Object
    public String toString() {
        return this._uri.toString();
    }
}
