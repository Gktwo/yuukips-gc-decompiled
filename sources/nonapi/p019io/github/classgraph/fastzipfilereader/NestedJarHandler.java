package nonapi.p019io.github.classgraph.fastzipfilereader;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import java.util.zip.ZipException;
import nonapi.p019io.github.classgraph.concurrency.InterruptionChecker;
import nonapi.p019io.github.classgraph.concurrency.SingletonMap;
import nonapi.p019io.github.classgraph.fileslice.ArraySlice;
import nonapi.p019io.github.classgraph.fileslice.FileSlice;
import nonapi.p019io.github.classgraph.fileslice.Slice;
import nonapi.p019io.github.classgraph.recycler.Recycler;
import nonapi.p019io.github.classgraph.recycler.Resettable;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p013io.github.classgraph.ModuleReaderProxy;
import p013io.github.classgraph.ModuleRef;

/* renamed from: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fastzipfilereader/NestedJarHandler.class */
public class NestedJarHandler {
    public final ScanSpec scanSpec;
    public static final String TEMP_FILENAME_LEAF_SEPARATOR = "---";
    public InterruptionChecker interruptionChecker;
    private static final int DEFAULT_BUFFER_SIZE = 16384;
    private static final int MAX_INITIAL_BUFFER_SIZE = 16777216;
    private SingletonMap<File, PhysicalZipFile, IOException> canonicalFileToPhysicalZipFileMap = new SingletonMap<File, PhysicalZipFile, IOException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.1
        public PhysicalZipFile newInstance(File canonicalFile, LogNode log) throws IOException {
            return new PhysicalZipFile(canonicalFile, NestedJarHandler.this, log);
        }
    };
    private SingletonMap<FastZipEntry, ZipFileSlice, IOException> fastZipEntryToZipFileSliceMap = new SingletonMap<FastZipEntry, ZipFileSlice, IOException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.2
        public ZipFileSlice newInstance(FastZipEntry childZipEntry, LogNode log) throws IOException, InterruptedException {
            ZipFileSlice childZipEntrySlice;
            if (!childZipEntry.isDeflated) {
                childZipEntrySlice = new ZipFileSlice(childZipEntry);
            } else {
                if (log != null) {
                    log.log("Inflating nested zip entry: " + childZipEntry + " ; uncompressed size: " + childZipEntry.uncompressedSize);
                }
                childZipEntrySlice = new ZipFileSlice(new PhysicalZipFile(childZipEntry.getSlice().open(), (childZipEntry.uncompressedSize < 0 || childZipEntry.uncompressedSize > 2147483639) ? -1 : (long) ((int) childZipEntry.uncompressedSize), childZipEntry.entryName, NestedJarHandler.this, log), childZipEntry);
            }
            return childZipEntrySlice;
        }
    };
    private SingletonMap<ZipFileSlice, LogicalZipFile, IOException> zipFileSliceToLogicalZipFileMap = new SingletonMap<ZipFileSlice, LogicalZipFile, IOException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.3
        public LogicalZipFile newInstance(ZipFileSlice zipFileSlice, LogNode log) throws IOException, InterruptedException {
            return new LogicalZipFile(zipFileSlice, NestedJarHandler.this, log);
        }
    };
    public SingletonMap<String, Map.Entry<LogicalZipFile, String>, IOException> nestedPathToLogicalZipFileAndPackageRootMap = new SingletonMap<String, Map.Entry<LogicalZipFile, String>, IOException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.4
        public Map.Entry<LogicalZipFile, String> newInstance(String nestedJarPathRaw, LogNode log) throws IOException, InterruptedException {
            PhysicalZipFile physicalZipFile;
            String nestedJarPath = FastPathResolver.resolve(nestedJarPathRaw);
            int lastPlingIdx = nestedJarPath.lastIndexOf(33);
            if (lastPlingIdx < 0) {
                if (JarUtils.URL_SCHEME_PATTERN.matcher(nestedJarPath).matches()) {
                    String scheme = nestedJarPath.substring(0, nestedJarPath.indexOf(58));
                    if (NestedJarHandler.this.scanSpec.allowedURLSchemes == null || !NestedJarHandler.this.scanSpec.allowedURLSchemes.contains(scheme)) {
                        throw new IOException("Scanning of URL scheme \"" + scheme + "\" has not been enabled -- cannot scan classpath element: " + nestedJarPath);
                    }
                    physicalZipFile = NestedJarHandler.this.downloadJarFromURL(nestedJarPath, log);
                } else {
                    try {
                        physicalZipFile = (PhysicalZipFile) NestedJarHandler.this.canonicalFileToPhysicalZipFileMap.get(new File(nestedJarPath).getCanonicalFile(), log);
                    } catch (SecurityException e) {
                        throw new IOException("Path component " + nestedJarPath + " could not be canonicalized: " + e);
                    } catch (SingletonMap.NullSingletonException e2) {
                        throw new IOException("Could not get PhysicalZipFile for path " + nestedJarPath + " : " + e2);
                    }
                }
                ZipFileSlice topLevelSlice = new ZipFileSlice(physicalZipFile);
                try {
                    return new AbstractMap.SimpleEntry((LogicalZipFile) NestedJarHandler.this.zipFileSliceToLogicalZipFileMap.get(topLevelSlice, log), "");
                } catch (SingletonMap.NullSingletonException e3) {
                    throw new IOException("Could not get toplevel slice " + topLevelSlice + " : " + e3);
                }
            } else {
                String parentPath = nestedJarPath.substring(0, lastPlingIdx);
                String childPath = FileUtils.sanitizeEntryPath(nestedJarPath.substring(lastPlingIdx + 1), true, true);
                try {
                    LogicalZipFile parentLogicalZipFile = NestedJarHandler.this.nestedPathToLogicalZipFileAndPackageRootMap.get(parentPath, log).getKey();
                    boolean isDirectory = false;
                    while (childPath.endsWith("/")) {
                        isDirectory = true;
                        childPath = childPath.substring(0, childPath.length() - 1);
                    }
                    FastZipEntry childZipEntry = null;
                    if (!isDirectory) {
                        Iterator<FastZipEntry> it = parentLogicalZipFile.entries.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            FastZipEntry entry = it.next();
                            if (entry.entryName.equals(childPath)) {
                                childZipEntry = entry;
                                break;
                            }
                        }
                    }
                    if (childZipEntry == null) {
                        String childPathPrefix = childPath + "/";
                        Iterator<FastZipEntry> it2 = parentLogicalZipFile.entries.iterator();
                        while (true) {
                            if (it2.hasNext()) {
                                if (it2.next().entryName.startsWith(childPathPrefix)) {
                                    isDirectory = true;
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                    if (isDirectory) {
                        if (!childPath.isEmpty()) {
                            if (log != null) {
                                log.log("Path " + childPath + " in jarfile " + parentLogicalZipFile + " is a directory, not a file -- using as package root");
                            }
                            parentLogicalZipFile.classpathRoots.add(childPath);
                        }
                        return new AbstractMap.SimpleEntry(parentLogicalZipFile, childPath);
                    } else if (childZipEntry == null) {
                        throw new IOException("Path " + childPath + " does not exist in jarfile " + parentLogicalZipFile);
                    } else if (!NestedJarHandler.this.scanSpec.scanNestedJars) {
                        throw new IOException("Nested jar scanning is disabled -- skipping nested jar " + nestedJarPath);
                    } else {
                        try {
                            ZipFileSlice childZipEntrySlice = (ZipFileSlice) NestedJarHandler.this.fastZipEntryToZipFileSliceMap.get(childZipEntry, log);
                            try {
                                return new AbstractMap.SimpleEntry((LogicalZipFile) NestedJarHandler.this.zipFileSliceToLogicalZipFileMap.get(childZipEntrySlice, log == null ? null : log.log("Getting zipfile slice " + childZipEntrySlice + " for nested jar " + childZipEntry.entryName)), "");
                            } catch (SingletonMap.NullSingletonException e4) {
                                throw new IOException("Could not get child logical zipfile " + childZipEntrySlice + " : " + e4);
                            }
                        } catch (SingletonMap.NullSingletonException e5) {
                            throw new IOException("Could not get child zip entry slice " + childZipEntry + " : " + e5);
                        }
                    }
                } catch (SingletonMap.NullSingletonException e6) {
                    throw new IOException("Could not get parent logical zipfile " + parentPath + " : " + e6);
                }
            }
        }
    };
    public SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException> moduleRefToModuleReaderProxyRecyclerMap = new SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.5
        public Recycler<ModuleReaderProxy, IOException> newInstance(final ModuleRef moduleRef, LogNode ignored) {
            return new Recycler<ModuleReaderProxy, IOException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.5.1
                @Override // nonapi.p019io.github.classgraph.recycler.Recycler
                public ModuleReaderProxy newInstance() throws IOException {
                    return moduleRef.open();
                }
            };
        }
    };
    private Recycler<RecyclableInflater, RuntimeException> inflaterRecycler = new Recycler<RecyclableInflater, RuntimeException>() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.6
        @Override // nonapi.p019io.github.classgraph.recycler.Recycler
        public RecyclableInflater newInstance() throws RuntimeException {
            return new RecyclableInflater();
        }
    };
    private Set<Slice> openSlices = Collections.newSetFromMap(new ConcurrentHashMap());
    private Set<File> tempFiles = Collections.newSetFromMap(new ConcurrentHashMap());
    private final AtomicBoolean closed = new AtomicBoolean(false);

    public NestedJarHandler(ScanSpec scanSpec, InterruptionChecker interruptionChecker) {
        this.scanSpec = scanSpec;
        this.interruptionChecker = interruptionChecker;
    }

    private static String leafname(String path) {
        return path.substring(path.lastIndexOf(47) + 1);
    }

    private String sanitizeFilename(String filename) {
        return filename.replace('/', '_').replace('\\', '_').replace(':', '_').replace('?', '_').replace('&', '_').replace('=', '_').replace(' ', '_');
    }

    public File makeTempFile(String filePathBase, boolean onlyUseLeafname) throws IOException {
        File tempFile = File.createTempFile("ClassGraph--", TEMP_FILENAME_LEAF_SEPARATOR + sanitizeFilename(onlyUseLeafname ? leafname(filePathBase) : filePathBase));
        tempFile.deleteOnExit();
        this.tempFiles.add(tempFile);
        return tempFile;
    }

    void removeTempFile(File tempFile) throws IOException, SecurityException {
        if (this.tempFiles.contains(tempFile)) {
            try {
                Files.delete(tempFile.toPath());
            } finally {
                this.tempFiles.remove(tempFile);
            }
        } else {
            throw new IOException("Not a temp file: " + tempFile);
        }
    }

    public void markSliceAsOpen(Slice slice) throws IOException {
        this.openSlices.add(slice);
    }

    public void markSliceAsClosed(Slice slice) {
        this.openSlices.remove(slice);
    }

    /* access modifiers changed from: private */
    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:35:0x0131
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public nonapi.p019io.github.classgraph.fastzipfilereader.PhysicalZipFile downloadJarFromURL(java.lang.String r10, nonapi.p019io.github.classgraph.utils.LogNode r11) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 530
        */
        throw new UnsupportedOperationException("Method not decompiled: nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler.downloadJarFromURL(java.lang.String, nonapi.io.github.classgraph.utils.LogNode):nonapi.io.github.classgraph.fastzipfilereader.PhysicalZipFile");
    }

    /* access modifiers changed from: private */
    /* renamed from: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler$RecyclableInflater */
    /* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fastzipfilereader/NestedJarHandler$RecyclableInflater.class */
    public static class RecyclableInflater implements Resettable, AutoCloseable {
        private final Inflater inflater;

        private RecyclableInflater() {
            this.inflater = new Inflater(true);
        }

        public Inflater getInflater() {
            return this.inflater;
        }

        @Override // nonapi.p019io.github.classgraph.recycler.Resettable
        public void reset() {
            this.inflater.reset();
        }

        @Override // java.lang.AutoCloseable
        public void close() {
            this.inflater.end();
        }
    }

    public InputStream openInflaterInputStream(final InputStream rawInputStream) throws IOException {
        return new InputStream() { // from class: nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler.7
            private final RecyclableInflater recyclableInflater;
            private final Inflater inflater;
            private final AtomicBoolean closed = new AtomicBoolean();
            private final byte[] buf = new byte[8192];
            private static final int INFLATE_BUF_SIZE = 8192;

            {
                this.recyclableInflater = (RecyclableInflater) NestedJarHandler.this.inflaterRecycler.acquire();
                this.inflater = this.recyclableInflater.getInflater();
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                if (this.closed.get()) {
                    throw new IOException("Already closed");
                } else if (!this.inflater.finished() && read(this.buf, 0, 1) >= 0) {
                    return this.buf[0] & 255;
                } else {
                    return -1;
                }
            }

            @Override // java.io.InputStream
            public int read(byte[] outBuf, int off, int len) throws IOException {
                if (this.closed.get()) {
                    throw new IOException("Already closed");
                } else if (len < 0) {
                    throw new IllegalArgumentException("len cannot be negative");
                } else if (len == 0) {
                    return 0;
                } else {
                    int totInflatedBytes = 0;
                    while (!this.inflater.finished() && totInflatedBytes < len) {
                        try {
                            int numInflatedBytes = this.inflater.inflate(outBuf, off + totInflatedBytes, len - totInflatedBytes);
                            if (numInflatedBytes != 0) {
                                totInflatedBytes += numInflatedBytes;
                            } else if (this.inflater.needsDictionary()) {
                                throw new IOException("Inflater needs preset dictionary");
                            } else if (this.inflater.needsInput()) {
                                int numRawBytesRead = rawInputStream.read(this.buf, 0, this.buf.length);
                                if (numRawBytesRead == -1) {
                                    this.buf[0] = 0;
                                    this.inflater.setInput(this.buf, 0, 1);
                                } else {
                                    this.inflater.setInput(this.buf, 0, numRawBytesRead);
                                }
                            }
                        } catch (DataFormatException e) {
                            throw new ZipException(e.getMessage() != null ? e.getMessage() : "Invalid deflated zip entry data");
                        }
                    }
                    if (totInflatedBytes == 0) {
                        return -1;
                    }
                    return totInflatedBytes;
                }
            }

            @Override // java.io.InputStream
            public long skip(long numToSkip) throws IOException {
                if (this.closed.get()) {
                    throw new IOException("Already closed");
                } else if (numToSkip < 0) {
                    throw new IllegalArgumentException("numToSkip cannot be negative");
                } else if (numToSkip == 0) {
                    return 0;
                } else {
                    if (this.inflater.finished()) {
                        return -1;
                    }
                    long totBytesSkipped = 0;
                    while (true) {
                        int numBytesRead = read(this.buf, 0, (int) Math.min(numToSkip - totBytesSkipped, (long) this.buf.length));
                        if (numBytesRead <= 0) {
                            return totBytesSkipped;
                        }
                        totBytesSkipped -= (long) numBytesRead;
                    }
                }
            }

            @Override // java.io.InputStream
            public int available() throws IOException {
                if (!this.closed.get()) {
                    return this.inflater.finished() ? 0 : 1;
                }
                throw new IOException("Already closed");
            }

            @Override // java.io.InputStream
            public synchronized void mark(int readlimit) {
                throw new IllegalArgumentException("Not supported");
            }

            @Override // java.io.InputStream
            public synchronized void reset() throws IOException {
                throw new IllegalArgumentException("Not supported");
            }

            @Override // java.io.InputStream
            public boolean markSupported() {
                return false;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                if (!this.closed.getAndSet(true)) {
                    try {
                        rawInputStream.close();
                    } catch (IOException e) {
                    } finally {
                        NestedJarHandler.this.inflaterRecycler.recycle(this.recyclableInflater);
                    }
                }
            }
        };
    }

    public Slice readAllBytesWithSpilloverToDisk(InputStream inputStream, String tempFileBaseName, long inputStreamLengthHint, LogNode log) throws IOException {
        int bufSize;
        int bytesRead;
        Throwable th = null;
        try {
            if (inputStreamLengthHint <= ((long) this.scanSpec.maxBufferedJarRAMSize)) {
                if (inputStreamLengthHint == -1) {
                    bufSize = this.scanSpec.maxBufferedJarRAMSize;
                } else {
                    bufSize = inputStreamLengthHint == 0 ? 16384 : Math.min((int) inputStreamLengthHint, this.scanSpec.maxBufferedJarRAMSize);
                }
                byte[] buf = new byte[bufSize];
                int bufLength = buf.length;
                int bufBytesUsed = 0;
                while (true) {
                    bytesRead = inputStream.read(buf, bufBytesUsed, bufLength - bufBytesUsed);
                    if (bytesRead <= 0) {
                        break;
                    }
                    bufBytesUsed += bytesRead;
                }
                if (bytesRead == 0) {
                    byte[] overflowBuf = new byte[1];
                    if (inputStream.read(overflowBuf, 0, 1) == 1) {
                        FileSlice spillToDisk = spillToDisk(inputStream, tempFileBaseName, buf, overflowBuf, log);
                        if (inputStream != null) {
                            if (0 != 0) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            } else {
                                inputStream.close();
                            }
                        }
                        return spillToDisk;
                    }
                }
                if (bufBytesUsed < buf.length) {
                    buf = Arrays.copyOf(buf, bufBytesUsed);
                }
                ArraySlice arraySlice = new ArraySlice(buf, false, 0, this);
                if (inputStream != null) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th3) {
                            th.addSuppressed(th3);
                        }
                    } else {
                        inputStream.close();
                    }
                }
                return arraySlice;
            }
            FileSlice spillToDisk2 = spillToDisk(inputStream, tempFileBaseName, null, null, log);
            if (inputStream != null) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    inputStream.close();
                }
            }
            return spillToDisk2;
        } catch (Throwable th5) {
            if (inputStream != null) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (Throwable th6) {
                        th.addSuppressed(th6);
                    }
                } else {
                    inputStream.close();
                }
            }
            throw th5;
        }
    }

    private FileSlice spillToDisk(InputStream inputStream, String tempFileBaseName, byte[] buf, byte[] overflowBuf, LogNode log) throws IOException {
        try {
            File tempFile = makeTempFile(tempFileBaseName, true);
            if (log != null) {
                log.log("Could not fit InputStream content into max RAM buffer size, saving to temporary file: " + tempFileBaseName + " -> " + tempFile);
            }
            OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(tempFile));
            Throwable th = null;
            if (buf != null) {
                try {
                    outputStream.write(buf);
                    outputStream.write(overflowBuf);
                } catch (Throwable th2) {
                    if (outputStream != null) {
                        if (0 != 0) {
                            try {
                                outputStream.close();
                            } catch (Throwable th3) {
                                th.addSuppressed(th3);
                            }
                        } else {
                            outputStream.close();
                        }
                    }
                    throw th2;
                }
            }
            byte[] copyBuf = new byte[8192];
            while (true) {
                int bytesRead = inputStream.read(copyBuf, 0, copyBuf.length);
                if (bytesRead <= 0) {
                    break;
                }
                outputStream.write(copyBuf, 0, bytesRead);
            }
            if (outputStream != null) {
                if (0 != 0) {
                    try {
                        outputStream.close();
                    } catch (Throwable th4) {
                        th.addSuppressed(th4);
                    }
                } else {
                    outputStream.close();
                }
            }
            return new FileSlice(tempFile, this, log);
        } catch (IOException e) {
            throw new IOException("Could not create temporary file: " + e.getMessage());
        }
    }

    public static byte[] readAllBytesAsArray(InputStream inputStream, long uncompressedLengthHint) throws IOException {
        int bufferSize;
        int extraByte;
        if (uncompressedLengthHint > 2147483639) {
            throw new IOException("InputStream is too large to read");
        }
        Throwable th = null;
        if (uncompressedLengthHint < 1) {
            bufferSize = 16384;
        } else {
            try {
                bufferSize = Math.min((int) uncompressedLengthHint, 16777216);
            } finally {
                if (inputStream != null) {
                    if (0 != 0) {
                        try {
                            inputStream.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    } else {
                        inputStream.close();
                    }
                }
            }
        }
        byte[] buf = new byte[bufferSize];
        int totBytesRead = 0;
        while (true) {
            int bytesRead = inputStream.read(buf, totBytesRead, buf.length - totBytesRead);
            if (bytesRead > 0) {
                totBytesRead += bytesRead;
            } else if (bytesRead >= 0 && (extraByte = inputStream.read()) != -1) {
                if (buf.length == 2147483639) {
                    throw new IOException("InputStream too large to read into array");
                }
                buf = Arrays.copyOf(buf, (int) Math.min(((long) buf.length) * 2, 2147483639L));
                totBytesRead++;
                buf[totBytesRead] = (byte) extraByte;
            }
        }
        return totBytesRead == buf.length ? buf : Arrays.copyOf(buf, totBytesRead);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ae, code lost:
        if (r4.openSlices != null) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00ba, code lost:
        if (r4.openSlices.isEmpty() != false) goto L_0x00f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00bd, code lost:
        r0 = new java.util.ArrayList(r4.openSlices).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d2, code lost:
        if (r0.hasNext() == false) goto L_0x00b1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00d5, code lost:
        r0 = (nonapi.p019io.github.classgraph.fileslice.Slice) r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00e0, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f6, code lost:
        r4.openSlices.clear();
        r4.openSlices = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0108, code lost:
        if (r4.inflaterRecycler == null) goto L_0x0117;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x010b, code lost:
        r4.inflaterRecycler.forceClose();
        r4.inflaterRecycler = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x011b, code lost:
        if (r4.tempFiles == null) goto L_0x019e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0127, code lost:
        if (r4.tempFiles.isEmpty() != false) goto L_0x012e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x012b, code lost:
        if (r5 != null) goto L_0x0132;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x012e, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0132, code lost:
        r0 = r5.log("Removing temporary files");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0142, code lost:
        if (r4.tempFiles.isEmpty() != false) goto L_0x0199;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0145, code lost:
        r0 = new java.util.ArrayList(r4.tempFiles).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x015c, code lost:
        if (r0.hasNext() == false) goto L_0x0139;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x015f, code lost:
        r0 = (java.io.File) r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x016b, code lost:
        removeTempFile(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0177, code lost:
        if (r0 != null) goto L_0x017a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x017a, code lost:
        r0.log("Removing temporary file failed: " + r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0199, code lost:
        r4.tempFiles = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x019f, code lost:
        if (r6 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x01a2, code lost:
        r4.interruptionChecker.interrupt();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x01a9, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(nonapi.p019io.github.classgraph.utils.LogNode r5) {
        /*
        // Method dump skipped, instructions count: 426
        */
        throw new UnsupportedOperationException("Method not decompiled: nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler.close(nonapi.io.github.classgraph.utils.LogNode):void");
    }
}
