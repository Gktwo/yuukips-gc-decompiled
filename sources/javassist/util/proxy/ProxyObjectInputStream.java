package javassist.util.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;

/* loaded from: grasscutter.jar:javassist/util/proxy/ProxyObjectInputStream.class */
public class ProxyObjectInputStream extends ObjectInputStream {
    private ClassLoader loader;

    public ProxyObjectInputStream(InputStream in) throws IOException {
        super(in);
        this.loader = Thread.currentThread().getContextClassLoader();
        if (this.loader == null) {
            this.loader = ClassLoader.getSystemClassLoader();
        }
    }

    public void setClassLoader(ClassLoader loader) {
        if (loader != null) {
            this.loader = loader;
        } else {
            ClassLoader.getSystemClassLoader();
        }
    }

    @Override // java.io.ObjectInputStream
    protected ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
        if (!readBoolean()) {
            return readClassDescriptor();
        }
        Class<?> superClass = this.loader.loadClass((String) readObject());
        int length = readInt();
        Class<?>[] interfaces = new Class[length];
        for (int i = 0; i < length; i++) {
            interfaces[i] = this.loader.loadClass((String) readObject());
        }
        byte[] signature = new byte[readInt()];
        read(signature);
        ProxyFactory factory = new ProxyFactory();
        factory.setUseCache(true);
        factory.setUseWriteReplace(false);
        factory.setSuperclass(superClass);
        factory.setInterfaces(interfaces);
        return ObjectStreamClass.lookup(factory.createClass(signature));
    }
}
