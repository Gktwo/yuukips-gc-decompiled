package net.bytebuddy.description;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;

/* loaded from: grasscutter.jar:net/bytebuddy/description/ByteCodeElement.class */
public interface ByteCodeElement extends NamedElement.WithRuntimeName, NamedElement.WithDescriptor, ModifierReviewable, DeclaredByType, AnnotationSource {

    /* loaded from: grasscutter.jar:net/bytebuddy/description/ByteCodeElement$TypeDependant.class */
    public interface TypeDependant<T extends TypeDependant<?, S>, S extends Token<S>> {
        T asDefined();

        S asToken(ElementMatcher<? super TypeDescription> elementMatcher);
    }

    boolean isVisibleTo(TypeDescription typeDescription);

    boolean isAccessibleTo(TypeDescription typeDescription);

    /* loaded from: grasscutter.jar:net/bytebuddy/description/ByteCodeElement$Token.class */
    public interface Token<T extends Token<T>> {
        T accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor);

        /* loaded from: grasscutter.jar:net/bytebuddy/description/ByteCodeElement$Token$TokenList.class */
        public static class TokenList<S extends Token<S>> extends FilterableList.AbstractBase<S, TokenList<S>> {
            private final List<? extends S> tokens;

            public TokenList(S... token) {
                this(Arrays.asList(token));
            }

            public TokenList(List<? extends S> tokens) {
                this.tokens = tokens;
            }

            public TokenList<S> accept(TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
                ArrayList arrayList = new ArrayList(this.tokens.size());
                Iterator<? extends S> it = this.tokens.iterator();
                while (it.hasNext()) {
                    arrayList.add(((Token) it.next()).accept(visitor));
                }
                return new TokenList<>(arrayList);
            }

            /* access modifiers changed from: protected */
            @Override // net.bytebuddy.matcher.FilterableList.AbstractBase
            public TokenList<S> wrap(List<S> values) {
                return new TokenList<>(values);
            }

            @Override // java.util.AbstractList, java.util.List
            public S get(int index) {
                return (S) ((Token) this.tokens.get(index));
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return this.tokens.size();
            }
        }
    }
}
