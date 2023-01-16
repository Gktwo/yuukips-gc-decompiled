package org.jline.style;

import java.util.Objects;
import org.jline.utils.AttributedString;

/* loaded from: grasscutter.jar:org/jline/style/StyleFactory.class */
public class StyleFactory {
    private final StyleResolver resolver;

    public StyleFactory(StyleResolver resolver) {
        this.resolver = (StyleResolver) Objects.requireNonNull(resolver);
    }

    public AttributedString style(String style, String value) {
        Objects.requireNonNull(value);
        return new AttributedString(value, this.resolver.resolve(style));
    }

    public AttributedString style(String style, String format, Object... params) {
        Objects.requireNonNull(format);
        Objects.requireNonNull(params);
        return style(style, String.format(format, params));
    }

    public AttributedString evaluate(String expression) {
        Objects.requireNonNull(expression);
        return new StyleExpression(this.resolver).evaluate(expression);
    }

    public AttributedString evaluate(String format, Object... params) {
        Objects.requireNonNull(format);
        Objects.requireNonNull(params);
        return evaluate(String.format(format, params));
    }
}
