package net.bytebuddy.pool;

import dev.morphia.mapping.Mapper;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.ref.SoftReference;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReference;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.TypeVariableSource;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.method.ParameterList;
import net.bytebuddy.description.type.PackageDescription;
import net.bytebuddy.description.type.RecordComponentDescription;
import net.bytebuddy.description.type.RecordComponentList;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.AnnotationVisitor;
import net.bytebuddy.jar.asm.ClassReader;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.FieldVisitor;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.RecordComponentVisitor;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.jar.asm.TypePath;
import net.bytebuddy.jar.asm.TypeReference;
import net.bytebuddy.jar.asm.signature.SignatureReader;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaType;
import net.bytebuddy.utility.OpenedClassReader;

/* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool.class */
public interface TypePool {
    Resolution describe(String str);

    void clear();

    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Resolution.class */
    public interface Resolution {
        boolean isResolved();

        TypeDescription resolve();

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Resolution$Simple.class */
        public static class Simple implements Resolution {
            private final TypeDescription typeDescription;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.typeDescription.equals(((Simple) obj).typeDescription);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.typeDescription.hashCode();
            }

            public Simple(TypeDescription typeDescription) {
                this.typeDescription = typeDescription;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return true;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                return this.typeDescription;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Resolution$Illegal.class */
        public static class Illegal implements Resolution {
            private final String name;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((Illegal) obj).name);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.name.hashCode();
            }

