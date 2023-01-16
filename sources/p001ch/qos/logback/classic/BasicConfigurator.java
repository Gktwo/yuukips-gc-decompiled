package p001ch.qos.logback.classic;

import org.slf4j.Logger;
import p001ch.qos.logback.classic.layout.TTLLLayout;
import p001ch.qos.logback.classic.spi.Configurator;
import p001ch.qos.logback.classic.spi.ILoggingEvent;
import p001ch.qos.logback.core.ConsoleAppender;
import p001ch.qos.logback.core.encoder.LayoutWrappingEncoder;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.classic.BasicConfigurator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/BasicConfigurator.class */
public class BasicConfigurator extends ContextAwareBase implements Configurator {
    @Override // p001ch.qos.logback.classic.spi.Configurator
    public void configure(LoggerContext lc) {
        addInfo("Setting up default configuration.");
        ConsoleAppender<ILoggingEvent> ca = new ConsoleAppender<>();
        ca.setContext(lc);
        ca.setName("console");
        LayoutWrappingEncoder<ILoggingEvent> encoder = new LayoutWrappingEncoder<>();
        encoder.setContext(lc);
        TTLLLayout layout = new TTLLLayout();
        layout.setContext(lc);
        layout.start();
        encoder.setLayout(layout);
        ca.setEncoder(encoder);
        ca.start();
        lc.getLogger(Logger.ROOT_LOGGER_NAME).addAppender(ca);
    }
}
