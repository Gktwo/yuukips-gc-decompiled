package org.jline.console.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.jline.console.CmdDesc;
import org.jline.console.CommandInput;
import org.jline.console.CommandMethods;
import org.jline.console.CommandRegistry;
import org.jline.reader.impl.completer.SystemCompleter;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import p001ch.qos.logback.classic.net.SyslogAppender;

/* loaded from: grasscutter.jar:org/jline/console/impl/AbstractCommandRegistry.class */
public abstract class AbstractCommandRegistry implements CommandRegistry {
    private CmdRegistry cmdRegistry;
    private Exception exception;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/AbstractCommandRegistry$CmdRegistry.class */
    public interface CmdRegistry {
        boolean hasCommand(String str);

        Set<String> commandNames();

        Map<String, String> commandAliases();

        Object command(String str);

        <V extends Enum<V>> void rename(V v, String str);

        void alias(String str, String str2);

        SystemCompleter compileCompleters();

        CommandMethods getCommandMethods(String str);
    }

    public CmdDesc doHelpDesc(String command, List<String> info, CmdDesc cmdDesc) {
        List<AttributedString> mainDesc = new ArrayList<>();
        AttributedStringBuilder asb = new AttributedStringBuilder();
        asb.append((CharSequence) command.toLowerCase()).append((CharSequence) " -  ");
        for (String s : info) {
            if (asb.length() == 0) {
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            }
            asb.append((CharSequence) s);
            mainDesc.add(asb.toAttributedString());
            asb = new AttributedStringBuilder();
            asb.tabs(2);
        }
        AttributedStringBuilder asb2 = new AttributedStringBuilder();
        asb2.tabs(7);
        asb2.append((CharSequence) "Usage:");
        for (AttributedString as : cmdDesc.getMainDesc()) {
            asb2.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            asb2.append(as);
            mainDesc.add(asb2.toAttributedString());
            asb2 = new AttributedStringBuilder();
            asb2.tabs(7);
        }
        return new CmdDesc(mainDesc, new ArrayList(), cmdDesc.getOptsDesc());
    }

    public <T extends Enum<T>> void registerCommands(Map<T, String> commandName, Map<T, CommandMethods> commandExecute) {
        this.cmdRegistry = new EnumCmdRegistry(commandName, commandExecute);
    }

    public void registerCommands(Map<String, CommandMethods> commandExecute) {
        this.cmdRegistry = new NameCmdRegistry(commandExecute);
    }

    @Override // org.jline.console.CommandRegistry
    public Object invoke(CommandRegistry.CommandSession session, String command, Object... args) throws Exception {
        this.exception = null;
        Object out = getCommandMethods(command).execute().apply(new CommandInput(command, args, session));
        if (this.exception == null) {
            return out;
        }
        throw this.exception;
    }

    public void saveException(Exception exception) {
        this.exception = exception;
    }

    @Override // org.jline.console.CommandRegistry
    public boolean hasCommand(String command) {
        return this.cmdRegistry.hasCommand(command);
    }

    @Override // org.jline.console.CommandRegistry
    public Set<String> commandNames() {
        return this.cmdRegistry.commandNames();
    }

    @Override // org.jline.console.CommandRegistry
    public Map<String, String> commandAliases() {
        return this.cmdRegistry.commandAliases();
    }

    public <V extends Enum<V>> void rename(V command, String newName) {
        this.cmdRegistry.rename(command, newName);
    }

    public void alias(String alias, String command) {
        this.cmdRegistry.alias(alias, command);
    }

    @Override // org.jline.console.CommandRegistry
    public SystemCompleter compileCompleters() {
        return this.cmdRegistry.compileCompleters();
    }

    public CommandMethods getCommandMethods(String command) {
        return this.cmdRegistry.getCommandMethods(command);
    }

    public Object registeredCommand(String command) {
        return this.cmdRegistry.command(command);
    }

    /* loaded from: grasscutter.jar:org/jline/console/impl/AbstractCommandRegistry$EnumCmdRegistry.class */
    private static class EnumCmdRegistry<T extends Enum<T>> implements CmdRegistry {
        private final Map<T, String> commandName;
        private final Map<T, CommandMethods> commandExecute;
        private Map<String, T> nameCommand = new HashMap();
        private final Map<String, String> aliasCommand = new HashMap();

