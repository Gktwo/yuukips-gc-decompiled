package com.sun.jna;

import com.sun.jna.Structure;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:com/sun/jna/Pointer.class */
public class Pointer {
    public static final Pointer NULL = null;
    protected long peer;

    public static final Pointer createConstant(long peer) {
        return new Opaque(peer);
    }

    public static final Pointer createConstant(int peer) {
        return new Opaque(((long) peer) & -1);
    }

    /* access modifiers changed from: package-private */
    public Pointer() {
    }

    public Pointer(long peer) {
        this.peer = peer;
    }

    public Pointer share(long offset) {
        return share(offset, 0);
    }

    public Pointer share(long offset, long sz) {
        if (offset == 0) {
            return this;
        }
        return new Pointer(this.peer + offset);
    }

    public void clear(long size) {
        setMemory(0, size, (byte) 0);
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        return o != null && (o instanceof Pointer) && ((Pointer) o).peer == this.peer;
    }

    public int hashCode() {
        return (int) ((this.peer >>> 32) + (this.peer & -1));
    }

    public long indexOf(long offset, byte value) {
        return Native.indexOf(this, this.peer, offset, value);
    }

    public void read(long offset, byte[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, short[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, char[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, int[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, long[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, float[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, double[] buf, int index, int length) {
        Native.read(this, this.peer, offset, buf, index, length);
    }

    public void read(long offset, Pointer[] buf, int index, int length) {
        for (int i = 0; i < length; i++) {
            Pointer p = getPointer(offset + ((long) (i * Native.POINTER_SIZE)));
            Pointer oldp = buf[i + index];
            if (oldp == null || p == null || p.peer != oldp.peer) {
                buf[i + index] = p;
            }
        }
    }

    public void write(long offset, byte[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long offset, short[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long offset, char[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long offset, int[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long offset, long[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long offset, float[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long offset, double[] buf, int index, int length) {
        Native.write(this, this.peer, offset, buf, index, length);
    }

    public void write(long bOff, Pointer[] buf, int index, int length) {
        for (int i = 0; i < length; i++) {
            setPointer(bOff + ((long) (i * Native.POINTER_SIZE)), buf[index + i]);
        }
    }

    /* access modifiers changed from: package-private */
    public Object getValue(long offset, Class<?> type, Object currentValue) {
        Object result = null;
        if (Structure.class.isAssignableFrom(type)) {
            Structure s = (Structure) currentValue;
            if (Structure.ByReference.class.isAssignableFrom(type)) {
                s = Structure.updateStructureByReference(type, s, getPointer(offset));
            } else {
                s.useMemory(this, (int) offset, true);
                s.read();
            }
            result = s;
        } else if (type == Boolean.TYPE || type == Boolean.class) {
            result = Function.valueOf(getInt(offset) != 0);
        } else if (type == Byte.TYPE || type == Byte.class) {
            result = Byte.valueOf(getByte(offset));
        } else if (type == Short.TYPE || type == Short.class) {
            result = Short.valueOf(getShort(offset));
        } else if (type == Character.TYPE || type == Character.class) {
            result = Character.valueOf(getChar(offset));
        } else if (type == Integer.TYPE || type == Integer.class) {
            result = Integer.valueOf(getInt(offset));
        } else if (type == Long.TYPE || type == Long.class) {
            result = Long.valueOf(getLong(offset));
        } else if (type == Float.TYPE || type == Float.class) {
            result = Float.valueOf(getFloat(offset));
        } else if (type == Double.TYPE || type == Double.class) {
            result = Double.valueOf(getDouble(offset));
        } else if (Pointer.class.isAssignableFrom(type)) {
            Pointer p = getPointer(offset);
            if (p != null) {
                Pointer oldp = currentValue instanceof Pointer ? (Pointer) currentValue : null;
                if (oldp == null || p.peer != oldp.peer) {
                    result = p;
                } else {
                    result = oldp;
                }
            }
        } else if (type == String.class) {
            Pointer p2 = getPointer(offset);
            result = p2 != null ? p2.getString(0) : null;
        } else if (type == WString.class) {
            Pointer p3 = getPointer(offset);
            result = p3 != null ? new WString(p3.getWideString(0)) : null;
        } else if (Callback.class.isAssignableFrom(type)) {
            Pointer fp = getPointer(offset);
            if (fp == null) {
                result = null;
            } else {
                Callback cb = (Callback) currentValue;
                if (!fp.equals(CallbackReference.getFunctionPointer(cb))) {
                    cb = CallbackReference.getCallback(type, fp);
                }
                result = cb;
            }
        } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(type)) {
            Pointer bp = getPointer(offset);
            if (bp == null) {
                result = null;
            } else {
                Pointer oldbp = currentValue == null ? null : Native.getDirectBufferPointer((Buffer) currentValue);
                if (oldbp == null || !oldbp.equals(bp)) {
                    throw new IllegalStateException("Can't autogenerate a direct buffer on memory read");
                }
                result = currentValue;
            }
        } else if (NativeMapped.class.isAssignableFrom(type)) {
            NativeMapped nm = (NativeMapped) currentValue;
            if (nm != null) {
                result = nm.fromNative(getValue(offset, nm.nativeType(), null), new FromNativeContext(type));
                if (nm.equals(result)) {
                    result = nm;
                }
            } else {
                NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
                result = tc.fromNative(getValue(offset, tc.nativeType(), null), new FromNativeContext(type));
            }
        } else if (type.isArray()) {
            result = currentValue;
            if (result == null) {
                throw new IllegalStateException("Need an initialized array");
            }
            readArray(offset, result, type.getComponentType());
        } else {
            throw new IllegalArgumentException("Reading \"" + type + "\" from memory is not supported");
        }
        return result;
    }

    private void readArray(long offset, Object o, Class<?> cls) {
        int length = Array.getLength(o);
        if (cls == Byte.TYPE) {
            read(offset, (byte[]) o, 0, length);
        } else if (cls == Short.TYPE) {
            read(offset, (short[]) o, 0, length);
        } else if (cls == Character.TYPE) {
            read(offset, (char[]) o, 0, length);
        } else if (cls == Integer.TYPE) {
            read(offset, (int[]) o, 0, length);
        } else if (cls == Long.TYPE) {
            read(offset, (long[]) o, 0, length);
        } else if (cls == Float.TYPE) {
            read(offset, (float[]) o, 0, length);
        } else if (cls == Double.TYPE) {
            read(offset, (double[]) o, 0, length);
        } else if (Pointer.class.isAssignableFrom(cls)) {
            read(offset, (Pointer[]) o, 0, length);
        } else if (Structure.class.isAssignableFrom(cls)) {
            Structure[] sarray = (Structure[]) o;
            if (Structure.ByReference.class.isAssignableFrom(cls)) {
                Pointer[] parray = getPointerArray(offset, sarray.length);
                for (int i = 0; i < sarray.length; i++) {
                    sarray[i] = Structure.updateStructureByReference(cls, sarray[i], parray[i]);
                }
                return;
            }
            Structure first = sarray[0];
            if (first == null) {
                first = Structure.newInstance((Class<Structure>) cls, share(offset));
                first.conditionalAutoRead();
                sarray[0] = first;
            } else {
                first.useMemory(this, (int) offset, true);
                first.read();
            }
            Structure[] tmp = first.toArray(sarray.length);
            for (int i2 = 1; i2 < sarray.length; i2++) {
                if (sarray[i2] == null) {
                    sarray[i2] = tmp[i2];
                } else {
                    sarray[i2].useMemory(this, (int) (offset + ((long) (i2 * sarray[i2].size()))), true);
                    sarray[i2].read();
                }
            }
        } else if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMapped[] array = (NativeMapped[]) o;
            NativeMappedConverter tc = NativeMappedConverter.getInstance(cls);
            int size = Native.getNativeSize(o.getClass(), o) / array.length;
            for (int i3 = 0; i3 < array.length; i3++) {
                array[i3] = (NativeMapped) tc.fromNative(getValue(offset + ((long) (size * i3)), tc.nativeType(), array[i3]), new FromNativeContext(cls));
            }
        } else {
            throw new IllegalArgumentException("Reading array of " + cls + " from memory not supported");
        }
    }

    public byte getByte(long offset) {
        return Native.getByte(this, this.peer, offset);
    }

    public char getChar(long offset) {
        return Native.getChar(this, this.peer, offset);
    }

    public short getShort(long offset) {
        return Native.getShort(this, this.peer, offset);
    }

    public int getInt(long offset) {
        return Native.getInt(this, this.peer, offset);
    }

    public long getLong(long offset) {
        return Native.getLong(this, this.peer, offset);
    }

    public NativeLong getNativeLong(long offset) {
        return new NativeLong(NativeLong.SIZE == 8 ? getLong(offset) : (long) getInt(offset));
    }

    public float getFloat(long offset) {
        return Native.getFloat(this, this.peer, offset);
    }

    public double getDouble(long offset) {
        return Native.getDouble(this, this.peer, offset);
    }

    public Pointer getPointer(long offset) {
        return Native.getPointer(this.peer + offset);
    }

    public ByteBuffer getByteBuffer(long offset, long length) {
        return Native.getDirectByteBuffer(this, this.peer, offset, length).order(ByteOrder.nativeOrder());
    }

    public String getWideString(long offset) {
        return Native.getWideString(this, this.peer, offset);
    }

    public String getString(long offset) {
        return getString(offset, Native.getDefaultStringEncoding());
    }

    public String getString(long offset, String encoding) {
        return Native.getString(this, offset, encoding);
    }

    public byte[] getByteArray(long offset, int arraySize) {
        byte[] buf = new byte[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public char[] getCharArray(long offset, int arraySize) {
        char[] buf = new char[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public short[] getShortArray(long offset, int arraySize) {
        short[] buf = new short[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public int[] getIntArray(long offset, int arraySize) {
        int[] buf = new int[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public long[] getLongArray(long offset, int arraySize) {
        long[] buf = new long[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public float[] getFloatArray(long offset, int arraySize) {
        float[] buf = new float[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public double[] getDoubleArray(long offset, int arraySize) {
        double[] buf = new double[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public Pointer[] getPointerArray(long offset) {
        List<Pointer> array = new ArrayList<>();
        int addOffset = 0;
        Pointer p = getPointer(offset);
        while (p != null) {
            array.add(p);
            addOffset += Native.POINTER_SIZE;
            p = getPointer(offset + ((long) addOffset));
        }
        return (Pointer[]) array.toArray(new Pointer[0]);
    }

    public Pointer[] getPointerArray(long offset, int arraySize) {
        Pointer[] buf = new Pointer[arraySize];
        read(offset, buf, 0, arraySize);
        return buf;
    }

    public String[] getStringArray(long offset) {
        return getStringArray(offset, -1, Native.getDefaultStringEncoding());
    }

    public String[] getStringArray(long offset, String encoding) {
        return getStringArray(offset, -1, encoding);
    }

    public String[] getStringArray(long offset, int length) {
        return getStringArray(offset, length, Native.getDefaultStringEncoding());
    }

    public String[] getWideStringArray(long offset) {
        return getWideStringArray(offset, -1);
    }

    public String[] getWideStringArray(long offset, int length) {
        return getStringArray(offset, length, "--WIDE-STRING--");
    }

    public String[] getStringArray(long offset, int length, String encoding) {
        String s;
        String s2;
        List<String> strings = new ArrayList<>();
        int addOffset = 0;
        if (length == -1) {
            while (true) {
                Pointer p = getPointer(offset + ((long) addOffset));
                if (p == null) {
                    break;
                }
                if ("--WIDE-STRING--".equals(encoding)) {
                    s = p.getWideString(0);
                } else {
                    s = p.getString(0, encoding);
                }
                strings.add(s);
                addOffset += Native.POINTER_SIZE;
            }
        } else {
            Pointer p2 = getPointer(offset + ((long) 0));
            int count = 0;
            while (true) {
                count++;
                if (count >= length) {
                    break;
                }
                if (p2 == null) {
                    s2 = null;
                } else {
                    s2 = "--WIDE-STRING--".equals(encoding) ? p2.getWideString(0) : p2.getString(0, encoding);
                }
                strings.add(s2);
                if (count < length) {
                    addOffset += Native.POINTER_SIZE;
                    p2 = getPointer(offset + ((long) addOffset));
                }
            }
        }
        return (String[]) strings.toArray(new String[0]);
    }

    /* access modifiers changed from: package-private */
    public void setValue(long offset, Object value, Class<?> type) {
        if (type == Boolean.TYPE || type == Boolean.class) {
            setInt(offset, Boolean.TRUE.equals(value) ? -1 : 0);
        } else if (type == Byte.TYPE || type == Byte.class) {
            setByte(offset, value == null ? 0 : ((Byte) value).byteValue());
        } else if (type == Short.TYPE || type == Short.class) {
            setShort(offset, value == null ? 0 : ((Short) value).shortValue());
        } else if (type == Character.TYPE || type == Character.class) {
            setChar(offset, value == null ? 0 : ((Character) value).charValue());
        } else if (type == Integer.TYPE || type == Integer.class) {
            setInt(offset, value == null ? 0 : ((Integer) value).intValue());
        } else if (type == Long.TYPE || type == Long.class) {
            setLong(offset, value == null ? 0 : ((Long) value).longValue());
        } else if (type == Float.TYPE || type == Float.class) {
            setFloat(offset, value == null ? 0.0f : ((Float) value).floatValue());
        } else if (type == Double.TYPE || type == Double.class) {
            setDouble(offset, value == null ? 0.0d : ((Double) value).doubleValue());
        } else if (type == Pointer.class) {
            setPointer(offset, (Pointer) value);
        } else if (type == String.class) {
            setPointer(offset, (Pointer) value);
        } else if (type == WString.class) {
            setPointer(offset, (Pointer) value);
        } else if (Structure.class.isAssignableFrom(type)) {
            Structure s = (Structure) value;
            if (Structure.ByReference.class.isAssignableFrom(type)) {
                setPointer(offset, s == null ? null : s.getPointer());
                if (s != null) {
                    s.autoWrite();
                    return;
                }
                return;
            }
            s.useMemory(this, (int) offset, true);
            s.write();
        } else if (Callback.class.isAssignableFrom(type)) {
            setPointer(offset, CallbackReference.getFunctionPointer((Callback) value));
        } else if (Platform.HAS_BUFFERS && Buffer.class.isAssignableFrom(type)) {
            setPointer(offset, value == null ? null : Native.getDirectBufferPointer((Buffer) value));
        } else if (NativeMapped.class.isAssignableFrom(type)) {
            NativeMappedConverter tc = NativeMappedConverter.getInstance(type);
            setValue(offset, tc.toNative(value, new ToNativeContext()), tc.nativeType());
        } else if (type.isArray()) {
            writeArray(offset, value, type.getComponentType());
        } else {
            throw new IllegalArgumentException("Writing " + type + " to memory is not supported");
        }
    }

    private void writeArray(long offset, Object value, Class<?> cls) {
        if (cls == Byte.TYPE) {
            byte[] buf = (byte[]) value;
            write(offset, buf, 0, buf.length);
        } else if (cls == Short.TYPE) {
            short[] buf2 = (short[]) value;
            write(offset, buf2, 0, buf2.length);
        } else if (cls == Character.TYPE) {
            char[] buf3 = (char[]) value;
            write(offset, buf3, 0, buf3.length);
        } else if (cls == Integer.TYPE) {
            int[] buf4 = (int[]) value;
            write(offset, buf4, 0, buf4.length);
        } else if (cls == Long.TYPE) {
            long[] buf5 = (long[]) value;
            write(offset, buf5, 0, buf5.length);
        } else if (cls == Float.TYPE) {
            float[] buf6 = (float[]) value;
            write(offset, buf6, 0, buf6.length);
        } else if (cls == Double.TYPE) {
            double[] buf7 = (double[]) value;
            write(offset, buf7, 0, buf7.length);
        } else if (Pointer.class.isAssignableFrom(cls)) {
            Pointer[] buf8 = (Pointer[]) value;
            write(offset, buf8, 0, buf8.length);
        } else if (Structure.class.isAssignableFrom(cls)) {
            Structure[] sbuf = (Structure[]) value;
            if (Structure.ByReference.class.isAssignableFrom(cls)) {
                Pointer[] buf9 = new Pointer[sbuf.length];
                for (int i = 0; i < sbuf.length; i++) {
                    if (sbuf[i] == null) {
                        buf9[i] = null;
                    } else {
                        buf9[i] = sbuf[i].getPointer();
                        sbuf[i].write();
                    }
                }
                write(offset, buf9, 0, buf9.length);
                return;
            }
            Structure first = sbuf[0];
            if (first == null) {
                first = Structure.newInstance((Class<Structure>) cls, share(offset));
                sbuf[0] = first;
            } else {
                first.useMemory(this, (int) offset, true);
            }
            first.write();
            Structure[] tmp = first.toArray(sbuf.length);
            for (int i2 = 1; i2 < sbuf.length; i2++) {
                if (sbuf[i2] == null) {
                    sbuf[i2] = tmp[i2];
                } else {
                    sbuf[i2].useMemory(this, (int) (offset + ((long) (i2 * sbuf[i2].size()))), true);
                }
                sbuf[i2].write();
            }
        } else if (NativeMapped.class.isAssignableFrom(cls)) {
            NativeMapped[] buf10 = (NativeMapped[]) value;
            NativeMappedConverter tc = NativeMappedConverter.getInstance(cls);
            Class<?> nativeType = tc.nativeType();
            int size = Native.getNativeSize(value.getClass(), value) / buf10.length;
            for (int i3 = 0; i3 < buf10.length; i3++) {
                setValue(offset + ((long) (i3 * size)), tc.toNative(buf10[i3], new ToNativeContext()), nativeType);
            }
        } else {
            throw new IllegalArgumentException("Writing array of " + cls + " to memory not supported");
        }
    }

    public void setMemory(long offset, long length, byte value) {
        Native.setMemory(this, this.peer, offset, length, value);
    }

    public void setByte(long offset, byte value) {
        Native.setByte(this, this.peer, offset, value);
    }

    public void setShort(long offset, short value) {
        Native.setShort(this, this.peer, offset, value);
    }

    public void setChar(long offset, char value) {
        Native.setChar(this, this.peer, offset, value);
    }

    public void setInt(long offset, int value) {
        Native.setInt(this, this.peer, offset, value);
    }

    public void setLong(long offset, long value) {
        Native.setLong(this, this.peer, offset, value);
    }

    public void setNativeLong(long offset, NativeLong value) {
        if (NativeLong.SIZE == 8) {
            setLong(offset, value.longValue());
        } else {
            setInt(offset, value.intValue());
        }
    }

    public void setFloat(long offset, float value) {
        Native.setFloat(this, this.peer, offset, value);
    }

    public void setDouble(long offset, double value) {
        Native.setDouble(this, this.peer, offset, value);
    }

    public void setPointer(long offset, Pointer value) {
        Native.setPointer(this, this.peer, offset, value != null ? value.peer : 0);
    }

    public void setWideString(long offset, String value) {
        Native.setWideString(this, this.peer, offset, value);
    }

    public void setString(long offset, WString value) {
        setWideString(offset, value == null ? null : value.toString());
    }

    public void setString(long offset, String value) {
        setString(offset, value, Native.getDefaultStringEncoding());
    }

    public void setString(long offset, String value, String encoding) {
        byte[] data = Native.getBytes(value, encoding);
        write(offset, data, 0, data.length);
        setByte(offset + ((long) data.length), (byte) 0);
    }

    public String dump(long offset, int size) {
        StringWriter sw = new StringWriter("memory dump".length() + 2 + (size * 2) + ((size / 4) * 4));
        PrintWriter out = new PrintWriter(sw);
        out.println("memory dump");
        for (int i = 0; i < size; i++) {
            byte b = getByte(offset + ((long) i));
            if (i % 4 == 0) {
                out.print("[");
            }
            if (b >= 0 && b < 16) {
                out.print("0");
            }
            out.print(Integer.toHexString(b & 255));
            if (i % 4 == 3 && i < size - 1) {
                out.println("]");
            }
        }
        if (sw.getBuffer().charAt(sw.getBuffer().length() - 2) != ']') {
            out.println("]");
        }
        return sw.toString();
    }

    public String toString() {
        return "native@0x" + Long.toHexString(this.peer);
    }

    public static long nativeValue(Pointer p) {
        if (p == null) {
            return 0;
        }
        return p.peer;
    }

    public static void nativeValue(Pointer p, long value) {
        p.peer = value;
    }

    /* loaded from: grasscutter.jar:com/sun/jna/Pointer$Opaque.class */
    private static class Opaque extends Pointer {
        private final String MSG;

        private Opaque(long peer) {
            super(peer);
            this.MSG = "This pointer is opaque: " + this;
        }

        @Override // com.sun.jna.Pointer
        public Pointer share(long offset, long size) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void clear(long size) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long indexOf(long offset, byte value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, byte[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, char[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, short[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, int[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, long[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, float[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, double[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void read(long bOff, Pointer[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, byte[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, char[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, short[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, int[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, long[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, float[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, double[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void write(long bOff, Pointer[] buf, int index, int length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public ByteBuffer getByteBuffer(long offset, long length) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public byte getByte(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public char getChar(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public short getShort(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public int getInt(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public long getLong(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public float getFloat(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public double getDouble(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public Pointer getPointer(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getString(long bOff, String encoding) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String getWideString(long bOff) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setByte(long bOff, byte value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setChar(long bOff, char value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setShort(long bOff, short value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setInt(long bOff, int value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setLong(long bOff, long value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setFloat(long bOff, float value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setDouble(long bOff, double value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setPointer(long offset, Pointer value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setString(long offset, String value, String encoding) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setWideString(long offset, String value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public void setMemory(long offset, long size, byte value) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String dump(long offset, int size) {
            throw new UnsupportedOperationException(this.MSG);
        }

        @Override // com.sun.jna.Pointer
        public String toString() {
            return "const@0x" + Long.toHexString(this.peer);
        }
    }
}
