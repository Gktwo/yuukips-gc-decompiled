package org.luaj.vm2.ast;

import org.luaj.vm2.LuaValue;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp.class */
public abstract class Exp extends SyntaxElement {

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$AnonFuncDef.class */
    public static class AnonFuncDef extends Exp {
        public final FuncBody body;

        public AnonFuncDef(FuncBody funcBody) {
            this.body = funcBody;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$BinopExp.class */
    public static class BinopExp extends Exp {
        public final Exp lhs;
        public final Exp rhs;

        /* renamed from: op */
        public final int f3305op;

        public BinopExp(Exp exp, int i, Exp exp2) {
            this.lhs = exp;
            this.f3305op = i;
            this.rhs = exp2;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$Constant.class */
    public static class Constant extends Exp {
        public final LuaValue value;

        public Constant(LuaValue luaValue) {
            this.value = luaValue;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$FieldExp.class */
    public static class FieldExp extends VarExp {
        public final PrimaryExp lhs;
        public final Name name;

        public FieldExp(PrimaryExp primaryExp, String str) {
            this.lhs = primaryExp;
            this.name = new Name(str);
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$FuncCall.class */
    public static class FuncCall extends PrimaryExp {
        public final PrimaryExp lhs;
        public final FuncArgs args;

        public FuncCall(PrimaryExp primaryExp, FuncArgs funcArgs) {
            this.lhs = primaryExp;
            this.args = funcArgs;
        }

        @Override // org.luaj.vm2.ast.Exp.PrimaryExp, org.luaj.vm2.ast.Exp
        public boolean isfunccall() {
            return true;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override // org.luaj.vm2.ast.Exp
        public boolean isvarargexp() {
            return true;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$IndexExp.class */
    public static class IndexExp extends VarExp {
        public final PrimaryExp lhs;
        public final Exp exp;

        public IndexExp(PrimaryExp primaryExp, Exp exp) {
            this.lhs = primaryExp;
            this.exp = exp;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$MethodCall.class */
    public static class MethodCall extends FuncCall {
        public final String name;

        public MethodCall(PrimaryExp primaryExp, String str, FuncArgs funcArgs) {
            super(primaryExp, funcArgs);
            this.name = new String(str);
        }

        @Override // org.luaj.vm2.ast.Exp.FuncCall, org.luaj.vm2.ast.Exp.PrimaryExp, org.luaj.vm2.ast.Exp
        public boolean isfunccall() {
            return true;
        }

        @Override // org.luaj.vm2.ast.Exp.FuncCall, org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$NameExp.class */
    public static class NameExp extends VarExp {
        public final Name name;

        public NameExp(String str) {
            this.name = new Name(str);
        }

        @Override // org.luaj.vm2.ast.Exp.VarExp
        public void markHasAssignment() {
            this.name.variable.hasassignments = true;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$ParensExp.class */
    public static class ParensExp extends PrimaryExp {
        public final Exp exp;

        public ParensExp(Exp exp) {
            this.exp = exp;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$PrimaryExp.class */
    public static abstract class PrimaryExp extends Exp {
        @Override // org.luaj.vm2.ast.Exp
        public boolean isvarexp() {
            return false;
        }

        @Override // org.luaj.vm2.ast.Exp
        public boolean isfunccall() {
            return false;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$UnopExp.class */
    public static class UnopExp extends Exp {

        /* renamed from: op */
        public final int f3306op;
        public final Exp rhs;

        public UnopExp(int i, Exp exp) {
            this.f3306op = i;
            this.rhs = exp;
        }

        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$VarExp.class */
    public static abstract class VarExp extends PrimaryExp {
        @Override // org.luaj.vm2.ast.Exp.PrimaryExp, org.luaj.vm2.ast.Exp
        public boolean isvarexp() {
            return true;
        }

        public void markHasAssignment() {
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Exp$VarargsExp.class */
    public static class VarargsExp extends Exp {
        @Override // org.luaj.vm2.ast.Exp
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        @Override // org.luaj.vm2.ast.Exp
        public boolean isvarargexp() {
            return true;
        }
    }

    public abstract void accept(Visitor visitor);

    public static Exp constant(LuaValue luaValue) {
        return new Constant(luaValue);
    }

    public static Exp numberconstant(String str) {
        return new Constant(LuaValue.valueOf(str).tonumber());
    }

    public static Exp varargs() {
        return new VarargsExp();
    }

    public static Exp tableconstructor(TableConstructor tableConstructor) {
        return tableConstructor;
    }

    public static Exp unaryexp(int i, Exp exp) {
        if (exp instanceof BinopExp) {
            BinopExp binopExp = (BinopExp) exp;
            if (precedence(i) > precedence(binopExp.f3305op)) {
                return binaryexp(unaryexp(i, binopExp.lhs), binopExp.f3305op, binopExp.rhs);
            }
        }
        return new UnopExp(i, exp);
    }

    public static Exp binaryexp(Exp exp, int i, Exp exp2) {
        if (exp instanceof UnopExp) {
            UnopExp unopExp = (UnopExp) exp;
            if (precedence(i) > precedence(unopExp.f3306op)) {
                return unaryexp(unopExp.f3306op, binaryexp(unopExp.rhs, i, exp2));
            }
        }
        if (exp instanceof BinopExp) {
            BinopExp binopExp = (BinopExp) exp;
            if (precedence(i) > precedence(binopExp.f3305op) || (precedence(i) == precedence(binopExp.f3305op) && isrightassoc(i))) {
                return binaryexp(binopExp.lhs, binopExp.f3305op, binaryexp(binopExp.rhs, i, exp2));
            }
        }
        if (exp2 instanceof BinopExp) {
            BinopExp binopExp2 = (BinopExp) exp2;
            if (precedence(i) > precedence(binopExp2.f3305op) || (precedence(i) == precedence(binopExp2.f3305op) && !isrightassoc(i))) {
                return binaryexp(binaryexp(exp, i, binopExp2.lhs), binopExp2.f3305op, binopExp2.rhs);
            }
        }
        return new BinopExp(exp, i, exp2);
    }

    static boolean isrightassoc(int i) {
        switch (i) {
            case 18:
            case 22:
                return true;
            default:
                return false;
        }
    }

    static int precedence(int i) {
        switch (i) {
            case 13:
            case 14:
                return 4;
            case 15:
            case 16:
            case 17:
                return 5;
            case 18:
                return 7;
            case 19:
            case 20:
            case 21:
                return 6;
            case 22:
                return 3;
            case 23:
            case 27:
            case 28:
            case 29:
            case 30:
            case 31:
            case 32:
            case 33:
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
            default:
                throw new IllegalStateException(new StringBuffer().append("precedence of bad op ").append(i).toString());
            case 24:
            case 25:
            case 26:
            case 61:
            case 62:
            case 63:
                return 2;
            case 59:
                return 0;
            case 60:
                return 1;
        }
    }

    public static Exp anonymousfunction(FuncBody funcBody) {
        return new AnonFuncDef(funcBody);
    }

    public static NameExp nameprefix(String str) {
        return new NameExp(str);
    }

    public static ParensExp parensprefix(Exp exp) {
        return new ParensExp(exp);
    }

    public static IndexExp indexop(PrimaryExp primaryExp, Exp exp) {
        return new IndexExp(primaryExp, exp);
    }

    public static FieldExp fieldop(PrimaryExp primaryExp, String str) {
        return new FieldExp(primaryExp, str);
    }

    public static FuncCall functionop(PrimaryExp primaryExp, FuncArgs funcArgs) {
        return new FuncCall(primaryExp, funcArgs);
    }

    public static MethodCall methodop(PrimaryExp primaryExp, String str, FuncArgs funcArgs) {
        return new MethodCall(primaryExp, str, funcArgs);
    }

    public boolean isvarexp() {
        return false;
    }

    public boolean isfunccall() {
        return false;
    }

    public boolean isvarargexp() {
        return false;
    }
}
