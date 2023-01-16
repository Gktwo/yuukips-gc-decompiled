package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: PrimitiveSpreadBuilders.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n��\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n��\n\u0002\u0010\u0006\n\u0002\b\u0003\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\u0002J\f\u0010\f\u001a\u00020\u0004*\u00020\u0002H\u0014R\u000e\u0010\u0006\u001a\u00020\u0002X\u0004¢\u0006\u0002\n��¨\u0006\r"}, m373d2 = {"Lkotlin/jvm/internal/DoubleSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", BeanUtil.PREFIX_ADDER, "", "value", "", "toArray", "getSize", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/jvm/internal/DoubleSpreadBuilder.class */
public final class DoubleSpreadBuilder extends PrimitiveSpreadBuilder<double[]> {
    @NotNull
    private final double[] values;

    public DoubleSpreadBuilder(int size) {
        super(size);
        this.values = new double[size];
    }

    /* access modifiers changed from: protected */
    public int getSize(@NotNull double[] $this$getSize) {
        Intrinsics.checkNotNullParameter($this$getSize, "<this>");
        return $this$getSize.length;
    }

    public final void add(double value) {
        double[] dArr = this.values;
        int position = getPosition();
        setPosition(position + 1);
        dArr[position] = value;
    }

    @NotNull
    public final double[] toArray() {
        return toArray(this.values, new double[size()]);
    }
}
