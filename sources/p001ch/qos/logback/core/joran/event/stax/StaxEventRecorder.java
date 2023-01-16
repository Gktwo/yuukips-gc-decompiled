package p001ch.qos.logback.core.joran.event.stax;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.joran.spi.ElementPath;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.joran.event.stax.StaxEventRecorder */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/event/stax/StaxEventRecorder.class */
public class StaxEventRecorder extends ContextAwareBase {
    List<StaxEvent> eventList = new ArrayList();
    ElementPath globalElementPath = new ElementPath();

    public StaxEventRecorder(Context context) {
        setContext(context);
    }

    public void recordEvents(InputStream inputStream) throws JoranException {
        try {
            read(XMLInputFactory.newInstance().createXMLEventReader(inputStream));
        } catch (XMLStreamException e) {
            throw new JoranException("Problem parsing XML document. See previously reported errors.", e);
        }
    }

    public List<StaxEvent> getEventList() {
        return this.eventList;
    }

    private void read(XMLEventReader xmlEventReader) throws XMLStreamException {
        while (xmlEventReader.hasNext()) {
            XMLEvent xmlEvent = xmlEventReader.nextEvent();
            switch (xmlEvent.getEventType()) {
                case 1:
                    addStartElement(xmlEvent);
                    break;
                case 2:
                    addEndEvent(xmlEvent);
                    break;
                case 4:
                    addCharacters(xmlEvent);
                    break;
            }
        }
    }

    private void addStartElement(XMLEvent xmlEvent) {
        StartElement se = xmlEvent.asStartElement();
        String tagName = se.getName().getLocalPart();
        this.globalElementPath.push(tagName);
        this.eventList.add(new StartEvent(this.globalElementPath.duplicate(), tagName, se.getAttributes(), se.getLocation()));
    }

    private void addCharacters(XMLEvent xmlEvent) {
        Characters characters = xmlEvent.asCharacters();
        StaxEvent lastEvent = getLastEvent();
        if (lastEvent instanceof BodyEvent) {
            ((BodyEvent) lastEvent).append(characters.getData());
        } else if (!characters.isWhiteSpace()) {
            this.eventList.add(new BodyEvent(characters.getData(), xmlEvent.getLocation()));
        }
    }

    private void addEndEvent(XMLEvent xmlEvent) {
        EndElement ee = xmlEvent.asEndElement();
        this.eventList.add(new EndEvent(ee.getName().getLocalPart(), ee.getLocation()));
        this.globalElementPath.pop();
    }

    StaxEvent getLastEvent() {
        int size;
        if (!this.eventList.isEmpty() && (size = this.eventList.size()) != 0) {
            return this.eventList.get(size - 1);
        }
        return null;
    }
}
