package org.jline.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import org.jline.builtins.Options;
import org.jline.console.ArgDesc;
import org.jline.console.CmdDesc;
import org.jline.console.CmdLine;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.Buffer;
import org.jline.reader.LineReader;
import org.jline.reader.Reference;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.InfoCmp;
import org.jline.utils.StyleResolver;
import p001ch.qos.logback.classic.net.SyslogAppender;

/* loaded from: grasscutter.jar:org/jline/widget/TailTipWidgets.class */
public class TailTipWidgets extends Widgets {
    private boolean enabled;
    private final CommandDescriptions cmdDescs;
    private TipType tipType;
    private int descriptionSize;
    private boolean descriptionEnabled;
    private boolean descriptionCache;
    private Object readerErrors;

    /* loaded from: grasscutter.jar:org/jline/widget/TailTipWidgets$TipType.class */
    public enum TipType {
        TAIL_TIP,
        COMPLETER,
        COMBINED
    }

    public TailTipWidgets(LineReader reader, Map<String, CmdDesc> tailTips) {
        this(reader, tailTips, 0, TipType.COMBINED);
    }

    public TailTipWidgets(LineReader reader, Map<String, CmdDesc> tailTips, TipType tipType) {
        this(reader, tailTips, 0, tipType);
    }

    public TailTipWidgets(LineReader reader, Map<String, CmdDesc> tailTips, int descriptionSize) {
        this(reader, tailTips, descriptionSize, TipType.COMBINED);
    }

    public TailTipWidgets(LineReader reader, Map<String, CmdDesc> tailTips, int descriptionSize, TipType tipType) {
        this(reader, tailTips, descriptionSize, tipType, null);
    }

    public TailTipWidgets(LineReader reader, Function<CmdLine, CmdDesc> descFun, int descriptionSize, TipType tipType) {
        this(reader, null, descriptionSize, tipType, descFun);
    }

    private TailTipWidgets(LineReader reader, Map<String, CmdDesc> tailTips, int descriptionSize, TipType tipType, Function<CmdLine, CmdDesc> descFun) {
        super(reader);
        this.enabled = false;
        this.descriptionEnabled = true;
        this.descriptionCache = false;
        if (existsWidget("_tailtip-accept-line")) {
            throw new IllegalStateException("TailTipWidgets already created!");
        }
        this.cmdDescs = tailTips != null ? new CommandDescriptions(tailTips) : new CommandDescriptions(descFun);
        this.descriptionSize = descriptionSize;
        this.tipType = tipType;
        addWidget("_tailtip-accept-line", this::tailtipAcceptLine);
        addWidget("_tailtip-self-insert", this::tailtipInsert);
        addWidget("_tailtip-backward-delete-char", this::tailtipBackwardDelete);
        addWidget("_tailtip-delete-char", this::tailtipDelete);
        addWidget("_tailtip-expand-or-complete", this::tailtipComplete);
        addWidget("_tailtip-redisplay", this::tailtipUpdateStatus);
        addWidget("_tailtip-kill-line", this::tailtipKillLine);
        addWidget("_tailtip-kill-whole-line", this::tailtipKillWholeLine);
        addWidget(Widgets.TAILTIP_PANE, this::toggleWindow);
        addWidget(Widgets.TAILTIP_TOGGLE, this::toggleKeyBindings);
    }

    public void setTailTips(Map<String, CmdDesc> tailTips) {
        this.cmdDescs.setDescriptions(tailTips);
    }

    public void setDescriptionSize(int descriptionSize) {
        this.descriptionSize = descriptionSize;
        initDescription(descriptionSize);
    }

    public int getDescriptionSize() {
        return this.descriptionSize;
    }

    public void setTipType(TipType type) {
        this.tipType = type;
        if (this.tipType == TipType.TAIL_TIP) {
            setSuggestionType(LineReader.SuggestionType.TAIL_TIP);
        } else {
            setSuggestionType(LineReader.SuggestionType.COMPLETER);
        }
    }

