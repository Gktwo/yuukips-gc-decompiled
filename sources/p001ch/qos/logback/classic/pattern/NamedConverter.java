package p001ch.qos.logback.classic.pattern;

import p001ch.qos.logback.classic.spi.ILoggingEvent;

/* renamed from: ch.qos.logback.classic.pattern.NamedConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/NamedConverter.class */
public abstract class NamedConverter extends ClassicConverter {
    Abbreviator abbreviator = null;

    protected abstract String getFullyQualifiedName(ILoggingEvent iLoggingEvent);

    @Override // p001ch.qos.logback.core.pattern.DynamicConverter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        String optStr = getFirstOption();
        if (optStr != null) {
            try {
                int targetLen = Integer.parseInt(optStr);
                if (targetLen == 0) {
                    this.abbreviator = new ClassNameOnlyAbbreviator();
                } else if (targetLen > 0) {
                    this.abbreviator = new TargetLengthBasedClassNameAbbreviator(targetLen);
                }
            } catch (NumberFormatException e) {
            }
        }
    }

    public String convert(ILoggingEvent event) {
        String fqn = getFullyQualifiedName(event);
        if (this.abbreviator == null) {
            return fqn;
        }
        return this.abbreviator.abbreviate(fqn);
    }
}
