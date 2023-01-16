package p001ch.qos.logback.core.util;

/* renamed from: ch.qos.logback.core.util.IncompatibleClassException */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/IncompatibleClassException.class */
public class IncompatibleClassException extends Exception {
    private static final long serialVersionUID = -5823372159561159549L;
    Class<?> requestedClass;
    Class<?> obtainedClass;

    /* access modifiers changed from: package-private */
    public IncompatibleClassException(Class<?> requestedClass, Class<?> obtainedClass) {
        this.requestedClass = requestedClass;
        this.obtainedClass = obtainedClass;
    }
}
