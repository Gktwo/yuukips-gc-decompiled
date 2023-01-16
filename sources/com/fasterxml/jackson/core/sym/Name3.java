package com.fasterxml.jackson.core.sym;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/sym/Name3.class */
public final class Name3 extends Name {

    /* renamed from: q1 */
    private final int f225q1;

    /* renamed from: q2 */
    private final int f226q2;

    /* renamed from: q3 */
    private final int f227q3;

    Name3(String name, int hash, int i1, int i2, int i3) {
        super(name, hash);
        this.f225q1 = i1;
        this.f226q2 = i2;
        this.f227q3 = i3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2) {
        return false;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int quad1, int quad2, int quad3) {
        return this.f225q1 == quad1 && this.f226q2 == quad2 && this.f227q3 == quad3;
    }

    @Override // com.fasterxml.jackson.core.sym.Name
    public boolean equals(int[] quads, int qlen) {
        return qlen == 3 && quads[0] == this.f225q1 && quads[1] == this.f226q2 && quads[2] == this.f227q3;
    }
}
