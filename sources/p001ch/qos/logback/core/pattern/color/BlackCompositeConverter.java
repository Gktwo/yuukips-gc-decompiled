package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.BlackCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/BlackCompositeConverter.class */
public class BlackCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.BLACK_FG;
    }
}
