package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/OutputByteInputExpCodingLoop.class */
public class OutputByteInputExpCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        for (int iOutput = 0; iOutput < outputCount; iOutput++) {
            byte[] outputShard = outputs[iOutput];
            byte[] matrixRow = matrixRows[iOutput];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                int value = 0;
                for (int iInput = 0; iInput < inputCount; iInput++) {
                    value ^= Galois.multiply(matrixRow[iInput], inputs[iInput][iByte]);
                }
                outputShard[iByte] = (byte) value;
            }
        }
    }
}
