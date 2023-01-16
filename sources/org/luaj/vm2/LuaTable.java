package org.luaj.vm2;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.lang.ref.WeakReference;
import java.util.Vector;
import net.bytebuddy.jar.asm.Opcodes;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable.class */
public class LuaTable extends LuaValue implements Metatable {
    private static final int MIN_HASH_CAPACITY = 2;
    protected LuaValue[] array;
    protected Slot[] hash;
    protected int hashEntries;
    protected Metatable m_metatable;

    /* renamed from: N */
    private static final LuaString f3290N = valueOf("n");
    private static final Slot[] NOBUCKETS = new Slot[0];

    /* renamed from: org.luaj.vm2.LuaTable$1 */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$1.class */
    static class C58641 {
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$DeadSlot.class */
    private static class DeadSlot implements Slot {
        private final Object key;
        private Slot next;

        private DeadSlot(LuaValue luaValue, Slot slot) {
            this.key = LuaTable.isLargeKey(luaValue) ? new WeakReference(luaValue) : luaValue;
            this.next = slot;
        }

        private LuaValue key() {
            return (LuaValue) (this.key instanceof WeakReference ? ((WeakReference) this.key).get() : this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return 0;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot first() {
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot find(LuaValue luaValue) {
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            LuaValue key = key();
            return key != null && luaValue.raweq(key);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot rest() {
            return this.next;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return -1;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot set(StrongSlot strongSlot, LuaValue luaValue) {
            Slot slot = this.next != null ? this.next.set(strongSlot, luaValue) : null;
            if (key() == null) {
                return slot;
            }
            this.next = slot;
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot add(Slot slot) {
            return this.next != null ? this.next.add(slot) : slot;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot remove(StrongSlot strongSlot) {
            if (key() == null) {
                return this.next;
            }
            this.next = this.next.remove(strongSlot);
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot relink(Slot slot) {
            return slot;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<dead");
            LuaValue key = key();
            if (key != null) {
                stringBuffer.append(": ");
                stringBuffer.append(key.toString());
            }
            stringBuffer.append('>');
            if (this.next != null) {
                stringBuffer.append("; ");
                stringBuffer.append(this.next.toString());
            }
            return stringBuffer.toString();
        }

        DeadSlot(LuaValue luaValue, Slot slot, C58641 r7) {
            this(luaValue, slot);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$Entry.class */
    public static abstract class Entry extends Varargs implements StrongSlot {
        Entry() {
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public abstract LuaValue key();

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public abstract LuaValue value();

        abstract Entry set(LuaValue luaValue);

        @Override // org.luaj.vm2.LuaTable.Slot
        public abstract boolean keyeq(LuaValue luaValue);

        @Override // org.luaj.vm2.LuaTable.Slot
        public abstract int keyindex(int i);

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return 0;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            switch (i) {
                case 1:
                    return key();
                case 2:
                    return value();
                default:
                    return LuaValue.NIL;
            }
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return 2;
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public Varargs toVarargs() {
            return LuaValue.varargsOf(key(), value());
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return key();
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            switch (i) {
                case 1:
                    return this;
                case 2:
                    return value();
                default:
                    return LuaValue.NONE;
            }
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot first() {
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot rest() {
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot find(LuaValue luaValue) {
            if (keyeq(luaValue)) {
                return this;
            }
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot set(StrongSlot strongSlot, LuaValue luaValue) {
            return set(luaValue);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot add(Slot slot) {
            return new LinkSlot(this, slot);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot remove(StrongSlot strongSlot) {
            return new DeadSlot(key(), null, null);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot relink(Slot slot) {
            return slot != null ? new LinkSlot(this, slot) : this;
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$IntKeyEntry.class */
    public static class IntKeyEntry extends Entry {
        private final int key;
        private LuaValue value;

        IntKeyEntry(int i, LuaValue luaValue) {
            this.key = i;
            this.value = luaValue;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return LuaValue.valueOf(this.key);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            if (this.key < 1 || this.key > i) {
                return 0;
            }
            return this.key;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return this.value;
        }

        @Override // org.luaj.vm2.LuaTable.Entry
        public Entry set(LuaValue luaValue) {
            this.value = luaValue;
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashmod(LuaInteger.hashCode(this.key), i);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return luaValue.raweq(this.key);
        }
    }

    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$LinkSlot.class */
    private static class LinkSlot implements StrongSlot {
        private Entry entry;
        private Slot next;

        LinkSlot(Entry entry, Slot slot) {
            this.entry = entry;
            this.next = slot;
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return this.entry.key();
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return this.entry.keyindex(i);
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return this.entry.value();
        }

        @Override // org.luaj.vm2.LuaTable.StrongSlot
        public Varargs toVarargs() {
            return this.entry.toVarargs();
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot first() {
            return this.entry;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public StrongSlot find(LuaValue luaValue) {
            if (this.entry.keyeq(luaValue)) {
                return this;
            }
            return null;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return this.entry.keyeq(luaValue);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot rest() {
            return this.next;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public int arraykey(int i) {
            return this.entry.arraykey(i);
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot set(StrongSlot strongSlot, LuaValue luaValue) {
            if (strongSlot != this) {
                return setnext(this.next.set(strongSlot, luaValue));
            }
            this.entry = this.entry.set(luaValue);
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot add(Slot slot) {
            return setnext(this.next.add(slot));
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot remove(StrongSlot strongSlot) {
            if (this == strongSlot) {
                return new DeadSlot(key(), this.next, null);
            }
            this.next = this.next.remove(strongSlot);
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Slot
        public Slot relink(Slot slot) {
            return slot != null ? new LinkSlot(this.entry, slot) : this.entry;
        }

        private Slot setnext(Slot slot) {
            if (slot == null) {
                return this.entry;
            }
            this.next = slot;
            return this;
        }

        public String toString() {
            return new StringBuffer().append(this.entry).append("; ").append(this.next).toString();
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$NormalEntry.class */
    public static class NormalEntry extends Entry {
        private final LuaValue key;
        private LuaValue value;

        /* access modifiers changed from: package-private */
        public NormalEntry(LuaValue luaValue, LuaValue luaValue2) {
            this.key = luaValue;
            this.value = luaValue2;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return this.key;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return this.value;
        }

        @Override // org.luaj.vm2.LuaTable.Entry
        public Entry set(LuaValue luaValue) {
            this.value = luaValue;
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public Varargs toVarargs() {
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashSlot(this.key, i);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return luaValue.raweq(this.key);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$NumberValueEntry.class */
    public static class NumberValueEntry extends Entry {
        private double value;
        private final LuaValue key;

        NumberValueEntry(LuaValue luaValue, double d) {
            this.key = luaValue;
            this.value = d;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue key() {
            return this.key;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.StrongSlot
        public LuaValue value() {
            return LuaValue.valueOf(this.value);
        }

        @Override // org.luaj.vm2.LuaTable.Entry
        public Entry set(LuaValue luaValue) {
            LuaValue luaValue2 = luaValue.tonumber();
            if (luaValue2.isnil()) {
                return new NormalEntry(this.key, luaValue);
            }
            this.value = luaValue2.todouble();
            return this;
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public int keyindex(int i) {
            return LuaTable.hashSlot(this.key, i);
        }

        @Override // org.luaj.vm2.LuaTable.Entry, org.luaj.vm2.LuaTable.Slot
        public boolean keyeq(LuaValue luaValue) {
            return luaValue.raweq(this.key);
        }
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$Slot.class */
    public interface Slot {
        int keyindex(int i);

        StrongSlot first();

        StrongSlot find(LuaValue luaValue);

        boolean keyeq(LuaValue luaValue);

        Slot rest();

        int arraykey(int i);

        Slot set(StrongSlot strongSlot, LuaValue luaValue);

        Slot add(Slot slot);

        Slot remove(StrongSlot strongSlot);

        Slot relink(Slot slot);
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:org/luaj/vm2/LuaTable$StrongSlot.class */
    public interface StrongSlot extends Slot {
        LuaValue key();

        LuaValue value();

        Varargs toVarargs();
    }

    public LuaTable() {
        this.array = NOVALS;
        this.hash = NOBUCKETS;
    }

    public LuaTable(int i, int i2) {
        presize(i, i2);
    }

    public LuaTable(LuaValue[] luaValueArr, LuaValue[] luaValueArr2, Varargs varargs) {
        int length = luaValueArr != null ? luaValueArr.length : 0;
        int length2 = luaValueArr2 != null ? luaValueArr2.length : 0;
        presize(length2 + (varargs != null ? varargs.narg() : 0), length >> 1);
        for (int i = 0; i < length2; i++) {
            rawset(i + 1, luaValueArr2[i]);
        }
        if (varargs != null) {
            int narg = varargs.narg();
            for (int i2 = 1; i2 <= narg; i2++) {
                rawset(length2 + i2, varargs.arg(i2));
            }
        }
        for (int i3 = 0; i3 < length; i3 += 2) {
            if (!luaValueArr[i3 + 1].isnil()) {
                rawset(luaValueArr[i3], luaValueArr[i3 + 1]);
            }
        }
    }

    public LuaTable(Varargs varargs) {
        this(varargs, 1);
    }

    public LuaTable(Varargs varargs, int i) {
        int i2 = i - 1;
        int max = Math.max(varargs.narg() - i2, 0);
        presize(max, 1);
        set(f3290N, valueOf(max));
        for (int i3 = 1; i3 <= max; i3++) {
            set(i3, varargs.arg(i3 + i2));
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 5;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "table";
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean istable() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaTable checktable() {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaTable opttable(LuaTable luaTable) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public void presize(int i) {
        if (i > this.array.length) {
            this.array = resize(this.array, 1 << log2(i));
        }
    }

    public void presize(int i, int i2) {
        if (i2 > 0 && i2 < 2) {
            i2 = 2;
        }
        this.array = i > 0 ? new LuaValue[1 << log2(i)] : NOVALS;
        this.hash = i2 > 0 ? new Slot[1 << log2(i2)] : NOBUCKETS;
        this.hashEntries = 0;
    }

    private static LuaValue[] resize(LuaValue[] luaValueArr, int i) {
        LuaValue[] luaValueArr2 = new LuaValue[i];
        System.arraycopy(luaValueArr, 0, luaValueArr2, 0, luaValueArr.length);
        return luaValueArr2;
    }

    protected int getArrayLength() {
        return this.array.length;
    }

    protected int getHashLength() {
        return this.hash.length;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        if (this.m_metatable != null) {
            return this.m_metatable.toLuaValue();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x006f, code lost:
        if (r0 != (r3.m_metatable != null && r3.m_metatable.useWeakValues())) goto L_0x0072;
     */
    @Override // org.luaj.vm2.LuaValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.luaj.vm2.LuaValue setmetatable(org.luaj.vm2.LuaValue r4) {
        /*
            r3 = this;
            r0 = r3
            org.luaj.vm2.Metatable r0 = r0.m_metatable
            if (r0 == 0) goto L_0x0017
            r0 = r3
            org.luaj.vm2.Metatable r0 = r0.m_metatable
            boolean r0 = r0.useWeakKeys()
            if (r0 == 0) goto L_0x0017
            r0 = 1
            goto L_0x0018
        L_0x0017:
            r0 = 0
        L_0x0018:
            r5 = r0
            r0 = r3
            org.luaj.vm2.Metatable r0 = r0.m_metatable
            if (r0 == 0) goto L_0x0030
            r0 = r3
            org.luaj.vm2.Metatable r0 = r0.m_metatable
            boolean r0 = r0.useWeakValues()
            if (r0 == 0) goto L_0x0030
            r0 = 1
            goto L_0x0031
        L_0x0030:
            r0 = 0
        L_0x0031:
            r6 = r0
            r0 = r3
            r1 = r4
            org.luaj.vm2.Metatable r1 = metatableOf(r1)
            r0.m_metatable = r1
            r0 = r5
            r1 = r3
            org.luaj.vm2.Metatable r1 = r1.m_metatable
            if (r1 == 0) goto L_0x0052
            r1 = r3
            org.luaj.vm2.Metatable r1 = r1.m_metatable
            boolean r1 = r1.useWeakKeys()
            if (r1 == 0) goto L_0x0052
            r1 = 1
            goto L_0x0053
        L_0x0052:
            r1 = 0
        L_0x0053:
            if (r0 != r1) goto L_0x0072
            r0 = r6
            r1 = r3
            org.luaj.vm2.Metatable r1 = r1.m_metatable
            if (r1 == 0) goto L_0x006e
            r1 = r3
            org.luaj.vm2.Metatable r1 = r1.m_metatable
            boolean r1 = r1.useWeakValues()
            if (r1 == 0) goto L_0x006e
            r1 = 1
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            if (r0 == r1) goto L_0x0077
        L_0x0072:
            r0 = r3
            r1 = 0
            r0.rehash(r1)
        L_0x0077:
            r0 = r3
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.LuaTable.setmetatable(org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue get(int i) {
        LuaValue rawget = rawget(i);
        return (!rawget.isnil() || this.m_metatable == null) ? rawget : gettable(this, valueOf(i));
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue get(LuaValue luaValue) {
        LuaValue rawget = rawget(luaValue);
        return (!rawget.isnil() || this.m_metatable == null) ? rawget : gettable(this, luaValue);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue rawget(int i) {
        if (i <= 0 || i > this.array.length) {
            return hashget(LuaInteger.valueOf(i));
        }
        LuaValue arrayget = this.m_metatable == null ? this.array[i - 1] : this.m_metatable.arrayget(this.array, i - 1);
        return arrayget != null ? arrayget : NIL;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue rawget(LuaValue luaValue) {
        int i;
        if (!luaValue.isinttype() || (i = luaValue.toint()) <= 0 || i > this.array.length) {
            return hashget(luaValue);
        }
        LuaValue arrayget = this.m_metatable == null ? this.array[i - 1] : this.m_metatable.arrayget(this.array, i - 1);
        return arrayget != null ? arrayget : NIL;
    }

    protected LuaValue hashget(LuaValue luaValue) {
        if (this.hashEntries > 0) {
            for (Slot slot = this.hash[hashSlot(luaValue)]; slot != null; slot = slot.rest()) {
                StrongSlot find = slot.find(luaValue);
                if (find != null) {
                    return find.value();
                }
            }
        }
        return NIL;
    }

    @Override // org.luaj.vm2.LuaValue
    public void set(int i, LuaValue luaValue) {
        if (this.m_metatable == null || !rawget(i).isnil() || !settable(this, LuaInteger.valueOf(i), luaValue)) {
            rawset(i, luaValue);
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public void set(LuaValue luaValue, LuaValue luaValue2) {
        if (!luaValue.isvalidkey() && !metatag(NEWINDEX).isfunction()) {
            typerror("table index");
        }
        if (this.m_metatable == null || !rawget(luaValue).isnil() || !settable(this, luaValue, luaValue2)) {
            rawset(luaValue, luaValue2);
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public void rawset(int i, LuaValue luaValue) {
        if (!arrayset(i, luaValue)) {
            hashset(LuaInteger.valueOf(i), luaValue);
        }
    }

    @Override // org.luaj.vm2.LuaValue
    public void rawset(LuaValue luaValue, LuaValue luaValue2) {
        if (!luaValue.isinttype() || !arrayset(luaValue.toint(), luaValue2)) {
            hashset(luaValue, luaValue2);
        }
    }

    private boolean arrayset(int i, LuaValue luaValue) {
        if (i <= 0 || i > this.array.length) {
            return false;
        }
        this.array[i - 1] = luaValue.isnil() ? null : this.m_metatable != null ? this.m_metatable.wrap(luaValue) : luaValue;
        return true;
    }

    public LuaValue remove(int i) {
        int rawlen = rawlen();
        if (i == 0) {
            i = rawlen;
        } else if (i > rawlen) {
            return NONE;
        }
        LuaValue rawget = rawget(i);
        LuaValue luaValue = rawget;
        while (!luaValue.isnil()) {
            luaValue = rawget(i + 1);
            i++;
            rawset(i, luaValue);
        }
        return rawget.isnil() ? NONE : rawget;
    }

    public void insert(int i, LuaValue luaValue) {
        if (i == 0) {
            i = rawlen() + 1;
        }
        while (!luaValue.isnil()) {
            luaValue = rawget(i);
            i++;
            rawset(i, luaValue);
        }
    }

    public LuaValue concat(LuaString luaString, int i, int i2) {
        Buffer buffer = new Buffer();
        if (i <= i2) {
            buffer.append(get(i).checkstring());
            while (true) {
                i++;
                if (i > i2) {
                    break;
                }
                buffer.append(luaString);
                buffer.append(get(i).checkstring());
            }
        }
        return buffer.tostring();
    }

    @Override // org.luaj.vm2.LuaValue
    public int length() {
        return this.m_metatable != null ? len().toint() : rawlen();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue len() {
        LuaValue metatag = metatag(LEN);
        return metatag.toboolean() ? metatag.call(this) : LuaInteger.valueOf(rawlen());
    }

    @Override // org.luaj.vm2.LuaValue
    public int rawlen() {
        int arrayLength = getArrayLength();
        int i = arrayLength + 1;
        int i2 = 0;
        while (!rawget(i).isnil()) {
            i2 = i;
            i += arrayLength + getHashLength() + 1;
        }
        while (i > i2 + 1) {
            int i3 = (i + i2) / 2;
            if (!rawget(i3).isnil()) {
                i2 = i3;
            } else {
                i = i3;
            }
        }
        return i2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001f, code lost:
        if (r6 <= r4.array.length) goto L_0x0092;
     */
    @Override // org.luaj.vm2.LuaValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.luaj.vm2.Varargs next(org.luaj.vm2.LuaValue r5) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.LuaTable.next(org.luaj.vm2.LuaValue):org.luaj.vm2.Varargs");
    }

    @Override // org.luaj.vm2.LuaValue
    public Varargs inext(LuaValue luaValue) {
        int checkint = luaValue.checkint() + 1;
        LuaValue rawget = rawget(checkint);
        return rawget.isnil() ? NONE : varargsOf(LuaInteger.valueOf(checkint), rawget);
    }

    public void hashset(LuaValue luaValue, LuaValue luaValue2) {
        if (luaValue2.isnil()) {
            hashRemove(luaValue);
            return;
        }
        int i = 0;
        if (this.hash.length > 0) {
            i = hashSlot(luaValue);
            for (Slot slot = this.hash[i]; slot != null; slot = slot.rest()) {
                StrongSlot find = slot.find(luaValue);
                if (find != null) {
                    this.hash[i] = this.hash[i].set(find, luaValue2);
                    return;
                }
            }
        }
        if (checkLoadFactor()) {
            if (!luaValue.isinttype() || luaValue.toint() <= 0) {
                rehash(-1);
            } else {
                rehash(luaValue.toint());
                if (arrayset(luaValue.toint(), luaValue2)) {
                    return;
                }
            }
            i = hashSlot(luaValue);
        }
        Slot entry = this.m_metatable != null ? this.m_metatable.entry(luaValue, luaValue2) : defaultEntry(luaValue, luaValue2);
        this.hash[i] = this.hash[i] != null ? this.hash[i].add(entry) : entry;
        this.hashEntries++;
    }

    public static int hashpow2(int i, int i2) {
        return i & i2;
    }

    public static int hashmod(int i, int i2) {
        return (i & Integer.MAX_VALUE) % i2;
    }

    public static int hashSlot(LuaValue luaValue, int i) {
        switch (luaValue.type()) {
            case 2:
            case 3:
            case 5:
            case 7:
            case 8:
                return hashmod(luaValue.hashCode(), i);
            case 4:
            case 6:
            default:
                return hashpow2(luaValue.hashCode(), i);
        }
    }

    private int hashSlot(LuaValue luaValue) {
        return hashSlot(luaValue, this.hash.length - 1);
    }

    private void hashRemove(LuaValue luaValue) {
        if (this.hash.length > 0) {
            int hashSlot = hashSlot(luaValue);
            for (Slot slot = this.hash[hashSlot]; slot != null; slot = slot.rest()) {
                StrongSlot find = slot.find(luaValue);
                if (find != null) {
                    this.hash[hashSlot] = this.hash[hashSlot].remove(find);
                    this.hashEntries--;
                    return;
                }
            }
        }
    }

    private boolean checkLoadFactor() {
        return this.hashEntries >= this.hash.length;
    }

    private int countHashKeys() {
        int i = 0;
        for (int i2 = 0; i2 < this.hash.length; i2++) {
            for (Slot slot = this.hash[i2]; slot != null; slot = slot.rest()) {
                if (slot.first() != null) {
                    i++;
                }
            }
        }
        return i;
    }

    private void dropWeakArrayValues() {
        for (int i = 0; i < this.array.length; i++) {
            this.m_metatable.arrayget(this.array, i);
        }
    }

    private int countIntKeys(int[] iArr) {
        int i = 0;
        int i2 = 1;
        for (int i3 = 0; i3 < 31 && i2 <= this.array.length; i3++) {
            int min = Math.min(this.array.length, 1 << i3);
            int i4 = 0;
            while (i2 <= min) {
                i2++;
                if (this.array[i2 - 1] != null) {
                    i4++;
                }
            }
            iArr[i3] = i4;
            i += i4;
        }
        for (int i5 = 0; i5 < this.hash.length; i5++) {
            for (Slot slot = this.hash[i5]; slot != null; slot = slot.rest()) {
                int arraykey = slot.arraykey(Integer.MAX_VALUE);
                if (arraykey > 0) {
                    int log2 = log2(arraykey);
                    iArr[log2] = iArr[log2] + 1;
                    i++;
                }
            }
        }
        return i;
    }

    static int log2(int i) {
        int i2 = 0;
        int i3 = i - 1;
        if (i3 < 0) {
            return Integer.MIN_VALUE;
        }
        if ((i3 & Opcodes.V_PREVIEW) != 0) {
            i2 = 16;
            i3 >>>= 16;
        }
        if ((i3 & 65280) != 0) {
            i2 += 8;
            i3 >>>= 8;
        }
        if ((i3 & PacketOpcodes.ExecuteGadgetLuaRsp) != 0) {
            i2 += 4;
            i3 >>>= 4;
        }
        switch (i3) {
            case 0:
                return 0;
            case 1:
                i2++;
                break;
            case 2:
                i2 += 2;
                break;
            case 3:
                i2 += 2;
                break;
            case 4:
                i2 += 3;
                break;
            case 5:
                i2 += 3;
                break;
            case 6:
                i2 += 3;
                break;
            case 7:
                i2 += 3;
                break;
            case 8:
                i2 += 4;
                break;
            case 9:
                i2 += 4;
                break;
            case 10:
                i2 += 4;
                break;
            case 11:
                i2 += 4;
                break;
            case 12:
                i2 += 4;
                break;
            case 13:
                i2 += 4;
                break;
            case 14:
                i2 += 4;
                break;
            case 15:
                i2 += 4;
                break;
        }
        return i2;
    }

    private void rehash(int i) {
        LuaValue[] luaValueArr;
        int i2;
        Slot[] slotArr;
        Slot defaultEntry;
        if (this.m_metatable != null && (this.m_metatable.useWeakKeys() || this.m_metatable.useWeakValues())) {
            this.hashEntries = countHashKeys();
            if (this.m_metatable.useWeakValues()) {
                dropWeakArrayValues();
            }
        }
        int[] iArr = new int[32];
        int countIntKeys = countIntKeys(iArr);
        if (i > 0) {
            countIntKeys++;
            int log2 = log2(i);
            iArr[log2] = iArr[log2] + 1;
        }
        int i3 = iArr[0];
        int i4 = 0;
        for (int i5 = 1; i5 < 32; i5++) {
            i3 += iArr[i5];
            if (countIntKeys * 2 < (1 << i5)) {
                break;
            }
            if (i3 >= (1 << (i5 - 1))) {
                i4 = 1 << i5;
            }
        }
        LuaValue[] luaValueArr2 = this.array;
        Slot[] slotArr2 = this.hash;
        int i6 = 0;
        if (i > 0 && i <= i4) {
            i6 = 0 - 1;
        }
        if (i4 != luaValueArr2.length) {
            luaValueArr = new LuaValue[i4];
            if (i4 > luaValueArr2.length) {
                int log22 = log2(i4) + 1;
                for (int log23 = log2(luaValueArr2.length + 1); log23 < log22; log23++) {
                    i6 += iArr[log23];
                }
            } else if (luaValueArr2.length > i4) {
                int log24 = log2(luaValueArr2.length) + 1;
                for (int log25 = log2(i4 + 1); log25 < log24; log25++) {
                    i6 -= iArr[log25];
                }
            }
            System.arraycopy(luaValueArr2, 0, luaValueArr, 0, Math.min(luaValueArr2.length, i4));
        } else {
            luaValueArr = this.array;
        }
        int i7 = (this.hashEntries - i6) + ((i < 0 || i > i4) ? 1 : 0);
        int length = slotArr2.length;
        if (i7 > 0) {
            int log26 = i7 < 2 ? 2 : 1 << log2(i7);
            i2 = log26 - 1;
            slotArr = new Slot[log26];
        } else {
            i2 = 0;
            slotArr = NOBUCKETS;
        }
        for (int i8 = 0; i8 < length; i8++) {
            for (Slot slot = slotArr2[i8]; slot != null; slot = slot.rest()) {
                int arraykey = slot.arraykey(i4);
                if (arraykey > 0) {
                    StrongSlot first = slot.first();
                    if (first != null) {
                        luaValueArr[arraykey - 1] = first.value();
                    }
                } else {
                    int keyindex = slot.keyindex(i2);
                    slotArr[keyindex] = slot.relink(slotArr[keyindex]);
                }
            }
        }
        int i9 = i4;
        while (i9 < luaValueArr2.length) {
            i9++;
            LuaValue luaValue = luaValueArr2[i9];
            if (luaValue != null) {
                int hashmod = hashmod(LuaInteger.hashCode(i9), i2);
                if (this.m_metatable != null) {
                    defaultEntry = this.m_metatable.entry(valueOf(i9), luaValue);
                    if (defaultEntry == null) {
                    }
                } else {
                    defaultEntry = defaultEntry(valueOf(i9), luaValue);
                }
                slotArr[hashmod] = slotArr[hashmod] != null ? slotArr[hashmod].add(defaultEntry) : defaultEntry;
            }
        }
        this.hash = slotArr;
        this.array = luaValueArr;
        this.hashEntries -= i6;
    }

    @Override // org.luaj.vm2.Metatable
    public Slot entry(LuaValue luaValue, LuaValue luaValue2) {
        return defaultEntry(luaValue, luaValue2);
    }

    protected static boolean isLargeKey(LuaValue luaValue) {
        switch (luaValue.type()) {
            case 1:
            case 3:
                return false;
            case 2:
            default:
                return true;
            case 4:
                return luaValue.rawlen() > 32;
        }
    }

    /* access modifiers changed from: protected */
    public static Entry defaultEntry(LuaValue luaValue, LuaValue luaValue2) {
        return luaValue.isinttype() ? new IntKeyEntry(luaValue.toint(), luaValue2) : luaValue2.type() == 3 ? new NumberValueEntry(luaValue, luaValue2.todouble()) : new NormalEntry(luaValue, luaValue2);
    }

    public void sort(LuaValue luaValue) {
        if (this.m_metatable != null && this.m_metatable.useWeakValues()) {
            dropWeakArrayValues();
        }
        int length = this.array.length;
        while (length > 0 && this.array[length - 1] == null) {
            length--;
        }
        if (length > 1) {
            heapSort(length, luaValue);
        }
    }

    private void heapSort(int i, LuaValue luaValue) {
        heapify(i, luaValue);
        int i2 = i - 1;
        while (i2 > 0) {
            swap(i2, 0);
            i2--;
            siftDown(0, i2, luaValue);
        }
    }

    private void heapify(int i, LuaValue luaValue) {
        for (int i2 = (i / 2) - 1; i2 >= 0; i2--) {
            siftDown(i2, i - 1, luaValue);
        }
    }

    private void siftDown(int i, int i2, LuaValue luaValue) {
        int i3;
        for (int i4 = i; (i4 * 2) + 1 <= i2; i4 = i3) {
            i3 = (i4 * 2) + 1;
            if (i3 < i2 && compare(i3, i3 + 1, luaValue)) {
                i3++;
            }
            if (compare(i4, i3, luaValue)) {
                swap(i4, i3);
            } else {
                return;
            }
        }
    }

    private boolean compare(int i, int i2, LuaValue luaValue) {
        LuaValue luaValue2;
        LuaValue luaValue3;
        if (this.m_metatable == null) {
            luaValue3 = this.array[i];
            luaValue2 = this.array[i2];
        } else {
            luaValue3 = this.m_metatable.arrayget(this.array, i);
            luaValue2 = this.m_metatable.arrayget(this.array, i2);
        }
        if (luaValue3 == null || luaValue2 == null) {
            return false;
        }
        return !luaValue.isnil() ? luaValue.call(luaValue3, luaValue2).toboolean() : luaValue3.lt_b(luaValue2);
    }

    private void swap(int i, int i2) {
        LuaValue luaValue = this.array[i];
        this.array[i] = this.array[i2];
        this.array[i2] = luaValue;
    }

    public int keyCount() {
        LuaValue luaValue = LuaValue.NIL;
        int i = 0;
        while (true) {
            LuaValue arg1 = next(luaValue).arg1();
            luaValue = arg1;
            if (arg1.isnil()) {
                return i;
            }
            i++;
        }
    }

    public LuaValue[] keys() {
        Vector vector = new Vector();
        LuaValue luaValue = LuaValue.NIL;
        while (true) {
            LuaValue arg1 = next(luaValue).arg1();
            luaValue = arg1;
            if (arg1.isnil()) {
                LuaValue[] luaValueArr = new LuaValue[vector.size()];
                vector.copyInto(luaValueArr);
                return luaValueArr;
            }
            vector.addElement(luaValue);
        }
    }

    @Override // org.luaj.vm2.LuaValue
    /* renamed from: eq */
    public LuaValue mo24eq(LuaValue luaValue) {
        return eq_b(luaValue) ? TRUE : FALSE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean eq_b(LuaValue luaValue) {
        LuaValue luaValue2;
        if (this == luaValue) {
            return true;
        }
        return this.m_metatable != null && luaValue.istable() && (luaValue2 = luaValue.getmetatable()) != null && LuaValue.eqmtcall(this, this.m_metatable.toLuaValue(), luaValue, luaValue2);
    }

    public Varargs unpack() {
        return unpack(1, rawlen());
    }

    public Varargs unpack(int i) {
        return unpack(i, rawlen());
    }

    public Varargs unpack(int i, int i2) {
        int i3 = (i2 + 1) - i;
        switch (i3) {
            case 0:
                return NONE;
            case 1:
                return get(i);
            case 2:
                return varargsOf(get(i), get(i + 1));
            default:
                if (i3 < 0) {
                    return NONE;
                }
                LuaValue[] luaValueArr = new LuaValue[i3];
                while (true) {
                    i3--;
                    if (i3 < 0) {
                        return varargsOf(luaValueArr);
                    }
                    luaValueArr[i3] = get(i + i3);
                }
        }
    }

    @Override // org.luaj.vm2.Metatable
    public boolean useWeakKeys() {
        return false;
    }

    @Override // org.luaj.vm2.Metatable
    public boolean useWeakValues() {
        return false;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue toLuaValue() {
        return this;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue wrap(LuaValue luaValue) {
        return luaValue;
    }

    @Override // org.luaj.vm2.Metatable
    public LuaValue arrayget(LuaValue[] luaValueArr, int i) {
        return luaValueArr[i];
    }
}
