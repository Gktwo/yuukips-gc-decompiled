package p000at.favre.lib.bytes;

import java.io.ByteArrayOutputStream;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

/* renamed from: at.favre.lib.bytes.Util */
/* loaded from: grasscutter.jar:at/favre/lib/bytes/Util.class */
final class Util {

    /* access modifiers changed from: package-private */
    /* renamed from: at.favre.lib.bytes.Util$Byte */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Util$Byte.class */
    public static final class Byte {
        private Byte() {
        }

        /* access modifiers changed from: package-private */
        public static byte[] concat(byte[]... arrays) {
            int length = 0;
            for (byte[] array : arrays) {
                length += array.length;
            }
            byte[] result = new byte[length];
            int pos = 0;
            for (byte[] array2 : arrays) {
                System.arraycopy(array2, 0, result, pos, array2.length);
                pos += array2.length;
            }
            return result;
        }

        /* access modifiers changed from: package-private */
        public static byte[] concatVararg(byte firstByte, byte[] moreBytes) {
            return moreBytes == null ? new byte[]{firstByte} : concat(new byte[]{firstByte}, moreBytes);
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
            r9 = r9 + 1;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int indexOf(byte[] r5, byte[] r6, int r7, int r8) {
            /*
                r0 = r5
                java.lang.String r1 = "array must not be null"
                java.lang.Object r0 = java.util.Objects.requireNonNull(r0, r1)
                r0 = r6
                java.lang.String r1 = "target must not be null"
                java.lang.Object r0 = java.util.Objects.requireNonNull(r0, r1)
                r0 = r6
                int r0 = r0.length
                if (r0 == 0) goto L_0x0017
                r0 = r7
                if (r0 >= 0) goto L_0x0019
            L_0x0017:
                r0 = -1
                return r0
            L_0x0019:
                r0 = r7
                r9 = r0
            L_0x001c:
                r0 = r9
                r1 = r8
                r2 = r5
                int r2 = r2.length
                r3 = r6
                int r3 = r3.length
                int r2 = r2 - r3
                r3 = 1
                int r2 = r2 + r3
                int r1 = java.lang.Math.min(r1, r2)
                if (r0 >= r1) goto L_0x0056
                r0 = 0
                r10 = r0
            L_0x002f:
                r0 = r10
                r1 = r6
                int r1 = r1.length
                if (r0 >= r1) goto L_0x004d
                r0 = r5
                r1 = r9
                r2 = r10
                int r1 = r1 + r2
                r0 = r0[r1]
                r1 = r6
                r2 = r10
                r1 = r1[r2]
                if (r0 == r1) goto L_0x0047
                goto L_0x0050
            L_0x0047:
                int r10 = r10 + 1
                goto L_0x002f
            L_0x004d:
                r0 = r9
                return r0
            L_0x0050:
                int r9 = r9 + 1
                goto L_0x001c
            L_0x0056:
                r0 = -1
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000at.favre.lib.bytes.Util.Byte.indexOf(byte[], byte[], int, int):int");
        }

        /* access modifiers changed from: package-private */
        public static int lastIndexOf(byte[] array, byte target, int start, int end) {
            for (int i = end - 1; i >= start; i--) {
                if (array[i] == target) {
                    return i;
                }
            }
            return -1;
        }

        /* access modifiers changed from: package-private */
        public static int countByte(byte[] array, byte target) {
            int count = 0;
            for (byte b : array) {
                if (b == target) {
                    count++;
                }
            }
            return count;
        }

        /* access modifiers changed from: package-private */
        public static int countByteArray(byte[] array, byte[] pattern) {
            Objects.requireNonNull(pattern, "pattern must not be null");
            if (pattern.length == 0 || array.length == 0) {
                return 0;
            }
            int count = 0;
            for (int i = 0; i < (array.length - pattern.length) + 1; i++) {
                int j = 0;
                while (true) {
                    if (j >= pattern.length) {
                        count++;
                        break;
                    } else if (array[i + j] != pattern[j]) {
                        break;
                    } else {
                        j++;
                    }
                }
            }
            return count;
        }

        /* access modifiers changed from: package-private */
        public static void shuffle(byte[] array, Random random) {
            for (int i = array.length - 1; i > 0; i--) {
                int index = random.nextInt(i + 1);
                byte a = array[index];
                array[index] = array[i];
                array[i] = a;
            }
        }

        /* access modifiers changed from: package-private */
        public static void reverse(byte[] array, int fromIndex, int toIndex) {
            Objects.requireNonNull(array);
            int i = fromIndex;
            for (int j = toIndex - 1; i < j; j--) {
                byte tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public static byte[] shiftLeft(byte[] byteArray, int shiftBitCount) {
            int shiftMod = shiftBitCount % 8;
            byte carryMask = (byte) ((1 << shiftMod) - 1);
            int offsetBytes = shiftBitCount / 8;
            for (int i = 0; i < byteArray.length; i++) {
                int sourceIndex = i + offsetBytes;
                if (sourceIndex >= byteArray.length) {
                    byteArray[i] = 0;
                } else {
                    byte dst = (byte) (byteArray[sourceIndex] << shiftMod);
                    if (sourceIndex + 1 < byteArray.length) {
                        dst = (byte) (dst | ((byteArray[sourceIndex + 1] >>> (8 - shiftMod)) & carryMask));
                    }
                    byteArray[i] = dst;
                }
            }
            return byteArray;
        }

        /* access modifiers changed from: package-private */
        public static byte[] shiftRight(byte[] byteArray, int shiftBitCount) {
            int shiftMod = shiftBitCount % 8;
            byte carryMask = (byte) (255 << (8 - shiftMod));
            int offsetBytes = shiftBitCount / 8;
            for (int i = byteArray.length - 1; i >= 0; i--) {
                int sourceIndex = i - offsetBytes;
                if (sourceIndex < 0) {
                    byteArray[i] = 0;
                } else {
                    byte dst = (byte) ((255 & byteArray[sourceIndex]) >>> shiftMod);
                    if (sourceIndex - 1 >= 0) {
                        dst = (byte) (dst | ((byteArray[sourceIndex - 1] << (8 - shiftMod)) & carryMask));
                    }
                    byteArray[i] = dst;
                }
            }
            return byteArray;
        }

        /* access modifiers changed from: package-private */
        public static boolean constantTimeEquals(byte[] array, byte[] anotherArray) {
            if (anotherArray == null || array.length != anotherArray.length) {
                return false;
            }
            int result = 0;
            for (int i = 0; i < array.length; i++) {
                result |= array[i] ^ anotherArray[i];
            }
            return result == 0;
        }

        /* JADX WARN: Type inference failed for: r0v22, types: [double] */
        /* access modifiers changed from: package-private */
        public static double entropy(byte[] array) {
            int[] buffer = new int[256];
            Arrays.fill(buffer, -1);
            for (byte element : array) {
                int unsigned = 255 & element;
                if (buffer[unsigned] == -1) {
                    buffer[unsigned] = 0;
                }
                buffer[unsigned] = buffer[unsigned] + 1;
            }
            char c = 0;
            for (int count : buffer) {
                if (count != -1) {
                    double prob = ((double) count) / ((double) array.length);
                    c -= prob * (Math.log(prob) / Math.log(2.0d));
                }
            }
            return c;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: at.favre.lib.bytes.Util$Converter */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Util$Converter.class */
    public static final class Converter {
        private Converter() {
        }

        /* access modifiers changed from: package-private */
        public static byte[] toArray(Collection<Byte> collection) {
            byte[] array = new byte[collection.size()];
            int i = 0;
            for (Byte b : collection) {
                array[i] = b.byteValue();
                i++;
            }
            return array;
        }

        /* access modifiers changed from: package-private */
        public static Byte[] toBoxedArray(byte[] array) {
            Byte[] objectArray = new Byte[array.length];
            for (int i = 0; i < array.length; i++) {
                objectArray[i] = Byte.valueOf(array[i]);
            }
            return objectArray;
        }

        /* access modifiers changed from: package-private */
        public static List<Byte> toList(byte[] array) {
            List<Byte> list = new ArrayList<>(array.length);
            for (byte b : array) {
                list.add(Byte.valueOf(b));
            }
            return list;
        }

        /* access modifiers changed from: package-private */
        public static byte[] toPrimitiveArray(Byte[] objectArray) {
            byte[] primitivesArray = new byte[objectArray.length];
            for (int i = 0; i < objectArray.length; i++) {
                primitivesArray[i] = objectArray[i].byteValue();
            }
            return primitivesArray;
        }

        /* access modifiers changed from: package-private */
        public static byte[] toByteArray(int[] intArray) {
            byte[] primitivesArray = new byte[intArray.length * 4];
            ByteBuffer buffer = ByteBuffer.allocate(4);
            for (int i = 0; i < intArray.length; i++) {
                buffer.clear();
                byte[] intBytes = buffer.putInt(intArray[i]).array();
                System.arraycopy(intBytes, 0, primitivesArray, i * 4, intBytes.length);
            }
            return primitivesArray;
        }

        /* access modifiers changed from: package-private */
        public static byte[] toByteArray(long[] longArray) {
            byte[] primitivesArray = new byte[longArray.length * 8];
            ByteBuffer buffer = ByteBuffer.allocate(8);
            for (int i = 0; i < longArray.length; i++) {
                buffer.clear();
                byte[] longBytes = buffer.putLong(longArray[i]).array();
                System.arraycopy(longBytes, 0, primitivesArray, i * 8, longBytes.length);
            }
            return primitivesArray;
        }

        /* access modifiers changed from: package-private */
        public static byte[] charToByteArray(char[] charArray, Charset charset, int offset, int length) {
            if (offset < 0 || offset > charArray.length) {
                throw new IllegalArgumentException("offset must be gt 0 and smaller than array length");
            } else if (length < 0 || length > charArray.length) {
                throw new IllegalArgumentException("length must be at least 1 and less than array length");
            } else if (offset + length > charArray.length) {
                throw new IllegalArgumentException("length + offset must be smaller than array length");
            } else if (length == 0) {
                return new byte[0];
            } else {
                CharBuffer charBuffer = CharBuffer.wrap(charArray);
                if (!(offset == 0 && length == charBuffer.remaining())) {
                    charBuffer = charBuffer.subSequence(offset, offset + length);
                }
                ByteBuffer bb = charset.encode(charBuffer);
                if (bb.capacity() == bb.limit()) {
                    return bb.array();
                }
                byte[] bytes = new byte[bb.remaining()];
                bb.get(bytes);
                return bytes;
            }
        }

        /* access modifiers changed from: package-private */
        public static char[] byteToCharArray(byte[] bytes, Charset charset, ByteOrder byteOrder) {
            Objects.requireNonNull(bytes, "bytes must not be null");
            Objects.requireNonNull(charset, "charset must not be null");
            try {
                CharBuffer charBuffer = charset.newDecoder().decode(ByteBuffer.wrap(bytes).order(byteOrder));
                if (charBuffer.capacity() == charBuffer.limit()) {
                    return charBuffer.array();
                }
                char[] compacted = new char[charBuffer.remaining()];
                charBuffer.get(compacted);
                return compacted;
            } catch (CharacterCodingException e) {
                throw new IllegalStateException(e);
            }
        }

        /* access modifiers changed from: package-private */
        public static int[] toIntArray(byte[] bytes, ByteOrder byteOrder) {
            IntBuffer buffer = ByteBuffer.wrap(bytes).order(byteOrder).asIntBuffer();
            int[] array = new int[buffer.remaining()];
            buffer.get(array);
            return array;
        }

        /* access modifiers changed from: package-private */
        public static long[] toLongArray(byte[] bytes, ByteOrder byteOrder) {
            LongBuffer buffer = ByteBuffer.wrap(bytes).order(byteOrder).asLongBuffer();
            long[] array = new long[buffer.remaining()];
            buffer.get(array);
            return array;
        }

        /* access modifiers changed from: package-private */
        public static float[] toFloatArray(byte[] bytes, ByteOrder byteOrder) {
            FloatBuffer buffer = ByteBuffer.wrap(bytes).order(byteOrder).asFloatBuffer();
            float[] array = new float[buffer.remaining()];
            buffer.get(array);
            return array;
        }

        /* access modifiers changed from: package-private */
        public static double[] toDoubleArray(byte[] bytes, ByteOrder byteOrder) {
            DoubleBuffer buffer = ByteBuffer.wrap(bytes).order(byteOrder).asDoubleBuffer();
            double[] array = new double[buffer.remaining()];
            buffer.get(array);
            return array;
        }

        /* access modifiers changed from: package-private */
        public static ByteBuffer toBytesFromUUID(UUID uuid) {
            ByteBuffer bb = ByteBuffer.allocate(16);
            bb.putLong(uuid.getMostSignificantBits());
            bb.putLong(uuid.getLeastSignificantBits());
            return bb;
        }
    }

    /* renamed from: at.favre.lib.bytes.Util$Obj */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Util$Obj.class */
    static final class Obj {
        private Obj() {
        }

        /* access modifiers changed from: package-private */
        public static boolean equals(byte[] obj, Byte[] anotherArray) {
            if (anotherArray == null || obj.length != anotherArray.length) {
                return false;
            }
            for (int i = 0; i < obj.length; i++) {
                if (anotherArray[i] == null || obj[i] != anotherArray[i].byteValue()) {
                    return false;
                }
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public static int hashCode(byte[] byteArray, ByteOrder byteOrder) {
            return (31 * Arrays.hashCode(byteArray)) + (byteOrder != null ? byteOrder.hashCode() : 0);
        }

        /* access modifiers changed from: package-private */
        public static String toString(Bytes bytes) {
            String preview;
            if (bytes.isEmpty()) {
                preview = "";
            } else if (bytes.length() > 8) {
                preview = "(0x" + bytes.copy(0, 4).encodeHex() + "..." + bytes.copy(bytes.length() - 4, 4).encodeHex() + ")";
            } else {
                preview = "(0x" + bytes.encodeHex() + ")";
            }
            return bytes.length() + " " + (bytes.length() == 1 ? "byte" : "bytes") + " " + preview;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: at.favre.lib.bytes.Util$Validation */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Util$Validation.class */
    public static final class Validation {
        private Validation() {
        }

        /* access modifiers changed from: package-private */
        public static void checkIndexBounds(int length, int index, int primitiveLength, String type) {
            if (index < 0 || index + primitiveLength > length) {
                throw new IndexOutOfBoundsException("cannot get " + type + " from index out of bounds: " + index);
            }
        }

        /* access modifiers changed from: package-private */
        public static void checkExactLength(int length, int expectedLength, String type) {
            if (length != expectedLength) {
                throw new IllegalArgumentException("cannot convert to " + type + " if length != " + expectedLength + " bytes (was " + length + ")");
            }
        }

        /* access modifiers changed from: package-private */
        public static void checkModLength(int length, int modFactor, String errorSubject) {
            if (length % modFactor != 0) {
                throw new IllegalArgumentException("Illegal length for " + errorSubject + ". Byte array length must be multiple of " + modFactor + ", length was " + length);
            }
        }

        /* access modifiers changed from: private */
        public static void checkFileExists(java.io.File file) {
            if (file == null || !file.exists() || !file.isFile()) {
                throw new IllegalArgumentException("file must not be null, has to exist and must be a file (not a directory) " + file);
            }
        }
    }

    /* renamed from: at.favre.lib.bytes.Util$File */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Util$File.class */
    static final class File {
        private static final int BUF_SIZE = 4096;

        private File() {
        }

        /* access modifiers changed from: package-private */
        public static byte[] readFromStream(InputStream inputStream, int maxLengthToRead) {
            boolean readWholeStream = maxLengthToRead == -1;
            int remaining = maxLengthToRead;
            try {
                ByteArrayOutputStream out = new ByteArrayOutputStream(readWholeStream ? 32 : maxLengthToRead);
                byte[] buf = new byte[0];
                while (true) {
                    if (!readWholeStream && remaining <= 0) {
                        break;
                    }
                    int bufSize = Math.min(4096, readWholeStream ? 4096 : remaining);
                    if (buf.length != bufSize) {
                        buf = new byte[bufSize];
                    }
                    int r = inputStream.read(buf);
                    if (r == -1) {
                        break;
                    }
                    remaining -= r;
                    out.write(buf, 0, r);
                }
                return out.toByteArray();
            } catch (Exception e) {
                throw new IllegalStateException("could not read from input stream", e);
            }
        }

        /* access modifiers changed from: package-private */
        public static byte[] readFromDataInput(DataInput dataInput, int length) {
            ByteArrayOutputStream out = new ByteArrayOutputStream(length);
            int remaining = length;
            for (int i = 0; i < length; i++) {
                try {
                    byte[] buf = new byte[Math.min(remaining, 4096)];
                    dataInput.readFully(buf);
                    out.write(buf);
                    remaining -= buf.length;
                } catch (Exception e) {
                    throw new IllegalStateException("could not read from data input", e);
                }
            }
            return out.toByteArray();
        }

        /* access modifiers changed from: package-private */
        public static byte[] readFromFile(java.io.File file) {
            Validation.checkFileExists(file);
            try {
                return Files.readAllBytes(file.toPath());
            } catch (IOException e) {
                throw new IllegalStateException("could not read from file", e);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0042
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        static byte[] readFromFile(java.io.File r5, int r6, int r7) {
            /*
                r0 = r5
                p000at.favre.lib.bytes.Util.Validation.access$000(r0)
                java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch: Exception -> 0x0070
                r1 = r0
                r2 = r5
                java.lang.String r3 = "r"
                r1.<init>(r2, r3)     // Catch: Exception -> 0x0070
                r8 = r0
                r0 = 0
                r9 = r0
                r0 = r8
                r1 = r6
                long r1 = (long) r1     // Catch: Throwable -> 0x0042, all -> 0x004b, Exception -> 0x0070
                r0.seek(r1)     // Catch: Throwable -> 0x0042, all -> 0x004b, Exception -> 0x0070
                r0 = r8
                r1 = r7
                byte[] r0 = readFromDataInput(r0, r1)     // Catch: Throwable -> 0x0042, all -> 0x004b, Exception -> 0x0070
                r10 = r0
                r0 = r8
                if (r0 == 0) goto L_0x003f
                r0 = r9
                if (r0 == 0) goto L_0x003b
                r0 = r8
                r0.close()     // Catch: Throwable -> 0x002f, Exception -> 0x0070
                goto L_0x003f
            L_0x002f:
                r11 = move-exception
                r0 = r9
                r1 = r11
                r0.addSuppressed(r1)     // Catch: Exception -> 0x0070
                goto L_0x003f
            L_0x003b:
                r0 = r8
                r0.close()     // Catch: Exception -> 0x0070
            L_0x003f:
                r0 = r10
                return r0
            L_0x0042:
                r10 = move-exception
                r0 = r10
                r9 = r0
                r0 = r10
                throw r0     // Catch: Exception -> 0x0070, all -> 0x004b
            L_0x004b:
                r12 = move-exception
                r0 = r8
                if (r0 == 0) goto L_0x006d
                r0 = r9
                if (r0 == 0) goto L_0x0069
                r0 = r8
                r0.close()     // Catch: Exception -> 0x0070, Throwable -> 0x005d
                goto L_0x006d
            L_0x005d:
                r13 = move-exception
                r0 = r9
                r1 = r13
                r0.addSuppressed(r1)     // Catch: Exception -> 0x0070
                goto L_0x006d
            L_0x0069:
                r0 = r8
                r0.close()     // Catch: Exception -> 0x0070
            L_0x006d:
                r0 = r12
                throw r0     // Catch: Exception -> 0x0070
            L_0x0070:
                r8 = move-exception
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                r1 = r0
                java.lang.String r2 = "could not read from random access file"
                r3 = r8
                r1.<init>(r2, r3)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p000at.favre.lib.bytes.Util.File.readFromFile(java.io.File, int, int):byte[]");
        }
    }

    private Util() {
    }

    /* renamed from: at.favre.lib.bytes.Util$BytesIterator */
    /* loaded from: grasscutter.jar:at/favre/lib/bytes/Util$BytesIterator.class */
    static final class BytesIterator implements Iterator<Byte> {
        private final byte[] array;
        private int cursor = 0;

        /* access modifiers changed from: package-private */
        public BytesIterator(byte[] array) {
            this.array = array;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cursor != this.array.length;
        }

        @Override // java.util.Iterator
        public Byte next() {
            try {
                int i = this.cursor;
                Byte next = Byte.valueOf(this.array[i]);
                this.cursor = i + 1;
                return next;
            } catch (IndexOutOfBoundsException e) {
                throw new NoSuchElementException();
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("The Bytes iterator does not support removing");
        }
    }
}
