package p001ch.qos.logback.core.joran.conditional;

import java.util.List;
import p001ch.qos.logback.core.joran.event.SaxEvent;

/* renamed from: ch.qos.logback.core.joran.conditional.ElseAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/ElseAction.class */
public class ElseAction extends ThenOrElseActionBase {
    @Override // p001ch.qos.logback.core.joran.conditional.ThenOrElseActionBase
    void registerEventList(IfAction ifAction, List<SaxEvent> eventList) {
        ifAction.setElseSaxEventList(eventList);
    }
}
