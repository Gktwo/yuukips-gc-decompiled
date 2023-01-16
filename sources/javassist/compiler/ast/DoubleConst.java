package javassist.compiler.ast;

import javassist.compiler.CompileError;

/* loaded from: grasscutter.jar:javassist/compiler/ast/DoubleConst.class */
public class DoubleConst extends ASTree {
    private static final long serialVersionUID = 1;
    protected double value;
    protected int type;

    public DoubleConst(double v, int tokenId) {
        this.value = v;
        this.type = tokenId;
    }

    public double get() {
        return this.value;
    }

    public void set(double v) {
        this.value = v;
    }

    public int getType() {
        return this.type;
    }

    @Override // javassist.compiler.ast.ASTree, java.lang.Object
    public String toString() {
        return Double.toString(this.value);
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(Visitor v) throws CompileError {
        v.atDoubleConst(this);
    }

    public ASTree compute(int op, ASTree right) {
        if (right instanceof IntConst) {
            return compute0(op, (IntConst) right);
        }
        if (right instanceof DoubleConst) {
            return compute0(op, (DoubleConst) right);
        }
        return null;
    }

    private DoubleConst compute0(int op, DoubleConst right) {
        int newType;
        if (this.type == 405 || right.type == 405) {
            newType = 405;
        } else {
            newType = 404;
        }
        return compute(op, this.value, right.value, newType);
    }

    private DoubleConst compute0(int op, IntConst right) {
        return compute(op, this.value, (double) right.value, this.type);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [double] */
    /* JADX WARN: Type inference failed for: r0v6, types: [double] */
    /* JADX WARN: Type inference failed for: r0v8, types: [double] */
    /* JADX WARN: Type inference failed for: r0v10, types: [double] */
    /* JADX WARN: Type inference failed for: r0v12, types: [double] */
    private static DoubleConst compute(int op, double value1, double value2, int newType) {
        char c;
        switch (op) {
            case 37:
                c = value1 % value2;
                break;
            case 38:
            case 39:
            case 40:
            case 41:
            case 44:
            case 46:
            default:
                return null;
            case 42:
                c = value1 * value2;
                break;
            case 43:
                c = value1 + value2;
                break;
            case 45:
                c = value1 - value2;
                break;
            case 47:
                c = value1 / value2;
                break;
        }
        return new DoubleConst(c, newType);
    }
}
