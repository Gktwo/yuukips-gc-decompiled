package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.CyanCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/CyanCompositeConverter.class */
public class CyanCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return ANSIConstants.CYAN_FG;
    }
}
