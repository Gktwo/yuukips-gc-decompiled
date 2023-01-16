package org.eclipse.jetty.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Part;
import org.eclipse.jetty.http.MultiPartParser;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.ByteArrayOutputStream2;
import org.eclipse.jetty.util.LazyList;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.MultiMap;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartFormInputStream.class */
public class MultiPartFormInputStream {
    private static final Logger LOG = Log.getLogger(MultiPartFormInputStream.class);
    private static final MultiMap<Part> EMPTY_MAP = new MultiMap<>(Collections.emptyMap());
    private final MultiMap<Part> _parts;
    private InputStream _in;
    private MultipartConfigElement _config;
    private String _contentType;
    private Throwable _err;
    private File _tmpDir;
    private File _contextTmpDir;
    private boolean _writeFilesWithFilenames;
    private boolean _parsed;
    private final EnumSet<NonCompliance> _nonComplianceWarnings = EnumSet.noneOf(NonCompliance.class);
    private int _bufferSize = 16384;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartFormInputStream$NonCompliance.class */
    public enum NonCompliance {
        TRANSFER_ENCODING("https://tools.ietf.org/html/rfc7578#section-4.7");
        
        final String _rfcRef;

        NonCompliance(String rfcRef) {
            this._rfcRef = rfcRef;
        }

        public String getURL() {
            return this._rfcRef;
        }
    }

