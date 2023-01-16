package org.jline.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jline.console.Printer;
import org.jline.keymap.KeyMap;
import org.jline.reader.Binding;
import org.jline.reader.Buffer;
import org.jline.reader.LineReader;
import org.jline.reader.Reference;

/* loaded from: grasscutter.jar:org/jline/widget/AutopairWidgets.class */
public class AutopairWidgets extends Widgets {
    private static final Map<String, String> LBOUNDS = new HashMap();
    private static final Map<String, String> RBOUNDS = new HashMap();
    private final Map<String, String> pairs;
    private final Map<String, Binding> defaultBindings;
    private boolean enabled;

    static {
        LBOUNDS.put(Printer.ALL, "[.:/\\!]");
        LBOUNDS.put("quotes", "[\\]})a-zA-Z0-9]");
        LBOUNDS.put("spaces", "[^{(\\[]");
        LBOUNDS.put("braces", "");
        LBOUNDS.put("`", "`");
        LBOUNDS.put("\"", "\"");
        LBOUNDS.put("'", "'");
        RBOUNDS.put(Printer.ALL, "[\\[{(<,.:?/%$!a-zA-Z0-9]");
        RBOUNDS.put("quotes", "[a-zA-Z0-9]");
        RBOUNDS.put("spaces", "[^\\]})]");
        RBOUNDS.put("braces", "");
        RBOUNDS.put("`", "");
        RBOUNDS.put("\"", "");
        RBOUNDS.put("'", "");
    }

    public AutopairWidgets(LineReader reader) {
        this(reader, false);
    }

    public AutopairWidgets(LineReader reader, boolean addCurlyBrackets) {
        super(reader);
        this.defaultBindings = new HashMap();
        this.pairs = new HashMap();
        this.pairs.put("`", "`");
        this.pairs.put("'", "'");
        this.pairs.put("\"", "\"");
        this.pairs.put("[", "]");
        this.pairs.put("(", ")");
        this.pairs.put(" ", " ");
        if (existsWidget("_autopair-insert")) {
            throw new IllegalStateException("AutopairWidgets already created!");
        }
        if (addCurlyBrackets) {
            this.pairs.put("{", "}");
        }
        addWidget("_autopair-insert", this::autopairInsert);
        addWidget("_autopair-close", this::autopairClose);
        addWidget("_autopair-backward-delete-char", this::autopairDelete);
        addWidget(Widgets.AUTOPAIR_TOGGLE, this::toggleKeyBindings);
        KeyMap<Binding> map = getKeyMap();
        for (Map.Entry<String, String> p : this.pairs.entrySet()) {
            this.defaultBindings.put(p.getKey(), map.getBound(p.getKey()));
            if (!p.getKey().equals(p.getValue())) {
                this.defaultBindings.put(p.getValue(), map.getBound(p.getValue()));
            }
        }
    }

    public void enable() {
        if (!this.enabled) {
            toggle();
        }
    }

    public void disable() {
        if (this.enabled) {
            toggle();
        }
    }

    public boolean toggle() {
        boolean before = this.enabled;
        toggleKeyBindings();
        return !before;
    }

    public boolean autopairInsert() {
        if (!this.pairs.containsKey(lastBinding())) {
            callWidget(LineReader.SELF_INSERT);
            return true;
        } else if (canSkip(lastBinding())) {
            callWidget(LineReader.FORWARD_CHAR);
            return true;
        } else if (canPair(lastBinding())) {
            callWidget(LineReader.SELF_INSERT);
            putString(this.pairs.get(lastBinding()));
            callWidget(LineReader.BACKWARD_CHAR);
            return true;
        } else {
            callWidget(LineReader.SELF_INSERT);
            return true;
        }
    }

    public boolean autopairClose() {
        if (!this.pairs.containsValue(lastBinding()) || !currChar().equals(lastBinding())) {
            callWidget(LineReader.SELF_INSERT);
            return true;
        }
        callWidget(LineReader.FORWARD_CHAR);
        return true;
    }

    public boolean autopairDelete() {
        if (this.pairs.containsKey(prevChar()) && this.pairs.get(prevChar()).equals(currChar()) && canDelete(prevChar())) {
            callWidget(LineReader.DELETE_CHAR);
        }
        callWidget(LineReader.BACKWARD_DELETE_CHAR);
        return true;
    }

