package p001ch.qos.logback.classic.encoder;

import p001ch.qos.logback.classic.PatternLayout;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.pattern.PatternLayoutEncoderBase;

/* renamed from: ch.qos.logback.classic.encoder.PatternLayoutEncoder */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/encoder/PatternLayoutEncoder.class */
public class PatternLayoutEncoder extends PatternLayoutEncoderBase<ILoggingEvent> {
    @Override // p001ch.qos.logback.core.encoder.LayoutWrappingEncoder, p001ch.qos.logback.core.encoder.EncoderBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        PatternLayout patternLayout = new PatternLayout();
        patternLayout.setContext(this.context);
        patternLayout.setPattern(getPattern());
        patternLayout.setOutputPatternAsHeader(this.outputPatternAsHeader);
        patternLayout.start();
        this.layout = patternLayout;
        start();
    }
}
