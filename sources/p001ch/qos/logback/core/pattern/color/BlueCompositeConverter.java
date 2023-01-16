package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.BlueCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/BlueCompositeConverter.class */
public class BlueCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.BLUE_FG;
    }
}
