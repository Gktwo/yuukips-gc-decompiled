package org.eclipse.jetty.util;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.IOException;
import java.nio.file.ClosedWatchServiceException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.EventListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher.class */
public class PathWatcher extends AbstractLifeCycle implements Runnable {
    private static final boolean IS_WINDOWS;
    static final Logger LOG;
    private static final WatchEvent.Kind<?>[] WATCH_EVENT_KINDS;
    private static final WatchEvent.Kind<?>[] WATCH_DIR_KINDS;
    private WatchService watchService;
    private Thread thread;
    private final List<Config> configs = new ArrayList();
    private final Map<WatchKey, Config> keys = new ConcurrentHashMap();
    private final List<EventListener> listeners = new CopyOnWriteArrayList();
    private final Map<Path, PathWatchEvent> pending = new LinkedHashMap(32, 0.75f, false);
    private final List<PathWatchEvent> events = new ArrayList();
    private long updateQuietTimeDuration = 1000;
    private TimeUnit updateQuietTimeUnit = TimeUnit.MILLISECONDS;
    private boolean _notifyExistingOnStart = true;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$DirAction.class */
    public enum DirAction {
        IGNORE,
        WATCH,
        ENTER
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$EventListListener.class */
    public interface EventListListener extends EventListener {
        void onPathWatchEvents(List<PathWatchEvent> list);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$Listener.class */
    public interface Listener extends EventListener {
        void onPathWatchEvent(PathWatchEvent pathWatchEvent);
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$PathWatchEventType.class */
    public enum PathWatchEventType {
        ADDED,
        DELETED,
        MODIFIED,
        UNKNOWN
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$Config.class */
    public static class Config implements Predicate<Path> {
        public static final int UNLIMITED_DEPTH = -9999;
        private static final String PATTERN_SEP;
        protected final Config parent;
        protected final Path path;
        protected final IncludeExcludeSet<PathMatcher, Path> includeExclude;
        protected int recurseDepth;
        protected boolean excludeHidden;
        protected long pauseUntil;

        static {
            String sep = File.separator;
            if (File.separatorChar == '\\') {
                sep = "\\\\";
            }
            PATTERN_SEP = sep;
        }

        public Config(Path path) {
            this(path, null);
        }

        public Config(Path path, Config parent) {
            this.recurseDepth = 0;
            this.excludeHidden = false;
            this.parent = parent;
            this.includeExclude = parent == null ? new IncludeExcludeSet<>(PathMatcherSet.class) : parent.includeExclude;
            Path dir = path;
            if (!Files.exists(path, new LinkOption[0])) {
                throw new IllegalStateException("Path does not exist: " + path);
            }
            if (!Files.isDirectory(path, new LinkOption[0])) {
                dir = path.getParent();
                this.includeExclude.include((IncludeExcludeSet<PathMatcher, Path>) new ExactPathMatcher(path));
                setRecurseDepth(0);
            }
            this.path = dir;
        }

        public Config getParent() {
            return this.parent;
        }

        public void setPauseUntil(long time) {
            if (time > this.pauseUntil) {
                this.pauseUntil = time;
            }
        }

        public boolean isPaused(long now) {
            if (this.pauseUntil == 0) {
                return false;
            }
            if (this.pauseUntil <= now) {
                if (PathWatcher.LOG.isDebugEnabled()) {
                    PathWatcher.LOG.debug("unpaused {}", this);
                }
                this.pauseUntil = 0;
                return false;
            } else if (!PathWatcher.LOG.isDebugEnabled()) {
                return true;
            } else {
                PathWatcher.LOG.debug("PAUSED {}", this);
                return true;
            }
        }

        public void addExclude(PathMatcher matcher) {
            this.includeExclude.exclude((IncludeExcludeSet<PathMatcher, Path>) matcher);
        }

        public void addExclude(String syntaxAndPattern) {
            if (PathWatcher.LOG.isDebugEnabled()) {
                PathWatcher.LOG.debug("Adding exclude: [{}]", syntaxAndPattern);
            }
            addExclude(this.path.getFileSystem().getPathMatcher(syntaxAndPattern));
        }

