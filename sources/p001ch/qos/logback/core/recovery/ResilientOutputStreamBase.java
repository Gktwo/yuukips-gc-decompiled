package p001ch.qos.logback.core.recovery;

import java.io.IOException;
import java.io.OutputStream;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.status.ErrorStatus;
import p001ch.qos.logback.core.status.InfoStatus;
import p001ch.qos.logback.core.status.Status;
import p001ch.qos.logback.core.status.StatusManager;

/* renamed from: ch.qos.logback.core.recovery.ResilientOutputStreamBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/recovery/ResilientOutputStreamBase.class */
public abstract class ResilientOutputStreamBase extends OutputStream {
    static final int STATUS_COUNT_LIMIT = 8;
    private Context context;
    private RecoveryCoordinator recoveryCoordinator;

    /* renamed from: os */
    protected OutputStream f15os;
    private int noContextWarning = 0;
    private int statusCount = 0;
    protected boolean presumedClean = true;

    abstract String getDescription();

    abstract OutputStream openNewOutputStream() throws IOException;

    private boolean isPresumedInError() {
        return this.recoveryCoordinator != null && !this.presumedClean;
    }

    @Override // java.io.OutputStream
    public void write(byte[] b, int off, int len) {
        if (!isPresumedInError()) {
            try {
                this.f15os.write(b, off, len);
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        } else if (!this.recoveryCoordinator.isTooSoon()) {
            attemptRecovery();
        }
    }

    @Override // java.io.OutputStream
    public void write(int b) {
        if (!isPresumedInError()) {
            try {
                this.f15os.write(b);
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        } else if (!this.recoveryCoordinator.isTooSoon()) {
            attemptRecovery();
        }
    }

    @Override // java.io.OutputStream, java.io.Flushable
    public void flush() {
        if (this.f15os != null) {
            try {
                this.f15os.flush();
                postSuccessfulWrite();
            } catch (IOException e) {
                postIOFailure(e);
            }
        }
    }

    private void postSuccessfulWrite() {
        if (this.recoveryCoordinator != null) {
            this.recoveryCoordinator = null;
            this.statusCount = 0;
            addStatus(new InfoStatus("Recovered from IO failure on " + getDescription(), this));
        }
    }

    public void postIOFailure(IOException e) {
        addStatusIfCountNotOverLimit(new ErrorStatus("IO failure while writing to " + getDescription(), this, e));
        this.presumedClean = false;
        if (this.recoveryCoordinator == null) {
            this.recoveryCoordinator = new RecoveryCoordinator();
        }
    }

    @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f15os != null) {
            this.f15os.close();
        }
    }

    void attemptRecovery() {
        try {
            close();
        } catch (IOException e) {
        }
        addStatusIfCountNotOverLimit(new InfoStatus("Attempting to recover from IO failure on " + getDescription(), this));
        try {
            this.f15os = openNewOutputStream();
            this.presumedClean = true;
        } catch (IOException e2) {
            addStatusIfCountNotOverLimit(new ErrorStatus("Failed to open " + getDescription(), this, e2));
        }
    }

    void addStatusIfCountNotOverLimit(Status s) {
        this.statusCount++;
        if (this.statusCount < 8) {
            addStatus(s);
        }
        if (this.statusCount == 8) {
            addStatus(s);
            addStatus(new InfoStatus("Will supress future messages regarding " + getDescription(), this));
        }
    }

    public void addStatus(Status status) {
        if (this.context == null) {
            int i = this.noContextWarning;
            this.noContextWarning = i + 1;
            if (i == 0) {
                System.out.println("LOGBACK: No context given for " + this);
                return;
            }
            return;
        }
        StatusManager sm = this.context.getStatusManager();
        if (sm != null) {
            sm.add(status);
        }
    }

    public Context getContext() {
        return this.context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
