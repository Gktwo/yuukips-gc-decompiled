package org.jline.builtins.telnet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import kcp.highway.Kcp;
import org.jline.builtins.Options;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/Telnet.class */
public class Telnet {
    public static final String[] functions = {"telnetd"};
    private static final int defaultPort = 2019;
    private final Terminal terminal;
    private final ShellProvider provider;
    private PortListener portListener;
    private ConnectionManager connectionManager;
    private int port;

    /* renamed from: ip */
    private String f3214ip;

    /* loaded from: grasscutter.jar:org/jline/builtins/telnet/Telnet$ShellProvider.class */
    public interface ShellProvider {
        void shell(Terminal terminal, Map<String, String> map);
    }

    public Telnet(Terminal terminal, ShellProvider provider) {
        this.terminal = terminal;
        this.provider = provider;
    }

    public void telnetd(String[] argv) throws Exception {
        Options opt = Options.compile(new String[]{"telnetd - start simple telnet server", "Usage: telnetd [-i ip] [-p port] start | stop | status", "  -i --ip=INTERFACE        listen interface (default=127.0.0.1)", "  -p --port=PORT           listen port (default=2019)", "  -? --help                show help"}).parse((Object[]) argv, true);
        List<String> args = opt.args();
        if (opt.isSet("help") || args.isEmpty()) {
            throw new Options.HelpException(opt.usage());
        }
        String command = args.get(0);
        if ("start".equals(command)) {
            if (this.portListener != null) {
                throw new IllegalStateException("telnetd is already running on port " + this.port);
            }
            this.f3214ip = opt.get("ip");
            this.port = opt.getNumber("port");
            start();
            status();
        } else if ("stop".equals(command)) {
            if (this.portListener == null) {
                throw new IllegalStateException("telnetd is not running.");
            }
            stop();
        } else if ("status".equals(command)) {
            status();
        } else {
            throw opt.usageError("bad command: " + command);
        }
    }

    private void status() {
        if (this.portListener != null) {
            System.out.println("telnetd is running on " + this.f3214ip + EmitterKt.COMMENT_PREFIX + this.port);
        } else {
            System.out.println("telnetd is not running.");
        }
    }

    private void start() throws IOException {
        this.connectionManager = new ConnectionManager(1000, 300000, 300000, Kcp.IKCP_RTO_MAX, null, null, false) { // from class: org.jline.builtins.telnet.Telnet.1
            @Override // org.jline.builtins.telnet.ConnectionManager
            protected Connection createConnection(ThreadGroup threadGroup, ConnectionData newCD) {
                return new Connection(threadGroup, newCD) { // from class: org.jline.builtins.telnet.Telnet.1.1
                    TelnetIO telnetIO;

                    @Override // org.jline.builtins.telnet.Connection
                    protected void doRun() throws Exception {
                        this.telnetIO = new TelnetIO();
                        this.telnetIO.setConnection(this);
                        this.telnetIO.initIO();
                        final Terminal terminal = TerminalBuilder.builder().type(getConnectionData().getNegotiatedTerminalType().toLowerCase()).streams(new InputStream() { // from class: org.jline.builtins.telnet.Telnet.1.1.1
                            @Override // java.io.InputStream
                            public int read() throws IOException {
                                return C58411.this.telnetIO.read();
                            }

                            @Override // java.io.InputStream
                            public int read(byte[] b, int off, int len) throws IOException {
                                int r = read();
                                if (r < 0) {
                                    return -1;
                                }
                                b[off] = (byte) r;
                                return 1;
                            }
                        }, new PrintStream(new OutputStream() { // from class: org.jline.builtins.telnet.Telnet.1.1.2
                            @Override // java.io.OutputStream
                            public void write(int b) throws IOException {
                                C58411.this.telnetIO.write(b);
                            }

                            @Override // java.io.OutputStream, java.io.Flushable
                            public void flush() throws IOException {
                                C58411.this.telnetIO.flush();
                            }
                        })).system(false).name("telnet").build();
                        terminal.setSize(new Size(getConnectionData().getTerminalColumns(), getConnectionData().getTerminalRows()));
                        terminal.setAttributes(Telnet.this.terminal.getAttributes());
                        addConnectionListener(new ConnectionListener() { // from class: org.jline.builtins.telnet.Telnet.1.1.3
                            @Override // org.jline.builtins.telnet.ConnectionListener
                            public void connectionTerminalGeometryChanged(ConnectionEvent ce) {
                                terminal.setSize(new Size(C58411.this.getConnectionData().getTerminalColumns(), C58411.this.getConnectionData().getTerminalRows()));
                                terminal.raise(Terminal.Signal.WINCH);
                            }
                        });
                        try {
                            Telnet.this.provider.shell(terminal, getConnectionData().getEnvironment());
                            close();
                        } catch (Throwable th) {
                            close();
                            throw th;
                        }
                    }

                    @Override // org.jline.builtins.telnet.Connection
                    protected void doClose() throws Exception {
                        this.telnetIO.closeOutput();
                        this.telnetIO.closeInput();
                    }
                };
            }
        };
        this.connectionManager.start();
        this.portListener = new PortListener("gogo", this.f3214ip, this.port, 10);
        this.portListener.setConnectionManager(this.connectionManager);
        this.portListener.start();
    }

    private void stop() throws IOException {
        this.portListener.stop();
        this.portListener = null;
        this.connectionManager.stop();
        this.connectionManager = null;
    }
}
