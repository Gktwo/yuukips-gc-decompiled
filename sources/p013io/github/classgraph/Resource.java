package p013io.github.classgraph;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.attribute.PosixFilePermission;
import java.util.Set;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.utils.LogNode;
import nonapi.p019io.github.classgraph.utils.URLPathEncoder;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* renamed from: io.github.classgraph.Resource */
/* loaded from: grasscutter.jar:io/github/classgraph/Resource.class */
public abstract class Resource implements Closeable, Comparable<Resource> {
    private final ClasspathElement classpathElement;
    protected InputStream inputStream;
    protected ByteBuffer byteBuffer;
    protected long length;
    private String toString;
    LogNode scanLog;

    public abstract String getPath();

    public abstract String getPathRelativeToClasspathElement();

    public abstract InputStream open() throws IOException;

    public abstract ByteBuffer read() throws IOException;

    public abstract byte[] load() throws IOException;

    /* access modifiers changed from: package-private */
    public abstract ClassfileReader openClassfile() throws IOException;

    public abstract long getLastModified();

    public abstract Set<PosixFilePermission> getPosixFilePermissions();

    public Resource(ClasspathElement classpathElement, long length) {
        this.classpathElement = classpathElement;
        this.length = length;
    }

    private static URL uriToURL(URI uri) {
        if (uri.getScheme().equals("jrt")) {
            throw new IllegalArgumentException("Could not create URL from URI with \"jrt:\" scheme: " + uri);
        }
        try {
            return uri.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Could not create URL from URI: " + uri + " -- " + e);
        }
    }

    public URI getURI() {
        String locationURIStr = getClasspathElementURI().toString();
        String resourcePath = getPathRelativeToClasspathElement();
        boolean isDir = locationURIStr.endsWith("/");
        try {
            return new URI(((isDir || locationURIStr.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) ? "" : XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX) + locationURIStr + (isDir ? "" : "!/") + URLPathEncoder.encodePath(resourcePath));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException("Could not form URL for classpath element: " + locationURIStr + " ; path: " + resourcePath + " : " + e);
        }
    }

    public URL getURL() {
        return uriToURL(getURI());
    }

    public URI getClasspathElementURI() {
        return this.classpathElement.getURI();
    }

    public URL getClasspathElementURL() {
        return uriToURL(getClasspathElementURI());
    }

    public File getClasspathElementFile() {
        return this.classpathElement.getFile();
    }

    public ModuleRef getModuleRef() {
        if (this.classpathElement instanceof ClasspathElementModule) {
            return ((ClasspathElementModule) this.classpathElement).moduleRef;
        }
        return null;
    }

    public String getContentAsString() throws IOException {
        try {
            return new String(load(), StandardCharsets.UTF_8);
        } finally {
            close();
        }
    }

    public long getLength() {
        return this.length;
    }

    @Override // java.lang.Object
    public String toString() {
        if (this.toString != null) {
            return this.toString;
        }
        String uri = getURI().toString();
        this.toString = uri;
        return uri;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return toString().hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Resource)) {
            return false;
        }
        return toString().equals(obj.toString());
    }

    public int compareTo(Resource o) {
        return toString().compareTo(o.toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.inputStream != null) {
            try {
                this.inputStream.close();
            } catch (IOException e) {
            }
            this.inputStream = null;
        }
    }
}
