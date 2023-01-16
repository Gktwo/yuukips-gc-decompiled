package kcp.highway.erasure;

/* loaded from: grasscutter.jar:kcp/highway/erasure/CodingLoopBase.class */
public abstract class CodingLoopBase implements CodingLoop {
    /* JADX DEBUG: Multi-variable search result rejected for r0v16, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kcp.highway.erasure.CodingLoop
    public boolean checkSomeShards(byte[][] matrixRows, byte[][] inputs, int inputCount, byte[][] toCheck, int checkCount, int offset, int byteCount, byte[] tempBuffer) {
        byte[][] table = Galois.MULTIPLICATION_TABLE;
        for (int iByte = offset; iByte < offset + byteCount; iByte++) {
            for (int iOutput = 0; iOutput < checkCount; iOutput++) {
                byte[] matrixRow = matrixRows[iOutput];
                int value = 0;
                for (int iInput = 0; iInput < inputCount; iInput++) {
                    value = (value ^ table[matrixRow[iInput] & 255][inputs[iInput][iByte] & 255]) == 1 ? 1 : 0;
                }
                if (toCheck[iOutput][iByte] != ((byte) value)) {
                    return false;
                }
            }
        }
        return true;
    }
}
