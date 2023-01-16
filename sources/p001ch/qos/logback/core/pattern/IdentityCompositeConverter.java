package p001ch.qos.logback.core.pattern;

/* renamed from: ch.qos.logback.core.pattern.IdentityCompositeConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/IdentityCompositeConverter.class */
public class IdentityCompositeConverter<E> extends CompositeConverter<E> {
    @Override // p001ch.qos.logback.core.pattern.CompositeConverter
    protected String transform(E event, String in) {
        return in;
    }
}
