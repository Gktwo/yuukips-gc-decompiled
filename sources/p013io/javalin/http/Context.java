package p013io.javalin.http;

import com.sun.jna.Callback;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.IOStreams;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;
import org.eclipse.jetty.client.RedirectProtocolHandler;
import org.eclipse.jetty.websocket.api.StatusCode;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import org.slf4j.Logger;
import p001ch.qos.logback.classic.ClassicConstants;
import p001ch.qos.logback.core.joran.action.Action;
import p013io.javalin.core.security.BasicAuthCredentials;
import p013io.javalin.core.validation.BodyValidator;
import p013io.javalin.core.validation.Validator;
import p013io.javalin.http.util.ContextUtil;
import p013io.javalin.http.util.CookieStore;
import p013io.javalin.http.util.MultipartUtil;
import p013io.javalin.http.util.SeekableWriter;
import p013io.javalin.plugin.json.JsonMapperKt;
import p013io.javalin.plugin.rendering.JavalinRenderer;

/* compiled from: Context.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��Î\u0001\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018��2\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007¢\u0006\u0002\u0010\tJ\u0019\u0010<\u001a\u0002H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b¢\u0006\u0002\u0010?J\u001b\u0010@\u001a\u0004\u0018\u0001H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b¢\u0006\u0002\u0010?J\u0018\u0010@\u001a\u00020A2\u0006\u0010>\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\u0001J\u0014\u0010C\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0006\u0010D\u001a\u00020EJ\u0006\u0010F\u001a\u00020GJ\u0006\u0010\f\u001a\u00020\bJ\u0006\u0010H\u001a\u00020\rJ\u001a\u0010I\u001a\u0002H=\"\n\b��\u0010=\u0018\u0001*\u00020\u0001H\b¢\u0006\u0002\u0010JJ\u001f\u0010I\u001a\u0002H=\"\u0004\b��\u0010=2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0L¢\u0006\u0002\u0010MJ\u0006\u0010N\u001a\u00020OJ\u001a\u0010P\u001a\u0002H=\"\n\b��\u0010=\u0018\u0001*\u00020\u0001H\b¢\u0006\u0002\u0010JJ\u001f\u0010P\u001a\u0002H=\"\u0004\b��\u0010=2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0L¢\u0006\u0002\u0010MJ\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u0002H=0R\"\n\b��\u0010=\u0018\u0001*\u00020\u0001H\bJ \u0010Q\u001a\b\u0012\u0004\u0012\u0002H=0R\"\u0004\b��\u0010=2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0LJ\u001b\u0010S\u001a\u0004\u0018\u0001H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b¢\u0006\u0002\u0010?J\u0018\u0010S\u001a\u00020A2\u0006\u0010>\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\u0001J/\u0010T\u001a\u0004\u0018\u0001H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b2\u0012\u0010U\u001a\u000e\u0012\u0004\u0012\u00020��\u0012\u0004\u0012\u0002H=0V¢\u0006\u0002\u0010WJ\u0006\u0010X\u001a\u00020AJ\u001b\u0010Y\u001a\u0004\u0018\u0001H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b¢\u0006\u0002\u0010?J\u0006\u0010Z\u001a\u00020[J\b\u0010\\\u001a\u0004\u0018\u00010\bJ\u000e\u0010\\\u001a\u00020��2\u0006\u0010\\\u001a\u00020]J\u000e\u0010\\\u001a\u00020��2\u0006\u0010\\\u001a\u00020\bJ\u0006\u0010^\u001a\u00020\bJ\u000e\u0010_\u001a\u00020��2\u0006\u0010_\u001a\u00020`J\u0010\u0010_\u001a\u0004\u0018\u00010\b2\u0006\u0010a\u001a\u00020\bJ\"\u0010_\u001a\u00020��2\u0006\u0010a\u001a\u00020\b2\u0006\u0010B\u001a\u00020\b2\b\b\u0002\u0010b\u001a\u00020[H\u0007J\u0012\u0010c\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\u0019\u0010\u0016\u001a\u0002H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b¢\u0006\u0002\u0010?J\u0016\u0010\u0016\u001a\u00020A2\u0006\u0010>\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u0001J\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010d\u001a\u0004\u0018\u00010\b2\u0006\u0010>\u001a\u00020\bJ#\u0010e\u001a\b\u0012\u0004\u0012\u0002H=0f\"\n\b��\u0010=\u0018\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\bH\bJ(\u0010e\u001a\b\u0012\u0004\u0012\u0002H=0f\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0LJ\u0018\u0010g\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0\u0007J\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0!2\u0006\u0010>\u001a\u00020\bJ\u0006\u0010h\u001a\u00020\bJ(\u0010i\u001a\u00020��2\n\u0010i\u001a\u0006\u0012\u0002\b\u00030j2\u0012\b\u0002\u0010U\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010kH\u0007J\u0006\u0010%\u001a\u00020$J\u0010\u0010l\u001a\u0004\u0018\u00010\b2\u0006\u0010l\u001a\u00020\bJ\u0016\u0010l\u001a\u00020��2\u0006\u0010a\u001a\u00020\b2\u0006\u0010B\u001a\u00020\bJ#\u0010m\u001a\b\u0012\u0004\u0012\u0002H=0f\"\n\b��\u0010=\u0018\u0001*\u00020\u00012\u0006\u0010l\u001a\u00020\bH\bJ(\u0010m\u001a\b\u0012\u0004\u0012\u0002H=0f\"\u0004\b��\u0010=2\u0006\u0010l\u001a\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0LJ\u0012\u0010n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\b\u0010o\u001a\u0004\u0018\u00010\bJ\u000e\u0010p\u001a\u00020��2\u0006\u0010p\u001a\u00020\bJ\u0006\u0010q\u001a\u00020\bJ\u0006\u0010r\u001a\u00020GJ\u0006\u0010s\u001a\u00020GJ\u000e\u0010t\u001a\u00020��2\u0006\u0010u\u001a\u00020\u0001J\u000e\u0010v\u001a\u00020��2\u0006\u0010u\u001a\u00020\u0001J\u0006\u0010*\u001a\u00020\bJ\u0006\u0010w\u001a\u00020\bJ\u0006\u0010x\u001a\u00020\bJ\u000e\u0010y\u001a\u00020\b2\u0006\u0010>\u001a\u00020\bJ#\u0010z\u001a\b\u0012\u0004\u0012\u0002H=0f\"\n\b��\u0010=\u0018\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\bH\bJ(\u0010z\u001a\b\u0012\u0004\u0012\u0002H=0f\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0LJ\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007J\u0006\u0010{\u001a\u00020[J\u0006\u0010|\u001a\u00020\bJ\u0010\u0010}\u001a\u0004\u0018\u00010\b2\u0006\u0010>\u001a\u00020\bJ#\u0010~\u001a\b\u0012\u0004\u0012\u0002H=0f\"\n\b��\u0010=\u0018\u0001*\u00020\u00012\u0006\u0010>\u001a\u00020\bH\bJ(\u0010~\u001a\b\u0012\u0004\u0012\u0002H=0f\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b2\f\u0010K\u001a\b\u0012\u0004\u0012\u0002H=0LJ\u0018\u0010\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0\u0007J\u0014\u00101\u001a\b\u0012\u0004\u0012\u00020\b0!2\u0006\u0010>\u001a\u00020\bJ\t\u0010\u0001\u001a\u0004\u0018\u00010\bJ\u001d\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020\b2\t\b\u0002\u0010\u0001\u001a\u00020[H\u0007J\u001d\u0010\u0001\u001a\u00020��2\u0006\u0010a\u001a\u00020\b2\n\b\u0002\u0010x\u001a\u0004\u0018\u00010\bH\u0007J+\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\b2\u0017\b\u0002\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007H\u0007J\u0013\u0010\u0001\u001a\f 6*\u0005\u0018\u00010\u00010\u0001H\u0002J\u0010\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020OJ\u0010\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\rJ\u0010\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020\bJ\r\u0010\u0001\u001a\b\u0012\u0002\b\u0003\u0018\u00010jJ\t\u0010\u0001\u001a\u0004\u0018\u00010OJ\t\u0010\u0001\u001a\u0004\u0018\u00010\bJ\u0007\u0010\u0001\u001a\u00020\bJ&\u0010\u0001\u001a\u00020A2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010\\\u001a\u00020\b2\n\b\u0002\u0010\u0001\u001a\u00030\u0001H\u0007J\u001c\u0010\u0001\u001a\u0004\u0018\u0001H=\"\u0004\b��\u0010=2\u0006\u0010>\u001a\u00020\b¢\u0006\u0002\u0010?J\u0019\u0010\u0001\u001a\u00020A2\u0006\u0010>\u001a\u00020\b2\b\u0010B\u001a\u0004\u0018\u00010\u0001J\u0015\u0010\u0001\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007J\u0007\u0010\u0001\u001a\u00020[J\u0011\u0010\u0001\u001a\u00020��2\b\u0010\u0001\u001a\u00030\u0001J\u0010\u0010\u0001\u001a\u00020��2\u0007\u0010\u0001\u001a\u00020[J\u0013\u0010\u0001\u001a\u0005\u0018\u00010\u00012\u0007\u0010\u0001\u001a\u00020\bJ\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010!J\u0017\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010!2\u0007\u0010\u0001\u001a\u00020\bJ\u0007\u0010\u0001\u001a\u00020\bJ\t\u0010\u0001\u001a\u0004\u0018\u00010\bR \u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u0007X\u0004¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0011\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b8@@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u001fR-\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0\u00078BX\u0002¢\u0006\f\n\u0004\b#\u0010\u0011\u001a\u0004\b\"\u0010\u000bR&\u0010%\u001a\u00020$2\u0006\u0010\u001b\u001a\u00020$8@@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R&\u0010*\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\b8@@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b+\u0010\u0014\"\u0004\b,\u0010\u001fR>\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00072\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00078@@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b.\u0010\u000b\"\u0004\b/\u00100R-\u00101\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0!0\u00078BX\u0002¢\u0006\f\n\u0004\b3\u0010\u0011\u001a\u0004\b2\u0010\u000bR\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0004¢\u0006\u0002\n��RB\u00107\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010505042\u0014\u0010\u001b\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010505048@@@X\u000e¢\u0006\u000e\n��\u001a\u0004\b8\u00109\"\u0004\b:\u0010;¨\u0006 \u0001"}, m373d2 = {"Lio/javalin/http/Context;", "", "req", "Ljavax/servlet/http/HttpServletRequest;", "res", "Ljavax/servlet/http/HttpServletResponse;", "appAttributes", "", "", "(Ljavax/servlet/http/HttpServletRequest;Ljavax/servlet/http/HttpServletResponse;Ljava/util/Map;)V", "getAppAttributes$javalin", "()Ljava/util/Map;", "body", "", "getBody", "()[B", "body$delegate", "Lkotlin/Lazy;", "characterEncoding", "getCharacterEncoding", "()Ljava/lang/String;", "characterEncoding$delegate", "cookieStore", "Lio/javalin/http/util/CookieStore;", "getCookieStore", "()Lio/javalin/http/util/CookieStore;", "cookieStore$delegate", "<set-?>", "endpointHandlerPath", "getEndpointHandlerPath$javalin", "setEndpointHandlerPath$javalin", "(Ljava/lang/String;)V", "formParams", "", "getFormParams", "formParams$delegate", "Lio/javalin/http/HandlerType;", "handlerType", "getHandlerType$javalin", "()Lio/javalin/http/HandlerType;", "setHandlerType$javalin", "(Lio/javalin/http/HandlerType;)V", "matchedPath", "getMatchedPath$javalin", "setMatchedPath$javalin", "pathParamMap", "getPathParamMap$javalin", "setPathParamMap$javalin", "(Ljava/util/Map;)V", "queryParams", "getQueryParams", "queryParams$delegate", "Ljava/util/concurrent/atomic/AtomicReference;", "Lio/javalin/http/Result;", "kotlin.jvm.PlatformType", "resultReference", "getResultReference$javalin", "()Ljava/util/concurrent/atomic/AtomicReference;", "setResultReference$javalin", "(Ljava/util/concurrent/atomic/AtomicReference;)V", "appAttribute", "T", Action.KEY_ATTRIBUTE, "(Ljava/lang/String;)Ljava/lang/Object;", "attribute", "", "value", "attributeMap", "basicAuthCredentials", "Lio/javalin/core/security/BasicAuthCredentials;", "basicAuthCredentialsExist", "", "bodyAsBytes", "bodyAsClass", "()Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "bodyAsInputStream", "Ljava/io/InputStream;", "bodyStreamAsClass", "bodyValidator", "Lio/javalin/core/validation/BodyValidator;", "cachedSessionAttribute", "cachedSessionAttributeOrCompute", Callback.METHOD_NAME, "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "clearCookieStore", "consumeSessionAttribute", "contentLength", "", "contentType", "Lio/javalin/http/ContentType;", "contextPath", "cookie", "Lio/javalin/http/Cookie;", "name", "maxAge", "cookieMap", "formParam", "formParamAsClass", "Lio/javalin/core/validation/Validator;", "formParamMap", "fullUrl", "future", "Ljava/util/concurrent/CompletableFuture;", "Ljava/util/function/Consumer;", "header", "headerAsClass", "headerMap", "host", "html", "ip", "isMultipart", "isMultipartFormData", "json", "obj", "jsonStream", EJBInvokerJob.EJB_METHOD_KEY, "path", "pathParam", "pathParamAsClass", "port", "protocol", "queryParam", "queryParamAsClass", "queryParamMap", "queryString", RedirectProtocolHandler.NAME, "location", "httpStatusCode", "removeCookie", "render", "filePath", "model", "responseCharset", "Ljava/nio/charset/Charset;", "result", "resultStream", "resultBytes", "resultString", "resultFuture", "scheme", "seekableStream", "inputStream", "size", "", "sessionAttribute", "sessionAttributeMap", "status", "httpCode", "Lio/javalin/http/HttpCode;", "statusCode", "uploadedFile", "Lio/javalin/http/UploadedFile;", "fileName", "uploadedFiles", "url", "userAgent", "javalin"})
/* renamed from: io.javalin.http.Context */
/* loaded from: grasscutter.jar:io/javalin/http/Context.class */
public class Context {
    @JvmField
    @NotNull
    public final HttpServletRequest req;
    @JvmField
    @NotNull
    public final HttpServletResponse res;
    @NotNull
    private final Map<String, Object> appAttributes;
    @NotNull
    private String matchedPath;
    @NotNull
    private String endpointHandlerPath;
    @NotNull
    private Map<String, String> pathParamMap;
    @NotNull
    private HandlerType handlerType;
    @NotNull
    private AtomicReference<Result> resultReference;
    @NotNull
    private final Lazy cookieStore$delegate;
    @NotNull
    private final Lazy characterEncoding$delegate;
    @NotNull
    private final Lazy body$delegate;
    @NotNull
    private final Lazy formParams$delegate;
    @NotNull
    private final Lazy queryParams$delegate;

