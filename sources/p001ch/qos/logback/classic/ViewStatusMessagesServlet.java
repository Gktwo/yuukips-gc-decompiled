package p001ch.qos.logback.classic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.LoggerFactory;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.status.ViewStatusMessagesServletBase;

/* renamed from: ch.qos.logback.classic.ViewStatusMessagesServlet */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/ViewStatusMessagesServlet.class */
public class ViewStatusMessagesServlet extends ViewStatusMessagesServletBase {
    private static final long serialVersionUID = 443878494348593337L;

    @Override // p001ch.qos.logback.core.status.ViewStatusMessagesServletBase
    protected StatusManager getStatusManager(HttpServletRequest req, HttpServletResponse resp) {
        return ((LoggerContext) LoggerFactory.getILoggerFactory()).getStatusManager();
    }

    @Override // p001ch.qos.logback.core.status.ViewStatusMessagesServletBase
    protected String getPageTitle(HttpServletRequest req, HttpServletResponse resp) {
        return "<h2>Status messages for LoggerContext named [" + ((LoggerContext) LoggerFactory.getILoggerFactory()).getName() + "]</h2>\r\n";
    }
}
