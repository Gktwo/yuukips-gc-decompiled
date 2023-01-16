package p001ch.qos.logback.core.joran.event.stax;

import javax.xml.stream.Location;

/* renamed from: ch.qos.logback.core.joran.event.stax.StaxEvent */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/event/stax/StaxEvent.class */
public class StaxEvent {
    final String name;
    final Location location;

    /* access modifiers changed from: package-private */
    public StaxEvent(String name, Location location) {
        this.name = name;
        this.location = location;
    }

    public String getName() {
        return this.name;
    }

    public Location getLocation() {
        return this.location;
    }
}