        public void addExcludeGlobRelative(String pattern) {
            addExclude(toGlobPattern(this.path, pattern));
        }

        public void addExcludeHidden() {
            if (!this.excludeHidden) {
                if (PathWatcher.LOG.isDebugEnabled()) {
                    PathWatcher.LOG.debug("Adding hidden files and directories to exclusions", new Object[0]);
                }
                this.excludeHidden = true;
            }
        }

        public void addExcludes(List<String> syntaxAndPatterns) {
            for (String syntaxAndPattern : syntaxAndPatterns) {
                addExclude(syntaxAndPattern);
            }
        }

        public void addInclude(PathMatcher matcher) {
            this.includeExclude.include((IncludeExcludeSet<PathMatcher, Path>) matcher);
        }

        public void addInclude(String syntaxAndPattern) {
            if (PathWatcher.LOG.isDebugEnabled()) {
                PathWatcher.LOG.debug("Adding include: [{}]", syntaxAndPattern);
            }
            addInclude(this.path.getFileSystem().getPathMatcher(syntaxAndPattern));
        }

        public void addIncludeGlobRelative(String pattern) {
            addInclude(toGlobPattern(this.path, pattern));
        }

        public void addIncludes(List<String> syntaxAndPatterns) {
            for (String syntaxAndPattern : syntaxAndPatterns) {
                addInclude(syntaxAndPattern);
            }
        }

        public Config asSubConfig(Path dir) {
            Config subconfig = new Config(dir, this);
            if (dir == this.path) {
                throw new IllegalStateException("sub " + dir.toString() + " of " + this);
            }
            if (this.recurseDepth == -9999) {
                subconfig.recurseDepth = UNLIMITED_DEPTH;
            } else {
                subconfig.recurseDepth = this.recurseDepth - (dir.getNameCount() - this.path.getNameCount());
            }
            if (PathWatcher.LOG.isDebugEnabled()) {
                PathWatcher.LOG.debug("subconfig {} of {}", subconfig, this.path);
            }
            return subconfig;
        }

        public int getRecurseDepth() {
            return this.recurseDepth;
        }

        public boolean isRecurseDepthUnlimited() {
            return this.recurseDepth == -9999;
        }

        public Path getPath() {
            return this.path;
        }

        public Path resolve(Path path) {
            if (Files.isDirectory(this.path, new LinkOption[0])) {
                return this.path.resolve(path);
            }
            if (Files.exists(this.path, new LinkOption[0])) {
                return this.path;
            }
            return path;
        }

        public boolean test(Path path) {
            int depth;
            if (!this.excludeHidden || !isHidden(path)) {
                if (!path.startsWith(this.path)) {
                    if (!PathWatcher.LOG.isDebugEnabled()) {
                        return false;
                    }
                    PathWatcher.LOG.debug("test({}) -> [!child {}]", toShortPath(path), this.path);
                    return false;
                } else if (this.recurseDepth == -9999 || (depth = (path.getNameCount() - this.path.getNameCount()) - 1) <= this.recurseDepth) {
                    boolean matched = this.includeExclude.test(path);
                    if (PathWatcher.LOG.isDebugEnabled()) {
                        PathWatcher.LOG.debug("test({}) -> {}", toShortPath(path), Boolean.valueOf(matched));
                    }
                    return matched;
                } else if (!PathWatcher.LOG.isDebugEnabled()) {
                    return false;
                } else {
                    PathWatcher.LOG.debug("test({}) -> [depth {}>{}]", toShortPath(path), Integer.valueOf(depth), Integer.valueOf(this.recurseDepth));
                    return false;
                }
            } else if (!PathWatcher.LOG.isDebugEnabled()) {
                return false;
            } else {
                PathWatcher.LOG.debug("test({}) -> [Hidden]", toShortPath(path));
                return false;
            }
        }

        public void setRecurseDepth(int depth) {
            this.recurseDepth = depth;
        }

