package org.eclipse.jetty.util.resource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/ResourceCollection.class */
public class ResourceCollection extends Resource {
    private Resource[] _resources;

    public ResourceCollection() {
        this._resources = new Resource[0];
    }

    public ResourceCollection(Resource... resources) {
        List<Resource> list = new ArrayList<>();
        for (Resource r : resources) {
            if (r != null) {
                if (r instanceof ResourceCollection) {
                    Collections.addAll(list, ((ResourceCollection) r).getResources());
                } else {
                    list.add(r);
                }
            }
        }
        this._resources = (Resource[]) list.toArray(new Resource[0]);
        for (Resource r2 : this._resources) {
            assertResourceValid(r2);
        }
    }

    public ResourceCollection(String[] resources) {
        if (resources == null || resources.length == 0) {
            this._resources = null;
            return;
        }
        ArrayList<Resource> res = new ArrayList<>();
        try {
            for (String strResource : resources) {
                if (strResource == null || strResource.length() == 0) {
                    throw new IllegalArgumentException("empty/null resource path not supported");
                }
                Resource resource = Resource.newResource(strResource);
                assertResourceValid(resource);
                res.add(resource);
            }
            if (res.isEmpty()) {
                this._resources = null;
            } else {
                this._resources = (Resource[]) res.toArray(new Resource[0]);
            }
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public ResourceCollection(String csvResources) {
        setResourcesAsCSV(csvResources);
    }

    public Resource[] getResources() {
        return this._resources;
    }

    public void setResources(Resource[] resources) {
        if (resources == null || resources.length == 0) {
            this._resources = null;
            return;
        }
        List<Resource> res = new ArrayList<>();
        for (Resource resource : resources) {
            assertResourceValid(resource);
            res.add(resource);
        }
        if (res.isEmpty()) {
            this._resources = null;
        } else {
            this._resources = (Resource[]) res.toArray(new Resource[0]);
        }
    }

    public void setResourcesAsCSV(String csvResources) {
        if (csvResources == null) {
            throw new IllegalArgumentException("CSV String is null");
        }
        StringTokenizer tokenizer = new StringTokenizer(csvResources, ",;");
        if (tokenizer.countTokens() == 0) {
            throw new IllegalArgumentException("ResourceCollection@setResourcesAsCSV(String)  argument must be a string containing one or more comma-separated resource strings.");
        }
        List<Resource> res = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            try {
                String token = tokenizer.nextToken().trim();
                if (token.length() != 0) {
                    Resource resource = Resource.newResource(token);
                    assertResourceValid(resource);
                    res.add(resource);
                }
            } catch (RuntimeException e) {
                throw e;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
        if (res.isEmpty()) {
            this._resources = null;
        } else {
            this._resources = (Resource[]) res.toArray(new Resource[0]);
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public Resource addPath(String path) throws IOException {
        assertResourcesSet();
        if (path == null) {
            throw new MalformedURLException();
        } else if (path.length() == 0 || "/".equals(path)) {
            return this;
        } else {
            Resource resource = null;
            ArrayList<Resource> resources = null;
            int i = 0;
            while (true) {
                if (i >= this._resources.length) {
                    break;
                }
                resource = this._resources[i].addPath(path);
                if (!resource.exists()) {
                    i++;
                } else if (!resource.isDirectory()) {
                    return resource;
                }
            }
            while (true) {
                i++;
                if (i >= this._resources.length) {
                    break;
                }
                Resource r = this._resources[i].addPath(path);
                if (r.exists() && r.isDirectory()) {
                    if (resources == null) {
                        resources = new ArrayList<>();
                    }
                    if (resource != null) {
                        resources.add(resource);
                        resource = null;
                    }
                    resources.add(r);
                }
            }
            if (resource != null) {
                return resource;
            }
            if (resources != null) {
                return new ResourceCollection((Resource[]) resources.toArray(new Resource[0]));
            }
            throw new MalformedURLException();
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean delete() throws SecurityException {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean exists() {
        assertResourcesSet();
        return true;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public File getFile() throws IOException {
        assertResourcesSet();
        for (Resource r : this._resources) {
            File f = r.getFile();
            if (f != null) {
                return f;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public InputStream getInputStream() throws IOException {
        assertResourcesSet();
        for (Resource r : this._resources) {
            InputStream is = r.getInputStream();
            if (is != null) {
                return is;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public ReadableByteChannel getReadableByteChannel() throws IOException {
        assertResourcesSet();
        for (Resource r : this._resources) {
            ReadableByteChannel channel = r.getReadableByteChannel();
            if (channel != null) {
                return channel;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String getName() {
        assertResourcesSet();
        for (Resource r : this._resources) {
            String name = r.getName();
            if (name != null) {
                return name;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public URL getURL() {
        assertResourcesSet();
        for (Resource r : this._resources) {
            URL url = r.getURL();
            if (url != null) {
                return url;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isDirectory() {
        assertResourcesSet();
        return true;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long lastModified() {
        assertResourcesSet();
        for (Resource r : this._resources) {
            long lm = r.lastModified();
            if (lm != -1) {
                return lm;
            }
        }
        return -1;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public long length() {
        return -1;
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public String[] list() {
        assertResourcesSet();
        HashSet<String> set = new HashSet<>();
        for (Resource r : this._resources) {
            String[] list = r.list();
            if (list != null) {
                Collections.addAll(set, list);
            }
        }
        String[] result = (String[]) set.toArray(new String[0]);
        Arrays.sort(result);
        return result;
    }

    @Override // org.eclipse.jetty.util.resource.Resource, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        assertResourcesSet();
        for (Resource r : this._resources) {
            r.close();
        }
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean renameTo(Resource dest) throws SecurityException {
        throw new UnsupportedOperationException();
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public void copyTo(File destination) throws IOException {
        assertResourcesSet();
        int r = this._resources.length;
        while (true) {
            r--;
            if (r > 0) {
                this._resources[r].copyTo(destination);
            } else {
                return;
            }
        }
    }

    @Override // java.lang.Object
    public String toString() {
        if (this._resources == null || this._resources.length == 0) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        return String.valueOf(Arrays.asList(this._resources));
    }

    @Override // org.eclipse.jetty.util.resource.Resource
    public boolean isContainedIn(Resource r) {
        return false;
    }

    private void assertResourcesSet() {
        if (this._resources == null || this._resources.length == 0) {
            throw new IllegalStateException("*resources* not set.");
        }
    }

    private void assertResourceValid(Resource resource) {
        if (resource == null) {
            throw new IllegalStateException("Null resource not supported");
        } else if (!resource.exists() || !resource.isDirectory()) {
            throw new IllegalArgumentException(resource + " is not an existing directory.");
        }
    }
}
