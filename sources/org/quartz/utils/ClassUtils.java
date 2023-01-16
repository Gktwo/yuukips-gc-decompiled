package org.quartz.utils;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* loaded from: grasscutter.jar:org/quartz/utils/ClassUtils.class */
public class ClassUtils {
    public static boolean isAnnotationPresent(Class<?> clazz, Class<? extends Annotation> a) {
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            if (c.isAnnotationPresent(a) || isAnnotationPresentOnInterfaces(c, a)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAnnotationPresentOnInterfaces(Class<?> clazz, Class<? extends Annotation> a) {
        Class<?>[] arr$ = clazz.getInterfaces();
        for (Class<?> i : arr$) {
            if (i.isAnnotationPresent(a) || isAnnotationPresentOnInterfaces(i, a)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Class<T extends java.lang.annotation.Annotation> */
    /* JADX WARN: Multi-variable type inference failed */
    public static <T extends Annotation> T getAnnotation(Class<?> clazz, Class<T> aClazz) {
        for (Class<?> c = clazz; c != null; c = c.getSuperclass()) {
            T anno = (T) c.getAnnotation(aClazz);
            if (anno != null) {
                return anno;
            }
        }
        Queue<Class<?>> q = new LinkedList<>();
        q.add(clazz);
        while (!q.isEmpty()) {
            Class<?> c2 = q.remove();
            if (c2 != null) {
                if (c2.isInterface()) {
                    T anno2 = (T) c2.getAnnotation(aClazz);
                    if (anno2 != null) {
                        return anno2;
                    }
                } else {
                    q.add(c2.getSuperclass());
                }
                q.addAll(Arrays.asList(c2.getInterfaces()));
            }
        }
        return null;
    }
}
