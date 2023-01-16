package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import java.io.Serializable;

@Beta
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/FunctionalEquivalence.class */
final class FunctionalEquivalence<F, T> extends Equivalence<F> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Function<F, ? extends T> function;
    private final Equivalence<T> resultEquivalence;

    /* access modifiers changed from: package-private */
    public FunctionalEquivalence(Function<F, ? extends T> function, Equivalence<T> resultEquivalence) {
        this.function = (Function) Preconditions.checkNotNull(function);
        this.resultEquivalence = (Equivalence) Preconditions.checkNotNull(resultEquivalence);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.base.Equivalence<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Equivalence
    protected boolean doEquivalent(F a, F b) {
        return this.resultEquivalence.equivalent(this.function.apply(a), this.function.apply(b));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: com.google.common.base.Equivalence<T> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Equivalence
    protected int doHash(F a) {
        return this.resultEquivalence.hash(this.function.apply(a));
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof FunctionalEquivalence)) {
            return false;
        }
        FunctionalEquivalence<?, ?> that = (FunctionalEquivalence) obj;
        return this.function.equals(that.function) && this.resultEquivalence.equals(that.resultEquivalence);
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(this.function, this.resultEquivalence);
    }

    @Override // java.lang.Object
    public String toString() {
        return this.resultEquivalence + ".onResultOf(" + this.function + ")";
    }
}
