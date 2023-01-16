package p014it.unimi.dsi.fastutil.objects;

import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.io.Serializable;
import java.util.Objects;
import p014it.unimi.dsi.fastutil.Pair;

/* renamed from: it.unimi.dsi.fastutil.objects.ReferenceBooleanMutablePair */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/objects/ReferenceBooleanMutablePair.class */
public class ReferenceBooleanMutablePair<K> implements ReferenceBooleanPair<K>, Serializable {
    private static final long serialVersionUID = 0;
    protected K left;
    protected boolean right;

    public ReferenceBooleanMutablePair(K left, boolean right) {
        this.left = left;
        this.right = right;
    }

    /* renamed from: of */
    public static <K> ReferenceBooleanMutablePair<K> m517of(K left, boolean right) {
        return new ReferenceBooleanMutablePair<>(left, right);
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public K left() {
        return this.left;
    }

    @Override // p014it.unimi.dsi.fastutil.Pair
    public ReferenceBooleanMutablePair<K> left(K l) {
        this.left = l;
        return this;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBooleanPair
    public boolean rightBoolean() {
        return this.right;
    }

    @Override // p014it.unimi.dsi.fastutil.objects.ReferenceBooleanPair
    public ReferenceBooleanMutablePair<K> right(boolean r) {
        this.right = r;
        return this;
    }

    @Override // java.lang.Object
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        return other instanceof ReferenceBooleanPair ? this.left == ((ReferenceBooleanPair) other).left() && this.right == ((ReferenceBooleanPair) other).rightBoolean() : (other instanceof Pair) && this.left == ((Pair) other).left() && Objects.equals(Boolean.valueOf(this.right), ((Pair) other).right());
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (System.identityHashCode(this.left) * 19) + (this.right ? RetcodeOuterClass.Retcode.RET_MP_OTHER_DATA_VERSION_NOT_LATEST_VALUE : RetcodeOuterClass.Retcode.RET_MP_MATCH_FULL_VALUE);
    }

    @Override // java.lang.Object
    public String toString() {
        return "<" + left() + "," + rightBoolean() + ">";
    }
}
