package org.jline.console;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jline.reader.impl.completer.SystemCompleter;
import org.jline.terminal.Terminal;

/* loaded from: grasscutter.jar:org/jline/console/CommandRegistry.class */
public interface CommandRegistry {
    Set<String> commandNames();

    Map<String, String> commandAliases();

    List<String> commandInfo(String str);

    boolean hasCommand(String str);

    SystemCompleter compileCompleters();

    CmdDesc commandDescription(List<String> list);

    static SystemCompleter aggregateCompleters(CommandRegistry... commandRegistries) {
        SystemCompleter out = new SystemCompleter();
        for (CommandRegistry r : commandRegistries) {
            out.add(r.compileCompleters());
        }
        return out;
    }

    static SystemCompleter compileCompleters(CommandRegistry... commandRegistries) {
        SystemCompleter out = aggregateCompleters(commandRegistries);
        out.compile();
        return out;
    }

    default String name() {
        return getClass().getSimpleName();
    }

    default Object invoke(CommandSession session, String command, Object... args) throws Exception {
        throw new IllegalStateException("CommandRegistry method invoke(session, command, ... args) is not implemented!");
    }

    /* loaded from: grasscutter.jar:org/jline/console/CommandRegistry$CommandSession.class */
    public static class CommandSession {
        private final Terminal terminal;

        /* renamed from: in */
        private final InputStream f3191in;
        private final PrintStream out;
        private final PrintStream err;

        public CommandSession() {
            this.f3191in = System.in;
            this.out = System.out;
            this.err = System.err;
            this.terminal = null;
        }

        public CommandSession(Terminal terminal) {
            this(terminal, terminal.input(), new PrintStream(terminal.output()), new PrintStream(terminal.output()));
        }

        public CommandSession(Terminal terminal, InputStream in, PrintStream out, PrintStream err) {
            this.terminal = terminal;
            this.f3191in = in;
            this.out = out;
            this.err = err;
        }

        public Terminal terminal() {
            return this.terminal;
        }

        /* renamed from: in */
        public InputStream m28in() {
            return this.f3191in;
        }

        public PrintStream out() {
            return this.out;
        }

        public PrintStream err() {
            return this.err;
        }
    }
}
