package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceObjectPair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceObjectPair.class */
public interface ReferenceObjectPair<K, V> extends Pair<K, V> {
    /* renamed from: of */
    static <K, V> ReferenceObjectPair<K, V> m483of(K left, V right) {
        return new ReferenceObjectImmutablePair(left, right);
    }
}