        private String toGlobPattern(Path path, String subPattern) {
            StringBuilder s = new StringBuilder();
            s.append("glob:");
            boolean needDelim = false;
            Path root = path.getRoot();
            if (root != null) {
                if (PathWatcher.LOG.isDebugEnabled()) {
                    PathWatcher.LOG.debug("Path: {} -> Root: {}", path, root);
                }
                char[] charArray = root.toString().toCharArray();
                for (char c : charArray) {
                    if (c == '\\') {
                        s.append(PATTERN_SEP);
                    } else {
                        s.append(c);
                    }
                }
            } else {
                needDelim = true;
            }
            for (Path segment : path) {
                if (needDelim) {
                    s.append(PATTERN_SEP);
                }
                s.append(segment);
                needDelim = true;
            }
            if (subPattern != null && subPattern.length() > 0) {
                if (needDelim) {
                    s.append(PATTERN_SEP);
                }
                char[] charArray2 = subPattern.toCharArray();
                for (char c2 : charArray2) {
                    if (c2 == '/') {
                        s.append(PATTERN_SEP);
                    } else {
                        s.append(c2);
                    }
                }
            }
            return s.toString();
        }

        DirAction handleDir(Path path) {
            try {
                if (!Files.isDirectory(path, new LinkOption[0])) {
                    return DirAction.IGNORE;
                }
                if (this.excludeHidden && isHidden(path)) {
                    return DirAction.IGNORE;
                }
                if (getRecurseDepth() == 0) {
                    return DirAction.WATCH;
                }
                return DirAction.ENTER;
            } catch (Exception e) {
                PathWatcher.LOG.ignore(e);
                return DirAction.IGNORE;
            }
        }

        public boolean isHidden(Path path) {
            try {
                if (!path.startsWith(this.path)) {
                    return true;
                }
                for (int i = this.path.getNameCount(); i < path.getNameCount(); i++) {
                    if (path.getName(i).toString().startsWith(Mapper.IGNORED_FIELDNAME)) {
                        return true;
                    }
                }
                if (Files.exists(path, new LinkOption[0])) {
                    if (Files.isHidden(path)) {
                        return true;
                    }
                }
                return false;
            } catch (IOException e) {
                PathWatcher.LOG.ignore(e);
                return false;
            }
        }

        public String toShortPath(Path path) {
            if (!path.startsWith(this.path)) {
                return path.toString();
            }
            return this.path.relativize(path).toString();
        }

        @Override // java.lang.Object
        public String toString() {
            StringBuilder s = new StringBuilder();
            s.append(this.path).append(" [depth=");
            if (this.recurseDepth == -9999) {
                s.append("UNLIMITED");
            } else {
                s.append(this.recurseDepth);
            }
            s.append(']');
            return s.toString();
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$PathWatchEvent.class */
    public class PathWatchEvent {
        private final Path path;
        private final PathWatchEventType type;
        private final Config config;
        long checked;
        long modified;
        long length;

        public PathWatchEvent(Path path, PathWatchEventType type, Config config) {
            this.path = path;
            this.type = type;
            this.config = config;
            this.checked = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            check();
        }

        public Config getConfig() {
            return this.config;
        }

        public PathWatchEvent(Path path, WatchEvent<Path> event, Config config) {
            this.path = path;
            if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                this.type = PathWatchEventType.ADDED;
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
                this.type = PathWatchEventType.DELETED;
            } else if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
                this.type = PathWatchEventType.MODIFIED;
            } else {
                this.type = PathWatchEventType.UNKNOWN;
            }
            this.config = config;
            this.checked = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            check();
        }

        private void check() {
            if (Files.exists(this.path, new LinkOption[0])) {
                try {
                    this.modified = Files.getLastModifiedTime(this.path, new LinkOption[0]).toMillis();
                    this.length = Files.size(this.path);
                } catch (IOException e) {
                    this.modified = -1;
                    this.length = -1;
                }
            } else {
                this.modified = -1;
                this.length = -1;
            }
        }

        public boolean isQuiet(long now, long quietTime) {
            long lastModified = this.modified;
            long lastLength = this.length;
            check();
            if (lastModified == this.modified && lastLength == this.length) {
                return now - this.checked >= quietTime;
            }
            this.checked = now;
            return false;
        }

        public long toQuietCheck(long now, long quietTime) {
            long check = quietTime - (now - this.checked);
            if (check <= 0) {
                return quietTime;
            }
            return check;
        }

