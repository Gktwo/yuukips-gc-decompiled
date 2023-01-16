package com.fasterxml.jackson.databind;

import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedField;
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import com.fasterxml.jackson.databind.introspect.AnnotatedParameter;
import java.io.Serializable;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies.class */
public abstract class PropertyNamingStrategies implements Serializable {
    private static final long serialVersionUID = 2;
    public static final PropertyNamingStrategy LOWER_CAMEL_CASE = new LowerCamelCaseStrategy();
    public static final PropertyNamingStrategy UPPER_CAMEL_CASE = new UpperCamelCaseStrategy();
    public static final PropertyNamingStrategy SNAKE_CASE = new SnakeCaseStrategy();
    public static final PropertyNamingStrategy UPPER_SNAKE_CASE = new UpperSnakeCaseStrategy();
    public static final PropertyNamingStrategy LOWER_CASE = new LowerCaseStrategy();
    public static final PropertyNamingStrategy KEBAB_CASE = new KebabCaseStrategy();
    public static final PropertyNamingStrategy LOWER_DOT_CASE = new LowerDotCaseStrategy();

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$NamingBase.class */
    public static abstract class NamingBase extends PropertyNamingStrategy {
        private static final long serialVersionUID = 2;

        public abstract String translate(String str);

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForField(MapperConfig<?> config, AnnotatedField field, String defaultName) {
            return translate(defaultName);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForGetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
            return translate(defaultName);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForSetterMethod(MapperConfig<?> config, AnnotatedMethod method, String defaultName) {
            return translate(defaultName);
        }

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategy
        public String nameForConstructorParameter(MapperConfig<?> config, AnnotatedParameter ctorParam, String defaultName) {
            return translate(defaultName);
        }

        protected String translateLowerCaseWithSeparator(String input, char separator) {
            if (input == null) {
                return input;
            }
            int length = input.length();
            if (length == 0) {
                return input;
            }
            StringBuilder result = new StringBuilder(length + (length >> 1));
            int upperCount = 0;
            for (int i = 0; i < length; i++) {
                char ch = input.charAt(i);
                char lc = Character.toLowerCase(ch);
                if (lc == ch) {
                    if (upperCount > 1) {
                        result.insert(result.length() - 1, separator);
                    }
                    upperCount = 0;
                } else {
                    if (upperCount == 0 && i > 0) {
                        result.append(separator);
                    }
                    upperCount++;
                }
                result.append(lc);
            }
            return result.toString();
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$SnakeCaseStrategy.class */
    public static class SnakeCaseStrategy extends NamingBase {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            if (input == null) {
                return input;
            }
            int length = input.length();
            StringBuilder result = new StringBuilder(length * 2);
            int resultLength = 0;
            boolean wasPrevTranslated = false;
            for (int i = 0; i < length; i++) {
                char c = input.charAt(i);
                if (i > 0 || c != '_') {
                    if (Character.isUpperCase(c)) {
                        if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '_') {
                            result.append('_');
                            resultLength++;
                        }
                        c = Character.toLowerCase(c);
                        wasPrevTranslated = true;
                    } else {
                        wasPrevTranslated = false;
                    }
                    result.append(c);
                    resultLength++;
                }
            }
            return resultLength > 0 ? result.toString() : input;
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$UpperSnakeCaseStrategy.class */
    public static class UpperSnakeCaseStrategy extends SnakeCaseStrategy {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.SnakeCaseStrategy, com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            if (translate(input) == null) {
                return null;
            }
            return translate(input).toUpperCase();
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$LowerCamelCaseStrategy.class */
    public static class LowerCamelCaseStrategy extends NamingBase {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            return input;
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$UpperCamelCaseStrategy.class */
    public static class UpperCamelCaseStrategy extends NamingBase {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            if (input == null || input.isEmpty()) {
                return input;
            }
            char c = input.charAt(0);
            char uc = Character.toUpperCase(c);
            if (c == uc) {
                return input;
            }
            StringBuilder sb = new StringBuilder(input);
            sb.setCharAt(0, uc);
            return sb.toString();
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$LowerCaseStrategy.class */
    public static class LowerCaseStrategy extends NamingBase {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            return input.toLowerCase();
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$KebabCaseStrategy.class */
    public static class KebabCaseStrategy extends NamingBase {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            return translateLowerCaseWithSeparator(input, '-');
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/PropertyNamingStrategies$LowerDotCaseStrategy.class */
    public static class LowerDotCaseStrategy extends NamingBase {
        private static final long serialVersionUID = 2;

        @Override // com.fasterxml.jackson.databind.PropertyNamingStrategies.NamingBase
        public String translate(String input) {
            return translateLowerCaseWithSeparator(input, '.');
        }
    }
}
