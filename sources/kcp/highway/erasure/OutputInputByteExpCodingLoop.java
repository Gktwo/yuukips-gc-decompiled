package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/OutputInputByteExpCodingLoop.class */
public class OutputInputByteExpCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        for (int iOutput = 0; iOutput < outputCount; iOutput++) {
            byte[] outputShard = outputs[iOutput];
            byte[] matrixRow = matrixRows[iOutput];
            byte[] inputShard = inputs[0];
            byte matrixByte = matrixRow[0];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                outputShard[iByte] = Galois.multiply(matrixByte, inputShard[iByte]);
            }
            for (int iInput = 1; iInput < inputCount; iInput++) {
                byte[] inputShard2 = inputs[iInput];
                byte matrixByte2 = matrixRow[iInput];
                for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                    outputShard[iByte2] = (byte) (outputShard[iByte2] ^ Galois.multiply(matrixByte2, inputShard2[iByte2]));
                }
            }
        }
    }
}
