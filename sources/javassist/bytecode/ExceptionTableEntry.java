package javassist.bytecode;

/* compiled from: ExceptionTable.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:javassist/bytecode/ExceptionTableEntry.class */
public class ExceptionTableEntry {
    int startPc;
    int endPc;
    int handlerPc;
    int catchType;

    /* access modifiers changed from: package-private */
    public ExceptionTableEntry(int start, int end, int handle, int type) {
        this.startPc = start;
        this.endPc = end;
        this.handlerPc = handle;
        this.catchType = type;
    }
}
