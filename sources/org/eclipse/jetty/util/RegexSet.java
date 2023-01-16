package org.eclipse.jetty.util;

import java.util.AbstractSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import java.util.regex.Pattern;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/RegexSet.class */
public class RegexSet extends AbstractSet<String> implements Predicate<String> {
    private final Set<String> _patterns = new HashSet();
    private final Set<String> _unmodifiable = Collections.unmodifiableSet(this._patterns);
    private Pattern _pattern;

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<String> iterator() {
        return this._unmodifiable.iterator();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return this._patterns.size();
    }

    public boolean add(String pattern) {
        boolean added = this._patterns.add(pattern);
        if (added) {
            updatePattern();
        }
        return added;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean remove(Object pattern) {
        boolean removed = this._patterns.remove(pattern);
        if (removed) {
            updatePattern();
        }
        return removed;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return this._patterns.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        this._patterns.clear();
        this._pattern = null;
    }

    private void updatePattern() {
        StringBuilder builder = new StringBuilder();
        builder.append("^(");
        for (String pattern : this._patterns) {
            if (builder.length() > 2) {
                builder.append('|');
            }
            builder.append('(');
            builder.append(pattern);
            builder.append(')');
        }
        builder.append(")$");
        this._pattern = Pattern.compile(builder.toString());
    }

    public boolean test(String s) {
        return this._pattern != null && this._pattern.matcher(s).matches();
    }

    public boolean matches(String s) {
        return this._pattern != null && this._pattern.matcher(s).matches();
    }
}
