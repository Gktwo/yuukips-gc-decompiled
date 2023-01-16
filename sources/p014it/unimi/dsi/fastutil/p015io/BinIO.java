package p014it.unimi.dsi.fastutil.p015io;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.NoSuchElementException;
import p001ch.qos.logback.core.util.FileSize;
import p014it.unimi.dsi.fastutil.Arrays;
import p014it.unimi.dsi.fastutil.BigArrays;
import p014it.unimi.dsi.fastutil.booleans.BooleanBigArrays;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterable;
import p014it.unimi.dsi.fastutil.booleans.BooleanIterator;
import p014it.unimi.dsi.fastutil.bytes.ByteBigArrays;
import p014it.unimi.dsi.fastutil.bytes.ByteIterable;
import p014it.unimi.dsi.fastutil.bytes.ByteIterator;
import p014it.unimi.dsi.fastutil.chars.CharBigArrays;
import p014it.unimi.dsi.fastutil.chars.CharIterable;
import p014it.unimi.dsi.fastutil.chars.CharIterator;
import p014it.unimi.dsi.fastutil.chars.CharMappedBigList;
import p014it.unimi.dsi.fastutil.doubles.DoubleBigArrays;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterable;
import p014it.unimi.dsi.fastutil.doubles.DoubleIterator;
import p014it.unimi.dsi.fastutil.doubles.DoubleMappedBigList;
import p014it.unimi.dsi.fastutil.floats.FloatBigArrays;
import p014it.unimi.dsi.fastutil.floats.FloatIterable;
import p014it.unimi.dsi.fastutil.floats.FloatIterator;
import p014it.unimi.dsi.fastutil.floats.FloatMappedBigList;
import p014it.unimi.dsi.fastutil.ints.IntBigArrays;
import p014it.unimi.dsi.fastutil.ints.IntIterable;
import p014it.unimi.dsi.fastutil.ints.IntIterator;
import p014it.unimi.dsi.fastutil.ints.IntMappedBigList;
import p014it.unimi.dsi.fastutil.longs.LongBigArrays;
import p014it.unimi.dsi.fastutil.longs.LongIterable;
import p014it.unimi.dsi.fastutil.longs.LongIterator;
import p014it.unimi.dsi.fastutil.longs.LongMappedBigList;
import p014it.unimi.dsi.fastutil.shorts.ShortBigArrays;
import p014it.unimi.dsi.fastutil.shorts.ShortIterable;
import p014it.unimi.dsi.fastutil.shorts.ShortIterator;
import p014it.unimi.dsi.fastutil.shorts.ShortMappedBigList;

/* renamed from: it.unimi.dsi.fastutil.io.BinIO */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO.class */
public class BinIO {
    public static int BUFFER_SIZE = 8192;
    private static final int MAX_IO_LENGTH = 1048576;

    private BinIO() {
    }

