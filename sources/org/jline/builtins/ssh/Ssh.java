package org.jline.builtins.ssh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.apache.sshd.client.SshClient;
import org.apache.sshd.client.auth.keyboard.UserInteraction;
import org.apache.sshd.client.future.ConnectFuture;
import org.apache.sshd.client.session.ClientSession;
import org.apache.sshd.common.NamedResource;
import org.apache.sshd.common.config.keys.FilePasswordProvider;
import org.apache.sshd.common.session.SessionContext;
import org.apache.sshd.scp.server.ScpCommandFactory;
import org.apache.sshd.server.SshServer;
import org.apache.sshd.server.keyprovider.SimpleGeneratorHostKeyProvider;
import org.apache.sshd.server.session.ServerSession;
import org.apache.sshd.sftp.server.SftpSubsystemFactory;
import org.jline.builtins.Options;
import org.jline.reader.LineReader;
import org.jline.terminal.Attributes;
import org.jline.terminal.Terminal;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/builtins/ssh/Ssh.class */
public class Ssh {
    public static final String[] functions = {"ssh", "sshd"};
    private static final int defaultPort = 2022;
    private final Consumer<ShellParams> shell;
    private final Consumer<ExecuteParams> execute;
    private final Supplier<SshServer> serverBuilder;
    private final Supplier<SshClient> clientBuilder;
    private SshServer server;
    private int port;

    /* renamed from: ip */
    private String f3175ip;

    /* loaded from: grasscutter.jar:org/jline/builtins/ssh/Ssh$ShellParams.class */
    public static class ShellParams {
        private final Map<String, String> env;
        private final Terminal terminal;
        private final Runnable closer;
        private final ServerSession session;

        public ShellParams(Map<String, String> env, ServerSession session, Terminal terminal, Runnable closer) {
            this.env = env;
            this.session = session;
            this.terminal = terminal;
            this.closer = closer;
        }

        public Map<String, String> getEnv() {
            return this.env;
        }

        public ServerSession getSession() {
            return this.session;
        }

        public Terminal getTerminal() {
            return this.terminal;
        }

