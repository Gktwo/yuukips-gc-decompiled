package p001ch.qos.logback.core.pattern;

import p001ch.qos.logback.core.Layout;
import p001ch.qos.logback.core.encoder.LayoutWrappingEncoder;

/* renamed from: ch.qos.logback.core.pattern.PatternLayoutEncoderBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/PatternLayoutEncoderBase.class */
public class PatternLayoutEncoderBase<E> extends LayoutWrappingEncoder<E> {
    String pattern;
    protected boolean outputPatternAsHeader = false;

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isOutputPatternAsHeader() {
        return this.outputPatternAsHeader;
    }

    public void setOutputPatternAsHeader(boolean outputPatternAsHeader) {
        this.outputPatternAsHeader = outputPatternAsHeader;
    }

    public boolean isOutputPatternAsPresentationHeader() {
        return this.outputPatternAsHeader;
    }

    public void setOutputPatternAsPresentationHeader(boolean outputPatternAsHeader) {
        addWarn("[outputPatternAsPresentationHeader] property is deprecated. Please use [outputPatternAsHeader] option instead.");
        this.outputPatternAsHeader = outputPatternAsHeader;
    }

    @Override // p001ch.qos.logback.core.encoder.LayoutWrappingEncoder
    public void setLayout(Layout<E> layout) {
        throw new UnsupportedOperationException("one cannot set the layout of " + getClass().getName());
    }
}
