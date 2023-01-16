package p001ch.qos.logback.core.sift;

import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.sift.Discriminator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/sift/Discriminator.class */
public interface Discriminator<E> extends LifeCycle {
    String getDiscriminatingValue(E e);

    String getKey();
}
