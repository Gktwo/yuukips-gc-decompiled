package net.bytebuddy.utility;

import java.util.Random;

/* loaded from: grasscutter.jar:net/bytebuddy/utility/RandomString.class */
public class RandomString {
    public static final int DEFAULT_LENGTH = 8;
    private static final char[] SYMBOL;
    private static final int KEY_BITS;
    private final Random random;
    private final int length;

    static {
        StringBuilder symbol = new StringBuilder();
        for (char character = '0'; character <= '9'; character = (char) (character + 1)) {
            symbol.append(character);
        }
        for (char character2 = 'a'; character2 <= 'z'; character2 = (char) (character2 + 1)) {
            symbol.append(character2);
        }
        for (char character3 = 'A'; character3 <= 'Z'; character3 = (char) (character3 + 1)) {
            symbol.append(character3);
        }
        SYMBOL = symbol.toString().toCharArray();
        int bits = 32 - Integer.numberOfLeadingZeros(SYMBOL.length);
        KEY_BITS = bits - (Integer.bitCount(SYMBOL.length) == bits ? 0 : 1);
    }

    public RandomString() {
        this(8);
    }

    public RandomString(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("A random string's length cannot be zero or negative");
        }
        this.length = length;
        this.random = new Random();
    }

    public static String make() {
        return make(8);
    }

    public static String make(int length) {
        return new RandomString(length).nextString();
    }

    public static String hashOf(int value) {
        char[] buffer = new char[(32 / KEY_BITS) + (32 % KEY_BITS == 0 ? 0 : 1)];
        for (int index = 0; index < buffer.length; index++) {
            buffer[index] = SYMBOL[(value >>> (index * KEY_BITS)) & (-1 >>> (32 - KEY_BITS))];
        }
        return new String(buffer);
    }

    public String nextString() {
        char[] buffer = new char[this.length];
        for (int index = 0; index < this.length; index++) {
            buffer[index] = SYMBOL[this.random.nextInt(SYMBOL.length)];
        }
        return new String(buffer);
    }
}
