package okhttp3.internal.cache;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.p020io.FileSystem;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.reader.LineReader;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: DiskLruCache.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n��\n\u0002\b\u0011\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010)\n\u0002\b\u0007*\u0001\u0014\u0018�� [2\u00020\u00012\u00020\u0002:\u0004[\\]^B7\b��\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\b\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u000209H\u0016J!\u0010;\u001a\u0002092\n\u0010<\u001a\u00060=R\u00020��2\u0006\u0010>\u001a\u00020\u0010H��¢\u0006\u0002\b?J\u0006\u0010@\u001a\u000209J \u0010A\u001a\b\u0018\u00010=R\u00020��2\u0006\u0010B\u001a\u00020(2\b\b\u0002\u0010C\u001a\u00020\u000bH\u0007J\u0006\u0010D\u001a\u000209J\b\u0010E\u001a\u000209H\u0016J\u0017\u0010F\u001a\b\u0018\u00010GR\u00020��2\u0006\u0010B\u001a\u00020(H\u0002J\u0006\u0010H\u001a\u000209J\u0006\u0010I\u001a\u00020\u0010J\b\u0010J\u001a\u00020\u0010H\u0002J\b\u0010K\u001a\u00020%H\u0002J\b\u0010L\u001a\u000209H\u0002J\b\u0010M\u001a\u000209H\u0002J\u0010\u0010N\u001a\u0002092\u0006\u0010O\u001a\u00020(H\u0002J\r\u0010P\u001a\u000209H��¢\u0006\u0002\bQJ\u000e\u0010R\u001a\u00020\u00102\u0006\u0010B\u001a\u00020(J\u0019\u0010S\u001a\u00020\u00102\n\u0010T\u001a\u00060)R\u00020��H��¢\u0006\u0002\bUJ\b\u0010V\u001a\u00020\u0010H\u0002J\u0006\u00105\u001a\u00020\u000bJ\u0010\u0010W\u001a\f\u0012\b\u0012\u00060GR\u00020��0XJ\u0006\u0010Y\u001a\u000209J\u0010\u0010Z\u001a\u0002092\u0006\u0010B\u001a\u00020(H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0004\n\u0002\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0010X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n��\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n��\u001a\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n��R\u000e\u0010 \u001a\u00020\u0010X\u000e¢\u0006\u0002\n��R\u000e\u0010!\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010\"\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u000e\u0010#\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n��R$\u0010&\u001a\u0012\u0012\u0004\u0012\u00020(\u0012\b\u0012\u00060)R\u00020��0'X\u0004¢\u0006\b\n��\u001a\u0004\b*\u0010+R&\u0010\n\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b8F@FX\u000e¢\u0006\u000e\n��\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0010X\u000e¢\u0006\u0002\n��R\u000e\u00102\u001a\u00020\u0010X\u000e¢\u0006\u0002\n��R\u000e\u00103\u001a\u00020\u000bX\u000e¢\u0006\u0002\n��R\u000e\u00104\u001a\u00020\bX\u000e¢\u0006\u0002\n��R\u000e\u00105\u001a\u00020\u000bX\u000e¢\u0006\u0002\n��R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n��\u001a\u0004\b6\u00107¨\u0006_"}, m373d2 = {"Lokhttp3/internal/cache/DiskLruCache;", "Ljava/io/Closeable;", "Ljava/io/Flushable;", "fileSystem", "Lokhttp3/internal/io/FileSystem;", "directory", "Ljava/io/File;", "appVersion", "", "valueCount", "maxSize", "", "taskRunner", "Lokhttp3/internal/concurrent/TaskRunner;", "(Lokhttp3/internal/io/FileSystem;Ljava/io/File;IIJLokhttp3/internal/concurrent/TaskRunner;)V", "civilizedFileSystem", "", "cleanupQueue", "Lokhttp3/internal/concurrent/TaskQueue;", "cleanupTask", "okhttp3/internal/cache/DiskLruCache$cleanupTask$1", "Lokhttp3/internal/cache/DiskLruCache$cleanupTask$1;", "closed", "getClosed$okhttp", "()Z", "setClosed$okhttp", "(Z)V", "getDirectory", "()Ljava/io/File;", "getFileSystem$okhttp", "()Lokhttp3/internal/io/FileSystem;", "hasJournalErrors", "initialized", "journalFile", "journalFileBackup", "journalFileTmp", "journalWriter", "Lokio/BufferedSink;", "lruEntries", "Ljava/util/LinkedHashMap;", "", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "getLruEntries$okhttp", "()Ljava/util/LinkedHashMap;", "value", "getMaxSize", "()J", "setMaxSize", "(J)V", "mostRecentRebuildFailed", "mostRecentTrimFailed", "nextSequenceNumber", "redundantOpCount", "size", "getValueCount$okhttp", "()I", "checkNotClosed", "", "close", "completeEdit", "editor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "success", "completeEdit$okhttp", "delete", "edit", Action.KEY_ATTRIBUTE, "expectedSequenceNumber", "evictAll", "flush", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "initialize", "isClosed", "journalRebuildRequired", "newJournalWriter", "processJournal", "readJournal", "readJournalLine", "line", "rebuildJournal", "rebuildJournal$okhttp", "remove", "removeEntry", "entry", "removeEntry$okhttp", "removeOldestEntry", "snapshots", "", "trimToSize", "validateKey", "Companion", "Editor", "Entry", "Snapshot", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache.class */
public final class DiskLruCache implements Closeable, Flushable {
    @NotNull
    private final FileSystem fileSystem;
    @NotNull
    private final File directory;
    private final int appVersion;
    private final int valueCount;
    private long maxSize;
    @NotNull
    private final File journalFile;
    @NotNull
    private final File journalFileTmp;
    @NotNull
    private final File journalFileBackup;
    private long size;
    @Nullable
    private BufferedSink journalWriter;
    private int redundantOpCount;
    private boolean hasJournalErrors;
    private boolean civilizedFileSystem;
    private boolean initialized;
    private boolean closed;
    private boolean mostRecentTrimFailed;
    private boolean mostRecentRebuildFailed;
    private long nextSequenceNumber;
    @NotNull
    private final TaskQueue cleanupQueue;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @JvmField
    @NotNull
    public static final String JOURNAL_FILE = "journal";
    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    @JvmField
    @NotNull
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    @JvmField
    @NotNull
    public static final String MAGIC = "libcore.io.DiskLruCache";
    @JvmField
    @NotNull
    public static final String VERSION_1 = "1";
    @JvmField
    public static final long ANY_SEQUENCE_NUMBER = -1;
    @JvmField
    @NotNull
    public static final Regex LEGAL_KEY_PATTERN = new Regex("[a-z0-9_-]{1,120}");
    @JvmField
    @NotNull
    public static final String CLEAN = "CLEAN";
    @JvmField
    @NotNull
    public static final String DIRTY = "DIRTY";
    @JvmField
    @NotNull
    public static final String REMOVE = "REMOVE";
    @JvmField
    @NotNull
    public static final String READ = "READ";
    @NotNull
    private final LinkedHashMap<String, Entry> lruEntries = new LinkedHashMap<>(0, 0.75f, true);
    @NotNull
    private final DiskLruCache$cleanupTask$1 cleanupTask = new DiskLruCache$cleanupTask$1(this, Intrinsics.stringPlus(Util.okHttpName, " Cache"));

    @JvmOverloads
    @Nullable
    public final Editor edit(@NotNull String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return edit$default(this, key, 0, 2, null);
    }

    public DiskLruCache(@NotNull FileSystem fileSystem, @NotNull File directory, int appVersion, int valueCount, long maxSize, @NotNull TaskRunner taskRunner) {
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = directory;
        this.appVersion = appVersion;
        this.valueCount = valueCount;
        this.maxSize = maxSize;
        this.cleanupQueue = taskRunner.newQueue();
        if (!(maxSize > 0)) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (!(this.valueCount > 0)) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = new File(this.directory, JOURNAL_FILE);
        this.journalFileTmp = new File(this.directory, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(this.directory, JOURNAL_FILE_BACKUP);
    }

    @NotNull
    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    @NotNull
    public final File getDirectory() {
        return this.directory;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final synchronized void setMaxSize(long value) {
        this.maxSize = value;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
    }

    @NotNull
    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final void setClosed$okhttp(boolean z) {
        this.closed = z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:19:0x00a3
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    public final synchronized void initialize() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 263
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.initialize():void");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:21:0x00ef
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private final void readJournal() throws java.io.IOException {
        /*
        // Method dump skipped, instructions count: 309
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.readJournal():void");
    }

    private final BufferedSink newJournalWriter() throws FileNotFoundException {
        return Okio.buffer(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new Function1<IOException, Unit>(this) { // from class: okhttp3.internal.cache.DiskLruCache$newJournalWriter$faultHidingSink$1
            final /* synthetic */ DiskLruCache this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IOException iOException) {
                invoke(iOException);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull IOException it) {
                Intrinsics.checkNotNullParameter(it, "it");
                Object $this$assertThreadHoldsLock$iv = this.this$0;
                if (!Util.assertionsEnabled || Thread.holdsLock($this$assertThreadHoldsLock$iv)) {
                    this.this$0.hasJournalErrors = true;
                    return;
                }
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + $this$assertThreadHoldsLock$iv);
            }
        }));
    }

    private final void readJournalLine(String line) throws IOException {
        String key;
        int firstSpace = StringsKt.indexOf$default((CharSequence) line, ' ', 0, false, 6, (Object) null);
        if (firstSpace == -1) {
            throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", line));
        }
        int keyBegin = firstSpace + 1;
        int secondSpace = StringsKt.indexOf$default((CharSequence) line, ' ', keyBegin, false, 4, (Object) null);
        if (secondSpace == -1) {
            String substring = line.substring(keyBegin);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            key = substring;
            if (firstSpace == REMOVE.length() && StringsKt.startsWith$default(line, REMOVE, false, 2, (Object) null)) {
                this.lruEntries.remove(key);
                return;
            }
        } else {
            String substring2 = line.substring(keyBegin, secondSpace);
            Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
            key = substring2;
        }
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            entry = new Entry(this, key);
            this.lruEntries.put(key, entry);
        }
        if (secondSpace != -1 && firstSpace == CLEAN.length() && StringsKt.startsWith$default(line, CLEAN, false, 2, (Object) null)) {
            String substring3 = line.substring(secondSpace + 1);
            Intrinsics.checkNotNullExpressionValue(substring3, "this as java.lang.String).substring(startIndex)");
            List parts = StringsKt.split$default((CharSequence) substring3, new char[]{' '}, false, 0, 6, (Object) null);
            entry.setReadable$okhttp(true);
            entry.setCurrentEditor$okhttp(null);
            entry.setLengths$okhttp(parts);
        } else if (secondSpace == -1 && firstSpace == DIRTY.length() && StringsKt.startsWith$default(line, DIRTY, false, 2, (Object) null)) {
            entry.setCurrentEditor$okhttp(new Editor(this, entry));
        } else if (secondSpace != -1 || firstSpace != READ.length() || !StringsKt.startsWith$default(line, READ, false, 2, (Object) null)) {
            throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", line));
        }
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator i = this.lruEntries.values().iterator();
        while (i.hasNext()) {
            Entry next = i.next();
            Intrinsics.checkNotNullExpressionValue(next, "i.next()");
            Entry entry = next;
            if (entry.getCurrentEditor$okhttp() == null) {
                int t = 0;
                int i2 = this.valueCount;
                while (t < i2) {
                    t++;
                    this.size += entry.getLengths$okhttp()[t];
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int t2 = 0;
                int i3 = this.valueCount;
                while (t2 < i3) {
                    t2++;
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(t2));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(t2));
                }
                i.remove();
            }
        }
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        BufferedSink bufferedSink = this.journalWriter;
        if (bufferedSink != null) {
            bufferedSink.close();
        }
        BufferedSink buffer = Okio.buffer(this.fileSystem.sink(this.journalFileTmp));
        try {
            BufferedSink sink = buffer;
            sink.writeUtf8(MAGIC).writeByte(10);
            sink.writeUtf8(VERSION_1).writeByte(10);
            sink.writeDecimalLong((long) this.appVersion).writeByte(10);
            sink.writeDecimalLong((long) getValueCount$okhttp()).writeByte(10);
            sink.writeByte(10);
            for (Entry entry : getLruEntries$okhttp().values()) {
                if (entry.getCurrentEditor$okhttp() != null) {
                    sink.writeUtf8(DIRTY).writeByte(32);
                    sink.writeUtf8(entry.getKey$okhttp());
                    sink.writeByte(10);
                } else {
                    sink.writeUtf8(CLEAN).writeByte(32);
                    sink.writeUtf8(entry.getKey$okhttp());
                    entry.writeLengths$okhttp(sink);
                    sink.writeByte(10);
                }
            }
            Unit unit = Unit.INSTANCE;
            kotlin.p016io.Closeable.closeFinally(buffer, null);
            if (this.fileSystem.exists(this.journalFile)) {
                this.fileSystem.rename(this.journalFile, this.journalFileBackup);
            }
            this.fileSystem.rename(this.journalFileTmp, this.journalFile);
            this.fileSystem.delete(this.journalFileBackup);
            this.journalWriter = newJournalWriter();
            this.hasJournalErrors = false;
            this.mostRecentRebuildFailed = false;
        } catch (Throwable th) {
            kotlin.p016io.Closeable.closeFinally(buffer, null);
            throw th;
        }
    }

    @Nullable
    public final synchronized Snapshot get(@NotNull String key) throws IOException {
        Snapshot snapshot;
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null || (snapshot = entry.snapshot$okhttp()) == null) {
            return null;
        }
        this.redundantOpCount++;
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.writeUtf8(READ).writeByte(32).writeUtf8(key).writeByte(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
        return snapshot;
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j, int i, Object obj) throws IOException {
        if ((i & 2) != 0) {
            j = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j);
    }

    @JvmOverloads
    @Nullable
    public final synchronized Editor edit(@NotNull String key, long expectedSequenceNumber) throws IOException {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (expectedSequenceNumber != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != expectedSequenceNumber)) {
            return null;
        }
        if ((entry == null ? null : entry.getCurrentEditor$okhttp()) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (this.mostRecentTrimFailed || this.mostRecentRebuildFailed) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
            return null;
        }
        BufferedSink journalWriter = this.journalWriter;
        Intrinsics.checkNotNull(journalWriter);
        journalWriter.writeUtf8(DIRTY).writeByte(32).writeUtf8(key).writeByte(10);
        journalWriter.flush();
        if (this.hasJournalErrors) {
            return null;
        }
        if (entry == null) {
            entry = new Entry(this, key);
            this.lruEntries.put(key, entry);
        }
        Editor editor = new Editor(this, entry);
        entry.setCurrentEditor$okhttp(editor);
        return editor;
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized void completeEdit$okhttp(@NotNull Editor editor, boolean success) throws IOException {
        Intrinsics.checkNotNullParameter(editor, "editor");
        Entry entry = editor.getEntry$okhttp();
        if (!Intrinsics.areEqual(entry.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (success && !entry.getReadable$okhttp()) {
            int i = 0;
            int i2 = this.valueCount;
            while (i < i2) {
                i++;
                boolean[] written$okhttp = editor.getWritten$okhttp();
                Intrinsics.checkNotNull(written$okhttp);
                if (!written$okhttp[i]) {
                    editor.abort();
                    throw new IllegalStateException(Intrinsics.stringPlus("Newly created entry didn't create value for index ", Integer.valueOf(i)));
                } else if (!this.fileSystem.exists(entry.getDirtyFiles$okhttp().get(i))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i3 = 0;
        int i4 = this.valueCount;
        while (i3 < i4) {
            i3++;
            File dirty = entry.getDirtyFiles$okhttp().get(i3);
            if (!success || entry.getZombie$okhttp()) {
                this.fileSystem.delete(dirty);
            } else if (this.fileSystem.exists(dirty)) {
                File clean = entry.getCleanFiles$okhttp().get(i3);
                this.fileSystem.rename(dirty, clean);
                long oldLength = entry.getLengths$okhttp()[i3];
                long newLength = this.fileSystem.size(clean);
                entry.getLengths$okhttp()[i3] = newLength;
                this.size = (this.size - oldLength) + newLength;
            }
        }
        entry.setCurrentEditor$okhttp(null);
        if (entry.getZombie$okhttp()) {
            removeEntry$okhttp(entry);
            return;
        }
        this.redundantOpCount++;
        BufferedSink $this$completeEdit_u24lambda_u2d4 = this.journalWriter;
        Intrinsics.checkNotNull($this$completeEdit_u24lambda_u2d4);
        if (entry.getReadable$okhttp() || success) {
            entry.setReadable$okhttp(true);
            $this$completeEdit_u24lambda_u2d4.writeUtf8(CLEAN).writeByte(32);
            $this$completeEdit_u24lambda_u2d4.writeUtf8(entry.getKey$okhttp());
            entry.writeLengths$okhttp($this$completeEdit_u24lambda_u2d4);
            $this$completeEdit_u24lambda_u2d4.writeByte(10);
            if (success) {
                long j = this.nextSequenceNumber;
                this.nextSequenceNumber = j + 1;
                entry.setSequenceNumber$okhttp(j);
            }
        } else {
            getLruEntries$okhttp().remove(entry.getKey$okhttp());
            $this$completeEdit_u24lambda_u2d4.writeUtf8(REMOVE).writeByte(32);
            $this$completeEdit_u24lambda_u2d4.writeUtf8(entry.getKey$okhttp());
            $this$completeEdit_u24lambda_u2d4.writeByte(10);
        }
        $this$completeEdit_u24lambda_u2d4.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        }
    }

    /* access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        return this.redundantOpCount >= 2000 && this.redundantOpCount >= this.lruEntries.size();
    }

    public final synchronized boolean remove(@NotNull String key) throws IOException {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        initialize();
        checkNotClosed();
        validateKey(key);
        Entry entry = this.lruEntries.get(key);
        if (entry == null) {
            return false;
        }
        boolean removed = removeEntry$okhttp(entry);
        if (removed && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return removed;
    }

    public final boolean removeEntry$okhttp(@NotNull Entry entry) throws IOException {
        BufferedSink it;
        Intrinsics.checkNotNullParameter(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (it = this.journalWriter) != null) {
                it.writeUtf8(DIRTY);
                it.writeByte(32);
                it.writeUtf8(entry.getKey$okhttp());
                it.writeByte(10);
                it.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i = 0;
        int i2 = this.valueCount;
        while (i < i2) {
            i++;
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i));
            this.size -= entry.getLengths$okhttp()[i];
            entry.getLengths$okhttp()[i] = 0;
        }
        this.redundantOpCount++;
        BufferedSink it2 = this.journalWriter;
        if (it2 != null) {
            it2.writeUtf8(REMOVE);
            it2.writeByte(32);
            it2.writeUtf8(entry.getKey$okhttp());
            it2.writeByte(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (!journalRebuildRequired()) {
            return true;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0, 2, null);
        return true;
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            BufferedSink bufferedSink = this.journalWriter;
            Intrinsics.checkNotNull(bufferedSink);
            bufferedSink.flush();
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (!this.initialized || this.closed) {
            this.closed = true;
            return;
        }
        Collection $this$toTypedArray$iv = this.lruEntries.values();
        Intrinsics.checkNotNullExpressionValue($this$toTypedArray$iv, "lruEntries.values");
        Object[] array = $this$toTypedArray$iv.toArray(new Entry[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        Entry[] entryArr = (Entry[]) array;
        int i = 0;
        int length = entryArr.length;
        while (i < length) {
            Entry entry = entryArr[i];
            i++;
            if (entry.getCurrentEditor$okhttp() != null) {
                Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
                if (currentEditor$okhttp != null) {
                    currentEditor$okhttp.detach$okhttp();
                }
            }
        }
        trimToSize();
        BufferedSink bufferedSink = this.journalWriter;
        Intrinsics.checkNotNull(bufferedSink);
        bufferedSink.close();
        this.journalWriter = null;
        this.closed = true;
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    private final boolean removeOldestEntry() {
        for (Entry toEvict : this.lruEntries.values()) {
            if (!toEvict.getZombie$okhttp()) {
                Intrinsics.checkNotNullExpressionValue(toEvict, "toEvict");
                removeEntry$okhttp(toEvict);
                return true;
            }
        }
        return false;
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final synchronized void evictAll() throws IOException {
        initialize();
        Collection $this$toTypedArray$iv = this.lruEntries.values();
        Intrinsics.checkNotNullExpressionValue($this$toTypedArray$iv, "lruEntries.values");
        Object[] array = $this$toTypedArray$iv.toArray(new Entry[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        Entry[] entryArr = (Entry[]) array;
        int i = 0;
        int length = entryArr.length;
        while (i < length) {
            Entry entry = entryArr[i];
            i++;
            Intrinsics.checkNotNullExpressionValue(entry, "entry");
            removeEntry$okhttp(entry);
        }
        this.mostRecentTrimFailed = false;
    }

    private final void validateKey(String key) {
        if (!LEGAL_KEY_PATTERN.matches(key)) {
            throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + key + '\"').toString());
        }
    }

    @NotNull
    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Object(this) { // from class: okhttp3.internal.cache.DiskLruCache$snapshots$1
            @NotNull
            private final Iterator<DiskLruCache.Entry> delegate;
            @Nullable
            private DiskLruCache.Snapshot nextSnapshot;
            @Nullable
            private DiskLruCache.Snapshot removeSnapshot;
            final /* synthetic */ DiskLruCache this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
                Iterator<DiskLruCache.Entry> it = new ArrayList(this.this$0.getLruEntries$okhttp().values()).iterator();
                Intrinsics.checkNotNullExpressionValue(it, "ArrayList(lruEntries.values).iterator()");
                this.delegate = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                DiskLruCache diskLruCache = this.this$0;
                DiskLruCache diskLruCache2 = this.this$0;
                synchronized (diskLruCache) {
                    if (diskLruCache2.getClosed$okhttp()) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        DiskLruCache.Entry next = this.delegate.next();
                        DiskLruCache.Snapshot snapshot$okhttp = next == null ? null : next.snapshot$okhttp();
                        if (snapshot$okhttp != null) {
                            this.nextSnapshot = snapshot$okhttp;
                            return true;
                        }
                    }
                    Unit unit = Unit.INSTANCE;
                    return false;
                }
            }

            @Override // java.util.Iterator
            @NotNull
            public DiskLruCache.Snapshot next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.removeSnapshot = this.nextSnapshot;
                this.nextSnapshot = null;
                DiskLruCache.Snapshot snapshot = this.removeSnapshot;
                Intrinsics.checkNotNull(snapshot);
                return snapshot;
            }

            @Override // java.util.Iterator
            public void remove() {
                DiskLruCache.Snapshot removeSnapshot = this.removeSnapshot;
                if (removeSnapshot == null) {
                    throw new IllegalStateException("remove() before next()".toString());
                }
                try {
                    this.this$0.remove(removeSnapshot.key());
                    this.removeSnapshot = null;
                } catch (IOException e) {
                    this.removeSnapshot = null;
                } catch (Throwable th) {
                    this.removeSnapshot = null;
                    throw th;
                }
            }
        };
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n��\n\u0002\u0010\t\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0004\u0018��2\u00020\u0001B-\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\f\u0010\u000e\u001a\b\u0018\u00010\u000fR\u00020\u0010J\u000e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0002\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n��R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n��R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n��R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n��¨\u0006\u0015"}, m373d2 = {"Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "Ljava/io/Closeable;", Action.KEY_ATTRIBUTE, "", "sequenceNumber", "", "sources", "", "Lokio/Source;", "lengths", "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;JLjava/util/List;[J)V", "close", "", "edit", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getLength", "index", "", "getSource", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$Snapshot.class */
    public final class Snapshot implements Closeable {
        @NotNull
        private final String key;
        private final long sequenceNumber;
        @NotNull
        private final List<Source> sources;
        @NotNull
        private final long[] lengths;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX DEBUG: Multi-variable search result rejected for r9v0, resolved type: java.util.List<? extends okio.Source> */
        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(@NotNull DiskLruCache this$0, String key, @NotNull long sequenceNumber, @NotNull List<? extends Source> list, long[] lengths) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
            Intrinsics.checkNotNullParameter(list, "sources");
            Intrinsics.checkNotNullParameter(lengths, "lengths");
            this.this$0 = this$0;
            this.key = key;
            this.sequenceNumber = sequenceNumber;
            this.sources = list;
            this.lengths = lengths;
        }

        @NotNull
        public final String key() {
            return this.key;
        }

        @Nullable
        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        @NotNull
        public final Source getSource(int index) {
            return this.sources.get(index);
        }

        public final long getLength(int index) {
            return this.lengths[index];
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            for (Source source : this.sources) {
                Util.closeQuietly(source);
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��@\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n��\b\u0004\u0018��2\u00020\u0001B\u0013\b��\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u000fJ\r\u0010\u0011\u001a\u00020\u000fH��¢\u0006\u0002\b\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n��R\u0018\u0010\u0002\u001a\u00060\u0003R\u00020\u0004X\u0004¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\b\n��\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, m373d2 = {"Lokhttp3/internal/cache/DiskLruCache$Editor;", "", "entry", "Lokhttp3/internal/cache/DiskLruCache$Entry;", "Lokhttp3/internal/cache/DiskLruCache;", "(Lokhttp3/internal/cache/DiskLruCache;Lokhttp3/internal/cache/DiskLruCache$Entry;)V", "done", "", "getEntry$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Entry;", "written", "", "getWritten$okhttp", "()[Z", LineReader.SEND_BREAK, "", "commit", "detach", "detach$okhttp", "newSink", "Lokio/Sink;", "index", "", "newSource", "Lokio/Source;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$Editor.class */
    public final class Editor {
        @NotNull
        private final Entry entry;
        @Nullable
        private final boolean[] written;
        private boolean done;
        final /* synthetic */ DiskLruCache this$0;

        public Editor(@NotNull DiskLruCache this$0, Entry entry) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(entry, "entry");
            this.this$0 = this$0;
            this.entry = entry;
            this.written = this.entry.getReadable$okhttp() ? null : new boolean[this.this$0.getValueCount$okhttp()];
        }

        @NotNull
        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        @Nullable
        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final void detach$okhttp() {
            if (!Intrinsics.areEqual(this.entry.getCurrentEditor$okhttp(), this)) {
                return;
            }
            if (this.this$0.civilizedFileSystem) {
                this.this$0.completeEdit$okhttp(this, false);
            } else {
                this.entry.setZombie$okhttp(true);
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x007e
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @org.jetbrains.annotations.Nullable
        public final okio.Source newSource(int r5) {
            /*
                r4 = this;
                r0 = r4
                okhttp3.internal.cache.DiskLruCache r0 = r0.this$0
                r6 = r0
                r0 = r4
                okhttp3.internal.cache.DiskLruCache r0 = r0.this$0
                r7 = r0
                r0 = r6
                r8 = r0
                r0 = r8
                monitor-enter(r0)
                r0 = 0
                r9 = r0
                r0 = r4
                boolean r0 = r0.done     // Catch: all -> 0x0090
                if (r0 != 0) goto L_0x001f
                r0 = 1
                goto L_0x0020
            L_0x001f:
                r0 = 0
            L_0x0020:
                if (r0 != 0) goto L_0x0034
                java.lang.String r0 = "Check failed."
                r10 = r0
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: all -> 0x0090
                r1 = r0
                r2 = r10
                java.lang.String r2 = r2.toString()     // Catch: all -> 0x0090
                r1.<init>(r2)     // Catch: all -> 0x0090
                throw r0     // Catch: all -> 0x0090
            L_0x0034:
                r0 = r4
                okhttp3.internal.cache.DiskLruCache$Entry r0 = r0.getEntry$okhttp()     // Catch: all -> 0x0090
                boolean r0 = r0.getReadable$okhttp()     // Catch: all -> 0x0090
                if (r0 == 0) goto L_0x0056
                r0 = r4
                okhttp3.internal.cache.DiskLruCache$Entry r0 = r0.getEntry$okhttp()     // Catch: all -> 0x0090
                okhttp3.internal.cache.DiskLruCache$Editor r0 = r0.getCurrentEditor$okhttp()     // Catch: all -> 0x0090
                r1 = r4
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: all -> 0x0090
                if (r0 == 0) goto L_0x0056
                r0 = r4
                okhttp3.internal.cache.DiskLruCache$Entry r0 = r0.getEntry$okhttp()     // Catch: all -> 0x0090
                boolean r0 = r0.getZombie$okhttp()     // Catch: all -> 0x0090
                if (r0 == 0) goto L_0x005f
            L_0x0056:
                r0 = 0
                r13 = r0
                r0 = r8
                monitor-exit(r0)
                r0 = r13
                return r0
            L_0x005f:
                r0 = r7
                okhttp3.internal.io.FileSystem r0 = r0.getFileSystem$okhttp()     // Catch: FileNotFoundException -> 0x007e, all -> 0x0090
                r1 = r4
                okhttp3.internal.cache.DiskLruCache$Entry r1 = r1.getEntry$okhttp()     // Catch: FileNotFoundException -> 0x007e, all -> 0x0090
                java.util.List r1 = r1.getCleanFiles$okhttp()     // Catch: FileNotFoundException -> 0x007e, all -> 0x0090
                r2 = r5
                java.lang.Object r1 = r1.get(r2)     // Catch: FileNotFoundException -> 0x007e, all -> 0x0090
                java.io.File r1 = (java.io.File) r1     // Catch: FileNotFoundException -> 0x007e, all -> 0x0090
                okio.Source r0 = r0.source(r1)     // Catch: FileNotFoundException -> 0x007e, all -> 0x0090
                r11 = r0
                goto L_0x0086
            L_0x007e:
                r10 = move-exception
                r0 = 0
                okio.Source r0 = (okio.Source) r0     // Catch: all -> 0x0090
                r11 = r0
            L_0x0086:
                r0 = r11
                r12 = r0
                r0 = r8
                monitor-exit(r0)
                r0 = r12
                return r0
            L_0x0090:
                r9 = move-exception
                r0 = r8
                monitor-exit(r0)
                r0 = r9
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:22:0x0088
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @org.jetbrains.annotations.NotNull
        public final okio.Sink newSink(int r9) {
            /*
                r8 = this;
                r0 = r8
                okhttp3.internal.cache.DiskLruCache r0 = r0.this$0
                r10 = r0
                r0 = r8
                okhttp3.internal.cache.DiskLruCache r0 = r0.this$0
                r11 = r0
                r0 = r10
                r12 = r0
                r0 = r12
                monitor-enter(r0)
                r0 = 0
                r13 = r0
                r0 = r8
                boolean r0 = r0.done     // Catch: all -> 0x00b5
                if (r0 != 0) goto L_0x001f
                r0 = 1
                goto L_0x0020
            L_0x001f:
                r0 = 0
            L_0x0020:
                if (r0 != 0) goto L_0x0034
                java.lang.String r0 = "Check failed."
                r14 = r0
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: all -> 0x00b5
                r1 = r0
                r2 = r14
                java.lang.String r2 = r2.toString()     // Catch: all -> 0x00b5
                r1.<init>(r2)     // Catch: all -> 0x00b5
                throw r0     // Catch: all -> 0x00b5
            L_0x0034:
                r0 = r8
                okhttp3.internal.cache.DiskLruCache$Entry r0 = r0.getEntry$okhttp()     // Catch: all -> 0x00b5
                okhttp3.internal.cache.DiskLruCache$Editor r0 = r0.getCurrentEditor$okhttp()     // Catch: all -> 0x00b5
                r1 = r8
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)     // Catch: all -> 0x00b5
                if (r0 != 0) goto L_0x004d
                okio.Sink r0 = okio.Okio.blackhole()     // Catch: all -> 0x00b5
                r19 = r0
                r0 = r12
                monitor-exit(r0)
                r0 = r19
                return r0
            L_0x004d:
                r0 = r8
                okhttp3.internal.cache.DiskLruCache$Entry r0 = r0.getEntry$okhttp()     // Catch: all -> 0x00b5
                boolean r0 = r0.getReadable$okhttp()     // Catch: all -> 0x00b5
                if (r0 != 0) goto L_0x0062
                r0 = r8
                boolean[] r0 = r0.getWritten$okhttp()     // Catch: all -> 0x00b5
                r1 = r0
                kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: all -> 0x00b5
                r1 = r9
                r2 = 1
                r0[r1] = r2     // Catch: all -> 0x00b5
            L_0x0062:
                r0 = r8
                okhttp3.internal.cache.DiskLruCache$Entry r0 = r0.getEntry$okhttp()     // Catch: all -> 0x00b5
                java.util.List r0 = r0.getDirtyFiles$okhttp()     // Catch: all -> 0x00b5
                r1 = r9
                java.lang.Object r0 = r0.get(r1)     // Catch: all -> 0x00b5
                java.io.File r0 = (java.io.File) r0     // Catch: all -> 0x00b5
                r15 = r0
                r0 = 0
                r14 = r0
                r0 = r11
                okhttp3.internal.io.FileSystem r0 = r0.getFileSystem$okhttp()     // Catch: FileNotFoundException -> 0x0088, all -> 0x00b5
                r1 = r15
                okio.Sink r0 = r0.sink(r1)     // Catch: FileNotFoundException -> 0x0088, all -> 0x00b5
                r14 = r0
                goto L_0x0095
            L_0x0088:
                r16 = move-exception
                okio.Sink r0 = okio.Okio.blackhole()     // Catch: all -> 0x00b5
                r18 = r0
                r0 = r12
                monitor-exit(r0)
                r0 = r18
                return r0
            L_0x0095:
                okhttp3.internal.cache.FaultHidingSink r0 = new okhttp3.internal.cache.FaultHidingSink     // Catch: all -> 0x00b5
                r1 = r0
                r2 = r14
                okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1 r3 = new okhttp3.internal.cache.DiskLruCache$Editor$newSink$1$1     // Catch: all -> 0x00b5
                r4 = r3
                r5 = r11
                r6 = r8
                r4.<init>(r5, r6)     // Catch: all -> 0x00b5
                kotlin.jvm.functions.Function1 r3 = (kotlin.jvm.functions.Function1) r3     // Catch: all -> 0x00b5
                r1.<init>(r2, r3)     // Catch: all -> 0x00b5
                okio.Sink r0 = (okio.Sink) r0     // Catch: all -> 0x00b5
                r17 = r0
                r0 = r12
                monitor-exit(r0)
                r0 = r17
                return r0
            L_0x00b5:
                r13 = move-exception
                r0 = r12
                monitor-exit(r0)
                r0 = r13
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.cache.DiskLruCache.Editor.newSink(int):okio.Sink");
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (Intrinsics.areEqual(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                    diskLruCache2.completeEdit$okhttp(this, true);
                }
                this.done = true;
                Unit unit = Unit.INSTANCE;
            }
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            DiskLruCache diskLruCache2 = this.this$0;
            synchronized (diskLruCache) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                if (Intrinsics.areEqual(getEntry$okhttp().getCurrentEditor$okhttp(), this)) {
                    diskLruCache2.completeEdit$okhttp(this, false);
                }
                this.done = true;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��v\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u0001\n��\n\u0002\u0010 \n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018��2\u00020\u0001B\u000f\b��\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010.\u001a\u00020/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H\u0002J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u001aH\u0002J\u001b\u00105\u001a\u0002062\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000301H��¢\u0006\u0002\b7J\u0013\u00108\u001a\b\u0018\u000109R\u00020\fH��¢\u0006\u0002\b:J\u0015\u0010;\u001a\u0002062\u0006\u0010<\u001a\u00020=H��¢\u0006\u0002\b>R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR \u0010\n\u001a\b\u0018\u00010\u000bR\u00020\fX\u000e¢\u0006\u000e\n��\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n��\u001a\u0004\b\u0012\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n��\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n��\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u000e¢\u0006\u000e\n��\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010%\u001a\u00020&X\u000e¢\u0006\u000e\n��\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020 X\u000e¢\u0006\u000e\n��\u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$¨\u0006?"}, m373d2 = {"Lokhttp3/internal/cache/DiskLruCache$Entry;", "", Action.KEY_ATTRIBUTE, "", "(Lokhttp3/internal/cache/DiskLruCache;Ljava/lang/String;)V", "cleanFiles", "", "Ljava/io/File;", "getCleanFiles$okhttp", "()Ljava/util/List;", "currentEditor", "Lokhttp3/internal/cache/DiskLruCache$Editor;", "Lokhttp3/internal/cache/DiskLruCache;", "getCurrentEditor$okhttp", "()Lokhttp3/internal/cache/DiskLruCache$Editor;", "setCurrentEditor$okhttp", "(Lokhttp3/internal/cache/DiskLruCache$Editor;)V", "dirtyFiles", "getDirtyFiles$okhttp", "getKey$okhttp", "()Ljava/lang/String;", "lengths", "", "getLengths$okhttp", "()[J", "lockingSourceCount", "", "getLockingSourceCount$okhttp", "()I", "setLockingSourceCount$okhttp", "(I)V", "readable", "", "getReadable$okhttp", "()Z", "setReadable$okhttp", "(Z)V", "sequenceNumber", "", "getSequenceNumber$okhttp", "()J", "setSequenceNumber$okhttp", "(J)V", "zombie", "getZombie$okhttp", "setZombie$okhttp", "invalidLengths", "", "strings", "", "newSource", "Lokio/Source;", "index", "setLengths", "", "setLengths$okhttp", "snapshot", "Lokhttp3/internal/cache/DiskLruCache$Snapshot;", "snapshot$okhttp", "writeLengths", "writer", "Lokio/BufferedSink;", "writeLengths$okhttp", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$Entry.class */
    public final class Entry {
        @NotNull
        private final String key;
        @NotNull
        private final long[] lengths;
        @NotNull
        private final List<File> cleanFiles = new ArrayList();
        @NotNull
        private final List<File> dirtyFiles = new ArrayList();
        private boolean readable;
        private boolean zombie;
        @Nullable
        private Editor currentEditor;
        private int lockingSourceCount;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;

        public Entry(@NotNull DiskLruCache this$0, String key) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
            this.this$0 = this$0;
            this.key = key;
            this.lengths = new long[this.this$0.getValueCount$okhttp()];
            StringBuilder fileBuilder = new StringBuilder(this.key).append('.');
            int truncateTo = fileBuilder.length();
            int i = 0;
            int valueCount$okhttp = this.this$0.getValueCount$okhttp();
            while (i < valueCount$okhttp) {
                i++;
                fileBuilder.append(i);
                this.cleanFiles.add(new File(this.this$0.getDirectory(), fileBuilder.toString()));
                fileBuilder.append(".tmp");
                this.dirtyFiles.add(new File(this.this$0.getDirectory(), fileBuilder.toString()));
                fileBuilder.setLength(truncateTo);
            }
        }

        @NotNull
        public final String getKey$okhttp() {
            return this.key;
        }

        @NotNull
        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        @NotNull
        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        @NotNull
        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final void setReadable$okhttp(boolean z) {
            this.readable = z;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setZombie$okhttp(boolean z) {
            this.zombie = z;
        }

        @Nullable
        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final void setCurrentEditor$okhttp(@Nullable Editor editor) {
            this.currentEditor = editor;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final void setLockingSourceCount$okhttp(int i) {
            this.lockingSourceCount = i;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final void setSequenceNumber$okhttp(long j) {
            this.sequenceNumber = j;
        }

        public final void setLengths$okhttp(@NotNull List<String> list) throws IOException {
            Intrinsics.checkNotNullParameter(list, "strings");
            if (list.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
            try {
                int i = 0;
                int size = list.size();
                while (i < size) {
                    i++;
                    this.lengths[i] = Long.parseLong(list.get(i));
                }
            } catch (NumberFormatException e) {
                invalidLengths(list);
                throw new KotlinNothingValueException();
            }
        }

        public final void writeLengths$okhttp(@NotNull BufferedSink writer) throws IOException {
            Intrinsics.checkNotNullParameter(writer, "writer");
            long[] jArr = this.lengths;
            int i = 0;
            int length = jArr.length;
            while (i < length) {
                long length2 = jArr[i];
                i++;
                writer.writeByte(32).writeDecimalLong(length2);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException(Intrinsics.stringPlus("unexpected journal line: ", list));
        }

        @Nullable
        public final Snapshot snapshot$okhttp() {
            Object $this$assertThreadHoldsLock$iv = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock($this$assertThreadHoldsLock$iv)) {
                throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + $this$assertThreadHoldsLock$iv);
            } else if (!this.readable) {
                return null;
            } else {
                if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                    return null;
                }
                List<Source> sources = new ArrayList();
                long[] lengths = (long[]) this.lengths.clone();
                try {
                    int i = 0;
                    int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                    while (i < valueCount$okhttp) {
                        i++;
                        sources.add(newSource(i));
                    }
                    return new Snapshot(this.this$0, this.key, this.sequenceNumber, sources, lengths);
                } catch (FileNotFoundException e) {
                    for (Source source : sources) {
                        Util.closeQuietly(source);
                    }
                    try {
                        this.this$0.removeEntry$okhttp(this);
                        return null;
                    } catch (IOException e2) {
                        return null;
                    }
                }
            }
        }

        private final Source newSource(int index) {
            Source fileSource = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(index));
            if (this.this$0.civilizedFileSystem) {
                return fileSource;
            }
            this.lockingSourceCount++;
            return new DiskLruCache$Entry$newSource$1(fileSource, this.this$0, this);
        }
    }

    /* compiled from: DiskLruCache.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\"\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\u0007\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\b\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\t\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\n\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\u000b\u001a\u00020\f8\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\r\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\u000e\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��R\u0010\u0010\u0010\u001a\u00020\u00068\u0006XD¢\u0006\u0002\n��¨\u0006\u0011"}, m373d2 = {"Lokhttp3/internal/cache/DiskLruCache$Companion;", "", "()V", "ANY_SEQUENCE_NUMBER", "", "CLEAN", "", "DIRTY", "JOURNAL_FILE", "JOURNAL_FILE_BACKUP", "JOURNAL_FILE_TEMP", "LEGAL_KEY_PATTERN", "Lkotlin/text/Regex;", "MAGIC", "READ", "REMOVE", "VERSION_1", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/cache/DiskLruCache$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }
    }
}
