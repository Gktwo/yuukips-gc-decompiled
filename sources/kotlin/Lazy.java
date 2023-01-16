package kotlin;

/* compiled from: Lazy.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n\u0002\b\u0004\n\u0002\u0010\u000b\n��\bf\u0018��*\u0006\b��\u0010\u0001 \u00012\u00020\u0002J\b\u0010\u0006\u001a\u00020\u0007H&R\u0012\u0010\u0003\u001a\u00028��X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\b"}, m373d2 = {"Lkotlin/Lazy;", "T", "", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/Lazy.class */
public interface Lazy<T> {
    T getValue();

    boolean isInitialized();
}
