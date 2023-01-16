package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/ByteInputOutputTableCodingLoop.class */
public class ByteInputOutputTableCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        for (int iByte = offset; iByte < offset + byteCount; iByte++) {
            byte inputByte = inputs[0][iByte];
            for (int iOutput = 0; iOutput < outputCount; iOutput++) {
                outputs[iOutput][iByte] = table[matrixRows[iOutput][0] & 255][inputByte & 255];
            }
            for (int iInput = 1; iInput < inputCount; iInput++) {
                byte inputByte2 = inputs[iInput][iByte];
                for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                    byte[] outputShard = outputs[iOutput2];
                    outputShard[iByte] = (byte) (outputShard[iByte] ^ table[matrixRows[iOutput2][iInput] & 255][inputByte2 & 255]);
                }
            }
        }
    }
}
