package org.jline.console.impl;

import com.fasterxml.jackson.core.JsonFactory;
import dev.morphia.mapping.Mapper;
import java.io.File;
import java.math.BigDecimal;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.jline.builtins.ConfigurationPath;
import org.jline.builtins.Nano;
import org.jline.builtins.Options;
import org.jline.builtins.Styles;
import org.jline.console.CmdDesc;
import org.jline.console.CommandInput;
import org.jline.console.Printer;
import org.jline.console.ScriptEngine;
import org.jline.console.SystemRegistry;
import org.jline.terminal.Terminal;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStringBuilder;
import org.jline.utils.AttributedStyle;
import org.jline.utils.Log;
import org.jline.utils.StyleResolver;
import p001ch.qos.logback.classic.net.SyslogAppender;
import p001ch.qos.logback.core.joran.action.ActionConst;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/jline/console/impl/DefaultPrinter.class */
public class DefaultPrinter extends JlineCommandRegistry implements Printer {
    protected static final String VAR_PRNT_OPTIONS = "PRNT_OPTIONS";
    protected static final String VAR_NANORC = "NANORC";
    protected static final int PRNT_MAX_ROWS = 100000;
    protected static final int PRNT_MAX_DEPTH = 1;
    protected static final int PRNT_INDENTION = 4;
    private static final int NANORC_MAX_STRING_LENGTH = 400;
    private Map<Class<?>, Function<Object, Map<String, Object>>> objectToMap;
    private Map<Class<?>, Function<Object, String>> objectToString;
    private Map<String, Function<Object, AttributedString>> highlightValue;
    private int totLines;
    private final ScriptEngine engine;
    private final ConfigurationPath configPath;
    private StyleResolver prntStyle;

    public DefaultPrinter(ConfigurationPath configPath) {
        this(null, configPath);
    }

    public DefaultPrinter(ScriptEngine engine, ConfigurationPath configPath) {
        this.objectToMap = new HashMap();
        this.objectToString = new HashMap();
        this.highlightValue = new HashMap();
        this.engine = engine;
        this.configPath = configPath;
    }

    @Override // org.jline.console.Printer
    public void println(Object object) {
        internalPrintln(defaultPrntOptions(false), object);
    }

    @Override // org.jline.console.Printer
    public void println(Map<String, Object> optionsIn, Object object) {
        Map<String, Object> options = new HashMap<>(optionsIn);
        for (Map.Entry<String, Object> entry : defaultPrntOptions(options.containsKey(Printer.SKIP_DEFAULT_OPTIONS)).entrySet()) {
            options.putIfAbsent(entry.getKey(), entry.getValue());
        }
        manageBooleanOptions(options);
        internalPrintln(options, object);
    }

    public String[] appendUsage(String[] customUsage) {
        String[] out;
        String[] usage = {"prnt -  print object", "Usage: prnt [OPTIONS] object", "  -? --help                       Displays command help", "  -a --all                        Ignore columnsOut configuration", "  -b --border=CHAR                Table cell vertical border character", "  -c --columns=COLUMNS,...        Display given columns on map/table", "  -e --exclude=COLUMNS,...        Exclude given columns on table", "  -i --include=COLUMNS,...        Include given columns on table", "     --indention=INDENTION        Indention size", "     --maxColumnWidth=WIDTH       Maximum column width", "  -d --maxDepth=DEPTH             Maximum depth objects are resolved", "  -n --maxrows=ROWS               Maximum number of lines to display", "     --oneRowTable                Display one row data on table", "  -h --rowHighlight=ROW           Highlight table rows. ROW = EVEN, ODD, ALL", "  -r --rownum                     Display table row numbers", "     --shortNames                 Truncate table column names (property.field -> field)", "     --skipDefaultOptions         Ignore all options defined in PRNT_OPTIONS", "     --structsOnTable             Display structs and lists on table", "  -s --style=STYLE                Use nanorc STYLE to highlight Object.", "                                  STYLE = JSON serialize object to JSON string before printing", "     --toString                   Use object's toString() method to get print value", "                                  DEFAULT: object's fields are put to property map before printing", "     --valueStyle=STYLE           Use nanorc style to highlight string and column/map values", "  -w --width=WIDTH                Display width (default terminal width)"};
        if (customUsage == null || customUsage.length == 0) {
            out = usage;
        } else {
            out = new String[usage.length + customUsage.length];
            System.arraycopy(usage, 0, out, 0, usage.length);
            System.arraycopy(customUsage, 0, out, usage.length, customUsage.length);
        }
        return out;
    }

