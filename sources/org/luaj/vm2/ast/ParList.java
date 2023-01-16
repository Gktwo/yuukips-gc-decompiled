package org.luaj.vm2.ast;

import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/ParList.class */
public class ParList extends SyntaxElement {
    public static final List EMPTY_NAMELIST = new ArrayList();
    public static final ParList EMPTY_PARLIST = new ParList(EMPTY_NAMELIST, false);
    public final List names;
    public final boolean isvararg;

    public ParList(List list, boolean z) {
        this.names = list;
        this.isvararg = z;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
