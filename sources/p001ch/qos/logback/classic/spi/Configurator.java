package p001ch.qos.logback.classic.spi;

import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.spi.ContextAware;

/* renamed from: ch.qos.logback.classic.spi.Configurator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/Configurator.class */
public interface Configurator extends ContextAware {
    void configure(LoggerContext loggerContext);
}
