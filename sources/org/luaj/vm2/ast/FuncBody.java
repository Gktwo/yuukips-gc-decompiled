package org.luaj.vm2.ast;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/FuncBody.class */
public class FuncBody extends SyntaxElement {
    public ParList parlist;
    public Block block;
    public NameScope scope;

    public FuncBody(ParList parList, Block block) {
        this.parlist = parList != null ? parList : ParList.EMPTY_PARLIST;
        this.block = block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
