package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/InputOutputByteTableCodingLoop.class */
public class InputOutputByteTableCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        byte[] inputShard = inputs[0];
        for (int iOutput = 0; iOutput < outputCount; iOutput++) {
            byte[] outputShard = outputs[iOutput];
            byte[] multTableRow = table[matrixRows[iOutput][0] & 255];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                outputShard[iByte] = multTableRow[inputShard[iByte] & 255];
            }
        }
        for (int iInput = 1; iInput < inputCount; iInput++) {
            byte[] inputShard2 = inputs[iInput];
            for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                byte[] outputShard2 = outputs[iOutput2];
                byte[] multTableRow2 = table[matrixRows[iOutput2][iInput] & 255];
                for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                    outputShard2[iByte2] = (byte) (outputShard2[iByte2] ^ multTableRow2[inputShard2[iByte2] & 255]);
                }
            }
        }
    }

    @Override // kcp.highway.erasure.CodingLoopBase, kcp.highway.erasure.CodingLoop
    public boolean checkSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] toCheck, int checkCount, int offset, int byteCount, byte[] tempBuffer) {
        if (tempBuffer == null) {
            return checkSomeShards(matrixRows, inputs, inputCount, toCheck, checkCount, offset, byteCount, null);
        }
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        for (int iOutput = 0; iOutput < checkCount; iOutput++) {
            byte[] outputShard = toCheck[iOutput];
            byte[] matrixRow = matrixRows[iOutput];
            byte[] inputShard = inputs[0];
            byte[] multTableRow = table[matrixRow[0] & 255];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                tempBuffer[iByte] = multTableRow[inputShard[iByte] & 255];
            }
            for (int iInput = 1; iInput < inputCount; iInput++) {
                byte[] inputShard2 = inputs[iInput];
                byte[] multTableRow2 = table[matrixRow[iInput] & 255];
                for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                    tempBuffer[iByte2] = (byte) (tempBuffer[iByte2] ^ multTableRow2[inputShard2[iByte2] & 255]);
                }
            }
            for (int iByte3 = offset; iByte3 < offset + byteCount; iByte3++) {
                if (tempBuffer[iByte3] != outputShard[iByte3]) {
                    return false;
                }
            }
        }
        return true;
    }
}
