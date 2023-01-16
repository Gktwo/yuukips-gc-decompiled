package kotlin.p016io;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p001ch.qos.logback.core.joran.action.Action;

/* compiled from: Exceptions.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a$\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0006"}, m373d2 = {"constructMessage", "", Action.FILE_ATTRIBUTE, "Ljava/io/File;", "other", "reason", "kotlin-stdlib"})
/* renamed from: kotlin.io.ExceptionsKt */
/* loaded from: grasscutter.jar:kotlin/io/ExceptionsKt.class */
public final class ExceptionsKt {
    /* access modifiers changed from: private */
    public static final String constructMessage(File file, File other, String reason) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (other != null) {
            sb.append(" -> " + other);
        }
        if (reason != null) {
            sb.append(": " + reason);
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}
