package org.jline.reader.impl.history;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.nio.file.attribute.FileAttribute;
import java.time.DateTimeException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Spliterator;
import org.jline.reader.History;
import org.jline.reader.LineReader;
import org.jline.reader.impl.ReaderUtils;
import org.jline.utils.Log;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/reader/impl/history/DefaultHistory.class */
public class DefaultHistory implements History {
    public static final int DEFAULT_HISTORY_SIZE = 500;
    public static final int DEFAULT_HISTORY_FILE_SIZE = 10000;
    private LineReader reader;
    private final LinkedList<History.Entry> items = new LinkedList<>();
    private Map<String, HistoryFileData> historyFiles = new HashMap();
    private int offset = 0;
    private int index = 0;

    public DefaultHistory() {
    }

    public DefaultHistory(LineReader reader) {
        attach(reader);
    }

    private Path getPath() {
        Object obj = this.reader != null ? this.reader.getVariables().get(LineReader.HISTORY_FILE) : null;
        if (obj instanceof Path) {
            return (Path) obj;
        }
        if (obj instanceof File) {
            return ((File) obj).toPath();
        }
        if (obj != null) {
            return Paths.get(obj.toString(), new String[0]);
        }
        return null;
    }

    @Override // org.jline.reader.History
    public void attach(LineReader reader) {
        if (this.reader != reader) {
            this.reader = reader;
            try {
                load();
            } catch (IOException | IllegalArgumentException e) {
                Log.warn("Failed to load history", e);
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x006b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.jline.reader.History
    public void load() throws java.io.IOException {
        /*
            r8 = this;
            r0 = r8
            java.nio.file.Path r0 = r0.getPath()
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L_0x009b
            r0 = r9
            r1 = 0
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]     // Catch: IllegalArgumentException | IOException -> 0x0084
            boolean r0 = java.nio.file.Files.exists(r0, r1)     // Catch: IllegalArgumentException | IOException -> 0x0084
            if (r0 == 0) goto L_0x0081
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: IllegalArgumentException | IOException -> 0x0084
            r1 = r0
            r2 = 0
            java.lang.String r3 = "Loading history from: "
            r1[r2] = r3     // Catch: IllegalArgumentException | IOException -> 0x0084
            r1 = r0
            r2 = 1
            r3 = r9
            r1[r2] = r3     // Catch: IllegalArgumentException | IOException -> 0x0084
            org.jline.utils.Log.trace(r0)     // Catch: IllegalArgumentException | IOException -> 0x0084
            r0 = r9
            java.io.BufferedReader r0 = java.nio.file.Files.newBufferedReader(r0)     // Catch: IllegalArgumentException | IOException -> 0x0084
            r10 = r0
            r0 = r8
            r0.internalClear()     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r0 = r10
            java.util.stream.Stream r0 = r0.lines()     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r1 = r8
            r2 = r9
            void r1 = (v2) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$load$0(r2, v2);
            }     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r0.forEach(r1)     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r0 = r8
            r1 = r9
            org.jline.reader.impl.history.DefaultHistory$HistoryFileData r2 = new org.jline.reader.impl.history.DefaultHistory$HistoryFileData     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r3 = r2
            r4 = r8
            java.util.LinkedList<org.jline.reader.History$Entry> r4 = r4.items     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            int r4 = r4.size()     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r5 = r8
            int r5 = r5.offset     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r6 = r8
            java.util.LinkedList<org.jline.reader.History$Entry> r6 = r6.items     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            int r6 = r6.size()     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            int r5 = r5 + r6
            r3.<init>(r4, r5)     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r0.setHistoryFileData(r1, r2)     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r0 = r8
            r0.maybeResize()     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x006b
            r0 = r10
            if (r0 == 0) goto L_0x0081
            r0 = r10
            r0.close()     // Catch: IllegalArgumentException | IOException -> 0x0084
            goto L_0x0081
        L_0x006b:
            r11 = move-exception
            r0 = r10
            if (r0 == 0) goto L_0x007f
            r0 = r10
            r0.close()     // Catch: IllegalArgumentException | IOException -> 0x0084, Throwable -> 0x0077
            goto L_0x007f
        L_0x0077:
            r12 = move-exception
            r0 = r11
            r1 = r12
            r0.addSuppressed(r1)     // Catch: IllegalArgumentException | IOException -> 0x0084
        L_0x007f:
            r0 = r11
            throw r0     // Catch: IllegalArgumentException | IOException -> 0x0084
        L_0x0081:
            goto L_0x009b
        L_0x0084:
            r10 = move-exception
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = r0
            r2 = 0
            java.lang.String r3 = "Failed to load history; clearing"
            r1[r2] = r3
            r1 = r0
            r2 = 1
            r3 = r10
            r1[r2] = r3
            org.jline.utils.Log.debug(r0)
            r0 = r8
            r0.internalClear()
            r0 = r10
            throw r0
        L_0x009b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.reader.impl.history.DefaultHistory.load():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0074
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // org.jline.reader.History
    public void read(java.nio.file.Path r9, boolean r10) throws java.io.IOException {
        /*
            r8 = this;
            r0 = r9
            if (r0 == 0) goto L_0x0008
            r0 = r9
            goto L_0x000c
        L_0x0008:
            r0 = r8
            java.nio.file.Path r0 = r0.getPath()
        L_0x000c:
            r11 = r0
            r0 = r11
            if (r0 == 0) goto L_0x00ac
            r0 = r11
            r1 = 0
            java.nio.file.LinkOption[] r1 = new java.nio.file.LinkOption[r1]     // Catch: IllegalArgumentException | IOException -> 0x0092
            boolean r0 = java.nio.file.Files.exists(r0, r1)     // Catch: IllegalArgumentException | IOException -> 0x0092
            if (r0 == 0) goto L_0x008f
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: IllegalArgumentException | IOException -> 0x0092
            r1 = r0
            r2 = 0
            java.lang.String r3 = "Reading history from: "
            r1[r2] = r3     // Catch: IllegalArgumentException | IOException -> 0x0092
            r1 = r0
            r2 = 1
            r3 = r11
            r1[r2] = r3     // Catch: IllegalArgumentException | IOException -> 0x0092
            org.jline.utils.Log.trace(r0)     // Catch: IllegalArgumentException | IOException -> 0x0092
            r0 = r11
            java.io.BufferedReader r0 = java.nio.file.Files.newBufferedReader(r0)     // Catch: IllegalArgumentException | IOException -> 0x0092
            r12 = r0
            r0 = r12
            java.util.stream.Stream r0 = r0.lines()     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r1 = r8
            r2 = r11
            r3 = r10
            void r1 = (v3) -> { // java.util.function.Consumer.accept(java.lang.Object):void
                r1.lambda$read$1(r2, r3, v3);
            }     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r0.forEach(r1)     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r0 = r8
            r1 = r11
            org.jline.reader.impl.history.DefaultHistory$HistoryFileData r2 = new org.jline.reader.impl.history.DefaultHistory$HistoryFileData     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r3 = r2
            r4 = r8
            java.util.LinkedList<org.jline.reader.History$Entry> r4 = r4.items     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            int r4 = r4.size()     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r5 = r8
            int r5 = r5.offset     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r6 = r8
            java.util.LinkedList<org.jline.reader.History$Entry> r6 = r6.items     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            int r6 = r6.size()     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            int r5 = r5 + r6
            r3.<init>(r4, r5)     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r0.setHistoryFileData(r1, r2)     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r0 = r8
            r0.maybeResize()     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0074
            r0 = r12
            if (r0 == 0) goto L_0x008f
            r0 = r12
            r0.close()     // Catch: IllegalArgumentException | IOException -> 0x0092
            goto L_0x008f
        L_0x0074:
            r13 = move-exception
            r0 = r12
            if (r0 == 0) goto L_0x008c
            r0 = r12
            r0.close()     // Catch: IllegalArgumentException | IOException -> 0x0092, Throwable -> 0x0083
            goto L_0x008c
        L_0x0083:
            r14 = move-exception
            r0 = r13
            r1 = r14
            r0.addSuppressed(r1)     // Catch: IllegalArgumentException | IOException -> 0x0092
        L_0x008c:
            r0 = r13
            throw r0     // Catch: IllegalArgumentException | IOException -> 0x0092
        L_0x008f:
            goto L_0x00ac
        L_0x0092:
            r12 = move-exception
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r1 = r0
            r2 = 0
            java.lang.String r3 = "Failed to read history; clearing"
            r1[r2] = r3
            r1 = r0
            r2 = 1
            r3 = r12
            r1[r2] = r3
            org.jline.utils.Log.debug(r0)
            r0 = r8
            r0.internalClear()
            r0 = r12
            throw r0
        L_0x00ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.reader.impl.history.DefaultHistory.read(java.nio.file.Path, boolean):void");
    }

    private String doHistoryFileDataKey(Path path) {
        if (path != null) {
            return path.toAbsolutePath().toString();
        }
        return null;
    }

    private HistoryFileData getHistoryFileData(Path path) {
        String key = doHistoryFileDataKey(path);
        if (!this.historyFiles.containsKey(key)) {
            this.historyFiles.put(key, new HistoryFileData());
        }
        return this.historyFiles.get(key);
    }

    private void setHistoryFileData(Path path, HistoryFileData historyFileData) {
        this.historyFiles.put(doHistoryFileDataKey(path), historyFileData);
    }

    private boolean isLineReaderHistory(Path path) throws IOException {
        Path lrp = getPath();
        if (lrp == null) {
            return path == null;
        }
        return Files.isSameFile(lrp, path);
    }

    private void setLastLoaded(Path path, int lastloaded) {
        getHistoryFileData(path).setLastLoaded(lastloaded);
    }

    private void setEntriesInFile(Path path, int entriesInFile) {
        getHistoryFileData(path).setEntriesInFile(entriesInFile);
    }

    private void incEntriesInFile(Path path, int amount) {
        getHistoryFileData(path).incEntriesInFile(amount);
    }

    private int getLastLoaded(Path path) {
        return getHistoryFileData(path).getLastLoaded();
    }

    private int getEntriesInFile(Path path) {
        return getHistoryFileData(path).getEntriesInFile();
    }

    protected void addHistoryLine(Path path, String line) {
        addHistoryLine(path, line, false);
    }

    protected void addHistoryLine(Path path, String line, boolean checkDuplicates) {
        if (this.reader.isSet(LineReader.Option.HISTORY_TIMESTAMPED)) {
            int idx = line.indexOf(58);
            String badHistoryFileSyntax = "Bad history file syntax! The history file `" + path + "` may be an older history: please remove it or use a different history file.";
            if (idx < 0) {
                throw new IllegalArgumentException(badHistoryFileSyntax);
            }
            try {
                internalAdd(Instant.ofEpochMilli(Long.parseLong(line.substring(0, idx))), unescape(line.substring(idx + 1)), checkDuplicates);
            } catch (NumberFormatException | DateTimeException e) {
                throw new IllegalArgumentException(badHistoryFileSyntax);
            }
        } else {
            internalAdd(Instant.now(), unescape(line), checkDuplicates);
        }
    }

    @Override // org.jline.reader.History
    public void purge() throws IOException {
        internalClear();
        Path path = getPath();
        if (path != null) {
            Log.trace("Purging history from: ", path);
            Files.deleteIfExists(path);
        }
    }

    @Override // org.jline.reader.History
    public void write(Path file, boolean incremental) throws IOException {
        Path path = file != null ? file : getPath();
        if (path != null && Files.exists(path, new LinkOption[0])) {
            path.toFile().delete();
        }
        internalWrite(path, incremental ? getLastLoaded(path) : 0);
    }

    @Override // org.jline.reader.History
    public void append(Path file, boolean incremental) throws IOException {
        internalWrite(file != null ? file : getPath(), incremental ? getLastLoaded(file) : 0);
    }

    @Override // org.jline.reader.History
    public void save() throws IOException {
        internalWrite(getPath(), getLastLoaded(getPath()));
    }

    private void internalWrite(Path path, int from) throws IOException {
        if (path != null) {
            Log.trace("Saving history to: ", path);
            Path parent = path.toAbsolutePath().getParent();
            if (!Files.exists(parent, new LinkOption[0])) {
                Files.createDirectories(parent, new FileAttribute[0]);
            }
            BufferedWriter writer = Files.newBufferedWriter(path.toAbsolutePath(), StandardOpenOption.WRITE, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
            try {
                for (History.Entry entry : this.items.subList(from, this.items.size())) {
                    if (isPersistable(entry)) {
                        writer.append((CharSequence) format(entry));
                    }
                }
                if (writer != null) {
                    writer.close();
                }
                incEntriesInFile(path, this.items.size() - from);
                int max = ReaderUtils.getInt(this.reader, LineReader.HISTORY_FILE_SIZE, 10000);
                if (getEntriesInFile(path) > max + (max / 4)) {
                    trimHistory(path, max);
                }
            } catch (Throwable th) {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        }
        setLastLoaded(path, this.items.size());
    }

    protected void trimHistory(Path path, int max) throws IOException {
        Log.trace("Trimming history path: ", path);
        LinkedList<History.Entry> allItems = new LinkedList<>();
        BufferedReader reader = Files.newBufferedReader(path);
        try {
            reader.lines().forEach(l -> {
                int idx = allItems.indexOf(58);
                allItems.add(createEntry(allItems.size(), Instant.ofEpochMilli(Long.parseLong(allItems.substring(0, idx))), unescape(allItems.substring(idx + 1))));
            });
            if (reader != null) {
                reader.close();
            }
            List<History.Entry> trimmedItems = doTrimHistory(allItems, max);
            Path temp = Files.createTempFile(path.toAbsolutePath().getParent(), path.getFileName().toString(), ".tmp", new FileAttribute[0]);
            BufferedWriter writer = Files.newBufferedWriter(temp, StandardOpenOption.WRITE);
            try {
                for (History.Entry entry : trimmedItems) {
                    writer.append((CharSequence) format(entry));
                }
                if (writer != null) {
                    writer.close();
                }
                Files.move(temp, path, StandardCopyOption.REPLACE_EXISTING);
                if (isLineReaderHistory(path)) {
                    internalClear();
                    this.offset = trimmedItems.get(0).index();
                    this.items.addAll(trimmedItems);
                    setHistoryFileData(path, new HistoryFileData(this.items.size(), this.items.size()));
                } else {
                    setEntriesInFile(path, allItems.size());
                }
                maybeResize();
            } catch (Throwable th) {
                if (writer != null) {
                    try {
                        writer.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            if (reader != null) {
                try {
                    reader.close();
                } catch (Throwable th4) {
                    th3.addSuppressed(th4);
                }
            }
            throw th3;
        }
    }

    protected EntryImpl createEntry(int index, Instant time, String line) {
        return new EntryImpl(index, time, line);
    }

    private void internalClear() {
        this.offset = 0;
        this.index = 0;
        this.historyFiles = new HashMap();
        this.items.clear();
    }

    static List<History.Entry> doTrimHistory(List<History.Entry> allItems, int max) {
        for (int idx = 0; idx < allItems.size(); idx++) {
            int ridx = (allItems.size() - idx) - 1;
            String line = allItems.get(ridx).line().trim();
            ListIterator<History.Entry> iterator = allItems.listIterator(ridx);
            while (iterator.hasPrevious()) {
                if (line.equals(iterator.previous().line().trim())) {
                    iterator.remove();
                }
            }
        }
        while (allItems.size() > max) {
            allItems.remove(0);
        }
        int index = (allItems.get(allItems.size() - 1).index() - allItems.size()) + 1;
        List<History.Entry> out = new ArrayList<>();
        for (History.Entry e : allItems) {
            index++;
            out.add(new EntryImpl(index, e.time(), e.line()));
        }
        return out;
    }

    @Override // org.jline.reader.History
    public int size() {
        return this.items.size();
    }

    @Override // org.jline.reader.History
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override // org.jline.reader.History
    public int index() {
        return this.offset + this.index;
    }

    @Override // org.jline.reader.History
    public int first() {
        return this.offset;
    }

    @Override // org.jline.reader.History
    public int last() {
        return (this.offset + this.items.size()) - 1;
    }

    private String format(History.Entry entry) {
        if (this.reader.isSet(LineReader.Option.HISTORY_TIMESTAMPED)) {
            return entry.time().toEpochMilli() + EmitterKt.COMMENT_PREFIX + escape(entry.line()) + "\n";
        }
        return escape(entry.line()) + "\n";
    }

    @Override // org.jline.reader.History
    public String get(int index) {
        int idx = index - this.offset;
        if (idx < this.items.size() && idx >= 0) {
            return this.items.get(idx).line();
        }
        throw new IllegalArgumentException("IndexOutOfBounds: Index:" + idx + ", Size:" + this.items.size());
    }

    @Override // org.jline.reader.History
    public void add(Instant time, String line) {
        Objects.requireNonNull(time);
        Objects.requireNonNull(line);
        if (!ReaderUtils.getBoolean(this.reader, LineReader.DISABLE_HISTORY, false)) {
            if (!ReaderUtils.isSet(this.reader, LineReader.Option.HISTORY_IGNORE_SPACE) || !line.startsWith(" ")) {
                if (ReaderUtils.isSet(this.reader, LineReader.Option.HISTORY_REDUCE_BLANKS)) {
                    line = line.trim();
                }
                if ((!ReaderUtils.isSet(this.reader, LineReader.Option.HISTORY_IGNORE_DUPS) || this.items.isEmpty() || !line.equals(this.items.getLast().line())) && !matchPatterns(ReaderUtils.getString(this.reader, LineReader.HISTORY_IGNORE, ""), line)) {
                    internalAdd(time, line);
                    if (ReaderUtils.isSet(this.reader, LineReader.Option.HISTORY_INCREMENTAL)) {
                        try {
                            save();
                        } catch (IOException e) {
                            Log.warn("Failed to save history", e);
                        }
                    }
                }
            }
        }
    }

    protected boolean matchPatterns(String patterns, String line) {
        if (patterns == null || patterns.isEmpty()) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < patterns.length()) {
            char ch = patterns.charAt(i);
            if (ch == '\\') {
                i++;
                sb.append(patterns.charAt(i));
            } else if (ch == ':') {
                sb.append('|');
            } else if (ch == '*') {
                sb.append('.').append('*');
            } else {
                sb.append(ch);
            }
            i++;
        }
        return line.matches(sb.toString());
    }

    protected void internalAdd(Instant time, String line) {
        internalAdd(time, line, false);
    }

    protected void internalAdd(Instant time, String line, boolean checkDuplicates) {
        History.Entry entry = new EntryImpl(this.offset + this.items.size(), time, line);
        if (checkDuplicates) {
            Iterator<History.Entry> it = this.items.iterator();
            while (it.hasNext()) {
                if (it.next().line().trim().equals(line.trim())) {
                    return;
                }
            }
        }
        this.items.add(entry);
        maybeResize();
    }

    private void maybeResize() {
        while (size() > ReaderUtils.getInt(this.reader, LineReader.HISTORY_SIZE, 500)) {
            this.items.removeFirst();
            for (HistoryFileData hfd : this.historyFiles.values()) {
                hfd.decLastLoaded();
            }
            this.offset++;
        }
        this.index = size();
    }

    @Override // org.jline.reader.History
    public ListIterator<History.Entry> iterator(int index) {
        return this.items.listIterator(index - this.offset);
    }

    @Override // java.lang.Iterable
    public Spliterator<History.Entry> spliterator() {
        return this.items.spliterator();
    }

    @Override // org.jline.reader.History
    public void resetIndex() {
        this.index = Math.min(this.index, this.items.size());
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/history/DefaultHistory$EntryImpl.class */
    public static class EntryImpl implements History.Entry {
        private final int index;
        private final Instant time;
        private final String line;

        public EntryImpl(int index, Instant time, String line) {
            this.index = index;
            this.time = time;
            this.line = line;
        }

        @Override // org.jline.reader.History.Entry
        public int index() {
            return this.index;
        }

        @Override // org.jline.reader.History.Entry
        public Instant time() {
            return this.time;
        }

        @Override // org.jline.reader.History.Entry
        public String line() {
            return this.line;
        }

        public String toString() {
            return String.format("%d: %s", Integer.valueOf(this.index), this.line);
        }
    }

    @Override // org.jline.reader.History
    public boolean moveToLast() {
        int lastEntry = size() - 1;
        if (lastEntry < 0 || lastEntry == this.index) {
            return false;
        }
        this.index = size() - 1;
        return true;
    }

    @Override // org.jline.reader.History
    public boolean moveTo(int index) {
        int index2 = index - this.offset;
        if (index2 < 0 || index2 >= size()) {
            return false;
        }
        this.index = index2;
        return true;
    }

    @Override // org.jline.reader.History
    public boolean moveToFirst() {
        if (size() <= 0 || this.index == 0) {
            return false;
        }
        this.index = 0;
        return true;
    }

    @Override // org.jline.reader.History
    public void moveToEnd() {
        this.index = size();
    }

    @Override // org.jline.reader.History
    public String current() {
        if (this.index >= size()) {
            return "";
        }
        return this.items.get(this.index).line();
    }

    @Override // org.jline.reader.History
    public boolean previous() {
        if (this.index <= 0) {
            return false;
        }
        this.index--;
        return true;
    }

    @Override // org.jline.reader.History
    public boolean next() {
        if (this.index >= size()) {
            return false;
        }
        this.index++;
        return true;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<History.Entry> it = iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString()).append("\n");
        }
        return sb.toString();
    }

    private static String escape(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '\n':
                    sb.append('\\');
                    sb.append('n');
                    break;
                case '\r':
                    sb.append('\\');
                    sb.append('r');
                    break;
                case '\\':
                    sb.append('\\');
                    sb.append('\\');
                    break;
                default:
                    sb.append(ch);
                    break;
            }
        }
        return sb.toString();
    }

