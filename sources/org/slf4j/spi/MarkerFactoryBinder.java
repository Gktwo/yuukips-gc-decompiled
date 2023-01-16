package org.slf4j.spi;

import org.slf4j.IMarkerFactory;

/* loaded from: grasscutter.jar:org/slf4j/spi/MarkerFactoryBinder.class */
public interface MarkerFactoryBinder {
    IMarkerFactory getMarkerFactory();

    String getMarkerFactoryClassStr();
}
