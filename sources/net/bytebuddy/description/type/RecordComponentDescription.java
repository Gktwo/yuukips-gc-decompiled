package net.bytebuddy.description.type;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.util.Collections;
import java.util.List;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.DeclaredByType;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.jar.asm.signature.SignatureWriter;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription.class */
public interface RecordComponentDescription extends DeclaredByType, NamedElement.WithDescriptor, AnnotationSource, ByteCodeElement.TypeDependant<InDefinedShape, Token> {

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$InGenericShape.class */
    public interface InGenericShape extends RecordComponentDescription {
        @Override // net.bytebuddy.description.type.RecordComponentDescription, net.bytebuddy.description.type.RecordComponentDescription.InDefinedShape
        MethodDescription.InGenericShape getAccessor();
    }

    TypeDescription.Generic getType();

    @Override // net.bytebuddy.description.type.RecordComponentDescription.InDefinedShape
    MethodDescription getAccessor();

    @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
    Token asToken(ElementMatcher<? super TypeDescription> elementMatcher);

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$InDefinedShape.class */
    public interface InDefinedShape extends RecordComponentDescription {
        MethodDescription.InDefinedShape getAccessor();

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        TypeDescription getDeclaringType();

        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$InDefinedShape$AbstractBase.class */
        public static abstract class AbstractBase extends AbstractBase implements InDefinedShape {
            @Override // net.bytebuddy.description.type.RecordComponentDescription, net.bytebuddy.description.type.RecordComponentDescription.InDefinedShape
            public MethodDescription.InDefinedShape getAccessor() {
                return (MethodDescription.InDefinedShape) getDeclaringType().getDeclaredMethods().filter(ElementMatchers.named(getActualName())).getOnly();
            }

