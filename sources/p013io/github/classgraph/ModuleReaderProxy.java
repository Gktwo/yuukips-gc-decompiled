package p013io.github.classgraph;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: io.github.classgraph.ModuleReaderProxy */
/* loaded from: grasscutter.jar:io/github/classgraph/ModuleReaderProxy.class */
public class ModuleReaderProxy implements Closeable {
    private final AutoCloseable moduleReader;
    private static Class<?> collectorClass = ReflectionUtils.classForNameOrNull("java.util.stream.Collector");
    private static Object collectorsToList;

    static {
        Class<?> collectorsClass = ReflectionUtils.classForNameOrNull("java.util.stream.Collectors");
        if (collectorsClass != null) {
            collectorsToList = ReflectionUtils.invokeStaticMethod(collectorsClass, "toList", true);
        }
    }

    /* access modifiers changed from: package-private */
    public ModuleReaderProxy(ModuleRef moduleRef) throws IOException {
        try {
            this.moduleReader = (AutoCloseable) ReflectionUtils.invokeMethod(moduleRef.getReference(), "open", true);
            if (this.moduleReader == null) {
                throw new IllegalArgumentException("moduleReference.open() should not return null");
            }
        } catch (SecurityException e) {
            throw new IOException("Could not open module " + moduleRef.getName(), e);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            this.moduleReader.close();
        } catch (Exception e) {
        }
    }

    public List<String> list() throws SecurityException {
        if (collectorsToList == null) {
            throw new IllegalArgumentException("Could not call Collectors.toList()");
        }
        Object resourcesStream = ReflectionUtils.invokeMethod(this.moduleReader, "list", true);
        if (resourcesStream == null) {
            throw new IllegalArgumentException("Could not call moduleReader.list()");
        }
        Object resourcesList = ReflectionUtils.invokeMethod(resourcesStream, "collect", collectorClass, collectorsToList, true);
        if (resourcesList != null) {
            return (List) resourcesList;
        }
        throw new IllegalArgumentException("Could not call moduleReader.list().collect(Collectors.toList())");
    }

    private Object openOrRead(String path, boolean open) throws SecurityException {
        String methodName = open ? "open" : "read";
        Object optionalInputStream = ReflectionUtils.invokeMethod(this.moduleReader, methodName, String.class, path, true);
        if (optionalInputStream == null) {
            throw new IllegalArgumentException("Got null result from moduleReader." + methodName + "(name)");
        }
        Object inputStream = ReflectionUtils.invokeMethod(optionalInputStream, BeanUtil.PREFIX_GETTER_GET, true);
        if (inputStream != null) {
            return inputStream;
        }
        throw new IllegalArgumentException("Got null result from moduleReader." + methodName + "(name).get()");
    }

    public InputStream open(String path) throws SecurityException {
        return (InputStream) openOrRead(path, true);
    }

    public ByteBuffer read(String path) throws SecurityException, OutOfMemoryError {
        return (ByteBuffer) openOrRead(path, false);
    }

    public void release(ByteBuffer byteBuffer) {
        ReflectionUtils.invokeMethod(this.moduleReader, "release", ByteBuffer.class, byteBuffer, true);
    }
}