    public EnumSet<NonCompliance> getNonComplianceWarnings() {
        return this._nonComplianceWarnings;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartFormInputStream$MultiPart.class */
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

        public MultiPart(String name, String filename) {
            this._name = name;
            this._filename = filename;
        }

        public String toString() {
            return String.format("Part{n=%s,fn=%s,ct=%s,s=%d,tmp=%b,file=%s}", this._name, this._filename, this._contentType, Long.valueOf(this._size), Boolean.valueOf(this._temporary), this._file);
        }

        protected void setContentType(String contentType) {
            this._contentType = contentType;
        }

        protected void open() throws IOException {
            if (!MultiPartFormInputStream.this.isWriteFilesWithFilenames() || this._filename == null || this._filename.trim().isEmpty()) {
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
            if (MultiPartFormInputStream.this._config.getMaxFileSize() <= 0 || this._size + 1 <= MultiPartFormInputStream.this._config.getMaxFileSize()) {
                if (MultiPartFormInputStream.this._config.getFileSizeThreshold() > 0 && this._size + 1 > ((long) MultiPartFormInputStream.this._config.getFileSizeThreshold()) && this._file == null) {
                    createFile();
                }
                this._out.write(b);
                this._size++;
                return;
            }
            throw new IllegalStateException("Multipart Mime part " + this._name + " exceeds max filesize");
        }

        protected void write(byte[] bytes, int offset, int length) throws IOException {
            if (MultiPartFormInputStream.this._config.getMaxFileSize() <= 0 || this._size + ((long) length) <= MultiPartFormInputStream.this._config.getMaxFileSize()) {
                if (MultiPartFormInputStream.this._config.getFileSizeThreshold() > 0 && this._size + ((long) length) > ((long) MultiPartFormInputStream.this._config.getFileSizeThreshold()) && this._file == null) {
                    createFile();
                }
                this._out.write(bytes, offset, length);
                this._size += (long) length;
                return;
            }
            throw new IllegalStateException("Multipart Mime part " + this._name + " exceeds max filesize");
        }

        protected void createFile() throws IOException {
            Path tempFile = Files.createTempFile(MultiPartFormInputStream.this._tmpDir.toPath(), "MultiPart", "", new FileAttribute[0]);
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
            return this._headers.getValue(StringUtil.asciiToLowerCase(name), 0);
        }

        @Override // javax.servlet.http.Part
        public Collection<String> getHeaderNames() {
            return this._headers.keySet();
        }

        @Override // javax.servlet.http.Part
        public Collection<String> getHeaders(String name) {
            Collection<String> headers = this._headers.getValues(name);
            return headers == null ? Collections.emptyList() : headers;
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

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0045
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // javax.servlet.http.Part
        public void write(java.lang.String r8) throws java.io.IOException {
            /*
                r7 = this;
                r0 = r7
                java.io.File r0 = r0._file
                if (r0 != 0) goto L_0x006c
                r0 = r7
                r1 = 0
                r0._temporary = r1
                r0 = r7
                java.io.File r1 = new java.io.File
                r2 = r1
                r3 = r7
                org.eclipse.jetty.http.MultiPartFormInputStream r3 = org.eclipse.jetty.http.MultiPartFormInputStream.this
                java.io.File r3 = org.eclipse.jetty.http.MultiPartFormInputStream.access$100(r3)
                r4 = r8
                r2.<init>(r3, r4)
                r0._file = r1
                java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch: all -> 0x005f
                r1 = r0
                java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch: all -> 0x005f
                r3 = r2
                r4 = r7
                java.io.File r4 = r4._file     // Catch: all -> 0x005f
                r3.<init>(r4)     // Catch: all -> 0x005f
                r1.<init>(r2)     // Catch: all -> 0x005f
                r9 = r0
                r0 = r7
                org.eclipse.jetty.util.ByteArrayOutputStream2 r0 = r0._bout     // Catch: all -> 0x005f, Throwable -> 0x0045
                r1 = r9
                r0.writeTo(r1)     // Catch: all -> 0x005f, Throwable -> 0x0045
                r0 = r9
                r0.flush()     // Catch: all -> 0x005f, Throwable -> 0x0045
                r0 = r9
                r0.close()     // Catch: all -> 0x005f
                goto L_0x0057
            L_0x0045:
                r10 = move-exception
                r0 = r9
                r0.close()     // Catch: all -> 0x005f, Throwable -> 0x004d
                goto L_0x0055
            L_0x004d:
                r11 = move-exception
                r0 = r10
                r1 = r11
                r0.addSuppressed(r1)     // Catch: all -> 0x005f
            L_0x0055:
                r0 = r10
                throw r0     // Catch: all -> 0x005f
            L_0x0057:
                r0 = r7
                r1 = 0
                r0._bout = r1
                goto L_0x0069
            L_0x005f:
                r12 = move-exception
                r0 = r7
                r1 = 0
                r0._bout = r1
                r0 = r12
                throw r0
            L_0x0069:
                goto L_0x009b
            L_0x006c:
                r0 = r7
                r1 = 0
                r0._temporary = r1
                r0 = r7
                java.io.File r0 = r0._file
                java.nio.file.Path r0 = r0.toPath()
                r9 = r0
                r0 = r9
                r1 = r8
                java.nio.file.Path r0 = r0.resolveSibling(r1)
                r10 = r0
                r0 = r9
                r1 = r10
                r2 = 1
                java.nio.file.CopyOption[] r2 = new java.nio.file.CopyOption[r2]
                r3 = r2
                r4 = 0
                java.nio.file.StandardCopyOption r5 = java.nio.file.StandardCopyOption.REPLACE_EXISTING
                r3[r4] = r5
                java.nio.file.Path r0 = java.nio.file.Files.move(r0, r1, r2)
                r0 = r7
                r1 = r10
                java.io.File r1 = r1.toFile()
                r0._file = r1
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.MultiPartFormInputStream.MultiPart.write(java.lang.String):void");
        }

        @Override // javax.servlet.http.Part
        public void delete() throws IOException {
            if (this._file != null && this._file.exists() && !this._file.delete()) {
                throw new IOException("Could Not Delete File");
            }
        }

        public void cleanUp() throws IOException {
            if (this._temporary) {
                delete();
            }
        }

        public File getFile() {
            return this._file;
        }

        public String getContentDispositionFilename() {
            return this._filename;
        }
    }

    public MultiPartFormInputStream(InputStream in, String contentType, MultipartConfigElement config, File contextTmpDir) {
        this._contentType = contentType;
        this._config = config;
        this._contextTmpDir = contextTmpDir;
        if (this._contextTmpDir == null) {
            this._contextTmpDir = new File(System.getProperty("java.io.tmpdir"));
        }
        if (this._config == null) {
            this._config = new MultipartConfigElement(this._contextTmpDir.getAbsolutePath());
        }
        MultiMap parts = new MultiMap();
        if ((in instanceof ServletInputStream) && ((ServletInputStream) in).isFinished()) {
            parts = EMPTY_MAP;
            this._parsed = true;
        }
        if (!this._parsed) {
            this._in = new BufferedInputStream(in);
        }
        this._parts = parts;
    }

    public boolean isEmpty() {
        if (this._parts == null) {
            return true;
        }
        Iterator<Part> it = this._parts.values().iterator();
        while (it.hasNext()) {
            if (!((List) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
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
        MultiException err = null;
        Iterator<Part> it = this._parts.values().iterator();
        while (it.hasNext()) {
            Iterator<Part> it2 = ((List) it.next()).iterator();
            while (it2.hasNext()) {
                try {
                    ((MultiPart) it2.next()).cleanUp();
                } catch (Exception e) {
                    if (err == null) {
                        err = new MultiException();
                    }
                    err.add(e);
                }
            }
        }
        this._parts.clear();
        if (err != null) {
            err.ifExceptionThrowRuntime();
        }
    }

    public Collection<Part> getParts() throws IOException {
        if (!this._parsed) {
            parse();
        }
        throwIfError();
        if (this._parts.isEmpty()) {
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

    public Part getPart(String name) throws IOException {
        if (!this._parsed) {
            parse();
        }
        throwIfError();
        return this._parts.getValue(name, 0);
    }

    protected void throwIfError() throws IOException {
        if (this._err != null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("MultiPart parsing failure ", this._err);
            }
            this._err.addSuppressed(new Throwable());
            if (this._err instanceof IOException) {
                throw ((IOException) this._err);
            } else if (this._err instanceof IllegalStateException) {
                throw ((IllegalStateException) this._err);
            } else {
                throw new IllegalStateException(this._err);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x01a0, code lost:
        if (r7._err == null) goto L_0x01a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x01a3, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x01ab, code lost:
        if (r0.getState() == org.eclipse.jetty.http.MultiPartParser.State.END) goto L_0x01d5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x01b5, code lost:
        if (r0.getState() != org.eclipse.jetty.http.MultiPartParser.State.PREAMBLE) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x01b8, code lost:
        r7._err = new java.io.IOException("Missing initial multi part boundary");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x01c8, code lost:
        r7._err = new java.io.IOException("Incomplete Multipart");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01dd, code lost:
        if (org.eclipse.jetty.http.MultiPartFormInputStream.LOG.isDebugEnabled() == false) goto L_0x01f9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x01e0, code lost:
        org.eclipse.jetty.http.MultiPartFormInputStream.LOG.debug("Parsing Complete {} err={}", r0, r7._err);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void parse() {
        /*
        // Method dump skipped, instructions count: 528
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.MultiPartFormInputStream.parse():void");
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MultiPartFormInputStream$Handler.class */
    public class Handler implements MultiPartParser.Handler {
        private MultiPart _part = null;
        private String contentDisposition = null;
        private String contentType = null;
        private MultiMap<String> headers = new MultiMap<>();

        Handler() {
        }

        @Override // org.eclipse.jetty.http.MultiPartParser.Handler
        public boolean messageComplete() {
            return true;
        }

        @Override // org.eclipse.jetty.http.MultiPartParser.Handler
        public void parsedField(String key, String value) {
            this.headers.put(StringUtil.asciiToLowerCase(key), value);
            if (key.equalsIgnoreCase("content-disposition")) {
                this.contentDisposition = value;
            } else if (key.equalsIgnoreCase("content-type")) {
                this.contentType = value;
            }
            if (key.equalsIgnoreCase("content-transfer-encoding") && !"8bit".equalsIgnoreCase(value) && !"binary".equalsIgnoreCase(value)) {
                MultiPartFormInputStream.this._nonComplianceWarnings.add(NonCompliance.TRANSFER_ENCODING);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:32:0x00ef
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // org.eclipse.jetty.http.MultiPartParser.Handler
        public boolean headerComplete() {
            /*
            // Method dump skipped, instructions count: 270
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.MultiPartFormInputStream.Handler.headerComplete():boolean");
        }

        @Override // org.eclipse.jetty.http.MultiPartParser.Handler
        public boolean content(ByteBuffer buffer, boolean last) {
            if (this._part == null) {
                return false;
            }
            if (BufferUtil.hasContent(buffer)) {
                try {
                    this._part.write(buffer.array(), buffer.arrayOffset() + buffer.position(), buffer.remaining());
                } catch (IOException e) {
                    MultiPartFormInputStream.this._err = e;
                    return true;
                }
            }
            if (!last) {
                return false;
            }
            try {
                this._part.close();
                return false;
            } catch (IOException e2) {
                MultiPartFormInputStream.this._err = e2;
                return true;
            }
        }

        @Override // org.eclipse.jetty.http.MultiPartParser.Handler
        public void startPart() {
            reset();
        }

        @Override // org.eclipse.jetty.http.MultiPartParser.Handler
        public void earlyEOF() {
            if (MultiPartFormInputStream.LOG.isDebugEnabled()) {
                MultiPartFormInputStream.LOG.debug("Early EOF {}", MultiPartFormInputStream.this);
            }
            try {
                if (this._part != null) {
                    this._part.close();
                }
            } catch (IOException e) {
                MultiPartFormInputStream.LOG.warn("part could not be closed", e);
            }
        }

        public void reset() {
            this._part = null;
            this.contentDisposition = null;
            this.contentType = null;
            this.headers = new MultiMap<>();
        }
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

    /* access modifiers changed from: private */
    public static String value(String nameEqualsValue) {
        return QuotedStringTokenizer.unquoteOnly(nameEqualsValue.substring(nameEqualsValue.indexOf(61) + 1).trim());
    }

    /* access modifiers changed from: private */
    public static String filenameValue(String nameEqualsValue) {
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

    public int getBufferSize() {
        return this._bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this._bufferSize = bufferSize;
    }
}
