package p001ch.qos.logback.core.helpers;

import p001ch.qos.logback.core.AppenderBase;

/* renamed from: ch.qos.logback.core.helpers.NOPAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/helpers/NOPAppender.class */
public final class NOPAppender<E> extends AppenderBase<E> {
    @Override // p001ch.qos.logback.core.AppenderBase
    protected void append(E eventObject) {
    }
}
