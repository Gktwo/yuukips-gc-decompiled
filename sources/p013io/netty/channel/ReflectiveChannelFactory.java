package p013io.netty.channel;

import java.lang.reflect.Constructor;
import p013io.netty.channel.Channel;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.StringUtil;

/* renamed from: io.netty.channel.ReflectiveChannelFactory */
/* loaded from: grasscutter.jar:io/netty/channel/ReflectiveChannelFactory.class */
public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Constructor<? extends T> constructor;

    public ReflectiveChannelFactory(Class<? extends T> clazz) {
        ObjectUtil.checkNotNull(clazz, "clazz");
        try {
            this.constructor = clazz.getConstructor(new Class[0]);
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + StringUtil.simpleClassName((Class<?>) clazz) + " does not have a public non-arg constructor", e);
        }
    }

    @Override // p013io.netty.channel.ChannelFactory, p013io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        try {
            return (T) ((Channel) this.constructor.newInstance(new Object[0]));
        } catch (Throwable t) {
            throw new ChannelException("Unable to create Channel from class " + this.constructor.getDeclaringClass(), t);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) ReflectiveChannelFactory.class) + '(' + StringUtil.simpleClassName((Class<?>) this.constructor.getDeclaringClass()) + ".class)";
    }
}