            public Illegal(String name) {
                this.name = name;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return false;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                throw new IllegalStateException("Cannot resolve type description for " + this.name);
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$CacheProvider.class */
    public interface CacheProvider {
        public static final Resolution UNRESOLVED = null;

        Resolution find(String str);

        Resolution register(String str, Resolution resolution);

        void clear();

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$CacheProvider$NoOp.class */
        public enum NoOp implements CacheProvider {
            INSTANCE;

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution find(String name) {
                return UNRESOLVED;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String name, Resolution resolution) {
                return resolution;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$CacheProvider$Simple.class */
        public static class Simple implements CacheProvider {
            private final ConcurrentMap<String, Resolution> storage;

            public Simple() {
                this(new ConcurrentHashMap());
            }

            public Simple(ConcurrentMap<String, Resolution> storage) {
                this.storage = storage;
            }

            public static CacheProvider withObjectType() {
                CacheProvider cacheProvider = new Simple();
                cacheProvider.register(Object.class.getName(), new Resolution.Simple(TypeDescription.OBJECT));
                return cacheProvider;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution find(String name) {
                return this.storage.get(name);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String name, Resolution resolution) {
                Resolution cached = this.storage.putIfAbsent(name, resolution);
                return cached == null ? resolution : cached;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
                this.storage.clear();
            }

            public ConcurrentMap<String, Resolution> getStorage() {
                return this.storage;
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$CacheProvider$Simple$UsingSoftReference.class */
            public static class UsingSoftReference implements CacheProvider {
                private final AtomicReference<SoftReference<Simple>> delegate = new AtomicReference<>(new SoftReference(new Simple()));

                @Override // net.bytebuddy.pool.TypePool.CacheProvider
                public Resolution find(String name) {
                    CacheProvider provider = this.delegate.get().get();
                    if (provider == null) {
                        return null;
                    }
                    return provider.find(name);
                }

                @Override // net.bytebuddy.pool.TypePool.CacheProvider
                public Resolution register(String name, Resolution resolution) {
                    SoftReference<Simple> reference = this.delegate.get();
                    Simple provider = reference.get();
                    if (provider == null) {
                        provider = new Simple();
                        while (true) {
                            if (this.delegate.compareAndSet(reference, new SoftReference<>(provider))) {
                                break;
                            }
                            reference = this.delegate.get();
                            Simple previous = reference.get();
                            if (previous != null) {
                                provider = previous;
                                break;
                            }
                        }
                    }
                    return provider.register(name, resolution);
                }

                @Override // net.bytebuddy.pool.TypePool.CacheProvider
                public void clear() {
                    CacheProvider provider = this.delegate.get().get();
                    if (provider != null) {
                        provider.clear();
                    }
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$CacheProvider$Discriminating.class */
        public static class Discriminating implements CacheProvider {
            private final ElementMatcher<String> matcher;
            private final CacheProvider matched;
            private final CacheProvider unmatched;

            public Discriminating(ElementMatcher<String> matcher, CacheProvider matched, CacheProvider unmatched) {
                this.matcher = matcher;
                this.matched = matched;
                this.unmatched = unmatched;
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution find(String name) {
                return (this.matcher.matches(name) ? this.matched : this.unmatched).find(name);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public Resolution register(String name, Resolution resolution) {
                return (this.matcher.matches(name) ? this.matched : this.unmatched).register(name, resolution);
            }

            @Override // net.bytebuddy.pool.TypePool.CacheProvider
            public void clear() {
                try {
                    this.unmatched.clear();
                } finally {
                    this.matched.clear();
                }
            }
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Empty.class */
    public enum Empty implements TypePool {
        INSTANCE;

        @Override // net.bytebuddy.pool.TypePool
        public Resolution describe(String name) {
            return new Resolution.Illegal(name);
        }

        @Override // net.bytebuddy.pool.TypePool
        public void clear() {
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$AbstractBase.class */
    public static abstract class AbstractBase implements TypePool {
        protected static final Map<String, TypeDescription> PRIMITIVE_TYPES;
        protected static final Map<String, String> PRIMITIVE_DESCRIPTORS;
        private static final String ARRAY_SYMBOL = "[";
        protected final CacheProvider cacheProvider;

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$AbstractBase$ComponentTypeReference.class */
        protected interface ComponentTypeReference {
            public static final String NO_ARRAY = null;

            String resolve();
        }

        protected abstract Resolution doDescribe(String str);

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.cacheProvider.equals(((AbstractBase) obj).cacheProvider);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.cacheProvider.hashCode();
        }

        static {
            Map<String, TypeDescription> primitiveTypes = new HashMap<>();
            Map<String, String> primitiveDescriptors = new HashMap<>();
            Class<?>[] clsArr = {Boolean.TYPE, Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
            for (Class<?> primitiveType : clsArr) {
                primitiveTypes.put(primitiveType.getName(), TypeDescription.ForLoadedType.m247of(primitiveType));
                primitiveDescriptors.put(Type.getDescriptor(primitiveType), primitiveType.getName());
            }
            PRIMITIVE_TYPES = Collections.unmodifiableMap(primitiveTypes);
            PRIMITIVE_DESCRIPTORS = Collections.unmodifiableMap(primitiveDescriptors);
        }

        protected AbstractBase(CacheProvider cacheProvider) {
            this.cacheProvider = cacheProvider;
        }

        @Override // net.bytebuddy.pool.TypePool
        public Resolution describe(String name) {
            if (name.contains("/")) {
                throw new IllegalArgumentException(name + " contains the illegal character '/'");
            }
            int arity = 0;
            while (name.startsWith(ARRAY_SYMBOL)) {
                arity++;
                name = name.substring(1);
            }
            if (arity > 0) {
                String primitiveName = PRIMITIVE_DESCRIPTORS.get(name);
                name = primitiveName == null ? name.substring(1, name.length() - 1) : primitiveName;
            }
            TypeDescription typeDescription = PRIMITIVE_TYPES.get(name);
            Resolution resolution = typeDescription == null ? this.cacheProvider.find(name) : new Resolution.Simple(typeDescription);
            if (resolution == null) {
                resolution = doCache(name, doDescribe(name));
            }
            return ArrayTypeResolution.m93of(resolution, arity);
        }

        protected Resolution doCache(String name, Resolution resolution) {
            return this.cacheProvider.register(name, resolution);
        }

        @Override // net.bytebuddy.pool.TypePool
        public void clear() {
            this.cacheProvider.clear();
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$AbstractBase$Hierarchical.class */
        public static abstract class Hierarchical extends AbstractBase {
            private final TypePool parent;

            @Override // net.bytebuddy.pool.TypePool.AbstractBase
            public boolean equals(Object obj) {
                if (!equals(obj)) {
                    return false;
                }
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.parent.equals(((Hierarchical) obj).parent);
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase
            public int hashCode() {
                return (hashCode() * 31) + this.parent.hashCode();
            }

            protected Hierarchical(CacheProvider cacheProvider, TypePool parent) {
                super(cacheProvider);
                this.parent = parent;
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase, net.bytebuddy.pool.TypePool
            public Resolution describe(String name) {
                Resolution resolution = this.parent.describe(name);
                return resolution.isResolved() ? resolution : describe(name);
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase, net.bytebuddy.pool.TypePool
            public void clear() {
                try {
                    this.parent.clear();
                } finally {
                    clear();
                }
            }
        }

        /* access modifiers changed from: protected */
        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$AbstractBase$ArrayTypeResolution.class */
        public static class ArrayTypeResolution implements Resolution {
            private final Resolution resolution;
            private final int arity;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.arity == ((ArrayTypeResolution) obj).arity && this.resolution.equals(((ArrayTypeResolution) obj).resolution);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.resolution.hashCode()) * 31) + this.arity;
            }

            protected ArrayTypeResolution(Resolution resolution, int arity) {
                this.resolution = resolution;
                this.arity = arity;
            }

            /* renamed from: of */
            protected static Resolution m93of(Resolution resolution, int arity) {
                return arity == 0 ? resolution : new ArrayTypeResolution(resolution, arity);
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return this.resolution.isResolved();
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                return TypeDescription.ArrayProjection.m248of(this.resolution.resolve(), this.arity);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default.class */
    public static class Default extends AbstractBase.Hierarchical {
        private static final MethodVisitor IGNORE_METHOD = null;
        protected final ClassFileLocator classFileLocator;
        protected final ReaderMode readerMode;

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(Object obj) {
            if (!equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.readerMode.equals(((Default) obj).readerMode) && this.classFileLocator.equals(((Default) obj).classFileLocator);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return (((hashCode() * 31) + this.classFileLocator.hashCode()) * 31) + this.readerMode.hashCode();
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode) {
            this(cacheProvider, classFileLocator, readerMode, Empty.INSTANCE);
        }

        public Default(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, TypePool parentPool) {
            super(cacheProvider, parentPool);
            this.classFileLocator = classFileLocator;
            this.readerMode = readerMode;
        }

        public static TypePool ofSystemLoader() {
            return m89of(ClassFileLocator.ForClassLoader.ofSystemLoader());
        }

        public static TypePool ofPlatformLoader() {
            return m89of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
        }

        public static TypePool ofBootLoader() {
            return m89of(ClassFileLocator.ForClassLoader.ofBootLoader());
        }

        /* renamed from: of */
        public static TypePool m90of(ClassLoader classLoader) {
            return m89of(ClassFileLocator.ForClassLoader.m232of(classLoader));
        }

        /* renamed from: of */
        public static TypePool m89of(ClassFileLocator classFileLocator) {
            return new Default(new CacheProvider.Simple(), classFileLocator, ReaderMode.FAST);
        }

        /* access modifiers changed from: protected */
        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public Resolution doDescribe(String name) {
            try {
                ClassFileLocator.Resolution resolution = this.classFileLocator.locate(name);
                return resolution.isResolved() ? new Resolution.Simple(parse(resolution.resolve())) : new Resolution.Illegal(name);
            } catch (IOException exception) {
                throw new IllegalStateException("Error while reading class file", exception);
            }
        }

        private TypeDescription parse(byte[] binaryRepresentation) {
            ClassReader classReader = OpenedClassReader.m63of(binaryRepresentation);
            TypeExtractor typeExtractor = new TypeExtractor();
            classReader.accept(typeExtractor, this.readerMode.getFlags());
            return typeExtractor.toTypeDescription();
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ReaderMode.class */
        public enum ReaderMode {
            EXTENDED(4),
            FAST(1);
            
            private final int flags;

            ReaderMode(int flags) {
                this.flags = flags;
            }

            protected int getFlags() {
                return this.flags;
            }

            public boolean isExtended() {
                return this == EXTENDED;
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$WithLazyResolution.class */
        public static class WithLazyResolution extends Default {
            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode) {
                this(cacheProvider, classFileLocator, readerMode, Empty.INSTANCE);
            }

            public WithLazyResolution(CacheProvider cacheProvider, ClassFileLocator classFileLocator, ReaderMode readerMode, TypePool parentPool) {
                super(cacheProvider, classFileLocator, readerMode, parentPool);
            }

            public static TypePool ofSystemLoader() {
                return m83of(ClassFileLocator.ForClassLoader.ofSystemLoader());
            }

            public static TypePool ofPlatformLoader() {
                return m83of(ClassFileLocator.ForClassLoader.ofPlatformLoader());
            }

            public static TypePool ofBootLoader() {
                return m83of(ClassFileLocator.ForClassLoader.ofBootLoader());
            }

            /* renamed from: of */
            public static TypePool m84of(ClassLoader classLoader) {
                return m83of(ClassFileLocator.ForClassLoader.m232of(classLoader));
            }

            /* renamed from: of */
            public static TypePool m83of(ClassFileLocator classFileLocator) {
                return new WithLazyResolution(new CacheProvider.Simple(), classFileLocator, ReaderMode.FAST);
            }

            /* access modifiers changed from: protected */
            @Override // net.bytebuddy.pool.TypePool.Default, net.bytebuddy.pool.TypePool.AbstractBase
            public Resolution doDescribe(String name) {
                return new LazyResolution(name);
            }

            @Override // net.bytebuddy.pool.TypePool.AbstractBase
            protected Resolution doCache(String name, Resolution resolution) {
                return resolution;
            }

            protected Resolution doResolve(String name) {
                Resolution resolution = this.cacheProvider.find(name);
                if (resolution == null) {
                    resolution = this.cacheProvider.register(name, doDescribe(name));
                }
                return resolution;
            }

            @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$WithLazyResolution$LazyResolution.class */
            protected class LazyResolution implements Resolution {
                private final String name;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((LazyResolution) obj).name) && WithLazyResolution.this.equals(WithLazyResolution.this);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + WithLazyResolution.this.hashCode();
                }

                protected LazyResolution(String name) {
                    this.name = name;
                }

                @Override // net.bytebuddy.pool.TypePool.Resolution
                public boolean isResolved() {
                    return WithLazyResolution.this.doResolve(this.name).isResolved();
                }

                @Override // net.bytebuddy.pool.TypePool.Resolution
                public TypeDescription resolve() {
                    return new LazyTypeDescription(this.name);
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$WithLazyResolution$LazyTypeDescription.class */
            protected class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
                private final String name;
                private transient /* synthetic */ TypeDescription delegate;

                protected LazyTypeDescription(String name) {
                    this.name = name;
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation
                @CachedReturnPlugin.Enhance(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
                protected TypeDescription delegate() {
                    TypeDescription resolve = this.delegate != null ? null : WithLazyResolution.this.doResolve(this.name).resolve();
                    if (resolve == null) {
                        resolve = this.delegate;
                    } else {
                        this.delegate = resolve;
                    }
                    return resolve;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant.class */
        public interface AnnotationRegistrant {
            void register(String str, AnnotationValue<?, ?> annotationValue);

            void onComplete();

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$AbstractBase.class */
            public static abstract class AbstractBase implements AnnotationRegistrant {
                private final String descriptor;
                private final Map<String, AnnotationValue<?, ?>> values = new HashMap();

                protected abstract List<LazyTypeDescription.AnnotationToken> getTokens();

                protected AbstractBase(String descriptor) {
                    this.descriptor = descriptor;
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void register(String name, AnnotationValue<?, ?> annotationValue) {
                    this.values.put(name, annotationValue);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void onComplete() {
                    getTokens().add(new LazyTypeDescription.AnnotationToken(this.descriptor, this.values));
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$AbstractBase$ForTypeVariable.class */
                protected static abstract class ForTypeVariable extends AbstractBase {
                    private final String typePath;

                    protected abstract Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap();

                    protected ForTypeVariable(String descriptor, TypePath typePath) {
                        super(descriptor);
                        this.typePath = typePath == null ? "" : typePath.toString();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase
                    protected List<LazyTypeDescription.AnnotationToken> getTokens() {
                        Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap = getPathMap();
                        List<LazyTypeDescription.AnnotationToken> tokens = pathMap.get(this.typePath);
                        if (tokens == null) {
                            tokens = new ArrayList();
                            pathMap.put(this.typePath, tokens);
                        }
                        return tokens;
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$AbstractBase$ForTypeVariable$WithIndex.class */
                    protected static abstract class WithIndex extends ForTypeVariable {
                        private final int index;

                        protected abstract Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap();

                        protected WithIndex(String descriptor, TypePath typePath, int index) {
                            super(descriptor, typePath);
                            this.index = index;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable
                        protected Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap() {
                            Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap = getIndexedPathMap();
                            Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap = indexedPathMap.get(Integer.valueOf(this.index));
                            if (pathMap == null) {
                                pathMap = new HashMap();
                                indexedPathMap.put(Integer.valueOf(this.index), pathMap);
                            }
                            return pathMap;
                        }

                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$AbstractBase$ForTypeVariable$WithIndex$DoubleIndexed.class */
                        protected static abstract class DoubleIndexed extends WithIndex {
                            private final int preIndex;

                            protected abstract Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap();

                            protected DoubleIndexed(String descriptor, TypePath typePath, int index, int preIndex) {
                                super(descriptor, typePath, index);
                                this.preIndex = preIndex;
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex
                            protected Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
                                Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexPathMap = getDoubleIndexedPathMap();
                                Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap = doubleIndexPathMap.get(Integer.valueOf(this.preIndex));
                                if (indexedPathMap == null) {
                                    indexedPathMap = new HashMap();
                                    doubleIndexPathMap.put(Integer.valueOf(this.preIndex), indexedPathMap);
                                }
                                return indexedPathMap;
                            }
                        }
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$ForByteCodeElement.class */
            public static class ForByteCodeElement extends AbstractBase {
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens;

                protected ForByteCodeElement(String descriptor, List<LazyTypeDescription.AnnotationToken> annotationTokens) {
                    super(descriptor);
                    this.annotationTokens = annotationTokens;
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase
                protected List<LazyTypeDescription.AnnotationToken> getTokens() {
                    return this.annotationTokens;
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$ForByteCodeElement$WithIndex.class */
                public static class WithIndex extends AbstractBase {
                    private final int index;
                    private final Map<Integer, List<LazyTypeDescription.AnnotationToken>> annotationTokens;

                    protected WithIndex(String descriptor, int index, Map<Integer, List<LazyTypeDescription.AnnotationToken>> annotationTokens) {
                        super(descriptor);
                        this.index = index;
                        this.annotationTokens = annotationTokens;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase
                    protected List<LazyTypeDescription.AnnotationToken> getTokens() {
                        List<LazyTypeDescription.AnnotationToken> annotationTokens = this.annotationTokens.get(Integer.valueOf(this.index));
                        if (annotationTokens == null) {
                            annotationTokens = new ArrayList();
                            this.annotationTokens.put(Integer.valueOf(this.index), annotationTokens);
                        }
                        return annotationTokens;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$ForTypeVariable.class */
            public static class ForTypeVariable extends AbstractBase.ForTypeVariable {
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap;

                protected ForTypeVariable(String descriptor, TypePath typePath, Map<String, List<LazyTypeDescription.AnnotationToken>> pathMap) {
                    super(descriptor, typePath);
                    this.pathMap = pathMap;
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable
                protected Map<String, List<LazyTypeDescription.AnnotationToken>> getPathMap() {
                    return this.pathMap;
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex.class */
                public static class WithIndex extends AbstractBase.ForTypeVariable.WithIndex {
                    private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap;

                    protected WithIndex(String descriptor, TypePath typePath, int index, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> indexedPathMap) {
                        super(descriptor, typePath, index);
                        this.indexedPathMap = indexedPathMap;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex
                    protected Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> getIndexedPathMap() {
                        return this.indexedPathMap;
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$AnnotationRegistrant$ForTypeVariable$WithIndex$DoubleIndexed.class */
                    public static class DoubleIndexed extends AbstractBase.ForTypeVariable.WithIndex.DoubleIndexed {
                        private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap;

                        protected DoubleIndexed(String descriptor, TypePath typePath, int index, int preIndex, Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> doubleIndexedPathMap) {
                            super(descriptor, typePath, index, preIndex);
                            this.doubleIndexedPathMap = doubleIndexedPathMap;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant.AbstractBase.ForTypeVariable.WithIndex.DoubleIndexed
                        protected Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> getDoubleIndexedPathMap() {
                            return this.doubleIndexedPathMap;
                        }
                    }
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ComponentTypeLocator.class */
        protected interface ComponentTypeLocator {
            AbstractBase.ComponentTypeReference bind(String str);

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ComponentTypeLocator$Illegal.class */
            public enum Illegal implements ComponentTypeLocator {
                INSTANCE;

                @Override // net.bytebuddy.pool.TypePool.Default.ComponentTypeLocator
                public AbstractBase.ComponentTypeReference bind(String name) {
                    throw new IllegalStateException("Unexpected lookup of component type for " + name);
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ComponentTypeLocator$ForAnnotationProperty.class */
            public static class ForAnnotationProperty implements ComponentTypeLocator {
                private final TypePool typePool;
                private final String annotationName;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.annotationName.equals(((ForAnnotationProperty) obj).annotationName) && this.typePool.equals(((ForAnnotationProperty) obj).typePool);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.typePool.hashCode()) * 31) + this.annotationName.hashCode();
                }

                public ForAnnotationProperty(TypePool typePool, String annotationDescriptor) {
                    this.typePool = typePool;
                    this.annotationName = annotationDescriptor.substring(1, annotationDescriptor.length() - 1).replace('/', '.');
                }

                @Override // net.bytebuddy.pool.TypePool.Default.ComponentTypeLocator
                public AbstractBase.ComponentTypeReference bind(String name) {
                    return new Bound(name);
                }

                @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ComponentTypeLocator$ForAnnotationProperty$Bound.class */
                protected class Bound implements AbstractBase.ComponentTypeReference {
                    private final String name;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((Bound) obj).name) && ForAnnotationProperty.this.equals(ForAnnotationProperty.this);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + ForAnnotationProperty.this.hashCode();
                    }

                    protected Bound(String name) {
                        this.name = name;
                    }

                    @Override // net.bytebuddy.pool.TypePool.AbstractBase.ComponentTypeReference
                    public String resolve() {
                        TypeDescription typeDescription = ((MethodDescription.InDefinedShape) ForAnnotationProperty.this.typePool.describe(ForAnnotationProperty.this.annotationName).resolve().getDeclaredMethods().filter(ElementMatchers.named(this.name)).getOnly()).getReturnType().asErasure();
                        return typeDescription.isArray() ? typeDescription.getComponentType().getName() : NO_ARRAY;
                    }
                }
            }

            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ComponentTypeLocator$ForArrayType.class */
            public static class ForArrayType implements ComponentTypeLocator, AbstractBase.ComponentTypeReference {
                private final String componentType;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.componentType.equals(((ForArrayType) obj).componentType);
                }

                public int hashCode() {
                    return (getClass().hashCode() * 31) + this.componentType.hashCode();
                }

                public ForArrayType(String methodDescriptor) {
                    String arrayType = Type.getMethodType(methodDescriptor).getReturnType().getClassName();
                    this.componentType = arrayType.substring(0, arrayType.length() - 2);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.ComponentTypeLocator
                public AbstractBase.ComponentTypeReference bind(String name) {
                    return this;
                }

                @Override // net.bytebuddy.pool.TypePool.AbstractBase.ComponentTypeReference
                public String resolve() {
                    return this.componentType;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeRegistrant.class */
        public interface GenericTypeRegistrant {
            void register(LazyTypeDescription.GenericTypeToken genericTypeToken);

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeRegistrant$RejectingSignatureVisitor.class */
            public static class RejectingSignatureVisitor extends SignatureVisitor {
                private static final String MESSAGE = "Unexpected token in generic signature";

                public RejectingSignatureVisitor() {
                    super(OpenedClassReader.ASM_API);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitFormalTypeParameter(String name) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitClassBound() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitInterfaceBound() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitSuperclass() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitInterface() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitParameterType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitReturnType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitExceptionType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitBaseType(char descriptor) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitTypeVariable(String name) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitArrayType() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitClassType(String name) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitInnerClassType(String name) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitTypeArgument() {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitTypeArgument(char wildcard) {
                    throw new IllegalStateException(MESSAGE);
                }

                @Override // net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitEnd() {
                    throw new IllegalStateException(MESSAGE);
                }
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$ParameterBag.class */
        protected static class ParameterBag {
            private final Type[] parameterType;
            private final Map<Integer, String> parameterRegistry = new HashMap();

            protected ParameterBag(Type[] parameterType) {
                this.parameterType = parameterType;
            }

            protected void register(int offset, String name) {
                this.parameterRegistry.put(Integer.valueOf(offset), name);
            }

            protected List<LazyTypeDescription.MethodToken.ParameterToken> resolve(boolean isStatic) {
                int offset;
                List<LazyTypeDescription.MethodToken.ParameterToken> parameterTokens = new ArrayList<>(this.parameterType.length);
                if (isStatic) {
                    offset = StackSize.ZERO.getSize();
                } else {
                    offset = StackSize.SINGLE.getSize();
                }
                Type[] typeArr = this.parameterType;
                for (Type aParameterType : typeArr) {
                    String name = this.parameterRegistry.get(Integer.valueOf(offset));
                    parameterTokens.add(name == null ? new LazyTypeDescription.MethodToken.ParameterToken() : new LazyTypeDescription.MethodToken.ParameterToken(name));
                    offset += aParameterType.getSize();
                }
                return parameterTokens;
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor.class */
        public static class GenericTypeExtractor extends GenericTypeRegistrant.RejectingSignatureVisitor implements GenericTypeRegistrant {
            private final GenericTypeRegistrant genericTypeRegistrant;
            private IncompleteToken incompleteToken;

            protected GenericTypeExtractor(GenericTypeRegistrant genericTypeRegistrant) {
                this.genericTypeRegistrant = genericTypeRegistrant;
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitBaseType(char descriptor) {
                this.genericTypeRegistrant.register(LazyTypeDescription.GenericTypeToken.ForPrimitiveType.m88of(descriptor));
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitTypeVariable(String name) {
                this.genericTypeRegistrant.register(new LazyTypeDescription.GenericTypeToken.ForTypeVariable(name));
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public SignatureVisitor visitArrayType() {
                return new GenericTypeExtractor(this);
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
            public void register(LazyTypeDescription.GenericTypeToken componentTypeToken) {
                this.genericTypeRegistrant.register(new LazyTypeDescription.GenericTypeToken.ForGenericArray(componentTypeToken));
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitClassType(String name) {
                this.incompleteToken = new IncompleteToken.ForTopLevelType(name);
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitInnerClassType(String name) {
                this.incompleteToken = new IncompleteToken.ForInnerClass(name, this.incompleteToken);
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitTypeArgument() {
                this.incompleteToken.appendPlaceholder();
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public SignatureVisitor visitTypeArgument(char wildcard) {
                switch (wildcard) {
                    case '+':
                        return this.incompleteToken.appendUpperBound();
                    case '-':
                        return this.incompleteToken.appendLowerBound();
                    case '=':
                        return this.incompleteToken.appendDirectBound();
                    default:
                        throw new IllegalArgumentException("Unknown wildcard: " + wildcard);
                }
            }

            @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
            public void visitEnd() {
                this.genericTypeRegistrant.register(this.incompleteToken.toToken());
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken.class */
            public interface IncompleteToken {
                SignatureVisitor appendLowerBound();

                SignatureVisitor appendUpperBound();

                SignatureVisitor appendDirectBound();

                void appendPlaceholder();

                boolean isParameterized();

                String getName();

                LazyTypeDescription.GenericTypeToken toToken();

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken$AbstractBase.class */
                public static abstract class AbstractBase implements IncompleteToken {
                    protected final List<LazyTypeDescription.GenericTypeToken> parameters = new ArrayList();

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public SignatureVisitor appendDirectBound() {
                        return new GenericTypeExtractor(new ForDirectBound());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public SignatureVisitor appendUpperBound() {
                        return new GenericTypeExtractor(new ForUpperBound());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public SignatureVisitor appendLowerBound() {
                        return new GenericTypeExtractor(new ForLowerBound());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public void appendPlaceholder() {
                        this.parameters.add(LazyTypeDescription.GenericTypeToken.ForUnboundWildcard.INSTANCE);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken$AbstractBase$ForDirectBound.class */
                    protected class ForDirectBound implements GenericTypeRegistrant {
                        protected ForDirectBound() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            AbstractBase.this.parameters.add(token);
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken$AbstractBase$ForUpperBound.class */
                    protected class ForUpperBound implements GenericTypeRegistrant {
                        protected ForUpperBound() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            AbstractBase.this.parameters.add(new LazyTypeDescription.GenericTypeToken.ForUpperBoundWildcard(token));
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken$AbstractBase$ForLowerBound.class */
                    protected class ForLowerBound implements GenericTypeRegistrant {
                        protected ForLowerBound() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            AbstractBase.this.parameters.add(new LazyTypeDescription.GenericTypeToken.ForLowerBoundWildcard(token));
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken$ForTopLevelType.class */
                public static class ForTopLevelType extends AbstractBase {
                    private final String internalName;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.internalName.equals(((ForTopLevelType) obj).internalName);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.internalName.hashCode();
                    }

                    public ForTopLevelType(String internalName) {
                        this.internalName = internalName;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public LazyTypeDescription.GenericTypeToken toToken() {
                        if (isParameterized()) {
                            return new LazyTypeDescription.GenericTypeToken.ForParameterizedType(getName(), this.parameters);
                        }
                        return new LazyTypeDescription.GenericTypeToken.ForRawType(getName());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public boolean isParameterized() {
                        return !this.parameters.isEmpty();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public String getName() {
                        return this.internalName.replace('/', '.');
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$IncompleteToken$ForInnerClass.class */
                public static class ForInnerClass extends AbstractBase {
                    private static final char INNER_CLASS_SEPARATOR = '$';
                    private final String internalName;
                    private final IncompleteToken outerTypeToken;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.internalName.equals(((ForInnerClass) obj).internalName) && this.outerTypeToken.equals(((ForInnerClass) obj).outerTypeToken);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.internalName.hashCode()) * 31) + this.outerTypeToken.hashCode();
                    }

                    public ForInnerClass(String internalName, IncompleteToken outerTypeToken) {
                        this.internalName = internalName;
                        this.outerTypeToken = outerTypeToken;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public LazyTypeDescription.GenericTypeToken toToken() {
                        if (isParameterized() || this.outerTypeToken.isParameterized()) {
                            return new LazyTypeDescription.GenericTypeToken.ForParameterizedType.Nested(getName(), this.parameters, this.outerTypeToken.toToken());
                        }
                        return new LazyTypeDescription.GenericTypeToken.ForRawType(getName());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public boolean isParameterized() {
                        return !this.parameters.isEmpty() || !this.outerTypeToken.isParameterized();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.IncompleteToken
                    public String getName() {
                        return this.outerTypeToken.getName() + '$' + this.internalName.replace('/', '.');
                    }
                }
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature.class */
            public static abstract class ForSignature<T extends LazyTypeDescription.GenericTypeToken.Resolution> extends GenericTypeRegistrant.RejectingSignatureVisitor implements GenericTypeRegistrant {
                protected final List<LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable> typeVariableTokens = new ArrayList();
                protected String currentTypeParameter;
                protected List<LazyTypeDescription.GenericTypeToken> currentBounds;

                public abstract T resolve();

                protected static <S extends LazyTypeDescription.GenericTypeToken.Resolution> S extract(String genericSignature, ForSignature<S> visitor) {
                    new SignatureReader(genericSignature).accept(visitor);
                    return visitor.resolve();
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                public void visitFormalTypeParameter(String name) {
                    collectTypeParameter();
                    this.currentTypeParameter = name;
                    this.currentBounds = new ArrayList();
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitClassBound() {
                    return new GenericTypeExtractor(this);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                public SignatureVisitor visitInterfaceBound() {
                    return new GenericTypeExtractor(this);
                }

                @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                public void register(LazyTypeDescription.GenericTypeToken token) {
                    if (this.currentBounds == null) {
                        throw new IllegalStateException("Did not expect " + token + " before finding formal parameter");
                    }
                    this.currentBounds.add(token);
                }

                protected void collectTypeParameter() {
                    if (this.currentTypeParameter != null) {
                        this.typeVariableTokens.add(new LazyTypeDescription.GenericTypeToken.ForTypeVariable.Formal(this.currentTypeParameter, this.currentBounds));
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfType.class */
                protected static class OfType extends ForSignature<LazyTypeDescription.GenericTypeToken.Resolution.ForType> {
                    private final List<LazyTypeDescription.GenericTypeToken> interfaceTypeTokens = new ArrayList();
                    private LazyTypeDescription.GenericTypeToken superClassToken;

                    protected OfType() {
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForType extract(String genericSignature) {
                        try {
                            return genericSignature == null ? LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : (LazyTypeDescription.GenericTypeToken.Resolution.ForType) ForSignature.extract(genericSignature, new OfType());
                        } catch (RuntimeException e) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitSuperclass() {
                        collectTypeParameter();
                        return new GenericTypeExtractor(new SuperClassRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitInterface() {
                        return new GenericTypeExtractor(new InterfaceTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.ForSignature
                    public LazyTypeDescription.GenericTypeToken.Resolution.ForType resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForType.Tokenized(this.superClassToken, this.interfaceTypeTokens, this.typeVariableTokens);
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfType$SuperClassRegistrant.class */
                    protected class SuperClassRegistrant implements GenericTypeRegistrant {
                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfType.this.equals(OfType.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfType.this.hashCode();
                        }

                        protected SuperClassRegistrant() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            OfType.this.superClassToken = token;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfType$InterfaceTypeRegistrant.class */
                    protected class InterfaceTypeRegistrant implements GenericTypeRegistrant {
                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfType.this.equals(OfType.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfType.this.hashCode();
                        }

                        protected InterfaceTypeRegistrant() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            OfType.this.interfaceTypeTokens.add(token);
                        }
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfField.class */
                protected static class OfField implements GenericTypeRegistrant {
                    private LazyTypeDescription.GenericTypeToken fieldTypeToken;

                    protected OfField() {
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForField extract(String genericSignature) {
                        if (genericSignature == null) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        }
                        SignatureReader signatureReader = new SignatureReader(genericSignature);
                        OfField visitor = new OfField();
                        try {
                            signatureReader.acceptType(new GenericTypeExtractor(visitor));
                            return visitor.resolve();
                        } catch (RuntimeException e) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                    public void register(LazyTypeDescription.GenericTypeToken token) {
                        this.fieldTypeToken = token;
                    }

                    protected LazyTypeDescription.GenericTypeToken.Resolution.ForField resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForField.Tokenized(this.fieldTypeToken);
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfMethod.class */
                protected static class OfMethod extends ForSignature<LazyTypeDescription.GenericTypeToken.Resolution.ForMethod> {
                    private final List<LazyTypeDescription.GenericTypeToken> parameterTypeTokens = new ArrayList();
                    private final List<LazyTypeDescription.GenericTypeToken> exceptionTypeTokens = new ArrayList();
                    private LazyTypeDescription.GenericTypeToken returnTypeToken;

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForMethod extract(String genericSignature) {
                        try {
                            return genericSignature == null ? LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE : (LazyTypeDescription.GenericTypeToken.Resolution.ForMethod) ForSignature.extract(genericSignature, new OfMethod());
                        } catch (RuntimeException e) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitParameterType() {
                        return new GenericTypeExtractor(new ParameterTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitReturnType() {
                        collectTypeParameter();
                        return new GenericTypeExtractor(new ReturnTypeTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant.RejectingSignatureVisitor, net.bytebuddy.jar.asm.signature.SignatureVisitor
                    public SignatureVisitor visitExceptionType() {
                        return new GenericTypeExtractor(new ExceptionTypeRegistrant());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeExtractor.ForSignature
                    public LazyTypeDescription.GenericTypeToken.Resolution.ForMethod resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForMethod.Tokenized(this.returnTypeToken, this.parameterTypeTokens, this.exceptionTypeTokens, this.typeVariableTokens);
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfMethod$ParameterTypeRegistrant.class */
                    protected class ParameterTypeRegistrant implements GenericTypeRegistrant {
                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfMethod.this.hashCode();
                        }

                        protected ParameterTypeRegistrant() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            OfMethod.this.parameterTypeTokens.add(token);
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfMethod$ReturnTypeTypeRegistrant.class */
                    protected class ReturnTypeTypeRegistrant implements GenericTypeRegistrant {
                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfMethod.this.hashCode();
                        }

                        protected ReturnTypeTypeRegistrant() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            OfMethod.this.returnTypeToken = token;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance(includeSyntheticFields = true)
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfMethod$ExceptionTypeRegistrant.class */
                    protected class ExceptionTypeRegistrant implements GenericTypeRegistrant {
                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && OfMethod.this.equals(OfMethod.this);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + OfMethod.this.hashCode();
                        }

                        protected ExceptionTypeRegistrant() {
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                        public void register(LazyTypeDescription.GenericTypeToken token) {
                            OfMethod.this.exceptionTypeTokens.add(token);
                        }
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$GenericTypeExtractor$ForSignature$OfRecordComponent.class */
                protected static class OfRecordComponent implements GenericTypeRegistrant {
                    private LazyTypeDescription.GenericTypeToken recordComponentType;

                    protected OfRecordComponent() {
                    }

                    public static LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent extract(String genericSignature) {
                        if (genericSignature == null) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Raw.INSTANCE;
                        }
                        SignatureReader signatureReader = new SignatureReader(genericSignature);
                        OfRecordComponent visitor = new OfRecordComponent();
                        try {
                            signatureReader.acceptType(new GenericTypeExtractor(visitor));
                            return visitor.resolve();
                        } catch (RuntimeException e) {
                            return LazyTypeDescription.GenericTypeToken.Resolution.Malformed.INSTANCE;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.GenericTypeRegistrant
                    public void register(LazyTypeDescription.GenericTypeToken token) {
                        this.recordComponentType = token;
                    }

                    protected LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent resolve() {
                        return new LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent.Tokenized(this.recordComponentType);
                    }
                }
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription.class */
        public static class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType {
            private static final int SUPER_CLASS_INDEX = -1;
            private static final String NO_TYPE = null;
            private final TypePool typePool;
            private final int actualModifiers;
            private final int modifiers;
            private final String name;
            private final String superClassDescriptor;
            private final String genericSignature;
            private final GenericTypeToken.Resolution.ForType signatureResolution;
            private final List<String> interfaceTypeDescriptors;
            private final TypeContainment typeContainment;
            private final String declaringTypeName;
            private final List<String> declaredTypes;
            private final boolean anonymousType;
            private final String nestHost;
            private final List<String> nestMembers;
            private final Map<Integer, Map<String, List<AnnotationToken>>> superTypeAnnotationTokens;
            private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
            private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundsAnnotationTokens;
            private final List<AnnotationToken> annotationTokens;
            private final List<FieldToken> fieldTokens;
            private final List<MethodToken> methodTokens;
            private final List<RecordComponentToken> recordComponentTokens;
            private final List<String> permittedSubclasses;
            private final ClassFileVersion classFileVersion;

            protected LazyTypeDescription(TypePool typePool, int actualModifiers, int modifiers, String name, String superClassInternalName, String[] interfaceInternalName, String genericSignature, TypeContainment typeContainment, String declaringTypeInternalName, List<String> declaredTypes, boolean anonymousType, String nestHostInternalName, List<String> nestMemberInternalNames, Map<Integer, Map<String, List<AnnotationToken>>> superTypeAnnotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundsAnnotationTokens, List<AnnotationToken> annotationTokens, List<FieldToken> fieldTokens, List<MethodToken> methodTokens, List<RecordComponentToken> recordComponentTokens, List<String> permittedSubclasses, ClassFileVersion classFileVersion) {
                this.typePool = typePool;
                this.actualModifiers = actualModifiers & -33;
                this.modifiers = modifiers & -131105;
                this.name = Type.getObjectType(name).getClassName();
                this.superClassDescriptor = superClassInternalName == null ? NO_TYPE : Type.getObjectType(superClassInternalName).getDescriptor();
                this.genericSignature = genericSignature;
                this.signatureResolution = RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfType.extract(genericSignature);
                if (interfaceInternalName == null) {
                    this.interfaceTypeDescriptors = Collections.emptyList();
                } else {
                    this.interfaceTypeDescriptors = new ArrayList(interfaceInternalName.length);
                    for (String internalName : interfaceInternalName) {
                        this.interfaceTypeDescriptors.add(Type.getObjectType(internalName).getDescriptor());
                    }
                }
                this.typeContainment = typeContainment;
                this.declaringTypeName = declaringTypeInternalName == null ? NO_TYPE : declaringTypeInternalName.replace('/', '.');
                this.declaredTypes = declaredTypes;
                this.anonymousType = anonymousType;
                this.nestHost = nestHostInternalName == null ? NO_TYPE : Type.getObjectType(nestHostInternalName).getClassName();
                this.nestMembers = new ArrayList(nestMemberInternalNames.size());
                for (String nestMemberInternalName : nestMemberInternalNames) {
                    this.nestMembers.add(Type.getObjectType(nestMemberInternalName).getClassName());
                }
                this.superTypeAnnotationTokens = superTypeAnnotationTokens;
                this.typeVariableAnnotationTokens = typeVariableAnnotationTokens;
                this.typeVariableBoundsAnnotationTokens = typeVariableBoundsAnnotationTokens;
                this.annotationTokens = annotationTokens;
                this.fieldTokens = fieldTokens;
                this.methodTokens = methodTokens;
                this.recordComponentTokens = recordComponentTokens;
                this.permittedSubclasses = new ArrayList(permittedSubclasses.size());
                for (String internalName2 : permittedSubclasses) {
                    this.permittedSubclasses.add(Type.getObjectType(internalName2).getDescriptor());
                }
                this.classFileVersion = classFileVersion;
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeDescription.Generic getSuperClass() {
                return (this.superClassDescriptor == null || isInterface()) ? TypeDescription.Generic.UNDEFINED : this.signatureResolution.resolveSuperClass(this.superClassDescriptor, this.typePool, this.superTypeAnnotationTokens.get(-1), this);
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public TypeList.Generic getInterfaces() {
                return this.signatureResolution.resolveInterfaceTypes(this.interfaceTypeDescriptors, this.typePool, this.superTypeAnnotationTokens, this);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public MethodDescription.InDefinedShape getEnclosingMethod() {
                return this.typeContainment.getEnclosingMethod(this.typePool);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeDescription getEnclosingType() {
                return this.typeContainment.getEnclosingType(this.typePool);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeList getDeclaredTypes() {
                return new LazyTypeList(this.typePool, this.declaredTypes);
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public boolean isAnonymousType() {
                return this.anonymousType;
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public boolean isLocalType() {
                return !this.anonymousType && this.typeContainment.isLocalType();
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public FieldList<FieldDescription.InDefinedShape> getDeclaredFields() {
                return new FieldTokenList();
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public MethodList<MethodDescription.InDefinedShape> getDeclaredMethods() {
                return new MethodTokenList();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public PackageDescription getPackage() {
                String name = getName();
                int index = name.lastIndexOf(46);
                return new LazyPackageDescription(this.typePool, index == -1 ? "" : name.substring(0, index));
            }

            @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
            public String getName() {
                return this.name;
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
            public TypeDescription getDeclaringType() {
                return this.declaringTypeName == null ? TypeDescription.UNDEFINED : this.typePool.describe(this.declaringTypeName).resolve();
            }

            @Override // net.bytebuddy.description.ModifierReviewable
            public int getModifiers() {
                return this.modifiers;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
            public int getActualModifiers(boolean superFlag) {
                return superFlag ? this.actualModifiers | 32 : this.actualModifiers;
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeDescription getNestHost() {
                return this.nestHost == null ? this : this.typePool.describe(this.nestHost).resolve();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeList getNestMembers() {
                return this.nestHost == null ? new LazyNestMemberList(this, this.typePool, this.nestMembers) : this.typePool.describe(this.nestHost).resolve().getNestMembers();
            }

            @Override // net.bytebuddy.description.annotation.AnnotationSource
            public AnnotationList getDeclaredAnnotations() {
                return LazyAnnotationDescription.asList(this.typePool, this.annotationTokens);
            }

            @Override // net.bytebuddy.description.TypeVariableSource
            public TypeList.Generic getTypeVariables() {
                return this.signatureResolution.resolveTypeVariables(this.typePool, this, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
            public String getGenericSignature() {
                return this.genericSignature;
            }

            @Override // net.bytebuddy.description.type.TypeDescription, net.bytebuddy.description.type.TypeDefinition
            public RecordComponentList<RecordComponentDescription.InDefinedShape> getRecordComponents() {
                return new RecordComponentTokenList();
            }

            @Override // net.bytebuddy.description.type.TypeDefinition
            public boolean isRecord() {
                return (this.actualModifiers & 65536) != 0 && JavaType.RECORD.getTypeStub().getDescriptor().equals(this.superClassDescriptor);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
            public boolean isSealed() {
                return !this.permittedSubclasses.isEmpty();
            }

            @Override // net.bytebuddy.description.type.TypeDescription
            public TypeList getPermittedSubtypes() {
                return new LazyTypeList(this.typePool, this.permittedSubclasses);
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase, net.bytebuddy.description.type.TypeDescription
            public ClassFileVersion getClassFileVersion() {
                return this.classFileVersion;
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$FieldTokenList.class */
            protected class FieldTokenList extends FieldList.AbstractBase<FieldDescription.InDefinedShape> {
                protected FieldTokenList() {
                }

                @Override // java.util.AbstractList, java.util.List
                public FieldDescription.InDefinedShape get(int index) {
                    return ((FieldToken) LazyTypeDescription.this.fieldTokens.get(index)).toFieldDescription(LazyTypeDescription.this);
                }

                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                public int size() {
                    return LazyTypeDescription.this.fieldTokens.size();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$MethodTokenList.class */
            protected class MethodTokenList extends MethodList.AbstractBase<MethodDescription.InDefinedShape> {
                protected MethodTokenList() {
                }

                @Override // java.util.AbstractList, java.util.List
                public MethodDescription.InDefinedShape get(int index) {
                    return ((MethodToken) LazyTypeDescription.this.methodTokens.get(index)).toMethodDescription(LazyTypeDescription.this);
                }

                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                public int size() {
                    return LazyTypeDescription.this.methodTokens.size();
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$RecordComponentTokenList.class */
            protected class RecordComponentTokenList extends RecordComponentList.AbstractBase<RecordComponentDescription.InDefinedShape> {
                protected RecordComponentTokenList() {
                }

                @Override // java.util.AbstractList, java.util.List
                public RecordComponentDescription.InDefinedShape get(int index) {
                    return ((RecordComponentToken) LazyTypeDescription.this.recordComponentTokens.get(index)).toRecordComponentDescription(LazyTypeDescription.this);
                }

                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                public int size() {
                    return LazyTypeDescription.this.recordComponentTokens.size();
                }
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TypeContainment.class */
            public interface TypeContainment {
                MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool);

                TypeDescription getEnclosingType(TypePool typePool);

                boolean isSelfContained();

                boolean isLocalType();

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TypeContainment$SelfContained.class */
                public enum SelfContained implements TypeContainment {
                    INSTANCE;

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        return MethodDescription.UNDEFINED;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return TypeDescription.UNDEFINED;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isSelfContained() {
                        return true;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isLocalType() {
                        return false;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TypeContainment$WithinType.class */
                public static class WithinType implements TypeContainment {
                    private final String name;
                    private final boolean localType;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.localType == ((WithinType) obj).localType && this.name.equals(((WithinType) obj).name);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + (this.localType ? 1 : 0);
                    }

                    protected WithinType(String internalName, boolean localType) {
                        this.name = internalName.replace('/', '.');
                        this.localType = localType;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        return MethodDescription.UNDEFINED;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return typePool.describe(this.name).resolve();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isSelfContained() {
                        return false;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isLocalType() {
                        return this.localType;
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TypeContainment$WithinMethod.class */
                public static class WithinMethod implements TypeContainment {
                    private final String name;
                    private final String methodName;
                    private final String methodDescriptor;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((WithinMethod) obj).name) && this.methodName.equals(((WithinMethod) obj).methodName) && this.methodDescriptor.equals(((WithinMethod) obj).methodDescriptor);
                    }

                    public int hashCode() {
                        return (((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.methodName.hashCode()) * 31) + this.methodDescriptor.hashCode();
                    }

                    protected WithinMethod(String internalName, String methodName, String methodDescriptor) {
                        this.name = internalName.replace('/', '.');
                        this.methodName = methodName;
                        this.methodDescriptor = methodDescriptor;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public MethodDescription.InDefinedShape getEnclosingMethod(TypePool typePool) {
                        TypeDescription enclosingType = getEnclosingType(typePool);
                        MethodList enclosingMethod = enclosingType.getDeclaredMethods().filter(ElementMatchers.hasMethodName(this.methodName).and(ElementMatchers.hasDescriptor(this.methodDescriptor)));
                        if (!enclosingMethod.isEmpty()) {
                            return (MethodDescription.InDefinedShape) enclosingMethod.getOnly();
                        }
                        throw new IllegalStateException(this.methodName + this.methodDescriptor + " not declared by " + enclosingType);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public TypeDescription getEnclosingType(TypePool typePool) {
                        return typePool.describe(this.name).resolve();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isSelfContained() {
                        return false;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.TypeContainment
                    public boolean isLocalType() {
                        return true;
                    }
                }
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken.class */
            public interface GenericTypeToken {
                public static final String EMPTY_TYPE_PATH = "";
                public static final char COMPONENT_TYPE_PATH = '[';
                public static final char WILDCARD_TYPE_PATH = '*';
                public static final char INNER_CLASS_PATH = '.';
                public static final char INDEXED_TYPE_DELIMITER = ';';

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$OfFormalTypeVariable.class */
                public interface OfFormalTypeVariable {
                    TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, Map<String, List<AnnotationToken>> map, Map<Integer, Map<String, List<AnnotationToken>>> map2);
                }

                TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String str, Map<String, List<AnnotationToken>> map);

                boolean isPrimaryBound(TypePool typePool);

                String getTypePathPrefix();

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForPrimitiveType.class */
                public enum ForPrimitiveType implements GenericTypeToken {
                    BOOLEAN(Boolean.TYPE),
                    BYTE(Byte.TYPE),
                    SHORT(Short.TYPE),
                    CHAR(Character.TYPE),
                    INTEGER(Integer.TYPE),
                    LONG(Long.TYPE),
                    FLOAT(Float.TYPE),
                    DOUBLE(Double.TYPE),
                    VOID(Void.TYPE);
                    
                    private final TypeDescription typeDescription;

                    ForPrimitiveType(Class cls) {
                        this.typeDescription = TypeDescription.ForLoadedType.m247of(cls);
                    }

                    /* renamed from: of */
                    public static GenericTypeToken m88of(char descriptor) {
                        switch (descriptor) {
                            case 'B':
                                return BYTE;
                            case 'C':
                                return CHAR;
                            case 'D':
                                return DOUBLE;
                            case 'E':
                            case 'G':
                            case 'H':
                            case 'K':
                            case 'L':
                            case 'M':
                            case 'N':
                            case 'O':
                            case 'P':
                            case 'Q':
                            case 'R':
                            case 'T':
                            case 'U':
                            case 'W':
                            case 'X':
                            case 'Y':
                            default:
                                throw new IllegalArgumentException("Not a valid primitive type descriptor: " + descriptor);
                            case 'F':
                                return FLOAT;
                            case 'I':
                                return INTEGER;
                            case 'J':
                                return LONG;
                            case 'S':
                                return SHORT;
                            case 'V':
                                return VOID;
                            case 'Z':
                                return BOOLEAN;
                        }
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new LazyPrimitiveType(typePool, typePath, annotationTokens == null ? Collections.emptyMap() : annotationTokens, this.typeDescription);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A primitive type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A primitive type cannot be the owner of a nested type: " + this);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForPrimitiveType$LazyPrimitiveType.class */
                    protected static class LazyPrimitiveType extends TypeDescription.Generic.OfNonGenericType {
                        private final TypePool typePool;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final TypeDescription typeDescription;

                        protected LazyPrimitiveType(TypePool typePool, String typePath, Map<String, List<AnnotationToken>> annotationTokens, TypeDescription typeDescription) {
                            this.typePool = typePool;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                            this.typeDescription = typeDescription;
                        }

                        @Override // net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription asErasure() {
                            return this.typeDescription;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeDescription.Generic getOwnerType() {
                            return TypeDescription.Generic.UNDEFINED;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription.Generic getComponentType() {
                            return TypeDescription.Generic.UNDEFINED;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForUnboundWildcard.class */
                public enum ForUnboundWildcard implements GenericTypeToken {
                    INSTANCE;

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new LazyUnboundWildcard(typePool, typePath, annotationTokens == null ? Collections.emptyMap() : annotationTokens);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("An unbound wildcard cannot be the owner of a nested type: " + this);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForUnboundWildcard$LazyUnboundWildcard.class */
                    protected static class LazyUnboundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final TypePool typePool;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;

                        protected LazyUnboundWildcard(TypePool typePool, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                            this.typePool = typePool;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return new TypeList.Generic.Explicit(TypeDescription.Generic.OBJECT);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getLowerBounds() {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution.class */
                public interface Resolution {
                    TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> map, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> map2);

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$Raw.class */
                    public enum Raw implements ForType, ForField, ForMethod, ForRecordComponent {
                        INSTANCE;

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeDescription.Generic resolveSuperClass(String superClassDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, TypeDescription definingType) {
                            return RawAnnotatedType.m87of(typePool, annotationTokens, superClassDescriptor);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeList.Generic resolveInterfaceTypes(List<String> interfaceTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, TypeDescription definingType) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.m86of(typePool, annotationTokens, interfaceTypeDescriptors);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                        public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens) {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField
                        public TypeDescription.Generic resolveFieldType(String fieldTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, FieldDescription.InDefinedShape definingField) {
                            return RawAnnotatedType.m87of(typePool, annotationTokens, fieldTypeDescriptor);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeDescription.Generic resolveReturnType(String returnTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                            return RawAnnotatedType.m87of(typePool, annotationTokens, returnTypeDescriptor);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveParameterTypes(List<String> parameterTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.m86of(typePool, annotationTokens, parameterTypeDescriptors);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveExceptionTypes(List<String> exceptionTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                            return RawAnnotatedType.LazyRawAnnotatedTypeList.m86of(typePool, annotationTokens, exceptionTypeDescriptors);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent
                        public TypeDescription.Generic resolveRecordType(String recordTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, RecordComponentDescription definingRecordComponent) {
                            return RawAnnotatedType.m87of(typePool, annotationTokens, recordTypeDescriptor);
                        }

                        /* access modifiers changed from: protected */
                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$Raw$RawAnnotatedType.class */
                        public static class RawAnnotatedType extends TypeDescription.Generic.OfNonGenericType {
                            private final TypePool typePool;
                            private final String typePath;
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final TypeDescription typeDescription;

                            protected RawAnnotatedType(TypePool typePool, String typePath, Map<String, List<AnnotationToken>> annotationTokens, TypeDescription typeDescription) {
                                this.typePool = typePool;
                                this.typePath = typePath;
                                this.annotationTokens = annotationTokens;
                                this.typeDescription = typeDescription;
                            }

                            /* renamed from: of */
                            protected static TypeDescription.Generic m87of(TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, String descriptor) {
                                return new RawAnnotatedType(typePool, "", annotationTokens == null ? Collections.emptyMap() : annotationTokens, TokenizedGenericType.toErasure(typePool, descriptor));
                            }

                            @Override // net.bytebuddy.description.type.TypeDefinition
                            public TypeDescription asErasure() {
                                return this.typeDescription;
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeDescription.Generic getOwnerType() {
                                TypeDescription declaringType = this.typeDescription.getDeclaringType();
                                return declaringType == null ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath, this.annotationTokens, declaringType);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                            public TypeDescription.Generic getComponentType() {
                                TypeDescription componentType = this.typeDescription.getComponentType();
                                return componentType == null ? TypeDescription.Generic.UNDEFINED : new RawAnnotatedType(this.typePool, this.typePath + '[', this.annotationTokens, componentType);
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                StringBuilder typePath = new StringBuilder(this.typePath);
                                for (int index = 0; index < this.typeDescription.getInnerClassCount(); index++) {
                                    typePath = typePath.append('.');
                                }
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(typePath.toString()));
                            }

                            /* access modifiers changed from: protected */
                            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$Raw$RawAnnotatedType$LazyRawAnnotatedTypeList.class */
                            public static class LazyRawAnnotatedTypeList extends TypeList.Generic.AbstractBase {
                                private final TypePool typePool;
                                private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                                private final List<String> descriptors;

                                protected LazyRawAnnotatedTypeList(TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, List<String> descriptors) {
                                    this.typePool = typePool;
                                    this.annotationTokens = annotationTokens;
                                    this.descriptors = descriptors;
                                }

                                /* renamed from: of */
                                protected static TypeList.Generic m86of(TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, List<String> descriptors) {
                                    return new LazyRawAnnotatedTypeList(typePool, annotationTokens == null ? Collections.emptyMap() : annotationTokens, descriptors);
                                }

                                @Override // java.util.AbstractList, java.util.List
                                public TypeDescription.Generic get(int index) {
                                    return RawAnnotatedType.m87of(this.typePool, this.annotationTokens.get(Integer.valueOf(index)), this.descriptors.get(index));
                                }

                                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                                public int size() {
                                    return this.descriptors.size();
                                }

                                @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                                public TypeList asErasures() {
                                    return new LazyTypeList(this.typePool, this.descriptors);
                                }

                                @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                                public TypeList.Generic asRawTypes() {
                                    return this;
                                }

                                @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                                public int getStackSize() {
                                    int stackSize = 0;
                                    for (String descriptor : this.descriptors) {
                                        stackSize += Type.getType(descriptor).getSize();
                                    }
                                    return stackSize;
                                }
                            }
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$Malformed.class */
                    public enum Malformed implements ForType, ForField, ForMethod, ForRecordComponent {
                        INSTANCE;

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeDescription.Generic resolveSuperClass(String superClassDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, TypeDescription definingType) {
                            return new TokenizedGenericType.Malformed(typePool, superClassDescriptor);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                        public TypeList.Generic resolveInterfaceTypes(List<String> interfaceTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, TypeDescription definingType) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, interfaceTypeDescriptors);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                        public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens) {
                            throw new GenericSignatureFormatError();
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField
                        public TypeDescription.Generic resolveFieldType(String fieldTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, FieldDescription.InDefinedShape definingField) {
                            return new TokenizedGenericType.Malformed(typePool, fieldTypeDescriptor);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeDescription.Generic resolveReturnType(String returnTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                            return new TokenizedGenericType.Malformed(typePool, returnTypeDescriptor);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveParameterTypes(List<String> parameterTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, parameterTypeDescriptors);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                        public TypeList.Generic resolveExceptionTypes(List<String> exceptionTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                            return new TokenizedGenericType.Malformed.TokenList(typePool, exceptionTypeDescriptors);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent
                        public TypeDescription.Generic resolveRecordType(String recordTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, RecordComponentDescription definingRecordComponent) {
                            return new TokenizedGenericType.Malformed(typePool, recordTypeDescriptor);
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForType.class */
                    public interface ForType extends Resolution {
                        TypeDescription.Generic resolveSuperClass(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, TypeDescription typeDescription);

                        TypeList.Generic resolveInterfaceTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, TypeDescription typeDescription);

                        @HashCodeAndEqualsPlugin.Enhance
                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForType$Tokenized.class */
                        public static class Tokenized implements ForType {
                            private final GenericTypeToken superClassToken;
                            private final List<GenericTypeToken> interfaceTypeTokens;
                            private final List<OfFormalTypeVariable> typeVariableTokens;

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.superClassToken.equals(((Tokenized) obj).superClassToken) && this.interfaceTypeTokens.equals(((Tokenized) obj).interfaceTypeTokens) && this.typeVariableTokens.equals(((Tokenized) obj).typeVariableTokens);
                            }

                            public int hashCode() {
                                return (((((getClass().hashCode() * 31) + this.superClassToken.hashCode()) * 31) + this.interfaceTypeTokens.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                            }

                            protected Tokenized(GenericTypeToken superClassToken, List<GenericTypeToken> interfaceTypeTokens, List<OfFormalTypeVariable> typeVariableTokens) {
                                this.superClassToken = superClassToken;
                                this.interfaceTypeTokens = interfaceTypeTokens;
                                this.typeVariableTokens = typeVariableTokens;
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                            public TypeDescription.Generic resolveSuperClass(String superClassDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, TypeDescription definingType) {
                                return TokenizedGenericType.m85of(typePool, this.superClassToken, superClassDescriptor, annotationTokens, definingType);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForType
                            public TypeList.Generic resolveInterfaceTypes(List<String> interfaceTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, TypeDescription definingType) {
                                return new TokenizedGenericType.TokenList(typePool, this.interfaceTypeTokens, annotationTokens, interfaceTypeDescriptors, definingType);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                            public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens) {
                                return new TokenizedGenericType.TypeVariableList(typePool, this.typeVariableTokens, typeVariableSource, annotationTokens, boundAnnotationTokens);
                            }
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForField.class */
                    public interface ForField {
                        TypeDescription.Generic resolveFieldType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, FieldDescription.InDefinedShape inDefinedShape);

                        @HashCodeAndEqualsPlugin.Enhance
                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForField$Tokenized.class */
                        public static class Tokenized implements ForField {
                            private final GenericTypeToken fieldTypeToken;

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.fieldTypeToken.equals(((Tokenized) obj).fieldTypeToken);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.fieldTypeToken.hashCode();
                            }

                            protected Tokenized(GenericTypeToken fieldTypeToken) {
                                this.fieldTypeToken = fieldTypeToken;
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForField
                            public TypeDescription.Generic resolveFieldType(String fieldTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, FieldDescription.InDefinedShape definingField) {
                                return TokenizedGenericType.m85of(typePool, this.fieldTypeToken, fieldTypeDescriptor, annotationTokens, definingField.getDeclaringType());
                            }
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForMethod.class */
                    public interface ForMethod extends Resolution {
                        TypeDescription.Generic resolveReturnType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, MethodDescription.InDefinedShape inDefinedShape);

                        TypeList.Generic resolveParameterTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape);

                        TypeList.Generic resolveExceptionTypes(List<String> list, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> map, MethodDescription.InDefinedShape inDefinedShape);

                        @HashCodeAndEqualsPlugin.Enhance
                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForMethod$Tokenized.class */
                        public static class Tokenized implements ForMethod {
                            private final GenericTypeToken returnTypeToken;
                            private final List<GenericTypeToken> parameterTypeTokens;
                            private final List<GenericTypeToken> exceptionTypeTokens;
                            private final List<OfFormalTypeVariable> typeVariableTokens;

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.returnTypeToken.equals(((Tokenized) obj).returnTypeToken) && this.parameterTypeTokens.equals(((Tokenized) obj).parameterTypeTokens) && this.exceptionTypeTokens.equals(((Tokenized) obj).exceptionTypeTokens) && this.typeVariableTokens.equals(((Tokenized) obj).typeVariableTokens);
                            }

                            public int hashCode() {
                                return (((((((getClass().hashCode() * 31) + this.returnTypeToken.hashCode()) * 31) + this.parameterTypeTokens.hashCode()) * 31) + this.exceptionTypeTokens.hashCode()) * 31) + this.typeVariableTokens.hashCode();
                            }

                            protected Tokenized(GenericTypeToken returnTypeToken, List<GenericTypeToken> parameterTypeTokens, List<GenericTypeToken> exceptionTypeTokens, List<OfFormalTypeVariable> typeVariableTokens) {
                                this.returnTypeToken = returnTypeToken;
                                this.parameterTypeTokens = parameterTypeTokens;
                                this.exceptionTypeTokens = exceptionTypeTokens;
                                this.typeVariableTokens = typeVariableTokens;
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                            public TypeDescription.Generic resolveReturnType(String returnTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                                return TokenizedGenericType.m85of(typePool, this.returnTypeToken, returnTypeDescriptor, annotationTokens, definingMethod);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                            public TypeList.Generic resolveParameterTypes(List<String> parameterTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                                return new TokenizedGenericType.TokenList(typePool, this.parameterTypeTokens, annotationTokens, parameterTypeDescriptors, definingMethod);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForMethod
                            public TypeList.Generic resolveExceptionTypes(List<String> exceptionTypeDescriptors, TypePool typePool, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, MethodDescription.InDefinedShape definingMethod) {
                                return this.exceptionTypeTokens.isEmpty() ? Raw.INSTANCE.resolveExceptionTypes(exceptionTypeDescriptors, typePool, annotationTokens, definingMethod) : new TokenizedGenericType.TokenList(typePool, this.exceptionTypeTokens, annotationTokens, exceptionTypeDescriptors, definingMethod);
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution
                            public TypeList.Generic resolveTypeVariables(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens) {
                                return new TokenizedGenericType.TypeVariableList(typePool, this.typeVariableTokens, typeVariableSource, annotationTokens, boundAnnotationTokens);
                            }
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForRecordComponent.class */
                    public interface ForRecordComponent {
                        TypeDescription.Generic resolveRecordType(String str, TypePool typePool, Map<String, List<AnnotationToken>> map, RecordComponentDescription recordComponentDescription);

                        @HashCodeAndEqualsPlugin.Enhance
                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$Resolution$ForRecordComponent$Tokenized.class */
                        public static class Tokenized implements ForRecordComponent {
                            private final GenericTypeToken recordComponentTypeToken;

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                return obj != null && getClass() == obj.getClass() && this.recordComponentTypeToken.equals(((Tokenized) obj).recordComponentTypeToken);
                            }

                            public int hashCode() {
                                return (getClass().hashCode() * 31) + this.recordComponentTypeToken.hashCode();
                            }

                            protected Tokenized(GenericTypeToken recordComponentTypeToken) {
                                this.recordComponentTypeToken = recordComponentTypeToken;
                            }

                            @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.Resolution.ForRecordComponent
                            public TypeDescription.Generic resolveRecordType(String recordTypeDescriptor, TypePool typePool, Map<String, List<AnnotationToken>> annotationTokens, RecordComponentDescription definingRecordComponent) {
                                return TokenizedGenericType.m85of(typePool, this.recordComponentTypeToken, recordTypeDescriptor, annotationTokens, TypeVariableSource.UNDEFINED);
                            }
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForRawType.class */
                public static class ForRawType implements GenericTypeToken {
                    private final String name;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((ForRawType) obj).name);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.name.hashCode();
                    }

                    protected ForRawType(String name) {
                        this.name = name;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new Resolution.Raw.RawAnnotatedType(typePool, typePath, annotationTokens == null ? Collections.emptyMap() : annotationTokens, typePool.describe(this.name).resolve());
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        return !typePool.describe(this.name).resolve().isInterface();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A non-generic type cannot be the owner of a nested type: " + this);
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForTypeVariable.class */
                public static class ForTypeVariable implements GenericTypeToken {
                    private final String symbol;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.symbol.equals(((ForTypeVariable) obj).symbol);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.symbol.hashCode();
                    }

                    protected ForTypeVariable(String symbol) {
                        this.symbol = symbol;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        TypeDescription.Generic typeVariable = typeVariableSource.findVariable(this.symbol);
                        if (typeVariable == null) {
                            return new UnresolvedTypeVariable(typeVariableSource, typePool, this.symbol, annotationTokens.get(typePath));
                        }
                        return new AnnotatedTypeVariable(typePool, annotationTokens.get(typePath), typeVariable);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        return true;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A type variable cannot be the owner of a nested type: " + this);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForTypeVariable$AnnotatedTypeVariable.class */
                    protected static class AnnotatedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                        private final TypePool typePool;
                        private final List<AnnotationToken> annotationTokens;
                        private final TypeDescription.Generic typeVariable;

                        protected AnnotatedTypeVariable(TypePool typePool, List<AnnotationToken> annotationTokens, TypeDescription.Generic typeVariable) {
                            this.typePool = typePool;
                            this.annotationTokens = annotationTokens;
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
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForTypeVariable$UnresolvedTypeVariable.class */
                    protected static class UnresolvedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                        private final TypeVariableSource typeVariableSource;
                        private final TypePool typePool;
                        private final String symbol;
                        private final List<AnnotationToken> annotationTokens;

                        protected UnresolvedTypeVariable(TypeVariableSource typeVariableSource, TypePool typePool, String symbol, List<AnnotationToken> annotationTokens) {
                            this.typeVariableSource = typeVariableSource;
                            this.typePool = typePool;
                            this.symbol = symbol;
                            this.annotationTokens = annotationTokens;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            throw new IllegalStateException("Cannot resolve bounds of unresolved type variable " + this + " by " + this.typeVariableSource);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeVariableSource getTypeVariableSource() {
                            return this.typeVariableSource;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public String getSymbol() {
                            return this.symbol;
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens);
                        }
                    }

                    /* access modifiers changed from: protected */
                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForTypeVariable$Formal.class */
                    public static class Formal implements OfFormalTypeVariable {
                        private final String symbol;
                        private final List<GenericTypeToken> boundTypeTokens;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.symbol.equals(((Formal) obj).symbol) && this.boundTypeTokens.equals(((Formal) obj).boundTypeTokens);
                        }

                        public int hashCode() {
                            return (((getClass().hashCode() * 31) + this.symbol.hashCode()) * 31) + this.boundTypeTokens.hashCode();
                        }

                        protected Formal(String symbol, List<GenericTypeToken> boundTypeTokens) {
                            this.symbol = symbol;
                            this.boundTypeTokens = boundTypeTokens;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken.OfFormalTypeVariable
                        public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, Map<String, List<AnnotationToken>> annotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> boundaryAnnotationTokens) {
                            return new LazyTypeVariable(typePool, typeVariableSource, annotationTokens == null ? Collections.emptyMap() : annotationTokens, boundaryAnnotationTokens == null ? Collections.emptyMap() : boundaryAnnotationTokens, this.symbol, this.boundTypeTokens);
                        }

                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForTypeVariable$Formal$LazyTypeVariable.class */
                        protected static class LazyTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                            private final TypePool typePool;
                            private final TypeVariableSource typeVariableSource;
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final Map<Integer, Map<String, List<AnnotationToken>>> boundaryAnnotationTokens;
                            private final String symbol;
                            private final List<GenericTypeToken> boundTypeTokens;

                            protected LazyTypeVariable(TypePool typePool, TypeVariableSource typeVariableSource, Map<String, List<AnnotationToken>> annotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> boundaryAnnotationTokens, String symbol, List<GenericTypeToken> boundTypeTokens) {
                                this.typePool = typePool;
                                this.typeVariableSource = typeVariableSource;
                                this.annotationTokens = annotationTokens;
                                this.boundaryAnnotationTokens = boundaryAnnotationTokens;
                                this.symbol = symbol;
                                this.boundTypeTokens = boundTypeTokens;
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeList.Generic getUpperBounds() {
                                return new LazyBoundTokenList(this.typePool, this.typeVariableSource, this.boundaryAnnotationTokens, this.boundTypeTokens);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeVariableSource getTypeVariableSource() {
                                return this.typeVariableSource;
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public String getSymbol() {
                                return this.symbol;
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(""));
                            }

                            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForTypeVariable$Formal$LazyTypeVariable$LazyBoundTokenList.class */
                            protected static class LazyBoundTokenList extends TypeList.Generic.AbstractBase {
                                private final TypePool typePool;
                                private final TypeVariableSource typeVariableSource;
                                private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                                private final List<GenericTypeToken> boundTypeTokens;

                                protected LazyBoundTokenList(TypePool typePool, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, List<GenericTypeToken> boundTypeTokens) {
                                    this.typePool = typePool;
                                    this.typeVariableSource = typeVariableSource;
                                    this.annotationTokens = annotationTokens;
                                    this.boundTypeTokens = boundTypeTokens;
                                }

                                @Override // java.util.AbstractList, java.util.List
                                public TypeDescription.Generic get(int index) {
                                    Map<String, List<AnnotationToken>> annotationTokens;
                                    if (this.annotationTokens.containsKey(Integer.valueOf(index)) || this.annotationTokens.containsKey(Integer.valueOf(index + 1))) {
                                        annotationTokens = this.annotationTokens.get(Integer.valueOf(index + (this.boundTypeTokens.get(0).isPrimaryBound(this.typePool) ? 0 : 1)));
                                    } else {
                                        annotationTokens = Collections.emptyMap();
                                    }
                                    return this.boundTypeTokens.get(index).toGenericType(this.typePool, this.typeVariableSource, "", annotationTokens == null ? Collections.emptyMap() : annotationTokens);
                                }

                                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                                public int size() {
                                    return this.boundTypeTokens.size();
                                }
                            }
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForGenericArray.class */
                public static class ForGenericArray implements GenericTypeToken {
                    private final GenericTypeToken componentTypeToken;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.componentTypeToken.equals(((ForGenericArray) obj).componentTypeToken);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.componentTypeToken.hashCode();
                    }

                    protected ForGenericArray(GenericTypeToken componentTypeToken) {
                        this.componentTypeToken = componentTypeToken;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new LazyGenericArray(typePool, typeVariableSource, typePath, annotationTokens, this.componentTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A generic array type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A generic array type cannot be the owner of a nested type: " + this);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForGenericArray$LazyGenericArray.class */
                    protected static class LazyGenericArray extends TypeDescription.Generic.OfGenericArray {
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken componentTypeToken;

                        protected LazyGenericArray(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, GenericTypeToken componentTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                            this.componentTypeToken = componentTypeToken;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription.Generic getComponentType() {
                            return this.componentTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath + '[', this.annotationTokens);
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForLowerBoundWildcard.class */
                public static class ForLowerBoundWildcard implements GenericTypeToken {
                    private final GenericTypeToken boundTypeToken;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.boundTypeToken.equals(((ForLowerBoundWildcard) obj).boundTypeToken);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.boundTypeToken.hashCode();
                    }

                    protected ForLowerBoundWildcard(GenericTypeToken boundTypeToken) {
                        this.boundTypeToken = boundTypeToken;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new LazyLowerBoundWildcard(typePool, typeVariableSource, typePath, annotationTokens, this.boundTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("A lower bound wildcard cannot be the owner of a nested type: " + this);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForLowerBoundWildcard$LazyLowerBoundWildcard.class */
                    protected static class LazyLowerBoundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken boundTypeToken;

                        protected LazyLowerBoundWildcard(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, GenericTypeToken boundTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                            this.boundTypeToken = boundTypeToken;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return new TypeList.Generic.Explicit(TypeDescription.Generic.OBJECT);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getLowerBounds() {
                            return new LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForUpperBoundWildcard.class */
                public static class ForUpperBoundWildcard implements GenericTypeToken {
                    private final GenericTypeToken boundTypeToken;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.boundTypeToken.equals(((ForUpperBoundWildcard) obj).boundTypeToken);
                    }

                    public int hashCode() {
                        return (getClass().hashCode() * 31) + this.boundTypeToken.hashCode();
                    }

                    protected ForUpperBoundWildcard(GenericTypeToken boundTypeToken) {
                        this.boundTypeToken = boundTypeToken;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new LazyUpperBoundWildcard(typePool, typeVariableSource, typePath, annotationTokens, this.boundTypeToken);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        throw new IllegalStateException("A wildcard type cannot be a type variable bound: " + this);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        throw new IllegalStateException("An upper bound wildcard cannot be the owner of a nested type: " + this);
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForUpperBoundWildcard$LazyUpperBoundWildcard.class */
                    protected static class LazyUpperBoundWildcard extends TypeDescription.Generic.OfWildcardType {
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken boundTypeToken;

                        protected LazyUpperBoundWildcard(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, GenericTypeToken boundTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                            this.boundTypeToken = boundTypeToken;
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getUpperBounds() {
                            return new LazyTokenList.ForWildcardBound(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.boundTypeToken);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getLowerBounds() {
                            return new TypeList.Generic.Empty();
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }
                    }
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForParameterizedType.class */
                public static class ForParameterizedType implements GenericTypeToken {
                    private final String name;
                    private final List<GenericTypeToken> parameterTypeTokens;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.name.equals(((ForParameterizedType) obj).name) && this.parameterTypeTokens.equals(((ForParameterizedType) obj).parameterTypeTokens);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.parameterTypeTokens.hashCode();
                    }

                    protected ForParameterizedType(String name, List<GenericTypeToken> parameterTypeTokens) {
                        this.name = name;
                        this.parameterTypeTokens = parameterTypeTokens;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                        return new LazyParameterizedType(typePool, typeVariableSource, typePath, annotationTokens, this.name, this.parameterTypeTokens);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public boolean isPrimaryBound(TypePool typePool) {
                        return !typePool.describe(this.name).resolve().isInterface();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                    public String getTypePathPrefix() {
                        return String.valueOf('.');
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForParameterizedType$Nested.class */
                    public static class Nested implements GenericTypeToken {
                        private final String name;
                        private final List<GenericTypeToken> parameterTypeTokens;
                        private final GenericTypeToken ownerTypeToken;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.name.equals(((Nested) obj).name) && this.parameterTypeTokens.equals(((Nested) obj).parameterTypeTokens) && this.ownerTypeToken.equals(((Nested) obj).ownerTypeToken);
                        }

                        public int hashCode() {
                            return (((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.parameterTypeTokens.hashCode()) * 31) + this.ownerTypeToken.hashCode();
                        }

                        protected Nested(String name, List<GenericTypeToken> parameterTypeTokens, GenericTypeToken ownerTypeToken) {
                            this.name = name;
                            this.parameterTypeTokens = parameterTypeTokens;
                            this.ownerTypeToken = ownerTypeToken;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                        public TypeDescription.Generic toGenericType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens) {
                            return new LazyParameterizedType(typePool, typeVariableSource, typePath, annotationTokens, this.name, this.parameterTypeTokens, this.ownerTypeToken);
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                        public String getTypePathPrefix() {
                            return this.ownerTypeToken.getTypePathPrefix() + '.';
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.GenericTypeToken
                        public boolean isPrimaryBound(TypePool typePool) {
                            return !typePool.describe(this.name).resolve().isInterface();
                        }

                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForParameterizedType$Nested$LazyParameterizedType.class */
                        protected static class LazyParameterizedType extends TypeDescription.Generic.OfParameterizedType {
                            private final TypePool typePool;
                            private final TypeVariableSource typeVariableSource;
                            private final String typePath;
                            private final Map<String, List<AnnotationToken>> annotationTokens;
                            private final String name;
                            private final List<GenericTypeToken> parameterTypeTokens;
                            private final GenericTypeToken ownerTypeToken;

                            protected LazyParameterizedType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, String name, List<GenericTypeToken> parameterTypeTokens, GenericTypeToken ownerTypeToken) {
                                this.typePool = typePool;
                                this.typeVariableSource = typeVariableSource;
                                this.typePath = typePath;
                                this.annotationTokens = annotationTokens;
                                this.name = name;
                                this.parameterTypeTokens = parameterTypeTokens;
                                this.ownerTypeToken = ownerTypeToken;
                            }

                            @Override // net.bytebuddy.description.type.TypeDefinition
                            public TypeDescription asErasure() {
                                return this.typePool.describe(this.name).resolve();
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeList.Generic getTypeArguments() {
                                return new LazyTokenList(this.typePool, this.typeVariableSource, this.typePath + this.ownerTypeToken.getTypePathPrefix(), this.annotationTokens, this.parameterTypeTokens);
                            }

                            @Override // net.bytebuddy.description.type.TypeDescription.Generic
                            public TypeDescription.Generic getOwnerType() {
                                return this.ownerTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens);
                            }

                            @Override // net.bytebuddy.description.annotation.AnnotationSource
                            public AnnotationList getDeclaredAnnotations() {
                                return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath + this.ownerTypeToken.getTypePathPrefix()));
                            }
                        }
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$ForParameterizedType$LazyParameterizedType.class */
                    protected static class LazyParameterizedType extends TypeDescription.Generic.OfParameterizedType {
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final String name;
                        private final List<GenericTypeToken> parameterTypeTokens;

                        protected LazyParameterizedType(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, String name, List<GenericTypeToken> parameterTypeTokens) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                            this.name = name;
                            this.parameterTypeTokens = parameterTypeTokens;
                        }

                        @Override // net.bytebuddy.description.type.TypeDefinition
                        public TypeDescription asErasure() {
                            return this.typePool.describe(this.name).resolve();
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeList.Generic getTypeArguments() {
                            return new LazyTokenList(this.typePool, this.typeVariableSource, this.typePath, this.annotationTokens, this.parameterTypeTokens);
                        }

                        @Override // net.bytebuddy.description.type.TypeDescription.Generic
                        public TypeDescription.Generic getOwnerType() {
                            TypeDescription ownerType = this.typePool.describe(this.name).resolve().getEnclosingType();
                            return ownerType == null ? TypeDescription.Generic.UNDEFINED : ownerType.asGenericType();
                        }

                        @Override // net.bytebuddy.description.annotation.AnnotationSource
                        public AnnotationList getDeclaredAnnotations() {
                            return LazyAnnotationDescription.asListOfNullable(this.typePool, this.annotationTokens.get(this.typePath));
                        }
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$LazyTokenList.class */
                public static class LazyTokenList extends TypeList.Generic.AbstractBase {
                    private final TypePool typePool;
                    private final TypeVariableSource typeVariableSource;
                    private final String typePath;
                    private final Map<String, List<AnnotationToken>> annotationTokens;
                    private final List<GenericTypeToken> genericTypeTokens;

                    protected LazyTokenList(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, List<GenericTypeToken> genericTypeTokens) {
                        this.typePool = typePool;
                        this.typeVariableSource = typeVariableSource;
                        this.typePath = typePath;
                        this.annotationTokens = annotationTokens;
                        this.genericTypeTokens = genericTypeTokens;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int index) {
                        return this.genericTypeTokens.get(index).toGenericType(this.typePool, this.typeVariableSource, this.typePath + index + ';', this.annotationTokens);
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.genericTypeTokens.size();
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$GenericTypeToken$LazyTokenList$ForWildcardBound.class */
                    protected static class ForWildcardBound extends TypeList.Generic.AbstractBase {
                        private final TypePool typePool;
                        private final TypeVariableSource typeVariableSource;
                        private final String typePath;
                        private final Map<String, List<AnnotationToken>> annotationTokens;
                        private final GenericTypeToken genericTypeToken;

                        protected ForWildcardBound(TypePool typePool, TypeVariableSource typeVariableSource, String typePath, Map<String, List<AnnotationToken>> annotationTokens, GenericTypeToken genericTypeToken) {
                            this.typePool = typePool;
                            this.typeVariableSource = typeVariableSource;
                            this.typePath = typePath;
                            this.annotationTokens = annotationTokens;
                            this.genericTypeToken = genericTypeToken;
                        }

                        @Override // java.util.AbstractList, java.util.List
                        public TypeDescription.Generic get(int index) {
                            if (index == 0) {
                                return this.genericTypeToken.toGenericType(this.typePool, this.typeVariableSource, this.typePath + '*', this.annotationTokens);
                            }
                            throw new IndexOutOfBoundsException("index = " + index);
                        }

                        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                        public int size() {
                            return 1;
                        }
                    }
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$AnnotationToken.class */
            public static class AnnotationToken {
                private final String descriptor;
                private final Map<String, AnnotationValue<?, ?>> values;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.descriptor.equals(((AnnotationToken) obj).descriptor) && this.values.equals(((AnnotationToken) obj).values);
                }

                public int hashCode() {
                    return (((getClass().hashCode() * 31) + this.descriptor.hashCode()) * 31) + this.values.hashCode();
                }

                protected AnnotationToken(String descriptor, Map<String, AnnotationValue<?, ?>> values) {
                    this.descriptor = descriptor;
                    this.values = values;
                }

                protected Map<String, AnnotationValue<?, ?>> getValues() {
                    return this.values;
                }

                protected String getBinaryName() {
                    return this.descriptor.substring(1, this.descriptor.length() - 1).replace('/', '.');
                }

                /* access modifiers changed from: private */
                public Resolution toAnnotationDescription(TypePool typePool) {
                    Resolution resolution = typePool.describe(getBinaryName());
                    if (resolution.isResolved()) {
                        return new Resolution.Simple(new LazyAnnotationDescription(typePool, resolution.resolve(), this.values));
                    }
                    return new Resolution.Illegal(getBinaryName());
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$AnnotationToken$Resolution.class */
                public interface Resolution {
                    boolean isResolved();

                    AnnotationDescription resolve();

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$AnnotationToken$Resolution$Simple.class */
                    public static class Simple implements Resolution {
                        private final AnnotationDescription annotationDescription;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.annotationDescription.equals(((Simple) obj).annotationDescription);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.annotationDescription.hashCode();
                        }

                        protected Simple(AnnotationDescription annotationDescription) {
                            this.annotationDescription = annotationDescription;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public boolean isResolved() {
                            return true;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public AnnotationDescription resolve() {
                            return this.annotationDescription;
                        }
                    }

                    @HashCodeAndEqualsPlugin.Enhance
                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$AnnotationToken$Resolution$Illegal.class */
                    public static class Illegal implements Resolution {
                        private final String annotationType;

                        public boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Illegal) obj).annotationType);
                        }

                        public int hashCode() {
                            return (getClass().hashCode() * 31) + this.annotationType.hashCode();
                        }

                        public Illegal(String annotationType) {
                            this.annotationType = annotationType;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public boolean isResolved() {
                            return false;
                        }

                        @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.AnnotationToken.Resolution
                        public AnnotationDescription resolve() {
                            throw new IllegalStateException("Annotation type is not available: " + this.annotationType);
                        }
                    }
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$FieldToken.class */
            public static class FieldToken {
                private final String name;
                private final int modifiers;
                private final String descriptor;
                private final String genericSignature;
                private final GenericTypeToken.Resolution.ForField signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;
                private final List<AnnotationToken> annotationTokens;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.modifiers == ((FieldToken) obj).modifiers && this.name.equals(((FieldToken) obj).name) && this.descriptor.equals(((FieldToken) obj).descriptor) && this.genericSignature.equals(((FieldToken) obj).genericSignature) && this.signatureResolution.equals(((FieldToken) obj).signatureResolution) && this.typeAnnotationTokens.equals(((FieldToken) obj).typeAnnotationTokens) && this.annotationTokens.equals(((FieldToken) obj).annotationTokens);
                }

                public int hashCode() {
                    return (((((((((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.modifiers) * 31) + this.descriptor.hashCode()) * 31) + this.genericSignature.hashCode()) * 31) + this.signatureResolution.hashCode()) * 31) + this.typeAnnotationTokens.hashCode()) * 31) + this.annotationTokens.hashCode();
                }

                protected FieldToken(String name, int modifiers, String descriptor, String genericSignature, Map<String, List<AnnotationToken>> typeAnnotationTokens, List<AnnotationToken> annotationTokens) {
                    this.modifiers = modifiers & -131073;
                    this.name = name;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                    this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfField.extract(genericSignature);
                    this.typeAnnotationTokens = typeAnnotationTokens;
                    this.annotationTokens = annotationTokens;
                }

                /* access modifiers changed from: private */
                public LazyFieldDescription toFieldDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyFieldDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens);
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$MethodToken.class */
            public static class MethodToken {
                private final String name;
                private final int modifiers;
                private final String descriptor;
                private final String genericSignature;
                private final GenericTypeToken.Resolution.ForMethod signatureResolution;
                private final String[] exceptionName;
                private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens;
                private final Map<String, List<AnnotationToken>> returnTypeAnnotationTokens;
                private final Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens;
                private final Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens;
                private final List<AnnotationToken> annotationTokens;
                private final Map<Integer, List<AnnotationToken>> parameterAnnotationTokens;
                private final List<ParameterToken> parameterTokens;
                private final AnnotationValue<?, ?> defaultValue;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.modifiers == ((MethodToken) obj).modifiers && this.name.equals(((MethodToken) obj).name) && this.descriptor.equals(((MethodToken) obj).descriptor) && this.genericSignature.equals(((MethodToken) obj).genericSignature) && this.signatureResolution.equals(((MethodToken) obj).signatureResolution) && Arrays.equals(this.exceptionName, ((MethodToken) obj).exceptionName) && this.typeVariableAnnotationTokens.equals(((MethodToken) obj).typeVariableAnnotationTokens) && this.typeVariableBoundAnnotationTokens.equals(((MethodToken) obj).typeVariableBoundAnnotationTokens) && this.returnTypeAnnotationTokens.equals(((MethodToken) obj).returnTypeAnnotationTokens) && this.parameterTypeAnnotationTokens.equals(((MethodToken) obj).parameterTypeAnnotationTokens) && this.exceptionTypeAnnotationTokens.equals(((MethodToken) obj).exceptionTypeAnnotationTokens) && this.receiverTypeAnnotationTokens.equals(((MethodToken) obj).receiverTypeAnnotationTokens) && this.annotationTokens.equals(((MethodToken) obj).annotationTokens) && this.parameterAnnotationTokens.equals(((MethodToken) obj).parameterAnnotationTokens) && this.parameterTokens.equals(((MethodToken) obj).parameterTokens) && this.defaultValue.equals(((MethodToken) obj).defaultValue);
                }

                public int hashCode() {
                    return (((((((((((((((((((((((((((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.modifiers) * 31) + this.descriptor.hashCode()) * 31) + this.genericSignature.hashCode()) * 31) + this.signatureResolution.hashCode()) * 31) + Arrays.hashCode(this.exceptionName)) * 31) + this.typeVariableAnnotationTokens.hashCode()) * 31) + this.typeVariableBoundAnnotationTokens.hashCode()) * 31) + this.returnTypeAnnotationTokens.hashCode()) * 31) + this.parameterTypeAnnotationTokens.hashCode()) * 31) + this.exceptionTypeAnnotationTokens.hashCode()) * 31) + this.receiverTypeAnnotationTokens.hashCode()) * 31) + this.annotationTokens.hashCode()) * 31) + this.parameterAnnotationTokens.hashCode()) * 31) + this.parameterTokens.hashCode()) * 31) + this.defaultValue.hashCode();
                }

                protected MethodToken(String name, int modifiers, String descriptor, String genericSignature, String[] exceptionName, Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens, Map<String, List<AnnotationToken>> returnTypeAnnotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens, Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens, List<AnnotationToken> annotationTokens, Map<Integer, List<AnnotationToken>> parameterAnnotationTokens, List<ParameterToken> parameterTokens, AnnotationValue<?, ?> defaultValue) {
                    this.modifiers = modifiers & -131073;
                    this.name = name;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                    this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfMethod.extract(genericSignature);
                    this.exceptionName = exceptionName;
                    this.typeVariableAnnotationTokens = typeVariableAnnotationTokens;
                    this.typeVariableBoundAnnotationTokens = typeVariableBoundAnnotationTokens;
                    this.returnTypeAnnotationTokens = returnTypeAnnotationTokens;
                    this.parameterTypeAnnotationTokens = parameterTypeAnnotationTokens;
                    this.exceptionTypeAnnotationTokens = exceptionTypeAnnotationTokens;
                    this.receiverTypeAnnotationTokens = receiverTypeAnnotationTokens;
                    this.annotationTokens = annotationTokens;
                    this.parameterAnnotationTokens = parameterAnnotationTokens;
                    this.parameterTokens = parameterTokens;
                    this.defaultValue = defaultValue;
                }

                /* access modifiers changed from: private */
                public MethodDescription.InDefinedShape toMethodDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyMethodDescription(this.name, this.modifiers, this.descriptor, this.genericSignature, this.signatureResolution, this.exceptionName, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens, this.returnTypeAnnotationTokens, this.parameterTypeAnnotationTokens, this.exceptionTypeAnnotationTokens, this.receiverTypeAnnotationTokens, this.annotationTokens, this.parameterAnnotationTokens, this.parameterTokens, this.defaultValue);
                }

                /* access modifiers changed from: protected */
                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$MethodToken$ParameterToken.class */
                public static class ParameterToken {
                    protected static final String NO_NAME = null;
                    protected static final Integer NO_MODIFIERS = null;
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final String name;
                    @HashCodeAndEqualsPlugin.ValueHandling(HashCodeAndEqualsPlugin.ValueHandling.Sort.REVERSE_NULLABILITY)
                    private final Integer modifiers;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (obj == null || getClass() != obj.getClass()) {
                            return false;
                        }
                        Integer num = this.modifiers;
                        Integer num2 = ((ParameterToken) obj).modifiers;
                        if (num2 != null) {
                            if (num == null || !num.equals(num2)) {
                                return false;
                            }
                        } else if (num != null) {
                            return false;
                        }
                        String str = this.name;
                        String str2 = ((ParameterToken) obj).name;
                        return str2 != null ? str != null && str.equals(str2) : str == null;
                    }

                    public int hashCode() {
                        int hashCode = getClass().hashCode() * 31;
                        String str = this.name;
                        if (str != null) {
                            hashCode += str.hashCode();
                        }
                        int i = hashCode * 31;
                        Integer num = this.modifiers;
                        return num != null ? i + num.hashCode() : i;
                    }

                    protected ParameterToken() {
                        this(NO_NAME);
                    }

                    protected ParameterToken(String name) {
                        this(name, NO_MODIFIERS);
                    }

                    protected ParameterToken(String name, Integer modifiers) {
                        this.name = name;
                        this.modifiers = modifiers;
                    }

                    protected String getName() {
                        return this.name;
                    }

                    protected Integer getModifiers() {
                        return this.modifiers;
                    }
                }
            }

            /* access modifiers changed from: protected */
            @HashCodeAndEqualsPlugin.Enhance
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$RecordComponentToken.class */
            public static class RecordComponentToken {
                private final String name;
                private final String descriptor;
                private final String genericSignature;
                private final GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;
                private final List<AnnotationToken> annotationTokens;

                public boolean equals(Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    return obj != null && getClass() == obj.getClass() && this.name.equals(((RecordComponentToken) obj).name) && this.descriptor.equals(((RecordComponentToken) obj).descriptor) && this.genericSignature.equals(((RecordComponentToken) obj).genericSignature) && this.signatureResolution.equals(((RecordComponentToken) obj).signatureResolution) && this.typeAnnotationTokens.equals(((RecordComponentToken) obj).typeAnnotationTokens) && this.annotationTokens.equals(((RecordComponentToken) obj).annotationTokens);
                }

                public int hashCode() {
                    return (((((((((((getClass().hashCode() * 31) + this.name.hashCode()) * 31) + this.descriptor.hashCode()) * 31) + this.genericSignature.hashCode()) * 31) + this.signatureResolution.hashCode()) * 31) + this.typeAnnotationTokens.hashCode()) * 31) + this.annotationTokens.hashCode();
                }

                protected RecordComponentToken(String name, String descriptor, String genericSignature, Map<String, List<AnnotationToken>> typeAnnotationTokens, List<AnnotationToken> annotationTokens) {
                    this.name = name;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                    this.signatureResolution = TypeDescription.AbstractBase.RAW_TYPES ? GenericTypeToken.Resolution.Raw.INSTANCE : GenericTypeExtractor.ForSignature.OfRecordComponent.extract(genericSignature);
                    this.typeAnnotationTokens = typeAnnotationTokens;
                    this.annotationTokens = annotationTokens;
                }

                /* access modifiers changed from: private */
                public RecordComponentDescription.InDefinedShape toRecordComponentDescription(LazyTypeDescription lazyTypeDescription) {
                    lazyTypeDescription.getClass();
                    return new LazyRecordComponentDescription(this.name, this.descriptor, this.genericSignature, this.signatureResolution, this.typeAnnotationTokens, this.annotationTokens);
                }
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationDescription.class */
            public static class LazyAnnotationDescription extends AnnotationDescription.AbstractBase {
                protected final TypePool typePool;
                private final TypeDescription annotationType;
                protected final Map<String, AnnotationValue<?, ?>> values;

                private LazyAnnotationDescription(TypePool typePool, TypeDescription annotationType, Map<String, AnnotationValue<?, ?>> values) {
                    this.typePool = typePool;
                    this.annotationType = annotationType;
                    this.values = values;
                }

                protected static AnnotationList asListOfNullable(TypePool typePool, List<? extends AnnotationToken> tokens) {
                    return tokens == null ? new AnnotationList.Empty() : asList(typePool, tokens);
                }

                protected static AnnotationList asList(TypePool typePool, List<? extends AnnotationToken> tokens) {
                    List<AnnotationDescription> annotationDescriptions = new ArrayList<>(tokens.size());
                    for (AnnotationToken token : tokens) {
                        AnnotationToken.Resolution resolution = token.toAnnotationDescription(typePool);
                        if (resolution.isResolved() && resolution.resolve().getAnnotationType().isAnnotation()) {
                            annotationDescriptions.add(resolution.resolve());
                        }
                    }
                    return new AnnotationList.Explicit(annotationDescriptions);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationDescription
                public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape property) {
                    if (!property.getDeclaringType().asErasure().equals(this.annotationType)) {
                        throw new IllegalArgumentException(property + " is not declared by " + getAnnotationType());
                    }
                    AnnotationValue<?, ?> annotationValue = this.values.get(property.getName());
                    if (annotationValue != null) {
                        return annotationValue.filter(property);
                    }
                    AnnotationValue<?, ?> annotationValue2 = ((MethodDescription.InDefinedShape) getAnnotationType().getDeclaredMethods().filter(ElementMatchers.m97is(property)).getOnly()).getDefaultValue();
                    return annotationValue2 == null ? new AnnotationValue.ForMissingValue(this.annotationType, property.getName()) : annotationValue2;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationDescription
                public TypeDescription getAnnotationType() {
                    return this.annotationType;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationDescription
                public <T extends Annotation> Loadable<T> prepare(Class<T> annotationType) {
                    if (this.annotationType.represents(annotationType)) {
                        return new Loadable<>(this.typePool, annotationType, this.values);
                    }
                    throw new IllegalArgumentException(annotationType + " does not represent " + this.annotationType);
                }

                /* access modifiers changed from: private */
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationDescription$Loadable.class */
                public static class Loadable<S extends Annotation> extends LazyAnnotationDescription implements AnnotationDescription.Loadable<S> {
                    private final Class<S> annotationType;

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationDescription, net.bytebuddy.description.annotation.AnnotationDescription
                    public /* bridge */ /* synthetic */ AnnotationDescription.Loadable prepare(Class cls) {
                        return prepare(cls);
                    }

                    private Loadable(TypePool typePool, Class<S> annotationType, Map<String, AnnotationValue<?, ?>> values) {
                        super(typePool, TypeDescription.ForLoadedType.m247of(annotationType), values);
                        this.annotationType = annotationType;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationDescription.Loadable
                    public S load() {
                        return (S) AnnotationDescription.AnnotationInvocationHandler.m287of(this.annotationType.getClassLoader(), this.annotationType, this.values);
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue.class */
            private static abstract class LazyAnnotationValue<U, V> extends AnnotationValue.AbstractBase<U, V> {
                private transient /* synthetic */ int hashCode;

                protected abstract AnnotationValue<U, V> doResolve();

                private LazyAnnotationValue() {
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public AnnotationValue.State getState() {
                    return doResolve().getState();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public AnnotationValue<U, V> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
                    return doResolve().filter(property, typeDefinition);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public U resolve() {
                    return doResolve().resolve();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationValue
                public AnnotationValue.Loaded<V> load(ClassLoader classLoader) {
                    return doResolve().load(classLoader);
                }

                @CachedReturnPlugin.Enhance("hashCode")
                public int hashCode() {
                    int hashCode = this.hashCode != 0 ? 0 : doResolve().hashCode();
                    if (hashCode == 0) {
                        hashCode = this.hashCode;
                    } else {
                        this.hashCode = hashCode;
                    }
                    return hashCode;
                }

                public boolean equals(Object other) {
                    return doResolve().equals(other);
                }

                public String toString() {
                    return doResolve().toString();
                }

                @HashCodeAndEqualsPlugin.Enhance
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue$ForMismatchedType.class */
                private static class ForMismatchedType<W, X> extends AnnotationValue.AbstractBase<W, X> {
                    private final String value;
                    private final AnnotationValue.Sort sort;

                    public boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        return obj != null && getClass() == obj.getClass() && this.sort.equals(((ForMismatchedType) obj).sort) && this.value.equals(((ForMismatchedType) obj).value);
                    }

                    public int hashCode() {
                        return (((getClass().hashCode() * 31) + this.value.hashCode()) * 31) + this.sort.hashCode();
                    }

                    private ForMismatchedType(String value, AnnotationValue.Sort sort) {
                        this.value = value;
                        this.sort = sort;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.State getState() {
                        return AnnotationValue.State.UNRESOLVED;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.NONE;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue<W, X> filter(MethodDescription.InDefinedShape property, TypeDefinition typeDefinition) {
                        return new AnnotationValue.ForMismatchedType(property, property.getReturnType().isArray() ? AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(this.sort) : this.value);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public W resolve() {
                        throw new IllegalStateException("Expected filtering of this unresolved property");
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Loaded<X> load(ClassLoader classLoader) {
                        throw new IllegalStateException("Expected filtering of this unresolved property");
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue$ForTypeValue.class */
                private static class ForTypeValue extends LazyAnnotationValue<TypeDescription, Class<?>> {
                    private final TypePool typePool;
                    private final String typeName;
                    private transient /* synthetic */ AnnotationValue resolved;

                    private ForTypeValue(TypePool typePool, String typeName) {
                        super();
                        this.typePool = typePool;
                        this.typeName = typeName;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.TYPE;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    protected AnnotationValue<TypeDescription, Class<?>> doResolve() {
                        AnnotationValue<TypeDescription, Class<?>> annotationValue;
                        if (this.resolved != null) {
                            annotationValue = null;
                        } else {
                            Resolution resolution = this.typePool.describe(this.typeName);
                            annotationValue = resolution.isResolved() ? new AnnotationValue.ForTypeDescription<>(resolution.resolve()) : new AnnotationValue.ForMissingType<>(this.typeName);
                        }
                        if (annotationValue == null) {
                            annotationValue = this.resolved;
                        } else {
                            this.resolved = annotationValue;
                        }
                        return annotationValue;
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue$ForAnnotationValue.class */
                private static class ForAnnotationValue extends LazyAnnotationValue<AnnotationDescription, Annotation> {
                    private final TypePool typePool;
                    private final AnnotationToken annotationToken;
                    private transient /* synthetic */ AnnotationValue resolved;

                    private ForAnnotationValue(TypePool typePool, AnnotationToken annotationToken) {
                        super();
                        this.typePool = typePool;
                        this.annotationToken = annotationToken;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ANNOTATION;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    protected AnnotationValue<AnnotationDescription, Annotation> doResolve() {
                        AnnotationValue<AnnotationDescription, Annotation> annotationValue;
                        if (this.resolved != null) {
                            annotationValue = null;
                        } else {
                            AnnotationToken.Resolution resolution = this.annotationToken.toAnnotationDescription(this.typePool);
                            if (!resolution.isResolved()) {
                                annotationValue = new AnnotationValue.ForMissingType<>(this.annotationToken.getBinaryName());
                            } else if (!resolution.resolve().getAnnotationType().isAnnotation()) {
                                annotationValue = new ForMismatchedType<>(resolution.resolve().getAnnotationType().getName(), AnnotationValue.Sort.ANNOTATION);
                            } else {
                                annotationValue = new AnnotationValue.ForAnnotationDescription<>(resolution.resolve());
                            }
                        }
                        if (annotationValue == null) {
                            annotationValue = this.resolved;
                        } else {
                            this.resolved = annotationValue;
                        }
                        return annotationValue;
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue$ForEnumerationValue.class */
                private static class ForEnumerationValue extends LazyAnnotationValue<EnumerationDescription, Enum<?>> {
                    private final TypePool typePool;
                    private final String typeName;
                    private final String value;
                    private transient /* synthetic */ AnnotationValue resolved;

                    private ForEnumerationValue(TypePool typePool, String typeName, String value) {
                        super();
                        this.typePool = typePool;
                        this.typeName = typeName;
                        this.value = value;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ENUMERATION;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    protected AnnotationValue<EnumerationDescription, Enum<?>> doResolve() {
                        AnnotationValue<EnumerationDescription, Enum<?>> annotationValue;
                        if (this.resolved != null) {
                            annotationValue = null;
                        } else {
                            Resolution resolution = this.typePool.describe(this.typeName);
                            if (!resolution.isResolved()) {
                                annotationValue = new AnnotationValue.ForMissingType<>(this.typeName);
                            } else if (!resolution.resolve().isEnum()) {
                                annotationValue = new ForMismatchedType<>(this.typeName + Mapper.IGNORED_FIELDNAME + this.value, AnnotationValue.Sort.ENUMERATION);
                            } else if (resolution.resolve().getDeclaredFields().filter(ElementMatchers.named(this.value)).isEmpty()) {
                                annotationValue = new AnnotationValue.ForEnumerationDescription.WithUnknownConstant<>(resolution.resolve(), this.value);
                            } else {
                                annotationValue = new AnnotationValue.ForEnumerationDescription<>(new EnumerationDescription.Latent(resolution.resolve(), this.value));
                            }
                        }
                        if (annotationValue == null) {
                            annotationValue = this.resolved;
                        } else {
                            this.resolved = annotationValue;
                        }
                        return annotationValue;
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyAnnotationValue$ForArray.class */
                private static class ForArray extends LazyAnnotationValue<Object, Object> {
                    private final TypePool typePool;
                    private final AbstractBase.ComponentTypeReference componentTypeReference;
                    private final List<AnnotationValue<?, ?>> values;
                    private transient /* synthetic */ AnnotationValue resolved;

                    private ForArray(TypePool typePool, AbstractBase.ComponentTypeReference componentTypeReference, List<AnnotationValue<?, ?>> values) {
                        super();
                        this.typePool = typePool;
                        this.componentTypeReference = componentTypeReference;
                        this.values = values;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationValue
                    public AnnotationValue.Sort getSort() {
                        return AnnotationValue.Sort.ARRAY;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.LazyTypeDescription.LazyAnnotationValue
                    @CachedReturnPlugin.Enhance("resolved")
                    protected AnnotationValue<Object, Object> doResolve() {
                        AnnotationValue<Object, Object> annotationValue;
                        if (this.resolved != null) {
                            annotationValue = null;
                        } else {
                            String typeName = this.componentTypeReference.resolve();
                            if (typeName != null) {
                                Resolution resolution = this.typePool.describe(typeName);
                                if (!resolution.isResolved()) {
                                    annotationValue = new AnnotationValue.ForMissingType<>(typeName);
                                } else if (resolution.resolve().isEnum()) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(EnumerationDescription.class, resolution.resolve(), this.values);
                                } else if (resolution.resolve().isAnnotation()) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(AnnotationDescription.class, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Class.class)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(TypeDescription.class, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(String.class)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(String.class, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Boolean.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Boolean.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Byte.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Byte.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Short.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Short.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Character.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Character.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Integer.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Integer.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Long.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Long.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Float.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Float.TYPE, resolution.resolve(), this.values);
                                } else if (resolution.resolve().represents(Double.TYPE)) {
                                    annotationValue = new AnnotationValue.ForDescriptionArray<>(Double.TYPE, resolution.resolve(), this.values);
                                }
                            }
                            AnnotationValue.Sort sort = AnnotationValue.Sort.NONE;
                            ListIterator<AnnotationValue<?, ?>> iterator = this.values.listIterator(this.values.size());
                            while (iterator.hasPrevious() && !sort.isDefined()) {
                                sort = iterator.previous().getSort();
                            }
                            annotationValue = new ForMismatchedType<>(AnnotationValue.RenderingDispatcher.CURRENT.toArrayErrorString(sort), sort);
                        }
                        if (annotationValue == null) {
                            annotationValue = this.resolved;
                        } else {
                            this.resolved = annotationValue;
                        }
                        return annotationValue;
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyPackageDescription.class */
            private static class LazyPackageDescription extends PackageDescription.AbstractBase {
                private final TypePool typePool;
                private final String name;

                private LazyPackageDescription(TypePool typePool, String name) {
                    this.typePool = typePool;
                    this.name = name;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    Resolution resolution = this.typePool.describe(this.name + Mapper.IGNORED_FIELDNAME + PackageDescription.PACKAGE_CLASS_NAME);
                    return resolution.isResolved() ? resolution.resolve().getDeclaredAnnotations() : new AnnotationList.Empty();
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyTypeList.class */
            protected static class LazyTypeList extends TypeList.AbstractBase {
                private final TypePool typePool;
                private final List<String> descriptors;

                protected LazyTypeList(TypePool typePool, List<String> descriptors) {
                    this.typePool = typePool;
                    this.descriptors = descriptors;
                }

                @Override // java.util.AbstractList, java.util.List
                public TypeDescription get(int index) {
                    return TokenizedGenericType.toErasure(this.typePool, this.descriptors.get(index));
                }

                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                public int size() {
                    return this.descriptors.size();
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public String[] toInternalNames() {
                    String[] internalName = new String[this.descriptors.size()];
                    int index = 0;
                    for (String descriptor : this.descriptors) {
                        index++;
                        internalName[index] = Type.getType(descriptor).getInternalName();
                    }
                    return internalName.length == 0 ? NO_INTERFACES : internalName;
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public int getStackSize() {
                    int stackSize = 0;
                    for (String descriptor : this.descriptors) {
                        stackSize += Type.getType(descriptor).getSize();
                    }
                    return stackSize;
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyNestMemberList.class */
            protected static class LazyNestMemberList extends TypeList.AbstractBase {
                private final TypeDescription typeDescription;
                private final TypePool typePool;
                private final List<String> nestMembers;

                protected LazyNestMemberList(TypeDescription typeDescription, TypePool typePool, List<String> nestMembers) {
                    this.typeDescription = typeDescription;
                    this.typePool = typePool;
                    this.nestMembers = nestMembers;
                }

                @Override // java.util.AbstractList, java.util.List
                public TypeDescription get(int index) {
                    return index == 0 ? this.typeDescription : this.typePool.describe(this.nestMembers.get(index - 1)).resolve();
                }

                @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                public int size() {
                    return this.nestMembers.size() + 1;
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public String[] toInternalNames() {
                    String[] internalName = new String[this.nestMembers.size() + 1];
                    internalName[0] = this.typeDescription.getInternalName();
                    int index = 1;
                    for (String name : this.nestMembers) {
                        index++;
                        internalName[index] = name.replace('.', '/');
                    }
                    return internalName;
                }

                @Override // net.bytebuddy.description.type.TypeList.AbstractBase, net.bytebuddy.description.type.TypeList
                public int getStackSize() {
                    return this.nestMembers.size() + 1;
                }
            }

            /* access modifiers changed from: protected */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TokenizedGenericType.class */
            public static class TokenizedGenericType extends TypeDescription.Generic.LazyProjection.WithEagerNavigation {
                private final TypePool typePool;
                private final GenericTypeToken genericTypeToken;
                private final String rawTypeDescriptor;
                private final Map<String, List<AnnotationToken>> annotationTokens;
                private final TypeVariableSource typeVariableSource;
                private transient /* synthetic */ TypeDescription.Generic resolved;
                private transient /* synthetic */ TypeDescription erasure;

                protected TokenizedGenericType(TypePool typePool, GenericTypeToken genericTypeToken, String rawTypeDescriptor, Map<String, List<AnnotationToken>> annotationTokens, TypeVariableSource typeVariableSource) {
                    this.typePool = typePool;
                    this.genericTypeToken = genericTypeToken;
                    this.rawTypeDescriptor = rawTypeDescriptor;
                    this.annotationTokens = annotationTokens;
                    this.typeVariableSource = typeVariableSource;
                }

                /* renamed from: of */
                protected static TypeDescription.Generic m85of(TypePool typePool, GenericTypeToken genericTypeToken, String rawTypeDescriptor, Map<String, List<AnnotationToken>> annotationTokens, TypeVariableSource typeVariableSource) {
                    return new TokenizedGenericType(typePool, genericTypeToken, rawTypeDescriptor, annotationTokens == null ? Collections.emptyMap() : annotationTokens, typeVariableSource);
                }

                protected static TypeDescription toErasure(TypePool typePool, String descriptor) {
                    String str;
                    Type type = Type.getType(descriptor);
                    if (type.getSort() == 9) {
                        str = type.getInternalName().replace('/', '.');
                    } else {
                        str = type.getClassName();
                    }
                    return typePool.describe(str).resolve();
                }

                @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                @CachedReturnPlugin.Enhance("resolved")
                protected TypeDescription.Generic resolve() {
                    TypeDescription.Generic genericType = this.resolved != null ? null : this.genericTypeToken.toGenericType(this.typePool, this.typeVariableSource, "", this.annotationTokens);
                    if (genericType == null) {
                        genericType = this.resolved;
                    } else {
                        this.resolved = genericType;
                    }
                    return genericType;
                }

                @Override // net.bytebuddy.description.type.TypeDefinition
                @CachedReturnPlugin.Enhance("erasure")
                public TypeDescription asErasure() {
                    TypeDescription erasure = this.erasure != null ? null : toErasure(this.typePool, this.rawTypeDescriptor);
                    if (erasure == null) {
                        erasure = this.erasure;
                    } else {
                        this.erasure = erasure;
                    }
                    return erasure;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return resolve().getDeclaredAnnotations();
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TokenizedGenericType$TokenList.class */
                protected static class TokenList extends TypeList.Generic.AbstractBase {
                    private final TypePool typePool;
                    private final List<GenericTypeToken> genericTypeTokens;
                    private final List<String> rawTypeDescriptors;
                    private final TypeVariableSource typeVariableSource;
                    private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;

                    private TokenList(TypePool typePool, List<GenericTypeToken> genericTypeTokens, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, List<String> rawTypeDescriptors, TypeVariableSource typeVariableSource) {
                        this.typePool = typePool;
                        this.genericTypeTokens = genericTypeTokens;
                        this.annotationTokens = annotationTokens;
                        this.rawTypeDescriptors = rawTypeDescriptors;
                        this.typeVariableSource = typeVariableSource;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int index) {
                        if (this.rawTypeDescriptors.size() == this.genericTypeTokens.size()) {
                            return TokenizedGenericType.m85of(this.typePool, this.genericTypeTokens.get(index), this.rawTypeDescriptors.get(index), this.annotationTokens.get(Integer.valueOf(index)), this.typeVariableSource);
                        }
                        return TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptors.get(index)).asGenericType();
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.rawTypeDescriptors.size();
                    }

                    @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                    public TypeList asErasures() {
                        return new LazyTypeList(this.typePool, this.rawTypeDescriptors);
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TokenizedGenericType$TypeVariableList.class */
                protected static class TypeVariableList extends TypeList.Generic.AbstractBase {
                    private final TypePool typePool;
                    private final List<GenericTypeToken.OfFormalTypeVariable> typeVariables;
                    private final TypeVariableSource typeVariableSource;
                    private final Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens;
                    private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens;

                    protected TypeVariableList(TypePool typePool, List<GenericTypeToken.OfFormalTypeVariable> typeVariables, TypeVariableSource typeVariableSource, Map<Integer, Map<String, List<AnnotationToken>>> annotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> boundAnnotationTokens) {
                        this.typePool = typePool;
                        this.typeVariables = typeVariables;
                        this.typeVariableSource = typeVariableSource;
                        this.annotationTokens = annotationTokens;
                        this.boundAnnotationTokens = boundAnnotationTokens;
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public TypeDescription.Generic get(int index) {
                        return this.typeVariables.get(index).toGenericType(this.typePool, this.typeVariableSource, this.annotationTokens.get(Integer.valueOf(index)), this.boundAnnotationTokens.get(Integer.valueOf(index)));
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return this.typeVariables.size();
                    }
                }

                /* access modifiers changed from: protected */
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TokenizedGenericType$Malformed.class */
                public static class Malformed extends TypeDescription.Generic.LazyProjection.WithEagerNavigation {
                    private final TypePool typePool;
                    private final String rawTypeDescriptor;

                    protected Malformed(TypePool typePool, String rawTypeDescriptor) {
                        this.typePool = typePool;
                        this.rawTypeDescriptor = rawTypeDescriptor;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic.LazyProjection
                    protected TypeDescription.Generic resolve() {
                        throw new GenericSignatureFormatError();
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return TokenizedGenericType.toErasure(this.typePool, this.rawTypeDescriptor);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        throw new GenericSignatureFormatError();
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$TokenizedGenericType$Malformed$TokenList.class */
                    protected static class TokenList extends TypeList.Generic.AbstractBase {
                        private final TypePool typePool;
                        private final List<String> rawTypeDescriptors;

                        protected TokenList(TypePool typePool, List<String> rawTypeDescriptors) {
                            this.typePool = typePool;
                            this.rawTypeDescriptors = rawTypeDescriptors;
                        }

                        @Override // java.util.AbstractList, java.util.List
                        public TypeDescription.Generic get(int index) {
                            return new Malformed(this.typePool, this.rawTypeDescriptors.get(index));
                        }

                        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                        public int size() {
                            return this.rawTypeDescriptors.size();
                        }

                        @Override // net.bytebuddy.description.type.TypeList.Generic.AbstractBase, net.bytebuddy.description.type.TypeList.Generic
                        public TypeList asErasures() {
                            return new LazyTypeList(this.typePool, this.rawTypeDescriptors);
                        }
                    }
                }
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyFieldDescription.class */
            public class LazyFieldDescription extends FieldDescription.InDefinedShape.AbstractBase {
                private final String name;
                private final int modifiers;
                private final String descriptor;
                private final String genericSignature;
                private final GenericTypeToken.Resolution.ForField signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;
                private final List<AnnotationToken> annotationTokens;

                private LazyFieldDescription(String name, int modifiers, String descriptor, String genericSignature, GenericTypeToken.Resolution.ForField signatureResolution, Map<String, List<AnnotationToken>> typeAnnotationTokens, List<AnnotationToken> annotationTokens) {
                    this.modifiers = modifiers;
                    this.name = name;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                    this.signatureResolution = signatureResolution;
                    this.typeAnnotationTokens = typeAnnotationTokens;
                    this.annotationTokens = annotationTokens;
                }

                @Override // net.bytebuddy.description.field.FieldDescription
                public TypeDescription.Generic getType() {
                    return this.signatureResolution.resolveFieldType(this.descriptor, LazyTypeDescription.this.typePool, this.typeAnnotationTokens, this);
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return this.modifiers;
                }

                @Override // net.bytebuddy.description.field.FieldDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                public String getGenericSignature() {
                    return this.genericSignature;
                }
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription.class */
            public class LazyMethodDescription extends MethodDescription.InDefinedShape.AbstractBase {
                private final String internalName;
                private final int modifiers;
                private final String returnTypeDescriptor;
                private final String genericSignature;
                private final GenericTypeToken.Resolution.ForMethod signatureResolution;
                private final List<String> parameterTypeDescriptors;
                private final List<String> exceptionTypeDescriptors;
                private final Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens;
                private final Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens;
                private final Map<String, List<AnnotationToken>> returnTypeAnnotationTokens;
                private final Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens;
                private final Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens;
                private final Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens;
                private final List<AnnotationToken> annotationTokens;
                private final Map<Integer, List<AnnotationToken>> parameterAnnotationTokens;
                private final String[] parameterNames;
                private final Integer[] parameterModifiers;
                private final AnnotationValue<?, ?> defaultValue;

                private LazyMethodDescription(String internalName, int modifiers, String descriptor, String genericSignature, GenericTypeToken.Resolution.ForMethod signatureResolution, String[] exceptionTypeInternalName, Map<Integer, Map<String, List<AnnotationToken>>> typeVariableAnnotationTokens, Map<Integer, Map<Integer, Map<String, List<AnnotationToken>>>> typeVariableBoundAnnotationTokens, Map<String, List<AnnotationToken>> returnTypeAnnotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> parameterTypeAnnotationTokens, Map<Integer, Map<String, List<AnnotationToken>>> exceptionTypeAnnotationTokens, Map<String, List<AnnotationToken>> receiverTypeAnnotationTokens, List<AnnotationToken> annotationTokens, Map<Integer, List<AnnotationToken>> parameterAnnotationTokens, List<MethodToken.ParameterToken> parameterTokens, AnnotationValue<?, ?> defaultValue) {
                    this.modifiers = modifiers;
                    this.internalName = internalName;
                    Type methodType = Type.getMethodType(descriptor);
                    Type returnType = methodType.getReturnType();
                    Type[] parameterType = methodType.getArgumentTypes();
                    this.returnTypeDescriptor = returnType.getDescriptor();
                    this.parameterTypeDescriptors = new ArrayList(parameterType.length);
                    for (Type type : parameterType) {
                        this.parameterTypeDescriptors.add(type.getDescriptor());
                    }
                    this.genericSignature = genericSignature;
                    this.signatureResolution = signatureResolution;
                    if (exceptionTypeInternalName == null) {
                        this.exceptionTypeDescriptors = Collections.emptyList();
                    } else {
                        this.exceptionTypeDescriptors = new ArrayList(exceptionTypeInternalName.length);
                        for (String anExceptionTypeInternalName : exceptionTypeInternalName) {
                            this.exceptionTypeDescriptors.add(Type.getObjectType(anExceptionTypeInternalName).getDescriptor());
                        }
                    }
                    this.typeVariableAnnotationTokens = typeVariableAnnotationTokens;
                    this.typeVariableBoundAnnotationTokens = typeVariableBoundAnnotationTokens;
                    this.returnTypeAnnotationTokens = returnTypeAnnotationTokens;
                    this.parameterTypeAnnotationTokens = parameterTypeAnnotationTokens;
                    this.exceptionTypeAnnotationTokens = exceptionTypeAnnotationTokens;
                    this.receiverTypeAnnotationTokens = receiverTypeAnnotationTokens;
                    this.annotationTokens = annotationTokens;
                    this.parameterAnnotationTokens = parameterAnnotationTokens;
                    this.parameterNames = new String[parameterType.length];
                    this.parameterModifiers = new Integer[parameterType.length];
                    if (parameterTokens.size() == parameterType.length) {
                        int index = 0;
                        for (MethodToken.ParameterToken parameterToken : parameterTokens) {
                            this.parameterNames[index] = parameterToken.getName();
                            this.parameterModifiers[index] = parameterToken.getModifiers();
                            index++;
                        }
                    }
                    this.defaultValue = defaultValue;
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReturnType() {
                    return this.signatureResolution.resolveReturnType(this.returnTypeDescriptor, LazyTypeDescription.this.typePool, this.returnTypeAnnotationTokens, this);
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public TypeList.Generic getExceptionTypes() {
                    return this.signatureResolution.resolveExceptionTypes(this.exceptionTypeDescriptors, LazyTypeDescription.this.typePool, this.exceptionTypeAnnotationTokens, this);
                }

                @Override // net.bytebuddy.description.method.MethodDescription, net.bytebuddy.description.method.MethodDescription.InDefinedShape
                public ParameterList<ParameterDescription.InDefinedShape> getParameters() {
                    return new LazyParameterList();
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asList(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
                public String getInternalName() {
                    return this.internalName;
                }

                @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }

                @Override // net.bytebuddy.description.ModifierReviewable
                public int getModifiers() {
                    return this.modifiers;
                }

                @Override // net.bytebuddy.description.TypeVariableSource
                public TypeList.Generic getTypeVariables() {
                    return this.signatureResolution.resolveTypeVariables(LazyTypeDescription.this.typePool, this, this.typeVariableAnnotationTokens, this.typeVariableBoundAnnotationTokens);
                }

                @Override // net.bytebuddy.description.method.MethodDescription
                public AnnotationValue<?, ?> getDefaultValue() {
                    return this.defaultValue;
                }

                @Override // net.bytebuddy.description.method.MethodDescription.InDefinedShape.AbstractBase, net.bytebuddy.description.method.MethodDescription
                public TypeDescription.Generic getReceiverType() {
                    if (isStatic()) {
                        return TypeDescription.Generic.UNDEFINED;
                    }
                    if (!isConstructor()) {
                        return LazyTypeDescription.this.isGenerified() ? new LazyParameterizedReceiverType(this) : new LazyNonGenericReceiverType(this);
                    }
                    TypeDescription declaringType = getDeclaringType();
                    TypeDescription enclosingDeclaringType = declaringType.getEnclosingType();
                    return enclosingDeclaringType == null ? declaringType.isGenerified() ? new LazyParameterizedReceiverType(declaringType) : new LazyNonGenericReceiverType(declaringType) : (declaringType.isStatic() || !declaringType.isGenerified()) ? new LazyNonGenericReceiverType(enclosingDeclaringType) : new LazyParameterizedReceiverType(enclosingDeclaringType);
                }

                @Override // net.bytebuddy.description.method.MethodDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                public String getGenericSignature() {
                    return this.genericSignature;
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription$LazyParameterList.class */
                private class LazyParameterList extends ParameterList.AbstractBase<ParameterDescription.InDefinedShape> {
                    private LazyParameterList() {
                    }

                    @Override // java.util.AbstractList, java.util.List
                    public ParameterDescription.InDefinedShape get(int index) {
                        return new LazyParameterDescription(index);
                    }

                    @Override // net.bytebuddy.description.method.ParameterList.AbstractBase, net.bytebuddy.description.method.ParameterList
                    public boolean hasExplicitMetaData() {
                        for (int i = 0; i < size(); i++) {
                            if (LazyMethodDescription.this.parameterNames[i] == null || LazyMethodDescription.this.parameterModifiers[i] == null) {
                                return false;
                            }
                        }
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                    public int size() {
                        return LazyMethodDescription.this.parameterTypeDescriptors.size();
                    }

                    @Override // net.bytebuddy.description.method.ParameterList.AbstractBase, net.bytebuddy.description.method.ParameterList
                    public TypeList.Generic asTypeList() {
                        return LazyMethodDescription.this.signatureResolution.resolveParameterTypes(LazyMethodDescription.this.parameterTypeDescriptors, LazyTypeDescription.this.typePool, LazyMethodDescription.this.parameterTypeAnnotationTokens, LazyMethodDescription.this);
                    }
                }

                /* access modifiers changed from: private */
                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription$LazyParameterDescription.class */
                public class LazyParameterDescription extends ParameterDescription.InDefinedShape.AbstractBase {
                    private final int index;

                    protected LazyParameterDescription(int index) {
                        this.index = index;
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription, net.bytebuddy.description.method.ParameterDescription.InDefinedShape
                    public MethodDescription.InDefinedShape getDeclaringMethod() {
                        return LazyMethodDescription.this;
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription
                    public int getIndex() {
                        return this.index;
                    }

                    @Override // net.bytebuddy.description.NamedElement.WithOptionalName
                    public boolean isNamed() {
                        return LazyMethodDescription.this.parameterNames[this.index] != null;
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription
                    public boolean hasModifiers() {
                        return LazyMethodDescription.this.parameterModifiers[this.index] != null;
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithRuntimeName
                    public String getName() {
                        if (isNamed()) {
                            return LazyMethodDescription.this.parameterNames[this.index];
                        }
                        return getName();
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription.AbstractBase, net.bytebuddy.description.ModifierReviewable
                    public int getModifiers() {
                        if (hasModifiers()) {
                            return LazyMethodDescription.this.parameterModifiers[this.index].intValue();
                        }
                        return getModifiers();
                    }

                    @Override // net.bytebuddy.description.method.ParameterDescription
                    public TypeDescription.Generic getType() {
                        return (TypeDescription.Generic) LazyMethodDescription.this.signatureResolution.resolveParameterTypes(LazyMethodDescription.this.parameterTypeDescriptors, LazyTypeDescription.this.typePool, LazyMethodDescription.this.parameterTypeAnnotationTokens, LazyMethodDescription.this).get(this.index);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.parameterAnnotationTokens.get(Integer.valueOf(this.index)));
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription$LazyParameterizedReceiverType.class */
                private class LazyParameterizedReceiverType extends TypeDescription.Generic.OfParameterizedType {
                    private final TypeDescription typeDescription;

                    protected LazyParameterizedReceiverType(LazyMethodDescription lazyMethodDescription) {
                        this(LazyTypeDescription.this);
                    }

                    protected LazyParameterizedReceiverType(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public TypeList.Generic getTypeArguments() {
                        return new TypeArgumentList(this.typeDescription.getTypeVariables());
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public TypeDescription.Generic getOwnerType() {
                        TypeDescription declaringType = this.typeDescription.getDeclaringType();
                        if (declaringType == null) {
                            return TypeDescription.Generic.UNDEFINED;
                        }
                        return (this.typeDescription.isStatic() || !declaringType.isGenerified()) ? new LazyNonGenericReceiverType(declaringType) : new LazyParameterizedReceiverType(declaringType);
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(getTypePath()));
                    }

                    /* access modifiers changed from: private */
                    public String getTypePath() {
                        StringBuilder typePath = new StringBuilder();
                        for (int index = 0; index < this.typeDescription.getInnerClassCount(); index++) {
                            typePath = typePath.append('.');
                        }
                        return typePath.toString();
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return this.typeDescription;
                    }

                    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription$LazyParameterizedReceiverType$TypeArgumentList.class */
                    protected class TypeArgumentList extends TypeList.Generic.AbstractBase {
                        private final List<? extends TypeDescription.Generic> typeVariables;

                        protected TypeArgumentList(List<? extends TypeDescription.Generic> typeVariables) {
                            this.typeVariables = typeVariables;
                        }

                        @Override // java.util.AbstractList, java.util.List
                        public TypeDescription.Generic get(int index) {
                            return new AnnotatedTypeVariable((TypeDescription.Generic) this.typeVariables.get(index), index);
                        }

                        @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
                        public int size() {
                            return this.typeVariables.size();
                        }

                        /* access modifiers changed from: protected */
                        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription$LazyParameterizedReceiverType$TypeArgumentList$AnnotatedTypeVariable.class */
                        public class AnnotatedTypeVariable extends TypeDescription.Generic.OfTypeVariable {
                            private final TypeDescription.Generic typeVariable;
                            private final int index;

                            protected AnnotatedTypeVariable(TypeDescription.Generic typeVariable, int index) {
                                this.typeVariable = typeVariable;
                                this.index = index;
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
                                return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(LazyParameterizedReceiverType.this.getTypePath() + this.index + ';'));
                            }
                        }
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyMethodDescription$LazyNonGenericReceiverType.class */
                protected class LazyNonGenericReceiverType extends TypeDescription.Generic.OfNonGenericType {
                    private final TypeDescription typeDescription;

                    protected LazyNonGenericReceiverType(LazyMethodDescription this$1) {
                        this(LazyTypeDescription.this);
                    }

                    protected LazyNonGenericReceiverType(TypeDescription typeDescription) {
                        this.typeDescription = typeDescription;
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic
                    public TypeDescription.Generic getOwnerType() {
                        TypeDescription declaringType = this.typeDescription.getDeclaringType();
                        return declaringType == null ? TypeDescription.Generic.UNDEFINED : new LazyNonGenericReceiverType(declaringType);
                    }

                    @Override // net.bytebuddy.description.type.TypeDescription.Generic, net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription.Generic getComponentType() {
                        return TypeDescription.Generic.UNDEFINED;
                    }

                    @Override // net.bytebuddy.description.annotation.AnnotationSource
                    public AnnotationList getDeclaredAnnotations() {
                        StringBuilder typePath = new StringBuilder();
                        for (int index = 0; index < this.typeDescription.getInnerClassCount(); index++) {
                            typePath = typePath.append('.');
                        }
                        return LazyAnnotationDescription.asListOfNullable(LazyTypeDescription.this.typePool, (List) LazyMethodDescription.this.receiverTypeAnnotationTokens.get(typePath.toString()));
                    }

                    @Override // net.bytebuddy.description.type.TypeDefinition
                    public TypeDescription asErasure() {
                        return this.typeDescription;
                    }
                }
            }

            /* access modifiers changed from: private */
            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$LazyTypeDescription$LazyRecordComponentDescription.class */
            public class LazyRecordComponentDescription extends RecordComponentDescription.InDefinedShape.AbstractBase {
                private final String name;
                private final String descriptor;
                private final String genericSignature;
                private final GenericTypeToken.Resolution.ForRecordComponent signatureResolution;
                private final Map<String, List<AnnotationToken>> typeAnnotationTokens;
                private final List<AnnotationToken> annotationTokens;

                private LazyRecordComponentDescription(String name, String descriptor, String genericSignature, GenericTypeToken.Resolution.ForRecordComponent signatureResolution, Map<String, List<AnnotationToken>> typeAnnotationTokens, List<AnnotationToken> annotationTokens) {
                    this.name = name;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                    this.signatureResolution = signatureResolution;
                    this.typeAnnotationTokens = typeAnnotationTokens;
                    this.annotationTokens = annotationTokens;
                }

                @Override // net.bytebuddy.description.type.RecordComponentDescription
                public TypeDescription.Generic getType() {
                    return this.signatureResolution.resolveRecordType(this.descriptor, LazyTypeDescription.this.typePool, this.typeAnnotationTokens, this);
                }

                @Override // net.bytebuddy.description.DeclaredByType, net.bytebuddy.description.field.FieldDescription.InDefinedShape
                public TypeDescription getDeclaringType() {
                    return LazyTypeDescription.this;
                }

                @Override // net.bytebuddy.description.NamedElement
                public String getActualName() {
                    return this.name;
                }

                @Override // net.bytebuddy.description.annotation.AnnotationSource
                public AnnotationList getDeclaredAnnotations() {
                    return LazyAnnotationDescription.asList(LazyTypeDescription.this.typePool, this.annotationTokens);
                }

                @Override // net.bytebuddy.description.type.RecordComponentDescription.AbstractBase, net.bytebuddy.description.NamedElement.WithDescriptor
                public String getGenericSignature() {
                    return this.genericSignature;
                }
            }
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor.class */
        public class TypeExtractor extends ClassVisitor {
            private static final int REAL_MODIFIER_MASK = 65535;
            private int actualModifiers;
            private int modifiers;
            private String internalName;
            private String superClassName;
            private String genericSignature;
            private String[] interfaceName;
            private String nestHost;
            private String declaringTypeName;
            private ClassFileVersion classFileVersion;
            private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> superTypeAnnotationTokens = new HashMap();
            private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens = new HashMap();
            private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> typeVariableBoundsAnnotationTokens = new HashMap();
            private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();
            private final List<LazyTypeDescription.FieldToken> fieldTokens = new ArrayList();
            private final List<LazyTypeDescription.MethodToken> methodTokens = new ArrayList();
            private final List<LazyTypeDescription.RecordComponentToken> recordComponentTokens = new ArrayList();
            private boolean anonymousType = false;
            private LazyTypeDescription.TypeContainment typeContainment = LazyTypeDescription.TypeContainment.SelfContained.INSTANCE;
            private final List<String> nestMembers = new ArrayList();
            private final List<String> declaredTypes = new ArrayList();
            private final List<String> permittedSubclasses = new ArrayList();

            protected TypeExtractor() {
                super(OpenedClassReader.ASM_API);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            @SuppressFBWarnings(value = {"EI_EXPOSE_REP2"}, justification = "The array is not to be modified by contract")
            public void visit(int classFileVersion, int modifiers, String internalName, String genericSignature, String superClassName, String[] interfaceName) {
                this.modifiers = modifiers & 65535;
                this.actualModifiers = modifiers;
                this.internalName = internalName;
                this.genericSignature = genericSignature;
                this.superClassName = superClassName;
                this.interfaceName = interfaceName;
                this.classFileVersion = ClassFileVersion.ofMinorMajor(classFileVersion);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitOuterClass(String typeName, String methodName, String methodDescriptor) {
                if (methodName != null && !methodName.equals("<clinit>")) {
                    this.typeContainment = new LazyTypeDescription.TypeContainment.WithinMethod(typeName, methodName, methodDescriptor);
                } else if (typeName != null) {
                    this.typeContainment = new LazyTypeDescription.TypeContainment.WithinType(typeName, true);
                }
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitInnerClass(String internalName, String outerName, String innerName, int modifiers) {
                if (internalName.equals(this.internalName)) {
                    if (outerName != null) {
                        this.declaringTypeName = outerName;
                        if (this.typeContainment.isSelfContained()) {
                            this.typeContainment = new LazyTypeDescription.TypeContainment.WithinType(outerName, false);
                        }
                    }
                    if (innerName == null && !this.typeContainment.isSelfContained()) {
                        this.anonymousType = true;
                    }
                    this.modifiers = modifiers & 65535;
                } else if (outerName != null && innerName != null && outerName.equals(this.internalName)) {
                    this.declaredTypes.add("L" + internalName + ";");
                }
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public AnnotationVisitor visitTypeAnnotation(int rawTypeReference, TypePath typePath, String descriptor, boolean visible) {
                AnnotationRegistrant annotationRegistrant;
                TypeReference typeReference = new TypeReference(rawTypeReference);
                switch (typeReference.getSort()) {
                    case 0:
                        annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex(descriptor, typePath, typeReference.getTypeParameterIndex(), this.typeVariableAnnotationTokens);
                        break;
                    case 16:
                        annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex(descriptor, typePath, typeReference.getSuperTypeIndex(), this.superTypeAnnotationTokens);
                        break;
                    case 17:
                        annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed(descriptor, typePath, typeReference.getTypeParameterBoundIndex(), typeReference.getTypeParameterIndex(), this.typeVariableBoundsAnnotationTokens);
                        break;
                    default:
                        throw new IllegalArgumentException("Unexpected type reference: " + typeReference.getSort());
                }
                return new AnnotationExtractor(annotationRegistrant, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                return new AnnotationExtractor(this, descriptor, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public FieldVisitor visitField(int modifiers, String internalName, String descriptor, String genericSignature, Object defaultValue) {
                return new FieldExtractor(modifiers & 65535, internalName, descriptor, genericSignature);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public MethodVisitor visitMethod(int modifiers, String internalName, String descriptor, String genericSignature, String[] exceptionName) {
                return internalName.equals("<clinit>") ? Default.IGNORE_METHOD : new MethodExtractor(modifiers & 65535, internalName, descriptor, genericSignature, exceptionName);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestHost(String nestHost) {
                this.nestHost = nestHost;
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitNestMember(String nestMember) {
                this.nestMembers.add(nestMember);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public RecordComponentVisitor visitRecordComponent(String name, String descriptor, String signature) {
                return new RecordComponentExtractor(name, descriptor, signature);
            }

            @Override // net.bytebuddy.jar.asm.ClassVisitor
            public void visitPermittedSubclass(String permittedSubclass) {
                this.permittedSubclasses.add(permittedSubclass);
            }

            protected TypeDescription toTypeDescription() {
                return new LazyTypeDescription(Default.this, this.actualModifiers, this.modifiers, this.internalName, this.superClassName, this.interfaceName, this.genericSignature, this.typeContainment, this.declaringTypeName, this.declaredTypes, this.anonymousType, this.nestHost, this.nestMembers, this.superTypeAnnotationTokens, this.typeVariableAnnotationTokens, this.typeVariableBoundsAnnotationTokens, this.annotationTokens, this.fieldTokens, this.methodTokens, this.recordComponentTokens, this.permittedSubclasses, this.classFileVersion);
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor$AnnotationExtractor.class */
            protected class AnnotationExtractor extends AnnotationVisitor {
                private final AnnotationRegistrant annotationRegistrant;
                private final ComponentTypeLocator componentTypeLocator;

                protected AnnotationExtractor(TypeExtractor this$1, String descriptor, List<LazyTypeDescription.AnnotationToken> annotationTokens, ComponentTypeLocator componentTypeLocator) {
                    this(new AnnotationRegistrant.ForByteCodeElement(descriptor, annotationTokens), componentTypeLocator);
                }

                protected AnnotationExtractor(TypeExtractor this$1, String descriptor, int index, Map<Integer, List<LazyTypeDescription.AnnotationToken>> annotationTokens, ComponentTypeLocator componentTypeLocator) {
                    this(new AnnotationRegistrant.ForByteCodeElement.WithIndex(descriptor, index, annotationTokens), componentTypeLocator);
                }

                protected AnnotationExtractor(AnnotationRegistrant annotationRegistrant, ComponentTypeLocator componentTypeLocator) {
                    super(OpenedClassReader.ASM_API);
                    this.annotationRegistrant = annotationRegistrant;
                    this.componentTypeLocator = componentTypeLocator;
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public void visit(String name, Object value) {
                    String str;
                    if (value instanceof Type) {
                        Type type = (Type) value;
                        AnnotationRegistrant annotationRegistrant = this.annotationRegistrant;
                        Default r4 = Default.this;
                        if (type.getSort() == 9) {
                            str = type.getInternalName().replace('/', '.');
                        } else {
                            str = type.getClassName();
                        }
                        annotationRegistrant.register(name, new LazyTypeDescription.LazyAnnotationValue.ForTypeValue(r4, str));
                        return;
                    }
                    this.annotationRegistrant.register(name, AnnotationValue.ForConstant.m278of(value));
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public void visitEnum(String name, String descriptor, String value) {
                    this.annotationRegistrant.register(name, new LazyTypeDescription.LazyAnnotationValue.ForEnumerationValue(Default.this, descriptor.substring(1, descriptor.length() - 1).replace('/', '.'), value));
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public AnnotationVisitor visitAnnotation(String name, String descriptor) {
                    return new AnnotationExtractor(new AnnotationLookup(descriptor, name), new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public AnnotationVisitor visitArray(String name) {
                    return new AnnotationExtractor(new ArrayLookup(name, this.componentTypeLocator.bind(name)), ComponentTypeLocator.Illegal.INSTANCE);
                }

                @Override // net.bytebuddy.jar.asm.AnnotationVisitor
                public void visitEnd() {
                    this.annotationRegistrant.onComplete();
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor$AnnotationExtractor$ArrayLookup.class */
                protected class ArrayLookup implements AnnotationRegistrant {
                    private final String name;
                    private final AbstractBase.ComponentTypeReference componentTypeReference;
                    private final List<AnnotationValue<?, ?>> values;

                    private ArrayLookup(String name, AbstractBase.ComponentTypeReference componentTypeReference) {
                        this.name = name;
                        this.componentTypeReference = componentTypeReference;
                        this.values = new ArrayList();
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void register(String ignored, AnnotationValue<?, ?> annotationValue) {
                        this.values.add(annotationValue);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void onComplete() {
                        AnnotationExtractor.this.annotationRegistrant.register(this.name, new LazyTypeDescription.LazyAnnotationValue.ForArray(Default.this, this.componentTypeReference, this.values));
                    }
                }

                /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor$AnnotationExtractor$AnnotationLookup.class */
                protected class AnnotationLookup implements AnnotationRegistrant {
                    private final String descriptor;
                    private final String name;
                    private final Map<String, AnnotationValue<?, ?>> values = new HashMap();

                    protected AnnotationLookup(String descriptor, String name) {
                        this.descriptor = descriptor;
                        this.name = name;
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void register(String name, AnnotationValue<?, ?> annotationValue) {
                        this.values.put(name, annotationValue);
                    }

                    @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                    public void onComplete() {
                        AnnotationExtractor.this.annotationRegistrant.register(this.name, new LazyTypeDescription.LazyAnnotationValue.ForAnnotationValue(Default.this, new LazyTypeDescription.AnnotationToken(this.descriptor, this.values)));
                    }
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor$FieldExtractor.class */
            protected class FieldExtractor extends FieldVisitor {
                private final int modifiers;
                private final String internalName;
                private final String descriptor;
                private final String genericSignature;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> typeAnnotationTokens = new HashMap();
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();

                protected FieldExtractor(int modifiers, String internalName, String descriptor, String genericSignature) {
                    super(OpenedClassReader.ASM_API);
                    this.modifiers = modifiers;
                    this.internalName = internalName;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public AnnotationVisitor visitTypeAnnotation(int rawTypeReference, TypePath typePath, String descriptor, boolean visible) {
                    TypeReference typeReference = new TypeReference(rawTypeReference);
                    switch (typeReference.getSort()) {
                        case 19:
                            return new AnnotationExtractor(new AnnotationRegistrant.ForTypeVariable(descriptor, typePath, this.typeAnnotationTokens), new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                        default:
                            throw new IllegalStateException("Unexpected type reference on field: " + typeReference.getSort());
                    }
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                    return new AnnotationExtractor(TypeExtractor.this, descriptor, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                }

                @Override // net.bytebuddy.jar.asm.FieldVisitor
                public void visitEnd() {
                    TypeExtractor.this.fieldTokens.add(new LazyTypeDescription.FieldToken(this.internalName, this.modifiers, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor$MethodExtractor.class */
            protected class MethodExtractor extends MethodVisitor implements AnnotationRegistrant {
                private final int modifiers;
                private final String internalName;
                private final String descriptor;
                private final String genericSignature;
                private final String[] exceptionName;
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> typeVariableAnnotationTokens = new HashMap();
                private final Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> typeVariableBoundAnnotationTokens = new HashMap();
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> returnTypeAnnotationTokens = new HashMap();
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> parameterTypeAnnotationTokens = new HashMap();
                private final Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> exceptionTypeAnnotationTokens = new HashMap();
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> receiverTypeAnnotationTokens = new HashMap();
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();
                private final Map<Integer, List<LazyTypeDescription.AnnotationToken>> parameterAnnotationTokens = new HashMap();
                private final List<LazyTypeDescription.MethodToken.ParameterToken> parameterTokens = new ArrayList();
                private final ParameterBag legacyParameterBag;
                private Label firstLabel;
                private int visibleParameterShift;
                private int invisibleParameterShift;
                private AnnotationValue<?, ?> defaultValue;

                protected MethodExtractor(int modifiers, String internalName, String descriptor, String genericSignature, String[] exceptionName) {
                    super(OpenedClassReader.ASM_API);
                    this.modifiers = modifiers;
                    this.internalName = internalName;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                    this.exceptionName = exceptionName;
                    this.legacyParameterBag = new ParameterBag(Type.getMethodType(descriptor).getArgumentTypes());
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitTypeAnnotation(int rawTypeReference, TypePath typePath, String descriptor, boolean visible) {
                    AnnotationRegistrant annotationRegistrant;
                    TypeReference typeReference = new TypeReference(rawTypeReference);
                    switch (typeReference.getSort()) {
                        case 1:
                            annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex(descriptor, typePath, typeReference.getTypeParameterIndex(), this.typeVariableAnnotationTokens);
                            break;
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                        case 11:
                        case 12:
                        case 13:
                        case 14:
                        case 15:
                        case 16:
                        case 17:
                        default:
                            throw new IllegalStateException("Unexpected type reference on method: " + typeReference.getSort());
                        case 18:
                            annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex.DoubleIndexed(descriptor, typePath, typeReference.getTypeParameterBoundIndex(), typeReference.getTypeParameterIndex(), this.typeVariableBoundAnnotationTokens);
                            break;
                        case 19:
                            return null;
                        case 20:
                            annotationRegistrant = new AnnotationRegistrant.ForTypeVariable(descriptor, typePath, this.returnTypeAnnotationTokens);
                            break;
                        case 21:
                            annotationRegistrant = new AnnotationRegistrant.ForTypeVariable(descriptor, typePath, this.receiverTypeAnnotationTokens);
                            break;
                        case 22:
                            annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex(descriptor, typePath, typeReference.getFormalParameterIndex(), this.parameterTypeAnnotationTokens);
                            break;
                        case 23:
                            annotationRegistrant = new AnnotationRegistrant.ForTypeVariable.WithIndex(descriptor, typePath, typeReference.getExceptionIndex(), this.exceptionTypeAnnotationTokens);
                            break;
                    }
                    return new AnnotationExtractor(annotationRegistrant, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                    return new AnnotationExtractor(TypeExtractor.this, descriptor, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitAnnotableParameterCount(int count, boolean visible) {
                    if (visible) {
                        this.visibleParameterShift = Type.getMethodType(this.descriptor).getArgumentTypes().length - count;
                    } else {
                        this.invisibleParameterShift = Type.getMethodType(this.descriptor).getArgumentTypes().length - count;
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitParameterAnnotation(int index, String descriptor, boolean visible) {
                    return new AnnotationExtractor(TypeExtractor.this, descriptor, index + (visible ? this.visibleParameterShift : this.invisibleParameterShift), this.parameterAnnotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitLabel(Label label) {
                    if (Default.this.readerMode.isExtended() && this.firstLabel == null) {
                        this.firstLabel = label;
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitLocalVariable(String name, String descriptor, String signature, Label start, Label end, int index) {
                    if (Default.this.readerMode.isExtended() && start == this.firstLabel) {
                        this.legacyParameterBag.register(index, name);
                    }
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitParameter(String name, int modifiers) {
                    this.parameterTokens.add(new LazyTypeDescription.MethodToken.ParameterToken(name, Integer.valueOf(modifiers)));
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public AnnotationVisitor visitAnnotationDefault() {
                    return new AnnotationExtractor(this, new ComponentTypeLocator.ForArrayType(this.descriptor));
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void register(String ignored, AnnotationValue<?, ?> annotationValue) {
                    this.defaultValue = annotationValue;
                }

                @Override // net.bytebuddy.pool.TypePool.Default.AnnotationRegistrant
                public void onComplete() {
                }

                @Override // net.bytebuddy.jar.asm.MethodVisitor
                public void visitEnd() {
                    List<LazyTypeDescription.MethodToken.ParameterToken> list;
                    List list2 = TypeExtractor.this.methodTokens;
                    String str = this.internalName;
                    int i = this.modifiers;
                    String str2 = this.descriptor;
                    String str3 = this.genericSignature;
                    String[] strArr = this.exceptionName;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map = this.typeVariableAnnotationTokens;
                    Map<Integer, Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>>> map2 = this.typeVariableBoundAnnotationTokens;
                    Map<String, List<LazyTypeDescription.AnnotationToken>> map3 = this.returnTypeAnnotationTokens;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map4 = this.parameterTypeAnnotationTokens;
                    Map<Integer, Map<String, List<LazyTypeDescription.AnnotationToken>>> map5 = this.exceptionTypeAnnotationTokens;
                    Map<String, List<LazyTypeDescription.AnnotationToken>> map6 = this.receiverTypeAnnotationTokens;
                    List<LazyTypeDescription.AnnotationToken> list3 = this.annotationTokens;
                    Map<Integer, List<LazyTypeDescription.AnnotationToken>> map7 = this.parameterAnnotationTokens;
                    if (this.parameterTokens.isEmpty()) {
                        list = this.legacyParameterBag.resolve((this.modifiers & 8) != 0);
                    } else {
                        list = this.parameterTokens;
                    }
                    list2.add(new LazyTypeDescription.MethodToken(str, i, str2, str3, strArr, map, map2, map3, map4, map5, map6, list3, map7, list, this.defaultValue));
                }
            }

            /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Default$TypeExtractor$RecordComponentExtractor.class */
            protected class RecordComponentExtractor extends RecordComponentVisitor {
                private final String name;
                private final String descriptor;
                private final String genericSignature;
                private final Map<String, List<LazyTypeDescription.AnnotationToken>> typeAnnotationTokens = new HashMap();
                private final List<LazyTypeDescription.AnnotationToken> annotationTokens = new ArrayList();

                protected RecordComponentExtractor(String name, String descriptor, String genericSignature) {
                    super(OpenedClassReader.ASM_API);
                    this.name = name;
                    this.descriptor = descriptor;
                    this.genericSignature = genericSignature;
                }

                @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                public AnnotationVisitor visitTypeAnnotation(int rawTypeReference, TypePath typePath, String descriptor, boolean visible) {
                    TypeReference typeReference = new TypeReference(rawTypeReference);
                    switch (typeReference.getSort()) {
                        case 19:
                            return new AnnotationExtractor(new AnnotationRegistrant.ForTypeVariable(descriptor, typePath, this.typeAnnotationTokens), new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                        default:
                            throw new IllegalStateException("Unexpected type reference on record component: " + typeReference.getSort());
                    }
                }

                @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                public AnnotationVisitor visitAnnotation(String descriptor, boolean visible) {
                    return new AnnotationExtractor(TypeExtractor.this, descriptor, this.annotationTokens, new ComponentTypeLocator.ForAnnotationProperty(Default.this, descriptor));
                }

                @Override // net.bytebuddy.jar.asm.RecordComponentVisitor
                public void visitEnd() {
                    TypeExtractor.this.recordComponentTokens.add(new LazyTypeDescription.RecordComponentToken(this.name, this.descriptor, this.genericSignature, this.typeAnnotationTokens, this.annotationTokens));
                }
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$LazyFacade.class */
    public static class LazyFacade extends AbstractBase {
        private final TypePool typePool;

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(Object obj) {
            if (!equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.typePool.equals(((LazyFacade) obj).typePool);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return (hashCode() * 31) + this.typePool.hashCode();
        }

        public LazyFacade(TypePool typePool) {
            super(CacheProvider.NoOp.INSTANCE);
            this.typePool = typePool;
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        protected Resolution doDescribe(String name) {
            return new LazyResolution(this.typePool, name);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase, net.bytebuddy.pool.TypePool
        public void clear() {
            this.typePool.clear();
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$LazyFacade$LazyResolution.class */
        protected static class LazyResolution implements Resolution {
            private final TypePool typePool;
            private final String name;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.name.equals(((LazyResolution) obj).name) && this.typePool.equals(((LazyResolution) obj).typePool);
            }

            public int hashCode() {
                return (((getClass().hashCode() * 31) + this.typePool.hashCode()) * 31) + this.name.hashCode();
            }

            protected LazyResolution(TypePool typePool, String name) {
                this.typePool = typePool;
                this.name = name;
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public boolean isResolved() {
                return this.typePool.describe(this.name).isResolved();
            }

            @Override // net.bytebuddy.pool.TypePool.Resolution
            public TypeDescription resolve() {
                return new LazyTypeDescription(this.typePool, this.name);
            }
        }

        /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$LazyFacade$LazyTypeDescription.class */
        protected static class LazyTypeDescription extends TypeDescription.AbstractBase.OfSimpleType.WithDelegation {
            private final TypePool typePool;
            private final String name;
            private transient /* synthetic */ TypeDescription delegate;

            protected LazyTypeDescription(TypePool typePool, String name) {
                this.typePool = typePool;
                this.name = name;
            }

            @Override // net.bytebuddy.description.NamedElement.WithRuntimeName
            public String getName() {
                return this.name;
            }

            @Override // net.bytebuddy.description.type.TypeDescription.AbstractBase.OfSimpleType.WithDelegation
            @CachedReturnPlugin.Enhance(MethodDelegation.ImplementationDelegate.FIELD_NAME_PREFIX)
            protected TypeDescription delegate() {
                TypeDescription resolve = this.delegate != null ? null : this.typePool.describe(this.name).resolve();
                if (resolve == null) {
                    resolve = this.delegate;
                } else {
                    this.delegate = resolve;
                }
                return resolve;
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$ClassLoading.class */
    public static class ClassLoading extends AbstractBase.Hierarchical {
        private static final ClassLoader BOOTSTRAP_CLASS_LOADER = null;
        private final ClassLoader classLoader;

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(Object obj) {
            if (!equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.classLoader.equals(((ClassLoading) obj).classLoader);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return (hashCode() * 31) + this.classLoader.hashCode();
        }

        public ClassLoading(CacheProvider cacheProvider, TypePool parent, ClassLoader classLoader) {
            super(cacheProvider, parent);
            this.classLoader = classLoader;
        }

        /* renamed from: of */
        public static TypePool m92of(ClassLoader classLoader) {
            return m91of(classLoader, Empty.INSTANCE);
        }

        /* renamed from: of */
        public static TypePool m91of(ClassLoader classLoader, TypePool parent) {
            return new ClassLoading(new CacheProvider.Simple(), parent, classLoader);
        }

        public static TypePool ofSystemLoader() {
            return m92of(ClassLoader.getSystemClassLoader());
        }

        public static TypePool ofPlatformLoader() {
            return m92of(ClassLoader.getSystemClassLoader().getParent());
        }

        public static TypePool ofBootLoader() {
            return m92of(BOOTSTRAP_CLASS_LOADER);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        protected Resolution doDescribe(String name) {
            try {
                return new Resolution.Simple(TypeDescription.ForLoadedType.m247of(Class.forName(name, false, this.classLoader)));
            } catch (ClassNotFoundException e) {
                return new Resolution.Illegal(name);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/pool/TypePool$Explicit.class */
    public static class Explicit extends AbstractBase.Hierarchical {
        private final Map<String, TypeDescription> types;

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public boolean equals(Object obj) {
            if (!equals(obj)) {
                return false;
            }
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.types.equals(((Explicit) obj).types);
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase.Hierarchical, net.bytebuddy.pool.TypePool.AbstractBase
        public int hashCode() {
            return (hashCode() * 31) + this.types.hashCode();
        }

        public Explicit(Map<String, TypeDescription> types) {
            this(Empty.INSTANCE, types);
        }

        public Explicit(TypePool parent, Map<String, TypeDescription> types) {
            super(CacheProvider.NoOp.INSTANCE, parent);
            this.types = types;
        }

        @Override // net.bytebuddy.pool.TypePool.AbstractBase
        protected Resolution doDescribe(String name) {
            TypeDescription typeDescription = this.types.get(name);
            return typeDescription == null ? new Resolution.Illegal(name) : new Resolution.Simple(typeDescription);
        }
    }
}
