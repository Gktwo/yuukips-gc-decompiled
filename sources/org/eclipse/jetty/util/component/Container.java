package org.eclipse.jetty.util.component;

import java.util.Collection;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Container.class */
public interface Container {

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Container$InheritedListener.class */
    public interface InheritedListener extends Listener {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/component/Container$Listener.class */
    public interface Listener {
        void beanAdded(Container container, Object obj);

        void beanRemoved(Container container, Object obj);
    }

    boolean addBean(Object obj);

    Collection<Object> getBeans();

    <T> Collection<T> getBeans(Class<T> cls);

    <T> T getBean(Class<T> cls);

    boolean removeBean(Object obj);

    void addEventListener(Listener listener);

    void removeEventListener(Listener listener);

    void unmanage(Object obj);

    void manage(Object obj);

    boolean isManaged(Object obj);

    boolean addBean(Object obj, boolean z);

    <T> Collection<T> getContainedBeans(Class<T> cls);
}
