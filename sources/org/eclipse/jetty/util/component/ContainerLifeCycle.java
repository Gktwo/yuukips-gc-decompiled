package org.eclipse.jetty.util.component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.Container;
import org.eclipse.jetty.util.component.Dumpable;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject("Implementation of Container and LifeCycle")
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/ContainerLifeCycle.class */
public class ContainerLifeCycle extends AbstractLifeCycle implements Container, Destroyable, Dumpable.DumpableContainer {
    private static final Logger LOG = Log.getLogger(ContainerLifeCycle.class);
    private final List<Bean> _beans = new CopyOnWriteArrayList();
    private final List<Container.Listener> _listeners = new CopyOnWriteArrayList();
    private boolean _doStarted;
    private boolean _destroyed;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/ContainerLifeCycle$Managed.class */
    public enum Managed {
        POJO,
        MANAGED,
        UNMANAGED,
        AUTO
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._destroyed) {
            throw new IllegalStateException("Destroyed container cannot be restarted");
        }
        this._doStarted = true;
        try {
            for (Bean b : this._beans) {
                if (b._bean instanceof LifeCycle) {
                    LifeCycle l = (LifeCycle) b._bean;
                    switch (b._managed) {
                        case MANAGED:
                            if (l.isStopped() || l.isFailed()) {
                                start(l);
                                break;
                            } else {
                                continue;
                            }
                            break;
                        case AUTO:
                            if (!l.isStopped()) {
                                unmanage(b);
                                break;
                            } else {
                                manage(b);
                                start(l);
                                continue;
                            }
                    }
                }
            }
            doStart();
        } catch (Throwable t) {
            List<Bean> reverse = new ArrayList<>(this._beans);
            Collections.reverse(reverse);
            for (Bean b2 : reverse) {
                if ((b2._bean instanceof LifeCycle) && b2._managed == Managed.MANAGED) {
                    LifeCycle l2 = (LifeCycle) b2._bean;
                    if (l2.isRunning()) {
                        try {
                            stop(l2);
                        } catch (Throwable cause2) {
                            if (cause2 != t) {
                                t.addSuppressed(cause2);
                            }
                        }
                    }
                }
            }
            throw t;
        }
    }

    protected void start(LifeCycle l) throws Exception {
        l.start();
    }

    protected void stop(LifeCycle l) throws Exception {
        l.stop();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._doStarted = false;
        doStop();
        List<Bean> reverse = new ArrayList<>(this._beans);
        Collections.reverse(reverse);
        MultiException mex = new MultiException();
        for (Bean b : reverse) {
            if (b._managed == Managed.MANAGED && (b._bean instanceof LifeCycle)) {
                try {
                    stop((LifeCycle) b._bean);
                } catch (Throwable cause) {
                    mex.add(cause);
                }
            }
        }
        mex.ifExceptionThrow();
    }

    @Override // org.eclipse.jetty.util.component.Destroyable
    public void destroy() {
        this._destroyed = true;
        List<Bean> reverse = new ArrayList<>(this._beans);
        Collections.reverse(reverse);
        for (Bean b : reverse) {
            if ((b._bean instanceof Destroyable) && (b._managed == Managed.MANAGED || b._managed == Managed.POJO)) {
                try {
                    ((Destroyable) b._bean).destroy();
                } catch (Throwable cause) {
                    LOG.warn(cause);
                }
            }
        }
        this._beans.clear();
    }

    public boolean contains(Object bean) {
        for (Bean b : this._beans) {
            if (b._bean == bean) {
                return true;
            }
        }
        return false;
    }

    @Override // org.eclipse.jetty.util.component.Container
    public boolean isManaged(Object bean) {
        for (Bean b : this._beans) {
            if (b._bean == bean) {
                return b.isManaged();
            }
        }
        return false;
    }

    public boolean isAuto(Object bean) {
        for (Bean b : this._beans) {
            if (b._bean == bean) {
                return b._managed == Managed.AUTO;
            }
        }
        return false;
    }

    public boolean isUnmanaged(Object bean) {
        for (Bean b : this._beans) {
            if (b._bean == bean) {
                return b._managed == Managed.UNMANAGED;
            }
        }
        return false;
    }

    @Override // org.eclipse.jetty.util.component.Container
    public boolean addBean(Object o) {
        if (!(o instanceof LifeCycle)) {
            return addBean(o, Managed.POJO);
        }
        return addBean(o, ((LifeCycle) o).isRunning() ? Managed.UNMANAGED : Managed.AUTO);
    }

    @Override // org.eclipse.jetty.util.component.Container
    public boolean addBean(Object o, boolean managed) {
        if (o instanceof LifeCycle) {
            return addBean(o, managed ? Managed.MANAGED : Managed.UNMANAGED);
        }
        return addBean(o, managed ? Managed.POJO : Managed.UNMANAGED);
    }

    private boolean addBean(Object o, Managed managed) {
        if (o == null || contains(o)) {
            return false;
        }
        Bean newBean = new Bean(o);
        if (o instanceof Container.Listener) {
            addEventListener((Container.Listener) o);
        }
        this._beans.add(newBean);
        for (Container.Listener l : this._listeners) {
            l.beanAdded(this, o);
        }
        try {
            switch (managed) {
                case MANAGED:
                    manage(newBean);
                    if (isStarting() && this._doStarted) {
                        LifeCycle l2 = (LifeCycle) o;
                        if (!l2.isRunning()) {
                            start(l2);
                        }
                        break;
                    }
                    break;
                case AUTO:
                    if (o instanceof LifeCycle) {
                        LifeCycle l3 = (LifeCycle) o;
                        if (isStarting()) {
                            if (l3.isRunning()) {
                                unmanage(newBean);
                            } else if (this._doStarted) {
                                manage(newBean);
                                start(l3);
                            } else {
                                newBean._managed = Managed.AUTO;
                            }
                        } else if (isStarted()) {
                            unmanage(newBean);
                        } else {
                            newBean._managed = Managed.AUTO;
                        }
                        break;
                    } else {
                        newBean._managed = Managed.POJO;
                        break;
                    }
                case UNMANAGED:
                    unmanage(newBean);
                    break;
                case POJO:
                    newBean._managed = Managed.POJO;
                    break;
            }
            if (!LOG.isDebugEnabled()) {
                return true;
            }
            LOG.debug("{} added {}", this, newBean);
            return true;
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public void addManaged(LifeCycle lifecycle) {
        addBean((Object) lifecycle, true);
        try {
            if (isRunning() && !lifecycle.isRunning()) {
                start(lifecycle);
            }
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public void addEventListener(Container.Listener listener) {
        if (!this._listeners.contains(listener)) {
            this._listeners.add(listener);
            for (Bean b : this._beans) {
                listener.beanAdded(this, b._bean);
                if ((listener instanceof Container.InheritedListener) && b.isManaged() && (b._bean instanceof Container)) {
                    if (b._bean instanceof ContainerLifeCycle) {
                        ((ContainerLifeCycle) b._bean).addBean((Object) listener, false);
                    } else {
                        ((Container) b._bean).addBean(listener);
                    }
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public void manage(Object bean) {
        for (Bean b : this._beans) {
            if (b._bean == bean) {
                manage(b);
                return;
            }
        }
        throw new IllegalArgumentException("Unknown bean " + bean);
    }

    private void manage(Bean bean) {
        if (bean._managed != Managed.MANAGED) {
            bean._managed = Managed.MANAGED;
            if (bean._bean instanceof Container) {
                for (Container.Listener l : this._listeners) {
                    if (l instanceof Container.InheritedListener) {
                        if (bean._bean instanceof ContainerLifeCycle) {
                            ((ContainerLifeCycle) bean._bean).addBean((Object) l, false);
                        } else {
                            ((Container) bean._bean).addBean(l);
                        }
                    }
                }
            }
            if (bean._bean instanceof AbstractLifeCycle) {
                ((AbstractLifeCycle) bean._bean).setStopTimeout(getStopTimeout());
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public void unmanage(Object bean) {
        for (Bean b : this._beans) {
            if (b._bean == bean) {
                unmanage(b);
                return;
            }
        }
        throw new IllegalArgumentException("Unknown bean " + bean);
    }

    private void unmanage(Bean bean) {
        if (bean._managed != Managed.UNMANAGED) {
            if (bean._managed == Managed.MANAGED && (bean._bean instanceof Container)) {
                for (Container.Listener l : this._listeners) {
                    if (l instanceof Container.InheritedListener) {
                        ((Container) bean._bean).removeBean(l);
                    }
                }
            }
            bean._managed = Managed.UNMANAGED;
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public Collection<Object> getBeans() {
        return getBeans(Object.class);
    }

    public void setBeans(Collection<Object> beans) {
        for (Object bean : beans) {
            addBean(bean);
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public <T> Collection<T> getBeans(Class<T> clazz) {
        ArrayList<T> beans = null;
        for (Bean b : this._beans) {
            if (clazz.isInstance(b._bean)) {
                if (beans == null) {
                    beans = new ArrayList<>();
                }
                beans.add(clazz.cast(b._bean));
            }
        }
        return beans == null ? Collections.emptyList() : beans;
    }

    @Override // org.eclipse.jetty.util.component.Container
    public <T> T getBean(Class<T> clazz) {
        for (Bean b : this._beans) {
            if (clazz.isInstance(b._bean)) {
                return clazz.cast(b._bean);
            }
        }
        return null;
    }

    public void removeBeans() {
        Iterator<Bean> it = new ArrayList<>(this._beans).iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    private Bean getBean(Object o) {
        for (Bean b : this._beans) {
            if (b._bean == o) {
                return b;
            }
        }
        return null;
    }

    @Override // org.eclipse.jetty.util.component.Container
    public boolean removeBean(Object o) {
        Bean b = getBean(o);
        return b != null && remove(b);
    }

    private boolean remove(Bean bean) {
        if (!this._beans.remove(bean)) {
            return false;
        }
        boolean wasManaged = bean.isManaged();
        unmanage(bean);
        for (Container.Listener l : this._listeners) {
            l.beanRemoved(this, bean._bean);
        }
        if (bean._bean instanceof Container.Listener) {
            removeEventListener((Container.Listener) bean._bean);
        }
        if (!wasManaged || !(bean._bean instanceof LifeCycle)) {
            return true;
        }
        try {
            stop((LifeCycle) bean._bean);
            return true;
        } catch (Error | RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public void removeEventListener(Container.Listener listener) {
        if (this._listeners.remove(listener)) {
            for (Bean b : this._beans) {
                listener.beanRemoved(this, b._bean);
                if ((listener instanceof Container.InheritedListener) && b.isManaged() && (b._bean instanceof Container)) {
                    ((Container) b._bean).removeBean(listener);
                }
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void setStopTimeout(long stopTimeout) {
        setStopTimeout(stopTimeout);
        for (Bean bean : this._beans) {
            if (bean.isManaged() && (bean._bean instanceof AbstractLifeCycle)) {
                ((AbstractLifeCycle) bean._bean).setStopTimeout(stopTimeout);
            }
        }
    }

    @ManagedOperation("Dump the object to stderr")
    public void dumpStdErr() {
        try {
            dump(System.err, "");
            System.err.println(Dumpable.KEY);
        } catch (IOException e) {
            LOG.warn(e);
        }
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    @ManagedOperation("Dump the object to a string")
    public String dump() {
        return Dumpable.dump(this);
    }

    @Deprecated
    public static String dump(Dumpable dumpable) {
        return Dumpable.dump(dumpable);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, new Object[0]);
    }

    public void dump(Appendable out) throws IOException {
        dump(out, "");
    }

    @Deprecated
    protected void dumpThis(Appendable out) throws IOException {
        out.append(String.valueOf(this)).append(" - ").append(getState()).append("\n");
    }

    @Deprecated
    public static void dumpObject(Appendable out, Object obj) throws IOException {
        Dumpable.dumpObject(out, obj);
    }

    protected void dumpObjects(Appendable out, String indent, Object... items) throws IOException {
        Dumpable.dumpObjects(out, indent, this, items);
    }

    @Deprecated
    protected void dumpBeans(Appendable out, String indent, Collection<?>... items) throws IOException {
        dump(out, indent, items);
    }

    @Deprecated
    public static void dump(Appendable out, String indent, Collection<?>... collections) throws IOException {
        if (collections.length != 0) {
            int size = 0;
            for (Collection<?> c : collections) {
                size += c.size();
            }
            if (size != 0) {
                int i = 0;
                for (Collection<?> c2 : collections) {
                    for (Object o : c2) {
                        i++;
                        out.append(indent).append(" +- ");
                        Dumpable.dumpObjects(out, indent + (i < size ? " |  " : "    "), o, new Object[0]);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/ContainerLifeCycle$Bean.class */
    public static class Bean {
        private final Object _bean;
        private volatile Managed _managed;

        private Bean(Object b) {
            this._managed = Managed.POJO;
            if (b == null) {
                throw new NullPointerException();
            }
            this._bean = b;
        }

        public boolean isManaged() {
            return this._managed == Managed.MANAGED;
        }

        public boolean isManageable() {
            switch (this._managed) {
                case MANAGED:
                    return true;
                case AUTO:
                    return (this._bean instanceof LifeCycle) && ((LifeCycle) this._bean).isStopped();
                default:
                    return false;
            }
        }

        public String toString() {
            return String.format("{%s,%s}", this._bean, this._managed);
        }
    }

    public void updateBean(Object oldBean, Object newBean) {
        if (newBean != oldBean) {
            if (oldBean != null) {
                removeBean(oldBean);
            }
            if (newBean != null) {
                addBean(newBean);
            }
        }
    }

    public void updateBean(Object oldBean, Object newBean, boolean managed) {
        if (newBean != oldBean) {
            if (oldBean != null) {
                removeBean(oldBean);
            }
            if (newBean != null) {
                addBean(newBean, managed);
            }
        }
    }

    public void updateBeans(Object[] oldBeans, Object[] newBeans) {
        if (oldBeans != null) {
            for (Object o : oldBeans) {
                if (newBeans != null) {
                    for (Object n : newBeans) {
                        if (o == n) {
                            break;
                        }
                    }
                }
                removeBean(o);
            }
        }
        if (newBeans != null) {
            for (Object n2 : newBeans) {
                if (oldBeans != null) {
                    for (Object o2 : oldBeans) {
                        if (o2 == n2) {
                            break;
                        }
                    }
                }
                addBean(n2);
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.Container
    public <T> Collection<T> getContainedBeans(Class<T> clazz) {
        HashSet hashSet = new HashSet();
        getContainedBeans(clazz, hashSet);
        return hashSet;
    }

    protected <T> void getContainedBeans(Class<T> clazz, Collection<T> beans) {
        beans.addAll(getBeans(clazz));
        for (T c : getBeans(Container.class)) {
            Bean bean = getBean(c);
            if (bean != null && bean.isManageable()) {
                if (c instanceof ContainerLifeCycle) {
                    ((ContainerLifeCycle) c).getContainedBeans(clazz, beans);
                } else {
                    beans.addAll(c.getContainedBeans(clazz));
                }
            }
        }
    }
}
