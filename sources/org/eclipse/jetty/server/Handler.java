package org.eclipse.jetty.server;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.component.LifeCycle;

@ManagedObject("Jetty Handler")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/Handler.class */
public interface Handler extends LifeCycle, Destroyable {
    void handle(String str, Request request, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException, ServletException;

    void setServer(Server server);

    @ManagedAttribute(value = "the jetty server for this handler", readonly = true)
    Server getServer();

    @Override // org.eclipse.jetty.util.component.Destroyable
    @ManagedOperation(value = "destroy associated resources", impact = "ACTION")
    void destroy();
}
