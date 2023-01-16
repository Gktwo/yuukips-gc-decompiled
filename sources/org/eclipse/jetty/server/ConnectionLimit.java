package org.eclipse.jetty.server;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.jetty.p023io.Connection;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.p023io.SelectorManager;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ConnectionLimit.class */
public class ConnectionLimit extends AbstractLifeCycle implements Connection.Listener, SelectorManager.AcceptListener {
    private static final Logger LOG = Log.getLogger(ConnectionLimit.class);
    private final Server _server;
    private final List<AbstractConnector> _connectors;
    private final Set<SelectableChannel> _accepting;
    private int _connections;
    private int _maxConnections;
    private long _idleTimeout;
    private boolean _limiting;

    public ConnectionLimit(@Name("maxConnections") int maxConnections, @Name("server") Server server) {
        this._connectors = new ArrayList();
        this._accepting = new HashSet();
        this._limiting = false;
        this._maxConnections = maxConnections;
        this._server = server;
    }

    public ConnectionLimit(@Name("maxConnections") int maxConnections, @Name("connectors") Connector... connectors) {
        this(maxConnections, (Server) null);
        for (Connector c : connectors) {
            if (c instanceof AbstractConnector) {
                this._connectors.add((AbstractConnector) c);
            } else {
                LOG.warn("Connector {} is not an AbstractConnection. Connections not limited", c);
            }
        }
    }

    @ManagedAttribute("The endpoint idle timeout in ms to apply when the connection limit is reached")
    public long getIdleTimeout() {
        return this._idleTimeout;
    }

    public void setIdleTimeout(long idleTimeout) {
        this._idleTimeout = idleTimeout;
    }

    @ManagedAttribute("The maximum number of connections allowed")
    public int getMaxConnections() {
        int i;
        synchronized (this) {
            i = this._maxConnections;
        }
        return i;
    }

    public void setMaxConnections(int max) {
        synchronized (this) {
            this._maxConnections = max;
        }
    }

    @ManagedAttribute("The current number of connections ")
    public int getConnections() {
        int i;
        synchronized (this) {
            i = this._connections;
        }
        return i;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        synchronized (this) {
            if (this._server != null) {
                Connector[] connectors = this._server.getConnectors();
                for (Connector c : connectors) {
                    if (c instanceof AbstractConnector) {
                        this._connectors.add((AbstractConnector) c);
                    } else {
                        LOG.warn("Connector {} is not an AbstractConnector. Connections not limited", c);
                    }
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("ConnectionLimit {} for {}", Integer.valueOf(this._maxConnections), this._connectors);
            }
            this._connections = 0;
            this._limiting = false;
            for (AbstractConnector c2 : this._connectors) {
                c2.addBean(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this) {
            for (AbstractConnector c : this._connectors) {
                c.removeBean(this);
            }
            this._connections = 0;
            if (this._server != null) {
                this._connectors.clear();
            }
        }
    }

    protected void check() {
        if (this._accepting.size() + this._connections >= this._maxConnections) {
            if (!this._limiting) {
                this._limiting = true;
                LOG.info("Connection Limit({}) reached for {}", Integer.valueOf(this._maxConnections), this._connectors);
                limit();
            }
        } else if (this._limiting) {
            this._limiting = false;
            LOG.info("Connection Limit({}) cleared for {}", Integer.valueOf(this._maxConnections), this._connectors);
            unlimit();
        }
    }

    protected void limit() {
        for (AbstractConnector c : this._connectors) {
            c.setAccepting(false);
            if (this._idleTimeout > 0) {
                for (EndPoint endPoint : c.getConnectedEndPoints()) {
                    endPoint.setIdleTimeout(this._idleTimeout);
                }
            }
        }
    }

    protected void unlimit() {
        for (AbstractConnector c : this._connectors) {
            c.setAccepting(true);
            if (this._idleTimeout > 0) {
                for (EndPoint endPoint : c.getConnectedEndPoints()) {
                    endPoint.setIdleTimeout(c.getIdleTimeout());
                }
            }
        }
    }

    @Override // org.eclipse.jetty.p023io.SelectorManager.AcceptListener
    public void onAccepting(SelectableChannel channel) {
        synchronized (this) {
            this._accepting.add(channel);
            if (LOG.isDebugEnabled()) {
                LOG.debug("onAccepting ({}+{}) < {} {}", Integer.valueOf(this._accepting.size()), Integer.valueOf(this._connections), Integer.valueOf(this._maxConnections), channel);
            }
            check();
        }
    }

    @Override // org.eclipse.jetty.p023io.SelectorManager.AcceptListener
    public void onAcceptFailed(SelectableChannel channel, Throwable cause) {
        synchronized (this) {
            this._accepting.remove(channel);
            if (LOG.isDebugEnabled()) {
                LOG.debug("onAcceptFailed ({}+{}) < {} {} {}", Integer.valueOf(this._accepting.size()), Integer.valueOf(this._connections), Integer.valueOf(this._maxConnections), channel, cause);
            }
            check();
        }
    }

    @Override // org.eclipse.jetty.p023io.SelectorManager.AcceptListener
    public void onAccepted(SelectableChannel channel) {
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onOpened(Connection connection) {
        synchronized (this) {
            this._accepting.remove(connection.getEndPoint().getTransport());
            this._connections++;
            if (LOG.isDebugEnabled()) {
                LOG.debug("onOpened ({}+{}) < {} {}", Integer.valueOf(this._accepting.size()), Integer.valueOf(this._connections), Integer.valueOf(this._maxConnections), connection);
            }
            check();
        }
    }

    @Override // org.eclipse.jetty.p023io.Connection.Listener
    public void onClosed(Connection connection) {
        synchronized (this) {
            this._connections--;
            if (LOG.isDebugEnabled()) {
                LOG.debug("onClosed ({}+{}) < {} {}", Integer.valueOf(this._accepting.size()), Integer.valueOf(this._connections), Integer.valueOf(this._maxConnections), connection);
            }
            check();
        }
    }
}
