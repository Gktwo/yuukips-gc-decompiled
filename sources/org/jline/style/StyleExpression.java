package org.jline.style;

import java.util.Objects;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;

/* loaded from: grasscutter.jar:org/jline/style/StyleExpression.class */
public class StyleExpression {
    private final StyleResolver resolver;

    public StyleExpression() {
        this(new StyleResolver(new NopStyleSource(), ""));
    }

    public StyleExpression(StyleResolver resolver) {
        this.resolver = (StyleResolver) Objects.requireNonNull(resolver);
    }

    public void evaluate(AttributedStringBuilder buff, String expression) {
        Objects.requireNonNull(buff);
        Objects.requireNonNull(expression);
        buff.appendAnsi(InterpolationHelper.substVars(expression, this::style, false));
    }

    private String style(String key) {
        int idx = key.indexOf(32);
        if (idx <= 0) {
            return null;
        }
        String spec = key.substring(0, idx);
        return new AttributedStringBuilder().style(this.resolver.resolve(spec)).ansiAppend(key.substring(idx + 1)).toAnsi();
    }

    public AttributedString evaluate(String expression) {
        AttributedStringBuilder buff = new AttributedStringBuilder();
        evaluate(buff, expression);
        return buff.toAttributedString();
    }
}
