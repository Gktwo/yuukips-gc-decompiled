package javassist.compiler;

import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.ArrayInit;
import javassist.compiler.ast.AssignExpr;
import javassist.compiler.ast.BinExpr;
import javassist.compiler.ast.CallExpr;
import javassist.compiler.ast.CastExpr;
import javassist.compiler.ast.CondExpr;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.DoubleConst;
import javassist.compiler.ast.Expr;
import javassist.compiler.ast.FieldDecl;
import javassist.compiler.ast.InstanceOfExpr;
import javassist.compiler.ast.IntConst;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Member;
import javassist.compiler.ast.MethodDecl;
import javassist.compiler.ast.NewExpr;
import javassist.compiler.ast.Pair;
import javassist.compiler.ast.Stmnt;
import javassist.compiler.ast.StringL;
import javassist.compiler.ast.Symbol;
import javassist.compiler.ast.Variable;

/* loaded from: grasscutter.jar:javassist/compiler/Parser.class */
public final class Parser implements TokenId {
    private Lex lex;
    private static final int[] binaryOpPrecedence = {0, 0, 0, 0, 1, 6, 0, 0, 0, 1, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0};

    public Parser(Lex lex) {
        this.lex = lex;
    }

    public boolean hasMore() {
        return this.lex.lookAhead() >= 0;
    }

    public ASTList parseMember(SymbolTable tbl) throws CompileError {
        ASTList mem = parseMember1(tbl);
        if (mem instanceof MethodDecl) {
            return parseMethod2(tbl, (MethodDecl) mem);
        }
        return mem;
    }

    public ASTList parseMember1(SymbolTable tbl) throws CompileError {
        Declarator d;
        String name;
        ASTList mods = parseMemberMods();
        boolean isConstructor = false;
        if (this.lex.lookAhead() == 400 && this.lex.lookAhead(1) == 40) {
            d = new Declarator(344, 0);
            isConstructor = true;
        } else {
            d = parseFormalType(tbl);
        }
        if (this.lex.get() != 400) {
            throw new SyntaxError(this.lex);
        }
        if (isConstructor) {
            name = "<init>";
        } else {
            name = this.lex.getString();
        }
        d.setVariable(new Symbol(name));
        if (isConstructor || this.lex.lookAhead() == 40) {
            return parseMethod1(tbl, isConstructor, mods, d);
        }
        return parseField(tbl, mods, d);
    }

    private FieldDecl parseField(SymbolTable tbl, ASTList mods, Declarator d) throws CompileError {
        ASTree expr = null;
        if (this.lex.lookAhead() == 61) {
            this.lex.get();
            expr = parseExpression(tbl);
        }
        int c = this.lex.get();
        if (c == 59) {
            return new FieldDecl(mods, new ASTList(d, new ASTList(expr)));
        }
        if (c == 44) {
            throw new CompileError("only one field can be declared in one declaration", this.lex);
        }
        throw new SyntaxError(this.lex);
    }

    private MethodDecl parseMethod1(SymbolTable tbl, boolean isConstructor, ASTList mods, Declarator d) throws CompileError {
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        ASTList parms = null;
        if (this.lex.lookAhead() != 41) {
            while (true) {
                parms = ASTList.append(parms, parseFormalParam(tbl));
                int t = this.lex.lookAhead();
                if (t == 44) {
                    this.lex.get();
                } else if (t == 41) {
                    break;
                }
            }
        }
        this.lex.get();
        d.addArrayDim(parseArrayDimension());
        if (!isConstructor || d.getArrayDim() <= 0) {
            ASTList throwsList = null;
            if (this.lex.lookAhead() == 341) {
                this.lex.get();
                while (true) {
                    throwsList = ASTList.append(throwsList, parseClassType(tbl));
                    if (this.lex.lookAhead() != 44) {
                        break;
                    }
                    this.lex.get();
                }
            }
            return new MethodDecl(mods, new ASTList(d, ASTList.make(parms, throwsList, null)));
        }
        throw new SyntaxError(this.lex);
    }

