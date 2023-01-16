package p013io.netty.buffer.search;

/* renamed from: io.netty.buffer.search.AbstractMultiSearchProcessorFactory */
/* loaded from: grasscutter.jar:io/netty/buffer/search/AbstractMultiSearchProcessorFactory.class */
public abstract class AbstractMultiSearchProcessorFactory implements MultiSearchProcessorFactory {
    public static AhoCorasicSearchProcessorFactory newAhoCorasicSearchProcessorFactory(byte[]... needles) {
        return new AhoCorasicSearchProcessorFactory(needles);
    }
}
