package org.eclipse.jetty.util;

import dev.morphia.mapping.Mapper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/RolloverFileOutputStream.class */
public class RolloverFileOutputStream extends OutputStream {
    private static Timer __rollover;
    static final String YYYY_MM_DD = "yyyy_mm_dd";
    static final String ROLLOVER_FILE_DATE_FORMAT = "yyyy_MM_dd";
    static final String ROLLOVER_FILE_BACKUP_FORMAT = "HHmmssSSS";
    static final int ROLLOVER_FILE_RETAIN_DAYS = 31;
    private OutputStream _out;
    private RollTask _rollTask;
    private SimpleDateFormat _fileBackupFormat;
    private SimpleDateFormat _fileDateFormat;
    private String _filename;
    private File _file;
    private boolean _append;
    private int _retainDays;

    public RolloverFileOutputStream(String filename) throws IOException {
        this(filename, true, 31);
    }

    public RolloverFileOutputStream(String filename, boolean append) throws IOException {
        this(filename, append, 31);
    }

    public RolloverFileOutputStream(String filename, boolean append, int retainDays) throws IOException {
        this(filename, append, retainDays, TimeZone.getDefault());
    }

    public RolloverFileOutputStream(String filename, boolean append, int retainDays, TimeZone zone) throws IOException {
        this(filename, append, retainDays, zone, null, null, ZonedDateTime.now(zone.toZoneId()));
    }

    public RolloverFileOutputStream(String filename, boolean append, int retainDays, TimeZone zone, String dateFormat, String backupFormat) throws IOException {
        this(filename, append, retainDays, zone, dateFormat, backupFormat, ZonedDateTime.now(zone.toZoneId()));
    }

    RolloverFileOutputStream(String filename, boolean append, int retainDays, TimeZone zone, String dateFormat, String backupFormat, ZonedDateTime now) throws IOException {
        this._fileDateFormat = new SimpleDateFormat(dateFormat == null ? ROLLOVER_FILE_DATE_FORMAT : dateFormat);
        this._fileBackupFormat = new SimpleDateFormat(backupFormat == null ? ROLLOVER_FILE_BACKUP_FORMAT : backupFormat);
        this._fileBackupFormat.setTimeZone(zone);
        this._fileDateFormat.setTimeZone(zone);
        if (filename != null) {
            filename = filename.trim();
            if (filename.length() == 0) {
                filename = null;
            }
        }
        if (filename == null) {
            throw new IllegalArgumentException("Invalid filename");
        }
        this._filename = filename;
        this._append = append;
        this._retainDays = retainDays;
        setFile(now);
        synchronized (RolloverFileOutputStream.class) {
            if (__rollover == null) {
                __rollover = new Timer(RolloverFileOutputStream.class.getName(), true);
            }
        }
        scheduleNextRollover(now);
    }

    public static ZonedDateTime toMidnight(ZonedDateTime now) {
        return now.toLocalDate().atStartOfDay(now.getZone()).plus(1L, (TemporalUnit) ChronoUnit.DAYS);
    }

    /* access modifiers changed from: private */
    public void scheduleNextRollover(ZonedDateTime now) {
        this._rollTask = new RollTask();
        long delay = toMidnight(now).toInstant().toEpochMilli() - now.toInstant().toEpochMilli();
        synchronized (RolloverFileOutputStream.class) {
            __rollover.schedule(this._rollTask, delay);
        }
    }

    public String getFilename() {
        return this._filename;
    }

    public String getDatedFilename() {
        if (this._file == null) {
            return null;
        }
        return this._file.toString();
    }

    public int getRetainDays() {
        return this._retainDays;
    }

    void setFile(ZonedDateTime now) throws IOException {
        File oldFile = null;
        File newFile = null;
        File backupFile = null;
        synchronized (this) {
            this._filename = new File(this._filename).getCanonicalPath();
            File file = new File(this._filename);
            File dir = new File(file.getParent());
            if (!dir.isDirectory() || !dir.canWrite()) {
                throw new IOException("Cannot write log directory " + dir);
            }
            String filename = file.getName();
            int datePattern = filename.toLowerCase(Locale.ENGLISH).indexOf(YYYY_MM_DD);
            if (datePattern >= 0) {
                file = new File(dir, filename.substring(0, datePattern) + this._fileDateFormat.format(new Date(now.toInstant().toEpochMilli())) + filename.substring(datePattern + YYYY_MM_DD.length()));
            }
            if (file.exists() && !file.canWrite()) {
                throw new IOException("Cannot write log file " + file);
            } else if (this._out == null || datePattern >= 0) {
                oldFile = this._file;
                this._file = file;
                newFile = this._file;
                OutputStream oldOut = this._out;
                if (oldOut != null) {
                    oldOut.close();
                }
                if (!this._append && file.exists()) {
                    backupFile = new File(file.toString() + Mapper.IGNORED_FIELDNAME + this._fileBackupFormat.format(new Date(now.toInstant().toEpochMilli())));
                    renameFile(file, backupFile);
                }
                this._out = new FileOutputStream(file.toString(), this._append);
            }
        }
        if (newFile != null) {
            rollover(oldFile, backupFile, newFile);
        }
    }

