package org.jline.builtins.telnet;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/Connection.class */
public abstract class Connection extends Thread {
    private static final Logger LOG = Logger.getLogger(Connection.class.getName());
    private static int number;
    private ConnectionData connectionData;
    private List<ConnectionListener> listeners = new CopyOnWriteArrayList();
    private boolean dead = false;

    protected abstract void doRun() throws Exception;

    protected abstract void doClose() throws Exception;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Connection(java.lang.ThreadGroup r7, org.jline.builtins.telnet.ConnectionData r8) {
        /*
            r6 = this;
            r0 = r6
            r1 = r7
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "Connection"
            java.lang.StringBuilder r2 = r2.append(r3)
            int r3 = org.jline.builtins.telnet.Connection.number
            r4 = 1
            int r3 = r3 + r4
            r4 = r3
            org.jline.builtins.telnet.Connection.number = r4
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r0.<init>(r1, r2)
            r0 = r6
            r1 = r8
            r0.connectionData = r1
            r0 = r6
            java.util.concurrent.CopyOnWriteArrayList r1 = new java.util.concurrent.CopyOnWriteArrayList
            r2 = r1
            r2.<init>()
            r0.listeners = r1
            r0 = r6
            r1 = 0
            r0.dead = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.telnet.Connection.<init>(java.lang.ThreadGroup, org.jline.builtins.telnet.ConnectionData):void");
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            try {
                doRun();
                if (!this.dead) {
                    close();
                }
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, "run()", (Throwable) ex);
                if (!this.dead) {
                    close();
                }
            }
            LOG.log(Level.FINE, "run():: Returning from " + toString());
        } catch (Throwable th) {
            if (!this.dead) {
                close();
            }
            throw th;
        }
    }

    public ConnectionData getConnectionData() {
        return this.connectionData;
    }

    public synchronized void close() {
        if (!this.dead) {
            try {
                this.dead = true;
                doClose();
            } catch (Exception ex) {
                LOG.log(Level.SEVERE, "close()", (Throwable) ex);
            }
            try {
                this.connectionData.getSocket().close();
            } catch (Exception ex2) {
                LOG.log(Level.SEVERE, "close()", (Throwable) ex2);
            }
            try {
                this.connectionData.getManager().registerClosedConnection(this);
            } catch (Exception ex3) {
                LOG.log(Level.SEVERE, "close()", (Throwable) ex3);
            }
            try {
                interrupt();
            } catch (Exception ex4) {
                LOG.log(Level.SEVERE, "close()", (Throwable) ex4);
            }
            LOG.log(Level.FINE, "Closed " + toString() + " and inactive.");
        }
    }

    public boolean isActive() {
        return !this.dead;
    }

    public void addConnectionListener(ConnectionListener cl) {
        this.listeners.add(cl);
    }

    public void removeConnectionListener(ConnectionListener cl) {
        this.listeners.remove(cl);
    }

    public void processConnectionEvent(ConnectionEvent ce) {
        for (ConnectionListener cl : this.listeners) {
            switch (ce.getType()) {
                case CONNECTION_IDLE:
                    cl.connectionIdle(ce);
                    break;
                case CONNECTION_TIMEDOUT:
                    cl.connectionTimedOut(ce);
                    break;
                case CONNECTION_LOGOUTREQUEST:
                    cl.connectionLogoutRequest(ce);
                    break;
                case CONNECTION_BREAK:
                    cl.connectionSentBreak(ce);
                    break;
                case CONNECTION_TERMINAL_GEOMETRY_CHANGED:
                    cl.connectionTerminalGeometryChanged(ce);
                    break;
            }
        }
    }
}
