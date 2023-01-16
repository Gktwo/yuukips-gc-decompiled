package com.fasterxml.jackson.core.p003io;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Arrays;

/* renamed from: com.fasterxml.jackson.core.io.CharTypes */
/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/CharTypes.class */
public final class CharTypes {

    /* renamed from: HC */
    protected static final char[] f216HC = "0123456789ABCDEF".toCharArray();

    /* renamed from: HB */
    protected static final byte[] f217HB;
    protected static final int[] sInputCodes;
    protected static final int[] sInputCodesUTF8;
    protected static final int[] sInputCodesJsNames;
    protected static final int[] sInputCodesUtf8JsNames;
    protected static final int[] sInputCodesComment;
    protected static final int[] sInputCodesWS;
    protected static final int[] sOutputEscapes128;
    protected static final int[] sHexValues;

    static {
        int code;
        int len = f216HC.length;
        f217HB = new byte[len];
        for (int i = 0; i < len; i++) {
            f217HB[i] = (byte) f216HC[i];
        }
        int[] table = new int[256];
        for (int i2 = 0; i2 < 32; i2++) {
            table[i2] = -1;
        }
        table[34] = 1;
        table[92] = 1;
        sInputCodes = table;
        int[] table2 = new int[sInputCodes.length];
        System.arraycopy(sInputCodes, 0, table2, 0, table2.length);
        for (int c = 128; c < 256; c++) {
            if ((c & PacketOpcodes.WorldPlayerLocationNotify) == 192) {
                code = 2;
            } else if ((c & PacketOpcodes.ExecuteGadgetLuaRsp) == 224) {
                code = 3;
            } else if ((c & PacketOpcodes.ScenePlayerLocationNotify) == 240) {
                code = 4;
            } else {
                code = -1;
            }
            table2[c] = code;
        }
        sInputCodesUTF8 = table2;
        int[] table3 = new int[256];
        Arrays.fill(table3, -1);
        for (int i3 = 33; i3 < 256; i3++) {
            if (Character.isJavaIdentifierPart((char) i3)) {
                table3[i3] = 0;
            }
        }
        table3[64] = 0;
        table3[35] = 0;
        table3[42] = 0;
        table3[45] = 0;
        table3[43] = 0;
        sInputCodesJsNames = table3;
        int[] table4 = new int[256];
        System.arraycopy(sInputCodesJsNames, 0, table4, 0, table4.length);
        Arrays.fill(table4, 128, 128, 0);
        sInputCodesUtf8JsNames = table4;
        int[] buf = new int[256];
        System.arraycopy(sInputCodesUTF8, 128, buf, 128, 128);
        Arrays.fill(buf, 0, 32, -1);
        buf[9] = 0;
        buf[10] = 10;
        buf[13] = 13;
        buf[42] = 42;
        sInputCodesComment = buf;
        int[] buf2 = new int[256];
        System.arraycopy(sInputCodesUTF8, 128, buf2, 128, 128);
        Arrays.fill(buf2, 0, 32, -1);
        buf2[32] = 1;
        buf2[9] = 1;
        buf2[10] = 10;
        buf2[13] = 13;
        buf2[47] = 47;
        buf2[35] = 35;
        sInputCodesWS = buf2;
        int[] table5 = new int[128];
        for (int i4 = 0; i4 < 32; i4++) {
            table5[i4] = -1;
        }
        table5[34] = 34;
        table5[92] = 92;
        table5[8] = 98;
        table5[9] = 116;
        table5[12] = 102;
        table5[10] = 110;
        table5[13] = 114;
        sOutputEscapes128 = table5;
        sHexValues = new int[256];
        Arrays.fill(sHexValues, -1);
        for (int i5 = 0; i5 < 10; i5++) {
            sHexValues[48 + i5] = i5;
        }
        for (int i6 = 0; i6 < 6; i6++) {
            sHexValues[97 + i6] = 10 + i6;
            sHexValues[65 + i6] = 10 + i6;
        }
    }

    public static int[] getInputCodeLatin1() {
        return sInputCodes;
    }

    public static int[] getInputCodeUtf8() {
        return sInputCodesUTF8;
    }

    public static int[] getInputCodeLatin1JsNames() {
        return sInputCodesJsNames;
    }

    public static int[] getInputCodeUtf8JsNames() {
        return sInputCodesUtf8JsNames;
    }

    public static int[] getInputCodeComment() {
        return sInputCodesComment;
    }

    public static int[] getInputCodeWS() {
        return sInputCodesWS;
    }

    public static int[] get7BitOutputEscapes() {
        return sOutputEscapes128;
    }

    public static int[] get7BitOutputEscapes(int quoteChar) {
        if (quoteChar == 34) {
            return sOutputEscapes128;
        }
        return AltEscapes.instance.escapesFor(quoteChar);
    }

    public static int charToHex(int ch) {
        return sHexValues[ch & 255];
    }

    public static char hexToChar(int ch) {
        return f216HC[ch];
    }

    public static void appendQuoted(StringBuilder sb, String content) {
        int[] escCodes = sOutputEscapes128;
        int escLen = escCodes.length;
        int len = content.length();
        for (int i = 0; i < len; i++) {
            char c = content.charAt(i);
            if (c >= escLen || escCodes[c] == 0) {
                sb.append(c);
            } else {
                sb.append('\\');
                int escCode = escCodes[c];
                if (escCode < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    sb.append(f216HC[c >> 4]);
                    sb.append(f216HC[c & 15]);
                } else {
                    sb.append((char) escCode);
                }
            }
        }
    }

    public static char[] copyHexChars() {
        return (char[]) f216HC.clone();
    }

    public static byte[] copyHexBytes() {
        return (byte[]) f217HB.clone();
    }

    /* renamed from: com.fasterxml.jackson.core.io.CharTypes$AltEscapes */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/core/io/CharTypes$AltEscapes.class */
    private static class AltEscapes {
        public static final AltEscapes instance = new AltEscapes();
        private int[][] _altEscapes = new int[128];

        private AltEscapes() {
        }

        public int[] escapesFor(int quoteChar) {
            int[] esc = this._altEscapes[quoteChar];
            if (esc == null) {
                esc = Arrays.copyOf(CharTypes.sOutputEscapes128, 128);
                if (esc[quoteChar] == 0) {
                    esc[quoteChar] = -1;
                }
                this._altEscapes[quoteChar] = esc;
            }
            return esc;
        }
    }
}
