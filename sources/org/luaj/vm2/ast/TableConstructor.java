package org.luaj.vm2.ast;

import java.util.List;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/TableConstructor.class */
public class TableConstructor extends Exp {
    public List fields;

    @Override // org.luaj.vm2.ast.Exp
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
