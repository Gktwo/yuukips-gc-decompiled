package org.jline.builtins;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.text.Typography;
import org.jline.utils.Colors;
import org.jline.utils.WCWidth;
import p001ch.qos.logback.core.pattern.color.ANSIConstants;

/* loaded from: grasscutter.jar:org/jline/builtins/ScreenTerminal.class */
public class ScreenTerminal {
    private int width;
    private int height;
    private long attr;
    private boolean eol;

    /* renamed from: cx */
    private int f3167cx;

    /* renamed from: cy */
    private int f3168cy;
    private long[][] screen;
    private long[][] screen2;
    private State vt100_parse_state;
    private int vt100_parse_len;
    private int vt100_lastchar;
    private int vt100_parse_func;
    private String vt100_parse_param;
    private boolean vt100_mode_autowrap;
    private boolean vt100_mode_insert;
    private boolean vt100_charset_is_single_shift;
    private boolean vt100_charset_is_graphical;
    private boolean vt100_mode_lfnewline;
    private boolean vt100_mode_origin;
    private boolean vt100_mode_inverse;
    private boolean vt100_mode_cursorkey;
    private boolean vt100_mode_cursor;
    private boolean vt100_mode_alt_screen;
    private boolean vt100_mode_backspace;
    private boolean vt100_mode_column_switch;
    private boolean vt100_keyfilter_escape;
    private int[] vt100_charset_graph;
    private int vt100_charset_g_sel;
    private int[] vt100_charset_g;
    private Map<String, Object> vt100_saved;
    private Map<String, Object> vt100_saved2;
    private int vt100_alternate_saved_cx;
    private int vt100_alternate_saved_cy;
    private int vt100_saved_cx;
    private int vt100_saved_cy;
    private String vt100_out;
    private int scroll_area_y0;
    private int scroll_area_y1;
    private List<Integer> tab_stops;
    private final List<long[]> history;
    private AtomicBoolean dirty;

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/jline/builtins/ScreenTerminal$State.class */
    public enum State {
        None,
        Esc,
        Str,
        Csi
    }

    public ScreenTerminal() {
        this(80, 24);
    }

    public ScreenTerminal(int width, int height) {
        this.vt100_parse_state = State.None;
        this.vt100_charset_graph = new int[]{9674, Typography.ellipsis, Typography.bullet, 63, 182, 63, 176, 177, 63, 63, 43, 43, 43, 43, 43, 175, Typography.mdash, Typography.mdash, Typography.mdash, 95, 43, 43, 43, 43, 124, 8804, Typography.greaterOrEqual, 182, 8800, 163, 183, 127};
        this.vt100_charset_g = new int[]{0, 0};
        this.history = new ArrayList();
        this.dirty = new AtomicBoolean(true);
        this.width = width;
        this.height = height;
        reset_hard();
    }

    private void reset_hard() {
        this.attr = 0;
        this.vt100_keyfilter_escape = false;
        this.vt100_lastchar = 0;
        this.vt100_parse_len = 0;
        this.vt100_parse_state = State.None;
        this.vt100_parse_func = 0;
        this.vt100_parse_param = "";
        this.vt100_out = "";
        reset_screen();
        reset_soft();
    }

    private void reset_soft() {
        this.attr = 0;
        this.scroll_area_y0 = 0;
        this.scroll_area_y1 = this.height;
        this.vt100_charset_is_single_shift = false;
        this.vt100_charset_is_graphical = false;
        this.vt100_charset_g_sel = 0;
        this.vt100_charset_g = new int[]{0, 0};
        this.vt100_mode_insert = false;
        this.vt100_mode_lfnewline = false;
        this.vt100_mode_cursorkey = false;
        this.vt100_mode_column_switch = false;
        this.vt100_mode_inverse = false;
        this.vt100_mode_origin = false;
        this.vt100_mode_autowrap = true;
        this.vt100_mode_cursor = true;
        this.vt100_mode_alt_screen = false;
        this.vt100_mode_backspace = false;
        esc_DECSC();
        this.vt100_saved2 = this.vt100_saved;
        esc_DECSC();
    }

    private void reset_screen() {
        this.screen = (long[][]) Array.newInstance(Long.TYPE, this.height, this.width);
        this.screen2 = (long[][]) Array.newInstance(Long.TYPE, this.height, this.width);
        for (int i = 0; i < this.height; i++) {
            Arrays.fill(this.screen[i], this.attr | 32);
            Arrays.fill(this.screen2[i], this.attr | 32);
        }
        this.scroll_area_y0 = 0;
        this.scroll_area_y1 = this.height;
        this.f3167cx = 0;
        this.f3168cy = 0;
        this.tab_stops = new ArrayList();
        for (int i2 = 7; i2 < this.width; i2 += 8) {
            this.tab_stops.add(Integer.valueOf(i2));
        }
    }

    private int utf8_charwidth(int c) {
        return WCWidth.wcwidth(c);
    }

    private long[] peek(int y0, int x0, int y1, int x1) {
        int from = (this.width * y0) + x0;
        int to = (this.width * (y1 - 1)) + x1;
        int newLength = to - from;
        if (newLength < 0) {
            throw new IllegalArgumentException(from + " > " + to);
        }
        long[] copy = new long[newLength];
        int cur = from;
        while (cur < to) {
            int y = cur / this.width;
            int x = cur % this.width;
            int nb = Math.min(this.width - x, to - cur);
            System.arraycopy(this.screen[y], x, copy, cur - from, nb);
            cur += nb;
        }
        return copy;
    }

    private void poke(int y, int x, long[] s) {
        int cur = 0;
        int max = s.length;
        while (cur < max) {
            int nb = Math.min(this.width - x, max - cur);
            y++;
            System.arraycopy(s, 0, this.screen[y], x, nb);
            x = 0;
            cur += nb;
        }
        setDirty();
    }

    private void fill(int y0, int x0, int y1, int x1, long c) {
        if (y0 == y1 - 1) {
            if (x0 < x1 - 1) {
                Arrays.fill(this.screen[y0], x0, x1, c);
                setDirty();
            }
        } else if (y0 < y1 - 1) {
            Arrays.fill(this.screen[y0], x0, this.width, c);
            for (int i = y0; i < y1 - 1; i++) {
                Arrays.fill(this.screen[i], c);
            }
            Arrays.fill(this.screen[y1 - 1], 0, x1, c);
            setDirty();
        }
    }

