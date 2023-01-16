package net.bytebuddy.description.annotation;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.security.AccessController;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import net.bytebuddy.ClassFileVersion;
import net.bytebuddy.build.CachedReturnPlugin;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationValue;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.privilege.SetAccessibleAction;

/* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription.class */
public interface AnnotationDescription {
    public static final Loadable<?> UNDEFINED = null;

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$Loadable.class */
    public interface Loadable<S extends Annotation> extends AnnotationDescription {
        S load();
    }

    AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape inDefinedShape);

    TypeDescription getAnnotationType();

    <T extends Annotation> Loadable<T> prepare(Class<T> cls);

    RetentionPolicy getRetention();

    Set<ElementType> getElementTypes();

    boolean isInherited();

    boolean isDocumented();

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$RenderingDispatcher.class */
    public enum RenderingDispatcher {
        LEGACY_VM,
        JAVA_14_CAPABLE_VM {
            @Override // net.bytebuddy.description.annotation.AnnotationDescription.RenderingDispatcher
            public void appendPrefix(StringBuilder toString, String key, int count) {
                if (count > 1 || !key.equals("value")) {
                    appendPrefix(toString, key, count);
                }
            }
        };
        
        public static final RenderingDispatcher CURRENT;

        static {
            if (ClassFileVersion.ofThisVm(ClassFileVersion.JAVA_V5).isAtLeast(ClassFileVersion.JAVA_V14)) {
                CURRENT = JAVA_14_CAPABLE_VM;
            } else {
                CURRENT = LEGACY_VM;
            }
        }

        public void appendPrefix(StringBuilder toString, String key, int count) {
            toString.append(key).append('=');
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$AnnotationInvocationHandler.class */
    public static class AnnotationInvocationHandler<T extends Annotation> implements InvocationHandler {
        private static final String HASH_CODE = "hashCode";
        private static final String EQUALS = "equals";
        private static final String TO_STRING = "toString";
        private static final String ANNOTATION_TYPE = "annotationType";
        private static final Object[] NO_ARGUMENT = new Object[0];
        private final Class<? extends Annotation> annotationType;
        private final LinkedHashMap<Method, AnnotationValue.Loaded<?>> values;
        private transient /* synthetic */ int hashCode;

        protected AnnotationInvocationHandler(Class<T> annotationType, LinkedHashMap<Method, AnnotationValue.Loaded<?>> values) {
            this.annotationType = annotationType;
            this.values = values;
        }

        /* renamed from: of */
        public static <S extends Annotation> S m287of(ClassLoader classLoader, Class<S> annotationType, Map<String, ? extends AnnotationValue<?, ?>> values) {
            AnnotationValue annotationValue;
            LinkedHashMap<Method, AnnotationValue.Loaded<?>> loadedValues = new LinkedHashMap<>();
            Method[] declaredMethods = annotationType.getDeclaredMethods();
            for (Method method : declaredMethods) {
                AnnotationValue<?, ?> annotationValue2 = (AnnotationValue) values.get(method.getName());
                if (annotationValue2 == null) {
                    Object defaultValue = method.getDefaultValue();
                    if (defaultValue == null) {
                        annotationValue = new AnnotationValue.ForMissingValue(new TypeDescription.ForLoadedType(method.getDeclaringClass()), method.getName());
                    } else {
                        annotationValue = ForLoadedAnnotation.asValue(defaultValue, method.getReturnType());
                    }
                    loadedValues.put(method, annotationValue.load(classLoader));
                } else {
                    loadedValues.put(method, annotationValue2.filter(new MethodDescription.ForLoadedMethod(method)).load(classLoader));
                }
            }
            return (S) ((Annotation) Proxy.newProxyInstance(classLoader, new Class[]{annotationType}, new AnnotationInvocationHandler(annotationType, loadedValues)));
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object proxy, Method method, Object[] argument) {
            if (method.getDeclaringClass() == this.annotationType) {
                return this.values.get(method).resolve();
            }
            if (method.getName().equals(HASH_CODE)) {
                return Integer.valueOf(hashCodeRepresentation());
            }
            if (method.getName().equals(EQUALS) && method.getParameterTypes().length == 1) {
                return Boolean.valueOf(equalsRepresentation(proxy, argument[0]));
            }
            if (method.getName().equals("toString")) {
                return toStringRepresentation();
            }
            if (method.getName().equals(ANNOTATION_TYPE)) {
                return this.annotationType;
            }
            throw new IllegalStateException("Unexpected method: " + method);
        }

        protected String toStringRepresentation() {
            StringBuilder toString = new StringBuilder();
            toString.append('@');
            toString.append(this.annotationType.getName());
            toString.append('(');
            boolean firstMember = true;
            for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                if (entry.getValue().getState().isDefined()) {
                    if (firstMember) {
                        firstMember = false;
                    } else {
                        toString.append(", ");
                    }
                    RenderingDispatcher.CURRENT.appendPrefix(toString, entry.getKey().getName(), this.values.entrySet().size());
                    toString.append(entry.getValue().toString());
                }
            }
            toString.append(')');
            return toString.toString();
        }

        private int hashCodeRepresentation() {
            int hashCode = 0;
            for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                if (entry.getValue().getState().isDefined()) {
                    hashCode += (127 * entry.getKey().getName().hashCode()) ^ entry.getValue().hashCode();
                }
            }
            return hashCode;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:25:0x0079
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        private boolean equalsRepresentation(java.lang.Object r6, java.lang.Object r7) {
            /*
                r5 = this;
                r0 = r6
                r1 = r7
                if (r0 != r1) goto L_0x0007
                r0 = 1
                return r0
            L_0x0007:
                r0 = r5
                java.lang.Class<? extends java.lang.annotation.Annotation> r0 = r0.annotationType
                r1 = r7
                boolean r0 = r0.isInstance(r1)
                if (r0 != 0) goto L_0x0014
                r0 = 0
                return r0
            L_0x0014:
                r0 = r7
                java.lang.Class r0 = r0.getClass()
                boolean r0 = java.lang.reflect.Proxy.isProxyClass(r0)
                if (r0 == 0) goto L_0x0030
                r0 = r7
                java.lang.reflect.InvocationHandler r0 = java.lang.reflect.Proxy.getInvocationHandler(r0)
                r8 = r0
                r0 = r8
                boolean r0 = r0 instanceof net.bytebuddy.description.annotation.AnnotationDescription.AnnotationInvocationHandler
                if (r0 == 0) goto L_0x0030
                r0 = r8
                r1 = r5
                boolean r0 = r0.equals(r1)
                return r0
            L_0x0030:
                r0 = r5
                java.util.LinkedHashMap<java.lang.reflect.Method, net.bytebuddy.description.annotation.AnnotationValue$Loaded<?>> r0 = r0.values     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085
                java.util.Set r0 = r0.entrySet()     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085
                java.util.Iterator r0 = r0.iterator()     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085
                r8 = r0
            L_0x003d:
                r0 = r8
                boolean r0 = r0.hasNext()     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085
                if (r0 == 0) goto L_0x0080
                r0 = r8
                java.lang.Object r0 = r0.next()     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085
                java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085
                r9 = r0
                r0 = r9
                java.lang.Object r0 = r0.getValue()     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                net.bytebuddy.description.annotation.AnnotationValue$Loaded r0 = (net.bytebuddy.description.annotation.AnnotationValue.Loaded) r0     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                r1 = r9
                java.lang.Object r1 = r1.getKey()     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                java.lang.reflect.Method r1 = (java.lang.reflect.Method) r1     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                r2 = r7
                java.lang.Object[] r3 = net.bytebuddy.description.annotation.AnnotationDescription.AnnotationInvocationHandler.NO_ARGUMENT     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                java.lang.Object r1 = r1.invoke(r2, r3)     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                boolean r0 = r0.represents(r1)     // Catch: InvocationTargetException -> 0x0082, IllegalAccessException -> 0x0085, RuntimeException -> 0x0079
                if (r0 != 0) goto L_0x0076
                r0 = 0
                return r0
            L_0x0076:
                goto L_0x007d
            L_0x0079:
                r10 = move-exception
                r0 = 0
                return r0
            L_0x007d:
                goto L_0x003d
            L_0x0080:
                r0 = 1
                return r0
            L_0x0082:
                r8 = move-exception
                r0 = 0
                return r0
            L_0x0085:
                r8 = move-exception
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "Could not access annotation property"
                r3 = r8
                r1.<init>(r2, r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.description.annotation.AnnotationDescription.AnnotationInvocationHandler.equalsRepresentation(java.lang.Object, java.lang.Object):boolean");
        }

        @Override // java.lang.Object
        @CachedReturnPlugin.Enhance(HASH_CODE)
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                int result = (31 * this.annotationType.hashCode()) + this.values.hashCode();
                Iterator<Map.Entry<Method, AnnotationValue.Loaded<?>>> it = this.values.entrySet().iterator();
                while (it.hasNext()) {
                    result = (31 * result) + it.next().getValue().hashCode();
                }
                i = result;
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
            if (!(other instanceof AnnotationInvocationHandler)) {
                return false;
            }
            AnnotationInvocationHandler<?> that = (AnnotationInvocationHandler) other;
            if (!this.annotationType.equals(that.annotationType)) {
                return false;
            }
            for (Map.Entry<Method, AnnotationValue.Loaded<?>> entry : this.values.entrySet()) {
                if (!entry.getValue().equals(that.values.get(entry.getKey()))) {
                    return false;
                }
            }
            return true;
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$AbstractBase.class */
    public static abstract class AbstractBase implements AnnotationDescription {
        private static final ElementType[] DEFAULT_TARGET = {ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.FIELD, ElementType.LOCAL_VARIABLE, ElementType.METHOD, ElementType.PACKAGE, ElementType.PARAMETER, ElementType.TYPE};
        private transient /* synthetic */ int hashCode;

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public RetentionPolicy getRetention() {
            Loadable<Retention> retention = getAnnotationType().getDeclaredAnnotations().ofType(Retention.class);
            return retention == null ? RetentionPolicy.CLASS : retention.load().value();
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public Set<ElementType> getElementTypes() {
            Loadable<Target> target = getAnnotationType().getDeclaredAnnotations().ofType(Target.class);
            return new HashSet(Arrays.asList(target == null ? DEFAULT_TARGET : target.load().value()));
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public boolean isInherited() {
            return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent(Inherited.class);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public boolean isDocumented() {
            return getAnnotationType().getDeclaredAnnotations().isAnnotationPresent(Documented.class);
        }

        @CachedReturnPlugin.Enhance("hashCode")
        public int hashCode() {
            int i;
            if (this.hashCode != 0) {
                i = 0;
            } else {
                int hashCode = 0;
                for (MethodDescription.InDefinedShape methodDescription : getAnnotationType().getDeclaredMethods()) {
                    hashCode += 31 * getValue(methodDescription).hashCode();
                }
                i = hashCode;
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
            if (!(other instanceof AnnotationDescription)) {
                return false;
            }
            AnnotationDescription annotationDescription = (AnnotationDescription) other;
            TypeDescription annotationType = getAnnotationType();
            if (!annotationDescription.getAnnotationType().equals(annotationType)) {
                return false;
            }
            for (MethodDescription.InDefinedShape methodDescription : annotationType.getDeclaredMethods()) {
                if (!getValue(methodDescription).equals(annotationDescription.getValue(methodDescription))) {
                    return false;
                }
            }
            return true;
        }

        public String toString() {
            TypeDescription annotationType = getAnnotationType();
            StringBuilder toString = new StringBuilder().append('@').append(annotationType.getName()).append('(');
            boolean firstMember = true;
            for (MethodDescription.InDefinedShape methodDescription : annotationType.getDeclaredMethods()) {
                AnnotationValue<?, ?> value = getValue(methodDescription);
                if (value.getState() != AnnotationValue.State.UNDEFINED) {
                    if (firstMember) {
                        firstMember = false;
                    } else {
                        toString.append(", ");
                    }
                    RenderingDispatcher.CURRENT.appendPrefix(toString, methodDescription.getName(), annotationType.getDeclaredMethods().size());
                    toString.append(value);
                }
            }
            return toString.append(')').toString();
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$ForLoadedAnnotation.class */
    public static class ForLoadedAnnotation<S extends Annotation> extends AbstractBase implements Loadable<S> {
        private static final Object[] NO_ARGUMENT = new Object[0];
        private final S annotation;
        private final Class<S> annotationType;

        protected ForLoadedAnnotation(S annotation) {
            this(annotation, annotation.annotationType());
        }

        private ForLoadedAnnotation(S annotation, Class<S> annotationType) {
            this.annotation = annotation;
            this.annotationType = annotationType;
        }

        /* renamed from: of */
        public static <U extends Annotation> Loadable<U> m286of(U annotation) {
            return new ForLoadedAnnotation(annotation);
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription.Loadable
        public S load() {
            return this.annotationType == this.annotation.annotationType() ? this.annotation : (S) AnnotationInvocationHandler.m287of(this.annotationType.getClassLoader(), this.annotationType, asValue(this.annotation));
        }

        private static Map<String, AnnotationValue<?, ?>> asValue(Annotation annotation) {
            Map<String, AnnotationValue<?, ?>> annotationValues = new HashMap<>();
            Method[] declaredMethods = annotation.annotationType().getDeclaredMethods();
            for (Method property : declaredMethods) {
                try {
                    annotationValues.put(property.getName(), asValue(property.invoke(annotation, NO_ARGUMENT), property.getReturnType()));
                } catch (IllegalAccessException exception) {
                    throw new IllegalStateException("Cannot access " + property, exception);
                } catch (InvocationTargetException exception2) {
                    Throwable cause = exception2.getCause();
                    if (cause instanceof TypeNotPresentException) {
                        annotationValues.put(property.getName(), new AnnotationValue.ForMissingType<>(((TypeNotPresentException) cause).typeName()));
                    } else if (cause instanceof EnumConstantNotPresentException) {
                        annotationValues.put(property.getName(), new AnnotationValue.ForEnumerationDescription.WithUnknownConstant<>(new TypeDescription.ForLoadedType(((EnumConstantNotPresentException) cause).enumType()), ((EnumConstantNotPresentException) cause).constantName()));
                    } else if (cause instanceof AnnotationTypeMismatchException) {
                        annotationValues.put(property.getName(), new AnnotationValue.ForMismatchedType<>(new MethodDescription.ForLoadedMethod(((AnnotationTypeMismatchException) cause).element()), ((AnnotationTypeMismatchException) cause).foundType()));
                    } else if (!(cause instanceof IncompleteAnnotationException)) {
                        throw new IllegalStateException("Cannot read " + property, exception2.getCause());
                    }
                }
            }
            return annotationValues;
        }

        /* JADX DEBUG: Type inference failed for r0v27. Raw type applied. Possible types: net.bytebuddy.description.annotation.AnnotationValue<net.bytebuddy.description.type.TypeDescription[], java.lang.Class<?>[]>, net.bytebuddy.description.annotation.AnnotationValue<?, ?> */
        public static AnnotationValue<?, ?> asValue(Object value, Class<?> type) {
            if (Enum.class.isAssignableFrom(type)) {
                return AnnotationValue.ForEnumerationDescription.m262of(new EnumerationDescription.ForLoadedEnumeration((Enum) value));
            }
            if (Enum[].class.isAssignableFrom(type)) {
                Enum<?>[] element = (Enum[]) value;
                EnumerationDescription[] enumerationDescription = new EnumerationDescription[element.length];
                int index = 0;
                for (Enum<?> anElement : element) {
                    index++;
                    enumerationDescription[index] = new EnumerationDescription.ForLoadedEnumeration(anElement);
                }
                return AnnotationValue.ForDescriptionArray.m264of(TypeDescription.ForLoadedType.m247of(type.getComponentType()), enumerationDescription);
            } else if (Annotation.class.isAssignableFrom(type)) {
                return AnnotationValue.ForAnnotationDescription.m285of(TypeDescription.ForLoadedType.m247of(type), asValue((Annotation) value));
            } else {
                if (Annotation[].class.isAssignableFrom(type)) {
                    Annotation[] element2 = (Annotation[]) value;
                    AnnotationDescription[] annotationDescription = new AnnotationDescription[element2.length];
                    int index2 = 0;
                    for (Annotation anElement2 : element2) {
                        index2++;
                        annotationDescription[index2] = new Latent(TypeDescription.ForLoadedType.m247of(type.getComponentType()), asValue(anElement2));
                    }
                    return AnnotationValue.ForDescriptionArray.m265of(TypeDescription.ForLoadedType.m247of(type.getComponentType()), annotationDescription);
                } else if (Class.class.isAssignableFrom(type)) {
                    return AnnotationValue.ForTypeDescription.m261of(TypeDescription.ForLoadedType.m247of((Class) value));
                } else {
                    if (!Class[].class.isAssignableFrom(type)) {
                        return AnnotationValue.ForConstant.m278of(value);
                    }
                    Class<?>[] element3 = (Class[]) value;
                    TypeDescription[] typeDescription = new TypeDescription[element3.length];
                    int index3 = 0;
                    for (Class<?> anElement3 : element3) {
                        index3++;
                        typeDescription[index3] = TypeDescription.ForLoadedType.m247of(anElement3);
                    }
                    return AnnotationValue.ForDescriptionArray.m263of(typeDescription);
                }
            }
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should always be wrapped for clarity")
        public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape property) {
            if (!property.getDeclaringType().represents(this.annotation.annotationType())) {
                throw new IllegalArgumentException(property + " does not represent " + this.annotation.annotationType());
            }
            try {
                boolean accessible = property.getDeclaringType().isPublic();
                Method method = property instanceof MethodDescription.ForLoadedMethod ? ((MethodDescription.ForLoadedMethod) property).getLoadedMethod() : null;
                if (method == null || method.getDeclaringClass() != this.annotation.annotationType() || (!accessible && !method.isAccessible())) {
                    method = this.annotation.annotationType().getMethod(property.getName(), new Class[0]);
                    if (!accessible) {
                        AccessController.doPrivileged(new SetAccessibleAction(method));
                    }
                }
                return asValue(method.invoke(this.annotation, NO_ARGUMENT), method.getReturnType()).filter(property);
            } catch (InvocationTargetException exception) {
                Throwable cause = exception.getCause();
                if (cause instanceof TypeNotPresentException) {
                    return new AnnotationValue.ForMissingType(((TypeNotPresentException) cause).typeName());
                }
                if (cause instanceof EnumConstantNotPresentException) {
                    return new AnnotationValue.ForEnumerationDescription.WithUnknownConstant(new TypeDescription.ForLoadedType(((EnumConstantNotPresentException) cause).enumType()), ((EnumConstantNotPresentException) cause).constantName());
                }
                if (cause instanceof AnnotationTypeMismatchException) {
                    return new AnnotationValue.ForMismatchedType(new MethodDescription.ForLoadedMethod(((AnnotationTypeMismatchException) cause).element()), ((AnnotationTypeMismatchException) cause).foundType());
                }
                if (cause instanceof IncompleteAnnotationException) {
                    return new AnnotationValue.ForMissingValue(new TypeDescription.ForLoadedType(((IncompleteAnnotationException) cause).annotationType()), ((IncompleteAnnotationException) cause).elementName());
                }
                throw new IllegalStateException("Error reading annotation property " + property, cause);
            } catch (Exception exception2) {
                throw new IllegalStateException("Cannot access annotation property " + property, exception2);
            }
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public <T extends Annotation> Loadable<T> prepare(Class<T> annotationType) {
            if (this.annotation.annotationType().getName().equals(annotationType.getName())) {
                return annotationType == this.annotation.annotationType() ? this : new ForLoadedAnnotation(this.annotation, annotationType);
            }
            throw new IllegalArgumentException(annotationType + " does not represent " + this.annotation.annotationType());
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public TypeDescription getAnnotationType() {
            return TypeDescription.ForLoadedType.m247of(this.annotation.annotationType());
        }
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$Latent.class */
    public static class Latent extends AbstractBase {
        private final TypeDescription annotationType;
        private final Map<String, ? extends AnnotationValue<?, ?>> annotationValues;

        /* access modifiers changed from: protected */
        public Latent(TypeDescription annotationType, Map<String, ? extends AnnotationValue<?, ?>> annotationValues) {
            this.annotationType = annotationType;
            this.annotationValues = annotationValues;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape property) {
            if (!property.getDeclaringType().equals(this.annotationType)) {
                throw new IllegalArgumentException("Not a property of " + this.annotationType + ": " + property);
            }
            AnnotationValue<?, ?> value = (AnnotationValue) this.annotationValues.get(property.getName());
            if (value != null) {
                return value.filter(property);
            }
            AnnotationValue<?, ?> defaultValue = property.getDefaultValue();
            return defaultValue == null ? new AnnotationValue.ForMissingValue(this.annotationType, property.getName()) : defaultValue;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public TypeDescription getAnnotationType() {
            return this.annotationType;
        }

        @Override // net.bytebuddy.description.annotation.AnnotationDescription
        public <T extends Annotation> Loadable<T> prepare(Class<T> annotationType) {
            if (this.annotationType.represents(annotationType)) {
                return new Loadable<>(annotationType);
            }
            throw new IllegalArgumentException(annotationType + " does not represent " + this.annotationType);
        }

        /* access modifiers changed from: protected */
        /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$Latent$Loadable.class */
        public class Loadable<S extends Annotation> extends AbstractBase implements Loadable<S> {
            private final Class<S> annotationType;

            protected Loadable(Class<S> annotationType) {
                this.annotationType = annotationType;
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription.Loadable
            public S load() {
                return (S) AnnotationInvocationHandler.m287of(this.annotationType.getClassLoader(), this.annotationType, Latent.this.annotationValues);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription
            public AnnotationValue<?, ?> getValue(MethodDescription.InDefinedShape property) {
                return Latent.this.getValue(property);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription
            public TypeDescription getAnnotationType() {
                return TypeDescription.ForLoadedType.m247of(this.annotationType);
            }

            @Override // net.bytebuddy.description.annotation.AnnotationDescription
            public <T extends Annotation> Loadable<T> prepare(Class<T> annotationType) {
                return Latent.this.prepare((Class) annotationType);
            }
        }
    }

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/description/annotation/AnnotationDescription$Builder.class */
    public static class Builder {
        private final TypeDescription annotationType;
        private final Map<String, AnnotationValue<?, ?>> annotationValues;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.annotationType.equals(((Builder) obj).annotationType) && this.annotationValues.equals(((Builder) obj).annotationValues);
        }

        public int hashCode() {
            return (((getClass().hashCode() * 31) + this.annotationType.hashCode()) * 31) + this.annotationValues.hashCode();
        }

        protected Builder(TypeDescription annotationType, Map<String, AnnotationValue<?, ?>> annotationValues) {
            this.annotationType = annotationType;
            this.annotationValues = annotationValues;
        }

        public static Builder ofType(Class<? extends Annotation> annotationType) {
            return ofType(TypeDescription.ForLoadedType.m247of(annotationType));
        }

        public static Builder ofType(TypeDescription annotationType) {
            if (annotationType.isAnnotation()) {
                return new Builder(annotationType, Collections.emptyMap());
            }
            throw new IllegalArgumentException("Not an annotation type: " + annotationType);
        }

        public Builder define(String property, AnnotationValue<?, ?> value) {
            MethodList methodDescriptions = this.annotationType.getDeclaredMethods().filter(ElementMatchers.named(property));
            if (methodDescriptions.isEmpty()) {
                throw new IllegalArgumentException(this.annotationType + " does not define a property named " + property);
            }
            Map<String, AnnotationValue<?, ?>> annotationValues = new HashMap<>(this.annotationValues);
            if (annotationValues.put(((MethodDescription.InDefinedShape) methodDescriptions.getOnly()).getName(), value) == null) {
                return new Builder(this.annotationType, annotationValues);
            }
            throw new IllegalArgumentException("Property already defined: " + property);
        }

        public Builder define(String property, Enum<?> value) {
            return define(property, new EnumerationDescription.ForLoadedEnumeration(value));
        }

        public Builder define(String property, TypeDescription enumerationType, String value) {
            return define(property, new EnumerationDescription.Latent(enumerationType, value));
        }

        public Builder define(String property, EnumerationDescription value) {
            return define(property, AnnotationValue.ForEnumerationDescription.m262of(value));
        }

        public Builder define(String property, Annotation annotation) {
            return define(property, new ForLoadedAnnotation(annotation));
        }

        public Builder define(String property, AnnotationDescription annotationDescription) {
            return define(property, new AnnotationValue.ForAnnotationDescription(annotationDescription));
        }

        public Builder define(String property, Class<?> type) {
            return define(property, TypeDescription.ForLoadedType.m247of(type));
        }

        public Builder define(String property, TypeDescription typeDescription) {
            return define(property, AnnotationValue.ForTypeDescription.m261of(typeDescription));
        }

        public <T extends Enum<?>> Builder defineEnumerationArray(String property, Class<T> enumerationType, T... value) {
            EnumerationDescription[] enumerationDescription = new EnumerationDescription[value.length];
            int index = 0;
            for (T aValue : value) {
                index++;
                enumerationDescription[index] = new EnumerationDescription.ForLoadedEnumeration(aValue);
            }
            return defineEnumerationArray(property, TypeDescription.ForLoadedType.m247of(enumerationType), enumerationDescription);
        }

        public Builder defineEnumerationArray(String property, TypeDescription enumerationType, String... value) {
            if (!enumerationType.isEnum()) {
                throw new IllegalArgumentException("Not an enumeration type: " + enumerationType);
            }
            EnumerationDescription[] enumerationDescription = new EnumerationDescription[value.length];
            for (int i = 0; i < value.length; i++) {
                enumerationDescription[i] = new EnumerationDescription.Latent(enumerationType, value[i]);
            }
            return defineEnumerationArray(property, enumerationType, enumerationDescription);
        }

        public Builder defineEnumerationArray(String property, TypeDescription enumerationType, EnumerationDescription... value) {
            return define(property, AnnotationValue.ForDescriptionArray.m264of(enumerationType, value));
        }

        public <T extends Annotation> Builder defineAnnotationArray(String property, Class<T> annotationType, T... annotation) {
            return defineAnnotationArray(property, TypeDescription.ForLoadedType.m247of(annotationType), (AnnotationDescription[]) new AnnotationList.ForLoadedAnnotations(annotation).toArray(new AnnotationDescription[0]));
        }

        public Builder defineAnnotationArray(String property, TypeDescription annotationType, AnnotationDescription... annotationDescription) {
            return define(property, AnnotationValue.ForDescriptionArray.m265of(annotationType, annotationDescription));
        }

        public Builder defineTypeArray(String property, Class<?>... type) {
            return defineTypeArray(property, (TypeDescription[]) new TypeList.ForLoadedTypes(type).toArray(new TypeDescription[0]));
        }

        public Builder defineTypeArray(String property, TypeDescription... typeDescription) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForDescriptionArray.m263of(typeDescription));
        }

        public Builder define(String property, boolean value) {
            return define(property, AnnotationValue.ForConstant.m275of(value));
        }

        public Builder define(String property, byte value) {
            return define(property, AnnotationValue.ForConstant.m284of(value));
        }

        public Builder define(String property, char value) {
            return define(property, AnnotationValue.ForConstant.m283of(value));
        }

        public Builder define(String property, short value) {
            return define(property, AnnotationValue.ForConstant.m276of(value));
        }

        public Builder define(String property, int value) {
            return define(property, AnnotationValue.ForConstant.m280of(value));
        }

        public Builder define(String property, long value) {
            return define(property, AnnotationValue.ForConstant.m279of(value));
        }

        public Builder define(String property, float value) {
            return define(property, AnnotationValue.ForConstant.m281of(value));
        }

        public Builder define(String property, double value) {
            return define(property, AnnotationValue.ForConstant.m282of(value));
        }

        public Builder define(String property, String value) {
            return define(property, AnnotationValue.ForConstant.m277of(value));
        }

        public Builder defineArray(String property, boolean... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m266of(value));
        }

        public Builder defineArray(String property, byte... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m274of(value));
        }

        public Builder defineArray(String property, char... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m273of(value));
        }

        public Builder defineArray(String property, short... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m267of(value));
        }

        public Builder defineArray(String property, int... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m270of(value));
        }

        public Builder defineArray(String property, long... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m269of(value));
        }

        public Builder defineArray(String property, float... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m271of(value));
        }

        public Builder defineArray(String property, double... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m272of(value));
        }

        public Builder defineArray(String property, String... value) {
            return define(property, (AnnotationValue<?, ?>) AnnotationValue.ForConstant.m268of(value));
        }

        public AnnotationDescription build() {
            for (MethodDescription.InDefinedShape methodDescription : this.annotationType.getDeclaredMethods()) {
                AnnotationValue<?, ?> annotationValue = this.annotationValues.get(methodDescription.getName());
                if (annotationValue == null && methodDescription.getDefaultValue() == null) {
                    throw new IllegalStateException("No value or default value defined for " + methodDescription.getName());
                } else if (annotationValue != null && annotationValue.filter(methodDescription).getState() != AnnotationValue.State.RESOLVED) {
                    throw new IllegalStateException("Illegal annotation value for " + methodDescription + ": " + annotationValue);
                }
            }
            return new Latent(this.annotationType, this.annotationValues);
        }

        public AnnotationDescription build(boolean validated) {
            return validated ? build() : new Latent(this.annotationType, this.annotationValues);
        }
    }
}
