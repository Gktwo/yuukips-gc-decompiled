package net.bytebuddy.description.type;

import dev.morphia.mapping.Mapper;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.TargetType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.CompoundList;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import net.bytebuddy.utility.privilege.GetSystemPropertyAction;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription.class */
public interface TypeDescription extends TypeDefinition, ByteCodeElement, TypeVariableSource {
    public static final TypeDescription OBJECT = new ForLoadedType(Object.class);
    public static final TypeDescription STRING = new ForLoadedType(String.class);
    public static final TypeDescription CLASS = new ForLoadedType(Class.class);
    public static final TypeDescription THROWABLE = new ForLoadedType(Throwable.class);
    public static final TypeDescription VOID = new ForLoadedType(Void.TYPE);
    public static final TypeList.Generic ARRAY_INTERFACES = new TypeList.Generic.ForLoadedTypes(Cloneable.class, Serializable.class);
    public static final TypeDescription UNDEFINED = null;

    @Override // net.bytebuddy.description.type.TypeDefinition
    FieldList<FieldDescription.InDefinedShape> getDeclaredFields();

    @Override // net.bytebuddy.description.type.TypeDefinition
    MethodList<MethodDescription.InDefinedShape> getDeclaredMethods();

    @Override // net.bytebuddy.description.type.TypeDefinition
    RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents();

    boolean isInstance(Object obj);

    boolean isAssignableFrom(Class<?> cls);

    boolean isAssignableFrom(TypeDescription typeDescription);

    boolean isAssignableTo(Class<?> cls);

    boolean isAssignableTo(TypeDescription typeDescription);

    boolean isInHierarchyWith(Class<?> cls);

    boolean isInHierarchyWith(TypeDescription typeDescription);

    @Override // net.bytebuddy.description.type.TypeDefinition
    TypeDescription getComponentType();

    @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
    TypeDescription getDeclaringType();

    TypeList getDeclaredTypes();

    MethodDescription.InDefinedShape getEnclosingMethod();

    TypeDescription getEnclosingType();

    int getActualModifiers(boolean z);

    String getSimpleName();

    String getCanonicalName();

    boolean isAnonymousType();

    boolean isLocalType();

    boolean isMemberType();

    PackageDescription getPackage();

    AnnotationList getInheritedAnnotations();

    boolean isSamePackage(TypeDescription typeDescription);

    boolean isPrimitiveWrapper();

    boolean isAnnotationReturnType();

    boolean isAnnotationValue();

    boolean isAnnotationValue(Object obj);

    boolean isPackageType();

    int getInnerClassCount();

    boolean isInnerClass();

    boolean isNestedClass();

    TypeDescription asBoxed();

    TypeDescription asUnboxed();

    Object getDefaultValue();

    TypeDescription getNestHost();

    TypeList getNestMembers();

    boolean isNestHost();

    boolean isNestMateOf(Class<?> cls);

    boolean isNestMateOf(TypeDescription typeDescription);

    boolean isCompileTimeConstant();

    TypeList getPermittedSubtypes();

    boolean isSealed();

    ClassFileVersion getClassFileVersion();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic.class */
    public interface Generic extends TypeDefinition, AnnotationSource {
        public static final Generic OBJECT = new OfNonGenericType.ForLoadedType(Object.class);
        public static final Generic CLASS = new OfNonGenericType.ForLoadedType(Class.class);
        public static final Generic VOID = new OfNonGenericType.ForLoadedType(Void.TYPE);
        public static final Generic ANNOTATION = new OfNonGenericType.ForLoadedType(Annotation.class);
        public static final Generic UNDEFINED = null;

        Generic asRawType();

        TypeList.Generic getUpperBounds();

        TypeList.Generic getLowerBounds();

        TypeList.Generic getTypeArguments();

        Generic getOwnerType();

        Generic findBindingOf(Generic generic);

        TypeVariableSource getTypeVariableSource();

        String getSymbol();

        @Override // net.bytebuddy.description.type.TypeDefinition
        Generic getComponentType();

        @Override // net.bytebuddy.description.type.TypeDefinition
        FieldList<FieldDescription.InGenericShape> getDeclaredFields();

        @Override // net.bytebuddy.description.type.TypeDefinition
        MethodList<MethodDescription.InGenericShape> getDeclaredMethods();

        @Override // net.bytebuddy.description.type.TypeDefinition
        RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents();

        <T> T accept(Visitor<T> visitor);

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor.class */
        public interface Visitor<T> {
            T onGenericArray(Generic generic);

            T onWildcard(Generic generic);

            T onParameterizedType(Generic generic);

            T onTypeVariable(Generic generic);

