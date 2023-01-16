package p001ch.qos.logback.classic.sift;

import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.selector.ContextSelector;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.classic.util.ContextSelectorStaticBinder;
import p001ch.qos.logback.core.sift.AbstractDiscriminator;

/* renamed from: ch.qos.logback.classic.sift.JNDIBasedContextDiscriminator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/sift/JNDIBasedContextDiscriminator.class */
public class JNDIBasedContextDiscriminator extends AbstractDiscriminator<ILoggingEvent> {
    private static final String KEY = "contextName";
    private String defaultValue;

    public String getDiscriminatingValue(ILoggingEvent event) {
        ContextSelector selector = ContextSelectorStaticBinder.getSingleton().getContextSelector();
        if (selector == null) {
            return this.defaultValue;
        }
        LoggerContext lc = selector.getLoggerContext();
        if (lc == null) {
            return this.defaultValue;
        }
        return lc.getName();
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
