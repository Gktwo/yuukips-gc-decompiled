package dev.morphia.mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import net.bytebuddy.utility.JavaConstant;

/* loaded from: grasscutter.jar:dev/morphia/mapping/NamingStrategy.class */
public abstract class NamingStrategy {
    public abstract String apply(String str);

    public static NamingStrategy identity() {
        return new NamingStrategy() { // from class: dev.morphia.mapping.NamingStrategy.1
            @Override // dev.morphia.mapping.NamingStrategy
            public String apply(String value) {
                return value;
            }
        };
    }

    public static NamingStrategy lowerCase() {
        return new NamingStrategy() { // from class: dev.morphia.mapping.NamingStrategy.2
            @Override // dev.morphia.mapping.NamingStrategy
            public String apply(String value) {
                return value.toLowerCase();
            }
        };
    }

    public static NamingStrategy snakeCase() {
        return new NamingStrategy() { // from class: dev.morphia.mapping.NamingStrategy.3
            @Override // dev.morphia.mapping.NamingStrategy
            public String apply(String value) {
                List<String> groups = NamingStrategy.groupByCapitals(value);
                StringJoiner joiner = new StringJoiner(JavaConstant.Dynamic.DEFAULT_NAME);
                for (String group : groups) {
                    joiner.add(group.toLowerCase());
                }
                return joiner.toString();
            }
        };
    }

    public static NamingStrategy camelCase() {
        return new NamingStrategy() { // from class: dev.morphia.mapping.NamingStrategy.4
            @Override // dev.morphia.mapping.NamingStrategy
            public String apply(String value) {
                List<String> groups = NamingStrategy.groupByCapitals(value);
                StringJoiner joiner = new StringJoiner("");
                joiner.add(groups.get(0).toLowerCase());
                for (int i = 1; i < groups.size(); i++) {
                    joiner.add(groups.get(i));
                }
                return joiner.toString();
            }
        };
    }

    public static NamingStrategy kebabCase() {
        return new NamingStrategy() { // from class: dev.morphia.mapping.NamingStrategy.5
            @Override // dev.morphia.mapping.NamingStrategy
            public String apply(String value) {
                List<String> groups = NamingStrategy.groupByCapitals(value);
                StringJoiner joiner = new StringJoiner("-");
                joiner.add(groups.get(0).toLowerCase());
                for (int i = 1; i < groups.size(); i++) {
                    joiner.add(groups.get(i).toLowerCase());
                }
                return joiner.toString();
            }
        };
    }

    private static List<String> groupByCapitals(String value) {
        List<String> groups = new ArrayList<>();
        StringBuilder builder = null;
        int length = value.length();
        for (int index = 0; index < length; index++) {
            char current = value.charAt(index);
            if (index == 0 || Character.isUpperCase(current)) {
                if (builder != null) {
                    groups.add(builder.toString());
                }
                builder = new StringBuilder();
            }
            builder.append(current);
        }
        groups.add(builder.toString());
        return groups;
    }
}
