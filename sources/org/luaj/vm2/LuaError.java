package org.luaj.vm2;

/* loaded from: grasscutter.jar:org/luaj/vm2/LuaError.class */
public class LuaError extends RuntimeException {
    private static final long serialVersionUID = 1;
    protected int level;
    protected String fileline;
    protected String traceback;
    protected Throwable cause;
    private LuaValue object;

    @Override // java.lang.Throwable
    public String getMessage() {
        if (this.traceback != null) {
            return this.traceback;
        }
        String message = getMessage();
        if (message == null) {
            return null;
        }
        return this.fileline != null ? new StringBuffer().append(this.fileline).append(" ").append(message).toString() : message;
    }

    public LuaValue getMessageObject() {
        if (this.object != null) {
            return this.object;
        }
        String message = getMessage();
        if (message != null) {
            return LuaValue.valueOf(message);
        }
        return null;
    }

    public LuaError(Throwable th) {
        super(new StringBuffer().append("vm error: ").append(th).toString());
        this.cause = th;
        this.level = 1;
    }

    public LuaError(String str) {
        super(str);
        this.level = 1;
    }

    public LuaError(String str, int i) {
        super(str);
        this.level = i;
    }

    public LuaError(LuaValue luaValue) {
        super(luaValue.tojstring());
        this.object = luaValue;
        this.level = 1;
    }

    @Override // java.lang.Throwable
    public Throwable getCause() {
        return this.cause;
    }
}
