package net.bytebuddy.description.method;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.FilterableList;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;

/* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList.class */
public interface ParameterList<T extends ParameterDescription> extends FilterableList<T, ParameterList<T>> {
    TypeList.Generic asTypeList();

    ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> elementMatcher);

    ParameterList<ParameterDescription.InDefinedShape> asDefined();

    boolean hasExplicitMetaData();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$AbstractBase.class */
    public static abstract class AbstractBase<S extends ParameterDescription> extends FilterableList.AbstractBase<S, ParameterList<S>> implements ParameterList<S> {
        /* JADX WARNING: Removed duplicated region for block: B:5:0x000e  */
        @Override // net.bytebuddy.description.method.ParameterList
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean hasExplicitMetaData() {
            /*
                r2 = this;
                r0 = r2
                java.util.Iterator r0 = r0.iterator()
                r3 = r0
            L_0x0005:
                r0 = r3
                boolean r0 = r0.hasNext()
                if (r0 == 0) goto L_0x002f
                r0 = r3
                java.lang.Object r0 = r0.next()
                net.bytebuddy.description.method.ParameterDescription r0 = (net.bytebuddy.description.method.ParameterDescription) r0
                r4 = r0
                r0 = r4
                boolean r0 = r0.isNamed()
                if (r0 == 0) goto L_0x002a
                r0 = r4
                boolean r0 = r0.hasModifiers()
                if (r0 != 0) goto L_0x002c
            L_0x002a:
                r0 = 0
                return r0
            L_0x002c:
                goto L_0x0005
            L_0x002f:
                r0 = 1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.method.ParameterList.AbstractBase.hasExplicitMetaData():boolean");
        }

        @Override // net.bytebuddy.description.method.ParameterList
        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> matcher) {
            List<ParameterDescription.Token> tokens = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                tokens.add(((ParameterDescription) it.next()).asToken(matcher));
            }
            return new ByteCodeElement.Token.TokenList<>(tokens);
        }

        @Override // net.bytebuddy.description.method.ParameterList
        public TypeList.Generic asTypeList() {
            List<TypeDescription.Generic> types = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                types.add(((ParameterDescription) it.next()).getType());
            }
            return new TypeList.Generic.Explicit(types);
        }

        @Override // net.bytebuddy.description.method.ParameterList
        public ParameterList<ParameterDescription.InDefinedShape> asDefined() {
            List<ParameterDescription.InDefinedShape> declaredForms = new ArrayList<>(size());
            Iterator it = iterator();
            while (it.hasNext()) {
                declaredForms.add(((ParameterDescription) it.next()).asDefined());
            }
            return new Explicit(declaredForms);
        }

        /* access modifiers changed from: protected */
        @Override // net.bytebuddy.matcher.FilterableList.AbstractBase
        public ParameterList<S> wrap(List<S> values) {
            return new Explicit(values);
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForLoadedExecutable.class */
    public static abstract class ForLoadedExecutable<T> extends AbstractBase<ParameterDescription.InDefinedShape> {
        protected static final Executable EXECUTABLE = (Executable) AccessController.doPrivileged(JavaDispatcher.m62of(Executable.class));
        protected final T executable;
        protected final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;

        /* access modifiers changed from: protected */
        @JavaDispatcher.Proxied("java.lang.reflect.Executable")
        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForLoadedExecutable$Executable.class */
        public interface Executable {
            @JavaDispatcher.Instance
            boolean isInstance(Object obj);

            int getParameterCount(Object obj);

            Object[] getParameters(Object obj);
        }

        protected ForLoadedExecutable(T executable, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
            this.executable = executable;
            this.parameterAnnotationSource = parameterAnnotationSource;
        }

        /* renamed from: of */
        public static ParameterList<ParameterDescription.InDefinedShape> m259of(Constructor<?> constructor) {
            return m258of(constructor, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) new ParameterDescription.ForLoadedParameter.ParameterAnnotationSource.ForLoadedConstructor(constructor));
        }

        /* renamed from: of */
        public static ParameterList<ParameterDescription.InDefinedShape> m258of(Constructor<?> constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
            return EXECUTABLE.isInstance(constructor) ? new OfConstructor(constructor, parameterAnnotationSource) : new OfLegacyVmConstructor(constructor, parameterAnnotationSource);
        }

        /* renamed from: of */
        public static ParameterList<ParameterDescription.InDefinedShape> m257of(Method method) {
            return m256of(method, (ParameterDescription.ForLoadedParameter.ParameterAnnotationSource) new ParameterDescription.ForLoadedParameter.ParameterAnnotationSource.ForLoadedMethod(method));
        }

        /* renamed from: of */
        public static ParameterList<ParameterDescription.InDefinedShape> m256of(Method method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
            return EXECUTABLE.isInstance(method) ? new OfMethod(method, parameterAnnotationSource) : new OfLegacyVmMethod(method, parameterAnnotationSource);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return EXECUTABLE.getParameterCount(this.executable);
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForLoadedExecutable$OfConstructor.class */
        public static class OfConstructor extends ForLoadedExecutable<Constructor<?>> {
            protected OfConstructor(Constructor<?> constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
                super(constructor, parameterAnnotationSource);
            }

            @Override // java.util.AbstractList, java.util.List
            public ParameterDescription.InDefinedShape get(int index) {
                return new ParameterDescription.ForLoadedParameter.OfConstructor((Constructor) this.executable, index, this.parameterAnnotationSource);
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForLoadedExecutable$OfMethod.class */
        public static class OfMethod extends ForLoadedExecutable<Method> {
            protected OfMethod(Method method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
                super(method, parameterAnnotationSource);
            }

            @Override // java.util.AbstractList, java.util.List
            public ParameterDescription.InDefinedShape get(int index) {
                return new ParameterDescription.ForLoadedParameter.OfMethod((Method) this.executable, index, this.parameterAnnotationSource);
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForLoadedExecutable$OfLegacyVmConstructor.class */
        public static class OfLegacyVmConstructor extends AbstractBase<ParameterDescription.InDefinedShape> {
            private final Constructor<?> constructor;
            private final Class<?>[] parameterType;
            private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;

            protected OfLegacyVmConstructor(Constructor<?> constructor, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
                this.constructor = constructor;
                this.parameterType = constructor.getParameterTypes();
                this.parameterAnnotationSource = parameterAnnotationSource;
            }

            @Override // java.util.AbstractList, java.util.List
            public ParameterDescription.InDefinedShape get(int index) {
                return new ParameterDescription.ForLoadedParameter.OfLegacyVmConstructor(this.constructor, index, this.parameterType, this.parameterAnnotationSource);
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return this.parameterType.length;
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForLoadedExecutable$OfLegacyVmMethod.class */
        public static class OfLegacyVmMethod extends AbstractBase<ParameterDescription.InDefinedShape> {
            private final Method method;
            private final Class<?>[] parameterType;
            private final ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource;

            protected OfLegacyVmMethod(Method method, ParameterDescription.ForLoadedParameter.ParameterAnnotationSource parameterAnnotationSource) {
                this.method = method;
                this.parameterType = method.getParameterTypes();
                this.parameterAnnotationSource = parameterAnnotationSource;
            }

            @Override // java.util.AbstractList, java.util.List
            public ParameterDescription.InDefinedShape get(int index) {
                return new ParameterDescription.ForLoadedParameter.OfLegacyVmMethod(this.method, index, this.parameterType, this.parameterAnnotationSource);
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return this.parameterType.length;
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$Explicit.class */
    public static class Explicit<S extends ParameterDescription> extends AbstractBase<S> {
        private final List<? extends S> parameterDescriptions;

        public Explicit(S... parameterDescription) {
            this(Arrays.asList(parameterDescription));
        }

        public Explicit(List<? extends S> parameterDescriptions) {
            this.parameterDescriptions = parameterDescriptions;
        }

        @Override // java.util.AbstractList, java.util.List
        public S get(int index) {
            return (S) ((ParameterDescription) this.parameterDescriptions.get(index));
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.parameterDescriptions.size();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$Explicit$ForTypes.class */
        public static class ForTypes extends AbstractBase<ParameterDescription.InDefinedShape> {
            private final MethodDescription.InDefinedShape methodDescription;
            private final List<? extends TypeDefinition> typeDefinitions;

            public ForTypes(MethodDescription.InDefinedShape methodDescription, TypeDefinition... typeDefinition) {
                this(methodDescription, Arrays.asList(typeDefinition));
            }

            public ForTypes(MethodDescription.InDefinedShape methodDescription, List<? extends TypeDefinition> typeDefinitions) {
                this.methodDescription = methodDescription;
                this.typeDefinitions = typeDefinitions;
            }

            @Override // java.util.AbstractList, java.util.List
            public ParameterDescription.InDefinedShape get(int index) {
                int offset = this.methodDescription.isStatic() ? 0 : 1;
                for (int previous = 0; previous < index; previous++) {
                    offset += ((TypeDefinition) this.typeDefinitions.get(previous)).getStackSize().getSize();
                }
                return new ParameterDescription.Latent(this.methodDescription, ((TypeDefinition) this.typeDefinitions.get(index)).asGenericType(), index, offset);
            }

            @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
            public int size() {
                return this.typeDefinitions.size();
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$ForTokens.class */
    public static class ForTokens extends AbstractBase<ParameterDescription.InDefinedShape> {
        private final MethodDescription.InDefinedShape declaringMethod;
        private final List<? extends ParameterDescription.Token> tokens;

        public ForTokens(MethodDescription.InDefinedShape declaringMethod, List<? extends ParameterDescription.Token> tokens) {
            this.declaringMethod = declaringMethod;
            this.tokens = tokens;
        }

        @Override // java.util.AbstractList, java.util.List
        public ParameterDescription.InDefinedShape get(int index) {
            int offset = this.declaringMethod.isStatic() ? 0 : 1;
            for (ParameterDescription.Token token : this.tokens.subList(0, index)) {
                offset += token.getType().getStackSize().getSize();
            }
            return new ParameterDescription.Latent(this.declaringMethod, (ParameterDescription.Token) this.tokens.get(index), index, offset);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.tokens.size();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$TypeSubstituting.class */
    public static class TypeSubstituting extends AbstractBase<ParameterDescription.InGenericShape> {
        private final MethodDescription.InGenericShape declaringMethod;
        private final List<? extends ParameterDescription> parameterDescriptions;
        private final TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor;

        public TypeSubstituting(MethodDescription.InGenericShape declaringMethod, List<? extends ParameterDescription> parameterDescriptions, TypeDescription.Generic.Visitor<? extends TypeDescription.Generic> visitor) {
            this.declaringMethod = declaringMethod;
            this.parameterDescriptions = parameterDescriptions;
            this.visitor = visitor;
        }

        @Override // java.util.AbstractList, java.util.List
        public ParameterDescription.InGenericShape get(int index) {
            return new ParameterDescription.TypeSubstituting(this.declaringMethod, (ParameterDescription) this.parameterDescriptions.get(index), this.visitor);
        }

        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
        public int size() {
            return this.parameterDescriptions.size();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/method/ParameterList$Empty.class */
    public static class Empty<S extends ParameterDescription> extends FilterableList.Empty<S, ParameterList<S>> implements ParameterList<S> {
        @Override // net.bytebuddy.description.method.ParameterList
        public boolean hasExplicitMetaData() {
            return true;
        }

        @Override // net.bytebuddy.description.method.ParameterList
        public TypeList.Generic asTypeList() {
            return new TypeList.Generic.Empty();
        }

        @Override // net.bytebuddy.description.method.ParameterList
        public ByteCodeElement.Token.TokenList<ParameterDescription.Token> asTokenList(ElementMatcher<? super TypeDescription> matcher) {
            return new ByteCodeElement.Token.TokenList<>(new ParameterDescription.Token[0]);
        }

        @Override // net.bytebuddy.description.method.ParameterList
        public ParameterList<ParameterDescription.InDefinedShape> asDefined() {
            return this;
        }
    }
}
