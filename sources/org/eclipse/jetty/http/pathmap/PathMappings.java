package org.eclipse.jetty.http.pathmap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Path Mappings")
/* loaded from: grasscutter.jar:org/eclipse/jetty/http/pathmap/PathMappings.class */
public class PathMappings<E> implements Iterable<MappedResource<E>>, Dumpable {
    private static final Logger LOG = Log.getLogger(PathMappings.class);
    private final Set<MappedResource<E>> _mappings = new TreeSet(Comparator.comparing((v0) -> {
        return v0.getPathSpec();
    }));
    private boolean _optimizedExact = true;
    private Trie<MappedResource<E>> _exactMap = new ArrayTernaryTrie(false);
    private boolean _optimizedPrefix = true;
    private Trie<MappedResource<E>> _prefixMap = new ArrayTernaryTrie(false);
    private boolean _optimizedSuffix = true;
    private Trie<MappedResource<E>> _suffixMap = new ArrayTernaryTrie(false);

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, toString(), this._mappings);
    }

    @ManagedAttribute(value = "mappings", readonly = true)
    public List<MappedResource<E>> getMappings() {
        return new ArrayList(this._mappings);
    }

    public int size() {
        return this._mappings.size();
    }

    public void reset() {
        this._mappings.clear();
        this._prefixMap.clear();
        this._suffixMap.clear();
    }

    public void removeIf(Predicate<MappedResource<E>> predicate) {
        this._mappings.removeIf(predicate);
    }

    public List<MatchedResource<E>> getMatchedList(String path) {
        ArrayList ret = new ArrayList();
        for (MappedResource<E> mr : this._mappings) {
            MatchedPath matchedPath = mr.getPathSpec().matched(path);
            if (matchedPath != null) {
                ret.add(new MatchedResource<>(mr.getResource(), mr.getPathSpec(), matchedPath));
            }
        }
        return ret;
    }

    public List<MappedResource<E>> getMatches(String path) {
        boolean isRootPath = "/".equals(path);
        ArrayList ret = new ArrayList();
        for (MappedResource<E> mr : this._mappings) {
            switch (mr.getPathSpec().getGroup()) {
                case ROOT:
                    if (isRootPath) {
                        ret.add(mr);
                        break;
                    } else {
                        break;
                    }
                case DEFAULT:
                    if (isRootPath || mr.getPathSpec().matched(path) != null) {
                        ret.add(mr);
                        break;
                    } else {
                        break;
                    }
                default:
                    if (mr.getPathSpec().matched(path) != null) {
                        ret.add(mr);
                        break;
                    } else {
                        break;
                    }
            }
        }
        return ret;
    }

    public MatchedResource<E> getMatched(String path) {
        MatchedPath matchedPath;
        MatchedPath matchedPath2;
        MatchedPath matchedPath3;
        PathSpecGroup lastGroup = null;
        boolean skipRestOfGroup = false;
        for (MappedResource<E> mr : this._mappings) {
            PathSpecGroup group = mr.getPathSpec().getGroup();
            if (group != lastGroup || !skipRestOfGroup) {
                if (group != lastGroup) {
                    skipRestOfGroup = false;
                    switch (group) {
                        case EXACT:
                            if (this._optimizedExact) {
                                int i = path.length();
                                while (i >= 0) {
                                    i--;
                                    MappedResource<E> candidate = this._exactMap.getBest(path, 0, i);
                                    if (!(candidate == null || (matchedPath3 = candidate.getPathSpec().matched(path)) == null)) {
                                        return new MatchedResource<>(candidate.getResource(), candidate.getPathSpec(), matchedPath3);
                                    }
                                }
                                skipRestOfGroup = true;
                                break;
                            }
                            break;
                        case PREFIX_GLOB:
                            if (this._optimizedPrefix) {
                                int i2 = path.length();
                                while (i2 >= 0) {
                                    i2--;
                                    MappedResource<E> candidate2 = this._prefixMap.getBest(path, 0, i2);
                                    if (!(candidate2 == null || (matchedPath2 = candidate2.getPathSpec().matched(path)) == null)) {
                                        return new MatchedResource<>(candidate2.getResource(), candidate2.getPathSpec(), matchedPath2);
                                    }
                                }
                                skipRestOfGroup = true;
                                break;
                            }
                            break;
                        case SUFFIX_GLOB:
                            if (this._optimizedSuffix) {
                                int i3 = 0;
                                while (true) {
                                    int indexOf = path.indexOf(46, i3 + 1);
                                    i3 = indexOf;
                                    if (indexOf <= 0) {
                                        skipRestOfGroup = true;
                                        break;
                                    } else {
                                        MappedResource<E> candidate3 = this._suffixMap.get(path, i3 + 1, (path.length() - i3) - 1);
                                        if (!(candidate3 == null || (matchedPath = candidate3.getPathSpec().matched(path)) == null)) {
                                            return new MatchedResource<>(candidate3.getResource(), candidate3.getPathSpec(), matchedPath);
                                        }
                                    }
                                }
                            }
                            break;
                    }
                }
                MatchedPath matchedPath4 = mr.getPathSpec().matched(path);
                if (matchedPath4 != null) {
                    return new MatchedResource<>(mr.getResource(), mr.getPathSpec(), matchedPath4);
                }
                lastGroup = group;
            }
        }
        return null;
    }

    @Deprecated
    public MappedResource<E> getMatch(String path) {
        throw new UnsupportedOperationException("Use .getMatched(String) instead");
    }

    @Override // java.lang.Iterable
    public Iterator<MappedResource<E>> iterator() {
        return this._mappings.iterator();
    }

    @Deprecated
    public static PathSpec asPathSpec(String pathSpecString) {
        return PathSpec.from(pathSpecString);
    }

    public E get(PathSpec spec) {
        return (E) this._mappings.stream().filter(mappedResource -> {
            return mappedResource.getPathSpec().equals(spec);
        }).map((v0) -> {
            return v0.getResource();
        }).findFirst().orElse(null);
    }

    public boolean put(String pathSpecString, E resource) {
        return put(PathSpec.from(pathSpecString), (PathSpec) resource);
    }

    public boolean put(PathSpec pathSpec, E resource) {
        MappedResource<E> entry = new MappedResource<>(pathSpec, resource);
        boolean added = this._mappings.add(entry);
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[3];
            objArr[0] = added ? "Added" : "Ignored";
            objArr[1] = entry;
            objArr[2] = this;
            logger.debug("{} {} to {}", objArr);
        }
        if (added) {
            switch (pathSpec.getGroup()) {
                case EXACT:
                    if (!(pathSpec instanceof ServletPathSpec)) {
                        this._optimizedExact = false;
                        break;
                    } else {
                        String exact = pathSpec.getDeclaration();
                        while (exact != null && !this._exactMap.put(exact, entry)) {
                            this._exactMap = new ArrayTernaryTrie((ArrayTernaryTrie) this._exactMap, 1.5d);
                        }
                    }
                    break;
                case PREFIX_GLOB:
                    if (!(pathSpec instanceof ServletPathSpec)) {
                        this._optimizedPrefix = false;
                        break;
                    } else {
                        String prefix = pathSpec.getPrefix();
                        while (prefix != null && !this._prefixMap.put(prefix, entry)) {
                            this._prefixMap = new ArrayTernaryTrie((ArrayTernaryTrie) this._prefixMap, 1.5d);
                        }
                    }
                    break;
                case SUFFIX_GLOB:
                    if (!(pathSpec instanceof ServletPathSpec)) {
                        this._optimizedSuffix = false;
                        break;
                    } else {
                        String suffix = pathSpec.getSuffix();
                        while (suffix != null && !this._suffixMap.put(suffix, entry)) {
                            this._suffixMap = new ArrayTernaryTrie((ArrayTernaryTrie) this._prefixMap, 1.5d);
                        }
                    }
                    break;
            }
        }
        return added;
    }

    public boolean remove(PathSpec pathSpec) {
        Iterator<MappedResource<E>> iter = this._mappings.iterator();
        boolean removed = false;
        while (true) {
            if (iter.hasNext()) {
                if (iter.next().getPathSpec().equals(pathSpec)) {
                    removed = true;
                    iter.remove();
                    break;
                }
            } else {
                break;
            }
        }
        if (LOG.isDebugEnabled()) {
            Logger logger = LOG;
            Object[] objArr = new Object[3];
            objArr[0] = removed ? "Removed" : "Ignored";
            objArr[1] = pathSpec;
            objArr[2] = this;
            logger.debug("{} {} to {}", objArr);
        }
        if (removed) {
            switch (pathSpec.getGroup()) {
                case EXACT:
                    String exact = pathSpec.getDeclaration();
                    if (exact != null) {
                        this._exactMap.remove(exact);
                        this._optimizedExact = canBeOptimized(PathSpecGroup.EXACT);
                        break;
                    }
                    break;
                case PREFIX_GLOB:
                    String prefix = pathSpec.getPrefix();
                    if (prefix != null) {
                        this._prefixMap.remove(prefix);
                        this._optimizedPrefix = canBeOptimized(PathSpecGroup.PREFIX_GLOB);
                        break;
                    }
                    break;
                case SUFFIX_GLOB:
                    String suffix = pathSpec.getSuffix();
                    if (suffix != null) {
                        this._suffixMap.remove(suffix);
                        this._optimizedSuffix = canBeOptimized(PathSpecGroup.SUFFIX_GLOB);
                        break;
                    }
                    break;
            }
        }
        return removed;
    }

    private boolean canBeOptimized(PathSpecGroup suffixGlob) {
        return this._mappings.stream().filter(mapping -> {
            return mapping.getPathSpec().getGroup() == suffixGlob;
        }).allMatch(mapping -> {
            return mapping.getPathSpec() instanceof ServletPathSpec;
        });
    }

    @Override // java.lang.Object
    public String toString() {
        return String.format("%s[size=%d]", getClass().getSimpleName(), Integer.valueOf(this._mappings.size()));
    }
}
