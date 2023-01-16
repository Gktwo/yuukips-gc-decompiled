package p001ch.qos.logback.core;

import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.Layout */
/* loaded from: grasscutter.jar:ch/qos/logback/core/Layout.class */
public interface Layout<E> extends ContextAware, LifeCycle {
    String doLayout(E e);

    String getFileHeader();

    String getPresentationHeader();

    String getPresentationFooter();

    String getFileFooter();

    String getContentType();
}
