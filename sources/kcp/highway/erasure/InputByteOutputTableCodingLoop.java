package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/InputByteOutputTableCodingLoop.class */
public class InputByteOutputTableCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        byte[] inputShard = inputs[0];
        for (int iByte = offset; iByte < offset + byteCount; iByte++) {
            byte[] multTableRow = table[inputShard[iByte] & 255];
            for (int iOutput = 0; iOutput < outputCount; iOutput++) {
                outputs[iOutput][iByte] = multTableRow[matrixRows[iOutput][0] & 255];
            }
        }
        for (int iInput = 1; iInput < inputCount; iInput++) {
            byte[] inputShard2 = inputs[iInput];
            for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                byte[] multTableRow2 = table[inputShard2[iByte2] & 255];
                for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                    byte[] outputShard = outputs[iOutput2];
                    outputShard[iByte2] = (byte) (outputShard[iByte2] ^ multTableRow2[matrixRows[iOutput2][iInput] & 255]);
                }
            }
        }
    }
}
