package p001ch.qos.logback.core.pattern;

import p001ch.qos.logback.core.Context;

/* renamed from: ch.qos.logback.core.pattern.PostCompileProcessor */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/PostCompileProcessor.class */
public interface PostCompileProcessor<E> {
    void process(Context context, Converter<E> converter);
}
