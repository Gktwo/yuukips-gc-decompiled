package org.bson.types;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.security.SecureRandom;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;
import org.bson.assertions.Assertions;

/* loaded from: grasscutter.jar:org/bson/types/ObjectId.class */
public final class ObjectId implements Comparable<ObjectId>, Serializable {
    private static final long serialVersionUID = 1;
    private static final int OBJECT_ID_LENGTH = 12;
    private static final int LOW_ORDER_THREE_BYTES = 16777215;
    private static final int RANDOM_VALUE1;
    private static final short RANDOM_VALUE2;
    private static final AtomicInteger NEXT_COUNTER = new AtomicInteger(new SecureRandom().nextInt());
    private static final char[] HEX_CHARS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private final int timestamp;
    private final int counter;
    private final int randomValue1;
    private final short randomValue2;

    static {
        try {
            SecureRandom secureRandom = new SecureRandom();
            RANDOM_VALUE1 = secureRandom.nextInt(16777216);
            RANDOM_VALUE2 = (short) secureRandom.nextInt(32768);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ObjectId get() {
        return new ObjectId();
    }

    public static ObjectId getSmallestWithDate(Date date) {
        return new ObjectId(dateToTimestampSeconds(date), 0, 0, 0, false);
    }

    public static boolean isValid(String hexString) {
        if (hexString == null) {
            throw new IllegalArgumentException();
        }
        int len = hexString.length();
        if (len != 24) {
            return false;
        }
        for (int i = 0; i < len; i++) {
            char c = hexString.charAt(i);
            if ((c < '0' || c > '9') && ((c < 'a' || c > 'f') && (c < 'A' || c > 'F'))) {
                return false;
            }
        }
        return true;
    }

    public ObjectId() {
        this(new Date());
    }

    public ObjectId(Date date) {
        this(dateToTimestampSeconds(date), NEXT_COUNTER.getAndIncrement() & LOW_ORDER_THREE_BYTES, false);
    }

    public ObjectId(Date date, int counter) {
        this(dateToTimestampSeconds(date), counter, true);
    }

    public ObjectId(int timestamp, int counter) {
        this(timestamp, counter, true);
    }

    private ObjectId(int timestamp, int counter, boolean checkCounter) {
        this(timestamp, RANDOM_VALUE1, RANDOM_VALUE2, counter, checkCounter);
    }

    private ObjectId(int timestamp, int randomValue1, short randomValue2, int counter, boolean checkCounter) {
        if ((randomValue1 & -16777216) != 0) {
            throw new IllegalArgumentException("The machine identifier must be between 0 and 16777215 (it must fit in three bytes).");
        } else if (!checkCounter || (counter & -16777216) == 0) {
            this.timestamp = timestamp;
            this.counter = counter & LOW_ORDER_THREE_BYTES;
            this.randomValue1 = randomValue1;
            this.randomValue2 = randomValue2;
        } else {
            throw new IllegalArgumentException("The counter must be between 0 and 16777215 (it must fit in three bytes).");
        }
    }

    public ObjectId(String hexString) {
        this(parseHexString(hexString));
    }

    public ObjectId(byte[] bytes) {
        this(ByteBuffer.wrap((byte[]) Assertions.isTrueArgument("bytes has length of 12", bytes, ((byte[]) Assertions.notNull("bytes", bytes)).length == 12)));
    }

    public ObjectId(ByteBuffer buffer) {
        Assertions.notNull("buffer", buffer);
        Assertions.isTrueArgument("buffer.remaining() >=12", buffer.remaining() >= 12);
        this.timestamp = makeInt(buffer.get(), buffer.get(), buffer.get(), buffer.get());
        this.randomValue1 = makeInt((byte) 0, buffer.get(), buffer.get(), buffer.get());
        this.randomValue2 = makeShort(buffer.get(), buffer.get());
        this.counter = makeInt((byte) 0, buffer.get(), buffer.get(), buffer.get());
    }

    public byte[] toByteArray() {
        ByteBuffer buffer = ByteBuffer.allocate(12);
        putToByteBuffer(buffer);
        return buffer.array();
    }

    public void putToByteBuffer(ByteBuffer buffer) {
        Assertions.notNull("buffer", buffer);
        Assertions.isTrueArgument("buffer.remaining() >=12", buffer.remaining() >= 12);
        buffer.put(int3(this.timestamp));
        buffer.put(int2(this.timestamp));
        buffer.put(int1(this.timestamp));
        buffer.put(int0(this.timestamp));
        buffer.put(int2(this.randomValue1));
        buffer.put(int1(this.randomValue1));
        buffer.put(int0(this.randomValue1));
        buffer.put(short1(this.randomValue2));
        buffer.put(short0(this.randomValue2));
        buffer.put(int2(this.counter));
        buffer.put(int1(this.counter));
        buffer.put(int0(this.counter));
    }

    public int getTimestamp() {
        return this.timestamp;
    }

    public Date getDate() {
        return new Date((((long) this.timestamp) & 4294967295L) * 1000);
    }

    public String toHexString() {
        char[] chars = new char[24];
        int i = 0;
        byte[] byteArray = toByteArray();
        for (byte b : byteArray) {
            int i2 = i + 1;
            chars[i] = HEX_CHARS[(b >> 4) & 15];
            i = i2 + 1;
            chars[i2] = HEX_CHARS[b & 15];
        }
        return new String(chars);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ObjectId objectId = (ObjectId) o;
        if (this.counter == objectId.counter && this.timestamp == objectId.timestamp && this.randomValue1 == objectId.randomValue1 && this.randomValue2 == objectId.randomValue2) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (31 * ((31 * ((31 * this.timestamp) + this.counter)) + this.randomValue1)) + this.randomValue2;
    }

    public int compareTo(ObjectId other) {
        if (other == null) {
            throw new NullPointerException();
        }
        byte[] byteArray = toByteArray();
        byte[] otherByteArray = other.toByteArray();
        for (int i = 0; i < 12; i++) {
            if (byteArray[i] != otherByteArray[i]) {
                return (byteArray[i] & 255) < (otherByteArray[i] & 255) ? -1 : 1;
            }
        }
        return 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return toHexString();
    }

    private Object writeReplace() {
        return new SerializationProxy(this);
    }

    private void readObject(ObjectInputStream stream) throws InvalidObjectException {
        throw new InvalidObjectException("Proxy required");
    }

    /* loaded from: grasscutter.jar:org/bson/types/ObjectId$SerializationProxy.class */
    private static class SerializationProxy implements Serializable {
        private static final long serialVersionUID = 1;
        private final byte[] bytes;

        SerializationProxy(ObjectId objectId) {
            this.bytes = objectId.toByteArray();
        }

        private Object readResolve() {
            return new ObjectId(this.bytes);
        }
    }

    private static byte[] parseHexString(String s) {
        if (!isValid(s)) {
            throw new IllegalArgumentException("invalid hexadecimal representation of an ObjectId: [" + s + "]");
        }
        byte[] b = new byte[12];
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) Integer.parseInt(s.substring(i * 2, (i * 2) + 2), 16);
        }
        return b;
    }

    private static int dateToTimestampSeconds(Date time) {
        return (int) (time.getTime() / 1000);
    }

    private static int makeInt(byte b3, byte b2, byte b1, byte b0) {
        return (b3 << 24) | ((b2 & 255) << 16) | ((b1 & 255) << 8) | (b0 & 255);
    }

    private static short makeShort(byte b1, byte b0) {
        return (short) (((b1 & 255) << 8) | (b0 & 255));
    }

    private static byte int3(int x) {
        return (byte) (x >> 24);
    }

    private static byte int2(int x) {
        return (byte) (x >> 16);
    }

    private static byte int1(int x) {
        return (byte) (x >> 8);
    }

    private static byte int0(int x) {
        return (byte) x;
    }

    private static byte short1(short x) {
        return (byte) (x >> 8);
    }

    private static byte short0(short x) {
        return (byte) x;
    }
}
