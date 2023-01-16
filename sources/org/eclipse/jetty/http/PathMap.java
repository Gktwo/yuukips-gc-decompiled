package org.eclipse.jetty.http;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.function.Predicate;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.Trie;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/http/PathMap.class */
public class PathMap<O> extends HashMap<String, O> {
    private static String __pathSpecSeparators = ":,";
    Trie<MappedEntry<O>> _prefixMap;
    Trie<MappedEntry<O>> _suffixMap;
    final Map<String, MappedEntry<O>> _exactMap;
    List<MappedEntry<O>> _defaultSingletonList;
    MappedEntry<O> _prefixDefault;
    MappedEntry<O> _default;
    boolean _nodefault;

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((String) obj, (String) obj2);
    }

    public static void setPathSpecSeparators(String s) {
        __pathSpecSeparators = s;
    }

    public PathMap() {
        this(11);
    }

    public PathMap(boolean noDefault) {
        this(11, noDefault);
    }

    public PathMap(int capacity) {
        this(capacity, false);
    }

    private PathMap(int capacity, boolean noDefault) {
        super(capacity);
        this._prefixMap = new ArrayTernaryTrie(false);
        this._suffixMap = new ArrayTernaryTrie(false);
        this._exactMap = new HashMap();
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        this._default = null;
        this._nodefault = false;
        this._nodefault = noDefault;
    }

    public PathMap(Map<String, ? extends O> dictMap) {
        this._prefixMap = new ArrayTernaryTrie(false);
        this._suffixMap = new ArrayTernaryTrie(false);
        this._exactMap = new HashMap();
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        this._default = null;
        this._nodefault = false;
        putAll(dictMap);
    }

    public O put(String pathSpec, O object) {
        if ("".equals(pathSpec.trim())) {
            MappedEntry<O> entry = new MappedEntry<>("", object);
            entry.setMapped("");
            this._exactMap.put("", entry);
            return put((PathMap<O>) "", (String) object);
        }
        StringTokenizer tok = new StringTokenizer(pathSpec, __pathSpecSeparators);
        O old = null;
        while (tok.hasMoreTokens()) {
            String spec = tok.nextToken();
            if (spec.startsWith("/") || spec.startsWith("*.")) {
                old = put((PathMap<O>) spec, (String) object);
                MappedEntry<O> entry2 = new MappedEntry<>(spec, object);
                if (entry2.getKey().equals(spec)) {
                    if (spec.equals("/*")) {
                        this._prefixDefault = entry2;
                    } else if (spec.endsWith("/*")) {
                        String mapped = spec.substring(0, spec.length() - 2);
                        entry2.setMapped(mapped);
                        while (!this._prefixMap.put(mapped, entry2)) {
                            this._prefixMap = new ArrayTernaryTrie((ArrayTernaryTrie) this._prefixMap, 1.5d);
                        }
                    } else if (spec.startsWith("*.")) {
                        String suffix = spec.substring(2);
                        while (!this._suffixMap.put(suffix, entry2)) {
                            this._suffixMap = new ArrayTernaryTrie((ArrayTernaryTrie) this._suffixMap, 1.5d);
                        }
                    } else if (!spec.equals("/")) {
                        entry2.setMapped(spec);
                        this._exactMap.put(spec, entry2);
                    } else if (this._nodefault) {
                        this._exactMap.put(spec, entry2);
                    } else {
                        this._default = entry2;
                        this._defaultSingletonList = Collections.singletonList(this._default);
                    }
                }
            } else {
                throw new IllegalArgumentException("PathSpec " + spec + ". must start with '/' or '*.'");
            }
        }
        return old;
    }

    public O match(String path) {
        MappedEntry<O> entry = getMatch(path);
        if (entry != null) {
            return entry.getValue();
        }
        return null;
    }

    public MappedEntry<O> getMatch(String path) {
        MappedEntry<O> entry;
        MappedEntry<O> entry2;
        MappedEntry<O> entry3;
        if (path == null) {
            return null;
        }
        int l = path.length();
        if (l == 1 && path.charAt(0) == '/' && (entry3 = this._exactMap.get("")) != null) {
            return entry3;
        }
        MappedEntry<O> entry4 = this._exactMap.get(path);
        if (entry4 != null) {
            return entry4;
        }
        int i = l;
        Trie<MappedEntry<O>> prefix_map = this._prefixMap;
        while (i >= 0 && (entry2 = prefix_map.getBest(path, 0, i)) != null) {
            String key = entry2.getKey();
            if (key.length() - 2 >= path.length() || path.charAt(key.length() - 2) == '/') {
                return entry2;
            }
            i = key.length() - 3;
        }
        if (this._prefixDefault != null) {
            return this._prefixDefault;
        }
        int i2 = 0;
        Trie<MappedEntry<O>> suffix_map = this._suffixMap;
        do {
            int indexOf = path.indexOf(46, i2 + 1);
            i2 = indexOf;
            if (indexOf <= 0) {
                return this._default;
            }
            entry = suffix_map.get(path, i2 + 1, (l - i2) - 1);
        } while (entry == null);
        return entry;
    }

    public List<? extends Map.Entry<String, O>> getMatches(String path) {
        MappedEntry<O> entry;
        MappedEntry<O> entry2;
        List<MappedEntry<O>> entries = new ArrayList<>();
        if (path == null) {
            return entries;
        }
        if (path.isEmpty()) {
            return this._defaultSingletonList;
        }
        MappedEntry<O> entry3 = this._exactMap.get(path);
        if (entry3 != null) {
            entries.add(entry3);
        }
        int l = path.length();
        int i = l;
        Trie<MappedEntry<O>> prefix_map = this._prefixMap;
        while (i >= 0 && (entry2 = prefix_map.getBest(path, 0, i)) != null) {
            String key = entry2.getKey();
            if (key.length() - 2 >= path.length() || path.charAt(key.length() - 2) == '/') {
                entries.add(entry2);
            }
            i = key.length() - 3;
        }
        if (this._prefixDefault != null) {
            entries.add(this._prefixDefault);
        }
        int i2 = 0;
        Trie<MappedEntry<O>> suffix_map = this._suffixMap;
        while (true) {
            int indexOf = path.indexOf(46, i2 + 1);
            i2 = indexOf;
            if (indexOf <= 0) {
                break;
            }
            MappedEntry<O> entry4 = suffix_map.get(path, i2 + 1, (l - i2) - 1);
            if (entry4 != null) {
                entries.add(entry4);
            }
        }
        if ("/".equals(path) && (entry = this._exactMap.get("")) != null) {
            entries.add(entry);
        }
        if (this._default != null) {
            entries.add(this._default);
        }
        return entries;
    }

    public boolean containsMatch(String path) {
        MappedEntry<O> match = getMatch(path);
        return match != null && !match.equals(this._default);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public O remove(Object pathSpec) {
        if (pathSpec != null) {
            String spec = (String) pathSpec;
            if (spec.equals("/*")) {
                this._prefixDefault = null;
            } else if (spec.endsWith("/*")) {
                this._prefixMap.remove(spec.substring(0, spec.length() - 2));
            } else if (spec.startsWith("*.")) {
                this._suffixMap.remove(spec.substring(2));
            } else if (spec.equals("/")) {
                this._default = null;
                this._defaultSingletonList = null;
            } else {
                this._exactMap.remove(spec);
            }
        }
        return remove(pathSpec);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        this._exactMap.clear();
        this._prefixMap = new ArrayTernaryTrie(false);
        this._suffixMap = new ArrayTernaryTrie(false);
        this._default = null;
        this._defaultSingletonList = null;
        this._prefixDefault = null;
        clear();
    }

    public static boolean match(String pathSpec, String path) {
        return match(pathSpec, path, false);
    }

    public static boolean match(String pathSpec, String path, boolean noDefault) {
        if (pathSpec.isEmpty()) {
            return "/".equals(path);
        }
        char c = pathSpec.charAt(0);
        if (c == '/') {
            if ((noDefault || pathSpec.length() != 1) && !pathSpec.equals(path)) {
                return isPathWildcardMatch(pathSpec, path);
            }
            return true;
        } else if (c == '*') {
            return path.regionMatches((path.length() - pathSpec.length()) + 1, pathSpec, 1, pathSpec.length() - 1);
        } else {
            return false;
        }
    }

    private static boolean isPathWildcardMatch(String pathSpec, String path) {
        int cpl = pathSpec.length() - 2;
        if (!pathSpec.endsWith("/*") || !path.regionMatches(0, pathSpec, 0, cpl)) {
            return false;
        }
        return path.length() == cpl || '/' == path.charAt(cpl);
    }

    public static String pathMatch(String pathSpec, String path) {
        char c = pathSpec.charAt(0);
        if (c == '/') {
            if (pathSpec.length() == 1) {
                return path;
            }
            if (pathSpec.equals(path)) {
                return path;
            }
            if (isPathWildcardMatch(pathSpec, path)) {
                return path.substring(0, pathSpec.length() - 2);
            }
            return null;
        } else if (c != '*' || !path.regionMatches(path.length() - (pathSpec.length() - 1), pathSpec, 1, pathSpec.length() - 1)) {
            return null;
        } else {
            return path;
        }
    }

    public static String pathInfo(String pathSpec, String path) {
        if ("".equals(pathSpec)) {
            return path;
        }
        if (pathSpec.charAt(0) != '/' || pathSpec.length() == 1) {
            return null;
        }
        boolean wildcard = isPathWildcardMatch(pathSpec, path);
        if ((!pathSpec.equals(path) || wildcard) && wildcard && path.length() != pathSpec.length() - 2) {
            return path.substring(pathSpec.length() - 2);
        }
        return null;
    }

    public static String relativePath(String base, String pathSpec, String path) {
        String path2;
        String info = pathInfo(pathSpec, path);
        if (info == null) {
            info = path;
        }
        if (info.startsWith("./")) {
            info = info.substring(2);
        }
        if (base.endsWith("/")) {
            if (info.startsWith("/")) {
                path2 = base + info.substring(1);
            } else {
                path2 = base + info;
            }
        } else if (info.startsWith("/")) {
            path2 = base + info;
        } else {
            path2 = base + "/" + info;
        }
        return path2;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/PathMap$MappedEntry.class */
    public static class MappedEntry<O> implements Map.Entry<String, O> {
        private final String key;
        private final O value;
        private String mapped;

        MappedEntry(String key, O value) {
            this.key = key;
            this.value = value;
        }

        @Override // java.util.Map.Entry
        public String getKey() {
            return this.key;
        }

        @Override // java.util.Map.Entry
        public O getValue() {
            return this.value;
        }

        @Override // java.util.Map.Entry
        public O setValue(O o) {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Object
        public String toString() {
            return this.key + "=" + this.value;
        }

        public String getMapped() {
            return this.mapped;
        }

        void setMapped(String mapped) {
            this.mapped = mapped;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/PathMap$PathSet.class */
    public static class PathSet extends AbstractSet<String> implements Predicate<String> {
        private final PathMap<Boolean> _map = new PathMap<>();

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<String> iterator() {
            return this._map.keySet().iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this._map.size();
        }

        public boolean add(String item) {
            return this._map.put(item, (String) Boolean.TRUE) == null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object item) {
            return this._map.remove(item) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object o) {
            return this._map.containsKey(o);
        }

        public boolean test(String s) {
            return this._map.containsMatch(s);
        }

        public boolean containsMatch(String s) {
            return this._map.containsMatch(s);
        }
    }
}