    public Map<String, Object> compileOptions(Options opt) {
        Map<String, Object> options = new HashMap<>();
        if (opt.isSet(Printer.SKIP_DEFAULT_OPTIONS)) {
            options.put(Printer.SKIP_DEFAULT_OPTIONS, true);
        } else if (opt.isSet(Printer.STYLE)) {
            options.put(Printer.STYLE, opt.get(Printer.STYLE));
        }
        if (opt.isSet(Printer.TO_STRING)) {
            options.put(Printer.TO_STRING, true);
        }
        if (opt.isSet(Printer.WIDTH)) {
            options.put(Printer.WIDTH, Integer.valueOf(opt.getNumber(Printer.WIDTH)));
        }
        if (opt.isSet(Printer.ROWNUM)) {
            options.put(Printer.ROWNUM, true);
        }
        if (opt.isSet(Printer.ONE_ROW_TABLE)) {
            options.put(Printer.ONE_ROW_TABLE, true);
        }
        if (opt.isSet(Printer.SHORT_NAMES)) {
            options.put(Printer.SHORT_NAMES, true);
        }
        if (opt.isSet(Printer.STRUCT_ON_TABLE)) {
            options.put(Printer.STRUCT_ON_TABLE, true);
        }
        if (opt.isSet(Printer.COLUMNS)) {
            options.put(Printer.COLUMNS, Arrays.asList(opt.get(Printer.COLUMNS).split(",")));
        }
        if (opt.isSet(Printer.EXCLUDE)) {
            options.put(Printer.EXCLUDE, Arrays.asList(opt.get(Printer.EXCLUDE).split(",")));
        }
        if (opt.isSet(Printer.INCLUDE)) {
            options.put(Printer.INCLUDE, Arrays.asList(opt.get(Printer.INCLUDE).split(",")));
        }
        if (opt.isSet(Printer.ALL)) {
            options.put(Printer.ALL, true);
        }
        if (opt.isSet(Printer.MAXROWS)) {
            options.put(Printer.MAXROWS, Integer.valueOf(opt.getNumber(Printer.MAXROWS)));
        }
        if (opt.isSet(Printer.MAX_COLUMN_WIDTH)) {
            options.put(Printer.MAX_COLUMN_WIDTH, Integer.valueOf(opt.getNumber(Printer.MAX_COLUMN_WIDTH)));
        }
        if (opt.isSet(Printer.MAX_DEPTH)) {
            options.put(Printer.MAX_DEPTH, Integer.valueOf(opt.getNumber(Printer.MAX_DEPTH)));
        }
        if (opt.isSet(Printer.INDENTION)) {
            options.put(Printer.INDENTION, Integer.valueOf(opt.getNumber(Printer.INDENTION)));
        }
        if (opt.isSet(Printer.VALUE_STYLE)) {
            options.put(Printer.VALUE_STYLE, opt.get(Printer.VALUE_STYLE));
        }
        if (opt.isSet(Printer.BORDER)) {
            options.put(Printer.BORDER, opt.get(Printer.BORDER));
        }
        if (opt.isSet(Printer.ROW_HIGHLIGHT)) {
            try {
                options.put(Printer.ROW_HIGHLIGHT, optionRowHighlight(opt.get(Printer.ROW_HIGHLIGHT)));
            } catch (Exception e) {
                RuntimeException exception = new BadOptionValueException("rowHighlight has a bad value: " + opt.get(Printer.ROW_HIGHLIGHT));
                exception.addSuppressed(e);
                throw exception;
            }
        }
        options.put("exception", "stack");
        return options;
    }

    private Printer.TableRows optionRowHighlight(Object value) {
        if ((value instanceof Printer.TableRows) || value == null) {
            return (Printer.TableRows) value;
        }
        if (value instanceof String) {
            String val = ((String) value).trim().toUpperCase();
            if (val.isEmpty() || val.equals(ActionConst.NULL)) {
                return null;
            }
            return Printer.TableRows.valueOf(val);
        }
        throw new IllegalArgumentException("rowHighlight has a bad option value type: " + value.getClass());
    }

    @Override // org.jline.console.Printer
    public Exception prntCommand(CommandInput input) {
        Exception out = null;
        try {
            Options opt = parseOptions(appendUsage(null), input.xargs());
            Map<String, Object> options = compileOptions(opt);
            List<Object> args = opt.argObjects();
            if (args.size() > 0) {
                println(options, args.get(0));
            }
        } catch (Exception e) {
            out = e;
        }
        return out;
    }

    public void setObjectToMap(Map<Class<?>, Function<Object, Map<String, Object>>> objectToMap) {
        this.objectToMap = objectToMap;
    }

    public void setObjectToString(Map<Class<?>, Function<Object, String>> objectToString) {
        this.objectToString = objectToString;
    }

    public void setHighlightValue(Map<String, Function<Object, AttributedString>> highlightValue) {
        this.highlightValue = highlightValue;
    }

    protected Terminal terminal() {
        return SystemRegistry.get().terminal();
    }

    protected void manageBooleanOptions(Map<String, Object> options) {
        for (String key : Printer.BOOLEAN_KEYS) {
            if (options.containsKey(key)) {
                if (!((options.get(key) instanceof Boolean) && ((Boolean) options.get(key)).booleanValue())) {
                    options.remove(key);
                }
            }
        }
    }

    protected Map<String, Object> defaultPrntOptions(boolean skipDefault) {
        Map<String, Object> out = new HashMap<>();
        if (this.engine != null && !skipDefault && this.engine.hasVariable(VAR_PRNT_OPTIONS)) {
            out.putAll((Map) this.engine.get(VAR_PRNT_OPTIONS));
            out.remove(Printer.SKIP_DEFAULT_OPTIONS);
            manageBooleanOptions(out);
        }
        out.putIfAbsent(Printer.MAXROWS, Integer.valueOf((int) PRNT_MAX_ROWS));
        out.putIfAbsent(Printer.MAX_DEPTH, 1);
        out.putIfAbsent(Printer.INDENTION, 4);
        out.putIfAbsent(Printer.COLUMNS_OUT, new ArrayList());
        out.putIfAbsent(Printer.COLUMNS_IN, new ArrayList());
        if (this.engine == null) {
            out.remove(Printer.OBJECT_TO_MAP);
            out.remove(Printer.OBJECT_TO_STRING);
            out.remove(Printer.HIGHLIGHT_VALUE);
        }
        return out;
    }

