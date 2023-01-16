package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* renamed from: com.mchange.v2.codegen.bean.PropertyMapConstructorGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/PropertyMapConstructorGeneratorExtension.class */
public class PropertyMapConstructorGeneratorExtension implements GeneratorExtension {
    int ctor_modifiers = 1;

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        HashSet hashSet = new HashSet();
        hashSet.add("java.util.Map");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.print(CodegenUtils.getModifierString(this.ctor_modifiers));
        indentedWriter.print(' ' + classInfo.getClassName() + "( Map map )");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("Object raw;");
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            String name = propertyArr[i].getName();
            Class cls2 = clsArr[i];
            indentedWriter.println("raw = map.get( \"" + name + "\" );");
            indentedWriter.println("if (raw != null)");
            indentedWriter.println("{");
            indentedWriter.upIndent();
            indentedWriter.print("this." + name + " = ");
            if (cls2 == Boolean.TYPE) {
                indentedWriter.println("((Boolean) raw ).booleanValue();");
            } else if (cls2 == Byte.TYPE) {
                indentedWriter.println("((Byte) raw ).byteValue();");
            } else if (cls2 == Character.TYPE) {
                indentedWriter.println("((Character) raw ).charValue();");
            } else if (cls2 == Short.TYPE) {
                indentedWriter.println("((Short) raw ).shortValue();");
            } else if (cls2 == Integer.TYPE) {
                indentedWriter.println("((Integer) raw ).intValue();");
            } else if (cls2 == Long.TYPE) {
                indentedWriter.println("((Long) raw ).longValue();");
            } else if (cls2 == Float.TYPE) {
                indentedWriter.println("((Float) raw ).floatValue();");
            } else if (cls2 == Double.TYPE) {
                indentedWriter.println("((Double) raw ).doubleValue();");
            }
            indentedWriter.println("raw = null;");
            indentedWriter.downIndent();
            indentedWriter.println("}");
        }
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }
}
