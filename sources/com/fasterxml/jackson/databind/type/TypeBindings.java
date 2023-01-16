package com.fasterxml.jackson.databind.type;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import java.io.Serializable;
import java.lang.reflect.TypeVariable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/type/TypeBindings.class */
public class TypeBindings implements Serializable {
    private static final long serialVersionUID = 1;
    private static final String[] NO_STRINGS = new String[0];
    private static final JavaType[] NO_TYPES = new JavaType[0];
    private static final TypeBindings EMPTY = new TypeBindings(NO_STRINGS, NO_TYPES, null);
    private final String[] _names;
    private final JavaType[] _types;
    private final String[] _unboundVariables;
    private final int _hashCode;

    private TypeBindings(String[] names, JavaType[] types, String[] uvars) {
        this._names = names == null ? NO_STRINGS : names;
        this._types = types == null ? NO_TYPES : types;
        if (this._names.length != this._types.length) {
            throw new IllegalArgumentException("Mismatching names (" + this._names.length + "), types (" + this._types.length + ")");
        }
        int h = 1;
        int len = this._types.length;
        for (int i = 0; i < len; i++) {
            h += this._types[i].hashCode();
        }
        this._unboundVariables = uvars;
        this._hashCode = h;
    }

    public static TypeBindings emptyBindings() {
        return EMPTY;
    }

    protected Object readResolve() {
        if (this._names == null || this._names.length == 0) {
            return EMPTY;
        }
        return this;
    }

    public static TypeBindings create(Class<?> erasedType, List<JavaType> typeList) {
        return create(erasedType, (typeList == null || typeList.isEmpty()) ? NO_TYPES : (JavaType[]) typeList.toArray(NO_TYPES));
    }

