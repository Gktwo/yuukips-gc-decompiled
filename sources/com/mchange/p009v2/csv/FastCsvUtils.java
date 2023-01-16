package com.mchange.p009v2.csv;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.mchange.v2.csv.FastCsvUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/csv/FastCsvUtils.class */
public final class FastCsvUtils {
    private static final int ESCAPE_BIT = 16777216;
    private static final int SHIFT_BIT = 33554432;
    private static final int SHIFT_OFFSET = 8;

    /* renamed from: CR */
    private static final int f418CR = 13;

    /* renamed from: LF */
    private static final int f419LF = 10;
    private static final int EOF = -1;
    private static final int CRLF_TOKEN = 999;
    private static final String CRLF = "\r\n";
    private static final int GUESSED_LINE_LEN = 512;

    public static String csvReadLine(BufferedReader bufferedReader) throws IOException, MalformedCsvException {
        String str;
        int[] iArr = new int[1];
        String readLine = readLine(bufferedReader, iArr);
        if (readLine != null) {
            int countQuotes = countQuotes(readLine);
            if (countQuotes % 2 != 0) {
                StringBuilder sb = new StringBuilder(readLine);
                do {
                    appendForToken(iArr[0], sb);
                    String readLine2 = readLine(bufferedReader, iArr);
                    if (readLine2 != null) {
                        sb.append(readLine2);
                        countQuotes += countQuotes(readLine2);
                    } else {
                        throw new MalformedCsvException("Unterminated quote at EOF: '" + sb.toString() + "'");
                    }
                } while (countQuotes % 2 != 0);
                str = sb.toString();
            } else {
                str = readLine;
            }
        } else {
            str = null;
        }
        return str;
    }

    private static void appendForToken(int i, StringBuilder sb) {
        switch (i) {
            case -1:
                return;
            case 10:
            case 13:
                sb.append((char) i);
                return;
            case 999:
                sb.append("\r\n");
                return;
            default:
                throw new InternalError("Unexpected token (should never happen): " + i);
        }
    }

    private static String readLine(BufferedReader bufferedReader, int[] iArr) throws IOException {
        StringBuilder sb = new StringBuilder(512);
        int read = bufferedReader.read();
        if (read < 0) {
            iArr[0] = -1;
            return null;
        }
        while (notSepOrEOF(read)) {
            sb.append((char) read);
            read = bufferedReader.read();
        }
        if (read == 13) {
            bufferedReader.mark(1);
            if (bufferedReader.read() == 10) {
                iArr[0] = 999;
            } else {
                bufferedReader.reset();
                iArr[0] = 13;
            }
        } else {
            iArr[0] = read;
        }
        return sb.toString();
    }

    private static boolean notSepOrEOF(int i) {
        return (i < 0 || i == 10 || i == 13) ? false : true;
    }

    private static int countQuotes(String str) {
        int i = 0;
        for (char c : str.toCharArray()) {
            if (c == '\"') {
                i++;
            }
        }
        return i;
    }

    public static String[] splitRecord(String str) throws MalformedCsvException {
        List splitShifted = splitShifted(upshiftQuoteString(str));
        int size = splitShifted.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = downshift((int[]) splitShifted.get(i));
        }
        return strArr;
    }

    private static void debugPrint(int[] iArr) {
        int length = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            cArr[i] = isShifted(iArr[i]) ? '_' : (char) iArr[i];
        }
        System.err.println(new String(cArr));
    }

    private static List splitShifted(int[] iArr) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int length = iArr.length;
        for (int i2 = 0; i2 <= length; i2++) {
            if (i2 == length || iArr[i2] == 44) {
                int i3 = i2 - i;
                int i4 = -1;
                int i5 = i;
                while (true) {
                    if (i5 <= i2) {
                        if (i5 == i2) {
                            i4 = 0;
                            break;
                        }
                        if (!(iArr[i5] == 32 || iArr[i5] == 9)) {
                            break;
                        }
                        i5++;
                    } else {
                        break;
                    }
                }
                if (i4 < 0) {
                    if (i5 != i2 - 1) {
                        i4 = i2 - i5;
                        while (i4 > 0) {
                            int i6 = (i5 + i4) - 1;
                            if (!(iArr[i6] == 32 || iArr[i6] == 9)) {
                                break;
                            }
                            i4--;
                        }
                    } else {
                        i4 = 1;
                    }
                }
                int[] iArr2 = new int[i4];
                if (i4 > 0) {
                    System.arraycopy(iArr, i5, iArr2, 0, i4);
                }
                arrayList.add(iArr2);
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    private static String downshift(int[] iArr) {
        int length = iArr.length;
        char[] cArr = new char[length];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            cArr[i] = (char) (isShifted(i2) ? i2 >>> 8 : i2);
        }
        return new String(cArr);
    }

    private static boolean isShifted(int i) {
        return (i & 33554432) != 0;
    }

    private static int[] upshiftQuoteString(String str) throws MalformedCsvException {
        char[] charArray = str.toCharArray();
        int[] iArr = new int[charArray.length];
        EscapedCharReader escapedCharReader = new EscapedCharReader(charArray);
        int i = 0;
        boolean z = false;
        for (int read = escapedCharReader.read(false); read >= 0; read = escapedCharReader.read(z)) {
            if (read == 34) {
                z = !z;
            } else {
                i++;
                iArr[i] = findShiftyChar(read, z);
            }
        }
        int[] iArr2 = new int[i];
        System.arraycopy(iArr, 0, iArr2, 0, i);
        return iArr2;
    }

    private static int findShiftyChar(int i, boolean z) {
        return z ? (i << 8) | 33554432 : i;
    }

    /* access modifiers changed from: private */
    public static int escape(int i) {
        return i | 16777216;
    }

    private static boolean isEscaped(int i) {
        return (i & 16777216) != 0;
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.csv.FastCsvUtils$EscapedCharReader */
    /* loaded from: grasscutter.jar:com/mchange/v2/csv/FastCsvUtils$EscapedCharReader.class */
    public static class EscapedCharReader {
        char[] chars;
        int finger = 0;

        EscapedCharReader(char[] cArr) {
            this.chars = cArr;
        }

        int read(boolean z) throws MalformedCsvException {
            if (this.finger >= this.chars.length) {
                return -1;
            }
            char[] cArr = this.chars;
            int i = this.finger;
            this.finger = i + 1;
            char c = cArr[i];
            if (c != '\"' || !z) {
                return c;
            }
            if (this.finger >= this.chars.length) {
                return c;
            }
            char c2 = this.chars[this.finger];
            if (c2 != '\"') {
                return c;
            }
            this.finger++;
            return FastCsvUtils.escape(c2);
        }
    }

    private FastCsvUtils() {
    }
}
