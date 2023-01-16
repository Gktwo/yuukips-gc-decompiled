package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.quartz.xml.XMLSchedulingDataProcessor;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/JarFileResource.class */
public class JarFileResource extends JarResource {
    private static final Logger LOG = Log.getLogger(JarFileResource.class);
    private JarFile _jarFile;
    private File _file;
    private String[] _list;
    private JarEntry _entry;
    private boolean _directory;
    private String _jarUrl;
    private String _path;
    private boolean _exists;

    protected JarFileResource(URL url) {
        super(url);
    }

    /* access modifiers changed from: protected */
    public JarFileResource(URL url, boolean useCaches) {
        super(url, useCaches);
    }

    @Override // org.eclipse.jetty.util.resource.JarResource, org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this._exists = false;
        this._list = null;
        this._entry = null;
        this._file = null;
        if (!getUseCaches() && this._jarFile != null) {
            try {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Closing JarFile " + this._jarFile.getName(), new Object[0]);
                }
                this._jarFile.close();
            } catch (IOException ioe) {
                LOG.ignore(ioe);
            }
        }
        this._jarFile = null;
        close();
    }

    @Override // org.eclipse.jetty.util.resource.JarResource, org.eclipse.jetty.util.resource.URLResource
    protected synchronized boolean checkConnection() {
        try {
            checkConnection();
            if (this._jarConnection == null) {
                this._entry = null;
                this._file = null;
                this._jarFile = null;
                this._list = null;
            }
            return this._jarFile != null;
        } catch (Throwable th) {
            if (this._jarConnection == null) {
                this._entry = null;
                this._file = null;
                this._jarFile = null;
                this._list = null;
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.util.resource.JarResource
    protected synchronized void newConnection() throws IOException {
        newConnection();
        this._entry = null;
        this._file = null;
        this._jarFile = null;
        this._list = null;
        int sep = this._urlString.lastIndexOf("!/");
        this._jarUrl = this._urlString.substring(0, sep + 2);
        this._path = URIUtil.decodePath(this._urlString.substring(sep + 2));
        if (this._path.length() == 0) {
            this._path = null;
        }
        this._jarFile = this._jarConnection.getJarFile();
        this._file = new File(this._jarFile.getName());
    }

    @Override // org.eclipse.jetty.util.resource.JarResource, org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        if (this._exists) {
            return true;
        }
        if (this._urlString.endsWith("!/")) {
            try {
                return newResource(this._urlString.substring(4, this._urlString.length() - 2)).exists();
            } catch (Exception e) {
                LOG.ignore(e);
                return false;
            }
        } else {
            boolean check = checkConnection();
            if (this._jarUrl == null || this._path != null) {
                boolean closeJarFile = false;
                JarFile jarFile = null;
                if (check) {
                    jarFile = this._jarFile;
                } else {
                    try {
                        JarURLConnection c = (JarURLConnection) new URL(this._jarUrl).openConnection();
                        c.setUseCaches(getUseCaches());
                        jarFile = c.getJarFile();
                        closeJarFile = !getUseCaches();
                    } catch (Exception e2) {
                        LOG.ignore(e2);
                    }
                }
                if (jarFile != null && this._entry == null && !this._directory) {
                    JarEntry entry = jarFile.getJarEntry(this._path);
                    if (entry == null) {
                        this._exists = false;
                    } else if (entry.isDirectory()) {
                        this._directory = true;
                        this._entry = entry;
                    } else {
                        JarEntry directory = jarFile.getJarEntry(this._path + '/');
                        if (directory != null) {
                            this._directory = true;
                            this._entry = directory;
                        } else {
                            this._directory = false;
                            this._entry = entry;
                        }
                    }
                }
                if (closeJarFile && jarFile != null) {
                    try {
                        jarFile.close();
                    } catch (IOException ioe) {
                        LOG.ignore(ioe);
                    }
                }
                this._exists = this._directory || this._entry != null;
                return this._exists;
            }
            this._directory = check;
            return true;
        }
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        return this._urlString.endsWith("/") || (exists() && this._directory);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        if (!checkConnection() || this._file == null) {
            return -1;
        }
        if (!exists() || this._entry == null) {
            return this._file.lastModified();
        }
        return this._entry.getTime();
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public synchronized String[] list() {
        List<String> list;
        if (isDirectory() && this._list == null) {
            try {
                list = listEntries();
            } catch (Exception e) {
                LOG.warn("Retrying list:" + e, new Object[0]);
                LOG.debug(e);
                close();
                list = listEntries();
            }
            if (list != null) {
                this._list = new String[list.size()];
                list.toArray(this._list);
            }
        }
        return this._list;
    }

    private List<String> listEntries() {
        checkConnection();
        ArrayList<String> list = new ArrayList<>(32);
        JarFile jarFile = this._jarFile;
        if (jarFile == null) {
            try {
                JarURLConnection jc = (JarURLConnection) new URL(this._jarUrl).openConnection();
                jc.setUseCaches(getUseCaches());
                jarFile = jc.getJarFile();
            } catch (Exception e) {
                e.printStackTrace();
                LOG.ignore(e);
            }
            if (jarFile == null) {
                throw new IllegalStateException();
            }
        }
        Enumeration<JarEntry> e2 = jarFile.entries();
        String dir = URIUtil.decodePath(this._urlString.substring(this._urlString.lastIndexOf("!/") + 2));
        while (e2.hasMoreElements()) {
            String name = e2.nextElement().getName();
            if (name.startsWith(dir) && name.length() != dir.length()) {
                String listName = name.substring(dir.length());
                int dash = listName.indexOf(47);
                if (dash >= 0) {
                    if (dash != 0 || listName.length() != 1) {
                        if (dash == 0) {
                            listName = listName.substring(dash + 1);
                        } else {
                            listName = listName.substring(0, dash + 1);
                        }
                        if (list.contains(listName)) {
                        }
                    }
                }
                list.add(listName);
            }
        }
        return list;
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public long length() {
        if (!isDirectory() && this._entry != null) {
            return this._entry.getSize();
        }
        return -1;
    }

    public static Resource getNonCachingResource(Resource resource) {
        if (!(resource instanceof JarFileResource)) {
            return resource;
        }
        return new JarFileResource(((JarFileResource) resource).getURL(), false);
    }

    @Override // org.eclipse.jetty.util.resource.URLResource, org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource resource) throws MalformedURLException {
        String string = this._urlString;
        int index = string.lastIndexOf("!/");
        if (index > 0) {
            string = string.substring(0, index);
        }
        if (string.startsWith(XMLSchedulingDataProcessor.QUARTZ_SYSTEM_ID_JAR_PREFIX)) {
            string = string.substring(4);
        }
        return new URL(string).sameFile(resource.getURI().toURL());
    }

    public File getJarFile() {
        if (this._file != null) {
            return this._file;
        }
        return null;
    }
}
