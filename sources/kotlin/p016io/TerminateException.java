package kotlin.p016io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: Utils.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m373d2 = {"Lkotlin/io/TerminateException;", "Lkotlin/io/FileSystemException;", Action.FILE_ATTRIBUTE, "Ljava/io/File;", "(Ljava/io/File;)V", "kotlin-stdlib"})
/* renamed from: kotlin.io.TerminateException */
/* loaded from: grasscutter.jar:kotlin/io/TerminateException.class */
public final class TerminateException extends FileSystemException {
    /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
    public TerminateException(@NotNull File file) {
        super(file, null, null, 6, null);
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
    }
}
