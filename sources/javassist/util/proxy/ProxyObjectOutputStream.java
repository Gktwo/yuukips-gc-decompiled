package javassist.util.proxy;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
import java.io.OutputStream;

/* loaded from: grasscutter.jar:javassist/util/proxy/ProxyObjectOutputStream.class */
public class ProxyObjectOutputStream extends ObjectOutputStream {
    public ProxyObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }

    @Override // java.io.ObjectOutputStream
    protected void writeClassDescriptor(ObjectStreamClass desc) throws IOException {
        Class<?> cl = desc.forClass();
        if (ProxyFactory.isProxyClass(cl)) {
            writeBoolean(true);
            Class<?> superClass = cl.getSuperclass();
            Class<?>[] interfaces = cl.getInterfaces();
            byte[] signature = ProxyFactory.getFilterSignature(cl);
            writeObject(superClass.getName());
            writeInt(interfaces.length - 1);
            for (int i = 0; i < interfaces.length; i++) {
                Class<?> interfaze = interfaces[i];
                if (!(interfaze == ProxyObject.class || interfaze == Proxy.class)) {
                    writeObject(interfaces[i].getName());
                }
            }
            writeInt(signature.length);
            write(signature);
            return;
        }
        writeBoolean(false);
        writeClassDescriptor(desc);
    }
}
