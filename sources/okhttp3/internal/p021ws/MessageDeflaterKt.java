package okhttp3.internal.p021ws;

import kotlin.Metadata;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;

/* compiled from: MessageDeflater.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u000e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\"\u000e\u0010��\u001a\u00020\u0001X\u0004¢\u0006\u0002\n��\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n��¨\u0006\u0004"}, m373d2 = {"EMPTY_DEFLATE_BLOCK", "Lokio/ByteString;", "LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION", "", "okhttp"})
/* renamed from: okhttp3.internal.ws.MessageDeflaterKt */
/* loaded from: grasscutter.jar:okhttp3/internal/ws/MessageDeflaterKt.class */
public final class MessageDeflaterKt {
    @NotNull
    private static final ByteString EMPTY_DEFLATE_BLOCK = ByteString.Companion.decodeHex("000000ffff");
    private static final int LAST_OCTETS_COUNT_TO_REMOVE_AFTER_DEFLATION = 4;
}
