package p013io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.PlatformDependent0")
/* renamed from: io.netty.util.internal.svm.PlatformDependent0Substitution */
/* loaded from: grasscutter.jar:io/netty/util/internal/svm/PlatformDependent0Substitution.class */
final class PlatformDependent0Substitution {
    @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClassName = "java.nio.Buffer", name = "address")
    @Alias
    private static long ADDRESS_FIELD_OFFSET;

    private PlatformDependent0Substitution() {
    }
}
