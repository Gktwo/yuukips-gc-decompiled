package p013io.github.classgraph;

/* renamed from: io.github.classgraph.ClassGraphException */
/* loaded from: grasscutter.jar:io/github/classgraph/ClassGraphException.class */
public class ClassGraphException extends IllegalArgumentException {
    static final long serialVersionUID = 1;

    private ClassGraphException(String message) {
        super(message);
    }

    private ClassGraphException(String message, Throwable cause) {
        super(message, cause);
    }

    public static ClassGraphException newClassGraphException(String message) {
        return new ClassGraphException(message);
    }

    public static ClassGraphException newClassGraphException(String message, Throwable cause) throws ClassGraphException {
        return new ClassGraphException(message, cause);
    }
}
