package p014it.unimi.dsi.fastutil.objects;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ObjectBooleanImmutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ObjectBooleanImmutablePair.class */
public class ObjectBooleanImmutablePair<K> implements ObjectBooleanPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected final K left;
    protected final boolean right;

    public ObjectBooleanImmutablePair(K left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ObjectBooleanImmutablePair<K> m578of(K left, boolean right) {
        return new ObjectBooleanImmutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ObjectBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ObjectBooleanPair ? Objects.equals(this.left, ((ObjectBooleanPair) other).left()) && this.right == ((ObjectBooleanPair) other).rightBoolean() : (other instanceof Pair) && Objects.equals(this.left, ((Pair) other).left()) && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.left == null ? 0 : this.left.hashCode()) * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightBoolean() + ">";
    }
}
