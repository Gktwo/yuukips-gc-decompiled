package org.eclipse.jetty.server;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import javax.servlet.http.Cookie;
import org.eclipse.jetty.http.HttpFields;
import org.eclipse.jetty.http.QuotedCSV;
import org.eclipse.jetty.http.pathmap.PathMappings;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.RequestLog;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.DateCache;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;
import p001ch.qos.logback.core.rolling.helper.IntegerTokenConverter;

@ManagedObject("Custom format request log")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/CustomRequestLog.class */
public class CustomRequestLog extends ContainerLifeCycle implements RequestLog {
    public static final String DEFAULT_DATE_FORMAT = "dd/MMM/yyyy:HH:mm:ss ZZZ";
    public static final String NCSA_FORMAT = "%{client}a - %u %t \"%r\" %s %O";
    public static final String EXTENDED_NCSA_FORMAT = "%{client}a - %u %t \"%r\" %s %O \"%{Referer}i\" \"%{User-Agent}i\"";
    private final RequestLog.Writer _requestLogWriter;
    private final MethodHandle _logHandle;
    private final String _formatString;
    private transient PathMappings<String> _ignorePathMap;
    private String[] _ignorePaths;
    protected static final Logger LOG = Log.getLogger(CustomRequestLog.class);
    private static final ThreadLocal<StringBuilder> _buffers = ThreadLocal.withInitial(() -> {
        return new StringBuilder(256);
    });

    public CustomRequestLog(RequestLog.Writer writer, String formatString) {
        this._formatString = formatString;
        this._requestLogWriter = writer;
        addBean(this._requestLogWriter);
        try {
            this._logHandle = getLogHandle(formatString);
        } catch (IllegalAccessException | NoSuchMethodException e) {
            throw new IllegalStateException(e);
        }
    }

    public CustomRequestLog(String file) {
        this(file, EXTENDED_NCSA_FORMAT);
    }

    public CustomRequestLog(String file, String format) {
        this(new RequestLogWriter(file), format);
    }

    @ManagedAttribute("The RequestLogWriter")
    public RequestLog.Writer getWriter() {
        return this._requestLogWriter;
    }

    @Override // org.eclipse.jetty.server.RequestLog
    public void log(Request request, Response response) {
        try {
            if (this._ignorePathMap == null || this._ignorePathMap.getMatched(request.getRequestURI()) == null) {
                StringBuilder sb = _buffers.get();
                sb.setLength(0);
                this._logHandle.invoke(sb, request, response);
                this._requestLogWriter.write(sb.toString());
            }
        } catch (Throwable e) {
            LOG.warn(e);
        }
    }

    protected static String getAuthentication(Request request, boolean checkDeferred) {
        Authentication authentication = request.getAuthentication();
        if (checkDeferred && (authentication instanceof Authentication.Deferred)) {
            authentication = ((Authentication.Deferred) authentication).authenticate(request);
        }
        String name = null;
        if (authentication instanceof Authentication.User) {
            name = ((Authentication.User) authentication).getUserIdentity().getUserPrincipal().getName();
        }
        return name;
    }

    public void setIgnorePaths(String[] ignorePaths) {
        this._ignorePaths = ignorePaths;
    }

    public String[] getIgnorePaths() {
        return this._ignorePaths;
    }

