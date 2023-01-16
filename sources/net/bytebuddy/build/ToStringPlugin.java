package net.bytebuddy.build;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.build.Plugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.ToStringMethod;
import net.bytebuddy.matcher.ElementMatcher;
import net.bytebuddy.matcher.ElementMatchers;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/build/ToStringPlugin.class */
public class ToStringPlugin implements Plugin, Plugin.Factory {

    @Target({ElementType.FIELD})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/build/ToStringPlugin$Exclude.class */
    public @interface Exclude {
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass();
    }

    @Override // java.lang.Object
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override // net.bytebuddy.build.Plugin.Factory
    public Plugin make() {
        return this;
    }

    public boolean matches(TypeDescription target) {
        return target.getDeclaredAnnotations().isAnnotationPresent(Enhance.class);
    }

    @Override // net.bytebuddy.build.Plugin
    public DynamicType.Builder<?> apply(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassFileLocator classFileLocator) {
        ElementMatcher.Junction junction;
        Enhance enhance = (Enhance) typeDescription.getDeclaredAnnotations().ofType(Enhance.class).load();
        if (typeDescription.getDeclaredMethods().filter(ElementMatchers.isToString()).isEmpty()) {
            DynamicType.Builder.MethodDefinition.ImplementationDefinition<?> method = builder.method(ElementMatchers.isToString());
            ToStringMethod prefixedBy = ToStringMethod.prefixedBy(enhance.prefix().getPrefixResolver());
            if (enhance.includeSyntheticFields()) {
                junction = ElementMatchers.none();
            } else {
                junction = ElementMatchers.isSynthetic();
            }
            builder = method.intercept(prefixedBy.withIgnoredFields(junction).withIgnoredFields(ElementMatchers.isAnnotatedWith(Exclude.class)));
        }
        return builder;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Target({ElementType.TYPE})
    @Documented
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: grasscutter.jar:net/bytebuddy/build/ToStringPlugin$Enhance.class */
    public @interface Enhance {
        Prefix prefix() default Prefix.SIMPLE;

        boolean includeSyntheticFields() default false;

        /* loaded from: grasscutter.jar:net/bytebuddy/build/ToStringPlugin$Enhance$Prefix.class */
        public enum Prefix {
            FULLY_QUALIFIED(ToStringMethod.PrefixResolver.Default.FULLY_QUALIFIED_CLASS_NAME),
            CANONICAL(ToStringMethod.PrefixResolver.Default.CANONICAL_CLASS_NAME),
            SIMPLE(ToStringMethod.PrefixResolver.Default.SIMPLE_CLASS_NAME);
            
            private final ToStringMethod.PrefixResolver.Default prefixResolver;

            Prefix(ToStringMethod.PrefixResolver.Default prefixResolver) {
                this.prefixResolver = prefixResolver;
            }

            protected ToStringMethod.PrefixResolver.Default getPrefixResolver() {
                return this.prefixResolver;
            }
        }
    }
}
