package javassist.util.proxy;

/* loaded from: grasscutter.jar:javassist/util/proxy/ProxyObject.class */
public interface ProxyObject extends Proxy {
    @Override // javassist.util.proxy.Proxy
    void setHandler(MethodHandler methodHandler);

    MethodHandler getHandler();
}
