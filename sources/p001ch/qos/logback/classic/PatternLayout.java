package p001ch.qos.logback.classic;

import java.util.HashMap;
import java.util.Map;
import org.jline.builtins.Tmux;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;
import org.quartz.jobs.p027ee.mail.SendMailJob;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;
import p001ch.qos.logback.classic.pattern.ClassOfCallerConverter;
import p001ch.qos.logback.classic.pattern.ContextNameConverter;
import p001ch.qos.logback.classic.pattern.DateConverter;
import p001ch.qos.logback.classic.pattern.EnsureExceptionHandling;
import p001ch.qos.logback.classic.pattern.ExtendedThrowableProxyConverter;
import p001ch.qos.logback.classic.pattern.FileOfCallerConverter;
import p001ch.qos.logback.classic.pattern.LevelConverter;
import p001ch.qos.logback.classic.pattern.LineOfCallerConverter;
import p001ch.qos.logback.classic.pattern.LineSeparatorConverter;
import p001ch.qos.logback.classic.pattern.LocalSequenceNumberConverter;
import p001ch.qos.logback.classic.pattern.LoggerConverter;
import p001ch.qos.logback.classic.pattern.MDCConverter;
import p001ch.qos.logback.classic.pattern.MarkerConverter;
import p001ch.qos.logback.classic.pattern.MessageConverter;
import p001ch.qos.logback.classic.pattern.MethodOfCallerConverter;
import p001ch.qos.logback.classic.pattern.NopThrowableInformationConverter;
import p001ch.qos.logback.classic.pattern.PrefixCompositeConverter;
import p001ch.qos.logback.classic.pattern.PropertyConverter;
import p001ch.qos.logback.classic.pattern.RelativeTimeConverter;
import p001ch.qos.logback.classic.pattern.RootCauseFirstThrowableProxyConverter;
import p001ch.qos.logback.classic.pattern.ThreadConverter;
import p001ch.qos.logback.classic.pattern.ThrowableProxyConverter;
import p001ch.qos.logback.classic.pattern.color.HighlightingCompositeConverter;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.pattern.PatternLayoutBase;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;
import p001ch.qos.logback.core.pattern.color.BlackCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BlueCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldBlueCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldCyanCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldGreenCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldMagentaCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldRedCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldWhiteCompositeConverter;
import p001ch.qos.logback.core.pattern.color.BoldYellowCompositeConverter;
import p001ch.qos.logback.core.pattern.color.CyanCompositeConverter;
import p001ch.qos.logback.core.pattern.color.GrayCompositeConverter;
import p001ch.qos.logback.core.pattern.color.GreenCompositeConverter;
import p001ch.qos.logback.core.pattern.color.MagentaCompositeConverter;
import p001ch.qos.logback.core.pattern.color.RedCompositeConverter;
import p001ch.qos.logback.core.pattern.color.WhiteCompositeConverter;
import p001ch.qos.logback.core.pattern.color.YellowCompositeConverter;
import p001ch.qos.logback.core.pattern.parser.Parser;
import p001ch.qos.logback.core.rolling.helper.DateTokenConverter;

/* renamed from: ch.qos.logback.classic.PatternLayout */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/PatternLayout.class */
public class PatternLayout extends PatternLayoutBase<ILoggingEvent> {
    public static final Map<String, String> DEFAULT_CONVERTER_MAP = new HashMap();
    public static final Map<String, String> CONVERTER_CLASS_TO_KEY_MAP = new HashMap();
    public static final Map<String, String> defaultConverterMap = DEFAULT_CONVERTER_MAP;
    public static final String HEADER_PREFIX = "#logback.classic pattern: ";

