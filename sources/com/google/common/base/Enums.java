package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/base/Enums.class */
public final class Enums {
    @GwtIncompatible
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> enumConstantCache = new WeakHashMap();

    private Enums() {
    }

    @GwtIncompatible
    public static Field getField(Enum<?> enumValue) {
        try {
            return enumValue.getDeclaringClass().getDeclaredField(enumValue.name());
        } catch (NoSuchFieldException impossible) {
            throw new AssertionError(impossible);
        }
    }

    public static <T extends Enum<T>> Optional<T> getIfPresent(Class<T> enumClass, String value) {
        Preconditions.checkNotNull(enumClass);
        Preconditions.checkNotNull(value);
        return Platform.getEnumIfPresent(enumClass, value);
    }

    @GwtIncompatible
    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> populateCache(Class<T> enumClass) {
        Map<String, WeakReference<? extends Enum<?>>> result = new HashMap<>();
        Iterator it = EnumSet.allOf(enumClass).iterator();
        while (it.hasNext()) {
            Enum r0 = (Enum) it.next();
            result.put(r0.name(), new WeakReference<>(r0));
        }
        enumConstantCache.put(enumClass, result);
        return result;
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> getEnumConstants(Class<T> enumClass) {
        Map<String, WeakReference<? extends Enum<?>>> constants;
        synchronized (enumConstantCache) {
            constants = enumConstantCache.get(enumClass);
            if (constants == null) {
                constants = populateCache(enumClass);
            }
        }
        return constants;
    }

    public static <T extends Enum<T>> Converter<String, T> stringConverter(Class<T> enumClass) {
        return new StringConverter(enumClass);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/Enums$StringConverter.class */
    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private final Class<T> enumClass;
        private static final long serialVersionUID = 0;

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.base.Enums$StringConverter<T extends java.lang.Enum<T>> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.base.Converter
        protected /* bridge */ /* synthetic */ String doBackward(Object obj) {
            return doBackward((StringConverter<T>) ((Enum) obj));
        }

        StringConverter(Class<T> enumClass) {
            this.enumClass = (Class) Preconditions.checkNotNull(enumClass);
        }

        /* access modifiers changed from: protected */
        public T doForward(String value) {
            return (T) Enum.valueOf(this.enumClass, value);
        }

        protected String doBackward(T enumValue) {
            return enumValue.name();
        }

        @Override // com.google.common.base.Converter, com.google.common.base.Function, java.lang.Object
        public boolean equals(Object object) {
            if (object instanceof StringConverter) {
                return this.enumClass.equals(((StringConverter) object).enumClass);
            }
            return false;
        }

        @Override // java.lang.Object
        public int hashCode() {
            return this.enumClass.hashCode();
        }

        @Override // java.lang.Object
        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }
    }
}
