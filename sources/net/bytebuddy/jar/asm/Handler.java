package net.bytebuddy.jar.asm;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/Handler.class */
public final class Handler {
    final Label startPc;
    final Label endPc;
    final Label handlerPc;
    final int catchType;
    final String catchTypeDescriptor;
    Handler nextHandler;

    /* access modifiers changed from: package-private */
    public Handler(Label startPc, Label endPc, Label handlerPc, int catchType, String catchTypeDescriptor) {
        this.startPc = startPc;
        this.endPc = endPc;
        this.handlerPc = handlerPc;
        this.catchType = catchType;
        this.catchTypeDescriptor = catchTypeDescriptor;
    }

    Handler(Handler handler, Label startPc, Label endPc) {
        this(startPc, endPc, handler.handlerPc, handler.catchType, handler.catchTypeDescriptor);
        this.nextHandler = handler.nextHandler;
    }

    /* access modifiers changed from: package-private */
    public static Handler removeRange(Handler firstHandler, Label start, Label end) {
        if (firstHandler == null) {
            return null;
        }
        firstHandler.nextHandler = removeRange(firstHandler.nextHandler, start, end);
        int handlerStart = firstHandler.startPc.bytecodeOffset;
        int handlerEnd = firstHandler.endPc.bytecodeOffset;
        int rangeStart = start.bytecodeOffset;
        int rangeEnd = end == null ? Integer.MAX_VALUE : end.bytecodeOffset;
        if (rangeStart >= handlerEnd || rangeEnd <= handlerStart) {
            return firstHandler;
        }
        if (rangeStart <= handlerStart) {
            if (rangeEnd >= handlerEnd) {
                return firstHandler.nextHandler;
            }
            return new Handler(firstHandler, end, firstHandler.endPc);
        } else if (rangeEnd >= handlerEnd) {
            return new Handler(firstHandler, firstHandler.startPc, start);
        } else {
            firstHandler.nextHandler = new Handler(firstHandler, end, firstHandler.endPc);
            return new Handler(firstHandler, firstHandler.startPc, start);
        }
    }

    static int getExceptionTableLength(Handler firstHandler) {
        int length = 0;
        for (Handler handler = firstHandler; handler != null; handler = handler.nextHandler) {
            length++;
        }
        return length;
    }

    /* access modifiers changed from: package-private */
    public static int getExceptionTableSize(Handler firstHandler) {
        return 2 + (8 * getExceptionTableLength(firstHandler));
    }

    /* access modifiers changed from: package-private */
    public static void putExceptionTable(Handler firstHandler, ByteVector output) {
        output.putShort(getExceptionTableLength(firstHandler));
        for (Handler handler = firstHandler; handler != null; handler = handler.nextHandler) {
            output.putShort(handler.startPc.bytecodeOffset).putShort(handler.endPc.bytecodeOffset).putShort(handler.handlerPc.bytecodeOffset).putShort(handler.catchType);
        }
    }
}
