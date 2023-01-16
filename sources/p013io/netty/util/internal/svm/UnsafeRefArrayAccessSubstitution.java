package p013io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.shaded.org.jctools.util.UnsafeRefArrayAccess")
/* renamed from: io.netty.util.internal.svm.UnsafeRefArrayAccessSubstitution */
/* loaded from: grasscutter.jar:io/netty/util/internal/svm/UnsafeRefArrayAccessSubstitution.class */
final class UnsafeRefArrayAccessSubstitution {
    @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexShift, declClass = Object[].class)
    @Alias
    public static int REF_ELEMENT_SHIFT;

    private UnsafeRefArrayAccessSubstitution() {
    }
}
