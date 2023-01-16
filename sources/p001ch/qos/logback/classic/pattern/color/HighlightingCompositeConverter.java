package p001ch.qos.logback.classic.pattern.color;

import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;

/* renamed from: ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/color/HighlightingCompositeConverter.class */
public class HighlightingCompositeConverter extends ForegroundCompositeConverterBase<ILoggingEvent> {
    /* access modifiers changed from: protected */
    public String getForegroundColorCode(ILoggingEvent event) {
        switch (event.getLevel().toInt()) {
            case Level.INFO_INT:
                return ANSIConstants.BLUE_FG;
            case 30000:
                return ANSIConstants.RED_FG;
            case Level.ERROR_INT:
                return "1;31";
            default:
                return ANSIConstants.DEFAULT_FG;
        }
    }
}
