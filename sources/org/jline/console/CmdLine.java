package org.jline.console;

import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:org/jline/console/CmdLine.class */
public class CmdLine {
    private final String line;
    private final String head;
    private final String tail;
    private final List<String> args;
    private final DescriptionType descType;

    /* loaded from: grasscutter.jar:org/jline/console/CmdLine$DescriptionType.class */
    public enum DescriptionType {
        COMMAND,
        METHOD,
        SYNTAX
    }

    public CmdLine(String line, String head, String tail, List<String> args, DescriptionType descType) {
        this.line = line;
        this.head = head;
        this.tail = tail;
        this.args = new ArrayList(args);
        this.descType = descType;
    }

    public String getLine() {
        return this.line;
    }

    public String getHead() {
        return this.head;
    }

    public String getTail() {
        return this.tail;
    }

    public List<String> getArgs() {
        return this.args;
    }

    public DescriptionType getDescriptionType() {
        return this.descType;
    }
}