    public MethodDecl parseMethod2(SymbolTable tbl, MethodDecl md) throws CompileError {
        Stmnt body = null;
        if (this.lex.lookAhead() == 59) {
            this.lex.get();
        } else {
            body = parseBlock(tbl);
            if (body == null) {
                body = new Stmnt(66);
            }
        }
        md.sublist(4).setHead(body);
        return md;
    }

    private ASTList parseMemberMods() {
        ASTList list = null;
        while (true) {
            int t = this.lex.lookAhead();
            if (t != 300 && t != 315 && t != 332 && t != 331 && t != 330 && t != 338 && t != 335 && t != 345 && t != 342 && t != 347) {
                return list;
            }
            list = new ASTList(new Keyword(this.lex.get()), list);
        }
    }

    private Declarator parseFormalType(SymbolTable tbl) throws CompileError {
        int t = this.lex.lookAhead();
        if (!isBuiltinType(t) && t != 344) {
            return new Declarator(parseClassType(tbl), parseArrayDimension());
        }
        this.lex.get();
        return new Declarator(t, parseArrayDimension());
    }

    private static boolean isBuiltinType(int t) {
        return t == 301 || t == 303 || t == 306 || t == 334 || t == 324 || t == 326 || t == 317 || t == 312;
    }

    private Declarator parseFormalParam(SymbolTable tbl) throws CompileError {
        Declarator d = parseFormalType(tbl);
        if (this.lex.get() != 400) {
            throw new SyntaxError(this.lex);
        }
        String name = this.lex.getString();
        d.setVariable(new Symbol(name));
        d.addArrayDim(parseArrayDimension());
        tbl.append(name, d);
        return d;
    }

    public Stmnt parseStatement(SymbolTable tbl) throws CompileError {
        int t = this.lex.lookAhead();
        if (t == 123) {
            return parseBlock(tbl);
        }
        if (t == 59) {
            this.lex.get();
            return new Stmnt(66);
        } else if (t == 400 && this.lex.lookAhead(1) == 58) {
            this.lex.get();
            String label = this.lex.getString();
            this.lex.get();
            return Stmnt.make(76, new Symbol(label), parseStatement(tbl));
        } else if (t == 320) {
            return parseIf(tbl);
        } else {
            if (t == 346) {
                return parseWhile(tbl);
            }
            if (t == 311) {
                return parseDo(tbl);
            }
            if (t == 318) {
                return parseFor(tbl);
            }
            if (t == 343) {
                return parseTry(tbl);
            }
            if (t == 337) {
                return parseSwitch(tbl);
            }
            if (t == 338) {
                return parseSynchronized(tbl);
            }
            if (t == 333) {
                return parseReturn(tbl);
            }
            if (t == 340) {
                return parseThrow(tbl);
            }
            if (t == 302) {
                return parseBreak(tbl);
            }
            if (t == 309) {
                return parseContinue(tbl);
            }
            return parseDeclarationOrExpression(tbl, false);
        }
    }

    private Stmnt parseBlock(SymbolTable tbl) throws CompileError {
        if (this.lex.get() != 123) {
            throw new SyntaxError(this.lex);
        }
        Stmnt body = null;
        SymbolTable tbl2 = new SymbolTable(tbl);
        while (this.lex.lookAhead() != 125) {
            Stmnt s = parseStatement(tbl2);
            if (s != null) {
                body = (Stmnt) ASTList.concat(body, new Stmnt(66, s));
            }
        }
        this.lex.get();
        if (body == null) {
            return new Stmnt(66);
        }
        return body;
    }

    private Stmnt parseIf(SymbolTable tbl) throws CompileError {
        Stmnt elsep;
        int t = this.lex.get();
        ASTree expr = parseParExpression(tbl);
        Stmnt thenp = parseStatement(tbl);
        if (this.lex.lookAhead() == 313) {
            this.lex.get();
            elsep = parseStatement(tbl);
        } else {
            elsep = null;
        }
        return new Stmnt(t, expr, new ASTList(thenp, new ASTList(elsep)));
    }

