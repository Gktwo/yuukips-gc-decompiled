package p013io.netty.handler.codec.compression;

import emu.grasscutter.net.packet.PacketOpcodes;

/* renamed from: io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2HuffmanStageDecoder.class */
final class Bzip2HuffmanStageDecoder {
    private final Bzip2BitReader reader;
    byte[] selectors;
    private final int[] minimumLengths;
    private final int[][] codeBases;
    private final int[][] codeLimits;
    private final int[][] codeSymbols;
    private int currentTable;
    final int totalTables;
    final int alphabetSize;
    int currentSelector;
    final byte[][] tableCodeLengths;
    int currentGroup;
    int currentAlpha;
    boolean modifyLength;
    private int groupIndex = -1;
    private int groupPosition = -1;
    final Bzip2MoveToFrontTable tableMTF = new Bzip2MoveToFrontTable();
    int currentLength = -1;

    /* JADX WARN: Type inference failed for: r1v10, types: [int[][][][], int[][]] */
    /* JADX WARN: Type inference failed for: r1v12, types: [int[][][][], int[][]] */
    /* JADX WARN: Type inference failed for: r1v14, types: [int[][][][], int[][]] */
    /* JADX WARN: Type inference failed for: r1v16, types: [byte[][][][], byte[][]] */
    /* access modifiers changed from: package-private */
    public Bzip2HuffmanStageDecoder(Bzip2BitReader reader, int totalTables, int alphabetSize) {
        this.reader = reader;
        this.totalTables = totalTables;
        this.alphabetSize = alphabetSize;
        this.minimumLengths = new int[totalTables];
        this.codeBases = new int[totalTables][25][];
        this.codeLimits = new int[totalTables][24][];
        this.codeSymbols = new int[totalTables][PacketOpcodes.SceneAreaUnlockNotify][];
        this.tableCodeLengths = new byte[totalTables][PacketOpcodes.SceneAreaUnlockNotify][];
    }

    /* access modifiers changed from: package-private */
    public void createHuffmanDecodingTables() {
        int alphabetSize = this.alphabetSize;
        for (int table = 0; table < this.tableCodeLengths.length; table++) {
            int[] tableBases = this.codeBases[table];
            int[] tableLimits = this.codeLimits[table];
            int[] tableSymbols = this.codeSymbols[table];
            byte[] codeLengths = this.tableCodeLengths[table];
            int minimumLength = 23;
            int maximumLength = 0;
            for (int i = 0; i < alphabetSize; i++) {
                byte currLength = codeLengths[i];
                maximumLength = Math.max((int) currLength, maximumLength);
                minimumLength = Math.min((int) currLength, minimumLength);
            }
            this.minimumLengths[table] = minimumLength;
            for (int i2 = 0; i2 < alphabetSize; i2++) {
                int i3 = codeLengths[i2] + 1;
                tableBases[i3] = tableBases[i3] + 1;
            }
            int b = tableBases[0];
            for (int i4 = 1; i4 < 25; i4++) {
                b += tableBases[i4];
                tableBases[i4] = b;
            }
            int code = 0;
            for (int i5 = minimumLength; i5 <= maximumLength; i5++) {
                int code2 = code + (tableBases[i5 + 1] - tableBases[i5]);
                tableBases[i5] = code - tableBases[i5];
                tableLimits[i5] = code2 - 1;
                code = code2 << 1;
            }
            int codeIndex = 0;
            for (int bitLength = minimumLength; bitLength <= maximumLength; bitLength++) {
                for (int symbol = 0; symbol < alphabetSize; symbol++) {
                    if (codeLengths[symbol] == bitLength) {
                        codeIndex++;
                        tableSymbols[codeIndex] = symbol;
                    }
                }
            }
        }
        this.currentTable = this.selectors[0];
    }

    /* access modifiers changed from: package-private */
    public int nextSymbol() {
        int i = this.groupPosition + 1;
        this.groupPosition = i;
        if (i % 50 == 0) {
            this.groupIndex++;
            if (this.groupIndex == this.selectors.length) {
                throw new DecompressionException("error decoding block");
            }
            this.currentTable = this.selectors[this.groupIndex] & 255;
        }
        Bzip2BitReader reader = this.reader;
        int currentTable = this.currentTable;
        int[] tableLimits = this.codeLimits[currentTable];
        int[] tableBases = this.codeBases[currentTable];
        int[] tableSymbols = this.codeSymbols[currentTable];
        int codeLength = this.minimumLengths[currentTable];
        int codeBits = reader.readBits(codeLength);
        while (codeLength <= 23) {
            if (codeBits <= tableLimits[codeLength]) {
                return tableSymbols[codeBits - tableBases[codeLength]];
            }
            codeBits = (codeBits << 1) | reader.readBits(1);
            codeLength++;
        }
        throw new DecompressionException("a valid code was not recognised");
    }
}
