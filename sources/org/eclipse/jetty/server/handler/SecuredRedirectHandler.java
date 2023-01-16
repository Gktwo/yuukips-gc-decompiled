package org.eclipse.jetty.server.handler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.HttpConfiguration;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.URIUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/SecuredRedirectHandler.class */
public class SecuredRedirectHandler extends AbstractHandler {
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpChannel channel = baseRequest.getHttpChannel();
        if (!baseRequest.isSecure() && channel != null) {
            HttpConfiguration httpConfig = channel.getHttpConfiguration();
            if (httpConfig == null) {
                response.sendError(403, "No http configuration available");
                return;
            }
            if (httpConfig.getSecurePort() > 0) {
                String url = URIUtil.newURI(httpConfig.getSecureScheme(), baseRequest.getServerName(), httpConfig.getSecurePort(), baseRequest.getRequestURI(), baseRequest.getQueryString());
                response.setContentLength(0);
                baseRequest.getResponse().sendRedirect(302, url, true);
            } else {
                response.sendError(403, "Not Secure");
            }
            baseRequest.setHandled(true);
        }
    }
}
