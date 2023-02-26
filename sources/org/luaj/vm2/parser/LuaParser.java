package org.luaj.vm2.parser;

import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.ast.Block;
import org.luaj.vm2.ast.Chunk;
import org.luaj.vm2.ast.Exp;
import org.luaj.vm2.ast.FuncArgs;
import org.luaj.vm2.ast.FuncBody;
import org.luaj.vm2.ast.FuncName;
import org.luaj.vm2.ast.Name;
import org.luaj.vm2.ast.ParList;
import org.luaj.vm2.ast.Stat;
import org.luaj.vm2.ast.Str;
import org.luaj.vm2.ast.SyntaxElement;
import org.luaj.vm2.ast.TableConstructor;
import org.luaj.vm2.ast.TableField;

/* loaded from: grasscutter.jar:org/luaj/vm2/parser/LuaParser.class */
public class LuaParser implements LuaParserConstants {
    public LuaParserTokenManager token_source;
    SimpleCharStream jj_input_stream;
    public Token token;
    public Token jj_nt;
    private int jj_ntk;
    private Token jj_scanpos;
    private Token jj_lastpos;
    private int jj_la;
    private int jj_gen;
    private final int[] jj_la1;
    private static int[] jj_la1_0;
    private static int[] jj_la1_1;
    private static int[] jj_la1_2;
    private final JJCalls[] jj_2_rtns;
    private boolean jj_rescan;
    private int jj_gc;
    private final LookaheadSuccess jj_ls;
    private List jj_expentries;
    private int[] jj_expentry;
    private int jj_kind;
    private int[] jj_lasttokens;
    private int jj_endpos;

    /* renamed from: org.luaj.vm2.parser.LuaParser$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/parser/LuaParser$1.class */
    static class C58741 {
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/parser/LuaParser$JJCalls.class */
    public static final class JJCalls {
        int gen;
        Token first;
        int arg;
        JJCalls next;

        JJCalls() {
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/parser/LuaParser$LookaheadSuccess.class */
    public static final class LookaheadSuccess extends Error {
        private LookaheadSuccess() {
        }

        LookaheadSuccess(C58741 r3) {
            this();
        }
    }

    public static void main(String[] strArr) throws ParseException {
        new LuaParser(System.in).Chunk();
    }

    private static Exp.VarExp assertvarexp(Exp.PrimaryExp primaryExp) throws ParseException {
        if (primaryExp.isvarexp()) {
            return (Exp.VarExp) primaryExp;
        }
        throw new ParseException("expected variable");
    }

    private static Exp.FuncCall assertfunccall(Exp.PrimaryExp primaryExp) throws ParseException {
        if (primaryExp.isfunccall()) {
            return (Exp.FuncCall) primaryExp;
        }
        throw new ParseException("expected function call");
    }

    public SimpleCharStream getCharStream() {
        return this.jj_input_stream;
    }

    private long LineInfo() {
        return (((long) this.jj_input_stream.getBeginLine()) << 32) | ((long) this.jj_input_stream.getBeginColumn());
    }

    /* renamed from: L */
    private void m15L(SyntaxElement syntaxElement, long j) {
        syntaxElement.beginLine = (int) (j >> 32);
        syntaxElement.beginColumn = (short) ((int) j);
        syntaxElement.endLine = this.token.endLine;
        syntaxElement.endColumn = (short) this.token.endColumn;
    }

    /* renamed from: L */
    private void m14L(SyntaxElement syntaxElement, Token token) {
        syntaxElement.beginLine = token.beginLine;
        syntaxElement.beginColumn = (short) token.beginColumn;
        syntaxElement.endLine = this.token.endLine;
        syntaxElement.endColumn = (short) this.token.endColumn;
    }

    public final Chunk Chunk() throws ParseException {
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 69:
                jj_consume_token(69);
                this.token_source.SwitchTo(1);
                break;
            default:
                this.jj_la1[0] = this.jj_gen;
                break;
        }
        Block Block = Block();
        jj_consume_token(0);
        Chunk chunk = new Chunk(Block);
        m15L(chunk, LineInfo);
        return chunk;
    }

