package org.eclipse.jetty.p023io;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;
import org.eclipse.jetty.util.IncludeExcludeSet;

/* renamed from: org.eclipse.jetty.io.IncludeExcludeConnectionStatistics */
/* loaded from: grasscutter.jar:org/eclipse/jetty/io/IncludeExcludeConnectionStatistics.class */
public class IncludeExcludeConnectionStatistics extends ConnectionStatistics {
    private final IncludeExcludeSet<Class<? extends Connection>, Connection> _set = new IncludeExcludeSet<>(ConnectionSet.class);

    public void include(String className) throws ClassNotFoundException {
        this._set.include((IncludeExcludeSet<Class<? extends Connection>, Connection>) connectionForName(className));
    }

    public void include(Class<? extends Connection> clazz) {
        this._set.include((IncludeExcludeSet<Class<? extends Connection>, Connection>) clazz);
    }

    public void exclude(String className) throws ClassNotFoundException {
        this._set.exclude((IncludeExcludeSet<Class<? extends Connection>, Connection>) connectionForName(className));
    }

    public void exclude(Class<? extends Connection> clazz) {
        this._set.exclude((IncludeExcludeSet<Class<? extends Connection>, Connection>) clazz);
    }

    private Class<? extends Connection> connectionForName(String className) throws ClassNotFoundException {
        Class cls = Class.forName(className);
        if (Connection.class.isAssignableFrom(cls)) {
            return cls;
        }
        throw new IllegalArgumentException("Class is not a Connection");
    }

    @Override // org.eclipse.jetty.p023io.ConnectionStatistics, org.eclipse.jetty.p023io.Connection.Listener
    public void onOpened(Connection connection) {
        if (this._set.test(connection)) {
            onOpened(connection);
        }
    }

    @Override // org.eclipse.jetty.p023io.ConnectionStatistics, org.eclipse.jetty.p023io.Connection.Listener
    public void onClosed(Connection connection) {
        if (this._set.test(connection)) {
            onClosed(connection);
        }
    }

    /* renamed from: org.eclipse.jetty.io.IncludeExcludeConnectionStatistics$ConnectionSet */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/io/IncludeExcludeConnectionStatistics$ConnectionSet.class */
    public static class ConnectionSet extends AbstractSet<Class<? extends Connection>> implements Predicate<Connection> {
        private final Set<Class<? extends Connection>> set = new HashSet();

        public boolean add(Class<? extends Connection> aClass) {
            return this.set.add(aClass);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object o) {
            return this.set.remove(o);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
        public Iterator<Class<? extends Connection>> iterator() {
            return this.set.iterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.set.size();
        }

        public boolean test(Connection connection) {
            if (connection == null) {
                return false;
            }
            return this.set.stream().anyMatch(c -> {
                return c.isAssignableFrom(connection.getClass());
            });
        }
    }
}
