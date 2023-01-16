package p001ch.qos.logback.classic.net;

import org.slf4j.Marker;
import p001ch.qos.logback.classic.ClassicConstants;
import p001ch.qos.logback.classic.PatternLayout;
import p001ch.qos.logback.classic.boolex.OnErrorEvaluator;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.Layout;
import p001ch.qos.logback.core.boolex.EventEvaluator;
import p001ch.qos.logback.core.helpers.CyclicBuffer;
import p001ch.qos.logback.core.net.SMTPAppenderBase;
import p001ch.qos.logback.core.pattern.PatternLayoutBase;

/* renamed from: ch.qos.logback.classic.net.SMTPAppender */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/net/SMTPAppender.class */
public class SMTPAppender extends SMTPAppenderBase<ILoggingEvent> {
    static final String DEFAULT_SUBJECT_PATTERN = "%logger{20} - %m";
    private int bufferSize = 512;
    private boolean includeCallerData = false;

    public SMTPAppender() {
    }

    @Override // p001ch.qos.logback.core.net.SMTPAppenderBase, p001ch.qos.logback.core.AppenderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.eventEvaluator == null) {
            OnErrorEvaluator onError = new OnErrorEvaluator();
            onError.setContext(getContext());
            onError.setName("onError");
            onError.start();
            this.eventEvaluator = onError;
        }
        start();
    }

    public SMTPAppender(EventEvaluator<ILoggingEvent> eventEvaluator) {
        this.eventEvaluator = eventEvaluator;
    }

    /* access modifiers changed from: protected */
    public void subAppend(CyclicBuffer<ILoggingEvent> cb, ILoggingEvent event) {
        if (this.includeCallerData) {
            event.getCallerData();
        }
        event.prepareForDeferredProcessing();
        cb.add(event);
    }

    @Override // p001ch.qos.logback.core.net.SMTPAppenderBase
    protected void fillBuffer(CyclicBuffer<ILoggingEvent> cb, StringBuffer sbuf) {
        int len = cb.length();
        for (int i = 0; i < len; i++) {
            sbuf.append(this.layout.doLayout(cb.get()));
        }
    }

    /* access modifiers changed from: protected */
    public boolean eventMarksEndOfLife(ILoggingEvent eventObject) {
        Marker marker = eventObject.getMarker();
        if (marker == null) {
            return false;
        }
        return marker.contains(ClassicConstants.FINALIZE_SESSION_MARKER);
    }

    @Override // p001ch.qos.logback.core.net.SMTPAppenderBase
    protected Layout<ILoggingEvent> makeSubjectLayout(String subjectStr) {
        if (subjectStr == null) {
            subjectStr = DEFAULT_SUBJECT_PATTERN;
        }
        PatternLayout pl = new PatternLayout();
        pl.setContext(getContext());
        pl.setPattern(subjectStr);
        pl.setPostCompileProcessor(null);
        pl.start();
        return pl;
    }

    /* Return type fixed from 'ch.qos.logback.classic.PatternLayout' to match base method */
    /* access modifiers changed from: protected */
    @Override // p001ch.qos.logback.core.net.SMTPAppenderBase
    public PatternLayoutBase<ILoggingEvent> makeNewToPatternLayout(String toPattern) {
        PatternLayout pl = new PatternLayout();
        pl.setPattern(toPattern + "%nopex");
        return pl;
    }

    public boolean isIncludeCallerData() {
        return this.includeCallerData;
    }

    public void setIncludeCallerData(boolean includeCallerData) {
        this.includeCallerData = includeCallerData;
    }
}