            @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
            public InDefinedShape asDefined() {
                return this;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$AbstractBase.class */
    public static abstract class AbstractBase implements RecordComponentDescription {
        @Override // net.bytebuddy.description.type.RecordComponentDescription, net.bytebuddy.description.ByteCodeElement.TypeDependant
        public Token asToken(ElementMatcher<? super TypeDescription> matcher) {
            return new Token(getActualName(), (TypeDescription.Generic) getType().accept(new TypeDescription.Generic.Visitor.Substitutor.ForDetachment(matcher)), getDeclaredAnnotations());
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getDescriptor() {
            return getType().asErasure().getDescriptor();
        }

        @Override // net.bytebuddy.description.NamedElement.WithDescriptor
        public String getGenericSignature() {
            TypeDescription.Generic recordComponentType = getType();
            try {
                return recordComponentType.getSort().isNonGeneric() ? NON_GENERIC_SIGNATURE : ((SignatureVisitor) recordComponentType.accept(new TypeDescription.Generic.Visitor.ForSignatureVisitor(new SignatureWriter()))).toString();
            } catch (GenericSignatureFormatError e) {
                return NON_GENERIC_SIGNATURE;
            }
        }

        public int hashCode() {
            return getActualName().hashCode();
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RecordComponentDescription)) {
                return false;
            }
            return getActualName().equals(((RecordComponentDescription) other).getActualName());
        }

        public String toString() {
            return getType().getTypeName() + " " + getActualName();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$ForLoadedRecordComponent.class */
    public static class ForLoadedRecordComponent extends InDefinedShape.AbstractBase {
        protected static final RecordComponent RECORD_COMPONENT = (RecordComponent) AccessController.doPrivileged(JavaDispatcher.m62of(RecordComponent.class));
        private final AnnotatedElement recordComponent;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.reflect.RecordComponent")
        /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$ForLoadedRecordComponent$RecordComponent.class */
        public interface RecordComponent {
            @JavaDispatcher.Instance
            boolean isInstance(Object obj);

            String getName(Object obj);

            Class<?> getDeclaringRecord(Object obj);

            Method getAccessor(Object obj);

            Class<?> getType(Object obj);

            Type getGenericType(Object obj);

            String getGenericSignature(Object obj);

            AnnotatedElement getAnnotatedType(Object obj);
        }

        /* access modifiers changed from: protected */
        public ForLoadedRecordComponent(AnnotatedElement recordComponent) {
            this.recordComponent = recordComponent;
        }

        /* renamed from: of */
        public static RecordComponentDescription m250of(Object recordComponent) {
            if (RECORD_COMPONENT.isInstance(recordComponent)) {
                return new ForLoadedRecordComponent((AnnotatedElement) recordComponent);
            }
            throw new IllegalArgumentException("Not a record component: " + recordComponent);
        }

        @Override // net.bytebuddy.description.type.RecordComponentDescription
        public TypeDescription.Generic getType() {
            return new TypeDescription.Generic.LazyProjection.OfRecordComponent(this.recordComponent);
        }

        @Override // net.bytebuddy.description.type.RecordComponentDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.type.RecordComponentDescription, net.bytebuddy.description.type.RecordComponentDescription.InDefinedShape
        public MethodDescription.InDefinedShape getAccessor() {
            return new MethodDescription.ForLoadedMethod(RECORD_COMPONENT.getAccessor(this.recordComponent));
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return TypeDescription.ForLoadedType.m247of(RECORD_COMPONENT.getDeclaringRecord(this.recordComponent));
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return RECORD_COMPONENT.getName(this.recordComponent);
        }

        @Override // net.bytebuddy.description.type.RecordComponentDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
        public String getGenericSignature() {
            return RECORD_COMPONENT.getGenericSignature(this.recordComponent);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.ForLoadedAnnotations(this.recordComponent.getDeclaredAnnotations());
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$Latent.class */
    public static class Latent extends InDefinedShape.AbstractBase {
        private final TypeDescription declaringType;
        private final String name;
        private final TypeDescription.Generic type;
        private final List<? extends AnnotationDescription> annotations;

        public Latent(TypeDescription declaringType, Token token) {
            this(declaringType, token.getName(), token.getType(), token.getAnnotations());
        }

        public Latent(TypeDescription declaringType, String name, TypeDescription.Generic type, List<? extends AnnotationDescription> annotations) {
            this.declaringType = declaringType;
            this.name = name;
            this.type = type;
            this.annotations = annotations;
        }

        @Override // net.bytebuddy.description.type.RecordComponentDescription
        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.type.accept(TypeDescription.Generic.Visitor.Substitutor.ForAttachment.m238of(this));
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDescription getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return this.name;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$TypeSubstituting.class */
    public static class TypeSubstituting extends AbstractBase implements InGenericShape {
        private final TypeDescription.Generic declaringType;
        private final RecordComponentDescription recordComponentDescription;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic declaringType, RecordComponentDescription recordComponentDescription, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringType = declaringType;
            this.recordComponentDescription = recordComponentDescription;
            this.visitor = visitor;
        }

        @Override // net.bytebuddy.description.type.RecordComponentDescription, net.bytebuddy.description.type.RecordComponentDescription.InDefinedShape
        public MethodDescription.InGenericShape getAccessor() {
            return (MethodDescription.InGenericShape) this.declaringType.getDeclaredMethods().filter(ElementMatchers.named(getActualName())).getOnly();
        }

        @Override // net.bytebuddy.description.type.RecordComponentDescription
        public TypeDescription.Generic getType() {
            return (TypeDescription.Generic) this.recordComponentDescription.getType().accept(this.visitor);
        }

        @Override // net.bytebuddy.description.ByteCodeElement.TypeDependant
        public InDefinedShape asDefined() {
            return this.recordComponentDescription.asDefined();
        }

        @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
        public TypeDefinition getDeclaringType() {
            return this.declaringType;
        }

        @Override // net.bytebuddy.description.NamedElement
        public String getActualName() {
            return this.recordComponentDescription.getActualName();
        }

        @Override // net.bytebuddy.description.annotation.AnnotationSource
        public AnnotationList getDeclaredAnnotations() {
            return this.recordComponentDescription.getDeclaredAnnotations();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/type/RecordComponentDescription$Token.class */
    public static class Token implements ByteCodeElement.Token<Token> {
        private final String name;
        private final TypeDescription.Generic type;
        private final List<? extends AnnotationDescription> annotations;
        private transient /* synthetic */ int hashCode;

        public Token(String name, TypeDescription.Generic type) {
            this(name, type, Collections.emptyList());
        }

        public Token(String name, TypeDescription.Generic type, List<? extends AnnotationDescription> annotations) {
            this.name = name;
            this.type = type;
            this.annotations = annotations;
        }

        public String getName() {
            return this.name;
        }

        public TypeDescription.Generic getType() {
            return this.type;
        }

        public AnnotationList getAnnotations() {
            return new AnnotationList.Explicit(this.annotations);
        }

        @Override // net.bytebuddy.description.ByteCodeElement.Token
        public Token accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            return new Token(this.name, (TypeDescription.Generic) this.type.accept(visitor), this.annotations);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int hashCode = this.hashCode != 0 ? 0 : (31 * ((31 * this.name.hashCode()) + this.type.hashCode())) + this.annotations.hashCode();
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
            return this.name.equals(token.name) && this.type.equals(token.type) && this.annotations.equals(token.annotations);
        }
    }
}