    private void internalPrintln(Map<String, Object> options, Object object) {
        if (object != null) {
            long start = new Date().getTime();
            if (options.containsKey(Printer.EXCLUDE)) {
                List<String> colOut = optionList(Printer.EXCLUDE, options);
                List<String> colIn = optionList(Printer.COLUMNS_IN, options);
                colIn.removeAll(colOut);
                colOut.addAll((List) options.get(Printer.COLUMNS_OUT));
                options.put(Printer.COLUMNS_IN, colIn);
                options.put(Printer.COLUMNS_OUT, colOut);
            }
            if (options.containsKey(Printer.INCLUDE)) {
                List<String> colIn2 = optionList(Printer.INCLUDE, options);
                colIn2.addAll((List) options.get(Printer.COLUMNS_IN));
                options.put(Printer.COLUMNS_IN, colIn2);
            }
            options.put(Printer.VALUE_STYLE, valueHighlighter((String) options.getOrDefault(Printer.VALUE_STYLE, null)));
            this.prntStyle = Styles.prntStyle();
            options.putIfAbsent(Printer.WIDTH, Integer.valueOf(terminal().getSize().getColumns()));
            String style = (String) options.getOrDefault(Printer.STYLE, "");
            options.put(Printer.STYLE, valueHighlighter(style));
            int width = ((Integer) options.get(Printer.WIDTH)).intValue();
            if (!style.isEmpty() && (object instanceof String)) {
                highlightAndPrint(width, (Nano.SyntaxHighlighter) options.get(Printer.STYLE), (String) object, true);
            } else if (style.equalsIgnoreCase(JsonFactory.FORMAT_NAME_JSON)) {
                if (this.engine == null) {
                    throw new IllegalArgumentException("JSON style not supported!");
                }
                highlightAndPrint(width, (Nano.SyntaxHighlighter) options.get(Printer.STYLE), this.engine.toJson(object), true);
            } else if (options.containsKey(Printer.SKIP_DEFAULT_OPTIONS)) {
                highlightAndPrint(options, object);
            } else if (object instanceof Exception) {
                highlightAndPrint(options, (Throwable) ((Exception) object));
            } else if (object instanceof CmdDesc) {
                highlight((CmdDesc) object).println(terminal());
            } else if ((object instanceof String) || (object instanceof Number)) {
                String str = object.toString();
                highlightAndPrint(width, (Nano.SyntaxHighlighter) options.getOrDefault(Printer.VALUE_STYLE, null), str, doValueHighlight(options, str));
            } else {
                highlightAndPrint(options, object);
            }
            terminal().flush();
            Log.debug("println: ", Long.valueOf(new Date().getTime() - start), " msec");
        }
    }

    protected void highlightAndPrint(Map<String, Object> options, Throwable exception) {
        SystemRegistry.get().trace(options.getOrDefault("exception", "stack").equals("stack"), exception);
    }

    private AttributedString highlight(CmdDesc cmdDesc) {
        StringBuilder sb = new StringBuilder();
        for (AttributedString as : cmdDesc.getMainDesc()) {
            sb.append(as.toString());
            sb.append("\n");
        }
        List<Integer> tabs = Arrays.asList(0, 2, 33);
        for (Map.Entry<String, List<AttributedString>> entry : cmdDesc.getOptsDesc().entrySet()) {
            AttributedStringBuilder asb = new AttributedStringBuilder();
            asb.tabs(tabs);
            asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            asb.append((CharSequence) entry.getKey());
            asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            boolean first = true;
            for (AttributedString as2 : entry.getValue()) {
                if (!first) {
                    asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                }
                asb.append(as2);
                asb.append((CharSequence) "\n");
                first = false;
            }
            sb.append(asb.toString());
        }
        return Options.HelpException.highlight(sb.toString(), Styles.helpStyle());
    }

    private Nano.SyntaxHighlighter valueHighlighter(String style) {
        Nano.SyntaxHighlighter out;
        if (style == null || style.isEmpty()) {
            out = null;
        } else if (style.matches("[a-z]+:.*")) {
            out = Nano.SyntaxHighlighter.build(style);
        } else {
            Path nanorc = this.configPath != null ? this.configPath.getConfig("jnanorc") : null;
            if (this.engine != null && this.engine.hasVariable(VAR_NANORC)) {
                nanorc = Paths.get((String) this.engine.get(VAR_NANORC), new String[0]);
            }
            if (nanorc == null) {
                nanorc = Paths.get("/etc/nanorc", new String[0]);
            }
            out = Nano.SyntaxHighlighter.build(nanorc, style);
        }
        return out;
    }

    private String truncate4nanorc(String obj) {
        String val = obj;
        if (val.length() > 400 && !val.contains("\n")) {
            val = val.substring(0, 399);
        }
        return val;
    }

    private AttributedString highlight(Integer width, Nano.SyntaxHighlighter highlighter, String object, boolean doValueHighlight) {
        AttributedString out;
        AttributedStringBuilder asb = new AttributedStringBuilder();
        String val = object;
        if (highlighter != null && doValueHighlight) {
            val = truncate4nanorc(object);
        }
        asb.append((CharSequence) val);
        if (highlighter == null || val.length() >= 400 || !doValueHighlight) {
            out = asb.toAttributedString();
        } else {
            out = highlighter.highlight(asb);
        }
        if (width != null) {
            out = out.columnSubSequence(0, width.intValue());
        }
        return out;
    }

