package org.luaj.vm2.luajc;

import dev.morphia.mapping.Mapper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* loaded from: grasscutter.jar:org/luaj/vm2/luajc/VarInfo.class */
public class VarInfo {
    public static VarInfo INVALID = new VarInfo(-1, -1);
    public final int slot;

    /* renamed from: pc */
    public final int f3316pc;
    public UpvalInfo upvalue;
    public boolean allocupvalue;
    public boolean isreferenced;

    /* access modifiers changed from: package-private */
    /* renamed from: org.luaj.vm2.luajc.VarInfo$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/VarInfo$1.class */
    public static class C58731 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/VarInfo$NilVarInfo.class */
    private static final class NilVarInfo extends VarInfo {
        private NilVarInfo(int i, int i2) {
            super(i, i2);
        }

        @Override // org.luaj.vm2.luajc.VarInfo
        public String toString() {
            return "nil";
        }

        NilVarInfo(int i, int i2, C58731 r7) {
            this(i, i2);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/VarInfo$ParamVarInfo.class */
    public static final class ParamVarInfo extends VarInfo {
        private ParamVarInfo(int i, int i2) {
            super(i, i2);
        }

        @Override // org.luaj.vm2.luajc.VarInfo
        public String toString() {
            return new StringBuffer().append(this.slot).append(".p").toString();
        }

        ParamVarInfo(int i, int i2, C58731 r7) {
            this(i, i2);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/luajc/VarInfo$PhiVarInfo.class */
    private static final class PhiVarInfo extends VarInfo {

        /* renamed from: pi */
        private final ProtoInfo f3317pi;
        VarInfo[] values;

        private PhiVarInfo(ProtoInfo protoInfo, int i, int i2) {
            super(i, i2);
            this.f3317pi = protoInfo;
        }

        @Override // org.luaj.vm2.luajc.VarInfo
        public boolean isPhiVar() {
            return true;
        }

        @Override // org.luaj.vm2.luajc.VarInfo
        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(toString());
            stringBuffer.append("={");
            int length = this.values != null ? this.values.length : 0;
            for (int i = 0; i < length; i++) {
                if (i > 0) {
                    stringBuffer.append(",");
                }
                stringBuffer.append(String.valueOf(this.values[i]));
            }
            stringBuffer.append("}");
            return stringBuffer.toString();
        }

        @Override // org.luaj.vm2.luajc.VarInfo
        public VarInfo resolvePhiVariableValues() {
            HashSet hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            collectUniqueValues(hashSet, hashSet2);
            if (hashSet2.contains(INVALID)) {
                return INVALID;
            }
            int size = hashSet2.size();
            Iterator it = hashSet2.iterator();
            if (size == 1) {
                VarInfo varInfo = (VarInfo) it.next();
                varInfo.isreferenced |= this.isreferenced;
                return varInfo;
            }
            this.values = new VarInfo[size];
            for (int i = 0; i < size; i++) {
                this.values[i] = (VarInfo) it.next();
                this.values[i].isreferenced |= this.isreferenced;
            }
            return null;
        }

        @Override // org.luaj.vm2.luajc.VarInfo
        protected void collectUniqueValues(Set set, Set set2) {
            BasicBlock basicBlock = this.f3317pi.blocks[this.f3316pc];
            if (this.f3316pc == 0) {
                set2.add(this.f3317pi.params[this.slot]);
            }
            int length = basicBlock.prev != null ? basicBlock.prev.length : 0;
            for (int i = 0; i < length; i++) {
                BasicBlock basicBlock2 = basicBlock.prev[i];
                if (!set.contains(basicBlock2)) {
                    set.add(basicBlock2);
                    VarInfo varInfo = this.f3317pi.vars[this.slot][basicBlock2.pc1];
                    if (varInfo != null) {
                        varInfo.collectUniqueValues(set, set2);
                    }
                }
            }
        }

        PhiVarInfo(ProtoInfo protoInfo, int i, int i2, C58731 r9) {
            this(protoInfo, i, i2);
        }
    }

    public static VarInfo PARAM(int i) {
        return new ParamVarInfo(i, -1, null);
    }

    public static VarInfo NIL(int i) {
        return new NilVarInfo(i, -1, null);
    }

    public static VarInfo PHI(ProtoInfo protoInfo, int i, int i2) {
        return new PhiVarInfo(protoInfo, i, i2, null);
    }

    public VarInfo(int i, int i2) {
        this.slot = i;
        this.f3316pc = i2;
    }

    public String toString() {
        return this.slot < 0 ? "x.x" : new StringBuffer().append(this.slot).append(Mapper.IGNORED_FIELDNAME).append(this.f3316pc).toString();
    }

    public VarInfo resolvePhiVariableValues() {
        return null;
    }

    protected void collectUniqueValues(Set set, Set set2) {
        set2.add(this);
    }

    public boolean isPhiVar() {
        return false;
    }
}
