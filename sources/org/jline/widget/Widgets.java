package org.jline.widget;

import dev.morphia.mapping.Mapper;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import net.bytebuddy.utility.JavaConstant;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.Buffer;
import org.jline.reader.LineReader;
import org.jline.reader.Parser;
import org.jline.reader.Reference;
import org.jline.reader.Widget;
import org.jline.utils.AttributedString;
import org.jline.utils.Status;

/* loaded from: grasscutter.jar:org/jline/widget/Widgets.class */
public abstract class Widgets {
    public static final String TAILTIP_TOGGLE = "tailtip-toggle";
    public static final String TAILTIP_PANE = "tailtip-window";
    public static final String AUTOPAIR_TOGGLE = "autopair-toggle";
    public static final String AUTOSUGGEST_TOGGLE = "autosuggest-toggle";
    protected static final String AP_INSERT = "_autopair-insert";
    protected static final String AP_BACKWARD_DELETE_CHAR = "_autopair-backward-delete-char";
    protected static final String TT_ACCEPT_LINE = "_tailtip-accept-line";
    protected final LineReader reader;

    public Widgets(LineReader reader) {
        this.reader = reader;
    }

    public void addWidget(String name, Widget widget) {
        this.reader.getWidgets().put(name, namedWidget(name, widget));
    }

    private Widget namedWidget(final String name, final Widget widget) {
        return new Widget() { // from class: org.jline.widget.Widgets.1
            public String toString() {
                return name;
            }

            @Override // org.jline.reader.Widget
            public boolean apply() {
                return widget.apply();
            }
        };
    }

    public void callWidget(String name) {
        if (!name.startsWith(JavaConstant.Dynamic.DEFAULT_NAME) && !name.endsWith("-toggle")) {
            name = Mapper.IGNORED_FIELDNAME + name;
        }
        this.reader.callWidget(name);
    }

    public void executeWidget(String name) {
        Binding ref = getKeyMap().getBoundKeys().get(KeyMap.alt(KeyMap.ctrl('X')));
        getKeyMap().bind((KeyMap<Binding>) new Reference(name), KeyMap.alt(KeyMap.ctrl('X')));
        this.reader.runMacro(KeyMap.alt(KeyMap.ctrl('X')));
        if (ref != null) {
            getKeyMap().bind((KeyMap<Binding>) ref, KeyMap.alt(KeyMap.ctrl('X')));
        }
    }

    public void aliasWidget(String orig, String alias) {
        this.reader.getWidgets().put(alias, widget(orig));
    }

    public String getWidget(String name) {
        return widget(name).toString();
    }

    public boolean existsWidget(String name) {
        try {
            widget(name);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Widget widget(String name) {
        Widget out;
        if (name.startsWith(Mapper.IGNORED_FIELDNAME)) {
            out = this.reader.getBuiltinWidgets().get(name.substring(1));
        } else {
            out = this.reader.getWidgets().get(name);
        }
        if (out != null) {
            return out;
        }
        throw new InvalidParameterException("widget: no such widget " + name);
    }

    public Parser parser() {
        return this.reader.getParser();
    }

    public KeyMap<Binding> getKeyMap() {
        return this.reader.getKeyMaps().get(LineReader.MAIN);
    }

    public Buffer buffer() {
        return this.reader.getBuffer();
    }

    public void replaceBuffer(Buffer buffer) {
        this.reader.getBuffer().copyFrom(buffer);
    }

    public List<String> args() {
        return this.reader.getParser().parse(buffer().toString(), 0, Parser.ParseContext.COMPLETE).words();
    }

    public String prevChar() {
        return String.valueOf((char) this.reader.getBuffer().prevChar());
    }

    public String currChar() {
        return String.valueOf((char) this.reader.getBuffer().currChar());
    }

    public String lastBinding() {
        return this.reader.getLastBinding();
    }

    public void putString(String string) {
        this.reader.getBuffer().write(string);
    }

    public String tailTip() {
        return this.reader.getTailTip();
    }

    public void setTailTip(String tailTip) {
        this.reader.setTailTip(tailTip);
    }

    public void setErrorPattern(Pattern errorPattern) {
        this.reader.getHighlighter().setErrorPattern(errorPattern);
    }

    public void setErrorIndex(int errorIndex) {
        this.reader.getHighlighter().setErrorIndex(errorIndex);
    }

    public void clearTailTip() {
        this.reader.setTailTip("");
    }

    public void setSuggestionType(LineReader.SuggestionType type) {
        this.reader.setAutosuggestion(type);
    }

    public void addDescription(List<AttributedString> desc) {
        Status.getStatus(this.reader.getTerminal()).update(desc);
    }

    public void clearDescription() {
        initDescription(0);
    }

    public void initDescription(int size) {
        Status status = Status.getStatus(this.reader.getTerminal(), false);
        if (size > 0) {
            if (status == null) {
                status = Status.getStatus(this.reader.getTerminal());
            }
            status.setBorder(true);
            List<AttributedString> as = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                as.add(new AttributedString(""));
            }
            addDescription(as);
        } else if (status != null) {
            if (size < 0) {
                status.update(null);
            } else {
                status.clear();
            }
        }
    }

    public void destroyDescription() {
        initDescription(-1);
    }
}
