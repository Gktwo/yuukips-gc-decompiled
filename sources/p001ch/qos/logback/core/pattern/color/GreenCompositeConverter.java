package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.GreenCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/GreenCompositeConverter.class */
public class GreenCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.GREEN_FG;
    }
}
