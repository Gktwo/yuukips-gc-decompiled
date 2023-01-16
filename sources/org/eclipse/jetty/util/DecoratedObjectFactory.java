package org.eclipse.jetty.util;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/DecoratedObjectFactory.class */
public class DecoratedObjectFactory implements Iterable<Decorator> {
    private static final Logger LOG = Log.getLogger(DecoratedObjectFactory.class);
    public static final String ATTR = DecoratedObjectFactory.class.getName();
    private List<Decorator> decorators = new ArrayList();

    public void addDecorator(Decorator decorator) {
        LOG.debug("Adding Decorator: {}", decorator);
        this.decorators.add(decorator);
    }

    public boolean removeDecorator(Decorator decorator) {
        LOG.debug("Remove Decorator: {}", decorator);
        return this.decorators.remove(decorator);
    }

    public void clear() {
        this.decorators.clear();
    }

    public <T> T createInstance(Class<T> clazz) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Creating Instance: " + clazz, new Object[0]);
        }
        return (T) decorate(clazz.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]));
    }

    public <T> T decorate(T obj) {
        T f = obj;
        for (int i = this.decorators.size() - 1; i >= 0; i--) {
            f = (T) this.decorators.get(i).decorate(f);
        }
        return f;
    }

    public void destroy(Object obj) {
        for (Decorator decorator : this.decorators) {
            decorator.destroy(obj);
        }
    }

    public List<Decorator> getDecorators() {
        return Collections.unmodifiableList(this.decorators);
    }

    @Override // java.lang.Iterable
    public Iterator<Decorator> iterator() {
        return this.decorators.iterator();
    }

    public void setDecorators(List<? extends Decorator> decorators) {
        this.decorators.clear();
        if (decorators != null) {
            this.decorators.addAll(decorators);
        }
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(getClass().getName()).append("[decorators=");
        str.append(this.decorators.size());
        str.append("]");
        return str.toString();
    }
}
