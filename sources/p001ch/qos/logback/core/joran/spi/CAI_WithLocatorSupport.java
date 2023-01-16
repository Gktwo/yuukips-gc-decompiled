package p001ch.qos.logback.core.joran.spi;

import org.xml.sax.Locator;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.spi.ContextAwareImpl;
import p013io.javalin.http.sse.EmitterKt;

/* compiled from: Interpreter.java */
/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.joran.spi.CAI_WithLocatorSupport */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/CAI_WithLocatorSupport.class */
public class CAI_WithLocatorSupport extends ContextAwareImpl {
    /* access modifiers changed from: package-private */
    public CAI_WithLocatorSupport(Context context, Interpreter interpreter) {
        super(context, interpreter);
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.spi.ContextAwareImpl
    public Object getOrigin() {
        Locator locator = ((Interpreter) getOrigin()).locator;
        if (locator != null) {
            return Interpreter.class.getName() + "@" + locator.getLineNumber() + EmitterKt.COMMENT_PREFIX + locator.getColumnNumber();
        }
        return Interpreter.class.getName() + "@NA:NA";
    }
}
