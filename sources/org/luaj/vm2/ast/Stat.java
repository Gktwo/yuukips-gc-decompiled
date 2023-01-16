package org.luaj.vm2.ast;

import java.util.List;
import org.luaj.vm2.ast.Exp;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat.class */
public abstract class Stat extends SyntaxElement {

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$Assign.class */
    public static class Assign extends Stat {
        public final List vars;
        public final List exps;

        public Assign(List list, List list2) {
            this.vars = list;
            this.exps = list2;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$Break.class */
    public static class Break extends Stat {
        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$FuncCallStat.class */
    public static class FuncCallStat extends Stat {
        public final Exp.FuncCall funccall;

        public FuncCallStat(Exp.FuncCall funcCall) {
            this.funccall = funcCall;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$FuncDef.class */
    public static class FuncDef extends Stat {
        public final FuncName name;
        public final FuncBody body;

        public FuncDef(FuncName funcName, FuncBody funcBody) {
            this.name = funcName;
            this.body = funcBody;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$GenericFor.class */
    public static class GenericFor extends Stat {
        public List names;
        public List exps;
        public Block block;
        public NameScope scope;

        public GenericFor(List list, List list2, Block block) {
            this.names = list;
            this.exps = list2;
            this.block = block;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$Goto.class */
    public static class Goto extends Stat {
        public final String name;

        public Goto(String str) {
            this.name = str;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$IfThenElse.class */
    public static class IfThenElse extends Stat {
        public final Exp ifexp;
        public final Block ifblock;
        public final List elseifexps;
        public final List elseifblocks;
        public final Block elseblock;

        public IfThenElse(Exp exp, Block block, List list, List list2, Block block2) {
            this.ifexp = exp;
            this.ifblock = block;
            this.elseifexps = list;
            this.elseifblocks = list2;
            this.elseblock = block2;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$Label.class */
    public static class Label extends Stat {
        public final String name;

        public Label(String str) {
            this.name = str;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$LocalAssign.class */
    public static class LocalAssign extends Stat {
        public final List names;
        public final List values;

        public LocalAssign(List list, List list2) {
            this.names = list;
            this.values = list2;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$LocalFuncDef.class */
    public static class LocalFuncDef extends Stat {
        public final Name name;
        public final FuncBody body;

        public LocalFuncDef(String str, FuncBody funcBody) {
            this.name = new Name(str);
            this.body = funcBody;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$NumericFor.class */
    public static class NumericFor extends Stat {
        public final Name name;
        public final Exp initial;
        public final Exp limit;
        public final Exp step;
        public final Block block;
        public NameScope scope;

        public NumericFor(String str, Exp exp, Exp exp2, Exp exp3, Block block) {
            this.name = new Name(str);
            this.initial = exp;
            this.limit = exp2;
            this.step = exp3;
            this.block = block;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$RepeatUntil.class */
    public static class RepeatUntil extends Stat {
        public final Block block;
        public final Exp exp;

        public RepeatUntil(Block block, Exp exp) {
            this.block = block;
            this.exp = exp;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$Return.class */
    public static class Return extends Stat {
        public final List values;

        public Return(List list) {
            this.values = list;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }

        public int nreturns() {
            int size = this.values != null ? this.values.size() : 0;
            if (size > 0 && ((Exp) this.values.get(size - 1)).isvarargexp()) {
                size = -1;
            }
            return size;
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/ast/Stat$WhileDo.class */
    public static class WhileDo extends Stat {
        public final Exp exp;
        public final Block block;

        public WhileDo(Exp exp, Block block) {
            this.exp = exp;
            this.block = block;
        }

        @Override // org.luaj.vm2.ast.Stat
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    public abstract void accept(Visitor visitor);

    public static Stat block(Block block) {
        return block;
    }

    public static Stat whiledo(Exp exp, Block block) {
        return new WhileDo(exp, block);
    }

    public static Stat repeatuntil(Block block, Exp exp) {
        return new RepeatUntil(block, exp);
    }

    public static Stat breakstat() {
        return new Break();
    }

    public static Stat returnstat(List list) {
        return new Return(list);
    }

    public static Stat assignment(List list, List list2) {
        return new Assign(list, list2);
    }

    public static Stat functioncall(Exp.FuncCall funcCall) {
        return new FuncCallStat(funcCall);
    }

    public static Stat localfunctiondef(String str, FuncBody funcBody) {
        return new LocalFuncDef(str, funcBody);
    }

    public static Stat fornumeric(String str, Exp exp, Exp exp2, Exp exp3, Block block) {
        return new NumericFor(str, exp, exp2, exp3, block);
    }

    public static Stat functiondef(FuncName funcName, FuncBody funcBody) {
        return new FuncDef(funcName, funcBody);
    }

    public static Stat forgeneric(List list, List list2, Block block) {
        return new GenericFor(list, list2, block);
    }

    public static Stat localassignment(List list, List list2) {
        return new LocalAssign(list, list2);
    }

    public static Stat ifthenelse(Exp exp, Block block, List list, List list2, Block block2) {
        return new IfThenElse(exp, block, list, list2, block2);
    }

    public static Stat gotostat(String str) {
        return new Goto(str);
    }

    public static Stat labelstat(String str) {
        return new Label(str);
    }
}
