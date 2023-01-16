package emu.grasscutter.net.packet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: grasscutter.jar:emu/grasscutter/net/packet/PacketWriter.class */
public class PacketWriter {
    private final ByteArrayOutputStream baos = new ByteArrayOutputStream(128);

    public byte[] build() {
        return this.baos.toByteArray();
    }

    public void writeEmpty(int i) {
        while (i > 0) {
            this.baos.write(0);
            i--;
        }
    }

    public void writeMax(int i) {
        while (i > 0) {
            this.baos.write(255);
            i--;
        }
    }

    public void writeInt8(byte b) {
        this.baos.write(b);
    }

    public void writeInt8(int i) {
        this.baos.write((byte) i);
    }

    public void writeBoolean(boolean b) {
        this.baos.write(b ? 1 : 0);
    }

    public void writeUint8(byte b) {
        this.baos.write(b & 255);
    }

    public void writeUint8(int i) {
        this.baos.write(((byte) i) & 255);
    }

    public void writeUint16(int i) {
        this.baos.write((byte) (i & 255));
        this.baos.write((byte) ((i >>> 8) & 255));
    }

    public void writeUint24(int i) {
        this.baos.write((byte) (i & 255));
        this.baos.write((byte) ((i >>> 8) & 255));
        this.baos.write((byte) ((i >>> 16) & 255));
    }

    public void writeInt16(int i) {
        this.baos.write((byte) i);
        this.baos.write((byte) (i >>> 8));
    }

    public void writeUint32(int i) {
        this.baos.write((byte) (i & 255));
        this.baos.write((byte) ((i >>> 8) & 255));
        this.baos.write((byte) ((i >>> 16) & 255));
        this.baos.write((byte) ((i >>> 24) & 255));
    }

    public void writeInt32(int i) {
        this.baos.write((byte) i);
        this.baos.write((byte) (i >>> 8));
        this.baos.write((byte) (i >>> 16));
        this.baos.write((byte) (i >>> 24));
    }

    public void writeUint32(long i) {
        this.baos.write((byte) ((int) (i & 255)));
        this.baos.write((byte) ((int) ((i >>> 8) & 255)));
        this.baos.write((byte) ((int) ((i >>> 16) & 255)));
        this.baos.write((byte) ((int) ((i >>> 24) & 255)));
    }

    public void writeFloat(float f) {
        writeUint32(Float.floatToRawIntBits(f));
    }

    public void writeUint64(long l) {
        this.baos.write((byte) ((int) (l & 255)));
        this.baos.write((byte) ((int) ((l >>> 8) & 255)));
        this.baos.write((byte) ((int) ((l >>> 16) & 255)));
        this.baos.write((byte) ((int) ((l >>> 24) & 255)));
        this.baos.write((byte) ((int) ((l >>> 32) & 255)));
        this.baos.write((byte) ((int) ((l >>> 40) & 255)));
        this.baos.write((byte) ((int) ((l >>> 48) & 255)));
        this.baos.write((byte) ((int) ((l >>> 56) & 255)));
    }

    public void writeDouble(double d) {
        writeUint64(Double.doubleToLongBits(d));
    }

    public void writeString16(String s) {
        if (s == null) {
            writeUint16(0);
            return;
        }
        writeUint16(s.length() * 2);
        for (int i = 0; i < s.length(); i++) {
            writeUint16((short) s.charAt(i));
        }
    }

    public void writeString8(String s) {
        if (s == null) {
            writeUint16(0);
            return;
        }
        writeUint16(s.length());
        for (int i = 0; i < s.length(); i++) {
            writeUint8((byte) s.charAt(i));
        }
    }

    public void writeDirectString8(String s, int expectedSize) {
        if (s != null) {
            int i = 0;
            while (i < expectedSize) {
                writeUint8((byte) (i < s.length() ? s.charAt(i) : 0));
                i++;
            }
        }
    }

    public void writeBytes(byte[] bytes) {
        try {
            this.baos.write(bytes);
        } catch (IOException e) {
        }
    }

    public void writeBytes(int[] bytes) {
        byte[] b = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
            b[i] = (byte) bytes[i];
        }
        try {
            this.baos.write(b);
        } catch (IOException e) {
        }
    }
}
