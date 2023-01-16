package nonapi.p019io.github.classgraph.utils;

/* renamed from: nonapi.io.github.classgraph.utils.StringUtils */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/utils/StringUtils.class */
public final class StringUtils {
    private StringUtils() {
    }

    public static String readString(byte[] arr, int startOffset, int numBytes, boolean replaceSlashWithDot, boolean stripLSemicolon) throws IllegalArgumentException {
        if (((long) startOffset) < 0 || numBytes < 0 || startOffset + numBytes > arr.length) {
            throw new IllegalArgumentException("offset or numBytes out of range");
        }
        char[] chars = new char[numBytes];
        int byteIdx = 0;
        int charIdx = 0;
        while (byteIdx < numBytes) {
            int c = arr[startOffset + byteIdx] & 255;
            if (c > 127) {
                break;
            }
            charIdx++;
            chars[charIdx] = (char) ((!replaceSlashWithDot || c != 47) ? c : 46);
            byteIdx++;
        }
        while (byteIdx < numBytes) {
            int c2 = arr[startOffset + byteIdx] & 255;
            switch (c2 >> 4) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    byteIdx++;
                    charIdx++;
                    chars[charIdx] = (char) ((!replaceSlashWithDot || c2 != 47) ? c2 : 46);
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                default:
                    throw new IllegalArgumentException("Bad modified UTF8");
                case 12:
                case 13:
                    byteIdx += 2;
                    if (byteIdx <= numBytes) {
                        byte b = arr[(startOffset + byteIdx) - 1];
                        if ((b & 192) == 128) {
                            int c3 = ((c2 & 31) << 6) | (b & 63);
                            charIdx++;
                            chars[charIdx] = (char) ((!replaceSlashWithDot || c3 != 47) ? c3 : 46);
                            break;
                        } else {
                            throw new IllegalArgumentException("Bad modified UTF8");
                        }
                    } else {
                        throw new IllegalArgumentException("Bad modified UTF8");
                    }
                case 14:
                    byteIdx += 3;
                    if (byteIdx <= numBytes) {
                        byte b2 = arr[(startOffset + byteIdx) - 2];
                        byte b3 = arr[(startOffset + byteIdx) - 1];
                        if ((b2 & 192) == 128 && (b3 & 192) == 128) {
                            int c4 = ((c2 & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63);
                            charIdx++;
                            chars[charIdx] = (char) ((!replaceSlashWithDot || c4 != 47) ? c4 : 46);
                            break;
                        } else {
                            throw new IllegalArgumentException("Bad modified UTF8");
                        }
                    } else {
                        throw new IllegalArgumentException("Bad modified UTF8");
                    }
            }
        }
        if (charIdx == numBytes && !stripLSemicolon) {
            return new String(chars);
        }
        if (!stripLSemicolon) {
            return new String(chars, 0, charIdx);
        }
        if (charIdx >= 2 && chars[0] == 'L' && chars[charIdx - 1] == ';') {
            return new String(chars, 1, charIdx - 2);
        }
        throw new IllegalArgumentException("Expected string to start with 'L' and end with ';', got \"" + new String(chars) + "\"");
    }
}
