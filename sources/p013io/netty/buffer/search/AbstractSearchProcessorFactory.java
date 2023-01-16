package p013io.netty.buffer.search;

/* renamed from: io.netty.buffer.search.AbstractSearchProcessorFactory */
/* loaded from: grasscutter.jar:io/netty/buffer/search/AbstractSearchProcessorFactory.class */
public abstract class AbstractSearchProcessorFactory implements SearchProcessorFactory {
    public static KmpSearchProcessorFactory newKmpSearchProcessorFactory(byte[] needle) {
        return new KmpSearchProcessorFactory(needle);
    }

    public static BitapSearchProcessorFactory newBitapSearchProcessorFactory(byte[] needle) {
        return new BitapSearchProcessorFactory(needle);
    }
}
