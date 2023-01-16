package p001ch.qos.logback.core.pattern;

/* renamed from: ch.qos.logback.core.pattern.LiteralConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/LiteralConverter.class */
public final class LiteralConverter<E> extends Converter<E> {
    String literal;

    public LiteralConverter(String literal) {
        this.literal = literal;
    }

    @Override // p001ch.qos.logback.core.pattern.Converter
    public String convert(E o) {
        return this.literal;
    }
}
