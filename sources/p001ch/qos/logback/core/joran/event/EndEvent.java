package p001ch.qos.logback.core.joran.event;

import org.xml.sax.Locator;

/* renamed from: ch.qos.logback.core.joran.event.EndEvent */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/event/EndEvent.class */
public class EndEvent extends SaxEvent {
    /* access modifiers changed from: package-private */
    public EndEvent(String namespaceURI, String localName, String qName, Locator locator) {
        super(namespaceURI, localName, qName, locator);
    }

    public String toString() {
        return "  EndEvent(" + getQName() + ")  [" + this.locator.getLineNumber() + "," + this.locator.getColumnNumber() + "]";
    }
}
