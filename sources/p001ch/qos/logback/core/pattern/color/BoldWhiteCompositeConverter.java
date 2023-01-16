package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/BoldWhiteCompositeConverter.class */
public class BoldWhiteCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return "1;37";
    }
}
