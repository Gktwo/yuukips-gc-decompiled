package javassist.bytecode.annotation;

import java.io.IOException;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;

/* loaded from: grasscutter.jar:javassist/bytecode/annotation/IntegerMemberValue.class */
public class IntegerMemberValue extends MemberValue {
    int valueIndex;

    public IntegerMemberValue(int index, ConstPool cp) {
        super('I', cp);
        this.valueIndex = index;
    }

    public IntegerMemberValue(ConstPool cp, int value) {
        super('I', cp);
        setValue(value);
    }

    public IntegerMemberValue(ConstPool cp) {
        super('I', cp);
        setValue(0);
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.annotation.MemberValue
    public Object getValue(ClassLoader cl, ClassPool cp, Method m) {
        return Integer.valueOf(getValue());
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.annotation.MemberValue
    public Class<?> getType(ClassLoader cl) {
        return Integer.TYPE;
    }

    public int getValue() {
        return this.f3074cp.getIntegerInfo(this.valueIndex);
    }

    public void setValue(int newValue) {
        this.valueIndex = this.f3074cp.addIntegerInfo(newValue);
    }

    public String toString() {
        return Integer.toString(getValue());
    }

    @Override // javassist.bytecode.annotation.MemberValue
    public void write(AnnotationsWriter writer) throws IOException {
        writer.constValueIndex(getValue());
    }

    @Override // javassist.bytecode.annotation.MemberValue
    public void accept(MemberValueVisitor visitor) {
        visitor.visitIntegerMemberValue(this);
    }
}