    private void renameFile(File src, File dest) throws IOException {
        if (!src.renameTo(dest)) {
            try {
                Files.move(src.toPath(), dest.toPath(), new CopyOption[0]);
            } catch (IOException e) {
                Files.copy(src.toPath(), dest.toPath(), new CopyOption[0]);
                Files.deleteIfExists(src.toPath());
            }
        }
    }

    protected void rollover(File oldFile, File backupFile, File newFile) {
    }

    void removeOldFiles(ZonedDateTime now) {
        if (this._retainDays > 0) {
            long expired = now.minus((long) this._retainDays, (TemporalUnit) ChronoUnit.DAYS).toInstant().toEpochMilli();
            File file = new File(this._filename);
            File dir = new File(file.getParent());
            String fn = file.getName();
            int s = fn.toLowerCase(Locale.ENGLISH).indexOf(YYYY_MM_DD);
            if (s >= 0) {
                String prefix = fn.substring(0, s);
                String suffix = fn.substring(s + YYYY_MM_DD.length());
                String[] logList = dir.list();
                for (String fn2 : logList) {
                    if (fn2.startsWith(prefix) && fn2.indexOf(suffix, prefix.length()) >= 0) {
                        File f = new File(dir, fn2);
                        if (f.lastModified() < expired) {
                            f.delete();
                        }
                    }
                }
            }
        }
    }

    @Override // java.io.OutputStream
    public void write(int b) throws IOException {
        synchronized (this) {
            this._out.write(b);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf) throws IOException {
        synchronized (this) {
            this._out.write(buf);
        }
    }

    @Override // java.io.OutputStream
    public void write(byte[] buf, int off, int len) throws IOException {
        synchronized (this) {
            this._out.write(buf, off, len);
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() throws IOException {
        synchronized (this) {
            this._out.flush();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:6:0x0018
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws java.io.IOException {
        /*
            r3 = this;
            r0 = r3
            r1 = r0
            r4 = r1
            monitor-enter(r0)
            r0 = r3
            java.io.OutputStream r0 = r0._out     // Catch: all -> 0x0018, all -> 0x002a
            r0.close()     // Catch: all -> 0x0018, all -> 0x002a
            r0 = r3
            r1 = 0
            r0._out = r1     // Catch: all -> 0x002a
            r0 = r3
            r1 = 0
            r0._file = r1     // Catch: all -> 0x002a
            goto L_0x0025
        L_0x0018:
            r5 = move-exception
            r0 = r3
            r1 = 0
            r0._out = r1     // Catch: all -> 0x002a
            r0 = r3
            r1 = 0
            r0._file = r1     // Catch: all -> 0x002a
            r0 = r5
            throw r0     // Catch: all -> 0x002a
        L_0x0025:
            r0 = r4
            monitor-exit(r0)     // Catch: all -> 0x002a
            goto L_0x002f
        L_0x002a:
            r6 = move-exception
            r0 = r4
            monitor-exit(r0)     // Catch: all -> 0x002a
            r0 = r6
            throw r0
        L_0x002f:
            java.lang.Class<org.eclipse.jetty.util.RolloverFileOutputStream> r0 = org.eclipse.jetty.util.RolloverFileOutputStream.class
            r1 = r0
            r4 = r1
            monitor-enter(r0)
            r0 = r3
            org.eclipse.jetty.util.RolloverFileOutputStream$RollTask r0 = r0._rollTask     // Catch: all -> 0x0048
            if (r0 == 0) goto L_0x0043
            r0 = r3
            org.eclipse.jetty.util.RolloverFileOutputStream$RollTask r0 = r0._rollTask     // Catch: all -> 0x0048
            boolean r0 = r0.cancel()     // Catch: all -> 0x0048
        L_0x0043:
            r0 = r4
            monitor-exit(r0)     // Catch: all -> 0x0048
            goto L_0x004f
        L_0x0048:
            r7 = move-exception
            r0 = r4
            monitor-exit(r0)     // Catch: all -> 0x0048
            r0 = r7
            throw r0
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.RolloverFileOutputStream.close():void");
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/RolloverFileOutputStream$RollTask.class */
    public class RollTask extends TimerTask {
        private RollTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            try {
                ZonedDateTime now = ZonedDateTime.now(RolloverFileOutputStream.this._fileDateFormat.getTimeZone().toZoneId());
                RolloverFileOutputStream.this.setFile(now);
                RolloverFileOutputStream.this.removeOldFiles(now);
                RolloverFileOutputStream.this.scheduleNextRollover(now);
            } catch (Throwable t) {
                t.printStackTrace(System.err);
            }
        }
    }
}
