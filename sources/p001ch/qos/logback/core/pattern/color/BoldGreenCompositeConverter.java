package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.BoldGreenCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/BoldGreenCompositeConverter.class */
public class BoldGreenCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return "1;32";
    }
}