    private Stmnt parseWhile(SymbolTable tbl) throws CompileError {
        return new Stmnt(this.lex.get(), parseParExpression(tbl), parseStatement(tbl));
    }

    private Stmnt parseDo(SymbolTable tbl) throws CompileError {
        int t = this.lex.get();
        Stmnt body = parseStatement(tbl);
        if (this.lex.get() == 346 && this.lex.get() == 40) {
            ASTree expr = parseExpression(tbl);
            if (this.lex.get() == 41 && this.lex.get() == 59) {
                return new Stmnt(t, expr, body);
            }
            throw new SyntaxError(this.lex);
        }
        throw new SyntaxError(this.lex);
    }

    private Stmnt parseFor(SymbolTable tbl) throws CompileError {
        Stmnt expr1;
        ASTree expr2;
        Stmnt expr3;
        int t = this.lex.get();
        SymbolTable tbl2 = new SymbolTable(tbl);
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        if (this.lex.lookAhead() == 59) {
            this.lex.get();
            expr1 = null;
        } else {
            expr1 = parseDeclarationOrExpression(tbl2, true);
        }
        if (this.lex.lookAhead() == 59) {
            expr2 = null;
        } else {
            expr2 = parseExpression(tbl2);
        }
        if (this.lex.get() != 59) {
            throw new CompileError("; is missing", this.lex);
        }
        if (this.lex.lookAhead() == 41) {
            expr3 = null;
        } else {
            expr3 = parseExprList(tbl2);
        }
        if (this.lex.get() == 41) {
            return new Stmnt(t, expr1, new ASTList(expr2, new ASTList(expr3, parseStatement(tbl2))));
        }
        throw new CompileError(") is missing", this.lex);
    }

    private Stmnt parseSwitch(SymbolTable tbl) throws CompileError {
        return new Stmnt(this.lex.get(), parseParExpression(tbl), parseSwitchBlock(tbl));
    }

    private Stmnt parseSwitchBlock(SymbolTable tbl) throws CompileError {
        if (this.lex.get() != 123) {
            throw new SyntaxError(this.lex);
        }
        SymbolTable tbl2 = new SymbolTable(tbl);
        Stmnt s = parseStmntOrCase(tbl2);
        if (s == null) {
            throw new CompileError("empty switch block", this.lex);
        }
        int op = s.getOperator();
        if (op == 304 || op == 310) {
            Stmnt body = new Stmnt(66, s);
            while (this.lex.lookAhead() != 125) {
                Stmnt s2 = parseStmntOrCase(tbl2);
                if (s2 != null) {
                    int op2 = s2.getOperator();
                    if (op2 == 304 || op2 == 310) {
                        body = (Stmnt) ASTList.concat(body, new Stmnt(66, s2));
                        s = s2;
                    } else {
                        s = (Stmnt) ASTList.concat(s, new Stmnt(66, s2));
                    }
                }
            }
            this.lex.get();
            return body;
        }
        throw new CompileError("no case or default in a switch block", this.lex);
    }

    private Stmnt parseStmntOrCase(SymbolTable tbl) throws CompileError {
        Stmnt s;
        int t = this.lex.lookAhead();
        if (t != 304 && t != 310) {
            return parseStatement(tbl);
        }
        this.lex.get();
        if (t == 304) {
            s = new Stmnt(t, parseExpression(tbl));
        } else {
            s = new Stmnt(TokenId.DEFAULT);
        }
        if (this.lex.get() == 58) {
            return s;
        }
        throw new CompileError(": is missing", this.lex);
    }

    private Stmnt parseSynchronized(SymbolTable tbl) throws CompileError {
        int t = this.lex.get();
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        ASTree expr = parseExpression(tbl);
        if (this.lex.get() == 41) {
            return new Stmnt(t, expr, parseBlock(tbl));
        }
        throw new SyntaxError(this.lex);
    }