    public TipType getTipType() {
        return this.tipType;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void disable() {
        if (this.enabled) {
            toggleKeyBindings();
        }
    }

    public void enable() {
        if (!this.enabled) {
            toggleKeyBindings();
        }
    }

    public void setDescriptionCache(boolean cache) {
        this.descriptionCache = cache;
    }

    public boolean tailtipComplete() {
        if (!doTailTip(LineReader.EXPAND_OR_COMPLETE)) {
            return false;
        }
        if (!lastBinding().equals(SyslogAppender.DEFAULT_STACKTRACE_PATTERN)) {
            return true;
        }
        callWidget(LineReader.BACKWARD_CHAR);
        this.reader.runMacro(KeyMap.key(this.reader.getTerminal(), InfoCmp.Capability.key_right));
        return true;
    }

    public boolean tailtipAcceptLine() {
        if (this.tipType != TipType.TAIL_TIP) {
            setSuggestionType(LineReader.SuggestionType.COMPLETER);
        }
        clearDescription();
        setErrorPattern(null);
        setErrorIndex(-1);
        this.cmdDescs.clearTemporaryDescs();
        return clearTailTip(LineReader.ACCEPT_LINE);
    }

    public boolean tailtipBackwardDelete() {
        return doTailTip(autopairEnabled() ? "_autopair-backward-delete-char" : LineReader.BACKWARD_DELETE_CHAR);
    }

    private boolean clearTailTip(String widget) {
        clearTailTip();
        callWidget(widget);
        return true;
    }

    public boolean tailtipDelete() {
        clearTailTip();
        return doTailTip(LineReader.DELETE_CHAR);
    }

    public boolean tailtipKillLine() {
        clearTailTip();
        return doTailTip(LineReader.KILL_LINE);
    }

    public boolean tailtipKillWholeLine() {
        callWidget(LineReader.KILL_WHOLE_LINE);
        return doTailTip(LineReader.REDISPLAY);
    }

    public boolean tailtipInsert() {
        return doTailTip(autopairEnabled() ? "_autopair-insert" : LineReader.SELF_INSERT);
    }

    public boolean tailtipUpdateStatus() {
        return doTailTip(LineReader.REDISPLAY);
    }

    private boolean doTailTip(String widget) {
        Pair<String, Boolean> cmdkey;
        Buffer buffer = buffer();
        callWidget(widget);
        List<String> args = args();
        if (buffer.length() == buffer.cursor()) {
            cmdkey = this.cmdDescs.evaluateCommandLine(buffer.toString(), args);
        } else {
            cmdkey = this.cmdDescs.evaluateCommandLine(buffer.toString(), buffer.cursor());
        }
        CmdDesc cmdDesc = this.cmdDescs.getDescription(cmdkey.getU());
        if (cmdDesc == null) {
            setErrorPattern(null);
            setErrorIndex(-1);
            clearDescription();
            resetTailTip();
            return true;
        } else if (!cmdDesc.isValid()) {
            return true;
        } else {
            if (!cmdkey.getV().booleanValue()) {
                doDescription(compileMainDescription(cmdDesc, this.descriptionSize));
                setErrorPattern(cmdDesc.getErrorPattern());
                setErrorIndex(cmdDesc.getErrorIndex());
                return true;
            } else if (!cmdDesc.isCommand() || buffer.length() != buffer.cursor()) {
                return true;
            } else {
                doCommandTailTip(widget, cmdDesc, args);
                return true;
            }
        }
    }

    private void doCommandTailTip(String widget, CmdDesc cmdDesc, List<String> args) {
        List<AttributedString> d;
        int argnum = 0;
        String prevArg = "";
        for (String a : args) {
            if (!a.startsWith("-") && (!prevArg.matches("-[a-zA-Z]") || !cmdDesc.optionWithValue(prevArg))) {
                argnum++;
            }
            prevArg = a;
        }
        String lastArg = "";
        String prevArg2 = args.get(args.size() - 1);
        if (!prevChar().equals(" ") && args.size() > 1) {
            lastArg = args.get(args.size() - 1);
            prevArg2 = args.get(args.size() - 2);
        }
        int bpsize = argnum;
        boolean doTailTip = true;
        boolean noCompleters = false;
        if (widget.endsWith(LineReader.BACKWARD_DELETE_CHAR)) {
            setSuggestionType(LineReader.SuggestionType.TAIL_TIP);
            noCompleters = true;
            if (!lastArg.startsWith("-") && (!prevArg2.matches("-[a-zA-Z]") || !cmdDesc.optionWithValue(prevArg2))) {
                bpsize--;
            }
            if (prevChar().equals(" ")) {
                bpsize++;
            }
        } else if (!prevChar().equals(" ")) {
            doTailTip = false;
            doDescription(compileMainDescription(cmdDesc, this.descriptionSize, cmdDesc.isSubcommand() ? lastArg : null));
        } else if (cmdDesc != null) {
            doDescription(compileMainDescription(cmdDesc, this.descriptionSize));
        }
        if (cmdDesc != null) {
            if (lastArg.startsWith("-")) {
                if (!lastArg.matches("-[a-zA-Z][a-zA-Z0-9]+")) {
                    doDescription(compileOptionDescription(cmdDesc, lastArg, this.descriptionSize));
                    if (!lastArg.contains("=")) {
                        setSuggestionType(LineReader.SuggestionType.TAIL_TIP);
                        noCompleters = true;
                    } else {
                        setTipType(this.tipType);
                    }
                } else if (cmdDesc.optionWithValue(lastArg.substring(0, 2))) {
                    doDescription(compileOptionDescription(cmdDesc, lastArg.substring(0, 2), this.descriptionSize));
                    setTipType(this.tipType);
                } else {
                    doDescription(compileOptionDescription(cmdDesc, "-" + lastArg.substring(lastArg.length() - 1), this.descriptionSize));
                    setSuggestionType(LineReader.SuggestionType.TAIL_TIP);
                    noCompleters = true;
                }
            } else if (!widget.endsWith(LineReader.BACKWARD_DELETE_CHAR)) {
                setTipType(this.tipType);
            }
            if (bpsize > 0 && doTailTip) {
                List<ArgDesc> params = cmdDesc.getArgsDesc();
                if (!noCompleters) {
                    setSuggestionType(this.tipType == TipType.COMPLETER ? LineReader.SuggestionType.COMPLETER : LineReader.SuggestionType.TAIL_TIP);
                }
                if (bpsize - 1 < params.size()) {
                    if (!lastArg.startsWith("-")) {
                        if (!prevArg2.matches("-[a-zA-Z]") || !cmdDesc.optionWithValue(prevArg2)) {
                            d = params.get(bpsize - 1).getDescription();
                        } else {
                            d = compileOptionDescription(cmdDesc, prevArg2, this.descriptionSize);
                        }
                        if (d == null || d.isEmpty()) {
                            d = compileMainDescription(cmdDesc, this.descriptionSize, cmdDesc.isSubcommand() ? lastArg : null);
                        }
                        doDescription(d);
                    }
                    StringBuilder tip = new StringBuilder();
                    for (int i = bpsize - 1; i < params.size(); i++) {
                        tip.append(params.get(i).getName());
                        tip.append(" ");
                    }
                    setTailTip(tip.toString());
                } else if (!params.isEmpty() && params.get(params.size() - 1).getName().startsWith("[")) {
                    setTailTip(params.get(params.size() - 1).getName());
                    doDescription(params.get(params.size() - 1).getDescription());
                }
            } else if (doTailTip) {
                resetTailTip();
            }
        } else {
            clearDescription();
            resetTailTip();
        }
    }

    private void resetTailTip() {
        setTailTip("");
        if (this.tipType != TipType.TAIL_TIP) {
            setSuggestionType(LineReader.SuggestionType.COMPLETER);
        }
    }

    private void doDescription(List<AttributedString> desc) {
        if (this.descriptionSize != 0 && this.descriptionEnabled) {
            if (desc.isEmpty()) {
                clearDescription();
            } else if (desc.size() == this.descriptionSize) {
                addDescription(desc);
            } else if (desc.size() > this.descriptionSize) {
                AttributedStringBuilder asb = new AttributedStringBuilder();
                asb.append(desc.get(this.descriptionSize - 1)).append("...", new AttributedStyle(AttributedStyle.INVERSE));
                List<AttributedString> mod = new ArrayList<>(desc.subList(0, this.descriptionSize - 1));
                mod.add(asb.toAttributedString());
                addDescription(mod);
            } else {
                while (desc.size() != this.descriptionSize) {
                    desc.add(new AttributedString(""));
                }
                addDescription(desc);
            }
        }
    }

    private boolean autopairEnabled() {
        Binding binding = getKeyMap().getBound("(");
        return (binding instanceof Reference) && ((Reference) binding).name().equals("_autopair-insert");
    }

    public boolean toggleWindow() {
        this.descriptionEnabled = !this.descriptionEnabled;
        if (this.descriptionEnabled) {
            initDescription(this.descriptionSize);
        } else {
            destroyDescription();
        }
        callWidget(LineReader.REDRAW_LINE);
        return true;
    }

    public boolean toggleKeyBindings() {
        if (this.enabled) {
            defaultBindings();
            destroyDescription();
            this.reader.setVariable(LineReader.ERRORS, this.readerErrors);
        } else {
            customBindings();
            if (this.descriptionEnabled) {
                initDescription(this.descriptionSize);
            }
            this.readerErrors = this.reader.getVariable(LineReader.ERRORS);
            this.reader.setVariable(LineReader.ERRORS, 0);
        }
        try {
            callWidget(LineReader.REDRAW_LINE);
        } catch (Exception e) {
        }
        return this.enabled;
    }

    private boolean defaultBindings() {
        if (!this.enabled) {
            return false;
        }
        aliasWidget(".accept-line", LineReader.ACCEPT_LINE);
        aliasWidget(".backward-delete-char", LineReader.BACKWARD_DELETE_CHAR);
        aliasWidget(".delete-char", LineReader.DELETE_CHAR);
        aliasWidget(".expand-or-complete", LineReader.EXPAND_OR_COMPLETE);
        aliasWidget(".self-insert", LineReader.SELF_INSERT);
        aliasWidget(".redisplay", LineReader.REDISPLAY);
        aliasWidget(".kill-line", LineReader.KILL_LINE);
        aliasWidget(".kill-whole-line", LineReader.KILL_WHOLE_LINE);
        getKeyMap().bind((KeyMap<Binding>) new Reference(LineReader.INSERT_CLOSE_PAREN), ")");
        setSuggestionType(LineReader.SuggestionType.NONE);
        if (autopairEnabled()) {
            callWidget(Widgets.AUTOPAIR_TOGGLE);
            callWidget(Widgets.AUTOPAIR_TOGGLE);
        }
        this.enabled = false;
        return true;
    }

    private void customBindings() {
        if (!this.enabled) {
            aliasWidget("_tailtip-accept-line", LineReader.ACCEPT_LINE);
            aliasWidget("_tailtip-backward-delete-char", LineReader.BACKWARD_DELETE_CHAR);
            aliasWidget("_tailtip-delete-char", LineReader.DELETE_CHAR);
            aliasWidget("_tailtip-expand-or-complete", LineReader.EXPAND_OR_COMPLETE);
            aliasWidget("_tailtip-self-insert", LineReader.SELF_INSERT);
            aliasWidget("_tailtip-redisplay", LineReader.REDISPLAY);
            aliasWidget("_tailtip-kill-line", LineReader.KILL_LINE);
            aliasWidget("_tailtip-kill-whole-line", LineReader.KILL_WHOLE_LINE);
            getKeyMap().bind((KeyMap<Binding>) new Reference("_tailtip-self-insert"), ")");
            if (this.tipType != TipType.TAIL_TIP) {
                setSuggestionType(LineReader.SuggestionType.COMPLETER);
            } else {
                setSuggestionType(LineReader.SuggestionType.TAIL_TIP);
            }
            this.enabled = true;
        }
    }

    private List<AttributedString> compileMainDescription(CmdDesc cmdDesc, int descriptionSize) {
        return compileMainDescription(cmdDesc, descriptionSize, null);
    }

    private List<AttributedString> compileMainDescription(CmdDesc cmdDesc, int descriptionSize, String lastArg) {
        if (descriptionSize == 0 || !this.descriptionEnabled) {
            return new ArrayList();
        }
        List<AttributedString> out = new ArrayList<>();
        List<AttributedString> mainDesc = cmdDesc.getMainDesc();
        if (mainDesc == null) {
            return out;
        }
        if (cmdDesc.isCommand() && cmdDesc.isValid() && !cmdDesc.isHighlighted()) {
            mainDesc = new ArrayList<>();
            StyleResolver resolver = Options.HelpException.defaultStyle();
            for (AttributedString as : cmdDesc.getMainDesc()) {
                mainDesc.add(Options.HelpException.highlightSyntax(as.toString(), resolver));
            }
        }
        if (mainDesc.size() > descriptionSize || lastArg != null) {
            int tabs = 0;
            for (AttributedString as2 : mainDesc) {
                if (as2.columnLength() >= tabs) {
                    tabs = as2.columnLength() + 2;
                }
            }
            int row = 0;
            int col = 0;
            List<AttributedString> descList = new ArrayList<>();
            for (int i = 0; i < descriptionSize; i++) {
                descList.add(new AttributedString(""));
            }
            for (AttributedString as3 : mainDesc) {
                if (lastArg == null || as3.toString().startsWith(lastArg)) {
                    AttributedStringBuilder asb = new AttributedStringBuilder().tabs(tabs);
                    if (col > 0) {
                        asb.append(descList.get(row));
                        asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    }
                    asb.append(as3);
                    descList.remove(row);
                    descList.add(row, asb.toAttributedString());
                    row++;
                    if (row >= descriptionSize) {
                        row = 0;
                        col++;
                    }
                }
            }
            out = new ArrayList<>(descList);
        } else {
            out.addAll(mainDesc);
        }
        return out;
    }

    private List<AttributedString> compileOptionDescription(CmdDesc cmdDesc, String opt, int descriptionSize) {
        if (descriptionSize == 0 || !this.descriptionEnabled) {
            return new ArrayList();
        }
        List<AttributedString> out = new ArrayList<>();
        Map<String, List<AttributedString>> optsDesc = cmdDesc.getOptsDesc();
        StyleResolver resolver = Options.HelpException.defaultStyle();
        if (!opt.startsWith("-")) {
            return out;
        }
        int ind = opt.indexOf("=");
        if (ind > 0) {
            opt = opt.substring(0, ind);
        }
        List<String> matched = new ArrayList<>();
        int tabs = 0;
        for (String key : optsDesc.keySet()) {
            String[] split = key.split("\\s+");
            int length = split.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                } else if (split[i].trim().startsWith(opt)) {
                    matched.add(key);
                    if (key.length() >= tabs) {
                        tabs = key.length() + 2;
                    }
                } else {
                    i++;
                }
            }
        }
        if (matched.size() == 1) {
            out.add(Options.HelpException.highlightSyntax(matched.get(0), resolver));
            for (AttributedString as : optsDesc.get(matched.get(0))) {
                AttributedStringBuilder asb = new AttributedStringBuilder().tabs(8);
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                asb.append(as);
                out.add(asb.toAttributedString());
            }
        } else if (matched.size() <= descriptionSize) {
            for (String key2 : matched) {
                AttributedStringBuilder asb2 = new AttributedStringBuilder().tabs(tabs);
                asb2.append(Options.HelpException.highlightSyntax(key2, resolver));
                asb2.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                asb2.append(cmdDesc.optionDescription(key2));
                out.add(asb2.toAttributedString());
            }
        } else if (matched.size() <= 2 * descriptionSize) {
            List<AttributedString> keyList = new ArrayList<>();
            int row = 0;
            int columnWidth = 2 * tabs;
            while (columnWidth < 50) {
                columnWidth += tabs;
            }
            for (String key3 : matched) {
                AttributedStringBuilder asb3 = new AttributedStringBuilder().tabs(tabs);
                if (row < descriptionSize) {
                    asb3.append(Options.HelpException.highlightSyntax(key3, resolver));
                    asb3.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    asb3.append(cmdDesc.optionDescription(key3));
                    if (asb3.columnLength() > columnWidth - 2) {
                        AttributedString trunc = asb3.columnSubSequence(0, columnWidth - 5);
                        asb3 = new AttributedStringBuilder().tabs(tabs);
                        asb3.append(trunc);
                        asb3.append("...", new AttributedStyle(AttributedStyle.INVERSE));
                        asb3.append((CharSequence) "  ");
                    } else {
                        for (int i2 = asb3.columnLength(); i2 < columnWidth; i2++) {
                            asb3.append((CharSequence) " ");
                        }
                    }
                    keyList.add(asb3.toAttributedString().columnSubSequence(0, columnWidth));
                } else {
                    asb3.append(keyList.get(row - descriptionSize));
                    asb3.append(Options.HelpException.highlightSyntax(key3, resolver));
                    asb3.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    asb3.append(cmdDesc.optionDescription(key3));
                    keyList.remove(row - descriptionSize);
                    keyList.add(row - descriptionSize, asb3.toAttributedString());
                }
                row++;
            }
            out = new ArrayList<>(keyList);
        } else {
            List<AttributedString> keyList2 = new ArrayList<>();
            for (int i3 = 0; i3 < descriptionSize; i3++) {
                keyList2.add(new AttributedString(""));
            }
            int row2 = 0;
            for (String key4 : matched) {
                AttributedStringBuilder asb4 = new AttributedStringBuilder().tabs(tabs);
                asb4.append(keyList2.get(row2));
                asb4.append(Options.HelpException.highlightSyntax(key4, resolver));
                asb4.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                keyList2.remove(row2);
                keyList2.add(row2, asb4.toAttributedString());
                row2++;
                if (row2 >= descriptionSize) {
                    row2 = 0;
                }
            }
            out = new ArrayList<>(keyList2);
        }
        return out;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/widget/TailTipWidgets$CommandDescriptions.class */
    public class CommandDescriptions {
        Map<String, CmdDesc> descriptions;
        Map<String, CmdDesc> temporaryDescs;
        Map<String, CmdDesc> volatileDescs;
        Function<CmdLine, CmdDesc> descFun;

