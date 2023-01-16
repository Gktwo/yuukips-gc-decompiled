package p001ch.qos.logback.core.net.server;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import p001ch.qos.logback.core.net.server.Client;
import p001ch.qos.logback.core.spi.ContextAwareBase;

/* renamed from: ch.qos.logback.core.net.server.ConcurrentServerRunner */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/ConcurrentServerRunner.class */
public abstract class ConcurrentServerRunner<T extends Client> extends ContextAwareBase implements Runnable, ServerRunner<T> {
    private final Lock clientsLock = new ReentrantLock();
    private final Collection<T> clients = new ArrayList();
    private final ServerListener<T> listener;
    private final Executor executor;
    private boolean running;

    protected abstract boolean configureClient(T t);

    public ConcurrentServerRunner(ServerListener<T> listener, Executor executor) {
        this.listener = listener;
        this.executor = executor;
    }

    @Override // p001ch.qos.logback.core.net.server.ServerRunner
    public boolean isRunning() {
        return this.running;
    }

    protected void setRunning(boolean running) {
        this.running = running;
    }

    @Override // p001ch.qos.logback.core.net.server.ServerRunner
    public void stop() throws IOException {
        this.listener.close();
        accept(new ClientVisitor<T>() { // from class: ch.qos.logback.core.net.server.ConcurrentServerRunner.1
            @Override // p001ch.qos.logback.core.net.server.ClientVisitor
            public void visit(T client) {
                client.close();
            }
        });
    }

    @Override // p001ch.qos.logback.core.net.server.ServerRunner
    public void accept(ClientVisitor<T> visitor) {
        for (T client : copyClients()) {
            try {
                visitor.visit(client);
            } catch (RuntimeException ex) {
                addError(client + ": " + ex);
            }
        }
    }

    private Collection<T> copyClients() {
        this.clientsLock.lock();
        try {
            return new ArrayList<>(this.clients);
        } finally {
            this.clientsLock.unlock();
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:10:0x006f
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.Runnable
    public void run() {
        /*
            r6 = this;
            r0 = r6
            r1 = 1
            r0.setRunning(r1)
            r0 = r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r2 = r1
            r2.<init>()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.String r2 = "listening on "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r2 = r6
            ch.qos.logback.core.net.server.ServerListener<T extends ch.qos.logback.core.net.server.Client> r2 = r2.listener     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.String r1 = r1.toString()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r0.addInfo(r1)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
        L_0x001f:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            boolean r0 = r0.isInterrupted()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            if (r0 != 0) goto L_0x0090
            r0 = r6
            ch.qos.logback.core.net.server.ServerListener<T extends ch.qos.logback.core.net.server.Client> r0 = r0.listener     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            ch.qos.logback.core.net.server.Client r0 = r0.acceptClient()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r7 = r0
            r0 = r6
            r1 = r7
            boolean r0 = r0.configureClient(r1)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            if (r0 != 0) goto L_0x005a
            r0 = r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r2 = r1
            r2.<init>()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r2 = r7
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.String r2 = ": connection dropped"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.String r1 = r1.toString()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r0.addError(r1)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r0 = r7
            r0.close()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            goto L_0x001f
        L_0x005a:
            r0 = r6
            java.util.concurrent.Executor r0 = r0.executor     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097, RejectedExecutionException -> 0x006f
            ch.qos.logback.core.net.server.ConcurrentServerRunner$ClientWrapper r1 = new ch.qos.logback.core.net.server.ConcurrentServerRunner$ClientWrapper     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097, RejectedExecutionException -> 0x006f
            r2 = r1
            r3 = r6
            r4 = r7
            r2.<init>(r4)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097, RejectedExecutionException -> 0x006f
            r0.execute(r1)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097, RejectedExecutionException -> 0x006f
            goto L_0x008d
        L_0x006f:
            r8 = move-exception
            r0 = r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r2 = r1
            r2.<init>()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r2 = r7
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.String r2 = ": connection dropped"
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            java.lang.String r1 = r1.toString()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r0.addError(r1)     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
            r0 = r7
            r0.close()     // Catch: InterruptedException -> 0x0093, Exception -> 0x0097
        L_0x008d:
            goto L_0x001f
        L_0x0090:
            goto L_0x00af
        L_0x0093:
            r7 = move-exception
            goto L_0x00af
        L_0x0097:
            r7 = move-exception
            r0 = r6
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r2 = r1
            r2.<init>()
            java.lang.String r2 = "listener: "
            java.lang.StringBuilder r1 = r1.append(r2)
            r2 = r7
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.addError(r1)
        L_0x00af:
            r0 = r6
            r1 = 0
            r0.setRunning(r1)
            r0 = r6
            java.lang.String r1 = "shutting down"
            r0.addInfo(r1)
            r0 = r6
            ch.qos.logback.core.net.server.ServerListener<T extends ch.qos.logback.core.net.server.Client> r0 = r0.listener
            r0.close()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p001ch.qos.logback.core.net.server.ConcurrentServerRunner.run():void");
    }

    /* access modifiers changed from: private */
    public void addClient(T client) {
        this.clientsLock.lock();
        try {
            this.clients.add(client);
        } finally {
            this.clientsLock.unlock();
        }
    }

    /* access modifiers changed from: private */
    public void removeClient(T client) {
        this.clientsLock.lock();
        try {
            this.clients.remove(client);
        } finally {
            this.clientsLock.unlock();
        }
    }

    /* JADX WARN: Incorrect field signature: TT; */
    /* renamed from: ch.qos.logback.core.net.server.ConcurrentServerRunner$ClientWrapper */
    /* loaded from: grasscutter.jar:ch/qos/logback/core/net/server/ConcurrentServerRunner$ClientWrapper.class */
    private class ClientWrapper implements Client {
        private final Client delegate;

        public ClientWrapper(T client) {
            this.delegate = client;
        }

        @Override // java.lang.Runnable
        public void run() {
            ConcurrentServerRunner.this.addClient(this.delegate);
            try {
                this.delegate.run();
            } finally {
                ConcurrentServerRunner.this.removeClient(this.delegate);
            }
        }

        @Override // p001ch.qos.logback.core.net.server.Client, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this.delegate.close();
        }
    }
}
