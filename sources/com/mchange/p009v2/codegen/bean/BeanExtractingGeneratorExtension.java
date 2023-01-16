package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* renamed from: com.mchange.v2.codegen.bean.BeanExtractingGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/BeanExtractingGeneratorExtension.class */
public class BeanExtractingGeneratorExtension implements GeneratorExtension {
    int ctor_modifiers = 1;
    int method_modifiers = 2;

    public void setConstructorModifiers(int i) {
        this.ctor_modifiers = i;
    }

    public int getConstructorModifiers() {
        return this.ctor_modifiers;
    }

    public void setExtractMethodModifiers(int i) {
        this.method_modifiers = i;
    }

    public int getExtractMethodModifiers() {
        return this.method_modifiers;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        HashSet hashSet = new HashSet();
        hashSet.add("java.beans.BeanInfo");
        hashSet.add("java.beans.PropertyDescriptor");
        hashSet.add("java.beans.Introspector");
        hashSet.add("java.beans.IntrospectionException");
        hashSet.add("java.lang.reflect.InvocationTargetException");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        indentedWriter.println("private static Class[] NOARGS = new Class[0];");
        indentedWriter.println();
        indentedWriter.print(CodegenUtils.getModifierString(this.method_modifiers));
        indentedWriter.print(" void extractPropertiesFromBean( Object bean ) throws InvocationTargetException, IllegalAccessException, IntrospectionException");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("BeanInfo bi = Introspector.getBeanInfo( bean.getClass() );");
        indentedWriter.println("PropertyDescriptor[] pds = bi.getPropertyDescriptors();");
        indentedWriter.println("for (int i = 0, len = pds.length; i < len; ++i)");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            indentedWriter.println("if (\"" + propertyArr[i].getName() + "\".equals( pds[i].getName() ) )");
            indentedWriter.upIndent();
            indentedWriter.println("this." + propertyArr[i].getName() + " = " + extractorExpr(propertyArr[i], clsArr[i]) + ';');
            indentedWriter.downIndent();
        }
        indentedWriter.println("}");
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.print(CodegenUtils.getModifierString(this.ctor_modifiers));
        indentedWriter.println(' ' + classInfo.getClassName() + "( Object bean ) throws InvocationTargetException, IllegalAccessException, IntrospectionException");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("extractPropertiesFromBean( bean );");
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }

    private String extractorExpr(Property property, Class cls) {
        if (!cls.isPrimitive()) {
            return "(" + property.getSimpleTypeName() + ") pds[i].getReadMethod().invoke( bean, NOARGS )";
        }
        String capitalize = BeangenUtils.capitalize(property.getSimpleTypeName());
        String str = property.getSimpleTypeName() + "Value()";
        if (cls == Character.TYPE) {
            capitalize = "Character";
        } else if (cls == Integer.TYPE) {
            capitalize = "Integer";
        }
        return "((" + capitalize + ") pds[i].getReadMethod().invoke( bean, NOARGS ))." + str;
    }
}
