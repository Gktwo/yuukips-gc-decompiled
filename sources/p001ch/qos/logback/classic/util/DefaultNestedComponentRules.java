package p001ch.qos.logback.classic.util;

import p001ch.qos.logback.classic.PatternLayout;
import p001ch.qos.logback.classic.boolex.JaninoEventEvaluator;
import p001ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import p001ch.qos.logback.core.AppenderBase;
import p001ch.qos.logback.core.UnsynchronizedAppenderBase;
import p001ch.qos.logback.core.filter.EvaluatorFilter;
import p001ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p001ch.qos.logback.core.net.ssl.SSLNestedComponentRegistryRules;

/* renamed from: ch.qos.logback.classic.util.DefaultNestedComponentRules */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/DefaultNestedComponentRules.class */
public class DefaultNestedComponentRules {
    public static void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry registry) {
        registry.add(AppenderBase.class, "layout", PatternLayout.class);
        registry.add(UnsynchronizedAppenderBase.class, "layout", PatternLayout.class);
        registry.add(AppenderBase.class, "encoder", PatternLayoutEncoder.class);
        registry.add(UnsynchronizedAppenderBase.class, "encoder", PatternLayoutEncoder.class);
        registry.add(EvaluatorFilter.class, "evaluator", JaninoEventEvaluator.class);
        SSLNestedComponentRegistryRules.addDefaultNestedComponentRegistryRules(registry);
    }
}
