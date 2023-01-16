package org.jline.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jline.terminal.Terminal;
import org.jline.utils.Colors;
import org.jline.utils.InfoCmp;

/* WARNING: Classes with same name are omitted:
  
 */
/* loaded from: grasscutter.jar:org/jline/utils/ColorPalette.class */
public class ColorPalette {
    public static final String XTERM_INITC = "\\E]4;%p1%d;rgb\\:%p2%{255}%*%{1000}%/%2.2X/%p3%{255}%*%{1000}%/%2.2X/%p4%{255}%*%{1000}%/%2.2X\\E\\\\";
    public static final ColorPalette DEFAULT = new ColorPalette();
    private final Terminal terminal;
    private String distanceName;
    private Colors.Distance distance;
    private boolean osc4;
    private int[] palette;

    public ColorPalette() {
        this.terminal = null;
        this.distanceName = null;
        this.palette = Colors.DEFAULT_COLORS_256;
    }

    public ColorPalette(Terminal terminal) throws IOException {
        this(terminal, null);
    }

    public ColorPalette(Terminal terminal, String distance) throws IOException {
        this.terminal = terminal;
        this.distanceName = distance;
        loadPalette(false);
    }

    public String getDistanceName() {
        return this.distanceName;
    }

    public void setDistance(String name) {
        this.distanceName = name;
    }

    public boolean canChange() {
        return this.terminal != null && this.terminal.getBooleanCapability(InfoCmp.Capability.can_change);
    }

    public boolean loadPalette() throws IOException {
        if (!this.osc4) {
            loadPalette(true);
        }
        return this.osc4;
    }

    protected void loadPalette(boolean doLoad) throws IOException {
        if (this.terminal != null) {
            int[] pal = doLoad ? doLoad(this.terminal) : null;
            if (pal != null) {
                this.palette = pal;
                this.osc4 = true;
                return;
            }
            Integer cols = this.terminal.getNumericCapability(InfoCmp.Capability.max_colors);
            if (cols == null) {
                this.palette = Arrays.copyOf(Colors.DEFAULT_COLORS_256, 256);
            } else if (cols.intValue() == Colors.DEFAULT_COLORS_88.length) {
                this.palette = Colors.DEFAULT_COLORS_88;
            } else {
                this.palette = Arrays.copyOf(Colors.DEFAULT_COLORS_256, Math.min(cols.intValue(), 256));
            }
            this.osc4 = false;
            return;
        }
        this.palette = Colors.DEFAULT_COLORS_256;
        this.osc4 = false;
    }

    public int getLength() {
        return this.palette.length;
    }

    public int getColor(int index) {
        return this.palette[index];
    }

    public void setColor(int index, int color) {
        this.palette[index] = color;
        if (canChange()) {
            String initc = this.terminal.getStringCapability(InfoCmp.Capability.initialize_color);
            if (initc != null || this.osc4) {
                int r = ((((color >> 16) & 255) * 1000) / 255) + 1;
                int g = ((((color >> 8) & 255) * 1000) / 255) + 1;
                int b = (((color & 255) * 1000) / 255) + 1;
                if (initc == null) {
                    initc = "\\E]4;%p1%d;rgb\\:%p2%{255}%*%{1000}%/%2.2X/%p3%{255}%*%{1000}%/%2.2X/%p4%{255}%*%{1000}%/%2.2X\\E\\\\";
                }
                Curses.tputs(this.terminal.writer(), initc, Integer.valueOf(index), Integer.valueOf(r), Integer.valueOf(g), Integer.valueOf(b));
                this.terminal.writer().flush();
            }
        }
    }

    public boolean isReal() {
        return this.osc4;
    }

    public int round(int r, int g, int b) {
        return Colors.roundColor((r << 16) + (g << 8) + b, this.palette, this.palette.length, getDist());
    }

    public int round(int col) {
        if (col >= this.palette.length) {
            col = Colors.roundColor(DEFAULT.getColor(col), this.palette, this.palette.length, getDist());
        }
        return col;
    }

    protected Colors.Distance getDist() {
        if (this.distance == null) {
            this.distance = Colors.getDistance(this.distanceName);
        }
        return this.distance;
    }

    private static int[] doLoad(Terminal terminal) throws IOException {
        int c;
        PrintWriter writer = terminal.writer();
        NonBlockingReader reader = terminal.reader();
        int[] palette = new int[256];
        for (int i = 0; i < 16; i++) {
            StringBuilder req = new StringBuilder(1024);
            req.append("\u001b]4");
            for (int j = 0; j < 16; j++) {
                req.append(';').append((i * 16) + j).append(";?");
            }
            req.append("\u001b\\");
            writer.write(req.toString());
            writer.flush();
            boolean black = true;
            for (int j2 = 0; j2 < 16 && reader.peek(50) >= 0; j2++) {
                if (!(reader.read(10) == 27 && reader.read(10) == 93 && reader.read(10) == 52 && reader.read(10) == 59)) {
                    return null;
                }
                int idx = 0;
                while (true) {
                    c = reader.read(10);
                    if (c < 48 || c > 57) {
                        break;
                    }
                    idx = (idx * 10) + (c - 48);
                }
                if (!(c == 59 && idx <= 255 && reader.read(10) == 114 && reader.read(10) == 103 && reader.read(10) == 98 && reader.read(10) == 58)) {
                    return null;
                }
                StringBuilder sb = new StringBuilder(16);
                List<String> rgb = new ArrayList<>();
                while (true) {
                    int c2 = reader.read(10);
                    if (c2 == 7) {
                        rgb.add(sb.toString());
                        break;
                    } else if (c2 == 27) {
                        if (reader.read(10) != 92) {
                            return null;
                        }
                        rgb.add(sb.toString());
                    } else if ((c2 >= 48 && c2 <= 57) || ((c2 >= 65 && c2 <= 90) || (c2 >= 97 && c2 <= 122))) {
                        sb.append((char) c2);
                    } else if (c2 == 47) {
                        rgb.add(sb.toString());
                        sb.setLength(0);
                    }
                }
                if (rgb.size() != 3) {
                    return null;
                }
                palette[idx] = (int) ((Math.round((((double) Integer.parseInt(rgb.get(0), 16)) / (((double) (1 << (4 * rgb.get(0).length()))) - 1.0d)) * 255.0d) << 16) + (Math.round((((double) Integer.parseInt(rgb.get(1), 16)) / (((double) (1 << (4 * rgb.get(1).length()))) - 1.0d)) * 255.0d) << 8) + Math.round((((double) Integer.parseInt(rgb.get(2), 16)) / (((double) (1 << (4 * rgb.get(2).length()))) - 1.0d)) * 255.0d));
                black &= palette[idx] == 0;
            }
            if (black) {
                break;
            }
        }
        int max = 256;
        while (max > 0) {
            max--;
            if (palette[max] != 0) {
                break;
            }
        }
        return Arrays.copyOfRange(palette, 0, max + 1);
    }
}
