package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.PropertyConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/PropertyConverter.class */
public final class PropertyConverter extends ClassicConverter {
    String key;

    @Override // p001ch.qos.logback.core.pattern.DynamicConverter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String optStr = getFirstOption();
        if (optStr != null) {
            this.key = optStr;
            start();
        }
    }

    public String getKey() {
        return this.key;
    }

    public String convert(ILoggingEvent event) {
        if (this.key == null) {
            return "Property_HAS_NO_KEY";
        }
        String val = event.getLoggerContextVO().getPropertyMap().get(this.key);
        if (val != null) {
            return val;
        }
        return System.getProperty(this.key);
    }
}
