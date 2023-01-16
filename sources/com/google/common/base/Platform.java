package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.lang.ref.WeakReference;
import java.util.Locale;
import java.util.ServiceConfigurationError;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/base/Platform.class */
final class Platform {
    private static final Logger logger = Logger.getLogger(Platform.class.getName());
    private static final PatternCompiler patternCompiler = loadPatternCompiler();

    private Platform() {
    }

    /* access modifiers changed from: package-private */
    public static long systemNanoTime() {
        return System.nanoTime();
    }

    /* access modifiers changed from: package-private */
    public static CharMatcher precomputeCharMatcher(CharMatcher matcher) {
        return matcher.precomputedInternal();
    }

    /* access modifiers changed from: package-private */
    public static <T extends Enum<T>> Optional<T> getEnumIfPresent(Class<T> enumClass, String value) {
        WeakReference<? extends Enum<?>> ref = Enums.getEnumConstants(enumClass).get(value);
        return ref == null ? Optional.absent() : Optional.m1463of(enumClass.cast(ref.get()));
    }

    /* access modifiers changed from: package-private */
    public static String formatCompact4Digits(double value) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(value));
    }

    /* access modifiers changed from: package-private */
    public static boolean stringIsNullOrEmpty(String string) {
        return string == null || string.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public static String nullToEmpty(String string) {
        return string == null ? "" : string;
    }

    /* access modifiers changed from: package-private */
    public static String emptyToNull(String string) {
        if (stringIsNullOrEmpty(string)) {
            return null;
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public static CommonPattern compilePattern(String pattern) {
        Preconditions.checkNotNull(pattern);
        return patternCompiler.compile(pattern);
    }

    /* access modifiers changed from: package-private */
    public static boolean patternCompilerIsPcreLike() {
        return patternCompiler.isPcreLike();
    }

    private static PatternCompiler loadPatternCompiler() {
        return new JdkPatternCompiler();
    }

    private static void logPatternCompilerError(ServiceConfigurationError e) {
        logger.log(Level.WARNING, "Error loading regex compiler, falling back to next option", (Throwable) e);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/Platform$JdkPatternCompiler.class */
    public static final class JdkPatternCompiler implements PatternCompiler {
        private JdkPatternCompiler() {
        }

        @Override // com.google.common.base.PatternCompiler
        public CommonPattern compile(String pattern) {
            return new JdkPattern(Pattern.compile(pattern));
        }

        @Override // com.google.common.base.PatternCompiler
        public boolean isPcreLike() {
            return true;
        }
    }
}
