package com.fasterxml.jackson.core.sym;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/sym/Name1.class */
public final class Name1 extends Name {
    private static final Name1 EMPTY = new Name1("", 0, 0);

    /* renamed from: q */
    private final int f222q;

    Name1(String name, int hash, int quad) {
        super(name, hash);
        this.f222q = quad;
    }

    public static Name1 getEmptyName() {
        return EMPTY;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad) {
        return quad == this.f222q;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2) {
        return quad1 == this.f222q && quad2 == 0;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int q1, int q2, int q3) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] quads, int qlen) {
        return qlen == 1 && quads[0] == this.f222q;
    }
}
