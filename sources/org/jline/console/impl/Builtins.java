package org.jline.console.impl;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import org.jline.builtins.Commands;
import org.jline.builtins.Completers;
import org.jline.builtins.ConfigurationPath;
import org.jline.builtins.TTop;
import org.jline.console.CommandInput;
import org.jline.console.CommandMethods;
import org.jline.console.CommandRegistry;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.Widget;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

/* loaded from: grasscutter.jar:org/jline/console/impl/Builtins.class */
public class Builtins extends JlineCommandRegistry implements CommandRegistry {
    private final ConfigurationPath configPath;
    private final Function<String, Widget> widgetCreator;
    private final Supplier<Path> workDir;
    private LineReader reader;

    /* loaded from: grasscutter.jar:org/jline/console/impl/Builtins$Command.class */
    public enum Command {
        NANO,
        LESS,
        HISTORY,
        WIDGET,
        KEYMAP,
        SETOPT,
        SETVAR,
        UNSETOPT,
        TTOP,
        COLORS
    }

    public Builtins(Path workDir, ConfigurationPath configPath, Function<String, Widget> widgetCreator) {
        this((Set<Command>) null, () -> {
            return workDir;
        }, configPath, widgetCreator);
    }

    public Builtins(Set<Command> commands, Path workDir, ConfigurationPath configpath, Function<String, Widget> widgetCreator) {
        this(commands, () -> {
            return workDir;
        }, configpath, widgetCreator);
    }

    public Builtins(Supplier<Path> workDir, ConfigurationPath configPath, Function<String, Widget> widgetCreator) {
        this((Set<Command>) null, workDir, configPath, widgetCreator);
    }

    public Builtins(Set<Command> commands, Supplier<Path> workDir, ConfigurationPath configpath, Function<String, Widget> widgetCreator) {
        Set<Command> cmds;
        this.configPath = configpath;
        this.widgetCreator = widgetCreator;
        this.workDir = workDir;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        if (commands == null) {
            cmds = new HashSet<>(EnumSet.allOf(Command.class));
        } else {
            cmds = new HashSet<>(commands);
        }
        for (Command c : cmds) {
            hashMap.put(c, c.name().toLowerCase());
        }
        hashMap2.put(Command.NANO, new CommandMethods(this::nano, this::nanoCompleter));
        hashMap2.put(Command.LESS, new CommandMethods(this::less, this::lessCompleter));
        hashMap2.put(Command.HISTORY, new CommandMethods(this::history, this::historyCompleter));
        hashMap2.put(Command.WIDGET, new CommandMethods(this::widget, this::widgetCompleter));
        hashMap2.put(Command.KEYMAP, new CommandMethods(this::keymap, this::defaultCompleter));
        hashMap2.put(Command.SETOPT, new CommandMethods(this::setopt, this::setoptCompleter));
        hashMap2.put(Command.SETVAR, new CommandMethods(this::setvar, this::setvarCompleter));
        hashMap2.put(Command.UNSETOPT, new CommandMethods(this::unsetopt, this::unsetoptCompleter));
        hashMap2.put(Command.TTOP, new CommandMethods(this::ttop, this::defaultCompleter));
        hashMap2.put(Command.COLORS, new CommandMethods(this::colors, this::defaultCompleter));
        registerCommands(hashMap, hashMap2);
    }

    public void setLineReader(LineReader reader) {
        this.reader = reader;
    }

    private void less(CommandInput input) {
        try {
            Commands.less(input.terminal(), input.m29in(), input.out(), input.err(), this.workDir.get(), input.args(), this.configPath);
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void nano(CommandInput input) {
        try {
            Commands.nano(input.terminal(), input.out(), input.err(), this.workDir.get(), input.args(), this.configPath);
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void history(CommandInput input) {
        try {
            Commands.history(this.reader, input.out(), input.err(), this.workDir.get(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void widget(CommandInput input) {
        try {
            Commands.widget(this.reader, input.out(), input.err(), this.widgetCreator, input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void keymap(CommandInput input) {
        try {
            Commands.keymap(this.reader, input.out(), input.err(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void setopt(CommandInput input) {
        try {
            Commands.setopt(this.reader, input.out(), input.err(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void setvar(CommandInput input) {
        try {
            Commands.setvar(this.reader, input.out(), input.err(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void unsetopt(CommandInput input) {
        try {
            Commands.unsetopt(this.reader, input.out(), input.err(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void ttop(CommandInput input) {
        try {
            TTop.ttop(input.terminal(), input.out(), input.err(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private void colors(CommandInput input) {
        try {
            Commands.colors(input.terminal(), input.out(), input.args());
        } catch (Exception e) {
            saveException(e);
        }
    }

    private List<String> unsetOptions(boolean set) {
        List<String> out = new ArrayList<>();
        LineReader.Option[] values = LineReader.Option.values();
        for (LineReader.Option option : values) {
            if (set == (this.reader.isSet(option) == option.isDef())) {
                out.add((option.isDef() ? "no-" : "") + option.toString().toLowerCase().replace('_', '-'));
            }
        }
        return out;
    }

    private Set<String> allWidgets() {
        Set<String> out = new HashSet<>();
        for (String s : this.reader.getWidgets().keySet()) {
            out.add(s);
            out.add(this.reader.getWidgets().get(s).toString());
        }
        return out;
    }

    private List<Completer> nanoCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(new Completers.FilesCompleter(this.workDir), this::commandOptions, 1)));
        return completers;
    }

    private List<Completer> lessCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(new Completers.FilesCompleter(this.workDir), this::commandOptions, 1)));
        return completers;
    }

    private List<Completer> historyCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        List<Completers.OptDesc> optDescs = commandOptions(name);
        for (Completers.OptDesc o : optDescs) {
            if (o.shortOption() != null && (o.shortOption().equals("-A") || o.shortOption().equals("-W") || o.shortOption().equals("-R"))) {
                o.setValueCompleter(new Completers.FilesCompleter(this.workDir));
            }
        }
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(NullCompleter.INSTANCE, optDescs, 1)));
        return completers;
    }

    private List<Completer> widgetCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        List<Completers.OptDesc> optDescs = commandOptions(name);
        Candidate aliasOption = new Candidate("-A", "-A", null, null, null, null, true);
        Iterator<Completers.OptDesc> i = optDescs.iterator();
        while (i.hasNext()) {
            Completers.OptDesc o = i.next();
            if (o.shortOption() != null) {
                if (o.shortOption().equals("-D")) {
                    o.setValueCompleter(new StringsCompleter(() -> {
                        return this.reader.getWidgets().keySet();
                    }));
                } else if (o.shortOption().equals("-A")) {
                    aliasOption = new Candidate(o.shortOption(), o.shortOption(), null, o.description(), null, null, true);
                    i.remove();
                }
            }
        }
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(NullCompleter.INSTANCE, optDescs, 1)));
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new StringsCompleter(aliasOption), new StringsCompleter(this::allWidgets), new StringsCompleter(() -> {
            return this.reader.getWidgets().keySet();
        }), NullCompleter.INSTANCE));
        return completers;
    }

    private List<Completer> setvarCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new StringsCompleter(() -> {
            return this.reader.getVariables().keySet();
        }), NullCompleter.INSTANCE));
        return completers;
    }

    private List<Completer> setoptCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new StringsCompleter(() -> {
            return unsetOptions(true);
        })));
        return completers;
    }

    private List<Completer> unsetoptCompleter(String name) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new StringsCompleter(() -> {
            return unsetOptions(false);
        })));
        return completers;
    }
}
