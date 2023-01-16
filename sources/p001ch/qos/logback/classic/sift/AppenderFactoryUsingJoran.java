package p001ch.qos.logback.classic.sift;

import java.util.List;
import java.util.Map;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.sift.AbstractAppenderFactoryUsingJoran;
import p001ch.qos.logback.core.sift.SiftingJoranConfiguratorBase;

/* renamed from: ch.qos.logback.classic.sift.AppenderFactoryUsingJoran */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/sift/AppenderFactoryUsingJoran.class */
public class AppenderFactoryUsingJoran extends AbstractAppenderFactoryUsingJoran<ILoggingEvent> {
    /* access modifiers changed from: package-private */
    public AppenderFactoryUsingJoran(List<SaxEvent> eventList, String key, Map<String, String> parentPropertyMap) {
        super(eventList, key, parentPropertyMap);
    }

    @Override // p001ch.qos.logback.core.sift.AbstractAppenderFactoryUsingJoran
    public SiftingJoranConfiguratorBase<ILoggingEvent> getSiftingJoranConfigurator(String discriminatingValue) {
        return new SiftingJoranConfigurator(this.key, discriminatingValue, this.parentPropertyMap);
    }
}
