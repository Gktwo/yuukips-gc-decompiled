package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectReferencePair.class */
public interface ObjectReferencePair<K, V> extends Pair<K, V> {
    /* renamed from: of */
    static <K, V> ObjectReferencePair<K, V> m534of(K left, V right) {
        return new ObjectReferenceImmutablePair(left, right);
    }
}
