package org.jline.console;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.jline.builtins.ConsoleOptionGetter;
import org.jline.reader.Completer;
import org.jline.reader.ParsedLine;
import org.jline.terminal.Terminal;

/* loaded from: grasscutter.jar:org/jline/console/SystemRegistry.class */
public interface SystemRegistry extends CommandRegistry, ConsoleOptionGetter {
    void setCommandRegistries(CommandRegistry... commandRegistryArr);

    void register(String str, CommandRegistry commandRegistry);

    void initialize(File file);

    Collection<String> getPipeNames();

    Completer completer();

    CmdDesc commandDescription(CmdLine cmdLine);

    Object execute(String str) throws Exception;

    void cleanUp();

    void trace(Throwable th);

    void trace(boolean z, Throwable th);

    @Override // org.jline.builtins.ConsoleOptionGetter
    Object consoleOption(String str);

    Terminal terminal();

    Object invoke(String str, Object... objArr) throws Exception;

    boolean isCommandOrScript(ParsedLine parsedLine);

    boolean isCommandOrScript(String str);

    boolean isCommandAlias(String str);

    void close();

    static SystemRegistry get() {
        return Registeries.getInstance().getSystemRegistry();
    }

    static void add(SystemRegistry systemRegistry) {
        Registeries.getInstance().addRegistry(systemRegistry);
    }

    static void remove() {
        Registeries.getInstance().removeRegistry();
    }

    /* loaded from: grasscutter.jar:org/jline/console/SystemRegistry$Registeries.class */
    public static class Registeries {
        private static final Registeries instance = new Registeries();
        private final Map<Long, SystemRegistry> systemRegisteries = new HashMap();

        private Registeries() {
        }

        protected static Registeries getInstance() {
            return instance;
        }

        protected void addRegistry(SystemRegistry systemRegistry) {
            this.systemRegisteries.put(Long.valueOf(Thread.currentThread().getId()), systemRegistry);
        }

        protected SystemRegistry getSystemRegistry() {
            return this.systemRegisteries.getOrDefault(Long.valueOf(Thread.currentThread().getId()), null);
        }

        protected void removeRegistry() {
            this.systemRegisteries.remove(Long.valueOf(Thread.currentThread().getId()));
        }
    }
}
