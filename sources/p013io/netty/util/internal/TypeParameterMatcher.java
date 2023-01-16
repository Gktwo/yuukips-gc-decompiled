package p013io.netty.util.internal;

import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.HashMap;
import java.util.Map;

/* renamed from: io.netty.util.internal.TypeParameterMatcher */
/* loaded from: grasscutter.jar:io/netty/util/internal/TypeParameterMatcher.class */
public abstract class TypeParameterMatcher {
    private static final TypeParameterMatcher NOOP = new TypeParameterMatcher() { // from class: io.netty.util.internal.TypeParameterMatcher.1
        @Override // p013io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object msg) {
            return true;
        }
    };

    public abstract boolean match(Object obj);

    public static TypeParameterMatcher get(Class<?> parameterType) {
        Map<Class<?>, TypeParameterMatcher> getCache = InternalThreadLocalMap.get().typeParameterMatcherGetCache();
        TypeParameterMatcher matcher = getCache.get(parameterType);
        if (matcher == null) {
            if (parameterType == Object.class) {
                matcher = NOOP;
            } else {
                matcher = new ReflectiveMatcher(parameterType);
            }
            getCache.put(parameterType, matcher);
        }
        return matcher;
    }

    public static TypeParameterMatcher find(Object object, Class<?> parametrizedSuperclass, String typeParamName) {
        Map<Class<?>, Map<String, TypeParameterMatcher>> findCache = InternalThreadLocalMap.get().typeParameterMatcherFindCache();
        Class<?> thisClass = object.getClass();
        Map<String, TypeParameterMatcher> map = findCache.get(thisClass);
        if (map == null) {
            map = new HashMap();
            findCache.put(thisClass, map);
        }
        TypeParameterMatcher matcher = map.get(typeParamName);
        if (matcher == null) {
            matcher = get(find0(object, parametrizedSuperclass, typeParamName));
            map.put(typeParamName, matcher);
        }
        return matcher;
    }

    private static Class<?> find0(Object object, Class<?> parametrizedSuperclass, String typeParamName) {
        Class<?> thisClass = object.getClass();
        Class<?> currentClass = thisClass;
        while (true) {
            if (currentClass.getSuperclass() == parametrizedSuperclass) {
                int typeParamIndex = -1;
                TypeVariable<?>[] typeParams = currentClass.getSuperclass().getTypeParameters();
                int i = 0;
                while (true) {
                    if (i >= typeParams.length) {
                        break;
                    } else if (typeParamName.equals(typeParams[i].getName())) {
                        typeParamIndex = i;
                        break;
                    } else {
                        i++;
                    }
                }
                if (typeParamIndex < 0) {
                    throw new IllegalStateException("unknown type parameter '" + typeParamName + "': " + parametrizedSuperclass);
                }
                Type genericSuperType = currentClass.getGenericSuperclass();
                if (!(genericSuperType instanceof ParameterizedType)) {
                    return Object.class;
                }
                Type actualTypeParam = ((ParameterizedType) genericSuperType).getActualTypeArguments()[typeParamIndex];
                if (actualTypeParam instanceof ParameterizedType) {
                    actualTypeParam = ((ParameterizedType) actualTypeParam).getRawType();
                }
                if (actualTypeParam instanceof Class) {
                    return (Class) actualTypeParam;
                }
                if (actualTypeParam instanceof GenericArrayType) {
                    Type componentType = ((GenericArrayType) actualTypeParam).getGenericComponentType();
                    if (componentType instanceof ParameterizedType) {
                        componentType = ((ParameterizedType) componentType).getRawType();
                    }
                    if (componentType instanceof Class) {
                        return Array.newInstance((Class) componentType, 0).getClass();
                    }
                }
                if (!(actualTypeParam instanceof TypeVariable)) {
                    return fail(thisClass, typeParamName);
                }
                TypeVariable<?> v = (TypeVariable) actualTypeParam;
                if (!(v.getGenericDeclaration() instanceof Class)) {
                    return Object.class;
                }
                currentClass = thisClass;
                parametrizedSuperclass = (Class) v.getGenericDeclaration();
                typeParamName = v.getName();
                if (!parametrizedSuperclass.isAssignableFrom(thisClass)) {
                    return Object.class;
                }
            } else {
                currentClass = currentClass.getSuperclass();
                if (currentClass == null) {
                    return fail(thisClass, typeParamName);
                }
            }
        }
    }

    private static Class<?> fail(Class<?> type, String typeParamName) {
        throw new IllegalStateException("cannot determine the type of the type parameter '" + typeParamName + "': " + type);
    }

    /* access modifiers changed from: private */
    /* renamed from: io.netty.util.internal.TypeParameterMatcher$ReflectiveMatcher */
    /* loaded from: grasscutter.jar:io/netty/util/internal/TypeParameterMatcher$ReflectiveMatcher.class */
    public static final class ReflectiveMatcher extends TypeParameterMatcher {
        private final Class<?> type;

        ReflectiveMatcher(Class<?> type) {
            this.type = type;
        }

        @Override // p013io.netty.util.internal.TypeParameterMatcher
        public boolean match(Object msg) {
            return this.type.isInstance(msg);
        }
    }
}
