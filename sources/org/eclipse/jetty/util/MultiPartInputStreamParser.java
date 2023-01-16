package org.eclipse.jetty.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Part;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiPartInputStreamParser.class */
public class MultiPartInputStreamParser {
    private static final Logger LOG = Log.getLogger(MultiPartInputStreamParser.class);
    public static final MultipartConfigElement __DEFAULT_MULTIPART_CONFIG = new MultipartConfigElement(System.getProperty("java.io.tmpdir"));
    public static final MultiMap<Part> EMPTY_MAP = new MultiMap<>(Collections.emptyMap());
    protected InputStream _in;
    protected MultipartConfigElement _config;
    protected String _contentType;
    protected MultiMap<Part> _parts;
    protected Exception _err;
    protected File _tmpDir;
    protected File _contextTmpDir;
    protected boolean _writeFilesWithFilenames;
    protected boolean _parsed;
    private EnumSet<NonCompliance> nonComplianceWarnings = EnumSet.noneOf(NonCompliance.class);

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiPartInputStreamParser$NonCompliance.class */
    public enum NonCompliance {
        CR_LINE_TERMINATION("https://tools.ietf.org/html/rfc2046#section-4.1.1"),
        LF_LINE_TERMINATION("https://tools.ietf.org/html/rfc2046#section-4.1.1"),
        NO_CRLF_AFTER_PREAMBLE("https://tools.ietf.org/html/rfc2046#section-5.1.1"),
        BASE64_TRANSFER_ENCODING("https://tools.ietf.org/html/rfc7578#section-4.7"),
        QUOTED_PRINTABLE_TRANSFER_ENCODING("https://tools.ietf.org/html/rfc7578#section-4.7");
        
        final String _rfcRef;

        NonCompliance(String rfcRef) {
            this._rfcRef = rfcRef;
        }

        public String getURL() {
            return this._rfcRef;
        }
    }

