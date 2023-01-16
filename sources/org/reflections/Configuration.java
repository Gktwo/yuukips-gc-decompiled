package org.reflections;

import java.net.URL;
import java.util.Set;
import java.util.function.Predicate;
import org.reflections.scanners.Scanner;

/* loaded from: grasscutter.jar:org/reflections/Configuration.class */
public interface Configuration {
    Set<Scanner> getScanners();

    Set<URL> getUrls();

    Predicate<String> getInputsFilter();

    boolean isParallel();

    ClassLoader[] getClassLoaders();

    boolean shouldExpandSuperTypes();
}
