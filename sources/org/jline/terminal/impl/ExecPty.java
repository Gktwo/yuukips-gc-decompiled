package org.jline.terminal.impl;

import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jline.console.Printer;
import org.jline.terminal.Attributes;
import org.jline.terminal.Size;
import org.jline.terminal.spi.Pty;
import org.jline.utils.ExecHelper;
import org.jline.utils.OSUtils;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/terminal/impl/ExecPty.class */
public class ExecPty extends AbstractPty implements Pty {
    private final String name;
    private final boolean system;

    public static Pty current() throws IOException {
        try {
            return new ExecPty(ExecHelper.exec(true, OSUtils.TTY_COMMAND).trim(), true);
        } catch (IOException e) {
            throw new IOException("Not a tty", e);
        }
    }

    protected ExecPty(String name, boolean system) {
        this.name = name;
        this.system = system;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public String getName() {
        return this.name;
    }

    @Override // org.jline.terminal.spi.Pty
    public InputStream getMasterInput() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jline.terminal.spi.Pty
    public OutputStream getMasterOutput() {
        throw new UnsupportedOperationException();
    }

    @Override // org.jline.terminal.impl.AbstractPty
    protected InputStream doGetSlaveInput() throws IOException {
        if (this.system) {
            return new FileInputStream(FileDescriptor.in);
        }
        return new FileInputStream(getName());
    }

    @Override // org.jline.terminal.spi.Pty
    public OutputStream getSlaveOutput() throws IOException {
        if (this.system) {
            return new FileOutputStream(FileDescriptor.out);
        }
        return new FileOutputStream(getName());
    }

    @Override // org.jline.terminal.spi.Pty
    public Attributes getAttr() throws IOException {
        return doGetAttr(doGetConfig());
    }

    @Override // org.jline.terminal.impl.AbstractPty
    protected void doSetAttr(Attributes attr) throws IOException {
        List<String> commands = getFlagsToSet(attr, getAttr());
        if (!commands.isEmpty()) {
            commands.add(0, OSUtils.STTY_COMMAND);
            if (!this.system) {
                commands.add(1, OSUtils.STTY_F_OPTION);
                commands.add(2, getName());
            }
            ExecHelper.exec(this.system, (String[]) commands.toArray(new String[commands.size()]));
        }
    }

    protected List<String> getFlagsToSet(Attributes attr, Attributes current) {
        List<String> commands = new ArrayList<>();
        Attributes.InputFlag[] values = Attributes.InputFlag.values();
        for (Attributes.InputFlag flag : values) {
            if (attr.getInputFlag(flag) != current.getInputFlag(flag)) {
                commands.add((attr.getInputFlag(flag) ? flag.name() : "-" + flag.name()).toLowerCase());
            }
        }
        Attributes.OutputFlag[] values2 = Attributes.OutputFlag.values();
        for (Attributes.OutputFlag flag2 : values2) {
            if (attr.getOutputFlag(flag2) != current.getOutputFlag(flag2)) {
                commands.add((attr.getOutputFlag(flag2) ? flag2.name() : "-" + flag2.name()).toLowerCase());
            }
        }
        Attributes.ControlFlag[] values3 = Attributes.ControlFlag.values();
        for (Attributes.ControlFlag flag3 : values3) {
            if (attr.getControlFlag(flag3) != current.getControlFlag(flag3)) {
                commands.add((attr.getControlFlag(flag3) ? flag3.name() : "-" + flag3.name()).toLowerCase());
            }
        }
        Attributes.LocalFlag[] values4 = Attributes.LocalFlag.values();
        for (Attributes.LocalFlag flag4 : values4) {
            if (attr.getLocalFlag(flag4) != current.getLocalFlag(flag4)) {
                commands.add((attr.getLocalFlag(flag4) ? flag4.name() : "-" + flag4.name()).toLowerCase());
            }
        }
        String undef = System.getProperty("os.name").toLowerCase().startsWith("hp") ? "^-" : "undef";
        Attributes.ControlChar[] values5 = Attributes.ControlChar.values();
        for (Attributes.ControlChar cchar : values5) {
            int v = attr.getControlChar(cchar);
            if (v >= 0 && v != current.getControlChar(cchar)) {
                String str = "";
                commands.add(cchar.name().toLowerCase().substring(1));
                if (cchar == Attributes.ControlChar.VMIN || cchar == Attributes.ControlChar.VTIME) {
                    commands.add(Integer.toString(v));
                } else if (v == 0) {
                    commands.add(undef);
                } else {
                    if (v >= 128) {
                        v -= 128;
                        str = str + "M-";
                    }
                    if (v < 32 || v == 127) {
                        v ^= 64;
                        str = str + "^";
                    }
                    commands.add(str + ((char) v));
                }
            }
        }
        return commands;
    }

    @Override // org.jline.terminal.spi.Pty
    public Size getSize() throws IOException {
        return doGetSize(doGetConfig());
    }

    protected String doGetConfig() throws IOException {
        if (this.system) {
            return ExecHelper.exec(true, OSUtils.STTY_COMMAND, "-a");
        }
        return ExecHelper.exec(false, OSUtils.STTY_COMMAND, OSUtils.STTY_F_OPTION, getName(), "-a");
    }

    /* access modifiers changed from: package-private */
    public static Attributes doGetAttr(String cfg) throws IOException {
        Attributes attributes = new Attributes();
        Attributes.InputFlag[] values = Attributes.InputFlag.values();
        for (Attributes.InputFlag flag : values) {
            Boolean value = doGetFlag(cfg, flag);
            if (value != null) {
                attributes.setInputFlag(flag, value.booleanValue());
            }
        }
        Attributes.OutputFlag[] values2 = Attributes.OutputFlag.values();
        for (Attributes.OutputFlag flag2 : values2) {
            Boolean value2 = doGetFlag(cfg, flag2);
            if (value2 != null) {
                attributes.setOutputFlag(flag2, value2.booleanValue());
            }
        }
        Attributes.ControlFlag[] values3 = Attributes.ControlFlag.values();
        for (Attributes.ControlFlag flag3 : values3) {
            Boolean value3 = doGetFlag(cfg, flag3);
            if (value3 != null) {
                attributes.setControlFlag(flag3, value3.booleanValue());
            }
        }
        Attributes.LocalFlag[] values4 = Attributes.LocalFlag.values();
        for (Attributes.LocalFlag flag4 : values4) {
            Boolean value4 = doGetFlag(cfg, flag4);
            if (value4 != null) {
                attributes.setLocalFlag(flag4, value4.booleanValue());
            }
        }
        Attributes.ControlChar[] values5 = Attributes.ControlChar.values();
        for (Attributes.ControlChar cchar : values5) {
            String name = cchar.name().toLowerCase().substring(1);
            if ("reprint".endsWith(name)) {
                name = "(?:reprint|rprnt)";
            }
            Matcher matcher = Pattern.compile("[\\s;]" + name + "\\s*=\\s*(.+?)[\\s;]").matcher(cfg);
            if (matcher.find()) {
                attributes.setControlChar(cchar, parseControlChar(matcher.group(1).toUpperCase()));
            }
        }
        return attributes;
    }

    private static Boolean doGetFlag(String cfg, Enum<?> flag) {
        Matcher matcher = Pattern.compile("(?:^|[\\s;])(\\-?" + flag.name().toLowerCase() + ")(?:[\\s;]|$)").matcher(cfg);
        if (!matcher.find()) {
            return null;
        }
        return Boolean.valueOf(!matcher.group(1).startsWith("-"));
    }

    static int parseControlChar(String str) {
        if ("<UNDEF>".equals(str)) {
            return -1;
        }
        if ("DEL".equalsIgnoreCase(str)) {
            return 127;
        }
        if (str.charAt(0) == '0') {
            return Integer.parseInt(str, 8);
        }
        if (str.charAt(0) >= '1' && str.charAt(0) <= '9') {
            return Integer.parseInt(str, 10);
        }
        if (str.charAt(0) == '^') {
            if (str.charAt(1) == '?') {
                return 127;
            }
            return str.charAt(1) - '@';
        } else if (str.charAt(0) != 'M' || str.charAt(1) != '-') {
            return str.charAt(0);
        } else {
            if (str.charAt(2) != '^') {
                return str.charAt(2) + 128;
            }
            if (str.charAt(3) == '?') {
                return 255;
            }
            return (str.charAt(3) - '@') + 128;
        }
    }

    static Size doGetSize(String cfg) throws IOException {
        return new Size(doGetInt(Printer.COLUMNS, cfg), doGetInt("rows", cfg));
    }

    static int doGetInt(String name, String cfg) throws IOException {
        for (String pattern : new String[]{"\\b([0-9]+)\\s+" + name + "\\b", "\\b" + name + "\\s+([0-9]+)\\b", "\\b" + name + "\\s*=\\s*([0-9]+)\\b"}) {
            Matcher matcher = Pattern.compile(pattern).matcher(cfg);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group(1));
            }
        }
        throw new IOException("Unable to parse " + name);
    }

    @Override // org.jline.terminal.spi.Pty
    public void setSize(Size size) throws IOException {
        if (this.system) {
            ExecHelper.exec(true, OSUtils.STTY_COMMAND, Printer.COLUMNS, Integer.toString(size.getColumns()), "rows", Integer.toString(size.getRows()));
        } else {
            ExecHelper.exec(false, OSUtils.STTY_COMMAND, OSUtils.STTY_F_OPTION, getName(), Printer.COLUMNS, Integer.toString(size.getColumns()), "rows", Integer.toString(size.getRows()));
        }
    }

    @Override // java.lang.Object
    public String toString() {
        return "ExecPty[" + getName() + (this.system ? ", system]" : "]");
    }
}