    public static void storeObject(Object o, File file) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        oos.writeObject(o);
        oos.close();
    }

    public static void storeObject(Object o, CharSequence filename) throws IOException {
        storeObject(o, new File(filename.toString()));
    }

    public static Object loadObject(File file) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FastBufferedInputStream(new FileInputStream(file)));
        Object result = ois.readObject();
        ois.close();
        return result;
    }

    public static Object loadObject(CharSequence filename) throws IOException, ClassNotFoundException {
        return loadObject(new File(filename.toString()));
    }

    public static void storeObject(Object o, OutputStream s) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FastBufferedOutputStream(s));
        oos.writeObject(o);
        oos.flush();
    }

    public static Object loadObject(InputStream s) throws IOException, ClassNotFoundException {
        return new ObjectInputStream(new FastBufferedInputStream(s)).readObject();
    }

    public static int loadBooleans(DataInput dataInput, boolean[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readBoolean();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadBooleans(DataInput dataInput, boolean[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readBoolean();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadBooleans(File file, boolean[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        DataInputStream dis = new DataInputStream(new FastBufferedInputStream(new FileInputStream(file)));
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dis.readBoolean();
                i++;
            } catch (EOFException e) {
            }
        }
        dis.close();
        return i;
    }

    public static int loadBooleans(CharSequence filename, boolean[] array, int offset, int length) throws IOException {
        return loadBooleans(new File(filename.toString()), array, offset, length);
    }

    public static int loadBooleans(File file, boolean[] array) throws IOException {
        return loadBooleans(file, array, 0, array.length);
    }

    public static int loadBooleans(CharSequence filename, boolean[] array) throws IOException {
        return loadBooleans(new File(filename.toString()), array);
    }

    public static boolean[] loadBooleans(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        long length = fis.getChannel().size();
        if (length > 2147483647L) {
            fis.close();
            throw new IllegalArgumentException("File too long: " + fis.getChannel().size() + " bytes (" + length + " elements)");
        }
        boolean[] array = new boolean[(int) length];
        DataInputStream dis = new DataInputStream(new FastBufferedInputStream(fis));
        for (int i = 0; ((long) i) < length; i++) {
            array[i] = dis.readBoolean();
        }
        dis.close();
        return array;
    }

    public static boolean[] loadBooleans(CharSequence filename) throws IOException {
        return loadBooleans(new File(filename.toString()));
    }

    public static void storeBooleans(boolean[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeBoolean(array[offset + i]);
        }
    }

    public static void storeBooleans(boolean[] array, DataOutput dataOutput) throws IOException {
        for (boolean z : array) {
            dataOutput.writeBoolean(z);
        }
    }

    public static void storeBooleans(boolean[] array, int offset, int length, File file) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        DataOutputStream dos = new DataOutputStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        for (int i = 0; i < length; i++) {
            dos.writeBoolean(array[offset + i]);
        }
        dos.close();
    }

    public static void storeBooleans(boolean[] array, int offset, int length, CharSequence filename) throws IOException {
        storeBooleans(array, offset, length, new File(filename.toString()));
    }

    public static void storeBooleans(boolean[] array, File file) throws IOException {
        storeBooleans(array, 0, array.length, file);
    }

    public static void storeBooleans(boolean[] array, CharSequence filename) throws IOException {
        storeBooleans(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadBooleans(DataInput dataInput, boolean[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                boolean[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readBoolean();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadBooleans(DataInput dataInput, boolean[][] array) throws IOException {
        char c = 0;
        for (boolean[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readBoolean();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v22, types: [long] */
    public static long loadBooleans(File file, boolean[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        DataInputStream dis = new DataInputStream(new FastBufferedInputStream(new FileInputStream(file)));
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                boolean[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dis.readBoolean();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        dis.close();
        return c;
    }

    public static long loadBooleans(CharSequence filename, boolean[][] array, long offset, long length) throws IOException {
        return loadBooleans(new File(filename.toString()), array, offset, length);
    }

    /* JADX WARN: Type inference failed for: r0v15, types: [long] */
    public static long loadBooleans(File file, boolean[][] array) throws IOException {
        DataInputStream dis = new DataInputStream(new FastBufferedInputStream(new FileInputStream(file)));
        char c = 0;
        for (boolean[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dis.readBoolean();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        dis.close();
        return c;
    }

    public static long loadBooleans(CharSequence filename, boolean[][] array) throws IOException {
        return loadBooleans(new File(filename.toString()), array);
    }

    public static boolean[][] loadBooleansBig(File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        boolean[][] array = BooleanBigArrays.newBigArray(fis.getChannel().size());
        DataInputStream dis = new DataInputStream(new FastBufferedInputStream(fis));
        for (boolean[] t : array) {
            int l = t.length;
            for (int d = 0; d < l; d++) {
                t[d] = dis.readBoolean();
            }
        }
        dis.close();
        return array;
    }

    public static boolean[][] loadBooleansBig(CharSequence filename) throws IOException {
        return loadBooleansBig(new File(filename.toString()));
    }

    public static void storeBooleans(boolean[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            boolean[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeBoolean(t[d]);
            }
        }
    }

    public static void storeBooleans(boolean[][] array, DataOutput dataOutput) throws IOException {
        for (boolean[] t : array) {
            for (boolean z : t) {
                dataOutput.writeBoolean(z);
            }
        }
    }

    public static void storeBooleans(boolean[][] array, long offset, long length, File file) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            boolean[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dos.writeBoolean(t[d]);
            }
        }
        dos.close();
    }

    public static void storeBooleans(boolean[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeBooleans(array, offset, length, new File(filename.toString()));
    }

    public static void storeBooleans(boolean[][] array, File file) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        for (boolean[] t : array) {
            for (boolean z : t) {
                dos.writeBoolean(z);
            }
        }
        dos.close();
    }

    public static void storeBooleans(boolean[][] array, CharSequence filename) throws IOException {
        storeBooleans(array, new File(filename.toString()));
    }

    public static void storeBooleans(BooleanIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeBoolean(i.nextBoolean());
        }
    }

    public static void storeBooleans(BooleanIterator i, File file) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        while (i.hasNext()) {
            dos.writeBoolean(i.nextBoolean());
        }
        dos.close();
    }

    public static void storeBooleans(BooleanIterator i, CharSequence filename) throws IOException {
        storeBooleans(i, new File(filename.toString()));
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$BooleanDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$BooleanDataInputWrapper.class */
    public static final class BooleanDataInputWrapper implements BooleanIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private boolean next;

        public BooleanDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readBoolean();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.booleans.BooleanIterator
        public boolean nextBoolean() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static BooleanIterator asBooleanIterator(DataInput dataInput) {
        return new BooleanDataInputWrapper(dataInput);
    }

    public static BooleanIterator asBooleanIterator(File file) throws IOException {
        return new BooleanDataInputWrapper(new DataInputStream(new FastBufferedInputStream(new FileInputStream(file))));
    }

    public static BooleanIterator asBooleanIterator(CharSequence filename) throws IOException {
        return asBooleanIterator(new File(filename.toString()));
    }

    public static BooleanIterable asBooleanIterable(File file) {
        return () -> {
            try {
                return asBooleanIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static BooleanIterable asBooleanIterable(CharSequence filename) {
        return () -> {
            try {
                return asBooleanIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    private static int read(InputStream is, byte[] a, int offset, int length) throws IOException {
        if (length == 0) {
            return 0;
        }
        int read = 0;
        do {
            int result = is.read(a, offset + read, Math.min(length - read, 1048576));
            if (result < 0) {
                return read;
            }
            read += result;
        } while (read < length);
        return read;
    }

    private static void write(OutputStream outputStream, byte[] a, int offset, int length) throws IOException {
        int written = 0;
        while (written < length) {
            outputStream.write(a, offset + written, Math.min(length - written, 1048576));
            written += Math.min(length - written, 1048576);
        }
    }

    private static void write(DataOutput dataOutput, byte[] a, int offset, int length) throws IOException {
        int written = 0;
        while (written < length) {
            dataOutput.write(a, offset + written, Math.min(length - written, 1048576));
            written += Math.min(length - written, 1048576);
        }
    }

    public static int loadBytes(InputStream inputStream, byte[] array, int offset, int length) throws IOException {
        return read(inputStream, array, offset, length);
    }

    public static int loadBytes(InputStream inputStream, byte[] array) throws IOException {
        return read(inputStream, array, 0, array.length);
    }

    public static void storeBytes(byte[] array, int offset, int length, OutputStream outputStream) throws IOException {
        write(outputStream, array, offset, length);
    }

    public static void storeBytes(byte[] array, OutputStream outputStream) throws IOException {
        write(outputStream, array, 0, array.length);
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    private static long read(InputStream is, byte[][] a, long offset, long length) throws IOException {
        if (length == 0) {
            return 0;
        }
        char c = 0;
        int segment = BigArrays.segment(offset);
        int displacement = BigArrays.displacement(offset);
        do {
            int result = is.read(a[segment], displacement, (int) Math.min((long) (a[segment].length - displacement), Math.min(length - c, (long) FileSize.MB_COEFFICIENT)));
            if (result < 0) {
                return c;
            }
            c += (long) result;
            displacement += result;
            if (displacement == a[segment].length) {
                segment++;
                displacement = 0;
            }
        } while (c < length);
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    private static void write(OutputStream outputStream, byte[][] a, long offset, long length) throws IOException {
        if (length != 0) {
            char c = 0;
            int segment = BigArrays.segment(offset);
            int displacement = BigArrays.displacement(offset);
            do {
                int toWrite = (int) Math.min((long) (a[segment].length - displacement), Math.min(length - c, (long) FileSize.MB_COEFFICIENT));
                outputStream.write(a[segment], displacement, toWrite);
                c += (long) toWrite;
                displacement += toWrite;
                if (displacement == a[segment].length) {
                    segment++;
                    displacement = 0;
                }
            } while (c < length);
        }
    }

    /* JADX WARN: Type inference failed for: r0v16, types: [long] */
    private static void write(DataOutput dataOutput, byte[][] a, long offset, long length) throws IOException {
        if (length != 0) {
            char c = 0;
            int segment = BigArrays.segment(offset);
            int displacement = BigArrays.displacement(offset);
            do {
                int toWrite = (int) Math.min((long) (a[segment].length - displacement), Math.min(length - c, (long) FileSize.MB_COEFFICIENT));
                dataOutput.write(a[segment], displacement, toWrite);
                c += (long) toWrite;
                displacement += toWrite;
                if (displacement == a[segment].length) {
                    segment++;
                    displacement = 0;
                }
            } while (c < length);
        }
    }

    public static long loadBytes(InputStream inputStream, byte[][] array, long offset, long length) throws IOException {
        return read(inputStream, array, offset, length);
    }

    public static long loadBytes(InputStream inputStream, byte[][] array) throws IOException {
        return read(inputStream, array, 0, BigArrays.length(array));
    }

    public static void storeBytes(byte[][] array, long offset, long length, OutputStream outputStream) throws IOException {
        write(outputStream, array, offset, length);
    }

    public static void storeBytes(byte[][] array, OutputStream outputStream) throws IOException {
        write(outputStream, array, 0, BigArrays.length(array));
    }

    public static int loadBytes(ReadableByteChannel channel, byte[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer buffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
        int read = 0;
        while (true) {
            buffer.clear();
            buffer.limit(Math.min(buffer.capacity(), length));
            int r = channel.read(buffer);
            if (r <= 0) {
                return read;
            }
            read += r;
            buffer.flip();
            buffer.get(array, offset, r);
            offset += r;
            length -= r;
        }
    }

    public static int loadBytes(ReadableByteChannel channel, byte[] array) throws IOException {
        return loadBytes(channel, array, 0, array.length);
    }

    public static void storeBytes(byte[] array, int offset, int length, WritableByteChannel channel) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer buffer = ByteBuffer.allocateDirect(BUFFER_SIZE);
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            channel.write(buffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeBytes(byte[] array, WritableByteChannel channel) throws IOException {
        storeBytes(array, 0, array.length, channel);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadBytes(ReadableByteChannel channel, byte[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            byte[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadBytes(channel, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadBytes(ReadableByteChannel channel, byte[][] array) throws IOException {
        return loadBytes(channel, array, 0, BigArrays.length(array));
    }

    public static void storeBytes(byte[][] array, long offset, long length, WritableByteChannel channel) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeBytes(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel);
        }
    }

    public static void storeBytes(byte[][] array, WritableByteChannel channel) throws IOException {
        for (byte[] t : array) {
            storeBytes(t, channel);
        }
    }

    public static int loadBytes(DataInput dataInput, byte[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readByte();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadBytes(DataInput dataInput, byte[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readByte();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadBytes(File file, byte[] array, int offset, int length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int result = loadBytes(channel, array, offset, length);
        channel.close();
        return result;
    }

    public static int loadBytes(CharSequence filename, byte[] array, int offset, int length) throws IOException {
        return loadBytes(new File(filename.toString()), array, offset, length);
    }

    public static int loadBytes(File file, byte[] array) throws IOException {
        return loadBytes(file, array, 0, array.length);
    }

    public static int loadBytes(CharSequence filename, byte[] array) throws IOException {
        return loadBytes(new File(filename.toString()), array);
    }

    public static byte[] loadBytes(File file) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size();
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        byte[] array = new byte[(int) length];
        if (((long) loadBytes(channel, array)) >= length) {
            return array;
        }
        throw new EOFException();
    }

    public static byte[] loadBytes(CharSequence filename) throws IOException {
        return loadBytes(new File(filename.toString()));
    }

    public static void storeBytes(byte[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        write(dataOutput, array, offset, length);
    }

    public static void storeBytes(byte[] array, DataOutput dataOutput) throws IOException {
        write(dataOutput, array, 0, array.length);
    }

    public static void storeBytes(byte[] array, int offset, int length, File file) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeBytes(array, offset, length, channel);
        channel.close();
    }

    public static void storeBytes(byte[] array, int offset, int length, CharSequence filename) throws IOException {
        storeBytes(array, offset, length, new File(filename.toString()));
    }

    public static void storeBytes(byte[] array, File file) throws IOException {
        storeBytes(array, 0, array.length, file);
    }

    public static void storeBytes(byte[] array, CharSequence filename) throws IOException {
        storeBytes(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadBytes(DataInput dataInput, byte[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                byte[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readByte();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadBytes(DataInput dataInput, byte[][] array) throws IOException {
        char c = 0;
        for (byte[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readByte();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadBytes(File file, byte[][] array, long offset, long length) throws IOException {
        return loadBytes(FileChannel.open(file.toPath(), new OpenOption[0]), array, offset, length);
    }

    public static long loadBytes(CharSequence filename, byte[][] array, long offset, long length) throws IOException {
        return loadBytes(new File(filename.toString()), array, offset, length);
    }

    public static long loadBytes(File file, byte[][] array) throws IOException {
        return loadBytes(FileChannel.open(file.toPath(), new OpenOption[0]), array);
    }

    public static long loadBytes(CharSequence filename, byte[][] array) throws IOException {
        return loadBytes(new File(filename.toString()), array);
    }

    public static byte[][] loadBytesBig(File file) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        byte[][] array = ByteBigArrays.newBigArray(channel.size());
        loadBytes(channel, array);
        channel.close();
        return array;
    }

    public static byte[][] loadBytesBig(CharSequence filename) throws IOException {
        return loadBytesBig(new File(filename.toString()));
    }

    public static void storeBytes(byte[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        write(dataOutput, array, offset, length);
    }

    public static void storeBytes(byte[][] array, DataOutput dataOutput) throws IOException {
        write(dataOutput, array, 0, BigArrays.length(array));
    }

    public static void storeBytes(byte[][] array, long offset, long length, File file) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeBytes(array, offset, length, channel);
        channel.close();
    }

    public static void storeBytes(byte[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeBytes(array, offset, length, new File(filename.toString()));
    }

    public static void storeBytes(byte[][] array, File file) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeBytes(array, channel);
        channel.close();
    }

    public static void storeBytes(byte[][] array, CharSequence filename) throws IOException {
        storeBytes(array, new File(filename.toString()));
    }

    public static void storeBytes(ByteIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeByte(i.nextByte());
        }
    }

    public static void storeBytes(ByteIterator i, File file) throws IOException {
        DataOutputStream dos = new DataOutputStream(new FastBufferedOutputStream(new FileOutputStream(file)));
        while (i.hasNext()) {
            dos.writeByte(i.nextByte());
        }
        dos.close();
    }

    public static void storeBytes(ByteIterator i, CharSequence filename) throws IOException {
        storeBytes(i, new File(filename.toString()));
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$ByteDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$ByteDataInputWrapper.class */
    public static final class ByteDataInputWrapper implements ByteIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private byte next;

        public ByteDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readByte();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.bytes.ByteIterator
        public byte nextByte() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static ByteIterator asByteIterator(DataInput dataInput) {
        return new ByteDataInputWrapper(dataInput);
    }

    public static ByteIterator asByteIterator(File file) throws IOException {
        return new ByteDataInputWrapper(new DataInputStream(new FastBufferedInputStream(new FileInputStream(file))));
    }

    public static ByteIterator asByteIterator(CharSequence filename) throws IOException {
        return asByteIterator(new File(filename.toString()));
    }

    public static ByteIterable asByteIterable(File file) {
        return () -> {
            try {
                return asByteIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static ByteIterable asByteIterable(CharSequence filename) {
        return () -> {
            try {
                return asByteIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadChars(ReadableByteChannel channel, ByteOrder byteOrder, char[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        CharBuffer buffer = byteBuffer.asCharBuffer();
        int read = 0;
        while (true) {
            byteBuffer.clear();
            byteBuffer.limit(Math.min(buffer.capacity(), length << CharMappedBigList.LOG2_BYTES));
            int r = channel.read(byteBuffer);
            if (r <= 0) {
                return read;
            }
            int r2 = r >>> CharMappedBigList.LOG2_BYTES;
            read += r2;
            buffer.clear();
            buffer.limit(r2);
            buffer.get(array, offset, r2);
            offset += r2;
            length -= r2;
        }
    }

    public static int loadChars(ReadableByteChannel channel, ByteOrder byteOrder, char[] array) throws IOException {
        return loadChars(channel, byteOrder, array, 0, array.length);
    }

    public static int loadChars(File file, ByteOrder byteOrder, char[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int read = loadChars(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static int loadChars(CharSequence filename, ByteOrder byteOrder, char[] array, int offset, int length) throws IOException {
        return loadChars(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static int loadChars(File file, ByteOrder byteOrder, char[] array) throws IOException {
        return loadChars(file, byteOrder, array, 0, array.length);
    }

    public static int loadChars(CharSequence filename, ByteOrder byteOrder, char[] array) throws IOException {
        return loadChars(new File(filename.toString()), byteOrder, array);
    }

    public static char[] loadChars(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size() / 2;
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        char[] array = new char[(int) length];
        if (((long) loadChars(channel, byteOrder, array)) < length) {
            throw new EOFException();
        }
        channel.close();
        return array;
    }

    public static char[] loadChars(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadChars(new File(filename.toString()), byteOrder);
    }

    public static void storeChars(char[] array, int offset, int length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        CharBuffer buffer = byteBuffer.asCharBuffer();
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            byteBuffer.clear();
            byteBuffer.limit(buffer.limit() << CharMappedBigList.LOG2_BYTES);
            channel.write(byteBuffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeChars(char[] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        storeChars(array, 0, array.length, channel, byteOrder);
    }

    public static void storeChars(char[] array, int offset, int length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeChars(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeChars(char[] array, int offset, int length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeChars(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeChars(char[] array, File file, ByteOrder byteOrder) throws IOException {
        storeChars(array, 0, array.length, file, byteOrder);
    }

    public static void storeChars(char[] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeChars(array, new File(filename.toString()), byteOrder);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadChars(ReadableByteChannel channel, ByteOrder byteOrder, char[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            char[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadChars(channel, byteOrder, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadChars(ReadableByteChannel channel, ByteOrder byteOrder, char[][] array) throws IOException {
        return loadChars(channel, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadChars(File file, ByteOrder byteOrder, char[][] array, long offset, long length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long read = loadChars(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static long loadChars(CharSequence filename, ByteOrder byteOrder, char[][] array, long offset, long length) throws IOException {
        return loadChars(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static long loadChars(File file, ByteOrder byteOrder, char[][] array) throws IOException {
        return loadChars(file, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadChars(CharSequence filename, ByteOrder byteOrder, char[][] array) throws IOException {
        return loadChars(new File(filename.toString()), byteOrder, array);
    }

    public static char[][] loadCharsBig(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        char[][] array = CharBigArrays.newBigArray(channel.size() / 2);
        for (char[] t : array) {
            loadChars(channel, byteOrder, t);
        }
        channel.close();
        return array;
    }

    public static char[][] loadCharsBig(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadCharsBig(new File(filename.toString()), byteOrder);
    }

    public static void storeChars(char[][] array, long offset, long length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeChars(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel, byteOrder);
        }
    }

    public static void storeChars(char[][] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (char[] t : array) {
            storeChars(t, channel, byteOrder);
        }
    }

    public static void storeChars(char[][] array, long offset, long length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeChars(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeChars(char[][] array, long offset, long length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeChars(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeChars(char[][] array, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeChars(array, channel, byteOrder);
        channel.close();
    }

    public static void storeChars(char[][] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeChars(array, new File(filename.toString()), byteOrder);
    }

    public static void storeChars(CharIterator i, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        CharBuffer buffer = byteBuffer.asCharBuffer();
        while (i.hasNext()) {
            if (!buffer.hasRemaining()) {
                buffer.flip();
                byteBuffer.clear();
                byteBuffer.limit(buffer.limit() << CharMappedBigList.LOG2_BYTES);
                channel.write(byteBuffer);
                buffer.clear();
            }
            buffer.put(i.nextChar());
        }
        buffer.flip();
        byteBuffer.clear();
        byteBuffer.limit(buffer.limit() << CharMappedBigList.LOG2_BYTES);
        channel.write(byteBuffer);
    }

    public static void storeChars(CharIterator i, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeChars(i, channel, byteOrder);
        channel.close();
    }

    public static void storeChars(CharIterator i, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeChars(i, new File(filename.toString()), byteOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$CharDataNioInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$CharDataNioInputWrapper.class */
    public static final class CharDataNioInputWrapper implements CharIterator {
        private final ReadableByteChannel channel;
        private final ByteBuffer byteBuffer;
        private final CharBuffer buffer;

        public CharDataNioInputWrapper(ReadableByteChannel channel, ByteOrder byteOrder) {
            this.channel = channel;
            this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
            this.buffer = this.byteBuffer.asCharBuffer();
            this.buffer.clear().flip();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.buffer.hasRemaining()) {
                this.byteBuffer.clear();
                try {
                    this.channel.read(this.byteBuffer);
                    this.byteBuffer.flip();
                    this.buffer.clear();
                    this.buffer.limit(this.byteBuffer.limit() >>> CharMappedBigList.LOG2_BYTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.buffer.hasRemaining();
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (hasNext()) {
                return this.buffer.get();
            }
            throw new NoSuchElementException();
        }
    }

    public static CharIterator asCharIterator(ReadableByteChannel channel, ByteOrder byteOrder) {
        return new CharDataNioInputWrapper(channel, byteOrder);
    }

    public static CharIterator asCharIterator(File file, ByteOrder byteOrder) throws IOException {
        return new CharDataNioInputWrapper(FileChannel.open(file.toPath(), new OpenOption[0]), byteOrder);
    }

    public static CharIterator asCharIterator(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return asCharIterator(new File(filename.toString()), byteOrder);
    }

    public static CharIterable asCharIterable(File file, ByteOrder byteOrder) {
        return () -> {
            try {
                return asCharIterator(file, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static CharIterable asCharIterable(CharSequence filename, ByteOrder byteOrder) {
        return () -> {
            try {
                return asCharIterator(filename, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadChars(DataInput dataInput, char[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readChar();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadChars(DataInput dataInput, char[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readChar();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadChars(File file, char[] array, int offset, int length) throws IOException {
        return loadChars(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static int loadChars(CharSequence filename, char[] array, int offset, int length) throws IOException {
        return loadChars(new File(filename.toString()), array, offset, length);
    }

    public static int loadChars(File file, char[] array) throws IOException {
        return loadChars(file, array, 0, array.length);
    }

    public static int loadChars(CharSequence filename, char[] array) throws IOException {
        return loadChars(new File(filename.toString()), array);
    }

    public static char[] loadChars(File file) throws IOException {
        return loadChars(file, ByteOrder.BIG_ENDIAN);
    }

    public static char[] loadChars(CharSequence filename) throws IOException {
        return loadChars(new File(filename.toString()));
    }

    public static void storeChars(char[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeChar(array[offset + i]);
        }
    }

    public static void storeChars(char[] array, DataOutput dataOutput) throws IOException {
        for (char c : array) {
            dataOutput.writeChar(c);
        }
    }

    public static void storeChars(char[] array, int offset, int length, File file) throws IOException {
        storeChars(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeChars(char[] array, int offset, int length, CharSequence filename) throws IOException {
        storeChars(array, offset, length, new File(filename.toString()));
    }

    public static void storeChars(char[] array, File file) throws IOException {
        storeChars(array, 0, array.length, file);
    }

    public static void storeChars(char[] array, CharSequence filename) throws IOException {
        storeChars(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadChars(DataInput dataInput, char[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                char[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readChar();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadChars(DataInput dataInput, char[][] array) throws IOException {
        char c = 0;
        for (char[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readChar();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadChars(File file, char[][] array, long offset, long length) throws IOException {
        return loadChars(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static long loadChars(CharSequence filename, char[][] array, long offset, long length) throws IOException {
        return loadChars(new File(filename.toString()), array, offset, length);
    }

    public static long loadChars(File file, char[][] array) throws IOException {
        return loadChars(file, ByteOrder.BIG_ENDIAN, array);
    }

    public static long loadChars(CharSequence filename, char[][] array) throws IOException {
        return loadChars(new File(filename.toString()), array);
    }

    public static char[][] loadCharsBig(File file) throws IOException {
        return loadCharsBig(file, ByteOrder.BIG_ENDIAN);
    }

    public static char[][] loadCharsBig(CharSequence filename) throws IOException {
        return loadCharsBig(new File(filename.toString()));
    }

    public static void storeChars(char[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            char[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeChar(t[d]);
            }
        }
    }

    public static void storeChars(char[][] array, DataOutput dataOutput) throws IOException {
        for (char[] t : array) {
            for (char c : t) {
                dataOutput.writeChar(c);
            }
        }
    }

    public static void storeChars(char[][] array, long offset, long length, File file) throws IOException {
        storeChars(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeChars(char[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeChars(array, offset, length, new File(filename.toString()));
    }

    public static void storeChars(char[][] array, File file) throws IOException {
        storeChars(array, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeChars(char[][] array, CharSequence filename) throws IOException {
        storeChars(array, new File(filename.toString()));
    }

    public static void storeChars(CharIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeChar(i.nextChar());
        }
    }

    public static void storeChars(CharIterator i, File file) throws IOException {
        storeChars(i, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeChars(CharIterator i, CharSequence filename) throws IOException {
        storeChars(i, new File(filename.toString()));
    }

    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$CharDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$CharDataInputWrapper.class */
    private static final class CharDataInputWrapper implements CharIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private char next;

        public CharDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readChar();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.chars.CharIterator
        public char nextChar() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static CharIterator asCharIterator(DataInput dataInput) {
        return new CharDataInputWrapper(dataInput);
    }

    public static CharIterator asCharIterator(File file) throws IOException {
        return asCharIterator(file, ByteOrder.BIG_ENDIAN);
    }

    public static CharIterator asCharIterator(CharSequence filename) throws IOException {
        return asCharIterator(new File(filename.toString()));
    }

    public static CharIterable asCharIterable(File file) {
        return () -> {
            try {
                return asCharIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static CharIterable asCharIterable(CharSequence filename) {
        return () -> {
            try {
                return asCharIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadShorts(ReadableByteChannel channel, ByteOrder byteOrder, short[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        ShortBuffer buffer = byteBuffer.asShortBuffer();
        int read = 0;
        while (true) {
            byteBuffer.clear();
            byteBuffer.limit(Math.min(buffer.capacity(), length << ShortMappedBigList.LOG2_BYTES));
            int r = channel.read(byteBuffer);
            if (r <= 0) {
                return read;
            }
            int r2 = r >>> ShortMappedBigList.LOG2_BYTES;
            read += r2;
            buffer.clear();
            buffer.limit(r2);
            buffer.get(array, offset, r2);
            offset += r2;
            length -= r2;
        }
    }

    public static int loadShorts(ReadableByteChannel channel, ByteOrder byteOrder, short[] array) throws IOException {
        return loadShorts(channel, byteOrder, array, 0, array.length);
    }

    public static int loadShorts(File file, ByteOrder byteOrder, short[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int read = loadShorts(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static int loadShorts(CharSequence filename, ByteOrder byteOrder, short[] array, int offset, int length) throws IOException {
        return loadShorts(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static int loadShorts(File file, ByteOrder byteOrder, short[] array) throws IOException {
        return loadShorts(file, byteOrder, array, 0, array.length);
    }

    public static int loadShorts(CharSequence filename, ByteOrder byteOrder, short[] array) throws IOException {
        return loadShorts(new File(filename.toString()), byteOrder, array);
    }

    public static short[] loadShorts(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size() / 2;
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        short[] array = new short[(int) length];
        if (((long) loadShorts(channel, byteOrder, array)) < length) {
            throw new EOFException();
        }
        channel.close();
        return array;
    }

    public static short[] loadShorts(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadShorts(new File(filename.toString()), byteOrder);
    }

    public static void storeShorts(short[] array, int offset, int length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        ShortBuffer buffer = byteBuffer.asShortBuffer();
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            byteBuffer.clear();
            byteBuffer.limit(buffer.limit() << ShortMappedBigList.LOG2_BYTES);
            channel.write(byteBuffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeShorts(short[] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        storeShorts(array, 0, array.length, channel, byteOrder);
    }

    public static void storeShorts(short[] array, int offset, int length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeShorts(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeShorts(short[] array, int offset, int length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeShorts(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeShorts(short[] array, File file, ByteOrder byteOrder) throws IOException {
        storeShorts(array, 0, array.length, file, byteOrder);
    }

    public static void storeShorts(short[] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeShorts(array, new File(filename.toString()), byteOrder);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadShorts(ReadableByteChannel channel, ByteOrder byteOrder, short[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            short[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadShorts(channel, byteOrder, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadShorts(ReadableByteChannel channel, ByteOrder byteOrder, short[][] array) throws IOException {
        return loadShorts(channel, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadShorts(File file, ByteOrder byteOrder, short[][] array, long offset, long length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long read = loadShorts(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static long loadShorts(CharSequence filename, ByteOrder byteOrder, short[][] array, long offset, long length) throws IOException {
        return loadShorts(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static long loadShorts(File file, ByteOrder byteOrder, short[][] array) throws IOException {
        return loadShorts(file, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadShorts(CharSequence filename, ByteOrder byteOrder, short[][] array) throws IOException {
        return loadShorts(new File(filename.toString()), byteOrder, array);
    }

    public static short[][] loadShortsBig(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        short[][] array = ShortBigArrays.newBigArray(channel.size() / 2);
        for (short[] t : array) {
            loadShorts(channel, byteOrder, t);
        }
        channel.close();
        return array;
    }

    public static short[][] loadShortsBig(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadShortsBig(new File(filename.toString()), byteOrder);
    }

    public static void storeShorts(short[][] array, long offset, long length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeShorts(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel, byteOrder);
        }
    }

    public static void storeShorts(short[][] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (short[] t : array) {
            storeShorts(t, channel, byteOrder);
        }
    }

    public static void storeShorts(short[][] array, long offset, long length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeShorts(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeShorts(short[][] array, long offset, long length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeShorts(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeShorts(short[][] array, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeShorts(array, channel, byteOrder);
        channel.close();
    }

    public static void storeShorts(short[][] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeShorts(array, new File(filename.toString()), byteOrder);
    }

    public static void storeShorts(ShortIterator i, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        ShortBuffer buffer = byteBuffer.asShortBuffer();
        while (i.hasNext()) {
            if (!buffer.hasRemaining()) {
                buffer.flip();
                byteBuffer.clear();
                byteBuffer.limit(buffer.limit() << ShortMappedBigList.LOG2_BYTES);
                channel.write(byteBuffer);
                buffer.clear();
            }
            buffer.put(i.nextShort());
        }
        buffer.flip();
        byteBuffer.clear();
        byteBuffer.limit(buffer.limit() << ShortMappedBigList.LOG2_BYTES);
        channel.write(byteBuffer);
    }

    public static void storeShorts(ShortIterator i, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeShorts(i, channel, byteOrder);
        channel.close();
    }

    public static void storeShorts(ShortIterator i, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeShorts(i, new File(filename.toString()), byteOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$ShortDataNioInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$ShortDataNioInputWrapper.class */
    public static final class ShortDataNioInputWrapper implements ShortIterator {
        private final ReadableByteChannel channel;
        private final ByteBuffer byteBuffer;
        private final ShortBuffer buffer;

        public ShortDataNioInputWrapper(ReadableByteChannel channel, ByteOrder byteOrder) {
            this.channel = channel;
            this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
            this.buffer = this.byteBuffer.asShortBuffer();
            this.buffer.clear().flip();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.buffer.hasRemaining()) {
                this.byteBuffer.clear();
                try {
                    this.channel.read(this.byteBuffer);
                    this.byteBuffer.flip();
                    this.buffer.clear();
                    this.buffer.limit(this.byteBuffer.limit() >>> ShortMappedBigList.LOG2_BYTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.buffer.hasRemaining();
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (hasNext()) {
                return this.buffer.get();
            }
            throw new NoSuchElementException();
        }
    }

    public static ShortIterator asShortIterator(ReadableByteChannel channel, ByteOrder byteOrder) {
        return new ShortDataNioInputWrapper(channel, byteOrder);
    }

    public static ShortIterator asShortIterator(File file, ByteOrder byteOrder) throws IOException {
        return new ShortDataNioInputWrapper(FileChannel.open(file.toPath(), new OpenOption[0]), byteOrder);
    }

    public static ShortIterator asShortIterator(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return asShortIterator(new File(filename.toString()), byteOrder);
    }

    public static ShortIterable asShortIterable(File file, ByteOrder byteOrder) {
        return () -> {
            try {
                return asShortIterator(file, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static ShortIterable asShortIterable(CharSequence filename, ByteOrder byteOrder) {
        return () -> {
            try {
                return asShortIterator(filename, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadShorts(DataInput dataInput, short[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readShort();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadShorts(DataInput dataInput, short[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readShort();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadShorts(File file, short[] array, int offset, int length) throws IOException {
        return loadShorts(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static int loadShorts(CharSequence filename, short[] array, int offset, int length) throws IOException {
        return loadShorts(new File(filename.toString()), array, offset, length);
    }

    public static int loadShorts(File file, short[] array) throws IOException {
        return loadShorts(file, array, 0, array.length);
    }

    public static int loadShorts(CharSequence filename, short[] array) throws IOException {
        return loadShorts(new File(filename.toString()), array);
    }

    public static short[] loadShorts(File file) throws IOException {
        return loadShorts(file, ByteOrder.BIG_ENDIAN);
    }

    public static short[] loadShorts(CharSequence filename) throws IOException {
        return loadShorts(new File(filename.toString()));
    }

    public static void storeShorts(short[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeShort(array[offset + i]);
        }
    }

    public static void storeShorts(short[] array, DataOutput dataOutput) throws IOException {
        for (short s : array) {
            dataOutput.writeShort(s);
        }
    }

    public static void storeShorts(short[] array, int offset, int length, File file) throws IOException {
        storeShorts(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeShorts(short[] array, int offset, int length, CharSequence filename) throws IOException {
        storeShorts(array, offset, length, new File(filename.toString()));
    }

    public static void storeShorts(short[] array, File file) throws IOException {
        storeShorts(array, 0, array.length, file);
    }

    public static void storeShorts(short[] array, CharSequence filename) throws IOException {
        storeShorts(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadShorts(DataInput dataInput, short[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                short[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readShort();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadShorts(DataInput dataInput, short[][] array) throws IOException {
        char c = 0;
        for (short[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readShort();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadShorts(File file, short[][] array, long offset, long length) throws IOException {
        return loadShorts(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static long loadShorts(CharSequence filename, short[][] array, long offset, long length) throws IOException {
        return loadShorts(new File(filename.toString()), array, offset, length);
    }

    public static long loadShorts(File file, short[][] array) throws IOException {
        return loadShorts(file, ByteOrder.BIG_ENDIAN, array);
    }

    public static long loadShorts(CharSequence filename, short[][] array) throws IOException {
        return loadShorts(new File(filename.toString()), array);
    }

    public static short[][] loadShortsBig(File file) throws IOException {
        return loadShortsBig(file, ByteOrder.BIG_ENDIAN);
    }

    public static short[][] loadShortsBig(CharSequence filename) throws IOException {
        return loadShortsBig(new File(filename.toString()));
    }

    public static void storeShorts(short[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            short[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeShort(t[d]);
            }
        }
    }

    public static void storeShorts(short[][] array, DataOutput dataOutput) throws IOException {
        for (short[] t : array) {
            for (short s : t) {
                dataOutput.writeShort(s);
            }
        }
    }

    public static void storeShorts(short[][] array, long offset, long length, File file) throws IOException {
        storeShorts(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeShorts(short[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeShorts(array, offset, length, new File(filename.toString()));
    }

    public static void storeShorts(short[][] array, File file) throws IOException {
        storeShorts(array, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeShorts(short[][] array, CharSequence filename) throws IOException {
        storeShorts(array, new File(filename.toString()));
    }

    public static void storeShorts(ShortIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeShort(i.nextShort());
        }
    }

    public static void storeShorts(ShortIterator i, File file) throws IOException {
        storeShorts(i, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeShorts(ShortIterator i, CharSequence filename) throws IOException {
        storeShorts(i, new File(filename.toString()));
    }

    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$ShortDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$ShortDataInputWrapper.class */
    private static final class ShortDataInputWrapper implements ShortIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private short next;

        public ShortDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readShort();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.shorts.ShortIterator
        public short nextShort() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static ShortIterator asShortIterator(DataInput dataInput) {
        return new ShortDataInputWrapper(dataInput);
    }

    public static ShortIterator asShortIterator(File file) throws IOException {
        return asShortIterator(file, ByteOrder.BIG_ENDIAN);
    }

    public static ShortIterator asShortIterator(CharSequence filename) throws IOException {
        return asShortIterator(new File(filename.toString()));
    }

    public static ShortIterable asShortIterable(File file) {
        return () -> {
            try {
                return asShortIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static ShortIterable asShortIterable(CharSequence filename) {
        return () -> {
            try {
                return asShortIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadInts(ReadableByteChannel channel, ByteOrder byteOrder, int[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        IntBuffer buffer = byteBuffer.asIntBuffer();
        int read = 0;
        while (true) {
            byteBuffer.clear();
            byteBuffer.limit(Math.min(buffer.capacity(), length << IntMappedBigList.LOG2_BYTES));
            int r = channel.read(byteBuffer);
            if (r <= 0) {
                return read;
            }
            int r2 = r >>> IntMappedBigList.LOG2_BYTES;
            read += r2;
            buffer.clear();
            buffer.limit(r2);
            buffer.get(array, offset, r2);
            offset += r2;
            length -= r2;
        }
    }

    public static int loadInts(ReadableByteChannel channel, ByteOrder byteOrder, int[] array) throws IOException {
        return loadInts(channel, byteOrder, array, 0, array.length);
    }

    public static int loadInts(File file, ByteOrder byteOrder, int[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int read = loadInts(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static int loadInts(CharSequence filename, ByteOrder byteOrder, int[] array, int offset, int length) throws IOException {
        return loadInts(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static int loadInts(File file, ByteOrder byteOrder, int[] array) throws IOException {
        return loadInts(file, byteOrder, array, 0, array.length);
    }

    public static int loadInts(CharSequence filename, ByteOrder byteOrder, int[] array) throws IOException {
        return loadInts(new File(filename.toString()), byteOrder, array);
    }

    public static int[] loadInts(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size() / 4;
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        int[] array = new int[(int) length];
        if (((long) loadInts(channel, byteOrder, array)) < length) {
            throw new EOFException();
        }
        channel.close();
        return array;
    }

    public static int[] loadInts(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadInts(new File(filename.toString()), byteOrder);
    }

    public static void storeInts(int[] array, int offset, int length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        IntBuffer buffer = byteBuffer.asIntBuffer();
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            byteBuffer.clear();
            byteBuffer.limit(buffer.limit() << IntMappedBigList.LOG2_BYTES);
            channel.write(byteBuffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeInts(int[] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        storeInts(array, 0, array.length, channel, byteOrder);
    }

    public static void storeInts(int[] array, int offset, int length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeInts(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeInts(int[] array, int offset, int length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeInts(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeInts(int[] array, File file, ByteOrder byteOrder) throws IOException {
        storeInts(array, 0, array.length, file, byteOrder);
    }

    public static void storeInts(int[] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeInts(array, new File(filename.toString()), byteOrder);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadInts(ReadableByteChannel channel, ByteOrder byteOrder, int[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadInts(channel, byteOrder, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadInts(ReadableByteChannel channel, ByteOrder byteOrder, int[][] array) throws IOException {
        return loadInts(channel, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadInts(File file, ByteOrder byteOrder, int[][] array, long offset, long length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long read = loadInts(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static long loadInts(CharSequence filename, ByteOrder byteOrder, int[][] array, long offset, long length) throws IOException {
        return loadInts(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static long loadInts(File file, ByteOrder byteOrder, int[][] array) throws IOException {
        return loadInts(file, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadInts(CharSequence filename, ByteOrder byteOrder, int[][] array) throws IOException {
        return loadInts(new File(filename.toString()), byteOrder, array);
    }

    public static int[][] loadIntsBig(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int[][] array = IntBigArrays.newBigArray(channel.size() / 4);
        for (int[] t : array) {
            loadInts(channel, byteOrder, t);
        }
        channel.close();
        return array;
    }

    public static int[][] loadIntsBig(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadIntsBig(new File(filename.toString()), byteOrder);
    }

    public static void storeInts(int[][] array, long offset, long length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeInts(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel, byteOrder);
        }
    }

    public static void storeInts(int[][] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int[] t : array) {
            storeInts(t, channel, byteOrder);
        }
    }

    public static void storeInts(int[][] array, long offset, long length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeInts(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeInts(int[][] array, long offset, long length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeInts(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeInts(int[][] array, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeInts(array, channel, byteOrder);
        channel.close();
    }

    public static void storeInts(int[][] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeInts(array, new File(filename.toString()), byteOrder);
    }

    public static void storeInts(IntIterator i, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        IntBuffer buffer = byteBuffer.asIntBuffer();
        while (i.hasNext()) {
            if (!buffer.hasRemaining()) {
                buffer.flip();
                byteBuffer.clear();
                byteBuffer.limit(buffer.limit() << IntMappedBigList.LOG2_BYTES);
                channel.write(byteBuffer);
                buffer.clear();
            }
            buffer.put(i.nextInt());
        }
        buffer.flip();
        byteBuffer.clear();
        byteBuffer.limit(buffer.limit() << IntMappedBigList.LOG2_BYTES);
        channel.write(byteBuffer);
    }

    public static void storeInts(IntIterator i, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeInts(i, channel, byteOrder);
        channel.close();
    }

    public static void storeInts(IntIterator i, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeInts(i, new File(filename.toString()), byteOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$IntDataNioInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$IntDataNioInputWrapper.class */
    public static final class IntDataNioInputWrapper implements IntIterator {
        private final ReadableByteChannel channel;
        private final ByteBuffer byteBuffer;
        private final IntBuffer buffer;

        public IntDataNioInputWrapper(ReadableByteChannel channel, ByteOrder byteOrder) {
            this.channel = channel;
            this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
            this.buffer = this.byteBuffer.asIntBuffer();
            this.buffer.clear().flip();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.buffer.hasRemaining()) {
                this.byteBuffer.clear();
                try {
                    this.channel.read(this.byteBuffer);
                    this.byteBuffer.flip();
                    this.buffer.clear();
                    this.buffer.limit(this.byteBuffer.limit() >>> IntMappedBigList.LOG2_BYTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.buffer.hasRemaining();
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (hasNext()) {
                return this.buffer.get();
            }
            throw new NoSuchElementException();
        }
    }

    public static IntIterator asIntIterator(ReadableByteChannel channel, ByteOrder byteOrder) {
        return new IntDataNioInputWrapper(channel, byteOrder);
    }

    public static IntIterator asIntIterator(File file, ByteOrder byteOrder) throws IOException {
        return new IntDataNioInputWrapper(FileChannel.open(file.toPath(), new OpenOption[0]), byteOrder);
    }

    public static IntIterator asIntIterator(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return asIntIterator(new File(filename.toString()), byteOrder);
    }

    public static IntIterable asIntIterable(File file, ByteOrder byteOrder) {
        return () -> {
            try {
                return asIntIterator(file, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static IntIterable asIntIterable(CharSequence filename, ByteOrder byteOrder) {
        return () -> {
            try {
                return asIntIterator(filename, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadInts(DataInput dataInput, int[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readInt();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadInts(DataInput dataInput, int[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readInt();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadInts(File file, int[] array, int offset, int length) throws IOException {
        return loadInts(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static int loadInts(CharSequence filename, int[] array, int offset, int length) throws IOException {
        return loadInts(new File(filename.toString()), array, offset, length);
    }

    public static int loadInts(File file, int[] array) throws IOException {
        return loadInts(file, array, 0, array.length);
    }

    public static int loadInts(CharSequence filename, int[] array) throws IOException {
        return loadInts(new File(filename.toString()), array);
    }

    public static int[] loadInts(File file) throws IOException {
        return loadInts(file, ByteOrder.BIG_ENDIAN);
    }

    public static int[] loadInts(CharSequence filename) throws IOException {
        return loadInts(new File(filename.toString()));
    }

    public static void storeInts(int[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeInt(array[offset + i]);
        }
    }

    public static void storeInts(int[] array, DataOutput dataOutput) throws IOException {
        for (int i : array) {
            dataOutput.writeInt(i);
        }
    }

    public static void storeInts(int[] array, int offset, int length, File file) throws IOException {
        storeInts(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeInts(int[] array, int offset, int length, CharSequence filename) throws IOException {
        storeInts(array, offset, length, new File(filename.toString()));
    }

    public static void storeInts(int[] array, File file) throws IOException {
        storeInts(array, 0, array.length, file);
    }

    public static void storeInts(int[] array, CharSequence filename) throws IOException {
        storeInts(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadInts(DataInput dataInput, int[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                int[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readInt();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadInts(DataInput dataInput, int[][] array) throws IOException {
        char c = 0;
        for (int[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readInt();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadInts(File file, int[][] array, long offset, long length) throws IOException {
        return loadInts(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static long loadInts(CharSequence filename, int[][] array, long offset, long length) throws IOException {
        return loadInts(new File(filename.toString()), array, offset, length);
    }

    public static long loadInts(File file, int[][] array) throws IOException {
        return loadInts(file, ByteOrder.BIG_ENDIAN, array);
    }

    public static long loadInts(CharSequence filename, int[][] array) throws IOException {
        return loadInts(new File(filename.toString()), array);
    }

    public static int[][] loadIntsBig(File file) throws IOException {
        return loadIntsBig(file, ByteOrder.BIG_ENDIAN);
    }

    public static int[][] loadIntsBig(CharSequence filename) throws IOException {
        return loadIntsBig(new File(filename.toString()));
    }

    public static void storeInts(int[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeInt(t[d]);
            }
        }
    }

    public static void storeInts(int[][] array, DataOutput dataOutput) throws IOException {
        for (int[] t : array) {
            for (int i : t) {
                dataOutput.writeInt(i);
            }
        }
    }

    public static void storeInts(int[][] array, long offset, long length, File file) throws IOException {
        storeInts(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeInts(int[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeInts(array, offset, length, new File(filename.toString()));
    }

    public static void storeInts(int[][] array, File file) throws IOException {
        storeInts(array, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeInts(int[][] array, CharSequence filename) throws IOException {
        storeInts(array, new File(filename.toString()));
    }

    public static void storeInts(IntIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeInt(i.nextInt());
        }
    }

    public static void storeInts(IntIterator i, File file) throws IOException {
        storeInts(i, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeInts(IntIterator i, CharSequence filename) throws IOException {
        storeInts(i, new File(filename.toString()));
    }

    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$IntDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$IntDataInputWrapper.class */
    private static final class IntDataInputWrapper implements IntIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private int next;

        public IntDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readInt();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.ints.IntIterator, java.util.PrimitiveIterator.OfInt
        public int nextInt() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static IntIterator asIntIterator(DataInput dataInput) {
        return new IntDataInputWrapper(dataInput);
    }

    public static IntIterator asIntIterator(File file) throws IOException {
        return asIntIterator(file, ByteOrder.BIG_ENDIAN);
    }

    public static IntIterator asIntIterator(CharSequence filename) throws IOException {
        return asIntIterator(new File(filename.toString()));
    }

    public static IntIterable asIntIterable(File file) {
        return () -> {
            try {
                return asIntIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static IntIterable asIntIterable(CharSequence filename) {
        return () -> {
            try {
                return asIntIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadFloats(ReadableByteChannel channel, ByteOrder byteOrder, float[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        FloatBuffer buffer = byteBuffer.asFloatBuffer();
        int read = 0;
        while (true) {
            byteBuffer.clear();
            byteBuffer.limit(Math.min(buffer.capacity(), length << FloatMappedBigList.LOG2_BYTES));
            int r = channel.read(byteBuffer);
            if (r <= 0) {
                return read;
            }
            int r2 = r >>> FloatMappedBigList.LOG2_BYTES;
            read += r2;
            buffer.clear();
            buffer.limit(r2);
            buffer.get(array, offset, r2);
            offset += r2;
            length -= r2;
        }
    }

    public static int loadFloats(ReadableByteChannel channel, ByteOrder byteOrder, float[] array) throws IOException {
        return loadFloats(channel, byteOrder, array, 0, array.length);
    }

    public static int loadFloats(File file, ByteOrder byteOrder, float[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int read = loadFloats(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static int loadFloats(CharSequence filename, ByteOrder byteOrder, float[] array, int offset, int length) throws IOException {
        return loadFloats(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static int loadFloats(File file, ByteOrder byteOrder, float[] array) throws IOException {
        return loadFloats(file, byteOrder, array, 0, array.length);
    }

    public static int loadFloats(CharSequence filename, ByteOrder byteOrder, float[] array) throws IOException {
        return loadFloats(new File(filename.toString()), byteOrder, array);
    }

    public static float[] loadFloats(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size() / 4;
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        float[] array = new float[(int) length];
        if (((long) loadFloats(channel, byteOrder, array)) < length) {
            throw new EOFException();
        }
        channel.close();
        return array;
    }

    public static float[] loadFloats(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadFloats(new File(filename.toString()), byteOrder);
    }

    public static void storeFloats(float[] array, int offset, int length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        FloatBuffer buffer = byteBuffer.asFloatBuffer();
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            byteBuffer.clear();
            byteBuffer.limit(buffer.limit() << FloatMappedBigList.LOG2_BYTES);
            channel.write(byteBuffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeFloats(float[] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        storeFloats(array, 0, array.length, channel, byteOrder);
    }

    public static void storeFloats(float[] array, int offset, int length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeFloats(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeFloats(float[] array, int offset, int length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeFloats(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeFloats(float[] array, File file, ByteOrder byteOrder) throws IOException {
        storeFloats(array, 0, array.length, file, byteOrder);
    }

    public static void storeFloats(float[] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeFloats(array, new File(filename.toString()), byteOrder);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadFloats(ReadableByteChannel channel, ByteOrder byteOrder, float[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            float[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadFloats(channel, byteOrder, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadFloats(ReadableByteChannel channel, ByteOrder byteOrder, float[][] array) throws IOException {
        return loadFloats(channel, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadFloats(File file, ByteOrder byteOrder, float[][] array, long offset, long length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long read = loadFloats(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static long loadFloats(CharSequence filename, ByteOrder byteOrder, float[][] array, long offset, long length) throws IOException {
        return loadFloats(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static long loadFloats(File file, ByteOrder byteOrder, float[][] array) throws IOException {
        return loadFloats(file, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadFloats(CharSequence filename, ByteOrder byteOrder, float[][] array) throws IOException {
        return loadFloats(new File(filename.toString()), byteOrder, array);
    }

    public static float[][] loadFloatsBig(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        float[][] array = FloatBigArrays.newBigArray(channel.size() / 4);
        for (float[] t : array) {
            loadFloats(channel, byteOrder, t);
        }
        channel.close();
        return array;
    }

    public static float[][] loadFloatsBig(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadFloatsBig(new File(filename.toString()), byteOrder);
    }

    public static void storeFloats(float[][] array, long offset, long length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeFloats(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel, byteOrder);
        }
    }

    public static void storeFloats(float[][] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (float[] t : array) {
            storeFloats(t, channel, byteOrder);
        }
    }

    public static void storeFloats(float[][] array, long offset, long length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeFloats(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeFloats(float[][] array, long offset, long length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeFloats(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeFloats(float[][] array, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeFloats(array, channel, byteOrder);
        channel.close();
    }

    public static void storeFloats(float[][] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeFloats(array, new File(filename.toString()), byteOrder);
    }

    public static void storeFloats(FloatIterator i, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        FloatBuffer buffer = byteBuffer.asFloatBuffer();
        while (i.hasNext()) {
            if (!buffer.hasRemaining()) {
                buffer.flip();
                byteBuffer.clear();
                byteBuffer.limit(buffer.limit() << FloatMappedBigList.LOG2_BYTES);
                channel.write(byteBuffer);
                buffer.clear();
            }
            buffer.put(i.nextFloat());
        }
        buffer.flip();
        byteBuffer.clear();
        byteBuffer.limit(buffer.limit() << FloatMappedBigList.LOG2_BYTES);
        channel.write(byteBuffer);
    }

    public static void storeFloats(FloatIterator i, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeFloats(i, channel, byteOrder);
        channel.close();
    }

    public static void storeFloats(FloatIterator i, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeFloats(i, new File(filename.toString()), byteOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$FloatDataNioInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$FloatDataNioInputWrapper.class */
    public static final class FloatDataNioInputWrapper implements FloatIterator {
        private final ReadableByteChannel channel;
        private final ByteBuffer byteBuffer;
        private final FloatBuffer buffer;

        public FloatDataNioInputWrapper(ReadableByteChannel channel, ByteOrder byteOrder) {
            this.channel = channel;
            this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
            this.buffer = this.byteBuffer.asFloatBuffer();
            this.buffer.clear().flip();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.buffer.hasRemaining()) {
                this.byteBuffer.clear();
                try {
                    this.channel.read(this.byteBuffer);
                    this.byteBuffer.flip();
                    this.buffer.clear();
                    this.buffer.limit(this.byteBuffer.limit() >>> FloatMappedBigList.LOG2_BYTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.buffer.hasRemaining();
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (hasNext()) {
                return this.buffer.get();
            }
            throw new NoSuchElementException();
        }
    }

    public static FloatIterator asFloatIterator(ReadableByteChannel channel, ByteOrder byteOrder) {
        return new FloatDataNioInputWrapper(channel, byteOrder);
    }

    public static FloatIterator asFloatIterator(File file, ByteOrder byteOrder) throws IOException {
        return new FloatDataNioInputWrapper(FileChannel.open(file.toPath(), new OpenOption[0]), byteOrder);
    }

    public static FloatIterator asFloatIterator(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return asFloatIterator(new File(filename.toString()), byteOrder);
    }

    public static FloatIterable asFloatIterable(File file, ByteOrder byteOrder) {
        return () -> {
            try {
                return asFloatIterator(file, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static FloatIterable asFloatIterable(CharSequence filename, ByteOrder byteOrder) {
        return () -> {
            try {
                return asFloatIterator(filename, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadFloats(DataInput dataInput, float[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readFloat();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadFloats(DataInput dataInput, float[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readFloat();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadFloats(File file, float[] array, int offset, int length) throws IOException {
        return loadFloats(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static int loadFloats(CharSequence filename, float[] array, int offset, int length) throws IOException {
        return loadFloats(new File(filename.toString()), array, offset, length);
    }

    public static int loadFloats(File file, float[] array) throws IOException {
        return loadFloats(file, array, 0, array.length);
    }

    public static int loadFloats(CharSequence filename, float[] array) throws IOException {
        return loadFloats(new File(filename.toString()), array);
    }

    public static float[] loadFloats(File file) throws IOException {
        return loadFloats(file, ByteOrder.BIG_ENDIAN);
    }

    public static float[] loadFloats(CharSequence filename) throws IOException {
        return loadFloats(new File(filename.toString()));
    }

    public static void storeFloats(float[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeFloat(array[offset + i]);
        }
    }

    public static void storeFloats(float[] array, DataOutput dataOutput) throws IOException {
        for (float f : array) {
            dataOutput.writeFloat(f);
        }
    }

    public static void storeFloats(float[] array, int offset, int length, File file) throws IOException {
        storeFloats(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeFloats(float[] array, int offset, int length, CharSequence filename) throws IOException {
        storeFloats(array, offset, length, new File(filename.toString()));
    }

    public static void storeFloats(float[] array, File file) throws IOException {
        storeFloats(array, 0, array.length, file);
    }

    public static void storeFloats(float[] array, CharSequence filename) throws IOException {
        storeFloats(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadFloats(DataInput dataInput, float[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                float[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readFloat();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadFloats(DataInput dataInput, float[][] array) throws IOException {
        char c = 0;
        for (float[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readFloat();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadFloats(File file, float[][] array, long offset, long length) throws IOException {
        return loadFloats(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static long loadFloats(CharSequence filename, float[][] array, long offset, long length) throws IOException {
        return loadFloats(new File(filename.toString()), array, offset, length);
    }

    public static long loadFloats(File file, float[][] array) throws IOException {
        return loadFloats(file, ByteOrder.BIG_ENDIAN, array);
    }

    public static long loadFloats(CharSequence filename, float[][] array) throws IOException {
        return loadFloats(new File(filename.toString()), array);
    }

    public static float[][] loadFloatsBig(File file) throws IOException {
        return loadFloatsBig(file, ByteOrder.BIG_ENDIAN);
    }

    public static float[][] loadFloatsBig(CharSequence filename) throws IOException {
        return loadFloatsBig(new File(filename.toString()));
    }

    public static void storeFloats(float[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            float[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeFloat(t[d]);
            }
        }
    }

    public static void storeFloats(float[][] array, DataOutput dataOutput) throws IOException {
        for (float[] t : array) {
            for (float f : t) {
                dataOutput.writeFloat(f);
            }
        }
    }

    public static void storeFloats(float[][] array, long offset, long length, File file) throws IOException {
        storeFloats(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeFloats(float[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeFloats(array, offset, length, new File(filename.toString()));
    }

    public static void storeFloats(float[][] array, File file) throws IOException {
        storeFloats(array, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeFloats(float[][] array, CharSequence filename) throws IOException {
        storeFloats(array, new File(filename.toString()));
    }

    public static void storeFloats(FloatIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeFloat(i.nextFloat());
        }
    }

    public static void storeFloats(FloatIterator i, File file) throws IOException {
        storeFloats(i, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeFloats(FloatIterator i, CharSequence filename) throws IOException {
        storeFloats(i, new File(filename.toString()));
    }

    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$FloatDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$FloatDataInputWrapper.class */
    private static final class FloatDataInputWrapper implements FloatIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private float next;

        public FloatDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readFloat();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.floats.FloatIterator
        public float nextFloat() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static FloatIterator asFloatIterator(DataInput dataInput) {
        return new FloatDataInputWrapper(dataInput);
    }

    public static FloatIterator asFloatIterator(File file) throws IOException {
        return asFloatIterator(file, ByteOrder.BIG_ENDIAN);
    }

    public static FloatIterator asFloatIterator(CharSequence filename) throws IOException {
        return asFloatIterator(new File(filename.toString()));
    }

    public static FloatIterable asFloatIterable(File file) {
        return () -> {
            try {
                return asFloatIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static FloatIterable asFloatIterable(CharSequence filename) {
        return () -> {
            try {
                return asFloatIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadLongs(ReadableByteChannel channel, ByteOrder byteOrder, long[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        LongBuffer buffer = byteBuffer.asLongBuffer();
        int read = 0;
        while (true) {
            byteBuffer.clear();
            byteBuffer.limit(Math.min(buffer.capacity(), length << LongMappedBigList.LOG2_BYTES));
            int r = channel.read(byteBuffer);
            if (r <= 0) {
                return read;
            }
            int r2 = r >>> LongMappedBigList.LOG2_BYTES;
            read += r2;
            buffer.clear();
            buffer.limit(r2);
            buffer.get(array, offset, r2);
            offset += r2;
            length -= r2;
        }
    }

    public static int loadLongs(ReadableByteChannel channel, ByteOrder byteOrder, long[] array) throws IOException {
        return loadLongs(channel, byteOrder, array, 0, array.length);
    }

    public static int loadLongs(File file, ByteOrder byteOrder, long[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int read = loadLongs(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static int loadLongs(CharSequence filename, ByteOrder byteOrder, long[] array, int offset, int length) throws IOException {
        return loadLongs(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static int loadLongs(File file, ByteOrder byteOrder, long[] array) throws IOException {
        return loadLongs(file, byteOrder, array, 0, array.length);
    }

    public static int loadLongs(CharSequence filename, ByteOrder byteOrder, long[] array) throws IOException {
        return loadLongs(new File(filename.toString()), byteOrder, array);
    }

    public static long[] loadLongs(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size() / 8;
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        long[] array = new long[(int) length];
        if (((long) loadLongs(channel, byteOrder, array)) < length) {
            throw new EOFException();
        }
        channel.close();
        return array;
    }

    public static long[] loadLongs(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadLongs(new File(filename.toString()), byteOrder);
    }

    public static void storeLongs(long[] array, int offset, int length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        LongBuffer buffer = byteBuffer.asLongBuffer();
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            byteBuffer.clear();
            byteBuffer.limit(buffer.limit() << LongMappedBigList.LOG2_BYTES);
            channel.write(byteBuffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeLongs(long[] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        storeLongs(array, 0, array.length, channel, byteOrder);
    }

    public static void storeLongs(long[] array, int offset, int length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeLongs(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeLongs(long[] array, int offset, int length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeLongs(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeLongs(long[] array, File file, ByteOrder byteOrder) throws IOException {
        storeLongs(array, 0, array.length, file, byteOrder);
    }

    public static void storeLongs(long[] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeLongs(array, new File(filename.toString()), byteOrder);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadLongs(ReadableByteChannel channel, ByteOrder byteOrder, long[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            long[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadLongs(channel, byteOrder, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadLongs(ReadableByteChannel channel, ByteOrder byteOrder, long[][] array) throws IOException {
        return loadLongs(channel, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadLongs(File file, ByteOrder byteOrder, long[][] array, long offset, long length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long read = loadLongs(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static long loadLongs(CharSequence filename, ByteOrder byteOrder, long[][] array, long offset, long length) throws IOException {
        return loadLongs(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static long loadLongs(File file, ByteOrder byteOrder, long[][] array) throws IOException {
        return loadLongs(file, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadLongs(CharSequence filename, ByteOrder byteOrder, long[][] array) throws IOException {
        return loadLongs(new File(filename.toString()), byteOrder, array);
    }

    public static long[][] loadLongsBig(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long[][] array = LongBigArrays.newBigArray(channel.size() / 8);
        for (long[] t : array) {
            loadLongs(channel, byteOrder, t);
        }
        channel.close();
        return array;
    }

    public static long[][] loadLongsBig(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadLongsBig(new File(filename.toString()), byteOrder);
    }

    public static void storeLongs(long[][] array, long offset, long length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeLongs(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel, byteOrder);
        }
    }

    public static void storeLongs(long[][] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (long[] t : array) {
            storeLongs(t, channel, byteOrder);
        }
    }

    public static void storeLongs(long[][] array, long offset, long length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeLongs(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeLongs(long[][] array, long offset, long length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeLongs(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeLongs(long[][] array, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeLongs(array, channel, byteOrder);
        channel.close();
    }

    public static void storeLongs(long[][] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeLongs(array, new File(filename.toString()), byteOrder);
    }

    public static void storeLongs(LongIterator i, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        LongBuffer buffer = byteBuffer.asLongBuffer();
        while (i.hasNext()) {
            if (!buffer.hasRemaining()) {
                buffer.flip();
                byteBuffer.clear();
                byteBuffer.limit(buffer.limit() << LongMappedBigList.LOG2_BYTES);
                channel.write(byteBuffer);
                buffer.clear();
            }
            buffer.put(i.nextLong());
        }
        buffer.flip();
        byteBuffer.clear();
        byteBuffer.limit(buffer.limit() << LongMappedBigList.LOG2_BYTES);
        channel.write(byteBuffer);
    }

    public static void storeLongs(LongIterator i, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeLongs(i, channel, byteOrder);
        channel.close();
    }

    public static void storeLongs(LongIterator i, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeLongs(i, new File(filename.toString()), byteOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$LongDataNioInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$LongDataNioInputWrapper.class */
    public static final class LongDataNioInputWrapper implements LongIterator {
        private final ReadableByteChannel channel;
        private final ByteBuffer byteBuffer;
        private final LongBuffer buffer;

        public LongDataNioInputWrapper(ReadableByteChannel channel, ByteOrder byteOrder) {
            this.channel = channel;
            this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
            this.buffer = this.byteBuffer.asLongBuffer();
            this.buffer.clear().flip();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.buffer.hasRemaining()) {
                this.byteBuffer.clear();
                try {
                    this.channel.read(this.byteBuffer);
                    this.byteBuffer.flip();
                    this.buffer.clear();
                    this.buffer.limit(this.byteBuffer.limit() >>> LongMappedBigList.LOG2_BYTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.buffer.hasRemaining();
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (hasNext()) {
                return this.buffer.get();
            }
            throw new NoSuchElementException();
        }
    }

    public static LongIterator asLongIterator(ReadableByteChannel channel, ByteOrder byteOrder) {
        return new LongDataNioInputWrapper(channel, byteOrder);
    }

    public static LongIterator asLongIterator(File file, ByteOrder byteOrder) throws IOException {
        return new LongDataNioInputWrapper(FileChannel.open(file.toPath(), new OpenOption[0]), byteOrder);
    }

    public static LongIterator asLongIterator(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return asLongIterator(new File(filename.toString()), byteOrder);
    }

    public static LongIterable asLongIterable(File file, ByteOrder byteOrder) {
        return () -> {
            try {
                return asLongIterator(file, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static LongIterable asLongIterable(CharSequence filename, ByteOrder byteOrder) {
        return () -> {
            try {
                return asLongIterator(filename, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadLongs(DataInput dataInput, long[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readLong();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadLongs(DataInput dataInput, long[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readLong();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadLongs(File file, long[] array, int offset, int length) throws IOException {
        return loadLongs(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static int loadLongs(CharSequence filename, long[] array, int offset, int length) throws IOException {
        return loadLongs(new File(filename.toString()), array, offset, length);
    }

    public static int loadLongs(File file, long[] array) throws IOException {
        return loadLongs(file, array, 0, array.length);
    }

    public static int loadLongs(CharSequence filename, long[] array) throws IOException {
        return loadLongs(new File(filename.toString()), array);
    }

    public static long[] loadLongs(File file) throws IOException {
        return loadLongs(file, ByteOrder.BIG_ENDIAN);
    }

    public static long[] loadLongs(CharSequence filename) throws IOException {
        return loadLongs(new File(filename.toString()));
    }

    public static void storeLongs(long[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeLong(array[offset + i]);
        }
    }

    public static void storeLongs(long[] array, DataOutput dataOutput) throws IOException {
        for (long j : array) {
            dataOutput.writeLong(j);
        }
    }

    public static void storeLongs(long[] array, int offset, int length, File file) throws IOException {
        storeLongs(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeLongs(long[] array, int offset, int length, CharSequence filename) throws IOException {
        storeLongs(array, offset, length, new File(filename.toString()));
    }

    public static void storeLongs(long[] array, File file) throws IOException {
        storeLongs(array, 0, array.length, file);
    }

    public static void storeLongs(long[] array, CharSequence filename) throws IOException {
        storeLongs(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadLongs(DataInput dataInput, long[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                long[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readLong();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadLongs(DataInput dataInput, long[][] array) throws IOException {
        char c = 0;
        for (long[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readLong();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadLongs(File file, long[][] array, long offset, long length) throws IOException {
        return loadLongs(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static long loadLongs(CharSequence filename, long[][] array, long offset, long length) throws IOException {
        return loadLongs(new File(filename.toString()), array, offset, length);
    }

    public static long loadLongs(File file, long[][] array) throws IOException {
        return loadLongs(file, ByteOrder.BIG_ENDIAN, array);
    }

    public static long loadLongs(CharSequence filename, long[][] array) throws IOException {
        return loadLongs(new File(filename.toString()), array);
    }

    public static long[][] loadLongsBig(File file) throws IOException {
        return loadLongsBig(file, ByteOrder.BIG_ENDIAN);
    }

    public static long[][] loadLongsBig(CharSequence filename) throws IOException {
        return loadLongsBig(new File(filename.toString()));
    }

    public static void storeLongs(long[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            long[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeLong(t[d]);
            }
        }
    }

    public static void storeLongs(long[][] array, DataOutput dataOutput) throws IOException {
        for (long[] t : array) {
            for (long j : t) {
                dataOutput.writeLong(j);
            }
        }
    }

    public static void storeLongs(long[][] array, long offset, long length, File file) throws IOException {
        storeLongs(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeLongs(long[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeLongs(array, offset, length, new File(filename.toString()));
    }

    public static void storeLongs(long[][] array, File file) throws IOException {
        storeLongs(array, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeLongs(long[][] array, CharSequence filename) throws IOException {
        storeLongs(array, new File(filename.toString()));
    }

    public static void storeLongs(LongIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeLong(i.nextLong());
        }
    }

    public static void storeLongs(LongIterator i, File file) throws IOException {
        storeLongs(i, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeLongs(LongIterator i, CharSequence filename) throws IOException {
        storeLongs(i, new File(filename.toString()));
    }

    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$LongDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$LongDataInputWrapper.class */
    private static final class LongDataInputWrapper implements LongIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private long next;

        public LongDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readLong();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.longs.LongIterator, java.util.PrimitiveIterator.OfLong
        public long nextLong() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static LongIterator asLongIterator(DataInput dataInput) {
        return new LongDataInputWrapper(dataInput);
    }

    public static LongIterator asLongIterator(File file) throws IOException {
        return asLongIterator(file, ByteOrder.BIG_ENDIAN);
    }

    public static LongIterator asLongIterator(CharSequence filename) throws IOException {
        return asLongIterator(new File(filename.toString()));
    }

    public static LongIterable asLongIterable(File file) {
        return () -> {
            try {
                return asLongIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static LongIterable asLongIterable(CharSequence filename) {
        return () -> {
            try {
                return asLongIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadDoubles(ReadableByteChannel channel, ByteOrder byteOrder, double[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        DoubleBuffer buffer = byteBuffer.asDoubleBuffer();
        int read = 0;
        while (true) {
            byteBuffer.clear();
            byteBuffer.limit(Math.min(buffer.capacity(), length << DoubleMappedBigList.LOG2_BYTES));
            int r = channel.read(byteBuffer);
            if (r <= 0) {
                return read;
            }
            int r2 = r >>> DoubleMappedBigList.LOG2_BYTES;
            read += r2;
            buffer.clear();
            buffer.limit(r2);
            buffer.get(array, offset, r2);
            offset += r2;
            length -= r2;
        }
    }

    public static int loadDoubles(ReadableByteChannel channel, ByteOrder byteOrder, double[] array) throws IOException {
        return loadDoubles(channel, byteOrder, array, 0, array.length);
    }

    public static int loadDoubles(File file, ByteOrder byteOrder, double[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        int read = loadDoubles(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static int loadDoubles(CharSequence filename, ByteOrder byteOrder, double[] array, int offset, int length) throws IOException {
        return loadDoubles(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static int loadDoubles(File file, ByteOrder byteOrder, double[] array) throws IOException {
        return loadDoubles(file, byteOrder, array, 0, array.length);
    }

    public static int loadDoubles(CharSequence filename, ByteOrder byteOrder, double[] array) throws IOException {
        return loadDoubles(new File(filename.toString()), byteOrder, array);
    }

    public static double[] loadDoubles(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long length = channel.size() / 8;
        if (length > 2147483647L) {
            channel.close();
            throw new IllegalArgumentException("File too long: " + channel.size() + " bytes (" + length + " elements)");
        }
        double[] array = new double[(int) length];
        if (((long) loadDoubles(channel, byteOrder, array)) < length) {
            throw new EOFException();
        }
        channel.close();
        return array;
    }

    public static double[] loadDoubles(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadDoubles(new File(filename.toString()), byteOrder);
    }

    public static void storeDoubles(double[] array, int offset, int length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        DoubleBuffer buffer = byteBuffer.asDoubleBuffer();
        while (length != 0) {
            int l = Math.min(length, buffer.capacity());
            buffer.clear();
            buffer.put(array, offset, l);
            buffer.flip();
            byteBuffer.clear();
            byteBuffer.limit(buffer.limit() << DoubleMappedBigList.LOG2_BYTES);
            channel.write(byteBuffer);
            offset += l;
            length -= l;
        }
    }

    public static void storeDoubles(double[] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        storeDoubles(array, 0, array.length, channel, byteOrder);
    }

    public static void storeDoubles(double[] array, int offset, int length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeDoubles(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeDoubles(double[] array, int offset, int length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeDoubles(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeDoubles(double[] array, File file, ByteOrder byteOrder) throws IOException {
        storeDoubles(array, 0, array.length, file, byteOrder);
    }

    public static void storeDoubles(double[] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeDoubles(array, new File(filename.toString()), byteOrder);
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadDoubles(ReadableByteChannel channel, ByteOrder byteOrder, double[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            double[] t = array[i];
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            int e = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            int r = loadDoubles(channel, byteOrder, t, s, e - s);
            c += (long) r;
            if (r < e - s) {
                break;
            }
        }
        return c;
    }

    public static long loadDoubles(ReadableByteChannel channel, ByteOrder byteOrder, double[][] array) throws IOException {
        return loadDoubles(channel, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadDoubles(File file, ByteOrder byteOrder, double[][] array, long offset, long length) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        long read = loadDoubles(channel, byteOrder, array, offset, length);
        channel.close();
        return read;
    }

    public static long loadDoubles(CharSequence filename, ByteOrder byteOrder, double[][] array, long offset, long length) throws IOException {
        return loadDoubles(new File(filename.toString()), byteOrder, array, offset, length);
    }

    public static long loadDoubles(File file, ByteOrder byteOrder, double[][] array) throws IOException {
        return loadDoubles(file, byteOrder, array, 0, BigArrays.length(array));
    }

    public static long loadDoubles(CharSequence filename, ByteOrder byteOrder, double[][] array) throws IOException {
        return loadDoubles(new File(filename.toString()), byteOrder, array);
    }

    public static double[][] loadDoublesBig(File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), new OpenOption[0]);
        double[][] array = DoubleBigArrays.newBigArray(channel.size() / 8);
        for (double[] t : array) {
            loadDoubles(channel, byteOrder, t);
        }
        channel.close();
        return array;
    }

    public static double[][] loadDoublesBig(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return loadDoublesBig(new File(filename.toString()), byteOrder);
    }

    public static void storeDoubles(double[][] array, long offset, long length, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            int s = (int) Math.max(0L, offset - BigArrays.start(i));
            storeDoubles(array[i], s, ((int) Math.min((long) array[i].length, (offset + length) - BigArrays.start(i))) - s, channel, byteOrder);
        }
    }

    public static void storeDoubles(double[][] array, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        for (double[] t : array) {
            storeDoubles(t, channel, byteOrder);
        }
    }

    public static void storeDoubles(double[][] array, long offset, long length, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeDoubles(array, offset, length, channel, byteOrder);
        channel.close();
    }

    public static void storeDoubles(double[][] array, long offset, long length, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeDoubles(array, offset, length, new File(filename.toString()), byteOrder);
    }

    public static void storeDoubles(double[][] array, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeDoubles(array, channel, byteOrder);
        channel.close();
    }

    public static void storeDoubles(double[][] array, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeDoubles(array, new File(filename.toString()), byteOrder);
    }

    public static void storeDoubles(DoubleIterator i, WritableByteChannel channel, ByteOrder byteOrder) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(BUFFER_SIZE).order(byteOrder);
        DoubleBuffer buffer = byteBuffer.asDoubleBuffer();
        while (i.hasNext()) {
            if (!buffer.hasRemaining()) {
                buffer.flip();
                byteBuffer.clear();
                byteBuffer.limit(buffer.limit() << DoubleMappedBigList.LOG2_BYTES);
                channel.write(byteBuffer);
                buffer.clear();
            }
            buffer.put(i.nextDouble());
        }
        buffer.flip();
        byteBuffer.clear();
        byteBuffer.limit(buffer.limit() << DoubleMappedBigList.LOG2_BYTES);
        channel.write(byteBuffer);
    }

    public static void storeDoubles(DoubleIterator i, File file, ByteOrder byteOrder) throws IOException {
        FileChannel channel = FileChannel.open(file.toPath(), StandardOpenOption.WRITE, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        storeDoubles(i, channel, byteOrder);
        channel.close();
    }

    public static void storeDoubles(DoubleIterator i, CharSequence filename, ByteOrder byteOrder) throws IOException {
        storeDoubles(i, new File(filename.toString()), byteOrder);
    }

    /* access modifiers changed from: private */
    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$DoubleDataNioInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$DoubleDataNioInputWrapper.class */
    public static final class DoubleDataNioInputWrapper implements DoubleIterator {
        private final ReadableByteChannel channel;
        private final ByteBuffer byteBuffer;
        private final DoubleBuffer buffer;

        public DoubleDataNioInputWrapper(ReadableByteChannel channel, ByteOrder byteOrder) {
            this.channel = channel;
            this.byteBuffer = ByteBuffer.allocateDirect(BinIO.BUFFER_SIZE).order(byteOrder);
            this.buffer = this.byteBuffer.asDoubleBuffer();
            this.buffer.clear().flip();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.buffer.hasRemaining()) {
                this.byteBuffer.clear();
                try {
                    this.channel.read(this.byteBuffer);
                    this.byteBuffer.flip();
                    this.buffer.clear();
                    this.buffer.limit(this.byteBuffer.limit() >>> DoubleMappedBigList.LOG2_BYTES);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return this.buffer.hasRemaining();
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (hasNext()) {
                return this.buffer.get();
            }
            throw new NoSuchElementException();
        }
    }

    public static DoubleIterator asDoubleIterator(ReadableByteChannel channel, ByteOrder byteOrder) {
        return new DoubleDataNioInputWrapper(channel, byteOrder);
    }

    public static DoubleIterator asDoubleIterator(File file, ByteOrder byteOrder) throws IOException {
        return new DoubleDataNioInputWrapper(FileChannel.open(file.toPath(), new OpenOption[0]), byteOrder);
    }

    public static DoubleIterator asDoubleIterator(CharSequence filename, ByteOrder byteOrder) throws IOException {
        return asDoubleIterator(new File(filename.toString()), byteOrder);
    }

    public static DoubleIterable asDoubleIterable(File file, ByteOrder byteOrder) {
        return () -> {
            try {
                return asDoubleIterator(file, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static DoubleIterable asDoubleIterable(CharSequence filename, ByteOrder byteOrder) {
        return () -> {
            try {
                return asDoubleIterator(filename, byteOrder);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static int loadDoubles(DataInput dataInput, double[] array, int offset, int length) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        int i = 0;
        while (i < length) {
            try {
                array[i + offset] = dataInput.readDouble();
                i++;
            } catch (EOFException e) {
            }
        }
        return i;
    }

    public static int loadDoubles(DataInput dataInput, double[] array) throws IOException {
        int i = 0;
        try {
            int length = array.length;
            i = 0;
            while (i < length) {
                array[i] = dataInput.readDouble();
                i++;
            }
        } catch (EOFException e) {
        }
        return i;
    }

    public static int loadDoubles(File file, double[] array, int offset, int length) throws IOException {
        return loadDoubles(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static int loadDoubles(CharSequence filename, double[] array, int offset, int length) throws IOException {
        return loadDoubles(new File(filename.toString()), array, offset, length);
    }

    public static int loadDoubles(File file, double[] array) throws IOException {
        return loadDoubles(file, array, 0, array.length);
    }

    public static int loadDoubles(CharSequence filename, double[] array) throws IOException {
        return loadDoubles(new File(filename.toString()), array);
    }

    public static double[] loadDoubles(File file) throws IOException {
        return loadDoubles(file, ByteOrder.BIG_ENDIAN);
    }

    public static double[] loadDoubles(CharSequence filename) throws IOException {
        return loadDoubles(new File(filename.toString()));
    }

    public static void storeDoubles(double[] array, int offset, int length, DataOutput dataOutput) throws IOException {
        Arrays.ensureOffsetLength(array.length, offset, length);
        for (int i = 0; i < length; i++) {
            dataOutput.writeDouble(array[offset + i]);
        }
    }

    public static void storeDoubles(double[] array, DataOutput dataOutput) throws IOException {
        for (double d : array) {
            dataOutput.writeDouble(d);
        }
    }

    public static void storeDoubles(double[] array, int offset, int length, File file) throws IOException {
        storeDoubles(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeDoubles(double[] array, int offset, int length, CharSequence filename) throws IOException {
        storeDoubles(array, offset, length, new File(filename.toString()));
    }

    public static void storeDoubles(double[] array, File file) throws IOException {
        storeDoubles(array, 0, array.length, file);
    }

    public static void storeDoubles(double[] array, CharSequence filename) throws IOException {
        storeDoubles(array, new File(filename.toString()));
    }

    /* JADX WARN: Type inference failed for: r0v19, types: [long] */
    public static long loadDoubles(DataInput dataInput, double[][] array, long offset, long length) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        char c = 0;
        try {
            for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
                double[] t = array[i];
                int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
                for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                    t[d] = dataInput.readDouble();
                    c++;
                }
            }
        } catch (EOFException e) {
        }
        return c;
    }

    /* JADX WARN: Type inference failed for: r0v12, types: [long] */
    public static long loadDoubles(DataInput dataInput, double[][] array) throws IOException {
        char c = 0;
        for (double[] t : array) {
            try {
                int l = t.length;
                for (int d = 0; d < l; d++) {
                    t[d] = dataInput.readDouble();
                    c++;
                }
            } catch (EOFException e) {
            }
        }
        return c;
    }

    public static long loadDoubles(File file, double[][] array, long offset, long length) throws IOException {
        return loadDoubles(file, ByteOrder.BIG_ENDIAN, array, offset, length);
    }

    public static long loadDoubles(CharSequence filename, double[][] array, long offset, long length) throws IOException {
        return loadDoubles(new File(filename.toString()), array, offset, length);
    }

    public static long loadDoubles(File file, double[][] array) throws IOException {
        return loadDoubles(file, ByteOrder.BIG_ENDIAN, array);
    }

    public static long loadDoubles(CharSequence filename, double[][] array) throws IOException {
        return loadDoubles(new File(filename.toString()), array);
    }

    public static double[][] loadDoublesBig(File file) throws IOException {
        return loadDoublesBig(file, ByteOrder.BIG_ENDIAN);
    }

    public static double[][] loadDoublesBig(CharSequence filename) throws IOException {
        return loadDoublesBig(new File(filename.toString()));
    }

    public static void storeDoubles(double[][] array, long offset, long length, DataOutput dataOutput) throws IOException {
        BigArrays.ensureOffsetLength(array, offset, length);
        for (int i = BigArrays.segment(offset); i < BigArrays.segment(offset + length + 134217727); i++) {
            double[] t = array[i];
            int l = (int) Math.min((long) t.length, (offset + length) - BigArrays.start(i));
            for (int d = (int) Math.max(0L, offset - BigArrays.start(i)); d < l; d++) {
                dataOutput.writeDouble(t[d]);
            }
        }
    }

    public static void storeDoubles(double[][] array, DataOutput dataOutput) throws IOException {
        for (double[] t : array) {
            for (double d : t) {
                dataOutput.writeDouble(d);
            }
        }
    }

    public static void storeDoubles(double[][] array, long offset, long length, File file) throws IOException {
        storeDoubles(array, offset, length, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeDoubles(double[][] array, long offset, long length, CharSequence filename) throws IOException {
        storeDoubles(array, offset, length, new File(filename.toString()));
    }

    public static void storeDoubles(double[][] array, File file) throws IOException {
        storeDoubles(array, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeDoubles(double[][] array, CharSequence filename) throws IOException {
        storeDoubles(array, new File(filename.toString()));
    }

    public static void storeDoubles(DoubleIterator i, DataOutput dataOutput) throws IOException {
        while (i.hasNext()) {
            dataOutput.writeDouble(i.nextDouble());
        }
    }

    public static void storeDoubles(DoubleIterator i, File file) throws IOException {
        storeDoubles(i, file, ByteOrder.BIG_ENDIAN);
    }

    public static void storeDoubles(DoubleIterator i, CharSequence filename) throws IOException {
        storeDoubles(i, new File(filename.toString()));
    }

    /* renamed from: it.unimi.dsi.fastutil.io.BinIO$DoubleDataInputWrapper */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/io/BinIO$DoubleDataInputWrapper.class */
    private static final class DoubleDataInputWrapper implements DoubleIterator {
        private final DataInput dataInput;
        private boolean toAdvance = true;
        private boolean endOfProcess = false;
        private double next;

        public DoubleDataInputWrapper(DataInput dataInput) {
            this.dataInput = dataInput;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!this.toAdvance) {
                return !this.endOfProcess;
            }
            this.toAdvance = false;
            try {
                this.next = this.dataInput.readDouble();
            } catch (EOFException e) {
                this.endOfProcess = true;
            } catch (IOException rethrow) {
                throw new RuntimeException(rethrow);
            }
            return !this.endOfProcess;
        }

        @Override // p014it.unimi.dsi.fastutil.doubles.DoubleIterator, java.util.PrimitiveIterator.OfDouble
        public double nextDouble() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.toAdvance = true;
            return this.next;
        }
    }

    public static DoubleIterator asDoubleIterator(DataInput dataInput) {
        return new DoubleDataInputWrapper(dataInput);
    }

    public static DoubleIterator asDoubleIterator(File file) throws IOException {
        return asDoubleIterator(file, ByteOrder.BIG_ENDIAN);
    }

    public static DoubleIterator asDoubleIterator(CharSequence filename) throws IOException {
        return asDoubleIterator(new File(filename.toString()));
    }

    public static DoubleIterable asDoubleIterable(File file) {
        return () -> {
            try {
                return asDoubleIterator(file);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static DoubleIterable asDoubleIterable(CharSequence filename) {
        return () -> {
            try {
                return asDoubleIterator(filename);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
