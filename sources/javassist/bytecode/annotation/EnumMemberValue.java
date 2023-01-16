package javassist.bytecode.annotation;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.lang.reflect.Method;
import javassist.ClassPool;
import javassist.bytecode.ConstPool;
import javassist.bytecode.Descriptor;

/* loaded from: grasscutter.jar:javassist/bytecode/annotation/EnumMemberValue.class */
public class EnumMemberValue extends MemberValue {
    int typeIndex;
    int valueIndex;

    public EnumMemberValue(int type, int value, ConstPool cp) {
        super('e', cp);
        this.typeIndex = type;
        this.valueIndex = value;
    }

    public EnumMemberValue(ConstPool cp) {
        super('e', cp);
        this.valueIndex = 0;
        this.typeIndex = 0;
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.annotation.MemberValue
    public Object getValue(ClassLoader cl, ClassPool cp, Method m) throws ClassNotFoundException {
        try {
            return getType(cl).getField(getValue()).get(null);
        } catch (IllegalAccessException e) {
            throw new ClassNotFoundException(getType() + Mapper.IGNORED_FIELDNAME + getValue());
        } catch (NoSuchFieldException e2) {
            throw new ClassNotFoundException(getType() + Mapper.IGNORED_FIELDNAME + getValue());
        }
    }

    /* access modifiers changed from: package-private */
    @Override // javassist.bytecode.annotation.MemberValue
    public Class<?> getType(ClassLoader cl) throws ClassNotFoundException {
        return loadClass(cl, getType());
    }

    public String getType() {
        return Descriptor.toClassName(this.f3074cp.getUtf8Info(this.typeIndex));
    }

    public void setType(String typename) {
        this.typeIndex = this.f3074cp.addUtf8Info(Descriptor.m380of(typename));
    }

    public String getValue() {
        return this.f3074cp.getUtf8Info(this.valueIndex);
    }

    public void setValue(String name) {
        this.valueIndex = this.f3074cp.addUtf8Info(name);
    }

    public String toString() {
        return getType() + Mapper.IGNORED_FIELDNAME + getValue();
    }

    @Override // javassist.bytecode.annotation.MemberValue
    public void write(AnnotationsWriter writer) throws IOException {
        writer.enumConstValue(this.f3074cp.getUtf8Info(this.typeIndex), getValue());
    }

    @Override // javassist.bytecode.annotation.MemberValue
    public void accept(MemberValueVisitor visitor) {
        visitor.visitEnumMemberValue(this);
    }
}
