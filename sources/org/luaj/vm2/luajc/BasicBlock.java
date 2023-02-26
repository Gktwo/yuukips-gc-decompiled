package org.luaj.vm2.luajc;

import java.util.Vector;
import org.luaj.vm2.Lua;
import org.luaj.vm2.Prototype;

/* loaded from: grasscutter.jar:org/luaj/vm2/luajc/BasicBlock.class */
public class BasicBlock {
    int pc0;
    int pc1;
    BasicBlock[] prev;
    BasicBlock[] next;
    boolean islive;

    /* renamed from: org.luaj.vm2.luajc.BasicBlock$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/BasicBlock$1.class */
    static class C58721 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/BasicBlock$AllocAndXRefVisitor.class */
    private static final class AllocAndXRefVisitor extends BranchVisitor {
        private final int[] nnext;
        private final int[] nprev;
        private final BasicBlock[] blocks;

        private AllocAndXRefVisitor(boolean[] zArr, int[] iArr, int[] iArr2, BasicBlock[] basicBlockArr) {
            super(zArr);
            this.nnext = iArr;
            this.nprev = iArr2;
            this.blocks = basicBlockArr;
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitBranch(int i, int i2) {
            if (this.blocks[i].next == null) {
                this.blocks[i].next = new BasicBlock[this.nnext[i]];
            }
            if (this.blocks[i2].prev == null) {
                this.blocks[i2].prev = new BasicBlock[this.nprev[i2]];
            }
            BasicBlock[] basicBlockArr = this.blocks[i].next;
            int[] iArr = this.nnext;
            int i3 = iArr[i] - 1;
            iArr[i] = i3;
            basicBlockArr[i3] = this.blocks[i2];
            BasicBlock[] basicBlockArr2 = this.blocks[i2].prev;
            int[] iArr2 = this.nprev;
            int i4 = iArr2[i2] - 1;
            iArr2[i2] = i4;
            basicBlockArr2[i4] = this.blocks[i];
        }

        AllocAndXRefVisitor(boolean[] zArr, int[] iArr, int[] iArr2, BasicBlock[] basicBlockArr, C58721 r11) {
            this(zArr, iArr, iArr2, basicBlockArr);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/BasicBlock$BranchVisitor.class */
    public static abstract class BranchVisitor {
        final boolean[] isbeg;

        public BranchVisitor(boolean[] zArr) {
            this.isbeg = zArr;
        }

        public void visitBranch(int i, int i2) {
        }

        public void visitReturn(int i) {
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/BasicBlock$CountPrevNextVistor.class */
    private static final class CountPrevNextVistor extends BranchVisitor {
        private final int[] nnext;
        private final int[] nprev;

        private CountPrevNextVistor(boolean[] zArr, int[] iArr, int[] iArr2) {
            super(zArr);
            this.nnext = iArr;
            this.nprev = iArr2;
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitBranch(int i, int i2) {
            int[] iArr = this.nnext;
            iArr[i] = iArr[i] + 1;
            int[] iArr2 = this.nprev;
            iArr2[i2] = iArr2[i2] + 1;
        }

        CountPrevNextVistor(boolean[] zArr, int[] iArr, int[] iArr2, C58721 r9) {
            this(zArr, iArr, iArr2);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/BasicBlock$MarkAndMergeVisitor.class */
    private static final class MarkAndMergeVisitor extends BranchVisitor {
        private final boolean[] isend;

        private MarkAndMergeVisitor(boolean[] zArr, boolean[] zArr2) {
            super(zArr);
            this.isend = zArr2;
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitBranch(int i, int i2) {
            this.isend[i] = true;
            this.isbeg[i2] = true;
        }

        @Override // org.luaj.vm2.luajc.BasicBlock.BranchVisitor
        public void visitReturn(int i) {
            this.isend[i] = true;
        }

        MarkAndMergeVisitor(boolean[] zArr, boolean[] zArr2, C58721 r7) {
            this(zArr, zArr2);
        }
    }

    public BasicBlock(Prototype prototype, int i) {
        this.pc1 = i;
        this.pc0 = i;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(new StringBuffer().append(this.pc0 + 1).append("-").append(this.pc1 + 1).append(this.prev != null ? new StringBuffer().append("  prv: ").append(str(this.prev, 1)).toString() : "").append(this.next != null ? new StringBuffer().append("  nxt: ").append(str(this.next, 0)).toString() : "").append("\n").toString());
        return stringBuffer.toString();
    }

    private String str(BasicBlock[] basicBlockArr, int i) {
        if (basicBlockArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("(");
        int length = basicBlockArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 > 0) {
                stringBuffer.append(",");
            }
            stringBuffer.append(String.valueOf((i == 1 ? basicBlockArr[i2].pc1 : basicBlockArr[i2].pc0) + 1));
        }
        stringBuffer.append(")");
        return stringBuffer.toString();
    }

    public static BasicBlock[] findBasicBlocks(Prototype prototype) {
        int length = prototype.code.length;
        boolean[] zArr = new boolean[length];
        boolean[] zArr2 = new boolean[length];
        zArr[0] = true;
        MarkAndMergeVisitor markAndMergeVisitor = new MarkAndMergeVisitor(zArr, zArr2, null);
        visitBranches(prototype, markAndMergeVisitor);
        visitBranches(prototype, markAndMergeVisitor);
        BasicBlock[] basicBlockArr = new BasicBlock[length];
        int i = 0;
        while (i < length) {
            zArr[i] = true;
            BasicBlock basicBlock = new BasicBlock(prototype, i);
            basicBlockArr[i] = basicBlock;
            while (!zArr2[i] && i + 1 < length && !zArr[i + 1]) {
                i++;
                basicBlock.pc1 = i;
                basicBlockArr[i] = basicBlock;
            }
            i++;
        }
        int[] iArr = new int[length];
        int[] iArr2 = new int[length];
        visitBranches(prototype, new CountPrevNextVistor(zArr, iArr, iArr2, null));
        visitBranches(prototype, new AllocAndXRefVisitor(zArr, iArr, iArr2, basicBlockArr, null));
        return basicBlockArr;
    }

    public static void visitBranches(Prototype prototype, BranchVisitor branchVisitor) {
        int[] iArr = prototype.code;
        int length = iArr.length;
        int i = 0;
        while (i < length) {
            int i2 = iArr[i];
            switch (Lua.GET_OPCODE(i2)) {
                case 3:
                    if (0 != Lua.GETARG_C(i2)) {
                        if (Lua.GET_OPCODE(iArr[i + 1]) == 23) {
                            throw new IllegalArgumentException(new StringBuffer().append("OP_LOADBOOL followed by jump at ").append(i).toString());
                        }
                        branchVisitor.visitBranch(i, i + 2);
                        continue;
                        i++;
                    }
                    break;
                case 23:
                case 33:
                    branchVisitor.visitBranch(i, i + Lua.GETARG_sBx(i2) + 1);
                    continue;
                    i++;
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                    if (Lua.GET_OPCODE(iArr[i + 1]) != 23) {
                        throw new IllegalArgumentException(new StringBuffer().append("test not followed by jump at ").append(i).toString());
                    }
                    i++;
                    branchVisitor.visitBranch(i, i + Lua.GETARG_sBx(iArr[i + 1]) + 1);
                    branchVisitor.visitBranch(i, i + 1);
                    continue;
                    i++;
                case 30:
                case 31:
                    branchVisitor.visitReturn(i);
                    continue;
                    i++;
                case 32:
                case 35:
                    branchVisitor.visitBranch(i, i + Lua.GETARG_sBx(i2) + 1);
                    branchVisitor.visitBranch(i, i + 1);
                    continue;
                    i++;
            }
            if (i + 1 < length && branchVisitor.isbeg[i + 1]) {
                branchVisitor.visitBranch(i, i + 1);
            }
            i++;
        }
    }

    public static BasicBlock[] findLiveBlocks(BasicBlock[] basicBlockArr) {
        Vector vector = new Vector();
        vector.addElement(basicBlockArr[0]);
        while (!vector.isEmpty()) {
            BasicBlock basicBlock = (BasicBlock) vector.elementAt(0);
            vector.removeElementAt(0);
            if (!basicBlock.islive) {
                basicBlock.islive = true;
                int length = basicBlock.next != null ? basicBlock.next.length : 0;
                for (int i = 0; i < length; i++) {
                    if (!basicBlock.next[i].islive) {
                        vector.addElement(basicBlock.next[i]);
                    }
                }
            }
        }
        Vector vector2 = new Vector();
        int i2 = 0;
        while (i2 < basicBlockArr.length) {
            if (basicBlockArr[i2].islive) {
                vector2.addElement(basicBlockArr[i2]);
            }
            i2 = basicBlockArr[i2].pc1 + 1;
        }
        BasicBlock[] basicBlockArr2 = new BasicBlock[vector2.size()];
        vector2.copyInto(basicBlockArr2);
        return basicBlockArr2;
    }
}
