package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.AnnotationIntrospector;
import com.fasterxml.jackson.databind.DeserializationConfig;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/util/EnumResolver.class */
public class EnumResolver implements Serializable {
    private static final long serialVersionUID = 1;
    protected final Class<Enum<?>> _enumClass;
    protected final Enum<?>[] _enums;
    protected final HashMap<String, Enum<?>> _enumsById;
    protected final Enum<?> _defaultValue;
    protected final boolean _isIgnoreCase;
    protected final boolean _isFromIntValue;

    protected EnumResolver(Class<Enum<?>> enumClass, Enum<?>[] enums, HashMap<String, Enum<?>> map, Enum<?> defaultValue, boolean isIgnoreCase, boolean isFromIntValue) {
        this._enumClass = enumClass;
        this._enums = enums;
        this._enumsById = map;
        this._defaultValue = defaultValue;
        this._isIgnoreCase = isIgnoreCase;
        this._isFromIntValue = isFromIntValue;
    }

    @Deprecated
    protected EnumResolver(Class<Enum<?>> enumClass, Enum<?>[] enums, HashMap<String, Enum<?>> map, Enum<?> defaultValue, boolean isIgnoreCase) {
        this(enumClass, enums, map, defaultValue, isIgnoreCase, false);
    }

    public static EnumResolver constructFor(DeserializationConfig config, Class<?> enumCls) {
        return _constructFor(enumCls, config.getAnnotationIntrospector(), config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    protected static EnumResolver _constructFor(Class<?> enumCls0, AnnotationIntrospector ai, boolean isIgnoreCase) {
        Class<Enum<?>> enumCls = _enumClass(enumCls0);
        Enum<?>[] enumConstants = _enumConstants(enumCls0);
        String[] names = ai.findEnumValues(enumCls, enumConstants, new String[enumConstants.length]);
        String[][] allAliases = new String[names.length];
        ai.findEnumAliases(enumCls, enumConstants, allAliases);
        HashMap<String, Enum<?>> map = new HashMap<>();
        int len = enumConstants.length;
        for (int i = 0; i < len; i++) {
            Enum<?> enumValue = enumConstants[i];
            String name = names[i];
            if (name == null) {
                name = enumValue.name();
            }
            map.put(name, enumValue);
            String[] aliases = allAliases[i];
            if (aliases != null) {
                for (String alias : aliases) {
                    if (!map.containsKey(alias)) {
                        map.put(alias, enumValue);
                    }
                }
            }
        }
        return new EnumResolver(enumCls, enumConstants, map, _enumDefault(ai, enumCls), isIgnoreCase, false);
    }

    public static EnumResolver constructUsingToString(DeserializationConfig config, Class<?> enumCls) {
        return _constructUsingToString(enumCls, config.getAnnotationIntrospector(), config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    protected static EnumResolver _constructUsingToString(Class<?> enumCls0, AnnotationIntrospector ai, boolean isIgnoreCase) {
        Class<Enum<?>> enumCls = _enumClass(enumCls0);
        Enum<?>[] enumConstants = _enumConstants(enumCls0);
        HashMap<String, Enum<?>> map = new HashMap<>();
        String[][] allAliases = new String[enumConstants.length];
        if (ai != null) {
            ai.findEnumAliases(enumCls, enumConstants, allAliases);
        }
        int i = enumConstants.length;
        while (true) {
            i--;
            if (i < 0) {
                return new EnumResolver(enumCls, enumConstants, map, _enumDefault(ai, enumCls), isIgnoreCase, false);
            }
            Enum<?> enumValue = enumConstants[i];
            map.put(enumValue.toString(), enumValue);
            String[] aliases = allAliases[i];
            if (aliases != null) {
                for (String alias : aliases) {
                    if (!map.containsKey(alias)) {
                        map.put(alias, enumValue);
                    }
                }
            }
        }
    }

    public static EnumResolver constructUsingMethod(DeserializationConfig config, Class<?> enumCls, AnnotatedMember accessor) {
        return _constructUsingMethod(enumCls, accessor, config.getAnnotationIntrospector(), config.isEnabled(MapperFeature.ACCEPT_CASE_INSENSITIVE_ENUMS));
    }

    protected static EnumResolver _constructUsingMethod(Class<?> enumCls0, AnnotatedMember accessor, AnnotationIntrospector ai, boolean isIgnoreCase) {
        Class<Enum<?>> enumCls = _enumClass(enumCls0);
        Enum<?>[] enumConstants = _enumConstants(enumCls0);
        HashMap<String, Enum<?>> map = new HashMap<>();
        int i = enumConstants.length;
        while (true) {
            i--;
            if (i < 0) {
                return new EnumResolver(enumCls, enumConstants, map, _enumDefault(ai, enumCls), isIgnoreCase, _isIntType(accessor.getRawType()));
            }
            Enum<?> en = enumConstants[i];
            try {
                Object o = accessor.getValue(en);
                if (o != null) {
                    map.put(o.toString(), en);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("Failed to access @JsonValue of Enum value " + en + ": " + e.getMessage());
            }
        }
    }

    public CompactStringObjectMap constructLookup() {
        return CompactStringObjectMap.construct(this._enumsById);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.lang.Class<?> */
    /* JADX WARN: Multi-variable type inference failed */
    protected static Class<Enum<?>> _enumClass(Class<?> enumCls0) {
        return enumCls0;
    }

    protected static Enum<?>[] _enumConstants(Class<?> enumCls) {
        Enum<?>[] enumValues = _enumClass(enumCls).getEnumConstants();
        if (enumValues != null) {
            return enumValues;
        }
        throw new IllegalArgumentException("No enum constants for class " + enumCls.getName());
    }

    protected static Enum<?> _enumDefault(AnnotationIntrospector intr, Class<?> enumCls) {
        if (intr != null) {
            return intr.findDefaultEnumValue(_enumClass(enumCls));
        }
        return null;
    }

    protected static boolean _isIntType(Class<?> erasedType) {
        if (erasedType.isPrimitive()) {
            erasedType = ClassUtil.wrapperType(erasedType);
        }
        return erasedType == Long.class || erasedType == Integer.class || erasedType == Short.class || erasedType == Byte.class;
    }

    @Deprecated
    protected EnumResolver(Class<Enum<?>> enumClass, Enum<?>[] enums, HashMap<String, Enum<?>> map, Enum<?> defaultValue) {
        this(enumClass, enums, map, defaultValue, false, false);
    }

    @Deprecated
    public static EnumResolver constructFor(Class<Enum<?>> enumCls, AnnotationIntrospector ai) {
        return _constructFor(enumCls, ai, false);
    }

    @Deprecated
    public static EnumResolver constructUnsafe(Class<?> rawEnumCls, AnnotationIntrospector ai) {
        return _constructFor(rawEnumCls, ai, false);
    }

    @Deprecated
    public static EnumResolver constructUsingToString(Class<Enum<?>> enumCls, AnnotationIntrospector ai) {
        return _constructUsingToString(enumCls, ai, false);
    }

    @Deprecated
    public static EnumResolver constructUnsafeUsingToString(Class<?> rawEnumCls, AnnotationIntrospector ai) {
        return _constructUsingToString(rawEnumCls, ai, false);
    }

    @Deprecated
    public static EnumResolver constructUsingToString(Class<Enum<?>> enumCls) {
        return _constructUsingToString(enumCls, null, false);
    }

    @Deprecated
    public static EnumResolver constructUsingMethod(Class<Enum<?>> enumCls, AnnotatedMember accessor, AnnotationIntrospector ai) {
        return _constructUsingMethod(enumCls, accessor, ai, false);
    }

    @Deprecated
    public static EnumResolver constructUnsafeUsingMethod(Class<?> rawEnumCls, AnnotatedMember accessor, AnnotationIntrospector ai) {
        return _constructUsingMethod(rawEnumCls, accessor, ai, false);
    }

    public Enum<?> findEnum(String key) {
        Enum<?> en = this._enumsById.get(key);
        if (en != null || !this._isIgnoreCase) {
            return en;
        }
        return _findEnumCaseInsensitive(key);
    }

    protected Enum<?> _findEnumCaseInsensitive(String key) {
        for (Map.Entry<String, Enum<?>> entry : this._enumsById.entrySet()) {
            if (key.equalsIgnoreCase(entry.getKey())) {
                return entry.getValue();
            }
        }
        return null;
    }

    public Enum<?> getEnum(int index) {
        if (index < 0 || index >= this._enums.length) {
            return null;
        }
        return this._enums[index];
    }

    public Enum<?> getDefaultValue() {
        return this._defaultValue;
    }

    public Enum<?>[] getRawEnums() {
        return this._enums;
    }

    public List<Enum<?>> getEnums() {
        ArrayList<Enum<?>> enums = new ArrayList<>(this._enums.length);
        for (Enum<?> e : this._enums) {
            enums.add(e);
        }
        return enums;
    }

    public Collection<String> getEnumIds() {
        return this._enumsById.keySet();
    }

    public Class<Enum<?>> getEnumClass() {
        return this._enumClass;
    }

    public int lastValidIndex() {
        return this._enums.length - 1;
    }

    public boolean isFromIntValue() {
        return this._isFromIntValue;
    }
}
