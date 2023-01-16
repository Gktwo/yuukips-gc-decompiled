package org.jline.console;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;
import org.jline.reader.LineReader;
import org.jline.utils.AttributedString;

/* loaded from: grasscutter.jar:org/jline/console/CmdDesc.class */
public class CmdDesc {
    private List<AttributedString> mainDesc;
    private List<ArgDesc> argsDesc;
    private TreeMap<String, List<AttributedString>> optsDesc;
    private Pattern errorPattern;
    private int errorIndex;
    private boolean valid;
    private boolean command;
    private boolean subcommand;
    private boolean highlighted;

    public CmdDesc() {
        this.errorIndex = -1;
        this.valid = true;
        this.command = false;
        this.subcommand = false;
        this.highlighted = true;
        this.command = false;
    }

    public CmdDesc(boolean valid) {
        this.errorIndex = -1;
        this.valid = true;
        this.command = false;
        this.subcommand = false;
        this.highlighted = true;
        this.valid = valid;
    }

    public CmdDesc(List<ArgDesc> argsDesc) {
        this(new ArrayList(), argsDesc, new HashMap());
    }

    public CmdDesc(List<ArgDesc> argsDesc, Map<String, List<AttributedString>> optsDesc) {
        this(new ArrayList(), argsDesc, optsDesc);
    }

    public CmdDesc(List<AttributedString> mainDesc, List<ArgDesc> argsDesc, Map<String, List<AttributedString>> optsDesc) {
        this.errorIndex = -1;
        this.valid = true;
        this.command = false;
        this.subcommand = false;
        this.highlighted = true;
        this.argsDesc = new ArrayList(argsDesc);
        this.optsDesc = new TreeMap<>(optsDesc);
        if (!mainDesc.isEmpty() || !optsDesc.containsKey(LineReader.MAIN)) {
            this.mainDesc = new ArrayList(mainDesc);
        } else {
            this.mainDesc = new ArrayList(optsDesc.get(LineReader.MAIN));
            this.optsDesc.remove(LineReader.MAIN);
        }
        this.command = true;
    }

    public boolean isValid() {
        return this.valid;
    }

    public boolean isCommand() {
        return this.command;
    }

    public void setSubcommand(boolean subcommand) {
        this.subcommand = subcommand;
    }

    public boolean isSubcommand() {
        return this.subcommand;
    }

    public void setHighlighted(boolean highlighted) {
        this.highlighted = highlighted;
    }

    public boolean isHighlighted() {
        return this.highlighted;
    }

    public CmdDesc mainDesc(List<AttributedString> mainDesc) {
        this.mainDesc = new ArrayList(mainDesc);
        return this;
    }

    public void setMainDesc(List<AttributedString> mainDesc) {
        this.mainDesc = new ArrayList(mainDesc);
    }

    public List<AttributedString> getMainDesc() {
        return this.mainDesc;
    }

    public TreeMap<String, List<AttributedString>> getOptsDesc() {
        return this.optsDesc;
    }

    public void setErrorPattern(Pattern errorPattern) {
        this.errorPattern = errorPattern;
    }

    public Pattern getErrorPattern() {
        return this.errorPattern;
    }

    public void setErrorIndex(int errorIndex) {
        this.errorIndex = errorIndex;
    }

    public int getErrorIndex() {
        return this.errorIndex;
    }

    public List<ArgDesc> getArgsDesc() {
        return this.argsDesc;
    }

    public boolean optionWithValue(String option) {
        for (String key : this.optsDesc.keySet()) {
            if (key.matches("(^|.*\\s)" + option + "($|=.*|\\s.*)")) {
                return key.contains("=");
            }
        }
        return false;
    }

    public AttributedString optionDescription(String key) {
        return this.optsDesc.get(key).size() > 0 ? this.optsDesc.get(key).get(0) : new AttributedString("");
    }
}
