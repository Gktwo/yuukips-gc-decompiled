package p001ch.qos.logback.core.joran.event;

import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

/* renamed from: ch.qos.logback.core.joran.event.SaxEvent */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/event/SaxEvent.class */
public class SaxEvent {
    public final String namespaceURI;
    public final String localName;
    public final String qName;
    public final Locator locator;

    /* access modifiers changed from: package-private */
    public SaxEvent(String namespaceURI, String localName, String qName, Locator locator) {
        this.namespaceURI = namespaceURI;
        this.localName = localName;
        this.qName = qName;
        this.locator = new LocatorImpl(locator);
    }

    public String getLocalName() {
        return this.localName;
    }

    public Locator getLocator() {
        return this.locator;
    }

    public String getNamespaceURI() {
        return this.namespaceURI;
    }

    public String getQName() {
        return this.qName;
    }
}
