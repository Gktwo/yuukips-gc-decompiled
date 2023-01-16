package p013io.netty.handler.codec.compression;

import p013io.netty.handler.codec.ByteToMessageDecoder;

/* renamed from: io.netty.handler.codec.compression.Bzip2Decoder */
/* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2Decoder.class */
public class Bzip2Decoder extends ByteToMessageDecoder {
    private State currentState = State.INIT;
    private final Bzip2BitReader reader = new Bzip2BitReader();
    private Bzip2BlockDecompressor blockDecompressor;
    private Bzip2HuffmanStageDecoder huffmanStageDecoder;
    private int blockSize;
    private int blockCRC;
    private int streamCRC;

    /* renamed from: io.netty.handler.codec.compression.Bzip2Decoder$State */
    /* loaded from: grasscutter.jar:io/netty/handler/codec/compression/Bzip2Decoder$State.class */
    private enum State {
        INIT,
        INIT_BLOCK,
        INIT_BLOCK_PARAMS,
        RECEIVE_HUFFMAN_USED_MAP,
        RECEIVE_HUFFMAN_USED_BITMAPS,
        RECEIVE_SELECTORS_NUMBER,
        RECEIVE_SELECTORS,
        RECEIVE_HUFFMAN_LENGTH,
        DECODE_HUFFMAN_DATA,
        EOF
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02e7, code lost:
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_LENGTH;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x02ee, code lost:
        r0 = r9.huffmanStageDecoder;
        r0 = r0.totalTables;
        r0 = r0.tableCodeLengths;
        r0 = r0.alphabetSize;
        r34 = r0.currentLength;
        r35 = 0;
        r36 = r0.modifyLength;
        r37 = false;
        r33 = r0.currentGroup;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x0328, code lost:
        if (r33 >= r0) goto L_0x03ca;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x0331, code lost:
        if (r0.hasReadableBits(5) != false) goto L_0x033a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x0334, code lost:
        r37 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x033c, code lost:
        if (r34 >= 0) goto L_0x0347;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x033f, code lost:
        r34 = r0.readBits(5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0347, code lost:
        r35 = r0.currentAlpha;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0352, code lost:
        if (r35 >= r0) goto L_0x03b5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x035a, code lost:
        if (r0.isReadable() != false) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x035d, code lost:
        r37 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0365, code lost:
        if (r36 != false) goto L_0x0370;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x036d, code lost:
        if (r0.readBoolean() == false) goto L_0x03a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0375, code lost:
        if (r0.isReadable() != false) goto L_0x0381;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0378, code lost:
        r36 = true;
        r37 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0388, code lost:
        if (r0.readBoolean() == false) goto L_0x038f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x038b, code lost:
        r1 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x038f, code lost:
        r1 = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0390, code lost:
        r34 = r34 + r1;
        r36 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x039b, code lost:
        if (r0.isReadable() != false) goto L_0x0363;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x039e, code lost:
        r37 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x03a4, code lost:
        r0[r33][r35] = (byte) r34;
        r35 = r35 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x03b5, code lost:
        r34 = -1;
        r0.currentAlpha = 0;
        r35 = 0;
        r36 = false;
        r33 = r33 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x03cc, code lost:
        if (r37 == false) goto L_0x03ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x03cf, code lost:
        r0.currentGroup = r33;
        r0.currentLength = r34;
        r0.currentAlpha = r35;
        r0.modifyLength = r36;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x03eb, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x03ec, code lost:
        r0.createHuffmanDecodingTables();
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.DECODE_HUFFMAN_DATA;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:137:0x03f8, code lost:
        r0 = r9.blockDecompressor;
        r0 = r11.readerIndex();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x0411, code lost:
        if (r0.decodeHuffmanData(r9.huffmanStageDecoder) != false) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0414, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x041b, code lost:
        if (r11.readerIndex() != r0) goto L_0x042a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x0422, code lost:
        if (r11.isReadable() == false) goto L_0x042a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0425, code lost:
        r0.refill();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x042a, code lost:
        r41 = r10.alloc().buffer(r0.blockLength());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x0440, code lost:
        r0 = r0.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x0448, code lost:
        if (r0 < 0) goto L_0x0456;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x044b, code lost:
        r41.writeByte(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0456, code lost:
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK;
        r9.streamCRC = ((r9.streamCRC << 1) | (r9.streamCRC >>> 31)) ^ r0.checkCRC();
        r12.add(r41);
        r41 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0487, code lost:
        if (0 == 0) goto L_0x04a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x048a, code lost:
        r41.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x0493, code lost:
        r44 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x0497, code lost:
        if (r41 != null) goto L_0x049a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x049a, code lost:
        r41.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x04a2, code lost:
        throw r44;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:158:0x04a3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0093, code lost:
        throw new p013io.netty.handler.codec.compression.DecompressionException("block size is invalid");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00fc, code lost:
        if (r0 != 3227993) goto L_0x0106;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0103, code lost:
        if (r0 == 2511705) goto L_0x0110;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010f, code lost:
        throw new p013io.netty.handler.codec.compression.DecompressionException("bad block header");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0110, code lost:
        r9.blockCRC = r0.readInt();
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.INIT_BLOCK_PARAMS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0127, code lost:
        if (r0.hasReadableBits(25) != false) goto L_0x012b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x012a, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x012b, code lost:
        r9.blockDecompressor = new p013io.netty.handler.codec.compression.Bzip2BlockDecompressor(r9.blockSize, r9.blockCRC, r0.readBoolean(), r0.readBits(24), r0);
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_MAP;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0162, code lost:
        if (r0.hasReadableBits(16) != false) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0165, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0166, code lost:
        r9.blockDecompressor.huffmanInUse16 = r0.readBits(16);
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_HUFFMAN_USED_BITMAPS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x017b, code lost:
        r0 = r9.blockDecompressor;
        r0 = r0.huffmanInUse16;
        r0 = java.lang.Integer.bitCount(r0);
        r0 = r0.huffmanSymbolMap;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x01a2, code lost:
        if (r0.hasReadableBits((r0 * 16) + 3) != false) goto L_0x01a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x01a5, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a6, code lost:
        r24 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01ab, code lost:
        if (r0 <= 0) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x01ae, code lost:
        r25 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x01b5, code lost:
        if (r25 >= 16) goto L_0x01f5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01c0, code lost:
        if ((r0 & (32768 >>> r25)) == 0) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c3, code lost:
        r26 = 0;
        r27 = r25 << 4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d0, code lost:
        if (r26 >= 16) goto L_0x01ef;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x01d8, code lost:
        if (r0.readBoolean() == false) goto L_0x01e6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x01db, code lost:
        r24 = r24 + 1;
        r0[r24] = (byte) r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x01e6, code lost:
        r26 = r26 + 1;
        r27 = r27 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x01ef, code lost:
        r25 = r25 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01f5, code lost:
        r0.huffmanEndOfBlockSymbol = r24 + 1;
        r0 = r0.readBits(3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0209, code lost:
        if (r0 < 2) goto L_0x0213;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0210, code lost:
        if (r0 <= 6) goto L_0x021d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x021c, code lost:
        throw new p013io.netty.handler.codec.compression.DecompressionException("incorrect huffman groups number");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x021d, code lost:
        r0 = r24 + 2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0228, code lost:
        if (r0 <= 258) goto L_0x0235;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0234, code lost:
        throw new p013io.netty.handler.codec.compression.DecompressionException("incorrect alphabet size");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0235, code lost:
        r9.huffmanStageDecoder = new p013io.netty.handler.codec.compression.Bzip2HuffmanStageDecoder(r0, r0, r0);
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS_NUMBER;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0254, code lost:
        if (r0.hasReadableBits(15) != false) goto L_0x0258;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0257, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0258, code lost:
        r0 = r0.readBits(15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0264, code lost:
        if (r0 < 1) goto L_0x026f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x026c, code lost:
        if (r0 <= 18002) goto L_0x0279;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0278, code lost:
        throw new p013io.netty.handler.codec.compression.DecompressionException("incorrect selectors number");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x0279, code lost:
        r9.huffmanStageDecoder.selectors = new byte[r0];
        r9.currentState = p013io.netty.handler.codec.compression.Bzip2Decoder.State.RECEIVE_SELECTORS;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x028b, code lost:
        r0 = r9.huffmanStageDecoder;
        r0 = r0.selectors;
        r0 = r0.length;
        r0 = r0.tableMTF;
        r31 = r0.currentSelector;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x02af, code lost:
        if (r31 >= r0) goto L_0x02e7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x02b9, code lost:
        if (r0.hasReadableBits(6) != false) goto L_0x02c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x02bc, code lost:
        r0.currentSelector = r31;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x02c3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x02c4, code lost:
        r32 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x02cc, code lost:
        if (r0.readBoolean() == false) goto L_0x02d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x02cf, code lost:
        r32 = r32 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x02d5, code lost:
        r0[r31] = r0.indexToFront(r32);
        r31 = r31 + 1;
     */
    @Override // p013io.netty.handler.codec.ByteToMessageDecoder
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void decode(p013io.netty.channel.ChannelHandlerContext r10, p013io.netty.buffer.ByteBuf r11, java.util.List<java.lang.Object> r12) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 1206
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.netty.handler.codec.compression.Bzip2Decoder.decode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, java.util.List):void");
    }

    public boolean isClosed() {
        return this.currentState == State.EOF;
    }
}
