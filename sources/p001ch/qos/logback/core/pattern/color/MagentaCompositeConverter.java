package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.MagentaCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/MagentaCompositeConverter.class */
public class MagentaCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.MAGENTA_FG;
    }
}
