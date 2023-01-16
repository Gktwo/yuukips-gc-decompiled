package com.fasterxml.jackson.core.sym;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/sym/Name2.class */
public final class Name2 extends Name {

    /* renamed from: q1 */
    private final int f223q1;

    /* renamed from: q2 */
    private final int f224q2;

    Name2(String name, int hash, int quad1, int quad2) {
        super(name, hash);
        this.f223q1 = quad1;
        this.f224q2 = quad2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2) {
        return quad1 == this.f223q1 && quad2 == this.f224q2;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2, int q3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] quads, int qlen) {
        return qlen == 2 && quads[0] == this.f223q1 && quads[1] == this.f224q2;
    }
}
