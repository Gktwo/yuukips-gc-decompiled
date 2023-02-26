package org.luaj.vm2.compiler;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import org.luaj.vm2.LocVars;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;
import org.luaj.vm2.compiler.FuncState;
import org.luaj.vm2.compiler.LuaC;
import org.luaj.vm2.lib.MathLib;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState.class */
public class LexState extends Constants {
    private static final int EOZ = -1;
    private static final int MAX_INT = 2147483645;
    private static final int UCHAR_MAX = 255;
    private static final int LUAI_MAXCCALLS = 200;
    private static final int LUA_COMPAT_LSTR = 1;
    private static final boolean LUA_COMPAT_VARARG = true;
    static final int NO_JUMP = -1;
    static final int OPR_ADD = 0;
    static final int OPR_SUB = 1;
    static final int OPR_MUL = 2;
    static final int OPR_DIV = 3;
    static final int OPR_MOD = 4;
    static final int OPR_POW = 5;
    static final int OPR_CONCAT = 6;
    static final int OPR_NE = 7;
    static final int OPR_EQ = 8;
    static final int OPR_LT = 9;
    static final int OPR_LE = 10;
    static final int OPR_GT = 11;
    static final int OPR_GE = 12;
    static final int OPR_AND = 13;
    static final int OPR_OR = 14;
    static final int OPR_NOBINOPR = 15;
    static final int OPR_MINUS = 0;
    static final int OPR_NOT = 1;
    static final int OPR_LEN = 2;
    static final int OPR_NOUNOPR = 3;
    static final int VVOID = 0;
    static final int VNIL = 1;
    static final int VTRUE = 2;
    static final int VFALSE = 3;

    /* renamed from: VK */
    static final int f3280VK = 4;
    static final int VKNUM = 5;
    static final int VNONRELOC = 6;
    static final int VLOCAL = 7;
    static final int VUPVAL = 8;
    static final int VINDEXED = 9;
    static final int VJMP = 10;
    static final int VRELOCABLE = 11;
    static final int VCALL = 12;
    static final int VVARARG = 13;
    int current;
    int linenumber;
    int lastline;

    /* renamed from: fs */
    FuncState f3282fs;

    /* renamed from: L */
    LuaC.CompileState f3283L;

    /* renamed from: z */
    InputStream f3284z;
    int nbuff;
    LuaString source;
    LuaString envn;
    byte decpoint;
    static final String[] luaX_tokens;
    static final int TK_AND = 257;
    static final int TK_BREAK = 258;
    static final int TK_DO = 259;
    static final int TK_ELSE = 260;
    static final int TK_ELSEIF = 261;
    static final int TK_END = 262;
    static final int TK_FALSE = 263;
    static final int TK_FOR = 264;
    static final int TK_FUNCTION = 265;
    static final int TK_GOTO = 266;
    static final int TK_IF = 267;
    static final int TK_IN = 268;
    static final int TK_LOCAL = 269;
    static final int TK_NIL = 270;
    static final int TK_NOT = 271;
    static final int TK_OR = 272;
    static final int TK_REPEAT = 273;
    static final int TK_RETURN = 274;
    static final int TK_THEN = 275;
    static final int TK_TRUE = 276;
    static final int TK_UNTIL = 277;
    static final int TK_WHILE = 278;
    static final int TK_CONCAT = 279;
    static final int TK_DOTS = 280;
    static final int TK_EQ = 281;
    static final int TK_GE = 282;
    static final int TK_LE = 283;
    static final int TK_NE = 284;
    static final int TK_DBCOLON = 285;
    static final int TK_EOS = 286;
    static final int TK_NUMBER = 287;
    static final int TK_NAME = 288;
    static final int TK_STRING = 289;
    static final int FIRST_RESERVED = 257;
    static final int NUM_RESERVED = 22;
    static final Hashtable RESERVED;
    static Priority[] priority;
    static final int UNARY_PRIORITY = 8;
    protected static final String RESERVED_LOCAL_VAR_FOR_CONTROL = "(for control)";
    protected static final String RESERVED_LOCAL_VAR_FOR_GENERATOR = "(for generator)";
    protected static final String RESERVED_LOCAL_VAR_FOR_INDEX = "(for index)";
    protected static final String RESERVED_LOCAL_VAR_FOR_LIMIT = "(for limit)";
    protected static final String RESERVED_LOCAL_VAR_FOR_STATE = "(for state)";
    protected static final String RESERVED_LOCAL_VAR_FOR_STEP = "(for step)";
    protected static final String[] RESERVED_LOCAL_VAR_KEYWORDS = {RESERVED_LOCAL_VAR_FOR_CONTROL, RESERVED_LOCAL_VAR_FOR_GENERATOR, RESERVED_LOCAL_VAR_FOR_INDEX, RESERVED_LOCAL_VAR_FOR_LIMIT, RESERVED_LOCAL_VAR_FOR_STATE, RESERVED_LOCAL_VAR_FOR_STEP};
    private static final Hashtable RESERVED_LOCAL_VAR_KEYWORDS_TABLE = new Hashtable();

    /* renamed from: t */
    final Token f3281t = new Token(null);
    final Token lookahead = new Token(null);
    Dyndata dyd = new Dyndata();
    char[] buff = new char[32];

    /* renamed from: org.luaj.vm2.compiler.LexState$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$1.class */
    static class C58581 {
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$ConsControl.class */
    public static class ConsControl {

        /* renamed from: v */
        expdesc f3285v = new expdesc();

        /* renamed from: t */
        expdesc f3286t;

        /* renamed from: nh */
        int f3287nh;

        /* renamed from: na */
        int f3288na;
        int tostore;

