package org.jline.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.jline.terminal.Size;
import org.jline.terminal.Terminal;
import org.jline.terminal.impl.AbstractTerminal;
import org.jline.utils.InfoCmp;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/Status.class */
public class Status {
    protected final AbstractTerminal terminal;
    protected final boolean supported;
    protected int rows;
    protected int columns;
    protected boolean force;
    protected AttributedString borderString;
    protected List<AttributedString> oldLines = Collections.emptyList();
    protected List<AttributedString> linesToRestore = Collections.emptyList();
    protected boolean suspended = false;
    protected int border = 0;

    public static Status getStatus(Terminal terminal) {
        return getStatus(terminal, true);
    }

    public static Status getStatus(Terminal terminal, boolean create) {
        if (terminal instanceof AbstractTerminal) {
            return ((AbstractTerminal) terminal).getStatus(create);
        }
        return null;
    }

    public Status(AbstractTerminal terminal) {
        this.terminal = (AbstractTerminal) Objects.requireNonNull(terminal, "terminal can not be null");
        this.supported = (terminal.getStringCapability(InfoCmp.Capability.change_scroll_region) == null || terminal.getStringCapability(InfoCmp.Capability.save_cursor) == null || terminal.getStringCapability(InfoCmp.Capability.restore_cursor) == null || terminal.getStringCapability(InfoCmp.Capability.cursor_address) == null) ? false : true;
        if (this.supported) {
            AttributedStringBuilder bb = new AttributedStringBuilder();
            for (int i = 0; i < 200; i++) {
                bb.append((char) 9472);
            }
            this.borderString = bb.toAttributedString();
            resize();
        }
    }

    public void setBorder(boolean border) {
        this.border = border ? 1 : 0;
    }

    public void resize() {
        Size size = this.terminal.getSize();
        this.rows = size.getRows();
        this.columns = size.getColumns();
        this.force = true;
    }

    public void reset() {
        this.force = true;
    }

    public void hardReset() {
        if (!this.suspended) {
            List<AttributedString> lines = new ArrayList<>(this.oldLines);
            int b = this.border;
            update(null);
            this.border = b;
            update(lines);
        }
    }

    public void redraw() {
        if (!this.suspended) {
            update(this.oldLines);
        }
    }

    public void clear() {
        privateClear(this.oldLines.size());
    }

    private void clearAll() {
        int b = this.border;
        this.border = 0;
        privateClear(this.oldLines.size() + b);
    }

    private void privateClear(int statusSize) {
        List<AttributedString> as = new ArrayList<>();
        for (int i = 0; i < statusSize; i++) {
            as.add(new AttributedString(""));
        }
        if (!as.isEmpty()) {
            update(as);
        }
    }

    public void update(List<AttributedString> lines) {
        if (this.supported) {
            if (lines == null) {
                lines = Collections.emptyList();
            }
            if (this.suspended) {
                this.linesToRestore = new ArrayList(lines);
                return;
            }
            if (lines.isEmpty()) {
                clearAll();
            }
            if (!this.oldLines.equals(lines) || this.force) {
                int statusSize = lines.size() + (lines.size() == 0 ? 0 : this.border);
                int nb = (statusSize - this.oldLines.size()) - (this.oldLines.size() == 0 ? 0 : this.border);
                if (nb > 0) {
                    for (int i = 0; i < nb; i++) {
                        this.terminal.puts(InfoCmp.Capability.cursor_down, new Object[0]);
                    }
                    for (int i2 = 0; i2 < nb; i2++) {
                        this.terminal.puts(InfoCmp.Capability.cursor_up, new Object[0]);
                    }
                }
                this.terminal.puts(InfoCmp.Capability.save_cursor, new Object[0]);
                this.terminal.puts(InfoCmp.Capability.cursor_address, Integer.valueOf(this.rows - statusSize), 0);
                if (!this.terminal.puts(InfoCmp.Capability.clr_eos, new Object[0])) {
                    for (int i3 = this.rows - statusSize; i3 < this.rows; i3++) {
                        this.terminal.puts(InfoCmp.Capability.cursor_address, Integer.valueOf(i3), 0);
                        this.terminal.puts(InfoCmp.Capability.clr_eol, new Object[0]);
                    }
                }
                if (this.border == 1 && lines.size() > 0) {
                    this.terminal.puts(InfoCmp.Capability.cursor_address, Integer.valueOf(this.rows - statusSize), 0);
                    this.borderString.columnSubSequence(0, this.columns).print(this.terminal);
                }
                for (int i4 = 0; i4 < lines.size(); i4++) {
                    this.terminal.puts(InfoCmp.Capability.cursor_address, Integer.valueOf((this.rows - lines.size()) + i4), 0);
                    if (lines.get(i4).length() > this.columns) {
                        AttributedStringBuilder asb = new AttributedStringBuilder();
                        asb.append(lines.get(i4).substring(0, this.columns - 3)).append("...", new AttributedStyle(AttributedStyle.INVERSE));
                        asb.toAttributedString().columnSubSequence(0, this.columns).print(this.terminal);
                    } else {
                        lines.get(i4).columnSubSequence(0, this.columns).print(this.terminal);
                    }
                }
                this.terminal.puts(InfoCmp.Capability.change_scroll_region, 0, Integer.valueOf((this.rows - 1) - statusSize));
                this.terminal.puts(InfoCmp.Capability.restore_cursor, new Object[0]);
                this.terminal.flush();
                this.oldLines = new ArrayList(lines);
                this.force = false;
            }
        }
    }

    public void suspend() {
        if (!this.suspended) {
            this.linesToRestore = new ArrayList(this.oldLines);
            int b = this.border;
            update(null);
            this.border = b;
            this.suspended = true;
        }
    }

    public void restore() {
        if (this.suspended) {
            this.suspended = false;
            update(this.linesToRestore);
            this.linesToRestore = Collections.emptyList();
        }
    }

    public int size() {
        return this.oldLines.size() + this.border;
    }
}
