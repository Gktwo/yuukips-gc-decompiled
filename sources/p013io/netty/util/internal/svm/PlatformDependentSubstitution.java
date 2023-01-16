package p013io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.PlatformDependent")
/* renamed from: io.netty.util.internal.svm.PlatformDependentSubstitution */
/* loaded from: grasscutter.jar:io/netty/util/internal/svm/PlatformDependentSubstitution.class */
final class PlatformDependentSubstitution {
    @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = byte[].class)
    @Alias
    private static long BYTE_ARRAY_BASE_OFFSET;

    private PlatformDependentSubstitution() {
    }
}
