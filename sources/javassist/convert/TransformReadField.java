package javassist.convert;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.BadBytecode;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;

/* loaded from: grasscutter.jar:javassist/convert/TransformReadField.class */
public class TransformReadField extends Transformer {
    protected String fieldname;
    protected CtClass fieldClass;
    protected boolean isPrivate;
    protected String methodClassname;
    protected String methodName;

    public TransformReadField(Transformer next, CtField field, String methodClassname, String methodName) {
        super(next);
        this.fieldClass = field.getDeclaringClass();
        this.fieldname = field.getName();
        this.methodClassname = methodClassname;
        this.methodName = methodName;
        this.isPrivate = Modifier.isPrivate(field.getModifiers());
    }

    /* access modifiers changed from: package-private */
    public static String isField(ClassPool pool, ConstPool cp, CtClass fclass, String fname, boolean is_private, int index) {
        if (!cp.getFieldrefName(index).equals(fname)) {
            return null;
        }
        try {
            CtClass c = pool.get(cp.getFieldrefClassName(index));
            if (c == fclass || (!is_private && isFieldInSuper(c, fclass, fname))) {
                return cp.getFieldrefType(index);
            }
            return null;
        } catch (NotFoundException e) {
            return null;
        }
    }

    static boolean isFieldInSuper(CtClass clazz, CtClass fclass, String fname) {
        if (!clazz.subclassOf(fclass)) {
            return false;
        }
        try {
            return clazz.getField(fname).getDeclaringClass() == fclass;
        } catch (NotFoundException e) {
            return false;
        }
    }

    @Override // javassist.convert.Transformer
    public int transform(CtClass tclazz, int pos, CodeIterator iterator, ConstPool cp) throws BadBytecode {
        String typedesc;
        int c = iterator.byteAt(pos);
        if ((c != 180 && c != 178) || (typedesc = isField(tclazz.getClassPool(), cp, this.fieldClass, this.fieldname, this.isPrivate, iterator.u16bitAt(pos + 1))) == null) {
            return pos;
        }
        if (c == 178) {
            iterator.move(pos);
            iterator.writeByte(1, iterator.insertGap(1));
            pos = iterator.next();
        }
        int methodref = cp.addMethodrefInfo(cp.addClassInfo(this.methodClassname), this.methodName, "(Ljava/lang/Object;)" + typedesc);
        iterator.writeByte(184, pos);
        iterator.write16bit(methodref, pos + 1);
        return pos;
    }
}
