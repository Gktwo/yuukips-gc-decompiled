package org.eclipse.jetty.util;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Decorator.class */
public interface Decorator {
    <T> T decorate(T t);

    void destroy(Object obj);
}