    private Stmnt parseTry(SymbolTable tbl) throws CompileError {
        this.lex.get();
        Stmnt block = parseBlock(tbl);
        ASTList catchList = null;
        while (this.lex.lookAhead() == 305) {
            this.lex.get();
            if (this.lex.get() != 40) {
                throw new SyntaxError(this.lex);
            }
            SymbolTable tbl2 = new SymbolTable(tbl);
            Declarator d = parseFormalParam(tbl2);
            if (d.getArrayDim() > 0 || d.getType() != 307) {
                throw new SyntaxError(this.lex);
            } else if (this.lex.get() != 41) {
                throw new SyntaxError(this.lex);
            } else {
                catchList = ASTList.append(catchList, new Pair(d, parseBlock(tbl2)));
            }
        }
        Stmnt finallyBlock = null;
        if (this.lex.lookAhead() == 316) {
            this.lex.get();
            finallyBlock = parseBlock(tbl);
        }
        return Stmnt.make(343, block, catchList, finallyBlock);
    }

    private Stmnt parseReturn(SymbolTable tbl) throws CompileError {
        Stmnt s = new Stmnt(this.lex.get());
        if (this.lex.lookAhead() != 59) {
            s.setLeft(parseExpression(tbl));
        }
        if (this.lex.get() == 59) {
            return s;
        }
        throw new CompileError("; is missing", this.lex);
    }

    private Stmnt parseThrow(SymbolTable tbl) throws CompileError {
        int t = this.lex.get();
        ASTree expr = parseExpression(tbl);
        if (this.lex.get() == 59) {
            return new Stmnt(t, expr);
        }
        throw new CompileError("; is missing", this.lex);
    }

    private Stmnt parseBreak(SymbolTable tbl) throws CompileError {
        return parseContinue(tbl);
    }

    private Stmnt parseContinue(SymbolTable tbl) throws CompileError {
        Stmnt s = new Stmnt(this.lex.get());
        int t2 = this.lex.get();
        if (t2 == 400) {
            s.setLeft(new Symbol(this.lex.getString()));
            t2 = this.lex.get();
        }
        if (t2 == 59) {
            return s;
        }
        throw new CompileError("; is missing", this.lex);
    }

    private Stmnt parseDeclarationOrExpression(SymbolTable tbl, boolean exprList) throws CompileError {
        Stmnt expr;
        int i;
        int t = this.lex.lookAhead();
        while (t == 315) {
            this.lex.get();
            t = this.lex.lookAhead();
        }
        if (isBuiltinType(t)) {
            return parseDeclarators(tbl, new Declarator(this.lex.get(), parseArrayDimension()));
        }
        if (t == 400 && (i = nextIsClassType(0)) >= 0 && this.lex.lookAhead(i) == 400) {
            return parseDeclarators(tbl, new Declarator(parseClassType(tbl), parseArrayDimension()));
        }
        if (exprList) {
            expr = parseExprList(tbl);
        } else {
            expr = new Stmnt(69, parseExpression(tbl));
        }
        if (this.lex.get() == 59) {
            return expr;
        }
        throw new CompileError("; is missing", this.lex);
    }

    private Stmnt parseExprList(SymbolTable tbl) throws CompileError {
        Stmnt expr = null;
        while (true) {
            expr = (Stmnt) ASTList.concat(expr, new Stmnt(66, new Stmnt(69, parseExpression(tbl))));
            if (this.lex.lookAhead() != 44) {
                return expr;
            }
            this.lex.get();
        }
    }

    private Stmnt parseDeclarators(SymbolTable tbl, Declarator d) throws CompileError {
        int t;
        Stmnt decl = null;
        do {
            decl = (Stmnt) ASTList.concat(decl, new Stmnt(68, parseDeclarator(tbl, d)));
            t = this.lex.get();
            if (t == 59) {
                return decl;
            }
        } while (t == 44);
        throw new CompileError("; is missing", this.lex);
    }

