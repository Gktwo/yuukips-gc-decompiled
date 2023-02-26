package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;
import java.util.jar.Manifest;
import org.eclipse.jetty.util.C5739IO;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/JarResource.class */
public class JarResource extends URLResource {
    private static final Logger LOG = Log.getLogger(JarResource.class);
    protected JarURLConnection _jarConnection;

    /* access modifiers changed from: protected */
    public JarResource(URL url) {
        super(url, null);
    }

    /* access modifiers changed from: protected */
    public JarResource(URL url, boolean useCaches) {
        super(url, null, useCaches);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this._jarConnection = null;
        close();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.resource.URLResource
    public synchronized boolean checkConnection() {
        checkConnection();
        try {
            if (this._jarConnection != this._connection) {
                newConnection();
            }
        } catch (IOException e) {
            LOG.ignore(e);
            this._jarConnection = null;
        }
        return this._jarConnection != null;
    }

    /* access modifiers changed from: protected */
    public void newConnection() throws IOException {
        this._jarConnection = (JarURLConnection) this._connection;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        if (this._urlString.endsWith("!/")) {
            return checkConnection();
        }
        return exists();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        checkConnection();
        if (!this._urlString.endsWith("!/")) {
            return new FilterInputStream(getInputStream(false)) { // from class: org.eclipse.jetty.util.resource.JarResource.1
                @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
                public void close() {
                    this.in = C5739IO.getClosedStream();
                }
            };
        }
        return new URL(this._urlString.substring(4, this._urlString.length() - 2)).openStream();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public void copyTo(File directory) throws IOException {
        Manifest manifest;
        OutputStream fout;
        boolean shouldExtract;
        if (exists()) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Extract " + this + " to " + directory, new Object[0]);
            }
            String urlString = getURL().toExternalForm().trim();
            int endOfJarUrl = urlString.indexOf("!/");
            int startOfJarUrl = endOfJarUrl >= 0 ? 4 : 0;
            if (endOfJarUrl < 0) {
                throw new IOException("Not a valid jar url: " + urlString);
            }
            URL jarFileURL = new URL(urlString.substring(startOfJarUrl, endOfJarUrl));
            String subEntryName = endOfJarUrl + 2 < urlString.length() ? urlString.substring(endOfJarUrl + 2) : null;
            boolean subEntryIsDir = subEntryName != null && subEntryName.endsWith("/");
            if (LOG.isDebugEnabled()) {
                LOG.debug("Extracting entry = " + subEntryName + " from jar " + jarFileURL, new Object[0]);
            }
            URLConnection c = jarFileURL.openConnection();
            c.setUseCaches(false);
            InputStream is = c.getInputStream();
            try {
                JarInputStream jin = new JarInputStream(is);
                while (true) {
                    JarEntry entry = jin.getNextJarEntry();
                    if (entry == null) {
                        break;
                    }
                    String entryName = entry.getName();
                    if (subEntryName == null || !entryName.startsWith(subEntryName)) {
                        shouldExtract = subEntryName == null || entryName.startsWith(subEntryName);
                    } else {
                        if (!subEntryIsDir && subEntryName.length() + 1 == entryName.length() && entryName.endsWith("/")) {
                            subEntryIsDir = true;
                        }
                        if (subEntryIsDir) {
                            entryName = entryName.substring(subEntryName.length());
                            shouldExtract = !entryName.equals("");
                        } else {
                            shouldExtract = true;
                        }
                    }
                    if (!shouldExtract) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Skipping entry: " + entryName, new Object[0]);
                        }
                    } else if (URIUtil.canonicalPath(StringUtil.replace(entryName, '\\', '/')) != null) {
                        File file = new File(directory, entryName);
                        if (!entry.isDirectory()) {
                            File dir = new File(file.getParent());
                            if (!dir.exists()) {
                                dir.mkdirs();
                            }
                            fout = new FileOutputStream(file);
                            try {
                                C5739IO.copy(jin, fout);
                                fout.close();
                                if (entry.getTime() >= 0) {
                                    file.setLastModified(entry.getTime());
                                }
                            } finally {
                            }
                        } else if (!file.exists()) {
                            file.mkdirs();
                        }
                    } else if (LOG.isDebugEnabled()) {
                        LOG.debug("Invalid entry: " + entryName, new Object[0]);
                    }
                }
                if ((subEntryName == null || (subEntryName != null && subEntryName.equalsIgnoreCase("META-INF/MANIFEST.MF"))) && (manifest = jin.getManifest()) != null) {
                    File metaInf = new File(directory, "META-INF");
                    metaInf.mkdir();
                    fout = new FileOutputStream(new File(metaInf, "MANIFEST.MF"));
                    try {
                        manifest.write(fout);
                        fout.close();
                    } finally {
                    }
                }
                jin.close();
                if (is != null) {
                    is.close();
                }
            } catch (Throwable th) {
                if (is != null) {
                    try {
                        is.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    public static Resource newJarResource(Resource resource) throws IOException {
        if (resource instanceof JarResource) {
            return resource;
        }
        return Resource.newResource(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX + resource + "!/");
    }
}
