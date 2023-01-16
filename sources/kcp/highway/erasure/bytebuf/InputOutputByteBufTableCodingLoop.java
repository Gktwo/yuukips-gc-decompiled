package kcp.highway.erasure.bytebuf;

import kcp.highway.erasure.Galois;
import p013io.netty.buffer.ByteBuf;

/* loaded from: grasscutter.jar:kcp/highway/erasure/bytebuf/InputOutputByteBufTableCodingLoop.class */
public class InputOutputByteBufTableCodingLoop extends ByteBufCodingLoopBase {
    @Override // kcp.highway.erasure.bytebuf.ByteBufCodingLoop
    public void codeSomeShards(byte[][] matrixRows, ByteBuf[] inputs, int inputCount, ByteBuf[] outputs, int outputCount, int offset, int byteCount) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        ByteBuf inputShard = inputs[0];
        for (int iOutput = 0; iOutput < outputCount; iOutput++) {
            ByteBuf outputShard = outputs[iOutput];
            byte[] multTableRow = table[matrixRows[iOutput][0] & 255];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                outputShard.setByte(iByte, multTableRow[inputShard.getByte(iByte) & 255]);
            }
        }
        for (int iInput = 1; iInput < inputCount; iInput++) {
            ByteBuf inputShard2 = inputs[iInput];
            for (int iOutput2 = 0; iOutput2 < outputCount; iOutput2++) {
                ByteBuf outputShard2 = outputs[iOutput2];
                byte[] multTableRow2 = table[matrixRows[iOutput2][iInput] & 255];
                for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                    outputShard2.setByte(iByte2, (byte) (outputShard2.getByte(iByte2) ^ multTableRow2[inputShard2.getByte(iByte2) & 255]));
                }
            }
        }
    }

    @Override // kcp.highway.erasure.bytebuf.ByteBufCodingLoopBase, kcp.highway.erasure.bytebuf.ByteBufCodingLoop
    public boolean checkSomeShards(byte[][] matrixRows, ByteBuf[] inputs, int inputCount, byte[][] toCheck, int checkCount, int offset, int byteCount, byte[] tempBuffer) {
        if (tempBuffer == null) {
            return checkSomeShards(matrixRows, inputs, inputCount, toCheck, checkCount, offset, byteCount, null);
        }
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        for (int iOutput = 0; iOutput < checkCount; iOutput++) {
            byte[] outputShard = toCheck[iOutput];
            byte[] matrixRow = matrixRows[iOutput];
            ByteBuf inputShard = inputs[0];
            byte[] multTableRow = table[matrixRow[0] & 255];
            for (int iByte = offset; iByte < offset + byteCount; iByte++) {
                tempBuffer[iByte] = multTableRow[inputShard.getByte(iByte) & 255];
            }
            for (int iInput = 1; iInput < inputCount; iInput++) {
                ByteBuf inputShard2 = inputs[iInput];
                byte[] multTableRow2 = table[matrixRow[iInput] & 255];
                for (int iByte2 = offset; iByte2 < offset + byteCount; iByte2++) {
                    tempBuffer[iByte2] = (byte) (tempBuffer[iByte2] ^ multTableRow2[inputShard2.getByte(iByte2) & 255]);
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
