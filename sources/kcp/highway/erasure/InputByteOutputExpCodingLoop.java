package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/InputByteOutputExpCodingLoop.class */
public class InputByteOutputExpCodingLoop extends CodingLoopBase {
    @Override // kcp.highway.erasure.CodingLoop
    public void codeSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] outputs, int outputCount, int offset, int byteCount) {
        byte[] inputShard = inputs[0];
        for (int iByte = offset; iByte < offset + byteCount; iByte++) {
            byte inputByte = inputShard[iByte];
            for (int iOutput = 0; iOutput < outputCount; iOutput++) {
                outputs[iOutput][iByte] = Galois.multiply(matrixRows[iOutput][0], inputByte);
            }
        }
        for (int iInput = 1; iInput < inputCount; iInput++) {
            byte[] inputShard2 = inputs[iInput];
            for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                byte inputByte2 = inputShard2[iByte2];
                for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                    byte[] outputShard = outputs[iOutput2];
                    outputShard[iByte2] = (byte) (outputShard[iByte2] ^ Galois.multiply(matrixRows[iOutput2][iInput], inputByte2));
                }
            }
        }
    }
}
