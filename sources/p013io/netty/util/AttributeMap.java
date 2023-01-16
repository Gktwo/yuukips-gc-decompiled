package p013io.netty.util;

/* renamed from: io.netty.util.AttributeMap */
/* loaded from: grasscutter.jar:io/netty/util/AttributeMap.class */
public interface AttributeMap {
    <T> Attribute<T> attr(AttributeKey<T> attributeKey);

    <T> boolean hasAttr(AttributeKey<T> attributeKey);
}
