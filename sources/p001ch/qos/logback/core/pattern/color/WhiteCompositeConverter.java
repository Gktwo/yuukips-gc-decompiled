package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.WhiteCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/WhiteCompositeConverter.class */
public class WhiteCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.WHITE_FG;
    }
}
