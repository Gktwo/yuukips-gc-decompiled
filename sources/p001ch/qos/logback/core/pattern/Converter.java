package p001ch.qos.logback.core.pattern;

/* renamed from: ch.qos.logback.core.pattern.Converter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/Converter.class */
public abstract class Converter<E> {
    Converter<E> next;

    public abstract String convert(E e);

    public void write(StringBuilder buf, E event) {
        buf.append(convert(event));
    }

    public final void setNext(Converter<E> next) {
        if (this.next != null) {
            throw new IllegalStateException("Next converter has been already set");
        }
        this.next = next;
    }

    public final Converter<E> getNext() {
        return this.next;
    }
}