    public EnumSet<NonCompliance> getNonComplianceWarnings() {
        return this.nonComplianceWarnings;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiPartInputStreamParser$MultiPart.class */
    public class MultiPart implements Part {
        protected String _name;
        protected String _filename;
        protected File _file;
        protected OutputStream _out;
        protected ByteArrayOutputStream2 _bout;
        protected String _contentType;
        protected MultiMap<String> _headers;
        protected long _size = 0;
        protected boolean _temporary = true;

        public MultiPart(String name, String filename) throws IOException {
            this._name = name;
            this._filename = filename;
        }

        public String toString() {
            return String.format("Part{n=%s,fn=%s,ct=%s,s=%d,t=%b,f=%s}", this._name, this._filename, this._contentType, Long.valueOf(this._size), Boolean.valueOf(this._temporary), this._file);
        }

        protected void setContentType(String contentType) {
            this._contentType = contentType;
        }

        protected void open() throws IOException {
            if (!MultiPartInputStreamParser.this.isWriteFilesWithFilenames() || this._filename == null || this._filename.trim().length() <= 0) {
                ByteArrayOutputStream2 byteArrayOutputStream2 = new ByteArrayOutputStream2();
                this._bout = byteArrayOutputStream2;
                this._out = byteArrayOutputStream2;
                return;
            }
            createFile();
        }

        protected void close() throws IOException {
            this._out.close();
        }

        protected void write(int b) throws IOException {
            if (MultiPartInputStreamParser.this._config.getMaxFileSize() <= 0 || this._size + 1 <= MultiPartInputStreamParser.this._config.getMaxFileSize()) {
                if (MultiPartInputStreamParser.this._config.getFileSizeThreshold() > 0 && this._size + 1 > ((long) MultiPartInputStreamParser.this._config.getFileSizeThreshold()) && this._file == null) {
                    createFile();
                }
                this._out.write(b);
                this._size++;
                return;
            }
            throw new IllegalStateException("Multipart Mime part " + this._name + " exceeds max filesize");
        }

        protected void write(byte[] bytes, int offset, int length) throws IOException {
            if (MultiPartInputStreamParser.this._config.getMaxFileSize() <= 0 || this._size + ((long) length) <= MultiPartInputStreamParser.this._config.getMaxFileSize()) {
                if (MultiPartInputStreamParser.this._config.getFileSizeThreshold() > 0 && this._size + ((long) length) > ((long) MultiPartInputStreamParser.this._config.getFileSizeThreshold()) && this._file == null) {
                    createFile();
                }
                this._out.write(bytes, offset, length);
                this._size += (long) length;
                return;
            }
            throw new IllegalStateException("Multipart Mime part " + this._name + " exceeds max filesize");
        }

        protected void createFile() throws IOException {
            Path tempFile = Files.createTempFile(MultiPartInputStreamParser.this._tmpDir.toPath(), "MultiPart", "", new FileAttribute[0]);
            this._file = tempFile.toFile();
            BufferedOutputStream bos = new BufferedOutputStream(Files.newOutputStream(tempFile, StandardOpenOption.WRITE));
            if (this._size > 0 && this._out != null) {
                this._out.flush();
                this._bout.writeTo(bos);
                this._out.close();
            }
            this._bout = null;
            this._out = bos;
        }

        protected void setHeaders(MultiMap<String> headers) {
            this._headers = headers;
        }

        @Override // javax.servlet.http.Part
        public String getContentType() {
            return this._contentType;
        }

        @Override // javax.servlet.http.Part
        public String getHeader(String name) {
            if (name == null) {
                return null;
            }
            return this._headers.getValue(name.toLowerCase(Locale.ENGLISH), 0);
        }

        @Override // javax.servlet.http.Part
        public Collection<String> getHeaderNames() {
            return this._headers.keySet();
        }

        @Override // javax.servlet.http.Part
        public Collection<String> getHeaders(String name) {
            return this._headers.getValues(name);
        }

        @Override // javax.servlet.http.Part
        public InputStream getInputStream() throws IOException {
            if (this._file != null) {
                return new BufferedInputStream(new FileInputStream(this._file));
            }
            return new ByteArrayInputStream(this._bout.getBuf(), 0, this._bout.size());
        }

        @Override // javax.servlet.http.Part
        public String getSubmittedFileName() {
            return getContentDispositionFilename();
        }

        public byte[] getBytes() {
            if (this._bout != null) {
                return this._bout.toByteArray();
            }
            return null;
        }

        @Override // javax.servlet.http.Part
        public String getName() {
            return this._name;
        }

        @Override // javax.servlet.http.Part
        public long getSize() {
            return this._size;
        }

        @Override // javax.servlet.http.Part
        public void write(String fileName) throws IOException {
            if (this._file == null) {
                this._temporary = false;
                this._file = new File(MultiPartInputStreamParser.this._tmpDir, fileName);
                BufferedOutputStream bos = null;
                try {
                    bos = new BufferedOutputStream(new FileOutputStream(this._file));
                    this._bout.writeTo(bos);
                    bos.flush();
                    if (bos != null) {
                        bos.close();
                    }
                    this._bout = null;
                } catch (Throwable th) {
                    if (bos != null) {
                        bos.close();
                    }
                    this._bout = null;
                    throw th;
                }
            } else {
                this._temporary = false;
                Path src = this._file.toPath();
                Path target = src.resolveSibling(fileName);
                Files.move(src, target, StandardCopyOption.REPLACE_EXISTING);
                this._file = target.toFile();
            }
        }

        @Override // javax.servlet.http.Part
        public void delete() throws IOException {
            if (this._file != null && this._file.exists()) {
                this._file.delete();
            }
        }

        public void cleanUp() throws IOException {
            if (this._temporary && this._file != null && this._file.exists()) {
                this._file.delete();
            }
        }

        public File getFile() {
            return this._file;
        }

        public String getContentDispositionFilename() {
            return this._filename;
        }
    }

    public MultiPartInputStreamParser(InputStream in, String contentType, MultipartConfigElement config, File contextTmpDir) {
        this._contentType = contentType;
        this._config = config;
        this._contextTmpDir = contextTmpDir;
        if (this._contextTmpDir == null) {
            this._contextTmpDir = new File(System.getProperty("java.io.tmpdir"));
        }
        if (this._config == null) {
            this._config = new MultipartConfigElement(this._contextTmpDir.getAbsolutePath());
        }
        if (!(in instanceof ServletInputStream) || !((ServletInputStream) in).isFinished()) {
            this._in = new ReadLineInputStream(in);
            return;
        }
        this._parts = EMPTY_MAP;
        this._parsed = true;
    }

    public Collection<Part> getParsedParts() {
        if (this._parts == null) {
            return Collections.emptyList();
        }
        Collection<Part> values = this._parts.values();
        List<Part> parts = new ArrayList<>();
        Iterator<Part> it = values.iterator();
        while (it.hasNext()) {
            parts.addAll(LazyList.getList((List) it.next(), false));
        }
        return parts;
    }

    public void deleteParts() {
        if (this._parsed) {
            Collection<Part> parts = getParsedParts();
            MultiException err = new MultiException();
            Iterator<Part> it = parts.iterator();
            while (it.hasNext()) {
                try {
                    ((MultiPart) it.next()).cleanUp();
                } catch (Exception e) {
                    err.add(e);
                }
            }
            this._parts.clear();
            err.ifExceptionThrowRuntime();
        }
    }

    public Collection<Part> getParts() throws IOException {
        if (!this._parsed) {
            parse();
        }
        throwIfError();
        Collection<Part> values = this._parts.values();
        List<Part> parts = new ArrayList<>();
        Iterator<Part> it = values.iterator();
        while (it.hasNext()) {
            parts.addAll(LazyList.getList((List) it.next(), false));
        }
        return parts;
    }

    public Part getPart(String name) throws IOException {
        if (!this._parsed) {
            parse();
        }
        throwIfError();
        return this._parts.getValue(name, 0);
    }

    protected void throwIfError() throws IOException {
        if (this._err == null) {
            return;
        }
        if (this._err instanceof IOException) {
            throw ((IOException) this._err);
        } else if (this._err instanceof IllegalStateException) {
            throw ((IllegalStateException) this._err);
        } else {
            throw new IllegalStateException(this._err);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:32:0x0133
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected void parse() {
        /*
        // Method dump skipped, instructions count: 1546
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.MultiPartInputStreamParser.parse():void");
    }

    @Deprecated
    public void setDeleteOnExit(boolean deleteOnExit) {
    }

    public void setWriteFilesWithFilenames(boolean writeFilesWithFilenames) {
        this._writeFilesWithFilenames = writeFilesWithFilenames;
    }

    public boolean isWriteFilesWithFilenames() {
        return this._writeFilesWithFilenames;
    }

    @Deprecated
    public boolean isDeleteOnExit() {
        return false;
    }

    private String value(String nameEqualsValue) {
        return QuotedStringTokenizer.unquoteOnly(nameEqualsValue.substring(nameEqualsValue.indexOf(61) + 1).trim());
    }

    private String filenameValue(String nameEqualsValue) {
        String value = nameEqualsValue.substring(nameEqualsValue.indexOf(61) + 1).trim();
        if (!value.matches(".??[a-z,A-Z]\\:\\\\[^\\\\].*")) {
            return QuotedStringTokenizer.unquoteOnly(value, true);
        }
        char first = value.charAt(0);
        if (first == '\"' || first == '\'') {
            value = value.substring(1);
        }
        char last = value.charAt(value.length() - 1);
        if (last == '\"' || last == '\'') {
            value = value.substring(0, value.length() - 1);
        }
        return value;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/MultiPartInputStreamParser$Base64InputStream.class */
    public static class Base64InputStream extends InputStream {
        ReadLineInputStream _in;
        String _line;
        byte[] _buffer;
        int _pos;
        Base64.Decoder base64Decoder = Base64.getDecoder();

        public Base64InputStream(ReadLineInputStream rlis) {
            this._in = rlis;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this._buffer == null || this._pos >= this._buffer.length) {
                this._line = this._in.readLine();
                if (this._line == null) {
                    return -1;
                }
                if (this._line.startsWith("--")) {
                    this._buffer = (this._line + "\r\n").getBytes();
                } else if (this._line.length() == 0) {
                    this._buffer = "\r\n".getBytes();
                } else {
                    ByteArrayOutputStream baos = new ByteArrayOutputStream(((4 * this._line.length()) / 3) + 2);
                    baos.write(this.base64Decoder.decode(this._line));
                    baos.write(13);
                    baos.write(10);
                    this._buffer = baos.toByteArray();
                }
                this._pos = 0;
            }
            byte[] bArr = this._buffer;
            int i = this._pos;
            this._pos = i + 1;
            return bArr[i];
        }
    }
}
