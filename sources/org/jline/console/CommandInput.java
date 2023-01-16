package org.jline.console;

import java.io.InputStream;
import java.io.PrintStream;
import org.jline.console.CommandRegistry;
import org.jline.terminal.Terminal;

/* loaded from: grasscutter.jar:org/jline/console/CommandInput.class */
public class CommandInput {
    String command;
    String[] args;
    Object[] xargs;
    Terminal terminal;

    /* renamed from: in */
    InputStream f3226in;
    PrintStream out;
    PrintStream err;

    public CommandInput(String command, Object[] xargs, CommandRegistry.CommandSession session) {
        if (xargs != null) {
            this.xargs = xargs;
            this.args = new String[xargs.length];
            for (int i = 0; i < xargs.length; i++) {
                this.args[i] = xargs[i] != null ? xargs[i].toString() : null;
            }
        }
        this.command = command;
        this.terminal = session.terminal();
        this.f3226in = session.m28in();
        this.out = session.out();
        this.err = session.err();
    }

    public CommandInput(String command, Object[] args, Terminal terminal, InputStream in, PrintStream out, PrintStream err) {
        this(command, args, new CommandRegistry.CommandSession(terminal, in, out, err));
    }

    public String command() {
        return this.command;
    }

    public String[] args() {
        return this.args;
    }

    public Object[] xargs() {
        return this.xargs;
    }

    public Terminal terminal() {
        return this.terminal;
    }

    /* renamed from: in */
    public InputStream m29in() {
        return this.f3226in;
    }

    public PrintStream out() {
        return this.out;
    }

    public PrintStream err() {
        return this.err;
    }

    public CommandRegistry.CommandSession session() {
        return new CommandRegistry.CommandSession(this.terminal, this.f3226in, this.out, this.err);
    }
}
