package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.mchange.v2.codegen.bean.ExplicitDefaultConstructorGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/ExplicitDefaultConstructorGeneratorExtension.class */
public class ExplicitDefaultConstructorGeneratorExtension implements GeneratorExtension {
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
        BeangenUtils.writeExplicitDefaultConstructor(this.ctor_modifiers, classInfo, indentedWriter);
    }
}
