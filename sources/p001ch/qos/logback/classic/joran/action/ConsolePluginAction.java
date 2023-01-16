package p001ch.qos.logback.classic.joran.action;

import org.slf4j.Logger;
import org.xml.sax.Attributes;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.net.SocketAppender;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;

/* renamed from: ch.qos.logback.classic.joran.action.ConsolePluginAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/ConsolePluginAction.class */
public class ConsolePluginAction extends Action {
    private static final String PORT_ATTR = "port";
    private static final Integer DEFAULT_PORT = 4321;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) throws ActionException {
        String portStr = attributes.getValue(PORT_ATTR);
        Integer port = null;
        if (portStr == null) {
            port = DEFAULT_PORT;
        } else {
            try {
                port = Integer.valueOf(portStr);
            } catch (NumberFormatException e) {
                addError("Port " + portStr + " in ConsolePlugin config is not a correct number");
            }
        }
        LoggerContext lc = (LoggerContext) ec.getContext();
        SocketAppender appender = new SocketAppender();
        appender.setContext(lc);
        appender.setIncludeCallerData(true);
        appender.setRemoteHost("localhost");
        appender.setPort(port.intValue());
        appender.start();
        lc.getLogger(Logger.ROOT_LOGGER_NAME).addAppender(appender);
        addInfo("Sending LoggingEvents to the plugin using port " + port);
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) throws ActionException {
    }
}
