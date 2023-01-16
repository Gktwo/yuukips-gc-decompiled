package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.mchange.v2.codegen.bean.PropsToStringGeneratorExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/PropsToStringGeneratorExtension.class */
public class PropsToStringGeneratorExtension implements GeneratorExtension {
    private Collection excludePropNames = null;

    public void setExcludePropertyNames(Collection collection) {
        this.excludePropNames = collection;
    }

    public Collection getExcludePropertyNames() {
        return this.excludePropNames;
    }

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
        indentedWriter.println("public String toString()");
        indentedWriter.println("{");
        indentedWriter.upIndent();
        indentedWriter.println("StringBuffer sb = new StringBuffer();");
        indentedWriter.println("sb.append( super.toString() );");
        indentedWriter.println("sb.append(\" [ \");");
        int length = propertyArr.length;
        for (int i = 0; i < length; i++) {
            Property property = propertyArr[i];
            if (this.excludePropNames == null || !this.excludePropNames.contains(property.getName())) {
                indentedWriter.println("sb.append( \"" + property.getName() + " -> \" + " + property.getName() + " );");
                if (i != length - 1) {
                    indentedWriter.println("sb.append( \", \");");
                }
            }
        }
        indentedWriter.println();
        indentedWriter.println("String extraToStringInfo = this.extraToStringInfo();");
        indentedWriter.println("if (extraToStringInfo != null)");
        indentedWriter.upIndent();
        indentedWriter.println("sb.append( extraToStringInfo );");
        indentedWriter.downIndent();
        indentedWriter.println("sb.append(\" ]\");");
        indentedWriter.println("return sb.toString();");
        indentedWriter.downIndent();
        indentedWriter.println("}");
        indentedWriter.println();
        indentedWriter.println("protected String extraToStringInfo()");
        indentedWriter.println("{ return null; }");
    }
}
