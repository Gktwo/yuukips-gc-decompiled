package p013io.netty.handler.codec.compression;

import emu.grasscutter.net.packet.PacketOpcodes;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.codec.compression.Bzip2MTFAndRLE2StageEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2MTFAndRLE2StageEncoder.class */
public final class Bzip2MTFAndRLE2StageEncoder {
    private final int[] bwtBlock;
    private final int bwtLength;
    private final boolean[] bwtValuesPresent;
    private final char[] mtfBlock;
    private int mtfLength;
    private final int[] mtfSymbolFrequencies = new int[PacketOpcodes.SceneAreaUnlockNotify];
    private int alphabetSize;

    /* access modifiers changed from: package-private */
    public Bzip2MTFAndRLE2StageEncoder(int[] bwtBlock, int bwtLength, boolean[] bwtValuesPresent) {
        this.bwtBlock = bwtBlock;
        this.bwtLength = bwtLength;
        this.bwtValuesPresent = bwtValuesPresent;
        this.mtfBlock = new char[bwtLength + 1];
    }

    /* access modifiers changed from: package-private */
    public void encode() {
        int bwtLength = this.bwtLength;
        boolean[] bwtValuesPresent = this.bwtValuesPresent;
        int[] bwtBlock = this.bwtBlock;
        char[] mtfBlock = this.mtfBlock;
        int[] mtfSymbolFrequencies = this.mtfSymbolFrequencies;
        byte[] huffmanSymbolMap = new byte[256];
        Bzip2MoveToFrontTable symbolMTF = new Bzip2MoveToFrontTable();
        int totalUniqueValues = 0;
        for (int i = 0; i < huffmanSymbolMap.length; i++) {
            if (bwtValuesPresent[i]) {
                totalUniqueValues++;
                huffmanSymbolMap[i] = (byte) totalUniqueValues;
            }
        }
        int endOfBlockSymbol = totalUniqueValues + 1;
        int mtfIndex = 0;
        int repeatCount = 0;
        int totalRunAs = 0;
        int totalRunBs = 0;
        for (int i2 = 0; i2 < bwtLength; i2++) {
            int mtfPosition = symbolMTF.valueToFront(huffmanSymbolMap[bwtBlock[i2] & 255]);
            if (mtfPosition == 0) {
                repeatCount++;
            } else {
                if (repeatCount > 0) {
                    int repeatCount2 = repeatCount - 1;
                    while (true) {
                        if ((repeatCount2 & 1) == 0) {
                            mtfIndex++;
                            mtfBlock[mtfIndex] = 0;
                            totalRunAs++;
                        } else {
                            mtfIndex++;
                            mtfBlock[mtfIndex] = 1;
                            totalRunBs++;
                        }
                        if (repeatCount2 <= 1) {
                            break;
                        }
                        repeatCount2 = (repeatCount2 - 2) >>> 1;
                    }
                    repeatCount = 0;
                }
                mtfIndex++;
                mtfBlock[mtfIndex] = (char) (mtfPosition + 1);
                int i3 = mtfPosition + 1;
                mtfSymbolFrequencies[i3] = mtfSymbolFrequencies[i3] + 1;
            }
        }
        if (repeatCount > 0) {
            int repeatCount3 = repeatCount - 1;
            while (true) {
                if ((repeatCount3 & 1) == 0) {
                    mtfIndex++;
                    mtfBlock[mtfIndex] = 0;
                    totalRunAs++;
                } else {
                    mtfIndex++;
                    mtfBlock[mtfIndex] = 1;
                    totalRunBs++;
                }
                if (repeatCount3 <= 1) {
                    break;
                }
                repeatCount3 = (repeatCount3 - 2) >>> 1;
            }
        }
        mtfBlock[mtfIndex] = (char) endOfBlockSymbol;
        mtfSymbolFrequencies[endOfBlockSymbol] = mtfSymbolFrequencies[endOfBlockSymbol] + 1;
        mtfSymbolFrequencies[0] = mtfSymbolFrequencies[0] + totalRunAs;
        mtfSymbolFrequencies[1] = mtfSymbolFrequencies[1] + totalRunBs;
        this.mtfLength = mtfIndex + 1;
        this.alphabetSize = endOfBlockSymbol + 1;
    }

    /* access modifiers changed from: package-private */
    public char[] mtfBlock() {
        return this.mtfBlock;
    }

    /* access modifiers changed from: package-private */
    public int mtfLength() {
        return this.mtfLength;
    }

    /* access modifiers changed from: package-private */
    public int mtfAlphabetSize() {
        return this.alphabetSize;
    }

    /* access modifiers changed from: package-private */
    public int[] mtfSymbolFrequencies() {
        return this.mtfSymbolFrequencies;
    }
}
