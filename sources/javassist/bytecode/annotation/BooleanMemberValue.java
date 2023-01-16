package javassist.bytecode.annotation;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;

/* loaded from: grasscutter.jar:javassist/bytecode/annotation/BooleanMemberValue.class */
public class BooleanMemberValue extends MemberValue {
    int valueIndex;

    public BooleanMemberValue(int index, ConstPool cp) {
        super('Z', cp);
        this.valueIndex = index;
    }

    public BooleanMemberValue(boolean b, ConstPool cp) {
        super('Z', cp);
        setValue(b);
    }

    public BooleanMemberValue(ConstPool cp) {
        super('Z', cp);
        setValue(false);
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.annotation.MemberValue
    public Object getValue(ClassLoader cl, ClassPool cp, Method m) {
        return Boolean.valueOf(getValue());
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.annotation.MemberValue
    public Class<?> getType(ClassLoader cl) {
        return Boolean.TYPE;
    }

    public boolean getValue() {
        return this.f3074cp.getIntegerInfo(this.valueIndex) != 0;
    }

    public void setValue(boolean newValue) {
        this.valueIndex = this.f3074cp.addIntegerInfo(newValue ? 1 : 0);
    }

    public String toString() {
        return getValue() ? C3P0Substitutions.DEBUG : "false";
    }

    @Override // javassist.bytecode.annotation.MemberValue
    public void write(AnnotationsWriter writer) throws IOException {
        writer.constValueIndex(getValue());
    }

    @Override // javassist.bytecode.annotation.MemberValue
    public void accept(MemberValueVisitor visitor) {
        visitor.visitBooleanMemberValue(this);
    }
}
