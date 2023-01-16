package net.bytebuddy.matcher;

import java.util.Set;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/StringSetMatcher.class */
public class StringSetMatcher extends ElementMatcher.Junction.AbstractBase<String> {
    private final Set<String> values;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.values.equals(((StringSetMatcher) obj).values);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.values.hashCode();
    }

    public StringSetMatcher(Set<String> values) {
        this.values = values;
    }

    public boolean matches(String target) {
        return this.values.contains(target);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder().append("in(");
        boolean first = true;
        for (String value : this.values) {
            if (first) {
                first = false;
            } else {
                stringBuilder.append(", ");
            }
            stringBuilder.append(value);
        }
        return stringBuilder.append(")").toString();
    }
}
