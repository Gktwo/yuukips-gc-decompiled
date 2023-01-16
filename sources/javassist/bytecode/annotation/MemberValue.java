package javassist.bytecode.annotation;

import java.io.IOException;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:javassist/bytecode/annotation/MemberValue.class */
public abstract class MemberValue {

    /* renamed from: cp */
    ConstPool f3074cp;
    char tag;

    /* access modifiers changed from: package-private */
    public abstract Object getValue(ClassLoader classLoader, ClassPool classPool, Method method) throws ClassNotFoundException;

    /* access modifiers changed from: package-private */
    public abstract Class<?> getType(ClassLoader classLoader) throws ClassNotFoundException;

    public abstract void accept(MemberValueVisitor memberValueVisitor);

    public abstract void write(AnnotationsWriter annotationsWriter) throws IOException;

    /* access modifiers changed from: package-private */
    public MemberValue(char tag, ConstPool cp) {
        this.f3074cp = cp;
        this.tag = tag;
    }

    /* access modifiers changed from: package-private */
    public static Class<?> loadClass(ClassLoader cl, String classname) throws ClassNotFoundException, NoSuchClassError {
        try {
            return Class.forName(convertFromArray(classname), true, cl);
        } catch (LinkageError e) {
            throw new NoSuchClassError(classname, e);
        }
    }

    private static String convertFromArray(String classname) {
        int index = classname.indexOf(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
        if (index == -1) {
            return classname;
        }
        StringBuffer sb = new StringBuffer(Descriptor.m380of(classname.substring(0, index)));
        while (index != -1) {
            sb.insert(0, "[");
            index = classname.indexOf(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI, index + 1);
        }
        return sb.toString().replace('/', '.');
    }
}
