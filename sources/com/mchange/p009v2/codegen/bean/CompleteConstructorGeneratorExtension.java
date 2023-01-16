package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.CodegenUtils;
import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.mchange.v2.codegen.bean.CompleteConstructorGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/CompleteConstructorGeneratorExtension.class */
public class CompleteConstructorGeneratorExtension implements GeneratorExtension {
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
        indentedWriter.print(CodegenUtils.getModifierString(this.ctor_modifiers));
        indentedWriter.print(classInfo.getClassName() + "( ");
        BeangenUtils.writeArgList(propertyArr, true, indentedWriter);
        indentedWriter.println(" )");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
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
