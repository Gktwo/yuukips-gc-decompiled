package kotlin.math;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;

/* compiled from: MathJVM.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\bÂ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048��X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u00020\u00048��X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0006\u001a\u00020\u00048��X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0007\u001a\u00020\u00048��X\u0004¢\u0006\u0002\n��R\u0010\u0010\b\u001a\u00020\u00048��X\u0004¢\u0006\u0002\n��R\u0010\u0010\t\u001a\u00020\u00048��X\u0004¢\u0006\u0002\n��¨\u0006\n"}, m373d2 = {"Lkotlin/math/Constants;", "", "()V", "LN2", "", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/math/Constants.class */
final class Constants {
    @NotNull
    public static final Constants INSTANCE = new Constants();
    @JvmField
    public static final double LN2 = Math.log(2.0d);
    @JvmField
    public static final double epsilon = Math.ulp(1.0d);
    @JvmField
    public static final double taylor_2_bound = Math.sqrt(epsilon);
    @JvmField
    public static final double taylor_n_bound = Math.sqrt(taylor_2_bound);
    @JvmField
    public static final double upper_taylor_2_bound = ((double) 1) / taylor_2_bound;
    @JvmField
    public static final double upper_taylor_n_bound = ((double) 1) / taylor_n_bound;

    private Constants() {
    }
}
