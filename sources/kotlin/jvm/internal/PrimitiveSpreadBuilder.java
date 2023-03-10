package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n��\n\u0002\u0010��\n��\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018��*\b\b��\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028��¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028��2\u0006\u0010\u0014\u001a\u00028��2\u0006\u0010\u0015\u001a\u00028��H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028��H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018��0\u000bX\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, m373d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/jvm/internal/PrimitiveSpreadBuilder.class */
public abstract class PrimitiveSpreadBuilder<T> {
    private final int size;
    private int position;
    @NotNull
    private final T[] spreads;

    protected abstract int getSize(@NotNull T t);

    private static /* synthetic */ void getSpreads$annotations() {
    }

    public PrimitiveSpreadBuilder(int size) {
        this.size = size;
        this.spreads = (T[]) new Object[this.size];
    }

    protected final int getPosition() {
        return this.position;
    }

    protected final void setPosition(int i) {
        this.position = i;
    }

    public final void addSpread(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "spreadArgument");
        T[] tArr = this.spreads;
        int i = this.position;
        this.position = i + 1;
        tArr[i] = t;
    }

    protected final int size() {
        int totalLength = 0;
        int i = 0;
        int i2 = this.size - 1;
        if (0 <= i2) {
            while (true) {
                T t = this.spreads[i];
                totalLength += t != null ? getSize(t) : 1;
                if (i == i2) {
                    break;
                }
                i++;
            }
        }
        return totalLength;
    }

    @NotNull
    protected final T toArray(@NotNull T t, @NotNull T t2) {
        Intrinsics.checkNotNullParameter(t, "values");
        Intrinsics.checkNotNullParameter(t2, "result");
        int dstIndex = 0;
        int copyValuesFrom = 0;
        int i = 0;
        int i2 = this.size - 1;
        if (0 <= i2) {
            while (true) {
                T t3 = this.spreads[i];
                if (t3 != null) {
                    if (copyValuesFrom < i) {
                        System.arraycopy(t, copyValuesFrom, t2, dstIndex, i - copyValuesFrom);
                        dstIndex += i - copyValuesFrom;
                    }
                    int spreadSize = getSize(t3);
                    System.arraycopy(t3, 0, t2, dstIndex, spreadSize);
                    dstIndex += spreadSize;
                    copyValuesFrom = i + 1;
                }
                if (i == i2) {
                    break;
                }
                i++;
            }
        }
        if (copyValuesFrom < this.size) {
            System.arraycopy(t, copyValuesFrom, t2, dstIndex, this.size - copyValuesFrom);
        }
        return t2;
    }
}
