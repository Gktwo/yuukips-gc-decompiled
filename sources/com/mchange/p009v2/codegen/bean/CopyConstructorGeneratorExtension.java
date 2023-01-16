package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* renamed from: com.mchange.v2.codegen.bean.CopyConstructorGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/CopyConstructorGeneratorExtension.class */
public class CopyConstructorGeneratorExtension implements GeneratorExtension {
    int ctor_modifiers = 1;

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        String str;
        indentedWriter.print(CodegenUtils.getModifierString(this.ctor_modifiers));
        indentedWriter.print(" " + classInfo.getClassName() + "( ");
        indentedWriter.print(classInfo.getClassName() + " copyMe");
        indentedWriter.println(" )");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            if (clsArr[i] == Boolean.TYPE) {
                str = BeanUtil.PREFIX_GETTER_IS + BeangenUtils.capitalize(propertyArr[i].getName()) + "()";
            } else {
                str = BeanUtil.PREFIX_GETTER_GET + BeangenUtils.capitalize(propertyArr[i].getName()) + "()";
            }
            indentedWriter.println(propertyArr[i].getSimpleTypeName() + ' ' + propertyArr[i].getName() + " = copyMe." + str + ';');
            indentedWriter.print("this." + propertyArr[i].getName() + " = ");
            String defensiveCopyExpression = propertyArr[i].getDefensiveCopyExpression();
            if (defensiveCopyExpression == null) {
                defensiveCopyExpression = propertyArr[i].getName();
            }
            indentedWriter.println(defensiveCopyExpression + ';');
        }
        indentedWriter.downIndent();
        indentedWriter.println("}");
    }
}
