package okhttp3.internal.http2;

import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.internal.Util;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.quartz.impl.jdbcjobstore.Constants;

/* compiled from: Http2.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��0\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bJ\u0015\u0010\"\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u000bH��¢\u0006\u0002\b#J.\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\u0002\n��R\u0018\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\n\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\f\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\r\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u000e\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u000f\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0010\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0011\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0012\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\u0014\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0015\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0016\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0017\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0018\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u0019\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u001a\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u001b\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u001c\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u001d\u001a\u00020\u000bXT¢\u0006\u0002\n��R\u000e\u0010\u001e\u001a\u00020\u000bXT¢\u0006\u0002\n��¨\u0006)"}, m373d2 = {"Lokhttp3/internal/http2/Http2;", "", "()V", "BINARY", "", "", "[Ljava/lang/String;", "CONNECTION_PREFACE", "Lokio/ByteString;", "FLAGS", "FLAG_ACK", "", "FLAG_COMPRESSED", "FLAG_END_HEADERS", "FLAG_END_PUSH_PROMISE", "FLAG_END_STREAM", "FLAG_NONE", "FLAG_PADDED", "FLAG_PRIORITY", "FRAME_NAMES", "INITIAL_MAX_FRAME_SIZE", "TYPE_CONTINUATION", "TYPE_DATA", "TYPE_GOAWAY", "TYPE_HEADERS", "TYPE_PING", "TYPE_PRIORITY", "TYPE_PUSH_PROMISE", "TYPE_RST_STREAM", "TYPE_SETTINGS", "TYPE_WINDOW_UPDATE", "formatFlags", "type", "flags", "formattedType", "formattedType$okhttp", "frameLog", "inbound", "", "streamId", "length", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/http2/Http2.class */
public final class Http2 {
    public static final int INITIAL_MAX_FRAME_SIZE = 16384;
    public static final int TYPE_DATA = 0;
    public static final int TYPE_HEADERS = 1;
    public static final int TYPE_PRIORITY = 2;
    public static final int TYPE_RST_STREAM = 3;
    public static final int TYPE_SETTINGS = 4;
    public static final int TYPE_PUSH_PROMISE = 5;
    public static final int TYPE_PING = 6;
    public static final int TYPE_GOAWAY = 7;
    public static final int TYPE_WINDOW_UPDATE = 8;
    public static final int TYPE_CONTINUATION = 9;
    public static final int FLAG_NONE = 0;
    public static final int FLAG_ACK = 1;
    public static final int FLAG_END_STREAM = 1;
    public static final int FLAG_END_HEADERS = 4;
    public static final int FLAG_END_PUSH_PROMISE = 4;
    public static final int FLAG_PADDED = 8;
    public static final int FLAG_PRIORITY = 32;
    public static final int FLAG_COMPRESSED = 32;
    @NotNull
    private static final String[] BINARY;
    @NotNull
    public static final Http2 INSTANCE = new Http2();
    @JvmField
    @NotNull
    public static final ByteString CONNECTION_PREFACE = ByteString.Companion.encodeUtf8("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
    @NotNull
    private static final String[] FRAME_NAMES = {"DATA", "HEADERS", Constants.COL_PRIORITY, "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
    @NotNull
    private static final String[] FLAGS = new String[64];

    private Http2() {
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x0153: AGET  (r3v3 java.lang.String A[REMOVE]) = 
      (wrap: java.lang.String[] : 0x014e: SGET  (r3v2 java.lang.String[] A[REMOVE]) =  okhttp3.internal.http2.Http2.FLAGS java.lang.String[])
      (r0v62 'prefixFlag' int A[D('prefixFlag' int)])
    )), ('|' char), (wrap: java.lang.Object : ?: CAST (java.lang.Object) (wrap: java.lang.String : 0x0161: AGET  (r3v6 java.lang.String A[REMOVE]) = 
      (wrap: java.lang.String[] : 0x015c: SGET  (r3v5 java.lang.String[] A[REMOVE]) =  okhttp3.internal.http2.Http2.FLAGS java.lang.String[])
      (r0v56 'frameFlag' int A[D('frameFlag' int)])
    ))] */
    static {
        String[] strArr = new String[256];
        for (int i = 0; i < 256; i++) {
            String binaryString = Integer.toBinaryString(i);
            Intrinsics.checkNotNullExpressionValue(binaryString, "toBinaryString(it)");
            strArr[i] = StringsKt.replace$default(Util.format("%8s", binaryString), ' ', '0', false, 4, (Object) null);
        }
        BINARY = strArr;
        FLAGS[0] = "";
        FLAGS[1] = "END_STREAM";
        int[] prefixFlags = {1};
        FLAGS[8] = "PADDED";
        int i2 = 0;
        int length = prefixFlags.length;
        while (i2 < length) {
            int prefixFlag = prefixFlags[i2];
            i2++;
            FLAGS[prefixFlag | 8] = Intrinsics.stringPlus(FLAGS[prefixFlag], "|PADDED");
        }
        FLAGS[4] = "END_HEADERS";
        FLAGS[32] = Constants.COL_PRIORITY;
        FLAGS[36] = "END_HEADERS|PRIORITY";
        int[] frameFlags = {4, 32, 36};
        int i3 = 0;
        int length2 = frameFlags.length;
        while (i3 < length2) {
            int frameFlag = frameFlags[i3];
            i3++;
            int i4 = 0;
            int length3 = prefixFlags.length;
            while (i4 < length3) {
                int prefixFlag2 = prefixFlags[i4];
                i4++;
                FLAGS[prefixFlag2 | frameFlag] = new StringBuilder().append((Object) FLAGS[prefixFlag2]).append('|').append((Object) FLAGS[frameFlag]).toString();
                FLAGS[prefixFlag2 | frameFlag | 8] = ((Object) FLAGS[prefixFlag2]) + '|' + ((Object) FLAGS[frameFlag]) + "|PADDED";
            }
        }
        int i5 = 0;
        int length4 = FLAGS.length;
        while (i5 < length4) {
            i5++;
            if (FLAGS[i5] == null) {
                FLAGS[i5] = BINARY[i5];
            }
        }
    }

    @NotNull
    public final String frameLog(boolean inbound, int streamId, int length, int type, int flags) {
        return Util.format("%s 0x%08x %5d %-13s %s", inbound ? "<<" : ">>", Integer.valueOf(streamId), Integer.valueOf(length), formattedType$okhttp(type), formatFlags(type, flags));
    }

    @NotNull
    public final String formattedType$okhttp(int type) {
        return type < FRAME_NAMES.length ? FRAME_NAMES[type] : Util.format("0x%02x", Integer.valueOf(type));
    }

    @NotNull
    public final String formatFlags(int type, int flags) {
        String result;
        if (flags == 0) {
            return "";
        }
        switch (type) {
            case 2:
            case 3:
            case 7:
            case 8:
                return BINARY[flags];
            case 4:
            case 6:
                return flags == 1 ? "ACK" : BINARY[flags];
            case 5:
            default:
                if (flags < FLAGS.length) {
                    result = FLAGS[flags];
                    Intrinsics.checkNotNull(result);
                } else {
                    result = BINARY[flags];
                }
                if (type == 5 && (flags & 4) != 0) {
                    return StringsKt.replace$default(result, "HEADERS", "PUSH_PROMISE", false, 4, (Object) null);
                }
                if (type != 0 || (flags & 32) == 0) {
                    return result;
                }
                return StringsKt.replace$default(result, Constants.COL_PRIORITY, "COMPRESSED", false, 4, (Object) null);
        }
    }
}
