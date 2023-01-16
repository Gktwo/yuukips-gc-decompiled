package org.luaj.vm2.compiler;

/* loaded from: grasscutter.jar:org/luaj/vm2/compiler/InstructionPtr.class */
class InstructionPtr {
    final int[] code;
    final int idx;

    /* access modifiers changed from: package-private */
    public InstructionPtr(int[] iArr, int i) {
        this.code = iArr;
        this.idx = i;
    }

    /* access modifiers changed from: package-private */
    public int get() {
        return this.code[this.idx];
    }

    /* access modifiers changed from: package-private */
    public void set(int i) {
        this.code[this.idx] = i;
    }
}
