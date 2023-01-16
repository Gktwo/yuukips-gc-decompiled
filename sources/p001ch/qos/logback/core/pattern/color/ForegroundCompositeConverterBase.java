package p001ch.qos.logback.core.pattern.color;

import p001ch.qos.logback.core.pattern.CompositeConverter;

/* renamed from: ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/color/ForegroundCompositeConverterBase.class */
public abstract class ForegroundCompositeConverterBase<E> extends CompositeConverter<E> {
    private static final String SET_DEFAULT_COLOR = "\u001b[0;39m";

    protected abstract String getForegroundColorCode(E e);

    @Override // p001ch.qos.logback.core.pattern.CompositeConverter
    protected String transform(E event, String in) {
        return ANSIConstants.ESC_START + getForegroundColorCode(event) + ANSIConstants.ESC_END + in + SET_DEFAULT_COLOR;
    }
}
