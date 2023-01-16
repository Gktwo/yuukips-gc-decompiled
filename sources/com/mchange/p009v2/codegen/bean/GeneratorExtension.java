package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;

/* renamed from: com.mchange.v2.codegen.bean.GeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/GeneratorExtension.class */
public interface GeneratorExtension {
    Collection extraGeneralImports();

    Collection extraSpecificImports();

    Collection extraInterfaceNames();

    void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException;
}
