package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.ReadableByteChannel;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/URLResource.class */
public class URLResource extends Resource {
    private static final Logger LOG = Log.getLogger(URLResource.class);
    protected final URL _url;
    protected final String _urlString;
    protected URLConnection _connection;
    protected InputStream _in;
    transient boolean _useCaches;

    /* access modifiers changed from: protected */
    public URLResource(URL url, URLConnection connection) {
        this._in = null;
        this._useCaches = Resource.__defaultUseCaches;
        this._url = url;
        this._urlString = this._url.toExternalForm();
        this._connection = connection;
    }

    /* access modifiers changed from: protected */
    public URLResource(URL url, URLConnection connection, boolean useCaches) {
        this(url, connection);
        this._useCaches = useCaches;
    }

    /* access modifiers changed from: protected */
    public synchronized boolean checkConnection() {
        if (this._connection == null) {
            try {
                this._connection = this._url.openConnection();
                this._connection.setUseCaches(this._useCaches);
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
        return this._connection != null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this._in != null) {
            try {
                this._in.close();
            } catch (IOException e) {
                LOG.ignore(e);
            }
            this._in = null;
        }
        if (this._connection != null) {
            this._connection = null;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        try {
            synchronized (this) {
                if (checkConnection() && this._in == null) {
                    this._in = this._connection.getInputStream();
                }
            }
        } catch (IOException e) {
            LOG.ignore(e);
        }
        return this._in != null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return exists() && this._urlString.endsWith("/");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        if (checkConnection()) {
            return this._connection.getLastModified();
        }
        return -1;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long length() {
        if (checkConnection()) {
            return (long) this._connection.getContentLength();
        }
        return -1;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getURL() {
        return this._url;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String getName() {
        return this._url.toExternalForm();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public synchronized InputStream getInputStream() throws IOException {
        return getInputStream(true);
    }

    protected synchronized InputStream getInputStream(boolean resetConnection) throws IOException {
        if (!checkConnection()) {
            throw new IOException("Invalid resource");
        }
        try {
            if (this._in != null) {
                InputStream in = this._in;
                this._in = null;
                if (resetConnection) {
                    this._connection = null;
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Connection nulled", new Object[0]);
                    }
                }
                return in;
            }
            InputStream inputStream = this._connection.getInputStream();
            if (resetConnection) {
                this._connection = null;
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Connection nulled", new Object[0]);
                }
            }
            return inputStream;
        } catch (Throwable th) {
            if (resetConnection) {
                this._connection = null;
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Connection nulled", new Object[0]);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        throw new SecurityException("Delete not supported");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource dest) throws SecurityException {
        throw new SecurityException("RenameTo not supported");
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String path) throws IOException {
        if (URIUtil.canonicalPath(path) != null) {
            return newResource(URIUtil.addEncodedPaths(this._url.toExternalForm(), URIUtil.encodePath(path)), this._useCaches);
        }
        throw new MalformedURLException(path);
    }

    @Override // java.lang.Object
    public String toString() {
        return this._urlString;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this._urlString.hashCode();
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        return (o instanceof URLResource) && this._urlString.equals(((URLResource) o)._urlString);
    }

    public boolean getUseCaches() {
        return this._useCaches;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource containingResource) throws MalformedURLException {
        return false;
    }
}
