package org.eclipse.jetty.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.function.Predicate;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner.class */
public class Scanner extends AbstractLifeCycle {
    public static final int DEFAULT_SCAN_DEPTH = 1;
    public static final int MAX_SCAN_DEPTH = Integer.MAX_VALUE;
    private static final Logger LOG = Log.getLogger(Scanner.class);
    private static int __scannerId = 0;
    private int _scanInterval;
    private FilenameFilter _filter;
    private Timer _timer;
    private TimerTask _task;
    private int _scanCount = 0;
    private final List<Listener> _listeners = new ArrayList();
    private final Map<String, TimeNSize> _prevScan = new HashMap();
    private final Map<String, TimeNSize> _currentScan = new HashMap();
    private final Map<Path, IncludeExcludeSet<PathMatcher, Path>> _scannables = new HashMap();
    private volatile boolean _running = false;
    private boolean _reportExisting = true;
    private boolean _reportDirs = true;
    private int _scanDepth = 1;
    private final Map<String, Notification> _notifications = new HashMap();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$BulkListener.class */
    public interface BulkListener extends Listener {
        void filesChanged(List<String> list) throws Exception;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$DiscreteListener.class */
    public interface DiscreteListener extends Listener {
        void fileChanged(String str) throws Exception;

        void fileAdded(String str) throws Exception;

        void fileRemoved(String str) throws Exception;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$Listener.class */
    public interface Listener {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$Notification.class */
    public enum Notification {
        ADDED,
        CHANGED,
        REMOVED
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$ScanCycleListener.class */
    public interface ScanCycleListener extends Listener {
        void scanStarted(int i) throws Exception;

        void scanEnded(int i) throws Exception;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$ScanListener.class */
    public interface ScanListener extends Listener {
        void scan();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$PathMatcherSet.class */
    static class PathMatcherSet extends HashSet<PathMatcher> implements Predicate<Path> {
        PathMatcherSet() {
        }

