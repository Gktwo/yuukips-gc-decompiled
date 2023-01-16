package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import com.google.common.collect.ForwardingSet;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.primitives.Primitives;
import com.google.common.reflect.Invokable;
import com.google.common.reflect.TypeResolver;
import com.google.common.reflect.Types;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import dev.morphia.mapping.Mapper;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Beta
/* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken.class */
public abstract class TypeToken<T> extends TypeCapture<T> implements Serializable {
    private final Type runtimeType;
    private transient TypeResolver invariantTypeResolver;
    private transient TypeResolver covariantTypeResolver;
    private static final long serialVersionUID = 3637540370352322684L;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$TypeFilter.class */
    public enum TypeFilter implements Predicate<TypeToken<?>> {
        IGNORE_TYPE_VARIABLE_OR_WILDCARD {
            public boolean apply(TypeToken<?> type) {
                return !(((TypeToken) type).runtimeType instanceof TypeVariable) && !(((TypeToken) type).runtimeType instanceof WildcardType);
            }
        },
        INTERFACE_ONLY {
            public boolean apply(TypeToken<?> type) {
                return type.getRawType().isInterface();
            }
        }
    }

    protected TypeToken() {
        this.runtimeType = capture();
        Preconditions.checkState(!(this.runtimeType instanceof TypeVariable), "Cannot construct a TypeToken for a type variable.\nYou probably meant to call new TypeToken<%s>(getClass()) that can resolve the type variable for you.\nIf you do need to create a TypeToken of a type variable, please use TypeToken.of() instead.", this.runtimeType);
    }

    protected TypeToken(Class<?> declaringClass) {
        Type captured = capture();
        if (captured instanceof Class) {
            this.runtimeType = captured;
        } else {
            this.runtimeType = TypeResolver.covariantly(declaringClass).resolveType(captured);
        }
    }

    private TypeToken(Type type) {
        this.runtimeType = (Type) Preconditions.checkNotNull(type);
    }

    /* renamed from: of */
    public static <T> TypeToken<T> m1299of(Class<T> type) {
        return new SimpleTypeToken(type);
    }

    /* renamed from: of */
    public static TypeToken<?> m1298of(Type type) {
        return new SimpleTypeToken(type);
    }

    public final Class<? super T> getRawType() {
        return getRawTypes().iterator().next();
    }

    public final Type getType() {
        return this.runtimeType;
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParam, TypeToken<X> typeArg) {
        return new SimpleTypeToken(new TypeResolver().where(ImmutableMap.m1418of(new TypeResolver.TypeVariableKey(typeParam.typeVariable), typeArg.runtimeType)).resolveType(this.runtimeType));
    }

    public final <X> TypeToken<T> where(TypeParameter<X> typeParam, Class<X> typeArg) {
        return where(typeParam, m1299of((Class) typeArg));
    }

    public final TypeToken<?> resolveType(Type type) {
        Preconditions.checkNotNull(type);
        return m1298of(getInvariantTypeResolver().resolveType(type));
    }

    private TypeToken<?> resolveSupertype(Type type) {
        TypeToken<?> supertype = m1298of(getCovariantTypeResolver().resolveType(type));
        supertype.covariantTypeResolver = this.covariantTypeResolver;
        supertype.invariantTypeResolver = this.invariantTypeResolver;
        return supertype;
    }

