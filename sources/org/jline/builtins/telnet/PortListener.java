package org.jline.builtins.telnet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/PortListener.class */
public class PortListener implements Runnable {
    private static final Logger LOG = Logger.getLogger(PortListener.class.getName());
    private static final String logmsg = "Listening to Port {0,number,integer} with a connectivity queue size of {1,number,integer}.";
    private String name;

    /* renamed from: ip */
    private String f3213ip;
    private int port;
    private int floodProtection;
    private Thread thread;
    private ConnectionManager connectionManager;
    private ServerSocket serverSocket = null;
    private boolean stopping = false;
    private boolean available = false;

    public PortListener(String name, String ip, int port, int floodprot) {
        this.name = name;
        this.f3213ip = ip;
        this.port = port;
        this.floodProtection = floodprot;
    }

    public String getName() {
        return this.name;
    }

    public boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(boolean b) {
        this.available = b;
    }

    public void start() {
        LOG.log(Level.FINE, "start()");
        this.thread = new Thread(this);
        this.thread.start();
        this.available = true;
    }

    public void stop() {
        LOG.log(Level.FINE, "stop()::" + toString());
        this.stopping = true;
        this.available = false;
        this.connectionManager.stop();
        try {
            this.serverSocket.close();
        } catch (IOException ex) {
            LOG.log(Level.SEVERE, "stop()", (Throwable) ex);
        }
        try {
            this.thread.join();
        } catch (InterruptedException iex) {
            LOG.log(Level.SEVERE, "stop()", (Throwable) iex);
        }
        LOG.info("stop()::Stopped " + toString());
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            this.serverSocket = new ServerSocket(this.port, this.floodProtection, this.f3213ip != null ? InetAddress.getByName(this.f3213ip) : null);
            LOG.info(MessageFormat.format(logmsg, Integer.valueOf(this.port), Integer.valueOf(this.floodProtection)));
            do {
                Socket s = this.serverSocket.accept();
                if (this.available) {
                    this.connectionManager.makeConnection(s);
                } else {
                    try {
                        s.close();
                    } catch (SocketException ex) {
                        if (this.stopping) {
                            LOG.log(Level.FINE, "run(): ServerSocket closed by stop()");
                        } else {
                            LOG.log(Level.SEVERE, "run()", (Throwable) ex);
                        }
                    }
                }
            } while (!this.stopping);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "run()", (Throwable) e);
        }
        LOG.log(Level.FINE, "run(): returning.");
    }

    public ConnectionManager getConnectionManager() {
        return this.connectionManager;
    }

    public void setConnectionManager(ConnectionManager connectionManager) {
        this.connectionManager = connectionManager;
    }
}