    @ManagedAttribute("format string")
    public String getFormatString() {
        return this._formatString;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public synchronized void doStart() throws Exception {
        if (this._ignorePaths == null || this._ignorePaths.length <= 0) {
            this._ignorePathMap = null;
        } else {
            this._ignorePathMap = new PathMappings<>();
            String[] strArr = this._ignorePaths;
            for (String ignorePath : strArr) {
                this._ignorePathMap.put(ignorePath, ignorePath);
            }
        }
        doStart();
    }

    private static void append(StringBuilder buf, String s) {
        if (s == null || s.length() == 0) {
            buf.append('-');
        } else {
            buf.append(s);
        }
    }

    private static void append(String s, StringBuilder buf) {
        append(buf, s);
    }

    private MethodHandle getLogHandle(String formatString) throws NoSuchMethodException, IllegalAccessException {
        MethodHandles.Lookup lookup = MethodHandles.lookup();
        MethodHandle append = lookup.findStatic(CustomRequestLog.class, "append", MethodType.methodType(Void.TYPE, String.class, StringBuilder.class));
        MethodHandle logHandle = lookup.findStatic(CustomRequestLog.class, "logNothing", MethodType.methodType(Void.TYPE, StringBuilder.class, Request.class, Response.class));
        List<Token> tokens = getTokens(formatString);
        Collections.reverse(tokens);
        for (Token t : tokens) {
            if (t.isLiteralString()) {
                logHandle = updateLogHandle(logHandle, append, t.literal);
            } else if (t.isPercentCode()) {
                logHandle = updateLogHandle(logHandle, append, lookup, t.code, t.arg, t.modifiers, t.negated);
            } else {
                throw new IllegalStateException("bad token " + t);
            }
        }
        return logHandle;
    }

    private static List<Token> getTokens(String formatString) {
        Pattern PATTERN = Pattern.compile("^(?:%(?<MOD>!?[0-9,]+)?(?:\\{(?<ARG>[^}]+)})?(?<CODE>(?:(?:ti)|(?:to)|[a-zA-Z%]))|(?<LITERAL>[^%]+))(?<REMAINING>.*)", 40);
        List<Token> tokens = new ArrayList<>();
        String remaining = formatString;
        while (remaining.length() > 0) {
            Matcher m = PATTERN.matcher(remaining);
            if (m.matches()) {
                if (m.group("CODE") != null) {
                    String code = m.group("CODE");
                    String arg = m.group("ARG");
                    String modifierString = m.group("MOD");
                    List<Integer> modifiers = null;
                    boolean negated = false;
                    if (modifierString != null) {
                        if (modifierString.startsWith("!")) {
                            modifierString = modifierString.substring(1);
                            negated = true;
                        }
                        modifiers = (List) new QuotedCSV(modifierString).getValues().stream().map(Integer::parseInt).collect(Collectors.toList());
                    }
                    tokens.add(new Token(code, arg, modifiers, negated));
                } else if (m.group("LITERAL") != null) {
                    tokens.add(new Token(m.group("LITERAL")));
                } else {
                    throw new IllegalStateException("formatString parsing error");
                }
                remaining = m.group("REMAINING");
            } else {
                throw new IllegalArgumentException("Invalid format string");
            }
        }
        return tokens;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/CustomRequestLog$Token.class */
    public static class Token {
        public final String code;
        public final String arg;
        public final List<Integer> modifiers;
        public final boolean negated;
        public final String literal;

        public Token(String code, String arg, List<Integer> modifiers, boolean negated) {
            this.code = code;
            this.arg = arg;
            this.modifiers = modifiers;
            this.negated = negated;
            this.literal = null;
        }

        public Token(String literal) {
            this.code = null;
            this.arg = null;
            this.modifiers = null;
            this.negated = false;
            this.literal = literal;
        }

        public boolean isLiteralString() {
            return this.literal != null;
        }

        public boolean isPercentCode() {
            return this.code != null;
        }
    }

    private static boolean modify(List<Integer> modifiers, Boolean negated, StringBuilder b, Request request, Response response) {
        if (negated.booleanValue()) {
            return !modifiers.contains(Integer.valueOf(response.getStatus()));
        }
        return modifiers.contains(Integer.valueOf(response.getStatus()));
    }

    private MethodHandle updateLogHandle(MethodHandle logHandle, MethodHandle append, String literal) {
        return MethodHandles.foldArguments(logHandle, MethodHandles.dropArguments(MethodHandles.dropArguments(append.bindTo(literal), 1, Request.class), 2, Response.class));
    }

    private MethodHandle updateLogHandle(MethodHandle logHandle, MethodHandle append, MethodHandles.Lookup lookup, String code, String arg, List<Integer> modifiers, boolean negated) throws NoSuchMethodException, IllegalAccessException {
        MethodHandle specificHandle;
        String method;
        String method2;
        String method3;
        String method4;
        String method5;
        String method6;
        String method7;
        MethodType logType = MethodType.methodType(Void.TYPE, StringBuilder.class, Request.class, Response.class);
        MethodType logTypeArg = MethodType.methodType(Void.TYPE, String.class, StringBuilder.class, Request.class, Response.class);
        char c = 65535;
        switch (code.hashCode()) {
            case 37:
                if (code.equals("%")) {
                    c = 0;
                    break;
                }
                break;
            case 67:
                if (code.equals("C")) {
                    c = 6;
                    break;
                }
                break;
            case 68:
                if (code.equals("D")) {
                    c = 7;
                    break;
                }
                break;
            case 72:
                if (code.equals("H")) {
                    c = '\n';
                    break;
                }
                break;
            case 73:
                if (code.equals("I")) {
                    c = 3;
                    break;
                }
                break;
            case 79:
                if (code.equals("O")) {
                    c = 4;
                    break;
                }
                break;
            case 82:
                if (code.equals("R")) {
                    c = 17;
                    break;
                }
                break;
            case 83:
                if (code.equals("S")) {
                    c = 5;
                    break;
                }
                break;
            case 84:
                if (code.equals("T")) {
                    c = 20;
                    break;
                }
                break;
            case 85:
                if (code.equals("U")) {
                    c = 22;
                    break;
                }
                break;
            case 88:
                if (code.equals("X")) {
                    c = 23;
                    break;
                }
                break;
            case 97:
                if (code.equals("a")) {
                    c = 1;
                    break;
                }
                break;
            case 101:
                if (code.equals("e")) {
                    c = '\b';
                    break;
                }
                break;
            case 102:
                if (code.equals("f")) {
                    c = '\t';
                    break;
                }
                break;
            case 105:
                if (code.equals(IntegerTokenConverter.CONVERTER_KEY)) {
                    c = 11;
                    break;
                }
                break;
            case 107:
                if (code.equals("k")) {
                    c = '\f';
                    break;
                }
                break;
            case 109:
                if (code.equals(ANSIConstants.ESC_END)) {
                    c = '\r';
                    break;
                }
                break;
            case 111:
                if (code.equals("o")) {
                    c = 14;
                    break;
                }
                break;
            case 112:
                if (code.equals("p")) {
                    c = 2;
                    break;
                }
                break;
            case 113:
                if (code.equals("q")) {
                    c = 15;
                    break;
                }
                break;
            case 114:
                if (code.equals("r")) {
                    c = 16;
                    break;
                }
                break;
            case 115:
                if (code.equals("s")) {
                    c = 18;
                    break;
                }
                break;
            case 116:
                if (code.equals("t")) {
                    c = 19;
                    break;
                }
                break;
            case 117:
                if (code.equals("u")) {
                    c = 21;
                    break;
                }
                break;
            case 3701:
                if (code.equals("ti")) {
                    c = 24;
                    break;
                }
                break;
            case 3707:
                if (code.equals("to")) {
                    c = 25;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                specificHandle = MethodHandles.dropArguments(MethodHandles.dropArguments(append.bindTo("%"), 1, Request.class), 2, Response.class);
                break;
            case 1:
                if (StringUtil.isEmpty(arg)) {
                    arg = "server";
                }
                char c2 = 65535;
                switch (arg.hashCode()) {
                    case -1357712437:
                        if (arg.equals("client")) {
                            c2 = 1;
                            break;
                        }
                        break;
                    case -934610874:
                        if (arg.equals("remote")) {
                            c2 = 3;
                            break;
                        }
                        break;
                    case -905826493:
                        if (arg.equals("server")) {
                            c2 = 0;
                            break;
                        }
                        break;
                    case 103145323:
                        if (arg.equals("local")) {
                            c2 = 2;
                            break;
                        }
                        break;
                }
                switch (c2) {
                    case 0:
                        method7 = "logServerHost";
                        break;
                    case 1:
                        method7 = "logClientHost";
                        break;
                    case 2:
                        method7 = "logLocalHost";
                        break;
                    case 3:
                        method7 = "logRemoteHost";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid arg for %a");
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method7, logType);
                break;
            case 2:
                if (StringUtil.isEmpty(arg)) {
                    arg = "server";
                }
                char c3 = 65535;
                switch (arg.hashCode()) {
                    case -1357712437:
                        if (arg.equals("client")) {
                            c3 = 1;
                            break;
                        }
                        break;
                    case -934610874:
                        if (arg.equals("remote")) {
                            c3 = 3;
                            break;
                        }
                        break;
                    case -905826493:
                        if (arg.equals("server")) {
                            c3 = 0;
                            break;
                        }
                        break;
                    case 103145323:
                        if (arg.equals("local")) {
                            c3 = 2;
                            break;
                        }
                        break;
                }
                switch (c3) {
                    case 0:
                        method6 = "logServerPort";
                        break;
                    case 1:
                        method6 = "logClientPort";
                        break;
                    case 2:
                        method6 = "logLocalPort";
                        break;
                    case 3:
                        method6 = "logRemotePort";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid arg for %p");
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method6, logType);
                break;
            case 3:
                if (StringUtil.isEmpty(arg)) {
                    method5 = "logBytesReceived";
                } else if (arg.equalsIgnoreCase("clf")) {
                    method5 = "logBytesReceivedCLF";
                } else {
                    throw new IllegalArgumentException("Invalid argument for %I");
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method5, logType);
                break;
            case 4:
                if (StringUtil.isEmpty(arg)) {
                    method4 = "logBytesSent";
                } else if (arg.equalsIgnoreCase("clf")) {
                    method4 = "logBytesSentCLF";
                } else {
                    throw new IllegalArgumentException("Invalid argument for %O");
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method4, logType);
                break;
            case 5:
                if (StringUtil.isEmpty(arg)) {
                    method3 = "logBytesTransferred";
                } else if (arg.equalsIgnoreCase("clf")) {
                    method3 = "logBytesTransferredCLF";
                } else {
                    throw new IllegalArgumentException("Invalid argument for %S");
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method3, logType);
                break;
            case 6:
                if (!StringUtil.isEmpty(arg)) {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestCookie", logTypeArg).bindTo(arg);
                    break;
                } else {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestCookies", logType);
                    break;
                }
            case 7:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logLatencyMicroseconds", logType);
                break;
            case '\b':
                if (!StringUtil.isEmpty(arg)) {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logEnvironmentVar", logTypeArg).bindTo(arg);
                    break;
                } else {
                    throw new IllegalArgumentException("No arg for %e");
                }
            case '\t':
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logFilename", logType);
                break;
            case '\n':
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestProtocol", logType);
                break;
            case 11:
                if (!StringUtil.isEmpty(arg)) {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestHeader", logTypeArg).bindTo(arg);
                    break;
                } else {
                    throw new IllegalArgumentException("No arg for %i");
                }
            case '\f':
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logKeepAliveRequests", logType);
                break;
            case '\r':
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestMethod", logType);
                break;
            case 14:
                if (!StringUtil.isEmpty(arg)) {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logResponseHeader", logTypeArg).bindTo(arg);
                    break;
                } else {
                    throw new IllegalArgumentException("No arg for %o");
                }
            case 15:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logQueryString", logType);
                break;
            case 16:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestFirstLine", logType);
                break;
            case 17:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestHandler", logType);
                break;
            case 18:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logResponseStatus", logType);
                break;
            case 19:
                String format = DEFAULT_DATE_FORMAT;
                TimeZone timeZone = TimeZone.getTimeZone("GMT");
                Locale locale = Locale.getDefault();
                if (arg != null && !arg.isEmpty()) {
                    String[] args = arg.split("\\|");
                    switch (args.length) {
                        case 1:
                            format = args[0];
                            break;
                        case 2:
                            format = args[0];
                            timeZone = TimeZone.getTimeZone(args[1]);
                            break;
                        case 3:
                            format = args[0];
                            timeZone = TimeZone.getTimeZone(args[1]);
                            locale = Locale.forLanguageTag(args[2]);
                            break;
                        default:
                            throw new IllegalArgumentException("Too many \"|\" characters in %t");
                    }
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestTime", MethodType.methodType(Void.TYPE, DateCache.class, StringBuilder.class, Request.class, Response.class)).bindTo(new DateCache(format, locale, timeZone));
                break;
            case 20:
                if (arg == null) {
                    arg = "s";
                }
                char c4 = 65535;
                switch (arg.hashCode()) {
                    case 115:
                        if (arg.equals("s")) {
                            c4 = 0;
                            break;
                        }
                        break;
                    case PacketOpcodes.GetScenePerformanceReq:
                        if (arg.equals("ms")) {
                            c4 = 2;
                            break;
                        }
                        break;
                    case 3742:
                        if (arg.equals("us")) {
                            c4 = 1;
                            break;
                        }
                        break;
                }
                switch (c4) {
                    case 0:
                        method2 = "logLatencySeconds";
                        break;
                    case 1:
                        method2 = "logLatencyMicroseconds";
                        break;
                    case 2:
                        method2 = "logLatencyMilliseconds";
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid arg for %T");
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method2, logType);
                break;
            case 21:
                if (StringUtil.isEmpty(arg)) {
                    method = "logRequestAuthentication";
                } else if (DateTokenConverter.CONVERTER_KEY.equals(arg)) {
                    method = "logRequestAuthenticationWithDeferred";
                } else {
                    throw new IllegalArgumentException("Invalid arg for %u: " + arg);
                }
                specificHandle = lookup.findStatic(CustomRequestLog.class, method, logType);
                break;
            case 22:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logUrlRequestPath", logType);
                break;
            case 23:
                specificHandle = lookup.findStatic(CustomRequestLog.class, "logConnectionStatus", logType);
                break;
            case 24:
                if (!StringUtil.isEmpty(arg)) {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logRequestTrailer", logTypeArg).bindTo(arg);
                    break;
                } else {
                    throw new IllegalArgumentException("No arg for %ti");
                }
            case 25:
                if (!StringUtil.isEmpty(arg)) {
                    specificHandle = lookup.findStatic(CustomRequestLog.class, "logResponseTrailer", logTypeArg).bindTo(arg);
                    break;
                } else {
                    throw new IllegalArgumentException("No arg for %to");
                }
            default:
                throw new IllegalArgumentException("Unsupported code %" + code);
        }
        if (modifiers == null || modifiers.isEmpty()) {
            return MethodHandles.foldArguments(logHandle, specificHandle);
        }
        return MethodHandles.guardWithTest(lookup.findStatic(CustomRequestLog.class, "modify", MethodType.methodType(Boolean.TYPE, List.class, Boolean.class, StringBuilder.class, Request.class, Response.class)).bindTo(modifiers).bindTo(Boolean.valueOf(negated)), MethodHandles.foldArguments(logHandle, specificHandle), updateLogHandle(logHandle, append, "-"));
    }

    private static void logNothing(StringBuilder b, Request request, Response response) {
    }

    private static void logServerHost(StringBuilder b, Request request, Response response) {
        append(b, request.getServerName());
    }

    private static void logClientHost(StringBuilder b, Request request, Response response) {
        append(b, request.getRemoteHost());
    }

    private static void logLocalHost(StringBuilder b, Request request, Response response) {
        append(b, request.getHttpChannel().getEndPoint().getLocalAddress().getAddress().getHostAddress());
    }

    private static void logRemoteHost(StringBuilder b, Request request, Response response) {
        append(b, request.getHttpChannel().getEndPoint().getRemoteAddress().getAddress().getHostAddress());
    }

    private static void logServerPort(StringBuilder b, Request request, Response response) {
        b.append(request.getServerPort());
    }

    private static void logClientPort(StringBuilder b, Request request, Response response) {
        b.append(request.getRemotePort());
    }

    private static void logLocalPort(StringBuilder b, Request request, Response response) {
        b.append(request.getHttpChannel().getEndPoint().getLocalAddress().getPort());
    }

    private static void logRemotePort(StringBuilder b, Request request, Response response) {
        b.append(request.getHttpChannel().getEndPoint().getRemoteAddress().getPort());
    }

    private static void logResponseSize(StringBuilder b, Request request, Response response) {
        b.append(response.getHttpChannel().getBytesWritten());
    }

    private static void logResponseSizeCLF(StringBuilder b, Request request, Response response) {
        long written = response.getHttpChannel().getBytesWritten();
        if (written == 0) {
            b.append('-');
        } else {
            b.append(written);
        }
    }

    private static void logBytesSent(StringBuilder b, Request request, Response response) {
        b.append(response.getHttpChannel().getBytesWritten());
    }

    private static void logBytesSentCLF(StringBuilder b, Request request, Response response) {
        long sent = response.getHttpChannel().getBytesWritten();
        if (sent == 0) {
            b.append('-');
        } else {
            b.append(sent);
        }
    }

    private static void logBytesReceived(StringBuilder b, Request request, Response response) {
        b.append(request.getHttpInput().getContentReceived());
    }

    private static void logBytesReceivedCLF(StringBuilder b, Request request, Response response) {
        long received = request.getHttpInput().getContentReceived();
        if (received == 0) {
            b.append('-');
        } else {
            b.append(received);
        }
    }

    private static void logBytesTransferred(StringBuilder b, Request request, Response response) {
        b.append(request.getHttpInput().getContentReceived() + response.getHttpOutput().getWritten());
    }

    private static void logBytesTransferredCLF(StringBuilder b, Request request, Response response) {
        long transferred = request.getHttpInput().getContentReceived() + response.getHttpOutput().getWritten();
        if (transferred == 0) {
            b.append('-');
        } else {
            b.append(transferred);
        }
    }

    private static void logRequestCookie(String arg, StringBuilder b, Request request, Response response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (arg.equals(c.getName())) {
                    b.append(c.getValue());
                    return;
                }
            }
        }
        b.append('-');
    }

    private static void logRequestCookies(StringBuilder b, Request request, Response response) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            b.append("-");
            return;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (i != 0) {
                b.append(';');
            }
            b.append(cookies[i].getName());
            b.append('=');
            b.append(cookies[i].getValue());
        }
    }

