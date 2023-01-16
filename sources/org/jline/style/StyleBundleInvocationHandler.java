package org.jline.style;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import org.jline.style.StyleBundle;
import org.jline.utils.AttributedString;

/* loaded from: grasscutter.jar:org/jline/style/StyleBundleInvocationHandler.class */
class StyleBundleInvocationHandler implements InvocationHandler {
    private static final Logger log = Logger.getLogger(StyleBundleInvocationHandler.class.getName());
    private final Class<? extends StyleBundle> type;
    private final StyleResolver resolver;

    public StyleBundleInvocationHandler(Class<? extends StyleBundle> type, StyleResolver resolver) {
        this.type = (Class) Objects.requireNonNull(type);
        this.resolver = (StyleResolver) Objects.requireNonNull(resolver);
    }

    private static void validate(Method method) {
        if (method.getParameterCount() != 1) {
            throw new InvalidStyleBundleMethodException(method, "Invalid parameters");
        } else if (method.getReturnType() != AttributedString.class) {
            throw new InvalidStyleBundleMethodException(method, "Invalid return-type");
        }
    }

    @Nullable
    private static String emptyToNull(@Nullable String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        return value;
    }

    @Nullable
    private static String getStyleGroup(Class<?> type) {
        StyleBundle.StyleGroup styleGroup = (StyleBundle.StyleGroup) type.getAnnotation(StyleBundle.StyleGroup.class);
        if (styleGroup != null) {
            return emptyToNull(styleGroup.value().trim());
        }
        return null;
    }

    private static String getStyleName(Method method) {
        StyleBundle.StyleName styleName = (StyleBundle.StyleName) method.getAnnotation(StyleBundle.StyleName.class);
        return styleName != null ? emptyToNull(styleName.value().trim()) : method.getName();
    }

    @Nullable
    private static String getDefaultStyle(Method method) {
        StyleBundle.DefaultStyle defaultStyle = (StyleBundle.DefaultStyle) method.getAnnotation(StyleBundle.DefaultStyle.class);
        if (defaultStyle != null) {
            return emptyToNull(defaultStyle.value());
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public static <T extends StyleBundle> T create(StyleResolver resolver, Class<T> type) {
        Objects.requireNonNull(resolver);
        Objects.requireNonNull(type);
        if (log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Using style-group: %s for type: %s", resolver.getGroup(), type.getName()));
        }
        return (T) ((StyleBundle) Proxy.newProxyInstance(type.getClassLoader(), new Class[]{type}, new StyleBundleInvocationHandler(type, resolver)));
    }

    /* access modifiers changed from: package-private */
    public static <T extends StyleBundle> T create(StyleSource source, Class<T> type) {
        Objects.requireNonNull(type);
        String group = getStyleGroup(type);
        if (group != null) {
            return (T) create(new StyleResolver(source, group), type);
        }
        throw new InvalidStyleGroupException(type);
    }

    @Override // java.lang.reflect.InvocationHandler
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        validate(method);
        String styleName = getStyleName(method);
        String style = this.resolver.getSource().get(this.resolver.getGroup(), styleName);
        if (log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Sourced-style: %s -> %s", styleName, style));
        }
        if (style == null) {
            style = getDefaultStyle(method);
            if (style == null) {
                throw new StyleBundleMethodMissingDefaultStyleException(method);
            }
        }
        String value = String.valueOf(args[0]);
        if (log.isLoggable(Level.FINEST)) {
            log.finest(String.format("Applying style: %s -> %s to: %s", styleName, style, value));
        }
        return new AttributedString(value, this.resolver.resolve(style));
    }

    @Override // java.lang.Object
    public String toString() {
        return this.type.getName();
    }

    /* loaded from: grasscutter.jar:org/jline/style/StyleBundleInvocationHandler$StyleBundleMethodMissingDefaultStyleException.class */
    static class StyleBundleMethodMissingDefaultStyleException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public StyleBundleMethodMissingDefaultStyleException(Method method) {
            super(String.format("%s method missing @%s: %s", StyleBundle.class.getSimpleName(), StyleBundle.DefaultStyle.class.getSimpleName(), method));
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/style/StyleBundleInvocationHandler$InvalidStyleBundleMethodException.class */
    public static class InvalidStyleBundleMethodException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public InvalidStyleBundleMethodException(Method method, String message) {
            super(message + ": " + method);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/style/StyleBundleInvocationHandler$InvalidStyleGroupException.class */
    static class InvalidStyleGroupException extends RuntimeException {
        private static final long serialVersionUID = 1;

        public InvalidStyleGroupException(Class<?> type) {
            super(String.format("%s missing or invalid @%s: %s", StyleBundle.class.getSimpleName(), StyleBundle.StyleGroup.class.getSimpleName(), type.getName()));
        }
    }
}