        public CommandDescriptions(Map<String, CmdDesc> descriptions) {
            this.descriptions = new HashMap();
            this.temporaryDescs = new HashMap();
            this.volatileDescs = new HashMap();
            this.descriptions = new HashMap(descriptions);
        }

        public CommandDescriptions(Function<CmdLine, CmdDesc> descFun) {
            this.descriptions = new HashMap();
            this.temporaryDescs = new HashMap();
            this.volatileDescs = new HashMap();
            this.descFun = descFun;
        }

        public void setDescriptions(Map<String, CmdDesc> descriptions) {
            this.descriptions = new HashMap(descriptions);
        }

        public Pair<String, Boolean> evaluateCommandLine(String line, int curPos) {
            return evaluateCommandLine(line, TailTipWidgets.this.args(), curPos);
        }

        public Pair<String, Boolean> evaluateCommandLine(String line, List<String> args) {
            return evaluateCommandLine(line, args, line.length());
        }

        private Pair<String, Boolean> evaluateCommandLine(String line, List<String> args, int curPos) {
            String cmd = null;
            CmdLine.DescriptionType descType = CmdLine.DescriptionType.METHOD;
            String head = line.substring(0, curPos);
            String tail = line.substring(curPos);
            if (TailTipWidgets.this.prevChar().equals(")")) {
                descType = CmdLine.DescriptionType.SYNTAX;
                cmd = head;
            } else {
                if (line.length() == curPos) {
                    cmd = (args == null || (args.size() <= 1 && (args.size() != 1 || !line.endsWith(" ")))) ? null : TailTipWidgets.this.parser().getCommand(args.get(0));
                    descType = CmdLine.DescriptionType.COMMAND;
                }
                int brackets = 0;
                int i = head.length() - 1;
                while (true) {
                    if (i < 0) {
                        break;
                    }
                    if (head.charAt(i) == ')') {
                        brackets++;
                    } else if (head.charAt(i) == '(') {
                        brackets--;
                    }
                    if (brackets < 0) {
                        descType = CmdLine.DescriptionType.METHOD;
                        head = head.substring(0, i);
                        cmd = head;
                        break;
                    }
                    i--;
                }
                if (descType == CmdLine.DescriptionType.METHOD) {
                    int brackets2 = 0;
                    int i2 = 0;
                    while (true) {
                        if (i2 >= tail.length()) {
                            break;
                        }
                        if (tail.charAt(i2) == ')') {
                            brackets2++;
                        } else if (tail.charAt(i2) == '(') {
                            brackets2--;
                        }
                        if (brackets2 > 0) {
                            tail = tail.substring(i2 + 1);
                            break;
                        }
                        i2++;
                    }
                }
            }
            if (cmd != null && this.descFun != null && !this.descriptions.containsKey(cmd) && !this.temporaryDescs.containsKey(cmd)) {
                CmdDesc c = this.descFun.apply(new CmdLine(line, head, tail, args, descType));
                if (descType != CmdLine.DescriptionType.COMMAND) {
                    this.temporaryDescs.put(cmd, c);
                } else if (!TailTipWidgets.this.descriptionCache) {
                    this.volatileDescs.put(cmd, c);
                } else if (c != null) {
                    this.descriptions.put(cmd, c);
                } else {
                    this.temporaryDescs.put(cmd, null);
                }
            }
            return new Pair<>(cmd, Boolean.valueOf(descType == CmdLine.DescriptionType.COMMAND));
        }

        public CmdDesc getDescription(String command) {
            CmdDesc out = null;
            if (this.descriptions.containsKey(command)) {
                out = this.descriptions.get(command);
            } else if (this.temporaryDescs.containsKey(command)) {
                out = this.temporaryDescs.get(command);
            } else if (this.volatileDescs.containsKey(command)) {
                out = this.volatileDescs.get(command);
                this.volatileDescs.remove(command);
            }
            return out;
        }

        public void clearTemporaryDescs() {
            this.temporaryDescs.clear();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/widget/TailTipWidgets$Pair.class */
    public static class Pair<U, V> {

        /* renamed from: u */
        final U f3238u;

        /* renamed from: v */
        final V f3239v;

        public Pair(U u, V v) {
            this.f3238u = u;
            this.f3239v = v;
        }

        public U getU() {
            return this.f3238u;
        }

        public V getV() {
            return this.f3239v;
        }
    }
}
