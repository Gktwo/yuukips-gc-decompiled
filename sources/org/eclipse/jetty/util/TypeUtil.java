package org.eclipse.jetty.util;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p001ch.qos.logback.core.CoreConstants;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/TypeUtil.class */
public class TypeUtil {

    /* renamed from: CR */
    public static final int f3164CR = 13;

    /* renamed from: LF */
    public static final int f3165LF = 10;
    private static final List<Function<Class<?>, URI>> LOCATION_METHODS;
    private static final Function<Class<?>, URI> MODULE_LOCATION;
    private static final Logger LOG = Log.getLogger(TypeUtil.class);
    public static final Class<?>[] NO_ARGS = new Class[0];
    private static final HashMap<String, Class<?>> name2Class = new HashMap<>();
    private static final HashMap<Class<?>, String> class2Name = new HashMap<>();
    private static final HashMap<Class<?>, Method> class2Value = new HashMap<>();

    static {
        name2Class.put("boolean", Boolean.TYPE);
        name2Class.put("byte", Byte.TYPE);
        name2Class.put("char", Character.TYPE);
        name2Class.put("double", Double.TYPE);
        name2Class.put("float", Float.TYPE);
        name2Class.put("int", Integer.TYPE);
        name2Class.put("long", Long.TYPE);
        name2Class.put("short", Short.TYPE);
        name2Class.put("void", Void.TYPE);
        name2Class.put("java.lang.Boolean.TYPE", Boolean.TYPE);
        name2Class.put("java.lang.Byte.TYPE", Byte.TYPE);
        name2Class.put("java.lang.Character.TYPE", Character.TYPE);
        name2Class.put("java.lang.Double.TYPE", Double.TYPE);
        name2Class.put("java.lang.Float.TYPE", Float.TYPE);
        name2Class.put("java.lang.Integer.TYPE", Integer.TYPE);
        name2Class.put("java.lang.Long.TYPE", Long.TYPE);
        name2Class.put("java.lang.Short.TYPE", Short.TYPE);
        name2Class.put("java.lang.Void.TYPE", Void.TYPE);
        name2Class.put("java.lang.Boolean", Boolean.class);
        name2Class.put("java.lang.Byte", Byte.class);
        name2Class.put("java.lang.Character", Character.class);
        name2Class.put("java.lang.Double", Double.class);
        name2Class.put("java.lang.Float", Float.class);
        name2Class.put("java.lang.Integer", Integer.class);
        name2Class.put("java.lang.Long", Long.class);
        name2Class.put("java.lang.Short", Short.class);
        name2Class.put("Boolean", Boolean.class);
        name2Class.put("Byte", Byte.class);
        name2Class.put("Character", Character.class);
        name2Class.put("Double", Double.class);
        name2Class.put("Float", Float.class);
        name2Class.put("Integer", Integer.class);
        name2Class.put("Long", Long.class);
        name2Class.put("Short", Short.class);
        name2Class.put(null, Void.TYPE);
        name2Class.put("string", String.class);
        name2Class.put("String", String.class);
        name2Class.put("java.lang.String", String.class);
        class2Name.put(Boolean.TYPE, "boolean");
        class2Name.put(Byte.TYPE, "byte");
        class2Name.put(Character.TYPE, "char");
        class2Name.put(Double.TYPE, "double");
        class2Name.put(Float.TYPE, "float");
        class2Name.put(Integer.TYPE, "int");
        class2Name.put(Long.TYPE, "long");
        class2Name.put(Short.TYPE, "short");
        class2Name.put(Void.TYPE, "void");
        class2Name.put(Boolean.class, "java.lang.Boolean");
        class2Name.put(Byte.class, "java.lang.Byte");
        class2Name.put(Character.class, "java.lang.Character");
        class2Name.put(Double.class, "java.lang.Double");
        class2Name.put(Float.class, "java.lang.Float");
        class2Name.put(Integer.class, "java.lang.Integer");
        class2Name.put(Long.class, "java.lang.Long");
        class2Name.put(Short.class, "java.lang.Short");
        class2Name.put(null, "void");
        class2Name.put(String.class, "java.lang.String");
        try {
            Class<?>[] s = {String.class};
            class2Value.put(Boolean.TYPE, Boolean.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Byte.TYPE, Byte.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Double.TYPE, Double.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Float.TYPE, Float.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Integer.TYPE, Integer.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Long.TYPE, Long.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Short.TYPE, Short.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Boolean.class, Boolean.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Byte.class, Byte.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Double.class, Double.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Float.class, Float.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Integer.class, Integer.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Long.class, Long.class.getMethod(CoreConstants.VALUE_OF, s));
            class2Value.put(Short.class, Short.class.getMethod(CoreConstants.VALUE_OF, s));
            LOCATION_METHODS = new ArrayList();
            LOCATION_METHODS.add(TypeUtil::getCodeSourceLocation);
            Function<Class<?>, URI> moduleFunc = null;
            try {
                Object obj = TypeUtil.class.getClassLoader().loadClass(TypeUtil.class.getPackage().getName() + ".ModuleLocation").getConstructor(new Class[0]).newInstance(new Object[0]);
                if (obj instanceof Function) {
                    moduleFunc = (Function) obj;
                    LOCATION_METHODS.add(moduleFunc);
                }
            } catch (Throwable th) {
                LOG.debug("This JVM Runtime does not support Modules, disabling Jetty internal support", new Object[0]);
            }
            MODULE_LOCATION = moduleFunc;
            LOCATION_METHODS.add(TypeUtil::getClassLoaderLocation);
            LOCATION_METHODS.add(TypeUtil::getSystemClassLoaderLocation);
        } catch (Exception e) {
            throw new Error(e);
        }
    }

