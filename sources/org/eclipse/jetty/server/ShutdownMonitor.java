package org.eclipse.jetty.server;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import org.eclipse.jetty.util.component.Destroyable;
import org.eclipse.jetty.util.component.LifeCycle;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ShutdownMonitor.class */
public class ShutdownMonitor {
    private final Set<LifeCycle> _lifeCycles;
    private boolean debug;
    private final String host;
    private int port;
    private String key;
    private boolean exitVm;
    private boolean alive;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ShutdownMonitor$Holder.class */
    public static class Holder {
        static ShutdownMonitor instance = new ShutdownMonitor();

        private Holder() {
        }
    }

    public static ShutdownMonitor getInstance() {
        return Holder.instance;
    }

    protected static void reset() {
        Holder.instance = new ShutdownMonitor();
    }

    public static void register(LifeCycle... lifeCycles) {
        getInstance().addLifeCycles(lifeCycles);
    }

    public static void deregister(LifeCycle lifeCycle) {
        getInstance().removeLifeCycle(lifeCycle);
    }

    public static boolean isRegistered(LifeCycle lifeCycle) {
        return getInstance().containsLifeCycle(lifeCycle);
    }

    private ShutdownMonitor() {
        this._lifeCycles = new LinkedHashSet();
        this.exitVm = true;
        this.debug = System.getProperty("DEBUG") != null;
        this.host = System.getProperty("STOP.HOST", "127.0.0.1");
        this.port = Integer.getInteger("STOP.PORT", -1).intValue();
        this.key = System.getProperty("STOP.KEY", null);
        this.exitVm = Boolean.valueOf(System.getProperty("STOP.EXIT", C3P0Substitutions.DEBUG)).booleanValue();
    }

    private void addLifeCycles(LifeCycle... lifeCycles) {
        synchronized (this) {
            this._lifeCycles.addAll(Arrays.asList(lifeCycles));
        }
    }

    private void removeLifeCycle(LifeCycle lifeCycle) {
        synchronized (this) {
            this._lifeCycles.remove(lifeCycle);
        }
    }

    private boolean containsLifeCycle(LifeCycle lifeCycle) {
        boolean contains;
        synchronized (this) {
            contains = this._lifeCycles.contains(lifeCycle);
        }
        return contains;
    }

    /* access modifiers changed from: private */
    public void debug(String format, Object... args) {
        if (this.debug) {
            System.err.printf("[ShutdownMonitor] " + format + "%n", args);
        }
    }

    /* access modifiers changed from: private */
    public void debug(Throwable t) {
        if (this.debug) {
            t.printStackTrace(System.err);
        }
    }

    public String getKey() {
        String str;
        synchronized (this) {
            str = this.key;
        }
        return str;
    }

    public int getPort() {
        int i;
        synchronized (this) {
            i = this.port;
        }
        return i;
    }

    public boolean isExitVm() {
        boolean z;
        synchronized (this) {
            z = this.exitVm;
        }
        return z;
    }

    public void setDebug(boolean flag) {
        this.debug = flag;
    }

    public void setExitVm(boolean exitVm) {
        synchronized (this) {
            if (this.alive) {
                throw new IllegalStateException("ShutdownMonitor already started");
            }
            this.exitVm = exitVm;
        }
    }

    public void setKey(String key) {
        synchronized (this) {
            if (this.alive) {
                throw new IllegalStateException("ShutdownMonitor already started");
            }
            this.key = key;
        }
    }

    public void setPort(int port) {
        synchronized (this) {
            if (this.alive) {
                throw new IllegalStateException("ShutdownMonitor already started");
            }
            this.port = port;
        }
    }

    /* access modifiers changed from: protected */
    public void start() throws Exception {
        synchronized (this) {
            if (this.alive) {
                debug("Already started", new Object[0]);
                return;
            }
            ServerSocket serverSocket = listen();
            if (serverSocket != null) {
                this.alive = true;
                Thread thread = new Thread(new ShutdownMonitorRunnable(serverSocket));
                thread.setDaemon(true);
                thread.setName("ShutdownMonitor");
                thread.start();
            }
        }
    }

    /* access modifiers changed from: private */
    public void stop() {
        synchronized (this) {
            this.alive = false;
            notifyAll();
        }
    }

    void await() throws InterruptedException {
        synchronized (this) {
            while (this.alive) {
                wait();
            }
        }
    }

    protected boolean isAlive() {
        boolean z;
        synchronized (this) {
            z = this.alive;
        }
        return z;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0044
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private java.net.ServerSocket listen() {
        /*
        // Method dump skipped, instructions count: 375
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.ShutdownMonitor.listen():java.net.ServerSocket");
    }

    public String toString() {
        return String.format("%s[port=%d,alive=%b]", getClass().getName(), Integer.valueOf(getPort()), Boolean.valueOf(isAlive()));
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/ShutdownMonitor$ShutdownMonitorRunnable.class */
    public class ShutdownMonitorRunnable implements Runnable {
        private final ServerSocket serverSocket;

        private ShutdownMonitorRunnable(ServerSocket serverSocket) {
            this.serverSocket = serverSocket;
        }

        /* JADX WARNING: Removed duplicated region for block: B:40:0x01b7 A[Catch: Throwable -> 0x01d7, Throwable -> 0x0201, all -> 0x0228, TryCatch #3 {all -> 0x0228, blocks: (B:3:0x000d, B:9:0x0055, B:17:0x00c3, B:20:0x00de, B:26:0x011e, B:29:0x0139, B:32:0x0183, B:35:0x01a1, B:37:0x01ab, B:40:0x01b7, B:44:0x01c3, B:46:0x01cc, B:48:0x01d3, B:51:0x01d8), top: B:63:0x000d }] */
        @Override // java.lang.Runnable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
            // Method dump skipped, instructions count: 585
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.ShutdownMonitor.ShutdownMonitorRunnable.run():void");
        }

        private void informClient(OutputStream out, String message) throws IOException {
            out.write(message.getBytes(StandardCharsets.UTF_8));
            out.flush();
        }

        private void stopLifeCycles(Predicate<LifeCycle> predicate, boolean destroy) {
            List<LifeCycle> lifeCycles = new ArrayList<>();
            synchronized (this) {
                lifeCycles.addAll(ShutdownMonitor.this._lifeCycles);
            }
            for (LifeCycle l : lifeCycles) {
                try {
                    if (l.isStarted() && predicate.test(l)) {
                        l.stop();
                    }
                    if ((l instanceof Destroyable) && destroy) {
                        ((Destroyable) l).destroy();
                    }
                } catch (Throwable x) {
                    ShutdownMonitor.this.debug(x);
                }
            }
        }
    }
}
