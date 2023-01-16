package p001ch.qos.logback.core.joran.conditional;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.joran.event.InPlayListener;
import p001ch.qos.logback.core.joran.event.SaxEvent;

/* compiled from: ThenOrElseActionBase.java */
/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.joran.conditional.ThenActionState */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/ThenActionState.class */
public class ThenActionState implements InPlayListener {
    List<SaxEvent> eventList = new ArrayList();
    boolean isRegistered = false;

    @Override // p001ch.qos.logback.core.joran.event.InPlayListener
    public void inPlay(SaxEvent event) {
        this.eventList.add(event);
    }
}
