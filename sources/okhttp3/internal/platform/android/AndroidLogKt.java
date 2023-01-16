package okhttp3.internal.platform.android;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import kotlin.Metadata;

/* compiled from: AndroidLog.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010��\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, m373d2 = {"androidLevel", "", "Ljava/util/logging/LogRecord;", "getAndroidLevel", "(Ljava/util/logging/LogRecord;)I", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/platform/android/AndroidLogKt.class */
public final class AndroidLogKt {
    public static final int getAndroidLevel(LogRecord $this$androidLevel) {
        if ($this$androidLevel.getLevel().intValue() > Level.INFO.intValue()) {
            return 5;
        }
        return $this$androidLevel.getLevel().intValue() == Level.INFO.intValue() ? 4 : 3;
    }
}