        public Runnable getCloser() {
            return this.closer;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/ssh/Ssh$ExecuteParams.class */
    public static class ExecuteParams {
        private final String command;
        private final Map<String, String> env;
        private final ServerSession session;

        /* renamed from: in */
        private final InputStream f3176in;
        private final OutputStream out;
        private final OutputStream err;

        public ExecuteParams(String command, Map<String, String> env, ServerSession session, InputStream in, OutputStream out, OutputStream err) {
            this.command = command;
            this.session = session;
            this.env = env;
            this.f3176in = in;
            this.out = out;
            this.err = err;
        }

        public String getCommand() {
            return this.command;
        }

        public Map<String, String> getEnv() {
            return this.env;
        }

        public ServerSession getSession() {
            return this.session;
        }

        public InputStream getIn() {
            return this.f3176in;
        }

        public OutputStream getOut() {
            return this.out;
        }

        public OutputStream getErr() {
            return this.err;
        }
    }

    public Ssh(Consumer<ShellParams> shell, Consumer<ExecuteParams> execute, Supplier<SshServer> serverBuilder, Supplier<SshClient> clientBuilder) {
        this.shell = shell;
        this.execute = execute;
        this.serverBuilder = serverBuilder;
        this.clientBuilder = clientBuilder;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0602
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void ssh(org.jline.terminal.Terminal r9, org.jline.reader.LineReader r10, java.lang.String r11, java.io.InputStream r12, java.io.PrintStream r13, java.io.PrintStream r14, java.lang.String[] r15) throws java.lang.Exception {
        /*
        // Method dump skipped, instructions count: 1700
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jline.builtins.ssh.Ssh.ssh(org.jline.terminal.Terminal, org.jline.reader.LineReader, java.lang.String, java.io.InputStream, java.io.PrintStream, java.io.PrintStream, java.lang.String[]):void");
    }

    private static int getFlag(Attributes attributes, Attributes.InputFlag flag) {
        return attributes.getInputFlag(flag) ? 1 : 0;
    }

    private static int getFlag(Attributes attributes, Attributes.OutputFlag flag) {
        return attributes.getOutputFlag(flag) ? 1 : 0;
    }

    private static int getFlag(Attributes attributes, Attributes.LocalFlag flag) {
        return attributes.getLocalFlag(flag) ? 1 : 0;
    }

    private ClientSession connectWithRetries(PrintWriter stdout, SshClient client, String username, String host, int port, int maxAttempts) throws Exception {
        ClientSession session = null;
        int retries = 0;
        do {
            ConnectFuture future = client.connect(username, host, port);
            future.await();
            try {
                session = (ClientSession) future.getSession();
            } catch (Exception ex) {
                retries++;
                if (retries < maxAttempts) {
                    Thread.sleep(2000);
                    stdout.println("retrying (attempt " + retries + ") ...");
                } else {
                    throw ex;
                }
            }
        } while (session == null);
        return session;
    }

    public void sshd(PrintStream stdout, PrintStream stderr, String[] argv) throws Exception {
        Options opt = Options.compile(new String[]{"sshd - start an ssh server", "Usage: sshd [-i ip] [-p port] start | stop | status", "  -i --ip=INTERFACE        listen interface (default=127.0.0.1)", "  -p --port=PORT           listen port (default=2022)", "  -? --help                show help"}).parse((Object[]) argv, true);
        List<String> args = opt.args();
        if (opt.isSet("help") || args.isEmpty()) {
            throw new Options.HelpException(opt.usage());
        }
        String command = args.get(0);
        if ("start".equals(command)) {
            if (this.server != null) {
                throw new IllegalStateException("sshd is already running on port " + this.port);
            }
            this.f3175ip = opt.get("ip");
            this.port = opt.getNumber("port");
            start();
            status(stdout);
        } else if ("stop".equals(command)) {
            if (this.server == null) {
                throw new IllegalStateException("sshd is not running.");
            }
            stop();
        } else if ("status".equals(command)) {
            status(stdout);
        } else {
            throw opt.usageError("bad command: " + command);
        }
    }

    private void status(PrintStream stdout) {
        if (this.server != null) {
            stdout.println("sshd is running on " + this.f3175ip + EmitterKt.COMMENT_PREFIX + this.port);
        } else {
            stdout.println("sshd is not running.");
        }
    }

    private void start() throws IOException {
        this.server = this.serverBuilder.get();
        this.server.setPort(this.port);
        this.server.setHost(this.f3175ip);
        this.server.setShellFactory(new ShellFactoryImpl(this.shell));
        this.server.setCommandFactory(new ScpCommandFactory.Builder().withDelegate(channel, command -> {
            return new ShellCommand(this.execute, command);
        }).build());
        this.server.setSubsystemFactories(Collections.singletonList(new SftpSubsystemFactory.Builder().build()));
        this.server.setKeyPairProvider(new SimpleGeneratorHostKeyProvider());
        this.server.start();
    }

    private void stop() throws IOException {
        try {
            this.server.stop();
        } finally {
            this.server = null;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/ssh/Ssh$JLineUserInteraction.class */
    private static class JLineUserInteraction implements UserInteraction, FilePasswordProvider {
        private final Terminal terminal;
        private final LineReader reader;
        private final PrintStream stderr;

        public JLineUserInteraction(Terminal terminal, LineReader reader, PrintStream stderr) {
            this.terminal = terminal;
            this.reader = reader;
            this.stderr = stderr;
        }

        public String getPassword(SessionContext session, NamedResource resourceKey, int retryIndex) throws IOException {
            return readLine("Enter password for " + resourceKey + EmitterKt.COMMENT_PREFIX, false);
        }

        public void welcome(ClientSession session, String banner, String lang) {
            this.terminal.writer().println(banner);
        }

        public String[] interactive(ClientSession s, String name, String instruction, String lang, String[] prompt, boolean[] echo) {
            String[] answers = new String[prompt.length];
            for (int i = 0; i < prompt.length; i++) {
                try {
                    answers[i] = readLine(prompt[i], echo[i]);
                } catch (Exception e) {
                    this.stderr.append((CharSequence) e.getClass().getSimpleName()).append((CharSequence) " while read prompts: ").println(e.getMessage());
                }
            }
            return answers;
        }

        public boolean isInteractionAllowed(ClientSession session) {
            return true;
        }

        public void serverVersionInfo(ClientSession session, List<String> lines) {
            for (String l : lines) {
                this.terminal.writer().append('\t').println(l);
            }
        }

        public String getUpdatedPassword(ClientSession session, String prompt, String lang) {
            try {
                return readLine(prompt, false);
            } catch (Exception e) {
                this.stderr.append((CharSequence) e.getClass().getSimpleName()).append((CharSequence) " while reading password: ").println(e.getMessage());
                return null;
            }
        }

        private String readLine(String prompt, boolean echo) {
            return this.reader.readLine(prompt + " ", echo ? null : (char) 0);
        }
    }
}
