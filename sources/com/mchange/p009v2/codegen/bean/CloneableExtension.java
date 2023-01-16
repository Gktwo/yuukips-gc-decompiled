package com.mchange.p009v2.codegen.bean;

import com.mchange.p009v2.codegen.IndentedWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;

/* renamed from: com.mchange.v2.codegen.bean.CloneableExtension */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/CloneableExtension.class */
public class CloneableExtension implements GeneratorExtension {
    boolean export_public;
    boolean exception_swallowing;
    String mLoggerName;

    public boolean isExportPublic() {
        return this.export_public;
    }

    public void setExportPublic(boolean z) {
        this.export_public = z;
    }

    public boolean isExceptionSwallowing() {
        return this.exception_swallowing;
    }

    public void setExceptionSwallowing(boolean z) {
        this.exception_swallowing = z;
    }

    public String getMLoggerName() {
        return this.mLoggerName;
    }

    public void setMLoggerName(String str) {
        this.mLoggerName = str;
    }

    public CloneableExtension(boolean z, boolean z2) {
        this.mLoggerName = null;
        this.export_public = z;
        this.exception_swallowing = z2;
    }

    public CloneableExtension() {
        this(true, false);
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraGeneralImports() {
        return this.mLoggerName == null ? Collections.EMPTY_SET : Arrays.asList("com.mchange.v2.log");
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraSpecificImports() {
        return Collections.EMPTY_SET;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public Collection extraInterfaceNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("Cloneable");
        return hashSet;
    }

    @Override // com.mchange.p009v2.codegen.bean.GeneratorExtension
    public void generate(ClassInfo classInfo, Class cls, Property[] propertyArr, Class[] clsArr, IndentedWriter indentedWriter) throws IOException {
        if (this.export_public) {
            indentedWriter.print("public Object clone()");
            if (!this.exception_swallowing) {
                indentedWriter.println(" throws CloneNotSupportedException");
            } else {
                indentedWriter.println();
            }
            indentedWriter.println("{");
            indentedWriter.upIndent();
            if (this.exception_swallowing) {
                indentedWriter.println("try");
                indentedWriter.println("{");
                indentedWriter.upIndent();
            }
            indentedWriter.println("return super.clone();");
            if (this.exception_swallowing) {
                indentedWriter.downIndent();
                indentedWriter.println("}");
                indentedWriter.println("catch (CloneNotSupportedException e)");
                indentedWriter.println("{");
                indentedWriter.upIndent();
                if (this.mLoggerName == null) {
                    indentedWriter.println("e.printStackTrace();");
                } else {
                    indentedWriter.println("if ( " + this.mLoggerName + ".isLoggable( MLevel.FINE ) )");
                    indentedWriter.upIndent();
                    indentedWriter.println(this.mLoggerName + ".log( MLevel.FINE, \"Inconsistent clone() definitions between subclass and superclass! \", e );");
                    indentedWriter.downIndent();
                }
                indentedWriter.println("throw new RuntimeException(\"Inconsistent clone() definitions between subclass and superclass! \" + e);");
                indentedWriter.downIndent();
                indentedWriter.println("}");
            }
            indentedWriter.downIndent();
            indentedWriter.println("}");
        }
    }
}
