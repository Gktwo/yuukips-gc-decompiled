package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.YellowCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/YellowCompositeConverter.class */
public class YellowCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.YELLOW_FG;
    }
}
