package org.eclipse.jetty.webapp;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.eclipse.jetty.p023io.RuntimeIOException;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.IncludeExcludeSet;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.URIUtil;
import org.eclipse.jetty.util.resource.Resource;
import p001ch.qos.logback.core.joran.action.Action;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern.class */
public class ClasspathPattern extends AbstractSet<String> {
    Map<String, Entry> _entries = new HashMap();
    IncludeExcludeSet<Entry, String> _packageOrNamePatterns = new IncludeExcludeSet<>(ByPackageOrName.class);
    IncludeExcludeSet<Entry, URI> _locations = new IncludeExcludeSet<>(ByLocationOrModule.class);

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$Entry.class */
    public static class Entry {
        private final String _pattern;
        private final String _name;
        private final boolean _inclusive;

        protected Entry(String name, boolean inclusive) {
            this._name = name;
            this._inclusive = inclusive;
            this._pattern = inclusive ? this._name : "-" + this._name;
        }

        public String getPattern() {
            return this._pattern;
        }

        public String getName() {
            return this._name;
        }

        public String toString() {
            return this._pattern;
        }

        public int hashCode() {
            return this._pattern.hashCode();
        }

        public boolean equals(Object o) {
            return (o instanceof Entry) && this._pattern.equals(((Entry) o)._pattern);
        }

