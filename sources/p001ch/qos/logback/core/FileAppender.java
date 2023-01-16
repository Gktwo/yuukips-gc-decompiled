package p001ch.qos.logback.core;

import java.io.File;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Map;
import p001ch.qos.logback.core.recovery.ResilientFileOutputStream;
import p001ch.qos.logback.core.util.ContextUtil;
import p001ch.qos.logback.core.util.FileSize;
import p001ch.qos.logback.core.util.FileUtil;

/* renamed from: ch.qos.logback.core.FileAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/FileAppender.class */
public class FileAppender<E> extends OutputStreamAppender<E> {
    public static final long DEFAULT_BUFFER_SIZE = 8192;
    protected static String COLLISION_WITH_EARLIER_APPENDER_URL = "http://logback.qos.ch/codes.html#earlier_fa_collision";
    protected boolean append = true;
    protected String fileName = null;
    private boolean prudent = false;
    private FileSize bufferSize = new FileSize(DEFAULT_BUFFER_SIZE);

    public void setFile(String file) {
        if (file == null) {
            this.fileName = file;
        } else {
            this.fileName = file.trim();
        }
    }

    public boolean isAppend() {
        return this.append;
    }

    public final String rawFileProperty() {
        return this.fileName;
    }

    public String getFile() {
        return this.fileName;
    }

    @Override // p001ch.qos.logback.core.OutputStreamAppender, p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int errors = 0;
        if (getFile() != null) {
            addInfo("File property is set to [" + this.fileName + "]");
            if (this.prudent && !isAppend()) {
                setAppend(true);
                addWarn("Setting \"Append\" property to true on account of \"Prudent\" mode");
            }
            if (checkForFileCollisionInPreviousFileAppenders()) {
                addError("Collisions detected with FileAppender/RollingAppender instances defined earlier. Aborting.");
                addError(CoreConstants.MORE_INFO_PREFIX + COLLISION_WITH_EARLIER_APPENDER_URL);
                errors = 0 + 1;
            } else {
                try {
                    openFile(getFile());
                } catch (IOException e) {
                    errors = 0 + 1;
                    addError("openFile(" + this.fileName + "," + this.append + ") call failed.", e);
                }
            }
        } else {
            errors = 0 + 1;
            addError("\"File\" property not set for appender named [" + this.name + "].");
        }
        if (errors == 0) {
            start();
        }
    }

    @Override // p001ch.qos.logback.core.OutputStreamAppender, p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        stop();
        Map<String, String> map = ContextUtil.getFilenameCollisionMap(this.context);
        if (map != null && getName() != null) {
            map.remove(getName());
        }
    }

    protected boolean checkForFileCollisionInPreviousFileAppenders() {
        Map<String, String> map;
        boolean collisionsDetected = false;
        if (!(this.fileName == null || (map = (Map) this.context.getObject(CoreConstants.FA_FILENAME_COLLISION_MAP)) == null)) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (this.fileName.equals(entry.getValue())) {
                    addErrorForCollision("File", entry.getValue(), entry.getKey());
                    collisionsDetected = true;
                }
            }
            if (this.name != null) {
                map.put(getName(), this.fileName);
            }
            return collisionsDetected;
        }
        return false;
    }

    protected void addErrorForCollision(String optionName, String optionValue, String appenderName) {
        addError("'" + optionName + "' option has the same value \"" + optionValue + "\" as that given for appender [" + appenderName + "] defined earlier.");
    }

    public void openFile(String file_name) throws IOException {
        this.lock.lock();
        try {
            File file = new File(file_name);
            if (!FileUtil.createMissingParentDirectories(file)) {
                addError("Failed to create parent directories for [" + file.getAbsolutePath() + "]");
            }
            ResilientFileOutputStream resilientFos = new ResilientFileOutputStream(file, this.append, this.bufferSize.getSize());
            resilientFos.setContext(this.context);
            setOutputStream(resilientFos);
            this.lock.unlock();
        } catch (Throwable th) {
            this.lock.unlock();
            throw th;
        }
    }

    public boolean isPrudent() {
        return this.prudent;
    }

    public void setPrudent(boolean prudent) {
        this.prudent = prudent;
    }

    public void setAppend(boolean append) {
        this.append = append;
    }

    public void setBufferSize(FileSize bufferSize) {
        addInfo("Setting bufferSize to [" + bufferSize.toString() + "]");
        this.bufferSize = bufferSize;
    }

    private void safeWrite(E event) throws IOException {
        FileLock fileLock;
        boolean interrupted;
        ResilientFileOutputStream resilientFOS = (ResilientFileOutputStream) getOutputStream();
        FileChannel fileChannel = resilientFOS.getChannel();
        if (fileChannel != null) {
            try {
                interrupted = Thread.interrupted();
                fileLock = null;
                try {
                    fileLock = fileChannel.lock();
                    long position = fileChannel.position();
                    long size = fileChannel.size();
                    if (size != position) {
                        fileChannel.position(size);
                    }
                    writeOut(event);
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                } catch (IOException e) {
                    resilientFOS.postIOFailure(e);
                    if (fileLock != null && fileLock.isValid()) {
                        fileLock.release();
                    }
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                    }
                }
            } catch (Throwable th) {
                if (fileLock != null && fileLock.isValid()) {
                    fileLock.release();
                }
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.OutputStreamAppender
    public void writeOut(E event) throws IOException {
        if (this.prudent) {
            safeWrite(event);
        } else {
            writeOut(event);
        }
    }
}
