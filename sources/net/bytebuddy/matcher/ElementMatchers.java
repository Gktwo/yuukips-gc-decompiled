package net.bytebuddy.matcher;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import net.bytebuddy.description.ByteCodeElement;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.description.NamedElement;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.annotation.AnnotationList;
import net.bytebuddy.description.annotation.AnnotationSource;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDefinition;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.description.type.TypeList;
import net.bytebuddy.matcher.CachingMatcher;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.MethodSortMatcher;
import net.bytebuddy.matcher.ModifierMatcher;
import net.bytebuddy.matcher.StringMatcher;
import net.bytebuddy.utility.JavaModule;
import org.jline.console.Printer;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* loaded from: grasscutter.jar:net/bytebuddy/matcher/ElementMatchers.class */
public final class ElementMatchers {
    private static final ClassLoader BOOTSTRAP_CLASSLOADER = null;

    private ElementMatchers() {
        throw new UnsupportedOperationException("This class is a utility class and not supposed to be instantiated");
    }

    public static <T> ElementMatcher.Junction<T> failSafe(ElementMatcher<? super T> matcher) {
        return new FailSafeMatcher(matcher, false);
    }

    public static <T> ElementMatcher.Junction<T> cached(ElementMatcher<? super T> matcher, ConcurrentMap<? super T, Boolean> map) {
        return new CachingMatcher(matcher, map);
    }

    public static <T> ElementMatcher.Junction<T> cached(ElementMatcher<? super T> matcher, int evictionSize) {
        if (evictionSize >= 1) {
            return new CachingMatcher.WithInlineEviction(matcher, new ConcurrentHashMap(), evictionSize);
        }
        throw new IllegalArgumentException("Eviction size must be a positive number: " + evictionSize);
    }

    /* renamed from: is */
    public static <T> ElementMatcher.Junction<T> m104is(Object value) {
        return value == null ? NullMatcher.make() : new EqualityMatcher(value);
    }

    /* renamed from: is */
    public static <T extends FieldDescription> ElementMatcher.Junction<T> m101is(Field field) {
        return m98is((FieldDescription.InDefinedShape) new FieldDescription.ForLoadedField(field));
    }

