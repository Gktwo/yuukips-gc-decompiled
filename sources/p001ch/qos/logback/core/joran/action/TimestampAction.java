package p001ch.qos.logback.core.joran.action;

import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.core.joran.action.TimestampAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/TimestampAction.class */
public class TimestampAction extends Action {
    static String DATE_PATTERN_ATTRIBUTE = "datePattern";
    static String TIME_REFERENCE_ATTRIBUTE = "timeReference";
    static String CONTEXT_BIRTH = "contextBirth";
    boolean inError = false;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r0v23, types: [long] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // p001ch.qos.logback.core.joran.action.Action
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin(p001ch.qos.logback.core.joran.spi.InterpretationContext r6, java.lang.String r7, org.xml.sax.Attributes r8) throws p001ch.qos.logback.core.joran.spi.ActionException {
        /*
        // Method dump skipped, instructions count: 241
        */
        throw new UnsupportedOperationException("Method not decompiled: p001ch.qos.logback.core.joran.action.TimestampAction.begin(ch.qos.logback.core.joran.spi.InterpretationContext, java.lang.String, org.xml.sax.Attributes):void");
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) throws ActionException {
    }
}