    final TypeToken<? super T> getGenericSuperclass() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundAsSuperclass(((TypeVariable) this.runtimeType).getBounds()[0]);
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundAsSuperclass(((WildcardType) this.runtimeType).getUpperBounds()[0]);
        }
        Type superclass = getRawType().getGenericSuperclass();
        if (superclass == null) {
            return null;
        }
        return (TypeToken<? super T>) resolveSupertype(superclass);
    }

    private TypeToken<? super T> boundAsSuperclass(Type bound) {
        TypeToken<? super T> typeToken = (TypeToken<? super T>) m1298of(bound);
        if (typeToken.getRawType().isInterface()) {
            return null;
        }
        return typeToken;
    }

    final ImmutableList<TypeToken<? super T>> getGenericInterfaces() {
        if (this.runtimeType instanceof TypeVariable) {
            return boundsAsInterfaces(((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return boundsAsInterfaces(((WildcardType) this.runtimeType).getUpperBounds());
        }
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type interfaceType : getRawType().getGenericInterfaces()) {
            builder.add((ImmutableList.Builder) resolveSupertype(interfaceType));
        }
        return builder.build();
    }

    private ImmutableList<TypeToken<? super T>> boundsAsInterfaces(Type[] bounds) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type bound : bounds) {
            TypeToken<?> of = m1298of(bound);
            if (of.getRawType().isInterface()) {
                builder.add((ImmutableList.Builder) of);
            }
        }
        return builder.build();
    }

    public final TypeToken<T>.TypeSet getTypes() {
        return new TypeSet();
    }

    public final TypeToken<? super T> getSupertype(Class<? super T> superclass) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(superclass), "%s is not a super class of %s", superclass, this);
        if (this.runtimeType instanceof TypeVariable) {
            return getSupertypeFromUpperBounds(superclass, ((TypeVariable) this.runtimeType).getBounds());
        }
        if (this.runtimeType instanceof WildcardType) {
            return getSupertypeFromUpperBounds(superclass, ((WildcardType) this.runtimeType).getUpperBounds());
        }
        if (superclass.isArray()) {
            return getArraySupertype(superclass);
        }
        return (TypeToken<? super T>) resolveSupertype(toGenericType(superclass).runtimeType);
    }

    public final TypeToken<? extends T> getSubtype(Class<?> subclass) {
        Preconditions.checkArgument(!(this.runtimeType instanceof TypeVariable), "Cannot get subtype of type variable <%s>", this);
        if (this.runtimeType instanceof WildcardType) {
            return getSubtypeFromLowerBounds(subclass, ((WildcardType) this.runtimeType).getLowerBounds());
        }
        if (isArray()) {
            return getArraySubtype(subclass);
        }
        Preconditions.checkArgument(getRawType().isAssignableFrom(subclass), "%s isn't a subclass of %s", subclass, this);
        TypeToken<? extends T> subtype = (TypeToken<? extends T>) m1298of(resolveTypeArgsForSubclass(subclass));
        Preconditions.checkArgument(subtype.isSubtypeOf((TypeToken<?>) this), "%s does not appear to be a subtype of %s", subtype, this);
        return subtype;
    }

    public final boolean isSupertypeOf(TypeToken<?> type) {
        return type.isSubtypeOf(getType());
    }

    public final boolean isSupertypeOf(Type type) {
        return m1298of(type).isSubtypeOf(getType());
    }

    public final boolean isSubtypeOf(TypeToken<?> type) {
        return isSubtypeOf(type.getType());
    }

    public final boolean isSubtypeOf(Type supertype) {
        Preconditions.checkNotNull(supertype);
        if (supertype instanceof WildcardType) {
            return any(((WildcardType) supertype).getLowerBounds()).isSupertypeOf(this.runtimeType);
        }
        if (this.runtimeType instanceof WildcardType) {
            return any(((WildcardType) this.runtimeType).getUpperBounds()).isSubtypeOf(supertype);
        }
        if (this.runtimeType instanceof TypeVariable) {
            return this.runtimeType.equals(supertype) || any(((TypeVariable) this.runtimeType).getBounds()).isSubtypeOf(supertype);
        }
        if (this.runtimeType instanceof GenericArrayType) {
            return m1298of(supertype).isSupertypeOfArray((GenericArrayType) this.runtimeType);
        }
        if (supertype instanceof Class) {
            return someRawTypeIsSubclassOf((Class) supertype);
        }
        if (supertype instanceof ParameterizedType) {
            return isSubtypeOfParameterizedType((ParameterizedType) supertype);
        }
        if (supertype instanceof GenericArrayType) {
            return isSubtypeOfArrayType((GenericArrayType) supertype);
        }
        return false;
    }

    public final boolean isArray() {
        return getComponentType() != null;
    }

    public final boolean isPrimitive() {
        return (this.runtimeType instanceof Class) && ((Class) this.runtimeType).isPrimitive();
    }

    public final TypeToken<T> wrap() {
        if (isPrimitive()) {
            return m1299of(Primitives.wrap((Class) this.runtimeType));
        }
        return this;
    }

    private boolean isWrapper() {
        return Primitives.allWrapperTypes().contains(this.runtimeType);
    }

    public final TypeToken<T> unwrap() {
        if (isWrapper()) {
            return m1299of(Primitives.unwrap((Class) this.runtimeType));
        }
        return this;
    }

    public final TypeToken<?> getComponentType() {
        Type componentType = Types.getComponentType(this.runtimeType);
        if (componentType == null) {
            return null;
        }
        return m1298of(componentType);
    }

    public final Invokable<T, Object> method(Method method) {
        Preconditions.checkArgument(someRawTypeIsSubclassOf(method.getDeclaringClass()), "%s not declared by %s", method, this);
        return new Invokable.MethodInvokable<T>(method) { // from class: com.google.common.reflect.TypeToken.1
            @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
            Type getGenericReturnType() {
                return TypeToken.this.getCovariantTypeResolver().resolveType(getGenericReturnType());
            }

            @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
            Type[] getGenericParameterTypes() {
                return TypeToken.this.getInvariantTypeResolver().resolveTypesInPlace(getGenericParameterTypes());
            }

            @Override // com.google.common.reflect.Invokable.MethodInvokable, com.google.common.reflect.Invokable
            Type[] getGenericExceptionTypes() {
                return TypeToken.this.getCovariantTypeResolver().resolveTypesInPlace(getGenericExceptionTypes());
            }

            @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element, java.lang.Object
            public String toString() {
                return getOwnerType() + Mapper.IGNORED_FIELDNAME + toString();
            }
        };
    }

    public final Invokable<T, T> constructor(Constructor<?> constructor) {
        Preconditions.checkArgument(constructor.getDeclaringClass() == getRawType(), "%s not declared by %s", constructor, getRawType());
        return new Invokable.ConstructorInvokable<T>(constructor) { // from class: com.google.common.reflect.TypeToken.2
            @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
            Type getGenericReturnType() {
                return TypeToken.this.getCovariantTypeResolver().resolveType(getGenericReturnType());
            }

            @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
            Type[] getGenericParameterTypes() {
                return TypeToken.this.getInvariantTypeResolver().resolveTypesInPlace(getGenericParameterTypes());
            }

            @Override // com.google.common.reflect.Invokable.ConstructorInvokable, com.google.common.reflect.Invokable
            Type[] getGenericExceptionTypes() {
                return TypeToken.this.getCovariantTypeResolver().resolveTypesInPlace(getGenericExceptionTypes());
            }

            @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element
            public TypeToken<T> getOwnerType() {
                return TypeToken.this;
            }

            @Override // com.google.common.reflect.Invokable, com.google.common.reflect.Element, java.lang.Object
            public String toString() {
                return getOwnerType() + "(" + Joiner.m1464on(", ").join(getGenericParameterTypes()) + ")";
            }
        };
    }

    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$TypeSet.class */
    public class TypeSet extends ForwardingSet<TypeToken<? super T>> implements Serializable {
        private transient ImmutableSet<TypeToken<? super T>> types;
        private static final long serialVersionUID = 0;

        TypeSet() {
        }

        public TypeToken<T>.TypeSet interfaces() {
            return new InterfaceSet(this);
        }

        public TypeToken<T>.TypeSet classes() {
            return new ClassSet();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> filteredTypes = this.types;
            if (filteredTypes != null) {
                return filteredTypes;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.collectTypes((TypeCollector<TypeToken<?>>) TypeToken.this)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.types = set;
            return set;
        }

        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getRawTypes()));
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$InterfaceSet.class */
    public final class InterfaceSet extends TypeToken<T>.TypeSet {
        private final transient TypeToken<T>.TypeSet allTypes;
        private transient ImmutableSet<TypeToken<? super T>> interfaces;
        private static final long serialVersionUID = 0;

        InterfaceSet(TypeToken<T>.TypeSet allTypes) {
            super();
            this.allTypes = allTypes;
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> result = this.interfaces;
            if (result != null) {
                return result;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(this.allTypes).filter(TypeFilter.INTERFACE_ONLY).toSet();
            this.interfaces = set;
            return set;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return FluentIterable.from(TypeCollector.FOR_RAW_TYPE.collectTypes(TypeToken.this.getRawTypes())).filter(new Predicate<Class<?>>() { // from class: com.google.common.reflect.TypeToken.InterfaceSet.1
                public boolean apply(Class<?> type) {
                    return type.isInterface();
                }
            }).toSet();
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            throw new UnsupportedOperationException("interfaces().classes() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().interfaces();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$ClassSet.class */
    public final class ClassSet extends TypeToken<T>.TypeSet {
        private transient ImmutableSet<TypeToken<? super T>> classes;
        private static final long serialVersionUID = 0;

        private ClassSet() {
            super();
        }

        /* access modifiers changed from: protected */
        @Override // com.google.common.reflect.TypeToken.TypeSet, com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
        public Set<TypeToken<? super T>> delegate() {
            ImmutableSet<TypeToken<? super T>> result = this.classes;
            if (result != null) {
                return result;
            }
            ImmutableSet<TypeToken<? super T>> set = FluentIterable.from(TypeCollector.FOR_GENERIC_TYPE.classesOnly().collectTypes((TypeCollector<TypeToken<?>>) TypeToken.this)).filter(TypeFilter.IGNORE_TYPE_VARIABLE_OR_WILDCARD).toSet();
            this.classes = set;
            return set;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet classes() {
            return this;
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public Set<Class<? super T>> rawTypes() {
            return ImmutableSet.copyOf((Collection) TypeCollector.FOR_RAW_TYPE.classesOnly().collectTypes(TypeToken.this.getRawTypes()));
        }

        @Override // com.google.common.reflect.TypeToken.TypeSet
        public TypeToken<T>.TypeSet interfaces() {
            throw new UnsupportedOperationException("classes().interfaces() not supported.");
        }

        private Object readResolve() {
            return TypeToken.this.getTypes().classes();
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (o instanceof TypeToken) {
            return this.runtimeType.equals(((TypeToken) o).runtimeType);
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.runtimeType.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return Types.toString(this.runtimeType);
    }

    protected Object writeReplace() {
        return m1298of(new TypeResolver().resolveType(this.runtimeType));
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    public final TypeToken<T> rejectTypeVariables() {
        new TypeVisitor() { // from class: com.google.common.reflect.TypeToken.3
            @Override // com.google.common.reflect.TypeVisitor
            void visitTypeVariable(TypeVariable<?> type) {
                throw new IllegalArgumentException(TypeToken.this.runtimeType + "contains a type variable and is not safe for the operation");
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitWildcardType(WildcardType type) {
                visit(type.getLowerBounds());
                visit(type.getUpperBounds());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitParameterizedType(ParameterizedType type) {
                visit(type.getActualTypeArguments());
                visit(type.getOwnerType());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitGenericArrayType(GenericArrayType type) {
                visit(type.getGenericComponentType());
            }
        }.visit(this.runtimeType);
        return this;
    }

    private boolean someRawTypeIsSubclassOf(Class<?> superclass) {
        UnmodifiableIterator<Class<? super T>> it = getRawTypes().iterator();
        while (it.hasNext()) {
            if (superclass.isAssignableFrom(it.next())) {
                return true;
            }
        }
        return false;
    }

    private boolean isSubtypeOfParameterizedType(ParameterizedType supertype) {
        Class<?> matchedClass = m1298of(supertype).getRawType();
        if (!someRawTypeIsSubclassOf(matchedClass)) {
            return false;
        }
        TypeVariable<?>[] typeVars = matchedClass.getTypeParameters();
        Type[] supertypeArgs = supertype.getActualTypeArguments();
        for (int i = 0; i < typeVars.length; i++) {
            if (!m1298of(getCovariantTypeResolver().resolveType(typeVars[i])).m1300is(supertypeArgs[i], typeVars[i])) {
                return false;
            }
        }
        return Modifier.isStatic(((Class) supertype.getRawType()).getModifiers()) || supertype.getOwnerType() == null || isOwnedBySubtypeOf(supertype.getOwnerType());
    }

    private boolean isSubtypeOfArrayType(GenericArrayType supertype) {
        if (this.runtimeType instanceof Class) {
            Class<?> fromClass = (Class) this.runtimeType;
            if (!fromClass.isArray()) {
                return false;
            }
            return m1299of((Class) fromClass.getComponentType()).isSubtypeOf(supertype.getGenericComponentType());
        } else if (this.runtimeType instanceof GenericArrayType) {
            return m1298of(((GenericArrayType) this.runtimeType).getGenericComponentType()).isSubtypeOf(supertype.getGenericComponentType());
        } else {
            return false;
        }
    }

    private boolean isSupertypeOfArray(GenericArrayType subtype) {
        if (this.runtimeType instanceof Class) {
            Class<?> thisClass = (Class) this.runtimeType;
            if (!thisClass.isArray()) {
                return thisClass.isAssignableFrom(Object[].class);
            }
            return m1298of(subtype.getGenericComponentType()).isSubtypeOf(thisClass.getComponentType());
        } else if (this.runtimeType instanceof GenericArrayType) {
            return m1298of(subtype.getGenericComponentType()).isSubtypeOf(((GenericArrayType) this.runtimeType).getGenericComponentType());
        } else {
            return false;
        }
    }

    /* renamed from: is */
    private boolean m1300is(Type formalType, TypeVariable<?> declaration) {
        if (this.runtimeType.equals(formalType)) {
            return true;
        }
        if (!(formalType instanceof WildcardType)) {
            return canonicalizeWildcardsInType(this.runtimeType).equals(canonicalizeWildcardsInType(formalType));
        }
        WildcardType your = canonicalizeWildcardType(declaration, (WildcardType) formalType);
        return every(your.getUpperBounds()).isSupertypeOf(this.runtimeType) && every(your.getLowerBounds()).isSubtypeOf(this.runtimeType);
    }

    private static Type canonicalizeTypeArg(TypeVariable<?> declaration, Type typeArg) {
        if (typeArg instanceof WildcardType) {
            return canonicalizeWildcardType(declaration, (WildcardType) typeArg);
        }
        return canonicalizeWildcardsInType(typeArg);
    }

    private static Type canonicalizeWildcardsInType(Type type) {
        if (type instanceof ParameterizedType) {
            return canonicalizeWildcardsInParameterizedType((ParameterizedType) type);
        }
        if (type instanceof GenericArrayType) {
            return Types.newArrayType(canonicalizeWildcardsInType(((GenericArrayType) type).getGenericComponentType()));
        }
        return type;
    }

    private static WildcardType canonicalizeWildcardType(TypeVariable<?> declaration, WildcardType type) {
        Type[] declared = declaration.getBounds();
        List<Type> upperBounds = new ArrayList<>();
        Type[] upperBounds2 = type.getUpperBounds();
        for (Type bound : upperBounds2) {
            if (!any(declared).isSubtypeOf(bound)) {
                upperBounds.add(canonicalizeWildcardsInType(bound));
            }
        }
        return new Types.WildcardTypeImpl(type.getLowerBounds(), (Type[]) upperBounds.toArray(new Type[0]));
    }

    private static ParameterizedType canonicalizeWildcardsInParameterizedType(ParameterizedType type) {
        Class<?> rawType = (Class) type.getRawType();
        TypeVariable<?>[] typeVars = rawType.getTypeParameters();
        Type[] typeArgs = type.getActualTypeArguments();
        for (int i = 0; i < typeArgs.length; i++) {
            typeArgs[i] = canonicalizeTypeArg(typeVars[i], typeArgs[i]);
        }
        return Types.newParameterizedTypeWithOwner(type.getOwnerType(), rawType, typeArgs);
    }

    private static Bounds every(Type[] bounds) {
        return new Bounds(bounds, false);
    }

    private static Bounds any(Type[] bounds) {
        return new Bounds(bounds, true);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$Bounds.class */
    public static class Bounds {
        private final Type[] bounds;
        private final boolean target;

        Bounds(Type[] bounds, boolean target) {
            this.bounds = bounds;
            this.target = target;
        }

        boolean isSubtypeOf(Type supertype) {
            for (Type bound : this.bounds) {
                if (TypeToken.m1298of(bound).isSubtypeOf(supertype) == this.target) {
                    return this.target;
                }
            }
            return !this.target;
        }

        boolean isSupertypeOf(Type subtype) {
            TypeToken<?> type = TypeToken.m1298of(subtype);
            for (Type bound : this.bounds) {
                if (type.isSubtypeOf(bound) == this.target) {
                    return this.target;
                }
            }
            return !this.target;
        }
    }

    /* access modifiers changed from: private */
    public ImmutableSet<Class<? super T>> getRawTypes() {
        final ImmutableSet.Builder builder = ImmutableSet.builder();
        new TypeVisitor() { // from class: com.google.common.reflect.TypeToken.4
            @Override // com.google.common.reflect.TypeVisitor
            void visitTypeVariable(TypeVariable<?> t) {
                visit(t.getBounds());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitWildcardType(WildcardType t) {
                visit(t.getUpperBounds());
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitParameterizedType(ParameterizedType t) {
                builder.add((ImmutableSet.Builder) ((Class) t.getRawType()));
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitClass(Class<?> t) {
                builder.add((ImmutableSet.Builder) t);
            }

            @Override // com.google.common.reflect.TypeVisitor
            void visitGenericArrayType(GenericArrayType t) {
                builder.add((ImmutableSet.Builder) Types.getArrayClass(TypeToken.m1298of(t.getGenericComponentType()).getRawType()));
            }
        }.visit(this.runtimeType);
        return builder.build();
    }

    private boolean isOwnedBySubtypeOf(Type supertype) {
        Iterator<TypeToken<? super T>> it = getTypes().iterator();
        while (it.hasNext()) {
            Type ownerType = it.next().getOwnerTypeIfPresent();
            if (ownerType != null && m1298of(ownerType).isSubtypeOf(supertype)) {
                return true;
            }
        }
        return false;
    }

    private Type getOwnerTypeIfPresent() {
        if (this.runtimeType instanceof ParameterizedType) {
            return ((ParameterizedType) this.runtimeType).getOwnerType();
        }
        if (this.runtimeType instanceof Class) {
            return ((Class) this.runtimeType).getEnclosingClass();
        }
        return null;
    }

    @VisibleForTesting
    static <T> TypeToken<? extends T> toGenericType(Class<T> cls) {
        if (cls.isArray()) {
            return (TypeToken<? extends T>) m1298of(Types.newArrayType(toGenericType(cls.getComponentType()).runtimeType));
        }
        TypeVariable<Class<T>>[] typeParams = cls.getTypeParameters();
        Type ownerType = (!cls.isMemberClass() || Modifier.isStatic(cls.getModifiers())) ? null : toGenericType(cls.getEnclosingClass()).runtimeType;
        if (typeParams.length > 0 || (ownerType != null && ownerType != cls.getEnclosingClass())) {
            return (TypeToken<? extends T>) m1298of(Types.newParameterizedTypeWithOwner(ownerType, cls, typeParams));
        }
        return m1299of((Class) cls);
    }

    /* access modifiers changed from: private */
    public TypeResolver getCovariantTypeResolver() {
        TypeResolver resolver = this.covariantTypeResolver;
        if (resolver == null) {
            TypeResolver covariantly = TypeResolver.covariantly(this.runtimeType);
            this.covariantTypeResolver = covariantly;
            resolver = covariantly;
        }
        return resolver;
    }

    /* access modifiers changed from: private */
    public TypeResolver getInvariantTypeResolver() {
        TypeResolver resolver = this.invariantTypeResolver;
        if (resolver == null) {
            TypeResolver invariantly = TypeResolver.invariantly(this.runtimeType);
            this.invariantTypeResolver = invariantly;
            resolver = invariantly;
        }
        return resolver;
    }

    private TypeToken<? super T> getSupertypeFromUpperBounds(Class<? super T> supertype, Type[] upperBounds) {
        for (Type upperBound : upperBounds) {
            TypeToken<?> of = m1298of(upperBound);
            if (of.isSubtypeOf(supertype)) {
                return (TypeToken<? super T>) of.getSupertype(supertype);
            }
        }
        throw new IllegalArgumentException(supertype + " isn't a super type of " + this);
    }

    private TypeToken<? extends T> getSubtypeFromLowerBounds(Class<?> subclass, Type[] lowerBounds) {
        if (0 < lowerBounds.length) {
            return (TypeToken<? extends T>) m1298of(lowerBounds[0]).getSubtype(subclass);
        }
        throw new IllegalArgumentException(subclass + " isn't a subclass of " + this);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: com.google.common.reflect.TypeToken */
    /* JADX WARN: Multi-variable type inference failed */
    private TypeToken<? super T> getArraySupertype(Class<? super T> supertype) {
        return (TypeToken<? super T>) m1298of(newArrayClassOrGenericArrayType(((TypeToken) Preconditions.checkNotNull(getComponentType(), "%s isn't a super type of %s", supertype, this)).getSupertype(supertype.getComponentType()).runtimeType));
    }

    private TypeToken<? extends T> getArraySubtype(Class<?> subclass) {
        return (TypeToken<? extends T>) m1298of(newArrayClassOrGenericArrayType(getComponentType().getSubtype(subclass.getComponentType()).runtimeType));
    }

    private Type resolveTypeArgsForSubclass(Class<?> subclass) {
        if ((this.runtimeType instanceof Class) && (subclass.getTypeParameters().length == 0 || getRawType().getTypeParameters().length != 0)) {
            return subclass;
        }
        TypeToken<?> genericSubtype = toGenericType(subclass);
        return new TypeResolver().where(genericSubtype.getSupertype(getRawType()).runtimeType, this.runtimeType).resolveType(genericSubtype.runtimeType);
    }

    private static Type newArrayClassOrGenericArrayType(Type componentType) {
        return Types.JavaVersion.JAVA7.newArrayType(componentType);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$SimpleTypeToken.class */
    public static final class SimpleTypeToken<T> extends TypeToken<T> {
        private static final long serialVersionUID = 0;

        SimpleTypeToken(Type type) {
            super(type);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$TypeCollector.class */
    public static abstract class TypeCollector<K> {
        static final TypeCollector<TypeToken<?>> FOR_GENERIC_TYPE = new TypeCollector<TypeToken<?>>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.1
            /* access modifiers changed from: package-private */
            public Class<?> getRawType(TypeToken<?> type) {
                return type.getRawType();
            }

            /* access modifiers changed from: package-private */
            public Iterable<? extends TypeToken<?>> getInterfaces(TypeToken<?> type) {
                return type.getGenericInterfaces();
            }

            /* access modifiers changed from: package-private */
            public TypeToken<?> getSuperclass(TypeToken<?> type) {
                return type.getGenericSuperclass();
            }
        };
        static final TypeCollector<Class<?>> FOR_RAW_TYPE = new TypeCollector<Class<?>>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.2
            /* access modifiers changed from: package-private */
            public Class<?> getRawType(Class<?> type) {
                return type;
            }

            /* access modifiers changed from: package-private */
            public Iterable<? extends Class<?>> getInterfaces(Class<?> type) {
                return Arrays.asList(type.getInterfaces());
            }

            /* access modifiers changed from: package-private */
            public Class<?> getSuperclass(Class<?> type) {
                return type.getSuperclass();
            }
        };

        abstract Class<?> getRawType(K k);

        abstract Iterable<? extends K> getInterfaces(K k);

        abstract K getSuperclass(K k);

        private TypeCollector() {
        }

        final TypeCollector<K> classesOnly() {
            return new ForwardingTypeCollector<K>(this) { // from class: com.google.common.reflect.TypeToken.TypeCollector.3
                @Override // com.google.common.reflect.TypeToken.TypeCollector.ForwardingTypeCollector, com.google.common.reflect.TypeToken.TypeCollector
                Iterable<? extends K> getInterfaces(K type) {
                    return ImmutableSet.m1396of();
                }

                /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: com.google.common.reflect.TypeToken$TypeCollector$3 */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.reflect.TypeToken.TypeCollector
                ImmutableList<K> collectTypes(Iterable<? extends K> types) {
                    ImmutableList.Builder builder = ImmutableList.builder();
                    for (Object obj : types) {
                        if (!getRawType(obj).isInterface()) {
                            builder.add((ImmutableList.Builder) obj);
                        }
                    }
                    return collectTypes((Iterable) builder.build());
                }
            };
        }

        final ImmutableList<K> collectTypes(K type) {
            return collectTypes((Iterable) ImmutableList.m1437of(type));
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.google.common.reflect.TypeToken$TypeCollector<K> */
        /* JADX WARN: Multi-variable type inference failed */
        ImmutableList<K> collectTypes(Iterable<? extends K> types) {
            HashMap newHashMap = Maps.newHashMap();
            Iterator<? extends K> it = types.iterator();
            while (it.hasNext()) {
                collectTypes(it.next(), newHashMap);
            }
            return sortKeysByValue(newHashMap, Ordering.natural().reverse());
        }

        @CanIgnoreReturnValue
        private int collectTypes(K type, Map<? super K, Integer> map) {
            Integer existing = map.get(type);
            if (existing != null) {
                return existing.intValue();
            }
            int aboveMe = getRawType(type).isInterface() ? 1 : 0;
            Iterator<? extends K> it = getInterfaces(type).iterator();
            while (it.hasNext()) {
                aboveMe = Math.max(aboveMe, collectTypes(it.next(), map));
            }
            K superclass = getSuperclass(type);
            if (superclass != null) {
                aboveMe = Math.max(aboveMe, collectTypes(superclass, map));
            }
            map.put(type, Integer.valueOf(aboveMe + 1));
            return aboveMe + 1;
        }

        private static <K, V> ImmutableList<K> sortKeysByValue(final Map<K, V> map, final Comparator<? super V> valueComparator) {
            return (ImmutableList<K>) new Ordering<K>() { // from class: com.google.common.reflect.TypeToken.TypeCollector.4
                /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.Comparator */
                /* JADX WARN: Multi-variable type inference failed */
                @Override // com.google.common.collect.Ordering, java.util.Comparator
                public int compare(K left, K right) {
                    return valueComparator.compare(map.get(left), map.get(right));
                }
            }.immutableSortedCopy(map.keySet());
        }

        /* loaded from: grasscutter.jar:com/google/common/reflect/TypeToken$TypeCollector$ForwardingTypeCollector.class */
        private static class ForwardingTypeCollector<K> extends TypeCollector<K> {
            private final TypeCollector<K> delegate;

            ForwardingTypeCollector(TypeCollector<K> delegate) {
                super();
                this.delegate = delegate;
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Class<?> getRawType(K type) {
                return this.delegate.getRawType(type);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            Iterable<? extends K> getInterfaces(K type) {
                return this.delegate.getInterfaces(type);
            }

            @Override // com.google.common.reflect.TypeToken.TypeCollector
            K getSuperclass(K type) {
                return this.delegate.getSuperclass(type);
            }
        }
    }
}