        public void modified() {
            long now = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
            this.checked = now;
            check();
            this.config.setPauseUntil(now + PathWatcher.this.getUpdateQuietTimeMillis());
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            PathWatchEvent other = (PathWatchEvent) obj;
            if (this.path == null) {
                if (other.path != null) {
                    return false;
                }
            } else if (!this.path.equals(other.path)) {
                return false;
            }
            return this.type == other.type;
        }

        public Path getPath() {
            return this.path;
        }

        public PathWatchEventType getType() {
            return this.type;
        }

        @Deprecated
        public int getCount() {
            return 1;
        }

        public int hashCode() {
            return (31 * ((31 * 1) + (this.path == null ? 0 : this.path.hashCode()))) + (this.type == null ? 0 : this.type.hashCode());
        }

        public String toString() {
            return String.format("PathWatchEvent[%8s|%s]", this.type, this.path);
        }
    }

    static {
        String os = System.getProperty("os.name");
        if (os == null) {
            IS_WINDOWS = false;
        } else {
            IS_WINDOWS = os.toLowerCase(Locale.ENGLISH).contains("windows");
        }
        LOG = Log.getLogger(PathWatcher.class);
        WATCH_EVENT_KINDS = new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE, StandardWatchEventKinds.ENTRY_MODIFY};
        WATCH_DIR_KINDS = new WatchEvent.Kind[]{StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE};
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.nio.file.WatchEvent<?> */
    /* JADX WARN: Multi-variable type inference failed */
    protected static <T> WatchEvent<T> cast(WatchEvent<?> event) {
        return event;
    }

    public Collection<Config> getConfigs() {
        return this.configs;
    }

    public void watch(Path file) {
        Path abs = file;
        if (!abs.isAbsolute()) {
            abs = file.toAbsolutePath();
        }
        Config config = null;
        Path parent = abs.getParent();
        Iterator<Config> it = this.configs.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Config c = it.next();
            if (c.getPath().equals(parent)) {
                config = c;
                break;
            }
        }
        if (config == null) {
            Config config2 = new Config(abs.getParent());
            config2.addIncludeGlobRelative("");
            config2.addIncludeGlobRelative(file.getFileName().toString());
            watch(config2);
            return;
        }
        config.addIncludeGlobRelative(file.getFileName().toString());
    }

    public void watch(Config config) {
        this.configs.add(config);
    }

    public void addListener(EventListener listener) {
        this.listeners.add(listener);
    }

    private void appendConfigId(StringBuilder s) {
        List<Path> dirs = new ArrayList<>();
        for (Config config : this.keys.values()) {
            dirs.add(config.path);
        }
        Collections.sort(dirs);
        s.append("[");
        if (dirs.size() > 0) {
            s.append(dirs.get(0));
            if (dirs.size() > 1) {
                s.append(" (+").append(dirs.size() - 1).append(")");
            }
        } else {
            s.append("<null>");
        }
        s.append("]");
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        this.watchService = FileSystems.getDefault().newWatchService();
        setUpdateQuietTime(getUpdateQuietTimeMillis(), TimeUnit.MILLISECONDS);
        for (Config c : this.configs) {
            registerTree(c.getPath(), c, isNotifyExistingOnStart());
        }
        StringBuilder threadId = new StringBuilder();
        threadId.append("PathWatcher@");
        threadId.append(Integer.toHexString(hashCode()));
        if (LOG.isDebugEnabled()) {
            LOG.debug("{} -> {}", this, threadId);
        }
        this.thread = new Thread(this, threadId.toString());
        this.thread.setDaemon(true);
        this.thread.start();
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (this.watchService != null) {
            this.watchService.close();
        }
        this.watchService = null;
        this.thread = null;
        this.keys.clear();
        this.pending.clear();
        this.events.clear();
        doStop();
    }

    public void reset() {
        if (!isStopped()) {
            throw new IllegalStateException("PathWatcher must be stopped before reset.");
        }
        this.configs.clear();
        this.listeners.clear();
    }

    protected boolean isNotifiable() {
        return isStarted() || (!isStarted() && isNotifyExistingOnStart());
    }

    public Iterator<EventListener> getListeners() {
        return this.listeners.iterator();
    }

