package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/ByteOutputInputTableCodingLoop.class */
public class ByteOutputInputTableCodingLoop extends CodingLoopBase {
    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        for (int iByte = offset; iByte < offset + byteCount; iByte++) {
            for (int iOutput = 0; iOutput < outputCount; iOutput++) {
                byte[] matrixRow = matrixRows[iOutput];
                int value = 0;
                for (int iInput = 0; iInput < inputCount; iInput++) {
                    value = (value ^ table[matrixRow[iInput] & 255][inputs[iInput][iByte] & 255]) == 1 ? 1 : 0;
                }
                outputs[iOutput][iByte] = (byte) value;
            }
        }
    }
}