    static {
        DEFAULT_CONVERTER_MAP.putAll(Parser.DEFAULT_COMPOSITE_CONVERTER_MAP);
        DEFAULT_CONVERTER_MAP.put(DateTokenConverter.CONVERTER_KEY, DateConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("date", DateConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(DateConverter.class.getName(), "date");
        DEFAULT_CONVERTER_MAP.put("r", RelativeTimeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("relative", RelativeTimeConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(RelativeTimeConverter.class.getName(), "relative");
        DEFAULT_CONVERTER_MAP.put("level", LevelConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("le", LevelConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("p", LevelConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(LevelConverter.class.getName(), "level");
        DEFAULT_CONVERTER_MAP.put("t", ThreadConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("thread", ThreadConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(ThreadConverter.class.getName(), "thread");
        DEFAULT_CONVERTER_MAP.put("lo", LoggerConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("logger", LoggerConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("c", LoggerConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(LoggerConverter.class.getName(), "logger");
        DEFAULT_CONVERTER_MAP.put(ANSIConstants.ESC_END, MessageConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("msg", MessageConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put(SendMailJob.PROP_MESSAGE, MessageConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(MessageConverter.class.getName(), SendMailJob.PROP_MESSAGE);
        DEFAULT_CONVERTER_MAP.put("C", ClassOfCallerConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("class", ClassOfCallerConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(ClassOfCallerConverter.class.getName(), "class");
        DEFAULT_CONVERTER_MAP.put("M", MethodOfCallerConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put(EJBInvokerJob.EJB_METHOD_KEY, MethodOfCallerConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(MethodOfCallerConverter.class.getName(), EJBInvokerJob.EJB_METHOD_KEY);
        DEFAULT_CONVERTER_MAP.put("L", LineOfCallerConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("line", LineOfCallerConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(LineOfCallerConverter.class.getName(), "line");
        DEFAULT_CONVERTER_MAP.put("F", FileOfCallerConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put(Action.FILE_ATTRIBUTE, FileOfCallerConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(FileOfCallerConverter.class.getName(), Action.FILE_ATTRIBUTE);
        DEFAULT_CONVERTER_MAP.put("X", MDCConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("mdc", MDCConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("ex", ThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("exception", ThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("rEx", RootCauseFirstThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("rootException", RootCauseFirstThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("throwable", ThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("xEx", ExtendedThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("xException", ExtendedThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("xThrowable", ExtendedThrowableProxyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("nopex", NopThrowableInformationConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("nopexception", NopThrowableInformationConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("cn", ContextNameConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("contextName", ContextNameConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(ContextNameConverter.class.getName(), "contextName");
        DEFAULT_CONVERTER_MAP.put("caller", CallerDataConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(CallerDataConverter.class.getName(), "caller");
        DEFAULT_CONVERTER_MAP.put("marker", MarkerConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(MarkerConverter.class.getName(), "marker");
        DEFAULT_CONVERTER_MAP.put("property", PropertyConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("n", LineSeparatorConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("black", BlackCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("red", RedCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("green", GreenCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("yellow", YellowCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("blue", BlueCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("magenta", MagentaCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("cyan", CyanCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("white", WhiteCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("gray", GrayCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldRed", BoldRedCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldGreen", BoldGreenCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldYellow", BoldYellowCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldBlue", BoldBlueCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldMagenta", BoldMagentaCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldCyan", BoldCyanCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("boldWhite", BoldWhiteCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("highlight", HighlightingCompositeConverter.class.getName());
        DEFAULT_CONVERTER_MAP.put("lsn", LocalSequenceNumberConverter.class.getName());
        CONVERTER_CLASS_TO_KEY_MAP.put(LocalSequenceNumberConverter.class.getName(), "lsn");
        DEFAULT_CONVERTER_MAP.put(Tmux.OPT_PREFIX, PrefixCompositeConverter.class.getName());
    }

    public PatternLayout() {
        this.postCompileProcessor = new EnsureExceptionHandling();
    }

    @Override // p001ch.qos.logback.core.pattern.PatternLayoutBase
    public Map<String, String> getDefaultConverterMap() {
        return DEFAULT_CONVERTER_MAP;
    }

    public String doLayout(ILoggingEvent event) {
        if (!isStarted()) {
            return "";
        }
        return writeLoopOnConverters(event);
    }

    @Override // p001ch.qos.logback.core.pattern.PatternLayoutBase
    protected String getPresentationHeaderPrefix() {
        return HEADER_PREFIX;
    }
}