        ConsControl() {
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$Dyndata.class */
    public static class Dyndata {
        Vardesc[] actvar;

        /* renamed from: gt */
        Labeldesc[] f3289gt;
        Labeldesc[] label;
        int n_actvar = 0;
        int n_gt = 0;
        int n_label = 0;

        Dyndata() {
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$LHS_assign.class */
    public static class LHS_assign {
        LHS_assign prev;

        /* renamed from: v */
        expdesc f3290v = new expdesc();

        LHS_assign() {
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$Labeldesc.class */
    public static class Labeldesc {
        LuaString name;

        /* renamed from: pc */
        int f3291pc;
        int line;
        short nactvar;

        public Labeldesc(LuaString luaString, int i, int i2, short s) {
            this.name = luaString;
            this.f3291pc = i;
            this.line = i2;
            this.nactvar = s;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$Priority.class */
    public static class Priority {
        final byte left;
        final byte right;

        public Priority(int i, int i2) {
            this.left = (byte) i;
            this.right = (byte) i2;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$SemInfo.class */
    public static class SemInfo {

        /* renamed from: r */
        LuaValue f3292r;

        /* renamed from: ts */
        LuaString f3293ts;

        private SemInfo() {
        }

        SemInfo(C58581 r3) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$Token.class */
    public static class Token {
        int token;
        final SemInfo seminfo;

        private Token() {
            this.seminfo = new SemInfo(null);
        }

        public void set(Token token) {
            this.token = token.token;
            this.seminfo.f3292r = token.seminfo.f3292r;
            this.seminfo.f3293ts = token.seminfo.f3293ts;
        }

        Token(C58581 r3) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$Vardesc.class */
    public static class Vardesc {
        final short idx;

        Vardesc(int i) {
            this.idx = (short) i;
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$expdesc.class */
    public static class expdesc {

        /* renamed from: k */
        int f3294k;

        /* renamed from: u */
        final C5859U f3295u = new C5859U();

        /* renamed from: t */
        final IntPtr f3296t = new IntPtr();

        /* renamed from: f */
        final IntPtr f3297f = new IntPtr();

        /* access modifiers changed from: package-private */
        /* renamed from: org.luaj.vm2.compiler.LexState$expdesc$U */
        /* loaded from: grasscutter.jar:org/luaj/vm2/compiler/LexState$expdesc$U.class */
        public static class C5859U {
            short ind_idx;
            short ind_t;
            short ind_vt;
            private LuaValue _nval;
            int info;

            C5859U() {
            }

            public void setNval(LuaValue luaValue) {
                this._nval = luaValue;
            }

            public LuaValue nval() {
                return this._nval == null ? LuaInteger.valueOf(this.info) : this._nval;
            }

            static LuaValue access$202(C5859U u, LuaValue luaValue) {
                u._nval = luaValue;
                return luaValue;
            }

            static LuaValue access$200(C5859U u) {
                return u._nval;
            }
        }

        /* access modifiers changed from: package-private */
        public void init(int i, int i2) {
            this.f3297f.f3279i = -1;
            this.f3296t.f3279i = -1;
            this.f3294k = i;
            this.f3295u.info = i2;
        }

        /* access modifiers changed from: package-private */
        public boolean hasjumps() {
            return this.f3296t.f3279i != this.f3297f.f3279i;
        }

        /* access modifiers changed from: package-private */
        public boolean isnumeral() {
            return this.f3294k == 5 && this.f3296t.f3279i == -1 && this.f3297f.f3279i == -1;
        }

        public void setvalue(expdesc expdesc) {
            this.f3297f.f3279i = expdesc.f3297f.f3279i;
            this.f3294k = expdesc.f3294k;
            this.f3296t.f3279i = expdesc.f3296t.f3279i;
            C5859U.access$202(this.f3295u, C5859U.access$200(expdesc.f3295u));
            this.f3295u.ind_idx = expdesc.f3295u.ind_idx;
            this.f3295u.ind_t = expdesc.f3295u.ind_t;
            this.f3295u.ind_vt = expdesc.f3295u.ind_vt;
            this.f3295u.info = expdesc.f3295u.info;
        }
    }

    private static final String LUA_QS(String str) {
        return new StringBuffer().append("'").append(str).append("'").toString();
    }

    private static final String LUA_QL(Object obj) {
        return LUA_QS(String.valueOf(obj));
    }

    public static boolean isReservedKeyword(String str) {
        return RESERVED_LOCAL_VAR_KEYWORDS_TABLE.containsKey(str);
    }

    private boolean isalnum(int i) {
        return (i >= 48 && i <= 57) || (i >= 97 && i <= 122) || ((i >= 65 && i <= 90) || i == 95);
    }

    private boolean isalpha(int i) {
        return (i >= 97 && i <= 122) || (i >= 65 && i <= 90);
    }

    private boolean isdigit(int i) {
        return i >= 48 && i <= 57;
    }

    private boolean isxdigit(int i) {
        return (i >= 48 && i <= 57) || (i >= 97 && i <= 102) || (i >= 65 && i <= 70);
    }

    private boolean isspace(int i) {
        return i <= 32;
    }

    public LexState(LuaC.CompileState compileState, InputStream inputStream) {
        this.f3284z = inputStream;
        this.f3283L = compileState;
    }

    void nextChar() {
        try {
            this.current = this.f3284z.read();
        } catch (IOException e) {
            e.printStackTrace();
            this.current = -1;
        }
    }

    boolean currIsNewline() {
        return this.current == 10 || this.current == 13;
    }

    void save_and_next() {
        save(this.current);
        nextChar();
    }

    void save(int i) {
        if (this.buff == null || this.nbuff + 1 > this.buff.length) {
            this.buff = realloc(this.buff, (this.nbuff * 2) + 1);
        }
        char[] cArr = this.buff;
        int i2 = this.nbuff;
        this.nbuff = i2 + 1;
        cArr[i2] = (char) i;
    }

    String token2str(int i) {
        return i < 257 ? iscntrl(i) ? this.f3283L.pushfstring(new StringBuffer().append("char(").append(i).append(")").toString()) : this.f3283L.pushfstring(String.valueOf((char) i)) : luaX_tokens[i - PacketOpcodes.CutSceneFinishNotify];
    }

    private static boolean iscntrl(int i) {
        return i < 32;
    }

    String txtToken(int i) {
        switch (i) {
            case 287:
            case 288:
            case 289:
                return new String(this.buff, 0, this.nbuff);
            default:
                return token2str(i);
        }
    }

    /* access modifiers changed from: package-private */
    public void lexerror(String str, int i) {
        String chunkid = Lua.chunkid(this.source.tojstring());
        this.f3283L.pushfstring(new StringBuffer().append(chunkid).append(EmitterKt.COMMENT_PREFIX).append(this.linenumber).append(": ").append(str).toString());
        if (i != 0) {
            this.f3283L.pushfstring(new StringBuffer().append("syntax error: ").append(str).append(" near ").append(txtToken(i)).toString());
        }
        throw new LuaError(new StringBuffer().append(chunkid).append(EmitterKt.COMMENT_PREFIX).append(this.linenumber).append(": ").append(str).toString());
    }

    /* access modifiers changed from: package-private */
    public void syntaxerror(String str) {
        lexerror(str, this.f3281t.token);
    }

    LuaString newstring(String str) {
        return this.f3283L.newTString(str);
    }

    LuaString newstring(char[] cArr, int i, int i2) {
        return this.f3283L.newTString(new String(cArr, i, i2));
    }

    void inclinenumber() {
        int i = this.current;
        _assert(currIsNewline());
        nextChar();
        if (currIsNewline() && this.current != i) {
            nextChar();
        }
        int i2 = this.linenumber + 1;
        this.linenumber = i2;
        if (i2 >= MAX_INT) {
            syntaxerror("chunk has too many lines");
        }
    }

    /* access modifiers changed from: package-private */
    public void setinput(LuaC.CompileState compileState, int i, InputStream inputStream, LuaString luaString) {
        this.decpoint = 46;
        this.f3283L = compileState;
        this.lookahead.token = 286;
        this.f3284z = inputStream;
        this.f3282fs = null;
        this.linenumber = 1;
        this.lastline = 1;
        this.source = luaString;
        this.envn = LuaValue.ENV;
        this.nbuff = 0;
        this.current = i;
        skipShebang();
    }

    private void skipShebang() {
        if (this.current == 35) {
            while (!currIsNewline() && this.current != -1) {
                nextChar();
            }
        }
    }

    boolean check_next(String str) {
        if (str.indexOf(this.current) < 0) {
            return false;
        }
        save_and_next();
        return true;
    }

    void buffreplace(char c, char c2) {
        int i = this.nbuff;
        char[] cArr = this.buff;
        while (true) {
            i--;
            if (i < 0) {
                return;
            }
            if (cArr[i] == c) {
                cArr[i] = c2;
            }
        }
    }

    LuaValue strx2number(String str, SemInfo semInfo) {
        char[] charArray = str.toCharArray();
        int i = 0;
        while (i < charArray.length && isspace(charArray[i])) {
            i++;
        }
        double d = 1.0d;
        if (i < charArray.length && charArray[i] == '-') {
            d = -1.0d;
            i++;
        }
        if (i + 2 >= charArray.length) {
            return LuaValue.ZERO;
        }
        int i2 = i + 1;
        if (charArray[i] != '0') {
            return LuaValue.ZERO;
        }
        if (charArray[i2] != 'x' && charArray[i2] != 'X') {
            return LuaValue.ZERO;
        }
        int i3 = i2 + 1;
        double d2 = 0.0d;
        int i4 = 0;
        while (i3 < charArray.length && isxdigit(charArray[i3])) {
            i3++;
            d2 = (d2 * 16.0d) + ((double) hexvalue(charArray[i3]));
        }
        if (i3 < charArray.length && charArray[i3] == '.') {
            i3++;
            while (i3 < charArray.length && isxdigit(charArray[i3])) {
                i3++;
                d2 = (d2 * 16.0d) + ((double) hexvalue(charArray[i3]));
                i4 -= 4;
            }
        }
        if (i3 < charArray.length && (charArray[i3] == 'p' || charArray[i3] == 'P')) {
            int i5 = i3 + 1;
            int i6 = 0;
            boolean z = false;
            if (i5 < charArray.length && charArray[i5] == '-') {
                z = true;
                i5++;
            }
            while (i5 < charArray.length && isdigit(charArray[i5])) {
                i5++;
                i6 = ((i6 * 10) + charArray[i5]) - 48;
            }
            if (z) {
                i6 = -i6;
            }
            i4 += i6;
        }
        return LuaValue.valueOf(d * d2 * MathLib.dpow_d(2.0d, (double) i4));
    }

    boolean str2d(String str, SemInfo semInfo) {
        if (str.indexOf(110) >= 0 || str.indexOf(78) >= 0) {
            semInfo.f3292r = LuaValue.ZERO;
            return true;
        } else if (str.indexOf(120) >= 0 || str.indexOf(88) >= 0) {
            semInfo.f3292r = strx2number(str, semInfo);
            return true;
        } else {
            semInfo.f3292r = LuaValue.valueOf(Double.parseDouble(str.trim()));
            return true;
        }
    }

    void read_numeral(SemInfo semInfo) {
        String str = "Ee";
        int i = this.current;
        _assert(isdigit(this.current));
        save_and_next();
        if (i == 48 && check_next("Xx")) {
            str = "Pp";
        }
        while (true) {
            if (check_next(str)) {
                check_next("+-");
            }
            if (isxdigit(this.current) || this.current == 46) {
                save_and_next();
            } else {
                save(0);
                str2d(new String(this.buff, 0, this.nbuff), semInfo);
                return;
            }
        }
    }

    int skip_sep() {
        int i = 0;
        int i2 = this.current;
        _assert(i2 == 91 || i2 == 93);
        save_and_next();
        while (this.current == 61) {
            save_and_next();
            i++;
        }
        return this.current == i2 ? i : (-i) - 1;
    }

    void read_long_string(SemInfo semInfo, int i) {
        int i2 = 0;
        save_and_next();
        if (currIsNewline()) {
            inclinenumber();
        }
        boolean z = false;
        while (!z) {
            switch (this.current) {
                case -1:
                    lexerror(semInfo != null ? "unfinished long string" : "unfinished long comment", 286);
                    break;
                case 10:
                case 13:
                    save(10);
                    inclinenumber();
                    if (semInfo != null) {
                        break;
                    } else {
                        this.nbuff = 0;
                        break;
                    }
                case 91:
                    if (skip_sep() != i) {
                        break;
                    } else {
                        save_and_next();
                        i2++;
                        if (i != 0) {
                            break;
                        } else {
                            lexerror("nesting of [[...]] is deprecated", 91);
                            break;
                        }
                    }
                case 93:
                    if (skip_sep() != i) {
                        break;
                    } else {
                        save_and_next();
                        z = true;
                        break;
                    }
                default:
                    if (semInfo == null) {
                        nextChar();
                        break;
                    } else {
                        save_and_next();
                        break;
                    }
            }
        }
        if (semInfo != null) {
            semInfo.f3293ts = this.f3283L.newTString(LuaString.valueOf(this.buff, 2 + i, this.nbuff - (2 * (2 + i))));
        }
    }

    int hexvalue(int i) {
        return i <= 57 ? i - 48 : i <= 70 ? (i + 10) - 65 : (i + 10) - 97;
    }

    int readhexaesc() {
        nextChar();
        int i = this.current;
        nextChar();
        int i2 = this.current;
        if (!isxdigit(i) || !isxdigit(i2)) {
            lexerror(new StringBuffer().append("hexadecimal digit expected 'x").append((char) i).append((char) i2).toString(), 289);
        }
        return (hexvalue(i) << 4) + hexvalue(i2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0171  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void read_string(int r8, org.luaj.vm2.compiler.LexState.SemInfo r9) {
        /*
        // Method dump skipped, instructions count: 435
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.LexState.read_string(int, org.luaj.vm2.compiler.LexState$SemInfo):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0146, code lost:
        nextChar();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0150, code lost:
        if (r5.current == 61) goto L_0x0156;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0153, code lost:
        return 61;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0156, code lost:
        nextChar();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x015d, code lost:
        return 281;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    int llex(org.luaj.vm2.compiler.LexState.SemInfo r6) {
        /*
        // Method dump skipped, instructions count: 680
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.compiler.LexState.llex(org.luaj.vm2.compiler.LexState$SemInfo):int");
    }

    void next() {
        this.lastline = this.linenumber;
        if (this.lookahead.token != 286) {
            this.f3281t.set(this.lookahead);
            this.lookahead.token = 286;
            return;
        }
        this.f3281t.token = llex(this.f3281t.seminfo);
    }

    void lookahead() {
        _assert(this.lookahead.token == 286);
        this.lookahead.token = llex(this.lookahead.seminfo);
    }

    static final boolean vkisvar(int i) {
        return 7 <= i && i <= 9;
    }

    static final boolean vkisinreg(int i) {
        return i == 6 || i == 7;
    }

    boolean hasmultret(int i) {
        return i == 12 || i == 13;
    }

    void anchor_token() {
        _assert(this.f3282fs != null || this.f3281t.token == 286);
        if (this.f3281t.token == 288 || this.f3281t.token == 289) {
            LuaString luaString = this.f3281t.seminfo.f3293ts;
            this.f3283L.cachedLuaString(this.f3281t.seminfo.f3293ts);
        }
    }

    /* access modifiers changed from: package-private */
    public void semerror(String str) {
        this.f3281t.token = 0;
        syntaxerror(str);
    }

    void error_expected(int i) {
        syntaxerror(this.f3283L.pushfstring(new StringBuffer().append(LUA_QS(token2str(i))).append(" expected").toString()));
    }

    boolean testnext(int i) {
        if (this.f3281t.token != i) {
            return false;
        }
        next();
        return true;
    }

    void check(int i) {
        if (this.f3281t.token != i) {
            error_expected(i);
        }
    }

    void checknext(int i) {
        check(i);
        next();
    }

    void check_condition(boolean z, String str) {
        if (!z) {
            syntaxerror(str);
        }
    }

    void check_match(int i, int i2, int i3) {
        if (testnext(i)) {
            return;
        }
        if (i3 == this.linenumber) {
            error_expected(i);
        } else {
            syntaxerror(this.f3283L.pushfstring(new StringBuffer().append(LUA_QS(token2str(i))).append(" expected ").append("(to close ").append(LUA_QS(token2str(i2))).append(" at line ").append(i3).append(")").toString()));
        }
    }

    LuaString str_checkname() {
        check(288);
        LuaString luaString = this.f3281t.seminfo.f3293ts;
        next();
        return luaString;
    }

    void codestring(expdesc expdesc2, LuaString luaString) {
        expdesc2.init(4, this.f3282fs.stringK(luaString));
    }

    void checkname(expdesc expdesc2) {
        codestring(expdesc2, str_checkname());
    }

    int registerlocalvar(LuaString luaString) {
        FuncState funcState = this.f3282fs;
        Prototype prototype = funcState.f3271f;
        if (prototype.locvars == null || funcState.nlocvars + 1 > prototype.locvars.length) {
            prototype.locvars = realloc(prototype.locvars, (funcState.nlocvars * 2) + 1);
        }
        prototype.locvars[funcState.nlocvars] = new LocVars(luaString, 0, 0);
        short s = funcState.nlocvars;
        funcState.nlocvars = (short) (s + 1);
        return s;
    }

    void new_localvar(LuaString luaString) {
        int registerlocalvar = registerlocalvar(luaString);
        this.f3282fs.checklimit(this.dyd.n_actvar + 1, 200, "local variables");
        if (this.dyd.actvar == null || this.dyd.n_actvar + 1 > this.dyd.actvar.length) {
            this.dyd.actvar = realloc(this.dyd.actvar, Math.max(1, this.dyd.n_actvar * 2));
        }
        Vardesc[] vardescArr = this.dyd.actvar;
        Dyndata dyndata = this.dyd;
        int i = dyndata.n_actvar;
        dyndata.n_actvar = i + 1;
        vardescArr[i] = new Vardesc(registerlocalvar);
    }

    void new_localvarliteral(String str) {
        new_localvar(newstring(str));
    }

    void adjustlocalvars(int i) {
        FuncState funcState = this.f3282fs;
        funcState.nactvar = (short) (funcState.nactvar + i);
        while (i > 0) {
            funcState.getlocvar(funcState.nactvar - i).startpc = funcState.f3276pc;
            i--;
        }
    }

    void removevars(int i) {
        FuncState funcState = this.f3282fs;
        while (funcState.nactvar > i) {
            short s = (short) (funcState.nactvar - 1);
            funcState.nactvar = s;
            funcState.getlocvar(s).endpc = funcState.f3276pc;
        }
    }

    void singlevar(expdesc expdesc2) {
        LuaString str_checkname = str_checkname();
        FuncState funcState = this.f3282fs;
        if (FuncState.singlevaraux(funcState, str_checkname, expdesc2, 1) == 0) {
            expdesc expdesc3 = new expdesc();
            FuncState.singlevaraux(funcState, this.envn, expdesc2, 1);
            _assert(expdesc2.f3294k == 7 || expdesc2.f3294k == 8);
            codestring(expdesc3, str_checkname);
            funcState.indexed(expdesc2, expdesc3);
        }
    }

    void adjust_assign(int i, int i2, expdesc expdesc2) {
        FuncState funcState = this.f3282fs;
        int i3 = i - i2;
        if (hasmultret(expdesc2.f3294k)) {
            int i4 = i3 + 1;
            if (i4 < 0) {
                i4 = 0;
            }
            funcState.setreturns(expdesc2, i4);
            if (i4 > 1) {
                funcState.reserveregs(i4 - 1);
                return;
            }
            return;
        }
        if (expdesc2.f3294k != 0) {
            funcState.exp2nextreg(expdesc2);
        }
        if (i3 > 0) {
            short s = funcState.freereg;
            funcState.reserveregs(i3);
            funcState.nil(s, i3);
        }
    }

    void enterlevel() {
        LuaC.CompileState compileState = this.f3283L;
        int i = compileState.nCcalls + 1;
        compileState.nCcalls = i;
        if (i > 200) {
            lexerror("chunk has too many syntax levels", 0);
        }
    }

    void leavelevel() {
        this.f3283L.nCcalls--;
    }

    void closegoto(int i, Labeldesc labeldesc) {
        FuncState funcState = this.f3282fs;
        Labeldesc[] labeldescArr = this.dyd.f3289gt;
        Labeldesc labeldesc2 = labeldescArr[i];
        _assert(labeldesc2.name.eq_b(labeldesc.name));
        if (labeldesc2.nactvar < labeldesc.nactvar) {
            semerror(this.f3283L.pushfstring(new StringBuffer().append("<goto ").append(labeldesc2.name).append("> at line ").append(labeldesc2.line).append(" jumps into the scope of local '").append(funcState.getlocvar(labeldesc2.nactvar).varname.tojstring()).append("'").toString()));
        }
        funcState.patchlist(labeldesc2.f3291pc, labeldesc.f3291pc);
        System.arraycopy(labeldescArr, i + 1, labeldescArr, i, (this.dyd.n_gt - i) - 1);
        Dyndata dyndata = this.dyd;
        int i2 = dyndata.n_gt - 1;
        dyndata.n_gt = i2;
        labeldescArr[i2] = null;
    }

    /* access modifiers changed from: package-private */
    public boolean findlabel(int i) {
        FuncState.BlockCnt blockCnt = this.f3282fs.f3275bl;
        Dyndata dyndata = this.dyd;
        Labeldesc labeldesc = dyndata.f3289gt[i];
        for (int i2 = blockCnt.firstlabel; i2 < dyndata.n_label; i2++) {
            Labeldesc labeldesc2 = dyndata.label[i2];
            if (labeldesc2.name.eq_b(labeldesc.name)) {
                if (labeldesc.nactvar > labeldesc2.nactvar && (blockCnt.upval || dyndata.n_label > blockCnt.firstlabel)) {
                    this.f3282fs.patchclose(labeldesc.f3291pc, labeldesc2.nactvar);
                }
                closegoto(i, labeldesc2);
                return true;
            }
        }
        return false;
    }

    int newlabelentry(Labeldesc[] labeldescArr, int i, LuaString luaString, int i2, int i3) {
        labeldescArr[i] = new Labeldesc(luaString, i3, i2, this.f3282fs.nactvar);
        return i;
    }

    void findgotos(Labeldesc labeldesc) {
        Labeldesc[] labeldescArr = this.dyd.f3289gt;
        int i = this.f3282fs.f3275bl.firstgoto;
        while (i < this.dyd.n_gt) {
            if (labeldescArr[i].name.eq_b(labeldesc.name)) {
                closegoto(i, labeldesc);
            } else {
                i++;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void breaklabel() {
        LuaString valueOf = LuaString.valueOf("break");
        Dyndata dyndata = this.dyd;
        Labeldesc[] grow = grow(this.dyd.label, this.dyd.n_label + 1);
        dyndata.label = grow;
        Dyndata dyndata2 = this.dyd;
        int i = dyndata2.n_label;
        dyndata2.n_label = i + 1;
        findgotos(this.dyd.label[newlabelentry(grow, i, valueOf, 0, this.f3282fs.f3276pc)]);
    }

    /* access modifiers changed from: package-private */
    public void undefgoto(Labeldesc labeldesc) {
        semerror(this.f3283L.pushfstring(isReservedKeyword(labeldesc.name.tojstring()) ? new StringBuffer().append("<").append(labeldesc.name).append("> at line ").append(labeldesc.line).append(" not inside a loop").toString() : new StringBuffer().append("no visible label '").append(labeldesc.name).append("' for <goto> at line ").append(labeldesc.line).toString()));
    }

    Prototype addprototype() {
        Prototype prototype = this.f3282fs.f3271f;
        if (prototype.f3260p == null || this.f3282fs.f3278np >= prototype.f3260p.length) {
            prototype.f3260p = realloc(prototype.f3260p, Math.max(1, this.f3282fs.f3278np * 2));
        }
        Prototype[] prototypeArr = prototype.f3260p;
        FuncState funcState = this.f3282fs;
        int i = funcState.f3278np;
        funcState.f3278np = i + 1;
        Prototype prototype2 = new Prototype();
        prototypeArr[i] = prototype2;
        return prototype2;
    }

    void codeclosure(expdesc expdesc2) {
        FuncState funcState = this.f3282fs.prev;
        expdesc2.init(11, funcState.codeABx(37, 0, funcState.f3278np - 1));
        funcState.exp2nextreg(expdesc2);
    }

    void open_func(FuncState funcState, FuncState.BlockCnt blockCnt) {
        funcState.prev = this.f3282fs;
        funcState.f3273ls = this;
        this.f3282fs = funcState;
        funcState.f3276pc = 0;
        funcState.lasttarget = -1;
        funcState.jpc = new IntPtr(-1);
        funcState.freereg = 0;
        funcState.f3277nk = 0;
        funcState.f3278np = 0;
        funcState.nups = 0;
        funcState.nlocvars = 0;
        funcState.nactvar = 0;
        funcState.firstlocal = this.dyd.n_actvar;
        funcState.f3275bl = null;
        funcState.f3271f.source = this.source;
        funcState.f3271f.maxstacksize = 2;
        funcState.enterblock(blockCnt, false);
    }

    void close_func() {
        FuncState funcState = this.f3282fs;
        Prototype prototype = funcState.f3271f;
        funcState.ret(0, 0);
        funcState.leaveblock();
        prototype.code = realloc(prototype.code, funcState.f3276pc);
        prototype.lineinfo = realloc(prototype.lineinfo, funcState.f3276pc);
        prototype.f3259k = realloc(prototype.f3259k, funcState.f3277nk);
        prototype.f3260p = realloc(prototype.f3260p, funcState.f3278np);
        prototype.locvars = realloc(prototype.locvars, funcState.nlocvars);
        prototype.upvalues = realloc(prototype.upvalues, funcState.nups);
        _assert(funcState.f3275bl == null);
        this.f3282fs = funcState.prev;
    }

    void fieldsel(expdesc expdesc2) {
        FuncState funcState = this.f3282fs;
        expdesc expdesc3 = new expdesc();
        funcState.exp2anyregup(expdesc2);
        next();
        checkname(expdesc3);
        funcState.indexed(expdesc2, expdesc3);
    }

    void yindex(expdesc expdesc2) {
        next();
        expr(expdesc2);
        this.f3282fs.exp2val(expdesc2);
        checknext(93);
    }

    void recfield(ConsControl consControl) {
        FuncState funcState = this.f3282fs;
        short s = this.f3282fs.freereg;
        expdesc expdesc2 = new expdesc();
        expdesc expdesc3 = new expdesc();
        if (this.f3281t.token == 288) {
            funcState.checklimit(consControl.f3287nh, MAX_INT, "items in a constructor");
            checkname(expdesc2);
        } else {
            yindex(expdesc2);
        }
        consControl.f3287nh++;
        checknext(61);
        int exp2RK = funcState.exp2RK(expdesc2);
        expr(expdesc3);
        funcState.codeABC(10, consControl.f3286t.f3295u.info, exp2RK, funcState.exp2RK(expdesc3));
        funcState.freereg = (short) s;
    }

    void listfield(ConsControl consControl) {
        expr(consControl.f3285v);
        this.f3282fs.checklimit(consControl.f3288na, MAX_INT, "items in a constructor");
        consControl.f3288na++;
        consControl.tostore++;
    }

    void constructor(expdesc expdesc2) {
        FuncState funcState = this.f3282fs;
        int i = this.linenumber;
        int codeABC = funcState.codeABC(11, 0, 0, 0);
        ConsControl consControl = new ConsControl();
        consControl.tostore = 0;
        consControl.f3287nh = 0;
        consControl.f3288na = 0;
        consControl.f3286t = expdesc2;
        expdesc2.init(11, codeABC);
        consControl.f3285v.init(0, 0);
        funcState.exp2nextreg(expdesc2);
        checknext(123);
        while (true) {
            _assert(consControl.f3285v.f3294k == 0 || consControl.tostore > 0);
            if (this.f3281t.token != 125) {
                funcState.closelistfield(consControl);
                switch (this.f3281t.token) {
                    case 91:
                        recfield(consControl);
                        break;
                    case 288:
                        lookahead();
                        if (this.lookahead.token == 61) {
                            recfield(consControl);
                            break;
                        } else {
                            listfield(consControl);
                            break;
                        }
                    default:
                        listfield(consControl);
                        break;
                }
                if (testnext(44) || testnext(59)) {
                }
            }
        }
        check_match(125, 123, i);
        funcState.lastlistfield(consControl);
        InstructionPtr instructionPtr = new InstructionPtr(funcState.f3271f.code, codeABC);
        SETARG_B(instructionPtr, luaO_int2fb(consControl.f3288na));
        SETARG_C(instructionPtr, luaO_int2fb(consControl.f3287nh));
    }

    static int luaO_int2fb(int i) {
        int i2 = 0;
        while (i >= 16) {
            i = (i + 1) >> 1;
            i2++;
        }
        return i < 8 ? i : ((i2 + 1) << 3) | (i - 8);
    }

    void parlist() {
        FuncState funcState = this.f3282fs;
        Prototype prototype = funcState.f3271f;
        int i = 0;
        prototype.is_vararg = 0;
        if (this.f3281t.token != 41) {
            do {
                switch (this.f3281t.token) {
                    case 280:
                        next();
                        prototype.is_vararg = 1;
                        break;
                    case 288:
                        new_localvar(str_checkname());
                        i++;
                        break;
                    default:
                        syntaxerror(new StringBuffer().append("<name> or ").append(LUA_QL("...")).append(" expected").toString());
                        break;
                }
                if (prototype.is_vararg == 0) {
                }
            } while (testnext(44));
        }
        adjustlocalvars(i);
        prototype.numparams = funcState.nactvar;
        funcState.reserveregs(funcState.nactvar);
    }

    void body(expdesc expdesc2, boolean z, int i) {
        FuncState funcState = new FuncState();
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        funcState.f3271f = addprototype();
        funcState.f3271f.linedefined = i;
        open_func(funcState, blockCnt);
        checknext(40);
        if (z) {
            new_localvarliteral("self");
            adjustlocalvars(1);
        }
        parlist();
        checknext(41);
        statlist();
        funcState.f3271f.lastlinedefined = this.linenumber;
        check_match(262, 265, i);
        codeclosure(expdesc2);
        close_func();
    }

    int explist(expdesc expdesc2) {
        int i = 1;
        expr(expdesc2);
        while (testnext(44)) {
            this.f3282fs.exp2nextreg(expdesc2);
            expr(expdesc2);
            i++;
        }
        return i;
    }

    void funcargs(expdesc expdesc2, int i) {
        int i2;
        FuncState funcState = this.f3282fs;
        expdesc expdesc3 = new expdesc();
        switch (this.f3281t.token) {
            case 40:
                next();
                if (this.f3281t.token == 41) {
                    expdesc3.f3294k = 0;
                } else {
                    explist(expdesc3);
                    funcState.setmultret(expdesc3);
                }
                check_match(41, 40, i);
                break;
            case 123:
                constructor(expdesc3);
                break;
            case 289:
                codestring(expdesc3, this.f3281t.seminfo.f3293ts);
                next();
                break;
            default:
                syntaxerror("function arguments expected");
                return;
        }
        _assert(expdesc2.f3294k == 6);
        int i3 = expdesc2.f3295u.info;
        if (hasmultret(expdesc3.f3294k)) {
            i2 = -1;
        } else {
            if (expdesc3.f3294k != 0) {
                funcState.exp2nextreg(expdesc3);
            }
            i2 = funcState.freereg - (i3 + 1);
        }
        expdesc2.init(12, funcState.codeABC(29, i3, i2 + 1, 2));
        funcState.fixline(i);
        funcState.freereg = (short) (i3 + 1);
    }

    void primaryexp(expdesc expdesc2) {
        switch (this.f3281t.token) {
            case 40:
                int i = this.linenumber;
                next();
                expr(expdesc2);
                check_match(41, 40, i);
                this.f3282fs.dischargevars(expdesc2);
                return;
            case 288:
                singlevar(expdesc2);
                return;
            default:
                syntaxerror(new StringBuffer().append("unexpected symbol ").append(this.f3281t.token).append(" (").append((char) this.f3281t.token).append(")").toString());
                return;
        }
    }

    void suffixedexp(expdesc expdesc2) {
        int i = this.linenumber;
        primaryexp(expdesc2);
        while (true) {
            switch (this.f3281t.token) {
                case 40:
                case 123:
                case 289:
                    this.f3282fs.exp2nextreg(expdesc2);
                    funcargs(expdesc2, i);
                    break;
                case 46:
                    fieldsel(expdesc2);
                    break;
                case 58:
                    expdesc expdesc3 = new expdesc();
                    next();
                    checkname(expdesc3);
                    this.f3282fs.self(expdesc2, expdesc3);
                    funcargs(expdesc2, i);
                    break;
                case 91:
                    expdesc expdesc4 = new expdesc();
                    this.f3282fs.exp2anyregup(expdesc2);
                    yindex(expdesc4);
                    this.f3282fs.indexed(expdesc2, expdesc4);
                    break;
                default:
                    return;
            }
        }
    }

    void simpleexp(expdesc expdesc2) {
        switch (this.f3281t.token) {
            case 123:
                constructor(expdesc2);
                return;
            case 263:
                expdesc2.init(3, 0);
                break;
            case 265:
                next();
                body(expdesc2, false, this.linenumber);
                return;
            case 270:
                expdesc2.init(1, 0);
                break;
            case 276:
                expdesc2.init(2, 0);
                break;
            case 280:
                FuncState funcState = this.f3282fs;
                check_condition(funcState.f3271f.is_vararg != 0, new StringBuffer().append("cannot use ").append(LUA_QL("...")).append(" outside a vararg function").toString());
                expdesc2.init(13, funcState.codeABC(38, 0, 1, 0));
                break;
            case 287:
                expdesc2.init(5, 0);
                expdesc2.f3295u.setNval(this.f3281t.seminfo.f3292r);
                break;
            case 289:
                codestring(expdesc2, this.f3281t.seminfo.f3293ts);
                break;
            default:
                suffixedexp(expdesc2);
                return;
        }
        next();
    }

    int getunopr(int i) {
        switch (i) {
            case 35:
                return 2;
            case 45:
                return 0;
            case 271:
                return 1;
            default:
                return 3;
        }
    }

    int getbinopr(int i) {
        switch (i) {
            case 37:
                return 4;
            case 42:
                return 2;
            case 43:
                return 0;
            case 45:
                return 1;
            case 47:
                return 3;
            case 60:
                return 9;
            case 62:
                return 11;
            case 94:
                return 5;
            case PacketOpcodes.CutSceneFinishNotify:
                return 13;
            case 272:
                return 14;
            case 279:
                return 6;
            case 281:
                return 8;
            case 282:
                return 12;
            case 283:
                return 10;
            case 284:
                return 7;
            default:
                return 15;
        }
    }

    int subexpr(expdesc expdesc2, int i) {
        enterlevel();
        int i2 = getunopr(this.f3281t.token);
        if (i2 != 3) {
            int i3 = this.linenumber;
            next();
            subexpr(expdesc2, 8);
            this.f3282fs.prefix(i2, expdesc2, i3);
        } else {
            simpleexp(expdesc2);
        }
        int i4 = getbinopr(this.f3281t.token);
        while (i4 != 15 && priority[i4].left > i) {
            expdesc expdesc3 = new expdesc();
            int i5 = this.linenumber;
            next();
            this.f3282fs.infix(i4, expdesc2);
            i4 = subexpr(expdesc3, priority[i4].right);
            this.f3282fs.posfix(i4, expdesc2, expdesc3, i5);
        }
        leavelevel();
        return i4;
    }

    void expr(expdesc expdesc2) {
        subexpr(expdesc2, 0);
    }

    boolean block_follow(boolean z) {
        switch (this.f3281t.token) {
            case 260:
            case 261:
            case 262:
            case 286:
                return true;
            case 277:
                return z;
            default:
                return false;
        }
    }

    void block() {
        FuncState funcState = this.f3282fs;
        funcState.enterblock(new FuncState.BlockCnt(), false);
        statlist();
        funcState.leaveblock();
    }

    void check_conflict(LHS_assign lHS_assign, expdesc expdesc2) {
        FuncState funcState = this.f3282fs;
        short s = funcState.freereg;
        boolean z = false;
        while (lHS_assign != null) {
            if (lHS_assign.f3290v.f3294k == 9) {
                if (lHS_assign.f3290v.f3295u.ind_vt == expdesc2.f3294k && lHS_assign.f3290v.f3295u.ind_t == expdesc2.f3295u.info) {
                    z = true;
                    lHS_assign.f3290v.f3295u.ind_vt = 7;
                    lHS_assign.f3290v.f3295u.ind_t = s;
                }
                if (expdesc2.f3294k == 7 && lHS_assign.f3290v.f3295u.ind_idx == expdesc2.f3295u.info) {
                    z = true;
                    lHS_assign.f3290v.f3295u.ind_idx = s;
                }
            }
            lHS_assign = lHS_assign.prev;
        }
        if (z) {
            funcState.codeABC(expdesc2.f3294k == 7 ? 0 : 5, s, expdesc2.f3295u.info, 0);
            funcState.reserveregs(1);
        }
    }

    void assignment(LHS_assign lHS_assign, int i) {
        expdesc expdesc2 = new expdesc();
        check_condition(7 <= lHS_assign.f3290v.f3294k && lHS_assign.f3290v.f3294k <= 9, "syntax error");
        if (testnext(44)) {
            LHS_assign lHS_assign2 = new LHS_assign();
            lHS_assign2.prev = lHS_assign;
            suffixedexp(lHS_assign2.f3290v);
            if (lHS_assign2.f3290v.f3294k != 9) {
                check_conflict(lHS_assign, lHS_assign2.f3290v);
            }
            assignment(lHS_assign2, i + 1);
        } else {
            checknext(61);
            int explist = explist(expdesc2);
            if (explist != i) {
                adjust_assign(i, explist, expdesc2);
                if (explist > i) {
                    FuncState funcState = this.f3282fs;
                    funcState.freereg = (short) (funcState.freereg - (explist - i));
                }
            } else {
                this.f3282fs.setoneret(expdesc2);
                this.f3282fs.storevar(lHS_assign.f3290v, expdesc2);
                return;
            }
        }
        expdesc2.init(6, this.f3282fs.freereg - 1);
        this.f3282fs.storevar(lHS_assign.f3290v, expdesc2);
    }

    int cond() {
        expdesc expdesc2 = new expdesc();
        expr(expdesc2);
        if (expdesc2.f3294k == 1) {
            expdesc2.f3294k = 3;
        }
        this.f3282fs.goiftrue(expdesc2);
        return expdesc2.f3297f.f3279i;
    }

    void gotostat(int i) {
        LuaString luaString;
        int i2 = this.linenumber;
        if (testnext(266)) {
            luaString = str_checkname();
        } else {
            next();
            luaString = LuaString.valueOf("break");
        }
        Dyndata dyndata = this.dyd;
        Labeldesc[] grow = grow(this.dyd.f3289gt, this.dyd.n_gt + 1);
        dyndata.f3289gt = grow;
        Dyndata dyndata2 = this.dyd;
        int i3 = dyndata2.n_gt;
        dyndata2.n_gt = i3 + 1;
        findlabel(newlabelentry(grow, i3, luaString, i2, i));
    }

    void skipnoopstat() {
        while (true) {
            if (this.f3281t.token == 59 || this.f3281t.token == 285) {
                statement();
            } else {
                return;
            }
        }
    }

    void labelstat(LuaString luaString, int i) {
        this.f3282fs.checkrepeated(this.dyd.label, this.dyd.n_label, luaString);
        checknext(285);
        Dyndata dyndata = this.dyd;
        Labeldesc[] grow = grow(this.dyd.label, this.dyd.n_label + 1);
        dyndata.label = grow;
        Dyndata dyndata2 = this.dyd;
        int i2 = dyndata2.n_label;
        dyndata2.n_label = i2 + 1;
        int newlabelentry = newlabelentry(grow, i2, luaString, i, this.f3282fs.f3276pc);
        skipnoopstat();
        if (block_follow(false)) {
            this.dyd.label[newlabelentry].nactvar = this.f3282fs.f3275bl.nactvar;
        }
        findgotos(this.dyd.label[newlabelentry]);
    }

    void whilestat(int i) {
        FuncState funcState = this.f3282fs;
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        next();
        int i2 = funcState.getlabel();
        int cond = cond();
        funcState.enterblock(blockCnt, true);
        checknext(259);
        block();
        funcState.patchlist(funcState.jump(), i2);
        check_match(262, 278, i);
        funcState.leaveblock();
        funcState.patchtohere(cond);
    }

    void repeatstat(int i) {
        FuncState funcState = this.f3282fs;
        int i2 = funcState.getlabel();
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        FuncState.BlockCnt blockCnt2 = new FuncState.BlockCnt();
        funcState.enterblock(blockCnt, true);
        funcState.enterblock(blockCnt2, false);
        next();
        statlist();
        check_match(277, 273, i);
        int cond = cond();
        if (blockCnt2.upval) {
            funcState.patchclose(cond, blockCnt2.nactvar);
        }
        funcState.leaveblock();
        funcState.patchlist(cond, i2);
        funcState.leaveblock();
    }

    int exp1() {
        expdesc expdesc2 = new expdesc();
        expr(expdesc2);
        int i = expdesc2.f3294k;
        this.f3282fs.exp2nextreg(expdesc2);
        return i;
    }

    void forbody(int i, int i2, int i3, boolean z) {
        int i4;
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        FuncState funcState = this.f3282fs;
        adjustlocalvars(3);
        checknext(259);
        int codeAsBx = z ? funcState.codeAsBx(33, i, -1) : funcState.jump();
        funcState.enterblock(blockCnt, false);
        adjustlocalvars(i3);
        funcState.reserveregs(i3);
        block();
        funcState.leaveblock();
        funcState.patchtohere(codeAsBx);
        if (z) {
            i4 = funcState.codeAsBx(32, i, -1);
        } else {
            funcState.codeABC(34, i, 0, i3);
            funcState.fixline(i2);
            i4 = funcState.codeAsBx(35, i + 2, -1);
        }
        funcState.patchlist(i4, codeAsBx + 1);
        funcState.fixline(i2);
    }

    void fornum(LuaString luaString, int i) {
        FuncState funcState = this.f3282fs;
        short s = funcState.freereg;
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_INDEX);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_LIMIT);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_STEP);
        new_localvar(luaString);
        checknext(61);
        exp1();
        checknext(44);
        exp1();
        if (testnext(44)) {
            exp1();
        } else {
            funcState.codeABx(1, funcState.freereg, funcState.numberK(LuaInteger.valueOf(1)));
            funcState.reserveregs(1);
        }
        forbody(s, i, 1, true);
    }

    void forlist(LuaString luaString) {
        FuncState funcState = this.f3282fs;
        expdesc expdesc2 = new expdesc();
        int i = 4;
        short s = funcState.freereg;
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_GENERATOR);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_STATE);
        new_localvarliteral(RESERVED_LOCAL_VAR_FOR_CONTROL);
        new_localvar(luaString);
        while (testnext(44)) {
            new_localvar(str_checkname());
            i++;
        }
        checknext(268);
        int i2 = this.linenumber;
        adjust_assign(3, explist(expdesc2), expdesc2);
        funcState.checkstack(3);
        forbody(s, i2, i - 3, false);
    }

    void forstat(int i) {
        FuncState funcState = this.f3282fs;
        funcState.enterblock(new FuncState.BlockCnt(), true);
        next();
        LuaString str_checkname = str_checkname();
        switch (this.f3281t.token) {
            case 44:
            case 268:
                forlist(str_checkname);
                break;
            case 61:
                fornum(str_checkname, i);
                break;
            default:
                syntaxerror(new StringBuffer().append(LUA_QL("=")).append(" or ").append(LUA_QL("in")).append(" expected").toString());
                break;
        }
        check_match(262, 264, i);
        funcState.leaveblock();
    }

    void test_then_block(IntPtr intPtr) {
        int i;
        expdesc expdesc2 = new expdesc();
        FuncState.BlockCnt blockCnt = new FuncState.BlockCnt();
        next();
        expr(expdesc2);
        checknext(275);
        if (this.f3281t.token == 266 || this.f3281t.token == 258) {
            this.f3282fs.goiffalse(expdesc2);
            this.f3282fs.enterblock(blockCnt, false);
            gotostat(expdesc2.f3296t.f3279i);
            skipnoopstat();
            if (block_follow(false)) {
                this.f3282fs.leaveblock();
                return;
            }
            i = this.f3282fs.jump();
        } else {
            this.f3282fs.goiftrue(expdesc2);
            this.f3282fs.enterblock(blockCnt, false);
            i = expdesc2.f3297f.f3279i;
        }
        statlist();
        this.f3282fs.leaveblock();
        if (this.f3281t.token == 260 || this.f3281t.token == 261) {
            this.f3282fs.concat(intPtr, this.f3282fs.jump());
        }
        this.f3282fs.patchtohere(i);
    }

    void ifstat(int i) {
        IntPtr intPtr = new IntPtr(-1);
        test_then_block(intPtr);
        while (this.f3281t.token == 261) {
            test_then_block(intPtr);
        }
        if (testnext(260)) {
            block();
        }
        check_match(262, 267, i);
        this.f3282fs.patchtohere(intPtr.f3279i);
    }

    void localfunc() {
        expdesc expdesc2 = new expdesc();
        FuncState funcState = this.f3282fs;
        new_localvar(str_checkname());
        adjustlocalvars(1);
        body(expdesc2, false, this.linenumber);
        funcState.getlocvar(funcState.nactvar - 1).startpc = funcState.f3276pc;
    }

    void localstat() {
        int i;
        int i2 = 0;
        expdesc expdesc2 = new expdesc();
        do {
            new_localvar(str_checkname());
            i2++;
        } while (testnext(44));
        if (testnext(61)) {
            i = explist(expdesc2);
        } else {
            expdesc2.f3294k = 0;
            i = 0;
        }
        adjust_assign(i2, i, expdesc2);
        adjustlocalvars(i2);
    }

    boolean funcname(expdesc expdesc2) {
        boolean z = false;
        singlevar(expdesc2);
        while (this.f3281t.token == 46) {
            fieldsel(expdesc2);
        }
        if (this.f3281t.token == 58) {
            z = true;
            fieldsel(expdesc2);
        }
        return z;
    }

    void funcstat(int i) {
        expdesc expdesc2 = new expdesc();
        expdesc expdesc3 = new expdesc();
        next();
        body(expdesc3, funcname(expdesc2), i);
        this.f3282fs.storevar(expdesc2, expdesc3);
        this.f3282fs.fixline(i);
    }

    void exprstat() {
        FuncState funcState = this.f3282fs;
        LHS_assign lHS_assign = new LHS_assign();
        suffixedexp(lHS_assign.f3290v);
        if (this.f3281t.token == 61 || this.f3281t.token == 44) {
            lHS_assign.prev = null;
            assignment(lHS_assign, 1);
            return;
        }
        check_condition(lHS_assign.f3290v.f3294k == 12, "syntax error");
        SETARG_C(funcState.getcodePtr(lHS_assign.f3290v), 1);
    }

    void retstat() {
        int i;
        int i2;
        FuncState funcState = this.f3282fs;
        expdesc expdesc2 = new expdesc();
        if (block_follow(true) || this.f3281t.token == 59) {
            i = 0;
            i2 = 0;
        } else {
            i = explist(expdesc2);
            if (hasmultret(expdesc2.f3294k)) {
                funcState.setmultret(expdesc2);
                if (expdesc2.f3294k == 12 && i == 1) {
                    SET_OPCODE(funcState.getcodePtr(expdesc2), 30);
                    _assert(Lua.GETARG_A(funcState.getcode(expdesc2)) == funcState.nactvar);
                }
                i2 = funcState.nactvar;
                i = -1;
            } else if (i == 1) {
                i2 = funcState.exp2anyreg(expdesc2);
            } else {
                funcState.exp2nextreg(expdesc2);
                i2 = funcState.nactvar;
                _assert(i == funcState.freereg - i2);
            }
        }
        funcState.ret(i2, i);
        testnext(59);
    }

    void statement() {
        int i = this.linenumber;
        enterlevel();
        switch (this.f3281t.token) {
            case 59:
                next();
                break;
            case 258:
            case 266:
                gotostat(this.f3282fs.jump());
                break;
            case 259:
                next();
                block();
                check_match(262, 259, i);
                break;
            case 264:
                forstat(i);
                break;
            case 265:
                funcstat(i);
                break;
            case 267:
                ifstat(i);
                break;
            case 269:
                next();
                if (!testnext(265)) {
                    localstat();
                    break;
                } else {
                    localfunc();
                    break;
                }
            case 273:
                repeatstat(i);
                break;
            case 274:
                next();
                retstat();
                break;
            case 278:
                whilestat(i);
                break;
            case 285:
                next();
                labelstat(str_checkname(), i);
                break;
            default:
                exprstat();
                break;
        }
        _assert(this.f3282fs.f3271f.maxstacksize >= this.f3282fs.freereg && this.f3282fs.freereg >= this.f3282fs.nactvar);
        this.f3282fs.freereg = this.f3282fs.nactvar;
        leavelevel();
    }

    void statlist() {
        while (!block_follow(true)) {
            if (this.f3281t.token == 274) {
                statement();
                return;
            }
            statement();
        }
    }

    public void mainfunc(FuncState funcState) {
        open_func(funcState, new FuncState.BlockCnt());
        this.f3282fs.f3271f.is_vararg = 1;
        expdesc expdesc2 = new expdesc();
        expdesc2.init(7, 0);
        this.f3282fs.newupvalue(this.envn, expdesc2);
        next();
        statlist();
        check(286);
        close_func();
    }

    static {
        for (int i = 0; i < RESERVED_LOCAL_VAR_KEYWORDS.length; i++) {
            RESERVED_LOCAL_VAR_KEYWORDS_TABLE.put(RESERVED_LOCAL_VAR_KEYWORDS[i], Boolean.TRUE);
        }
        luaX_tokens = new String[]{"and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "repeat", "return", "then", C3P0Substitutions.DEBUG, "until", "while", CallerDataConverter.DEFAULT_RANGE_DELIMITER, "...", "==", ">=", "<=", "~=", "::", "<eos>", "<number>", "<name>", "<string>", "<eof>"};
        RESERVED = new Hashtable();
        for (int i2 = 0; i2 < 22; i2++) {
            RESERVED.put(LuaValue.valueOf(luaX_tokens[i2]), new Integer(PacketOpcodes.CutSceneFinishNotify + i2));
        }
        priority = new Priority[]{new Priority(6, 6), new Priority(6, 6), new Priority(7, 7), new Priority(7, 7), new Priority(7, 7), new Priority(10, 9), new Priority(5, 4), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(3, 3), new Priority(2, 2), new Priority(1, 1)};
    }
}
