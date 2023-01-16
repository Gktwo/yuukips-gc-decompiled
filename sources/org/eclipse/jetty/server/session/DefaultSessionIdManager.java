package org.eclipse.jetty.server.session;

import dev.morphia.mapping.Mapper;
import java.security.SecureRandom;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.servlet.http.HttpServletRequest;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.SessionIdManager;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/DefaultSessionIdManager.class */
public class DefaultSessionIdManager extends ContainerLifeCycle implements SessionIdManager {
    public static final String __NEW_SESSION_ID = "org.eclipse.jetty.server.newSessionId";
    protected Random _random;
    protected boolean _weakRandom;
    protected String _workerName;
    protected String _workerAttr;
    protected long _reseed;
    protected Server _server;
    protected HouseKeeper _houseKeeper;
    protected boolean _ownHouseKeeper;
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    protected static final AtomicLong COUNTER = new AtomicLong();

    public DefaultSessionIdManager(Server server) {
        this._reseed = 100000;
        this._server = server;
    }

    public DefaultSessionIdManager(Server server, Random random) {
        this(server);
        this._random = random;
    }

    public void setServer(Server server) {
        this._server = server;
    }

    public Server getServer() {
        return this._server;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void setSessionHouseKeeper(HouseKeeper houseKeeper) {
        updateBean(this._houseKeeper, houseKeeper);
        this._houseKeeper = houseKeeper;
        this._houseKeeper.setSessionIdManager(this);
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public HouseKeeper getSessionHouseKeeper() {
        return this._houseKeeper;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    @ManagedAttribute(value = "unique name for this node", readonly = true)
    public String getWorkerName() {
        return this._workerName;
    }

    public void setWorkerName(String workerName) {
        if (isRunning()) {
            throw new IllegalStateException(getState());
        } else if (workerName == null) {
            this._workerName = "";
        } else if (workerName.contains(Mapper.IGNORED_FIELDNAME)) {
            throw new IllegalArgumentException("Name cannot contain '.'");
        } else {
            this._workerName = workerName;
        }
    }

    public Random getRandom() {
        return this._random;
    }

    public synchronized void setRandom(Random random) {
        this._random = random;
        this._weakRandom = false;
    }

    public long getReseed() {
        return this._reseed;
    }

    public void setReseed(long reseed) {
        this._reseed = reseed;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String newSessionId(HttpServletRequest request, long created) {
        if (request == null) {
            return newSessionId(created);
        }
        String requestedId = request.getRequestedSessionId();
        if (requestedId != null) {
            String clusterId = getId(requestedId);
            if (isIdInUse(clusterId)) {
                return clusterId;
            }
        }
        String newId = (String) request.getAttribute(__NEW_SESSION_ID);
        if (newId != null && isIdInUse(newId)) {
            return newId;
        }
        String id = newSessionId((long) request.hashCode());
        request.setAttribute(__NEW_SESSION_ID, id);
        return id;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1, types: [long] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r0v65, types: [long] */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String newSessionId(long r8) {
        /*
        // Method dump skipped, instructions count: 352
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.DefaultSessionIdManager.newSessionId(long):java.lang.String");
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public boolean isIdInUse(String id) {
        if (id == null) {
            return false;
        }
        boolean inUse = false;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Checking {} is in use by at least one context", id);
        }
        try {
            Iterator<SessionHandler> it = getSessionHandlers().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                SessionHandler manager = it.next();
                if (manager.isIdInUse(id)) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Context {} reports id in use", manager);
                    }
                    inUse = true;
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("Checked {}, in use: {}", id, Boolean.valueOf(inUse));
            }
            return inUse;
        } catch (Exception e) {
            LOG.warn("Problem checking if id {} is in use", id);
            LOG.warn(e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._server == null) {
            throw new IllegalStateException("No Server for SessionIdManager");
        }
        initRandom();
        if (this._workerName == null) {
            String inst = System.getenv("JETTY_WORKER_INSTANCE");
            this._workerName = "node" + (inst == null ? "0" : inst);
        }
        LOG.info("DefaultSessionIdManager workerName={}", this._workerName);
        this._workerAttr = (this._workerName == null || !this._workerName.startsWith("$")) ? null : this._workerName.substring(1);
        if (this._houseKeeper == null) {
            LOG.info("No SessionScavenger set, using defaults", new Object[0]);
            this._ownHouseKeeper = true;
            this._houseKeeper = new HouseKeeper();
            this._houseKeeper.setSessionIdManager(this);
            addBean((Object) this._houseKeeper, true);
        }
        this._houseKeeper.start();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._houseKeeper.stop();
        if (this._ownHouseKeeper) {
            this._houseKeeper = null;
        }
        this._random = null;
    }

    public void initRandom() {
        if (this._random == null) {
            try {
                this._random = new SecureRandom();
            } catch (Exception e) {
                LOG.warn("Could not generate SecureRandom for session-id randomness", e);
                this._random = new Random();
                this._weakRandom = true;
            }
        } else {
            this._random.setSeed(((this._random.nextLong() ^ System.currentTimeMillis()) ^ ((long) hashCode())) ^ Runtime.getRuntime().freeMemory());
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getExtendedId(String clusterId, HttpServletRequest request) {
        if (!StringUtil.isBlank(this._workerName)) {
            if (this._workerAttr == null) {
                return clusterId + '.' + this._workerName;
            }
            String worker = (String) request.getAttribute(this._workerAttr);
            if (worker != null) {
                return clusterId + '.' + worker;
            }
        }
        return clusterId;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String getId(String extendedId) {
        int dot = extendedId.lastIndexOf(46);
        return dot > 0 ? extendedId.substring(0, dot) : extendedId;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void expireAll(String id) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Expiring {}", id);
        }
        for (SessionHandler manager : getSessionHandlers()) {
            manager.invalidate(id);
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public void invalidateAll(String id) {
        for (SessionHandler manager : getSessionHandlers()) {
            manager.invalidate(id);
        }
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public String renewSessionId(String oldClusterId, String oldNodeId, HttpServletRequest request) {
        String newClusterId = newSessionId((long) request.hashCode());
        for (SessionHandler manager : getSessionHandlers()) {
            manager.renewSessionId(oldClusterId, oldNodeId, newClusterId, getExtendedId(newClusterId, request));
        }
        return newClusterId;
    }

    @Override // org.eclipse.jetty.server.SessionIdManager
    public Set<SessionHandler> getSessionHandlers() {
        Set<SessionHandler> handlers = new HashSet<>();
        Handler[] tmp = this._server.getChildHandlersByClass(SessionHandler.class);
        if (tmp != null) {
            for (Handler h : tmp) {
                if (!h.isStopped() && !h.isFailed()) {
                    handlers.add((SessionHandler) h);
                }
            }
        }
        return handlers;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s[worker=%s]", toString(), this._workerName);
    }
}
