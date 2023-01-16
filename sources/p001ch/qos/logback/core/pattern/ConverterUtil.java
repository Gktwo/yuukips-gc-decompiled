package p001ch.qos.logback.core.pattern;

import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.core.pattern.ConverterUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/ConverterUtil.class */
public class ConverterUtil {
    public static <E> void startConverters(Converter<E> head) {
        for (Converter<E> c = head; c != null; c = c.getNext()) {
            if (c instanceof CompositeConverter) {
                CompositeConverter<E> cc = (CompositeConverter) c;
                startConverters(cc.childConverter);
                cc.start();
            } else if (c instanceof DynamicConverter) {
                ((DynamicConverter) c).start();
            }
        }
    }

    public static <E> Converter<E> findTail(Converter<E> head) {
        Converter<E> p = head;
        while (p != null) {
            Converter<E> next = p.getNext();
            if (next == null) {
                break;
            }
            p = next;
        }
        return p;
    }

    public static <E> void setContextForConverters(Context context, Converter<E> head) {
        for (Converter<E> c = head; c != null; c = c.getNext()) {
            if (c instanceof ContextAware) {
                ((ContextAware) c).setContext(context);
            }
        }
    }
}
