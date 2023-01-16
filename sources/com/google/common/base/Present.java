package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import java.util.Collections;
import java.util.Set;

/* access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: grasscutter.jar:com/google/common/base/Present.class */
public final class Present<T> extends Optional<T> {
    private final T reference;
    private static final long serialVersionUID = 0;

    /* access modifiers changed from: package-private */
    public Present(T reference) {
        this.reference = reference;
    }

    @Override // com.google.common.base.Optional
    public boolean isPresent() {
        return true;
    }

    @Override // com.google.common.base.Optional
    public T get() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public T mo1456or(T defaultValue) {
        Preconditions.checkNotNull(defaultValue, "use Optional.orNull() instead of Optional.or(null)");
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public Optional<T> mo1458or(Optional<? extends T> secondChoice) {
        Preconditions.checkNotNull(secondChoice);
        return this;
    }

    @Override // com.google.common.base.Optional
    /* renamed from: or */
    public T mo1457or(Supplier<? extends T> supplier) {
        Preconditions.checkNotNull(supplier);
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public T orNull() {
        return this.reference;
    }

    @Override // com.google.common.base.Optional
    public Set<T> asSet() {
        return Collections.singleton(this.reference);
    }

    /* JADX DEBUG: Type inference failed for r3v1. Raw type applied. Possible types: T, ? super T */
    @Override // com.google.common.base.Optional
    public <V> Optional<V> transform(Function<? super T, V> function) {
        return new Present(Preconditions.checkNotNull(function.apply((T) this.reference), "the Function passed to Optional.transform() must not return null."));
    }

    @Override // com.google.common.base.Optional, java.lang.Object
    public boolean equals(Object object) {
        if (object instanceof Present) {
            return this.reference.equals(((Present) object).reference);
        }
        return false;
    }

    @Override // com.google.common.base.Optional, java.lang.Object
    public int hashCode() {
        return 1502476572 + this.reference.hashCode();
    }

    @Override // com.google.common.base.Optional, java.lang.Object
    public String toString() {
        return "Optional.of(" + this.reference + ")";
    }
}