    public static TypeBindings create(Class<?> erasedType, JavaType[] types) {
        String[] names;
        if (types == null) {
            types = NO_TYPES;
        } else {
            switch (types.length) {
                case 1:
                    return create(erasedType, types[0]);
                case 2:
                    return create(erasedType, types[0], types[1]);
            }
        }
        TypeVariable<?>[] vars = erasedType.getTypeParameters();
        if (vars == null || vars.length == 0) {
            names = NO_STRINGS;
        } else {
            int len = vars.length;
            names = new String[len];
            for (int i = 0; i < len; i++) {
                names[i] = vars[i].getName();
            }
        }
        if (names.length == types.length) {
            return new TypeBindings(names, types, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with " + types.length + " type parameter" + (types.length == 1 ? "" : "s") + ": class expects " + names.length);
    }

    public static TypeBindings create(Class<?> erasedType, JavaType typeArg1) {
        TypeVariable<?>[] vars = TypeParamStash.paramsFor1(erasedType);
        int varLen = vars == null ? 0 : vars.length;
        if (varLen == 1) {
            return new TypeBindings(new String[]{vars[0].getName()}, new JavaType[]{typeArg1}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with 1 type parameter: class expects " + varLen);
    }

    public static TypeBindings create(Class<?> erasedType, JavaType typeArg1, JavaType typeArg2) {
        TypeVariable<?>[] vars = TypeParamStash.paramsFor2(erasedType);
        int varLen = vars == null ? 0 : vars.length;
        if (varLen == 2) {
            return new TypeBindings(new String[]{vars[0].getName(), vars[1].getName()}, new JavaType[]{typeArg1, typeArg2}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with 2 type parameters: class expects " + varLen);
    }

    public static TypeBindings create(List<String> names, List<JavaType> types) {
        if (names == null || names.isEmpty() || types == null || types.isEmpty()) {
            return EMPTY;
        }
        return new TypeBindings((String[]) names.toArray(NO_STRINGS), (JavaType[]) types.toArray(NO_TYPES), null);
    }

    public static TypeBindings createIfNeeded(Class<?> erasedType, JavaType typeArg1) {
        TypeVariable<?>[] vars = erasedType.getTypeParameters();
        int varLen = vars == null ? 0 : vars.length;
        if (varLen == 0) {
            return EMPTY;
        }
        if (varLen == 1) {
            return new TypeBindings(new String[]{vars[0].getName()}, new JavaType[]{typeArg1}, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with 1 type parameter: class expects " + varLen);
    }

    public static TypeBindings createIfNeeded(Class<?> erasedType, JavaType[] types) {
        TypeVariable<?>[] vars = erasedType.getTypeParameters();
        if (vars == null || vars.length == 0) {
            return EMPTY;
        }
        if (types == null) {
            types = NO_TYPES;
        }
        int len = vars.length;
        String[] names = new String[len];
        for (int i = 0; i < len; i++) {
            names[i] = vars[i].getName();
        }
        if (names.length == types.length) {
            return new TypeBindings(names, types, null);
        }
        throw new IllegalArgumentException("Cannot create TypeBindings for class " + erasedType.getName() + " with " + types.length + " type parameter" + (types.length == 1 ? "" : "s") + ": class expects " + names.length);
    }

    public TypeBindings withUnboundVariable(String name) {
        int len = this._unboundVariables == null ? 0 : this._unboundVariables.length;
        String[] names = len == 0 ? new String[1] : (String[]) Arrays.copyOf(this._unboundVariables, len + 1);
        names[len] = name;
        return new TypeBindings(this._names, this._types, names);
    }

    public JavaType findBoundType(String name) {
        JavaType t2;
        int len = this._names.length;
        for (int i = 0; i < len; i++) {
            if (name.equals(this._names[i])) {
                JavaType t = this._types[i];
                if ((t instanceof ResolvedRecursiveType) && (t2 = ((ResolvedRecursiveType) t).getSelfReferencedType()) != null) {
                    t = t2;
                }
                return t;
            }
        }
        return null;
    }

    public boolean isEmpty() {
        return this._types.length == 0;
    }

    public int size() {
        return this._types.length;
    }

    public String getBoundName(int index) {
        if (index < 0 || index >= this._names.length) {
            return null;
        }
        return this._names[index];
    }

    public JavaType getBoundType(int index) {
        if (index < 0 || index >= this._types.length) {
            return null;
        }
        return this._types[index];
    }

    public List<JavaType> getTypeParameters() {
        if (this._types.length == 0) {
            return Collections.emptyList();
        }
        return Arrays.asList(this._types);
    }

    public boolean hasUnbound(String name) {
        if (this._unboundVariables == null) {
            return false;
        }
        int i = this._unboundVariables.length;
        do {
            i--;
            if (i < 0) {
                return false;
            }
        } while (!name.equals(this._unboundVariables[i]));
        return true;
    }

    public Object asKey(Class<?> rawBase) {
        return new AsKey(rawBase, this._types, this._hashCode);
    }

    @Override // java.lang.Object
    public String toString() {
        if (this._types.length == 0) {
            return "<>";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        int len = this._types.length;
        for (int i = 0; i < len; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this._types[i].getGenericSignature());
        }
        sb.append('>');
        return sb.toString();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this._hashCode;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!ClassUtil.hasClass(o, getClass())) {
            return false;
        }
        TypeBindings other = (TypeBindings) o;
        int len = this._types.length;
        if (len != other.size()) {
            return false;
        }
        JavaType[] otherTypes = other._types;
        for (int i = 0; i < len; i++) {
            if (!otherTypes[i].equals(this._types[i])) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public JavaType[] typeParameterArray() {
        return this._types;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/type/TypeBindings$TypeParamStash.class */
    public static class TypeParamStash {
        private static final TypeVariable<?>[] VARS_ABSTRACT_LIST = AbstractList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_COLLECTION = Collection.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ITERABLE = Iterable.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LIST = List.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_ARRAY_LIST = ArrayList.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_MAP = Map.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_HASH_MAP = HashMap.class.getTypeParameters();
        private static final TypeVariable<?>[] VARS_LINKED_HASH_MAP = LinkedHashMap.class.getTypeParameters();

        TypeParamStash() {
        }

        public static TypeVariable<?>[] paramsFor1(Class<?> erasedType) {
            if (erasedType == Collection.class) {
                return VARS_COLLECTION;
            }
            if (erasedType == List.class) {
                return VARS_LIST;
            }
            if (erasedType == ArrayList.class) {
                return VARS_ARRAY_LIST;
            }
            if (erasedType == AbstractList.class) {
                return VARS_ABSTRACT_LIST;
            }
            if (erasedType == Iterable.class) {
                return VARS_ITERABLE;
            }
            return erasedType.getTypeParameters();
        }

        public static TypeVariable<?>[] paramsFor2(Class<?> erasedType) {
            if (erasedType == Map.class) {
                return VARS_MAP;
            }
            if (erasedType == HashMap.class) {
                return VARS_HASH_MAP;
            }
            if (erasedType == LinkedHashMap.class) {
                return VARS_LINKED_HASH_MAP;
            }
            return erasedType.getTypeParameters();
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/type/TypeBindings$AsKey.class */
    static final class AsKey {
        private final Class<?> _raw;
        private final JavaType[] _params;
        private final int _hash;

        public AsKey(Class<?> raw, JavaType[] params, int hash) {
            this._raw = raw;
            this._params = params;
            this._hash = hash;
        }

        public int hashCode() {
            return this._hash;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (o == null || o.getClass() != getClass()) {
                return false;
            }
            AsKey other = (AsKey) o;
            if (!(this._hash == other._hash && this._raw == other._raw)) {
                return false;
            }
            JavaType[] otherParams = other._params;
            int len = this._params.length;
            if (len != otherParams.length) {
                return false;
            }
            for (int i = 0; i < len; i++) {
                if (!this._params[i].equals(otherParams[i])) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            return this._raw.getName() + "<>";
        }
    }
}
