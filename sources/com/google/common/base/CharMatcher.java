package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Arrays;
import java.util.BitSet;
import java.util.function.Predicate;

@GwtCompatible(emulated = true)
/* loaded from: grasscutter.jar:com/google/common/base/CharMatcher.class */
public abstract class CharMatcher implements Predicate<Character> {
    private static final int DISTINCT_CHARS = 65536;

    public abstract boolean matches(char c);

    public static CharMatcher any() {
        return Any.INSTANCE;
    }

    public static CharMatcher none() {
        return None.INSTANCE;
    }

    public static CharMatcher whitespace() {
        return Whitespace.INSTANCE;
    }

    public static CharMatcher breakingWhitespace() {
        return BreakingWhitespace.INSTANCE;
    }

    public static CharMatcher ascii() {
        return Ascii.INSTANCE;
    }

    @Deprecated
    public static CharMatcher digit() {
        return Digit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaDigit() {
        return JavaDigit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetter() {
        return JavaLetter.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLetterOrDigit() {
        return JavaLetterOrDigit.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaUpperCase() {
        return JavaUpperCase.INSTANCE;
    }

    @Deprecated
    public static CharMatcher javaLowerCase() {
        return JavaLowerCase.INSTANCE;
    }

    public static CharMatcher javaIsoControl() {
        return JavaIsoControl.INSTANCE;
    }

    @Deprecated
    public static CharMatcher invisible() {
        return Invisible.INSTANCE;
    }

    @Deprecated
    public static CharMatcher singleWidth() {
        return SingleWidth.INSTANCE;
    }

    /* renamed from: is */
    public static CharMatcher m1467is(char match) {
        return new C0106Is(match);
    }

    public static CharMatcher isNot(char match) {
        return new IsNot(match);
    }

    public static CharMatcher anyOf(CharSequence sequence) {
        switch (sequence.length()) {
            case 0:
                return none();
            case 1:
                return m1467is(sequence.charAt(0));
            case 2:
                return isEither(sequence.charAt(0), sequence.charAt(1));
            default:
                return new AnyOf(sequence);
        }
    }

    public static CharMatcher noneOf(CharSequence sequence) {
        return anyOf(sequence).negate();
    }

    public static CharMatcher inRange(char startInclusive, char endInclusive) {
        return new InRange(startInclusive, endInclusive);
    }

    public static CharMatcher forPredicate(Predicate<? super Character> predicate) {
        return predicate instanceof CharMatcher ? (CharMatcher) predicate : new ForPredicate(predicate);
    }

    protected CharMatcher() {
    }

    @Override // java.util.function.Predicate
    public CharMatcher negate() {
        return new Negated(this);
    }

    public CharMatcher and(CharMatcher other) {
        return new And(this, other);
    }

    /* renamed from: or */
    public CharMatcher mo1466or(CharMatcher other) {
        return new C0107Or(this, other);
    }

    public CharMatcher precomputed() {
        return Platform.precomputeCharMatcher(this);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public CharMatcher precomputedInternal() {
        BitSet table = new BitSet();
        setBits(table);
        int totalCharacters = table.cardinality();
        if (totalCharacters * 2 <= 65536) {
            return precomputedPositive(totalCharacters, table, toString());
        }
        table.flip(0, 65536);
        int negatedCharacters = 65536 - totalCharacters;
        final String description = toString();
        return new NegatedFastMatcher(precomputedPositive(negatedCharacters, table, description.endsWith(".negate()") ? description.substring(0, description.length() - ".negate()".length()) : description + ".negate()")) { // from class: com.google.common.base.CharMatcher.1
            @Override // com.google.common.base.CharMatcher.Negated, com.google.common.base.CharMatcher, java.lang.Object
            public String toString() {
                return description;
            }
        };
    }

    @GwtIncompatible
    private static CharMatcher precomputedPositive(int totalCharacters, BitSet table, String description) {
        switch (totalCharacters) {
            case 0:
                return none();
            case 1:
                return m1467is((char) table.nextSetBit(0));
            case 2:
                char c1 = (char) table.nextSetBit(0);
                return isEither(c1, (char) table.nextSetBit(c1 + 1));
            default:
                return isSmall(totalCharacters, table.length()) ? SmallCharMatcher.from(table, description) : new BitSetMatcher(table, description);
        }
    }

    @GwtIncompatible
    private static boolean isSmall(int totalCharacters, int tableLength) {
        return totalCharacters <= 1023 && tableLength > (totalCharacters * 4) * 16;
    }

    @GwtIncompatible
    void setBits(BitSet table) {
        for (int c = 65535; c >= 0; c--) {
            if (matches((char) c)) {
                table.set(c);
            }
        }
    }

    public boolean matchesAnyOf(CharSequence sequence) {
        return !matchesNoneOf(sequence);
    }

    public boolean matchesAllOf(CharSequence sequence) {
        for (int i = sequence.length() - 1; i >= 0; i--) {
            if (!matches(sequence.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean matchesNoneOf(CharSequence sequence) {
        return indexIn(sequence) == -1;
    }

    public int indexIn(CharSequence sequence) {
        return indexIn(sequence, 0);
    }

    public int indexIn(CharSequence sequence, int start) {
        int length = sequence.length();
        Preconditions.checkPositionIndex(start, length);
        for (int i = start; i < length; i++) {
            if (matches(sequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexIn(CharSequence sequence) {
        for (int i = sequence.length() - 1; i >= 0; i--) {
            if (matches(sequence.charAt(i))) {
                return i;
            }
        }
        return -1;
    }

    public int countIn(CharSequence sequence) {
        int count = 0;
        for (int i = 0; i < sequence.length(); i++) {
            if (matches(sequence.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    public String removeFrom(CharSequence sequence) {
        String string = sequence.toString();
        int pos = indexIn(string);
        if (pos == -1) {
            return string;
        }
        char[] chars = string.toCharArray();
        int spread = 1;
        while (true) {
            while (true) {
                pos++;
                if (pos == chars.length) {
                    return new String(chars, 0, pos - spread);
                }
                if (matches(chars[pos])) {
                    break;
                }
                chars[pos - spread] = chars[pos];
            }
            spread++;
        }
    }

    public String retainFrom(CharSequence sequence) {
        return negate().removeFrom(sequence);
    }

    public String replaceFrom(CharSequence sequence, char replacement) {
        String string = sequence.toString();
        int pos = indexIn(string);
        if (pos == -1) {
            return string;
        }
        char[] chars = string.toCharArray();
        chars[pos] = replacement;
        for (int i = pos + 1; i < chars.length; i++) {
            if (matches(chars[i])) {
                chars[i] = replacement;
            }
        }
        return new String(chars);
    }

    public String replaceFrom(CharSequence sequence, CharSequence replacement) {
        int replacementLen = replacement.length();
        if (replacementLen == 0) {
            return removeFrom(sequence);
        }
        if (replacementLen == 1) {
            return replaceFrom(sequence, replacement.charAt(0));
        }
        String string = sequence.toString();
        int pos = indexIn(string);
        if (pos == -1) {
            return string;
        }
        int len = string.length();
        StringBuilder buf = new StringBuilder(((len * 3) / 2) + 16);
        int oldpos = 0;
        do {
            buf.append((CharSequence) string, oldpos, pos);
            buf.append(replacement);
            oldpos = pos + 1;
            pos = indexIn(string, oldpos);
        } while (pos != -1);
        buf.append((CharSequence) string, oldpos, len);
        return buf.toString();
    }

    public String trimFrom(CharSequence sequence) {
        int len = sequence.length();
        int first = 0;
        while (first < len && matches(sequence.charAt(first))) {
            first++;
        }
        int last = len - 1;
        while (last > first && matches(sequence.charAt(last))) {
            last--;
        }
        return sequence.subSequence(first, last + 1).toString();
    }

    public String trimLeadingFrom(CharSequence sequence) {
        int len = sequence.length();
        for (int first = 0; first < len; first++) {
            if (!matches(sequence.charAt(first))) {
                return sequence.subSequence(first, len).toString();
            }
        }
        return "";
    }

    public String trimTrailingFrom(CharSequence sequence) {
        for (int last = sequence.length() - 1; last >= 0; last--) {
            if (!matches(sequence.charAt(last))) {
                return sequence.subSequence(0, last + 1).toString();
            }
        }
        return "";
    }

    public String collapseFrom(CharSequence sequence, char replacement) {
        int len = sequence.length();
        int i = 0;
        while (i < len) {
            char c = sequence.charAt(i);
            if (matches(c)) {
                if (c != replacement || (i != len - 1 && matches(sequence.charAt(i + 1)))) {
                    return finishCollapseFrom(sequence, i + 1, len, replacement, new StringBuilder(len).append(sequence, 0, i).append(replacement), true);
                }
                i++;
            }
            i++;
        }
        return sequence.toString();
    }

    public String trimAndCollapseFrom(CharSequence sequence, char replacement) {
        int len = sequence.length();
        int first = 0;
        int last = len - 1;
        while (first < len && matches(sequence.charAt(first))) {
            first++;
        }
        while (last > first && matches(sequence.charAt(last))) {
            last--;
        }
        if (first == 0 && last == len - 1) {
            return collapseFrom(sequence, replacement);
        }
        return finishCollapseFrom(sequence, first, last + 1, replacement, new StringBuilder((last + 1) - first), false);
    }

    private String finishCollapseFrom(CharSequence sequence, int start, int end, char replacement, StringBuilder builder, boolean inMatchingGroup) {
        for (int i = start; i < end; i++) {
            char c = sequence.charAt(i);
            if (!matches(c)) {
                builder.append(c);
                inMatchingGroup = false;
            } else if (!inMatchingGroup) {
                builder.append(replacement);
                inMatchingGroup = true;
            }
        }
        return builder.toString();
    }

    @Deprecated
    public boolean apply(Character character) {
        return matches(character.charValue());
    }

    @Override // java.lang.Object
    public String toString() {
        return toString();
    }

    /* access modifiers changed from: private */
    public static String showCharacter(char c) {
        char[] tmp = new char[6];
        tmp[0] = '\\';
        tmp[1] = 'u';
        tmp[2] = 0;
        tmp[3] = 0;
        tmp[4] = 0;
        tmp[5] = 0;
        for (int i = 0; i < 4; i++) {
            tmp[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        return String.copyValueOf(tmp);
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$FastMatcher.class */
    static abstract class FastMatcher extends CharMatcher {
        FastMatcher() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return new NegatedFastMatcher(this);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$NamedFastMatcher.class */
    public static abstract class NamedFastMatcher extends FastMatcher {
        private final String description;

        /* access modifiers changed from: package-private */
        public NamedFastMatcher(String description) {
            this.description = (String) Preconditions.checkNotNull(description);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public final String toString() {
            return this.description;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$NegatedFastMatcher.class */
    public static class NegatedFastMatcher extends Negated {
        NegatedFastMatcher(CharMatcher original) {
            super(original);
        }

        @Override // com.google.common.base.CharMatcher
        public final CharMatcher precomputed() {
            return this;
        }
    }

    /* access modifiers changed from: private */
    @GwtIncompatible
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$BitSetMatcher.class */
    public static final class BitSetMatcher extends NamedFastMatcher {
        private final BitSet table;

        private BitSetMatcher(BitSet table, String description) {
            super(description);
            this.table = table.length() + 64 < table.size() ? (BitSet) table.clone() : table;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.table.get(c);
        }

        @Override // com.google.common.base.CharMatcher
        void setBits(BitSet bitSet) {
            bitSet.or(this.table);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Any.class */
    private static final class Any extends NamedFastMatcher {
        static final Any INSTANCE = new Any();

        private Any() {
            super("CharMatcher.any()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence sequence) {
            return sequence.length() == 0 ? -1 : 0;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence sequence, int start) {
            int length = sequence.length();
            Preconditions.checkPositionIndex(start, length);
            if (start == length) {
                return -1;
            }
            return start;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence sequence) {
            return sequence.length() - 1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence sequence) {
            return sequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence sequence, char replacement) {
            char[] array = new char[sequence.length()];
            Arrays.fill(array, replacement);
            return new String(array);
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence sequence, CharSequence replacement) {
            StringBuilder result = new StringBuilder(sequence.length() * replacement.length());
            for (int i = 0; i < sequence.length(); i++) {
                result.append(replacement);
            }
            return result.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence sequence, char replacement) {
            return sequence.length() == 0 ? "" : String.valueOf(replacement);
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return "";
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence sequence) {
            return sequence.length();
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher other) {
            return (CharMatcher) Preconditions.checkNotNull(other);
        }

        @Override // com.google.common.base.CharMatcher
        /* renamed from: or */
        public CharMatcher mo1466or(CharMatcher other) {
            Preconditions.checkNotNull(other);
            return this;
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return none();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$None.class */
    public static final class None extends NamedFastMatcher {
        static final None INSTANCE = new None();

        private None() {
            super("CharMatcher.none()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return false;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int indexIn(CharSequence sequence, int start) {
            Preconditions.checkPositionIndex(start, sequence.length());
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public int lastIndexIn(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return -1;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence sequence) {
            return sequence.length() == 0;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return true;
        }

        @Override // com.google.common.base.CharMatcher
        public String removeFrom(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence sequence, char replacement) {
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence sequence, CharSequence replacement) {
            Preconditions.checkNotNull(replacement);
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String collapseFrom(CharSequence sequence, char replacement) {
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimFrom(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimLeadingFrom(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public String trimTrailingFrom(CharSequence sequence) {
            return sequence.toString();
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence sequence) {
            Preconditions.checkNotNull(sequence);
            return 0;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher other) {
            Preconditions.checkNotNull(other);
            return this;
        }

        @Override // com.google.common.base.CharMatcher
        /* renamed from: or */
        public CharMatcher mo1466or(CharMatcher other) {
            return (CharMatcher) Preconditions.checkNotNull(other);
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return any();
        }
    }

    @VisibleForTesting
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Whitespace.class */
    static final class Whitespace extends NamedFastMatcher {
        static final int MULTIPLIER = 1682554634;
        static final String TABLE = " 　\r   　 \u000b　   　 \t     \f 　 　　 \n 　";
        static final int SHIFT = Integer.numberOfLeadingZeros(TABLE.length() - 1);
        static final Whitespace INSTANCE = new Whitespace();

        Whitespace() {
            super("CharMatcher.whitespace()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return TABLE.charAt((MULTIPLIER * c) >>> SHIFT) == c;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            for (int i = 0; i < TABLE.length(); i++) {
                table.set(TABLE.charAt(i));
            }
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$BreakingWhitespace.class */
    private static final class BreakingWhitespace extends CharMatcher {
        static final CharMatcher INSTANCE = new BreakingWhitespace();

        private BreakingWhitespace() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            switch (c) {
                case '\t':
                case '\n':
                case 11:
                case '\f':
                case '\r':
                case ' ':
                case 133:
                case 5760:
                case 8232:
                case 8233:
                case 8287:
                case 12288:
                    return true;
                case 8199:
                    return false;
                default:
                    return c >= 8192 && c <= 8202;
            }
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.breakingWhitespace()";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Ascii.class */
    private static final class Ascii extends NamedFastMatcher {
        static final Ascii INSTANCE = new Ascii();

        Ascii() {
            super("CharMatcher.ascii()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 127;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$RangesMatcher.class */
    private static class RangesMatcher extends CharMatcher {
        private final String description;
        private final char[] rangeStarts;
        private final char[] rangeEnds;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        RangesMatcher(String description, char[] rangeStarts, char[] rangeEnds) {
            this.description = description;
            this.rangeStarts = rangeStarts;
            this.rangeEnds = rangeEnds;
            Preconditions.checkArgument(rangeStarts.length == rangeEnds.length);
            for (int i = 0; i < rangeStarts.length; i++) {
                Preconditions.checkArgument(rangeStarts[i] <= rangeEnds[i]);
                if (i + 1 < rangeStarts.length) {
                    Preconditions.checkArgument(rangeEnds[i] < rangeStarts[i + 1]);
                }
            }
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            int index = Arrays.binarySearch(this.rangeStarts, c);
            if (index >= 0) {
                return true;
            }
            int index2 = (index ^ -1) - 1;
            return index2 >= 0 && c <= this.rangeEnds[index2];
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return this.description;
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Digit.class */
    private static final class Digit extends RangesMatcher {
        private static final String ZEROES = "0٠۰߀०০੦૦୦௦౦೦൦෦๐໐༠၀႐០᠐᥆᧐᪀᪐᭐᮰᱀᱐꘠꣐꤀꧐꧰꩐꯰０";
        static final Digit INSTANCE = new Digit();

        private static char[] zeroes() {
            return ZEROES.toCharArray();
        }

        private static char[] nines() {
            char[] nines = new char[ZEROES.length()];
            for (int i = 0; i < ZEROES.length(); i++) {
                nines[i] = (char) (ZEROES.charAt(i) + '\t');
            }
            return nines;
        }

        private Digit() {
            super("CharMatcher.digit()", zeroes(), nines());
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$JavaDigit.class */
    private static final class JavaDigit extends CharMatcher {
        static final JavaDigit INSTANCE = new JavaDigit();

        private JavaDigit() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isDigit(c);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.javaDigit()";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$JavaLetter.class */
    private static final class JavaLetter extends CharMatcher {
        static final JavaLetter INSTANCE = new JavaLetter();

        private JavaLetter() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLetter(c);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.javaLetter()";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$JavaLetterOrDigit.class */
    private static final class JavaLetterOrDigit extends CharMatcher {
        static final JavaLetterOrDigit INSTANCE = new JavaLetterOrDigit();

        private JavaLetterOrDigit() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLetterOrDigit(c);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.javaLetterOrDigit()";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$JavaUpperCase.class */
    private static final class JavaUpperCase extends CharMatcher {
        static final JavaUpperCase INSTANCE = new JavaUpperCase();

        private JavaUpperCase() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isUpperCase(c);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.javaUpperCase()";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$JavaLowerCase.class */
    private static final class JavaLowerCase extends CharMatcher {
        static final JavaLowerCase INSTANCE = new JavaLowerCase();

        private JavaLowerCase() {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Character.isLowerCase(c);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.javaLowerCase()";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$JavaIsoControl.class */
    private static final class JavaIsoControl extends NamedFastMatcher {
        static final JavaIsoControl INSTANCE = new JavaIsoControl();

        private JavaIsoControl() {
            super("CharMatcher.javaIsoControl()");
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c <= 31 || (c >= 127 && c <= 159);
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Invisible.class */
    private static final class Invisible extends RangesMatcher {
        private static final String RANGE_STARTS = "��­؀؜۝܏࣢ ᠎   ⁦　�﻿￹";
        private static final String RANGE_ENDS = "  ­؅؜۝܏࣢ ᠎‏ ⁤⁯　﻿￻";
        static final Invisible INSTANCE = new Invisible();

        private Invisible() {
            super("CharMatcher.invisible()", RANGE_STARTS.toCharArray(), RANGE_ENDS.toCharArray());
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$SingleWidth.class */
    private static final class SingleWidth extends RangesMatcher {
        static final SingleWidth INSTANCE = new SingleWidth();

        private SingleWidth() {
            super("CharMatcher.singleWidth()", "��־א׳؀ݐ฀Ḁ℀ﭐﹰ｡".toCharArray(), "ӹ־ת״ۿݿ๿₯℺﷿﻿ￜ".toCharArray());
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Negated.class */
    public static class Negated extends CharMatcher {
        final CharMatcher original;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        Negated(CharMatcher original) {
            this.original = (CharMatcher) Preconditions.checkNotNull(original);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return !this.original.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesAllOf(CharSequence sequence) {
            return this.original.matchesNoneOf(sequence);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matchesNoneOf(CharSequence sequence) {
            return this.original.matchesAllOf(sequence);
        }

        @Override // com.google.common.base.CharMatcher
        public int countIn(CharSequence sequence) {
            return sequence.length() - this.original.countIn(sequence);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            BitSet tmp = new BitSet();
            this.original.setBits(tmp);
            tmp.flip(0, 65536);
            table.or(tmp);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return this.original;
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return this.original + ".negate()";
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$And.class */
    public static final class And extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        And(CharMatcher a, CharMatcher b) {
            this.first = (CharMatcher) Preconditions.checkNotNull(a);
            this.second = (CharMatcher) Preconditions.checkNotNull(b);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.first.matches(c) && this.second.matches(c);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            BitSet tmp1 = new BitSet();
            this.first.setBits(tmp1);
            BitSet tmp2 = new BitSet();
            this.second.setBits(tmp2);
            tmp1.and(tmp2);
            table.or(tmp1);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.and(" + this.first + ", " + this.second + ")";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.base.CharMatcher$Or */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Or.class */
    public static final class C0107Or extends CharMatcher {
        final CharMatcher first;
        final CharMatcher second;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        C0107Or(CharMatcher a, CharMatcher b) {
            this.first = (CharMatcher) Preconditions.checkNotNull(a);
            this.second = (CharMatcher) Preconditions.checkNotNull(b);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            this.first.setBits(table);
            this.second.setBits(table);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.first.matches(c) || this.second.matches(c);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.or(" + this.first + ", " + this.second + ")";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: com.google.common.base.CharMatcher$Is */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$Is.class */
    public static final class C0106Is extends FastMatcher {
        private final char match;

        C0106Is(char match) {
            this.match = match;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.match;
        }

        @Override // com.google.common.base.CharMatcher
        public String replaceFrom(CharSequence sequence, char replacement) {
            return sequence.toString().replace(this.match, replacement);
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher other) {
            return other.matches(this.match) ? this : none();
        }

        @Override // com.google.common.base.CharMatcher
        /* renamed from: or */
        public CharMatcher mo1466or(CharMatcher other) {
            return other.matches(this.match) ? other : mo1466or(other);
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return isNot(this.match);
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            table.set(this.match);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.is('" + CharMatcher.showCharacter(this.match) + "')";
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$IsNot.class */
    public static final class IsNot extends FastMatcher {
        private final char match;

        IsNot(char match) {
            this.match = match;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c != this.match;
        }

        @Override // com.google.common.base.CharMatcher
        public CharMatcher and(CharMatcher other) {
            return other.matches(this.match) ? and(other) : other;
        }

        @Override // com.google.common.base.CharMatcher
        /* renamed from: or */
        public CharMatcher mo1466or(CharMatcher other) {
            return other.matches(this.match) ? any() : this;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            table.set(0, this.match);
            table.set(this.match + 1, 65536);
        }

        @Override // com.google.common.base.CharMatcher.FastMatcher, com.google.common.base.CharMatcher, java.util.function.Predicate
        public CharMatcher negate() {
            return m1467is(this.match);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.isNot('" + CharMatcher.showCharacter(this.match) + "')";
        }
    }

    private static IsEither isEither(char c1, char c2) {
        return new IsEither(c1, c2);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$IsEither.class */
    public static final class IsEither extends FastMatcher {
        private final char match1;
        private final char match2;

        IsEither(char match1, char match2) {
            this.match1 = match1;
            this.match2 = match2;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return c == this.match1 || c == this.match2;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            table.set(this.match1);
            table.set(this.match2);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.anyOf(\"" + CharMatcher.showCharacter(this.match1) + CharMatcher.showCharacter(this.match2) + "\")";
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$AnyOf.class */
    public static final class AnyOf extends CharMatcher {
        private final char[] chars;

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.base.CharMatcher, com.google.common.base.Predicate
        @Deprecated
        public /* bridge */ /* synthetic */ boolean apply(Character ch) {
            return apply(ch);
        }

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        public AnyOf(CharSequence chars) {
            this.chars = chars.toString().toCharArray();
            Arrays.sort(this.chars);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return Arrays.binarySearch(this.chars, c) >= 0;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            for (char c : this.chars) {
                table.set(c);
            }
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            StringBuilder description = new StringBuilder("CharMatcher.anyOf(\"");
            for (char c : this.chars) {
                description.append(CharMatcher.showCharacter(c));
            }
            description.append("\")");
            return description.toString();
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$InRange.class */
    private static final class InRange extends FastMatcher {
        private final char startInclusive;
        private final char endInclusive;

        InRange(char startInclusive, char endInclusive) {
            Preconditions.checkArgument(endInclusive >= startInclusive);
            this.startInclusive = startInclusive;
            this.endInclusive = endInclusive;
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.startInclusive <= c && c <= this.endInclusive;
        }

        @Override // com.google.common.base.CharMatcher
        @GwtIncompatible
        void setBits(BitSet table) {
            table.set(this.startInclusive, this.endInclusive + 1);
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.inRange('" + CharMatcher.showCharacter(this.startInclusive) + "', '" + CharMatcher.showCharacter(this.endInclusive) + "')";
        }
    }

    /* loaded from: grasscutter.jar:com/google/common/base/CharMatcher$ForPredicate.class */
    private static final class ForPredicate extends CharMatcher {
        private final Predicate<? super Character> predicate;

        @Override // com.google.common.base.CharMatcher, java.util.function.Predicate
        public /* bridge */ /* synthetic */ Predicate negate() {
            return negate();
        }

        ForPredicate(Predicate<? super Character> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        @Override // com.google.common.base.CharMatcher
        public boolean matches(char c) {
            return this.predicate.apply(Character.valueOf(c));
        }

        @Override // com.google.common.base.CharMatcher
        public boolean apply(Character character) {
            return this.predicate.apply(Preconditions.checkNotNull(character));
        }

        @Override // com.google.common.base.CharMatcher, java.lang.Object
        public String toString() {
            return "CharMatcher.forPredicate(" + this.predicate + ")";
        }
    }
}
