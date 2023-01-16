package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.RedCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/RedCompositeConverter.class */
public class RedCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.RED_FG;
    }
}
