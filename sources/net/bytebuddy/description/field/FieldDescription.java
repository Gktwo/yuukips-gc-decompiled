package net.bytebuddy.description.field;

import java.lang.reflect.Field;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeVariableToken;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription.class */
public interface FieldDescription extends ByteCodeElement, ModifierReviewable.ForFieldDescription, NamedElement.WithGenericName, ByteCodeElement.TypeDependant<InDefinedShape, Token> {
    public static final Object NO_DEFAULT_VALUE = null;

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$InGenericShape.class */
    public interface InGenericShape extends FieldDescription {
        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        TypeDescription.Generic getDeclaringType();
    }

    TypeDescription.Generic getType();

    int getActualModifiers();

    SignatureToken asSignatureToken();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$InDefinedShape.class */
    public interface InDefinedShape extends FieldDescription {
        TypeDescription getDeclaringType();

        /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$InDefinedShape$AbstractBase.class */
        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
            public InDefinedShape asDefined() {
                return this;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$AbstractBase.class */
    public static abstract class AbstractBase extends ModifierReviewable.AbstractBase implements FieldDescription {
        private transient /* synthetic */ int hashCode;

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getInternalName() {
            return getName();
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return getName();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return getType().asErasure().getDescriptor();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getGenericSignature() {
            TypeDescription.Generic fieldType = getType();
            try {
                return fieldType.getSort().isNonGeneric() ? NON_GENERIC_SIGNATURE : ((SignatureVisitor) fieldType.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(new SignatureWriter()))).toString();
            } catch (GenericSignatureFormatError e) {
                return NON_GENERIC_SIGNATURE;
            }
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isVisibleTo(TypeDescription typeDescription) {
            return getDeclaringType().asErasure().isVisibleTo(typeDescription) && (isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || ((isProtected() && getDeclaringType().asErasure().isAssignableFrom(typeDescription)) || ((!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure())))));
        }

        @Override // net.bytebuddy.description.ByteCodeElement
        public boolean isAccessibleTo(TypeDescription typeDescription) {
            return isPublic() || typeDescription.equals(getDeclaringType().asErasure()) || (!isPrivate() && typeDescription.isSamePackage(getDeclaringType().asErasure())) || (isPrivate() && typeDescription.isNestMateOf(getDeclaringType().asErasure()));
        }

        @Override // net.bytebuddy.description.field.FieldDescription
        public int getActualModifiers() {
            return getModifiers() | (getDeclaredAnnotations().isAnnotationPresent(Deprecated.class) ? 131072 : 0);
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public Token asToken(ElementMatcher<? super TypeDescription> matcher) {
            return new Token(getName(), getModifiers(), (TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)), getDeclaredAnnotations());
        }

        @Override // net.bytebuddy.description.field.FieldDescription
        public SignatureToken asSignatureToken() {
            return new SignatureToken(getInternalName(), getType().asErasure());
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : getDeclaringType().hashCode() + (31 * (17 + getName().hashCode()));
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
            if (!(other instanceof FieldDescription)) {
                return false;
            }
            FieldDescription fieldDescription = (FieldDescription) other;
            return getName().equals(fieldDescription.getName()) && getDeclaringType().equals(fieldDescription.getDeclaringType());
        }

        @Override // net.bytebuddy.description.NamedElement.WithGenericName
        public String toGenericString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (getModifiers() != 0) {
                stringBuilder.append(Modifier.toString(getModifiers())).append(' ');
            }
            stringBuilder.append(getType().getActualName()).append(' ');
            stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
            return stringBuilder.append(getName()).toString();
        }

        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            if (getModifiers() != 0) {
                stringBuilder.append(Modifier.toString(getModifiers())).append(' ');
            }
            stringBuilder.append(getType().asErasure().getActualName()).append(' ');
            stringBuilder.append(getDeclaringType().asErasure().getActualName()).append('.');
            return stringBuilder.append(getName()).toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$ForLoadedField.class */
    public static class ForLoadedField extends InDefinedShape.AbstractBase {
        private final Field field;
        private transient /* synthetic */ AnnotationList declaredAnnotations;

        public ForLoadedField(Field field) {
            this.field = field;
        }

        @Override // net.bytebuddy.description.field.FieldDescription
        public TypeDescription.Generic getType() {
            if (TypeDescription.AbstractBase.RAW_TYPES) {
                return TypeDescription.Generic.OfNonGenericType.ForLoadedType.m244of(this.field.getType());
            }
            return new TypeDescription.Generic.LazyProjection.ForLoadedFieldType(this.field);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        @CachedReturnPlugin.Enhance("declaredAnnotations")
        public AnnotationList getDeclaredAnnotations() {
            AnnotationList forLoadedAnnotations = this.declaredAnnotations != null ? null : new AnnotationList.ForLoadedAnnotations(this.field.getDeclaredAnnotations());
            if (forLoadedAnnotations == null) {
                forLoadedAnnotations = this.declaredAnnotations;
            } else {
                this.declaredAnnotations = forLoadedAnnotations;
            }
            return forLoadedAnnotations;
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.field.getName();
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.m247of(this.field.getDeclaringClass());
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.field.getModifiers();
        }

        @Override // net.bytebuddy.description.ModifierReviewable.AbstractBase, net.bytebuddy.description.ModifierReviewable
        public boolean isSynthetic() {
            return this.field.isSynthetic();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$Latent.class */
    public static class Latent extends InDefinedShape.AbstractBase {
        private final TypeDescription declaringType;
        private final String name;
        private final int modifiers;
        private final TypeDescription.Generic fieldType;
        private final List<? extends AnnotationDescription> declaredAnnotations;

        public Latent(TypeDescription declaringType, Token token) {
            this(declaringType, token.getName(), token.getModifiers(), token.getType(), token.getAnnotations());
        }

        public Latent(TypeDescription declaringType, String name, int modifiers, TypeDescription.Generic fieldType, List<? extends AnnotationDescription> declaredAnnotations) {
            this.declaringType = declaringType;
            this.name = name;
            this.modifiers = modifiers;
            this.fieldType = fieldType;
            this.declaredAnnotations = declaredAnnotations;
        }

        @Override // net.bytebuddy.description.field.FieldDescription
        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.fieldType.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.m241of(this));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.declaredAnnotations);
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.name;
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.modifiers;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$TypeSubstituting.class */
    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final FieldDescription fieldDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic declaringType, FieldDescription fieldDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringType = declaringType;
            this.fieldDescription = fieldDescription;
            this.visitor = visitor;
        }

        @Override // net.bytebuddy.description.field.FieldDescription
        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.fieldDescription.getType().accept(this.visitor);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.fieldDescription.getDeclaredAnnotations();
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription.Generic getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.description.ModifierReviewable
        public int getModifiers() {
            return this.fieldDescription.getModifiers();
        }

        @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
        public String getName() {
            return this.fieldDescription.getName();
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public InDefinedShape asDefined() {
            return this.fieldDescription.asDefined();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$Token.class */
    public static class Token implements ByteCodeElement.Token<Token> {
        private final String name;
        private final int modifiers;
        private final TypeDescription.Generic type;
        private final List<? extends AnnotationDescription> annotations;
        private transient /* synthetic */ int hashCode;

        public Token(String name, int modifiers, TypeDescription.Generic type) {
            this(name, modifiers, type, Collections.emptyList());
        }

        public Token(String name, int modifiers, TypeDescription.Generic type, List<? extends AnnotationDescription> annotations) {
            this.name = name;
            this.modifiers = modifiers;
            this.type = type;
            this.annotations = annotations;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        public int getModifiers() {
            return this.modifiers;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        @Override // net.bytebuddy.description.ByteCodeElement.Token
        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token(this.name, this.modifiers, (TypeDescription.Generic) this.type.accept(visitor), this.annotations);
        }

        public SignatureToken asSignatureToken(TypeDescription declaringType) {
            return new SignatureToken(this.name, (TypeDescription) this.type.accept(new TypeDescription.Generic.Visitor.Reducing(declaringType, new TypeVariableToken[0])));
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : (31 * ((31 * ((31 * this.name.hashCode()) + this.modifiers)) + this.type.hashCode())) + this.annotations.hashCode();
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
            if (other == null || getClass() != other.getClass()) {
                return false;
            }
            Token token = (Token) other;
            return this.modifiers == token.modifiers && this.name.equals(token.name) && this.type.equals(token.type) && this.annotations.equals(token.annotations);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/field/FieldDescription$SignatureToken.class */
    public static class SignatureToken {
        private final String name;
        private final TypeDescription type;
        private transient /* synthetic */ int hashCode;

        public SignatureToken(String name, TypeDescription type) {
            this.name = name;
            this.type = type;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription getType() {
            return this.type;
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : (31 * this.name.hashCode()) + this.type.hashCode();
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
            return this.name.equals(signatureToken.name) && this.type.equals(signatureToken.type);
        }

        public String toString() {
            return this.type + " " + this.name;
        }
    }
}