    public static <T> List<T> asList(T[] a) {
        if (a == null) {
            return Collections.emptyList();
        }
        return Arrays.asList(a);
    }

    public static Class<?> fromName(String name) {
        return name2Class.get(name);
    }

    public static String toName(Class<?> type) {
        return class2Name.get(type);
    }

    public static String toClassReference(Class<?> clazz) {
        return toClassReference(clazz.getName());
    }

    public static String toClassReference(String className) {
        return StringUtil.replace(className, '.', '/').concat(".class");
    }

    public static Object valueOf(Class<?> type, String value) {
        try {
            try {
                if (type.equals(String.class)) {
                    return value;
                }
                Method m = class2Value.get(type);
                if (m != null) {
                    return m.invoke(null, value);
                }
                if (type.equals(Character.TYPE) || type.equals(Character.class)) {
                    return Character.valueOf(value.charAt(0));
                }
                return type.getConstructor(String.class).newInstance(value);
            } catch (InvocationTargetException x) {
                if (x.getTargetException() instanceof Error) {
                    throw ((Error) x.getTargetException());
                }
                LOG.ignore(x);
                return null;
            }
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException x2) {
            LOG.ignore(x2);
            return null;
        }
    }

    public static Object valueOf(String type, String value) {
        return valueOf(fromName(type), value);
    }

    public static int parseInt(String s, int offset, int length, int base) throws NumberFormatException {
        int value = 0;
        if (length < 0) {
            length = s.length() - offset;
        }
        for (int i = 0; i < length; i++) {
            int digit = convertHexDigit((int) s.charAt(offset + i));
            if (digit < 0 || digit >= base) {
                throw new NumberFormatException(s.substring(offset, offset + length));
            }
            value = (value * base) + digit;
        }
        return value;
    }

