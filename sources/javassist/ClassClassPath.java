package javassist;

import java.io.InputStream;
import java.net.URL;

/* loaded from: grasscutter.jar:javassist/ClassClassPath.class */
public class ClassClassPath implements ClassPath {
    private Class<?> thisClass;

    public ClassClassPath(Class<?> c) {
        this.thisClass = c;
    }

    /* access modifiers changed from: package-private */
    public ClassClassPath() {
        this(Object.class);
    }

    @Override // javassist.ClassPath
    public InputStream openClassfile(String classname) throws NotFoundException {
        return this.thisClass.getResourceAsStream('/' + classname.replace('.', '/') + ".class");
    }

    @Override // javassist.ClassPath
    public URL find(String classname) {
        return this.thisClass.getResource('/' + classname.replace('.', '/') + ".class");
    }

    public String toString() {
        return this.thisClass.getName() + ".class";
    }
}
