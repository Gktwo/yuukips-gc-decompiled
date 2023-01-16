package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/EmptyResource.class */
public class EmptyResource extends Resource {
    public static final Resource INSTANCE = new EmptyResource();

    private EmptyResource() {
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource r) throws MalformedURLException {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        return 0;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long length() {
        return 0;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getURL() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String getName() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource dest) throws SecurityException {
        return false;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String path) throws IOException {
        return null;
    }
}
