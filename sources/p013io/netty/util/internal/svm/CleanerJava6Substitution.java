package p013io.netty.util.internal.svm;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.CleanerJava6")
/* renamed from: io.netty.util.internal.svm.CleanerJava6Substitution */
/* loaded from: grasscutter.jar:io/netty/util/internal/svm/CleanerJava6Substitution.class */
final class CleanerJava6Substitution {
    @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClassName = "java.nio.DirectByteBuffer", name = "cleaner")
    @Alias
    private static long CLEANER_FIELD_OFFSET;

    private CleanerJava6Substitution() {
    }
}
