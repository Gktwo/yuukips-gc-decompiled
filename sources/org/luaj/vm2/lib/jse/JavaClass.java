package org.luaj.vm2.lib.jse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/jse/JavaClass.class */
class JavaClass extends JavaInstance implements CoerceJavaToLua.Coercion {
    static final Map classes = Collections.synchronizedMap(new HashMap());
    static final LuaValue NEW = valueOf("new");
    Map fields;
    Map methods;
    Map innerclasses;

    /* access modifiers changed from: package-private */
    public static JavaClass forClass(Class cls) {
        JavaClass javaClass = (JavaClass) classes.get(cls);
        if (javaClass == null) {
            Map map = classes;
            JavaClass javaClass2 = new JavaClass(cls);
            javaClass = javaClass2;
            map.put(cls, javaClass2);
        }
        return javaClass;
    }

    JavaClass(Class cls) {
        super(cls);
        this.jclass = this;
    }

    @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
    public LuaValue coerce(Object obj) {
        return this;
    }

    /* access modifiers changed from: package-private */
    public Field getField(LuaValue luaValue) {
        if (this.fields == null) {
            HashMap hashMap = new HashMap();
            Field[] fields = ((Class) this.m_instance).getFields();
            for (Field field : fields) {
                if (Modifier.isPublic(field.getModifiers())) {
                    hashMap.put(LuaValue.valueOf(field.getName()), field);
                    try {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                    } catch (SecurityException e) {
                    }
                }
            }
            this.fields = hashMap;
        }
        return (Field) this.fields.get(luaValue);
    }

    /* access modifiers changed from: package-private */
    public LuaValue getMethod(LuaValue luaValue) {
        if (this.methods == null) {
            HashMap hashMap = new HashMap();
            Method[] methods = ((Class) this.m_instance).getMethods();
            for (Method method : methods) {
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    List list = (List) hashMap.get(name);
                    if (list == null) {
                        ArrayList arrayList = new ArrayList();
                        list = arrayList;
                        hashMap.put(name, arrayList);
                    }
                    list.add(JavaMethod.forMethod(method));
                }
            }
            HashMap hashMap2 = new HashMap();
            Constructor<?>[] constructors = ((Class) this.m_instance).getConstructors();
            ArrayList arrayList2 = new ArrayList();
            for (int i = 0; i < constructors.length; i++) {
                if (Modifier.isPublic(constructors[i].getModifiers())) {
                    arrayList2.add(JavaConstructor.forConstructor(constructors[i]));
                }
            }
            switch (arrayList2.size()) {
                case 0:
                    break;
                case 1:
                    hashMap2.put(NEW, arrayList2.get(0));
                    break;
                default:
                    hashMap2.put(NEW, JavaConstructor.forConstructors((JavaConstructor[]) arrayList2.toArray(new JavaConstructor[arrayList2.size()])));
                    break;
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list2 = (List) entry.getValue();
                hashMap2.put(LuaValue.valueOf(str), list2.size() == 1 ? list2.get(0) : JavaMethod.forMethods((JavaMethod[]) list2.toArray(new JavaMethod[list2.size()])));
            }
            this.methods = hashMap2;
        }
        return (LuaValue) this.methods.get(luaValue);
    }

    /* access modifiers changed from: package-private */
    public Class getInnerClass(LuaValue luaValue) {
        if (this.innerclasses == null) {
            HashMap hashMap = new HashMap();
            Class<?>[] classes2 = ((Class) this.m_instance).getClasses();
            for (Class<?> cls : classes2) {
                String name = cls.getName();
                hashMap.put(LuaValue.valueOf(name.substring(Math.max(name.lastIndexOf(36), name.lastIndexOf(46)) + 1)), cls);
            }
            this.innerclasses = hashMap;
        }
        return (Class) this.innerclasses.get(luaValue);
    }

    public LuaValue getConstructor() {
        return getMethod(NEW);
    }
}
