package p001ch.qos.logback.classic.sift;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.event.InPlayListener;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.classic.sift.SiftAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/sift/SiftAction.class */
public class SiftAction extends Action implements InPlayListener {
    List<SaxEvent> seList;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ic, String name, Attributes attributes) throws ActionException {
        this.seList = new ArrayList();
        ic.addInPlayListener(this);
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ic, String name) throws ActionException {
        ic.removeInPlayListener(this);
        Object o = ic.peekObject();
        if (o instanceof SiftingAppender) {
            SiftingAppender sa = (SiftingAppender) o;
            sa.setAppenderFactory(new AppenderFactoryUsingJoran(this.seList, sa.getDiscriminatorKey(), ic.getCopyOfPropertyMap()));
        }
    }

    @Override // p001ch.qos.logback.core.joran.event.InPlayListener
    public void inPlay(SaxEvent event) {
        this.seList.add(event);
    }

    public List<SaxEvent> getSeList() {
        return this.seList;
    }
}