    public long getUpdateQuietTimeMillis() {
        return TimeUnit.MILLISECONDS.convert(this.updateQuietTimeDuration, this.updateQuietTimeUnit);
    }

    private void registerTree(Path dir, Config config, boolean notify) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("registerTree {} {} {}", dir, config, Boolean.valueOf(notify));
        }
        if (!Files.isDirectory(dir, new LinkOption[0])) {
            throw new IllegalArgumentException(dir.toString());
        }
        register(dir, config);
        MultiException me = new MultiException();
        Stream<Path> stream = Files.list(dir);
        try {
            stream.forEach(p -> {
                if (LOG.isDebugEnabled()) {
                    LOG.debug("registerTree? {}", me);
                }
                if (notify) {
                    try {
                        if (notify.test(me)) {
                            this.pending.put(me, new PathWatchEvent(me, PathWatchEventType.ADDED, notify));
                        }
                    } catch (IOException e) {
                        config.add(e);
                        return;
                    }
                }
                switch (notify.handleDir(me)) {
                    case ENTER:
                        registerTree(me, notify.asSubConfig(me), notify);
                        break;
                    case WATCH:
                        registerDir(me, notify);
                        break;
                }
            });
            if (stream != null) {
                stream.close();
            }
            try {
                me.ifExceptionThrow();
            } catch (IOException e) {
                throw e;
            } catch (Throwable ex) {
                throw new IOException(ex);
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

    private void registerDir(Path path, Config config) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("registerDir {} {}", path, config);
        }
        if (!Files.isDirectory(path, new LinkOption[0])) {
            throw new IllegalArgumentException(path.toString());
        }
        register(path, config.asSubConfig(path), WATCH_DIR_KINDS);
    }

    protected void register(Path path, Config config) throws IOException {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Registering watch on {}", path);
        }
        register(path, config, WATCH_EVENT_KINDS);
    }

    private void register(Path path, Config config, WatchEvent.Kind<?>[] kinds) throws IOException {
        this.keys.put(path.register(this.watchService, kinds), config);
    }

