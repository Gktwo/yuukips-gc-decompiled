package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/ByteOutputInputExpCodingLoop.class */
public class ByteOutputInputExpCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        for (int iByte = offset; iByte < offset + byteCount; iByte++) {
            for (int iOutput = 0; iOutput < outputCount; iOutput++) {
                byte[] matrixRow = matrixRows[iOutput];
                int value = 0;
                for (int iInput = 0; iInput < inputCount; iInput++) {
                    value ^= Galois.multiply(matrixRow[iInput], inputs[iInput][iByte]);
                }
                outputs[iOutput][iByte] = (byte) value;
            }
        }
    }
}
