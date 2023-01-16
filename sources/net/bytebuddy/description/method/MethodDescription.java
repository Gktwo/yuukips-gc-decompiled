package net.bytebuddy.description.method;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.modifier.ModifierContributor;
import net.bytebuddy.description.modifier.Visibility;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.quartz.jobs.NativeJob;

/* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription.class */
public interface MethodDescription extends TypeVariableSource, ModifierReviewable.ForMethodDescription, NamedElement.WithGenericName, ByteCodeElement, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final String CONSTRUCTOR_INTERNAL_NAME = "<init>";
    public static final String TYPE_INITIALIZER_INTERNAL_NAME = "<clinit>";
    public static final int TYPE_INITIALIZER_MODIFIER = 8;
    public static final InDefinedShape UNDEFINED = null;

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$InGenericShape.class */
    public interface InGenericShape extends MethodDescription {
        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        TypeDescription.Generic getDeclaringType();

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        ParameterList<ParameterDescription.InGenericShape> getParameters();
    }

    TypeDescription.Generic getReturnType();

    @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape
    ParameterList<?> getParameters();

    TypeList.Generic getExceptionTypes();

    int getActualModifiers();

    int getActualModifiers(boolean z);

    int getActualModifiers(boolean z, Visibility visibility);

    boolean isConstructor();

    boolean isMethod();

    boolean isTypeInitializer();

    boolean represents(Method method);

    boolean represents(Constructor<?> constructor);

    boolean isVirtual();

    int getStackSize();

    boolean isDefaultMethod();

    boolean isSpecializableFor(TypeDescription typeDescription);

    AnnotationValue<?, ?> getDefaultValue();

    <T> T getDefaultValue(Class<T> cls);

    boolean isInvokableOn(TypeDescription typeDescription);

    boolean isInvokeBootstrap();

    boolean isInvokeBootstrap(List<? extends TypeDefinition> list);

    boolean isConstantBootstrap();

    boolean isConstantBootstrap(List<? extends TypeDefinition> list);

    boolean isDefaultValue();

    boolean isDefaultValue(AnnotationValue<?, ?> annotationValue);

    TypeDescription.Generic getReceiverType();

    SignatureToken asSignatureToken();

    TypeToken asTypeToken();

    boolean isBridgeCompatible(TypeToken typeToken);

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$InDefinedShape.class */
    public interface InDefinedShape extends MethodDescription {
        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        TypeDescription getDeclaringType();

        ParameterList<ParameterDescription.InDefinedShape> getParameters();

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$InDefinedShape$AbstractBase.class */
        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {

            /* access modifiers changed from: protected */
            @JavaDispatcher.Proxied("java.lang.reflect.Executable")
            /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$InDefinedShape$AbstractBase$Executable.class */
            public interface Executable {
                @JavaDispatcher.Defaults
                AnnotatedElement getAnnotatedReceiverType(Object obj);
            }

            @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
            public InDefinedShape asDefined() {
                return this;
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            public TypeDescription.Generic getReceiverType() {
                if (isStatic()) {
                    return TypeDescription.Generic.UNDEFINED;
                }
                if (!isConstructor()) {
                    return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.m242of(getDeclaringType());
                }
                TypeDescription declaringType = getDeclaringType();
                TypeDescription enclosingDeclaringType = getDeclaringType().getEnclosingType();
                if (enclosingDeclaringType == null) {
                    return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.m242of(declaringType);
                }
                if (declaringType.isStatic()) {
                    return enclosingDeclaringType.asGenericType();
                }
                return TypeDescription.Generic.OfParameterizedType.ForGenerifiedErasure.m242of(enclosingDeclaringType);
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$InDefinedShape$AbstractBase$ForLoadedExecutable.class */
            protected static abstract class ForLoadedExecutable<T extends AnnotatedElement> extends AbstractBase {
                protected static final Executable EXECUTABLE = (Executable) AccessController.doPrivileged(JavaDispatcher.m62of(Executable.class));
                protected final T executable;

                /* Return type fixed from 'net.bytebuddy.description.ByteCodeElement$TypeDependant' to match base method */
                @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.ByteCodeElement.TypeDependant
                public /* bridge */ /* synthetic */ InDefinedShape asDefined() {
                    return asDefined();
                }

                protected ForLoadedExecutable(T executable) {
                    this.executable = executable;
                }

                @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReceiverType() {
                    AnnotatedElement element = EXECUTABLE.getAnnotatedReceiverType(this.executable);
                    if (element == null) {
                        return getReceiverType();
                    }
                    return TypeDefinition.Sort.describeAnnotated(element);
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$AbstractBase.class */
    public static abstract class AbstractBase extends TypeVariableSource.AbstractBase implements MethodDescription {
        private static final int SOURCE_MODIFIERS = 1343;
        private transient /* synthetic */ int hashCode;

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getStackSize() {
            return getParameters().asTypeList().getStackSize() + (isStatic() ? 0 : 1);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isMethod() {
            return !isConstructor() && !isTypeInitializer();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return "<init>".equals(getInternalName());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return "<clinit>".equals(getInternalName());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean represents(Method method) {
            return equals(new ForLoadedMethod(method));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean represents(Constructor<?> constructor) {
            return equals(new ForLoadedConstructor(constructor));
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            if (isMethod()) {
                return getInternalName();
            }
            return getDeclaringType().asErasure().getName();
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return isMethod() ? getName() : "";
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            StringBuilder descriptor = new StringBuilder().append('(');
            for (TypeDescription parameterType : getParameters().asTypeList().asErasures()) {
                descriptor.append(parameterType.getDescriptor());
            }
            return descriptor.append(')').append(getReturnType().asErasure().getDescriptor()).toString();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getGenericSignature() {
            SignatureVisitor signatureVisitor;
            try {
                SignatureWriter signatureWriter = new SignatureWriter();
                boolean generic = false;
                for (TypeDescription.Generic typeVariable : getTypeVariables()) {
                    signatureWriter.visitFormalTypeParameter(typeVariable.getSymbol());
                    boolean classBound = true;
                    for (TypeDescription.Generic upperBound : typeVariable.getUpperBounds()) {
                        if (classBound) {
                            signatureVisitor = signatureWriter.visitClassBound();
                        } else {
                            signatureVisitor = signatureWriter.visitInterfaceBound();
                        }
                        upperBound.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureVisitor));
                        classBound = false;
                    }
                    generic = true;
                }
                for (TypeDescription.Generic parameterType : getParameters().asTypeList()) {
                    parameterType.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitParameterType()));
                    generic = generic || !parameterType.getSort().isNonGeneric();
                }
                TypeDescription.Generic returnType = getReturnType();
                returnType.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitReturnType()));
                boolean generic2 = generic || !returnType.getSort().isNonGeneric();
                TypeList.Generic<TypeDescription.Generic> exceptionTypes = getExceptionTypes();
                if (!exceptionTypes.filter(ElementMatchers.not(ElementMatchers.ofSort(TypeDefinition.Sort.NON_GENERIC))).isEmpty()) {
                    for (TypeDescription.Generic exceptionType : exceptionTypes) {
                        exceptionType.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(signatureWriter.visitExceptionType()));
                        generic2 = generic2 || !exceptionType.getSort().isNonGeneric();
                    }
                }
                return generic2 ? signatureWriter.toString() : NON_GENERIC_SIGNATURE;
            } catch (GenericSignatureFormatError e) {
                return NON_GENERIC_SIGNATURE;
            }
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getActualModifiers() {
            return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getActualModifiers(boolean manifest) {
            if (manifest) {
                return getActualModifiers() & -1281;
            }
            return (getActualModifiers() & -257) | 1024;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public int getActualModifiers(boolean manifest, Visibility visibility) {
            return ModifierContributor.Resolver.m255of(Collections.singleton(getVisibility().expandTo(visibility))).resolve(getActualModifiers(manifest));
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isVisibleTo(TypeDescription typeDescription) {
            return (isVirtual() || getDeclaringType().asErasure().isVisibleTo(typeDescription)) && (isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || ((isProtected() && getDeclaringType().asErasure().isAssignableFrom(typeDescription)) || ((!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure())))));
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isAccessibleTo(TypeDescription typeDescription) {
            return ((isVirtual() || getDeclaringType().asErasure().isVisibleTo(typeDescription)) && (isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || (!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())))) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure()));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isVirtual() {
            return !isConstructor() && !isPrivate() && !isStatic() && !isTypeInitializer();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isDefaultMethod() {
            return !isAbstract() && !isBridge() && getDeclaringType().isInterface();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isSpecializableFor(TypeDescription targetType) {
            if (isStatic()) {
                return false;
            }
            if (isPrivate() || isConstructor()) {
                return getDeclaringType().equals(targetType);
            }
            return !isAbstract() && getDeclaringType().asErasure().isAssignableFrom(targetType);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public <T> T getDefaultValue(Class<T> type) {
            return type.cast(getDefaultValue());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isInvokableOn(TypeDescription typeDescription) {
            return !isStatic() && !isTypeInitializer() && isVisibleTo(typeDescription) && (!isVirtual() ? getDeclaringType().asErasure().equals(typeDescription) : getDeclaringType().asErasure().isAssignableFrom(typeDescription));
        }

        private boolean isBootstrap(TypeDescription bootstrapped) {
            TypeList parameterTypes = getParameters().asTypeList().asErasures();
            switch (parameterTypes.size()) {
                case 0:
                    return false;
                case 1:
                    return parameterTypes.getOnly().represents(Object[].class);
                case 2:
                    return JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription) parameterTypes.get(0)) && ((TypeDescription) parameterTypes.get(1)).represents(Object[].class);
                case 3:
                    return JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription) parameterTypes.get(0)) && (((TypeDescription) parameterTypes.get(1)).represents(Object.class) || ((TypeDescription) parameterTypes.get(1)).represents(String.class)) && ((((TypeDescription) parameterTypes.get(2)).isArray() && ((TypeDescription) parameterTypes.get(2)).getComponentType().isAssignableFrom(bootstrapped)) || ((TypeDescription) parameterTypes.get(2)).isAssignableFrom(bootstrapped));
                default:
                    return JavaType.METHOD_HANDLES_LOOKUP.getTypeStub().isAssignableTo((TypeDescription) parameterTypes.get(0)) && (((TypeDescription) parameterTypes.get(1)).represents(Object.class) || ((TypeDescription) parameterTypes.get(1)).represents(String.class)) && ((TypeDescription) parameterTypes.get(2)).isAssignableFrom(bootstrapped);
            }
        }

        private boolean isBootstrapping(List<? extends TypeDefinition> arguments) {
            TypeList targets = getParameters().asTypeList().asErasures();
            if (targets.size() >= 4) {
                Iterator<TypeDescription> iterator = targets.subList(3, targets.size()).iterator();
                for (TypeDefinition type : arguments) {
                    if (!iterator.hasNext()) {
                        return false;
                    }
                    TypeDescription target = iterator.next();
                    if (!iterator.hasNext() && target.isArray()) {
                        return true;
                    }
                    if (!type.asErasure().isAssignableTo(target)) {
                        return false;
                    }
                }
                if (iterator.hasNext()) {
                    return iterator.next().isArray() && !iterator.hasNext();
                }
                return true;
            } else if (arguments.isEmpty()) {
                return true;
            } else {
                if (!((TypeDescription) targets.get(targets.size() - 1)).isArray()) {
                    return false;
                }
                for (TypeDefinition argument : arguments) {
                    if (!argument.asErasure().isAssignableTo(((TypeDescription) targets.get(targets.size() - 1)).getComponentType())) {
                        return false;
                    }
                }
                return true;
            }
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isInvokeBootstrap() {
            TypeDescription returnType = getReturnType().asErasure();
            if (isMethod()) {
                if (!isStatic()) {
                    return false;
                }
                if (!JavaType.CALL_SITE.getTypeStub().isAssignableFrom(returnType) && !JavaType.CALL_SITE.getTypeStub().isAssignableTo(returnType)) {
                    return false;
                }
            }
            if (!isConstructor() || JavaType.CALL_SITE.getTypeStub().isAssignableFrom(getDeclaringType().asErasure())) {
                return isBootstrap(JavaType.METHOD_TYPE.getTypeStub());
            }
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isInvokeBootstrap(List<? extends TypeDefinition> arguments) {
            return isInvokeBootstrap() && isBootstrapping(arguments);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isConstantBootstrap() {
            return isBootstrap(TypeDescription.CLASS);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isConstantBootstrap(List<? extends TypeDefinition> arguments) {
            return isConstantBootstrap() && isBootstrapping(arguments);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isDefaultValue() {
            return !isConstructor() && !isStatic() && getReturnType().asErasure().isAnnotationReturnType() && getParameters().isEmpty();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isDefaultValue(AnnotationValue<?, ?> annotationValue) {
            if (!isDefaultValue()) {
                return false;
            }
            TypeDescription returnType = getReturnType().asErasure();
            Object value = annotationValue.resolve();
            return (returnType.represents(Boolean.TYPE) && (value instanceof Boolean)) || (returnType.represents(Byte.TYPE) && (value instanceof Byte)) || ((returnType.represents(Character.TYPE) && (value instanceof Character)) || ((returnType.represents(Short.TYPE) && (value instanceof Short)) || ((returnType.represents(Integer.TYPE) && (value instanceof Integer)) || ((returnType.represents(Long.TYPE) && (value instanceof Long)) || ((returnType.represents(Float.TYPE) && (value instanceof Float)) || ((returnType.represents(Double.TYPE) && (value instanceof Double)) || ((returnType.represents(String.class) && (value instanceof String)) || ((returnType.isAssignableTo(Enum.class) && (value instanceof EnumerationDescription) && isEnumerationType(returnType, (EnumerationDescription) value)) || ((returnType.isAssignableTo(Annotation.class) && (value instanceof AnnotationDescription) && isAnnotationType(returnType, (AnnotationDescription) value)) || ((returnType.represents(Class.class) && (value instanceof TypeDescription)) || ((returnType.represents(boolean[].class) && (value instanceof boolean[])) || ((returnType.represents(byte[].class) && (value instanceof byte[])) || ((returnType.represents(char[].class) && (value instanceof char[])) || ((returnType.represents(short[].class) && (value instanceof short[])) || ((returnType.represents(int[].class) && (value instanceof int[])) || ((returnType.represents(long[].class) && (value instanceof long[])) || ((returnType.represents(float[].class) && (value instanceof float[])) || ((returnType.represents(double[].class) && (value instanceof double[])) || ((returnType.represents(String[].class) && (value instanceof String[])) || ((returnType.isAssignableTo(Enum[].class) && (value instanceof EnumerationDescription[]) && isEnumerationType(returnType.getComponentType(), (EnumerationDescription[]) value)) || ((returnType.isAssignableTo(Annotation[].class) && (value instanceof AnnotationDescription[]) && isAnnotationType(returnType.getComponentType(), (AnnotationDescription[]) value)) || (returnType.represents(Class[].class) && (value instanceof TypeDescription[])))))))))))))))))))))));
        }

        private static boolean isEnumerationType(TypeDescription enumerationType, EnumerationDescription... enumerationDescription) {
            for (EnumerationDescription anEnumerationDescription : enumerationDescription) {
                if (!anEnumerationDescription.getEnumerationType().equals(enumerationType)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean isAnnotationType(TypeDescription annotationType, AnnotationDescription... annotationDescription) {
            for (AnnotationDescription anAnnotationDescription : annotationDescription) {
                if (!anAnnotationDescription.getAnnotationType().equals(annotationType)) {
                    return false;
                }
            }
            return true;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeVariableSource getEnclosingSource() {
            return isStatic() ? TypeVariableSource.UNDEFINED : getDeclaringType().asErasure();
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public boolean isInferrable() {
            return true;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public <T> T accept(TypeVariableSource.Visitor<T> visitor) {
            return visitor.onMethod(asDefined());
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public boolean isGenerified() {
            return !getTypeVariables().isEmpty();
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public Token asToken(ElementMatcher<? super TypeDescription> matcher) {
            TypeDescription.Generic receiverType = getReceiverType();
            return new Token(getInternalName(), getModifiers(), getTypeVariables().asTokenList(matcher), (TypeDescription.Generic) getReturnType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)), getParameters().asTokenList(matcher), getExceptionTypes().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)), getDeclaredAnnotations(), getDefaultValue(), receiverType == null ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic) receiverType.accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)));
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public SignatureToken asSignatureToken() {
            return new SignatureToken(getInternalName(), getReturnType().asErasure(), getParameters().asTypeList().asErasures());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeToken asTypeToken() {
            return new TypeToken(getReturnType().asErasure(), getParameters().asTypeList().asErasures());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public boolean isBridgeCompatible(TypeToken typeToken) {
            List<TypeDescription> types = getParameters().asTypeList().asErasures();
            List<TypeDescription> bridgeTypes = typeToken.getParameterTypes();
            if (types.size() != bridgeTypes.size()) {
                return false;
            }
            for (int index = 0; index < types.size(); index++) {
                if (!types.get(index).equals(bridgeTypes.get(index)) && (types.get(index).isPrimitive() || bridgeTypes.get(index).isPrimitive())) {
                    return false;
                }
            }
            TypeDescription returnType = getReturnType().asErasure();
            TypeDescription bridgeReturnType = typeToken.getReturnType();
            return returnType.equals(bridgeReturnType) || (!returnType.isPrimitive() && !bridgeReturnType.isPrimitive());
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : (31 * ((31 * ((31 * (17 + getDeclaringType().hashCode())) + getInternalName().hashCode())) + getReturnType().asErasure().hashCode())) + getParameters().asTypeList().asErasures().hashCode();
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
            if (!(other instanceof MethodDescription)) {
                return false;
            }
            MethodDescription methodDescription = (MethodDescription) other;
            return getInternalName().equals(methodDescription.getInternalName()) && getDeclaringType().equals(methodDescription.getDeclaringType()) && getReturnType().asErasure().equals(methodDescription.getReturnType().asErasure()) && getParameters().asTypeList().asErasures().equals(methodDescription.getParameters().asTypeList().asErasures());
        }

        @Override // net.bytebuddy.description.NamedElement.WithGenericName
        public String toGenericString() {
            StringBuilder stringBuilder = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                stringBuilder.append(Modifier.toString(modifiers)).append(' ');
            }
            if (isMethod()) {
                stringBuilder.append(getReturnType().getActualName()).append(' ');
                stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
            }
            stringBuilder.append(getName()).append('(');
            boolean first = true;
            for (TypeDescription.Generic typeDescription : getParameters().asTypeList()) {
                if (!first) {
                    stringBuilder.append(',');
                } else {
                    first = false;
                }
                stringBuilder.append(typeDescription.getActualName());
            }
            stringBuilder.append(')');
            TypeList.Generic<TypeDescription.Generic> exceptionTypes = getExceptionTypes();
            if (!exceptionTypes.isEmpty()) {
                stringBuilder.append(" throws ");
                boolean first2 = true;
                for (TypeDescription.Generic typeDescription2 : exceptionTypes) {
                    if (!first2) {
                        stringBuilder.append(',');
                    } else {
                        first2 = false;
                    }
                    stringBuilder.append(typeDescription2.getActualName());
                }
            }
            return stringBuilder.toString();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            int modifiers = getModifiers() & SOURCE_MODIFIERS;
            if (modifiers != 0) {
                stringBuilder.append(Modifier.toString(modifiers)).append(' ');
            }
            if (isMethod()) {
                stringBuilder.append(getReturnType().asErasure().getActualName()).append(' ');
                stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
            }
            stringBuilder.append(getName()).append('(');
            boolean first = true;
            for (TypeDescription typeDescription : getParameters().asTypeList().asErasures()) {
                if (!first) {
                    stringBuilder.append(',');
                } else {
                    first = false;
                }
                stringBuilder.append(typeDescription.getActualName());
            }
            stringBuilder.append(')');
            TypeList<TypeDescription> exceptionTypes = getExceptionTypes().asErasures();
            if (!exceptionTypes.isEmpty()) {
                stringBuilder.append(" throws ");
                boolean first2 = true;
                for (TypeDescription typeDescription2 : exceptionTypes) {
                    if (!first2) {
                        stringBuilder.append(',');
                    } else {
                        first2 = false;
                    }
                    stringBuilder.append(typeDescription2.getActualName());
                }
            }
            return stringBuilder.toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$ForLoadedConstructor.class */
    public static class ForLoadedConstructor extends InDefinedShape.AbstractBase.ForLoadedExecutable<Constructor<?>> implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource {
        private transient /* synthetic */ ParameterList parameters;
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ Annotation[][] parameterAnnotations;

        @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase.ForLoadedExecutable, net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public /* bridge */ /* synthetic */ TypeDescription.Generic getReceiverType() {
            return getReceiverType();
        }

        public ForLoadedConstructor(Constructor<?> constructor) {
            super(constructor);
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.m247of(((Constructor) this.executable).getDeclaringClass());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return TypeDescription.Generic.VOID;
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        @CachedReturnPlugin.Enhance(NativeJob.PROP_PARAMETERS)
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            ParameterList<ParameterDescription.InDefinedShape> of = this.parameters != null ? null : ParameterList.ForLoadedExecutable.m258of((Constructor<?>) ((Constructor) this.executable), (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) this);
            if (of == null) {
                of = this.parameters;
            } else {
                this.parameters = of;
            }
            return of;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.OfConstructorExceptionTypes((Constructor) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return true;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Method method) {
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Constructor<?> constructor) {
            return ((Constructor) this.executable).equals(constructor) || equals(new ForLoadedConstructor(constructor));
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return ((Constructor) this.executable).getName();
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return ((Constructor) this.executable).getModifiers();
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public boolean isSynthetic() {
            return ((Constructor) this.executable).isSynthetic();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return "<init>";
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return Type.getConstructorDescriptor((Constructor) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public AnnotationValue<?, ?> getDefaultValue() {
            return AnnotationValue.UNDEFINED;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(((Constructor) this.executable).getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                forLoadedAnnotations = this.declaredAnnotations;
            } else {
                this.declaredAnnotations = forLoadedAnnotations;
            }
            return forLoadedAnnotations;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.m234of((GenericDeclaration) this.executable);
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
        @CachedReturnPlugin.Enhance("parameterAnnotations")
        public Annotation[][] getParameterAnnotations() {
            Annotation[][] parameterAnnotations = this.parameterAnnotations != null ? null : ((Constructor) this.executable).getParameterAnnotations();
            if (parameterAnnotations == null) {
                parameterAnnotations = this.parameterAnnotations;
            } else {
                this.parameterAnnotations = parameterAnnotations;
            }
            return parameterAnnotations;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$ForLoadedMethod.class */
    public static class ForLoadedMethod extends InDefinedShape.AbstractBase.ForLoadedExecutable<Method> implements ParameterDescription.ForLoadedParameter.ParameterAnnotationSource {
        private transient /* synthetic */ ParameterList parameters;
        private transient /* synthetic */ AnnotationList declaredAnnotations;
        private transient /* synthetic */ Annotation[][] parameterAnnotations;

        @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase.ForLoadedExecutable, net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public /* bridge */ /* synthetic */ TypeDescription.Generic getReceiverType() {
            return getReceiverType();
        }

        public ForLoadedMethod(Method method) {
            super(method);
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.m247of(((Method) this.executable).getDeclaringClass());
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(((Method) this.executable).getReturnType());
            }
            return new TypeDescription.Generic.LazyProjection.ForLoadedReturnType((Method) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        @CachedReturnPlugin.Enhance(NativeJob.PROP_PARAMETERS)
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            ParameterList<ParameterDescription.InDefinedShape> of = this.parameters != null ? null : ParameterList.ForLoadedExecutable.m256of((Method) this.executable, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) this);
            if (of == null) {
                of = this.parameters;
            } else {
                this.parameters = of;
            }
            return of;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return new TypeList.Generic.ForLoadedTypes(((Method) this.executable).getExceptionTypes());
            }
            return new TypeList.Generic.OfMethodExceptionTypes((Method) this.executable);
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return false;
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable.ForMethodDescription
        public boolean isBridge() {
            return ((Method) this.executable).isBridge();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Method method) {
            return ((Method) this.executable).equals(method) || equals(new ForLoadedMethod(method));
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean represents(Constructor<?> constructor) {
            return false;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return ((Method) this.executable).getName();
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return ((Method) this.executable).getModifiers();
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public boolean isSynthetic() {
            return ((Method) this.executable).isSynthetic();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return ((Method) this.executable).getName();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return Type.getMethodDescriptor((Method) this.executable);
        }

        public Method getLoadedMethod() {
            return (Method) this.executable;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(((Method) this.executable).getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                forLoadedAnnotations = this.declaredAnnotations;
            } else {
                this.declaredAnnotations = forLoadedAnnotations;
            }
            return forLoadedAnnotations;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public AnnotationValue<?, ?> getDefaultValue() {
            Object value = ((Method) this.executable).getDefaultValue();
            return value == null ? AnnotationValue.UNDEFINED : AnnotationDescription.ForLoadedAnnotation.asValue(value, ((Method) this.executable).getReturnType());
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return new TypeList.Generic.Empty();
            }
            return TypeList.Generic.ForLoadedTypes.OfTypeVariables.m234of((GenericDeclaration) this.executable);
        }

        @Override // net.bytebuddy.description.method.ParameterDescription.ForLoadedParameter.ParameterAnnotationSource
        @CachedReturnPlugin.Enhance("parameterAnnotations")
        public Annotation[][] getParameterAnnotations() {
            Annotation[][] parameterAnnotations = this.parameterAnnotations != null ? null : ((Method) this.executable).getParameterAnnotations();
            if (parameterAnnotations == null) {
                parameterAnnotations = this.parameterAnnotations;
            } else {
                this.parameterAnnotations = parameterAnnotations;
            }
            return parameterAnnotations;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$Latent.class */
    public static class Latent extends InDefinedShape.AbstractBase {
        private final TypeDescription declaringType;
        private final String internalName;
        private final int modifiers;
        private final List<? extends TypeVariableToken> typeVariables;
        private final TypeDescription.Generic returnType;
        private final List<? extends ParameterDescription.Token> parameterTokens;
        private final List<? extends TypeDescription.Generic> exceptionTypes;
        private final List<? extends AnnotationDescription> declaredAnnotations;
        private final AnnotationValue<?, ?> defaultValue;
        private final TypeDescription.Generic receiverType;

        public Latent(TypeDescription declaringType, Token token) {
            this(declaringType, token.getName(), token.getModifiers(), token.getTypeVariableTokens(), token.getReturnType(), token.getParameterTokens(), token.getExceptionTypes(), token.getAnnotations(), token.getDefaultValue(), token.getReceiverType());
        }

        public Latent(TypeDescription declaringType, String internalName, int modifiers, List<? extends TypeVariableToken> typeVariables, TypeDescription.Generic returnType, List<? extends ParameterDescription.Token> parameterTokens, List<? extends TypeDescription.Generic> exceptionTypes, List<? extends AnnotationDescription> declaredAnnotations, AnnotationValue<?, ?> defaultValue, TypeDescription.Generic receiverType) {
            this.declaringType = declaringType;
            this.internalName = internalName;
            this.modifiers = modifiers;
            this.typeVariables = typeVariables;
            this.returnType = returnType;
            this.parameterTokens = parameterTokens;
            this.exceptionTypes = exceptionTypes;
            this.declaredAnnotations = declaredAnnotations;
            this.defaultValue = defaultValue;
            this.receiverType = receiverType;
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return TypeList.Generic.ForDetachedTypes.attachVariables(this, this.typeVariables);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return (TypeDescription.Generic) this.returnType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.m240of(this));
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
            return new ParameterList.ForTokens(this, this.parameterTokens);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return TypeList.Generic.ForDetachedTypes.attach(this, this.exceptionTypes);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return this.internalName;
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.modifiers;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.defaultValue;
        }

        @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReceiverType() {
            if (this.receiverType == null) {
                return getReceiverType();
            }
            return (TypeDescription.Generic) this.receiverType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.m240of(this));
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$Latent$TypeInitializer.class */
        public static class TypeInitializer extends InDefinedShape.AbstractBase {
            private final TypeDescription typeDescription;

            public TypeInitializer(TypeDescription typeDescription) {
                this.typeDescription = typeDescription;
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            public TypeDescription.Generic getReturnType() {
                return TypeDescription.Generic.VOID;
            }

            @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
            public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                return new ParameterList.Empty();
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            public TypeList.Generic getExceptionTypes() {
                return new TypeList.Generic.Empty();
            }

            @Override // net.bytebuddy.description.method.MethodDescription
            public AnnotationValue<?, ?> getDefaultValue() {
                return AnnotationValue.UNDEFINED;
            }

            @Override // net.bytebuddy.description.TypeVariableSource
            public TypeList.Generic getTypeVariables() {
                return new TypeList.Generic.Empty();
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                return new AnnotationList.Empty();
            }

            @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
            public TypeDescription getDeclaringType() {
                return this.typeDescription;
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return 8;
            }

            @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
            public String getInternalName() {
                return "<clinit>";
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$TypeSubstituting.class */
    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final MethodDescription methodDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic declaringType, MethodDescription methodDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringType = declaringType;
            this.methodDescription = methodDescription;
            this.visitor = visitor;
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReturnType() {
            return (TypeDescription.Generic) this.methodDescription.getReturnType().accept(this.visitor);
        }

        @Override // net.bytebuddy.description.TypeVariableSource
        public TypeList.Generic getTypeVariables() {
            return this.methodDescription.getTypeVariables().accept(this.visitor).filter(ElementMatchers.ofSort(TypeDefinition.Sort.VARIABLE));
        }

        @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
        public ParameterList<ParameterDescription.InGenericShape> getParameters() {
            return new ParameterList.TypeSubstituting(this, this.methodDescription.getParameters(), this.visitor);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.ForDetachedTypes(this.methodDescription.getExceptionTypes(), this.visitor);
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public AnnotationValue<?, ?> getDefaultValue() {
            return this.methodDescription.getDefaultValue();
        }

        @Override // net.bytebuddy.description.method.MethodDescription
        public TypeDescription.Generic getReceiverType() {
            TypeDescription.Generic receiverType = this.methodDescription.getReceiverType();
            return receiverType == null ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic) receiverType.accept(this.visitor);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.methodDescription.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription.Generic getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.methodDescription.getModifiers();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return this.methodDescription.getInternalName();
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public InDefinedShape asDefined() {
            return this.methodDescription.asDefined();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isConstructor() {
            return this.methodDescription.isConstructor();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isMethod() {
            return this.methodDescription.isMethod();
        }

        @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.method.MethodDescription
        public boolean isTypeInitializer() {
            return this.methodDescription.isTypeInitializer();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$Token.class */
    public static class Token implements ByteCodeElement.Token<Token> {
        private final String name;
        private final int modifiers;
        private final List<? extends TypeVariableToken> typeVariableTokens;
        private final TypeDescription.Generic returnType;
        private final List<? extends ParameterDescription.Token> parameterTokens;
        private final List<? extends TypeDescription.Generic> exceptionTypes;
        private final List<? extends AnnotationDescription> annotations;
        private final AnnotationValue<?, ?> defaultValue;
        private final TypeDescription.Generic receiverType;
        private transient /* synthetic */ int hashCode;

        public Token(int modifiers) {
            this("<init>", modifiers, TypeDescription.Generic.VOID);
        }

        public Token(String name, int modifiers, TypeDescription.Generic returnType) {
            this(name, modifiers, returnType, Collections.emptyList());
        }

        public Token(String name, int modifiers, TypeDescription.Generic returnType, List<? extends TypeDescription.Generic> parameterTypes) {
            this(name, modifiers, Collections.emptyList(), returnType, new ParameterDescription.Token.TypeList(parameterTypes), Collections.emptyList(), Collections.emptyList(), AnnotationValue.UNDEFINED, TypeDescription.Generic.UNDEFINED);
        }

        public Token(String name, int modifiers, List<? extends TypeVariableToken> typeVariableTokens, TypeDescription.Generic returnType, List<? extends ParameterDescription.Token> parameterTokens, List<? extends TypeDescription.Generic> exceptionTypes, List<? extends AnnotationDescription> annotations, AnnotationValue<?, ?> defaultValue, TypeDescription.Generic receiverType) {
            this.name = name;
            this.modifiers = modifiers;
            this.typeVariableTokens = typeVariableTokens;
            this.returnType = returnType;
            this.parameterTokens = parameterTokens;
            this.exceptionTypes = exceptionTypes;
            this.annotations = annotations;
            this.defaultValue = defaultValue;
            this.receiverType = receiverType;
        }

        public String getName() {
            return this.name;
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public ByteCodeElement.Token.TokenList<TypeVariableToken> getTypeVariableTokens() {
            return new ByteCodeElement.Token.TokenList<>(this.typeVariableTokens);
        }

        public TypeDescription.Generic getReturnType() {
            return this.returnType;
        }

        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> getParameterTokens() {
            return new ByteCodeElement.Token.TokenList<>(this.parameterTokens);
        }

        public TypeList.Generic getExceptionTypes() {
            return new TypeList.Generic.Explicit(this.exceptionTypes);
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        public AnnotationValue<?, ?> getDefaultValue() {
            return this.defaultValue;
        }

        public TypeDescription.Generic getReceiverType() {
            return this.receiverType;
        }

        @Override // net.bytebuddy.description.ByteCodeElement.Token
        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token(this.name, this.modifiers, getTypeVariableTokens().accept(visitor), (TypeDescription.Generic) this.returnType.accept(visitor), getParameterTokens().accept(visitor), getExceptionTypes().accept(visitor), this.annotations, this.defaultValue, this.receiverType == null ? TypeDescription.Generic.UNDEFINED : (TypeDescription.Generic) this.receiverType.accept(visitor));
        }

        public SignatureToken asSignatureToken(TypeDescription declaringType) {
            TypeDescription.Generic.Visitor.Reducing reducing = new TypeDescription.Generic.Visitor.Reducing(declaringType, this.typeVariableTokens);
            ArrayList arrayList = new ArrayList(this.parameterTokens.size());
            for (ParameterDescription.Token parameter : this.parameterTokens) {
                arrayList.add(parameter.getType().accept(reducing));
            }
            return new SignatureToken(this.name, (TypeDescription) this.returnType.accept(reducing), arrayList);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                i = (31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * ((31 * this.name.hashCode()) + this.modifiers)) + this.typeVariableTokens.hashCode())) + this.returnType.hashCode())) + this.parameterTokens.hashCode())) + this.exceptionTypes.hashCode())) + this.annotations.hashCode())) + (this.defaultValue != null ? this.defaultValue.hashCode() : 0))) + (this.receiverType != null ? this.receiverType.hashCode() : 0);
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
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Token token = (Token) other;
            return this.modifiers == token.modifiers && this.name.equals(token.name) && this.typeVariableTokens.equals(token.typeVariableTokens) && this.returnType.equals(token.returnType) && this.parameterTokens.equals(token.parameterTokens) && this.exceptionTypes.equals(token.exceptionTypes) && this.annotations.equals(token.annotations) && (this.defaultValue == null ? token.defaultValue == null : this.defaultValue.equals(token.defaultValue)) && (this.receiverType == null ? token.receiverType == null : this.receiverType.equals(token.receiverType));
        }

        public String toString() {
            return "MethodDescription.Token{name='" + this.name + "', modifiers=" + this.modifiers + ", typeVariableTokens=" + this.typeVariableTokens + ", returnType=" + this.returnType + ", parameterTokens=" + this.parameterTokens + ", exceptionTypes=" + this.exceptionTypes + ", annotations=" + this.annotations + ", defaultValue=" + this.defaultValue + ", receiverType=" + this.receiverType + '}';
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$SignatureToken.class */
    public static class SignatureToken {
        private final String name;
        private final TypeDescription returnType;
        private final List<? extends TypeDescription> parameterTypes;
        private transient /* synthetic */ int hashCode;

        public SignatureToken(String name, TypeDescription returnType, TypeDescription... parameterType) {
            this(name, returnType, Arrays.asList(parameterType));
        }

        public SignatureToken(String name, TypeDescription returnType, List<? extends TypeDescription> parameterTypes) {
            this.name = name;
            this.returnType = returnType;
            this.parameterTypes = parameterTypes;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends net.bytebuddy.description.type.TypeDescription>, java.util.List<net.bytebuddy.description.type.TypeDescription> */
        public List<TypeDescription> getParameterTypes() {
            return this.parameterTypes;
        }

        public TypeToken asTypeToken() {
            return new TypeToken(this.returnType, this.parameterTypes);
        }

        public String getDescriptor() {
            StringBuilder stringBuilder = new StringBuilder().append('(');
            for (TypeDescription typeDescription : this.parameterTypes) {
                stringBuilder.append(typeDescription.getDescriptor());
            }
            return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : (31 * ((31 * this.name.hashCode()) + this.returnType.hashCode())) + this.parameterTypes.hashCode();
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
            if (!(other instanceof SignatureToken)) {
                return false;
            }
            SignatureToken signatureToken = (SignatureToken) other;
            return this.name.equals(signatureToken.name) && this.returnType.equals(signatureToken.returnType) && this.parameterTypes.equals(signatureToken.parameterTypes);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append(this.returnType).append(' ').append(this.name).append('(');
            boolean first = true;
            for (TypeDescription parameterType : this.parameterTypes) {
                if (first) {
                    first = false;
                } else {
                    stringBuilder.append(',');
                }
                stringBuilder.append(parameterType);
            }
            return stringBuilder.append(')').toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodDescription$TypeToken.class */
    public static class TypeToken {
        private final TypeDescription returnType;
        private final List<? extends TypeDescription> parameterTypes;
        private transient /* synthetic */ int hashCode;

        public TypeToken(TypeDescription returnType, List<? extends TypeDescription> parameterTypes) {
            this.returnType = returnType;
            this.parameterTypes = parameterTypes;
        }

        public TypeDescription getReturnType() {
            return this.returnType;
        }

        /* JADX DEBUG: Type inference failed for r0v1. Raw type applied. Possible types: java.util.List<? extends net.bytebuddy.description.type.TypeDescription>, java.util.List<net.bytebuddy.description.type.TypeDescription> */
        public List<TypeDescription> getParameterTypes() {
            return this.parameterTypes;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : (31 * this.returnType.hashCode()) + this.parameterTypes.hashCode();
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
            if (!(other instanceof TypeToken)) {
                return false;
            }
            TypeToken typeToken = (TypeToken) other;
            return this.returnType.equals(typeToken.returnType) && this.parameterTypes.equals(typeToken.parameterTypes);
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder().append('(');
            for (TypeDescription parameterType : this.parameterTypes) {
                stringBuilder.append(parameterType.getDescriptor());
            }
            return stringBuilder.append(')').append(this.returnType.getDescriptor()).toString();
        }
    }
}
