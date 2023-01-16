package p001ch.qos.logback.classic.sift;

import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.sift.AbstractDiscriminator;

/* renamed from: ch.qos.logback.classic.sift.ContextBasedDiscriminator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/sift/ContextBasedDiscriminator.class */
public class ContextBasedDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    private static final String KEY = "contextName";
    private String defaultValue;

    public String getDiscriminatingValue(ILoggingEvent event) {
        String contextName = event.getLoggerContextVO().getName();
        if (contextName == null) {
            return this.defaultValue;
        }
        return contextName;
    }

    @Override // p001ch.qos.logback.core.sift.Discriminator
    public String getKey() {
        return KEY;
    }

    public void setKey(String key) {
        throw new UnsupportedOperationException("Key cannot be set. Using fixed key contextName");
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
}
