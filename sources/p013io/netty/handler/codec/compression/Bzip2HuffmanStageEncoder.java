package p013io.netty.handler.codec.compression;

import java.util.Arrays;
import p013io.netty.buffer.ByteBuf;

/* access modifiers changed from: package-private */
/* renamed from: io.netty.handler.codec.compression.Bzip2HuffmanStageEncoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2HuffmanStageEncoder.class */
public final class Bzip2HuffmanStageEncoder {
    private static final int HUFFMAN_HIGH_SYMBOL_COST = 15;
    private final Bzip2BitWriter writer;
    private final char[] mtfBlock;
    private final int mtfLength;
    private final int mtfAlphabetSize;
    private final int[] mtfSymbolFrequencies;
    private final int[][] huffmanCodeLengths;
    private final int[][] huffmanMergedCodeSymbols;
    private final byte[] selectors;

    /* JADX WARN: Type inference failed for: r1v6, types: [int[][][][], int[][]] */
    /* JADX WARN: Type inference failed for: r1v8, types: [int[][][][], int[][]] */
    /* access modifiers changed from: package-private */
    public Bzip2HuffmanStageEncoder(Bzip2BitWriter writer, char[] mtfBlock, int mtfLength, int mtfAlphabetSize, int[] mtfSymbolFrequencies) {
        this.writer = writer;
        this.mtfBlock = mtfBlock;
        this.mtfLength = mtfLength;
        this.mtfAlphabetSize = mtfAlphabetSize;
        this.mtfSymbolFrequencies = mtfSymbolFrequencies;
        int totalTables = selectTableCount(mtfLength);
        this.huffmanCodeLengths = new int[totalTables][mtfAlphabetSize][];
        this.huffmanMergedCodeSymbols = new int[totalTables][mtfAlphabetSize][];
        this.selectors = new byte[((mtfLength + 50) - 1) / 50];
    }

    private static int selectTableCount(int mtfLength) {
        if (mtfLength >= 2400) {
            return 6;
        }
        if (mtfLength >= 1200) {
            return 5;
        }
        if (mtfLength >= 600) {
            return 4;
        }
        if (mtfLength >= 200) {
            return 3;
        }
        return 2;
    }

    private static void generateHuffmanCodeLengths(int alphabetSize, int[] symbolFrequencies, int[] codeLengths) {
        int[] mergedFrequenciesAndIndices = new int[alphabetSize];
        int[] sortedFrequencies = new int[alphabetSize];
        for (int i = 0; i < alphabetSize; i++) {
            mergedFrequenciesAndIndices[i] = (symbolFrequencies[i] << 9) | i;
        }
        Arrays.sort(mergedFrequenciesAndIndices);
        for (int i2 = 0; i2 < alphabetSize; i2++) {
            sortedFrequencies[i2] = mergedFrequenciesAndIndices[i2] >>> 9;
        }
        Bzip2HuffmanAllocator.allocateHuffmanCodeLengths(sortedFrequencies, 20);
        for (int i3 = 0; i3 < alphabetSize; i3++) {
            codeLengths[mergedFrequenciesAndIndices[i3] & 511] = sortedFrequencies[i3];
        }
    }

