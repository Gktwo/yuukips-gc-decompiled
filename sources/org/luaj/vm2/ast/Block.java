package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/Block.class */
public class Block extends Stat {
    public List stats = new ArrayList();
    public NameScope scope;

    public void add(Stat stat) {
        if (stat != null) {
            this.stats.add(stat);
        }
    }

    @Override // org.luaj.vm2.ast.Stat
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
