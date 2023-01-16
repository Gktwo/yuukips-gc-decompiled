package p001ch.qos.logback.core.joran.event.stax;

import javax.xml.stream.Location;

/* renamed from: ch.qos.logback.core.joran.event.stax.BodyEvent */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/event/stax/BodyEvent.class */
public class BodyEvent extends StaxEvent {
    private String text;

    /* access modifiers changed from: package-private */
    public BodyEvent(String text, Location location) {
        super(null, location);
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

    /* access modifiers changed from: package-private */
    public void append(String txt) {
        this.text += txt;
    }

    public String toString() {
        return "BodyEvent(" + getText() + ")" + this.location.getLineNumber() + "," + this.location.getColumnNumber();
    }
}