    private Declarator parseDeclarator(SymbolTable tbl, Declarator d) throws CompileError {
        if (this.lex.get() != 400 || d.getType() == 344) {
            throw new SyntaxError(this.lex);
        }
        String name = this.lex.getString();
        Symbol symbol = new Symbol(name);
        int dim = parseArrayDimension();
        ASTree init = null;
        if (this.lex.lookAhead() == 61) {
            this.lex.get();
            init = parseInitializer(tbl);
        }
        Declarator decl = d.make(symbol, dim, init);
        tbl.append(name, decl);
        return decl;
    }

    private ASTree parseInitializer(SymbolTable tbl) throws CompileError {
        if (this.lex.lookAhead() == 123) {
            return parseArrayInitializer(tbl);
        }
        return parseExpression(tbl);
    }

    private ArrayInit parseArrayInitializer(SymbolTable tbl) throws CompileError {
        this.lex.get();
        if (this.lex.lookAhead() == 125) {
            this.lex.get();
            return new ArrayInit(null);
        }
        ArrayInit init = new ArrayInit(parseExpression(tbl));
        while (this.lex.lookAhead() == 44) {
            this.lex.get();
            ASTList.append(init, parseExpression(tbl));
        }
        if (this.lex.get() == 125) {
            return init;
        }
        throw new SyntaxError(this.lex);
    }

    private ASTree parseParExpression(SymbolTable tbl) throws CompileError {
        if (this.lex.get() != 40) {
            throw new SyntaxError(this.lex);
        }
        ASTree expr = parseExpression(tbl);
        if (this.lex.get() == 41) {
            return expr;
        }
        throw new SyntaxError(this.lex);
    }

    public ASTree parseExpression(SymbolTable tbl) throws CompileError {
        ASTree left = parseConditionalExpr(tbl);
        if (!isAssignOp(this.lex.lookAhead())) {
            return left;
        }
        return AssignExpr.makeAssign(this.lex.get(), left, parseExpression(tbl));
    }

    private static boolean isAssignOp(int t) {
        return t == 61 || t == 351 || t == 352 || t == 353 || t == 354 || t == 355 || t == 356 || t == 360 || t == 361 || t == 365 || t == 367 || t == 371;
    }

    private ASTree parseConditionalExpr(SymbolTable tbl) throws CompileError {
        ASTree cond = parseBinaryExpr(tbl);
        if (this.lex.lookAhead() != 63) {
            return cond;
        }
        this.lex.get();
        ASTree thenExpr = parseExpression(tbl);
        if (this.lex.get() == 58) {
            return new CondExpr(cond, thenExpr, parseExpression(tbl));
        }
        throw new CompileError(": is missing", this.lex);
    }

    private ASTree parseBinaryExpr(SymbolTable tbl) throws CompileError {
        ASTree expr = parseUnaryExpr(tbl);
        while (true) {
            int p = getOpPrecedence(this.lex.lookAhead());
            if (p == 0) {
                return expr;
            }
            expr = binaryExpr2(tbl, expr, p);
        }
    }

    private ASTree parseInstanceOf(SymbolTable tbl, ASTree expr) throws CompileError {
        int t = this.lex.lookAhead();
        if (!isBuiltinType(t)) {
            return new InstanceOfExpr(parseClassType(tbl), parseArrayDimension(), expr);
        }
        this.lex.get();
        return new InstanceOfExpr(t, parseArrayDimension(), expr);
    }

    private ASTree binaryExpr2(SymbolTable tbl, ASTree expr, int prec) throws CompileError {
        int t = this.lex.get();
        if (t == 323) {
            return parseInstanceOf(tbl, expr);
        }
        ASTree expr2 = parseUnaryExpr(tbl);
        while (true) {
            int p2 = getOpPrecedence(this.lex.lookAhead());
            if (p2 == 0 || prec <= p2) {
                break;
            }
            expr2 = binaryExpr2(tbl, expr2, p2);
        }
        return BinExpr.makeBin(t, expr, expr2);
    }

