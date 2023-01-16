package javassist.convert;

import javassist.CtMethod;
import javassist.bytecode.CodeIterator;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

/* loaded from: grasscutter.jar:javassist/convert/TransformCallToStatic.class */
public class TransformCallToStatic extends TransformCall {
    public TransformCallToStatic(Transformer next, CtMethod origMethod, CtMethod substMethod) {
        super(next, origMethod, substMethod);
        this.methodDescriptor = origMethod.getMethodInfo2().getDescriptor();
    }

    @Override // javassist.convert.TransformCall
    protected int match(int c, int pos, CodeIterator iterator, int typedesc, ConstPool cp) {
        if (this.newIndex == 0) {
            this.newIndex = cp.addMethodrefInfo(cp.addClassInfo(this.newClassname), cp.addNameAndTypeInfo(this.newMethodname, Descriptor.insertParameter(this.classname, this.methodDescriptor)));
            this.constPool = cp;
        }
        iterator.writeByte(184, pos);
        iterator.write16bit(this.newIndex, pos + 1);
        return pos;
    }
}
