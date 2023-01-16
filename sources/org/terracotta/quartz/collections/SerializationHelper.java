package org.terracotta.quartz.collections;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializationHelper.class */
public class SerializationHelper {
    private static final char MARKER = 65534;

    public static byte[] serialize(Object obj) {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            return baos.toByteArray();
        } catch (IOException e) {
            throw new RuntimeException("error serializing " + obj, e);
        }
    }

    public static Object deserialize(byte[] bytes) {
        try {
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bytes));
            Object obj = ois.readObject();
            ois.close();
            return obj;
        } catch (Exception e) {
            throw new RuntimeException("error deserializing " + bytes, e);
        }
    }

    public static Object deserializeFromString(String key) throws IOException, ClassNotFoundException {
        if (key.length() < 1 || key.charAt(0) != 65534) {
            return key;
        }
        return new ObjectInputStream(new StringSerializedObjectInputStream(key)).readObject();
    }

    public static String serializeToString(Object key) throws IOException {
        if (key instanceof String) {
            String stringKey = (String) key;
            if (stringKey.length() < 1 || stringKey.charAt(0) != 65534) {
                return stringKey;
            }
            throw new IOException("Illegal string key: " + stringKey);
        }
        StringSerializedObjectOutputStream out = new StringSerializedObjectOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(out);
        writeStringKey(key, oos);
        oos.close();
        return out.toString();
    }

    private static void writeStringKey(Object key, ObjectOutputStream oos) throws IOException {
        oos.writeObject(key);
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializationHelper$StringSerializedObjectOutputStream.class */
    private static class StringSerializedObjectOutputStream extends OutputStream {
        private int count;
        private char[] buf;

        StringSerializedObjectOutputStream() {
            this(16);
        }

        StringSerializedObjectOutputStream(int size) {
            this.buf = new char[Math.max(1, size)];
            char[] cArr = this.buf;
            int i = this.count;
            this.count = i + 1;
            cArr[i] = 65534;
        }

        @Override // java.io.OutputStream
        public void write(int b) {
            if (this.count + 1 > this.buf.length) {
                char[] newbuf = new char[this.buf.length << 1];
                System.arraycopy(this.buf, 0, newbuf, 0, this.count);
                this.buf = newbuf;
            }
            writeChar(b);
        }

        private void writeChar(int b) {
            char[] cArr = this.buf;
            int i = this.count;
            this.count = i + 1;
            cArr[i] = (char) (b & 255);
        }

        @Override // java.io.OutputStream
        public void write(byte[] b, int off, int len) {
            if (off < 0 || off > b.length || len < 0 || off + len > b.length || off + len < 0) {
                throw new IndexOutOfBoundsException();
            } else if (len != 0) {
                int newcount = this.count + len;
                if (newcount > this.buf.length) {
                    char[] newbuf = new char[Math.max(this.buf.length << 1, newcount)];
                    System.arraycopy(this.buf, 0, newbuf, 0, this.count);
                    this.buf = newbuf;
                }
                for (int i = 0; i < len; i++) {
                    writeChar(b[off + i]);
                }
            }
        }

        @Override // java.lang.Object
        public String toString() {
            return new String(this.buf, 0, this.count);
        }
    }

    /* loaded from: grasscutter.jar:org/terracotta/quartz/collections/SerializationHelper$StringSerializedObjectInputStream.class */
    private static class StringSerializedObjectInputStream extends InputStream {
        private final String source;
        private final int length;
        private int index;

        StringSerializedObjectInputStream(String source) {
            this.source = source;
            this.length = source.length();
            read();
        }

        @Override // java.io.InputStream
        public int read() {
            if (this.index == this.length) {
                return -1;
            }
            String str = this.source;
            int i = this.index;
            this.index = i + 1;
            return str.charAt(i) & 255;
        }
    }
}
