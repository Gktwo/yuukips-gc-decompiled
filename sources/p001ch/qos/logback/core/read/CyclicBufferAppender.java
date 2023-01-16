package p001ch.qos.logback.core.read;

import p001ch.qos.logback.core.AppenderBase;
import p001ch.qos.logback.core.helpers.CyclicBuffer;

/* renamed from: ch.qos.logback.core.read.CyclicBufferAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/core/read/CyclicBufferAppender.class */
public class CyclicBufferAppender<E> extends AppenderBase<E> {

    /* renamed from: cb */
    CyclicBuffer<E> f14cb;
    int maxSize = 512;

    @Override // p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        this.f14cb = new CyclicBuffer<>(this.maxSize);
        start();
    }

    @Override // p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void stop() {
        this.f14cb = null;
        stop();
    }

    @Override // p001ch.qos.logback.core.AppenderBase
    protected void append(E eventObject) {
        if (isStarted()) {
            this.f14cb.add(eventObject);
        }
    }

    public int getLength() {
        if (isStarted()) {
            return this.f14cb.length();
        }
        return 0;
    }

    public E get(int i) {
        if (isStarted()) {
            return this.f14cb.get(i);
        }
        return null;
    }

    public void reset() {
        this.f14cb.clear();
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
}
