package com.mchange.p009v2.lang.reflect;

import java.lang.reflect.Method;
import java.util.Comparator;

/* renamed from: com.mchange.v2.lang.reflect.MethodUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/lang/reflect/MethodUtils.class */
public final class MethodUtils {
    public static final Comparator METHOD_COMPARATOR = new Comparator() { // from class: com.mchange.v2.lang.reflect.MethodUtils.1
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            Method method = (Method) obj;
            Method method2 = (Method) obj2;
            String name = method.getName();
            String name2 = method2.getName();
            int compare = String.CASE_INSENSITIVE_ORDER.compare(name, name2);
            if (compare == 0) {
                if (name.equals(name2)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Class<?>[] parameterTypes2 = method2.getParameterTypes();
                    if (parameterTypes.length < parameterTypes2.length) {
                        compare = -1;
                    } else if (parameterTypes.length > parameterTypes2.length) {
                        compare = 1;
                    } else {
                        int length = parameterTypes.length;
                        for (int i = 0; i < length; i++) {
                            compare = parameterTypes[i].getName().compareTo(parameterTypes2[i].getName());
                            if (compare != 0) {
                                break;
                            }
                        }
                    }
                } else {
                    compare = name.compareTo(name2);
                }
            }
            return compare;
        }
    };
}