    @JvmOverloads
    public final void seekableStream(@NotNull InputStream inputStream, @NotNull String contentType) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        seekableStream$default(this, inputStream, contentType, 0, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final Context future(@NotNull CompletableFuture<?> completableFuture) {
        Intrinsics.checkNotNullParameter(completableFuture, "future");
        return future$default(this, completableFuture, null, 2, null);
    }

    @JvmOverloads
    public final void redirect(@NotNull String location) {
        Intrinsics.checkNotNullParameter(location, "location");
        redirect$default(this, location, 0, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Context cookie(@NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return cookie$default(this, name, value, 0, 4, null);
    }

    @JvmOverloads
    @NotNull
    public final Context removeCookie(@NotNull String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return removeCookie$default(this, name, null, 2, null);
    }

    @JvmOverloads
    @NotNull
    public final Context render(@NotNull String filePath) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        return render$default(this, filePath, null, 2, null);
    }

    public Context(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        Intrinsics.checkNotNullParameter(map, "appAttributes");
        this.req = req;
        this.res = res;
        this.appAttributes = map;
        this.matchedPath = "";
        this.endpointHandlerPath = "";
        this.pathParamMap = MapsKt.emptyMap();
        this.handlerType = HandlerType.BEFORE;
        this.resultReference = new AtomicReference<>(new Result(null, null, null, 7, null));
        this.cookieStore$delegate = LazyKt.lazy(new Function0<CookieStore>(this) { // from class: io.javalin.http.Context$cookieStore$2
            final /* synthetic */ Context this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final CookieStore invoke() {
                return new CookieStore(JsonMapperKt.jsonMapper(this.this$0), this.this$0.cookie(CookieStore.Companion.getCOOKIE_NAME()));
            }
        });
        this.characterEncoding$delegate = LazyKt.lazy(new Function0<String>(this) { // from class: io.javalin.http.Context$characterEncoding$2
            final /* synthetic */ Context this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String requestCharset = ContextUtil.INSTANCE.getRequestCharset(this.this$0);
                return requestCharset == null ? "UTF-8" : requestCharset;
            }
        });
        this.body$delegate = LazyKt.lazy(new Function0<byte[]>(this) { // from class: io.javalin.http.Context$body$2
            final /* synthetic */ Context this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final byte[] invoke() {
                ContextUtil.INSTANCE.throwPayloadTooLargeIfPayloadTooLarge(this.this$0);
                ServletInputStream inputStream = this.this$0.req.getInputStream();
                Intrinsics.checkNotNullExpressionValue(inputStream, "req.inputStream");
                return IOStreams.readBytes(inputStream);
            }
        });
        this.formParams$delegate = LazyKt.lazy(new Function0<Map<String, ? extends List<? extends String>>>(this) { // from class: io.javalin.http.Context$formParams$2
            final /* synthetic */ Context this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.util.Map<java.lang.String, java.util.List<java.lang.String>>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends List<? extends String>> invoke() {
                return this.this$0.isMultipartFormData() ? MultipartUtil.INSTANCE.getFieldMap(this.this$0.req) : ContextUtil.INSTANCE.splitKeyValueStringAndGroupByKey(this.this$0.body(), this.this$0.getCharacterEncoding());
            }
        });
        this.queryParams$delegate = LazyKt.lazy(new Function0<Map<String, ? extends List<? extends String>>>(this) { // from class: io.javalin.http.Context$queryParams$2
            final /* synthetic */ Context this$0;

            /* access modifiers changed from: package-private */
            {
                this.this$0 = $receiver;
            }

            /* Return type fixed from 'java.util.Map<java.lang.String, java.util.List<java.lang.String>>' to match base method */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Map<String, ? extends List<? extends String>> invoke() {
                ContextUtil contextUtil = ContextUtil.INSTANCE;
                String queryString = this.this$0.queryString();
                return contextUtil.splitKeyValueStringAndGroupByKey(queryString == null ? "" : queryString, this.this$0.getCharacterEncoding());
            }
        });
    }

    public /* synthetic */ Context(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpServletRequest, httpServletResponse, (i & 4) != 0 ? MapsKt.emptyMap() : map);
    }

