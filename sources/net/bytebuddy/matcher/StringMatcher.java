package net.bytebuddy.matcher;

import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/StringMatcher.class */
public class StringMatcher extends ElementMatcher.Junction.AbstractBase<String> {
    private final String value;
    private final Mode mode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mode.equals(((StringMatcher) obj).mode) && this.value.equals(((StringMatcher) obj).value);
    }

    public int hashCode() {
        return (((getClass().hashCode() * 31) + this.value.hashCode()) * 31) + this.mode.hashCode();
    }

    public StringMatcher(String value, Mode mode) {
        this.value = value;
        this.mode = mode;
    }

    public boolean matches(String target) {
        return this.mode.matches(this.value, target);
    }

    public String toString() {
        return this.mode.getDescription() + '(' + this.value + ')';
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/matcher/StringMatcher$Mode.class */
    public enum Mode {
        EQUALS_FULLY("equals") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            protected boolean matches(String expected, String actual) {
                return actual.equals(expected);
            }
        },
        EQUALS_FULLY_IGNORE_CASE("equalsIgnoreCase") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            protected boolean matches(String expected, String actual) {
                return actual.equalsIgnoreCase(expected);
            }
        },
        STARTS_WITH("startsWith") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            protected boolean matches(String expected, String actual) {
                return actual.startsWith(expected);
            }
        },
        STARTS_WITH_IGNORE_CASE("startsWithIgnoreCase") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            @SuppressFBWarnings(value = {"DM_CONVERT_CASE"}, justification = "Both strings are transformed by the default locale")
            protected boolean matches(String expected, String actual) {
                return actual.toLowerCase().startsWith(expected.toLowerCase());
            }
        },
        ENDS_WITH("endsWith") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            protected boolean matches(String expected, String actual) {
                return actual.endsWith(expected);
            }
        },
        ENDS_WITH_IGNORE_CASE("endsWithIgnoreCase") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            @SuppressFBWarnings(value = {"DM_CONVERT_CASE"}, justification = "Both strings are transformed by the default locale")
            protected boolean matches(String expected, String actual) {
                return actual.toLowerCase().endsWith(expected.toLowerCase());
            }
        },
        CONTAINS("contains") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            protected boolean matches(String expected, String actual) {
                return actual.contains(expected);
            }
        },
        CONTAINS_IGNORE_CASE("containsIgnoreCase") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            @SuppressFBWarnings(value = {"DM_CONVERT_CASE"}, justification = "Both strings are transformed by the default locale")
            protected boolean matches(String expected, String actual) {
                return actual.toLowerCase().contains(expected.toLowerCase());
            }
        },
        MATCHES("matches") {
            @Override // net.bytebuddy.matcher.StringMatcher.Mode
            protected boolean matches(String expected, String actual) {
                return actual.matches(expected);
            }
        };
        
        private final String description;

        protected abstract boolean matches(String str, String str2);

        Mode(String description) {
            this.description = description;
        }

        protected String getDescription() {
            return this.description;
        }
    }
}