        public boolean test(Path p) {
            Iterator<PathMatcher> it = iterator();
            while (it.hasNext()) {
                if (it.next().matches(p)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$TimeNSize.class */
    public static class TimeNSize {
        final long _lastModified;
        final long _size;

        public TimeNSize(long lastModified, long size) {
            this._lastModified = lastModified;
            this._size = size;
        }

        public int hashCode() {
            return ((int) this._lastModified) ^ ((int) this._size);
        }

        public boolean equals(Object o) {
            if (!(o instanceof TimeNSize)) {
                return false;
            }
            TimeNSize tns = (TimeNSize) o;
            return tns._lastModified == this._lastModified && tns._size == this._size;
        }

        public String toString() {
            return "[lm=" + this._lastModified + ",s=" + this._size + "]";
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/Scanner$Visitor.class */
    public class Visitor implements FileVisitor<Path> {
        Map<String, TimeNSize> scanInfoMap;
        IncludeExcludeSet<PathMatcher, Path> rootIncludesExcludes;
        Path root;

        public Visitor(Path root, IncludeExcludeSet<PathMatcher, Path> rootIncludesExcludes, Map<String, TimeNSize> scanInfoMap) {
            this.root = root;
            this.rootIncludesExcludes = rootIncludesExcludes;
            this.scanInfoMap = scanInfoMap;
        }

        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            if (!Files.exists(dir, new LinkOption[0])) {
                return FileVisitResult.SKIP_SUBTREE;
            }
            File f = dir.toFile();
            if (Scanner.this._reportDirs && !this.scanInfoMap.containsKey(f.getCanonicalPath())) {
                boolean accepted = false;
                if (this.rootIncludesExcludes == null || this.rootIncludesExcludes.isEmpty()) {
                    if (Scanner.this._filter == null || Scanner.this._filter.accept(f.getParentFile(), f.getName())) {
                        accepted = true;
                    }
                } else if (this.rootIncludesExcludes.test(dir)) {
                    accepted = true;
                }
                if (accepted) {
                    this.scanInfoMap.put(f.getCanonicalPath(), new TimeNSize(f.lastModified(), f.isDirectory() ? 0 : f.length()));
                    if (Scanner.LOG.isDebugEnabled()) {
                        Scanner.LOG.debug("scan accepted dir {} mod={}", f, Long.valueOf(f.lastModified()));
                    }
                }
            }
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            if (!Files.exists(file, new LinkOption[0])) {
                return FileVisitResult.CONTINUE;
            }
            File f = file.toFile();
            boolean accepted = false;
            if (f.isFile() || (f.isDirectory() && Scanner.this._reportDirs && !this.scanInfoMap.containsKey(f.getCanonicalPath()))) {
                if (this.rootIncludesExcludes == null || this.rootIncludesExcludes.isEmpty()) {
                    if (Scanner.this._filter == null || Scanner.this._filter.accept(f.getParentFile(), f.getName())) {
                        accepted = true;
                    }
                } else if (this.rootIncludesExcludes.test(file)) {
                    accepted = true;
                }
            }
            if (accepted) {
                this.scanInfoMap.put(f.getCanonicalPath(), new TimeNSize(f.lastModified(), f.isDirectory() ? 0 : f.length()));
                if (Scanner.LOG.isDebugEnabled()) {
                    Scanner.LOG.debug("scan accepted {} mod={}", f, Long.valueOf(f.lastModified()));
                }
            }
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            Scanner.LOG.warn(exc);
            return FileVisitResult.CONTINUE;
        }

        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }

    public synchronized int getScanInterval() {
        return this._scanInterval;
    }

    public synchronized void setScanInterval(int scanInterval) {
        this._scanInterval = scanInterval;
        schedule();
    }

    public void setScanDirs(List<File> dirs) {
        this._scannables.clear();
        if (dirs != null) {
            for (File f : dirs) {
                addScanDir(f);
            }
        }
    }

    @Deprecated
    public synchronized void addScanDir(File dir) {
        if (dir != null) {
            try {
                if (dir.isDirectory()) {
                    addDirectory(dir.toPath());
                } else {
                    addFile(dir.toPath());
                }
            } catch (Exception e) {
                LOG.warn(e);
            }
        }
    }

    public synchronized void addFile(Path p) throws IOException {
        if (p == null) {
            throw new IllegalStateException("Null path");
        }
        File f = p.toFile();
        if (!f.exists() || f.isDirectory()) {
            throw new IllegalStateException("Not file or doesn't exist: " + f.getCanonicalPath());
        }
        this._scannables.put(p, null);
    }

    public synchronized IncludeExcludeSet<PathMatcher, Path> addDirectory(Path p) throws IOException {
        if (p == null) {
            throw new IllegalStateException("Null path");
        }
        File f = p.toFile();
        if (!f.exists() || !f.isDirectory()) {
            throw new IllegalStateException("Not directory or doesn't exist: " + f.getCanonicalPath());
        }
        IncludeExcludeSet<PathMatcher, Path> includesExcludes = this._scannables.get(p);
        if (includesExcludes == null) {
            includesExcludes = new IncludeExcludeSet<>(PathMatcherSet.class);
            this._scannables.put(p.toRealPath(new LinkOption[0]), includesExcludes);
        }
        return includesExcludes;
    }

    @Deprecated
    public List<File> getScanDirs() {
        ArrayList<File> files = new ArrayList<>();
        for (Path p : this._scannables.keySet()) {
            files.add(p.toFile());
        }
        return Collections.unmodifiableList(files);
    }

    public Set<Path> getScannables() {
        return this._scannables.keySet();
    }

    @Deprecated
    public void setRecursive(boolean recursive) {
        this._scanDepth = recursive ? Integer.MAX_VALUE : 1;
    }

    @Deprecated
    public boolean getRecursive() {
        return this._scanDepth > 1;
    }

    public int getScanDepth() {
        return this._scanDepth;
    }

    public void setScanDepth(int scanDepth) {
        this._scanDepth = scanDepth;
    }

    @Deprecated
    public void setFilenameFilter(FilenameFilter filter) {
        this._filter = filter;
    }

    @Deprecated
    public FilenameFilter getFilenameFilter() {
        return this._filter;
    }

    public void setReportExistingFilesOnStartup(boolean reportExisting) {
        this._reportExisting = reportExisting;
    }

    public boolean getReportExistingFilesOnStartup() {
        return this._reportExisting;
    }

    public void setReportDirs(boolean dirs) {
        this._reportDirs = dirs;
    }

    public boolean getReportDirs() {
        return this._reportDirs;
    }

    public synchronized void addListener(Listener listener) {
        if (listener != null) {
            this._listeners.add(listener);
        }
    }

    public synchronized void removeListener(Listener listener) {
        if (listener != null) {
            this._listeners.remove(listener);
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() {
        if (!this._running) {
            this._running = true;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Scanner start: rprtExists={}, depth={}, rprtDirs={}, interval={}, filter={}, scannables={}", Boolean.valueOf(this._reportExisting), Integer.valueOf(this._scanDepth), Boolean.valueOf(this._reportDirs), Integer.valueOf(this._scanInterval), this._filter, this._scannables);
            }
            if (this._reportExisting) {
                scan();
                scan();
            } else {
                scanFiles();
                this._prevScan.putAll(this._currentScan);
            }
            schedule();
        }
    }

    public TimerTask newTimerTask() {
        return new TimerTask() { // from class: org.eclipse.jetty.util.Scanner.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                Scanner.this.scan();
            }
        };
    }

    public Timer newTimer() {
        StringBuilder append = new StringBuilder().append("Scanner-");
        int i = __scannerId;
        __scannerId = i + 1;
        return new Timer(append.append(i).toString(), true);
    }

    public void schedule() {
        if (this._running) {
            if (this._timer != null) {
                this._timer.cancel();
            }
            if (this._task != null) {
                this._task.cancel();
            }
            if (getScanInterval() > 0) {
                this._timer = newTimer();
                this._task = newTimerTask();
                this._timer.schedule(this._task, 1010 * ((long) getScanInterval()), 1010 * ((long) getScanInterval()));
            }
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStop() {
        if (this._running) {
            this._running = false;
            if (this._timer != null) {
                this._timer.cancel();
            }
            if (this._task != null) {
                this._task.cancel();
            }
            this._task = null;
            this._timer = null;
        }
    }

    public void reset() {
        if (!isStopped()) {
            throw new IllegalStateException("Not stopped");
        }
        this._scannables.clear();
        this._currentScan.clear();
        this._prevScan.clear();
    }

    public boolean exists(String path) {
        for (Path p : this._scannables.keySet()) {
            if (p.resolve(path).toFile().exists()) {
                return true;
            }
        }
        return false;
    }

    public synchronized void scan() {
        int i = this._scanCount + 1;
        this._scanCount = i;
        reportScanStart(i);
        scanFiles();
        reportDifferences(this._currentScan, this._prevScan);
        this._prevScan.clear();
        this._prevScan.putAll(this._currentScan);
        reportScanEnd(this._scanCount);
        for (Listener l : this._listeners) {
            try {
                if (l instanceof ScanListener) {
                    ((ScanListener) l).scan();
                }
            } catch (Throwable e) {
                LOG.warn(e);
            }
        }
    }

    public synchronized void scanFiles() {
        this._currentScan.clear();
        for (Map.Entry<Path, IncludeExcludeSet<PathMatcher, Path>> entry : this._scannables.entrySet()) {
            Path p = entry.getKey();
            try {
                Files.walkFileTree(p, EnumSet.allOf(FileVisitOption.class), this._scanDepth, new Visitor(p, entry.getValue(), this._currentScan));
            } catch (IOException e) {
                LOG.warn("Error scanning files.", e);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:72:0x0224 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x022d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0236 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void reportDifferences(java.util.Map<java.lang.String, org.eclipse.jetty.util.Scanner.TimeNSize> r5, java.util.Map<java.lang.String, org.eclipse.jetty.util.Scanner.TimeNSize> r6) {
        /*
        // Method dump skipped, instructions count: 592
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.Scanner.reportDifferences(java.util.Map, java.util.Map):void");
    }

    private void warn(Object listener, String filename, Throwable th) {
        LOG.warn(listener + " failed on '" + filename, th);
    }

    private void reportAddition(String filename) {
        for (Listener l : this._listeners) {
            try {
                if (l instanceof DiscreteListener) {
                    ((DiscreteListener) l).fileAdded(filename);
                }
            } catch (Throwable e) {
                warn(l, filename, e);
            }
        }
    }

    private void reportRemoval(String filename) {
        for (Object l : this._listeners) {
            try {
                if (l instanceof DiscreteListener) {
                    ((DiscreteListener) l).fileRemoved(filename);
                }
            } catch (Throwable e) {
                warn(l, filename, e);
            }
        }
    }

    private void reportChange(String filename) {
        for (Listener l : this._listeners) {
            try {
                if (l instanceof DiscreteListener) {
                    ((DiscreteListener) l).fileChanged(filename);
                }
            } catch (Throwable e) {
                warn(l, filename, e);
            }
        }
    }

    private void reportBulkChanges(List<String> filenames) {
        for (Listener l : this._listeners) {
            try {
                if (l instanceof BulkListener) {
                    ((BulkListener) l).filesChanged(filenames);
                }
            } catch (Throwable e) {
                warn(l, filenames.toString(), e);
            }
        }
    }

    private void reportScanStart(int cycle) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof ScanCycleListener) {
                    ((ScanCycleListener) listener).scanStarted(cycle);
                }
            } catch (Exception e) {
                LOG.warn(listener + " failed on scan start for cycle " + cycle, e);
            }
        }
    }

    private void reportScanEnd(int cycle) {
        for (Listener listener : this._listeners) {
            try {
                if (listener instanceof ScanCycleListener) {
                    ((ScanCycleListener) listener).scanEnded(cycle);
                }
            } catch (Exception e) {
                LOG.warn(listener + " failed on scan end for cycle " + cycle, e);
            }
        }
    }
}
