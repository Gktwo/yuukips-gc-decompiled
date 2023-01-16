package p001ch.qos.logback.core;

import p001ch.qos.logback.core.spi.ContextAwareBase;
import p013io.javalin.http.ContentType;

/* renamed from: ch.qos.logback.core.LayoutBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/LayoutBase.class */
public abstract class LayoutBase<E> extends ContextAwareBase implements Layout<E> {
    protected boolean started;
    String fileHeader;
    String fileFooter;
    String presentationHeader;
    String presentationFooter;

    @Override // p001ch.qos.logback.core.spi.ContextAwareBase, p001ch.qos.logback.core.spi.ContextAware
    public void setContext(Context context) {
        this.context = context;
    }

    @Override // p001ch.qos.logback.core.spi.ContextAwareBase, p001ch.qos.logback.core.spi.ContextAware
    public Context getContext() {
        return this.context;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.started = true;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.started = false;
    }

    @Override // p001ch.qos.logback.core.spi.LifeCycle
    public boolean isStarted() {
        return this.started;
    }

    @Override // p001ch.qos.logback.core.Layout
    public String getFileHeader() {
        return this.fileHeader;
    }

    @Override // p001ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        return this.presentationHeader;
    }

    @Override // p001ch.qos.logback.core.Layout
    public String getPresentationFooter() {
        return this.presentationFooter;
    }

    @Override // p001ch.qos.logback.core.Layout
    public String getFileFooter() {
        return this.fileFooter;
    }

    @Override // p001ch.qos.logback.core.Layout
    public String getContentType() {
        return ContentType.PLAIN;
    }

    public void setFileHeader(String header) {
        this.fileHeader = header;
    }

    public void setFileFooter(String footer) {
        this.fileFooter = footer;
    }

    public void setPresentationHeader(String header) {
        this.presentationHeader = header;
    }

    public void setPresentationFooter(String footer) {
        this.presentationFooter = footer;
    }
}
