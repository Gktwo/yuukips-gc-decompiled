package org.luaj.vm2.server;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/* loaded from: grasscutter.jar:org/luaj/vm2/server/LuajClassLoader.class */
public class LuajClassLoader extends ClassLoader {
    static final String luajPackageRoot = "org.luaj.vm2.";
    static final String launcherInterfaceRoot = Launcher.class.getName();
    Map<String, Class<?>> classes = new HashMap();

    public static Launcher NewLauncher() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return NewLauncher(DefaultLauncher.class);
    }

    public static Launcher NewLauncher(Class<? extends Launcher> cls) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return (Launcher) new LuajClassLoader().loadAsUserClass(cls.getName()).newInstance();
    }

    public static boolean isUserClass(String str) {
        return str.startsWith(luajPackageRoot) && !str.startsWith(launcherInterfaceRoot);
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        return this.classes.containsKey(str) ? this.classes.get(str) : !isUserClass(str) ? findSystemClass(str) : loadAsUserClass(str);
    }

    private Class<?> loadAsUserClass(String str) throws ClassNotFoundException {
        InputStream resourceAsStream = getResourceAsStream(str.replace('.', '/').concat(".class"));
        if (resourceAsStream != null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = resourceAsStream.read(bArr);
                    if (read >= 0) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        byte[] byteArray = byteArrayOutputStream.toByteArray();
                        Class<?> defineClass = defineClass(str, byteArray, 0, byteArray.length);
                        this.classes.put(str, defineClass);
                        return defineClass;
                    }
                }
            } catch (IOException e) {
                throw new ClassNotFoundException("Read failed: " + str + ": " + e);
            }
        } else {
            throw new ClassNotFoundException("Not found: " + str);
        }
    }
}
