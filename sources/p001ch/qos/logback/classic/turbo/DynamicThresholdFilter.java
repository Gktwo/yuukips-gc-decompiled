package p001ch.qos.logback.classic.turbo;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.MDC;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.core.spi.FilterReply;

/* renamed from: ch.qos.logback.classic.turbo.DynamicThresholdFilter */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/turbo/DynamicThresholdFilter.class */
public class DynamicThresholdFilter extends TurboFilter {
    private String key;
    private Map<String, Level> valueLevelMap = new HashMap();
    private Level defaultThreshold = Level.ERROR;
    private FilterReply onHigherOrEqual = FilterReply.NEUTRAL;
    private FilterReply onLower = FilterReply.DENY;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Level getDefaultThreshold() {
        return this.defaultThreshold;
    }

    public void setDefaultThreshold(Level defaultThreshold) {
        this.defaultThreshold = defaultThreshold;
    }

    public FilterReply getOnHigherOrEqual() {
        return this.onHigherOrEqual;
    }

    public void setOnHigherOrEqual(FilterReply onHigherOrEqual) {
        this.onHigherOrEqual = onHigherOrEqual;
    }

    public FilterReply getOnLower() {
        return this.onLower;
    }

    public void setOnLower(FilterReply onLower) {
        this.onLower = onLower;
    }

    public void addMDCValueLevelPair(MDCValueLevelPair mdcValueLevelPair) {
        if (this.valueLevelMap.containsKey(mdcValueLevelPair.getValue())) {
            addError(mdcValueLevelPair.getValue() + " has been already set");
        } else {
            this.valueLevelMap.put(mdcValueLevelPair.getValue(), mdcValueLevelPair.getLevel());
        }
    }

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter, p001ch.qos.logback.core.spi.LifeCycle
    public void start() {
        if (this.key == null) {
            addError("No key name was specified");
        }
        start();
    }

    @Override // p001ch.qos.logback.classic.turbo.TurboFilter
    public FilterReply decide(Marker marker, Logger logger, Level level, String s, Object[] objects, Throwable throwable) {
        String mdcValue = MDC.get(this.key);
        if (!isStarted()) {
            return FilterReply.NEUTRAL;
        }
        Level levelAssociatedWithMDCValue = null;
        if (mdcValue != null) {
            levelAssociatedWithMDCValue = this.valueLevelMap.get(mdcValue);
        }
        if (levelAssociatedWithMDCValue == null) {
            levelAssociatedWithMDCValue = this.defaultThreshold;
        }
        if (level.isGreaterOrEqual(levelAssociatedWithMDCValue)) {
            return this.onHigherOrEqual;
        }
        return this.onLower;
    }
}
