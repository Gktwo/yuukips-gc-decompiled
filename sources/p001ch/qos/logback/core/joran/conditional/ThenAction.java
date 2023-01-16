package p001ch.qos.logback.core.joran.conditional;

import java.util.List;
import p001ch.qos.logback.core.joran.event.SaxEvent;

/* renamed from: ch.qos.logback.core.joran.conditional.ThenAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/ThenAction.class */
public class ThenAction extends ThenOrElseActionBase {
    @Override // p001ch.qos.logback.core.joran.conditional.ThenOrElseActionBase
    void registerEventList(IfAction ifAction, List<SaxEvent> eventList) {
        ifAction.setThenSaxEventList(eventList);
    }
}
