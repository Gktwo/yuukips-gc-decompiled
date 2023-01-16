package p014it.unimi.dsi.fastutil.objects;

import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceReferencePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceReferencePair.class */
public interface ReferenceReferencePair<K, V> extends Pair<K, V> {
    /* renamed from: of */
    static <K, V> ReferenceReferencePair<K, V> m475of(K left, V right) {
        return new ReferenceReferenceImmutablePair(left, right);
    }
}
