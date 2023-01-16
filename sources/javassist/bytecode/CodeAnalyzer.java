package javassist.bytecode;

/* loaded from: grasscutter.jar:javassist/bytecode/CodeAnalyzer.class */
class CodeAnalyzer implements Opcode {
    private ConstPool constPool;
    private CodeAttribute codeAttr;

    public CodeAnalyzer(CodeAttribute ca) {
        this.codeAttr = ca;
        this.constPool = ca.getConstPool();
    }

    public int computeMaxStack() throws BadBytecode {
        boolean repeat;
        CodeIterator ci = this.codeAttr.iterator();
        int length = ci.getCodeLength();
        int[] stack = new int[length];
        this.constPool = this.codeAttr.getConstPool();
        initStack(stack, this.codeAttr);
        do {
            repeat = false;
            for (int i = 0; i < length; i++) {
                if (stack[i] < 0) {
                    repeat = true;
                    visitBytecode(ci, stack, i);
                }
            }
        } while (repeat);
        int maxStack = 1;
        for (int i2 = 0; i2 < length; i2++) {
            if (stack[i2] > maxStack) {
                maxStack = stack[i2];
            }
        }
        return maxStack - 1;
    }

    private void initStack(int[] stack, CodeAttribute ca) {
        stack[0] = -1;
        ExceptionTable et = ca.getExceptionTable();
        if (et != null) {
            int size = et.size();
            for (int i = 0; i < size; i++) {
                stack[et.handlerPc(i)] = -2;
            }
        }
    }

    private void visitBytecode(CodeIterator ci, int[] stack, int index) throws BadBytecode {
        int codeLength = stack.length;
        ci.move(index);
        int stackDepth = -stack[index];
        int[] jsrDepth = {-1};
        while (ci.hasNext()) {
            int index2 = ci.next();
            stack[index2] = stackDepth;
            int op = ci.byteAt(index2);
            stackDepth = visitInst(op, ci, index2, stackDepth);
            if (stackDepth < 1) {
                throw new BadBytecode("stack underflow at " + index2);
            } else if (processBranch(op, ci, index2, codeLength, stack, stackDepth, jsrDepth) || isEnd(op)) {
                return;
            } else {
                if (op == 168 || op == 201) {
                    stackDepth--;
                }
            }
        }
    }

    private boolean processBranch(int opcode, CodeIterator ci, int index, int codeLength, int[] stack, int stackDepth, int[] jsrDepth) throws BadBytecode {
        int target;
        if ((153 <= opcode && opcode <= 166) || opcode == 198 || opcode == 199) {
            checkTarget(index, index + ci.s16bitAt(index + 1), codeLength, stack, stackDepth);
            return false;
        }
        switch (opcode) {
            case 167:
                checkTarget(index, index + ci.s16bitAt(index + 1), codeLength, stack, stackDepth);
                return true;
            case 168:
            case 201:
                if (opcode == 168) {
                    target = index + ci.s16bitAt(index + 1);
                } else {
                    target = index + ci.s32bitAt(index + 1);
                }
                checkTarget(index, target, codeLength, stack, stackDepth);
                if (jsrDepth[0] < 0) {
                    jsrDepth[0] = stackDepth;
                    return false;
                } else if (stackDepth == jsrDepth[0]) {
                    return false;
                } else {
                    throw new BadBytecode("sorry, cannot compute this data flow due to JSR: " + stackDepth + "," + jsrDepth[0]);
                }
            case 169:
                if (jsrDepth[0] < 0) {
                    jsrDepth[0] = stackDepth + 1;
                    return false;
                } else if (stackDepth + 1 == jsrDepth[0]) {
                    return true;
                } else {
                    throw new BadBytecode("sorry, cannot compute this data flow due to RET: " + stackDepth + "," + jsrDepth[0]);
                }
            case 170:
            case 171:
                int index2 = (index & -4) + 4;
                checkTarget(index, index + ci.s32bitAt(index2), codeLength, stack, stackDepth);
                if (opcode == 171) {
                    int npairs = ci.s32bitAt(index2 + 4);
                    int index22 = index2 + 12;
                    for (int i = 0; i < npairs; i++) {
                        checkTarget(index, index + ci.s32bitAt(index22), codeLength, stack, stackDepth);
                        index22 += 8;
                    }
                    return true;
                }
                int n = (ci.s32bitAt(index2 + 8) - ci.s32bitAt(index2 + 4)) + 1;
                int index23 = index2 + 12;
                for (int i2 = 0; i2 < n; i2++) {
                    checkTarget(index, index + ci.s32bitAt(index23), codeLength, stack, stackDepth);
                    index23 += 4;
                }
                return true;
            case 200:
                checkTarget(index, index + ci.s32bitAt(index + 1), codeLength, stack, stackDepth);
                return true;
            default:
                return false;
        }
    }

    private void checkTarget(int opIndex, int target, int codeLength, int[] stack, int stackDepth) throws BadBytecode {
        if (target < 0 || codeLength <= target) {
            throw new BadBytecode("bad branch offset at " + opIndex);
        }
        int d = stack[target];
        if (d == 0) {
            stack[target] = -stackDepth;
        } else if (d != stackDepth && d != (-stackDepth)) {
            throw new BadBytecode("verification error (" + stackDepth + "," + d + ") at " + opIndex);
        }
    }

    private static boolean isEnd(int opcode) {
        return (172 <= opcode && opcode <= 177) || opcode == 191;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    private int visitInst(int op, CodeIterator ci, int index, int stack) throws BadBytecode {
        int stack2;
        switch (op) {
            case 178:
                stack2 = stack + getFieldSize(ci, index);
                break;
            case 179:
                stack2 = stack - getFieldSize(ci, index);
                break;
            case 180:
                stack2 = stack + (getFieldSize(ci, index) - 1);
                break;
            case 181:
                stack2 = stack - (getFieldSize(ci, index) + 1);
                break;
            case 182:
            case 183:
                stack2 = stack + (Descriptor.dataSize(this.constPool.getMethodrefType(ci.u16bitAt(index + 1))) - 1);
                break;
            case 184:
                stack2 = stack + Descriptor.dataSize(this.constPool.getMethodrefType(ci.u16bitAt(index + 1)));
                break;
            case 185:
                stack2 = stack + (Descriptor.dataSize(this.constPool.getInterfaceMethodrefType(ci.u16bitAt(index + 1))) - 1);
                break;
            case 186:
                stack2 = stack + Descriptor.dataSize(this.constPool.getInvokeDynamicType(ci.u16bitAt(index + 1)));
                break;
            case 187:
            case 188:
            case 189:
            case 190:
            case 192:
            case 193:
            case 194:
            case 195:
            default:
                stack2 = stack + STACK_GROW[op];
                break;
            case 191:
                stack2 = 1;
                break;
            case 196:
                op = ci.byteAt(index + 1);
                stack2 = stack + STACK_GROW[op];
                break;
            case 197:
                stack2 = stack + (1 - ci.byteAt(index + 3));
                break;
        }
        return stack2;
    }

    private int getFieldSize(CodeIterator ci, int index) {
        return Descriptor.dataSize(this.constPool.getFieldrefType(ci.u16bitAt(index + 1)));
    }
}
