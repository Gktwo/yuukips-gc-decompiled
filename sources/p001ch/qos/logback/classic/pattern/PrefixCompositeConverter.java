package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.PatternLayout;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.pattern.CompositeConverter;
import p001ch.qos.logback.core.pattern.Converter;

/* renamed from: ch.qos.logback.classic.pattern.PrefixCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/PrefixCompositeConverter.class */
public class PrefixCompositeConverter extends CompositeConverter<ILoggingEvent> {
    public String convert(ILoggingEvent event) {
        StringBuilder buf = new StringBuilder();
        for (Converter<ILoggingEvent> c = getChildConverter(); c != null; c = c.getNext()) {
            if (c instanceof MDCConverter) {
                String key = ((MDCConverter) c).getKey();
                if (key != null) {
                    buf.append(key).append("=");
                }
            } else if (c instanceof PropertyConverter) {
                String key2 = ((PropertyConverter) c).getKey();
                if (key2 != null) {
                    buf.append(key2).append("=");
                }
            } else {
                String key3 = PatternLayout.CONVERTER_CLASS_TO_KEY_MAP.get(c.getClass().getName());
                if (key3 != null) {
                    buf.append(key3).append("=");
                }
            }
            buf.append(c.convert(event));
        }
        return buf.toString();
    }

    /* access modifiers changed from: protected */
    public String transform(ILoggingEvent event, String in) {
        throw new UnsupportedOperationException();
    }
}
