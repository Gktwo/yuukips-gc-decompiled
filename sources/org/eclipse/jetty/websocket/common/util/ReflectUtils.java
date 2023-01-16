package org.eclipse.jetty.websocket.common.util;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import okhttp3.HttpUrl;
import org.jline.reader.impl.LineReaderImpl;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/util/ReflectUtils.class */
public class ReflectUtils {

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/util/ReflectUtils$GenericRef.class */
    public static class GenericRef {
        private final Class<?> baseClass;
        private final Class<?> ifaceClass;
        Class<?> genericClass;
        public Type genericType;
        private int genericIndex;

        public GenericRef(Class<?> baseClass, Class<?> ifaceClass) {
            this.baseClass = baseClass;
            this.ifaceClass = ifaceClass;
        }

        public boolean needsUnwrap() {
            return this.genericClass == null && this.genericType != null && (this.genericType instanceof TypeVariable);
        }

        public void setGenericFromType(Type type, int index) {
            this.genericType = type;
            this.genericIndex = index;
            if (type instanceof Class) {
                this.genericClass = (Class) type;
            }
        }

        public String toString() {
            return "GenericRef [baseClass=" + this.baseClass + ", ifaceClass=" + this.ifaceClass + ", genericType=" + this.genericType + ", genericClass=" + this.genericClass + "]";
        }
    }

    private static StringBuilder appendTypeName(StringBuilder sb, Type type, boolean ellipses) {
        if (type instanceof Class) {
            Class<?> ctype = (Class) type;
            if (ctype.isArray()) {
                int dimensions = 0;
                while (ctype.isArray()) {
                    try {
                        dimensions++;
                        ctype = ctype.getComponentType();
                    } catch (Throwable th) {
                    }
                }
                sb.append(ctype.getName());
                for (int i = 0; i < dimensions; i++) {
                    if (ellipses) {
                        sb.append("...");
                        continue;
                    } else {
                        sb.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
                        continue;
                    }
                }
                return sb;
            }
            sb.append(ctype.getName());
        } else {
            sb.append(type.toString());
        }
        return sb;
    }

    public static Class<?> findGenericClassFor(Class<?> baseClass, Class<?> ifaceClass) {
        GenericRef ref = new GenericRef(baseClass, ifaceClass);
        if (resolveGenericRef(ref, baseClass)) {
            return ref.genericClass;
        }
        return null;
    }

    private static int findTypeParameterIndex(Class<?> clazz, TypeVariable<?> needVar) {
        TypeVariable<?>[] params = clazz.getTypeParameters();
        for (int i = 0; i < params.length; i++) {
            if (params[i].getName().equals(needVar.getName())) {
                return i;
            }
        }
        return -1;
    }

    public static boolean isDefaultConstructable(Class<?> clazz) {
        int mods = clazz.getModifiers();
        if (Modifier.isAbstract(mods) || !Modifier.isPublic(mods)) {
            return false;
        }
        try {
            return Modifier.isPublic(clazz.getConstructor(new Class[0]).getModifiers());
        } catch (NoSuchMethodException | SecurityException e) {
            return false;
        }
    }

    private static boolean resolveGenericRef(GenericRef ref, Class<?> clazz, Type type) {
        if (type instanceof Class) {
            if (type != ref.ifaceClass) {
                return resolveGenericRef(ref, type);
            }
            ref.setGenericFromType(type, 0);
            return true;
        } else if (!(type instanceof ParameterizedType)) {
            return false;
        } else {
            ParameterizedType ptype = (ParameterizedType) type;
            Type rawType = ptype.getRawType();
            if (rawType != ref.ifaceClass) {
                return resolveGenericRef(ref, rawType);
            }
            ref.setGenericFromType(ptype.getActualTypeArguments()[0], 0);
            return true;
        }
    }

    private static boolean resolveGenericRef(GenericRef ref, Type type) {
        if (type == null || type == Object.class) {
            return false;
        }
        if (type instanceof Class) {
            Class<?> clazz = (Class) type;
            if (clazz.getName().matches("^javax*\\..*")) {
                return false;
            }
            Type[] ifaces = clazz.getGenericInterfaces();
            for (Type iface : ifaces) {
                if (resolveGenericRef(ref, clazz, iface)) {
                    if (!ref.needsUnwrap()) {
                        return true;
                    } else {
                        int typeParamIdx = findTypeParameterIndex(clazz, (TypeVariable) ref.genericType);
                        if (typeParamIdx >= 0) {
                            TypeVariable<?>[] params = clazz.getTypeParameters();
                            if (params.length < typeParamIdx) {
                                return true;
                            }
                            ref.setGenericFromType(params[typeParamIdx], typeParamIdx);
                            return true;
                        } else if (!(iface instanceof ParameterizedType)) {
                            return true;
                        } else {
                            ref.setGenericFromType(((ParameterizedType) iface).getActualTypeArguments()[ref.genericIndex], ref.genericIndex);
                            return true;
                        }
                    }
                }
            }
            return resolveGenericRef(ref, clazz.getGenericSuperclass());
        } else if (!(type instanceof ParameterizedType)) {
            return false;
        } else {
            ParameterizedType ptype = (ParameterizedType) type;
            Class<?> rawClass = (Class) ptype.getRawType();
            if (!resolveGenericRef(ref, rawClass) || !ref.needsUnwrap()) {
                return false;
            }
            int typeParamIdx2 = findTypeParameterIndex(rawClass, (TypeVariable) ref.genericType);
            ref.setGenericFromType(ptype.getActualTypeArguments()[typeParamIdx2], typeParamIdx2);
            return true;
        }
    }

    public static String toShortName(Type type) {
        if (type == null) {
            return "<null>";
        }
        if (type instanceof Class) {
            return trimClassName(((Class) type).getName());
        }
        if (!(type instanceof ParameterizedType)) {
            return type.toString();
        }
        ParameterizedType ptype = (ParameterizedType) type;
        StringBuilder str = new StringBuilder();
        str.append(trimClassName(((Class) ptype.getRawType()).getName()));
        str.append("<");
        Type[] args = ptype.getActualTypeArguments();
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                str.append(",");
            }
            str.append(args[i]);
        }
        str.append(">");
        return str.toString();
    }

    public static String toString(Class<?> pojo, Method method) {
        StringBuilder str = new StringBuilder();
        int mod = method.getModifiers() & Modifier.methodModifiers();
        if (mod != 0) {
            str.append(Modifier.toString(mod)).append(' ');
        }
        appendTypeName(str, method.getGenericReturnType(), false).append(' ');
        str.append(pojo.getName());
        str.append(LineReaderImpl.DEFAULT_COMMENT_BEGIN);
        str.append(method.getName());
        str.append('(');
        Type[] params = method.getGenericParameterTypes();
        int j = 0;
        while (j < params.length) {
            appendTypeName(str, params[j], method.isVarArgs() && j == params.length - 1);
            if (j < params.length - 1) {
                str.append(", ");
            }
            j++;
        }
        str.append(')');
        return str.toString();
    }

    public static String trimClassName(String name) {
        String name2 = name.substring(name.lastIndexOf(46) + 1);
        int idx = name2.lastIndexOf(36);
        if (idx >= 0) {
            name2 = name2.substring(idx + 1);
        }
        return name2;
    }
}
