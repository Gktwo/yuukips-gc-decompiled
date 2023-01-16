package emu.grasscutter.net.packet;

import com.google.protobuf.GeneratedMessageV3;
import emu.grasscutter.net.proto.PacketHeadOuterClass;
import emu.grasscutter.utils.Crypto;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* loaded from: grasscutter.jar:emu/grasscutter/net/packet/BasePacket.class */
public class BasePacket {
    private static final int const1 = 17767;
    private static final int const2 = -30293;
    private int opcode;
    private boolean shouldBuildHeader;
    private byte[] header;
    private byte[] data;
    private boolean useDispatchKey;
    public boolean shouldEncrypt;

    public BasePacket(int opcode) {
        this.shouldBuildHeader = false;
        this.shouldEncrypt = true;
        this.opcode = opcode;
    }

    public BasePacket(int opcode, int clientSequence) {
        this.shouldBuildHeader = false;
        this.shouldEncrypt = true;
        this.opcode = opcode;
        buildHeader(clientSequence);
    }

    public BasePacket(int opcode, boolean buildHeader) {
        this.shouldBuildHeader = false;
        this.shouldEncrypt = true;
        this.opcode = opcode;
        this.shouldBuildHeader = buildHeader;
    }

    public int getOpcode() {
        return this.opcode;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    public boolean useDispatchKey() {
        return this.useDispatchKey;
    }

    public void setUseDispatchKey(boolean useDispatchKey) {
        this.useDispatchKey = useDispatchKey;
    }

    public byte[] getHeader() {
        return this.header;
    }

    public void setHeader(byte[] header) {
        this.header = header;
    }

    public boolean shouldBuildHeader() {
        return this.shouldBuildHeader;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public void setData(GeneratedMessageV3 proto) {
        this.data = proto.toByteArray();
    }

    public void setData(GeneratedMessageV3.Builder proto) {
        this.data = proto.build().toByteArray();
    }

    public BasePacket buildHeader(int clientSequence) {
        if (getHeader() != null && clientSequence == 0) {
            return this;
        }
        setHeader(PacketHeadOuterClass.PacketHead.newBuilder().setClientSequenceId(clientSequence).setSentMs(System.currentTimeMillis()).build().toByteArray());
        return this;
    }

    public byte[] build() {
        if (getHeader() == null) {
            this.header = new byte[0];
        }
        if (getData() == null) {
            this.data = new byte[0];
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream(10 + getHeader().length + getData().length + 2);
        writeUint16(baos, const1);
        writeUint16(baos, this.opcode);
        writeUint16(baos, this.header.length);
        writeUint32(baos, this.data.length);
        writeBytes(baos, this.header);
        writeBytes(baos, this.data);
        writeUint16(baos, const2);
        byte[] packet = baos.toByteArray();
        if (this.shouldEncrypt) {
            Crypto.xor(packet, useDispatchKey() ? Crypto.DISPATCH_KEY : Crypto.ENCRYPT_KEY);
        }
        return packet;
    }

    public void writeUint16(ByteArrayOutputStream baos, int i) {
        baos.write((byte) ((i >>> 8) & 255));
        baos.write((byte) (i & 255));
    }

    public void writeUint32(ByteArrayOutputStream baos, int i) {
        baos.write((byte) ((i >>> 24) & 255));
        baos.write((byte) ((i >>> 16) & 255));
        baos.write((byte) ((i >>> 8) & 255));
        baos.write((byte) (i & 255));
    }

    public void writeBytes(ByteArrayOutputStream baos, byte[] bytes) {
        try {
            baos.write(bytes);
        } catch (IOException e) {
        }
    }
}
