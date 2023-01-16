package p001ch.qos.logback.core.sift;

import java.util.List;
import java.util.Map;
import p001ch.qos.logback.core.Appender;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.joran.spi.JoranException;

/* renamed from: ch.qos.logback.core.sift.AbstractAppenderFactoryUsingJoran */
/* loaded from: grasscutter.jar:ch/qos/logback/core/sift/AbstractAppenderFactoryUsingJoran.class */
public abstract class AbstractAppenderFactoryUsingJoran<E> implements AppenderFactory<E> {
    final List<SaxEvent> eventList;
    protected String key;
    protected Map<String, String> parentPropertyMap;

    public abstract SiftingJoranConfiguratorBase<E> getSiftingJoranConfigurator(String str);

    /* access modifiers changed from: protected */
    public AbstractAppenderFactoryUsingJoran(List<SaxEvent> eventList, String key, Map<String, String> parentPropertyMap) {
        this.eventList = removeSiftElement(eventList);
        this.key = key;
        this.parentPropertyMap = parentPropertyMap;
    }

    List<SaxEvent> removeSiftElement(List<SaxEvent> eventList) {
        return eventList.subList(1, eventList.size() - 1);
    }

    @Override // p001ch.qos.logback.core.sift.AppenderFactory
    public Appender<E> buildAppender(Context context, String discriminatingValue) throws JoranException {
        SiftingJoranConfiguratorBase<E> sjc = getSiftingJoranConfigurator(discriminatingValue);
        sjc.setContext(context);
        sjc.doConfigure(this.eventList);
        return sjc.getAppender();
    }

    public List<SaxEvent> getEventList() {
        return this.eventList;
    }
}
