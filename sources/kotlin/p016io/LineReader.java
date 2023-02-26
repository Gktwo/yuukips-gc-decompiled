package kotlin.p016io;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Console.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\\\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0019\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n��R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0004¢\u0006\u0002\n��¨\u0006$"}, m373d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"})
/* renamed from: kotlin.io.LineReader */
/* loaded from: grasscutter.jar:kotlin/io/LineReader.class */
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    @NotNull
    private static final ByteBuffer byteBuf;
    @NotNull
    private static final CharBuffer charBuf;
    @NotNull
    public static final LineReader INSTANCE = new LineReader();
    @NotNull
    private static final byte[] bytes = new byte[32];
    @NotNull
    private static final char[] chars = new char[32];
    @NotNull

    /* renamed from: sb */
    private static final StringBuilder f3051sb = new StringBuilder();

    private LineReader() {
    }

    static {
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
        Intrinsics.checkNotNullExpressionValue(wrap, "wrap(bytes)");
        byteBuf = wrap;
        CharBuffer wrap2 = CharBuffer.wrap(chars);
        Intrinsics.checkNotNullExpressionValue(wrap2, "wrap(chars)");
        charBuf = wrap2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0027, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.charset(), r8) == false) goto L_0x002a;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized java.lang.String readLine(@org.jetbrains.annotations.NotNull java.io.InputStream r7, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r8) {
        /*
        // Method dump skipped, instructions count: 331
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.p016io.LineReader.readLine(java.io.InputStream, java.nio.charset.Charset):java.lang.String");
    }

    private final int decode(boolean endOfInput) {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
            CoderResult coderResult = charsetDecoder.decode(byteBuf, charBuf, endOfInput);
            Intrinsics.checkNotNullExpressionValue(coderResult, "decoder.decode(byteBuf, charBuf, endOfInput)");
            if (coderResult.isError()) {
                resetAll();
                coderResult.throwException();
            }
            int nChars = charBuf.position();
            if (!coderResult.isOverflow()) {
                return nChars;
            }
            f3051sb.append(chars, 0, nChars - 1);
            charBuf.position(0);
            charBuf.limit(32);
            charBuf.put(chars[nChars - 1]);
        }
    }

    private final int compactBytes() {
        ByteBuffer $this$compactBytes_u24lambda_u2d1 = byteBuf;
        $this$compactBytes_u24lambda_u2d1.compact();
        int position = $this$compactBytes_u24lambda_u2d1.position();
        $this$compactBytes_u24lambda_u2d1.position(0);
        return position;
    }

    private final int decodeEndOfInput(int nBytes, int nChars) {
        byteBuf.limit(nBytes);
        charBuf.position(nChars);
        int decode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        return decode;
    }

    private final void updateCharset(Charset charset) {
        CharsetDecoder newDecoder = charset.newDecoder();
        Intrinsics.checkNotNullExpressionValue(newDecoder, "charset.newDecoder()");
        decoder = newDecoder;
        byteBuf.clear();
        charBuf.clear();
        byteBuf.put((byte) 10);
        byteBuf.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.decode(byteBuf, charBuf, false);
        directEOL = charBuf.position() == 1 && charBuf.get(0) == '\n';
        resetAll();
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        f3051sb.setLength(0);
    }

    private final void trimStringBuilder() {
        f3051sb.setLength(32);
        f3051sb.trimToSize();
    }
}
