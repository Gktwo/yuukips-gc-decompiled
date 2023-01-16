package org.eclipse.jetty.util;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ClassVisibilityChecker.class */
public interface ClassVisibilityChecker {
    boolean isSystemClass(Class<?> cls);

    boolean isServerClass(Class<?> cls);
}
