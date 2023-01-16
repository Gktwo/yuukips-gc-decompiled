package org.luaj.vm2.ast;

/* loaded from: grasscutter.jar:org/luaj/vm2/ast/Chunk.class */
public class Chunk extends SyntaxElement {
    public final Block block;

    public Chunk(Block block) {
        this.block = block;
    }

    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