    public static int parseInt(byte[] b, int offset, int length, int base) throws NumberFormatException {
        int value = 0;
        if (length < 0) {
            length = b.length - offset;
        }
        for (int i = 0; i < length; i++) {
            char c = (char) (255 & b[offset + i]);
            int digit = c - '0';
            if (digit < 0 || digit >= base || digit >= 10) {
                digit = ('\n' + c) - 65;
                if (digit < 10 || digit >= base) {
                    digit = ('\n' + c) - 97;
                }
            }
            if (digit < 0 || digit >= base) {
                throw new NumberFormatException(new String(b, offset, length));
            }
            value = (value * base) + digit;
        }
        return value;
    }

    public static byte[] parseBytes(String s, int base) {
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < s.length(); i += 2) {
            bytes[i / 2] = (byte) parseInt(s, i, 2, base);
        }
        return bytes;
    }

    public static String toString(byte[] bytes, int base) {
        StringBuilder buf = new StringBuilder();
        for (byte b : bytes) {
            int bi = 255 & b;
            int c = 48 + ((bi / base) % base);
            if (c > 57) {
                c = 97 + ((c - 48) - 10);
            }
            buf.append((char) c);
            int c2 = 48 + (bi % base);
            if (c2 > 57) {
                c2 = 97 + ((c2 - 48) - 10);
            }
            buf.append((char) c2);
        }
        return buf.toString();
    }

    public static byte convertHexDigit(byte c) {
        byte b = (byte) (((c & 31) + ((c >> 6) * 25)) - 16);
        if (b >= 0 && b <= 15) {
            return b;
        }
        throw new NumberFormatException("!hex " + ((int) c));
    }

    public static int convertHexDigit(char c) {
        int d = ((c & 31) + ((c >> 6) * 25)) - 16;
        if (d >= 0 && d <= 15) {
            return d;
        }
        throw new NumberFormatException("!hex " + c);
    }

    public static int convertHexDigit(int c) {
        int d = ((c & 31) + ((c >> 6) * 25)) - 16;
        if (d >= 0 && d <= 15) {
            return d;
        }
        throw new NumberFormatException("!hex " + c);
    }

    public static void toHex(byte b, Appendable buf) {
        try {
            int d = 15 & ((240 & b) >> 4);
            buf.append((char) ((d > 9 ? 55 : 48) + d));
            int d2 = 15 & b;
            buf.append((char) ((d2 > 9 ? 55 : 48) + d2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void toHex(int value, Appendable buf) throws IOException {
        int d = 15 & ((-268435456 & value) >> 28);
        buf.append((char) ((d > 9 ? 55 : 48) + d));
        int d2 = 15 & ((251658240 & value) >> 24);
        buf.append((char) ((d2 > 9 ? 55 : 48) + d2));
        int d3 = 15 & ((15728640 & value) >> 20);
        buf.append((char) ((d3 > 9 ? 55 : 48) + d3));
        int d4 = 15 & ((983040 & value) >> 16);
        buf.append((char) ((d4 > 9 ? 55 : 48) + d4));
        int d5 = 15 & ((61440 & value) >> 12);
        buf.append((char) ((d5 > 9 ? 55 : 48) + d5));
        int d6 = 15 & ((3840 & value) >> 8);
        buf.append((char) ((d6 > 9 ? 55 : 48) + d6));
        int d7 = 15 & ((240 & value) >> 4);
        buf.append((char) ((d7 > 9 ? 55 : 48) + d7));
        int d8 = 15 & value;
        buf.append((char) ((d8 > 9 ? 55 : 48) + d8));
        Integer.toString(0, 36);
    }

    public static void toHex(long value, Appendable buf) throws IOException {
        toHex((int) (value >> 32), buf);
        toHex((int) value, buf);
    }

    public static String toHexString(byte b) {
        return toHexString(new byte[]{b}, 0, 1);
    }

    public static String toHexString(byte[] b) {
        return toHexString(b, 0, b.length);
    }

    public static String toHexString(byte[] b, int offset, int length) {
        StringBuilder buf = new StringBuilder();
        for (int i = offset; i < offset + length; i++) {
            int bi = 255 & b[i];
            int c = 48 + ((bi / 16) % 16);
            if (c > 57) {
                c = 65 + ((c - 48) - 10);
            }
            buf.append((char) c);
            int c2 = 48 + (bi % 16);
            if (c2 > 57) {
                c2 = 97 + ((c2 - 48) - 10);
            }
            buf.append((char) c2);
        }
        return buf.toString();
    }

    public static byte[] fromHexString(String s) {
        if (s.length() % 2 != 0) {
            throw new IllegalArgumentException(s);
        }
        byte[] array = new byte[s.length() / 2];
        for (int i = 0; i < array.length; i++) {
            array[i] = (byte) (255 & Integer.parseInt(s.substring(i * 2, (i * 2) + 2), 16));
        }
        return array;
    }

    public static void dump(Class<?> c) {
        System.err.println("Dump: " + c);
        dump(c.getClassLoader());
    }

    public static void dump(ClassLoader cl) {
        System.err.println("Dump Loaders:");
        while (cl != null) {
            System.err.println("  loader " + cl);
            cl = cl.getParent();
        }
    }

    @Deprecated
    public static Object call(Class<?> oClass, String methodName, Object obj, Object[] arg) throws InvocationTargetException, NoSuchMethodException {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static Object construct(Class<?> klass, Object[] arguments) throws InvocationTargetException, NoSuchMethodException {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public static Object construct(Class<?> klass, Object[] arguments, Map<String, Object> namedArgMap) throws InvocationTargetException, NoSuchMethodException {
        throw new UnsupportedOperationException();
    }

    public static boolean isTrue(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Boolean) {
            return ((Boolean) o).booleanValue();
        }
        return Boolean.parseBoolean(o.toString());
    }

    public static boolean isFalse(Object o) {
        if (o == null) {
            return false;
        }
        if (o instanceof Boolean) {
            return !((Boolean) o).booleanValue();
        }
        return "false".equalsIgnoreCase(o.toString());
    }

    public static URI getLocationOfClass(Class<?> clazz) {
        URI location;
        for (Function<Class<?>, URI> locationFunction : LOCATION_METHODS) {
            try {
                location = locationFunction.apply(clazz);
            } catch (Throwable cause) {
                cause.printStackTrace(System.err);
            }
            if (location != null) {
                return location;
            }
        }
        return null;
    }

    public static URI getClassLoaderLocation(Class<?> clazz) {
        return getClassLoaderLocation(clazz, clazz.getClassLoader());
    }

    public static URI getSystemClassLoaderLocation(Class<?> clazz) {
        return getClassLoaderLocation(clazz, ClassLoader.getSystemClassLoader());
    }

    public static URI getClassLoaderLocation(Class<?> clazz, ClassLoader loader) {
        URL url;
        String uriStr;
        int idx;
        if (loader == null) {
            return null;
        }
        try {
            String resourceName = toClassReference(clazz);
            if (loader == null || (url = loader.getResource(resourceName)) == null) {
                return null;
            }
            URI uri = url.toURI();
            String uriStr2 = uri.toASCIIString();
            if (!uriStr2.startsWith("jar:file:") || (idx = (uriStr = uriStr2.substring(4)).indexOf("!/")) <= 0) {
                return uri;
            }
            return URI.create(uriStr.substring(0, idx));
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static URI getCodeSourceLocation(Class<?> clazz) {
        CodeSource source;
        URL location;
        try {
            ProtectionDomain domain = (ProtectionDomain) AccessController.doPrivileged(() -> {
                return clazz.getProtectionDomain();
            });
            if (domain == null || (source = domain.getCodeSource()) == null || (location = source.getLocation()) == null) {
                return null;
            }
            return location.toURI();
        } catch (URISyntaxException e) {
            return null;
        }
    }

    public static URI getModuleLocation(Class<?> clazz) {
        if (MODULE_LOCATION != null) {
            return MODULE_LOCATION.apply(clazz);
        }
        return null;
    }
}
