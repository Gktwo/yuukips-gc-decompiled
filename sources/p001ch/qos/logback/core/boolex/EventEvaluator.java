package p001ch.qos.logback.core.boolex;

import p001ch.qos.logback.core.spi.ContextAware;
import p001ch.qos.logback.core.spi.LifeCycle;

/* renamed from: ch.qos.logback.core.boolex.EventEvaluator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/boolex/EventEvaluator.class */
public interface EventEvaluator<E> extends ContextAware, LifeCycle {
    boolean evaluate(E e) throws NullPointerException, EvaluationException;

    String getName();

    void setName(String str);
}
