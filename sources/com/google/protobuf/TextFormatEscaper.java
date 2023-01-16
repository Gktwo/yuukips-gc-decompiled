package com.google.protobuf;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/google/protobuf/TextFormatEscaper.class */
public final class TextFormatEscaper {

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/google/protobuf/TextFormatEscaper$ByteSequence.class */
    public interface ByteSequence {
        int size();

        byte byteAt(int i);
    }

    private TextFormatEscaper() {
    }

    static String escapeBytes(ByteSequence input) {
        StringBuilder builder = new StringBuilder(input.size());
        for (int i = 0; i < input.size(); i++) {
            byte b = input.byteAt(i);
            switch (b) {
                case 7:
                    builder.append("\\a");
                    break;
                case 8:
                    builder.append("\\b");
                    break;
                case 9:
                    builder.append("\\t");
                    break;
                case 10:
                    builder.append("\\n");
                    break;
                case 11:
                    builder.append("\\v");
                    break;
                case 12:
                    builder.append("\\f");
                    break;
                case 13:
                    builder.append("\\r");
                    break;
                case 34:
                    builder.append("\\\"");
                    break;
                case 39:
                    builder.append("\\'");
                    break;
                case 92:
                    builder.append("\\\\");
                    break;
                default:
                    if (b < 32 || b > 126) {
                        builder.append('\\');
                        builder.append((char) (48 + ((b >>> 6) & 3)));
                        builder.append((char) (48 + ((b >>> 3) & 7)));
                        builder.append((char) (48 + (b & 7)));
                        break;
                    } else {
                        builder.append((char) b);
                        break;
                    }
                    break;
            }
        }
        return builder.toString();
    }

    /* access modifiers changed from: package-private */
    public static String escapeBytes(final ByteString input) {
        return escapeBytes(new ByteSequence() { // from class: com.google.protobuf.TextFormatEscaper.1
            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return input.size();
            }

            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int offset) {
                return input.byteAt(offset);
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static String escapeBytes(final byte[] input) {
        return escapeBytes(new ByteSequence() { // from class: com.google.protobuf.TextFormatEscaper.2
            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public int size() {
                return input.length;
            }

            @Override // com.google.protobuf.TextFormatEscaper.ByteSequence
            public byte byteAt(int offset) {
                return input[offset];
            }
        });
    }

    /* access modifiers changed from: package-private */
    public static String escapeText(String input) {
        return escapeBytes(ByteString.copyFromUtf8(input));
    }

    /* access modifiers changed from: package-private */
    public static String escapeDoubleQuotesAndBackslashes(String input) {
        return input.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