    public boolean removeListener(Listener listener) {
        return this.listeners.remove(listener);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [long] */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    @Override // java.lang.Runnable
    public void run() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Starting java.nio file watching with {}", this.watchService);
        }
        char updateQuietTimeMillis = getUpdateQuietTimeMillis();
        WatchService watch = this.watchService;
        while (isRunning() && this.thread == Thread.currentThread()) {
            try {
                long now = TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
                for (Map.Entry<WatchKey, Config> e : this.keys.entrySet()) {
                    WatchKey k = e.getKey();
                    if (!e.getValue().isPaused(now) && !k.reset()) {
                        this.keys.remove(k);
                        if (this.keys.isEmpty()) {
                            return;
                        }
                    }
                }
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Waiting for poll({})", updateQuietTimeMillis);
                }
                for (WatchKey key = updateQuietTimeMillis < 0 ? watch.take() : updateQuietTimeMillis > 0 ? watch.poll(updateQuietTimeMillis, this.updateQuietTimeUnit) : watch.poll(); key != null; key = watch.poll()) {
                    handleKey(key);
                }
                updateQuietTimeMillis = processPending();
                notifyEvents();
            } catch (InterruptedException e2) {
                if (isRunning()) {
                    LOG.warn(e2);
                } else {
                    LOG.ignore(e2);
                }
            } catch (ClosedWatchServiceException e3) {
                return;
            }
        }
    }

    private void handleKey(WatchKey key) {
        Config config = this.keys.get(key);
        if (config != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent<Path> ev = cast(event);
                Path path = config.resolve(ev.context());
                if (LOG.isDebugEnabled()) {
                    LOG.debug("handleKey? {} {} {}", ev.kind(), config.toShortPath(path), config);
                }
                if (ev.kind() != StandardWatchEventKinds.ENTRY_MODIFY || !Files.exists(path, new LinkOption[0]) || !Files.isDirectory(path, new LinkOption[0])) {
                    if (config.test(path)) {
                        handleWatchEvent(path, new PathWatchEvent(path, ev, config));
                    } else if (config.getRecurseDepth() == -1) {
                        Path parent = path.getParent();
                        handleWatchEvent(parent, new PathWatchEvent(parent, PathWatchEventType.MODIFIED, config.getParent()));
                    }
                    if (ev.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
                        try {
                            switch (config.handleDir(path)) {
                                case ENTER:
                                    registerTree(path, config.asSubConfig(path), true);
                                    break;
                                case WATCH:
                                    registerDir(path, config);
                                    break;
                            }
                        } catch (IOException e) {
                            LOG.warn(e);
                        }
                    }
                }
            }
        } else if (LOG.isDebugEnabled()) {
            LOG.debug("WatchKey not recognized: {}", key);
        }
    }

    public void handleWatchEvent(Path path, PathWatchEvent event) {
        PathWatchEvent existing = this.pending.get(path);
        if (LOG.isDebugEnabled()) {
            LOG.debug("handleWatchEvent {} {} <= {}", path, event, existing);
        }
        switch (event.getType()) {
            case ADDED:
                if (existing != null && existing.getType() == PathWatchEventType.MODIFIED) {
                    this.events.add(new PathWatchEvent(path, PathWatchEventType.DELETED, existing.getConfig()));
                }
                this.pending.put(path, event);
                return;
            case MODIFIED:
                if (existing == null) {
                    this.pending.put(path, event);
                    return;
                } else {
                    existing.modified();
                    return;
                }
            case DELETED:
            case UNKNOWN:
                if (existing != null) {
                    this.pending.remove(path);
                }
                this.events.add(event);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Type inference failed for: r0v36, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long processPending() {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.PathWatcher.processPending():long");
    }

    private void notifyEvents() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("notifyEvents {}", (long) this.events.size());
        }
        if (!this.events.isEmpty()) {
            boolean eventListeners = false;
            for (EventListener listener : this.listeners) {
                if (listener instanceof EventListListener) {
                    try {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("notifyEvents {} {}", listener, this.events);
                        }
                        ((EventListListener) listener).onPathWatchEvents(this.events);
                    } catch (Throwable t) {
                        LOG.warn(t);
                    }
                } else {
                    eventListeners = true;
                }
            }
            if (eventListeners) {
                for (PathWatchEvent event : this.events) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("notifyEvent {} {}", event, this.listeners);
                    }
                    for (EventListener listener2 : this.listeners) {
                        if (listener2 instanceof Listener) {
                            try {
                                ((Listener) listener2).onPathWatchEvent(event);
                            } catch (Throwable t2) {
                                LOG.warn(t2);
                            }
                        }
                    }
                }
            }
            this.events.clear();
        }
    }

    public void setNotifyExistingOnStart(boolean notify) {
        this._notifyExistingOnStart = notify;
    }

    public boolean isNotifyExistingOnStart() {
        return this._notifyExistingOnStart;
    }

    public void setUpdateQuietTime(long duration, TimeUnit unit) {
        long desiredMillis = unit.toMillis(duration);
        if (!IS_WINDOWS || desiredMillis >= 1000) {
            this.updateQuietTimeDuration = duration;
            this.updateQuietTimeUnit = unit;
            return;
        }
        LOG.warn("Quiet Time is too low for Microsoft Windows: {} < 1000 ms (defaulting to 1000 ms)", Long.valueOf(desiredMillis));
        this.updateQuietTimeDuration = 1000;
        this.updateQuietTimeUnit = TimeUnit.MILLISECONDS;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        StringBuilder s = new StringBuilder(getClass().getName());
        appendConfigId(s);
        return s.toString();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$ExactPathMatcher.class */
    private static class ExactPathMatcher implements PathMatcher {
        private final Path path;

        ExactPathMatcher(Path path) {
            this.path = path;
        }

        @Override // java.nio.file.PathMatcher
        public boolean matches(Path path) {
            return this.path.equals(path);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/PathWatcher$PathMatcherSet.class */
    public static class PathMatcherSet extends HashSet<PathMatcher> implements Predicate<Path> {
        public boolean test(Path path) {
            Iterator<PathMatcher> it = iterator();
            while (it.hasNext()) {
                if (it.next().matches(path)) {
                    return true;
                }
            }
            return false;
        }
    }
}
