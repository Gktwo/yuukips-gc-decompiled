package p013io.javalin.http;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.eclipse.jetty.http.HttpStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.console.Printer;
import org.quartz.jobs.p027ee.mail.SendMailJob;

/* compiled from: HttpCode.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\b\n��\n\u0002\u0010\u000e\n\u0002\bB\b\u0001\u0018�� F2\b\u0012\u0004\u0012\u00020��0\u0001:\u0001FB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n��\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\nj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bE¨\u0006G"}, m373d2 = {"Lio/javalin/http/HttpCode;", "", "status", "", SendMailJob.PROP_MESSAGE, "", "(Ljava/lang/String;IILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getStatus", "()I", Printer.TO_STRING, "CONTINUE", "SWITCHING_PROTOCOLS", "PROCESSING", "OK", "CREATED", "ACCEPTED", "NON_AUTHORITATIVE_INFORMATION", "NO_CONTENT", "RESET_CONTENT", "PARTIAL_CONTENT", "MULTI_STATUS", "MULTIPLE_CHOICES", "MOVED_PERMANENTLY", "FOUND", "SEE_OTHER", "NOT_MODIFIED", "USE_PROXY", "TEMPORARY_REDIRECT", "PERMANENT_REDIRECT", "BAD_REQUEST", "UNAUTHORIZED", "PAYMENT_REQUIRED", "FORBIDDEN", "NOT_FOUND", "METHOD_NOT_ALLOWED", "NOT_ACCEPTABLE", "PROXY_AUTHENTICATION_REQUIRED", "REQUEST_TIMEOUT", "CONFLICT", "GONE", "LENGTH_REQUIRED", "PRECONDITION_FAILED", "PAYLOAD_TOO_LARGE", "URI_TOO_LONG", "UNSUPPORTED_MEDIA_TYPE", "RANGE_NOT_SATISFIABLE", "EXPECTATION_FAILED", "IM_A_TEAPOT", "ENHANCE_YOUR_CALM", "MISDIRECTED_REQUEST", "UNPROCESSABLE_ENTITY", "LOCKED", "FAILED_DEPENDENCY", "UPGRADE_REQUIRED", "PRECONDITION_REQUIRED", "TOO_MANY_REQUESTS", "REQUEST_HEADER_FIELDS_TOO_LARGE", "UNAVAILABLE_FOR_LEGAL_REASONS", "INTERNAL_SERVER_ERROR", "NOT_IMPLEMENTED", "BAD_GATEWAY", "SERVICE_UNAVAILABLE", "GATEWAY_TIMEOUT", "HTTP_VERSION_NOT_SUPPORTED", "INSUFFICIENT_STORAGE", "LOOP_DETECTED", "NOT_EXTENDED", "NETWORK_AUTHENTICATION_REQUIRED", "Companion", "javalin"})
/* renamed from: io.javalin.http.HttpCode */
/* loaded from: grasscutter.jar:io/javalin/http/HttpCode.class */
public enum HttpCode {
    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    OK(200, "OK"),
    CREATED(201, "Created"),
    ACCEPTED(202, "Accepted"),
    NON_AUTHORITATIVE_INFORMATION(203, "Non Authoritative Information"),
    NO_CONTENT(204, "No Content"),
    RESET_CONTENT(205, "Reset Content"),
    PARTIAL_CONTENT(206, "Partial Content"),
    MULTI_STATUS(207, "Multi-Status"),
    MULTIPLE_CHOICES(300, "Multiple Choices"),
    MOVED_PERMANENTLY(301, "Moved Permanently"),
    FOUND(302, "Found"),
    SEE_OTHER(303, "See Other"),
    NOT_MODIFIED(304, "Not Modified"),
    USE_PROXY(305, "Use Proxy"),
    TEMPORARY_REDIRECT(307, "Temporary Redirect"),
    PERMANENT_REDIRECT(308, "Permanent Redirect"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    PAYMENT_REQUIRED(402, "Payment Required"),
    FORBIDDEN(403, "Forbidden"),
    NOT_FOUND(404, "Not Found"),
    METHOD_NOT_ALLOWED(405, "Method Not Allowed"),
    NOT_ACCEPTABLE(406, "Not Acceptable"),
    PROXY_AUTHENTICATION_REQUIRED(407, "Proxy Authentication Required"),
    REQUEST_TIMEOUT(408, "Request Timeout"),
    CONFLICT(409, "Conflict"),
    GONE(410, "Gone"),
    LENGTH_REQUIRED(411, "Length Required"),
    PRECONDITION_FAILED(412, "Precondition Failed"),
    PAYLOAD_TOO_LARGE(413, "Payload Too Large"),
    URI_TOO_LONG(414, "URI Too Long"),
    UNSUPPORTED_MEDIA_TYPE(415, "Unsupported Media Type"),
    RANGE_NOT_SATISFIABLE(416, "Range Not Satisfiable"),
    EXPECTATION_FAILED(417, "Expectation Failed"),
    IM_A_TEAPOT(HttpStatus.IM_A_TEAPOT_418, "I'm a Teapot"),
    ENHANCE_YOUR_CALM(420, "Enhance your Calm"),
    MISDIRECTED_REQUEST(421, "Misdirected Request"),
    UNPROCESSABLE_ENTITY(422, "Unprocessable Entity"),
    LOCKED(423, "Locked"),
    FAILED_DEPENDENCY(424, "Failed Dependency"),
    UPGRADE_REQUIRED(HttpStatus.UPGRADE_REQUIRED_426, "Upgrade Required"),
    PRECONDITION_REQUIRED(HttpStatus.PRECONDITION_REQUIRED_428, "Precondition Required"),
    TOO_MANY_REQUESTS(HttpStatus.TOO_MANY_REQUESTS_429, "Too Many Requests"),
    REQUEST_HEADER_FIELDS_TOO_LARGE(HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE_431, "Request Header Fields Too Large"),
    UNAVAILABLE_FOR_LEGAL_REASONS(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS_451, "Unavailable for Legal Reason"),
    INTERNAL_SERVER_ERROR(500, "Server Error"),
    NOT_IMPLEMENTED(501, "Not Implemented"),
    BAD_GATEWAY(502, "Bad Gateway"),
    SERVICE_UNAVAILABLE(503, "Service Unavailable"),
    GATEWAY_TIMEOUT(504, "Gateway Timeout"),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP Version Not Supported"),
    INSUFFICIENT_STORAGE(507, "Insufficient Storage"),
    LOOP_DETECTED(508, "Loop Detected"),
    NOT_EXTENDED(510, "Not Extended"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "Network Authentication Required");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int status;
    @NotNull
    private final String message;

    HttpCode(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getMessage() {
        return this.message;
    }

    @Override // java.lang.Enum, java.lang.Object
    @NotNull
    public String toString() {
        return this.status + ' ' + this.message;
    }

    /* compiled from: HttpCode.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0018\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\b\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, m373d2 = {"Lio/javalin/http/HttpCode$Companion;", "", "()V", "forStatus", "Lio/javalin/http/HttpCode;", "status", "", "javalin"})
    /* renamed from: io.javalin.http.HttpCode$Companion */
    /* loaded from: grasscutter.jar:io/javalin/http/HttpCode$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @Nullable
        public final HttpCode forStatus(int status) {
            HttpCode[] values = HttpCode.values();
            for (HttpCode it : values) {
                if (it.getStatus() == status) {
                    return it;
                }
            }
            return null;
        }
    }
}