            T onNonGenericType(Generic generic);

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$NoOp.class */
            public enum NoOp implements Visitor<Generic> {
                INSTANCE;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onGenericArray(Generic genericArray) {
                    return genericArray;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onWildcard(Generic wildcard) {
                    return wildcard;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onParameterizedType(Generic parameterizedType) {
                    return parameterizedType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onTypeVariable(Generic typeVariable) {
                    return typeVariable;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onNonGenericType(Generic typeDescription) {
                    return typeDescription;
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$TypeErasing.class */
            public enum TypeErasing implements Visitor<Generic> {
                INSTANCE;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onGenericArray(Generic genericArray) {
                    return genericArray.asRawType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onWildcard(Generic wildcard) {
                    throw new IllegalArgumentException("Cannot erase a wildcard type: " + wildcard);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onParameterizedType(Generic parameterizedType) {
                    return parameterizedType.asRawType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onTypeVariable(Generic typeVariable) {
                    return typeVariable.asRawType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onNonGenericType(Generic typeDescription) {
                    return typeDescription.asRawType();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$AnnotationStripper.class */
            public enum AnnotationStripper implements Visitor<Generic> {
                INSTANCE;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onGenericArray(Generic genericArray) {
                    return new OfGenericArray.Latent((Generic) genericArray.getComponentType().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onWildcard(Generic wildcard) {
                    return new OfWildcardType.Latent(wildcard.getUpperBounds().accept(this), wildcard.getLowerBounds().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onParameterizedType(Generic parameterizedType) {
                    Generic ownerType = parameterizedType.getOwnerType();
                    return new OfParameterizedType.Latent(parameterizedType.asErasure(), ownerType == null ? Generic.UNDEFINED : (Generic) ownerType.accept(this), parameterizedType.getTypeArguments().accept(this), AnnotationSource.Empty.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onTypeVariable(Generic typeVariable) {
                    return new NonAnnotatedTypeVariable(typeVariable);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onNonGenericType(Generic typeDescription) {
                    if (typeDescription.isArray()) {
                        return new OfGenericArray.Latent(onNonGenericType(typeDescription.getComponentType()), AnnotationSource.Empty.INSTANCE);
                    }
                    return new OfNonGenericType.Latent(typeDescription.asErasure(), AnnotationSource.Empty.INSTANCE);
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$AnnotationStripper$NonAnnotatedTypeVariable.class */
                public static class NonAnnotatedTypeVariable extends OfTypeVariable {
                    private final Generic typeVariable;

                    protected NonAnnotatedTypeVariable(Generic typeVariable) {
                        this.typeVariable = typeVariable;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public TypeList.Generic getUpperBounds() {
                        return this.typeVariable.getUpperBounds();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public TypeVariableSource getTypeVariableSource() {
                        return this.typeVariable.getTypeVariableSource();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public String getSymbol() {
                        return this.typeVariable.getSymbol();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return new AnnotationList.Empty();
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner.class */
            public enum Assigner implements Visitor<Dispatcher> {
                INSTANCE;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Dispatcher onGenericArray(Generic genericArray) {
                    return new Dispatcher.ForGenericArray(genericArray);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Dispatcher onWildcard(Generic wildcard) {
                    throw new IllegalArgumentException("A wildcard is not a first level type: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Dispatcher onParameterizedType(Generic parameterizedType) {
                    return new Dispatcher.ForParameterizedType(parameterizedType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Dispatcher onTypeVariable(Generic typeVariable) {
                    return new Dispatcher.ForTypeVariable(typeVariable);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Dispatcher onNonGenericType(Generic typeDescription) {
                    return new Dispatcher.ForNonGenericType(typeDescription.asErasure());
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher.class */
                public interface Dispatcher {
                    boolean isAssignableFrom(Generic generic);

                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$AbstractBase.class */
                    public static abstract class AbstractBase implements Dispatcher, Visitor<Boolean> {
                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Assigner.Dispatcher
                        public boolean isAssignableFrom(Generic typeDescription) {
                            return ((Boolean) typeDescription.accept(this)).booleanValue();
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForNonGenericType.class */
                    public static class ForNonGenericType extends AbstractBase {
                        private final TypeDescription typeDescription;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForNonGenericType) obj).typeDescription);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                        }

                        protected ForNonGenericType(TypeDescription typeDescription) {
                            this.typeDescription = typeDescription;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onGenericArray(Generic genericArray) {
                            boolean z;
                            if (this.typeDescription.isArray()) {
                                z = ((Boolean) genericArray.getComponentType().accept(new ForNonGenericType(this.typeDescription.getComponentType()))).booleanValue();
                            } else {
                                z = this.typeDescription.represents(Object.class) || TypeDescription.ARRAY_INTERFACES.contains(this.typeDescription.asGenericType());
                            }
                            return Boolean.valueOf(z);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onWildcard(Generic wildcard) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + wildcard);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onParameterizedType(Generic parameterizedType) {
                            if (this.typeDescription.equals(parameterizedType.asErasure())) {
                                return true;
                            }
                            Generic superClass = parameterizedType.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return true;
                            }
                            for (Generic interfaceType : parameterizedType.getInterfaces()) {
                                if (isAssignableFrom(interfaceType)) {
                                    return true;
                                }
                            }
                            return Boolean.valueOf(this.typeDescription.represents(Object.class));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onTypeVariable(Generic typeVariable) {
                            for (Generic upperBound : typeVariable.getUpperBounds()) {
                                if (isAssignableFrom(upperBound)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onNonGenericType(Generic typeDescription) {
                            return Boolean.valueOf(this.typeDescription.isAssignableFrom(typeDescription.asErasure()));
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForTypeVariable.class */
                    public static class ForTypeVariable extends AbstractBase {
                        private final Generic typeVariable;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((ForTypeVariable) obj).typeVariable);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.typeVariable.hashCode();
                        }

                        protected ForTypeVariable(Generic typeVariable) {
                            this.typeVariable = typeVariable;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onGenericArray(Generic genericArray) {
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onWildcard(Generic wildcard) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + wildcard);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onParameterizedType(Generic parameterizedType) {
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onTypeVariable(Generic typeVariable) {
                            if (typeVariable.equals(this.typeVariable)) {
                                return true;
                            }
                            for (Generic upperBound : typeVariable.getUpperBounds()) {
                                if (isAssignableFrom(upperBound)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onNonGenericType(Generic typeDescription) {
                            return false;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType.class */
                    public static class ForParameterizedType extends AbstractBase {
                        private final Generic parameterizedType;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.parameterizedType.equals(((ForParameterizedType) obj).parameterizedType);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.parameterizedType.hashCode();
                        }

                        protected ForParameterizedType(Generic parameterizedType) {
                            this.parameterizedType = parameterizedType;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onGenericArray(Generic genericArray) {
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onWildcard(Generic wildcard) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + wildcard);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onParameterizedType(Generic parameterizedType) {
                            if (this.parameterizedType.asErasure().equals(parameterizedType.asErasure())) {
                                Generic fromOwner = this.parameterizedType.getOwnerType();
                                Generic toOwner = parameterizedType.getOwnerType();
                                if (!(fromOwner == null || toOwner == null || ((Dispatcher) fromOwner.accept(Assigner.INSTANCE)).isAssignableFrom(toOwner))) {
                                    return false;
                                }
                                TypeList.Generic fromArguments = this.parameterizedType.getTypeArguments();
                                TypeList.Generic toArguments = parameterizedType.getTypeArguments();
                                if (fromArguments.size() == toArguments.size()) {
                                    for (int index = 0; index < fromArguments.size(); index++) {
                                        if (!((Dispatcher) ((Generic) fromArguments.get(index)).accept(ParameterAssigner.INSTANCE)).isAssignableFrom((Generic) toArguments.get(index))) {
                                            return false;
                                        }
                                    }
                                    return true;
                                }
                                throw new IllegalArgumentException("Incompatible generic types: " + parameterizedType + " and " + this.parameterizedType);
                            }
                            Generic superClass = parameterizedType.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return true;
                            }
                            for (Generic interfaceType : parameterizedType.getInterfaces()) {
                                if (isAssignableFrom(interfaceType)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onTypeVariable(Generic typeVariable) {
                            for (Generic upperBound : typeVariable.getUpperBounds()) {
                                if (isAssignableFrom(upperBound)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onNonGenericType(Generic typeDescription) {
                            if (this.parameterizedType.asErasure().equals(typeDescription.asErasure())) {
                                return true;
                            }
                            Generic superClass = typeDescription.getSuperClass();
                            if (superClass != null && isAssignableFrom(superClass)) {
                                return true;
                            }
                            for (Generic interfaceType : typeDescription.getInterfaces()) {
                                if (isAssignableFrom(interfaceType)) {
                                    return true;
                                }
                            }
                            return false;
                        }

                        /* access modifiers changed from: protected */
                        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner.class */
                        public enum ParameterAssigner implements Visitor<Dispatcher> {
                            INSTANCE;

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                            public Dispatcher onGenericArray(Generic genericArray) {
                                return new InvariantBinding(genericArray);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                            public Dispatcher onWildcard(Generic wildcard) {
                                TypeList.Generic lowerBounds = wildcard.getLowerBounds();
                                if (lowerBounds.isEmpty()) {
                                    return new CovariantBinding(wildcard.getUpperBounds().getOnly());
                                }
                                return new ContravariantBinding(lowerBounds.getOnly());
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                            public Dispatcher onParameterizedType(Generic parameterizedType) {
                                return new InvariantBinding(parameterizedType);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                            public Dispatcher onTypeVariable(Generic typeVariable) {
                                return new InvariantBinding(typeVariable);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                            public Dispatcher onNonGenericType(Generic typeDescription) {
                                return new InvariantBinding(typeDescription);
                            }

                            /* access modifiers changed from: protected */
                            @HashCodeAndEqualsPlugin.Enhance
                            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner$InvariantBinding.class */
                            public static class InvariantBinding implements Dispatcher {
                                private final Generic typeDescription;

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((InvariantBinding) obj).typeDescription);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                                }

                                protected InvariantBinding(Generic typeDescription) {
                                    this.typeDescription = typeDescription;
                                }

                                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Assigner.Dispatcher
                                public boolean isAssignableFrom(Generic typeDescription) {
                                    return typeDescription.equals(this.typeDescription);
                                }
                            }

                            /* access modifiers changed from: protected */
                            @HashCodeAndEqualsPlugin.Enhance
                            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner$CovariantBinding.class */
                            public static class CovariantBinding implements Dispatcher {
                                private final Generic upperBound;

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.upperBound.equals(((CovariantBinding) obj).upperBound);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.upperBound.hashCode();
                                }

                                protected CovariantBinding(Generic upperBound) {
                                    this.upperBound = upperBound;
                                }

                                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Assigner.Dispatcher
                                public boolean isAssignableFrom(Generic typeDescription) {
                                    if (typeDescription.getSort().isWildcard()) {
                                        return typeDescription.getLowerBounds().isEmpty() && ((Dispatcher) this.upperBound.accept(Assigner.INSTANCE)).isAssignableFrom(typeDescription.getUpperBounds().getOnly());
                                    }
                                    return ((Dispatcher) this.upperBound.accept(Assigner.INSTANCE)).isAssignableFrom(typeDescription);
                                }
                            }

                            /* access modifiers changed from: protected */
                            @HashCodeAndEqualsPlugin.Enhance
                            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForParameterizedType$ParameterAssigner$ContravariantBinding.class */
                            public static class ContravariantBinding implements Dispatcher {
                                private final Generic lowerBound;

                                public boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    return obj != null && getClass() == obj.getClass() && this.lowerBound.equals(((ContravariantBinding) obj).lowerBound);
                                }

                                public int hashCode() {
                                    return (getClass().hashCode() * 31) + this.lowerBound.hashCode();
                                }

                                protected ContravariantBinding(Generic lowerBound) {
                                    this.lowerBound = lowerBound;
                                }

                                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Assigner.Dispatcher
                                public boolean isAssignableFrom(Generic typeDescription) {
                                    if (!typeDescription.getSort().isWildcard()) {
                                        return typeDescription.getSort().isWildcard() || ((Dispatcher) typeDescription.accept(Assigner.INSTANCE)).isAssignableFrom(this.lowerBound);
                                    }
                                    TypeList.Generic lowerBounds = typeDescription.getLowerBounds();
                                    return !lowerBounds.isEmpty() && ((Dispatcher) lowerBounds.getOnly().accept(Assigner.INSTANCE)).isAssignableFrom(this.lowerBound);
                                }
                            }
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Assigner$Dispatcher$ForGenericArray.class */
                    public static class ForGenericArray extends AbstractBase {
                        private final Generic genericArray;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.genericArray.equals(((ForGenericArray) obj).genericArray);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.genericArray.hashCode();
                        }

                        protected ForGenericArray(Generic genericArray) {
                            this.genericArray = genericArray;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onGenericArray(Generic genericArray) {
                            return Boolean.valueOf(((Dispatcher) this.genericArray.getComponentType().accept(Assigner.INSTANCE)).isAssignableFrom(genericArray.getComponentType()));
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onWildcard(Generic wildcard) {
                            throw new IllegalArgumentException("A wildcard is not a first-level type: " + wildcard);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onParameterizedType(Generic parameterizedType) {
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onTypeVariable(Generic typeVariable) {
                            return false;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                        public Boolean onNonGenericType(Generic typeDescription) {
                            return Boolean.valueOf(typeDescription.isArray() && ((Dispatcher) this.genericArray.getComponentType().accept(Assigner.INSTANCE)).isAssignableFrom(typeDescription.getComponentType()));
                        }
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Validator.class */
            public enum Validator implements Visitor<Boolean> {
                SUPER_CLASS(false, false, false, false) {
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onTypeVariable(Generic generic) {
                        return onTypeVariable(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onNonGenericType(Generic typeDescription) {
                        return Boolean.valueOf(onNonGenericType(typeDescription).booleanValue() && !typeDescription.isInterface());
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onParameterizedType(Generic parameterizedType) {
                        return Boolean.valueOf(!parameterizedType.isInterface());
                    }
                },
                INTERFACE(false, false, false, false) {
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onTypeVariable(Generic generic) {
                        return onTypeVariable(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onNonGenericType(Generic typeDescription) {
                        return Boolean.valueOf(onNonGenericType(typeDescription).booleanValue() && typeDescription.isInterface());
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onParameterizedType(Generic parameterizedType) {
                        return Boolean.valueOf(parameterizedType.isInterface());
                    }
                },
                TYPE_VARIABLE(false, false, true, false),
                FIELD(true, true, true, false),
                METHOD_RETURN(true, true, true, true),
                METHOD_PARAMETER(true, true, true, false),
                EXCEPTION(false, false, true, false) {
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Boolean onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onParameterizedType(Generic parameterizedType) {
                        return false;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onTypeVariable(Generic typeVariable) {
                        for (Generic bound : typeVariable.getUpperBounds()) {
                            if (((Boolean) bound.accept(this)).booleanValue()) {
                                return true;
                            }
                        }
                        return false;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onNonGenericType(Generic typeDescription) {
                        return Boolean.valueOf(typeDescription.asErasure().isAssignableTo(Throwable.class));
                    }
                },
                RECEIVER(false, false, false, false);
                
                private final boolean acceptsArray;
                private final boolean acceptsPrimitive;
                private final boolean acceptsVariable;
                private final boolean acceptsVoid;

                Validator(boolean acceptsArray, boolean acceptsPrimitive, boolean acceptsVariable, boolean acceptsVoid) {
                    this.acceptsArray = acceptsArray;
                    this.acceptsPrimitive = acceptsPrimitive;
                    this.acceptsVariable = acceptsVariable;
                    this.acceptsVoid = acceptsVoid;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Boolean onGenericArray(Generic genericArray) {
                    return Boolean.valueOf(this.acceptsArray);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Boolean onWildcard(Generic wildcard) {
                    return false;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Boolean onParameterizedType(Generic parameterizedType) {
                    return true;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Boolean onTypeVariable(Generic typeVariable) {
                    return Boolean.valueOf(this.acceptsVariable);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Boolean onNonGenericType(Generic typeDescription) {
                    return Boolean.valueOf((this.acceptsArray || !typeDescription.isArray()) && (this.acceptsPrimitive || !typeDescription.isPrimitive()) && (this.acceptsVoid || !typeDescription.represents(Void.TYPE)));
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations.class */
                public enum ForTypeAnnotations implements Visitor<Boolean> {
                    INSTANCE;
                    
                    private final ElementType typeUse;
                    private final ElementType typeParameter;

                    ForTypeAnnotations() {
                        ElementType typeParameter;
                        ElementType typeUse;
                        try {
                            typeUse = (ElementType) Enum.valueOf(ElementType.class, "TYPE_USE");
                            typeParameter = (ElementType) Enum.valueOf(ElementType.class, "TYPE_PARAMETER");
                        } catch (IllegalArgumentException e) {
                            typeUse = null;
                            typeParameter = null;
                        }
                        this.typeUse = typeUse;
                        this.typeParameter = typeParameter;
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:5:0x001d  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public static boolean ofFormalTypeVariable(net.bytebuddy.description.type.TypeDescription.Generic r3) {
                        /*
                            java.util.HashSet r0 = new java.util.HashSet
                            r1 = r0
                            r1.<init>()
                            r4 = r0
                            r0 = r3
                            net.bytebuddy.description.annotation.AnnotationList r0 = r0.getDeclaredAnnotations()
                            java.util.Iterator r0 = r0.iterator()
                            r5 = r0
                        L_0x0014:
                            r0 = r5
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x004f
                            r0 = r5
                            java.lang.Object r0 = r0.next()
                            net.bytebuddy.description.annotation.AnnotationDescription r0 = (net.bytebuddy.description.annotation.AnnotationDescription) r0
                            r6 = r0
                            r0 = r6
                            java.util.Set r0 = r0.getElementTypes()
                            net.bytebuddy.description.type.TypeDescription$Generic$Visitor$Validator$ForTypeAnnotations r1 = net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.INSTANCE
                            java.lang.annotation.ElementType r1 = r1.typeParameter
                            boolean r0 = r0.contains(r1)
                            if (r0 == 0) goto L_0x004a
                            r0 = r4
                            r1 = r6
                            net.bytebuddy.description.type.TypeDescription r1 = r1.getAnnotationType()
                            boolean r0 = r0.add(r1)
                            if (r0 != 0) goto L_0x004c
                        L_0x004a:
                            r0 = 0
                            return r0
                        L_0x004c:
                            goto L_0x0014
                        L_0x004f:
                            r0 = 1
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.ofFormalTypeVariable(net.bytebuddy.description.type.TypeDescription$Generic):boolean");
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onGenericArray(Generic genericArray) {
                        return Boolean.valueOf(isValid(genericArray) && ((Boolean) genericArray.getComponentType().accept(this)).booleanValue());
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onWildcard(Generic wildcard) {
                        if (!isValid(wildcard)) {
                            return false;
                        }
                        TypeList.Generic lowerBounds = wildcard.getLowerBounds();
                        return (Boolean) (lowerBounds.isEmpty() ? wildcard.getUpperBounds() : lowerBounds).getOnly().accept(this);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onParameterizedType(Generic parameterizedType) {
                        if (!isValid(parameterizedType)) {
                            return false;
                        }
                        Generic ownerType = parameterizedType.getOwnerType();
                        if (!(ownerType == null || ((Boolean) ownerType.accept(this)).booleanValue())) {
                            return false;
                        }
                        for (Generic typeArgument : parameterizedType.getTypeArguments()) {
                            if (!((Boolean) typeArgument.accept(this)).booleanValue()) {
                                return false;
                            }
                        }
                        return true;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onTypeVariable(Generic typeVariable) {
                        return Boolean.valueOf(isValid(typeVariable));
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Boolean onNonGenericType(Generic typeDescription) {
                        return Boolean.valueOf(isValid(typeDescription) && (!typeDescription.isArray() || ((Boolean) typeDescription.getComponentType().accept(this)).booleanValue()));
                    }

                    /* JADX WARNING: Removed duplicated region for block: B:5:0x001d  */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    private boolean isValid(net.bytebuddy.description.type.TypeDescription.Generic r4) {
                        /*
                            r3 = this;
                            java.util.HashSet r0 = new java.util.HashSet
                            r1 = r0
                            r1.<init>()
                            r5 = r0
                            r0 = r4
                            net.bytebuddy.description.annotation.AnnotationList r0 = r0.getDeclaredAnnotations()
                            java.util.Iterator r0 = r0.iterator()
                            r6 = r0
                        L_0x0014:
                            r0 = r6
                            boolean r0 = r0.hasNext()
                            if (r0 == 0) goto L_0x0050
                            r0 = r6
                            java.lang.Object r0 = r0.next()
                            net.bytebuddy.description.annotation.AnnotationDescription r0 = (net.bytebuddy.description.annotation.AnnotationDescription) r0
                            r7 = r0
                            r0 = r7
                            java.util.Set r0 = r0.getElementTypes()
                            r1 = r3
                            java.lang.annotation.ElementType r1 = r1.typeUse
                            boolean r0 = r0.contains(r1)
                            if (r0 == 0) goto L_0x004b
                            r0 = r5
                            r1 = r7
                            net.bytebuddy.description.type.TypeDescription r1 = r1.getAnnotationType()
                            boolean r0 = r0.add(r1)
                            if (r0 != 0) goto L_0x004d
                        L_0x004b:
                            r0 = 0
                            return r0
                        L_0x004d:
                            goto L_0x0014
                        L_0x0050:
                            r0 = 1
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Validator.ForTypeAnnotations.isValid(net.bytebuddy.description.type.TypeDescription$Generic):boolean");
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Reifying.class */
            public enum Reifying implements Visitor<Generic> {
                INITIATING {
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onNonGenericType(Generic generic) {
                        return onNonGenericType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onTypeVariable(Generic generic) {
                        return onTypeVariable(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onParameterizedType(Generic parameterizedType) {
                        return parameterizedType;
                    }
                },
                INHERITING {
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onNonGenericType(Generic generic) {
                        return onNonGenericType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onTypeVariable(Generic generic) {
                        return onTypeVariable(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Reifying, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onParameterizedType(Generic parameterizedType) {
                        return new OfParameterizedType.ForReifiedType(parameterizedType);
                    }
                };

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onGenericArray(Generic genericArray) {
                    throw new IllegalArgumentException("Cannot reify a generic array: " + genericArray);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onWildcard(Generic wildcard) {
                    throw new IllegalArgumentException("Cannot reify a wildcard: " + wildcard);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onTypeVariable(Generic typeVariable) {
                    throw new IllegalArgumentException("Cannot reify a type variable: " + typeVariable);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onNonGenericType(Generic typeDescription) {
                    TypeDescription erasure = typeDescription.asErasure();
                    return erasure.isGenerified() ? new OfNonGenericType.ForReifiedErasure(erasure) : typeDescription;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$ForSignatureVisitor.class */
            public static class ForSignatureVisitor implements Visitor<SignatureVisitor> {
                private static final int ONLY_CHARACTER = 0;
                protected final SignatureVisitor signatureVisitor;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.signatureVisitor.equals(((ForSignatureVisitor) obj).signatureVisitor);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.signatureVisitor.hashCode();
                }

                public ForSignatureVisitor(SignatureVisitor signatureVisitor) {
                    this.signatureVisitor = signatureVisitor;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public SignatureVisitor onGenericArray(Generic genericArray) {
                    genericArray.getComponentType().accept(new ForSignatureVisitor(this.signatureVisitor.visitArrayType()));
                    return this.signatureVisitor;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public SignatureVisitor onWildcard(Generic wildcard) {
                    throw new IllegalStateException("Unexpected wildcard: " + wildcard);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public SignatureVisitor onParameterizedType(Generic parameterizedType) {
                    onOwnableType(parameterizedType);
                    this.signatureVisitor.visitEnd();
                    return this.signatureVisitor;
                }

                private void onOwnableType(Generic ownableType) {
                    Generic ownerType = ownableType.getOwnerType();
                    if (ownerType == null || !ownerType.getSort().isParameterized()) {
                        this.signatureVisitor.visitClassType(ownableType.asErasure().getInternalName());
                    } else {
                        onOwnableType(ownerType);
                        this.signatureVisitor.visitInnerClassType(ownableType.asErasure().getSimpleName());
                    }
                    for (Generic typeArgument : ownableType.getTypeArguments()) {
                        typeArgument.accept(new OfTypeArgument(this.signatureVisitor));
                    }
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public SignatureVisitor onTypeVariable(Generic typeVariable) {
                    this.signatureVisitor.visitTypeVariable(typeVariable.getSymbol());
                    return this.signatureVisitor;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public SignatureVisitor onNonGenericType(Generic typeDescription) {
                    if (typeDescription.isArray()) {
                        typeDescription.getComponentType().accept(new ForSignatureVisitor(this.signatureVisitor.visitArrayType()));
                    } else if (typeDescription.isPrimitive()) {
                        this.signatureVisitor.visitBaseType(typeDescription.asErasure().getDescriptor().charAt(0));
                    } else {
                        this.signatureVisitor.visitClassType(typeDescription.asErasure().getInternalName());
                        this.signatureVisitor.visitEnd();
                    }
                    return this.signatureVisitor;
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$ForSignatureVisitor$OfTypeArgument.class */
                public static class OfTypeArgument extends ForSignatureVisitor {
                    protected OfTypeArgument(SignatureVisitor signatureVisitor) {
                        super(signatureVisitor);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.ForSignatureVisitor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public SignatureVisitor onWildcard(Generic wildcard) {
                        TypeList.Generic upperBounds = wildcard.getUpperBounds();
                        TypeList.Generic lowerBounds = wildcard.getLowerBounds();
                        if (lowerBounds.isEmpty() && upperBounds.getOnly().represents(Object.class)) {
                            this.signatureVisitor.visitTypeArgument();
                        } else if (!lowerBounds.isEmpty()) {
                            lowerBounds.getOnly().accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('-')));
                        } else {
                            upperBounds.getOnly().accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('+')));
                        }
                        return this.signatureVisitor;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.ForSignatureVisitor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public SignatureVisitor onGenericArray(Generic genericArray) {
                        genericArray.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
                        return this.signatureVisitor;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.ForSignatureVisitor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public SignatureVisitor onParameterizedType(Generic parameterizedType) {
                        parameterizedType.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
                        return this.signatureVisitor;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.ForSignatureVisitor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public SignatureVisitor onTypeVariable(Generic typeVariable) {
                        typeVariable.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
                        return this.signatureVisitor;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.ForSignatureVisitor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public SignatureVisitor onNonGenericType(Generic typeDescription) {
                        typeDescription.accept(new ForSignatureVisitor(this.signatureVisitor.visitTypeArgument('=')));
                        return this.signatureVisitor;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor.class */
            public static abstract class Substitutor implements Visitor<Generic> {
                protected abstract Generic onSimpleType(Generic generic);

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onParameterizedType(Generic parameterizedType) {
                    Generic ownerType = parameterizedType.getOwnerType();
                    ArrayList arrayList = new ArrayList(parameterizedType.getTypeArguments().size());
                    for (Generic typeArgument : parameterizedType.getTypeArguments()) {
                        arrayList.add(typeArgument.accept(this));
                    }
                    return new OfParameterizedType.Latent(((Generic) parameterizedType.asRawType().accept(this)).asErasure(), ownerType == null ? Generic.UNDEFINED : (Generic) ownerType.accept(this), arrayList, parameterizedType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onGenericArray(Generic genericArray) {
                    return new OfGenericArray.Latent((Generic) genericArray.getComponentType().accept(this), genericArray);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onWildcard(Generic wildcard) {
                    return new OfWildcardType.Latent(wildcard.getUpperBounds().accept(this), wildcard.getLowerBounds().accept(this), wildcard);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onNonGenericType(Generic typeDescription) {
                    if (typeDescription.isArray()) {
                        return new OfGenericArray.Latent((Generic) typeDescription.getComponentType().accept(this), typeDescription);
                    }
                    return onSimpleType(typeDescription);
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$WithoutTypeSubstitution.class */
                public static abstract class WithoutTypeSubstitution extends Substitutor {
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onParameterizedType(Generic generic) {
                        return onParameterizedType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onNonGenericType(Generic typeDescription) {
                        return typeDescription;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor
                    protected Generic onSimpleType(Generic typeDescription) {
                        return typeDescription;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$ForAttachment.class */
                public static class ForAttachment extends Substitutor {
                    private final TypeDescription declaringType;
                    private final TypeVariableSource typeVariableSource;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((ForAttachment) obj).declaringType) && this.typeVariableSource.equals(((ForAttachment) obj).typeVariableSource);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.declaringType.hashCode()) * 31) + this.typeVariableSource.hashCode();
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onNonGenericType(Generic generic) {
                        return onNonGenericType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onParameterizedType(Generic generic) {
                        return onParameterizedType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    protected ForAttachment(TypeDefinition declaringType, TypeVariableSource typeVariableSource) {
                        this(declaringType.asErasure(), typeVariableSource);
                    }

                    protected ForAttachment(TypeDescription declaringType, TypeVariableSource typeVariableSource) {
                        this.declaringType = declaringType;
                        this.typeVariableSource = typeVariableSource;
                    }

                    /* renamed from: of */
                    public static ForAttachment m237of(TypeDescription typeDescription) {
                        return new ForAttachment(typeDescription, (TypeVariableSource) typeDescription);
                    }

                    /* renamed from: of */
                    public static ForAttachment m241of(FieldDescription fieldDescription) {
                        return new ForAttachment(fieldDescription.getDeclaringType(), fieldDescription.getDeclaringType().asErasure());
                    }

                    /* renamed from: of */
                    public static ForAttachment m240of(MethodDescription methodDescription) {
                        return new ForAttachment(methodDescription.getDeclaringType(), methodDescription);
                    }

                    /* renamed from: of */
                    public static ForAttachment m239of(ParameterDescription parameterDescription) {
                        return new ForAttachment(parameterDescription.getDeclaringMethod().getDeclaringType(), parameterDescription.getDeclaringMethod());
                    }

                    /* renamed from: of */
                    public static ForAttachment m238of(RecordComponentDescription recordComponentDescription) {
                        return new ForAttachment(recordComponentDescription.getDeclaringType(), recordComponentDescription.getDeclaringType().asErasure());
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onTypeVariable(Generic typeVariable) {
                        Generic attachedVariable = this.typeVariableSource.findVariable(typeVariable.getSymbol());
                        if (attachedVariable != null) {
                            return new OfTypeVariable.WithAnnotationOverlay(attachedVariable, typeVariable);
                        }
                        throw new IllegalArgumentException("Cannot attach undefined variable: " + typeVariable);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor
                    protected Generic onSimpleType(Generic typeDescription) {
                        return typeDescription.represents(TargetType.class) ? new OfNonGenericType.Latent(this.declaringType, typeDescription) : typeDescription;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$ForDetachment.class */
                public static class ForDetachment extends Substitutor {
                    private final ElementMatcher<? super TypeDescription> typeMatcher;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeMatcher.equals(((ForDetachment) obj).typeMatcher);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeMatcher.hashCode();
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onNonGenericType(Generic generic) {
                        return onNonGenericType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onParameterizedType(Generic generic) {
                        return onParameterizedType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    public ForDetachment(ElementMatcher<? super TypeDescription> typeMatcher) {
                        this.typeMatcher = typeMatcher;
                    }

                    /* renamed from: of */
                    public static Visitor<Generic> m236of(TypeDefinition typeDefinition) {
                        return new ForDetachment(ElementMatchers.m104is(typeDefinition));
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onTypeVariable(Generic typeVariable) {
                        return new OfTypeVariable.Symbolic(typeVariable.getSymbol(), typeVariable);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor
                    protected Generic onSimpleType(Generic typeDescription) {
                        return this.typeMatcher.matches(typeDescription.asErasure()) ? new OfNonGenericType.Latent(TargetType.DESCRIPTION, typeDescription.getOwnerType(), typeDescription) : typeDescription;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$ForTypeVariableBinding.class */
                public static class ForTypeVariableBinding extends WithoutTypeSubstitution {
                    private final Generic parameterizedType;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.parameterizedType.equals(((ForTypeVariableBinding) obj).parameterizedType);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.parameterizedType.hashCode();
                    }

                    protected ForTypeVariableBinding(Generic parameterizedType) {
                        this.parameterizedType = parameterizedType;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onTypeVariable(Generic typeVariable) {
                        return (Generic) typeVariable.getTypeVariableSource().accept(new TypeVariableSubstitutor(typeVariable));
                    }

                    /* access modifiers changed from: protected */
                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$ForTypeVariableBinding$TypeVariableSubstitutor.class */
                    public class TypeVariableSubstitutor implements TypeVariableSource.Visitor<Generic> {
                        private final Generic typeVariable;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((TypeVariableSubstitutor) obj).typeVariable) && ForTypeVariableBinding.this.equals(ForTypeVariableBinding.this);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.typeVariable.hashCode()) * 31) + ForTypeVariableBinding.this.hashCode();
                        }

                        protected TypeVariableSubstitutor(Generic typeVariable) {
                            this.typeVariable = typeVariable;
                        }

                        @Override // net.bytebuddy.description.TypeVariableSource.Visitor
                        public Generic onType(TypeDescription typeDescription) {
                            Generic typeArgument = ForTypeVariableBinding.this.parameterizedType.findBindingOf(this.typeVariable);
                            return typeArgument == null ? this.typeVariable.asRawType() : typeArgument;
                        }

                        @Override // net.bytebuddy.description.TypeVariableSource.Visitor
                        public Generic onMethod(MethodDescription.InDefinedShape methodDescription) {
                            return new RetainedMethodTypeVariable(this.typeVariable);
                        }
                    }

                    /* access modifiers changed from: protected */
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$ForTypeVariableBinding$RetainedMethodTypeVariable.class */
                    public class RetainedMethodTypeVariable extends OfTypeVariable {
                        private final Generic typeVariable;

                        protected RetainedMethodTypeVariable(Generic typeVariable) {
                            this.typeVariable = typeVariable;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return this.typeVariable.getUpperBounds().accept(ForTypeVariableBinding.this);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariable.getTypeVariableSource();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public String getSymbol() {
                            return this.typeVariable.getSymbol();
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return this.typeVariable.getDeclaredAnnotations();
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Substitutor$ForTokenNormalization.class */
                public static class ForTokenNormalization extends Substitutor {
                    private final TypeDescription typeDescription;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((ForTokenNormalization) obj).typeDescription);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onNonGenericType(Generic generic) {
                        return onNonGenericType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onParameterizedType(Generic generic) {
                        return onParameterizedType(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onWildcard(Generic generic) {
                        return onWildcard(generic);
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor, net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public /* bridge */ /* synthetic */ Generic onGenericArray(Generic generic) {
                        return onGenericArray(generic);
                    }

                    public ForTokenNormalization(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor.Substitutor
                    protected Generic onSimpleType(Generic typeDescription) {
                        return typeDescription.represents(TargetType.class) ? new OfNonGenericType.Latent(this.typeDescription, typeDescription) : typeDescription;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                    public Generic onTypeVariable(Generic typeVariable) {
                        return new OfTypeVariable.Symbolic(typeVariable.getSymbol(), typeVariable);
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$ForRawType.class */
            public static class ForRawType implements Visitor<Generic> {
                private final TypeDescription declaringType;

                public ForRawType(TypeDescription declaringType) {
                    this.declaringType = declaringType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onGenericArray(Generic genericArray) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(genericArray.asErasure(), genericArray) : genericArray;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onWildcard(Generic wildcard) {
                    throw new IllegalStateException("Did not expect wildcard on top-level: " + wildcard);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onParameterizedType(Generic parameterizedType) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(parameterizedType.asErasure(), parameterizedType) : parameterizedType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onTypeVariable(Generic typeVariable) {
                    return this.declaringType.isGenerified() ? new OfNonGenericType.Latent(typeVariable.asErasure(), typeVariable) : typeVariable;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public Generic onNonGenericType(Generic typeDescription) {
                    return typeDescription;
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Visitor$Reducing.class */
            public static class Reducing implements Visitor<TypeDescription> {
                private final TypeDescription declaringType;
                private final List<? extends TypeVariableToken> typeVariableTokens;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.declaringType.equals(((Reducing) obj).declaringType) && this.typeVariableTokens.equals(((Reducing) obj).typeVariableTokens);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.declaringType.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                }

                public Reducing(TypeDescription declaringType, TypeVariableToken... typeVariableToken) {
                    this(declaringType, Arrays.asList(typeVariableToken));
                }

                public Reducing(TypeDescription declaringType, List<? extends TypeVariableToken> typeVariableTokens) {
                    this.declaringType = declaringType;
                    this.typeVariableTokens = typeVariableTokens;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public TypeDescription onGenericArray(Generic genericArray) {
                    Generic targetType = genericArray;
                    int arity = 0;
                    do {
                        targetType = targetType.getComponentType();
                        arity++;
                    } while (targetType.isArray());
                    if (!targetType.getSort().isTypeVariable()) {
                        return TargetType.resolve(genericArray.asErasure(), this.declaringType);
                    }
                    for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
                        if (targetType.getSymbol().equals(typeVariableToken.getSymbol())) {
                            return ArrayProjection.m248of((TypeDescription) ((Generic) typeVariableToken.getBounds().get(0)).accept(this), arity);
                        }
                    }
                    return TargetType.resolve(ArrayProjection.m248of(this.declaringType.findVariable(targetType.getSymbol()).asErasure(), arity), this.declaringType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public TypeDescription onWildcard(Generic wildcard) {
                    throw new IllegalStateException("A wildcard cannot be a top-level type: " + wildcard);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public TypeDescription onParameterizedType(Generic parameterizedType) {
                    return TargetType.resolve(parameterizedType.asErasure(), this.declaringType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public TypeDescription onTypeVariable(Generic typeVariable) {
                    for (TypeVariableToken typeVariableToken : this.typeVariableTokens) {
                        if (typeVariable.getSymbol().equals(typeVariableToken.getSymbol())) {
                            return (TypeDescription) ((Generic) typeVariableToken.getBounds().get(0)).accept(this);
                        }
                    }
                    return TargetType.resolve(this.declaringType.findVariable(typeVariable.getSymbol()).asErasure(), this.declaringType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Visitor
                public TypeDescription onNonGenericType(Generic typeDescription) {
                    return TargetType.resolve(typeDescription.asErasure(), this.declaringType);
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader.class */
        public interface AnnotationReader {
            AnnotatedElement resolve();

            AnnotationList asList();

            AnnotationReader ofWildcardUpperBoundType(int i);

            AnnotationReader ofWildcardLowerBoundType(int i);

            AnnotationReader ofTypeVariableBoundType(int i);

            AnnotationReader ofTypeArgument(int i);

            AnnotationReader ofOwnerType();

            AnnotationReader ofOuterClass();

            AnnotationReader ofComponentType();

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$NoOp.class */
            public enum NoOp implements AnnotationReader, AnnotatedElement {
                INSTANCE;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotatedElement resolve() {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationList asList() {
                    return new AnnotationList.Empty();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofWildcardUpperBoundType(int index) {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofWildcardLowerBoundType(int index) {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofTypeVariableBoundType(int index) {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofTypeArgument(int index) {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofOwnerType() {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofOuterClass() {
                    return this;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofComponentType() {
                    return this;
                }

                @Override // java.lang.reflect.AnnotatedElement
                public boolean isAnnotationPresent(Class<? extends Annotation> annotationClass) {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                @Override // java.lang.reflect.AnnotatedElement
                public <T extends Annotation> T getAnnotation(Class<T> annotationClass) {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                @Override // java.lang.reflect.AnnotatedElement
                public Annotation[] getAnnotations() {
                    throw new IllegalStateException("Cannot resolve annotations for no-op reader: " + this);
                }

                @Override // java.lang.reflect.AnnotatedElement
                public Annotation[] getDeclaredAnnotations() {
                    return new Annotation[0];
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator.class */
            public static abstract class Delegator implements AnnotationReader {
                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofWildcardUpperBoundType(int index) {
                    return new ForWildcardUpperBoundType(this, index);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofWildcardLowerBoundType(int index) {
                    return new ForWildcardLowerBoundType(this, index);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofTypeVariableBoundType(int index) {
                    return new ForTypeVariableBoundType(this, index);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofTypeArgument(int index) {
                    return new ForTypeArgument(this, index);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofOwnerType() {
                    return new ForOwnerType(this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofOuterClass() {
                    return new ForOwnerType(this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationReader ofComponentType() {
                    return new ForComponentType(this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public AnnotationList asList() {
                    return new AnnotationList.ForLoadedAnnotations(resolve().getDeclaredAnnotations());
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$Simple.class */
                public static class Simple extends Delegator {
                    private final AnnotatedElement annotatedElement;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.annotatedElement.equals(((Simple) obj).annotatedElement);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.annotatedElement.hashCode();
                    }

                    public Simple(AnnotatedElement annotatedElement) {
                        this.annotatedElement = annotatedElement;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        return this.annotatedElement;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$Chained.class */
                protected static abstract class Chained extends Delegator {
                    protected final AnnotationReader annotationReader;

                    protected abstract AnnotatedElement resolve(AnnotatedElement annotatedElement);

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.annotationReader.equals(((Chained) obj).annotationReader);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.annotationReader.hashCode();
                    }

                    protected Chained(AnnotationReader annotationReader) {
                        this.annotationReader = annotationReader;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        return resolve(this.annotationReader.resolve());
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedTypeVariable.class */
                public static class ForLoadedTypeVariable extends Delegator {
                    private final TypeVariable<?> typeVariable;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.typeVariable.equals(((ForLoadedTypeVariable) obj).typeVariable);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.typeVariable.hashCode();
                    }

                    public ForLoadedTypeVariable(TypeVariable<?> typeVariable) {
                        this.typeVariable = typeVariable;
                    }

                    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.reflect.TypeVariable<?>, java.lang.reflect.AnnotatedElement] */
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    @SuppressFBWarnings(value = {"BC_VACUOUS_INSTANCEOF"}, justification = "Cast is required for JVMs before Java 8")
                    public AnnotatedElement resolve() {
                        return this.typeVariable instanceof AnnotatedElement ? this.typeVariable : NoOp.INSTANCE;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotationReader ofTypeVariableBoundType(int index) {
                        return new ForTypeVariableBoundType.OfFormalTypeVariable(this.typeVariable, index);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedSuperClass.class */
                public static class ForLoadedSuperClass extends Delegator {
                    private final Class<?> type;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.type.equals(((ForLoadedSuperClass) obj).type);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.type.hashCode();
                    }

                    public ForLoadedSuperClass(Class<?> type) {
                        this.type = type;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        AnnotatedElement element = ForLoadedType.DISPATCHER.getAnnotatedSuperclass(this.type);
                        return element == null ? NoOp.INSTANCE : element;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedInterface.class */
                public static class ForLoadedInterface extends Delegator {
                    private final Class<?> type;
                    private final int index;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.index == ((ForLoadedInterface) obj).index && this.type.equals(((ForLoadedInterface) obj).type);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.type.hashCode()) * 31) + this.index;
                    }

                    public ForLoadedInterface(Class<?> type, int index) {
                        this.type = type;
                        this.index = index;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        AnnotatedElement[] element = ForLoadedType.DISPATCHER.getAnnotatedInterfaces(this.type);
                        return element.length == 0 ? NoOp.INSTANCE : element[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedField.class */
                public static class ForLoadedField extends Delegator {
                    protected static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
                    private final Field field;

                    @JavaDispatcher.Proxied("java.lang.reflect.Field")
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedField$Dispatcher.class */
                    protected interface Dispatcher {
                        @JavaDispatcher.Defaults
                        AnnotatedElement getAnnotatedType(Field field);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.field.equals(((ForLoadedField) obj).field);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.field.hashCode();
                    }

                    public ForLoadedField(Field field) {
                        this.field = field;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        AnnotatedElement element = DISPATCHER.getAnnotatedType(this.field);
                        return element == null ? NoOp.INSTANCE : element;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedMethodReturnType.class */
                public static class ForLoadedMethodReturnType extends Delegator {
                    protected static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
                    private final Method method;

                    @JavaDispatcher.Proxied("java.lang.reflect.Method")
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedMethodReturnType$Dispatcher.class */
                    protected interface Dispatcher {
                        @JavaDispatcher.Defaults
                        AnnotatedElement getAnnotatedReturnType(Method method);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.method.equals(((ForLoadedMethodReturnType) obj).method);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.method.hashCode();
                    }

                    public ForLoadedMethodReturnType(Method method) {
                        this.method = method;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        AnnotatedElement element = DISPATCHER.getAnnotatedReturnType(this.method);
                        return element == null ? NoOp.INSTANCE : element;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedExecutableParameterType.class */
                public static class ForLoadedExecutableParameterType extends Delegator {
                    protected static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
                    private final AccessibleObject executable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.Executable")
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedExecutableParameterType$Dispatcher.class */
                    protected interface Dispatcher {
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedParameterTypes(Object obj);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.index == ((ForLoadedExecutableParameterType) obj).index && this.executable.equals(((ForLoadedExecutableParameterType) obj).executable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.executable.hashCode()) * 31) + this.index;
                    }

                    public ForLoadedExecutableParameterType(AccessibleObject executable, int index) {
                        this.executable = executable;
                        this.index = index;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        AnnotatedElement[] element = DISPATCHER.getAnnotatedParameterTypes(this.executable);
                        return element.length == 0 ? NoOp.INSTANCE : element[this.index];
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedExecutableExceptionType.class */
                public static class ForLoadedExecutableExceptionType extends Delegator {
                    protected static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
                    private final AccessibleObject executable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.Executable")
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedExecutableExceptionType$Dispatcher.class */
                    protected interface Dispatcher {
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedExceptionTypes(Object obj);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.index == ((ForLoadedExecutableExceptionType) obj).index && this.executable.equals(((ForLoadedExecutableExceptionType) obj).executable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.executable.hashCode()) * 31) + this.index;
                    }

                    public ForLoadedExecutableExceptionType(AccessibleObject executable, int index) {
                        this.executable = executable;
                        this.index = index;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        AnnotatedElement[] element = DISPATCHER.getAnnotatedExceptionTypes(this.executable);
                        return element.length == 0 ? NoOp.INSTANCE : element[this.index];
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$Delegator$ForLoadedRecordComponent.class */
                public static class ForLoadedRecordComponent extends Delegator {
                    private final Object recordComponent;

                    public ForLoadedRecordComponent(Object recordComponent) {
                        this.recordComponent = recordComponent;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        return RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getAnnotatedType(this.recordComponent);
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForWildcardUpperBoundType.class */
            public static class ForWildcardUpperBoundType extends Delegator.Chained {
                private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = (AnnotatedWildcardType) AccessController.doPrivileged(JavaDispatcher.m62of(AnnotatedWildcardType.class));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedWildcardType")
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForWildcardUpperBoundType$AnnotatedWildcardType.class */
                protected interface AnnotatedWildcardType {
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);

                    AnnotatedElement[] getAnnotatedUpperBounds(AnnotatedElement annotatedElement);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForWildcardUpperBoundType) obj).index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public int hashCode() {
                    return (hashCode() * 31) + this.index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return resolve();
                }

                protected ForWildcardUpperBoundType(AnnotationReader annotationReader, int index) {
                    super(annotationReader);
                    this.index = index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                protected AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    if (!ANNOTATED_WILDCARD_TYPE.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        AnnotatedElement[] annotatedUpperBound = ANNOTATED_WILDCARD_TYPE.getAnnotatedUpperBounds(annotatedElement);
                        return annotatedUpperBound.length == 0 ? NoOp.INSTANCE : annotatedUpperBound[this.index];
                    } catch (ClassCastException e) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForWildcardLowerBoundType.class */
            public static class ForWildcardLowerBoundType extends Delegator.Chained {
                private static final AnnotatedWildcardType ANNOTATED_WILDCARD_TYPE = (AnnotatedWildcardType) AccessController.doPrivileged(JavaDispatcher.m62of(AnnotatedWildcardType.class));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedWildcardType")
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForWildcardLowerBoundType$AnnotatedWildcardType.class */
                protected interface AnnotatedWildcardType {
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);

                    AnnotatedElement[] getAnnotatedLowerBounds(AnnotatedElement annotatedElement);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForWildcardLowerBoundType) obj).index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public int hashCode() {
                    return (hashCode() * 31) + this.index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return resolve();
                }

                protected ForWildcardLowerBoundType(AnnotationReader annotationReader, int index) {
                    super(annotationReader);
                    this.index = index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                protected AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    if (!ANNOTATED_WILDCARD_TYPE.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return ANNOTATED_WILDCARD_TYPE.getAnnotatedLowerBounds(annotatedElement)[this.index];
                    } catch (ClassCastException e) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForTypeVariableBoundType.class */
            public static class ForTypeVariableBoundType extends Delegator.Chained {
                private static final AnnotatedTypeVariable ANNOTATED_TYPE_VARIABLE = (AnnotatedTypeVariable) AccessController.doPrivileged(JavaDispatcher.m62of(AnnotatedTypeVariable.class));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedTypeVariable")
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForTypeVariableBoundType$AnnotatedTypeVariable.class */
                protected interface AnnotatedTypeVariable {
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);

                    AnnotatedElement[] getAnnotatedBounds(AnnotatedElement annotatedElement);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForTypeVariableBoundType) obj).index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public int hashCode() {
                    return (hashCode() * 31) + this.index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return resolve();
                }

                protected ForTypeVariableBoundType(AnnotationReader annotationReader, int index) {
                    super(annotationReader);
                    this.index = index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                protected AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    if (!ANNOTATED_TYPE_VARIABLE.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return ANNOTATED_TYPE_VARIABLE.getAnnotatedBounds(annotatedElement)[this.index];
                    } catch (ClassCastException e) {
                        return NoOp.INSTANCE;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForTypeVariableBoundType$OfFormalTypeVariable.class */
                protected static class OfFormalTypeVariable extends Delegator {
                    private static final FormalTypeVariable TYPE_VARIABLE = (FormalTypeVariable) AccessController.doPrivileged(JavaDispatcher.m62of(FormalTypeVariable.class));
                    private final TypeVariable<?> typeVariable;
                    private final int index;

                    @JavaDispatcher.Proxied("java.lang.reflect.TypeVariable")
                    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForTypeVariableBoundType$OfFormalTypeVariable$FormalTypeVariable.class */
                    protected interface FormalTypeVariable {
                        @JavaDispatcher.Defaults
                        AnnotatedElement[] getAnnotatedBounds(Object obj);
                    }

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.index == ((OfFormalTypeVariable) obj).index && this.typeVariable.equals(((OfFormalTypeVariable) obj).typeVariable);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.typeVariable.hashCode()) * 31) + this.index;
                    }

                    protected OfFormalTypeVariable(TypeVariable<?> typeVariable, int index) {
                        this.typeVariable = typeVariable;
                        this.index = index;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                    public AnnotatedElement resolve() {
                        try {
                            AnnotatedElement[] annotatedBound = TYPE_VARIABLE.getAnnotatedBounds(this.typeVariable);
                            return annotatedBound.length == 0 ? NoOp.INSTANCE : annotatedBound[this.index];
                        } catch (ClassCastException e) {
                            return NoOp.INSTANCE;
                        }
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForTypeArgument.class */
            public static class ForTypeArgument extends Delegator.Chained {
                private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = (AnnotatedParameterizedType) AccessController.doPrivileged(JavaDispatcher.m62of(AnnotatedParameterizedType.class));
                private final int index;

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedParameterizedType")
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForTypeArgument$AnnotatedParameterizedType.class */
                protected interface AnnotatedParameterizedType {
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);

                    AnnotatedElement[] getAnnotatedActualTypeArguments(AnnotatedElement annotatedElement);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.index == ((ForTypeArgument) obj).index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                public int hashCode() {
                    return (hashCode() * 31) + this.index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return resolve();
                }

                protected ForTypeArgument(AnnotationReader annotationReader, int index) {
                    super(annotationReader);
                    this.index = index;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                protected AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    if (!ANNOTATED_PARAMETERIZED_TYPE.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return ANNOTATED_PARAMETERIZED_TYPE.getAnnotatedActualTypeArguments(annotatedElement)[this.index];
                    } catch (ClassCastException e) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForComponentType.class */
            public static class ForComponentType extends Delegator.Chained {
                private static final AnnotatedParameterizedType ANNOTATED_PARAMETERIZED_TYPE = (AnnotatedParameterizedType) AccessController.doPrivileged(JavaDispatcher.m62of(AnnotatedParameterizedType.class));

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedArrayType")
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForComponentType$AnnotatedParameterizedType.class */
                protected interface AnnotatedParameterizedType {
                    @JavaDispatcher.Instance
                    boolean isInstance(AnnotatedElement annotatedElement);

                    AnnotatedElement getAnnotatedGenericComponentType(AnnotatedElement annotatedElement);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return resolve();
                }

                protected ForComponentType(AnnotationReader annotationReader) {
                    super(annotationReader);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                protected AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    if (!ANNOTATED_PARAMETERIZED_TYPE.isInstance(annotatedElement)) {
                        return NoOp.INSTANCE;
                    }
                    try {
                        return ANNOTATED_PARAMETERIZED_TYPE.getAnnotatedGenericComponentType(annotatedElement);
                    } catch (ClassCastException e) {
                        return NoOp.INSTANCE;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForOwnerType.class */
            public static class ForOwnerType extends Delegator.Chained {
                private static final AnnotatedType ANNOTATED_TYPE = (AnnotatedType) AccessController.doPrivileged(JavaDispatcher.m62of(AnnotatedType.class));

                @JavaDispatcher.Proxied("java.lang.reflect.AnnotatedType")
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AnnotationReader$ForOwnerType$AnnotatedType.class */
                protected interface AnnotatedType {
                    @JavaDispatcher.Defaults
                    AnnotatedElement getAnnotatedOwnerType(AnnotatedElement annotatedElement);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained, net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader
                public /* bridge */ /* synthetic */ AnnotatedElement resolve() {
                    return resolve();
                }

                protected ForOwnerType(AnnotationReader annotationReader) {
                    super(annotationReader);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AnnotationReader.Delegator.Chained
                protected AnnotatedElement resolve(AnnotatedElement annotatedElement) {
                    try {
                        AnnotatedElement annotatedOwnerType = ANNOTATED_TYPE.getAnnotatedOwnerType(annotatedElement);
                        return annotatedOwnerType == null ? NoOp.INSTANCE : annotatedOwnerType;
                    } catch (ClassCastException e) {
                        return NoOp.INSTANCE;
                    }
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$AbstractBase.class */
        public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements Generic {
            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return asErasure().getModifiers();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public Generic asGenericType() {
                return this;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic asRawType() {
                return asErasure().asGenericType();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfNonGenericType.class */
        public static abstract class OfNonGenericType extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.NON_GENERIC;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public Generic getSuperClass() {
                TypeDescription erasure = asErasure();
                Generic superClass = erasure.getSuperClass();
                if (AbstractBase.RAW_TYPES) {
                    return superClass;
                }
                return superClass == null ? Generic.UNDEFINED : new LazyProjection.WithResolvedErasure(superClass, new Visitor.ForRawType(erasure), AnnotationSource.Empty.INSTANCE);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                TypeDescription erasure = asErasure();
                if (AbstractBase.RAW_TYPES) {
                    return erasure.getInterfaces();
                }
                return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(erasure.getInterfaces(), new Visitor.ForRawType(erasure));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                TypeDescription erasure = asErasure();
                return new FieldList.TypeSubstituting(this, erasure.getDeclaredFields(), AbstractBase.RAW_TYPES ? Visitor.NoOp.INSTANCE : new Visitor.ForRawType(erasure));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                TypeDescription erasure = asErasure();
                return new MethodList.TypeSubstituting(this, erasure.getDeclaredMethods(), AbstractBase.RAW_TYPES ? Visitor.NoOp.INSTANCE : new Visitor.ForRawType(erasure));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                TypeDescription erasure = asErasure();
                return new RecordComponentList.TypeSubstituting(this, erasure.getRecordComponents(), AbstractBase.RAW_TYPES ? Visitor.NoOp.INSTANCE : new Visitor.ForRawType(erasure));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic findBindingOf(Generic typeVariable) {
                throw new IllegalStateException("A non-generic type does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onNonGenericType(this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public String getTypeName() {
                return asErasure().getTypeName();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A non-generic type does not imply upper type bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A non-generic type does not imply lower type bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A non-generic type does not imply a type variable source: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public String getSymbol() {
                throw new IllegalStateException("A non-generic type does not imply a symbol: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                return asErasure().getStackSize();
            }

            @Override // net.bytebuddy.description.NamedElement
            public String getActualName() {
                return asErasure().getActualName();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return asErasure().isArray();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return asErasure().isPrimitive();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return asErasure().isRecord();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
            public boolean represents(Type type) {
                return asErasure().represents(type);
            }

            @Override // java.lang.Iterable
            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            @Override // java.lang.Object
            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode = this.hashCode != 0 ? 0 : asErasure().hashCode();
                if (hashCode == 0) {
                    hashCode = this.hashCode;
                } else {
                    this.hashCode = hashCode;
                }
                return hashCode;
            }

            @Override // java.lang.Object
            @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Type check is performed by erasure implementation")
            public boolean equals(Object other) {
                return this == other || asErasure().equals(other);
            }

            @Override // java.lang.Object
            public String toString() {
                return asErasure().toString();
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfNonGenericType$ForLoadedType.class */
            public static class ForLoadedType extends OfNonGenericType {
                @SuppressFBWarnings(value = {"MS_MUTABLE_COLLECTION_PKGPROTECT"}, justification = "This collection is not exposed.")
                private static final Map<Class<?>, Generic> TYPE_CACHE = new HashMap();
                private final Class<?> type;
                private final AnnotationReader annotationReader;

                static {
                    TYPE_CACHE.put(TargetType.class, new ForLoadedType(TargetType.class));
                    TYPE_CACHE.put(Object.class, new ForLoadedType(Object.class));
                    TYPE_CACHE.put(String.class, new ForLoadedType(String.class));
                    TYPE_CACHE.put(Boolean.class, new ForLoadedType(Boolean.class));
                    TYPE_CACHE.put(Byte.class, new ForLoadedType(Byte.class));
                    TYPE_CACHE.put(Short.class, new ForLoadedType(Short.class));
                    TYPE_CACHE.put(Character.class, new ForLoadedType(Character.class));
                    TYPE_CACHE.put(Integer.class, new ForLoadedType(Integer.class));
                    TYPE_CACHE.put(Long.class, new ForLoadedType(Long.class));
                    TYPE_CACHE.put(Float.class, new ForLoadedType(Float.class));
                    TYPE_CACHE.put(Double.class, new ForLoadedType(Double.class));
                    TYPE_CACHE.put(Void.TYPE, new ForLoadedType(Void.TYPE));
                    TYPE_CACHE.put(Boolean.TYPE, new ForLoadedType(Boolean.TYPE));
                    TYPE_CACHE.put(Byte.TYPE, new ForLoadedType(Byte.TYPE));
                    TYPE_CACHE.put(Short.TYPE, new ForLoadedType(Short.TYPE));
                    TYPE_CACHE.put(Character.TYPE, new ForLoadedType(Character.TYPE));
                    TYPE_CACHE.put(Integer.TYPE, new ForLoadedType(Integer.TYPE));
                    TYPE_CACHE.put(Long.TYPE, new ForLoadedType(Long.TYPE));
                    TYPE_CACHE.put(Float.TYPE, new ForLoadedType(Float.TYPE));
                    TYPE_CACHE.put(Double.TYPE, new ForLoadedType(Double.TYPE));
                }

                public ForLoadedType(Class<?> type) {
                    this(type, AnnotationReader.NoOp.INSTANCE);
                }

                /* access modifiers changed from: protected */
                public ForLoadedType(Class<?> type, AnnotationReader annotationReader) {
                    this.type = type;
                    this.annotationReader = annotationReader;
                }

                /* renamed from: of */
                public static Generic m244of(Class<?> type) {
                    Generic typeDescription = TYPE_CACHE.get(type);
                    return typeDescription == null ? new ForLoadedType(type) : typeDescription;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of(this.type);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    Class<?> declaringClass = this.type.getDeclaringClass();
                    return declaringClass == null ? Generic.UNDEFINED : new ForLoadedType(declaringClass, this.annotationReader.ofOuterClass());
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    Class<?> componentType = this.type.getComponentType();
                    return componentType == null ? Generic.UNDEFINED : new ForLoadedType(componentType, this.annotationReader.ofComponentType());
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType, net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
                public boolean represents(Type type) {
                    return this.type == type || represents(type);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfNonGenericType$ForErasure.class */
            public static class ForErasure extends OfNonGenericType {
                private final TypeDescription typeDescription;

                public ForErasure(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    return declaringType == null ? Generic.UNDEFINED : declaringType.asGenericType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    return componentType == null ? Generic.UNDEFINED : componentType.asGenericType();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfNonGenericType$Latent.class */
            public static class Latent extends OfNonGenericType {
                private final TypeDescription typeDescription;
                private final Generic declaringType;
                private final AnnotationSource annotationSource;

                public Latent(TypeDescription typeDescription, AnnotationSource annotationSource) {
                    this(typeDescription, typeDescription.getDeclaringType(), annotationSource);
                }

                private Latent(TypeDescription typeDescription, TypeDescription declaringType, AnnotationSource annotationSource) {
                    this(typeDescription, declaringType == null ? Generic.UNDEFINED : declaringType.asGenericType(), annotationSource);
                }

                protected Latent(TypeDescription typeDescription, Generic declaringType, AnnotationSource annotationSource) {
                    this.typeDescription = typeDescription;
                    this.declaringType = declaringType;
                    this.annotationSource = annotationSource;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    return this.declaringType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    return componentType == null ? Generic.UNDEFINED : componentType.asGenericType();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.typeDescription;
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfNonGenericType$ForReifiedErasure.class */
            public static class ForReifiedErasure extends OfNonGenericType {
                private final TypeDescription typeDescription;

                protected ForReifiedErasure(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                /* renamed from: of */
                protected static Generic m243of(TypeDescription typeDescription) {
                    return typeDescription.isGenerified() ? new ForReifiedErasure(typeDescription) : new ForErasure(typeDescription);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType, net.bytebuddy.description.type.TypeDefinition
                public Generic getSuperClass() {
                    Generic superClass = this.typeDescription.getSuperClass();
                    return superClass == null ? Generic.UNDEFINED : new LazyProjection.WithResolvedErasure(superClass, Visitor.Reifying.INHERITING);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType, net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(this.typeDescription.getInterfaces(), Visitor.Reifying.INHERITING);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    return new FieldList.TypeSubstituting(this, this.typeDescription.getDeclaredFields(), Visitor.TypeErasing.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfNonGenericType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    return new MethodList.TypeSubstituting(this, this.typeDescription.getDeclaredMethods(), Visitor.TypeErasing.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    return declaringType == null ? Generic.UNDEFINED : m243of(declaringType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    TypeDescription componentType = this.typeDescription.getComponentType();
                    return componentType == null ? Generic.UNDEFINED : m243of(componentType);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfGenericArray.class */
        public static abstract class OfGenericArray extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDefinition.Sort getSort() {
                return getComponentType().getSort().isNonGeneric() ? TypeDefinition.Sort.NON_GENERIC : TypeDefinition.Sort.GENERIC_ARRAY;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDescription asErasure() {
                return ArrayProjection.m248of(getComponentType().asErasure(), 1);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public Generic getSuperClass() {
                return Generic.OBJECT;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                return TypeDescription.ARRAY_INTERFACES;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return new FieldList.Empty();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return new MethodList.Empty();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return new RecordComponentList.Empty();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A generic array type does not imply upper type bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A generic array type does not imply lower type bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A generic array type does not imply a type variable source: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic findBindingOf(Generic typeVariable) {
                throw new IllegalStateException("A generic array type does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic getOwnerType() {
                return Generic.UNDEFINED;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public String getSymbol() {
                throw new IllegalStateException("A generic array type does not imply a symbol: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public String getTypeName() {
                if (getSort().isNonGeneric()) {
                    return asErasure().getTypeName();
                }
                return toString();
            }

            @Override // net.bytebuddy.description.NamedElement
            public String getActualName() {
                if (getSort().isNonGeneric()) {
                    return asErasure().getActualName();
                }
                return toString();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return true;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return false;
            }

            @Override // java.lang.Iterable
            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public <T> T accept(Visitor<T> visitor) {
                if (getSort().isNonGeneric()) {
                    return visitor.onNonGenericType(this);
                }
                return visitor.onGenericArray(this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            @Override // java.lang.Object
            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i;
                if (this.hashCode != 0) {
                    i = 0;
                } else if (getSort().isNonGeneric()) {
                    i = asErasure().hashCode();
                } else {
                    i = getComponentType().hashCode();
                }
                if (i == 0) {
                    i = this.hashCode;
                } else {
                    this.hashCode = i;
                }
                return i;
            }

            @Override // java.lang.Object
            @SuppressFBWarnings(value = {"EQ_CHECK_FOR_OPERAND_NOT_COMPATIBLE_WITH_THIS"}, justification = "Type check is performed by erasure implementation")
            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (getSort().isNonGeneric()) {
                    return asErasure().equals(other);
                }
                if (!(other instanceof Generic)) {
                    return false;
                }
                Generic typeDescription = (Generic) other;
                return typeDescription.getSort().isGenericArray() && getComponentType().equals(typeDescription.getComponentType());
            }

            @Override // java.lang.Object
            public String toString() {
                if (getSort().isNonGeneric()) {
                    return asErasure().toString();
                }
                return getComponentType().getTypeName() + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfGenericArray$ForLoadedType.class */
            public static class ForLoadedType extends OfGenericArray {
                private final GenericArrayType genericArrayType;
                private final AnnotationReader annotationReader;

                public ForLoadedType(GenericArrayType genericArrayType) {
                    this(genericArrayType, AnnotationReader.NoOp.INSTANCE);
                }

                /* access modifiers changed from: protected */
                public ForLoadedType(GenericArrayType genericArrayType, AnnotationReader annotationReader) {
                    this.genericArrayType = genericArrayType;
                    this.annotationReader = annotationReader;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    return TypeDefinition.Sort.describe(this.genericArrayType.getGenericComponentType(), this.annotationReader.ofComponentType());
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
                public boolean represents(Type type) {
                    return this.genericArrayType == type || represents(type);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfGenericArray$Latent.class */
            public static class Latent extends OfGenericArray {
                private final Generic componentType;
                private final AnnotationSource annotationSource;

                public Latent(Generic componentType, AnnotationSource annotationSource) {
                    this.componentType = componentType;
                    this.annotationSource = annotationSource;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    return this.componentType;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfWildcardType.class */
        public static abstract class OfWildcardType extends AbstractBase {
            public static final String SYMBOL = "?";
            private transient /* synthetic */ int hashCode;

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.WILDCARD;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDescription asErasure() {
                throw new IllegalStateException("A wildcard does not represent an erasable type: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public Generic getSuperClass() {
                throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                throw new IllegalStateException("A wildcard does not imply an interface type definition: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                throw new IllegalStateException("A wildcard does not imply field definitions: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                throw new IllegalStateException("A wildcard does not imply method definitions: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                throw new IllegalStateException("A wildcard does not imply record component definitions: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public Generic getComponentType() {
                throw new IllegalStateException("A wildcard does not imply a component type: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A wildcard does not imply a type variable source: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic findBindingOf(Generic typeVariable) {
                throw new IllegalStateException("A wildcard does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic getOwnerType() {
                throw new IllegalStateException("A wildcard does not imply an owner type: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public String getSymbol() {
                throw new IllegalStateException("A wildcard does not imply a symbol: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public String getTypeName() {
                return toString();
            }

            @Override // net.bytebuddy.description.NamedElement
            public String getActualName() {
                return toString();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            @Override // java.lang.Iterable
            public Iterator<TypeDefinition> iterator() {
                throw new IllegalStateException("A wildcard does not imply a super type definition: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onWildcard(this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                throw new IllegalStateException("A wildcard does not imply an operand stack size: " + this);
            }

            @Override // java.lang.Object
            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i;
                if (this.hashCode != 0) {
                    i = 0;
                } else {
                    int lowerHash = 1;
                    int upperHash = 1;
                    for (Generic lowerBound : getLowerBounds()) {
                        lowerHash = (31 * lowerHash) + lowerBound.hashCode();
                    }
                    for (Generic upperBound : getUpperBounds()) {
                        upperHash = (31 * upperHash) + upperBound.hashCode();
                    }
                    i = lowerHash ^ upperHash;
                }
                if (i == 0) {
                    i = this.hashCode;
                } else {
                    this.hashCode = i;
                }
                return i;
            }

            @Override // java.lang.Object
            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Generic)) {
                    return false;
                }
                Generic typeDescription = (Generic) other;
                return typeDescription.getSort().isWildcard() && getUpperBounds().equals(typeDescription.getUpperBounds()) && getLowerBounds().equals(typeDescription.getLowerBounds());
            }

            @Override // java.lang.Object
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder("?");
                TypeList.Generic bounds = getLowerBounds();
                if (!bounds.isEmpty()) {
                    stringBuilder.append(" super ");
                } else {
                    bounds = getUpperBounds();
                    if (bounds.getOnly().equals(Generic.OBJECT)) {
                        return "?";
                    }
                    stringBuilder.append(" extends ");
                }
                return stringBuilder.append(bounds.getOnly().getTypeName()).toString();
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfWildcardType$ForLoadedType.class */
            public static class ForLoadedType extends OfWildcardType {
                private final WildcardType wildcardType;
                private final AnnotationReader annotationReader;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfWildcardType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                public ForLoadedType(WildcardType wildcardType) {
                    this(wildcardType, AnnotationReader.NoOp.INSTANCE);
                }

                /* access modifiers changed from: protected */
                public ForLoadedType(WildcardType wildcardType, AnnotationReader annotationReader) {
                    this.wildcardType = wildcardType;
                    this.annotationReader = annotationReader;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getUpperBounds() {
                    return new WildcardUpperBoundTypeList(this.wildcardType.getUpperBounds(), this.annotationReader);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getLowerBounds() {
                    return new WildcardLowerBoundTypeList(this.wildcardType.getLowerBounds(), this.annotationReader);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfWildcardType, net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
                public boolean represents(Type type) {
                    return this.wildcardType == type || represents(type);
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfWildcardType$ForLoadedType$WildcardUpperBoundTypeList.class */
                protected static class WildcardUpperBoundTypeList extends TypeList.Generic.AbstractBase {
                    private final Type[] upperBound;
                    private final AnnotationReader annotationReader;

                    protected WildcardUpperBoundTypeList(Type[] upperBound, AnnotationReader annotationReader) {
                        this.upperBound = upperBound;
                        this.annotationReader = annotationReader;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public Generic get(int index) {
                        return TypeDefinition.Sort.describe(this.upperBound[index], this.annotationReader.ofWildcardUpperBoundType(index));
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.upperBound.length;
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfWildcardType$ForLoadedType$WildcardLowerBoundTypeList.class */
                protected static class WildcardLowerBoundTypeList extends TypeList.Generic.AbstractBase {
                    private final Type[] lowerBound;
                    private final AnnotationReader annotationReader;

                    protected WildcardLowerBoundTypeList(Type[] lowerBound, AnnotationReader annotationReader) {
                        this.lowerBound = lowerBound;
                        this.annotationReader = annotationReader;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public Generic get(int index) {
                        return TypeDefinition.Sort.describe(this.lowerBound[index], this.annotationReader.ofWildcardLowerBoundType(index));
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.lowerBound.length;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfWildcardType$Latent.class */
            public static class Latent extends OfWildcardType {
                private final List<? extends Generic> upperBounds;
                private final List<? extends Generic> lowerBounds;
                private final AnnotationSource annotationSource;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfWildcardType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                protected Latent(List<? extends Generic> upperBounds, List<? extends Generic> lowerBounds, AnnotationSource annotationSource) {
                    this.upperBounds = upperBounds;
                    this.lowerBounds = lowerBounds;
                    this.annotationSource = annotationSource;
                }

                public static Generic unbounded(AnnotationSource annotationSource) {
                    return new Latent(Collections.singletonList(Generic.OBJECT), Collections.emptyList(), annotationSource);
                }

                public static Generic boundedAbove(Generic upperBound, AnnotationSource annotationSource) {
                    return new Latent(Collections.singletonList(upperBound), Collections.emptyList(), annotationSource);
                }

                public static Generic boundedBelow(Generic lowerBound, AnnotationSource annotationSource) {
                    return new Latent(Collections.singletonList(Generic.OBJECT), Collections.singletonList(lowerBound), annotationSource);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getUpperBounds() {
                    return new TypeList.Generic.Explicit(this.upperBounds);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getLowerBounds() {
                    return new TypeList.Generic.Explicit(this.lowerBounds);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType.class */
        public static abstract class OfParameterizedType extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.PARAMETERIZED;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public Generic getSuperClass() {
                Generic superClass = asErasure().getSuperClass();
                return superClass == null ? Generic.UNDEFINED : new LazyProjection.WithResolvedErasure(superClass, new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(asErasure().getInterfaces(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return new FieldList.TypeSubstituting(this, asErasure().getDeclaredFields(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return new MethodList.TypeSubstituting(this, asErasure().getDeclaredMethods(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return new RecordComponentList.TypeSubstituting(this, asErasure().getRecordComponents(), new Visitor.Substitutor.ForTypeVariableBinding(this));
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic findBindingOf(Generic typeVariable) {
                Generic typeDescription = this;
                do {
                    TypeList.Generic typeArguments = typeDescription.getTypeArguments();
                    TypeList.Generic typeVariables = typeDescription.asErasure().getTypeVariables();
                    for (int index = 0; index < Math.min(typeArguments.size(), typeVariables.size()); index++) {
                        if (typeVariable.equals(typeVariables.get(index))) {
                            return (Generic) typeArguments.get(index);
                        }
                    }
                    typeDescription = typeDescription.getOwnerType();
                    if (typeDescription == null) {
                        break;
                    }
                } while (typeDescription.getSort().isParameterized());
                return Generic.UNDEFINED;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getUpperBounds() {
                throw new IllegalStateException("A parameterized type does not imply upper bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A parameterized type does not imply lower bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public Generic getComponentType() {
                throw new IllegalStateException("A parameterized type does not imply a component type: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeVariableSource getTypeVariableSource() {
                throw new IllegalStateException("A parameterized type does not imply a type variable source: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public String getSymbol() {
                throw new IllegalStateException("A parameterized type does not imply a symbol: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public String getTypeName() {
                return toString();
            }

            @Override // net.bytebuddy.description.NamedElement
            public String getActualName() {
                return toString();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return asErasure().isRecord();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            @Override // java.lang.Iterable
            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onParameterizedType(this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            @Override // java.lang.Object
            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int i;
                int i2;
                if (this.hashCode != 0) {
                    i = 0;
                } else {
                    int result = 1;
                    for (Generic typeArgument : getTypeArguments()) {
                        result = (31 * result) + typeArgument.hashCode();
                    }
                    Generic ownerType = getOwnerType();
                    if (ownerType == null) {
                        i2 = asErasure().hashCode();
                    } else {
                        i2 = ownerType.hashCode();
                    }
                    i = result ^ i2;
                }
                if (i == 0) {
                    i = this.hashCode;
                } else {
                    this.hashCode = i;
                }
                return i;
            }

            @Override // java.lang.Object
            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Generic)) {
                    return false;
                }
                Generic typeDescription = (Generic) other;
                if (!typeDescription.getSort().isParameterized()) {
                    return false;
                }
                Generic ownerType = getOwnerType();
                Generic otherOwnerType = typeDescription.getOwnerType();
                return asErasure().equals(typeDescription.asErasure()) && (ownerType != null || otherOwnerType == null) && ((ownerType == null || ownerType.equals(otherOwnerType)) && getTypeArguments().equals(typeDescription.getTypeArguments()));
            }

            @Override // java.lang.Object
            public String toString() {
                StringBuilder stringBuilder = new StringBuilder();
                RenderingDelegate.CURRENT.apply(stringBuilder, asErasure(), getOwnerType());
                TypeList.Generic<Generic> typeArguments = getTypeArguments();
                if (!typeArguments.isEmpty()) {
                    stringBuilder.append('<');
                    boolean multiple = false;
                    for (Generic typeArgument : typeArguments) {
                        if (multiple) {
                            stringBuilder.append(", ");
                        }
                        stringBuilder.append(typeArgument.getTypeName());
                        multiple = true;
                    }
                    stringBuilder.append('>');
                }
                return stringBuilder.toString();
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType$RenderingDelegate.class */
            public enum RenderingDelegate {
                FOR_LEGACY_VM {
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType.RenderingDelegate
                    protected void apply(StringBuilder stringBuilder, TypeDescription erasure, Generic ownerType) {
                        String str;
                        if (ownerType != null) {
                            StringBuilder append = stringBuilder.append(ownerType.getTypeName()).append('.');
                            if (ownerType.getSort().isParameterized()) {
                                str = erasure.getSimpleName();
                            } else {
                                str = erasure.getName();
                            }
                            append.append(str);
                            return;
                        }
                        stringBuilder.append(erasure.getName());
                    }
                },
                FOR_JAVA_8_CAPABLE_VM {
                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType.RenderingDelegate
                    protected void apply(StringBuilder stringBuilder, TypeDescription erasure, Generic ownerType) {
                        if (ownerType != null) {
                            stringBuilder.append(ownerType.getTypeName()).append('$');
                            if (ownerType.getSort().isParameterized()) {
                                stringBuilder.append(erasure.getName().replace(ownerType.asErasure().getName() + "$", ""));
                            } else {
                                stringBuilder.append(erasure.getSimpleName());
                            }
                        } else {
                            stringBuilder.append(erasure.getName());
                        }
                    }
                };
                
                protected static final RenderingDelegate CURRENT;

                protected abstract void apply(StringBuilder sb, TypeDescription typeDescription, Generic generic);

                static {
                    CURRENT = ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V8) ? FOR_JAVA_8_CAPABLE_VM : FOR_LEGACY_VM;
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType$ForLoadedType.class */
            public static class ForLoadedType extends OfParameterizedType {
                private final ParameterizedType parameterizedType;
                private final AnnotationReader annotationReader;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                public ForLoadedType(ParameterizedType parameterizedType) {
                    this(parameterizedType, AnnotationReader.NoOp.INSTANCE);
                }

                /* access modifiers changed from: protected */
                public ForLoadedType(ParameterizedType parameterizedType, AnnotationReader annotationReader) {
                    this.parameterizedType = parameterizedType;
                    this.annotationReader = annotationReader;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getTypeArguments() {
                    return new ParameterArgumentTypeList(this.parameterizedType.getActualTypeArguments(), this.annotationReader);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    Type ownerType = this.parameterizedType.getOwnerType();
                    return ownerType == null ? Generic.UNDEFINED : TypeDefinition.Sort.describe(ownerType, this.annotationReader.ofOwnerType());
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of((Class) this.parameterizedType.getRawType());
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
                public boolean represents(Type type) {
                    return this.parameterizedType == type || represents(type);
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType$ForLoadedType$ParameterArgumentTypeList.class */
                protected static class ParameterArgumentTypeList extends TypeList.Generic.AbstractBase {
                    private final Type[] argumentType;
                    private final AnnotationReader annotationReader;

                    protected ParameterArgumentTypeList(Type[] argumentType, AnnotationReader annotationReader) {
                        this.argumentType = argumentType;
                        this.annotationReader = annotationReader;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public Generic get(int index) {
                        return TypeDefinition.Sort.describe(this.argumentType[index], this.annotationReader.ofTypeArgument(index));
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.argumentType.length;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType$Latent.class */
            public static class Latent extends OfParameterizedType {
                private final TypeDescription rawType;
                private final Generic ownerType;
                private final List<? extends Generic> parameters;
                private final AnnotationSource annotationSource;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                public Latent(TypeDescription rawType, Generic ownerType, List<? extends Generic> parameters, AnnotationSource annotationSource) {
                    this.rawType = rawType;
                    this.ownerType = ownerType;
                    this.parameters = parameters;
                    this.annotationSource = annotationSource;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.rawType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    return this.ownerType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.Explicit(this.parameters);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType$ForReifiedType.class */
            public static class ForReifiedType extends OfParameterizedType {
                private final Generic parameterizedType;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                protected ForReifiedType(Generic parameterizedType) {
                    this.parameterizedType = parameterizedType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDefinition
                public Generic getSuperClass() {
                    Generic superClass = getSuperClass();
                    return superClass == null ? Generic.UNDEFINED : new LazyProjection.WithResolvedErasure(superClass, Visitor.Reifying.INHERITING);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    return new TypeList.Generic.ForDetachedTypes.WithResolvedErasure(getInterfaces(), Visitor.Reifying.INHERITING);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    return new FieldList.TypeSubstituting(this, getDeclaredFields(), Visitor.TypeErasing.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    return new MethodList.TypeSubstituting(this, getDeclaredMethods(), Visitor.TypeErasing.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.ForDetachedTypes(this.parameterizedType.getTypeArguments(), Visitor.TypeErasing.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    Generic ownerType = this.parameterizedType.getOwnerType();
                    return ownerType == null ? Generic.UNDEFINED : (Generic) ownerType.accept(Visitor.Reifying.INHERITING);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.parameterizedType.asErasure();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfParameterizedType$ForGenerifiedErasure.class */
            public static class ForGenerifiedErasure extends OfParameterizedType {
                private final TypeDescription typeDescription;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfParameterizedType, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                protected ForGenerifiedErasure(TypeDescription typeDescription) {
                    this.typeDescription = typeDescription;
                }

                /* renamed from: of */
                public static Generic m242of(TypeDescription typeDescription) {
                    return typeDescription.isGenerified() ? new ForGenerifiedErasure(typeDescription) : new OfNonGenericType.ForErasure(typeDescription);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.typeDescription;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getTypeArguments() {
                    return new TypeList.Generic.ForDetachedTypes(this.typeDescription.getTypeVariables(), Visitor.AnnotationStripper.INSTANCE);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    TypeDescription declaringType = this.typeDescription.getDeclaringType();
                    return declaringType == null ? Generic.UNDEFINED : m242of(declaringType);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return new AnnotationList.Empty();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfTypeVariable.class */
        public static abstract class OfTypeVariable extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDefinition.Sort getSort() {
                return TypeDefinition.Sort.VARIABLE;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDescription asErasure() {
                TypeList.Generic upperBounds = getUpperBounds();
                return upperBounds.isEmpty() ? TypeDescription.OBJECT : ((Generic) upperBounds.get(0)).asErasure();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public Generic getSuperClass() {
                throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                throw new IllegalStateException("A type variable does not imply an interface type definition: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                throw new IllegalStateException("A type variable does not imply field definitions: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                throw new IllegalStateException("A type variable does not imply method definitions: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                throw new IllegalStateException("A type variable does not imply record component definitions: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public Generic getComponentType() {
                throw new IllegalStateException("A type variable does not imply a component type: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getTypeArguments() {
                throw new IllegalStateException("A type variable does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic findBindingOf(Generic typeVariable) {
                throw new IllegalStateException("A type variable does not imply type arguments: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getLowerBounds() {
                throw new IllegalStateException("A type variable does not imply lower bounds: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic getOwnerType() {
                throw new IllegalStateException("A type variable does not imply an owner type: " + this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public String getTypeName() {
                return toString();
            }

            @Override // net.bytebuddy.description.NamedElement
            public String getActualName() {
                return getSymbol();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public <T> T accept(Visitor<T> visitor) {
                return visitor.onTypeVariable(this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
            public boolean represents(Type type) {
                return equals(TypeDefinition.Sort.describe(type));
            }

            @Override // java.lang.Iterable
            public Iterator<TypeDefinition> iterator() {
                throw new IllegalStateException("A type variable does not imply a super type definition: " + this);
            }

            @Override // java.lang.Object
            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode = this.hashCode != 0 ? 0 : getTypeVariableSource().hashCode() ^ getSymbol().hashCode();
                if (hashCode == 0) {
                    hashCode = this.hashCode;
                } else {
                    this.hashCode = hashCode;
                }
                return hashCode;
            }

            @Override // java.lang.Object
            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Generic)) {
                    return false;
                }
                Generic typeDescription = (Generic) other;
                return typeDescription.getSort().isTypeVariable() && getSymbol().equals(typeDescription.getSymbol()) && getTypeVariableSource().equals(typeDescription.getTypeVariableSource());
            }

            @Override // java.lang.Object
            public String toString() {
                return getSymbol();
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfTypeVariable$Symbolic.class */
            public static class Symbolic extends AbstractBase {
                private final String symbol;
                private final AnnotationSource annotationSource;

                public Symbolic(String symbol, AnnotationSource annotationSource) {
                    this.symbol = symbol;
                    this.annotationSource = annotationSource;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDefinition.Sort getSort() {
                    return TypeDefinition.Sort.VARIABLE_SYMBOLIC;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public String getSymbol() {
                    return this.symbol;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    throw new IllegalStateException("A symbolic type variable does not imply an erasure: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getUpperBounds() {
                    throw new IllegalStateException("A symbolic type variable does not imply an upper type bound: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeVariableSource getTypeVariableSource() {
                    throw new IllegalStateException("A symbolic type variable does not imply a variable source: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public Generic getSuperClass() {
                    throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    throw new IllegalStateException("A symbolic type variable does not imply an interface type definition: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                    throw new IllegalStateException("A symbolic type variable does not imply field definitions: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                    throw new IllegalStateException("A symbolic type variable does not imply method definitions: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                    throw new IllegalStateException("A symbolic type variable does not imply record component definitions: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public Generic getComponentType() {
                    throw new IllegalStateException("A symbolic type variable does not imply a component type: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getTypeArguments() {
                    throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic findBindingOf(Generic typeVariable) {
                    throw new IllegalStateException("A symbolic type variable does not imply type arguments: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getLowerBounds() {
                    throw new IllegalStateException("A symbolic type variable does not imply lower bounds: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public Generic getOwnerType() {
                    throw new IllegalStateException("A symbolic type variable does not imply an owner type: " + this);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public String getTypeName() {
                    return toString();
                }

                @Override // net.bytebuddy.description.NamedElement
                public String getActualName() {
                    return getSymbol();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public <T> T accept(Visitor<T> visitor) {
                    return visitor.onTypeVariable(this);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public StackSize getStackSize() {
                    return StackSize.SINGLE;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public boolean isArray() {
                    return false;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public boolean isPrimitive() {
                    return false;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public boolean isRecord() {
                    return false;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
                public boolean represents(Type type) {
                    if (type != null) {
                        return false;
                    }
                    throw new NullPointerException();
                }

                @Override // java.lang.Iterable
                public Iterator<TypeDefinition> iterator() {
                    throw new IllegalStateException("A symbolic type variable does not imply a super type definition: " + this);
                }

                @Override // java.lang.Object
                public int hashCode() {
                    return this.symbol.hashCode();
                }

                @Override // java.lang.Object
                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Generic)) {
                        return false;
                    }
                    Generic typeDescription = (Generic) other;
                    return typeDescription.getSort().isTypeVariable() && getSymbol().equals(typeDescription.getSymbol());
                }

                @Override // java.lang.Object
                public String toString() {
                    return getSymbol();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfTypeVariable$ForLoadedType.class */
            public static class ForLoadedType extends OfTypeVariable {
                private final TypeVariable<?> typeVariable;
                private final AnnotationReader annotationReader;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                public ForLoadedType(TypeVariable<?> typeVariable) {
                    this(typeVariable, AnnotationReader.NoOp.INSTANCE);
                }

                /* access modifiers changed from: protected */
                public ForLoadedType(TypeVariable<?> typeVariable, AnnotationReader annotationReader) {
                    this.typeVariable = typeVariable;
                    this.annotationReader = annotationReader;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeVariableSource getTypeVariableSource() {
                    GenericDeclaration genericDeclaration = this.typeVariable.getGenericDeclaration();
                    if (genericDeclaration instanceof Class) {
                        return ForLoadedType.m247of((Class) genericDeclaration);
                    }
                    if (genericDeclaration instanceof Method) {
                        return new MethodDescription.ForLoadedMethod((Method) genericDeclaration);
                    }
                    if (genericDeclaration instanceof Constructor) {
                        return new MethodDescription.ForLoadedConstructor((Constructor) genericDeclaration);
                    }
                    throw new IllegalStateException("Unknown declaration: " + genericDeclaration);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getUpperBounds() {
                    return new TypeVariableBoundList(this.typeVariable.getBounds(), this.annotationReader);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public String getSymbol() {
                    return this.typeVariable.getName();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationReader.asList();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable, net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
                public boolean represents(Type type) {
                    return this.typeVariable == type || represents(type);
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfTypeVariable$ForLoadedType$TypeVariableBoundList.class */
                protected static class TypeVariableBoundList extends TypeList.Generic.AbstractBase {
                    private final Type[] bound;
                    private final AnnotationReader annotationReader;

                    protected TypeVariableBoundList(Type[] bound, AnnotationReader annotationReader) {
                        this.bound = bound;
                        this.annotationReader = annotationReader;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public Generic get(int index) {
                        return TypeDefinition.Sort.describe(this.bound[index], this.annotationReader.ofTypeVariableBoundType(index));
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.bound.length;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$OfTypeVariable$WithAnnotationOverlay.class */
            public static class WithAnnotationOverlay extends OfTypeVariable {
                private final Generic typeVariable;
                private final AnnotationSource annotationSource;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.OfTypeVariable, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                public WithAnnotationOverlay(Generic typeVariable, AnnotationSource annotationSource) {
                    this.typeVariable = typeVariable;
                    this.annotationSource = annotationSource;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeList.Generic getUpperBounds() {
                    return this.typeVariable.getUpperBounds();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public TypeVariableSource getTypeVariableSource() {
                    return this.typeVariable.getTypeVariableSource();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic
                public String getSymbol() {
                    return this.typeVariable.getSymbol();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection.class */
        public static abstract class LazyProjection extends AbstractBase {
            private transient /* synthetic */ int hashCode;

            protected abstract Generic resolve();

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDefinition.Sort getSort() {
                return resolve().getSort();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InGenericShape> getDeclaredFields() {
                return resolve().getDeclaredFields();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InGenericShape> getDeclaredMethods() {
                return resolve().getDeclaredMethods();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InGenericShape> getRecordComponents() {
                return resolve().getRecordComponents();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getUpperBounds() {
                return resolve().getUpperBounds();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getLowerBounds() {
                return resolve().getLowerBounds();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
            public Generic getComponentType() {
                return resolve().getComponentType();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeList.Generic getTypeArguments() {
                return resolve().getTypeArguments();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic findBindingOf(Generic typeVariable) {
                return resolve().findBindingOf(typeVariable);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public TypeVariableSource getTypeVariableSource() {
                return resolve().getTypeVariableSource();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public Generic getOwnerType() {
                return resolve().getOwnerType();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public String getTypeName() {
                return resolve().getTypeName();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public String getSymbol() {
                return resolve().getSymbol();
            }

            @Override // net.bytebuddy.description.NamedElement
            public String getActualName() {
                return resolve().getActualName();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic
            public <T> T accept(Visitor<T> visitor) {
                return (T) resolve().accept(visitor);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                return asErasure().getStackSize();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return asErasure().isArray();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return asErasure().isPrimitive();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return asErasure().isRecord();
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic.AbstractBase, net.bytebuddy.description.type.TypeDefinition
            public boolean represents(Type type) {
                return resolve().represents(type);
            }

            @Override // java.lang.Object
            @CachedReturnPlugin.Enhance("hashCode")
            public int hashCode() {
                int hashCode = this.hashCode != 0 ? 0 : resolve().hashCode();
                if (hashCode == 0) {
                    hashCode = this.hashCode;
                } else {
                    this.hashCode = hashCode;
                }
                return hashCode;
            }

            @Override // java.lang.Object
            public boolean equals(Object other) {
                return this == other || ((other instanceof TypeDefinition) && resolve().equals(other));
            }

            @Override // java.lang.Object
            public String toString() {
                return resolve().toString();
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithLazyNavigation.class */
            public static abstract class WithLazyNavigation extends LazyProjection {
                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public Generic getSuperClass() {
                    return LazySuperClass.m245of(this);
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    return LazyInterfaceList.m246of((LazyProjection) this);
                }

                @Override // java.lang.Iterable
                public Iterator<TypeDefinition> iterator() {
                    return new TypeDefinition.SuperClassIterator(this);
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithLazyNavigation$LazySuperClass.class */
                protected static class LazySuperClass extends WithLazyNavigation {
                    private final LazyProjection delegate;
                    private transient /* synthetic */ Generic resolved;

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithLazyNavigation, net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return getComponentType();
                    }

                    protected LazySuperClass(LazyProjection delegate) {
                        this.delegate = delegate;
                    }

                    /* renamed from: of */
                    protected static Generic m245of(LazyProjection delegate) {
                        return delegate.asErasure().getSuperClass() == null ? Generic.UNDEFINED : new LazySuperClass(delegate);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return resolve().getDeclaredAnnotations();
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return this.delegate.asErasure().getSuperClass().asErasure();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                    @CachedReturnPlugin.Enhance("resolved")
                    protected Generic resolve() {
                        Generic superClass = this.resolved != null ? null : this.delegate.resolve().getSuperClass();
                        if (superClass == null) {
                            superClass = this.resolved;
                        } else {
                            this.resolved = superClass;
                        }
                        return superClass;
                    }
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithLazyNavigation$LazyInterfaceType.class */
                public static class LazyInterfaceType extends WithLazyNavigation {
                    private final LazyProjection delegate;
                    private final int index;
                    private final Generic rawInterface;
                    private transient /* synthetic */ Generic resolved;

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithLazyNavigation, net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return getComponentType();
                    }

                    protected LazyInterfaceType(LazyProjection delegate, int index, Generic rawInterface) {
                        this.delegate = delegate;
                        this.index = index;
                        this.rawInterface = rawInterface;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return resolve().getDeclaredAnnotations();
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return this.rawInterface.asErasure();
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                    @CachedReturnPlugin.Enhance("resolved")
                    protected Generic resolve() {
                        Generic generic = this.resolved != null ? null : (Generic) this.delegate.resolve().getInterfaces().get(this.index);
                        if (generic == null) {
                            generic = this.resolved;
                        } else {
                            this.resolved = generic;
                        }
                        return generic;
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithLazyNavigation$LazyInterfaceList.class */
                protected static class LazyInterfaceList extends TypeList.Generic.AbstractBase {
                    private final LazyProjection delegate;
                    private final TypeList.Generic rawInterfaces;

                    protected LazyInterfaceList(LazyProjection delegate, TypeList.Generic rawInterfaces) {
                        this.delegate = delegate;
                        this.rawInterfaces = rawInterfaces;
                    }

                    /* renamed from: of */
                    protected static TypeList.Generic m246of(LazyProjection delegate) {
                        return new LazyInterfaceList(delegate, delegate.asErasure().getInterfaces());
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public Generic get(int index) {
                        return new LazyInterfaceType(this.delegate, index, (Generic) this.rawInterfaces.get(index));
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.rawInterfaces.size();
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithLazyNavigation$OfAnnotatedElement.class */
                protected static abstract class OfAnnotatedElement extends WithLazyNavigation {
                    protected abstract AnnotationReader getAnnotationReader();

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithLazyNavigation, net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return getComponentType();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return getAnnotationReader().asList();
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithEagerNavigation.class */
            public static abstract class WithEagerNavigation extends LazyProjection {
                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public Generic getSuperClass() {
                    return resolve().getSuperClass();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    return resolve().getInterfaces();
                }

                @Override // java.lang.Iterable
                public Iterator<TypeDefinition> iterator() {
                    return resolve().iterator();
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithEagerNavigation$OfAnnotatedElement.class */
                protected static abstract class OfAnnotatedElement extends WithEagerNavigation {
                    protected abstract AnnotationReader getAnnotationReader();

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation, net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection, net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                    public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                        return getComponentType();
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return getAnnotationReader().asList();
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$ForLoadedSuperClass.class */
            public static class ForLoadedSuperClass extends WithLazyNavigation.OfAnnotatedElement {
                private final Class<?> type;
                private transient /* synthetic */ Generic resolved;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithLazyNavigation.OfAnnotatedElement, net.bytebuddy.description.annotation.AnnotationSource
                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return getDeclaredAnnotations();
                }

                public ForLoadedSuperClass(Class<?> type) {
                    this.type = type;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected Generic resolve() {
                    Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        Type superClass = this.type.getGenericSuperclass();
                        generic = superClass == null ? Generic.UNDEFINED : TypeDefinition.Sort.describe(superClass, getAnnotationReader());
                    }
                    if (generic == null) {
                        generic = this.resolved;
                    } else {
                        this.resolved = generic;
                    }
                    return generic;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    Class<?> superClass = this.type.getSuperclass();
                    return superClass == null ? TypeDescription.UNDEFINED : ForLoadedType.m247of(superClass);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithLazyNavigation.OfAnnotatedElement
                protected AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedSuperClass(this.type);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$ForLoadedFieldType.class */
            public static class ForLoadedFieldType extends WithEagerNavigation.OfAnnotatedElement {
                private final Field field;
                private transient /* synthetic */ Generic resolved;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement, net.bytebuddy.description.annotation.AnnotationSource
                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return getDeclaredAnnotations();
                }

                public ForLoadedFieldType(Field field) {
                    this.field = field;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(this.field.getGenericType(), getAnnotationReader());
                    if (describe == null) {
                        describe = this.resolved;
                    } else {
                        this.resolved = describe;
                    }
                    return describe;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of(this.field.getType());
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
                protected AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedField(this.field);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$ForLoadedReturnType.class */
            public static class ForLoadedReturnType extends WithEagerNavigation.OfAnnotatedElement {
                private final Method method;
                private transient /* synthetic */ Generic resolved;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement, net.bytebuddy.description.annotation.AnnotationSource
                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return getDeclaredAnnotations();
                }

                public ForLoadedReturnType(Method method) {
                    this.method = method;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(this.method.getGenericReturnType(), getAnnotationReader());
                    if (describe == null) {
                        describe = this.resolved;
                    } else {
                        this.resolved = describe;
                    }
                    return describe;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of(this.method.getReturnType());
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
                protected AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedMethodReturnType(this.method);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$OfConstructorParameter.class */
            public static class OfConstructorParameter extends WithEagerNavigation.OfAnnotatedElement {
                private final Constructor<?> constructor;
                private final int index;
                private final Class<?>[] erasure;
                private transient /* synthetic */ Generic delegate;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement, net.bytebuddy.description.annotation.AnnotationSource
                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return getDeclaredAnnotations();
                }

                @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is never exposed outside of the class")
                public OfConstructorParameter(Constructor<?> constructor, int index, Class<?>[] erasure) {
                    this.constructor = constructor;
                    this.index = index;
                    this.erasure = erasure;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
                protected Generic resolve() {
                    Generic generic;
                    if (this.delegate != null) {
                        generic = null;
                    } else {
                        Type[] type = this.constructor.getGenericParameterTypes();
                        if (this.erasure.length == type.length) {
                            generic = TypeDefinition.Sort.describe(type[this.index], getAnnotationReader());
                        } else {
                            generic = OfNonGenericType.ForLoadedType.m244of(this.erasure[this.index]);
                        }
                    }
                    if (generic == null) {
                        generic = this.delegate;
                    } else {
                        this.delegate = generic;
                    }
                    return generic;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of(this.erasure[this.index]);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
                protected AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.constructor, this.index);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$OfMethodParameter.class */
            public static class OfMethodParameter extends WithEagerNavigation.OfAnnotatedElement {
                private final Method method;
                private final int index;
                private final Class<?>[] erasure;
                private transient /* synthetic */ Generic resolved;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement, net.bytebuddy.description.annotation.AnnotationSource
                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return getDeclaredAnnotations();
                }

                @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is never exposed outside of the class")
                public OfMethodParameter(Method method, int index, Class<?>[] erasure) {
                    this.method = method;
                    this.index = index;
                    this.erasure = erasure;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected Generic resolve() {
                    Generic generic;
                    if (this.resolved != null) {
                        generic = null;
                    } else {
                        Type[] type = this.method.getGenericParameterTypes();
                        if (this.erasure.length == type.length) {
                            generic = TypeDefinition.Sort.describe(type[this.index], getAnnotationReader());
                        } else {
                            generic = OfNonGenericType.ForLoadedType.m244of(this.erasure[this.index]);
                        }
                    }
                    if (generic == null) {
                        generic = this.resolved;
                    } else {
                        this.resolved = generic;
                    }
                    return generic;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of(this.erasure[this.index]);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
                protected AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedExecutableParameterType(this.method, this.index);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$OfRecordComponent.class */
            public static class OfRecordComponent extends WithEagerNavigation.OfAnnotatedElement {
                private final Object recordComponent;
                private transient /* synthetic */ Generic resolved;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement, net.bytebuddy.description.annotation.AnnotationSource
                public /* bridge */ /* synthetic */ AnnotationList getDeclaredAnnotations() {
                    return getDeclaredAnnotations();
                }

                /* access modifiers changed from: protected */
                public OfRecordComponent(Object recordComponent) {
                    this.recordComponent = recordComponent;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected Generic resolve() {
                    Generic describe = this.resolved != null ? null : TypeDefinition.Sort.describe(RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getGenericType(this.recordComponent), getAnnotationReader());
                    if (describe == null) {
                        describe = this.resolved;
                    } else {
                        this.resolved = describe;
                    }
                    return describe;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return ForLoadedType.m247of(RecordComponentDescription.ForLoadedRecordComponent.RECORD_COMPONENT.getType(this.recordComponent));
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection.WithEagerNavigation.OfAnnotatedElement
                protected AnnotationReader getAnnotationReader() {
                    return new AnnotationReader.Delegator.ForLoadedRecordComponent(this.recordComponent);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$LazyProjection$WithResolvedErasure.class */
            public static class WithResolvedErasure extends WithEagerNavigation {
                private final Generic delegate;
                private final Visitor<? extends Generic> visitor;
                private final AnnotationSource annotationSource;
                private transient /* synthetic */ Generic resolved;

                public WithResolvedErasure(Generic delegate, Visitor<? extends Generic> visitor) {
                    this(delegate, visitor, delegate);
                }

                public WithResolvedErasure(Generic delegate, Visitor<? extends Generic> visitor, AnnotationSource annotationSource) {
                    this.delegate = delegate;
                    this.visitor = visitor;
                    this.annotationSource = annotationSource;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return this.annotationSource.getDeclaredAnnotations();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeDescription asErasure() {
                    return this.delegate.asErasure();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected Generic resolve() {
                    Generic generic = this.resolved != null ? null : (Generic) this.delegate.accept(this.visitor);
                    if (generic == null) {
                        generic = this.resolved;
                    } else {
                        this.resolved = generic;
                    }
                    return generic;
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Builder.class */
        public static abstract class Builder {
            private static final Type UNDEFINED = null;
            protected final List<? extends AnnotationDescription> annotations;

            protected abstract Builder doAnnotate(List<? extends AnnotationDescription> list);

            protected abstract Generic doBuild();

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.annotations.equals(((Builder) obj).annotations);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.annotations.hashCode();
            }

            protected Builder(List<? extends AnnotationDescription> annotations) {
                this.annotations = annotations;
            }

            public static Builder rawType(Class<?> type) {
                return rawType(ForLoadedType.m247of(type));
            }

            public static Builder rawType(TypeDescription type) {
                return new OfNonGenericType(type);
            }

            public static Builder rawType(Class<?> type, Generic ownerType) {
                return rawType(ForLoadedType.m247of(type), ownerType);
            }

            public static Builder rawType(TypeDescription type, Generic ownerType) {
                TypeDescription declaringType = type.getDeclaringType();
                if (declaringType == null && ownerType != null) {
                    throw new IllegalArgumentException(type + " does not have a declaring type: " + ownerType);
                } else if (declaringType == null || (ownerType != null && declaringType.equals(ownerType.asErasure()))) {
                    return new OfNonGenericType(type, ownerType);
                } else {
                    throw new IllegalArgumentException(ownerType + " is not the declaring type of " + type);
                }
            }

            public static Generic unboundWildcard() {
                return unboundWildcard(Collections.emptySet());
            }

            public static Generic unboundWildcard(Annotation... annotation) {
                return unboundWildcard((List<? extends Annotation>) Arrays.asList(annotation));
            }

            public static Generic unboundWildcard(List<? extends Annotation> annotations) {
                return unboundWildcard((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(annotations));
            }

            public static Generic unboundWildcard(AnnotationDescription... annotation) {
                return unboundWildcard((Collection<? extends AnnotationDescription>) Arrays.asList(annotation));
            }

            public static Generic unboundWildcard(Collection<? extends AnnotationDescription> annotations) {
                return OfWildcardType.Latent.unbounded(new AnnotationSource.Explicit(new ArrayList(annotations)));
            }

            public static Builder typeVariable(String symbol) {
                return new OfTypeVariable(symbol);
            }

            public static Builder parameterizedType(Class<?> rawType, Type... parameter) {
                return parameterizedType(rawType, Arrays.asList(parameter));
            }

            public static Builder parameterizedType(Class<?> rawType, List<? extends Type> parameters) {
                return parameterizedType(rawType, UNDEFINED, parameters);
            }

            public static Builder parameterizedType(Class<?> rawType, Type ownerType, List<? extends Type> parameters) {
                return parameterizedType(ForLoadedType.m247of(rawType), ownerType == null ? null : TypeDefinition.Sort.describe(ownerType), new TypeList.Generic.ForLoadedTypes(parameters));
            }

            public static Builder parameterizedType(TypeDescription rawType, TypeDefinition... parameter) {
                return parameterizedType(rawType, Arrays.asList(parameter));
            }

            public static Builder parameterizedType(TypeDescription rawType, Collection<? extends TypeDefinition> parameters) {
                return parameterizedType(rawType, Generic.UNDEFINED, parameters);
            }

            public static Builder parameterizedType(TypeDescription rawType, Generic ownerType, Collection<? extends TypeDefinition> parameters) {
                TypeDescription declaringType = rawType.getDeclaringType();
                if (ownerType == null && declaringType != null && rawType.isStatic()) {
                    ownerType = declaringType.asGenericType();
                }
                if (!rawType.represents(TargetType.class)) {
                    if (!rawType.isGenerified()) {
                        throw new IllegalArgumentException(rawType + " is not a parameterized type");
                    } else if (ownerType == null && declaringType != null && !rawType.isStatic()) {
                        throw new IllegalArgumentException(rawType + " requires an owner type");
                    } else if (ownerType != null && !ownerType.asErasure().equals(declaringType)) {
                        throw new IllegalArgumentException(ownerType + " does not represent required owner for " + rawType);
                    } else if (ownerType != null && (rawType.isStatic() ^ ownerType.getSort().isNonGeneric())) {
                        throw new IllegalArgumentException(ownerType + " does not define the correct parameters for owning " + rawType);
                    } else if (rawType.getTypeVariables().size() != parameters.size()) {
                        throw new IllegalArgumentException(parameters + " does not contain number of required parameters for " + rawType);
                    }
                }
                return new OfParameterizedType(rawType, ownerType, new TypeList.Generic.Explicit(new ArrayList(parameters)));
            }

            public Generic asWildcardUpperBound() {
                return asWildcardUpperBound(Collections.emptySet());
            }

            public Generic asWildcardUpperBound(Annotation... annotation) {
                return asWildcardUpperBound(Arrays.asList(annotation));
            }

            public Generic asWildcardUpperBound(List<? extends Annotation> annotations) {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(annotations));
            }

            public Generic asWildcardUpperBound(AnnotationDescription... annotation) {
                return asWildcardUpperBound((Collection<? extends AnnotationDescription>) Arrays.asList(annotation));
            }

            public Generic asWildcardUpperBound(Collection<? extends AnnotationDescription> annotations) {
                return OfWildcardType.Latent.boundedAbove(build(), new AnnotationSource.Explicit(new ArrayList(annotations)));
            }

            public Generic asWildcardLowerBound() {
                return asWildcardLowerBound(Collections.emptySet());
            }

            public Generic asWildcardLowerBound(Annotation... annotation) {
                return asWildcardLowerBound(Arrays.asList(annotation));
            }

            public Generic asWildcardLowerBound(List<? extends Annotation> annotations) {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(annotations));
            }

            public Generic asWildcardLowerBound(AnnotationDescription... annotation) {
                return asWildcardLowerBound((Collection<? extends AnnotationDescription>) Arrays.asList(annotation));
            }

            public Generic asWildcardLowerBound(Collection<? extends AnnotationDescription> annotations) {
                return OfWildcardType.Latent.boundedBelow(build(), new AnnotationSource.Explicit(new ArrayList(annotations)));
            }

            public Builder asArray() {
                return asArray(1);
            }

            public Builder asArray(int arity) {
                if (arity < 1) {
                    throw new IllegalArgumentException("Cannot define an array of a non-positive arity: " + arity);
                }
                Generic typeDescription = build();
                while (true) {
                    arity--;
                    if (arity <= 0) {
                        return new OfGenericArrayType(typeDescription);
                    }
                    typeDescription = new OfGenericArray.Latent(typeDescription, AnnotationSource.Empty.INSTANCE);
                }
            }

            public Builder annotate(Annotation... annotation) {
                return annotate(Arrays.asList(annotation));
            }

            public Builder annotate(List<? extends Annotation> annotations) {
                return annotate((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(annotations));
            }

            public Builder annotate(AnnotationDescription... annotation) {
                return annotate((Collection<? extends AnnotationDescription>) Arrays.asList(annotation));
            }

            public Builder annotate(Collection<? extends AnnotationDescription> annotations) {
                return doAnnotate(new ArrayList(annotations));
            }

            public Generic build() {
                return doBuild();
            }

            public Generic build(Annotation... annotation) {
                return build(Arrays.asList(annotation));
            }

            public Generic build(List<? extends Annotation> annotations) {
                return build((Collection<? extends AnnotationDescription>) new AnnotationList.ForLoadedAnnotations(annotations));
            }

            public Generic build(AnnotationDescription... annotation) {
                return build((Collection<? extends AnnotationDescription>) Arrays.asList(annotation));
            }

            public Generic build(Collection<? extends AnnotationDescription> annotations) {
                return doAnnotate(new ArrayList(annotations)).doBuild();
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Builder$OfNonGenericType.class */
            public static class OfNonGenericType extends Builder {
                private final TypeDescription typeDescription;
                @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                private final Generic ownerType;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    if (obj == null || getClass() != obj.getClass() || !this.typeDescription.equals(((OfNonGenericType) obj).typeDescription)) {
                        return false;
                    }
                    Generic generic = this.ownerType;
                    Generic generic2 = ((OfNonGenericType) obj).ownerType;
                    return generic2 != null ? generic != null && generic.equals(generic2) : generic == null;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public int hashCode() {
                    int hashCode = ((hashCode() * 31) + this.typeDescription.hashCode()) * 31;
                    Generic generic = this.ownerType;
                    return generic != null ? hashCode + generic.hashCode() : hashCode;
                }

                protected OfNonGenericType(TypeDescription typeDescription) {
                    this(typeDescription, typeDescription.getDeclaringType());
                }

                private OfNonGenericType(TypeDescription typeDescription, TypeDescription ownerType) {
                    this(typeDescription, ownerType == null ? Generic.UNDEFINED : ownerType.asGenericType());
                }

                protected OfNonGenericType(TypeDescription typeDescription, Generic ownerType) {
                    this(typeDescription, ownerType, Collections.emptyList());
                }

                protected OfNonGenericType(TypeDescription typeDescription, Generic ownerType, List<? extends AnnotationDescription> annotations) {
                    super(annotations);
                    this.ownerType = ownerType;
                    this.typeDescription = typeDescription;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Builder doAnnotate(List<? extends AnnotationDescription> annotations) {
                    return new OfNonGenericType(this.typeDescription, this.ownerType, CompoundList.m80of(this.annotations, (List) annotations));
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Generic doBuild() {
                    if (!this.typeDescription.represents(Void.TYPE) || this.annotations.isEmpty()) {
                        return new OfNonGenericType.Latent(this.typeDescription, this.ownerType, new AnnotationSource.Explicit(this.annotations));
                    }
                    throw new IllegalArgumentException("The void non-type cannot be annotated");
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Builder$OfParameterizedType.class */
            public static class OfParameterizedType extends Builder {
                private final TypeDescription rawType;
                private final Generic ownerType;
                private final List<? extends Generic> parameterTypes;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.rawType.equals(((OfParameterizedType) obj).rawType) && this.ownerType.equals(((OfParameterizedType) obj).ownerType) && this.parameterTypes.equals(((OfParameterizedType) obj).parameterTypes);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public int hashCode() {
                    return (((((hashCode() * 31) + this.rawType.hashCode()) * 31) + this.ownerType.hashCode()) * 31) + this.parameterTypes.hashCode();
                }

                protected OfParameterizedType(TypeDescription rawType, Generic ownerType, List<? extends Generic> parameterTypes) {
                    this(rawType, ownerType, parameterTypes, Collections.emptyList());
                }

                protected OfParameterizedType(TypeDescription rawType, Generic ownerType, List<? extends Generic> parameterTypes, List<? extends AnnotationDescription> annotations) {
                    super(annotations);
                    this.rawType = rawType;
                    this.ownerType = ownerType;
                    this.parameterTypes = parameterTypes;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Builder doAnnotate(List<? extends AnnotationDescription> annotations) {
                    return new OfParameterizedType(this.rawType, this.ownerType, this.parameterTypes, CompoundList.m80of(this.annotations, (List) annotations));
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Generic doBuild() {
                    return new OfParameterizedType.Latent(this.rawType, this.ownerType, this.parameterTypes, new AnnotationSource.Explicit(this.annotations));
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Builder$OfGenericArrayType.class */
            public static class OfGenericArrayType extends Builder {
                private final Generic componentType;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((OfGenericArrayType) obj).componentType);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public int hashCode() {
                    return (hashCode() * 31) + this.componentType.hashCode();
                }

                protected OfGenericArrayType(Generic componentType) {
                    this(componentType, Collections.emptyList());
                }

                protected OfGenericArrayType(Generic componentType, List<? extends AnnotationDescription> annotations) {
                    super(annotations);
                    this.componentType = componentType;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Builder doAnnotate(List<? extends AnnotationDescription> annotations) {
                    return new OfGenericArrayType(this.componentType, CompoundList.m80of(this.annotations, (List) annotations));
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Generic doBuild() {
                    return new OfGenericArray.Latent(this.componentType, new AnnotationSource.Explicit(this.annotations));
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Generic$Builder$OfTypeVariable.class */
            protected static class OfTypeVariable extends Builder {
                private final String symbol;

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public boolean equals(Object obj) {
                    if (!equals(obj)) {
                        return false;
                    }
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.symbol.equals(((OfTypeVariable) obj).symbol);
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                public int hashCode() {
                    return (hashCode() * 31) + this.symbol.hashCode();
                }

                protected OfTypeVariable(String symbol) {
                    this(symbol, Collections.emptyList());
                }

                protected OfTypeVariable(String symbol, List<? extends AnnotationDescription> annotations) {
                    super(annotations);
                    this.symbol = symbol;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Builder doAnnotate(List<? extends AnnotationDescription> annotations) {
                    return new OfTypeVariable(this.symbol, CompoundList.m80of(this.annotations, (List) annotations));
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.Builder
                protected Generic doBuild() {
                    return new OfTypeVariable.Symbolic(this.symbol, new AnnotationSource.Explicit(this.annotations));
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$AbstractBase.class */
    public static abstract class AbstractBase extends TypeVariableSource.AbstractBase implements TypeDescription {
        public static final boolean RAW_TYPES;
        private transient /* synthetic */ int hashCode;

        static {
            boolean rawTypes;
            try {
                rawTypes = Boolean.parseBoolean((String) AccessController.doPrivileged(new GetSystemPropertyAction(TypeDefinition.RAW_TYPES_PROPERTY)));
            } catch (Exception e) {
                rawTypes = false;
            }
            RAW_TYPES = rawTypes;
        }

        private static boolean isAssignable(TypeDescription sourceType, TypeDescription targetType) {
            if (sourceType.equals(targetType)) {
                return true;
            }
            if (targetType.isArray()) {
                if (sourceType.isArray()) {
                    return isAssignable(sourceType.getComponentType(), targetType.getComponentType());
                }
                return sourceType.represents(Object.class) || ARRAY_INTERFACES.contains(sourceType.asGenericType());
            } else if (sourceType.represents(Object.class)) {
                return !targetType.isPrimitive();
            } else {
                Generic superClass = targetType.getSuperClass();
                if (superClass != null && sourceType.isAssignableFrom(superClass.asErasure())) {
                    return true;
                }
                if (!sourceType.isInterface()) {
                    return false;
                }
                for (TypeDescription interfaceType : targetType.getInterfaces().asErasures()) {
                    if (sourceType.isAssignableFrom(interfaceType)) {
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableFrom(Class<?> type) {
            return isAssignableFrom(ForLoadedType.m247of(type));
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableFrom(TypeDescription typeDescription) {
            return isAssignable(this, typeDescription);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableTo(Class<?> type) {
            return isAssignableTo(ForLoadedType.m247of(type));
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableTo(TypeDescription typeDescription) {
            return isAssignable(typeDescription, this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isInHierarchyWith(Class<?> type) {
            return isAssignableTo(type) || isAssignableFrom(type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isInHierarchyWith(TypeDescription typeDescription) {
            return isAssignableTo(typeDescription) || isAssignableFrom(typeDescription);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeDescription asErasure() {
            return this;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public Generic asGenericType() {
            return new Generic.OfNonGenericType.ForErasure(this);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeDefinition.Sort getSort() {
            return TypeDefinition.Sort.NON_GENERIC;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isInstance(Object value) {
            return isAssignableFrom(value.getClass());
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnnotationValue(Object value) {
            if (represents(Class.class) && (value instanceof TypeDescription)) {
                return true;
            }
            if ((value instanceof AnnotationDescription) && ((AnnotationDescription) value).getAnnotationType().equals(this)) {
                return true;
            }
            if ((value instanceof EnumerationDescription) && ((EnumerationDescription) value).getEnumerationType().equals(this)) {
                return true;
            }
            if (represents(String.class) && (value instanceof String)) {
                return true;
            }
            if (represents(Boolean.TYPE) && (value instanceof Boolean)) {
                return true;
            }
            if (represents(Byte.TYPE) && (value instanceof Byte)) {
                return true;
            }
            if (represents(Short.TYPE) && (value instanceof Short)) {
                return true;
            }
            if (represents(Character.TYPE) && (value instanceof Character)) {
                return true;
            }
            if (represents(Integer.TYPE) && (value instanceof Integer)) {
                return true;
            }
            if (represents(Long.TYPE) && (value instanceof Long)) {
                return true;
            }
            if (represents(Float.TYPE) && (value instanceof Float)) {
                return true;
            }
            if (represents(Double.TYPE) && (value instanceof Double)) {
                return true;
            }
            if (represents(String[].class) && (value instanceof String[])) {
                return true;
            }
            if (represents(boolean[].class) && (value instanceof boolean[])) {
                return true;
            }
            if (represents(byte[].class) && (value instanceof byte[])) {
                return true;
            }
            if (represents(short[].class) && (value instanceof short[])) {
                return true;
            }
            if (represents(char[].class) && (value instanceof char[])) {
                return true;
            }
            if (represents(int[].class) && (value instanceof int[])) {
                return true;
            }
            if (represents(long[].class) && (value instanceof long[])) {
                return true;
            }
            if (represents(float[].class) && (value instanceof float[])) {
                return true;
            }
            if (represents(double[].class) && (value instanceof double[])) {
                return true;
            }
            if (represents(Class[].class) && (value instanceof TypeDescription[])) {
                return true;
            }
            if (isAssignableTo(Annotation[].class) && (value instanceof AnnotationDescription[])) {
                for (AnnotationDescription annotationDescription : (AnnotationDescription[]) value) {
                    if (!annotationDescription.getAnnotationType().equals(getComponentType())) {
                        return false;
                    }
                }
                return true;
            } else if (!isAssignableTo(Enum[].class) || !(value instanceof EnumerationDescription[])) {
                return false;
            } else {
                for (EnumerationDescription enumerationDescription : (EnumerationDescription[]) value) {
                    if (!enumerationDescription.getEnumerationType().equals(getComponentType())) {
                        return false;
                    }
                }
                return true;
            }
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return getName().replace('.', '/');
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public int getActualModifiers(boolean superFlag) {
            int actualModifiers = getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0) | (isRecord() ? 65536 : 0) | (superFlag ? 32 : 0);
            if (isPrivate()) {
                return actualModifiers & -11;
            }
            if (isProtected()) {
                return (actualModifiers & -13) | 1;
            }
            return actualModifiers & -9;
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getGenericSignature() {
            SignatureVisitor signatureVisitor;
            try {
                SignatureWriter signatureWriter = new SignatureWriter();
                boolean generic = false;
                for (Generic typeVariable : getTypeVariables()) {
                    signatureWriter.visitFormalTypeParameter(typeVariable.getSymbol());
                    for (Generic upperBound : typeVariable.getUpperBounds()) {
                        if (upperBound.asErasure().isInterface()) {
                            signatureVisitor = signatureWriter.visitInterfaceBound();
                        } else {
                            signatureVisitor = signatureWriter.visitClassBound();
                        }
                        upperBound.accept(new Generic.Visitor.ForSignatureVisitor(signatureVisitor));
                    }
                    generic = true;
                }
                Generic superClass = getSuperClass();
                if (superClass == null) {
                    superClass = Generic.OBJECT;
                }
                superClass.accept(new Generic.Visitor.ForSignatureVisitor(signatureWriter.visitSuperclass()));
                boolean generic2 = generic || !superClass.getSort().isNonGeneric();
                for (Generic interfaceType : getInterfaces()) {
                    interfaceType.accept(new Generic.Visitor.ForSignatureVisitor(signatureWriter.visitInterface()));
                    generic2 = generic2 || !interfaceType.getSort().isNonGeneric();
                }
                return generic2 ? signatureWriter.toString() : NON_GENERIC_SIGNATURE;
            } catch (GenericSignatureFormatError e) {
                return NON_GENERIC_SIGNATURE;
            }
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isSamePackage(TypeDescription typeDescription) {
            PackageDescription thisPackage = getPackage();
            PackageDescription otherPackage = typeDescription.getPackage();
            if (thisPackage == null || otherPackage == null) {
                return thisPackage == otherPackage;
            }
            return thisPackage.equals(otherPackage);
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isVisibleTo(TypeDescription typeDescription) {
            return isPrimitive() || (!isArray() ? isPublic() || isProtected() || isSamePackage(typeDescription) : getComponentType().isVisibleTo(typeDescription));
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isAccessibleTo(TypeDescription typeDescription) {
            return isPrimitive() || (!isArray() ? isPublic() || isSamePackage(typeDescription) : getComponentType().isVisibleTo(typeDescription));
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public AnnotationList getInheritedAnnotations() {
            Generic superClass = getSuperClass();
            AnnotationList<AnnotationDescription> declaredAnnotations = getDeclaredAnnotations();
            if (superClass == null) {
                return declaredAnnotations;
            }
            Set<TypeDescription> annotationTypes = new HashSet<>();
            for (AnnotationDescription annotationDescription : declaredAnnotations) {
                annotationTypes.add(annotationDescription.getAnnotationType());
            }
            return new AnnotationList.Explicit(CompoundList.m80of((List) declaredAnnotations, (List) superClass.asErasure().getInheritedAnnotations().inherited(annotationTypes)));
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            if (!isArray()) {
                return getName();
            }
            TypeDescription typeDescription = this;
            int dimensions = 0;
            do {
                dimensions++;
                typeDescription = typeDescription.getComponentType();
            } while (typeDescription.isArray());
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(typeDescription.getActualName());
            for (int i = 0; i < dimensions; i++) {
                stringBuilder.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return stringBuilder.toString();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isPrimitiveWrapper() {
            return represents(Boolean.class) || represents(Byte.class) || represents(Short.class) || represents(Character.class) || represents(Integer.class) || represents(Long.class) || represents(Float.class) || represents(Double.class);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnnotationReturnType() {
            return isPrimitive() || represents(String.class) || (isAssignableTo(Enum.class) && !represents(Enum.class)) || ((isAssignableTo(Annotation.class) && !represents(Annotation.class)) || represents(Class.class) || (isArray() && !getComponentType().isArray() && getComponentType().isAnnotationReturnType()));
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnnotationValue() {
            return isPrimitive() || represents(String.class) || isAssignableTo(TypeDescription.class) || isAssignableTo(AnnotationDescription.class) || isAssignableTo(EnumerationDescription.class) || (isArray() && !getComponentType().isArray() && getComponentType().isAnnotationValue());
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        @SuppressFBWarnings(value = {"EC_UNRELATED_CLASS_AND_INTERFACE"}, justification = "Fits equality contract for type definitions")
        public boolean represents(Type type) {
            return equals(TypeDefinition.Sort.describe(type));
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public String getTypeName() {
            return getName();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeVariableSource getEnclosingSource() {
            MethodDescription enclosingMethod = getEnclosingMethod();
            return enclosingMethod == null ? isStatic() ? TypeVariableSource.UNDEFINED : getEnclosingType() : enclosingMethod;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public boolean isInferrable() {
            return false;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public <T> T accept(TypeVariableSource.Visitor<T> visitor) {
            return visitor.onType(this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isPackageType() {
            return getSimpleName().equals(PackageDescription.PACKAGE_CLASS_NAME);
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public boolean isGenerified() {
            TypeDescription declaringType;
            if (!getTypeVariables().isEmpty()) {
                return true;
            }
            return !isStatic() && (declaringType = getDeclaringType()) != null && declaringType.isGenerified();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public int getInnerClassCount() {
            TypeDescription declaringType;
            if (!isStatic() && (declaringType = getDeclaringType()) != null) {
                return declaringType.getInnerClassCount() + 1;
            }
            return 0;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isInnerClass() {
            return !isStatic() && isNestedClass();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isNestedClass() {
            return getDeclaringType() != null;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription asBoxed() {
            if (represents(Boolean.TYPE)) {
                return ForLoadedType.m247of(Boolean.class);
            }
            if (represents(Byte.TYPE)) {
                return ForLoadedType.m247of(Byte.class);
            }
            if (represents(Short.TYPE)) {
                return ForLoadedType.m247of(Short.class);
            }
            if (represents(Character.TYPE)) {
                return ForLoadedType.m247of(Character.class);
            }
            if (represents(Integer.TYPE)) {
                return ForLoadedType.m247of(Integer.class);
            }
            if (represents(Long.TYPE)) {
                return ForLoadedType.m247of(Long.class);
            }
            if (represents(Float.TYPE)) {
                return ForLoadedType.m247of(Float.class);
            }
            if (represents(Double.TYPE)) {
                return ForLoadedType.m247of(Double.class);
            }
            return this;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription asUnboxed() {
            if (represents(Boolean.class)) {
                return ForLoadedType.m247of(Boolean.TYPE);
            }
            if (represents(Byte.class)) {
                return ForLoadedType.m247of(Byte.TYPE);
            }
            if (represents(Short.class)) {
                return ForLoadedType.m247of(Short.TYPE);
            }
            if (represents(Character.class)) {
                return ForLoadedType.m247of(Character.TYPE);
            }
            if (represents(Integer.class)) {
                return ForLoadedType.m247of(Integer.TYPE);
            }
            if (represents(Long.class)) {
                return ForLoadedType.m247of(Long.TYPE);
            }
            if (represents(Float.class)) {
                return ForLoadedType.m247of(Float.TYPE);
            }
            if (represents(Double.class)) {
                return ForLoadedType.m247of(Double.TYPE);
            }
            return this;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public Object getDefaultValue() {
            if (represents(Boolean.TYPE)) {
                return false;
            }
            if (represents(Byte.TYPE)) {
                return (byte) 0;
            }
            if (represents(Short.TYPE)) {
                return (short) 0;
            }
            if (represents(Character.TYPE)) {
                return (char) 0;
            }
            if (represents(Integer.TYPE)) {
                return 0;
            }
            if (represents(Long.TYPE)) {
                return 0L;
            }
            if (represents(Float.TYPE)) {
                return Float.valueOf(0.0f);
            }
            if (represents(Double.TYPE)) {
                return Double.valueOf(0.0d);
            }
            return null;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isNestHost() {
            return equals(getNestHost());
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isNestMateOf(Class<?> type) {
            return isNestMateOf(ForLoadedType.m247of(type));
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isNestMateOf(TypeDescription typeDescription) {
            return getNestHost().equals(typeDescription.getNestHost());
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isMemberType() {
            return !isLocalType() && !isAnonymousType() && getDeclaringType() != null;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isCompileTimeConstant() {
            return represents(Integer.TYPE) || represents(Long.TYPE) || represents(Float.TYPE) || represents(Double.TYPE) || represents(String.class) || represents(Class.class) || equals(JavaType.METHOD_TYPE.getTypeStub()) || equals(JavaType.METHOD_HANDLE.getTypeStub());
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isSealed() {
            return !isPrimitive() && !isArray() && !getPermittedSubtypes().isEmpty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public ClassFileVersion getClassFileVersion() {
            return null;
        }

        @Override // java.lang.Iterable
        public Iterator<TypeDefinition> iterator() {
            return new TypeDefinition.SuperClassIterator(this);
        }

        @Override // java.lang.Object
        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : getName().hashCode();
            if (hashCode == 0) {
                hashCode = this.hashCode;
            } else {
                this.hashCode = hashCode;
            }
            return hashCode;
        }

        @Override // java.lang.Object
        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TypeDefinition)) {
                return false;
            }
            TypeDefinition typeDefinition = (TypeDefinition) other;
            return typeDefinition.getSort().isNonGeneric() && getName().equals(typeDefinition.asErasure().getName());
        }

        @Override // java.lang.Object
        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            if (isPrimitive()) {
                str = "";
            } else {
                str = (isInterface() ? "interface" : "class") + " ";
            }
            return sb.append(str).append(getName()).toString();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$AbstractBase$OfSimpleType.class */
        public static abstract class OfSimpleType extends AbstractBase {
            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isPrimitive() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isArray() {
                return false;
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public TypeDescription getComponentType() {
                return TypeDescription.UNDEFINED;
            }

            @Override // net.bytebuddy.description.NamedElement.WithDescriptor
            public String getDescriptor() {
                return "L" + getInternalName() + ";";
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public String getCanonicalName() {
                if (isAnonymousType() || isLocalType()) {
                    return NO_NAME;
                }
                String internalName = getInternalName();
                TypeDescription enclosingType = getEnclosingType();
                if (enclosingType == null || !internalName.startsWith(enclosingType.getInternalName() + "$")) {
                    return getName();
                }
                return enclosingType.getCanonicalName() + Mapper.IGNORED_FIELDNAME + internalName.substring(enclosingType.getInternalName().length() + 1);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public String getSimpleName() {
                int simpleNameIndex;
                String internalName = getInternalName();
                TypeDescription enclosingType = getEnclosingType();
                if (enclosingType == null || !internalName.startsWith(enclosingType.getInternalName() + "$")) {
                    simpleNameIndex = internalName.lastIndexOf(47);
                    if (simpleNameIndex == -1) {
                        return internalName;
                    }
                } else {
                    simpleNameIndex = enclosingType.getInternalName().length() + 1;
                }
                while (simpleNameIndex < internalName.length() && !Character.isLetter(internalName.charAt(simpleNameIndex))) {
                    simpleNameIndex++;
                }
                return internalName.substring(simpleNameIndex);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public StackSize getStackSize() {
                return StackSize.SINGLE;
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$AbstractBase$OfSimpleType$WithDelegation.class */
            public static abstract class WithDelegation extends OfSimpleType {
                protected abstract TypeDescription delegate();

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType, net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
                public /* bridge */ /* synthetic */ TypeDefinition getComponentType() {
                    return getComponentType();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public Generic getSuperClass() {
                    return delegate().getSuperClass();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public TypeList.Generic getInterfaces() {
                    return delegate().getInterfaces();
                }

                @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
                public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
                    return delegate().getDeclaredFields();
                }

                @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
                public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
                    return delegate().getDeclaredMethods();
                }

                @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                public TypeDescription getDeclaringType() {
                    return delegate().getDeclaringType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public MethodDescription.InDefinedShape getEnclosingMethod() {
                    return delegate().getEnclosingMethod();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public TypeDescription getEnclosingType() {
                    return delegate().getEnclosingType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public TypeList getDeclaredTypes() {
                    return delegate().getDeclaredTypes();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public boolean isAnonymousType() {
                    return delegate().isAnonymousType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public boolean isLocalType() {
                    return delegate().isLocalType();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public PackageDescription getPackage() {
                    return delegate().getPackage();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return delegate().getDeclaredAnnotations();
                }

                @Override // net.bytebuddy.description.TypeVariableSource
                public TypeList.Generic getTypeVariables() {
                    return delegate().getTypeVariables();
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return delegate().getModifiers();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                public String getGenericSignature() {
                    return delegate().getGenericSignature();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
                public int getActualModifiers(boolean superFlag) {
                    return delegate().getActualModifiers(superFlag);
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public TypeDescription getNestHost() {
                    return delegate().getNestHost();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public TypeList getNestMembers() {
                    return delegate().getNestMembers();
                }

                @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
                public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
                    return delegate().getRecordComponents();
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                public boolean isRecord() {
                    return delegate().isRecord();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
                public boolean isSealed() {
                    return delegate().isSealed();
                }

                @Override // net.bytebuddy.description.type.TypeDescription
                public TypeList getPermittedSubtypes() {
                    return delegate().getPermittedSubtypes();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
                public ClassFileVersion getClassFileVersion() {
                    return delegate().getClassFileVersion();
                }
            }
        }
    }

    @SuppressFBWarnings(value = {"SE_TRANSIENT_FIELD_NOT_RESTORED"}, justification = "Field is only used as a cache store and is implicitly recomputed")
    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$ForLoadedType.class */
    public static class ForLoadedType extends AbstractBase implements Serializable {
        private static final long serialVersionUID = 1;
        private static final Dispatcher DISPATCHER = (Dispatcher) AccessController.doPrivileged(JavaDispatcher.m62of(Dispatcher.class));
        @SuppressFBWarnings(value = {"MS_MUTABLE_COLLECTION_PKGPROTECT"}, justification = "This collection is not exposed.")
        private static final Map<Class<?>, TypeDescription> TYPE_CACHE = new HashMap();
        private final Class<?> type;
        private transient /* synthetic */ FieldList declaredFields;
        private transient /* synthetic */ MethodList declaredMethods;
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ ClassFileVersion getClassFileVersion_wp1eqYxw;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Defaults
        @JavaDispatcher.Proxied("java.lang.Class")
        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$ForLoadedType$Dispatcher.class */
        public interface Dispatcher {
            AnnotatedElement getAnnotatedSuperclass(Class<?> cls);

            AnnotatedElement[] getAnnotatedInterfaces(Class<?> cls);

            Class<?> getNestHost(Class<?> cls);

            Class<?>[] getNestMembers(Class<?> cls);

            boolean isNestmateOf(Class<?> cls, Class<?> cls2);

            boolean isSealed(Class<?> cls);

            Class<?>[] getPermittedSubclasses(Class<?> cls);

            boolean isRecord(Class<?> cls);

            Object[] getRecordComponents(Class<?> cls);
        }

        static {
            TYPE_CACHE.put(TargetType.class, new ForLoadedType(TargetType.class));
            TYPE_CACHE.put(Object.class, new ForLoadedType(Object.class));
            TYPE_CACHE.put(String.class, new ForLoadedType(String.class));
            TYPE_CACHE.put(Boolean.class, new ForLoadedType(Boolean.class));
            TYPE_CACHE.put(Byte.class, new ForLoadedType(Byte.class));
            TYPE_CACHE.put(Short.class, new ForLoadedType(Short.class));
            TYPE_CACHE.put(Character.class, new ForLoadedType(Character.class));
            TYPE_CACHE.put(Integer.class, new ForLoadedType(Integer.class));
            TYPE_CACHE.put(Long.class, new ForLoadedType(Long.class));
            TYPE_CACHE.put(Float.class, new ForLoadedType(Float.class));
            TYPE_CACHE.put(Double.class, new ForLoadedType(Double.class));
            TYPE_CACHE.put(Void.TYPE, new ForLoadedType(Void.TYPE));
            TYPE_CACHE.put(Boolean.TYPE, new ForLoadedType(Boolean.TYPE));
            TYPE_CACHE.put(Byte.TYPE, new ForLoadedType(Byte.TYPE));
            TYPE_CACHE.put(Short.TYPE, new ForLoadedType(Short.TYPE));
            TYPE_CACHE.put(Character.TYPE, new ForLoadedType(Character.TYPE));
            TYPE_CACHE.put(Integer.TYPE, new ForLoadedType(Integer.TYPE));
            TYPE_CACHE.put(Long.TYPE, new ForLoadedType(Long.TYPE));
            TYPE_CACHE.put(Float.TYPE, new ForLoadedType(Float.TYPE));
            TYPE_CACHE.put(Double.TYPE, new ForLoadedType(Double.TYPE));
        }

        public ForLoadedType(Class<?> type) {
            this.type = type;
        }

        public static String getName(Class<?> type) {
            String name = type.getName();
            int anonymousLoaderIndex = name.indexOf(47);
            return anonymousLoaderIndex == -1 ? name : name.substring(0, anonymousLoaderIndex);
        }

        /* renamed from: of */
        public static TypeDescription m247of(Class<?> type) {
            TypeDescription typeDescription = TYPE_CACHE.get(type);
            return typeDescription == null ? new ForLoadedType(type) : typeDescription;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableFrom(Class<?> type) {
            return this.type.isAssignableFrom(type) || isAssignableFrom(type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableFrom(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && this.type.isAssignableFrom(((ForLoadedType) typeDescription).type)) || isAssignableFrom(typeDescription);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableTo(Class<?> type) {
            return type.isAssignableFrom(this.type) || isAssignableTo(type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isAssignableTo(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && ((ForLoadedType) typeDescription).type.isAssignableFrom(this.type)) || isAssignableTo(typeDescription);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isInHierarchyWith(Class<?> type) {
            return type.isAssignableFrom(this.type) || this.type.isAssignableFrom(type) || isInHierarchyWith(type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isInHierarchyWith(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && (((ForLoadedType) typeDescription).type.isAssignableFrom(this.type) || this.type.isAssignableFrom(((ForLoadedType) typeDescription).type))) || isInHierarchyWith(typeDescription);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDefinition
        public boolean represents(Type type) {
            return type == this.type || represents(type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public TypeDescription getComponentType() {
            Class<?> componentType = this.type.getComponentType();
            return componentType == null ? TypeDescription.UNDEFINED : m247of(componentType);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isArray() {
            return this.type.isArray();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isPrimitive() {
            return this.type.isPrimitive();
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.ForTypeDefinition
        public boolean isAnnotation() {
            return this.type.isAnnotation();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public Generic getSuperClass() {
            return RAW_TYPES ? this.type.getSuperclass() == null ? Generic.UNDEFINED : Generic.OfNonGenericType.ForLoadedType.m244of(this.type.getSuperclass()) : this.type.getSuperclass() == null ? Generic.UNDEFINED : new Generic.LazyProjection.ForLoadedSuperClass(this.type);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return RAW_TYPES ? isArray() ? ARRAY_INTERFACES : new TypeList.Generic.ForLoadedTypes(this.type.getInterfaces()) : isArray() ? ARRAY_INTERFACES : new TypeList.Generic.OfLoadedInterfaceTypes(this.type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            Class<?> declaringType = this.type.getDeclaringClass();
            return declaringType == null ? TypeDescription.UNDEFINED : m247of(declaringType);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            Method enclosingMethod = this.type.getEnclosingMethod();
            Constructor<?> enclosingConstructor = this.type.getEnclosingConstructor();
            if (enclosingMethod != null) {
                return new MethodDescription.ForLoadedMethod(enclosingMethod);
            }
            if (enclosingConstructor != null) {
                return new MethodDescription.ForLoadedConstructor(enclosingConstructor);
            }
            return MethodDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getEnclosingType() {
            Class<?> enclosingType = this.type.getEnclosingClass();
            return enclosingType == null ? TypeDescription.UNDEFINED : m247of(enclosingType);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            return new TypeList.ForLoadedTypes(this.type.getDeclaredClasses());
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public String getSimpleName() {
            String simpleName = this.type.getSimpleName();
            int anonymousLoaderIndex = simpleName.indexOf(47);
            if (anonymousLoaderIndex == -1) {
                return simpleName;
            }
            StringBuilder normalized = new StringBuilder(simpleName.substring(0, anonymousLoaderIndex));
            for (Class<?> type = this.type; type.isArray(); type = type.getComponentType()) {
                normalized.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return normalized.toString();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            return this.type.isAnonymousClass();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            return this.type.isLocalClass();
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isMemberType() {
            return this.type.isMemberClass();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        @CachedReturnPlugin.Enhance("declaredFields")
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            FieldList<FieldDescription.InDefinedShape> forLoadedFields = this.declaredFields != null ? null : new FieldList.ForLoadedFields(this.type.getDeclaredFields());
            if (forLoadedFields == null) {
                forLoadedFields = this.declaredFields;
            } else {
                this.declaredFields = forLoadedFields;
            }
            return forLoadedFields;
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        @CachedReturnPlugin.Enhance("declaredMethods")
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            MethodList<MethodDescription.InDefinedShape> forLoadedMethods = this.declaredMethods != null ? null : new MethodList.ForLoadedMethods(this.type);
            if (forLoadedMethods == null) {
                forLoadedMethods = this.declaredMethods;
            } else {
                this.declaredMethods = forLoadedMethods;
            }
            return forLoadedMethods;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public PackageDescription getPackage() {
            if (this.type.isArray() || this.type.isPrimitive()) {
                return PackageDescription.UNDEFINED;
            }
            Package aPackage = this.type.getPackage();
            if (aPackage != null) {
                return new PackageDescription.ForLoadedPackage(aPackage);
            }
            String name = this.type.getName();
            int index = name.lastIndexOf(46);
            return index == -1 ? new PackageDescription.Simple("") : new PackageDescription.Simple(name.substring(0, index));
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public StackSize getStackSize() {
            return StackSize.m122of(this.type);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return getName(this.type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public String getCanonicalName() {
            String canonicalName = this.type.getCanonicalName();
            if (canonicalName == null) {
                return NO_NAME;
            }
            int anonymousLoaderIndex = canonicalName.indexOf(47);
            if (anonymousLoaderIndex == -1) {
                return canonicalName;
            }
            StringBuilder normalized = new StringBuilder(canonicalName.substring(0, anonymousLoaderIndex));
            for (Class<?> type = this.type; type.isArray(); type = type.getComponentType()) {
                normalized.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return normalized.toString();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            String name = this.type.getName();
            int anonymousLoaderIndex = name.indexOf(47);
            if (anonymousLoaderIndex == -1) {
                return net.bytebuddy.jar.asm.Type.getDescriptor(this.type);
            }
            return "L" + name.substring(0, anonymousLoaderIndex).replace('.', '/') + ";";
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.type.getModifiers();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            if (RAW_TYPES) {
                return new TypeList.Generic.Empty();
            }
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.m234of((GenericDeclaration) this.type);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(this.type.getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                forLoadedAnnotations = this.declaredAnnotations;
            } else {
                this.declaredAnnotations = forLoadedAnnotations;
            }
            return forLoadedAnnotations;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDefinition
        public Generic asGenericType() {
            return Generic.OfNonGenericType.ForLoadedType.m244of(this.type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            Class<?> host = DISPATCHER.getNestHost(this.type);
            return host == null ? this : m247of(host);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            Class<?>[] member = DISPATCHER.getNestMembers(this.type);
            return new TypeList.ForLoadedTypes(member.length == 0 ? new Class[]{this.type} : member);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isNestHost() {
            Class<?> host = DISPATCHER.getNestHost(this.type);
            return host == null || host == this.type;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isNestMateOf(Class<?> type) {
            return DISPATCHER.isNestmateOf(this.type, type) || isNestMateOf(m247of(type));
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isNestMateOf(TypeDescription typeDescription) {
            return ((typeDescription instanceof ForLoadedType) && DISPATCHER.isNestmateOf(this.type, ((ForLoadedType) typeDescription).type)) || isNestMateOf(typeDescription);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            Object[] recordComponent = DISPATCHER.getRecordComponents(this.type);
            return recordComponent == null ? new RecordComponentList.Empty<>() : new RecordComponentList.ForLoadedRecordComponents(recordComponent);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            return DISPATCHER.isRecord(this.type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isSealed() {
            return DISPATCHER.isSealed(this.type);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            Class<?>[] permittedSubclass = DISPATCHER.getPermittedSubclasses(this.type);
            return permittedSubclass == null ? new TypeList.Empty() : new TypeList.ForLoadedTypes(permittedSubclass);
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0012 */
        /* JADX WARN: Type inference failed for: r0v11, types: [net.bytebuddy.description.type.TypeDescription$ForLoadedType] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v15, types: [net.bytebuddy.ClassFileVersion] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        @net.bytebuddy.build.CachedReturnPlugin.Enhance
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public net.bytebuddy.ClassFileVersion getClassFileVersion() {
            /*
                r4 = this;
                r0 = r4
                net.bytebuddy.ClassFileVersion r0 = r0.getClassFileVersion_wp1eqYxw
                goto L_0x0007
            L_0x0007:
                r5 = r0
                r0 = r5
                if (r0 == 0) goto L_0x0010
                r0 = 0
                goto L_0x0021
            L_0x0010:
                r0 = r4
                r6 = r0
                r0 = r6
                java.lang.Class<?> r0 = r0.type     // Catch: Throwable -> 0x001c
                net.bytebuddy.ClassFileVersion r0 = net.bytebuddy.ClassFileVersion.m352of(r0)     // Catch: Throwable -> 0x001c
                goto L_0x0021
            L_0x001c:
                r7 = move-exception
                r1 = 0
                goto L_0x0021
            L_0x0021:
                r6 = r0
                r0 = r6
                if (r0 != 0) goto L_0x0031
                r0 = r4
                net.bytebuddy.ClassFileVersion r0 = r0.getClassFileVersion_wp1eqYxw
                net.bytebuddy.ClassFileVersion r0 = (net.bytebuddy.ClassFileVersion) r0
                r6 = r0
                goto L_0x0038
            L_0x0031:
                r0 = r6
                r1 = r4
                r2 = r1; r1 = r0; r0 = r2; 
                r0.getClassFileVersion_wp1eqYxw = r1
            L_0x0038:
                goto L_0x003b
            L_0x003b:
                r0 = r6
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.ForLoadedType.getClassFileVersion():net.bytebuddy.ClassFileVersion");
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$ArrayProjection.class */
    public static class ArrayProjection extends AbstractBase {
        private static final int ARRAY_IMPLIED = 1040;
        private static final int ARRAY_EXCLUDED = 8712;
        private final TypeDescription componentType;
        private final int arity;

        protected ArrayProjection(TypeDescription componentType, int arity) {
            this.componentType = componentType;
            this.arity = arity;
        }

        /* renamed from: of */
        public static TypeDescription m249of(TypeDescription componentType) {
            return m248of(componentType, 1);
        }

        /* renamed from: of */
        public static TypeDescription m248of(TypeDescription componentType, int arity) {
            if (arity < 0) {
                throw new IllegalArgumentException("Arrays cannot have a negative arity");
            }
            while (componentType.isArray()) {
                componentType = componentType.getComponentType();
                arity++;
            }
            return arity == 0 ? componentType : new ArrayProjection(componentType, arity);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isArray() {
            return true;
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public TypeDescription getComponentType() {
            return this.arity == 1 ? this.componentType : new ArrayProjection(this.componentType, this.arity - 1);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isPrimitive() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public Generic getSuperClass() {
            return Generic.OBJECT;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return ARRAY_INTERFACES;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return MethodDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getEnclosingType() {
            return TypeDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            return new TypeList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public String getSimpleName() {
            StringBuilder stringBuilder = new StringBuilder(this.componentType.getSimpleName());
            for (int i = 0; i < this.arity; i++) {
                stringBuilder.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return stringBuilder.toString();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public String getCanonicalName() {
            String canonicalName = this.componentType.getCanonicalName();
            if (canonicalName == null) {
                return NO_NAME;
            }
            StringBuilder stringBuilder = new StringBuilder(canonicalName);
            for (int i = 0; i < this.arity; i++) {
                stringBuilder.append(HttpUrl.PATH_SEGMENT_ENCODE_SET_URI);
            }
            return stringBuilder.toString();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isMemberType() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public StackSize getStackSize() {
            return StackSize.SINGLE;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public AnnotationList getInheritedAnnotations() {
            return new AnnotationList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public PackageDescription getPackage() {
            return PackageDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            String descriptor = this.componentType.getDescriptor();
            StringBuilder stringBuilder = new StringBuilder(descriptor.length() + this.arity);
            for (int index = 0; index < this.arity; index++) {
                stringBuilder.append('[');
            }
            for (int index2 = 0; index2 < descriptor.length(); index2++) {
                char character = descriptor.charAt(index2);
                stringBuilder.append(character == '/' ? '.' : character);
            }
            return stringBuilder.toString();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < this.arity; i++) {
                stringBuilder.append('[');
            }
            return stringBuilder.append(this.componentType.getDescriptor()).toString();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return TypeDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return (getComponentType().getModifiers() & -8713) | ARRAY_IMPLIED;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return new TypeList.Generic.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            return this;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            return new TypeList.Explicit(this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            return new TypeList.Empty();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$Latent.class */
    public static class Latent extends AbstractBase.OfSimpleType {
        private final String name;
        private final int modifiers;
        private final Generic superClass;
        private final List<? extends Generic> interfaces;

        public Latent(String name, int modifiers, Generic superClass, Generic... anInterface) {
            this(name, modifiers, superClass, Arrays.asList(anInterface));
        }

        public Latent(String name, int modifiers, Generic superClass, List<? extends Generic> interfaces) {
            this.name = name;
            this.modifiers = modifiers;
            this.superClass = superClass;
            this.interfaces = interfaces;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public Generic getSuperClass() {
            return this.superClass;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.Explicit(this.interfaces);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            throw new IllegalStateException("Cannot resolve enclosing method of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getEnclosingType() {
            throw new IllegalStateException("Cannot resolve enclosing type of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            throw new IllegalStateException("Cannot resolve inner types of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            throw new IllegalStateException("Cannot resolve anonymous type property of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            throw new IllegalStateException("Cannot resolve local class property of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            throw new IllegalStateException("Cannot resolve declared fields of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            throw new IllegalStateException("Cannot resolve declared methods of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public PackageDescription getPackage() {
            String name = getName();
            int index = name.lastIndexOf(46);
            return new PackageDescription.Simple(index == -1 ? "" : name.substring(0, index));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            throw new IllegalStateException("Cannot resolve declared annotations of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            throw new IllegalStateException("Cannot resolve declared type of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.modifiers;
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.name;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            throw new IllegalStateException("Cannot resolve type variables of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            throw new IllegalStateException("Cannot resolve nest host of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            throw new IllegalStateException("Cannot resolve nest mates of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            throw new IllegalStateException("Cannot resolve record components of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            throw new IllegalStateException("Cannot resolve record attribute of a latent type description: " + this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            throw new IllegalStateException("Cannot resolve permitted subclasses of a latent type description: " + this);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$ForPackageDescription.class */
    public static class ForPackageDescription extends AbstractBase.OfSimpleType {
        private final PackageDescription packageDescription;

        public ForPackageDescription(PackageDescription packageDescription) {
            this.packageDescription = packageDescription;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public Generic getSuperClass() {
            return Generic.OBJECT;
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return new TypeList.Generic.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return MethodDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getEnclosingType() {
            return TypeDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            return new TypeList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return new FieldList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return new MethodList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public PackageDescription getPackage() {
            return this.packageDescription;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.packageDescription.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return TypeDescription.UNDEFINED;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return new TypeList.Generic.Empty();
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return PackageDescription.PACKAGE_MODIFIERS;
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.packageDescription.getName() + Mapper.IGNORED_FIELDNAME + PackageDescription.PACKAGE_CLASS_NAME;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            return this;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            return new TypeList.Explicit(this);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return new RecordComponentList.Empty();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            return false;
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            return new TypeList.Empty();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$SuperTypeLoading.class */
    public static class SuperTypeLoading extends AbstractBase {
        private final TypeDescription delegate;
        private final ClassLoader classLoader;
        private final ClassLoadingDelegate classLoadingDelegate;

        public SuperTypeLoading(TypeDescription delegate, ClassLoader classLoader) {
            this(delegate, classLoader, ClassLoadingDelegate.Simple.INSTANCE);
        }

        public SuperTypeLoading(TypeDescription delegate, ClassLoader classLoader, ClassLoadingDelegate classLoadingDelegate) {
            this.delegate = delegate;
            this.classLoader = classLoader;
            this.classLoadingDelegate = classLoadingDelegate;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.delegate.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.delegate.getModifiers();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return this.delegate.getTypeVariables();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return this.delegate.getDescriptor();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.delegate.getName();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public Generic getSuperClass() {
            Generic superClass = this.delegate.getSuperClass();
            return superClass == null ? Generic.UNDEFINED : new ClassLoadingTypeProjection(superClass, this.classLoader, this.classLoadingDelegate);
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public TypeList.Generic getInterfaces() {
            return new ClassLoadingTypeList(this.delegate.getInterfaces(), this.classLoader, this.classLoadingDelegate);
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
            return this.delegate.getDeclaredFields();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
            return this.delegate.getDeclaredMethods();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public StackSize getStackSize() {
            return this.delegate.getStackSize();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isArray() {
            return this.delegate.isArray();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isPrimitive() {
            return this.delegate.isPrimitive();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public TypeDescription getComponentType() {
            return this.delegate.getComponentType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return this.delegate.getDeclaringType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getDeclaredTypes() {
            return this.delegate.getDeclaredTypes();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public MethodDescription.InDefinedShape getEnclosingMethod() {
            return this.delegate.getEnclosingMethod();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getEnclosingType() {
            return this.delegate.getEnclosingType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public String getSimpleName() {
            return this.delegate.getSimpleName();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public String getCanonicalName() {
            return this.delegate.getCanonicalName();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isAnonymousType() {
            return this.delegate.isAnonymousType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public boolean isLocalType() {
            return this.delegate.isLocalType();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public PackageDescription getPackage() {
            return this.delegate.getPackage();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeDescription getNestHost() {
            return this.delegate.getNestHost();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getNestMembers() {
            return this.delegate.getNestMembers();
        }

        @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
        public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
            return this.delegate.getRecordComponents();
        }

        @Override // net.bytebuddy.description.type.TypeDefinition
        public boolean isRecord() {
            return this.delegate.isRecord();
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public boolean isSealed() {
            return this.delegate.isSealed();
        }

        @Override // net.bytebuddy.description.type.TypeDescription
        public TypeList getPermittedSubtypes() {
            return this.delegate.getPermittedSubtypes();
        }

        @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
        public ClassFileVersion getClassFileVersion() {
            return this.delegate.getClassFileVersion();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$SuperTypeLoading$ClassLoadingDelegate.class */
        public interface ClassLoadingDelegate {
            Class<?> load(String str, ClassLoader classLoader) throws ClassNotFoundException;

            /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$SuperTypeLoading$ClassLoadingDelegate$Simple.class */
            public enum Simple implements ClassLoadingDelegate {
                INSTANCE;

                @Override // net.bytebuddy.description.type.TypeDescription.SuperTypeLoading.ClassLoadingDelegate
                public Class<?> load(String name, ClassLoader classLoader) throws ClassNotFoundException {
                    return Class.forName(name, false, classLoader);
                }
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$SuperTypeLoading$ClassLoadingTypeProjection.class */
        public static class ClassLoadingTypeProjection extends Generic.LazyProjection {
            private final Generic delegate;
            private final ClassLoader classLoader;
            private final ClassLoadingDelegate classLoadingDelegate;
            private transient /* synthetic */ TypeDescription erasure;
            private transient /* synthetic */ Generic superClass;
            private transient /* synthetic */ TypeList.Generic interfaces;

            protected ClassLoadingTypeProjection(Generic delegate, ClassLoader classLoader, ClassLoadingDelegate classLoadingDelegate) {
                this.delegate = delegate;
                this.classLoader = classLoader;
                this.classLoadingDelegate = classLoadingDelegate;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                return this.delegate.getDeclaredAnnotations();
            }

            /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0012 */
            /* JADX WARN: Type inference failed for: r0v11, types: [net.bytebuddy.description.type.TypeDescription$SuperTypeLoading$ClassLoadingTypeProjection] */
            /* JADX WARN: Type inference failed for: r0v12 */
            /* JADX WARN: Type inference failed for: r0v16, types: [net.bytebuddy.description.type.TypeDescription] */
            /* JADX WARNING: Unknown variable types count: 1 */
            @Override // net.bytebuddy.description.type.TypeDefinition
            @net.bytebuddy.build.CachedReturnPlugin.Enhance("erasure")
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public net.bytebuddy.description.type.TypeDescription asErasure() {
                /*
                    r4 = this;
                    r0 = r4
                    net.bytebuddy.description.type.TypeDescription r0 = r0.erasure
                    goto L_0x0007
                L_0x0007:
                    r5 = r0
                    r0 = r5
                    if (r0 == 0) goto L_0x0010
                    r0 = 0
                    goto L_0x0040
                L_0x0010:
                    r0 = r4
                    r6 = r0
                    r0 = r6
                    net.bytebuddy.description.type.TypeDescription$SuperTypeLoading$ClassLoadingDelegate r0 = r0.classLoadingDelegate     // Catch: ClassNotFoundException -> 0x0033
                    r1 = r6
                    net.bytebuddy.description.type.TypeDescription$Generic r1 = r1.delegate     // Catch: ClassNotFoundException -> 0x0033
                    net.bytebuddy.description.type.TypeDescription r1 = r1.asErasure()     // Catch: ClassNotFoundException -> 0x0033
                    java.lang.String r1 = r1.getName()     // Catch: ClassNotFoundException -> 0x0033
                    r2 = r6
                    java.lang.ClassLoader r2 = r2.classLoader     // Catch: ClassNotFoundException -> 0x0033
                    java.lang.Class r0 = r0.load(r1, r2)     // Catch: ClassNotFoundException -> 0x0033
                    net.bytebuddy.description.type.TypeDescription r0 = net.bytebuddy.description.type.TypeDescription.ForLoadedType.m247of(r0)     // Catch: ClassNotFoundException -> 0x0033
                    goto L_0x0040
                L_0x0033:
                    r7 = move-exception
                    r1 = r6
                    net.bytebuddy.description.type.TypeDescription$Generic r1 = r1.delegate
                    net.bytebuddy.description.type.TypeDescription r1 = r1.asErasure()
                    goto L_0x0040
                L_0x0040:
                    r6 = r0
                    r0 = r6
                    if (r0 != 0) goto L_0x0050
                    r0 = r4
                    net.bytebuddy.description.type.TypeDescription r0 = r0.erasure
                    net.bytebuddy.description.type.TypeDescription r0 = (net.bytebuddy.description.type.TypeDescription) r0
                    r6 = r0
                    goto L_0x0057
                L_0x0050:
                    r0 = r6
                    r1 = r4
                    r2 = r1; r1 = r0; r0 = r2; 
                    r0.erasure = r1
                L_0x0057:
                    goto L_0x005a
                L_0x005a:
                    r0 = r6
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.type.TypeDescription.SuperTypeLoading.ClassLoadingTypeProjection.asErasure():net.bytebuddy.description.type.TypeDescription");
            }

            @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
            protected Generic resolve() {
                return this.delegate;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            @CachedReturnPlugin.Enhance("superClass")
            public Generic getSuperClass() {
                Generic generic;
                if (this.superClass != null) {
                    generic = null;
                } else {
                    Generic superClass = this.delegate.getSuperClass();
                    generic = superClass;
                    if (generic == null) {
                        generic = Generic.UNDEFINED;
                    } else {
                        try {
                            generic = new ClassLoadingTypeProjection(superClass, this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader).getClassLoader(), this.classLoadingDelegate);
                        } catch (ClassNotFoundException e) {
                        }
                    }
                }
                if (generic == null) {
                    generic = this.superClass;
                } else {
                    this.superClass = generic;
                }
                return generic;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            @CachedReturnPlugin.Enhance("interfaces")
            public TypeList.Generic getInterfaces() {
                TypeList.Generic interfaces;
                if (this.interfaces != null) {
                    interfaces = null;
                } else {
                    interfaces = this.delegate.getInterfaces();
                    try {
                        interfaces = new ClassLoadingTypeList(interfaces, this.classLoadingDelegate.load(this.delegate.asErasure().getName(), this.classLoader).getClassLoader(), this.classLoadingDelegate);
                    } catch (ClassNotFoundException e) {
                    }
                }
                if (interfaces == null) {
                    interfaces = this.interfaces;
                } else {
                    this.interfaces = interfaces;
                }
                return interfaces;
            }

            @Override // java.lang.Iterable
            public Iterator<TypeDefinition> iterator() {
                return new TypeDefinition.SuperClassIterator(this);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/TypeDescription$SuperTypeLoading$ClassLoadingTypeList.class */
        protected static class ClassLoadingTypeList extends TypeList.Generic.AbstractBase {
            private final TypeList.Generic delegate;
            private final ClassLoader classLoader;
            private final ClassLoadingDelegate classLoadingDelegate;

            protected ClassLoadingTypeList(TypeList.Generic delegate, ClassLoader classLoader, ClassLoadingDelegate classLoadingDelegate) {
                this.delegate = delegate;
                this.classLoader = classLoader;
                this.classLoadingDelegate = classLoadingDelegate;
            }

            @Override // java.util.AbstractList, java.util.List
            public Generic get(int index) {
                return new ClassLoadingTypeProjection((Generic) this.delegate.get(index), this.classLoader, this.classLoadingDelegate);
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return this.delegate.size();
            }
        }
    }
}
