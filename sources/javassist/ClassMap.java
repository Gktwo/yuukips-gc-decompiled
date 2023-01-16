package javassist;

import java.util.HashMap;
import javassist.bytecode.Descriptor;

/* loaded from: grasscutter.jar:javassist/ClassMap.class */
public class ClassMap extends HashMap<String, String> {
    private static final long serialVersionUID = 1;
    private ClassMap parent;

    public ClassMap() {
        this.parent = null;
    }

    /* access modifiers changed from: package-private */
    public ClassMap(ClassMap map) {
        this.parent = map;
    }

    public void put(CtClass oldname, CtClass newname) {
        put(oldname.getName(), newname.getName());
    }

    public String put(String oldname, String newname) {
        if (oldname == newname) {
            return oldname;
        }
        String oldname2 = toJvmName(oldname);
        String s = get((Object) oldname2);
        if (s == null || !s.equals(oldname2)) {
            return put((ClassMap) oldname2, toJvmName(newname));
        }
        return s;
    }

    public void putIfNone(String oldname, String newname) {
        if (oldname != newname) {
            String oldname2 = toJvmName(oldname);
            if (get((Object) oldname2) == null) {
                put((ClassMap) oldname2, toJvmName(newname));
            }
        }
    }

    protected final String put0(String oldname, String newname) {
        return put((ClassMap) oldname, newname);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public String get(Object jvmClassName) {
        String found = get(jvmClassName);
        if (found != null || this.parent == null) {
            return found;
        }
        return this.parent.get(jvmClassName);
    }

    public void fix(CtClass clazz) {
        fix(clazz.getName());
    }

    public void fix(String name) {
        String name2 = toJvmName(name);
        put((ClassMap) name2, name2);
    }

    public static String toJvmName(String classname) {
        return Descriptor.toJvmName(classname);
    }

    public static String toJavaName(String classname) {
        return Descriptor.toJavaName(classname);
    }
}
