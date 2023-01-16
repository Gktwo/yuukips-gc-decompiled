package net.bytebuddy.description.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;

/* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList.class */
public interface MethodList<T extends MethodDescription> extends FilterableList<T, MethodList<T>> {
    ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);

    List<MethodDescription.SignatureToken> asSignatureTokenList();

    List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> elementMatcher, TypeDescription typeDescription);

    MethodList<MethodDescription.InDefinedShape> asDefined();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList$AbstractBase.class */
    public static abstract class AbstractBase<S extends MethodDescription> extends FilterableList.AbstractBase<S, MethodList<S>> implements MethodList<S> {
        /* access modifiers changed from: protected */
        @Override // net.bytebuddy.matcher.FilterableList.AbstractBase
        public MethodList<S> wrap(List<S> values) {
            return new Explicit(values);
        }

        @Override // net.bytebuddy.description.method.MethodList
        public ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> matcher) {
            List<MethodDescription.Token> tokens = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                tokens.add(((MethodDescription) it.next()).asToken(matcher));
            }
            return new ByteCodeElement.Token.TokenList<>(tokens);
        }

        @Override // net.bytebuddy.description.method.MethodList
        public List<MethodDescription.SignatureToken> asSignatureTokenList() {
            List<MethodDescription.SignatureToken> tokens = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                tokens.add(((MethodDescription) it.next()).asSignatureToken());
            }
            return tokens;
        }

        @Override // net.bytebuddy.description.method.MethodList
        public List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> matcher, TypeDescription typeDescription) {
            List<MethodDescription.SignatureToken> tokens = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                tokens.add(((MethodDescription) it.next()).asToken(matcher).asSignatureToken(typeDescription));
            }
            return tokens;
        }

        @Override // net.bytebuddy.description.method.MethodList
        public MethodList<MethodDescription.InDefinedShape> asDefined() {
            List<MethodDescription.InDefinedShape> declaredForms = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                declaredForms.add(((MethodDescription) it.next()).asDefined());
            }
            return new Explicit(declaredForms);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList$ForLoadedMethods.class */
    public static class ForLoadedMethods extends AbstractBase<MethodDescription.InDefinedShape> {
        private final List<? extends Method> methods;
        private final List<? extends Constructor<?>> constructors;

        public ForLoadedMethods(Class<?> type) {
            this(type.getDeclaredConstructors(), type.getDeclaredMethods());
        }

        public ForLoadedMethods(Constructor<?>[] constructor, Method[] method) {
            this(Arrays.asList(constructor), Arrays.asList(method));
        }

        public ForLoadedMethods(List<? extends Constructor<?>> constructors, List<? extends Method> methods) {
            this.constructors = constructors;
            this.methods = methods;
        }

        @Override // java.util.AbstractList, java.util.List
        public MethodDescription.InDefinedShape get(int index) {
            if (index < this.constructors.size()) {
                return new MethodDescription.ForLoadedConstructor((Constructor) this.constructors.get(index));
            }
            return new MethodDescription.ForLoadedMethod((Method) this.methods.get(index - this.constructors.size()));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.constructors.size() + this.methods.size();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList$Explicit.class */
    public static class Explicit<S extends MethodDescription> extends AbstractBase<S> {
        private final List<? extends S> methodDescriptions;

        public Explicit(S... methodDescription) {
            this(Arrays.asList(methodDescription));
        }

        public Explicit(List<? extends S> methodDescriptions) {
            this.methodDescriptions = methodDescriptions;
        }

        @Override // java.util.AbstractList, java.util.List
        public S get(int index) {
            return (S) ((MethodDescription) this.methodDescriptions.get(index));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.methodDescriptions.size();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList$ForTokens.class */
    public static class ForTokens extends AbstractBase<MethodDescription.InDefinedShape> {
        private final TypeDescription declaringType;
        private final List<? extends MethodDescription.Token> tokens;

        public ForTokens(TypeDescription declaringType, MethodDescription.Token... token) {
            this(declaringType, Arrays.asList(token));
        }

        public ForTokens(TypeDescription declaringType, List<? extends MethodDescription.Token> tokens) {
            this.declaringType = declaringType;
            this.tokens = tokens;
        }

        @Override // java.util.AbstractList, java.util.List
        public MethodDescription.InDefinedShape get(int index) {
            return new MethodDescription.Latent(this.declaringType, (MethodDescription.Token) this.tokens.get(index));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.tokens.size();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList$TypeSubstituting.class */
    public static class TypeSubstituting extends AbstractBase<MethodDescription.InGenericShape> {
        protected final TypeDescription.Generic declaringType;
        protected final List<? extends MethodDescription> methodDescriptions;
        protected final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(TypeDescription.Generic declaringType, List<? extends MethodDescription> methodDescriptions, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringType = declaringType;
            this.methodDescriptions = methodDescriptions;
            this.visitor = visitor;
        }

        @Override // java.util.AbstractList, java.util.List
        public MethodDescription.InGenericShape get(int index) {
            return new MethodDescription.TypeSubstituting(this.declaringType, (MethodDescription) this.methodDescriptions.get(index), this.visitor);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.methodDescriptions.size();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/MethodList$Empty.class */
    public static class Empty<S extends MethodDescription> extends FilterableList.Empty<S, MethodList<S>> implements MethodList<S> {
        @Override // net.bytebuddy.description.method.MethodList
        public ByteCodeElement.Token.TokenList<MethodDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> matcher) {
            return new ByteCodeElement.Token.TokenList<>(new MethodDescription.Token[0]);
        }

        @Override // net.bytebuddy.description.method.MethodList
        public List<MethodDescription.SignatureToken> asSignatureTokenList() {
            return Collections.emptyList();
        }

        @Override // net.bytebuddy.description.method.MethodList
        public List<MethodDescription.SignatureToken> asSignatureTokenList(ElementMatcher<? super TypeDescription> matcher, TypeDescription typeDescription) {
            return Collections.emptyList();
        }

        @Override // net.bytebuddy.description.method.MethodList
        public MethodList<MethodDescription.InDefinedShape> asDefined() {
            return this;
        }
    }
}