    private void clear(int y0, int x0, int y1, int x1) {
        fill(y0, x0, y1, x1, this.attr | 32);
    }

    private void scroll_area_up(int y0, int y1) {
        scroll_area_up(y0, y1, 1);
    }

    private void scroll_area_up(int y0, int y1, int n) {
        int n2 = Math.min(y1 - y0, n);
        if (y0 == 0 && y1 == this.height) {
            for (int i = 0; i < n2; i++) {
                this.history.add(this.screen[i]);
            }
            System.arraycopy(this.screen, n2, this.screen, 0, this.height - n2);
            for (int i2 = 1; i2 <= n2; i2++) {
                this.screen[y1 - i2] = new long[this.width];
                Arrays.fill(this.screen[y1 - 1], this.attr | 32);
            }
            return;
        }
        poke(y0, 0, peek(y0 + n2, 0, y1, this.width));
        clear(y1 - n2, 0, y1, this.width);
    }

    private void scroll_area_down(int y0, int y1) {
        scroll_area_down(y0, y1, 1);
    }

    private void scroll_area_down(int y0, int y1, int n) {
        int n2 = Math.min(y1 - y0, n);
        poke(y0 + n2, 0, peek(y0, 0, y1 - n2, this.width));
        clear(y0, 0, y0 + n2, this.width);
    }

    private void scroll_area_set(int y0, int y1) {
        int y02 = Math.max(0, Math.min(this.height - 1, y0));
        int y12 = Math.max(1, Math.min(this.height, y1));
        if (y12 > y02) {
            this.scroll_area_y0 = y02;
            this.scroll_area_y1 = y12;
        }
    }

    private void scroll_line_right(int y, int x) {
        scroll_line_right(y, x, 1);
    }

    private void scroll_line_right(int y, int x, int n) {
        if (x < this.width) {
            int n2 = Math.min(this.width - this.f3167cx, n);
            poke(y, x + n2, peek(y, x, y + 1, this.width - n2));
            clear(y, x, y + 1, x + n2);
        }
    }

    private void scroll_line_left(int y, int x) {
        scroll_line_left(y, x, 1);
    }

    private void scroll_line_left(int y, int x, int n) {
        if (x < this.width) {
            int n2 = Math.min(this.width - this.f3167cx, n);
            poke(y, x, peek(y, x + n2, y + 1, this.width));
            clear(y, this.width - n2, y + 1, this.width);
        }
    }

    private int[] cursor_line_width(int next_char) {
        int wx = utf8_charwidth(next_char);
        int lx = 0;
        for (int x = 0; x < Math.min(this.f3167cx, this.width); x++) {
            wx += utf8_charwidth((int) (peek(this.f3168cy, x, this.f3168cy + 1, x + 1)[0] & 4294967295L));
            lx++;
        }
        return new int[]{wx, lx};
    }

    private void cursor_up() {
        cursor_up(1);
    }

    private void cursor_up(int n) {
        this.f3168cy = Math.max(this.scroll_area_y0, this.f3168cy - n);
        setDirty();
    }

    private void cursor_down() {
        cursor_down(1);
    }

    private void cursor_down(int n) {
        this.f3168cy = Math.min(this.scroll_area_y1 - 1, this.f3168cy + n);
        setDirty();
    }

    private void cursor_left() {
        cursor_left(1);
    }

    private void cursor_left(int n) {
        this.eol = false;
        this.f3167cx = Math.max(0, this.f3167cx - n);
        setDirty();
    }

    private void cursor_right() {
        cursor_right(1);
    }

    private void cursor_right(int n) {
        this.eol = this.f3167cx + n >= this.width;
        this.f3167cx = Math.min(this.width - 1, this.f3167cx + n);
        setDirty();
    }

    private void cursor_set_x(int x) {
        this.eol = false;
        this.f3167cx = Math.max(0, x);
        setDirty();
    }

    private void cursor_set_y(int y) {
        this.f3168cy = Math.max(0, Math.min(this.height - 1, y));
        setDirty();
    }

    private void cursor_set(int y, int x) {
        cursor_set_x(x);
        cursor_set_y(y);
    }

    private void ctrl_BS() {
        cursor_set(Math.max(this.scroll_area_y0, this.f3168cy + ((this.f3167cx - 1) / this.width)), (this.f3167cx - 1) % this.width);
    }

    private void ctrl_HT() {
        ctrl_HT(1);
    }

    private void ctrl_HT(int n) {
        if (n > 0 && this.f3167cx >= this.width) {
            return;
        }
        if (n > 0 || this.f3167cx != 0) {
            int ts = -1;
            for (int i = 0; i < this.tab_stops.size(); i++) {
                if (this.f3167cx >= this.tab_stops.get(i).intValue()) {
                    ts = i;
                }
            }
            int ts2 = ts + n;
            if (ts2 >= this.tab_stops.size() || ts2 < 0) {
                cursor_set_x(this.width - 1);
            } else {
                cursor_set_x(this.tab_stops.get(ts2).intValue());
            }
        }
    }

    private void ctrl_LF() {
        if (this.vt100_mode_lfnewline) {
            ctrl_CR();
        }
        if (this.f3168cy == this.scroll_area_y1 - 1) {
            scroll_area_up(this.scroll_area_y0, this.scroll_area_y1);
        } else {
            cursor_down();
        }
    }

    private void ctrl_CR() {
        cursor_set_x(0);
    }

    private boolean dumb_write(int c) {
        if (c >= 32) {
            return false;
        }
        if (c == 8) {
            ctrl_BS();
            return true;
        } else if (c == 9) {
            ctrl_HT();
            return true;
        } else if (c >= 10 && c <= 12) {
            ctrl_LF();
            return true;
        } else if (c != 13) {
            return true;
        } else {
            ctrl_CR();
            return true;
        }
    }

