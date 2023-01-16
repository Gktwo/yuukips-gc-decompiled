package p001ch.qos.logback.core.joran.spi;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.joran.event.BodyEvent;
import p001ch.qos.logback.core.joran.event.EndEvent;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.joran.event.StartEvent;

/* renamed from: ch.qos.logback.core.joran.spi.EventPlayer */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/EventPlayer.class */
public class EventPlayer {
    final Interpreter interpreter;
    List<SaxEvent> eventList;
    int currentIndex;

    public EventPlayer(Interpreter interpreter) {
        this.interpreter = interpreter;
    }

    public List<SaxEvent> getCopyOfPlayerEventList() {
        return new ArrayList(this.eventList);
    }

    public void play(List<SaxEvent> aSaxEventList) {
        this.eventList = aSaxEventList;
        this.currentIndex = 0;
        while (this.currentIndex < this.eventList.size()) {
            SaxEvent se = this.eventList.get(this.currentIndex);
            if (se instanceof StartEvent) {
                this.interpreter.startElement((StartEvent) se);
                this.interpreter.getInterpretationContext().fireInPlay(se);
            }
            if (se instanceof BodyEvent) {
                this.interpreter.getInterpretationContext().fireInPlay(se);
                this.interpreter.characters((BodyEvent) se);
            }
            if (se instanceof EndEvent) {
                this.interpreter.getInterpretationContext().fireInPlay(se);
                this.interpreter.endElement((EndEvent) se);
            }
            this.currentIndex++;
        }
    }

    public void addEventsDynamically(List<SaxEvent> eventList, int offset) {
        this.eventList.addAll(this.currentIndex + offset, eventList);
    }
}