    @NotNull
    public final Map<String, Object> getAppAttributes$javalin() {
        return this.appAttributes;
    }

    public final /* synthetic */ String getMatchedPath$javalin() {
        return this.matchedPath;
    }

    public final /* synthetic */ void setMatchedPath$javalin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.matchedPath = str;
    }

    public final /* synthetic */ String getEndpointHandlerPath$javalin() {
        return this.endpointHandlerPath;
    }

    public final /* synthetic */ void setEndpointHandlerPath$javalin(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.endpointHandlerPath = str;
    }

    public final /* synthetic */ Map getPathParamMap$javalin() {
        return this.pathParamMap;
    }

    public final /* synthetic */ void setPathParamMap$javalin(Map map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pathParamMap = map;
    }

    public final /* synthetic */ HandlerType getHandlerType$javalin() {
        return this.handlerType;
    }

    public final /* synthetic */ void setHandlerType$javalin(HandlerType handlerType) {
        Intrinsics.checkNotNullParameter(handlerType, "<set-?>");
        this.handlerType = handlerType;
    }

    public final /* synthetic */ AtomicReference getResultReference$javalin() {
        return this.resultReference;
    }

    public final /* synthetic */ void setResultReference$javalin(AtomicReference atomicReference) {
        Intrinsics.checkNotNullParameter(atomicReference, "<set-?>");
        this.resultReference = atomicReference;
    }

    private final CookieStore getCookieStore() {
        return (CookieStore) this.cookieStore$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getCharacterEncoding() {
        return (String) this.characterEncoding$delegate.getValue();
    }

    private final byte[] getBody() {
        return (byte[]) this.body$delegate.getValue();
    }

    @NotNull
    public final HandlerType handlerType() {
        return this.handlerType;
    }

    public final <T> T appAttribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (T) this.appAttributes.get(key);
    }

    public final <T> T cookieStore(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (T) getCookieStore().get(key);
    }

    public final void cookieStore(@NotNull String key, @NotNull Object value) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(value, "value");
        getCookieStore().set(key, value);
        cookie(getCookieStore().serializeToCookie());
    }

    public final void clearCookieStore() {
        getCookieStore().clear();
        removeCookie$default(this, CookieStore.Companion.getCOOKIE_NAME(), null, 2, null);
    }

    @NotNull
    public final String matchedPath() {
        return this.matchedPath;
    }

    @NotNull
    public final String endpointHandlerPath() {
        if (this.handlerType != HandlerType.BEFORE) {
            return this.endpointHandlerPath;
        }
        throw new IllegalStateException("Cannot access the endpoint handler path in a 'BEFORE' handler");
    }

    @NotNull
    public final String body() {
        byte[] bodyAsBytes = bodyAsBytes();
        Charset forName = Charset.forName(getCharacterEncoding());
        Intrinsics.checkNotNullExpressionValue(forName, "forName(characterEncoding)");
        return new String(bodyAsBytes, forName);
    }

    @NotNull
    public final byte[] bodyAsBytes() {
        return getBody();
    }

    public final <T> T bodyAsClass(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return (T) JsonMapperKt.jsonMapper(this).fromJsonString(body(), cls);
    }

    public final /* synthetic */ <T> T bodyAsClass() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) bodyAsClass(Object.class);
    }

    public final <T> T bodyStreamAsClass(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return (T) JsonMapperKt.jsonMapper(this).fromJsonStream(this.req.getInputStream(), cls);
    }

    public final /* synthetic */ <T> T bodyStreamAsClass() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) bodyStreamAsClass(Object.class);
    }

    @NotNull
    public final InputStream bodyAsInputStream() {
        ServletInputStream inputStream = this.req.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "req.inputStream");
        return inputStream;
    }

    @NotNull
    public final <T> BodyValidator<T> bodyValidator(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return new BodyValidator<>(body(), cls, JsonMapperKt.jsonMapper(this));
    }

    public final /* synthetic */ <T> BodyValidator<T> bodyValidator() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return bodyValidator(Object.class);
    }

    @Nullable
    public final UploadedFile uploadedFile(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return (UploadedFile) CollectionsKt.firstOrNull((List<? extends Object>) uploadedFiles(fileName));
    }

    @NotNull
    public final List<UploadedFile> uploadedFiles(@NotNull String fileName) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        return isMultipartFormData() ? MultipartUtil.INSTANCE.getUploadedFiles(this.req, fileName) : CollectionsKt.emptyList();
    }

    @NotNull
    public final List<UploadedFile> uploadedFiles() {
        return isMultipartFormData() ? MultipartUtil.INSTANCE.getUploadedFiles(this.req) : CollectionsKt.emptyList();
    }

    @Nullable
    public final String formParam(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (String) CollectionsKt.firstOrNull((List<? extends Object>) formParams(key));
    }

    @NotNull
    public final <T> Validator<T> formParamAsClass(@NotNull String key, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return Validator.Companion.create(cls, formParam(key), key);
    }

    public final /* synthetic */ <T> Validator<T> formParamAsClass(String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.reifiedOperationMarker(4, "T");
        return formParamAsClass(key, Object.class);
    }

    @NotNull
    public final List<String> formParams(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        List<String> list = formParamMap().get(key);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Map<String, List<String>> getFormParams() {
        return (Map) this.formParams$delegate.getValue();
    }

    @NotNull
    public final Map<String, List<String>> formParamMap() {
        return getFormParams();
    }

    @NotNull
    public final String pathParam(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return ContextUtil.INSTANCE.pathParamOrThrow(this.pathParamMap, key, this.matchedPath);
    }

    @NotNull
    public final <T> Validator<T> pathParamAsClass(@NotNull String key, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return Validator.Companion.create(cls, pathParam(key), key);
    }

    public final /* synthetic */ <T> Validator<T> pathParamAsClass(String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.reifiedOperationMarker(4, "T");
        return pathParamAsClass(key, Object.class);
    }

    @NotNull
    public final Map<String, String> pathParamMap() {
        Map<String, String> unmodifiableMap = Collections.unmodifiableMap(this.pathParamMap);
        Intrinsics.checkNotNullExpressionValue(unmodifiableMap, "unmodifiableMap(pathParamMap)");
        return unmodifiableMap;
    }

    public final boolean basicAuthCredentialsExist() {
        return ContextUtil.INSTANCE.hasBasicAuthCredentials(header("Authorization"));
    }

    @NotNull
    public final BasicAuthCredentials basicAuthCredentials() {
        return ContextUtil.INSTANCE.getBasicAuthCredentials(header("Authorization"));
    }

    public final void attribute(@NotNull String key, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        this.req.setAttribute(key, value);
    }

    @Nullable
    public final <T> T attribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        T t = (T) this.req.getAttribute(key);
        if (t == null) {
        }
        return t;
    }

    @NotNull
    public final Map<String, Object> attributeMap() {
        Enumeration<String> attributeNames = this.req.getAttributeNames();
        Intrinsics.checkNotNullExpressionValue(attributeNames, "req.attributeNames");
        Sequence $this$associateWith$iv = SequencesKt.asSequence(CollectionsKt.iterator(attributeNames));
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$associateWith$iv) {
            result$iv.put(element$iv$iv, attribute((String) element$iv$iv));
        }
        return result$iv;
    }

    public final int contentLength() {
        return this.req.getContentLength();
    }

    @Nullable
    public final String contentType() {
        return this.req.getContentType();
    }

    @Nullable
    public final String cookie(@NotNull String name) {
        Cookie cookie;
        Intrinsics.checkNotNullParameter(name, "name");
        Cookie[] cookies = this.req.getCookies();
        if (cookies == null) {
            return null;
        }
        int length = cookies.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                cookie = null;
                break;
            }
            Cookie it = cookies[i];
            if (Intrinsics.areEqual(name, it.getName())) {
                cookie = it;
                break;
            }
            i++;
        }
        if (cookie == null) {
            return null;
        }
        return cookie.getValue();
    }

    @NotNull
    public final Map<String, String> cookieMap() {
        Map map;
        Cookie[] cookies = this.req.getCookies();
        if (cookies == null) {
            map = null;
        } else {
            Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(cookies.length), 16));
            for (Cookie cookie : cookies) {
                Pair pair = Tuples.m366to(cookie.getName(), cookie.getValue());
                destination$iv$iv.put(pair.getFirst(), pair.getSecond());
            }
            map = destination$iv$iv;
        }
        return map == null ? MapsKt.emptyMap() : map;
    }

    @Nullable
    public final String header(@NotNull String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        return this.req.getHeader(header);
    }

    @NotNull
    public final <T> Validator<T> headerAsClass(@NotNull String header, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return Validator.Companion.create(cls, header(header), header);
    }

    public final /* synthetic */ <T> Validator<T> headerAsClass(String header) {
        Intrinsics.checkNotNullParameter(header, "header");
        Intrinsics.reifiedOperationMarker(4, "T");
        return headerAsClass(header, Object.class);
    }

    @NotNull
    public final Map<String, String> headerMap() {
        Enumeration<String> headerNames = this.req.getHeaderNames();
        Intrinsics.checkNotNullExpressionValue(headerNames, "req.headerNames");
        Sequence $this$associateWith$iv = SequencesKt.asSequence(CollectionsKt.iterator(headerNames));
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$associateWith$iv) {
            LinkedHashMap linkedHashMap = result$iv;
            String header = header((String) element$iv$iv);
            Intrinsics.checkNotNull(header);
            linkedHashMap.put(element$iv$iv, header);
        }
        return result$iv;
    }

    @Nullable
    public final String host() {
        return ContextResolverKt.contextResolver(this).host.invoke(this);
    }

    @NotNull
    /* renamed from: ip */
    public final String m1185ip() {
        return ContextResolverKt.contextResolver(this).f938ip.invoke(this);
    }

    public final boolean isMultipart() {
        String header = header("Content-Type");
        if (header == null) {
            return false;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
        String lowerCase = header.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase != null && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "multipart/", false, 2, (Object) null);
    }

    public final boolean isMultipartFormData() {
        String header = header("Content-Type");
        if (header == null) {
            return false;
        }
        Locale locale = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue(locale, Logger.ROOT_LOGGER_NAME);
        String lowerCase = header.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        return lowerCase != null && StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) ContentType.FORM_DATA, false, 2, (Object) null);
    }

    @NotNull
    public final String method() {
        String method = this.req.getMethod();
        Intrinsics.checkNotNullExpressionValue(method, ClassicConstants.REQUEST_METHOD);
        return method;
    }

    @NotNull
    public final String path() {
        String requestURI = this.req.getRequestURI();
        Intrinsics.checkNotNullExpressionValue(requestURI, ClassicConstants.REQUEST_REQUEST_URI);
        return requestURI;
    }

    public final int port() {
        return this.req.getServerPort();
    }

    @NotNull
    public final String protocol() {
        String protocol = this.req.getProtocol();
        Intrinsics.checkNotNullExpressionValue(protocol, "req.protocol");
        return protocol;
    }

    @Nullable
    public final String queryParam(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (String) CollectionsKt.firstOrNull((List<? extends Object>) queryParams(key));
    }

    @NotNull
    public final <T> Validator<T> queryParamAsClass(@NotNull String key, @NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return Validator.Companion.create(cls, queryParam(key), key);
    }

    public final /* synthetic */ <T> Validator<T> queryParamAsClass(String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.reifiedOperationMarker(4, "T");
        return queryParamAsClass(key, Object.class);
    }

    @NotNull
    public final List<String> queryParams(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        List<String> list = queryParamMap().get(key);
        return list == null ? CollectionsKt.emptyList() : list;
    }

    private final Map<String, List<String>> getQueryParams() {
        return (Map) this.queryParams$delegate.getValue();
    }

    @NotNull
    public final Map<String, List<String>> queryParamMap() {
        return getQueryParams();
    }

    @Nullable
    public final String queryString() {
        return this.req.getQueryString();
    }

    @NotNull
    public final String scheme() {
        return ContextResolverKt.contextResolver(this).scheme.invoke(this);
    }

    public final void sessionAttribute(@NotNull String key, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        this.req.getSession().setAttribute(key, value);
    }

    @Nullable
    public final <T> T sessionAttribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        HttpSession session = this.req.getSession(false);
        T t = session == null ? null : (T) session.getAttribute(key);
        if (t == null) {
        }
        return t;
    }

    @Nullable
    public final <T> T consumeSessionAttribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        T t = (T) sessionAttribute(key);
        sessionAttribute(key, null);
        return t;
    }

    public final void cachedSessionAttribute(@NotNull String key, @Nullable Object value) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        ContextUtil.INSTANCE.cacheAndSetSessionAttribute(key, value, this.req);
    }

    @Nullable
    public final <T> T cachedSessionAttribute(@NotNull String key) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        return (T) ContextUtil.INSTANCE.getCachedRequestAttributeOrSessionAttribute(key, this.req);
    }

    @Nullable
    public final <T> T cachedSessionAttributeOrCompute(@NotNull String key, @NotNull Function1<? super Context, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(key, Action.KEY_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(function1, Callback.METHOD_NAME);
        return (T) ContextUtil.INSTANCE.cachedSessionAttributeOrCompute(function1, key, this);
    }

    @NotNull
    public final Map<String, Object> sessionAttributeMap() {
        Enumeration<String> attributeNames = this.req.getSession().getAttributeNames();
        Intrinsics.checkNotNullExpressionValue(attributeNames, "req.session.attributeNames");
        Sequence $this$associateWith$iv = SequencesKt.asSequence(CollectionsKt.iterator(attributeNames));
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Object element$iv$iv : $this$associateWith$iv) {
            result$iv.put(element$iv$iv, sessionAttribute((String) element$iv$iv));
        }
        return result$iv;
    }

    @NotNull
    public final String url() {
        return ContextResolverKt.contextResolver(this).url.invoke(this);
    }

    @NotNull
    public final String fullUrl() {
        return ContextResolverKt.contextResolver(this).fullUrl.invoke(this);
    }

    @NotNull
    public final String contextPath() {
        String contextPath = this.req.getContextPath();
        Intrinsics.checkNotNullExpressionValue(contextPath, "req.contextPath");
        return contextPath;
    }

    @Nullable
    public final String userAgent() {
        return this.req.getHeader("User-Agent");
    }

    private final Charset responseCharset() {
        Charset charset;
        try {
            charset = Charset.forName(this.res.getCharacterEncoding());
        } catch (Exception e) {
            charset = Charset.defaultCharset();
        }
        return charset;
    }

    @NotNull
    public final Context result(@NotNull String resultString) {
        Intrinsics.checkNotNullParameter(resultString, "resultString");
        Charset responseCharset = responseCharset();
        Intrinsics.checkNotNullExpressionValue(responseCharset, "responseCharset()");
        byte[] bytes = resultString.getBytes(responseCharset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        return result(new ByteArrayInputStream(bytes));
    }

    @NotNull
    public final Context result(@NotNull byte[] resultBytes) {
        Intrinsics.checkNotNullParameter(resultBytes, "resultBytes");
        return result(new ByteArrayInputStream(resultBytes));
    }

    @Nullable
    public final String resultString() {
        ContextUtil contextUtil = ContextUtil.INSTANCE;
        InputStream resultStream = resultStream();
        Charset responseCharset = responseCharset();
        Intrinsics.checkNotNullExpressionValue(responseCharset, "responseCharset()");
        return contextUtil.readAndResetStreamIfPossible(resultStream, responseCharset);
    }

    @NotNull
    public final Context result(@NotNull InputStream resultStream) {
        Unit unit;
        Intrinsics.checkNotNullParameter(resultStream, "resultStream");
        try {
            Result.Companion companion = Result.Companion;
            InputStream resultStream2 = resultStream();
            if (resultStream2 == null) {
                unit = null;
            } else {
                resultStream2.close();
                unit = Unit.INSTANCE;
            }
            Result.m7059constructorimpl(unit);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            Result.m7059constructorimpl(ResultKt.createFailure(th));
        }
        CompletableFuture completedFuture = CompletableFuture.completedFuture(resultStream);
        Intrinsics.checkNotNullExpressionValue(completedFuture, "completedFuture(resultStream)");
        return future$default(this, completedFuture, null, 2, null);
    }

    public static /* synthetic */ void seekableStream$default(Context context, InputStream inputStream, String str, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: seekableStream");
        }
        if ((i & 4) != 0) {
            j = (long) inputStream.available();
        }
        context.seekableStream(inputStream, str, j);
    }

    @JvmOverloads
    public final void seekableStream(@NotNull InputStream inputStream, @NotNull String contentType, long size) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        SeekableWriter.INSTANCE.write(this, inputStream, contentType, size);
    }

    @Nullable
    public final InputStream resultStream() {
        Result result = this.resultReference.get();
        CompletableFuture it = result.getFuture();
        CompletableFuture completableFuture = it.isDone() ? it : null;
        InputStream inputStream = (InputStream) (completableFuture == null ? null : completableFuture.get());
        return inputStream == null ? result.getPrevious() : inputStream;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.javalin.http.Context */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context future$default(Context context, CompletableFuture completableFuture, Consumer consumer, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: future");
        }
        if ((i & 2) != 0) {
            consumer = null;
        }
        return context.future(completableFuture, consumer);
    }

    @JvmOverloads
    @NotNull
    public final Context future(@NotNull CompletableFuture<?> completableFuture, @Nullable Consumer<Object> consumer) {
        Intrinsics.checkNotNullParameter(completableFuture, "future");
        this.resultReference.updateAndGet((v2) -> {
            return m5807future$lambda9(r1, r2, v2);
        });
        return this;
    }

    /* renamed from: future$lambda-9  reason: not valid java name */
    private static final Result m5807future$lambda9(CompletableFuture $future, Consumer $callback, Result oldResult) {
        Intrinsics.checkNotNullParameter($future, "$future");
        oldResult.getFuture().cancel(true);
        return new Result(oldResult.getPrevious(), $future, $callback);
    }

    @Nullable
    public final CompletableFuture<?> resultFuture() {
        return this.resultReference.get().getFuture();
    }

    @NotNull
    public final Context contentType(@NotNull String contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        this.res.setContentType(contentType);
        return this;
    }

    @NotNull
    public final Context contentType(@NotNull ContentType contentType) {
        Intrinsics.checkNotNullParameter(contentType, "contentType");
        return contentType(contentType.getMimeType());
    }

    @NotNull
    public final Context header(@NotNull String name, @NotNull String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.res.setHeader(name, value);
        return this;
    }

    public static /* synthetic */ void redirect$default(Context context, String str, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: redirect");
        }
        if ((i2 & 2) != 0) {
            i = 302;
        }
        context.redirect(str, i);
    }

    @JvmOverloads
    public final void redirect(@NotNull String location, int httpStatusCode) {
        Intrinsics.checkNotNullParameter(location, "location");
        this.res.setHeader("Location", location);
        status(httpStatusCode);
        if (this.handlerType == HandlerType.BEFORE) {
            throw new RedirectResponse(httpStatusCode, null, null, 6, null);
        }
    }

    @NotNull
    public final Context status(@NotNull HttpCode httpCode) {
        Intrinsics.checkNotNullParameter(httpCode, "httpCode");
        return status(httpCode.getStatus());
    }

    @NotNull
    public final Context status(int statusCode) {
        this.res.setStatus(statusCode);
        return this;
    }

    public final int status() {
        return this.res.getStatus();
    }

    @JvmOverloads
    @NotNull
    public final Context cookie(@NotNull String name, @NotNull String value, int maxAge) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        return cookie(new Cookie(name, value, null, maxAge, false, 0, false, null, null, null, StatusCode.SERVICE_RESTART, null));
    }

    public static /* synthetic */ Context cookie$default(Context context, String str, String str2, int i, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: cookie");
        }
        if ((i2 & 4) != 0) {
            i = -1;
        }
        return context.cookie(str, str2, i);
    }

    @NotNull
    public final Context cookie(@NotNull Cookie cookie) {
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        CookieKt.setJavalinCookie(this.res, cookie);
        return this;
    }

    public static /* synthetic */ Context removeCookie$default(Context context, String str, String str2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeCookie");
        }
        if ((i & 2) != 0) {
            str2 = "/";
        }
        return context.removeCookie(str, str2);
    }

    @JvmOverloads
    @NotNull
    public final Context removeCookie(@NotNull String name, @Nullable String path) {
        Intrinsics.checkNotNullParameter(name, "name");
        HttpServletResponse httpServletResponse = this.res;
        Cookie $this$removeCookie_u24lambda_u2d10 = new Cookie(name, "");
        $this$removeCookie_u24lambda_u2d10.setPath(path);
        $this$removeCookie_u24lambda_u2d10.setMaxAge(0);
        Unit unit = Unit.INSTANCE;
        httpServletResponse.addCookie($this$removeCookie_u24lambda_u2d10);
        return this;
    }

    @NotNull
    public final Context html(@NotNull String html) {
        Intrinsics.checkNotNullParameter(html, "html");
        return contentType(ContentType.TEXT_HTML).result(html);
    }

    @NotNull
    public final Context json(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Context contentType = contentType(ContentType.APPLICATION_JSON);
        String jsonString = JsonMapperKt.jsonMapper(this).toJsonString(obj);
        Intrinsics.checkNotNullExpressionValue(jsonString, "jsonMapper().toJsonString(obj)");
        return contentType.result(jsonString);
    }

    @NotNull
    public final Context jsonStream(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "obj");
        Context contentType = contentType(ContentType.APPLICATION_JSON);
        InputStream jsonStream = JsonMapperKt.jsonMapper(this).toJsonStream(obj);
        Intrinsics.checkNotNullExpressionValue(jsonStream, "jsonMapper().toJsonStream(obj)");
        return contentType.result(jsonStream);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: io.javalin.http.Context */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Context render$default(Context context, String str, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: render");
        }
        if ((i & 2) != 0) {
            map = new LinkedHashMap();
        }
        return context.render(str, map);
    }

    @JvmOverloads
    @NotNull
    public final Context render(@NotNull String filePath, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(filePath, "filePath");
        Intrinsics.checkNotNullParameter(map, "model");
        return html(JavalinRenderer.INSTANCE.renderBasedOnExtension(filePath, map, this));
    }
}