    /* renamed from: is */
    public static <T extends FieldDescription> ElementMatcher.Junction<T> m98is(FieldDescription.InDefinedShape field) {
        return definedField(new EqualityMatcher(field));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> definedField(ElementMatcher<? super FieldDescription.InDefinedShape> matcher) {
        return new DefinedShapeMatcher(matcher);
    }

    /* renamed from: is */
    public static <T extends MethodDescription> ElementMatcher.Junction<T> m100is(Method method) {
        return m97is((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(method));
    }

    /* renamed from: is */
    public static <T extends MethodDescription> ElementMatcher.Junction<T> m102is(Constructor<?> constructor) {
        return m97is((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(constructor));
    }

    /* renamed from: is */
    public static <T extends MethodDescription> ElementMatcher.Junction<T> m97is(MethodDescription.InDefinedShape method) {
        return definedMethod(new EqualityMatcher(method));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> definedMethod(ElementMatcher<? super MethodDescription.InDefinedShape> matcher) {
        return new DefinedShapeMatcher(matcher);
    }

    /* renamed from: is */
    public static <T extends ParameterDescription> ElementMatcher.Junction<T> m96is(ParameterDescription.InDefinedShape parameter) {
        return definedParameter(new EqualityMatcher(parameter));
    }

    public static <T extends ParameterDescription> ElementMatcher.Junction<T> definedParameter(ElementMatcher<? super ParameterDescription.InDefinedShape> matcher) {
        return new DefinedShapeMatcher(matcher);
    }

    public static <T extends ParameterDescription> ElementMatcher.Junction<T> hasType(ElementMatcher<? super TypeDescription> matcher) {
        return hasGenericType(erasure(matcher));
    }

    public static <T extends ParameterDescription> ElementMatcher.Junction<T> hasGenericType(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new MethodParameterTypeMatcher(matcher);
    }

    public static <T extends ParameterDescription> ElementMatcher.Junction<T> isMandated() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.MANDATED);
    }

    /* renamed from: is */
    public static <T extends TypeDefinition> ElementMatcher.Junction<T> m99is(Type type) {
        return m104is(TypeDefinition.Sort.describe(type));
    }

    /* renamed from: is */
    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> m103is(Annotation annotation) {
        return m104is(AnnotationDescription.ForLoadedAnnotation.m286of(annotation));
    }

    public static <T> ElementMatcher.Junction<T> not(ElementMatcher<? super T> matcher) {
        return new NegatingMatcher(matcher);
    }

    public static <T> ElementMatcher.Junction<T> any() {
        return BooleanMatcher.m106of(true);
    }

    public static <T> ElementMatcher.Junction<T> none() {
        return BooleanMatcher.m106of(false);
    }

    public static <T> ElementMatcher.Junction<T> anyOf(Object... value) {
        return anyOf(Arrays.asList(value));
    }

    public static <T> ElementMatcher.Junction<T> anyOf(Iterable<?> values) {
        ElementMatcher.Junction<T> matcher = null;
        for (Object value : values) {
            if (matcher == null) {
                matcher = m104is(value);
            } else {
                matcher = matcher.mo105or(m104is(value));
            }
        }
        return matcher == null ? none() : matcher;
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> anyOf(Type... value) {
        return anyOf(new TypeList.Generic.ForLoadedTypes(value));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> anyOf(Constructor<?>... value) {
        return definedMethod(anyOf(new MethodList.ForLoadedMethods(value, new Method[0])));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> anyOf(Method... value) {
        return definedMethod(anyOf(new MethodList.ForLoadedMethods(new Constructor[0], value)));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> anyOf(Field... value) {
        return definedField(anyOf(new FieldList.ForLoadedFields(value)));
    }

    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> anyOf(Annotation... value) {
        return anyOf(new AnnotationList.ForLoadedAnnotations(value));
    }

    public static <T> ElementMatcher.Junction<T> noneOf(Object... value) {
        return noneOf(Arrays.asList(value));
    }

    public static <T> ElementMatcher.Junction<T> noneOf(Iterable<?> values) {
        ElementMatcher.Junction<T> matcher = null;
        for (Object value : values) {
            if (matcher == null) {
                matcher = not(m104is(value));
            } else {
                matcher = matcher.and(not(m104is(value)));
            }
        }
        return matcher == null ? any() : matcher;
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> noneOf(Type... value) {
        return noneOf(new TypeList.Generic.ForLoadedTypes(value));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> noneOf(Constructor<?>... value) {
        return definedMethod(noneOf(new MethodList.ForLoadedMethods(value, new Method[0])));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> noneOf(Method... value) {
        return definedMethod(noneOf(new MethodList.ForLoadedMethods(new Constructor[0], value)));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> noneOf(Field... value) {
        return definedField(noneOf(new FieldList.ForLoadedFields(value)));
    }

    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> noneOf(Annotation... value) {
        return noneOf(new AnnotationList.ForLoadedAnnotations(value));
    }

    public static <T> ElementMatcher.Junction<Iterable<? extends T>> whereAny(ElementMatcher<? super T> matcher) {
        return new CollectionItemMatcher(matcher);
    }

    public static <T> ElementMatcher.Junction<Iterable<? extends T>> whereNone(ElementMatcher<? super T> matcher) {
        return not(whereAny(matcher));
    }

    public static <T extends TypeDescription.Generic> ElementMatcher.Junction<T> erasure(Class<?> type) {
        return erasure(m99is((Type) type));
    }

    public static <T extends TypeDescription.Generic> ElementMatcher.Junction<T> erasure(TypeDescription type) {
        return erasure(m104is(type));
    }

    public static <T extends TypeDescription.Generic> ElementMatcher.Junction<T> erasure(ElementMatcher<? super TypeDescription> matcher) {
        return new ErasureMatcher(matcher);
    }

    public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(Class<?>... type) {
        return erasures(new TypeList.ForLoadedTypes(type));
    }

    public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(TypeDescription... type) {
        return erasures(Arrays.asList(type));
    }

    public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(Iterable<? extends TypeDescription> types) {
        List<ElementMatcher<? super TypeDescription>> typeMatchers = new ArrayList<>();
        for (TypeDescription type : types) {
            typeMatchers.add(m104is(type));
        }
        return erasures(new CollectionOneToOneMatcher(typeMatchers));
    }

    public static <T extends Iterable<? extends TypeDescription.Generic>> ElementMatcher.Junction<T> erasures(ElementMatcher<? super Iterable<? extends TypeDescription>> matcher) {
        return new CollectionErasureMatcher(matcher);
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> isVariable(String symbol) {
        return isVariable(named(symbol));
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> isVariable(ElementMatcher<? super NamedElement> matcher) {
        return (ElementMatcher.Junction<T>) new TypeSortMatcher(anyOf(TypeDefinition.Sort.VARIABLE, TypeDefinition.Sort.VARIABLE_SYMBOLIC)).and(matcher);
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> named(String name) {
        return new NameMatcher(new StringMatcher(name, StringMatcher.Mode.EQUALS_FULLY));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> namedOneOf(String... names) {
        return new NameMatcher(new StringSetMatcher(new HashSet(Arrays.asList(names))));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> namedIgnoreCase(String name) {
        return new NameMatcher(new StringMatcher(name, StringMatcher.Mode.EQUALS_FULLY_IGNORE_CASE));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameStartsWith(String prefix) {
        return new NameMatcher(new StringMatcher(prefix, StringMatcher.Mode.STARTS_WITH));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameStartsWithIgnoreCase(String prefix) {
        return new NameMatcher(new StringMatcher(prefix, StringMatcher.Mode.STARTS_WITH_IGNORE_CASE));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameEndsWith(String suffix) {
        return new NameMatcher(new StringMatcher(suffix, StringMatcher.Mode.ENDS_WITH));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameEndsWithIgnoreCase(String suffix) {
        return new NameMatcher(new StringMatcher(suffix, StringMatcher.Mode.ENDS_WITH_IGNORE_CASE));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameContains(String infix) {
        return new NameMatcher(new StringMatcher(infix, StringMatcher.Mode.CONTAINS));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameContainsIgnoreCase(String infix) {
        return new NameMatcher(new StringMatcher(infix, StringMatcher.Mode.CONTAINS_IGNORE_CASE));
    }

    public static <T extends NamedElement> ElementMatcher.Junction<T> nameMatches(String regex) {
        return new NameMatcher(new StringMatcher(regex, StringMatcher.Mode.MATCHES));
    }

    public static <T extends NamedElement.WithOptionalName> ElementMatcher.Junction<T> isNamed() {
        return new IsNamedMatcher();
    }

    public static <T extends NamedElement.WithDescriptor> ElementMatcher.Junction<T> hasDescriptor(String descriptor) {
        return new DescriptorMatcher(new StringMatcher(descriptor, StringMatcher.Mode.EQUALS_FULLY));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredBy(Class<?> type) {
        return isDeclaredBy(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredBy(TypeDescription type) {
        return isDeclaredBy(m104is(type));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredBy(ElementMatcher<? super TypeDescription> matcher) {
        return isDeclaredByGeneric(erasure(matcher));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredByGeneric(Type type) {
        return isDeclaredByGeneric(TypeDefinition.Sort.describe(type));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredByGeneric(TypeDescription.Generic type) {
        return isDeclaredByGeneric(m104is(type));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isDeclaredByGeneric(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new DeclaringTypeMatcher(matcher);
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isVisibleTo(Class<?> type) {
        return isVisibleTo(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isVisibleTo(TypeDescription type) {
        return new VisibilityMatcher(type);
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isAccessibleTo(Class<?> type) {
        return isAccessibleTo(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends ByteCodeElement> ElementMatcher.Junction<T> isAccessibleTo(TypeDescription type) {
        return new AccessibilityMatcher(type);
    }

    public static <T extends ModifierReviewable.OfAbstraction> ElementMatcher.Junction<T> isAbstract() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.ABSTRACT);
    }

    public static <T extends ModifierReviewable.OfEnumeration> ElementMatcher.Junction<T> isEnum() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.ENUMERATION);
    }

    public static <T extends AnnotationSource> ElementMatcher.Junction<T> isAnnotatedWith(Class<? extends Annotation> type) {
        return isAnnotatedWith(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends AnnotationSource> ElementMatcher.Junction<T> isAnnotatedWith(TypeDescription type) {
        return isAnnotatedWith(m104is(type));
    }

    public static <T extends AnnotationSource> ElementMatcher.Junction<T> isAnnotatedWith(ElementMatcher<? super TypeDescription> matcher) {
        return declaresAnnotation(annotationType(matcher));
    }

    public static <T extends AnnotationSource> ElementMatcher.Junction<T> declaresAnnotation(ElementMatcher<? super AnnotationDescription> matcher) {
        return new DeclaringAnnotationMatcher(new CollectionItemMatcher(matcher));
    }

    public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isPublic() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.PUBLIC);
    }

    public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isProtected() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.PROTECTED);
    }

    public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isPackagePrivate() {
        return not(isPublic().mo105or(isProtected()).mo105or(isPrivate()));
    }

    public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isPrivate() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.PRIVATE);
    }

    public static <T extends ModifierReviewable.OfByteCodeElement> ElementMatcher.Junction<T> isStatic() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.STATIC);
    }

    public static <T extends ModifierReviewable> ElementMatcher.Junction<T> isFinal() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.FINAL);
    }

    public static <T extends ModifierReviewable> ElementMatcher.Junction<T> isSynthetic() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.SYNTHETIC);
    }

    public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isSynchronized() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.SYNCHRONIZED);
    }

    public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isNative() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.NATIVE);
    }

    public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isStrict() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.STRICT);
    }

    public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isVarArgs() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.VAR_ARGS);
    }

    public static <T extends ModifierReviewable.ForMethodDescription> ElementMatcher.Junction<T> isBridge() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.BRIDGE);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> returnsGeneric(Type type) {
        return returnsGeneric(TypeDefinition.Sort.describe(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> returnsGeneric(TypeDescription.Generic type) {
        return returnsGeneric(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> returns(Class<?> type) {
        return returnsGeneric(erasure(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> returns(TypeDescription type) {
        return returns(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> returns(ElementMatcher<? super TypeDescription> matcher) {
        return returnsGeneric(erasure(matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> returnsGeneric(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new MethodReturnTypeMatcher(matcher);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArgument(int index, Type type) {
        return takesGenericArgument(index, TypeDefinition.Sort.describe(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArgument(int index, TypeDescription.Generic type) {
        return takesGenericArgument(index, m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArgument(int index, ElementMatcher<? super TypeDescription.Generic> matcher) {
        return takesGenericArguments(new CollectionElementMatcher(index, matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(Type... type) {
        return takesGenericArguments(new TypeList.Generic.ForLoadedTypes(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(TypeDefinition... type) {
        return takesGenericArguments(Arrays.asList(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(List<? extends TypeDefinition> types) {
        List<ElementMatcher<? super TypeDescription.Generic>> typeMatchers = new ArrayList<>();
        for (TypeDefinition type : types) {
            typeMatchers.add(m104is(type));
        }
        return takesGenericArguments(new CollectionOneToOneMatcher(typeMatchers));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesGenericArguments(ElementMatcher<? super Iterable<? extends TypeDescription.Generic>> matchers) {
        return new MethodParametersMatcher(new MethodParameterTypesMatcher(matchers));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArgument(int index, Class<?> type) {
        return takesArgument(index, TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArgument(int index, TypeDescription type) {
        return takesArgument(index, m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArgument(int index, ElementMatcher<? super TypeDescription> matcher) {
        return takesGenericArgument(index, erasure(matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(Class<?>... type) {
        return takesGenericArguments(erasures(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(TypeDescription... type) {
        return takesGenericArguments(erasures(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(Iterable<? extends TypeDescription> types) {
        List<ElementMatcher<? super TypeDescription.Generic>> typeMatchers = new ArrayList<>();
        for (TypeDescription type : types) {
            typeMatchers.add(erasure(type));
        }
        return takesGenericArguments(new CollectionOneToOneMatcher(typeMatchers));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(ElementMatcher<? super Iterable<? extends TypeDescription>> matchers) {
        return new MethodParametersMatcher(new MethodParameterTypesMatcher(erasures(matchers)));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesArguments(int length) {
        return new MethodParametersMatcher(new CollectionSizeMatcher(length));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> takesNoArguments() {
        return takesArguments(0);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> hasParameters(ElementMatcher<? super Iterable<? extends ParameterDescription>> matcher) {
        return new MethodParametersMatcher(matcher);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> canThrow(Class<? extends Throwable> exceptionType) {
        return canThrow(TypeDescription.ForLoadedType.m247of(exceptionType));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> canThrow(TypeDescription exceptionType) {
        if (exceptionType.isAssignableTo(RuntimeException.class) || exceptionType.isAssignableTo(Error.class)) {
            return BooleanMatcher.m106of(true);
        }
        return declaresGenericException(new CollectionItemMatcher(erasure(isSuperTypeOf(exceptionType))));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresGenericException(Type exceptionType) {
        return declaresGenericException(TypeDefinition.Sort.describe(exceptionType));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresGenericException(TypeDescription.Generic exceptionType) {
        if (exceptionType.getSort().isWildcard() || !exceptionType.asErasure().isAssignableTo(Throwable.class)) {
            return BooleanMatcher.m106of(false);
        }
        return declaresGenericException(new CollectionItemMatcher(m104is(exceptionType)));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresException(Class<? extends Throwable> exceptionType) {
        return declaresException(TypeDescription.ForLoadedType.m247of(exceptionType));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresException(TypeDescription exceptionType) {
        if (exceptionType.isAssignableTo(Throwable.class)) {
            return declaresGenericException(new CollectionItemMatcher(erasure(exceptionType)));
        }
        return BooleanMatcher.m106of(false);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> declaresGenericException(ElementMatcher<? super Iterable<? extends TypeDescription.Generic>> matcher) {
        return new MethodExceptionTypeMatcher(matcher);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFrom(Class<?> type) {
        return isOverriddenFrom(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFrom(TypeDescription type) {
        return isOverriddenFrom(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFrom(ElementMatcher<? super TypeDescription> matcher) {
        return isOverriddenFromGeneric(erasure(matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFromGeneric(Type type) {
        return isOverriddenFromGeneric(TypeDefinition.Sort.describe(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFromGeneric(TypeDescription.Generic type) {
        return isOverriddenFromGeneric(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isOverriddenFromGeneric(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new MethodOverrideMatcher(matcher);
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> isInterface() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.INTERFACE);
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> isAnnotation() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.ANNOTATION);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isMethod() {
        return MethodSortMatcher.m95of(MethodSortMatcher.Sort.METHOD);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isConstructor() {
        return MethodSortMatcher.m95of(MethodSortMatcher.Sort.CONSTRUCTOR);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isTypeInitializer() {
        return MethodSortMatcher.m95of(MethodSortMatcher.Sort.TYPE_INITIALIZER);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isVirtual() {
        return MethodSortMatcher.m95of(MethodSortMatcher.Sort.VIRTUAL);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isDefaultMethod() {
        return MethodSortMatcher.m95of(MethodSortMatcher.Sort.DEFAULT_METHOD);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isDefaultConstructor() {
        return isConstructor().and(takesNoArguments());
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isMain() {
        return named(LineReader.MAIN).and(takesArguments(String[].class)).and(returns(TypeDescription.VOID).and(isStatic()).and(isPublic()));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isDefaultFinalizer() {
        return isFinalizer().and(isDeclaredBy(TypeDescription.OBJECT));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isFinalizer() {
        return named("finalize").and(takesNoArguments()).and(returns(TypeDescription.VOID));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isHashCode() {
        return named("hashCode").and(takesNoArguments()).and(returns(Integer.TYPE));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isEquals() {
        return named("equals").and(takesArguments(TypeDescription.OBJECT)).and(returns(Boolean.TYPE));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isClone() {
        return named("clone").and(takesNoArguments());
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isToString() {
        return named(Printer.TO_STRING).and(takesNoArguments()).and(returns(TypeDescription.STRING));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter() {
        return nameStartsWith("set").and(takesArguments(1)).and(returns(TypeDescription.VOID));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(String property) {
        ElementMatcher.Junction junction;
        ElementMatcher.Junction isSetter = isSetter();
        if (property.length() == 0) {
            junction = named("set");
        } else {
            junction = named("set" + Character.toUpperCase(property.charAt(0)) + property.substring(1));
        }
        return isSetter.and(junction);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(Class<?> type) {
        return isSetter(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericSetter(Type type) {
        return isGenericSetter(TypeDefinition.Sort.describe(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(TypeDescription type) {
        return isSetter(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericSetter(TypeDescription.Generic type) {
        return isGenericSetter(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isSetter(ElementMatcher<? super TypeDescription> matcher) {
        return isGenericSetter(erasure(matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericSetter(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return isSetter().and(takesGenericArguments(new CollectionOneToOneMatcher(Collections.singletonList(matcher))));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter() {
        return takesNoArguments().and(not(returns(TypeDescription.VOID))).and(nameStartsWith(BeanUtil.PREFIX_GETTER_GET).mo105or(nameStartsWith(BeanUtil.PREFIX_GETTER_IS).and(returnsGeneric(anyOf(Boolean.TYPE, Boolean.class)))));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(String property) {
        ElementMatcher.Junction junction;
        ElementMatcher.Junction isGetter = isGetter();
        if (property.length() == 0) {
            junction = named(BeanUtil.PREFIX_GETTER_GET).mo105or(named(BeanUtil.PREFIX_GETTER_IS));
        } else {
            junction = named(BeanUtil.PREFIX_GETTER_GET + Character.toUpperCase(property.charAt(0)) + property.substring(1)).mo105or(named(BeanUtil.PREFIX_GETTER_IS + Character.toUpperCase(property.charAt(0)) + property.substring(1)));
        }
        return isGetter.and(junction);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(Class<?> type) {
        return isGetter(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericGetter(Type type) {
        return isGenericGetter(TypeDefinition.Sort.describe(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(TypeDescription type) {
        return isGetter(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericGetter(TypeDescription.Generic type) {
        return isGenericGetter(m104is(type));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGetter(ElementMatcher<? super TypeDescription> matcher) {
        return isGenericGetter(erasure(matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> isGenericGetter(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return isGetter().and(returnsGeneric(matcher));
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> hasMethodName(String internalName) {
        if ("<init>".equals(internalName)) {
            return isConstructor();
        }
        if ("<clinit>".equals(internalName)) {
            return isTypeInitializer();
        }
        return named(internalName);
    }

    public static <T extends MethodDescription> ElementMatcher.Junction<T> hasSignature(MethodDescription.SignatureToken token) {
        return new SignatureTokenMatcher(m104is(token));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> isSubTypeOf(Class<?> type) {
        return isSubTypeOf(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> isSubTypeOf(TypeDescription type) {
        return new SubTypeMatcher(type);
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> isSuperTypeOf(Class<?> type) {
        return isSuperTypeOf(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> isSuperTypeOf(TypeDescription type) {
        return new SuperTypeMatcher(type);
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> hasSuperClass(ElementMatcher<? super TypeDescription> matcher) {
        return hasGenericSuperClass(erasure(matcher));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> hasGenericSuperClass(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new HasSuperClassMatcher(matcher);
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> hasSuperType(ElementMatcher<? super TypeDescription> matcher) {
        return hasGenericSuperType(erasure(matcher));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> hasGenericSuperType(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new HasSuperTypeMatcher(matcher);
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> inheritsAnnotation(Class<?> type) {
        return inheritsAnnotation(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> inheritsAnnotation(TypeDescription type) {
        return inheritsAnnotation(m104is(type));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> inheritsAnnotation(ElementMatcher<? super TypeDescription> matcher) {
        return hasAnnotation(annotationType(matcher));
    }

    public static <T extends TypeDescription> ElementMatcher.Junction<T> hasAnnotation(ElementMatcher<? super AnnotationDescription> matcher) {
        return new InheritedAnnotationMatcher(new CollectionItemMatcher(matcher));
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> declaresField(ElementMatcher<? super FieldDescription> matcher) {
        return new DeclaringFieldMatcher(new CollectionItemMatcher(matcher));
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> declaresMethod(ElementMatcher<? super MethodDescription> matcher) {
        return new DeclaringMethodMatcher(new CollectionItemMatcher(matcher));
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> ofSort(TypeDefinition.Sort sort) {
        return ofSort(m104is(sort));
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> ofSort(ElementMatcher<? super TypeDefinition.Sort> matcher) {
        return new TypeSortMatcher(matcher);
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> isPrimitive() {
        return new PrimitiveTypeMatcher();
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> isArray() {
        return new ArrayTypeMatcher();
    }

    public static <T extends TypeDefinition> ElementMatcher.Junction<T> isRecord() {
        return new RecordMatcher();
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> genericFieldType(Type fieldType) {
        return genericFieldType(TypeDefinition.Sort.describe(fieldType));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> genericFieldType(TypeDescription.Generic fieldType) {
        return genericFieldType(m104is(fieldType));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> genericFieldType(ElementMatcher<? super TypeDescription.Generic> matcher) {
        return new FieldTypeMatcher(matcher);
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> fieldType(Class<?> fieldType) {
        return fieldType(TypeDescription.ForLoadedType.m247of(fieldType));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> fieldType(TypeDescription fieldType) {
        return fieldType(m104is(fieldType));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> fieldType(ElementMatcher<? super TypeDescription> matcher) {
        return genericFieldType(erasure(matcher));
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> isVolatile() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.VOLATILE);
    }

    public static <T extends FieldDescription> ElementMatcher.Junction<T> isTransient() {
        return ModifierMatcher.m94of(ModifierMatcher.Mode.TRANSIENT);
    }

    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> annotationType(Class<? extends Annotation> type) {
        return annotationType(TypeDescription.ForLoadedType.m247of(type));
    }

    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> annotationType(TypeDescription type) {
        return annotationType(m104is(type));
    }

    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> annotationType(ElementMatcher<? super TypeDescription> matcher) {
        return new AnnotationTypeMatcher(matcher);
    }

    public static <T extends AnnotationDescription> ElementMatcher.Junction<T> targetsElement(ElementType elementType) {
        return new AnnotationTargetMatcher(elementType);
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> isBootstrapClassLoader() {
        return NullMatcher.make();
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> isSystemClassLoader() {
        return new EqualityMatcher(ClassLoader.getSystemClassLoader());
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> isExtensionClassLoader() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader().getParent();
        return classLoader == null ? none() : new EqualityMatcher(classLoader);
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> isChildOf(ClassLoader classLoader) {
        if (classLoader == BOOTSTRAP_CLASSLOADER) {
            return BooleanMatcher.m106of(true);
        }
        return hasChild(m104is(classLoader));
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> hasChild(ElementMatcher<? super ClassLoader> matcher) {
        return new ClassLoaderHierarchyMatcher(matcher);
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> isParentOf(ClassLoader classLoader) {
        return classLoader == BOOTSTRAP_CLASSLOADER ? isBootstrapClassLoader() : new ClassLoaderParentMatcher(classLoader);
    }

    public static <T extends ClassLoader> ElementMatcher.Junction<T> ofType(ElementMatcher<? super TypeDescription> matcher) {
        return new InstanceTypeMatcher(matcher);
    }

    public static <T extends JavaModule> ElementMatcher.Junction<T> supportsModules() {
        return not(NullMatcher.make());
    }
}
