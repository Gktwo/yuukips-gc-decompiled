package org.jline.builtins.ssh;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.sshd.server.Environment;
import org.apache.sshd.server.ExitCallback;
import org.apache.sshd.server.channel.ChannelSession;
import org.apache.sshd.server.command.Command;
import org.apache.sshd.server.session.ServerSession;
import org.jline.builtins.ssh.Ssh;

/* loaded from: grasscutter.jar:org/jline/builtins/ssh/ShellCommand.class */
public class ShellCommand implements Command {
    private static final Logger LOGGER = Logger.getLogger(ShellCommand.class.getName());
    private final Consumer<Ssh.ExecuteParams> execute;
    private final String command;

    /* renamed from: in */
    private InputStream f3173in;
    private OutputStream out;
    private OutputStream err;
    private ExitCallback callback;
    private ServerSession session;
    private Environment env;

    public ShellCommand(Consumer<Ssh.ExecuteParams> execute, String command) {
        this.execute = execute;
        this.command = command;
    }

    public void setInputStream(InputStream in) {
        this.f3173in = in;
    }

    public void setOutputStream(OutputStream out) {
        this.out = out;
    }

    public void setErrorStream(OutputStream err) {
        this.err = err;
    }

    public void setExitCallback(ExitCallback callback) {
        this.callback = callback;
    }

    public void start(ChannelSession channel, Environment env) throws IOException {
        this.session = channel.getSession();
        this.env = env;
        new Thread(this::run).start();
    }

    private void run() {
        int exitStatus = 0;
        try {
            try {
                this.execute.accept(new Ssh.ExecuteParams(this.command, this.env.getEnv(), this.session, this.f3173in, this.out, this.err));
                ShellFactoryImpl.close(this.f3173in, this.out, this.err);
                this.callback.onExit(0);
            } catch (RuntimeException e) {
                exitStatus = 1;
                LOGGER.log(Level.SEVERE, "Unable to start shell", (Throwable) e);
                try {
                    this.err.write((e.getCause() != null ? e.getCause() : e).toString().getBytes());
                    this.err.flush();
                } catch (IOException e2) {
                }
                ShellFactoryImpl.close(this.f3173in, this.out, this.err);
                this.callback.onExit(1);
            }
        } catch (Throwable th) {
            ShellFactoryImpl.close(this.f3173in, this.out, this.err);
            this.callback.onExit(exitStatus);
            throw th;
        }
    }

    public void destroy(ChannelSession channel) {
    }
}
