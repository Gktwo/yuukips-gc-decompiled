package p001ch.qos.logback.core;

import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.locks.ReentrantLock;
import p001ch.qos.logback.core.encoder.Encoder;
import p001ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import p001ch.qos.logback.core.spi.DeferredProcessingAware;
import p001ch.qos.logback.core.status.ErrorStatus;

/* renamed from: ch.qos.logback.core.OutputStreamAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/OutputStreamAppender.class */
public class OutputStreamAppender<E> extends UnsynchronizedAppenderBase<E> {
    protected Encoder<E> encoder;
    private OutputStream outputStream;
    protected final ReentrantLock lock = new ReentrantLock(false);
    boolean immediateFlush = true;

    public OutputStream getOutputStream() {
        return this.outputStream;
    }

    @Override // p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        int errors = 0;
        if (this.encoder == null) {
            addStatus(new ErrorStatus("No encoder set for the appender named \"" + this.name + "\".", this));
            errors = 0 + 1;
        }
        if (this.outputStream == null) {
            addStatus(new ErrorStatus("No output stream set for the appender named \"" + this.name + "\".", this));
            errors++;
        }
        if (errors == 0) {
            start();
        }
    }

    public void setLayout(Layout<E> layout) {
        addWarn("This appender no longer admits a layout as a sub-component, set an encoder instead.");
        addWarn("To ensure compatibility, wrapping your layout in LayoutWrappingEncoder.");
        addWarn("See also http://logback.qos.ch/codes.html#layoutInsteadOfEncoder for details");
        LayoutWrappingEncoder<E> lwe = new LayoutWrappingEncoder<>();
        lwe.setLayout(layout);
        lwe.setContext(this.context);
        this.encoder = lwe;
    }

    @Override // p001ch.qos.logback.core.UnsynchronizedAppenderBase
    protected void append(E eventObject) {
        if (isStarted()) {
            subAppend(eventObject);
        }
    }

    @Override // p001ch.qos.logback.core.UnsynchronizedAppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.lock.lock();
        try {
            closeOutputStream();
            stop();
        } finally {
            this.lock.unlock();
        }
    }

    protected void closeOutputStream() {
        if (this.outputStream != null) {
            try {
                encoderClose();
                this.outputStream.close();
                this.outputStream = null;
            } catch (IOException e) {
                addStatus(new ErrorStatus("Could not close output stream for OutputStreamAppender.", this, e));
            }
        }
    }

    void encoderClose() {
        if (this.encoder != null && this.outputStream != null) {
            try {
                writeBytes(this.encoder.footerBytes());
            } catch (IOException ioe) {
                this.started = false;
                addStatus(new ErrorStatus("Failed to write footer for appender named [" + this.name + "].", this, ioe));
            }
        }
    }

    public void setOutputStream(OutputStream outputStream) {
        this.lock.lock();
        try {
            closeOutputStream();
            this.outputStream = outputStream;
            if (this.encoder == null) {
                addWarn("Encoder has not been set. Cannot invoke its init method.");
            } else {
                encoderInit();
            }
        } finally {
            this.lock.unlock();
        }
    }

    void encoderInit() {
        if (this.encoder != null && this.outputStream != null) {
            try {
                writeBytes(this.encoder.headerBytes());
            } catch (IOException ioe) {
                this.started = false;
                addStatus(new ErrorStatus("Failed to initialize encoder for appender named [" + this.name + "].", this, ioe));
            }
        }
    }

    /* access modifiers changed from: protected */
    public void writeOut(E event) throws IOException {
        writeBytes(this.encoder.encode(event));
    }

    private void writeBytes(byte[] byteArray) throws IOException {
        if (byteArray != null && byteArray.length != 0) {
            this.lock.lock();
            try {
                this.outputStream.write(byteArray);
                if (this.immediateFlush) {
                    this.outputStream.flush();
                }
            } finally {
                this.lock.unlock();
            }
        }
    }

    protected void subAppend(E event) {
        if (isStarted()) {
            try {
                if (event instanceof DeferredProcessingAware) {
                    ((DeferredProcessingAware) event).prepareForDeferredProcessing();
                }
                writeBytes(this.encoder.encode(event));
            } catch (IOException ioe) {
                this.started = false;
                addStatus(new ErrorStatus("IO failure in appender", this, ioe));
            }
        }
    }

    public Encoder<E> getEncoder() {
        return this.encoder;
    }

    public void setEncoder(Encoder<E> encoder) {
        this.encoder = encoder;
    }

    public boolean isImmediateFlush() {
        return this.immediateFlush;
    }

    public void setImmediateFlush(boolean immediateFlush) {
        this.immediateFlush = immediateFlush;
    }
}