    private int getOpPrecedence(int c) {
        if (33 <= c && c <= 63) {
            return binaryOpPrecedence[c - 33];
        }
        if (c == 94) {
            return 7;
        }
        if (c == 124) {
            return 8;
        }
        if (c == 369) {
            return 9;
        }
        if (c == 368) {
            return 10;
        }
        if (c == 358 || c == 350) {
            return 5;
        }
        if (c == 357 || c == 359 || c == 323) {
            return 4;
        }
        if (c == 364 || c == 366 || c == 370) {
            return 3;
        }
        return 0;
    }

    private ASTree parseUnaryExpr(SymbolTable tbl) throws CompileError {
        switch (this.lex.lookAhead()) {
            case 33:
            case 43:
            case 45:
            case 126:
            case TokenId.PLUSPLUS:
            case 363:
                int t = this.lex.get();
                if (t == 45) {
                    int t2 = this.lex.lookAhead();
                    switch (t2) {
                        case 401:
                        case 402:
                        case 403:
                            this.lex.get();
                            return new IntConst(-this.lex.getLong(), t2);
                        case 404:
                        case 405:
                            this.lex.get();
                            return new DoubleConst(-this.lex.getDouble(), t2);
                    }
                }
                return Expr.make(t, parseUnaryExpr(tbl));
            case 40:
                return parseCast(tbl);
            default:
                return parsePostfix(tbl);
        }
    }

    private ASTree parseCast(SymbolTable tbl) throws CompileError {
        int t = this.lex.lookAhead(1);
        if (isBuiltinType(t) && nextIsBuiltinCast()) {
            this.lex.get();
            this.lex.get();
            int dim = parseArrayDimension();
            if (this.lex.get() == 41) {
                return new CastExpr(t, dim, parseUnaryExpr(tbl));
            }
            throw new CompileError(") is missing", this.lex);
        } else if (t != 400 || !nextIsClassCast()) {
            return parsePostfix(tbl);
        } else {
            this.lex.get();
            ASTList name = parseClassType(tbl);
            int dim2 = parseArrayDimension();
            if (this.lex.get() == 41) {
                return new CastExpr(name, dim2, parseUnaryExpr(tbl));
            }
            throw new CompileError(") is missing", this.lex);
        }
    }

    private boolean nextIsBuiltinCast() {
        int i;
        int i2 = 2;
        do {
            i = i2 + 1;
            if (this.lex.lookAhead(i2) != 91) {
                return this.lex.lookAhead(i - 1) == 41;
            }
            i2 = i + 1;
        } while (this.lex.lookAhead(i) == 93);
        return false;
    }

