package org.eclipse.jetty.server.session;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import net.bytebuddy.utility.JavaConstant;
import org.eclipse.jetty.util.ClassLoadingObjectInputStream;
import org.eclipse.jetty.util.MultiException;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/FileSessionDataStore.class */
public class FileSessionDataStore extends AbstractSessionDataStore {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    protected File _storeDir;
    protected String _contextString;
    protected boolean _deleteUnrestorableFiles = false;
    protected Map<String, String> _sessionFileMap = new ConcurrentHashMap();
    protected long _lastSweepTime = 0;

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore, org.eclipse.jetty.server.session.SessionDataMap
    public void initialize(SessionContext context) throws Exception {
        initialize(context);
        this._contextString = this._context.getCanonicalContextPath() + JavaConstant.Dynamic.DEFAULT_NAME + this._context.getVhost();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        initializeStore();
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._sessionFileMap.clear();
        this._lastSweepTime = 0;
        doStop();
    }

    @ManagedAttribute(value = "dir where sessions are stored", readonly = true)
    public File getStoreDir() {
        return this._storeDir;
    }

    public void setStoreDir(File storeDir) {
        checkStarted();
        this._storeDir = storeDir;
    }

    public boolean isDeleteUnrestorableFiles() {
        return this._deleteUnrestorableFiles;
    }

