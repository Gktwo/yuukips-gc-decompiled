package p013io.netty.handler.codec.serialization;

/* renamed from: io.netty.handler.codec.serialization.ClassResolver */
/* loaded from: grasscutter.jar:io/netty/handler/codec/serialization/ClassResolver.class */
public interface ClassResolver {
    Class<?> resolve(String str) throws ClassNotFoundException;
}
