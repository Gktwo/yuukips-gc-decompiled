package p013io.github.classgraph;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import nonapi.p019io.github.classgraph.utils.CollectionUtils;

/* renamed from: io.github.classgraph.ResourceList */
/* loaded from: grasscutter.jar:io/github/classgraph/ResourceList.class */
public class ResourceList extends PotentiallyUnmodifiableList<Resource> implements AutoCloseable {
    static final long serialVersionUID = 1;
    static final ResourceList EMPTY_LIST = new ResourceList();
    private static final ResourceFilter CLASSFILE_FILTER = new ResourceFilter() { // from class: io.github.classgraph.ResourceList.1
        @Override // p013io.github.classgraph.ResourceList.ResourceFilter
        public boolean accept(Resource resource) {
            char c;
            String path = resource.getPath();
            return path.endsWith(".class") && path.length() >= 7 && (c = path.charAt(path.length() - 7)) != '/' && c != '.';
        }
    };

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ResourceList$ByteArrayConsumer */
    /* loaded from: grasscutter.jar:io/github/classgraph/ResourceList$ByteArrayConsumer.class */
    public interface ByteArrayConsumer {
        void accept(Resource resource, byte[] bArr);
    }

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ResourceList$ByteBufferConsumer */
    /* loaded from: grasscutter.jar:io/github/classgraph/ResourceList$ByteBufferConsumer.class */
    public interface ByteBufferConsumer {
        void accept(Resource resource, ByteBuffer byteBuffer);
    }

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ResourceList$InputStreamConsumer */
    /* loaded from: grasscutter.jar:io/github/classgraph/ResourceList$InputStreamConsumer.class */
    public interface InputStreamConsumer {
        void accept(Resource resource, InputStream inputStream);
    }

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ResourceList$ResourceFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/ResourceList$ResourceFilter.class */
    public interface ResourceFilter {
        boolean accept(Resource resource);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.List, java.util.AbstractList
    public /* bridge */ /* synthetic */ ListIterator listIterator() {
        return listIterator();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public /* bridge */ /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public /* bridge */ /* synthetic */ void clear() {
        clear();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return retainAll(collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return removeAll(collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.List, java.util.AbstractList
    public /* bridge */ /* synthetic */ boolean addAll(int i, Collection collection) {
        return addAll(i, collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean addAll(Collection collection) {
        return addAll(collection);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.ArrayList, java.util.AbstractCollection, java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return remove(obj);
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public /* bridge */ /* synthetic */ int hashCode() {
        return hashCode();
    }

    @Override // p013io.github.classgraph.PotentiallyUnmodifiableList, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Object
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return equals(obj);
    }

    static {
        EMPTY_LIST.makeUnmodifiable();
    }

    public static ResourceList emptyList() {
        return EMPTY_LIST;
    }

    public ResourceList() {
    }

    public ResourceList(int sizeHint) {
        super(sizeHint);
    }

    public ResourceList(Collection<Resource> resourceCollection) {
        super(resourceCollection);
    }

    public ResourceList get(String resourcePath) {
        boolean hasResourceWithPath = false;
        Iterator it = iterator();
        while (true) {
            if (it.hasNext()) {
                if (((Resource) it.next()).getPath().equals(resourcePath)) {
                    hasResourceWithPath = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!hasResourceWithPath) {
            return EMPTY_LIST;
        }
        ResourceList matchingResources = new ResourceList(2);
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            Resource res = (Resource) it2.next();
            if (res.getPath().equals(resourcePath)) {
                matchingResources.add(res);
            }
        }
        return matchingResources;
    }

    public List<String> getPaths() {
        List<String> resourcePaths = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            resourcePaths.add(((Resource) it.next()).getPath());
        }
        return resourcePaths;
    }

    public List<String> getPathsRelativeToClasspathElement() {
        List<String> resourcePaths = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            resourcePaths.add(((Resource) it.next()).getPath());
        }
        return resourcePaths;
    }

    public List<URL> getURLs() {
        List<URL> resourceURLs = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            resourceURLs.add(((Resource) it.next()).getURL());
        }
        return resourceURLs;
    }

    public List<URI> getURIs() {
        List<URI> resourceURLs = new ArrayList<>(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            resourceURLs.add(((Resource) it.next()).getURI());
        }
        return resourceURLs;
    }

    public ResourceList classFilesOnly() {
        return filter(CLASSFILE_FILTER);
    }

    public ResourceList nonClassFilesOnly() {
        return filter(new ResourceFilter() { // from class: io.github.classgraph.ResourceList.2
            @Override // p013io.github.classgraph.ResourceList.ResourceFilter
            public boolean accept(Resource resource) {
                return !ResourceList.CLASSFILE_FILTER.accept(resource);
            }
        });
    }

    public Map<String, ResourceList> asMap() {
        Map<String, ResourceList> pathToResourceList = new HashMap<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            Resource resource = (Resource) it.next();
            String path = resource.getPath();
            ResourceList resourceList = pathToResourceList.get(path);
            if (resourceList == null) {
                resourceList = new ResourceList(1);
                pathToResourceList.put(path, resourceList);
            }
            resourceList.add(resource);
        }
        return pathToResourceList;
    }

    public List<Map.Entry<String, ResourceList>> findDuplicatePaths() {
        List<Map.Entry<String, ResourceList>> duplicatePaths = new ArrayList<>();
        for (Map.Entry<String, ResourceList> pathAndResourceList : asMap().entrySet()) {
            if (pathAndResourceList.getValue().size() > 1) {
                duplicatePaths.add(new AbstractMap.SimpleEntry<>(pathAndResourceList.getKey(), pathAndResourceList.getValue()));
            }
        }
        CollectionUtils.sortIfNotEmpty(duplicatePaths, new Comparator<Map.Entry<String, ResourceList>>() { // from class: io.github.classgraph.ResourceList.3
            public int compare(Map.Entry<String, ResourceList> o1, Map.Entry<String, ResourceList> o2) {
                return o1.getKey().compareTo(o2.getKey());
            }
        });
        return duplicatePaths;
    }

    public ResourceList filter(ResourceFilter filter) {
        ResourceList resourcesFiltered = new ResourceList();
        Iterator it = iterator();
        while (it.hasNext()) {
            Resource resource = (Resource) it.next();
            if (filter.accept(resource)) {
                resourcesFiltered.add(resource);
            }
        }
        return resourcesFiltered;
    }

    public void forEachByteArray(ByteArrayConsumer byteArrayConsumer, boolean ignoreIOExceptions) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Resource resource = (Resource) it.next();
            try {
                try {
                    byteArrayConsumer.accept(resource, resource.load());
                    resource.close();
                } catch (IOException e) {
                    if (!ignoreIOExceptions) {
                        throw new IllegalArgumentException("Could not load resource " + resource, e);
                    }
                    resource.close();
                }
            } catch (Throwable th) {
                resource.close();
                throw th;
            }
        }
    }

    public void forEachByteArray(ByteArrayConsumer byteArrayConsumer) {
        forEachByteArray(byteArrayConsumer, false);
    }

    public void forEachInputStream(InputStreamConsumer inputStreamConsumer, boolean ignoreIOExceptions) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Resource resource = (Resource) it.next();
            try {
                try {
                    inputStreamConsumer.accept(resource, resource.open());
                    resource.close();
                } catch (IOException e) {
                    if (!ignoreIOExceptions) {
                        throw new IllegalArgumentException("Could not load resource " + resource, e);
                    }
                    resource.close();
                }
            } catch (Throwable th) {
                resource.close();
                throw th;
            }
        }
    }

    public void forEachInputStream(InputStreamConsumer inputStreamConsumer) {
        forEachInputStream(inputStreamConsumer, false);
    }

    public void forEachByteBuffer(ByteBufferConsumer byteBufferConsumer, boolean ignoreIOExceptions) {
        Iterator it = iterator();
        while (it.hasNext()) {
            Resource resource = (Resource) it.next();
            try {
                try {
                    byteBufferConsumer.accept(resource, resource.read());
                    resource.close();
                } catch (IOException e) {
                    if (!ignoreIOExceptions) {
                        throw new IllegalArgumentException("Could not load resource " + resource, e);
                    }
                    resource.close();
                }
            } catch (Throwable th) {
                resource.close();
                throw th;
            }
        }
    }

    public void forEachByteBuffer(ByteBufferConsumer byteBufferConsumer) {
        forEachByteBuffer(byteBufferConsumer, false);
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((Resource) it.next()).close();
        }
    }
}
