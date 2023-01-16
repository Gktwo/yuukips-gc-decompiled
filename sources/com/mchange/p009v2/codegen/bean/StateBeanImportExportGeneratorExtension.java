package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: com.mchange.v2.codegen.bean.StateBeanImportExportGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/StateBeanImportExportGeneratorExtension.class */
public class StateBeanImportExportGeneratorExtension implements GeneratorExtension {
    int ctor_modifiers = 1;

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Arrays.asList("com.mchange.v2.bean");
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        return Arrays.asList("StateBeanExporter");
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        String className = classInfo.getClassName();
        int length = propertyArr.length;
        Property[] propertyArr2 = new Property[length];
        for (int i = 0; i < length; i++) {
            propertyArr2[i] = new SimplePropertyMask(propertyArr[i]);
        }
        indentedWriter.println("protected class MyStateBean implements StateBean");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        for (int i2 = 0; i2 < length; i2++) {
            propertyArr2[i2] = new SimplePropertyMask(propertyArr[i2]);
            BeangenUtils.writePropertyMember(propertyArr2[i2], indentedWriter);
            indentedWriter.println();
            BeangenUtils.writePropertyGetter(propertyArr2[i2], indentedWriter);
            indentedWriter.println();
            BeangenUtils.writePropertySetter(propertyArr2[i2], indentedWriter);
        }
        indentedWriter.println();
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.println("public StateBean exportStateBean()");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("MyStateBean out = createEmptyStateBean();");
        for (int i3 = 0; i3 < length; i3++) {
            String capitalize = BeangenUtils.capitalize(propertyArr[i3].getName());
            indentedWriter.println("out.set" + capitalize + "( this." + (clsArr[i3] == Boolean.TYPE ? BeanUtil.PREFIX_GETTER_IS : BeanUtil.PREFIX_GETTER_GET) + capitalize + "() );");
        }
        indentedWriter.println("return out;");
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.println("public void importStateBean( StateBean bean )");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("MyStateBean msb = (MyStateBean) bean;");
        for (int i4 = 0; i4 < length; i4++) {
            String capitalize2 = BeangenUtils.capitalize(propertyArr[i4].getName());
            indentedWriter.println("this.set" + capitalize2 + "( msb." + (clsArr[i4] == Boolean.TYPE ? BeanUtil.PREFIX_GETTER_IS : BeanUtil.PREFIX_GETTER_GET) + capitalize2 + "() );");
        }
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.print(CodegenUtils.getModifierString(this.ctor_modifiers));
        indentedWriter.println(" " + className + "( StateBean bean )");
        indentedWriter.println("{ importStateBean( bean ); }");
        indentedWriter.println("protected MyStateBean createEmptyStateBean() throws StateBeanException");
        indentedWriter.println("{ return new MyStateBean(); }");
    }
}