    public void setDeleteUnrestorableFiles(boolean deleteUnrestorableFiles) {
        checkStarted();
        this._deleteUnrestorableFiles = deleteUnrestorableFiles;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public boolean delete(String id) throws Exception {
        String filename;
        if (this._storeDir == null || (filename = this._sessionFileMap.remove(getIdWithContext(id))) == null) {
            return false;
        }
        return deleteFile(filename);
    }

    public boolean deleteFile(String filename) throws Exception {
        if (filename == null) {
            return false;
        }
        return Files.deleteIfExists(new File(this._storeDir, filename).toPath());
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public Set<String> doGetExpired(Set<String> candidates) {
        long now = System.currentTimeMillis();
        HashSet<String> expired = new HashSet<>();
        for (String filename : this._sessionFileMap.values()) {
            try {
                long expiry = getExpiryFromFilename(filename);
                if (expiry > 0 && expiry < now) {
                    expired.add(getIdFromFilename(filename));
                }
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
        for (String c : candidates) {
            if (!expired.contains(c) && this._sessionFileMap.get(getIdWithContext(c)) == null) {
                expired.add(c);
            }
        }
        if (this._gracePeriodSec > 0 && (this._lastSweepTime == 0 || now - this._lastSweepTime >= 5 * TimeUnit.SECONDS.toMillis((long) this._gracePeriodSec))) {
            this._lastSweepTime = now;
            sweepDisk();
        }
        return expired;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0074
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void sweepDisk() {
        /*
            r7 = this;
            long r0 = java.lang.System.currentTimeMillis()
            r8 = r0
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.FileSessionDataStore.LOG
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0024
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.FileSessionDataStore.LOG
            java.lang.String r1 = "Sweeping {} for old session files"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r7
            java.io.File r5 = r5._storeDir
            r3[r4] = r5
            r0.debug(r1, r2)
        L_0x0024:
            r0 = r7
            java.io.File r0 = r0._storeDir     // Catch: Exception -> 0x0092
            java.nio.file.Path r0 = r0.toPath()     // Catch: Exception -> 0x0092
            r1 = 1
            r2 = 1
            java.nio.file.FileVisitOption[] r2 = new java.nio.file.FileVisitOption[r2]     // Catch: Exception -> 0x0092
            r3 = r2
            r4 = 0
            java.nio.file.FileVisitOption r5 = java.nio.file.FileVisitOption.FOLLOW_LINKS     // Catch: Exception -> 0x0092
            r3[r4] = r5     // Catch: Exception -> 0x0092
            java.util.stream.Stream r0 = java.nio.file.Files.walk(r0, r1, r2)     // Catch: Exception -> 0x0092
            r10 = r0
            r0 = r10
            void r1 = (v0) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return lambda$sweepDisk$0(v0);
            }     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            r1 = r7
            void r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return r1.lambda$sweepDisk$1(v1);
            }     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            r1 = r7
            void r1 = (v1) -> { // java.util.function.Predicate.test(java.lang.Object):boolean
                return r1.lambda$sweepDisk$2(v1);
            }     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            java.util.stream.Stream r0 = r0.filter(r1)     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            r1 = r7
            r2 = r8
            void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$sweepDisk$3(r2, v2);
            }     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            r0.forEach(r1)     // Catch: Exception -> 0x0092, Throwable -> 0x0074
            r0 = r10
            if (r0 == 0) goto L_0x008f
            r0 = r10
            r0.close()     // Catch: Exception -> 0x0092
            goto L_0x008f
        L_0x0074:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L_0x008c
            r0 = r10
            r0.close()     // Catch: Exception -> 0x0092, Throwable -> 0x0083
            goto L_0x008c
        L_0x0083:
            r12 = move-exception
            r0 = r11
            r1 = r12
            r0.addSuppressed(r1)     // Catch: Exception -> 0x0092
        L_0x008c:
            r0 = r11
            throw r0     // Catch: Exception -> 0x0092
        L_0x008f:
            goto L_0x009c
        L_0x0092:
            r10 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.FileSessionDataStore.LOG
            r1 = r10
            r0.warn(r1)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.FileSessionDataStore.sweepDisk():void");
    }

    public void sweepFile(long now, Path p) {
        if (p != null) {
            try {
                long expiry = getExpiryFromFilename(p.getFileName().toString());
                if (expiry > 0 && now - expiry >= 5 * TimeUnit.SECONDS.toMillis((long) this._gracePeriodSec)) {
                    try {
                        if (!Files.deleteIfExists(p)) {
                            LOG.warn("Could not delete {}", p.getFileName());
                        } else if (LOG.isDebugEnabled()) {
                            LOG.debug("Deleted {}", p.getFileName());
                        }
                    } catch (IOException e) {
                        LOG.warn("Could not delete {}", p.getFileName(), e);
                    }
                }
            } catch (NumberFormatException e2) {
                LOG.warn("Not valid session filename {}", p.getFileName());
                LOG.warn(e2);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:20:0x0096
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public org.eclipse.jetty.server.session.SessionData doLoad(java.lang.String r8) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 268
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.FileSessionDataStore.doLoad(java.lang.String):org.eclipse.jetty.server.session.SessionData");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x0054
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore
    public void doStore(java.lang.String r7, org.eclipse.jetty.server.session.SessionData r8, long r9) throws java.lang.Exception {
        /*
            r6 = this;
            r0 = r6
            java.io.File r0 = r0._storeDir
            if (r0 == 0) goto L_0x00a6
            r0 = r6
            r1 = r7
            boolean r0 = r0.delete(r1)
            r0 = r6
            r1 = r8
            java.lang.String r0 = r0.getIdWithContextAndExpiry(r1)
            r12 = r0
            r0 = r6
            r1 = r7
            java.lang.String r0 = r0.getIdWithContext(r1)
            r13 = r0
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r6
            java.io.File r2 = r2._storeDir
            r3 = r12
            r1.<init>(r2, r3)
            r11 = r0
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch: Exception -> 0x006d
            r1 = r0
            r2 = r11
            r3 = 0
            r1.<init>(r2, r3)     // Catch: Exception -> 0x006d
            r14 = r0
            r0 = r6
            r1 = r14
            r2 = r7
            r3 = r8
            r0.save(r1, r2, r3)     // Catch: Exception -> 0x006d, Throwable -> 0x0054
            r0 = r6
            java.util.Map<java.lang.String, java.lang.String> r0 = r0._sessionFileMap     // Catch: Exception -> 0x006d, Throwable -> 0x0054
            r1 = r13
            r2 = r12
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: Exception -> 0x006d, Throwable -> 0x0054
            r0 = r14
            r0.close()     // Catch: Exception -> 0x006d
            goto L_0x006a
        L_0x0054:
            r15 = move-exception
            r0 = r14
            r0.close()     // Catch: Exception -> 0x006d, Throwable -> 0x005e
            goto L_0x0067
        L_0x005e:
            r16 = move-exception
            r0 = r15
            r1 = r16
            r0.addSuppressed(r1)     // Catch: Exception -> 0x006d
        L_0x0067:
            r0 = r15
            throw r0     // Catch: Exception -> 0x006d
        L_0x006a:
            goto L_0x00a6
        L_0x006d:
            r14 = move-exception
            r0 = r11
            boolean r0 = r0.delete()
            if (r0 != 0) goto L_0x0097
            r0 = r14
            java.io.IOException r1 = new java.io.IOException
            r2 = r1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r4 = r3
            r4.<init>()
            java.lang.String r4 = "Could not delete "
            java.lang.StringBuilder r3 = r3.append(r4)
            r4 = r11
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.addSuppressed(r1)
        L_0x0097:
            org.eclipse.jetty.server.session.UnwriteableSessionDataException r0 = new org.eclipse.jetty.server.session.UnwriteableSessionDataException
            r1 = r0
            r2 = r7
            r3 = r6
            org.eclipse.jetty.server.session.SessionContext r3 = r3._context
            r4 = r14
            r1.<init>(r2, r3, r4)
            throw r0
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.FileSessionDataStore.doStore(java.lang.String, org.eclipse.jetty.server.session.SessionData, long):void");
    }

    public void initializeStore() throws Exception {
        if (this._storeDir == null) {
            throw new IllegalStateException("No file store specified");
        } else if (!this._storeDir.exists()) {
            if (!this._storeDir.mkdirs()) {
                throw new IllegalStateException("Could not create " + this._storeDir);
            }
        } else if (!this._storeDir.isDirectory() || !this._storeDir.canWrite() || !this._storeDir.canRead()) {
            throw new IllegalStateException(this._storeDir.getAbsolutePath() + " must be readable/writeable dir");
        } else {
            MultiException me = new MultiException();
            long now = System.currentTimeMillis();
            Stream<Path> stream = Files.walk(this._storeDir.toPath(), 1, FileVisitOption.FOLLOW_LINKS);
            try {
                stream.filter(p -> {
                    return !Files.isDirectory(p, new LinkOption[0]);
                }).filter(p -> {
                    return isSessionFilename(p.getFileName().toString());
                }).forEach(p -> {
                    String sessionIdWithContext;
                    String existing;
                    sweepFile(now, me);
                    String filename = me.getFileName().toString();
                    String context = getContextFromFilename(filename);
                    if (Files.exists(me, new LinkOption[0]) && this._contextString.equals(context) && (sessionIdWithContext = getIdWithContextFromFilename(filename)) != null && (existing = this._sessionFileMap.putIfAbsent(sessionIdWithContext, filename)) != null) {
                        try {
                            if (getExpiryFromFilename(filename) > getExpiryFromFilename(existing)) {
                                Path existingPath = this._storeDir.toPath().resolve(existing);
                                this._sessionFileMap.put(sessionIdWithContext, filename);
                                Files.delete(existingPath);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Replaced {} with {}", existing, filename);
                                }
                            } else {
                                Files.delete(me);
                                if (LOG.isDebugEnabled()) {
                                    LOG.debug("Deleted expired session file {}", filename);
                                }
                            }
                        } catch (IOException e) {
                            now.add(e);
                        }
                    }
                });
                me.ifExceptionThrow();
                if (stream != null) {
                    stream.close();
                }
            } catch (Throwable th) {
                if (stream != null) {
                    try {
                        stream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    @ManagedAttribute(value = "are sessions serialized by this store", readonly = true)
    public boolean isPassivating() {
        return true;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public boolean exists(String id) throws Exception {
        String filename = this._sessionFileMap.get(getIdWithContext(id));
        if (filename == null) {
            return false;
        }
        long expiry = getExpiryFromFilename(filename);
        return expiry <= 0 || expiry > System.currentTimeMillis();
    }

    protected void save(OutputStream os, String id, SessionData data) throws IOException {
        DataOutputStream out = new DataOutputStream(os);
        out.writeUTF(id);
        out.writeUTF(this._context.getCanonicalContextPath());
        out.writeUTF(this._context.getVhost());
        out.writeUTF(data.getLastNode());
        out.writeLong(data.getCreated());
        out.writeLong(data.getAccessed());
        out.writeLong(data.getLastAccessed());
        out.writeLong(data.getCookieSet());
        out.writeLong(data.getExpiry());
        out.writeLong(data.getMaxInactiveMs());
        SessionData.serializeAttributes(data, new ObjectOutputStream(out));
    }

    protected String getIdWithContext(String id) {
        return this._contextString + JavaConstant.Dynamic.DEFAULT_NAME + id;
    }

    protected String getIdWithContextAndExpiry(SessionData data) {
        return "" + data.getExpiry() + JavaConstant.Dynamic.DEFAULT_NAME + getIdWithContext(data.getId());
    }

    protected String getIdFromFilename(String filename) {
        if (filename == null) {
            return null;
        }
        return filename.substring(filename.lastIndexOf(95) + 1);
    }

    protected long getExpiryFromFilename(String filename) {
        if (!StringUtil.isBlank(filename) && filename.contains(JavaConstant.Dynamic.DEFAULT_NAME)) {
            return Long.parseLong(filename.substring(0, filename.indexOf(95)));
        }
        throw new IllegalStateException("Invalid or missing filename");
    }

    protected String getContextFromFilename(String filename) {
        if (StringUtil.isBlank(filename)) {
            return null;
        }
        return filename.substring(filename.indexOf(95) + 1, filename.lastIndexOf(95));
    }

    protected String getIdWithContextFromFilename(String filename) {
        if (StringUtil.isBlank(filename) || filename.indexOf(95) < 0) {
            return null;
        }
        return filename.substring(filename.indexOf(95) + 1);
    }

    protected boolean isSessionFilename(String filename) {
        return !StringUtil.isBlank(filename) && filename.split(JavaConstant.Dynamic.DEFAULT_NAME).length >= 4;
    }

    protected boolean isOurContextSessionFilename(String filename) {
        String context;
        if (!StringUtil.isBlank(filename) && filename.split(JavaConstant.Dynamic.DEFAULT_NAME).length >= 4 && (context = getContextFromFilename(filename)) != null) {
            return this._contextString.equals(context);
        }
        return false;
    }

    protected SessionData load(InputStream is, String expectedId) throws Exception {
        try {
            DataInputStream di = new DataInputStream(is);
            String id = di.readUTF();
            String contextPath = di.readUTF();
            String vhost = di.readUTF();
            String lastNode = di.readUTF();
            long created = di.readLong();
            long accessed = di.readLong();
            long lastAccessed = di.readLong();
            long cookieSet = di.readLong();
            long expiry = di.readLong();
            long maxIdle = di.readLong();
            SessionData data = newSessionData(id, created, accessed, lastAccessed, maxIdle);
            data.setContextPath(contextPath);
            data.setVhost(vhost);
            data.setLastNode(lastNode);
            data.setCookieSet(cookieSet);
            data.setExpiry(expiry);
            data.setMaxInactiveMs(maxIdle);
            SessionData.deserializeAttributes(data, new ClassLoadingObjectInputStream(is));
            return data;
        } catch (Exception e) {
            throw new UnreadableSessionDataException(expectedId, this._context, e);
        }
    }

    @Override // org.eclipse.jetty.server.session.AbstractSessionDataStore, org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[dir=%s,deleteUnrestorableFiles=%b]", toString(), this._storeDir, Boolean.valueOf(this._deleteUnrestorableFiles));
    }
}
