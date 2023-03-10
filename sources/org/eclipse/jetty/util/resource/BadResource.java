package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/BadResource.class */
public class BadResource extends URLResource {
    private String _message;

    /* access modifiers changed from: package-private */
    public BadResource(URL url, String message) {
        super(url, null);
        this._message = null;
        this._message = message;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        return -1;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long length() {
        return -1;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public File getFile() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        throw new FileNotFoundException(this._message);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        throw new SecurityException(this._message);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource dest) throws SecurityException {
        throw new SecurityException(this._message);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public void copyTo(File destination) throws IOException {
        throw new SecurityException(this._message);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, java.lang.Object
    public String toString() {
        return toString() + "; BadResource=" + this._message;
    }
}