    private void generateHuffmanOptimisationSeeds() {
        int[][] huffmanCodeLengths = this.huffmanCodeLengths;
        int[] mtfSymbolFrequencies = this.mtfSymbolFrequencies;
        int mtfAlphabetSize = this.mtfAlphabetSize;
        int totalTables = huffmanCodeLengths.length;
        int remainingLength = this.mtfLength;
        int lowCostEnd = -1;
        for (int i = 0; i < totalTables; i++) {
            int targetCumulativeFrequency = remainingLength / (totalTables - i);
            int lowCostStart = lowCostEnd + 1;
            int actualCumulativeFrequency = 0;
            while (actualCumulativeFrequency < targetCumulativeFrequency && lowCostEnd < mtfAlphabetSize - 1) {
                lowCostEnd++;
                actualCumulativeFrequency += mtfSymbolFrequencies[lowCostEnd];
            }
            if (lowCostEnd > lowCostStart && i != 0 && i != totalTables - 1 && ((totalTables - i) & 1) == 0) {
                lowCostEnd--;
                actualCumulativeFrequency -= mtfSymbolFrequencies[lowCostEnd];
            }
            int[] tableCodeLengths = huffmanCodeLengths[i];
            for (int j = 0; j < mtfAlphabetSize; j++) {
                if (j < lowCostStart || j > lowCostEnd) {
                    tableCodeLengths[j] = 15;
                }
            }
            remainingLength -= actualCumulativeFrequency;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v13, resolved type: int[][][][] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v4, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v36, resolved type: int[] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v6, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    private void optimiseSelectorsAndHuffmanTables(boolean storeSelectors) {
        char[] mtfBlock = this.mtfBlock;
        byte[] selectors = this.selectors;
        int[][] huffmanCodeLengths = this.huffmanCodeLengths;
        int mtfLength = this.mtfLength;
        int mtfAlphabetSize = this.mtfAlphabetSize;
        int totalTables = huffmanCodeLengths.length;
        int[][][][] iArr = new int[totalTables][mtfAlphabetSize][];
        int selectorIndex = 0;
        int groupStart = 0;
        while (groupStart < mtfLength) {
            int groupEnd = Math.min(groupStart + 50, mtfLength) - 1;
            int[] cost = new int[totalTables];
            for (int i = groupStart; i <= groupEnd; i++) {
                char c = mtfBlock[i];
                for (int j = 0; j < totalTables; j++) {
                    cost[j] = cost[j] + huffmanCodeLengths[j][c];
                }
            }
            byte bestTable = 0;
            int bestCost = cost[0];
            for (byte i2 = 1; i2 < totalTables; i2 = (byte) (i2 + 1)) {
                int tableCost = cost[i2];
                if (tableCost < bestCost) {
                    bestCost = tableCost;
                    bestTable = i2;
                }
            }
            int[] bestGroupFrequencies = iArr[bestTable];
            for (int i3 = groupStart; i3 <= groupEnd; i3++) {
                char c2 = mtfBlock[i3];
                bestGroupFrequencies[c2] = bestGroupFrequencies[c2] + 1;
            }
            if (storeSelectors) {
                selectorIndex++;
                selectors[selectorIndex] = bestTable;
            }
            groupStart = groupEnd + 1;
        }
        for (int i4 = 0; i4 < totalTables; i4++) {
            generateHuffmanCodeLengths(mtfAlphabetSize, iArr[i4], huffmanCodeLengths[i4]);
        }
    }

    private void assignHuffmanCodeSymbols() {
        int[][] huffmanMergedCodeSymbols = this.huffmanMergedCodeSymbols;
        int[][] huffmanCodeLengths = this.huffmanCodeLengths;
        int mtfAlphabetSize = this.mtfAlphabetSize;
        int totalTables = huffmanCodeLengths.length;
        for (int i = 0; i < totalTables; i++) {
            int[] tableLengths = huffmanCodeLengths[i];
            int minimumLength = 32;
            int maximumLength = 0;
            for (int j = 0; j < mtfAlphabetSize; j++) {
                int length = tableLengths[j];
                if (length > maximumLength) {
                    maximumLength = length;
                }
                if (length < minimumLength) {
                    minimumLength = length;
                }
            }
            int code = 0;
            for (int j2 = minimumLength; j2 <= maximumLength; j2++) {
                for (int k = 0; k < mtfAlphabetSize; k++) {
                    if ((huffmanCodeLengths[i][k] & 255) == j2) {
                        huffmanMergedCodeSymbols[i][k] = (j2 << 24) | code;
                        code++;
                    }
                }
                code <<= 1;
            }
        }
    }

    private void writeSelectorsAndHuffmanTables(ByteBuf out) {
        Bzip2BitWriter writer = this.writer;
        byte[] selectors = this.selectors;
        int totalSelectors = selectors.length;
        int[][] huffmanCodeLengths = this.huffmanCodeLengths;
        int totalTables = huffmanCodeLengths.length;
        int mtfAlphabetSize = this.mtfAlphabetSize;
        writer.writeBits(out, 3, (long) totalTables);
        writer.writeBits(out, 15, (long) totalSelectors);
        Bzip2MoveToFrontTable selectorMTF = new Bzip2MoveToFrontTable();
        for (byte selector : selectors) {
            writer.writeUnary(out, selectorMTF.valueToFront(selector));
        }
        for (int[] tableLengths : huffmanCodeLengths) {
            int currentLength = tableLengths[0];
            writer.writeBits(out, 5, (long) currentLength);
            for (int j = 0; j < mtfAlphabetSize; j++) {
                int codeLength = tableLengths[j];
                int value = currentLength < codeLength ? 2 : 3;
                int delta = Math.abs(codeLength - currentLength);
                while (true) {
                    delta--;
                    if (delta > 0) {
                        writer.writeBits(out, 2, (long) value);
                    }
                }
                writer.writeBoolean(out, false);
                currentLength = codeLength;
            }
        }
    }

    private void writeBlockData(ByteBuf out) {
        Bzip2BitWriter writer = this.writer;
        int[][] huffmanMergedCodeSymbols = this.huffmanMergedCodeSymbols;
        byte[] selectors = this.selectors;
        int mtfLength = this.mtfLength;
        int selectorIndex = 0;
        int mtfIndex = 0;
        while (mtfIndex < mtfLength) {
            int groupEnd = Math.min(mtfIndex + 50, mtfLength) - 1;
            selectorIndex++;
            int[] tableMergedCodeSymbols = huffmanMergedCodeSymbols[selectors[selectorIndex]];
            while (mtfIndex <= groupEnd) {
                mtfIndex++;
                int mergedCodeSymbol = tableMergedCodeSymbols[this.mtfBlock[mtfIndex]];
                writer.writeBits(out, mergedCodeSymbol >>> 24, (long) mergedCodeSymbol);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void encode(ByteBuf out) {
        generateHuffmanOptimisationSeeds();
        int i = 3;
        while (i >= 0) {
            optimiseSelectorsAndHuffmanTables(i == 0);
            i--;
        }
        assignHuffmanCodeSymbols();
        writeSelectorsAndHuffmanTables(out);
        writeBlockData(out);
    }
}
