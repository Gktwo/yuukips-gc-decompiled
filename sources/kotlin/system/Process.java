package kotlin.system;

import kotlin.Metadata;
import kotlin.internal.InlineOnly;
import kotlin.jvm.JvmName;

@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\u0001\n��\n\u0002\u0010\b\n��\u001a\u0011\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\b¨\u0006\u0004"}, m373d2 = {"exitProcess", "", "status", "", "kotlin-stdlib"})
@JvmName(name = "ProcessKt")
/* renamed from: kotlin.system.ProcessKt */
/* loaded from: grasscutter.jar:kotlin/system/ProcessKt.class */
public final class Process {
    @InlineOnly
    private static final Void exitProcess(int status) {
        System.exit(status);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
