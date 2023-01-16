package p001ch.qos.logback.core.spi;

import java.io.Serializable;

/* renamed from: ch.qos.logback.core.spi.PreSerializationTransformer */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/PreSerializationTransformer.class */
public interface PreSerializationTransformer<E> {
    Serializable transform(E e);
}