    private static void logEnvironmentVar(String arg, StringBuilder b, Request request, Response response) {
        append(b, System.getenv(arg));
    }

    private static void logFilename(StringBuilder b, Request request, Response response) {
        UserIdentity.Scope scope = request.getUserIdentityScope();
        if (scope == null || scope.getContextHandler() == null) {
            b.append('-');
        } else {
            append(b, scope.getContextHandler().getServletContext().getRealPath(request.getPathInfo().substring(scope.getContextPath().length() > 1 ? scope.getContextPath().length() : 0)));
        }
    }

    private static void logRequestProtocol(StringBuilder b, Request request, Response response) {
        append(b, request.getProtocol());
    }

    private static void logRequestHeader(String arg, StringBuilder b, Request request, Response response) {
        append(b, request.getHeader(arg));
    }

    private static void logKeepAliveRequests(StringBuilder b, Request request, Response response) {
        long requests = request.getHttpChannel().getConnection().getMessagesIn();
        if (requests >= 0) {
            b.append(requests);
        } else {
            b.append('-');
        }
    }

    private static void logRequestMethod(StringBuilder b, Request request, Response response) {
        append(b, request.getMethod());
    }

    private static void logResponseHeader(String arg, StringBuilder b, Request request, Response response) {
        append(b, response.getHeader(arg));
    }

