package org.reflections.util;

import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.reflections.ReflectionsException;
import org.slf4j.Marker;

/* loaded from: grasscutter.jar:org/reflections/util/FilterBuilder.class */
public class FilterBuilder implements Predicate<String> {
    private final List<Predicate<String>> chain = new ArrayList();

    public FilterBuilder() {
    }

    private FilterBuilder(Collection<Predicate<String>> filters) {
        this.chain.addAll(filters);
    }

    public FilterBuilder includePackage(String value) {
        return includePattern(prefixPattern(value));
    }

    public FilterBuilder excludePackage(String value) {
        return excludePattern(prefixPattern(value));
    }

    public FilterBuilder includePattern(String regex) {
        return add(new Include(regex));
    }

    public FilterBuilder excludePattern(String regex) {
        return add(new Exclude(regex));
    }

    @Deprecated
    public FilterBuilder include(String regex) {
        return add(new Include(regex));
    }

    @Deprecated
    public FilterBuilder exclude(String regex) {
        add(new Exclude(regex));
        return this;
    }

    public static FilterBuilder parsePackages(String includeExcludeString) {
        List<Predicate<String>> filters = new ArrayList<>();
        for (String string : includeExcludeString.split(",")) {
            String trimmed = string.trim();
            char prefix = trimmed.charAt(0);
            String pattern = prefixPattern(trimmed.substring(1));
            switch (prefix) {
                case '+':
                    filters.add(new Include(pattern));
                    break;
                case '-':
                    filters.add(new Exclude(pattern));
                    break;
                default:
                    throw new ReflectionsException("includeExclude should start with either + or -");
            }
        }
        return new FilterBuilder(filters);
    }

    public FilterBuilder add(Predicate<String> filter) {
        this.chain.add(filter);
        return this;
    }

    public boolean test(String regex) {
        boolean accept = this.chain.isEmpty() || (this.chain.get(0) instanceof Exclude);
        for (Predicate<String> filter : this.chain) {
            if (!accept || !(filter instanceof Include)) {
                if (accept || !(filter instanceof Exclude)) {
                    accept = filter.test(regex);
                    if (!accept && (filter instanceof Exclude)) {
                        break;
                    }
                }
            }
        }
        return accept;
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        return Objects.equals(this.chain, ((FilterBuilder) o).chain);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hash(this.chain);
    }

    @Override // java.lang.Object
    public String toString() {
        return (String) this.chain.stream().map((v0) -> {
            return v0.toString();
        }).collect(Collectors.joining(", "));
    }

    private static String prefixPattern(String fqn) {
        if (!fqn.endsWith(Mapper.IGNORED_FIELDNAME)) {
            fqn = fqn + Mapper.IGNORED_FIELDNAME;
        }
        return fqn.replace(Mapper.IGNORED_FIELDNAME, "\\.").replace("$", "\\$") + ".*";
    }

    /* loaded from: grasscutter.jar:org/reflections/util/FilterBuilder$Matcher.class */
    static abstract class Matcher implements Predicate<String> {
        final Pattern pattern;

        Matcher(String regex) {
            this.pattern = Pattern.compile(regex);
        }

        @Override // java.lang.Object
        public int hashCode() {
            return Objects.hash(this.pattern);
        }

        @Override // java.lang.Object
        public boolean equals(Object o) {
            return this == o || (o != null && getClass() == o.getClass() && Objects.equals(this.pattern.pattern(), ((Matcher) o).pattern.pattern()));
        }

        @Override // java.lang.Object
        public String toString() {
            return this.pattern.pattern();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/reflections/util/FilterBuilder$Include.class */
    public static class Include extends Matcher {
        Include(String regex) {
            super(regex);
        }

        public boolean test(String regex) {
            return this.pattern.matcher(regex).matches();
        }

        @Override // org.reflections.util.FilterBuilder.Matcher, java.lang.Object
        public String toString() {
            return Marker.ANY_NON_NULL_MARKER + this.pattern;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/reflections/util/FilterBuilder$Exclude.class */
    public static class Exclude extends Matcher {
        Exclude(String regex) {
            super(regex);
        }

        public boolean test(String regex) {
            return !this.pattern.matcher(regex).matches();
        }

        @Override // org.reflections.util.FilterBuilder.Matcher, java.lang.Object
        public String toString() {
            return "-" + this.pattern;
        }
    }
}
