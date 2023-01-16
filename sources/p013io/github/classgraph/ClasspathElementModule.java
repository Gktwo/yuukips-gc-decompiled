package p013io.github.classgraph;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import nonapi.p019io.github.classgraph.concurrency.SingletonMap;
import nonapi.p019io.github.classgraph.concurrency.WorkQueue;
import nonapi.p019io.github.classgraph.fileslice.reader.ClassfileReader;
import nonapi.p019io.github.classgraph.recycler.Recycler;
import nonapi.p019io.github.classgraph.scanspec.ScanSpec;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p013io.github.classgraph.Scanner;

/* access modifiers changed from: package-private */
/* renamed from: io.github.classgraph.ClasspathElementModule */
/* loaded from: grasscutter.jar:io/github/classgraph/ClasspathElementModule.class */
public class ClasspathElementModule extends ClasspathElement {
    final ModuleRef moduleRef;
    SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException> moduleRefToModuleReaderProxyRecyclerMap;
    private Recycler<ModuleReaderProxy, IOException> moduleReaderProxyRecycler;
    private final Set<String> allResourcePaths = new HashSet();

    /* access modifiers changed from: package-private */
    public ClasspathElementModule(ModuleRef moduleRef, ClassLoader classLoader, SingletonMap<ModuleRef, Recycler<ModuleReaderProxy, IOException>, IOException> moduleRefToModuleReaderProxyRecyclerMap, ScanSpec scanSpec) {
        super(classLoader, scanSpec);
        this.moduleRefToModuleReaderProxyRecyclerMap = moduleRefToModuleReaderProxyRecyclerMap;
        this.moduleRef = moduleRef;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public void open(WorkQueue<Scanner.ClasspathEntryWorkUnit> workQueueIgnored, LogNode log) throws InterruptedException {
        if (!this.scanSpec.scanModules) {
            if (log != null) {
                log(this.classpathElementIdx, "Skipping module, since module scanning is disabled: " + getModuleName(), log);
            }
            this.skipClasspathElement = true;
            return;
        }
        try {
            this.moduleReaderProxyRecycler = this.moduleRefToModuleReaderProxyRecyclerMap.get(this.moduleRef, log);
        } catch (IOException | SingletonMap.NullSingletonException e) {
            if (log != null) {
                log(this.classpathElementIdx, "Skipping invalid module " + getModuleName() + " : " + e, log);
            }
            this.skipClasspathElement = true;
        }
    }

    private Resource newResource(final String resourcePath) {
        return new Resource(this, -1) { // from class: io.github.classgraph.ClasspathElementModule.1
            private ModuleReaderProxy moduleReaderProxy;
            protected AtomicBoolean isOpen = new AtomicBoolean();

            @Override // p013io.github.classgraph.Resource
            public String getPath() {
                return resourcePath;
            }

            @Override // p013io.github.classgraph.Resource
            public String getPathRelativeToClasspathElement() {
                return resourcePath;
            }

            @Override // p013io.github.classgraph.Resource
            public long getLastModified() {
                return 0;
            }

            @Override // p013io.github.classgraph.Resource
            public Set<PosixFilePermission> getPosixFilePermissions() {
                return null;
            }

            @Override // p013io.github.classgraph.Resource
            public ByteBuffer read() throws IOException {
                if (ClasspathElementModule.this.skipClasspathElement) {
                    throw new IOException("Module could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    try {
                        this.moduleReaderProxy = (ModuleReaderProxy) ClasspathElementModule.this.moduleReaderProxyRecycler.acquire();
                        this.byteBuffer = this.moduleReaderProxy.read(resourcePath);
                        this.length = (long) this.byteBuffer.remaining();
                        return this.byteBuffer;
                    } catch (OutOfMemoryError | SecurityException e) {
                        close();
                        throw new IOException("Could not open " + this, e);
                    }
                }
            }

            /* access modifiers changed from: package-private */
            @Override // p013io.github.classgraph.Resource
            public ClassfileReader openClassfile() throws IOException {
                return new ClassfileReader(open());
            }

            @Override // p013io.github.classgraph.Resource
            public InputStream open() throws IOException {
                if (ClasspathElementModule.this.skipClasspathElement) {
                    throw new IOException("Module could not be opened");
                } else if (this.isOpen.getAndSet(true)) {
                    throw new IOException("Resource is already open -- cannot open it again without first calling close()");
                } else {
                    try {
                        this.moduleReaderProxy = (ModuleReaderProxy) ClasspathElementModule.this.moduleReaderProxyRecycler.acquire();
                        this.inputStream = this.moduleReaderProxy.open(resourcePath);
                        this.length = -1;
                        return this.inputStream;
                    } catch (SecurityException e) {
                        close();
                        throw new IOException("Could not open " + this, e);
                    }
                }
            }

            @Override // p013io.github.classgraph.Resource
            public byte[] load() throws IOException {
                byte[] byteArray;
                read();
                Throwable th = null;
                try {
                    if (this.byteBuffer.hasArray() && this.byteBuffer.position() == 0 && this.byteBuffer.limit() == this.byteBuffer.capacity()) {
                        byteArray = this.byteBuffer.array();
                    } else {
                        byteArray = new byte[this.byteBuffer.remaining()];
                        this.byteBuffer.get(byteArray);
                    }
                    this.length = (long) byteArray.length;
                    if (this != null) {
                        if (0 != 0) {
                            try {
                                close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        } else {
                            close();
                        }
                    }
                    return byteArray;
                } catch (Throwable th3) {
                    if (this != null) {
                        if (0 != 0) {
                            try {
                                close();
                            } catch (Throwable th4) {
                                th.addSuppressed(th4);
                            }
                        } else {
                            close();
                        }
                    }
                    throw th3;
                }
            }

            @Override // p013io.github.classgraph.Resource, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                close();
                if (this.isOpen.getAndSet(false) && this.moduleReaderProxy != null) {
                    if (this.byteBuffer != null) {
                        this.moduleReaderProxy.release(this.byteBuffer);
                    }
                    ClasspathElementModule.this.moduleReaderProxyRecycler.recycle(this.moduleReaderProxy);
                    this.moduleReaderProxy = null;
                }
            }
        };
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public Resource getResource(String relativePath) {
        if (this.allResourcePaths.contains(relativePath)) {
            return newResource(relativePath);
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x008d
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // p013io.github.classgraph.ClasspathElement
    void scanPaths(nonapi.p019io.github.classgraph.utils.LogNode r7) {
        /*
        // Method dump skipped, instructions count: 806
        */
        throw new UnsupportedOperationException("Method not decompiled: p013io.github.classgraph.ClasspathElementModule.scanPaths(nonapi.io.github.classgraph.utils.LogNode):void");
    }

    /* access modifiers changed from: package-private */
    public ModuleRef getModuleRef() {
        return this.moduleRef;
    }

    @Override // p013io.github.classgraph.ClasspathElement
    public String getModuleName() {
        String moduleName = this.moduleRef.getName();
        if (moduleName == null || moduleName.isEmpty()) {
            moduleName = this.moduleNameFromModuleDescriptor;
        }
        if (moduleName == null || moduleName.isEmpty()) {
            return null;
        }
        return moduleName;
    }

    private String getModuleNameOrEmpty() {
        String moduleName = getModuleName();
        return moduleName == null ? "" : moduleName;
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public URI getURI() {
        URI uri = this.moduleRef.getLocation();
        if (uri != null) {
            return uri;
        }
        throw new IllegalArgumentException("Module " + getModuleName() + " has a null location");
    }

    /* access modifiers changed from: package-private */
    @Override // p013io.github.classgraph.ClasspathElement
    public File getFile() {
        try {
            URI uri = this.moduleRef.getLocation();
            if (uri == null || uri.getScheme().equals("jrt")) {
                return null;
            }
            File file = new File(uri);
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public String toString() {
        return this.moduleRef.toString();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClasspathElementModule)) {
            return false;
        }
        return getModuleNameOrEmpty().equals(((ClasspathElementModule) obj).getModuleNameOrEmpty());
    }

    public int hashCode() {
        return getModuleNameOrEmpty().hashCode();
    }
}