    public final Block Block() throws ParseException {
        Block block = new Block();
        long LineInfo = LineInfo();
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 30:
                case 31:
                case 36:
                case 37:
                case 38:
                case 39:
                case 41:
                case 46:
                case 50:
                case 51:
                case 65:
                case 70:
                case 75:
                    block.add(Stat());
                case 32:
                case 33:
                case 34:
                case 35:
                case 40:
                case 42:
                case 43:
                case 44:
                case 45:
                case 47:
                case 48:
                case 49:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 66:
                case 67:
                case 68:
                case 69:
                case 71:
                case 72:
                case 73:
                case 74:
                default:
                    this.jj_la1[1] = this.jj_gen;
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 45:
                            block.add(ReturnStat());
                            break;
                        default:
                            this.jj_la1[2] = this.jj_gen;
                            break;
                    }
                    m15L(block, LineInfo);
                    return block;
            }
        }
    }

    public final Stat Stat() throws ParseException {
        Exp exp = null;
        List list = null;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 30:
                jj_consume_token(30);
                Stat breakstat = Stat.breakstat();
                m15L(breakstat, LineInfo);
                return breakstat;
            case 31:
                jj_consume_token(31);
                Block Block = Block();
                jj_consume_token(34);
                Stat block = Stat.block(Block);
                m15L(block, LineInfo);
                return block;
            case 38:
                jj_consume_token(38);
                Stat gotostat = Stat.gotostat(jj_consume_token(51).image);
                m15L(gotostat, LineInfo);
                return gotostat;
            case 39:
                Stat IfThenElse = IfThenElse();
                m15L(IfThenElse, LineInfo);
                return IfThenElse;
            case 46:
                jj_consume_token(46);
                Block Block2 = Block();
                jj_consume_token(49);
                Stat repeatuntil = Stat.repeatuntil(Block2, Exp());
                m15L(repeatuntil, LineInfo);
                return repeatuntil;
            case 50:
                jj_consume_token(50);
                Exp Exp = Exp();
                jj_consume_token(31);
                Block Block3 = Block();
                jj_consume_token(34);
                Stat whiledo = Stat.whiledo(Exp, Block3);
                m15L(whiledo, LineInfo);
                return whiledo;
            case 65:
                Stat Label = Label();
                m15L(Label, LineInfo);
                return Label;
            case 70:
                jj_consume_token(70);
                return null;
            default:
                this.jj_la1[5] = this.jj_gen;
                if (jj_2_1(3)) {
                    jj_consume_token(36);
                    Token jj_consume_token = jj_consume_token(51);
                    jj_consume_token(71);
                    Exp Exp2 = Exp();
                    jj_consume_token(72);
                    Exp Exp3 = Exp();
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 72:
                            jj_consume_token(72);
                            exp = Exp();
                            break;
                        default:
                            this.jj_la1[3] = this.jj_gen;
                            break;
                    }
                    jj_consume_token(31);
                    Block Block4 = Block();
                    jj_consume_token(34);
                    Stat fornumeric = Stat.fornumeric(jj_consume_token.image, Exp2, Exp3, exp, Block4);
                    m15L(fornumeric, LineInfo);
                    return fornumeric;
                }
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 36:
                        jj_consume_token(36);
                        List NameList = NameList();
                        jj_consume_token(40);
                        List ExpList = ExpList();
                        jj_consume_token(31);
                        Block Block5 = Block();
                        jj_consume_token(34);
                        Stat forgeneric = Stat.forgeneric(NameList, ExpList, Block5);
                        m15L(forgeneric, LineInfo);
                        return forgeneric;
                    case 37:
                        jj_consume_token(37);
                        Stat functiondef = Stat.functiondef(FuncName(), FuncBody());
                        m15L(functiondef, LineInfo);
                        return functiondef;
                    default:
                        this.jj_la1[6] = this.jj_gen;
                        if (jj_2_2(2)) {
                            jj_consume_token(41);
                            jj_consume_token(37);
                            Stat localfunctiondef = Stat.localfunctiondef(jj_consume_token(51).image, FuncBody());
                            m15L(localfunctiondef, LineInfo);
                            return localfunctiondef;
                        }
                        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                            case 41:
                                jj_consume_token(41);
                                List NameList2 = NameList();
                                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                                    case 71:
                                        jj_consume_token(71);
                                        list = ExpList();
                                        break;
                                    default:
                                        this.jj_la1[4] = this.jj_gen;
                                        break;
                                }
                                Stat localassignment = Stat.localassignment(NameList2, list);
                                m15L(localassignment, LineInfo);
                                return localassignment;
                            case 51:
                            case 75:
                                Stat ExprStat = ExprStat();
                                m15L(ExprStat, LineInfo);
                                return ExprStat;
                            default:
                                this.jj_la1[7] = this.jj_gen;
                                jj_consume_token(-1);
                                throw new ParseException();
                        }
                }
        }
    }

    public final Stat IfThenElse() throws ParseException {
        Block block = null;
        ArrayList arrayList = null;
        ArrayList arrayList2 = null;
        jj_consume_token(39);
        Exp Exp = Exp();
        jj_consume_token(47);
        Block Block = Block();
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 33:
                    jj_consume_token(33);
                    Exp Exp2 = Exp();
                    jj_consume_token(47);
                    Block Block2 = Block();
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                    }
                    arrayList.add(Exp2);
                    arrayList2.add(Block2);
                default:
                    this.jj_la1[8] = this.jj_gen;
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 32:
                            jj_consume_token(32);
                            block = Block();
                            break;
                        default:
                            this.jj_la1[9] = this.jj_gen;
                            break;
                    }
                    jj_consume_token(34);
                    return Stat.ifthenelse(Exp, Block, arrayList, arrayList2, block);
            }
        }
    }

    public final Stat ReturnStat() throws ParseException {
        List list = null;
        long LineInfo = LineInfo();
        jj_consume_token(45);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 35:
            case 37:
            case 42:
            case 43:
            case 48:
            case 51:
            case 52:
            case 61:
            case 62:
            case 69:
            case 75:
            case 79:
            case 80:
            case 83:
                list = ExpList();
                break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 45:
            case 46:
            case 47:
            case 49:
            case 50:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 81:
            case 82:
            default:
                this.jj_la1[10] = this.jj_gen;
                break;
        }
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 70:
                jj_consume_token(70);
                break;
            default:
                this.jj_la1[11] = this.jj_gen;
                break;
        }
        Stat returnstat = Stat.returnstat(list);
        m15L(returnstat, LineInfo);
        return returnstat;
    }

    public final Stat Label() throws ParseException {
        jj_consume_token(65);
        Token jj_consume_token = jj_consume_token(51);
        jj_consume_token(65);
        return Stat.labelstat(jj_consume_token.image);
    }

    public final Stat ExprStat() throws ParseException {
        Stat stat = null;
        long LineInfo = LineInfo();
        Exp.PrimaryExp PrimaryExp = PrimaryExp();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 71:
            case 72:
                stat = Assign(assertvarexp(PrimaryExp));
                break;
            default:
                this.jj_la1[12] = this.jj_gen;
                break;
        }
        if (stat == null) {
            stat = Stat.functioncall(assertfunccall(PrimaryExp));
        }
        m15L(stat, LineInfo);
        return stat;
    }

    public final Stat Assign(Exp.VarExp varExp) throws ParseException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(varExp);
        long LineInfo = LineInfo();
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 72:
                    jj_consume_token(72);
                    arrayList.add(VarExp());
                default:
                    this.jj_la1[13] = this.jj_gen;
                    jj_consume_token(71);
                    Stat assignment = Stat.assignment(arrayList, ExpList());
                    m15L(assignment, LineInfo);
                    return assignment;
            }
        }
    }

    public final Exp.VarExp VarExp() throws ParseException {
        return assertvarexp(PrimaryExp());
    }

    public final FuncName FuncName() throws ParseException {
        Token jj_consume_token = jj_consume_token(51);
        FuncName funcName = new FuncName(jj_consume_token.image);
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 73:
                    jj_consume_token(73);
                    jj_consume_token = jj_consume_token(51);
                    funcName.adddot(jj_consume_token.image);
                default:
                    this.jj_la1[14] = this.jj_gen;
                    switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                        case 74:
                            jj_consume_token(74);
                            jj_consume_token = jj_consume_token(51);
                            funcName.method = jj_consume_token.image;
                            break;
                        default:
                            this.jj_la1[15] = this.jj_gen;
                            break;
                    }
                    m14L(funcName, jj_consume_token);
                    return funcName;
            }
        }
    }

    public final Exp.PrimaryExp PrefixExp() throws ParseException {
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 51:
                Exp.NameExp nameprefix = Exp.nameprefix(jj_consume_token(51).image);
                m15L(nameprefix, LineInfo);
                return nameprefix;
            case 75:
                jj_consume_token(75);
                Exp Exp = Exp();
                jj_consume_token(76);
                Exp.ParensExp parensprefix = Exp.parensprefix(Exp);
                m15L(parensprefix, LineInfo);
                return parensprefix;
            default:
                this.jj_la1[16] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final Exp.PrimaryExp PrimaryExp() throws ParseException {
        long LineInfo = LineInfo();
        Exp.PrimaryExp PrefixExp = PrefixExp();
        while (jj_2_3(2)) {
            PrefixExp = PostfixOp(PrefixExp);
        }
        m15L(PrefixExp, LineInfo);
        return PrefixExp;
    }

    public final Exp.PrimaryExp PostfixOp(Exp.PrimaryExp primaryExp) throws ParseException {
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 61:
            case 62:
            case 75:
            case 80:
                Exp.FuncCall functionop = Exp.functionop(primaryExp, FuncArgs());
                m15L(functionop, LineInfo);
                return functionop;
            case 73:
                jj_consume_token(73);
                Exp.FieldExp fieldop = Exp.fieldop(primaryExp, jj_consume_token(51).image);
                m15L(fieldop, LineInfo);
                return fieldop;
            case 74:
                jj_consume_token(74);
                Exp.MethodCall methodop = Exp.methodop(primaryExp, jj_consume_token(51).image, FuncArgs());
                m15L(methodop, LineInfo);
                return methodop;
            case 77:
                jj_consume_token(77);
                Exp Exp = Exp();
                jj_consume_token(78);
                Exp.IndexExp indexop = Exp.indexop(primaryExp, Exp);
                m15L(indexop, LineInfo);
                return indexop;
            default:
                this.jj_la1[17] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final FuncArgs FuncArgs() throws ParseException {
        List list = null;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 61:
            case 62:
                FuncArgs string = FuncArgs.string(Str());
                m15L(string, LineInfo);
                return string;
            case 75:
                jj_consume_token(75);
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 35:
                    case 37:
                    case 42:
                    case 43:
                    case 48:
                    case 51:
                    case 52:
                    case 61:
                    case 62:
                    case 69:
                    case 75:
                    case 79:
                    case 80:
                    case 83:
                        list = ExpList();
                        break;
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 36:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 49:
                    case 50:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 76:
                    case 77:
                    case 78:
                    case 81:
                    case 82:
                    default:
                        this.jj_la1[18] = this.jj_gen;
                        break;
                }
                jj_consume_token(76);
                FuncArgs explist = FuncArgs.explist(list);
                m15L(explist, LineInfo);
                return explist;
            case 80:
                FuncArgs tableconstructor = FuncArgs.tableconstructor(TableConstructor());
                m15L(tableconstructor, LineInfo);
                return tableconstructor;
            default:
                this.jj_la1[19] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final List NameList() throws ParseException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Name(jj_consume_token(51).image));
        while (jj_2_4(2)) {
            jj_consume_token(72);
            arrayList.add(new Name(jj_consume_token(51).image));
        }
        return arrayList;
    }

    public final List ExpList() throws ParseException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Exp());
        while (true) {
            switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                case 72:
                    jj_consume_token(72);
                    arrayList.add(Exp());
                default:
                    this.jj_la1[20] = this.jj_gen;
                    return arrayList;
            }
        }
    }

    public final Exp SimpleExp() throws ParseException {
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 61:
            case 62:
                Exp constant = Exp.constant(Str());
                m15L(constant, LineInfo);
                return constant;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 39:
            case 40:
            case 41:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 49:
            case 50:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 69:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            default:
                this.jj_la1[21] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            case 35:
                jj_consume_token(35);
                Exp constant2 = Exp.constant(LuaValue.FALSE);
                m15L(constant2, LineInfo);
                return constant2;
            case 37:
                Exp anonymousfunction = Exp.anonymousfunction(FunctionCall());
                m15L(anonymousfunction, LineInfo);
                return anonymousfunction;
            case 42:
                jj_consume_token(42);
                Exp constant3 = Exp.constant(LuaValue.NIL);
                m15L(constant3, LineInfo);
                return constant3;
            case 48:
                jj_consume_token(48);
                Exp constant4 = Exp.constant(LuaValue.TRUE);
                m15L(constant4, LineInfo);
                return constant4;
            case 51:
            case 75:
                return PrimaryExp();
            case 52:
                Exp numberconstant = Exp.numberconstant(jj_consume_token(52).image);
                m15L(numberconstant, LineInfo);
                return numberconstant;
            case 79:
                jj_consume_token(79);
                Exp varargs = Exp.varargs();
                m15L(varargs, LineInfo);
                return varargs;
            case 80:
                Exp tableconstructor = Exp.tableconstructor(TableConstructor());
                m15L(tableconstructor, LineInfo);
                return tableconstructor;
        }
    }

    public final LuaString Str() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
                jj_consume_token(23);
                return Str.longString(this.token.image);
            case 24:
                jj_consume_token(24);
                return Str.longString(this.token.image);
            case 25:
                jj_consume_token(25);
                return Str.longString(this.token.image);
            case 26:
                jj_consume_token(26);
                return Str.longString(this.token.image);
            case 27:
                jj_consume_token(27);
                return Str.longString(this.token.image);
            case 61:
                jj_consume_token(61);
                return Str.quoteString(this.token.image);
            case 62:
                jj_consume_token(62);
                return Str.charString(this.token.image);
            default:
                this.jj_la1[22] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final Exp Exp() throws ParseException {
        Exp exp;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 35:
            case 37:
            case 42:
            case 48:
            case 51:
            case 52:
            case 61:
            case 62:
            case 75:
            case 79:
            case 80:
                exp = SimpleExp();
                break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 45:
            case 46:
            case 47:
            case 49:
            case 50:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 76:
            case 77:
            case 78:
            case 81:
            case 82:
            default:
                this.jj_la1[23] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
            case 43:
            case 69:
            case 83:
                exp = Exp.unaryexp(Unop(), Exp());
                break;
        }
        while (jj_2_5(2)) {
            exp = Exp.binaryexp(exp, Binop(), Exp());
        }
        m15L(exp, LineInfo);
        return exp;
    }

    public final FuncBody FunctionCall() throws ParseException {
        long LineInfo = LineInfo();
        jj_consume_token(37);
        FuncBody FuncBody = FuncBody();
        m15L(FuncBody, LineInfo);
        return FuncBody;
    }

    public final FuncBody FuncBody() throws ParseException {
        ParList parList = null;
        long LineInfo = LineInfo();
        jj_consume_token(75);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 51:
            case 79:
                parList = ParList();
                break;
            default:
                this.jj_la1[24] = this.jj_gen;
                break;
        }
        jj_consume_token(76);
        Block Block = Block();
        jj_consume_token(34);
        FuncBody funcBody = new FuncBody(parList, Block);
        m15L(funcBody, LineInfo);
        return funcBody;
    }

    public final ParList ParList() throws ParseException {
        boolean z = false;
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 51:
                List NameList = NameList();
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 72:
                        jj_consume_token(72);
                        jj_consume_token(79);
                        z = true;
                        break;
                    default:
                        this.jj_la1[25] = this.jj_gen;
                        break;
                }
                ParList parList = new ParList(NameList, z);
                m15L(parList, LineInfo);
                return parList;
            case 79:
                jj_consume_token(79);
                ParList parList2 = new ParList(null, true);
                m15L(parList2, LineInfo);
                return parList2;
            default:
                this.jj_la1[26] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final TableConstructor TableConstructor() throws ParseException {
        TableConstructor tableConstructor = new TableConstructor();
        long LineInfo = LineInfo();
        jj_consume_token(80);
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 35:
            case 37:
            case 42:
            case 43:
            case 48:
            case 51:
            case 52:
            case 61:
            case 62:
            case 69:
            case 75:
            case 77:
            case 79:
            case 80:
            case 83:
                tableConstructor.fields = FieldList();
                break;
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 36:
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 45:
            case 46:
            case 47:
            case 49:
            case 50:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            case 59:
            case 60:
            case 63:
            case 64:
            case 65:
            case 66:
            case 67:
            case 68:
            case 70:
            case 71:
            case 72:
            case 73:
            case 74:
            case 76:
            case 78:
            case 81:
            case 82:
            default:
                this.jj_la1[27] = this.jj_gen;
                break;
        }
        jj_consume_token(81);
        m15L(tableConstructor, LineInfo);
        return tableConstructor;
    }

    public final List FieldList() throws ParseException {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Field());
        while (jj_2_6(2)) {
            FieldSep();
            arrayList.add(Field());
        }
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 70:
            case 72:
                FieldSep();
                break;
            default:
                this.jj_la1[28] = this.jj_gen;
                break;
        }
        return arrayList;
    }

    public final TableField Field() throws ParseException {
        long LineInfo = LineInfo();
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 77:
                jj_consume_token(77);
                Exp Exp = Exp();
                jj_consume_token(78);
                jj_consume_token(71);
                TableField keyedField = TableField.keyedField(Exp, Exp());
                m15L(keyedField, LineInfo);
                return keyedField;
            default:
                this.jj_la1[29] = this.jj_gen;
                if (jj_2_7(2)) {
                    Token jj_consume_token = jj_consume_token(51);
                    jj_consume_token(71);
                    TableField namedField = TableField.namedField(jj_consume_token.image, Exp());
                    m15L(namedField, LineInfo);
                    return namedField;
                }
                switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 35:
                    case 37:
                    case 42:
                    case 43:
                    case 48:
                    case 51:
                    case 52:
                    case 61:
                    case 62:
                    case 69:
                    case 75:
                    case 79:
                    case 80:
                    case 83:
                        TableField listField = TableField.listField(Exp());
                        m15L(listField, LineInfo);
                        return listField;
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 36:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 49:
                    case 50:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                    case 60:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                    case 68:
                    case 70:
                    case 71:
                    case 72:
                    case 73:
                    case 74:
                    case 76:
                    case 77:
                    case 78:
                    case 81:
                    case 82:
                    default:
                        this.jj_la1[30] = this.jj_gen;
                        jj_consume_token(-1);
                        throw new ParseException();
                }
        }
    }

    public final void FieldSep() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 70:
                jj_consume_token(70);
                return;
            case 72:
                jj_consume_token(72);
                return;
            default:
                this.jj_la1[31] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final int Binop() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 29:
                jj_consume_token(29);
                return 60;
            case 44:
                jj_consume_token(44);
                return 59;
            case 82:
                jj_consume_token(82);
                return 13;
            case 83:
                jj_consume_token(83);
                return 14;
            case 84:
                jj_consume_token(84);
                return 15;
            case 85:
                jj_consume_token(85);
                return 16;
            case 86:
                jj_consume_token(86);
                return 18;
            case 87:
                jj_consume_token(87);
                return 17;
            case 88:
                jj_consume_token(88);
                return 22;
            case 89:
                jj_consume_token(89);
                return 25;
            case 90:
                jj_consume_token(90);
                return 26;
            case 91:
                jj_consume_token(91);
                return 63;
            case 92:
                jj_consume_token(92);
                return 62;
            case 93:
                jj_consume_token(93);
                return 24;
            case 94:
                jj_consume_token(94);
                return 61;
            default:
                this.jj_la1[32] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    public final int Unop() throws ParseException {
        switch (this.jj_ntk == -1 ? jj_ntk() : this.jj_ntk) {
            case 43:
                jj_consume_token(43);
                return 20;
            case 69:
                jj_consume_token(69);
                return 21;
            case 83:
                jj_consume_token(83);
                return 19;
            default:
                this.jj_la1[33] = this.jj_gen;
                jj_consume_token(-1);
                throw new ParseException();
        }
    }

    private boolean jj_2_1(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_1();
            jj_save(0, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(0, i);
            return true;
        } catch (Throwable th) {
            jj_save(0, i);
            throw th;
        }
    }

    private boolean jj_2_2(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_2();
            jj_save(1, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(1, i);
            return true;
        } catch (Throwable th) {
            jj_save(1, i);
            throw th;
        }
    }

    private boolean jj_2_3(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_3();
            jj_save(2, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(2, i);
            return true;
        } catch (Throwable th) {
            jj_save(2, i);
            throw th;
        }
    }

    private boolean jj_2_4(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_4();
            jj_save(3, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(3, i);
            return true;
        } catch (Throwable th) {
            jj_save(3, i);
            throw th;
        }
    }

    private boolean jj_2_5(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_5();
            jj_save(4, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(4, i);
            return true;
        } catch (Throwable th) {
            jj_save(4, i);
            throw th;
        }
    }

    private boolean jj_2_6(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_6();
            jj_save(5, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(5, i);
            return true;
        } catch (Throwable th) {
            jj_save(5, i);
            throw th;
        }
    }

    private boolean jj_2_7(int i) {
        this.jj_la = i;
        Token token = this.token;
        this.jj_scanpos = token;
        this.jj_lastpos = token;
        try {
            boolean z = !jj_3_7();
            jj_save(6, i);
            return z;
        } catch (LookaheadSuccess e) {
            jj_save(6, i);
            return true;
        } catch (Throwable th) {
            jj_save(6, i);
            throw th;
        }
    }

    private boolean jj_3R_43() {
        return jj_3R_58();
    }

    private boolean jj_3R_42() {
        return jj_3R_57();
    }

    private boolean jj_3R_41() {
        if (jj_scan_token(75)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_56()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(76);
    }

    private boolean jj_3R_38() {
        Token token = this.jj_scanpos;
        if (!jj_3R_41()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_42()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_43();
    }

    private boolean jj_3_3() {
        return jj_3R_10();
    }

    private boolean jj_3R_18() {
        return jj_3R_38();
    }

    private boolean jj_3R_17() {
        return jj_scan_token(74) || jj_scan_token(51);
    }

    private boolean jj_3R_16() {
        return jj_scan_token(77) || jj_3R_12();
    }

    private boolean jj_3R_35() {
        return jj_3R_40();
    }

    private boolean jj_3R_15() {
        return jj_scan_token(73) || jj_scan_token(51);
    }

    private boolean jj_3R_10() {
        Token token = this.jj_scanpos;
        if (!jj_3R_15()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_16()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_17()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_18();
    }

    private boolean jj_3R_59() {
        return jj_scan_token(37);
    }

    private boolean jj_3_5() {
        return jj_3R_11() || jj_3R_12();
    }

    private boolean jj_3R_60() {
        return jj_3R_70();
    }

    private boolean jj_3R_55() {
        return jj_scan_token(69);
    }

    private boolean jj_3R_54() {
        return jj_scan_token(43);
    }

    private boolean jj_3R_53() {
        return jj_scan_token(83);
    }

    private boolean jj_3R_40() {
        Token token = this.jj_scanpos;
        if (!jj_3R_53()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_54()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_55();
    }

    private boolean jj_3R_34() {
        return jj_3R_39();
    }

    private boolean jj_3R_12() {
        Token token = this.jj_scanpos;
        if (!jj_3R_34()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_35();
    }

    private boolean jj_3R_73() {
        return jj_scan_token(75);
    }

    private boolean jj_3R_33() {
        return jj_scan_token(44);
    }

    private boolean jj_3R_72() {
        return jj_scan_token(51);
    }

    private boolean jj_3R_70() {
        Token token = this.jj_scanpos;
        if (!jj_3R_72()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_73();
    }

    private boolean jj_3_2() {
        return jj_scan_token(41) || jj_scan_token(37);
    }

    private boolean jj_3R_32() {
        return jj_scan_token(29);
    }

    private boolean jj_3R_31() {
        return jj_scan_token(94);
    }

    private boolean jj_3_4() {
        return jj_scan_token(72) || jj_scan_token(51);
    }

    private boolean jj_3R_30() {
        return jj_scan_token(93);
    }

    private boolean jj_3_1() {
        return jj_scan_token(36) || jj_scan_token(51) || jj_scan_token(71);
    }

    private boolean jj_3R_29() {
        return jj_scan_token(92);
    }

    private boolean jj_3R_28() {
        return jj_scan_token(91);
    }

    private boolean jj_3R_69() {
        return jj_scan_token(27);
    }

    private boolean jj_3R_27() {
        return jj_scan_token(90);
    }

    private boolean jj_3R_68() {
        return jj_scan_token(26);
    }

    private boolean jj_3R_26() {
        return jj_scan_token(89);
    }

    private boolean jj_3R_67() {
        return jj_scan_token(25);
    }

    private boolean jj_3R_25() {
        return jj_scan_token(88);
    }

    private boolean jj_3R_66() {
        return jj_scan_token(24);
    }

    private boolean jj_3R_24() {
        return jj_scan_token(87);
    }

    private boolean jj_3R_65() {
        return jj_scan_token(23);
    }

    private boolean jj_3R_23() {
        return jj_scan_token(86);
    }

    private boolean jj_3R_64() {
        return jj_scan_token(62);
    }

    private boolean jj_3R_22() {
        return jj_scan_token(85);
    }

    private boolean jj_3R_63() {
        return jj_scan_token(61);
    }

    private boolean jj_3R_58() {
        Token token = this.jj_scanpos;
        if (!jj_3R_63()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_64()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_65()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_66()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_67()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_68()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_69();
    }

    private boolean jj_3R_21() {
        return jj_scan_token(84);
    }

    private boolean jj_3R_20() {
        return jj_scan_token(83);
    }

    private boolean jj_3R_19() {
        return jj_scan_token(82);
    }

    private boolean jj_3R_11() {
        Token token = this.jj_scanpos;
        if (!jj_3R_19()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_20()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_21()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_22()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_23()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_24()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_25()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_26()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_27()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_28()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_29()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_30()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_31()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_32()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_33();
    }

    private boolean jj_3_6() {
        return jj_3R_13() || jj_3R_14();
    }

    private boolean jj_3R_52() {
        return jj_3R_60();
    }

    private boolean jj_3R_51() {
        return jj_3R_59();
    }

    private boolean jj_3R_50() {
        return jj_3R_57();
    }

    private boolean jj_3R_13() {
        Token token = this.jj_scanpos;
        if (!jj_scan_token(72)) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_scan_token(70);
    }

    private boolean jj_3R_49() {
        return jj_scan_token(79);
    }

    private boolean jj_3R_48() {
        return jj_3R_58();
    }

    private boolean jj_3R_47() {
        return jj_scan_token(52);
    }

    private boolean jj_3R_46() {
        return jj_scan_token(35);
    }

    private boolean jj_3R_45() {
        return jj_scan_token(48);
    }

    private boolean jj_3R_44() {
        return jj_scan_token(42);
    }

    private boolean jj_3R_39() {
        Token token = this.jj_scanpos;
        if (!jj_3R_44()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_45()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_46()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_47()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_48()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_49()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_50()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3R_51()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_52();
    }

    private boolean jj_3R_37() {
        return jj_3R_12();
    }

    private boolean jj_3_7() {
        return jj_scan_token(51) || jj_scan_token(71);
    }

    private boolean jj_3R_14() {
        Token token = this.jj_scanpos;
        if (!jj_3R_36()) {
            return false;
        }
        this.jj_scanpos = token;
        if (!jj_3_7()) {
            return false;
        }
        this.jj_scanpos = token;
        return jj_3R_37();
    }

    private boolean jj_3R_36() {
        return jj_scan_token(77);
    }

    private boolean jj_3R_71() {
        return jj_3R_14();
    }

    private boolean jj_3R_61() {
        return jj_3R_12();
    }

    private boolean jj_3R_62() {
        return jj_3R_71();
    }

    private boolean jj_3R_57() {
        if (jj_scan_token(80)) {
            return true;
        }
        Token token = this.jj_scanpos;
        if (jj_3R_62()) {
            this.jj_scanpos = token;
        }
        return jj_scan_token(81);
    }

    private boolean jj_3R_56() {
        return jj_3R_61();
    }

    private static void jj_la1_init_0() {
        jj_la1_0 = new int[]{0, -1073741824, 0, 0, 0, -1073741824, 0, 0, 0, 0, 260046848, 0, 0, 0, 0, 0, 0, 260046848, 260046848, 260046848, 0, 260046848, 260046848, 260046848, 0, 0, 0, 260046848, 0, 0, 260046848, 0, 536870912, 0};
    }

    private static void jj_la1_init_1() {
        jj_la1_1 = new int[]{0, 803568, 8192, 0, 0, 278720, 48, 524800, 2, 1, 1612254248, 0, 0, 0, 0, 0, 524288, 1610612736, 1612254248, 1610612736, 0, 1612252200, 1610612736, 1612254248, 524288, 0, 524288, 1612254248, 0, 0, 1612254248, 0, 4096, 2048};
    }

    private static void jj_la1_init_2() {
        jj_la1_2 = new int[]{32, 2114, 0, 256, 128, 66, 0, 2048, 0, 0, 624672, 64, 384, 256, 512, 1024, 2048, 77312, 624672, 67584, 256, 100352, 0, 624672, 32768, 256, 32768, 632864, 320, 8192, 624672, 320, 2147221504, 524320};
    }

    public LuaParser(InputStream inputStream) {
        this(inputStream, null);
    }

    public LuaParser(InputStream inputStream, String str) {
        this.jj_la1 = new int[34];
        this.jj_2_rtns = new JJCalls[7];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(null);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        try {
            this.jj_input_stream = new SimpleCharStream(inputStream, str, 1, 1);
            this.token_source = new LuaParserTokenManager(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i = 0; i < 34; i++) {
                this.jj_la1[i] = -1;
            }
            for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
                this.jj_2_rtns[i2] = new JJCalls();
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void ReInit(InputStream inputStream) {
        ReInit(inputStream, null);
    }

    public void ReInit(InputStream inputStream, String str) {
        try {
            this.jj_input_stream.ReInit(inputStream, str, 1, 1);
            this.token_source.ReInit(this.jj_input_stream);
            this.token = new Token();
            this.jj_ntk = -1;
            this.jj_gen = 0;
            for (int i = 0; i < 34; i++) {
                this.jj_la1[i] = -1;
            }
            for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
                this.jj_2_rtns[i2] = new JJCalls();
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public LuaParser(Reader reader) {
        this.jj_la1 = new int[34];
        this.jj_2_rtns = new JJCalls[7];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(null);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.jj_input_stream = new SimpleCharStream(reader, 1, 1);
        this.token_source = new LuaParserTokenManager(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    public void ReInit(Reader reader) {
        this.jj_input_stream.ReInit(reader, 1, 1);
        this.token_source.ReInit(this.jj_input_stream);
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    public LuaParser(LuaParserTokenManager luaParserTokenManager) {
        this.jj_la1 = new int[34];
        this.jj_2_rtns = new JJCalls[7];
        this.jj_rescan = false;
        this.jj_gc = 0;
        this.jj_ls = new LookaheadSuccess(null);
        this.jj_expentries = new ArrayList();
        this.jj_kind = -1;
        this.jj_lasttokens = new int[100];
        this.token_source = luaParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    public void ReInit(LuaParserTokenManager luaParserTokenManager) {
        this.token_source = luaParserTokenManager;
        this.token = new Token();
        this.jj_ntk = -1;
        this.jj_gen = 0;
        for (int i = 0; i < 34; i++) {
            this.jj_la1[i] = -1;
        }
        for (int i2 = 0; i2 < this.jj_2_rtns.length; i2++) {
            this.jj_2_rtns[i2] = new JJCalls();
        }
    }

    private Token jj_consume_token(int i) throws ParseException {
        Token token = this.token;
        if (token.next != null) {
            this.token = this.token.next;
        } else {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        if (this.token.kind == i) {
            this.jj_gen++;
            int i2 = this.jj_gc + 1;
            this.jj_gc = i2;
            if (i2 > 100) {
                this.jj_gc = 0;
                for (int i3 = 0; i3 < this.jj_2_rtns.length; i3++) {
                    for (JJCalls jJCalls = this.jj_2_rtns[i3]; jJCalls != null; jJCalls = jJCalls.next) {
                        if (jJCalls.gen < this.jj_gen) {
                            jJCalls.first = null;
                        }
                    }
                }
            }
            return this.token;
        }
        this.token = token;
        this.jj_kind = i;
        throw generateParseException();
    }

    private boolean jj_scan_token(int i) {
        if (this.jj_scanpos == this.jj_lastpos) {
            this.jj_la--;
            if (this.jj_scanpos.next == null) {
                Token token = this.jj_scanpos;
                Token nextToken = this.token_source.getNextToken();
                token.next = nextToken;
                this.jj_scanpos = nextToken;
                this.jj_lastpos = nextToken;
            } else {
                Token token2 = this.jj_scanpos.next;
                this.jj_scanpos = token2;
                this.jj_lastpos = token2;
            }
        } else {
            this.jj_scanpos = this.jj_scanpos.next;
        }
        if (this.jj_rescan) {
            int i2 = 0;
            Token token3 = this.token;
            while (token3 != null && token3 != this.jj_scanpos) {
                i2++;
                token3 = token3.next;
            }
            if (token3 != null) {
                jj_add_error_token(i, i2);
            }
        }
        if (this.jj_scanpos.kind != i) {
            return true;
        }
        if (this.jj_la != 0 || this.jj_scanpos != this.jj_lastpos) {
            return false;
        }
        throw this.jj_ls;
    }

    public final Token getNextToken() {
        if (this.token.next != null) {
            this.token = this.token.next;
        } else {
            Token token = this.token;
            Token nextToken = this.token_source.getNextToken();
            token.next = nextToken;
            this.token = nextToken;
        }
        this.jj_ntk = -1;
        this.jj_gen++;
        return this.token;
    }

    public final Token getToken(int i) {
        Token token = this.token;
        for (int i2 = 0; i2 < i; i2++) {
            if (token.next != null) {
                token = token.next;
            } else {
                Token nextToken = this.token_source.getNextToken();
                token = nextToken;
                token.next = nextToken;
            }
        }
        return token;
    }

    private int jj_ntk() {
        Token token = this.token.next;
        this.jj_nt = token;
        if (token == null) {
            Token token2 = this.token;
            Token nextToken = this.token_source.getNextToken();
            token2.next = nextToken;
            int i = nextToken.kind;
            this.jj_ntk = i;
            return i;
        }
        int i2 = this.jj_nt.kind;
        this.jj_ntk = i2;
        return i2;
    }

    private void jj_add_error_token(int i, int i2) {
        if (i2 < 100) {
            if (i2 == this.jj_endpos + 1) {
                int[] iArr = this.jj_lasttokens;
                int i3 = this.jj_endpos;
                this.jj_endpos = i3 + 1;
                iArr[i3] = i;
            } else if (this.jj_endpos != 0) {
                this.jj_expentry = new int[this.jj_endpos];
                for (int i4 = 0; i4 < this.jj_endpos; i4++) {
                    this.jj_expentry[i4] = this.jj_lasttokens[i4];
                }
                Iterator it = this.jj_expentries.iterator();
                loop1: while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    int[] iArr2 = (int[]) it.next();
                    if (iArr2.length == this.jj_expentry.length) {
                        for (int i5 = 0; i5 < this.jj_expentry.length; i5++) {
                            if (iArr2[i5] != this.jj_expentry[i5]) {
                                break;
                            }
                        }
                        this.jj_expentries.add(this.jj_expentry);
                        break loop1;
                    }
                }
                if (i2 != 0) {
                    int[] iArr3 = this.jj_lasttokens;
                    this.jj_endpos = i2;
                    iArr3[i2 - 1] = i;
                }
            }
        }
    }

    public ParseException generateParseException() {
        this.jj_expentries.clear();
        boolean[] zArr = new boolean[95];
        if (this.jj_kind >= 0) {
            zArr[this.jj_kind] = true;
            this.jj_kind = -1;
        }
        for (int i = 0; i < 34; i++) {
            if (this.jj_la1[i] == this.jj_gen) {
                for (int i2 = 0; i2 < 32; i2++) {
                    if ((jj_la1_0[i] & (1 << i2)) != 0) {
                        zArr[i2] = true;
                    }
                    if ((jj_la1_1[i] & (1 << i2)) != 0) {
                        zArr[32 + i2] = true;
                    }
                    if ((jj_la1_2[i] & (1 << i2)) != 0) {
                        zArr[64 + i2] = true;
                    }
                }
            }
        }
        for (int i3 = 0; i3 < 95; i3++) {
            if (zArr[i3]) {
                this.jj_expentry = new int[1];
                this.jj_expentry[0] = i3;
                this.jj_expentries.add(this.jj_expentry);
            }
        }
        this.jj_endpos = 0;
        jj_rescan_token();
        jj_add_error_token(0, 0);
        int[][] iArr = new int[this.jj_expentries.size()];
        for (int i4 = 0; i4 < this.jj_expentries.size(); i4++) {
            iArr[i4] = (int[]) this.jj_expentries.get(i4);
        }
        return new ParseException(this.token, iArr, tokenImage);
    }

    public final void enable_tracing() {
    }

    public final void disable_tracing() {
    }

    private void jj_rescan_token() {
        this.jj_rescan = true;
        for (int i = 0; i < 7; i++) {
            try {
                JJCalls jJCalls = this.jj_2_rtns[i];
                do {
                    if (jJCalls.gen > this.jj_gen) {
                        this.jj_la = jJCalls.arg;
                        Token token = jJCalls.first;
                        this.jj_scanpos = token;
                        this.jj_lastpos = token;
                        switch (i) {
                            case 0:
                                jj_3_1();
                                break;
                            case 1:
                                jj_3_2();
                                break;
                            case 2:
                                jj_3_3();
                                break;
                            case 3:
                                jj_3_4();
                                break;
                            case 4:
                                jj_3_5();
                                break;
                            case 5:
                                jj_3_6();
                                break;
                            case 6:
                                jj_3_7();
                                break;
                        }
                    }
                    jJCalls = jJCalls.next;
                } while (jJCalls != null);
            } catch (LookaheadSuccess e) {
            }
        }
        this.jj_rescan = false;
    }

    private void jj_save(int i, int i2) {
        JJCalls jJCalls = this.jj_2_rtns[i];
        while (true) {
            if (jJCalls.gen <= this.jj_gen) {
                break;
            } else if (jJCalls.next == null) {
                JJCalls jJCalls2 = new JJCalls();
                jJCalls.next = jJCalls2;
                jJCalls = jJCalls2;
                break;
            } else {
                jJCalls = jJCalls.next;
            }
        }
        jJCalls.gen = (this.jj_gen + i2) - this.jj_la;
        jJCalls.first = this.token;
        jJCalls.arg = i2;
    }

    static {
        LuaValue.valueOf(true);
        jj_la1_init_0();
        jj_la1_init_1();
        jj_la1_init_2();
    }
}