    private void dumb_echo(int c) {
        if (this.eol) {
            if (this.vt100_mode_autowrap) {
                ctrl_CR();
                ctrl_LF();
            } else {
                this.f3167cx = cursor_line_width(c)[1] - 1;
            }
        }
        if (this.vt100_mode_insert) {
            scroll_line_right(this.f3168cy, this.f3167cx);
        }
        if (this.vt100_charset_is_single_shift) {
            this.vt100_charset_is_single_shift = false;
        } else if (this.vt100_charset_is_graphical && (c & 65504) == 96) {
            c = this.vt100_charset_graph[c - 96];
        }
        poke(this.f3168cy, this.f3167cx, new long[]{this.attr | ((long) c)});
        cursor_right();
    }

    private void vt100_charset_update() {
        this.vt100_charset_is_graphical = this.vt100_charset_g[this.vt100_charset_g_sel] == 2;
    }

    private void vt100_charset_set(int g) {
        this.vt100_charset_g_sel = g;
        vt100_charset_update();
    }

    private void vt100_charset_select(int g, int charset) {
        this.vt100_charset_g[g] = charset;
        vt100_charset_update();
    }

    private void vt100_setmode(String p, boolean state) {
        String[] ps = vt100_parse_params(p, new String[0]);
        for (String m : ps) {
            char c = 65535;
            switch (m.hashCode()) {
                case 52:
                    if (m.equals("4")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1598:
                    if (m.equals("20")) {
                        c = 1;
                        break;
                    }
                    break;
                case 2002:
                    if (m.equals("?1")) {
                        c = 2;
                        break;
                    }
                    break;
                case 2004:
                    if (m.equals("?3")) {
                        c = 3;
                        break;
                    }
                    break;
                case 2006:
                    if (m.equals("?5")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2007:
                    if (m.equals("?6")) {
                        c = 5;
                        break;
                    }
                    break;
                case RET_UNFINISH_ORDER_VALUE:
                    if (m.equals("?7")) {
                        c = 6;
                        break;
                    }
                    break;
                case 62146:
                    if (m.equals("?25")) {
                        c = 7;
                        break;
                    }
                    break;
                case 62203:
                    if (m.equals("?40")) {
                        c = '\b';
                        break;
                    }
                    break;
                case 62272:
                    if (m.equals("?67")) {
                        c = '\n';
                        break;
                    }
                    break;
                case 59689379:
                    if (m.equals("?1049")) {
                        c = '\t';
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.vt100_mode_insert = state;
                    break;
                case 1:
                    this.vt100_mode_lfnewline = state;
                    break;
                case 2:
                    this.vt100_mode_cursorkey = state;
                    break;
                case 3:
                    if (!this.vt100_mode_column_switch) {
                        break;
                    } else {
                        if (state) {
                            this.width = 132;
                        } else {
                            this.width = 80;
                        }
                        reset_screen();
                        break;
                    }
                case 4:
                    this.vt100_mode_inverse = state;
                    break;
                case 5:
                    this.vt100_mode_origin = state;
                    if (state) {
                        cursor_set(this.scroll_area_y0, 0);
                        break;
                    } else {
                        cursor_set(0, 0);
                        break;
                    }
                case 6:
                    this.vt100_mode_autowrap = state;
                    break;
                case 7:
                    this.vt100_mode_cursor = state;
                    break;
                case '\b':
                    this.vt100_mode_column_switch = state;
                    break;
                case '\t':
                    if ((state && !this.vt100_mode_alt_screen) || (!state && this.vt100_mode_alt_screen)) {
                        long[][] s = this.screen;
                        this.screen = this.screen2;
                        this.screen2 = s;
                        Map<String, Object> map = this.vt100_saved;
                        this.vt100_saved = this.vt100_saved2;
                        this.vt100_saved2 = map;
                        int c2 = this.vt100_alternate_saved_cx;
                        this.vt100_alternate_saved_cx = this.f3167cx;
                        this.f3167cx = Math.min(c2, this.width - 1);
                        int c3 = this.vt100_alternate_saved_cy;
                        this.vt100_alternate_saved_cy = this.f3168cy;
                        this.f3168cy = Math.min(c3, this.height - 1);
                    }
                    this.vt100_mode_alt_screen = state;
                    break;
                case '\n':
                    this.vt100_mode_backspace = state;
                    break;
            }
        }
    }

    private void ctrl_SO() {
        vt100_charset_set(1);
    }

    private void ctrl_SI() {
        vt100_charset_set(0);
    }

    private void esc_CSI() {
        vt100_parse_reset(State.Csi);
    }

    private void esc_DECALN() {
        fill(0, 0, this.height, this.width, 16711749);
    }

    private void esc_G0_0() {
        vt100_charset_select(0, 0);
    }

    private void esc_G0_1() {
        vt100_charset_select(0, 1);
    }

    private void esc_G0_2() {
        vt100_charset_select(0, 2);
    }

    private void esc_G0_3() {
        vt100_charset_select(0, 3);
    }

    private void esc_G0_4() {
        vt100_charset_select(0, 4);
    }

    private void esc_G1_0() {
        vt100_charset_select(1, 0);
    }

    private void esc_G1_1() {
        vt100_charset_select(1, 1);
    }

    private void esc_G1_2() {
        vt100_charset_select(1, 2);
    }

    private void esc_G1_3() {
        vt100_charset_select(1, 3);
    }

    private void esc_G1_4() {
        vt100_charset_select(1, 4);
    }

    private void esc_DECSC() {
        this.vt100_saved = new HashMap();
        this.vt100_saved.put("cx", Integer.valueOf(this.f3167cx));
        this.vt100_saved.put("cy", Integer.valueOf(this.f3168cy));
        this.vt100_saved.put("attr", Long.valueOf(this.attr));
        this.vt100_saved.put("vt100_charset_g_sel", Integer.valueOf(this.vt100_charset_g_sel));
        this.vt100_saved.put("vt100_charset_g", this.vt100_charset_g);
        this.vt100_saved.put("vt100_mode_autowrap", Boolean.valueOf(this.vt100_mode_autowrap));
        this.vt100_saved.put("vt100_mode_origin", Boolean.valueOf(this.vt100_mode_origin));
    }

    private void esc_DECRC() {
        this.f3167cx = ((Integer) this.vt100_saved.get("cx")).intValue();
        this.f3168cy = ((Integer) this.vt100_saved.get("cy")).intValue();
        this.attr = ((Long) this.vt100_saved.get("attr")).longValue();
        this.vt100_charset_g_sel = ((Integer) this.vt100_saved.get("vt100_charset_g_sel")).intValue();
        this.vt100_charset_g = (int[]) this.vt100_saved.get("vt100_charset_g");
        vt100_charset_update();
        this.vt100_mode_autowrap = ((Boolean) this.vt100_saved.get("vt100_mode_autowrap")).booleanValue();
        this.vt100_mode_origin = ((Boolean) this.vt100_saved.get("vt100_mode_origin")).booleanValue();
    }

    private void esc_IND() {
        ctrl_LF();
    }

    private void esc_NEL() {
        ctrl_CR();
        ctrl_LF();
    }

    private void esc_HTS() {
        csi_CTC("0");
    }

    private void esc_RI() {
        if (this.f3168cy == this.scroll_area_y0) {
            scroll_area_down(this.scroll_area_y0, this.scroll_area_y1);
        } else {
            cursor_up();
        }
    }

    private void esc_SS2() {
        this.vt100_charset_is_single_shift = true;
    }

    private void esc_SS3() {
        this.vt100_charset_is_single_shift = true;
    }

    private void esc_DCS() {
        vt100_parse_reset(State.Str);
    }

    private void esc_SOS() {
        vt100_parse_reset(State.Str);
    }

    private void esc_DECID() {
        csi_DA("0");
    }

    private void esc_ST() {
    }

    private void esc_OSC() {
        vt100_parse_reset(State.Str);
    }

    private void esc_PM() {
        vt100_parse_reset(State.Str);
    }

    private void esc_APC() {
        vt100_parse_reset(State.Str);
    }

    private void esc_RIS() {
        reset_hard();
    }

    private void csi_ICH(String p) {
        scroll_line_right(this.f3168cy, this.f3167cx, vt100_parse_params(p, new int[]{1})[0]);
    }

    private void csi_CUU(String p) {
        cursor_up(Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_CUD(String p) {
        cursor_down(Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_CUF(String p) {
        cursor_right(Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_CUB(String p) {
        cursor_left(Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_CNL(String p) {
        csi_CUD(p);
        ctrl_CR();
    }

    private void csi_CPL(String p) {
        csi_CUU(p);
        ctrl_CR();
    }

    private void csi_CHA(String p) {
        cursor_set_x(vt100_parse_params(p, new int[]{1})[0] - 1);
    }

    private void csi_CUP(String p) {
        int[] ps = vt100_parse_params(p, new int[]{1, 1});
        if (this.vt100_mode_origin) {
            cursor_set((this.scroll_area_y0 + ps[0]) - 1, ps[1] - 1);
        } else {
            cursor_set(ps[0] - 1, ps[1] - 1);
        }
    }

    private void csi_CHT(String p) {
        ctrl_HT(Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_ED(String p) {
        String[] ps = vt100_parse_params(p, new String[]{"0"});
        if ("0".equals(ps[0])) {
            clear(this.f3168cy, this.f3167cx, this.height, this.width);
        } else if ("1".equals(ps[0])) {
            clear(0, 0, this.f3168cy + 1, this.f3167cx + 1);
        } else if ("2".equals(ps[0])) {
            clear(0, 0, this.height, this.width);
        }
    }

    private void csi_EL(String p) {
        String[] ps = vt100_parse_params(p, new String[]{"0"});
        if ("0".equals(ps[0])) {
            clear(this.f3168cy, this.f3167cx, this.f3168cy + 1, this.width);
        } else if ("1".equals(ps[0])) {
            clear(this.f3168cy, 0, this.f3168cy + 1, this.f3167cx + 1);
        } else if ("2".equals(ps[0])) {
            clear(this.f3168cy, 0, this.f3168cy + 1, this.width);
        }
    }

    private void csi_IL(String p) {
        int[] ps = vt100_parse_params(p, new int[]{1});
        if (this.f3168cy >= this.scroll_area_y0 && this.f3168cy < this.scroll_area_y1) {
            scroll_area_down(this.f3168cy, this.scroll_area_y1, Math.max(1, ps[0]));
        }
    }

    private void csi_DL(String p) {
        int[] ps = vt100_parse_params(p, new int[]{1});
        if (this.f3168cy >= this.scroll_area_y0 && this.f3168cy < this.scroll_area_y1) {
            scroll_area_up(this.f3168cy, this.scroll_area_y1, Math.max(1, ps[0]));
        }
    }

    private void csi_DCH(String p) {
        scroll_line_left(this.f3168cy, this.f3167cx, Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_SU(String p) {
        scroll_area_up(this.scroll_area_y0, this.scroll_area_y1, Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_SD(String p) {
        scroll_area_down(this.scroll_area_y0, this.scroll_area_y1, Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_CTC(String p) {
        String[] ps = vt100_parse_params(p, new String[]{"0"});
        for (String m : ps) {
            if ("0".equals(m)) {
                if (this.tab_stops.indexOf(Integer.valueOf(this.f3167cx)) < 0) {
                    this.tab_stops.add(Integer.valueOf(this.f3167cx));
                    Collections.sort(this.tab_stops);
                }
            } else if ("2".equals(m)) {
                this.tab_stops.remove(Integer.valueOf(this.f3167cx));
            } else if ("5".equals(m)) {
                this.tab_stops = new ArrayList();
            }
        }
    }

    private void csi_ECH(String p) {
        clear(this.f3168cy, this.f3167cx, this.f3168cy + 1, this.f3167cx + Math.min(this.width - this.f3167cx, Math.max(1, vt100_parse_params(p, new int[]{1})[0])));
    }

    private void csi_CBT(String p) {
        ctrl_HT(1 - Math.max(1, vt100_parse_params(p, new int[]{1})[0]));
    }

    private void csi_HPA(String p) {
        cursor_set_x(vt100_parse_params(p, new int[]{1})[0] - 1);
    }

    private void csi_HPR(String p) {
        csi_CUF(p);
    }

    private void csi_REP(String p) {
        int[] ps = vt100_parse_params(p, new int[]{1});
        if (this.vt100_lastchar >= 32) {
            int n = Math.min(2000, Math.max(1, ps[0]));
            while (true) {
                n--;
                if (n > 0) {
                    dumb_echo(this.vt100_lastchar);
                } else {
                    this.vt100_lastchar = 0;
                    return;
                }
            }
        }
    }

    private void csi_DA(String p) {
        String[] ps = vt100_parse_params(p, new String[]{"0"});
        if ("0".equals(ps[0])) {
            this.vt100_out = "\u001b[?1;2c";
        } else if (">0".equals(ps[0]) || ">".equals(ps[0])) {
            this.vt100_out = "\u001b[>0;184;0c";
        }
    }

    private void csi_VPA(String p) {
        cursor_set_y(vt100_parse_params(p, new int[]{1})[0] - 1);
    }

    private void csi_VPR(String p) {
        csi_CUD(p);
    }

    private void csi_HVP(String p) {
        csi_CUP(p);
    }

    private void csi_TBC(String p) {
        String[] ps = vt100_parse_params(p, new String[]{"0"});
        if ("0".equals(ps[0])) {
            csi_CTC("2");
        } else if ("3".equals(ps[0])) {
            csi_CTC("5");
        }
    }

    private void csi_SM(String p) {
        vt100_setmode(p, true);
    }

    private void csi_RM(String p) {
        vt100_setmode(p, false);
    }

    private void csi_SGR(String p) {
        int[] ps = vt100_parse_params(p, new int[]{0});
        int i = 0;
        while (i < ps.length) {
            int m = ps[i];
            if (m == 0) {
                this.attr = 0;
            } else if (m == 1) {
                this.attr |= 576460752303423488L;
            } else if (m == 4) {
                this.attr |= 72057594037927936L;
            } else if (m == 7) {
                this.attr |= 144115188075855872L;
            } else if (m == 8) {
                this.attr |= 288230376151711744L;
            } else if (m == 21) {
                this.attr &= -576460756598390784L;
            } else if (m == 24) {
                this.attr &= -72057598332895232L;
            } else if (m == 27) {
                this.attr &= -144115192370823168L;
            } else if (m == 28) {
                this.attr &= -288230380446679040L;
            } else if (m >= 30 && m <= 37) {
                this.attr = (this.attr & -1224961510753697792L) | 1152921504606846976L | (col24(m - 30) << 44);
            } else if (m == 38) {
                i++;
                if ((i < ps.length ? ps[i] : 0) == 5) {
                    i++;
                    this.attr = (this.attr & -1224961510753697792L) | 1152921504606846976L | (col24(i < ps.length ? ps[i] : 0) << 44);
                }
            } else if (m == 39) {
                this.attr &= -1224961510753697792L;
            } else if (m >= 40 && m <= 47) {
                this.attr = (this.attr & -2305860601399738368L) | 2305843009213693952L | (col24(m - 40) << 32);
            } else if (m == 48) {
                i++;
                if ((i < ps.length ? ps[i] : 0) == 5) {
                    i++;
                    this.attr = (this.attr & -2305860601399738368L) | 2305843009213693952L | (col24(i < ps.length ? ps[i] : 0) << 32);
                }
            } else if (m == 49) {
                this.attr &= -2377883015360544768L;
            } else if (m >= 90 && m <= 97) {
                this.attr = (this.attr & -1224961510753697792L) | 1152921504606846976L | (col24((m - 90) + 8) << 44);
            } else if (m >= 100 && m <= 107) {
                this.attr = (this.attr & -2305860601399738368L) | 2305843009213693952L | (col24((m - 100) + 8) << 32);
            }
            i++;
        }
    }

    private long col24(int col) {
        int c = Colors.rgbColor(col);
        return (long) (((((c >> 16) & 255) >> 4) << 8) | ((((c >> 8) & 255) >> 4) << 4) | ((((c >> 0) & 255) >> 4) << 0));
    }

    private void csi_DSR(String p) {
        String[] ps = vt100_parse_params(p, new String[]{"0"});
        if ("5".equals(ps[0])) {
            this.vt100_out = "\u001b[0n";
        } else if ("6".equals(ps[0])) {
            this.vt100_out = ANSIConstants.ESC_START + (this.f3168cy + 1) + ";" + (this.f3167cx + 1) + "R";
        } else if ("7".equals(ps[0])) {
            this.vt100_out = "gogo-term";
        } else if ("8".equals(ps[0])) {
            this.vt100_out = "1.0-SNAPSHOT";
        } else if ("?6".equals(ps[0])) {
            this.vt100_out = ANSIConstants.ESC_START + (this.f3168cy + 1) + ";" + (this.f3167cx + 1) + ";0R";
        } else if ("?15".equals(ps[0])) {
            this.vt100_out = "\u001b[?13n";
        } else if ("?25".equals(ps[0])) {
            this.vt100_out = "\u001b[?20n";
        } else if ("?26".equals(ps[0])) {
            this.vt100_out = "\u001b[?27;1n";
        } else if ("?53".equals(ps[0])) {
            this.vt100_out = "\u001b[?53n";
        }
    }

    private void csi_DECSTBM(String p) {
        int[] ps = vt100_parse_params(p, new int[]{1, this.height});
        scroll_area_set(ps[0] - 1, ps[1]);
        if (this.vt100_mode_origin) {
            cursor_set(this.scroll_area_y0, 0);
        } else {
            cursor_set(0, 0);
        }
    }

    private void csi_SCP(String p) {
        this.vt100_saved_cx = this.f3167cx;
        this.vt100_saved_cy = this.f3168cy;
    }

    private void csi_RCP(String p) {
        this.f3167cx = this.vt100_saved_cx;
        this.f3168cy = this.vt100_saved_cy;
    }

    private void csi_DECREQTPARM(String p) {
        String[] ps = vt100_parse_params(p, new String[0]);
        if ("0".equals(ps[0])) {
            this.vt100_out = "\u001b[2;1;1;112;112;1;0x";
        } else if ("1".equals(ps[0])) {
            this.vt100_out = "\u001b[3;1;1;112;112;1;0x";
        }
    }

    private void csi_DECSTR(String p) {
        reset_soft();
    }

    private String[] vt100_parse_params(String p, String[] defaults) {
        String prefix = "";
        if (p.length() > 0 && p.charAt(0) >= '<' && p.charAt(0) <= '?') {
            prefix = "" + p.charAt(0);
            p = p.substring(1);
        }
        String[] ps = p.split(";");
        int n = Math.max(ps.length, defaults.length);
        String[] values = new String[n];
        for (int i = 0; i < n; i++) {
            String value = null;
            if (i < ps.length && ps[i].length() > 0) {
                value = prefix + ps[i];
            }
            if (value == null && i < defaults.length) {
                value = defaults[i];
            }
            if (value == null) {
                value = "";
            }
            values[i] = value;
        }
        return values;
    }

    private int[] vt100_parse_params(String p, int[] defaults) {
        String prefix = "";
        String p2 = p == null ? "" : p;
        if (p2.length() > 0 && p2.charAt(0) >= '<' && p2.charAt(0) <= '?') {
            prefix = p2.substring(0, 1);
            p2 = p2.substring(1);
        }
        String[] ps = p2.split(";");
        int n = Math.max(ps.length, defaults.length);
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            Integer value = null;
            if (i < ps.length) {
                try {
                    value = Integer.valueOf(Integer.parseInt(prefix + ps[i]));
                } catch (NumberFormatException e) {
                }
            }
            if (value == null && i < defaults.length) {
                value = Integer.valueOf(defaults[i]);
            }
            if (value == null) {
                value = 0;
            }
            values[i] = value.intValue();
        }
        return values;
    }

    private void vt100_parse_reset() {
        vt100_parse_reset(State.None);
    }

    private void vt100_parse_reset(State state) {
        this.vt100_parse_state = state;
        this.vt100_parse_len = 0;
        this.vt100_parse_func = 0;
        this.vt100_parse_param = "";
    }

    private void vt100_parse_process() {
        if (this.vt100_parse_state == State.Esc) {
            switch (this.vt100_parse_func) {
                case 55:
                    esc_DECSC();
                    break;
                case 56:
                    esc_DECRC();
                    break;
                case 68:
                    esc_IND();
                    break;
                case 69:
                    esc_NEL();
                    break;
                case 70:
                    esc_NEL();
                    break;
                case 72:
                    esc_HTS();
                    break;
                case 77:
                    esc_RI();
                    break;
                case 78:
                    esc_SS2();
                    break;
                case 79:
                    esc_SS3();
                    break;
                case 80:
                    esc_DCS();
                    break;
                case 88:
                    esc_SOS();
                    break;
                case 91:
                    esc_CSI();
                    break;
                case 92:
                    esc_ST();
                    break;
                case 93:
                    esc_OSC();
                    break;
                case 94:
                    esc_PM();
                    break;
                case 95:
                    esc_APC();
                    break;
                case 99:
                    esc_RIS();
                    break;
                case 9016:
                    esc_DECALN();
                    break;
                case 10288:
                    esc_G0_2();
                    break;
                case 10289:
                    esc_G0_3();
                    break;
                case 10290:
                    esc_G0_4();
                    break;
                case RET_IRODORI_CHESS_EQUIP_CARD_EXCEED_LIMIT_VALUE:
                    esc_G0_0();
                    break;
                case RET_IRODORI_CHESS_MAP_CARD_NOT_EQUIPED_VALUE:
                    esc_G0_1();
                    break;
                case 10544:
                    esc_G1_2();
                    break;
                case 10545:
                    esc_G1_3();
                    break;
                case 10546:
                    esc_G1_4();
                    break;
                case 10561:
                    esc_G1_0();
                    break;
                case 10562:
                    esc_G1_1();
                    break;
            }
            if (this.vt100_parse_state == State.Esc) {
                vt100_parse_reset();
                return;
            }
            return;
        }
        switch (this.vt100_parse_func) {
            case 64:
                csi_ICH(this.vt100_parse_param);
                break;
            case 65:
                csi_CUU(this.vt100_parse_param);
                break;
            case 66:
                csi_CUD(this.vt100_parse_param);
                break;
            case 67:
                csi_CUF(this.vt100_parse_param);
                break;
            case 68:
                csi_CUB(this.vt100_parse_param);
                break;
            case 69:
                csi_CNL(this.vt100_parse_param);
                break;
            case 70:
                csi_CPL(this.vt100_parse_param);
                break;
            case 71:
                csi_CHA(this.vt100_parse_param);
                break;
            case 72:
                csi_CUP(this.vt100_parse_param);
                break;
            case 73:
                csi_CHT(this.vt100_parse_param);
                break;
            case 74:
                csi_ED(this.vt100_parse_param);
                break;
            case 75:
                csi_EL(this.vt100_parse_param);
                break;
            case 76:
                csi_IL(this.vt100_parse_param);
                break;
            case 77:
                csi_DL(this.vt100_parse_param);
                break;
            case 80:
                csi_DCH(this.vt100_parse_param);
                break;
            case 83:
                csi_SU(this.vt100_parse_param);
                break;
            case 84:
                csi_SD(this.vt100_parse_param);
                break;
            case 87:
                csi_CTC(this.vt100_parse_param);
                break;
            case 88:
                csi_ECH(this.vt100_parse_param);
                break;
            case 90:
                csi_CBT(this.vt100_parse_param);
                break;
            case 96:
                csi_HPA(this.vt100_parse_param);
                break;
            case 97:
                csi_HPR(this.vt100_parse_param);
                break;
            case 98:
                csi_REP(this.vt100_parse_param);
                break;
            case 99:
                csi_DA(this.vt100_parse_param);
                break;
            case 100:
                csi_VPA(this.vt100_parse_param);
                break;
            case 101:
                csi_VPR(this.vt100_parse_param);
                break;
            case 102:
                csi_HVP(this.vt100_parse_param);
                break;
            case 103:
                csi_TBC(this.vt100_parse_param);
                break;
            case 104:
                csi_SM(this.vt100_parse_param);
                break;
            case 108:
                csi_RM(this.vt100_parse_param);
                break;
            case 109:
                csi_SGR(this.vt100_parse_param);
                break;
            case 110:
                csi_DSR(this.vt100_parse_param);
                break;
            case 114:
                csi_DECSTBM(this.vt100_parse_param);
                break;
            case 115:
                csi_SCP(this.vt100_parse_param);
                break;
            case 117:
                csi_RCP(this.vt100_parse_param);
                break;
            case 120:
                csi_DECREQTPARM(this.vt100_parse_param);
                break;
            case PacketOpcodes.EchoShellUpdateNotify:
                csi_DECSTR(this.vt100_parse_param);
                break;
        }
        if (this.vt100_parse_state == State.Csi) {
            vt100_parse_reset();
        }
    }

    private boolean vt100_write(int c) {
        if (c < 32) {
            if (c == 27) {
                vt100_parse_reset(State.Esc);
                return true;
            } else if (c == 14) {
                ctrl_SO();
            } else if (c == 15) {
                ctrl_SI();
            }
        } else if ((c & 65504) == 128) {
            vt100_parse_reset(State.Esc);
            this.vt100_parse_func = (char) (c - 64);
            vt100_parse_process();
            return true;
        }
        if (this.vt100_parse_state != State.None) {
            if (this.vt100_parse_state == State.Str) {
                if (c >= 32) {
                    return true;
                }
                vt100_parse_reset();
            } else if (c >= 32) {
                this.vt100_parse_len++;
                if (this.vt100_parse_len > 32) {
                    vt100_parse_reset();
                } else {
                    int msb = c & PacketOpcodes.SceneKickPlayerRsp;
                    if (msb == 32) {
                        this.vt100_parse_func <<= 8;
                        this.vt100_parse_func += (char) c;
                        return true;
                    } else if (msb == 48 && this.vt100_parse_state == State.Csi) {
                        this.vt100_parse_param += new String(new char[]{(char) c});
                        return true;
                    } else {
                        this.vt100_parse_func <<= 8;
                        this.vt100_parse_func += (char) c;
                        vt100_parse_process();
                        return true;
                    }
                }
            } else if (c == 24 || c == 26) {
                vt100_parse_reset();
                return true;
            }
        }
        this.vt100_lastchar = c;
        return false;
    }

    public boolean isDirty() {
        return this.dirty.compareAndSet(true, false);
    }

    public synchronized void waitDirty() throws InterruptedException {
        while (!this.dirty.compareAndSet(true, false)) {
            wait();
        }
    }

    /* access modifiers changed from: protected */
    public synchronized void setDirty() {
        this.dirty.set(true);
        notifyAll();
    }

    public synchronized boolean setSize(int w, int h) {
        if (w < 2 || w > 256 || h < 2 || h > 256) {
            return false;
        }
        for (int i = 0; i < this.height; i++) {
            if (this.screen[i].length < w) {
                this.screen[i] = Arrays.copyOf(this.screen[i], w);
            }
            if (this.screen2[i].length < w) {
                this.screen2[i] = Arrays.copyOf(this.screen2[i], w);
            }
        }
        if (this.f3167cx >= w) {
            this.f3167cx = w - 1;
        }
        if (h < this.height) {
            int needed = this.height - h;
            int avail = (this.height - 1) - this.f3168cy;
            if (avail > 0) {
                if (avail > needed) {
                    avail = needed;
                }
                this.screen = (long[][]) Arrays.copyOfRange(this.screen, 0, this.height - avail);
            }
            int needed2 = needed - avail;
            for (int i2 = 0; i2 < needed2; i2++) {
                this.history.add(this.screen[i2]);
            }
            this.screen = (long[][]) Arrays.copyOfRange(this.screen, needed2, this.screen.length);
            this.f3168cy -= needed2;
        } else if (h > this.height) {
            int needed3 = h - this.height;
            int avail2 = this.history.size();
            if (avail2 > needed3) {
                avail2 = needed3;
            }
            long[][] sc = new long[h];
            if (avail2 > 0) {
                for (int i3 = 0; i3 < avail2; i3++) {
                    sc[i3] = this.history.remove((this.history.size() - avail2) + i3);
                }
                this.f3168cy += avail2;
            }
            System.arraycopy(this.screen, 0, sc, avail2, this.screen.length);
            for (int i4 = avail2 + this.screen.length; i4 < sc.length; i4++) {
                sc[i4] = new long[w];
                Arrays.fill(sc[i4], this.attr | 32);
            }
            this.screen = sc;
        }
        this.screen2 = (long[][]) Array.newInstance(Long.TYPE, h, w);
        for (int i5 = 0; i5 < h; i5++) {
            Arrays.fill(this.screen2[i5], this.attr | 32);
        }
        this.scroll_area_y0 = Math.min(h, this.scroll_area_y0);
        this.scroll_area_y1 = this.scroll_area_y1 == this.height ? h : Math.min(h, this.scroll_area_y1);
        this.f3167cx = Math.min(w - 1, this.f3167cx);
        this.f3168cy = Math.min(h - 1, this.f3168cy);
        this.width = w;
        this.height = h;
        setDirty();
        return true;
    }

    public synchronized String read() {
        String d = this.vt100_out;
        this.vt100_out = "";
        return d;
    }

    public synchronized String pipe(String d) {
        String o = "";
        char[] charArray = d.toCharArray();
        for (char c : charArray) {
            if (this.vt100_keyfilter_escape) {
                this.vt100_keyfilter_escape = false;
                if (this.vt100_mode_cursorkey) {
                    switch (c) {
                        case '1':
                            o = o + "\u001b[5~";
                            continue;
                        case '2':
                            o = o + "\u001b[6~";
                            continue;
                        case '3':
                            o = o + "\u001b[2~";
                            continue;
                        case '4':
                            o = o + "\u001b[3~";
                            continue;
                        case 'A':
                            o = o + "\u001bOA";
                            continue;
                        case 'B':
                            o = o + "\u001bOB";
                            continue;
                        case 'C':
                            o = o + "\u001bOC";
                            continue;
                        case 'D':
                            o = o + "\u001bOD";
                            continue;
                        case 'F':
                            o = o + "\u001bOF";
                            continue;
                        case 'H':
                            o = o + "\u001bOH";
                            continue;
                        case 'a':
                            o = o + "\u001bOP";
                            continue;
                        case 'b':
                            o = o + "\u001bOQ";
                            continue;
                        case 'c':
                            o = o + "\u001bOR";
                            continue;
                        case 'd':
                            o = o + "\u001bOS";
                            continue;
                        case 'e':
                            o = o + "\u001b[15~";
                            continue;
                        case 'f':
                            o = o + "\u001b[17~";
                            continue;
                        case 'g':
                            o = o + "\u001b[18~";
                            continue;
                        case 'h':
                            o = o + "\u001b[19~";
                            continue;
                        case 'i':
                            o = o + "\u001b[20~";
                            continue;
                        case 'j':
                            o = o + "\u001b[21~";
                            continue;
                        case 'k':
                            o = o + "\u001b[23~";
                            continue;
                        case 'l':
                            o = o + "\u001b[24~";
                            continue;
                        case '~':
                            o = o + "~";
                            continue;
                    }
                } else {
                    switch (c) {
                        case '1':
                            o = o + "\u001b[5~";
                            continue;
                        case '2':
                            o = o + "\u001b[6~";
                            continue;
                        case '3':
                            o = o + "\u001b[2~";
                            continue;
                        case '4':
                            o = o + "\u001b[3~";
                            continue;
                        case 'A':
                            o = o + "\u001b[A";
                            continue;
                        case 'B':
                            o = o + "\u001b[B";
                            continue;
                        case 'C':
                            o = o + "\u001b[C";
                            continue;
                        case 'D':
                            o = o + "\u001b[D";
                            continue;
                        case 'F':
                            o = o + "\u001b[F";
                            continue;
                        case 'H':
                            o = o + "\u001b[H";
                            continue;
                        case 'a':
                            o = o + "\u001bOP";
                            continue;
                        case 'b':
                            o = o + "\u001bOQ";
                            continue;
                        case 'c':
                            o = o + "\u001bOR";
                            continue;
                        case 'd':
                            o = o + "\u001bOS";
                            continue;
                        case 'e':
                            o = o + "\u001b[15~";
                            continue;
                        case 'f':
                            o = o + "\u001b[17~";
                            continue;
                        case 'g':
                            o = o + "\u001b[18~";
                            continue;
                        case 'h':
                            o = o + "\u001b[19~";
                            continue;
                        case 'i':
                            o = o + "\u001b[20~";
                            continue;
                        case 'j':
                            o = o + "\u001b[21~";
                            continue;
                        case 'k':
                            o = o + "\u001b[23~";
                            continue;
                        case 'l':
                            o = o + "\u001b[24~";
                            continue;
                        case '~':
                            o = o + "~";
                            continue;
                    }
                }
            } else if (c == '~') {
                this.vt100_keyfilter_escape = true;
            } else if (c == 127) {
                o = this.vt100_mode_backspace ? o + '\b' : o + (char) 127;
            } else {
                o = o + c;
                if (this.vt100_mode_lfnewline && c == '\r') {
                    o = o + '\n';
                }
            }
        }
        return o;
    }

    public synchronized boolean write(CharSequence d) {
        d.codePoints().forEachOrdered(c -> {
            if (!vt100_write(c) && !dumb_write(c) && c <= 65535) {
                dumb_echo(c);
            }
        });
        return true;
    }

    public synchronized void dump(long[] fullscreen, int ftop, int fleft, int fheight, int fwidth, int[] cursor) {
        int cx = Math.min(this.f3167cx, this.width - 1);
        int cy = this.f3168cy;
        for (int y = 0; y < Math.min(this.height, fheight - ftop); y++) {
            System.arraycopy(this.screen[y], 0, fullscreen, ((y + ftop) * fwidth) + fleft, this.width);
        }
        if (cursor != null) {
            cursor[0] = cx + fleft;
            cursor[1] = cy + ftop;
        }
    }

    public synchronized String dump(long timeout, boolean forceDump) throws InterruptedException {
        String ul;
        String b;
        if (!this.dirty.get() && timeout > 0) {
            wait(timeout);
        }
        if (!(this.dirty.compareAndSet(true, false) || forceDump)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int prev_attr = -1;
        int cx = Math.min(this.f3167cx, this.width - 1);
        int cy = this.f3168cy;
        sb.append("<div><pre class='term'>");
        for (int y = 0; y < this.height; y++) {
            int wx = 0;
            for (int x = 0; x < this.width; x++) {
                long d = this.screen[y][x];
                int c = (int) (d & -1);
                int a = (int) (d >> 32);
                if (cy == y && cx == x && this.vt100_mode_cursor) {
                    a = (a & 65520) | 12;
                }
                if (a != prev_attr) {
                    if (prev_attr != -1) {
                        sb.append("</span>");
                    }
                    int bg = a & 255;
                    int fg = (a & 65280) >> 8;
                    boolean inv = (a & 131072) != 0;
                    boolean inv2 = this.vt100_mode_inverse;
                    if ((inv && !inv2) || (inv2 && !inv)) {
                        fg = bg;
                        bg = fg;
                    }
                    if ((a & 262144) != 0) {
                        fg = 12;
                    }
                    if ((a & 65536) != 0) {
                        ul = " ul";
                    } else {
                        ul = "";
                    }
                    if ((a & 524288) != 0) {
                        b = " b";
                    } else {
                        b = "";
                    }
                    sb.append("<span class='f").append(fg).append(" b").append(bg).append(ul).append(b).append("'>");
                    prev_attr = a;
                }
                switch (c) {
                    case 38:
                        sb.append("&amp;");
                        break;
                    case 60:
                        sb.append("&lt;");
                        break;
                    case 62:
                        sb.append("&gt;");
                        break;
                    default:
                        wx += utf8_charwidth(c);
                        if (wx <= this.width) {
                            sb.append((char) c);
                            break;
                        } else {
                            break;
                        }
                }
            }
            sb.append("\n");
        }
        sb.append("</span></pre></div>");
        return sb.toString();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                sb.appendCodePoint((int) (this.screen[y][x] & 4294967295L));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
