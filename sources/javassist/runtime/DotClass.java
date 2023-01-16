package javassist.runtime;

/* loaded from: grasscutter.jar:javassist/runtime/DotClass.class */
public class DotClass {
    public static NoClassDefFoundError fail(ClassNotFoundException e) {
        return new NoClassDefFoundError(e.getMessage());
    }
}