        public boolean isInclusive() {
            return this._inclusive;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$PackageEntry.class */
    public static class PackageEntry extends Entry {
        protected PackageEntry(String name, boolean inclusive) {
            super(name, inclusive);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ClassEntry.class */
    public static class ClassEntry extends Entry {
        protected ClassEntry(String name, boolean inclusive) {
            super(name, inclusive);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$LocationEntry.class */
    public static class LocationEntry extends Entry {
        private final File _file;

        protected LocationEntry(String name, boolean inclusive) {
            super(name, inclusive);
            if (!getName().startsWith("file:")) {
                throw new IllegalArgumentException(name);
            }
            try {
                this._file = Resource.newResource(getName()).getFile();
            } catch (IOException e) {
                throw new RuntimeIOException(e);
            }
        }

        public File getFile() {
            return this._file;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ModuleEntry.class */
    public static class ModuleEntry extends Entry {
        private final String _module;

        protected ModuleEntry(String name, boolean inclusive) {
            super(name, inclusive);
            if (!getName().startsWith("jrt:")) {
                throw new IllegalArgumentException(name);
            }
            this._module = getName().split("/")[1];
        }

        public String getModule() {
            return this._module;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ByPackage.class */
    public static class ByPackage extends AbstractSet<Entry> implements Predicate<String> {
        private final ArrayTernaryTrie.Growing<Entry> _entries = new ArrayTernaryTrie.Growing<>(false, 512, 512);

        public boolean test(String name) {
            return this._entries.getBest(name) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Entry> iterator() {
            Stream<String> stream = this._entries.keySet().stream();
            ArrayTernaryTrie.Growing<Entry> growing = this._entries;
            Objects.requireNonNull(growing);
            return stream.map(this::get).iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this._entries.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return this._entries.isEmpty();
        }

        public boolean add(Entry entry) {
            String name = entry.getName();
            if (entry instanceof ClassEntry) {
                name = name + "$";
            } else if (!(entry instanceof PackageEntry)) {
                throw new IllegalArgumentException(entry.toString());
            } else if (Mapper.IGNORED_FIELDNAME.equals(name)) {
                name = "";
            }
            if (this._entries.get(name) != null) {
                return false;
            }
            return this._entries.put(name, entry);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object entry) {
            return (entry instanceof Entry) && this._entries.remove(((Entry) entry).getName()) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this._entries.clear();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ByClass.class */
    public static class ByClass extends HashSet<Entry> implements Predicate<String> {
        private final Map<String, Entry> _entries = new HashMap();

        public boolean test(String name) {
            return this._entries.containsKey(name);
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Entry> iterator() {
            return this._entries.values().iterator();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this._entries.size();
        }

        public boolean add(Entry entry) {
            if (entry instanceof ClassEntry) {
                return this._entries.put(entry.getName(), entry) == null;
            }
            throw new IllegalArgumentException(entry.toString());
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object entry) {
            return (entry instanceof Entry) && this._entries.remove(((Entry) entry).getName()) != null;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ByPackageOrName.class */
    public static class ByPackageOrName extends AbstractSet<Entry> implements Predicate<String> {
        private final ByClass _byClass = new ByClass();
        private final ByPackage _byPackage = new ByPackage();

        public boolean test(String name) {
            return this._byPackage.test(name) || this._byClass.test(name);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Entry> iterator() {
            return this._byPackage.iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this._byPackage.size();
        }

        public boolean add(Entry entry) {
            if (entry instanceof PackageEntry) {
                return this._byPackage.add(entry);
            }
            if (entry instanceof ClassEntry) {
                return this._byClass.add(entry) || this._byPackage.add(entry);
            }
            throw new IllegalArgumentException();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            return this._byPackage.remove(o) || this._byClass.remove(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this._byPackage.clear();
            this._byClass.clear();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ByLocation.class */
    public static class ByLocation extends HashSet<Entry> implements Predicate<URI> {
        public boolean test(URI uri) {
            if (uri == null || !uri.isAbsolute() || !uri.getScheme().equals(Action.FILE_ATTRIBUTE)) {
                return false;
            }
            Path path = Paths.get(uri);
            Iterator<Entry> it = iterator();
            while (it.hasNext()) {
                Entry entry = it.next();
                if (!(entry instanceof LocationEntry)) {
                    throw new IllegalStateException();
                }
                File file = ((LocationEntry) entry).getFile();
                if (file.isDirectory()) {
                    if (path.startsWith(file.toPath())) {
                        return true;
                    }
                } else if (path.equals(file.toPath())) {
                    return true;
                }
            }
            return false;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ByModule.class */
    public static class ByModule extends HashSet<Entry> implements Predicate<URI> {
        private final ArrayTernaryTrie.Growing<Entry> _entries = new ArrayTernaryTrie.Growing<>(false, 512, 512);

        public boolean test(URI uri) {
            if (uri == null || !uri.isAbsolute() || !uri.getScheme().equalsIgnoreCase("jrt")) {
                return false;
            }
            String module = uri.getPath();
            int end = module.indexOf(47, 1);
            if (end < 1) {
                end = module.length();
            }
            return this._entries.get(module, 1, end - 1) != null;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Entry> iterator() {
            Stream<String> stream = this._entries.keySet().stream();
            ArrayTernaryTrie.Growing<Entry> growing = this._entries;
            Objects.requireNonNull(growing);
            return stream.map(this::get).iterator();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this._entries.size();
        }

        public boolean add(Entry entry) {
            if (!(entry instanceof ModuleEntry)) {
                throw new IllegalArgumentException(entry.toString());
            }
            String module = ((ModuleEntry) entry).getModule();
            if (this._entries.get(module) != null) {
                return false;
            }
            this._entries.put(module, entry);
            return true;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object entry) {
            return (entry instanceof Entry) && this._entries.remove(((Entry) entry).getName()) != null;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/ClasspathPattern$ByLocationOrModule.class */
    public static class ByLocationOrModule extends AbstractSet<Entry> implements Predicate<URI> {
        private final ByLocation _byLocation = new ByLocation();
        private final ByModule _byModule = new ByModule();

        public boolean test(URI name) {
            if (name == null || !name.isAbsolute()) {
                return false;
            }
            return this._byLocation.test(name) || this._byModule.test(name);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Entry> iterator() {
            Set<Entry> entries = new HashSet<>();
            entries.addAll(this._byLocation);
            entries.addAll(this._byModule);
            return entries.iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this._byLocation.size() + this._byModule.size();
        }

        public boolean add(Entry entry) {
            if (entry instanceof LocationEntry) {
                return this._byLocation.add(entry);
            }
            if (entry instanceof ModuleEntry) {
                return this._byModule.add(entry);
            }
            throw new IllegalArgumentException(entry.toString());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            if (o instanceof LocationEntry) {
                return this._byLocation.remove(o);
            }
            if (o instanceof ModuleEntry) {
                return this._byModule.remove(o);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            this._byLocation.clear();
            this._byModule.clear();
        }
    }

    public ClasspathPattern() {
    }

    public ClasspathPattern(String[] patterns) {
        setAll(patterns);
    }

    public ClasspathPattern(String pattern) {
        add(pattern);
    }

    public boolean include(String name) {
        if (name == null) {
            return false;
        }
        return add(newEntry(name, true));
    }

    public boolean include(String... name) {
        boolean added = false;
        for (String n : name) {
            if (n != null) {
                added = add(newEntry(n, true)) || added;
            }
        }
        return added;
    }

    public boolean exclude(String name) {
        if (name == null) {
            return false;
        }
        return add(newEntry(name, false));
    }

    public boolean exclude(String... name) {
        boolean added = false;
        for (String n : name) {
            if (n != null) {
                added = add(newEntry(n, false)) || added;
            }
        }
        return added;
    }

    public boolean add(String pattern) {
        if (pattern == null) {
            return false;
        }
        return add(newEntry(pattern));
    }

    public boolean add(String... pattern) {
        boolean added = false;
        for (String p : pattern) {
            if (p != null) {
                added = add(newEntry(p)) || added;
            }
        }
        return added;
    }

    protected Entry newEntry(String pattern) {
        if (pattern.startsWith("-")) {
            return newEntry(pattern.substring(1), false);
        }
        return newEntry(pattern, true);
    }

    protected Entry newEntry(String name, boolean inclusive) {
        if (name.startsWith("-")) {
            throw new IllegalStateException(name);
        } else if (name.startsWith("file:")) {
            return new LocationEntry(name, inclusive);
        } else {
            if (name.startsWith("jrt:")) {
                return new ModuleEntry(name, inclusive);
            }
            if (name.endsWith(Mapper.IGNORED_FIELDNAME)) {
                return new PackageEntry(name, inclusive);
            }
            return new ClassEntry(name, inclusive);
        }
    }

    protected boolean add(Entry entry) {
        if (this._entries.containsKey(entry.getPattern())) {
            return false;
        }
        this._entries.put(entry.getPattern(), entry);
        if ((entry instanceof LocationEntry) || (entry instanceof ModuleEntry)) {
            if (entry.isInclusive()) {
                this._locations.include((IncludeExcludeSet<Entry, URI>) entry);
                return true;
            }
            this._locations.exclude((IncludeExcludeSet<Entry, URI>) entry);
            return true;
        } else if (entry.isInclusive()) {
            this._packageOrNamePatterns.include((IncludeExcludeSet<Entry, String>) entry);
            return true;
        } else {
            this._packageOrNamePatterns.exclude((IncludeExcludeSet<Entry, String>) entry);
            return true;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object o) {
        if (!(o instanceof String)) {
            return false;
        }
        if (this._entries.remove((String) o) == null) {
            return false;
        }
        List<Entry> saved = new ArrayList<>(this._entries.values());
        clear();
        for (Entry e : saved) {
            add(e);
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this._entries.clear();
        this._packageOrNamePatterns.clear();
        this._locations.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<String> iterator() {
        return this._entries.keySet().iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._entries.size();
    }

    private void setAll(String[] classes) {
        this._entries.clear();
        addAll(classes);
    }

    private void addAll(String[] classes) {
        if (classes != null) {
            addAll(Arrays.asList(classes));
        }
    }

    public String[] getPatterns() {
        return (String[]) toArray(new String[this._entries.size()]);
    }

    public boolean match(String name) {
        return this._packageOrNamePatterns.test(name);
    }

    public boolean match(Class<?> clazz) {
        try {
            return combine(this._packageOrNamePatterns, clazz.getName(), this._locations, () -> {
                return TypeUtil.getLocationOfClass(clazz);
            });
        } catch (Exception e) {
            return false;
        }
    }

    public boolean match(String name, URL url) {
        if (name.endsWith(".class")) {
            name = name.substring(0, name.length() - 6);
        }
        return combine(this._packageOrNamePatterns, StringUtil.replace(name, '/', '.'), this._locations, () -> {
            try {
                return URIUtil.getJarSource(url.toURI());
            } catch (URISyntaxException e) {
                return null;
            }
        });
    }

    static boolean combine(IncludeExcludeSet<Entry, String> names, String name, IncludeExcludeSet<Entry, URI> locations, Supplier<URI> location) {
        Boolean byName = names.isIncludedAndNotExcluded(name);
        if (Boolean.FALSE.equals(byName)) {
            return false;
        }
        URI uri = location.get();
        Boolean byLocation = uri == null ? null : locations.isIncludedAndNotExcluded(uri);
        if (Boolean.FALSE.equals(byLocation)) {
            return false;
        }
        if (!locations.hasExcludes() || uri != null) {
            return (!names.hasIncludes() && !locations.hasIncludes()) || Boolean.TRUE.equals(byName) || Boolean.TRUE.equals(byLocation);
        }
        return false;
    }
}