    static String unescape(String s) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            switch (ch) {
                case '\\':
                    i++;
                    char ch2 = s.charAt(i);
                    if (ch2 != 'n') {
                        if (ch2 != 'r') {
                            sb.append(ch2);
                            break;
                        } else {
                            sb.append('\r');
                            break;
                        }
                    } else {
                        sb.append('\n');
                        break;
                    }
                default:
                    sb.append(ch);
                    break;
            }
            i++;
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/reader/impl/history/DefaultHistory$HistoryFileData.class */
    public static class HistoryFileData {
        private int lastLoaded;
        private int entriesInFile;

        public HistoryFileData() {
            this.lastLoaded = 0;
            this.entriesInFile = 0;
        }

        public HistoryFileData(int lastLoaded, int entriesInFile) {
            this.lastLoaded = 0;
            this.entriesInFile = 0;
            this.lastLoaded = lastLoaded;
            this.entriesInFile = entriesInFile;
        }

        public int getLastLoaded() {
            return this.lastLoaded;
        }

        public void setLastLoaded(int lastLoaded) {
            this.lastLoaded = lastLoaded;
        }

        public void decLastLoaded() {
            this.lastLoaded--;
            if (this.lastLoaded < 0) {
                this.lastLoaded = 0;
            }
        }

        public int getEntriesInFile() {
            return this.entriesInFile;
        }

        public void setEntriesInFile(int entriesInFile) {
            this.entriesInFile = entriesInFile;
        }

        public void incEntriesInFile(int amount) {
            this.entriesInFile += amount;
        }
    }
}
