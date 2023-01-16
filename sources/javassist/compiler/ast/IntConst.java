package javassist.compiler.ast;

import javassist.compiler.CompileError;

/* loaded from: grasscutter.jar:javassist/compiler/ast/IntConst.class */
public class IntConst extends ASTree {
    private static final long serialVersionUID = 1;
    protected long value;
    protected int type;

    public IntConst(long v, int tokenId) {
        this.value = v;
        this.type = tokenId;
    }

    public long get() {
        return this.value;
    }

    public void set(long v) {
        this.value = v;
    }

    public int getType() {
        return this.type;
    }

    @Override // javassist.compiler.ast.ASTree, java.lang.Object
    public String toString() {
        return Long.toString(this.value);
    }

    @Override // javassist.compiler.ast.ASTree
    public void accept(Visitor v) throws CompileError {
        v.atIntConst(this);
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r0v25, types: [long] */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r0v29, types: [long] */
    /* JADX WARN: Type inference failed for: r16v6 */
    /* JADX WARN: Type inference failed for: r0v31, types: [long] */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r0v33, types: [long] */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r0v35, types: [long] */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r0v37, types: [long] */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r0v39, types: [long] */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v13 */
    /* JADX WARN: Type inference failed for: r16v14 */
    /* JADX WARN: Type inference failed for: r16v15 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private javassist.compiler.ast.IntConst compute0(int r7, javassist.compiler.ast.IntConst r8) {
        /*
        // Method dump skipped, instructions count: 314
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.compiler.ast.IntConst.compute0(int, javassist.compiler.ast.IntConst):javassist.compiler.ast.IntConst");
    }

    /* JADX WARN: Type inference failed for: r0v9, types: [double] */
    /* JADX WARN: Type inference failed for: r0v11, types: [double] */
    /* JADX WARN: Type inference failed for: r0v13, types: [double] */
    /* JADX WARN: Type inference failed for: r0v15, types: [double] */
    /* JADX WARN: Type inference failed for: r0v17, types: [double] */
    private DoubleConst compute0(int op, DoubleConst right) {
        char c;
        double value1 = (double) this.value;
        double value2 = right.value;
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
        return new DoubleConst(c, right.type);
    }
}