    private static void logQueryString(StringBuilder b, Request request, Response response) {
        append(b, "?" + request.getQueryString());
    }

    private static void logRequestFirstLine(StringBuilder b, Request request, Response response) {
        append(b, request.getMethod());
        b.append(" ");
        append(b, request.getOriginalURI());
        b.append(" ");
        append(b, request.getProtocol());
    }

    private static void logRequestHandler(StringBuilder b, Request request, Response response) {
        append(b, request.getServletName());
    }

    private static void logResponseStatus(StringBuilder b, Request request, Response response) {
        b.append(response.getCommittedMetaData().getStatus());
    }

    private static void logRequestTime(DateCache dateCache, StringBuilder b, Request request, Response response) {
        b.append('[');
        append(b, dateCache.format(request.getTimeStamp()));
        b.append(']');
    }

    private static void logLatencyMicroseconds(StringBuilder b, Request request, Response response) {
        b.append(TimeUnit.MILLISECONDS.toMicros(System.currentTimeMillis() - request.getTimeStamp()));
    }

    private static void logLatencyMilliseconds(StringBuilder b, Request request, Response response) {
        b.append(System.currentTimeMillis() - request.getTimeStamp());
    }

    private static void logLatencySeconds(StringBuilder b, Request request, Response response) {
        b.append(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis() - request.getTimeStamp()));
    }

    private static void logRequestAuthentication(StringBuilder b, Request request, Response response) {
        append(b, getAuthentication(request, false));
    }

    private static void logRequestAuthenticationWithDeferred(StringBuilder b, Request request, Response response) {
        append(b, getAuthentication(request, true));
    }

    private static void logUrlRequestPath(StringBuilder b, Request request, Response response) {
        append(b, request.getRequestURI());
    }

    private static void logConnectionStatus(StringBuilder b, Request request, Response response) {
        b.append(request.getHttpChannel().isResponseCompleted() ? request.getHttpChannel().isPersistent() ? '+' : '-' : 'X');
    }

    private static void logRequestTrailer(String arg, StringBuilder b, Request request, Response response) {
        HttpFields trailers = request.getTrailers();
        if (trailers != null) {
            append(b, trailers.get(arg));
        } else {
            b.append('-');
        }
    }

    private static void logResponseTrailer(String arg, StringBuilder b, Request request, Response response) {
        Supplier<HttpFields> supplier = response.getTrailers();
        if (supplier != null) {
            HttpFields trailers = supplier.get();
            if (trailers != null) {
                append(b, trailers.get(arg));
            } else {
                b.append('-');
            }
        } else {
            b.append("-");
        }
    }
}
