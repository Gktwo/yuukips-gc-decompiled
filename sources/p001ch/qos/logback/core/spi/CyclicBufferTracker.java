package p001ch.qos.logback.core.spi;

import java.util.ArrayList;
import java.util.List;
import p001ch.qos.logback.core.helpers.CyclicBuffer;

/* renamed from: ch.qos.logback.core.spi.CyclicBufferTracker */
/* loaded from: grasscutter.jar:ch/qos/logback/core/spi/CyclicBufferTracker.class */
public class CyclicBufferTracker<E> extends AbstractComponentTracker<CyclicBuffer<E>> {
    static final int DEFAULT_NUMBER_OF_BUFFERS = 64;
    static final int DEFAULT_BUFFER_SIZE = 256;
    int bufferSize = 256;

    @Override // p001ch.qos.logback.core.spi.AbstractComponentTracker
    protected /* bridge */ /* synthetic */ boolean isComponentStale(Object obj) {
        return isComponentStale((CyclicBuffer) ((CyclicBuffer) obj));
    }

    @Override // p001ch.qos.logback.core.spi.AbstractComponentTracker
    protected /* bridge */ /* synthetic */ void processPriorToRemoval(Object obj) {
        processPriorToRemoval((CyclicBuffer) ((CyclicBuffer) obj));
    }

    public CyclicBufferTracker() {
        setMaxComponents(64);
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBufferSize(int bufferSize) {
        this.bufferSize = bufferSize;
    }

    protected void processPriorToRemoval(CyclicBuffer<E> component) {
        component.clear();
    }

    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.spi.AbstractComponentTracker
    public CyclicBuffer<E> buildComponent(String key) {
        return new CyclicBuffer<>(this.bufferSize);
    }

    protected boolean isComponentStale(CyclicBuffer<E> eCyclicBuffer) {
        return false;
    }

    List<String> liveKeysAsOrderedList() {
        return new ArrayList(this.liveMap.keySet());
    }

    List<String> lingererKeysAsOrderedList() {
        return new ArrayList(this.lingerersMap.keySet());
    }
}
