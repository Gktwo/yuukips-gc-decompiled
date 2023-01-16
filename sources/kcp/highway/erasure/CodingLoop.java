package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/CodingLoop.class */
public interface CodingLoop {
    public static final CodingLoop[] ALL_CODING_LOOPS = {new ByteInputOutputExpCodingLoop(), new ByteInputOutputTableCodingLoop(), new ByteOutputInputExpCodingLoop(), new ByteOutputInputTableCodingLoop(), new InputByteOutputExpCodingLoop(), new InputByteOutputTableCodingLoop(), new InputOutputByteExpCodingLoop(), new InputOutputByteTableCodingLoop(), new OutputByteInputExpCodingLoop(), new OutputByteInputTableCodingLoop(), new OutputInputByteExpCodingLoop(), new OutputInputByteTableCodingLoop()};

    void codeSomeShards(byte[][] bArr, byte[][] bArr2, int i, byte[][] bArr3, int i2, int i3, int i4);

    boolean checkSomeShards(byte[][] bArr, byte[][] bArr2, int i, byte[][] bArr3, int i2, int i3, int i4, byte[] bArr4);
}
