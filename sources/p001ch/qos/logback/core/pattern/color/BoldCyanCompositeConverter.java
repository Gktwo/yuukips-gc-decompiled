package p001ch.qos.logback.core.pattern.color;

/* renamed from: ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/BoldCyanCompositeConverter.class */
public class BoldCyanCompositeConverter<E> extends ForegroundCompositeConverterBase<E> {
    @Override // p001ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase
    protected String getForegroundColorCode(E event) {
        return "1;36";
    }
}
