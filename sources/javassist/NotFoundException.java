package javassist;

/* loaded from: grasscutter.jar:javassist/NotFoundException.class */
public class NotFoundException extends Exception {
    private static final long serialVersionUID = 1;

    public NotFoundException(String msg) {
        super(msg);
    }

    public NotFoundException(String msg, Exception e) {
        super(msg + " because of " + e.toString());
    }
}
