package p001ch.qos.logback.core.joran.conditional;

import java.util.List;
import p001ch.qos.logback.core.joran.event.SaxEvent;

/* compiled from: IfAction.java */
/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.joran.conditional.IfState */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/IfState.class */
public class IfState {
    Boolean boolResult;
    List<SaxEvent> thenSaxEventList;
    List<SaxEvent> elseSaxEventList;
    boolean active;
}
