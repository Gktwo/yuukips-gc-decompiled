package net.bytebuddy.description.method;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.util.AbstractList;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription.class */
public interface ParameterDescription extends AnnotationSource, NamedElement.WithRuntimeName, NamedElement.WithOptionalName, ModifierReviewable.ForParameterDescription, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final String NAME_PREFIX = "arg";

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$InGenericShape.class */
    public interface InGenericShape extends ParameterDescription {
        @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
        MethodDescription.InGenericShape getDeclaringMethod();
    }

    TypeDescription.Generic getType();

    @Override // net.bytebuddy.description.method.ParameterDescription.InDefinedShape
    MethodDescription getDeclaringMethod();

    int getIndex();

    boolean hasModifiers();

    int getOffset();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$InDefinedShape.class */
    public interface InDefinedShape extends ParameterDescription {
        MethodDescription.InDefinedShape getDeclaringMethod();

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$InDefinedShape$AbstractBase.class */
        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
            public InDefinedShape asDefined() {
                return this;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$AbstractBase.class */
    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements ParameterDescription {
        private transient /* synthetic */ int hashCode;

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return ParameterDescription.NAME_PREFIX.concat(String.valueOf(getIndex()));
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return getName();
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return isNamed() ? getName() : "";
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return 0;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public int getOffset() {
            int offset;
            TypeList parameterType = getDeclaringMethod().getParameters().asTypeList().asErasures();
            if (getDeclaringMethod().isStatic()) {
                offset = StackSize.ZERO.getSize();
            } else {
                offset = StackSize.SINGLE.getSize();
            }
            for (int i = 0; i < getIndex(); i++) {
                offset += ((TypeDescription) parameterType.get(i)).getStackSize().getSize();
            }
            return offset;
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public Token asToken(ElementMatcher<? super TypeDescription> matcher) {
            return new Token((TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)), getDeclaredAnnotations(), isNamed() ? getName() : Token.NO_NAME, hasModifiers() ? Integer.valueOf(getModifiers()) : Token.NO_MODIFIERS);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : getDeclaringMethod().hashCode() ^ getIndex();
            if (hashCode == 0) {
                hashCode = this.hashCode;
            } else {
                this.hashCode = hashCode;
            }
            return hashCode;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ParameterDescription)) {
                return false;
            }
            ParameterDescription parameterDescription = (ParameterDescription) other;
            return getDeclaringMethod().equals(parameterDescription.getDeclaringMethod()) && getIndex() == parameterDescription.getIndex();
        }

        public String toString() {
            String str;
            StringBuilder stringBuilder = new StringBuilder(Modifier.toString(getModifiers()));
            if (getModifiers() != 0) {
                stringBuilder.append(' ');
            }
            if (isVarArgs()) {
                str = getType().asErasure().getName().replaceFirst("\\[]$", "...");
            } else {
                str = getType().asErasure().getName();
            }
            stringBuilder.append(str);
            return stringBuilder.append(' ').append(getName()).toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter.class */
    public static abstract class ForLoadedParameter<T extends AccessibleObject> extends InDefinedShape.AbstractBase {
        private static final Parameter PARAMETER = (Parameter) AccessController.doPrivileged(JavaDispatcher.m62of(Parameter.class));
        protected final T executable;
        protected final int index;
        protected final ParameterAnnotationSource parameterAnnotationSource;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.reflect.Parameter")
        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$Parameter.class */
        public interface Parameter {
            int getModifiers(Object obj);

            boolean isNamePresent(Object obj);

            String getName(Object obj);
        }

        protected ForLoadedParameter(T executable, int index, ParameterAnnotationSource parameterAnnotationSource) {
            this.executable = executable;
            this.index = index;
            this.parameterAnnotationSource = parameterAnnotationSource;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return PARAMETER.getName(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public int getIndex() {
            return this.index;
        }

        @Override // net.bytebuddy.description.NamedElement.WithOptionalName
        public boolean isNamed() {
            return PARAMETER.isNamePresent(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return PARAMETER.getModifiers(ParameterList.ForLoadedExecutable.EXECUTABLE.getParameters(this.executable)[this.index]);
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public boolean hasModifiers() {
            return isNamed() || getModifiers() != 0;
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$ParameterAnnotationSource.class */
        public interface ParameterAnnotationSource {
            Annotation[][] getParameterAnnotations();

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$ParameterAnnotationSource$ForLoadedConstructor.class */
            public static class ForLoadedConstructor implements ParameterAnnotationSource {
                private final Constructor<?> constructor;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.constructor.equals(((ForLoadedConstructor) obj).constructor);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.constructor.hashCode();
                }

                public ForLoadedConstructor(Constructor<?> constructor) {
                    this.constructor = constructor;
                }

                @Override // net.bytebuddy.description.method.ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
                public Annotation[][] getParameterAnnotations() {
                    return this.constructor.getParameterAnnotations();
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$ParameterAnnotationSource$ForLoadedMethod.class */
            public static class ForLoadedMethod implements ParameterAnnotationSource {
                private final Method method;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.method.equals(((ForLoadedMethod) obj).method);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.method.hashCode();
                }

                public ForLoadedMethod(Method method) {
                    this.method = method;
                }

                @Override // net.bytebuddy.description.method.ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
                public Annotation[][] getParameterAnnotations() {
                    return this.method.getParameterAnnotations();
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$OfMethod.class */
        protected static class OfMethod extends ForLoadedParameter<Method> {
            /* access modifiers changed from: protected */
            public OfMethod(Method method, int index, ParameterAnnotationSource parameterAnnotationSource) {
                super(method, index, parameterAnnotationSource);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
            @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedMethod((Method) this.executable);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(((Method) this.executable).getParameterTypes()[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfMethodParameter((Method) this.executable, this.index, ((Method) this.executable).getParameterTypes());
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$OfConstructor.class */
        protected static class OfConstructor extends ForLoadedParameter<Constructor<?>> {
            /* access modifiers changed from: protected */
            public OfConstructor(Constructor<?> constructor, int index, ParameterAnnotationSource parameterAnnotationSource) {
                super(constructor, index, parameterAnnotationSource);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
            @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedConstructor((Constructor) this.executable);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(((Constructor) this.executable).getParameterTypes()[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfConstructorParameter((Constructor) this.executable, this.index, ((Constructor) this.executable).getParameterTypes());
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            @SuppressFBWarnings(value = {"BC_UNCONFIRMED_CAST"}, justification = "The implicit field type casting is not understood by Findbugs")
            public AnnotationList getDeclaredAnnotations() {
                Annotation[][] annotation = this.parameterAnnotationSource.getParameterAnnotations();
                MethodDescription.InDefinedShape declaringMethod = getDeclaringMethod();
                if (annotation.length == declaringMethod.getParameters().size() || !declaringMethod.getDeclaringType().isInnerClass()) {
                    return new AnnotationList.ForLoadedAnnotations(annotation[this.index]);
                }
                return this.index == 0 ? new AnnotationList.Empty() : new AnnotationList.ForLoadedAnnotations(annotation[this.index - 1]);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$OfLegacyVmMethod.class */
        protected static class OfLegacyVmMethod extends InDefinedShape.AbstractBase {
            private final Method method;
            private final int index;
            private final Class<?>[] parameterType;
            private final ParameterAnnotationSource parameterAnnotationSource;

            /* access modifiers changed from: protected */
            public OfLegacyVmMethod(Method method, int index, Class<?>[] parameterType, ParameterAnnotationSource parameterAnnotationSource) {
                this.method = method;
                this.index = index;
                this.parameterType = parameterType;
                this.parameterAnnotationSource = parameterAnnotationSource;
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(this.parameterType[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfMethodParameter(this.method, this.index, this.parameterType);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedMethod(this.method);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            public int getIndex() {
                return this.index;
            }

            @Override // net.bytebuddy.description.NamedElement.WithOptionalName
            public boolean isNamed() {
                return false;
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            public boolean hasModifiers() {
                return false;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.ForLoadedAnnotations(this.parameterAnnotationSource.getParameterAnnotations()[this.index]);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$ForLoadedParameter$OfLegacyVmConstructor.class */
        protected static class OfLegacyVmConstructor extends InDefinedShape.AbstractBase {
            private final Constructor<?> constructor;
            private final int index;
            private final Class<?>[] parameterType;
            private final ParameterAnnotationSource parameterAnnotationSource;

            /* access modifiers changed from: protected */
            public OfLegacyVmConstructor(Constructor<?> constructor, int index, Class<?>[] parameterType, ParameterAnnotationSource parameterAnnotationSource) {
                this.constructor = constructor;
                this.index = index;
                this.parameterType = parameterType;
                this.parameterAnnotationSource = parameterAnnotationSource;
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            public TypeDescription.Generic getType() {
                if (TypeDescription.AbstractBase.RAW_TYPES) {
                    return TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(this.parameterType[this.index]);
                }
                return new TypeDescription.Generic.LazyProjection.OfConstructorParameter(this.constructor, this.index, this.parameterType);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
            public MethodDescription.InDefinedShape getDeclaringMethod() {
                return new MethodDescription.ForLoadedConstructor(this.constructor);
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            public int getIndex() {
                return this.index;
            }

            @Override // net.bytebuddy.description.NamedElement.WithOptionalName
            public boolean isNamed() {
                return false;
            }

            @Override // net.bytebuddy.description.method.ParameterDescription
            public boolean hasModifiers() {
                return false;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                MethodDescription.InDefinedShape declaringMethod = getDeclaringMethod();
                Annotation[][] parameterAnnotation = this.parameterAnnotationSource.getParameterAnnotations();
                if (parameterAnnotation.length == declaringMethod.getParameters().size() || !declaringMethod.getDeclaringType().isInnerClass()) {
                    return new AnnotationList.ForLoadedAnnotations(parameterAnnotation[this.index]);
                }
                return this.index == 0 ? new AnnotationList.Empty() : new AnnotationList.ForLoadedAnnotations(parameterAnnotation[this.index - 1]);
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$Latent.class */
    public static class Latent extends InDefinedShape.AbstractBase {
        private final MethodDescription.InDefinedShape declaringMethod;
        private final TypeDescription.Generic parameterType;
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final String name;
        private final Integer modifiers;
        private final int index;
        private final int offset;

        public Latent(MethodDescription.InDefinedShape declaringMethod, Token token, int index, int offset) {
            this(declaringMethod, token.getType(), token.getAnnotations(), token.getName(), token.getModifiers(), index, offset);
        }

        public Latent(MethodDescription.InDefinedShape declaringMethod, TypeDescription.Generic parameterType, int index, int offset) {
            this(declaringMethod, parameterType, Collections.emptyList(), Token.NO_NAME, Token.NO_MODIFIERS, index, offset);
        }

        public Latent(MethodDescription.InDefinedShape declaringMethod, TypeDescription.Generic parameterType, List<? extends AnnotationDescription> declaredAnnotations, String name, Integer modifiers, int index, int offset) {
            this.declaringMethod = declaringMethod;
            this.parameterType = parameterType;
            this.declaredAnnotations = declaredAnnotations;
            this.name = name;
            this.modifiers = modifiers;
            this.index = index;
            this.offset = offset;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.parameterType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.m239of(this));
        }

        @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
        public MethodDescription.InDefinedShape getDeclaringMethod() {
            return this.declaringMethod;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public int getIndex() {
            return this.index;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.method.ParameterDescription
        public int getOffset() {
            return this.offset;
        }

        @Override // net.bytebuddy.description.NamedElement.WithOptionalName
        public boolean isNamed() {
            return this.name != null;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public boolean hasModifiers() {
            return this.modifiers != null;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return isNamed() ? this.name : getName();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            if (hasModifiers()) {
                return this.modifiers.intValue();
            }
            return getModifiers();
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$TypeSubstituting.class */
    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final MethodDescription.InGenericShape declaringMethod;
        private final ParameterDescription parameterDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(MethodDescription.InGenericShape declaringMethod, ParameterDescription parameterDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringMethod = declaringMethod;
            this.parameterDescription = parameterDescription;
            this.visitor = visitor;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.parameterDescription.getType().accept(this.visitor);
        }

        @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
        public MethodDescription.InGenericShape getDeclaringMethod() {
            return this.declaringMethod;
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public int getIndex() {
            return this.parameterDescription.getIndex();
        }

        @Override // net.bytebuddy.description.NamedElement.WithOptionalName
        public boolean isNamed() {
            return this.parameterDescription.isNamed();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription
        public boolean hasModifiers() {
            return this.parameterDescription.hasModifiers();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.method.ParameterDescription
        public int getOffset() {
            return this.parameterDescription.getOffset();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.parameterDescription.getName();
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.parameterDescription.getModifiers();
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.parameterDescription.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public InDefinedShape asDefined() {
            return this.parameterDescription.asDefined();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$Token.class */
    public static class Token implements ByteCodeElement.Token<Token> {
        public static final String NO_NAME = null;
        public static final Integer NO_MODIFIERS = null;
        private final TypeDescription.Generic type;
        private final List<? extends AnnotationDescription> annotations;
        private final String name;
        private final Integer modifiers;
        private transient /* synthetic */ int hashCode;

        public Token(TypeDescription.Generic type) {
            this(type, Collections.emptyList());
        }

        public Token(TypeDescription.Generic type, List<? extends AnnotationDescription> annotations) {
            this(type, annotations, NO_NAME, NO_MODIFIERS);
        }

        public Token(TypeDescription.Generic type, String name, Integer modifiers) {
            this(type, Collections.emptyList(), name, modifiers);
        }

        public Token(TypeDescription.Generic type, List<? extends AnnotationDescription> annotations, String name, Integer modifiers) {
            this.type = type;
            this.annotations = annotations;
            this.name = name;
            this.modifiers = modifiers;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public String getName() {
            return this.name;
        }

        public Integer getModifiers() {
            return this.modifiers;
        }

        @Override // net.bytebuddy.description.ByteCodeElement.Token
        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token((TypeDescription.Generic) this.type.accept(visitor), this.annotations, this.name, this.modifiers);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                i = (31 * ((31 * ((31 * this.type.hashCode()) + this.annotations.hashCode())) + (this.name != null ? this.name.hashCode() : 0))) + (this.modifiers != null ? this.modifiers.hashCode() : 0);
            }
            if (i == 0) {
                i = this.hashCode;
            } else {
                this.hashCode = i;
            }
            return i;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Token)) {
                return false;
            }
            Token token = (Token) other;
            return this.type.equals(token.type) && this.annotations.equals(token.annotations) && (this.name == null ? token.name == null : this.name.equals(token.name)) && (this.modifiers == null ? token.modifiers == null : this.modifiers.equals(token.modifiers));
        }

        public String toString() {
            return "ParameterDescription.Token{type=" + this.type + ", annotations=" + this.annotations + ", name='" + this.name + "', modifiers=" + this.modifiers + '}';
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterDescription$Token$TypeList.class */
        public static class TypeList extends AbstractList<Token> {
            private final List<? extends TypeDefinition> typeDescriptions;

            public TypeList(List<? extends TypeDefinition> typeDescriptions) {
                this.typeDescriptions = typeDescriptions;
            }

            @Override // java.util.AbstractList, java.util.List
            public Token get(int index) {
                return new Token(((TypeDefinition) this.typeDescriptions.get(index)).asGenericType());
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return this.typeDescriptions.size();
            }
        }
    }
}