    private boolean doValueHighlight(Map<String, Object> options, String value) {
        if (options.containsKey(Printer.VALUE_STYLE_ALL) || value.matches("\"(\\.|[^\"])*\"|'(\\.|[^'])*'")) {
            return true;
        }
        if (value.startsWith("[") && value.endsWith("]")) {
            return true;
        }
        if (value.startsWith("(") && value.endsWith(")")) {
            return true;
        }
        if (value.startsWith("{") && value.endsWith("}")) {
            return true;
        }
        if (!value.startsWith("<") || !value.endsWith(">")) {
            return !value.contains(" ") && !value.contains(SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
        }
        return true;
    }

    private void highlightAndPrint(int width, Nano.SyntaxHighlighter highlighter, String object, boolean doValueHighlight) {
        for (String s : object.split("\\r?\\n")) {
            for (AttributedString as : new AttributedStringBuilder().append((CharSequence) s).columnSplitLength(width)) {
                highlight(Integer.valueOf(width), highlighter, as.toString(), doValueHighlight).println(terminal());
            }
        }
    }

    private Map<String, Object> keysToString(Map<Object, Object> map) {
        Map<String, Object> out = new HashMap<>();
        for (Map.Entry<Object, Object> entry : map.entrySet()) {
            if (entry.getKey() instanceof String) {
                out.put((String) entry.getKey(), entry.getValue());
            } else if (entry.getKey() != null) {
                out.put(entry.getKey().toString(), entry.getValue());
            } else {
                out.put("null", entry.getValue());
            }
        }
        return out;
    }

    private Object mapValue(Map<String, Object> options, String key, Map<String, Object> map) {
        Object out = null;
        if (map.containsKey(key)) {
            out = map.get(key);
        } else if (key.contains(Mapper.IGNORED_FIELDNAME)) {
            String[] keys = key.split("\\.");
            out = map.get(keys[0]);
            for (int i = 1; i < keys.length; i++) {
                if (!(out instanceof Map)) {
                    if (!canConvert(out)) {
                        break;
                    }
                    out = this.engine.toMap(out).get(keys[i]);
                } else {
                    out = keysToString((Map) out).get(keys[i]);
                }
            }
        }
        if (!(out instanceof Map) && canConvert(out)) {
            out = objectToMap(options, out);
        }
        return out;
    }

    private List<String> optionList(String key, Map<String, Object> options) {
        List<String> out = new ArrayList<>();
        if (options.containsKey(key)) {
            if (options.get(key) instanceof String) {
                out.addAll(Arrays.asList(((String) options.get(key)).split(",")));
            } else if (options.get(key) instanceof Collection) {
                out.addAll((Collection) options.get(key));
            } else {
                throw new IllegalArgumentException("Unsupported option list: {key: " + key + ", type: " + options.get(key).getClass() + "}");
            }
        }
        return out;
    }

    private boolean hasMatch(List<String> regexes, String value) {
        for (String r : regexes) {
            if (value.matches(r)) {
                return true;
            }
        }
        return false;
    }

    private AttributedString addPadding(AttributedString str, int width) {
        AttributedStringBuilder sb = new AttributedStringBuilder();
        for (int i = str.columnLength(); i < width; i++) {
            sb.append((CharSequence) " ");
        }
        sb.append(str);
        return sb.toAttributedString();
    }

    private String addPadding(String str, int width) {
        AttributedStringBuilder sb = new AttributedStringBuilder();
        for (int i = str.length(); i < width; i++) {
            sb.append((CharSequence) " ");
        }
        sb.append((CharSequence) str);
        return sb.toString();
    }

    private String columnValue(String value) {
        return value.replaceAll("\r", "CR").replaceAll("\n", "LF");
    }

    private Map<String, Object> objectToMap(Map<String, Object> options, Object obj) {
        Map<Class<?>, Object> toMap;
        if (obj != null) {
            if (options.containsKey(Printer.OBJECT_TO_MAP)) {
                toMap = (Map) options.get(Printer.OBJECT_TO_MAP);
            } else {
                toMap = new HashMap<>();
            }
            if (toMap.containsKey(obj.getClass())) {
                return (Map) this.engine.execute(toMap.get(obj.getClass()), obj);
            }
            if (this.objectToMap.containsKey(obj.getClass())) {
                return this.objectToMap.get(obj.getClass()).apply(obj);
            }
        }
        return this.engine.toMap(obj);
    }

    private String objectToString(Map<String, Object> options, Object obj) {
        Map<Class<?>, Object> toString;
        String out = "null";
        if (obj != null) {
            if (options.containsKey(Printer.OBJECT_TO_STRING)) {
                toString = (Map) options.get(Printer.OBJECT_TO_STRING);
            } else {
                toString = new HashMap<>();
            }
            if (toString.containsKey(obj.getClass())) {
                out = (String) this.engine.execute(toString.get(obj.getClass()), obj);
            } else if (this.objectToString.containsKey(obj.getClass())) {
                out = this.objectToString.get(obj.getClass()).apply(obj);
            } else if (obj instanceof Class) {
                out = ((Class) obj).getName();
            } else if (this.engine != null) {
                out = this.engine.toString(obj);
            } else {
                out = obj.toString();
            }
        }
        return out;
    }

    private AttributedString highlightMapValue(Map<String, Object> options, String key, Map<String, Object> map) {
        return highlightValue(options, key, mapValue(options, key, map));
    }

    private boolean isHighlighted(AttributedString value) {
        for (int i = 0; i < value.length(); i++) {
            if (value.styleAt(i).getStyle() != AttributedStyle.DEFAULT.getStyle()) {
                return true;
            }
        }
        return false;
    }

    private AttributedString highlightValue(Map<String, Object> options, String column, Object obj) {
        Map<String, Object> hv;
        AttributedString out = null;
        String raw = (!options.containsKey(Printer.TO_STRING) || obj == null) ? obj : objectToString(options, obj);
        if (options.containsKey(Printer.HIGHLIGHT_VALUE)) {
            hv = (Map) options.get(Printer.HIGHLIGHT_VALUE);
        } else {
            hv = new HashMap<>();
        }
        if (column != null && simpleObject(raw)) {
            Iterator<Map.Entry<String, Object>> it = hv.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> entry = it.next();
                if (!entry.getKey().equals("*") && column.matches(entry.getKey())) {
                    out = (AttributedString) this.engine.execute(hv.get(entry.getKey()), raw);
                    break;
                }
            }
            if (out == null) {
                Iterator<Map.Entry<String, Function<Object, AttributedString>>> it2 = this.highlightValue.entrySet().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    Map.Entry<String, Function<Object, AttributedString>> entry2 = it2.next();
                    if (!entry2.getKey().equals("*") && column.matches(entry2.getKey())) {
                        out = this.highlightValue.get(entry2.getKey()).apply(raw);
                        break;
                    }
                }
            }
        }
        if (out == null) {
            if (raw instanceof String) {
                out = new AttributedString(columnValue((String) raw));
            } else {
                out = new AttributedString(columnValue(objectToString(options, raw)));
            }
        }
        if ((simpleObject(raw) || raw == null) && ((hv.containsKey("*") || this.highlightValue.containsKey("*")) && !isHighlighted(out))) {
            if (hv.containsKey("*")) {
                out = (AttributedString) this.engine.execute(hv.get("*"), out);
            }
            if (this.highlightValue.containsKey("*")) {
                out = this.highlightValue.get("*").apply(out);
            }
        }
        if (options.containsKey(Printer.VALUE_STYLE) && !isHighlighted(out)) {
            out = highlight(null, (Nano.SyntaxHighlighter) options.get(Printer.VALUE_STYLE), out.toString(), doValueHighlight(options, out.toString()));
        }
        return truncateValue(options, out);
    }

    private AttributedString truncateValue(Map<String, Object> options, AttributedString value) {
        if (value.columnLength() <= ((Integer) options.getOrDefault(Printer.MAX_COLUMN_WIDTH, Integer.MAX_VALUE)).intValue()) {
            return value;
        }
        AttributedStringBuilder asb = new AttributedStringBuilder();
        asb.append(value.columnSubSequence(0, ((Integer) options.get(Printer.MAX_COLUMN_WIDTH)).intValue() - 3));
        asb.append((CharSequence) "...");
        return asb.toAttributedString();
    }

    private String truncateValue(int maxWidth, String value) {
        if (value.length() > maxWidth) {
            return ((Object) value.subSequence(0, maxWidth - 3)) + "...";
        }
        return value;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private List<Object> objectToList(Object obj) {
        List<Object> out = new ArrayList<>();
        if (obj instanceof List) {
            out = (List) obj;
        } else if (obj instanceof Collection) {
            out.addAll((Collection) obj);
        } else if (obj instanceof Object[]) {
            out.addAll(Arrays.asList((Object[]) obj));
        } else if (obj instanceof Iterator) {
            Objects.requireNonNull(out);
            ((Iterator) obj).forEachRemaining(this::add);
        } else if (obj instanceof Iterable) {
            Objects.requireNonNull(out);
            ((Iterable) obj).forEach(this::add);
        } else {
            out.add(obj);
        }
        return out;
    }

    private boolean similarSets(List<String> ref, Set<String> c2, int matchLimit) {
        boolean out = false;
        int limit = matchLimit;
        Iterator<String> it = ref.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            } else if (c2.contains(it.next())) {
                limit--;
                if (limit == 0) {
                    out = true;
                    break;
                }
            }
        }
        return out;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/DefaultPrinter$BadOptionValueException.class */
    public static class BadOptionValueException extends RuntimeException {
        public BadOptionValueException(String message) {
            super(message);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/jline/console/impl/DefaultPrinter$TruncatedOutputException.class */
    public static class TruncatedOutputException extends RuntimeException {
        public TruncatedOutputException(String message) {
            super(message);
        }
    }

    private void println(AttributedString line, int maxrows) {
        line.println(terminal());
        this.totLines++;
        if (this.totLines > maxrows) {
            this.totLines = 0;
            throw new TruncatedOutputException("Truncated output: " + maxrows);
        }
    }

    private String columnName(String name, boolean shortName) {
        String out = name;
        if (shortName) {
            String[] p = name.split("\\.");
            out = p[p.length - 1];
        }
        return out;
    }

    private boolean isNumber(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    private void highlightAndPrint(Map<String, Object> options, Object obj) {
        List<String> _header;
        int width = ((Integer) options.get(Printer.WIDTH)).intValue();
        this.totLines = 0;
        String message = null;
        RuntimeException runtimeException = null;
        if (obj != null) {
            if (obj instanceof Map) {
                highlightMap(options, keysToString((Map) obj), width);
            } else if (collectionObject(obj)) {
                List<Object> collection = objectToList(obj);
                if (collection.size() > ((Integer) options.get(Printer.MAXROWS)).intValue()) {
                    message = "Truncated output: " + options.get(Printer.MAXROWS) + "/" + collection.size();
                    collection = collection.subList(collection.size() - ((Integer) options.get(Printer.MAXROWS)).intValue(), collection.size());
                }
                if (collection.isEmpty()) {
                    highlightValue(options, null, objectToString(options, obj)).println(terminal());
                } else if (collection.size() != 1 || options.containsKey(Printer.ONE_ROW_TABLE)) {
                    String columnSep = "";
                    Printer.TableRows tableRows = null;
                    boolean rownum = options.containsKey(Printer.ROWNUM);
                    try {
                        columnSep = (String) options.getOrDefault(Printer.BORDER, "");
                        tableRows = optionRowHighlight(options.getOrDefault(Printer.ROW_HIGHLIGHT, null));
                    } catch (Exception e) {
                        runtimeException = new BadOptionValueException("Option border or rowHighlight has a bad value!");
                        runtimeException.addSuppressed(e);
                    }
                    try {
                        Object elem = collection.iterator().next();
                        boolean convert = canConvert(elem);
                        if (((elem instanceof Map) || convert) && !options.containsKey(Printer.TO_STRING)) {
                            List<Map<String, Object>> convertedCollection = new ArrayList<>();
                            Set<String> keys = new HashSet<>();
                            for (Object o : collection) {
                                Map<String, Object> m = convert ? objectToMap(options, o) : keysToString((Map) o);
                                convertedCollection.add(m);
                                keys.addAll(m.keySet());
                            }
                            List<String> columnsIn = optionList(Printer.COLUMNS_IN, options);
                            List<String> columnsOut = !options.containsKey(Printer.ALL) ? optionList(Printer.COLUMNS_OUT, options) : new ArrayList<>();
                            if (options.containsKey(Printer.COLUMNS)) {
                                _header = (List) options.get(Printer.COLUMNS);
                            } else {
                                _header = columnsIn;
                                _header.addAll((Collection) keys.stream().filter(k -> {
                                    return !columnsIn.contains(columnsOut) && !hasMatch(columnsIn, columnsOut);
                                }).collect(Collectors.toList()));
                            }
                            List<String> header = new ArrayList<>();
                            List<Integer> columns = new ArrayList<>();
                            int headerWidth = 0;
                            List<String> refKeys = new ArrayList<>();
                            for (String v : _header) {
                                String value = v.split("\\.")[0];
                                if (keys.contains(value) || keys.contains(v)) {
                                    boolean addKey = false;
                                    Iterator<Map<String, Object>> it = convertedCollection.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        Object val = mapValue(options, v, it.next());
                                        if (val != null) {
                                            addKey = simpleObject(val) || options.containsKey(Printer.COLUMNS) || options.containsKey(Printer.STRUCT_ON_TABLE);
                                        }
                                    }
                                    if (addKey) {
                                        refKeys.add(value);
                                        header.add(v);
                                        String cn = columnName(v, options.containsKey(Printer.SHORT_NAMES));
                                        columns.add(Integer.valueOf(cn.length() + 1));
                                        headerWidth += cn.length() + 1;
                                        if (headerWidth > width) {
                                            break;
                                        }
                                    }
                                }
                            }
                            if (header.size() == 0) {
                                throw new Exception("No columns for table!");
                            }
                            int matchLimit = (int) Math.ceil(((double) header.size()) * ((BigDecimal) options.getOrDefault(Printer.MAP_SIMILARITY, new BigDecimal("0.8"))).doubleValue());
                            for (Map<String, Object> m2 : convertedCollection) {
                                if (!similarSets(refKeys, m2.keySet(), matchLimit)) {
                                    throw new Exception("Not homogenous list!");
                                }
                                for (int i = 0; i < header.size(); i++) {
                                    int cw = highlightMapValue(options, header.get(i), m2).columnLength();
                                    if (cw > columns.get(i).intValue() - 1) {
                                        columns.set(i, Integer.valueOf(cw + 1));
                                    }
                                }
                            }
                            toTabStops(columns, collection.size(), rownum, columnSep);
                            AttributedStringBuilder asb = new AttributedStringBuilder().tabs(columns);
                            asb.style(this.prntStyle.resolve(".th"));
                            int firstColumn = 0;
                            if (rownum) {
                                asb.append((CharSequence) addPadding("", (columns.get(0).intValue() - columnSep.length()) - 1));
                                asb.append((CharSequence) columnSep);
                                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                                firstColumn = 1;
                            }
                            boolean first = true;
                            for (String s : header) {
                                if (!first) {
                                    asb.append((CharSequence) columnSep);
                                }
                                asb.append((CharSequence) columnName(s, options.containsKey(Printer.SHORT_NAMES)));
                                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                                first = false;
                            }
                            asb.columnSubSequence(0, width).println(terminal());
                            int row = 0;
                            for (Map<String, Object> m3 : convertedCollection) {
                                AttributedStringBuilder asb2 = new AttributedStringBuilder().tabs(columns);
                                if (doRowHighlight(row, tableRows)) {
                                    asb2.style(this.prntStyle.resolve(".rs"));
                                }
                                if (rownum) {
                                    asb2.styled(this.prntStyle.resolve(".rn"), addPadding(Integer.toString(row), (columns.get(0).intValue() - columnSep.length()) - 1));
                                    asb2.append((CharSequence) columnSep);
                                    asb2.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                                }
                                row++;
                                for (int i2 = 0; i2 < header.size(); i2++) {
                                    if (i2 > 0) {
                                        asb2.append((CharSequence) columnSep);
                                    }
                                    AttributedString v2 = highlightMapValue(options, header.get(i2), m3);
                                    if (isNumber(v2.toString())) {
                                        v2 = addPadding(v2, cellWidth(firstColumn + i2, columns, rownum, columnSep) - 1);
                                    }
                                    asb2.append(v2);
                                    asb2.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                                }
                                asb2.columnSubSequence(0, width).println(terminal());
                            }
                        } else if (!collectionObject(elem) || options.containsKey(Printer.TO_STRING)) {
                            highlightList(options, collection, width);
                        } else {
                            List<Integer> columns2 = new ArrayList<>();
                            for (Object o2 : collection) {
                                List<Object> inner = objectToList(o2);
                                for (int i3 = 0; i3 < inner.size(); i3++) {
                                    int len1 = objectToString(options, inner.get(i3)).length() + 1;
                                    if (columns2.size() <= i3) {
                                        columns2.add(Integer.valueOf(len1));
                                    } else if (len1 > columns2.get(i3).intValue()) {
                                        columns2.set(i3, Integer.valueOf(len1));
                                    }
                                }
                            }
                            toTabStops(columns2, collection.size(), rownum, columnSep);
                            int row2 = 0;
                            int firstColumn2 = rownum ? 1 : 0;
                            for (Object o3 : collection) {
                                AttributedStringBuilder asb3 = new AttributedStringBuilder().tabs(columns2);
                                if (doRowHighlight(row2, tableRows)) {
                                    asb3.style(this.prntStyle.resolve(".rs"));
                                }
                                if (rownum) {
                                    asb3.styled(this.prntStyle.resolve(".rn"), addPadding(Integer.toString(row2), (columns2.get(0).intValue() - columnSep.length()) - 1));
                                    asb3.append((CharSequence) columnSep);
                                    asb3.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                                }
                                row2++;
                                List<Object> inner2 = objectToList(o3);
                                for (int i4 = 0; i4 < inner2.size(); i4++) {
                                    if (i4 > 0) {
                                        asb3.append((CharSequence) columnSep);
                                    }
                                    AttributedString v3 = highlightValue(options, null, inner2.get(i4));
                                    if (isNumber(v3.toString())) {
                                        v3 = addPadding(v3, cellWidth(firstColumn2 + i4, columns2, rownum, columnSep) - 1);
                                    }
                                    asb3.append(v3);
                                    asb3.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                                }
                                asb3.columnSubSequence(0, width).println(terminal());
                            }
                        }
                    } catch (Exception e2) {
                        Log.debug("Stack: ", e2);
                        highlightList(options, collection, width);
                    }
                } else {
                    Object elem2 = collection.iterator().next();
                    if (elem2 instanceof Map) {
                        highlightMap(options, keysToString((Map) elem2), width);
                    } else if (canConvert(elem2) && !options.containsKey(Printer.TO_STRING)) {
                        highlightMap(options, objectToMap(options, elem2), width);
                    } else if (!(elem2 instanceof String) || options.get(Printer.STYLE) == null) {
                        highlightValue(options, null, objectToString(options, obj)).println(terminal());
                    } else {
                        highlightAndPrint(width, (Nano.SyntaxHighlighter) options.get(Printer.STYLE), (String) elem2, true);
                    }
                }
            } else if (!canConvert(obj) || options.containsKey(Printer.TO_STRING)) {
                highlightValue(options, null, objectToString(options, obj)).println(terminal());
            } else {
                highlightMap(options, objectToMap(options, obj), width);
            }
        }
        if (message != null) {
            AttributedStringBuilder asb4 = new AttributedStringBuilder();
            asb4.styled(this.prntStyle.resolve(".em"), message);
            asb4.println(terminal());
        }
        if (runtimeException != null) {
            throw runtimeException;
        }
    }

    private boolean doRowHighlight(int row, Printer.TableRows tableRows) {
        if (tableRows == null) {
            return false;
        }
        switch (tableRows) {
            case EVEN:
                return row % 2 == 0;
            case ODD:
                return row % 2 == 1;
            case ALL:
                return true;
            default:
                return false;
        }
    }

    private void highlightList(Map<String, Object> options, List<Object> collection, int width) {
        highlightList(options, collection, width, 0);
    }

    private void highlightList(Map<String, Object> options, List<Object> collection, int width, int depth) {
        int row = 0;
        int maxrows = ((Integer) options.get(Printer.MAXROWS)).intValue();
        int indent = ((Integer) options.get(Printer.INDENTION)).intValue();
        List<Integer> tabs = new ArrayList<>();
        tabs.add(Integer.valueOf(indent * depth));
        if (options.containsKey(Printer.ROWNUM)) {
            tabs.add(Integer.valueOf((indent * depth) + digits(collection.size()) + 2));
        }
        options.remove(Printer.MAX_COLUMN_WIDTH);
        Nano.SyntaxHighlighter highlighter = depth == 0 ? (Nano.SyntaxHighlighter) options.get(Printer.STYLE) : null;
        for (Object o : collection) {
            AttributedStringBuilder asb = new AttributedStringBuilder().tabs(tabs);
            if (depth > 0) {
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            }
            if (options.containsKey(Printer.ROWNUM)) {
                asb.styled(this.prntStyle.resolve(".rn"), Integer.toString(row)).append((CharSequence) EmitterKt.COMMENT_PREFIX);
                asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                row++;
            }
            if (highlighter == null || !(o instanceof String)) {
                asb.append(highlightValue(options, null, o));
            } else {
                asb.append(highlighter.highlight((String) o));
            }
            println(asb.columnSubSequence(0, width), maxrows);
        }
    }

    private boolean collectionObject(Object obj) {
        return (obj instanceof Iterator) || (obj instanceof Iterable) || (obj instanceof Object[]);
    }

    private boolean simpleObject(Object obj) {
        return (obj instanceof Number) || (obj instanceof String) || (obj instanceof Date) || (obj instanceof File) || (obj instanceof Boolean) || (obj instanceof Enum);
    }

    private boolean canConvert(Object obj) {
        return this.engine != null && obj != null && !(obj instanceof Class) && !(obj instanceof Map) && !simpleObject(obj) && !collectionObject(obj);
    }

    private int digits(int number) {
        if (number < 100) {
            return number < 10 ? 1 : 2;
        }
        if (number < 1000) {
            return 3;
        }
        return number < 10000 ? 4 : 5;
    }

    private int cellWidth(int pos, List<Integer> columns, boolean rownum, String columnSep) {
        if (pos == 0) {
            return columns.get(0).intValue();
        }
        return (columns.get(pos).intValue() - columns.get(pos - 1).intValue()) - ((!rownum || pos != 1) ? columnSep.length() : 0);
    }

    private void toTabStops(List<Integer> columns, int rows, boolean rownum, String columnSep) {
        if (rownum) {
            columns.add(0, Integer.valueOf(digits(rows) + 2 + columnSep.length()));
        }
        int i = 1;
        while (i < columns.size()) {
            columns.set(i, Integer.valueOf(columns.get(i - 1).intValue() + columns.get(i).intValue() + ((i > 1 || !rownum) ? columnSep.length() : 0)));
            i++;
        }
    }

    private void highlightMap(Map<String, Object> options, Map<String, Object> map, int width) {
        if (!map.isEmpty()) {
            highlightMap(options, map, width, 0);
        } else {
            highlightValue(options, null, objectToString(options, map)).println(terminal());
        }
    }

    private void highlightMap(Map<String, Object> options, Map<String, Object> map, int width, int depth) {
        int maxrows = ((Integer) options.get(Printer.MAXROWS)).intValue();
        int max = ((Integer) map.keySet().stream().map((v0) -> {
            return v0.length();
        }).max((v0, v1) -> {
            return v0.compareTo(v1);
        }).get()).intValue();
        if (max > ((Integer) options.getOrDefault(Printer.MAX_COLUMN_WIDTH, Integer.MAX_VALUE)).intValue()) {
            max = ((Integer) options.get(Printer.MAX_COLUMN_WIDTH)).intValue();
        }
        Map<String, Object> mapOptions = new HashMap<>(options);
        mapOptions.remove(Printer.MAX_COLUMN_WIDTH);
        int indent = ((Integer) options.get(Printer.INDENTION)).intValue();
        int maxDepth = ((Integer) options.get(Printer.MAX_DEPTH)).intValue();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (depth != 0 || !options.containsKey(Printer.COLUMNS) || ((List) options.get(Printer.COLUMNS)).contains(entry.getKey())) {
                AttributedStringBuilder asb = new AttributedStringBuilder().tabs(Arrays.asList(0, Integer.valueOf(depth * indent), Integer.valueOf((depth * indent) + max + 1)));
                if (depth != 0) {
                    asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                }
                asb.styled(this.prntStyle.resolve(".mk"), truncateValue(max, entry.getKey()));
                Object elem = entry.getValue();
                boolean convert = canConvert(elem);
                boolean highlightValue = true;
                if (depth < maxDepth && !options.containsKey(Printer.TO_STRING)) {
                    if ((elem instanceof Map) || convert) {
                        Map<String, Object> childMap = convert ? objectToMap(options, elem) : keysToString((Map) elem);
                        if (!childMap.isEmpty()) {
                            println(asb.columnSubSequence(0, width), maxrows);
                            highlightMap(options, childMap, width, depth + 1);
                            highlightValue = false;
                        }
                    } else if (collectionObject(elem)) {
                        List<Object> collection = objectToList(elem);
                        if (!collection.isEmpty()) {
                            println(asb.columnSubSequence(0, width), maxrows);
                            Map<String, Object> listOptions = new HashMap<>(options);
                            listOptions.put(Printer.TO_STRING, true);
                            highlightList(listOptions, collection, width, depth + 1);
                            highlightValue = false;
                        }
                    }
                }
                if (highlightValue) {
                    AttributedString val = highlightMapValue(mapOptions, entry.getKey(), map);
                    asb.append((CharSequence) SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
                    if (map.size() != 1) {
                        if (val.contains('\n')) {
                            asb.append(highlightValue(options, entry.getKey(), new AttributedString(Arrays.asList(val.toString().split("\\r?\\n")).toString()).toString()));
                        } else {
                            asb.append(val);
                        }
                        println(asb.columnSubSequence(0, width), maxrows);
                    } else if (val.contains('\n')) {
                        for (String v : val.toString().split("\\r?\\n")) {
                            asb.append(highlightValue(options, entry.getKey(), v));
                            println(asb.columnSubSequence(0, width), maxrows);
                            asb = new AttributedStringBuilder().tabs(Arrays.asList(0, Integer.valueOf(max + 1)));
                        }
                    } else {
                        asb.append(val);
                        println(asb.columnSubSequence(0, width), maxrows);
                    }
                }
            }
        }
    }
}
