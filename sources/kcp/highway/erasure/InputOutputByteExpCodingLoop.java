package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/InputOutputByteExpCodingLoop.class */
public class InputOutputByteExpCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        byte[] inputShard = inputs[0];
        for (int iOutput = 0; iOutput < outputCount; iOutput++) {
            byte[] outputShard = outputs[iOutput];
            byte matrixByte = matrixRows[iOutput][0];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                outputShard[iByte] = Galois.multiply(matrixByte, inputShard[iByte]);
            }
        }
        for (int iInput = 1; iInput < inputCount; iInput++) {
            byte[] inputShard2 = inputs[iInput];
            for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                byte[] outputShard2 = outputs[iOutput2];
                byte matrixByte2 = matrixRows[iOutput2][iInput];
                for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                    outputShard2[iByte2] = (byte) (outputShard2[iByte2] ^ Galois.multiply(matrixByte2, inputShard2[iByte2]));
                }
            }
        }
    }
}