    private boolean nextIsClassCast() {
        int i = nextIsClassType(1);
        if (i < 0 || this.lex.lookAhead(i) != 41) {
            return false;
        }
        int t = this.lex.lookAhead(i + 1);
        return t == 40 || t == 412 || t == 406 || t == 400 || t == 339 || t == 336 || t == 328 || t == 410 || t == 411 || t == 403 || t == 402 || t == 401 || t == 405 || t == 404;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0042, code lost:
        if (r3.lex.lookAhead(r4) == 93) goto L_0x0023;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0045, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        return r4 - 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0023, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        if (r3.lex.lookAhead(r4) != 91) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0035, code lost:
        r4 = r4 + 1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int nextIsClassType(int r4) {
        /*
            r3 = this;
        L_0x0000:
            r0 = r3
            javassist.compiler.Lex r0 = r0.lex
            int r4 = r4 + 1
            r1 = r4
            int r0 = r0.lookAhead(r1)
            r1 = 46
            if (r0 != r1) goto L_0x0023
            r0 = r3
            javassist.compiler.Lex r0 = r0.lex
            int r4 = r4 + 1
            r1 = r4
            int r0 = r0.lookAhead(r1)
            r1 = 400(0x190, float:5.6E-43)
            if (r0 == r1) goto L_0x0000
            r0 = -1
            return r0
        L_0x0023:
            r0 = r3
            javassist.compiler.Lex r0 = r0.lex
            r1 = r4
            int r4 = r4 + 1
            int r0 = r0.lookAhead(r1)
            r1 = r0
            r5 = r1
            r1 = 91
            if (r0 != r1) goto L_0x0047
            r0 = r3
            javassist.compiler.Lex r0 = r0.lex
            r1 = r4
            int r4 = r4 + 1
            int r0 = r0.lookAhead(r1)
            r1 = 93
            if (r0 == r1) goto L_0x0023
            r0 = -1
            return r0
        L_0x0047:
            r0 = r4
            r1 = 1
            int r0 = r0 - r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.compiler.Parser.nextIsClassType(int):int");
    }

    private int parseArrayDimension() throws CompileError {
        int arrayDim = 0;
        while (this.lex.lookAhead() == 91) {
            arrayDim++;
            this.lex.get();
            if (this.lex.get() != 93) {
                throw new CompileError("] is missing", this.lex);
            }
        }
        return arrayDim;
    }

    private ASTList parseClassType(SymbolTable tbl) throws CompileError {
        ASTList list = null;
        while (this.lex.get() == 400) {
            list = ASTList.append(list, new Symbol(this.lex.getString()));
            if (this.lex.lookAhead() != 46) {
                return list;
            }
            this.lex.get();
        }
        throw new SyntaxError(this.lex);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00e7, code lost:
        throw new javassist.compiler.SyntaxError(r6.lex);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javassist.compiler.ast.ASTree parsePostfix(javassist.compiler.SymbolTable r7) throws javassist.compiler.CompileError {
        /*
        // Method dump skipped, instructions count: 513
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.compiler.Parser.parsePostfix(javassist.compiler.SymbolTable):javassist.compiler.ast.ASTree");
    }

    private ASTree parseDotClass(ASTree className, int dim) throws CompileError {
        String cname = toClassName(className);
        if (dim > 0) {
            StringBuffer sbuf = new StringBuffer();
            while (true) {
                dim--;
                if (dim <= 0) {
                    break;
                }
                sbuf.append('[');
            }
            sbuf.append('L').append(cname.replace('.', '/')).append(';');
            cname = sbuf.toString();
        }
        return Expr.make(46, new Symbol(cname), new Member("class"));
    }

    private ASTree parseDotClass(int builtinType, int dim) throws CompileError {
        String cname;
        if (dim > 0) {
            return Expr.make(46, new Symbol(CodeGen.toJvmTypeName(builtinType, dim)), new Member("class"));
        }
        switch (builtinType) {
            case 301:
                cname = "java.lang.Boolean";
                break;
            case 303:
                cname = "java.lang.Byte";
                break;
            case TokenId.CHAR:
                cname = "java.lang.Character";
                break;
            case TokenId.DOUBLE:
                cname = "java.lang.Double";
                break;
            case 317:
                cname = "java.lang.Float";
                break;
            case 324:
                cname = "java.lang.Integer";
                break;
            case TokenId.LONG:
                cname = "java.lang.Long";
                break;
            case 334:
                cname = "java.lang.Short";
                break;
            case 344:
                cname = "java.lang.Void";
                break;
            default:
                throw new CompileError("invalid builtin type: " + builtinType);
        }
        return Expr.make(35, new Symbol(cname), new Member("TYPE"));
    }

    private ASTree parseMethodCall(SymbolTable tbl, ASTree expr) throws CompileError {
        int op;
        if (expr instanceof Keyword) {
            int token = ((Keyword) expr).get();
            if (!(token == 339 || token == 336)) {
                throw new SyntaxError(this.lex);
            }
        } else if (!(expr instanceof Symbol) && (expr instanceof Expr) && (op = ((Expr) expr).getOperator()) != 46 && op != 35) {
            throw new SyntaxError(this.lex);
        }
        return CallExpr.makeCall(expr, parseArgumentList(tbl));
    }

    private String toClassName(ASTree name) throws CompileError {
        StringBuffer sbuf = new StringBuffer();
        toClassName(name, sbuf);
        return sbuf.toString();
    }

    private void toClassName(ASTree name, StringBuffer sbuf) throws CompileError {
        if (name instanceof Symbol) {
            sbuf.append(((Symbol) name).get());
            return;
        }
        if (name instanceof Expr) {
            Expr expr = (Expr) name;
            if (expr.getOperator() == 46) {
                toClassName(expr.oprand1(), sbuf);
                sbuf.append('.');
                toClassName(expr.oprand2(), sbuf);
                return;
            }
        }
        throw new CompileError("bad static member access", this.lex);
    }

    private ASTree parsePrimaryExpr(SymbolTable tbl) throws CompileError {
        int t = this.lex.get();
        switch (t) {
            case 40:
                ASTree expr = parseExpression(tbl);
                if (this.lex.get() == 41) {
                    return expr;
                }
                throw new CompileError(") is missing", this.lex);
            case TokenId.NEW:
                return parseNew(tbl);
            case TokenId.SUPER:
            case 339:
            case 410:
            case 411:
            case 412:
                return new Keyword(t);
            case 400:
                String name = this.lex.getString();
                Declarator decl = tbl.lookup(name);
                if (decl == null) {
                    return new Member(name);
                }
                return new Variable(name, decl);
            case 406:
                return new StringL(this.lex.getString());
            default:
                if (isBuiltinType(t) || t == 344) {
                    int dim = parseArrayDimension();
                    if (this.lex.get() == 46 && this.lex.get() == 307) {
                        return parseDotClass(t, dim);
                    }
                }
                throw new SyntaxError(this.lex);
        }
    }

    private NewExpr parseNew(SymbolTable tbl) throws CompileError {
        ArrayInit init = null;
        int t = this.lex.lookAhead();
        if (isBuiltinType(t)) {
            this.lex.get();
            ASTList size = parseArraySize(tbl);
            if (this.lex.lookAhead() == 123) {
                init = parseArrayInitializer(tbl);
            }
            return new NewExpr(t, size, init);
        }
        if (t == 400) {
            ASTList name = parseClassType(tbl);
            int t2 = this.lex.lookAhead();
            if (t2 == 40) {
                return new NewExpr(name, parseArgumentList(tbl));
            }
            if (t2 == 91) {
                ASTList size2 = parseArraySize(tbl);
                if (this.lex.lookAhead() == 123) {
                    init = parseArrayInitializer(tbl);
                }
                return NewExpr.makeObjectArray(name, size2, init);
            }
        }
        throw new SyntaxError(this.lex);
    }

    private ASTList parseArraySize(SymbolTable tbl) throws CompileError {
        ASTList list = null;
        while (this.lex.lookAhead() == 91) {
            list = ASTList.append(list, parseArrayIndex(tbl));
        }
        return list;
    }

    private ASTree parseArrayIndex(SymbolTable tbl) throws CompileError {
        this.lex.get();
        if (this.lex.lookAhead() == 93) {
            this.lex.get();
            return null;
        }
        ASTree index = parseExpression(tbl);
        if (this.lex.get() == 93) {
            return index;
        }
        throw new CompileError("] is missing", this.lex);
    }

    private ASTList parseArgumentList(SymbolTable tbl) throws CompileError {
        if (this.lex.get() != 40) {
            throw new CompileError("( is missing", this.lex);
        }
        ASTList list = null;
        if (this.lex.lookAhead() != 41) {
            while (true) {
                list = ASTList.append(list, parseExpression(tbl));
                if (this.lex.lookAhead() != 44) {
                    break;
                }
                this.lex.get();
            }
        }
        if (this.lex.get() == 41) {
            return list;
        }
        throw new CompileError(") is missing", this.lex);
    }
}
