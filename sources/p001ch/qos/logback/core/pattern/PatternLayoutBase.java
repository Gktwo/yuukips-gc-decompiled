package p001ch.qos.logback.core.pattern;

import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.LayoutBase;
import p001ch.qos.logback.core.pattern.parser.Parser;
import p001ch.qos.logback.core.spi.ScanException;
import p001ch.qos.logback.core.status.ErrorStatus;

/* renamed from: ch.qos.logback.core.pattern.PatternLayoutBase */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/PatternLayoutBase.class */
public abstract class PatternLayoutBase<E> extends LayoutBase<E> {
    static final int INTIAL_STRING_BUILDER_SIZE = 256;
    Converter<E> head;
    String pattern;
    protected PostCompileProcessor<E> postCompileProcessor;
    Map<String, String> instanceConverterMap = new HashMap();
    protected boolean outputPatternAsHeader = false;

    public abstract Map<String, String> getDefaultConverterMap();

    public Map<String, String> getEffectiveConverterMap() {
        Map<String, String> contextMap;
        Map<String, String> effectiveMap = new HashMap<>();
        Map<String, String> defaultMap = getDefaultConverterMap();
        if (defaultMap != null) {
            effectiveMap.putAll(defaultMap);
        }
        Context context = getContext();
        if (!(context == null || (contextMap = (Map) context.getObject(CoreConstants.PATTERN_RULE_REGISTRY)) == null)) {
            effectiveMap.putAll(contextMap);
        }
        effectiveMap.putAll(this.instanceConverterMap);
        return effectiveMap;
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.pattern == null || this.pattern.length() == 0) {
            addError("Empty or null pattern.");
            return;
        }
        try {
            Parser<E> p = new Parser<>(this.pattern);
            if (getContext() != null) {
                p.setContext(getContext());
            }
            this.head = p.compile(p.parse(), getEffectiveConverterMap());
            if (this.postCompileProcessor != null) {
                this.postCompileProcessor.process(this.context, this.head);
            }
            ConverterUtil.setContextForConverters(getContext(), this.head);
            ConverterUtil.startConverters(this.head);
            start();
        } catch (ScanException sce) {
            getContext().getStatusManager().add(new ErrorStatus("Failed to parse pattern \"" + getPattern() + "\".", this, sce));
        }
    }

    public void setPostCompileProcessor(PostCompileProcessor<E> postCompileProcessor) {
        this.postCompileProcessor = postCompileProcessor;
    }

    protected void setContextForConverters(Converter<E> head) {
        ConverterUtil.setContextForConverters(getContext(), head);
    }

    protected String writeLoopOnConverters(E event) {
        StringBuilder strBuilder = new StringBuilder(256);
        for (Converter<E> c = this.head; c != null; c = c.getNext()) {
            c.write(strBuilder, event);
        }
        return strBuilder.toString();
    }

    public String getPattern() {
        return this.pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String toString() {
        return getClass().getName() + "(\"" + getPattern() + "\")";
    }

    public Map<String, String> getInstanceConverterMap() {
        return this.instanceConverterMap;
    }

    protected String getPresentationHeaderPrefix() {
        return "";
    }

    public boolean isOutputPatternAsHeader() {
        return this.outputPatternAsHeader;
    }

    public void setOutputPatternAsHeader(boolean outputPatternAsHeader) {
        this.outputPatternAsHeader = outputPatternAsHeader;
    }

    @Override // p001ch.qos.logback.core.LayoutBase, p001ch.qos.logback.core.Layout
    public String getPresentationHeader() {
        if (this.outputPatternAsHeader) {
            return getPresentationHeaderPrefix() + this.pattern;
        }
        return getPresentationHeader();
    }
}
