package p001ch.qos.logback.core.sift;

/* renamed from: ch.qos.logback.core.sift.DefaultDiscriminator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/sift/DefaultDiscriminator.class */
public class DefaultDiscriminator<E> extends AbstractDiscriminator<E> {
    public static final String DEFAULT = "default";

    @Override // p001ch.qos.logback.core.sift.Discriminator
    public String getDiscriminatingValue(E e) {
        return "default";
    }

    @Override // p001ch.qos.logback.core.sift.Discriminator
    public String getKey() {
        return "default";
    }
}
