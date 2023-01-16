package com.mchange.p009v2.c3p0.codegen;

import com.mchange.p009v2.codegen.IndentedWriter;
import com.mchange.p009v2.codegen.bean.ClassInfo;
import com.mchange.p009v2.codegen.bean.GeneratorExtension;
import com.mchange.p009v2.codegen.bean.Property;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.mchange.v2.c3p0.codegen.UnsupportedParentLoggerGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/codegen/UnsupportedParentLoggerGeneratorExtension.class */
public class UnsupportedParentLoggerGeneratorExtension implements GeneratorExtension {
    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        return Arrays.asList("java.util.logging.Logger", "java.sql.SQLFeatureNotSupportedException");
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo info, Class superclassType, Property[] props, Class[] propTypes, IndentedWriter iw) throws IOException {
        iw.println("// JDK7 add-on");
        iw.println("public Logger getParentLogger() throws SQLFeatureNotSupportedException");
        iw.println("{ throw new SQLFeatureNotSupportedException(\"javax.sql.DataSource.getParentLogger() is not currently supported by \" + this.getClass().getName());}");
    }
}
