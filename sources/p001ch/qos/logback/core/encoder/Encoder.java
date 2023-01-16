package p001ch.qos.logback.core.encoder;

import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.encoder.Encoder */
/* loaded from: grasscutter.jar:ch/qos/logback/core/encoder/Encoder.class */
public interface Encoder<E> extends ContextAware, LifeCycle {
    byte[] headerBytes();

    byte[] encode(E e);

    byte[] footerBytes();
}
