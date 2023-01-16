package okhttp3.internal.http;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import kotlin.Metadata;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

/* compiled from: dates.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0011\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001��\b\n\u0018��2\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0014¨\u0006\u0004"}, m373d2 = {"okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1", "Ljava/lang/ThreadLocal;", "Ljava/text/DateFormat;", "initialValue", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http/DatesKt$STANDARD_DATE_FORMAT$1.class */
public final class DatesKt$STANDARD_DATE_FORMAT$1 extends ThreadLocal<DateFormat> {
    /* access modifiers changed from: protected */
    @Override // java.lang.ThreadLocal
    @NotNull
    public DateFormat initialValue() {
        SimpleDateFormat $this$initialValue_u24lambda_u2d0 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
        $this$initialValue_u24lambda_u2d0.setLenient(false);
        $this$initialValue_u24lambda_u2d0.setTimeZone(Util.UTC);
        return $this$initialValue_u24lambda_u2d0;
    }
}
