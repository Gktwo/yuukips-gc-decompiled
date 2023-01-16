package p001ch.qos.logback.core.layout;

import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.LayoutBase;

/* renamed from: ch.qos.logback.core.layout.EchoLayout */
/* loaded from: grasscutter.jar:ch/qos/logback/core/layout/EchoLayout.class */
public class EchoLayout<E> extends LayoutBase<E> {
    @Override // p001ch.qos.logback.core.Layout
    public String doLayout(E event) {
        return event + CoreConstants.LINE_SEPARATOR;
    }
}
