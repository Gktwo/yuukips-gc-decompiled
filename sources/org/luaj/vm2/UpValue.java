package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/UpValue.class */
public final class UpValue {
    LuaValue[] array;
    int index;

    public UpValue(LuaValue[] luaValueArr, int i) {
        this.array = luaValueArr;
        this.index = i;
    }

    public String toString() {
        return new StringBuffer().append(this.index).append("/").append(this.array.length).append(" ").append(this.array[this.index]).toString();
    }

    public String tojstring() {
        return this.array[this.index].tojstring();
    }

    public final LuaValue getValue() {
        return this.array[this.index];
    }

    public final void setValue(LuaValue luaValue) {
        this.array[this.index] = luaValue;
    }

    public final void close() {
        LuaValue[] luaValueArr = this.array;
        this.array = new LuaValue[]{luaValueArr[this.index]};
        luaValueArr[this.index] = null;
        this.index = 0;
    }
}
