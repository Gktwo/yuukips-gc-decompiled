package okhttp3.internal;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import kotlin.Exceptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.http2.Header;
import okhttp3.internal.p020io.FileSystem;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Options;
import okio.Sink;
import okio.Source;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.http.sse.EmitterKt;

/* compiled from: Util.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��¸\u0002\n��\n\u0002\u0010\u0012\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010��\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0005\n��\n\u0002\u0010\n\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001c\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u001a\u001e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u0017\u001a'\u0010\u001f\u001a\u00020\u00112\u0006\u0010\u001f\u001a\u00020\u00112\u0012\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\"0!\"\u00020\"¢\u0006\u0002\u0010#\u001a\u001a\u0010$\u001a\u00020\u001b2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\bø\u0001��\u001a-\u0010'\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b��\u0010)2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u0002H)0!\"\u0002H)H\u0007¢\u0006\u0002\u0010+\u001a\u000e\u0010,\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0011\u001a1\u0010-\u001a\u0004\u0018\u0001H)\"\u0004\b��\u0010)2\u0006\u0010.\u001a\u00020\"2\f\u0010/\u001a\b\u0012\u0004\u0012\u0002H)002\u0006\u00101\u001a\u00020\u0011¢\u0006\u0002\u00102\u001a\u0016\u00103\u001a\u0002042\u0006\u0010\u0015\u001a\u00020\u00112\u0006\u00105\u001a\u00020\u000f\u001a\"\u00106\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00112\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001b0&H\bø\u0001��\u001a%\u00107\u001a\u00020\u001b\"\u0004\b��\u00108*\b\u0012\u0004\u0012\u0002H8092\u0006\u0010:\u001a\u0002H8H��¢\u0006\u0002\u0010;\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020=2\u0006\u0010>\u001a\u00020\u0014H\u0004\u001a\u0015\u0010<\u001a\u00020\u0017*\u00020\u00142\u0006\u0010>\u001a\u00020\u0017H\u0004\u001a\u0015\u0010<\u001a\u00020\u0014*\u00020?2\u0006\u0010>\u001a\u00020\u0014H\u0004\u001a\n\u0010@\u001a\u00020A*\u00020B\u001a\r\u0010C\u001a\u00020\u001b*\u00020\"H\b\u001a\r\u0010D\u001a\u00020\u001b*\u00020\"H\b\u001a\n\u0010E\u001a\u00020\u000f*\u00020\u0011\u001a\u0012\u0010F\u001a\u00020\u000f*\u00020G2\u0006\u0010H\u001a\u00020G\u001a\n\u0010I\u001a\u00020\u001b*\u00020J\u001a\n\u0010I\u001a\u00020\u001b*\u00020K\u001a\n\u0010I\u001a\u00020\u001b*\u00020L\u001a#\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u0011¢\u0006\u0002\u0010O\u001a&\u0010P\u001a\u00020\u0014*\u00020\u00112\u0006\u0010Q\u001a\u00020R2\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a&\u0010P\u001a\u00020\u0014*\u00020\u00112\u0006\u0010U\u001a\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u001a\u0010V\u001a\u00020\u000f*\u00020W2\u0006\u0010X\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0019\u001a;\u0010Z\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b��\u0010)*\b\u0012\u0004\u0012\u0002H)0[2\u0017\u0010\\\u001a\u0013\u0012\u0004\u0012\u0002H)\u0012\u0004\u0012\u00020\u000f0]¢\u0006\u0002\b^H\bø\u0001��\u001a5\u0010_\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010!2\u000e\u0010`\u001a\n\u0012\u0006\b��\u0012\u00020\u00110a¢\u0006\u0002\u0010b\u001a\n\u0010c\u001a\u00020\u0017*\u00020d\u001a+\u0010e\u001a\u00020\u0014*\b\u0012\u0004\u0012\u00020\u00110!2\u0006\u0010N\u001a\u00020\u00112\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u00110a¢\u0006\u0002\u0010f\u001a\n\u0010g\u001a\u00020\u0014*\u00020\u0011\u001a\u001e\u0010h\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u001e\u0010i\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u0014\u0010j\u001a\u00020\u0014*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u0014\u001a9\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00110!*\b\u0012\u0004\u0012\u00020\u00110!2\f\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00110!2\u000e\u0010`\u001a\n\u0012\u0006\b��\u0012\u00020\u00110a¢\u0006\u0002\u0010l\u001a\u0012\u0010m\u001a\u00020\u000f*\u00020n2\u0006\u0010o\u001a\u00020p\u001a\u0012\u0010q\u001a\u00020\u000f*\u00020L2\u0006\u0010r\u001a\u00020s\u001a\r\u0010t\u001a\u00020\u001b*\u00020\"H\b\u001a\r\u0010u\u001a\u00020\u001b*\u00020\"H\b\u001a\n\u0010v\u001a\u00020\u0014*\u00020R\u001a\n\u0010w\u001a\u00020\u0011*\u00020L\u001a\u0012\u0010x\u001a\u00020y*\u00020s2\u0006\u0010z\u001a\u00020y\u001a\n\u0010{\u001a\u00020\u0014*\u00020s\u001a\u0012\u0010|\u001a\u00020\u0014*\u00020}2\u0006\u0010~\u001a\u00020=\u001a\u001a\u0010|\u001a\u00020\u000f*\u00020W2\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010Y\u001a\u00020\u0019\u001a\u0011\u0010\u001a\t\u0012\u0005\u0012\u00030\u00010(*\u00020\u0003\u001a\u0012\u0010\u0001\u001a\u00020\u0003*\t\u0012\u0005\u0012\u00030\u00010(\u001a\u000b\u0010\u0001\u001a\u00020\u0011*\u00020\u0014\u001a\u000b\u0010\u0001\u001a\u00020\u0011*\u00020\u0017\u001a\u0016\u0010\u0001\u001a\u00020\u0011*\u00020G2\t\b\u0002\u0010\u0001\u001a\u00020\u000f\u001a\u001d\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002H)0(\"\u0004\b��\u0010)*\b\u0012\u0004\u0012\u0002H)0(\u001a7\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u0001\"\u0005\b��\u0010\u0001\"\u0005\b\u0001\u0010\u0001*\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u0001\u001a\u0014\u0010\u0001\u001a\u00020\u0017*\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u0017\u001a\u0016\u0010\u0001\u001a\u00020\u0014*\u0004\u0018\u00010\u00112\u0007\u0010\u0001\u001a\u00020\u0014\u001a\u001f\u0010\u0001\u001a\u00020\u0011*\u00020\u00112\b\b\u0002\u0010S\u001a\u00020\u00142\b\b\u0002\u0010T\u001a\u00020\u0014\u001a\u000e\u0010\u0001\u001a\u00020\u001b*\u00020\"H\b\u001a'\u0010\u0001\u001a\u00030\u0001*\b0\u0001j\u0003`\u00012\u0013\u0010\u0001\u001a\u000e\u0012\n\u0012\b0\u0001j\u0003`\u00010(\u001a\u0015\u0010\u0001\u001a\u00020\u001b*\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0014\"\u0010\u0010��\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0002\n��\"\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��\"\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n��\"\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\u0002\n��\"\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n��\"\u0010\u0010\n\u001a\u00020\u000b8\u0006X\u0004¢\u0006\u0002\n��\"\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n��\"\u0010\u0010\u000e\u001a\u00020\u000f8��X\u0004¢\u0006\u0002\n��\"\u0010\u0010\u0010\u001a\u00020\u00118��X\u0004¢\u0006\u0002\n��\"\u000e\u0010\u0012\u001a\u00020\u0011XT¢\u0006\u0002\n��\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, m373d2 = {"EMPTY_BYTE_ARRAY", "", "EMPTY_HEADERS", "Lokhttp3/Headers;", "EMPTY_REQUEST", "Lokhttp3/RequestBody;", "EMPTY_RESPONSE", "Lokhttp3/ResponseBody;", "UNICODE_BOMS", "Lokio/Options;", "UTC", "Ljava/util/TimeZone;", "VERIFY_AS_IP_ADDRESS", "Lkotlin/text/Regex;", "assertionsEnabled", "", "okHttpName", "", "userAgent", "checkDuration", "", "name", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "checkOffsetAndCount", "", "arrayLength", "offset", "count", "format", EJBInvokerJob.EJB_ARGS_KEY, "", "", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "ignoreIoExceptions", "block", "Lkotlin/Function0;", "immutableListOf", "", "T", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "isSensitiveHeader", "readFieldOrNull", "instance", "fieldType", "Ljava/lang/Class;", "fieldName", "(Ljava/lang/Object;Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Object;", "threadFactory", "Ljava/util/concurrent/ThreadFactory;", "daemon", "threadName", "addIfAbsent", "E", "", "element", "(Ljava/util/List;Ljava/lang/Object;)V", "and", "", "mask", "", "asFactory", "Lokhttp3/EventListener$Factory;", "Lokhttp3/EventListener;", "assertThreadDoesntHoldLock", "assertThreadHoldsLock", "canParseAsIpAddress", "canReuseConnectionFor", "Lokhttp3/HttpUrl;", "other", "closeQuietly", "Ljava/io/Closeable;", "Ljava/net/ServerSocket;", "Ljava/net/Socket;", "concat", "value", "([Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;", "delimiterOffset", "delimiter", "", "startIndex", "endIndex", "delimiters", "discard", "Lokio/Source;", "timeout", "timeUnit", "filterList", "", "predicate", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "hasIntersection", "comparator", "Ljava/util/Comparator;", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)Z", "headersContentLength", "Lokhttp3/Response;", "indexOf", "([Ljava/lang/String;Ljava/lang/String;Ljava/util/Comparator;)I", "indexOfControlOrNonAscii", "indexOfFirstNonAsciiWhitespace", "indexOfLastNonAsciiWhitespace", "indexOfNonWhitespace", "intersect", "([Ljava/lang/String;[Ljava/lang/String;Ljava/util/Comparator;)[Ljava/lang/String;", "isCivilized", "Lokhttp3/internal/io/FileSystem;", Action.FILE_ATTRIBUTE, "Ljava/io/File;", "isHealthy", "source", "Lokio/BufferedSource;", "notify", "notifyAll", "parseHexDigit", "peerName", "readBomAsCharset", "Ljava/nio/charset/Charset;", "default", "readMedium", "skipAll", "Lokio/Buffer;", "b", "toHeaderList", "Lokhttp3/internal/http2/Header;", "toHeaders", "toHexString", "toHostHeader", "includeDefaultPort", "toImmutableList", "toImmutableMap", "", "K", "V", "toLongOrDefault", "defaultValue", "toNonNegativeInt", "trimSubstring", "wait", "withSuppressed", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "suppressed", "writeMedium", "Lokio/BufferedSink;", "medium", "okhttp"})
@JvmName(name = "Util")
/* loaded from: grasscutter.jar:okhttp3/internal/Util.class */
public final class Util {
    @JvmField
    @NotNull
    public static final TimeZone UTC;
    @JvmField
    @NotNull
    public static final String okHttpName;
    @NotNull
    public static final String userAgent = "okhttp/4.10.0";
    @JvmField
    @NotNull
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    @JvmField
    @NotNull
    public static final Headers EMPTY_HEADERS = Headers.Companion.m54of(new String[0]);
    @JvmField
    @NotNull
    public static final ResponseBody EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, EMPTY_BYTE_ARRAY, (MediaType) null, 1, (Object) null);
    @JvmField
    @NotNull
    public static final RequestBody EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, EMPTY_BYTE_ARRAY, (MediaType) null, 0, 0, 7, (Object) null);
    @NotNull
    private static final Options UNICODE_BOMS = Options.Companion.m46of(ByteString.Companion.decodeHex("efbbbf"), ByteString.Companion.decodeHex("feff"), ByteString.Companion.decodeHex("fffe"), ByteString.Companion.decodeHex("0000ffff"), ByteString.Companion.decodeHex("ffff0000"));
    @NotNull
    private static final Regex VERIFY_AS_IP_ADDRESS = new Regex("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    @JvmField
    public static final boolean assertionsEnabled = OkHttpClient.class.desiredAssertionStatus();

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Intrinsics.checkNotNull(timeZone);
        UTC = timeZone;
        String name = OkHttpClient.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "OkHttpClient::class.java.name");
        okHttpName = StringsKt.removeSuffix(StringsKt.removePrefix(name, (CharSequence) "okhttp3."), (CharSequence) "Client");
    }

    public static final void checkOffsetAndCount(long arrayLength, long offset, long count) {
        if ((offset | count) < 0 || offset > arrayLength || arrayLength - offset < count) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @NotNull
    public static final ThreadFactory threadFactory(@NotNull String name, boolean daemon) {
        Intrinsics.checkNotNullParameter(name, "name");
        return (v2) -> {
            return m9301threadFactory$lambda1(r0, r1, v2);
        };
    }

    /* renamed from: threadFactory$lambda-1  reason: not valid java name */
    private static final Thread m9301threadFactory$lambda1(String $name, boolean $daemon, Runnable runnable) {
        Intrinsics.checkNotNullParameter($name, "$name");
        Thread $this$threadFactory_u24lambda_u2d1_u24lambda_u2d0 = new Thread(runnable, $name);
        $this$threadFactory_u24lambda_u2d1_u24lambda_u2d0.setDaemon($daemon);
        return $this$threadFactory_u24lambda_u2d1_u24lambda_u2d0;
    }

    @NotNull
    public static final String[] intersect(@NotNull String[] $this$intersect, @NotNull String[] other, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter($this$intersect, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        List result = new ArrayList();
        int i = 0;
        int length = $this$intersect.length;
        while (i < length) {
            String a = $this$intersect[i];
            i++;
            int i2 = 0;
            int length2 = other.length;
            while (true) {
                if (i2 < length2) {
                    String b = other[i2];
                    i2++;
                    if (comparator.compare(a, b) == 0) {
                        result.add(a);
                        break;
                    }
                }
            }
        }
        Object[] array = result.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final boolean hasIntersection(@NotNull String[] $this$hasIntersection, @Nullable String[] other, @NotNull Comparator<? super String> comparator) {
        Intrinsics.checkNotNullParameter($this$hasIntersection, "<this>");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        if (($this$hasIntersection.length == 0) || other == null) {
            return false;
        }
        if (other.length == 0) {
            return false;
        }
        int i = 0;
        int length = $this$hasIntersection.length;
        while (i < length) {
            String a = $this$hasIntersection[i];
            i++;
            Iterator it = ArrayIteratorKt.iterator(other);
            while (it.hasNext()) {
                if (comparator.compare(a, (String) it.next()) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return toHostHeader(httpUrl, z);
    }

    @NotNull
    public static final String toHostHeader(@NotNull HttpUrl $this$toHostHeader, boolean includeDefaultPort) {
        String host;
        Intrinsics.checkNotNullParameter($this$toHostHeader, "<this>");
        if (StringsKt.contains$default((CharSequence) $this$toHostHeader.host(), (CharSequence) EmitterKt.COMMENT_PREFIX, false, 2, (Object) null)) {
            host = '[' + $this$toHostHeader.host() + ']';
        } else {
            host = $this$toHostHeader.host();
        }
        if (includeDefaultPort || $this$toHostHeader.port() != HttpUrl.Companion.defaultPort($this$toHostHeader.scheme())) {
            return host + ':' + $this$toHostHeader.port();
        }
        return host;
    }

    public static final int indexOf(@NotNull String[] $this$indexOf, @NotNull String value, @NotNull Comparator<String> comparator) {
        Intrinsics.checkNotNullParameter($this$indexOf, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(comparator, "comparator");
        int length = $this$indexOf.length;
        for (int index$iv = 0; index$iv < length; index$iv++) {
            if (comparator.compare($this$indexOf[index$iv], value) == 0) {
                return index$iv;
            }
        }
        return -1;
    }

    @NotNull
    public static final String[] concat(@NotNull String[] $this$concat, @NotNull String value) {
        Intrinsics.checkNotNullParameter($this$concat, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        Object[] copyOf = Arrays.copyOf($this$concat, $this$concat.length + 1);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        String[] result = (String[]) copyOf;
        result[ArraysKt.getLastIndex(result)] = value;
        return result;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfFirstNonAsciiWhitespace(@NotNull String $this$indexOfFirstNonAsciiWhitespace, int startIndex, int endIndex) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$indexOfFirstNonAsciiWhitespace, "<this>");
        int i = startIndex;
        while (i < endIndex) {
            i++;
            char charAt = $this$indexOfFirstNonAsciiWhitespace.charAt(i);
            if (charAt == '\t' ? true : charAt == '\n' ? true : charAt == '\f' ? true : charAt == '\r') {
                z = true;
                continue;
            } else if (charAt == ' ') {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (!z) {
                return i;
            }
        }
        return endIndex;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i, i2);
    }

    public static final int indexOfLastNonAsciiWhitespace(@NotNull String $this$indexOfLastNonAsciiWhitespace, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfLastNonAsciiWhitespace, "<this>");
        int i = endIndex - 1;
        if (startIndex > i) {
            return startIndex;
        }
        do {
            i--;
            char charAt = $this$indexOfLastNonAsciiWhitespace.charAt(i);
            if (!(charAt == '\t' ? true : charAt == '\n' ? true : charAt == '\f' ? true : charAt == '\r' ? true : charAt == ' ')) {
                return i + 1;
            }
        } while (i != startIndex);
        return startIndex;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return trimSubstring(str, i, i2);
    }

    @NotNull
    public static final String trimSubstring(@NotNull String $this$trimSubstring, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$trimSubstring, "<this>");
        int start = indexOfFirstNonAsciiWhitespace($this$trimSubstring, startIndex, endIndex);
        String substring = $this$trimSubstring.substring(start, indexOfLastNonAsciiWhitespace($this$trimSubstring, start, endIndex));
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, str2, i, i2);
    }

    public static final int delimiterOffset(@NotNull String $this$delimiterOffset, @NotNull String delimiters, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$delimiterOffset, "<this>");
        Intrinsics.checkNotNullParameter(delimiters, "delimiters");
        int i = startIndex;
        while (i < endIndex) {
            i++;
            if (StringsKt.contains$default((CharSequence) delimiters, $this$delimiterOffset.charAt(i), false, 2, (Object) null)) {
                return i;
            }
        }
        return endIndex;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return delimiterOffset(str, c, i, i2);
    }

    public static final int delimiterOffset(@NotNull String $this$delimiterOffset, char delimiter, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$delimiterOffset, "<this>");
        int i = startIndex;
        while (i < endIndex) {
            i++;
            if ($this$delimiterOffset.charAt(i) == delimiter) {
                return i;
            }
        }
        return endIndex;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int indexOfControlOrNonAscii(@org.jetbrains.annotations.NotNull java.lang.String r3) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = 0
            r4 = r0
            r0 = r3
            int r0 = r0.length()
            r5 = r0
        L_0x000d:
            r0 = r4
            r1 = r5
            if (r0 >= r1) goto L_0x0034
            r0 = r4
            r6 = r0
            int r4 = r4 + 1
            r0 = r3
            r1 = r6
            char r0 = r0.charAt(r1)
            r7 = r0
            r0 = r7
            r1 = 31
            int r0 = kotlin.jvm.internal.Intrinsics.compare(r0, r1)
            if (r0 <= 0) goto L_0x0032
            r0 = r7
            r1 = 127(0x7f, float:1.78E-43)
            int r0 = kotlin.jvm.internal.Intrinsics.compare(r0, r1)
            if (r0 < 0) goto L_0x000d
        L_0x0032:
            r0 = r6
            return r0
        L_0x0034:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.indexOfControlOrNonAscii(java.lang.String):int");
    }

    public static final boolean canParseAsIpAddress(@NotNull String $this$canParseAsIpAddress) {
        Intrinsics.checkNotNullParameter($this$canParseAsIpAddress, "<this>");
        return VERIFY_AS_IP_ADDRESS.matches($this$canParseAsIpAddress);
    }

    public static final boolean isSensitiveHeader(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return StringsKt.equals(name, "Authorization", true) || StringsKt.equals(name, "Cookie", true) || StringsKt.equals(name, "Proxy-Authorization", true) || StringsKt.equals(name, "Set-Cookie", true);
    }

    @NotNull
    public static final String format(@NotNull String format, @NotNull Object... args) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(args, EJBInvokerJob.EJB_ARGS_KEY);
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(args, args.length);
        String format2 = String.format(locale, format, Arrays.copyOf(copyOf, copyOf.length));
        Intrinsics.checkNotNullExpressionValue(format2, "format(locale, format, *args)");
        return format2;
    }

    @NotNull
    public static final Charset readBomAsCharset(@NotNull BufferedSource $this$readBomAsCharset, @NotNull Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readBomAsCharset, "<this>");
        Intrinsics.checkNotNullParameter(charset, "default");
        switch ($this$readBomAsCharset.select(UNICODE_BOMS)) {
            case -1:
                return charset;
            case 0:
                Charset charset2 = StandardCharsets.UTF_8;
                Intrinsics.checkNotNullExpressionValue(charset2, "UTF_8");
                return charset2;
            case 1:
                Charset charset3 = StandardCharsets.UTF_16BE;
                Intrinsics.checkNotNullExpressionValue(charset3, "UTF_16BE");
                return charset3;
            case 2:
                Charset charset4 = StandardCharsets.UTF_16LE;
                Intrinsics.checkNotNullExpressionValue(charset4, "UTF_16LE");
                return charset4;
            case 3:
                return Charsets.INSTANCE.UTF32_BE();
            case 4:
                return Charsets.INSTANCE.UTF32_LE();
            default:
                throw new AssertionError();
        }
    }

    public static final int checkDuration(@NotNull String name, long duration, @Nullable TimeUnit unit) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(duration >= 0)) {
            throw new IllegalStateException(Intrinsics.stringPlus(name, " < 0").toString());
        }
        if (!(unit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = unit.toMillis(duration);
        if (!(millis <= 2147483647L)) {
            throw new IllegalArgumentException(Intrinsics.stringPlus(name, " too large.").toString());
        }
        if (millis != 0 || duration <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(Intrinsics.stringPlus(name, " too small.").toString());
    }

    public static final int parseHexDigit(char $this$parseHexDigit) {
        boolean z;
        boolean z2;
        boolean z3;
        if ('0' <= $this$parseHexDigit) {
            z = $this$parseHexDigit < ':';
        } else {
            z = false;
        }
        if (z) {
            return $this$parseHexDigit - '0';
        }
        if ('a' <= $this$parseHexDigit) {
            z2 = $this$parseHexDigit < 'g';
        } else {
            z2 = false;
        }
        if (z2) {
            return ($this$parseHexDigit - 'a') + 10;
        }
        if ('A' <= $this$parseHexDigit) {
            z3 = $this$parseHexDigit < 'G';
        } else {
            z3 = false;
        }
        if (z3) {
            return ($this$parseHexDigit - 'A') + 10;
        }
        return -1;
    }

    @NotNull
    public static final Headers toHeaders(@NotNull List<Header> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().utf8(), header.component2().utf8());
        }
        return builder.build();
    }

    @NotNull
    public static final List<Header> toHeaderList(@NotNull Headers $this$toHeaderList) {
        Intrinsics.checkNotNullParameter($this$toHeaderList, "<this>");
        Iterable $this$map$iv = RangesKt.until(0, $this$toHeaderList.size());
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        Iterator<Integer> it = $this$map$iv.iterator();
        while (it.hasNext()) {
            int item$iv$iv = ((IntIterator) it).nextInt();
            destination$iv$iv.add(new Header($this$toHeaderList.name(item$iv$iv), $this$toHeaderList.value(item$iv$iv)));
        }
        return (List) destination$iv$iv;
    }

    public static final boolean canReuseConnectionFor(@NotNull HttpUrl $this$canReuseConnectionFor, @NotNull HttpUrl other) {
        Intrinsics.checkNotNullParameter($this$canReuseConnectionFor, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return Intrinsics.areEqual($this$canReuseConnectionFor.host(), other.host()) && $this$canReuseConnectionFor.port() == other.port() && Intrinsics.areEqual($this$canReuseConnectionFor.scheme(), other.scheme());
    }

    @NotNull
    public static final EventListener.Factory asFactory(@NotNull EventListener $this$asFactory) {
        Intrinsics.checkNotNullParameter($this$asFactory, "<this>");
        return (v1) -> {
            return m9302asFactory$lambda8(r0, v1);
        };
    }

    /* renamed from: asFactory$lambda-8  reason: not valid java name */
    private static final EventListener m9302asFactory$lambda8(EventListener $this_asFactory, Call it) {
        Intrinsics.checkNotNullParameter($this_asFactory, "$this_asFactory");
        Intrinsics.checkNotNullParameter(it, "it");
        return $this_asFactory;
    }

    public static final int and(byte $this$and, int mask) {
        return $this$and & mask;
    }

    public static final int and(short $this$and, int mask) {
        return $this$and & mask;
    }

    public static final long and(int $this$and, long mask) {
        return ((long) $this$and) & mask;
    }

    public static final void writeMedium(@NotNull BufferedSink $this$writeMedium, int medium) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeMedium, "<this>");
        $this$writeMedium.writeByte((medium >>> 16) & 255);
        $this$writeMedium.writeByte((medium >>> 8) & 255);
        $this$writeMedium.writeByte(medium & 255);
    }

    public static final int readMedium(@NotNull BufferedSource $this$readMedium) throws IOException {
        Intrinsics.checkNotNullParameter($this$readMedium, "<this>");
        return (and($this$readMedium.readByte(), 255) << 16) | (and($this$readMedium.readByte(), 255) << 8) | and($this$readMedium.readByte(), 255);
    }

    public static final boolean skipAll(@NotNull Source $this$skipAll, int duration, @NotNull TimeUnit timeUnit) throws IOException {
        long originalDurationNs;
        boolean z;
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        long nowNs = System.nanoTime();
        if ($this$skipAll.timeout().hasDeadline()) {
            originalDurationNs = $this$skipAll.timeout().deadlineNanoTime() - nowNs;
        } else {
            originalDurationNs = LongCompanionObject.MAX_VALUE;
        }
        $this$skipAll.timeout().deadlineNanoTime(nowNs + Math.min(originalDurationNs, timeUnit.toNanos((long) duration)));
        try {
            Buffer skipBuffer = new Buffer();
            while ($this$skipAll.read(skipBuffer, FileAppender.DEFAULT_BUFFER_SIZE) != -1) {
                skipBuffer.clear();
            }
            z = true;
            if (originalDurationNs == LongCompanionObject.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
        } catch (InterruptedIOException e) {
            z = false;
            if (originalDurationNs == LongCompanionObject.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
        } catch (Throwable th) {
            if (originalDurationNs == LongCompanionObject.MAX_VALUE) {
                $this$skipAll.timeout().clearDeadline();
            } else {
                $this$skipAll.timeout().deadlineNanoTime(nowNs + originalDurationNs);
            }
            throw th;
        }
        return z;
    }

    public static final boolean discard(@NotNull Source $this$discard, int timeout, @NotNull TimeUnit timeUnit) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$discard, "<this>");
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        try {
            z = skipAll($this$discard, timeout, timeUnit);
        } catch (IOException e) {
            z = false;
        }
        return z;
    }

    @NotNull
    public static final String peerName(@NotNull Socket $this$peerName) {
        Intrinsics.checkNotNullParameter($this$peerName, "<this>");
        SocketAddress address = $this$peerName.getRemoteSocketAddress();
        if (!(address instanceof InetSocketAddress)) {
            return address.toString();
        }
        String hostName = ((InetSocketAddress) address).getHostName();
        Intrinsics.checkNotNullExpressionValue(hostName, "address.hostName");
        return hostName;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x0030
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public static final boolean isHealthy(@org.jetbrains.annotations.NotNull java.net.Socket r3, @org.jetbrains.annotations.NotNull okio.BufferedSource r4) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r4
            java.lang.String r1 = "source"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r3
            int r0 = r0.getSoTimeout()     // Catch: SocketTimeoutException -> 0x003f, IOException -> 0x0045
            r5 = r0
            r0 = r3
            r1 = 1
            r0.setSoTimeout(r1)     // Catch: SocketTimeoutException -> 0x003f, IOException -> 0x0045, all -> 0x0030
            r0 = r4
            boolean r0 = r0.exhausted()     // Catch: SocketTimeoutException -> 0x003f, IOException -> 0x0045, all -> 0x0030
            if (r0 != 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            r6 = r0
            r0 = r3
            r1 = r5
            r0.setSoTimeout(r1)     // Catch: SocketTimeoutException -> 0x003f, IOException -> 0x0045
            goto L_0x003a
        L_0x0030:
            r7 = move-exception
            r0 = r3
            r1 = r5
            r0.setSoTimeout(r1)     // Catch: SocketTimeoutException -> 0x003f, IOException -> 0x0045
            r0 = r7
            throw r0     // Catch: SocketTimeoutException -> 0x003f, IOException -> 0x0045
        L_0x003a:
            r0 = r6
            r5 = r0
            goto L_0x0048
        L_0x003f:
            r6 = move-exception
            r0 = 1
            r5 = r0
            goto L_0x0048
        L_0x0045:
            r6 = move-exception
            r0 = 0
            r5 = r0
        L_0x0048:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.isHealthy(java.net.Socket, okio.BufferedSource):boolean");
    }

    public static final void ignoreIoExceptions(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            function0.invoke();
        } catch (IOException e) {
        }
    }

    public static final void threadName(@NotNull String name, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(function0, "block");
        Thread currentThread = Thread.currentThread();
        String oldName = currentThread.getName();
        currentThread.setName(name);
        try {
            function0.invoke();
            InlineMarker.finallyStart(1);
            currentThread.setName(oldName);
            InlineMarker.finallyEnd(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            currentThread.setName(oldName);
            InlineMarker.finallyEnd(1);
            throw th;
        }
    }

    public static final int skipAll(@NotNull Buffer $this$skipAll, byte b) {
        Intrinsics.checkNotNullParameter($this$skipAll, "<this>");
        int count = 0;
        while (!$this$skipAll.exhausted() && $this$skipAll.getByte(0) == b) {
            count++;
            $this$skipAll.readByte();
        }
        return count;
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return indexOfNonWhitespace(str, i);
    }

    public static final int indexOfNonWhitespace(@NotNull String $this$indexOfNonWhitespace, int startIndex) {
        Intrinsics.checkNotNullParameter($this$indexOfNonWhitespace, "<this>");
        int i = startIndex;
        int length = $this$indexOfNonWhitespace.length();
        while (i < length) {
            i++;
            char c = $this$indexOfNonWhitespace.charAt(i);
            if (c != ' ' && c != '\t') {
                return i;
            }
        }
        return $this$indexOfNonWhitespace.length();
    }

    public static final long headersContentLength(@NotNull Response $this$headersContentLength) {
        Intrinsics.checkNotNullParameter($this$headersContentLength, "<this>");
        String str = $this$headersContentLength.headers().get("Content-Length");
        if (str == null) {
            return -1;
        }
        return toLongOrDefault(str, -1);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    public static final long toLongOrDefault(@NotNull String $this$toLongOrDefault, long defaultValue) {
        char c;
        Intrinsics.checkNotNullParameter($this$toLongOrDefault, "<this>");
        try {
            c = Long.parseLong($this$toLongOrDefault);
        } catch (NumberFormatException e) {
            c = defaultValue;
        }
        return c;
    }

    public static final int toNonNegativeInt(@Nullable String $this$toNonNegativeInt, int defaultValue) {
        Long valueOf;
        if ($this$toNonNegativeInt == null) {
            valueOf = null;
        } else {
            try {
                valueOf = Long.valueOf(Long.parseLong($this$toNonNegativeInt));
            } catch (NumberFormatException e) {
                return defaultValue;
            }
        }
        if (valueOf == null) {
            return defaultValue;
        }
        long value = valueOf.longValue();
        if (value > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        if (value < 0) {
            return 0;
        }
        return (int) value;
    }

    @NotNull
    public static final <T> List<T> toImmutableList(@NotNull List<? extends T> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.toMutableList((Collection) list));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(toMutableList())");
        return unmodifiableList;
    }

    @SafeVarargs
    @NotNull
    public static final <T> List<T> immutableListOf(@NotNull T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> unmodifiableList = Collections.unmodifiableList(CollectionsKt.listOf(Arrays.copyOf(objArr, objArr.length)));
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return unmodifiableList;
    }

    @NotNull
    public static final <K, V> Map<K, V> toImmutableMap(@NotNull Map<K, ? extends V> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        if (map.isEmpty()) {
            return MapsKt.emptyMap();
        }
        Map<K, V> unmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return unmodifiableMap;
    }

    public static final void closeQuietly(@NotNull Closeable $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception e) {
        }
    }

    public static final void closeQuietly(@NotNull Socket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException rethrown) {
            if (!Intrinsics.areEqual(rethrown.getMessage(), "bio == null")) {
                throw rethrown;
            }
        } catch (Exception e2) {
        }
    }

    public static final void closeQuietly(@NotNull ServerSocket $this$closeQuietly) {
        Intrinsics.checkNotNullParameter($this$closeQuietly, "<this>");
        try {
            $this$closeQuietly.close();
        } catch (RuntimeException rethrown) {
            throw rethrown;
        } catch (Exception e) {
        }
    }

    public static final boolean isCivilized(@NotNull FileSystem $this$isCivilized, @NotNull File file) {
        Intrinsics.checkNotNullParameter($this$isCivilized, "<this>");
        Intrinsics.checkNotNullParameter(file, Action.FILE_ATTRIBUTE);
        Sink sink = $this$isCivilized.sink(file);
        try {
            Sink sink2 = sink;
            try {
                $this$isCivilized.delete(file);
                kotlin.p016io.Closeable.closeFinally(sink, null);
                return true;
            } catch (IOException e) {
                Unit unit = Unit.INSTANCE;
                kotlin.p016io.Closeable.closeFinally(sink, null);
                $this$isCivilized.delete(file);
                return false;
            }
        } catch (Throwable th) {
            kotlin.p016io.Closeable.closeFinally(sink, null);
            throw th;
        }
    }

    @NotNull
    public static final String toHexString(long $this$toHexString) {
        String hexString = Long.toHexString($this$toHexString);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    @NotNull
    public static final String toHexString(int $this$toHexString) {
        String hexString = Integer.toHexString($this$toHexString);
        Intrinsics.checkNotNullExpressionValue(hexString, "toHexString(this)");
        return hexString;
    }

    public static final void wait(@NotNull Object $this$wait) {
        Intrinsics.checkNotNullParameter($this$wait, "<this>");
        $this$wait.wait();
    }

    public static final void notify(@NotNull Object $this$notify) {
        Intrinsics.checkNotNullParameter($this$notify, "<this>");
        $this$notify.notify();
    }

    public static final void notifyAll(@NotNull Object $this$notifyAll) {
        Intrinsics.checkNotNullParameter($this$notifyAll, "<this>");
        $this$notifyAll.notifyAll();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:5:0x0023
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    @org.jetbrains.annotations.Nullable
    public static final <T> T readFieldOrNull(@org.jetbrains.annotations.NotNull java.lang.Object r4, @org.jetbrains.annotations.NotNull java.lang.Class<T> r5, @org.jetbrains.annotations.NotNull java.lang.String r6) {
        /*
            r0 = r4
            java.lang.String r1 = "instance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r5
            java.lang.String r1 = "fieldType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r6
            java.lang.String r1 = "fieldName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r4
            java.lang.Class r0 = r0.getClass()
            r7 = r0
        L_0x001a:
            r0 = r7
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L_0x0063
            r0 = r7
            r1 = r6
            java.lang.reflect.Field r0 = r0.getDeclaredField(r1)     // Catch: NoSuchFieldException -> 0x004d
            r8 = r0
            r0 = r8
            r1 = 1
            r0.setAccessible(r1)     // Catch: NoSuchFieldException -> 0x004d
            r0 = r8
            r1 = r4
            java.lang.Object r0 = r0.get(r1)     // Catch: NoSuchFieldException -> 0x004d
            r9 = r0
            r0 = r5
            r1 = r9
            boolean r0 = r0.isInstance(r1)     // Catch: NoSuchFieldException -> 0x004d
            if (r0 != 0) goto L_0x0046
            r0 = 0
            goto L_0x004c
        L_0x0046:
            r0 = r5
            r1 = r9
            java.lang.Object r0 = r0.cast(r1)     // Catch: NoSuchFieldException -> 0x004d
        L_0x004c:
            return r0
        L_0x004d:
            r8 = move-exception
            r0 = r7
            java.lang.Class r0 = r0.getSuperclass()
            r8 = r0
            r0 = r8
            java.lang.String r1 = "c.superclass"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r0 = r8
            r7 = r0
            goto L_0x001a
        L_0x0063:
            r0 = r6
            java.lang.String r1 = "delegate"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r0, r1)
            if (r0 != 0) goto L_0x0085
            r0 = r4
            java.lang.Class<java.lang.Object> r1 = java.lang.Object.class
            java.lang.String r2 = "delegate"
            java.lang.Object r0 = readFieldOrNull(r0, r1, r2)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x0085
            r0 = r8
            r1 = r5
            r2 = r6
            java.lang.Object r0 = readFieldOrNull(r0, r1, r2)
            return r0
        L_0x0085:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.readFieldOrNull(java.lang.Object, java.lang.Class, java.lang.String):java.lang.Object");
    }

    public static final <E> void addIfAbsent(@NotNull List<E> list, E e) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        if (!list.contains(e)) {
            list.add(e);
        }
    }

    public static final void assertThreadHoldsLock(@NotNull Object $this$assertThreadHoldsLock) {
        Intrinsics.checkNotNullParameter($this$assertThreadHoldsLock, "<this>");
        if (assertionsEnabled && !Thread.holdsLock($this$assertThreadHoldsLock)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST hold lock on " + $this$assertThreadHoldsLock);
        }
    }

    public static final void assertThreadDoesntHoldLock(@NotNull Object $this$assertThreadDoesntHoldLock) {
        Intrinsics.checkNotNullParameter($this$assertThreadDoesntHoldLock, "<this>");
        if (assertionsEnabled && Thread.holdsLock($this$assertThreadDoesntHoldLock)) {
            throw new AssertionError("Thread " + ((Object) Thread.currentThread().getName()) + " MUST NOT hold lock on " + $this$assertThreadDoesntHoldLock);
        }
    }

    @NotNull
    public static final Throwable withSuppressed(@NotNull Exception $this$withSuppressed, @NotNull List<? extends Exception> list) {
        Intrinsics.checkNotNullParameter($this$withSuppressed, "<this>");
        Intrinsics.checkNotNullParameter(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        for (Exception e : list) {
            Exceptions.addSuppressed($this$withSuppressed, e);
        }
        return $this$withSuppressed;
    }

    @NotNull
    public static final <T> List<T> filterList(@NotNull Iterable<? extends T> iterable, @NotNull Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        List result = CollectionsKt.emptyList();
        Iterator<? extends T> it = iterable.iterator();
        while (it.hasNext()) {
            Object i = (Object) it.next();
            if (function1.invoke(i).booleanValue()) {
                boolean isEmpty = result.isEmpty();
                result = result;
                if (isEmpty) {
                    result = new ArrayList();
                }
                TypeIntrinsics.asMutableList(result).add(i);
            }
        }
        return result;
    }
}
