package kcp.highway.erasure.bytebuf;

import kcp.highway.erasure.Galois;
import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/erasure/bytebuf/InputOutputByteBufHeapTableCodingLoop.class */
public class InputOutputByteBufHeapTableCodingLoop extends ByteBufCodingLoopBase {
    @Override // kcp.highway.erasure.bytebuf.ByteBufCodingLoop
    public void codeSomeShards(byte[][] matrixRows, ByteBuf[] inputs, int inputCount, ByteBuf[] outputs, int outputCount, int offset, int byteCount) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        int count = offset + byteCount;
        byte[] inputShard = new byte[count];
        byte[] outputShard = new byte[count];
        inputs[0].getBytes(0, inputShard);
        for (int iOutput = 0; iOutput < outputCount; iOutput++) {
            outputs[iOutput].getBytes(0, outputShard);
            byte[] multTableRow = table[matrixRows[iOutput][0] & 255];
            for (int iByte = offset; iByte < count; iByte++) {
                outputShard[iByte] = multTableRow[inputShard[iByte] & 255];
            }
            outputs[iOutput].setBytes(0, outputShard);
        }
        for (int iInput = 1; iInput < inputCount; iInput++) {
            inputs[iInput].getBytes(0, inputShard);
            for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                outputs[iOutput2].getBytes(0, outputShard);
                byte[] multTableRow2 = table[matrixRows[iOutput2][iInput] & 255];
                for (int iByte2 = offset; iByte2 < count; iByte2++) {
                    outputShard[iByte2] = (byte) (outputShard[iByte2] ^ multTableRow2[inputShard[iByte2] & 255]);
                }
                outputs[iOutput2].setBytes(0, outputShard);
            }
        }
    }

    @Override // kcp.highway.erasure.bytebuf.ByteBufCodingLoopBase, kcp.highway.erasure.bytebuf.ByteBufCodingLoop
    public boolean checkSomeShards(byte[][] matrixRows, ByteBuf[] inputs, int inputCount, byte[][] toCheck, int checkCount, int offset, int byteCount, byte[] tempBuffer) {
        if (tempBuffer == null) {
            return checkSomeShards(matrixRows, inputs, inputCount, toCheck, checkCount, offset, byteCount, null);
        }
        int count = offset + byteCount;
        byte[] inputShard = new byte[count];
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        for (int iOutput = 0; iOutput < checkCount; iOutput++) {
            byte[] outputShard = toCheck[iOutput];
            byte[] matrixRow = matrixRows[iOutput];
            inputs[0].getBytes(0, inputShard);
            byte[] multTableRow = table[matrixRow[0] & 255];
            for (int iByte = offset; iByte < count; iByte++) {
                tempBuffer[iByte] = multTableRow[inputShard[iByte] & 255];
            }
            for (int iInput = 1; iInput < inputCount; iInput++) {
                inputs[iInput].getBytes(0, inputShard);
                byte[] multTableRow2 = table[matrixRow[iInput] & 255];
                for (int iByte2 = offset; iByte2 < count; iByte2++) {
                    tempBuffer[iByte2] = (byte) (tempBuffer[iByte2] ^ multTableRow2[inputShard[iByte2] & 255]);
                }
            }
            for (int iByte3 = offset; iByte3 < count; iByte3++) {
                if (tempBuffer[iByte3] != outputShard[iByte3]) {
                    return false;
                }
            }
        }
        return true;
    }
}
