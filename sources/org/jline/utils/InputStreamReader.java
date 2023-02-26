package org.jline.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.MalformedInputException;
import java.nio.charset.UnmappableCharacterException;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/InputStreamReader.class */
public class InputStreamReader extends Reader {

    /* renamed from: in */
    private InputStream f3233in;
    private static final int BUFFER_SIZE = 4;
    private boolean endOfInput;
    CharsetDecoder decoder;
    ByteBuffer bytes;
    char pending;

    public InputStreamReader(InputStream in) {
        super(in);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(4);
        this.pending = 65535;
        this.f3233in = in;
        this.decoder = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.bytes.limit(0);
    }

    public InputStreamReader(InputStream in, String enc) throws UnsupportedEncodingException {
        super(in);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(4);
        this.pending = 65535;
        if (enc == null) {
            throw new NullPointerException();
        }
        this.f3233in = in;
        try {
            this.decoder = Charset.forName(enc).newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
            this.bytes.limit(0);
        } catch (IllegalArgumentException e) {
            throw ((UnsupportedEncodingException) new UnsupportedEncodingException(enc).initCause(e));
        }
    }

    public InputStreamReader(InputStream in, CharsetDecoder dec) {
        super(in);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(4);
        this.pending = 65535;
        dec.averageCharsPerByte();
        this.f3233in = in;
        this.decoder = dec;
        this.bytes.limit(0);
    }

    public InputStreamReader(InputStream in, Charset charset) {
        super(in);
        this.endOfInput = false;
        this.bytes = ByteBuffer.allocate(4);
        this.pending = 65535;
        this.f3233in = in;
        this.decoder = charset.newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        this.bytes.limit(0);
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this.lock) {
            this.decoder = null;
            if (this.f3233in != null) {
                this.f3233in.close();
                this.f3233in = null;
            }
        }
    }

    public String getEncoding() {
        if (!isOpen()) {
            return null;
        }
        return this.decoder.charset().name();
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        synchronized (this.lock) {
            if (!isOpen()) {
                throw new ClosedException("InputStreamReader is closed.");
            } else if (this.pending != 65535) {
                char c = this.pending;
                this.pending = 65535;
                return c;
            } else {
                char[] buf = new char[2];
                int nb = read(buf, 0, 2);
                if (nb == 2) {
                    this.pending = buf[1];
                }
                if (nb <= 0) {
                    return -1;
                }
                return buf[0];
            }
        }
    }

    @Override // java.io.Reader
    public int read(char[] buf, int offset, int length) throws IOException {
        synchronized (this.lock) {
            if (!isOpen()) {
                throw new IOException("InputStreamReader is closed.");
            } else if (offset < 0 || offset > buf.length - length || length < 0) {
                throw new IndexOutOfBoundsException();
            } else if (length == 0) {
                return 0;
            } else {
                CharBuffer out = CharBuffer.wrap(buf, offset, length);
                CoderResult result = CoderResult.UNDERFLOW;
                boolean needInput = !this.bytes.hasRemaining();
                while (true) {
                    if (out.position() == offset) {
                        if (needInput) {
                            if (this.f3233in.available() == 0) {
                                try {
                                    if (out.position() > offset) {
                                        break;
                                    }
                                } catch (IOException e) {
                                }
                            }
                            int was_red = this.f3233in.read(this.bytes.array(), this.bytes.arrayOffset() + this.bytes.limit(), 1);
                            if (was_red == -1) {
                                this.endOfInput = true;
                                break;
                            } else if (was_red == 0) {
                                break;
                            } else {
                                this.bytes.limit(this.bytes.limit() + was_red);
                            }
                        }
                        result = this.decoder.decode(this.bytes, out, false);
                        if (!result.isUnderflow()) {
                            break;
                        }
                        if (this.bytes.limit() == this.bytes.capacity()) {
                            this.bytes.compact();
                            this.bytes.limit(this.bytes.position());
                            this.bytes.position(0);
                        }
                        needInput = true;
                    } else {
                        break;
                    }
                }
                if (result == CoderResult.UNDERFLOW && this.endOfInput) {
                    result = this.decoder.decode(this.bytes, out, true);
                    this.decoder.flush(out);
                    this.decoder.reset();
                }
                if (result.isMalformed()) {
                    throw new MalformedInputException(result.length());
                } else if (result.isUnmappable()) {
                    throw new UnmappableCharacterException(result.length());
                } else {
                    return out.position() - offset == 0 ? -1 : out.position() - offset;
                }
            }
        }
    }

    private boolean isOpen() {
        return this.f3233in != null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:17:0x0034
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.io.Reader
    public boolean ready() throws java.io.IOException {
        /*
            r4 = this;
            r0 = r4
            java.lang.Object r0 = r0.lock
            r1 = r0
            r5 = r1
            monitor-enter(r0)
            r0 = r4
            java.io.InputStream r0 = r0.f3233in     // Catch: all -> 0x0039
            if (r0 != 0) goto L_0x0018
            java.io.IOException r0 = new java.io.IOException     // Catch: all -> 0x0039
            r1 = r0
            java.lang.String r2 = "InputStreamReader is closed."
            r1.<init>(r2)     // Catch: all -> 0x0039
            throw r0     // Catch: all -> 0x0039
        L_0x0018:
            r0 = r4
            java.nio.ByteBuffer r0 = r0.bytes     // Catch: all -> 0x0039, IOException -> 0x0034
            boolean r0 = r0.hasRemaining()     // Catch: all -> 0x0039, IOException -> 0x0034
            if (r0 != 0) goto L_0x002c
            r0 = r4
            java.io.InputStream r0 = r0.f3233in     // Catch: all -> 0x0039, IOException -> 0x0034
            int r0 = r0.available()     // Catch: all -> 0x0039, IOException -> 0x0034
            if (r0 <= 0) goto L_0x0030
        L_0x002c:
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            r1 = r5
            monitor-exit(r1)     // Catch: all -> 0x0039
            return r0
        L_0x0034:
            r6 = move-exception
            r0 = 0
            r1 = r5
            monitor-exit(r1)     // Catch: all -> 0x0039
            return r0
        L_0x0039:
            r7 = move-exception
            r0 = r5
            monitor-exit(r0)     // Catch: all -> 0x0039
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.utils.InputStreamReader.ready():boolean");
    }
}
