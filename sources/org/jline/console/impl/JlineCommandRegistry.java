package org.jline.console.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jline.builtins.Completers;
import org.jline.builtins.Options;
import org.jline.console.ArgDesc;
import org.jline.console.CmdDesc;
import org.jline.console.CommandRegistry;
import org.jline.reader.Completer;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.utils.AttributedString;
import org.jline.utils.Log;

/* loaded from: grasscutter.jar:org/jline/console/impl/JlineCommandRegistry.class */
public abstract class JlineCommandRegistry extends AbstractCommandRegistry {
    @Override // org.jline.console.CommandRegistry
    public List<String> commandInfo(String command) {
        try {
            Object[] args = {"--help"};
            if (command.equals("help")) {
                args = new Object[0];
            }
            invoke(new CommandRegistry.CommandSession(), command, args);
            throw new IllegalArgumentException("JlineCommandRegistry.commandInfo() method must be overridden in class " + getClass().getCanonicalName());
        } catch (Options.HelpException e) {
            return compileCommandInfo(e.getMessage());
        } catch (Exception e2) {
            Log.info("Error while getting command info", e2);
            if (Log.isDebugEnabled()) {
                e2.printStackTrace();
            }
            return new ArrayList();
        }
    }

    @Override // org.jline.console.CommandRegistry
    public CmdDesc commandDescription(List<String> args) {
        try {
            invoke(new CommandRegistry.CommandSession(), (args == null || args.isEmpty()) ? "" : args.get(0), "--help");
        } catch (Options.HelpException e) {
            return compileCommandDescription(e.getMessage());
        } catch (Exception e2) {
        }
        throw new IllegalArgumentException("JlineCommandRegistry.commandDescription() method must be overridden in class " + getClass().getCanonicalName());
    }

    public List<Completers.OptDesc> commandOptions(String command) {
        try {
            invoke(new CommandRegistry.CommandSession(), command, "--help");
            return null;
        } catch (Options.HelpException e) {
            return compileCommandOptions(e.getMessage());
        } catch (Exception e2) {
            return null;
        }
    }

    public List<Completer> defaultCompleter(String command) {
        List<Completer> completers = new ArrayList<>();
        completers.add(new ArgumentCompleter(NullCompleter.INSTANCE, new Completers.OptionCompleter(NullCompleter.INSTANCE, this::commandOptions, 1)));
        return completers;
    }

    public Options parseOptions(String[] usage, Object[] args) throws Options.HelpException {
        Options opt = Options.compile(usage).parse(args);
        if (!opt.isSet("help")) {
            return opt;
        }
        throw new Options.HelpException(opt.usage());
    }

    private static AttributedString highlightComment(String comment) {
        return Options.HelpException.highlightComment(comment, Options.HelpException.defaultStyle());
    }

    private static String[] helpLines(String helpMessage, boolean body) {
        return new HelpLines(helpMessage, body).lines();
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/JlineCommandRegistry$HelpLines.class */
    public static class HelpLines {
        private final String helpMessage;
        private final boolean body;
        private boolean subcommands;

        public HelpLines(String helpMessage, boolean body) {
            this.helpMessage = helpMessage;
            this.body = body;
        }

        public String[] lines() {
            String out = "";
            Matcher tm = Pattern.compile("(^|\\n)(Usage|Summary)(:)").matcher(this.helpMessage);
            if (tm.find()) {
                this.subcommands = tm.group(2).matches("Summary");
                if (this.body) {
                    out = this.helpMessage.substring(tm.end(3));
                } else {
                    out = this.helpMessage.substring(0, tm.start(1));
                }
            } else if (!this.body) {
                out = this.helpMessage;
            }
            return out.split("\\r?\\n");
        }

        public boolean subcommands() {
            return this.subcommands;
        }
    }

    public static CmdDesc compileCommandDescription(String helpMessage) {
        List<AttributedString> main = new ArrayList<>();
        Map<String, List<AttributedString>> options = new HashMap<>();
        String prevOpt = null;
        boolean mainDone = false;
        HelpLines hl = new HelpLines(helpMessage, true);
        String[] lines = hl.lines();
        for (String s : lines) {
            if (s.matches("^\\s+-.*$")) {
                mainDone = true;
                int ind = s.lastIndexOf("  ");
                if (ind > 0) {
                    String o = s.substring(0, ind);
                    String d = s.substring(ind);
                    if (o.trim().length() > 0) {
                        prevOpt = o.trim();
                        options.put(prevOpt, new ArrayList<>(Collections.singletonList(highlightComment(d.trim()))));
                    }
                }
            } else if (!s.matches("^[\\s]{20}.*$") || prevOpt == null || !options.containsKey(prevOpt)) {
                prevOpt = null;
            } else {
                int ind2 = s.lastIndexOf("  ");
                if (ind2 > 0) {
                    options.get(prevOpt).add(highlightComment(s.substring(ind2).trim()));
                }
            }
            if (!mainDone) {
                main.add(Options.HelpException.highlightSyntax(s.trim(), Options.HelpException.defaultStyle(), hl.subcommands()));
            }
        }
        return new CmdDesc(main, ArgDesc.doArgNames(Collections.singletonList("")), options);
    }

    public static List<Completers.OptDesc> compileCommandOptions(String helpMessage) {
        int ind;
        List<Completers.OptDesc> out = new ArrayList<>();
        String[] helpLines = helpLines(helpMessage, true);
        for (String s : helpLines) {
            if (s.matches("^\\s+-.*$") && (ind = s.lastIndexOf("  ")) > 0) {
                String[] op = s.substring(0, ind).trim().split("\\s+");
                String d = s.substring(ind).trim();
                String so = null;
                String lo = null;
                if (op.length != 1) {
                    so = op[0];
                    lo = op[1];
                } else if (op[0].startsWith("--")) {
                    lo = op[0];
                } else {
                    so = op[0];
                }
                boolean hasValue = false;
                if (lo != null && lo.contains("=")) {
                    hasValue = true;
                    lo = lo.split("=")[0];
                }
                out.add(new Completers.OptDesc(so, lo, d, hasValue ? Completers.AnyCompleter.INSTANCE : null));
            }
        }
        return out;
    }

    public static List<String> compileCommandInfo(String helpMessage) {
        List<String> out = new ArrayList<>();
        boolean first = true;
        String[] helpLines = helpLines(helpMessage, false);
        for (String s : helpLines) {
            if (!first || !s.contains(" - ")) {
                out.add(s.trim());
            } else {
                out.add(s.substring(s.indexOf(" - ") + 3).trim());
            }
            first = false;
        }
        return out;
    }
}
