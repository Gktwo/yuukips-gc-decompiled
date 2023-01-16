package p001ch.qos.logback.core.joran.event.stax;

import javax.xml.stream.Location;

/* renamed from: ch.qos.logback.core.joran.event.stax.EndEvent */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/event/stax/EndEvent.class */
public class EndEvent extends StaxEvent {
    public EndEvent(String name, Location location) {
        super(name, location);
    }

    public String toString() {
        return "EndEvent(" + getName() + ")  [" + this.location.getLineNumber() + "," + this.location.getColumnNumber() + "]";
    }
}