        public EnumCmdRegistry(Map<T, String> commandName, Map<T, CommandMethods> commandExecute) {
            this.commandName = commandName;
            this.commandExecute = commandExecute;
            doNameCommand();
        }

        private void doNameCommand() {
            this.nameCommand = (Map) this.commandName.entrySet().stream().collect(Collectors.toMap((v0) -> {
                return v0.getValue();
            }, (v0) -> {
                return v0.getKey();
            }));
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public Set<String> commandNames() {
            return this.nameCommand.keySet();
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public Map<String, String> commandAliases() {
            return this.aliasCommand;
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public <V extends Enum<V>> void rename(V command, String newName) {
            if (this.nameCommand.containsKey(newName)) {
                throw new IllegalArgumentException("Duplicate command name!");
            } else if (!this.commandName.containsKey(command)) {
                throw new IllegalArgumentException("Command does not exists!");
            } else {
                this.commandName.put(command, newName);
                doNameCommand();
            }
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public void alias(String alias, String command) {
            if (!this.nameCommand.containsKey(command)) {
                throw new IllegalArgumentException("Command does not exists!");
            }
            this.aliasCommand.put(alias, command);
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public boolean hasCommand(String name) {
            return this.nameCommand.containsKey(name) || this.aliasCommand.containsKey(name);
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public SystemCompleter compileCompleters() {
            SystemCompleter out = new SystemCompleter();
            for (Map.Entry<T, String> entry : this.commandName.entrySet()) {
                out.add(entry.getValue(), this.commandExecute.get(entry.getKey()).compileCompleter().apply(entry.getValue()));
            }
            out.addAliases(this.aliasCommand);
            return out;
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public T command(String name) {
            if (!hasCommand(name)) {
                throw new IllegalArgumentException("Command does not exists!");
            }
            if (this.aliasCommand.containsKey(name)) {
                name = this.aliasCommand.get(name);
            }
            if (this.nameCommand.containsKey(name)) {
                return this.nameCommand.get(name);
            }
            throw new IllegalArgumentException("Command does not exists!");
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public CommandMethods getCommandMethods(String command) {
            return this.commandExecute.get(command(command));
        }
    }

    /* loaded from: grasscutter.jar:org/jline/console/impl/AbstractCommandRegistry$NameCmdRegistry.class */
    private static class NameCmdRegistry implements CmdRegistry {
        private final Map<String, CommandMethods> commandExecute;
        private final Map<String, String> aliasCommand = new HashMap();

        public NameCmdRegistry(Map<String, CommandMethods> commandExecute) {
            this.commandExecute = commandExecute;
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public Set<String> commandNames() {
            return this.commandExecute.keySet();
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public Map<String, String> commandAliases() {
            return this.aliasCommand;
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public <V extends Enum<V>> void rename(V command, String newName) {
            throw new IllegalArgumentException();
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public void alias(String alias, String command) {
            if (!this.commandExecute.containsKey(command)) {
                throw new IllegalArgumentException("Command does not exists!");
            }
            this.aliasCommand.put(alias, command);
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public boolean hasCommand(String name) {
            return this.commandExecute.containsKey(name) || this.aliasCommand.containsKey(name);
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public SystemCompleter compileCompleters() {
            SystemCompleter out = new SystemCompleter();
            for (String c : this.commandExecute.keySet()) {
                out.add(c, this.commandExecute.get(c).compileCompleter().apply(c));
            }
            out.addAliases(this.aliasCommand);
            return out;
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public String command(String name) {
            if (this.commandExecute.containsKey(name)) {
                return name;
            }
            if (this.aliasCommand.containsKey(name)) {
                return this.aliasCommand.get(name);
            }
            return null;
        }

        @Override // org.jline.console.impl.AbstractCommandRegistry.CmdRegistry
        public CommandMethods getCommandMethods(String command) {
            return this.commandExecute.get(command(command));
        }
    }
}