    public boolean toggleKeyBindings() {
        if (this.enabled) {
            defaultBindings();
        } else {
            customBindings();
        }
        return this.enabled;
    }

    private void customBindings() {
        boolean ttActive = tailtipEnabled();
        if (ttActive) {
            callWidget(Widgets.TAILTIP_TOGGLE);
        }
        KeyMap<Binding> map = getKeyMap();
        for (Map.Entry<String, String> p : this.pairs.entrySet()) {
            map.bind((KeyMap<Binding>) new Reference("_autopair-insert"), p.getKey());
            if (!p.getKey().equals(p.getValue())) {
                map.bind((KeyMap<Binding>) new Reference("_autopair-close"), p.getValue());
            }
        }
        aliasWidget("_autopair-backward-delete-char", LineReader.BACKWARD_DELETE_CHAR);
        if (ttActive) {
            callWidget(Widgets.TAILTIP_TOGGLE);
        }
        this.enabled = true;
    }

    private void defaultBindings() {
        KeyMap<Binding> map = getKeyMap();
        for (Map.Entry<String, String> p : this.pairs.entrySet()) {
            map.bind((KeyMap<Binding>) this.defaultBindings.get(p.getKey()), p.getKey());
            if (!p.getKey().equals(p.getValue())) {
                map.bind((KeyMap<Binding>) this.defaultBindings.get(p.getValue()), p.getValue());
            }
        }
        aliasWidget(".backward-delete-char", LineReader.BACKWARD_DELETE_CHAR);
        if (tailtipEnabled()) {
            callWidget(Widgets.TAILTIP_TOGGLE);
            callWidget(Widgets.TAILTIP_TOGGLE);
        }
        this.enabled = false;
    }

    private boolean tailtipEnabled() {
        return getWidget(LineReader.ACCEPT_LINE).equals("_tailtip-accept-line");
    }

    private boolean canPair(String d) {
        if (!balanced(d) || nexToBoundary(d)) {
            return false;
        }
        return !d.equals(" ") || (!prevChar().equals(" ") && !currChar().equals(" "));
    }

    private boolean canSkip(String d) {
        return this.pairs.get(d).equals(d) && d.charAt(0) != ' ' && currChar().equals(d) && balanced(d);
    }

    private boolean canDelete(String d) {
        return balanced(d);
    }

    private boolean balanced(String d) {
        boolean out = false;
        Buffer buf = buffer();
        String lbuf = buf.upToCursor();
        String rbuf = buf.substring(lbuf.length());
        String regx1 = this.pairs.get(d).equals(d) ? d : "\\" + d;
        String regx2 = this.pairs.get(d).equals(d) ? this.pairs.get(d) : "\\" + this.pairs.get(d);
        int llen = lbuf.length() - lbuf.replaceAll(regx1, "").length();
        int rlen = rbuf.length() - rbuf.replaceAll(regx2, "").length();
        if (llen == 0 && rlen == 0) {
            out = true;
        } else if (d.charAt(0) == ' ') {
            out = true;
        } else if (!this.pairs.get(d).equals(d)) {
            int ltotal = llen - (lbuf.length() - lbuf.replaceAll(regx2, "").length());
            int rtotal = rlen - (rbuf.length() - rbuf.replaceAll(regx1, "").length());
            if (ltotal < 0) {
                ltotal = 0;
            }
            if (ltotal >= rtotal) {
                out = true;
            }
        } else if (llen == rlen || (llen + rlen) % 2 == 0) {
            out = true;
        }
        return out;
    }

    private boolean boundary(String lb, String rb) {
        return (lb.length() > 0 && prevChar().matches(lb)) || (rb.length() > 0 && currChar().matches(rb));
    }

    private boolean nexToBoundary(String d) {
        List<String> bk = new ArrayList<>();
        bk.add(Printer.ALL);
        if (d.matches("['\"`]")) {
            bk.add("quotes");
        } else if (d.matches("[{\\[(<]")) {
            bk.add("braces");
        } else if (d.charAt(0) == ' ') {
            bk.add("spaces");
        }
        if (LBOUNDS.containsKey(d) && RBOUNDS.containsKey(d)) {
            bk.add(d);
        }
        for (String k : bk) {
            if (boundary(LBOUNDS.get(k), RBOUNDS.get(k))) {
                return true;
            }
        }
        return false;
    }
}
