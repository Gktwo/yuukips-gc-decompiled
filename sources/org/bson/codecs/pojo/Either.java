package org.bson.codecs.pojo;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import org.bson.assertions.Assertions;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:org/bson/codecs/pojo/Either.class */
public final class Either<L, R> {
    private final L left;
    private final R right;

    public static <L, R> Either<L, R> left(L value) {
        return new Either<>(Assertions.notNull("value", value), null);
    }

    public static <L, R> Either<L, R> right(R value) {
        return new Either<>(null, Assertions.notNull("value", value));
    }

    private Either(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: R, ? super R */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: L, ? super L */
    public <T> T map(Function<? super L, ? extends T> lFunc, Function<? super R, ? extends T> rFunc) {
        return this.left != null ? (T) lFunc.apply((L) this.left) : (T) rFunc.apply((R) this.right);
    }

    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: R, ? super R */
    /* JADX DEBUG: Type inference failed for r1v3. Raw type applied. Possible types: L, ? super L */
    public void apply(Consumer<? super L> lFunc, Consumer<? super R> rFunc) {
        if (this.left != null) {
            lFunc.accept((L) this.left);
        }
        if (this.right != null) {
            rFunc.accept((R) this.right);
        }
    }

    public String toString() {
        return "Either{left=" + this.left + ", right=" + this.right + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Either<?, ?> either = (Either) o;
        return Objects.equals(this.left, either.left) && Objects.equals(this.right, either.right);
    }

    public int hashCode() {
        return Objects.hash(this.left, this.right);
    }
}
